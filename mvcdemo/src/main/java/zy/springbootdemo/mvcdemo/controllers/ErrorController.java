package zy.springbootdemo.mvcdemo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ErrorController extends AbstractErrorController {
    Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @Autowired
    ObjectMapper objectMapper;

    public ErrorController() {
        super(new DefaultErrorAttributes());
    }


    @RequestMapping("/error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
        // 获取异常
        Throwable cause = getCause(request);
        int status = (Integer) model.get("status");
        // 错误信息
        String message = (String)model.get("message");
        // 友好提示
        String errorMessage = getErrorMessage(cause);
        // 后台打印日志信息方便查错
        logger.info(status + "," + message, cause);
        response.setStatus(status);
        if(!isJsonRequest(request)) {
            ModelAndView view = new ModelAndView("/error.html");
            view.addAllObjects(model);
            view.addObject("errorMessage", errorMessage);
            view.addObject("status", status);
            view.addObject("cause", cause);
            return view;
        } else {
            Map error = new HashMap();
            error.put("success", false);
            error.put("errorMessage", errorMessage);
            error.put("message", message);
//            writecJson(response, error);
            return null;
        }
    }


    private Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
        if (error != null) {
           //MVC有可能会封装异常成ServletException，需调用getCause获取真正的异常
            while (error instanceof ServletException && error.getCause() != null) {
                error = ((ServletException)error).getCause();
            }
        }
        return error;
    }

    protected String getErrorMessage(Throwable ex) {
        return "服务器错误，请联系管理员";
    }

    protected boolean isJsonRequest(HttpServletRequest request) {
        String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
        if(requestUri != null && requestUri.endsWith(".json")) {
            return true;
        } else {
            // 也可以通过获取HTTP头,根据Accept字段是否包含JSON进一步判断,比如
            if(request.getHeader("Accept").contains("application/json")) {
                return true;
            }
            return false;
        }
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
