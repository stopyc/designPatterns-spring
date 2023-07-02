package shop.stopyc.controller;


import shop.stopyc.framework.context.ApplicationContext;
import shop.stopyc.framework.context.support.ClassPathXmlApplicationContext;
import shop.stopyc.service.UserService;

/**
 * @version v1.0
 * @ClassName: UserController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: YC104
 */
public class UserController {
    public static void main(String[] args) throws Exception {
        //1,创建spring的容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //2,从容器对象中获取userService对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        //3,调用userService方法进行业务逻辑处理
        userService.add();
    }
}
