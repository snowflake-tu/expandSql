/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.util;

import java.util.UUID;

/**
 * UUID工具类.
 * 1.生成UUID字符串.
 *
 * @author eck2016 at 2020/2/14
 * @version 1.0.0
 * @since 1.8
 */
public final class UuidUtil {

    /**
     * 私有构造方法.
     *
     * @author eck2016 at 2020/2/14
     */
    private UuidUtil() {
    }

    /**
     * 生成长度为32的UUID字符串.
     *
     * @return java.lang.String
     * @author eck2016 at 2020/2/14
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
