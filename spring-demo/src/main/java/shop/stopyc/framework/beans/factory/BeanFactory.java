package shop.stopyc.framework.beans.factory;

/**
 * @version v1.0
 * @ClassName: BeanFactory
 * @Description: IOC容器父接口
 * @Author: YC104
 */
public interface BeanFactory {

    /**
     * 工厂中获取bean对象
     * @param name :beanName
     * @return :beanObj
     * @throws Exception : cast exception
     */
    Object getBean(String name) throws Exception;

    /**
     * 工厂中获取bean对象
     * @param name :beanName;
     * @param clazz : 字节码
     * @param <T> :类型
     * @return: bean
     * @throws Exception :cast exception
     */
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
