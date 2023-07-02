package shop.stopyc.framework.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import shop.stopyc.framework.beans.BeanDefinition;
import shop.stopyc.framework.beans.MutablePropertyValues;
import shop.stopyc.framework.beans.PropertyValue;
import shop.stopyc.framework.beans.factory.support.BeanDefinitionReader;
import shop.stopyc.framework.beans.factory.support.BeanDefinitionRegistry;
import shop.stopyc.framework.beans.factory.support.SimpleBeanDefinitionRegistry;

import java.io.InputStream;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: XmlBeanDefinitionReader
 * @Description: 针对xml配置文件进行解析的类
 * @Author: YC104
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 声明注册表对象
     */
    private final BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    public void loadBeanDefinitions(String configLocation) throws Exception {
        //使用dom4j进行xml配置文件的解析
        SAXReader reader = new SAXReader();
        //获取类路径下的配置文件
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(is);
        //根据Document对象获取根标签对象 (beans)
        Element rootElement = document.getRootElement();
        //获取根标签下所有的bean标签对象
        List<Element> beanElements = rootElement.elements("bean");
        //遍历集合
        for (Element beanElement : beanElements) {
            //获取id属性
            String id = beanElement.attributeValue("id");
            //获取class属性
            String className = beanElement.attributeValue("class");

            //将id属性和class属性封装到BeanDefinition对象中
            //1，创建BeanDefinition
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);

            //创建MutablePropertyValues对象
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();

            //获取bean标签下所有的property标签对象
            List<Element> propertyElements = beanElement.elements("property");
            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");
                String value = propertyElement.attributeValue("value");
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                mutablePropertyValues.addPropertyValue(propertyValue);
            }
            //将mutablePropertyValues对象封装到BeanDefinition对象中
            beanDefinition.setPropertyValues(mutablePropertyValues);

            //将beanDefinition对象注册到注册表中
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
