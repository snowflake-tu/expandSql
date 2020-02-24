/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.ItemFunction;

/**
 * 常用SQL函数.
 *
 * @author eck2016 at 2020/2/16
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlFunction {

    /**
     * 私有构造方法.
     *
     * @author eck2016 at 2020/2/20
     */
    private SqlFunction() {
    }

    /**
     * NOW()函数.
     */
    public static ItemFunction NOW = new ItemFunction("NOW()");
    /**
     * VERSION()函数.
     */
    public static ItemFunction VERSION = new ItemFunction("VERSION()");

}
