package zy.springbootdemo.mvcdemo.domain;

import zy.springbootdemo.mvcdemo.validation.WorkOverTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


public class WorkinfoForm {

    public interface Update{}
    public interface Add{}

    @Null(groups = {Add.class})
    @NotNull(groups = {Update.class})
    private Long id;


    @WorkOverTime(max=2)
    private Integer workTime;


    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
