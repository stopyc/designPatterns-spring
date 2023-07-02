package shop.stopyc.framework.context;


import shop.stopyc.framework.beans.factory.BeanFactory;

/**
 * @version v1.0
 * @ClassName: ApplicationContext
 * @Description: 定义非延时加载功能
 * @Author: YC104
 */
public interface ApplicationContext extends BeanFactory {

    /**
     * 加载配置文件,把bean加入注册表
     * @throws Exception:
     */
    void refresh() throws Exception;
}
