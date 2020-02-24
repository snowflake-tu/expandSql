/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.transform;

/**
 * 对象处理器接口.
 * 1.处理SQL语句中的特殊字符"\"和"'".
 * 2.将Object转换为String.
 *
 * @author eck2016 at 2020/2/14
 * @version 1.0.0
 * @since 1.8
 */
public interface ObjectTransform {

    /**
     * 处理SQL语句中的特殊字符"\"和"'".
     *
     * @param value
     * @return java.lang.String
     * @author eck2016 at 2020/2/14
     */
    String formString(String value);

    /**
     * 将Object转换为String.
     *
     * @param value
     * @return java.lang.String
     * @author eck2016 at 2020/2/14
     */
    String fromObject(Object value);

}
