package shop.stopyc.framework.beans.factory.support;


import shop.stopyc.framework.beans.BeanDefinition;

/**
 * @version v1.0
 * @ClassName: BeanDefinitionRegistry
 * @Description: 注册表对象
 * @Author: YC104
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册BeanDefinition对象到注册表中
     * @param beanName :bean name
     * @param beanDefinition :bean definition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从注册表中删除指定名称的BeanDefinition对象
     * @param beanName :bean name
     * @throws Exception: null
     */
    void removeBeanDefinition(String beanName) throws Exception;

    /**
     * 根据名称从注册表中获取BeanDefinition对象
     * @param beanName: bean name
     * @return: BeanDefinition对象
     * @throws Exception: 获取不到
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 判断注册表中是否含有该bean
     * @param beanName :bean name;
     * @return: bool
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 获取注册表中bean的数量
     * @return :数量
     */
    int getBeanDefinitionCount();

    /**
     * 获取注册表中所有bean的名称
     * @return :bean名称字符串数组
     */
    String[] getBeanDefinitionNames();
}
