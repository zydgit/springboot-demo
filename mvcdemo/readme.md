### 局部的拦截initBinder， 全局的MvcConfigurer配置
#### MvcConfigurer 
1. 拦截器 addinterceptors
2. 跨域访问 addCorsMappings 
3. 格式化 addFormatters controller上映射字段值的时候可能需要格式化数据，例如spring默认没有配置如何将字符串的日期转为java日期
4. 注册Controller addViewControllers 没有必要命名注册那么多的controller类和方法
### @validated，动态配置，自定义条件注解
### 通用错误处理