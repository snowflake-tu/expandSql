/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.singleton;

import cn.eck2016.expandSql.mysql.transform.ObjectTransform;
import cn.eck2016.expandSql.mysql.transform.impl.ObjectTransformImpl;

/**
 * 单例模式.
 * 1.处理SQL语句中的特殊字符"\"和"'".
 * 2.将Object转换为String.
 *
 * @author eck2016 at 2020/2/13
 * @version 1.0.0
 * @since 1.8
 */
public class BaseTransform {

    /**
     * 饿汉模式单例.
     */
    private static BaseTransform baseTransform = new BaseTransform();
    /**
     * 使用默认的对象处理器.
     */
    private static ObjectTransform objectTransform = new ObjectTransformImpl();

    /**
     * 私有构造方法.
     *
     * @author eck2016 at 2020/2/14
     */
    private BaseTransform() {
    }

    /**
     * 获取单例模式的实例.
     *
     * @return cn.eck2016.expandSql.mysql.singleton.BaseTransform
     * @author eck2016 at 2020/2/14
     */
    public static BaseTransform getInstance() {
        return baseTransform;
    }

    /**
     * 设置新的处理器.
     *
     * @param object
     * @return void
     * @author eck2016 at 2020/2/14
     * @see ObjectTransform
     */
    public void setTransform(ObjectTransform object) {
        objectTransform = object;
    }

    /**
     * 处理SQL语句中的特殊字符"\"和"'".
     *
     * @param value
     * @return java.lang.String
     * @author eck2016 at 2020/2/14
     */
    public String valueOf(String value) {
        return objectTransform.formString(value);
    }

    /**
     * 将Object转换为String.
     *
     * @param value
     * @return java.lang.String
     * @author eck2016 at 2020/2/14
     */
    public String valueOf(Object value) {
        return objectTransform.fromObject(value);
    }

}
