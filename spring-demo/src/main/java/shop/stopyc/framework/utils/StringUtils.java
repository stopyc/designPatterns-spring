package shop.stopyc.framework.utils;

/**
 * @version v1.0
 * @ClassName: StringUtils
 * @Description: 字符串工具类
 * @Author: YC104
 */
public class StringUtils {
    private StringUtils() {

    }

    /**
     *  userDao   ==>   setUserDao
     * @param fieldName :依赖名称
     * @return :set方法名称
     */
    public static String getSetterMethodByFieldName(String fieldName) {
        return "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    }
}
