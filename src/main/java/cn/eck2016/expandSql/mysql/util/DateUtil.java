/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类.
 * 1.获取yyyy-MM-dd HH:mm:ss格式的日期字符串.
 *
 * @author eck2016 at 2020/2/14
 * @version 1.0.0
 * @since 1.8
 */
public final class DateUtil {

    /**
     * 私有构造方法.
     *
     * @author eck2016 at 2020/2/14
     */
    private DateUtil() {
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss格式的日期字符串.
     *
     * @return java.lang.String
     * @author eck2016 at 2020/2/14
     */
    public static String generateDateTime() {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return time.format(new Date());
    }

}
