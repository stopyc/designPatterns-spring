package shop.stopyc.framework.beans;


/**
 * @version v1.0
 * @ClassName: BeanDefinition
 * @Description: 用来封装bean标签数据
 * <p>
 * class属性
 * property子标签的数据(一些依赖的属性)
 * @Author: YC104
 */
public class BeanDefinition {

    /**
     * bean唯一id
     */
    private String id;
    /**
     * 全类名
     */
    private String className;

    /**
     * property属性(bean中会有很多的依赖,这里采用集合,使用了迭代器模式)
     */
    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new MutablePropertyValues();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
