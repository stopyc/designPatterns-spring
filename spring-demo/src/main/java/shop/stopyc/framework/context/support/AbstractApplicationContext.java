package shop.stopyc.framework.context.support;


import shop.stopyc.framework.beans.factory.support.BeanDefinitionReader;
import shop.stopyc.framework.beans.factory.support.BeanDefinitionRegistry;
import shop.stopyc.framework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version v1.0
 * @ClassName: AbstractApplicationContext
 * @Description: ApplicationContext接口的子实现类，用于立即加载
 * @Author: 黑马程序员
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    /**
     * 声明解析器变量
     */
    protected BeanDefinitionReader beanDefinitionReader;

    /**
     * 定义用于存储bean对象的map容器
     */
    protected Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();

    /**
     * 声明配置文件路径的变量
     */
    protected String configLocation;

    public void refresh() throws Exception {
        //加载BeanDefinition对象进注册表中
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        //初始化bean
        finishBeanInitialization();
    }

    /**
     * bean的初始化
     * @throws Exception:
     */
    private void finishBeanInitialization() throws Exception {
        //获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

        //获取BeanDefinition对象
        String[] beanNames = registry.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            //进行bean的初始化
            getBean(beanName);
        }
    }
}
