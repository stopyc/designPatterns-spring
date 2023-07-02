package shop.stopyc.framework.beans;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version v1.0
 * @ClassName: MutablePropertyValues
 * @Description: 用户存储和管理多个PropertyValue对象(迭代器模式)
 * @Author: YC104
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {

    /**
     * 定义list集合对象，用来存储PropertyValue对象
     */
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new CopyOnWriteArrayList<PropertyValue>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new CopyOnWriteArrayList<PropertyValue>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    /**
     * 获取所有的PropertyValue对象，返回以数组的形式
     * @return 集合变为数组
     */
    public PropertyValue[] getPropertyValues() {
        //将集合转换为数组并返回
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据name属性值获取PropertyValue对象
     * @param propertyName :属性名称
     * @return :属性对象
     */
    public PropertyValue getPropertyValue(String propertyName) {
        //遍历集合对象
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 判断集合是否为空
     * @return :true or false
     */
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    /**
     * 添加PropertyValue对象
     * @param pv :属性对象
     * @return: 属性对象列表, 为了链式编程
     */
    public MutablePropertyValues addPropertyValue(PropertyValue pv) {
        //判断集合中存储的PropertyValue对象是否和传递进行的重复了，如果重复了，进行覆盖
        for (int i = 0; i < propertyValueList.size(); i++) {
            //获取集合中每一个PropertyValue对象
            PropertyValue currentPv = propertyValueList.get(i);
            if (currentPv.getName().equals(pv.getName())) {
                propertyValueList.set(i, pv);
                return this;
            }
        }
        this.propertyValueList.add(pv);
        return this;
    }

    /**
     * 判断是否有指定name属性值的对象
     * @param propertyName :属性名
     * @return :bool
     */
    public boolean contains(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }

    /**
     * 获取迭代器对象
     * @return :迭代器对象
     */
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
