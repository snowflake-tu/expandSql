/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.enums;

/**
 * SQL参数的类型.
 *
 * @author eck2016 at 2020/2/13
 * @version 1.0.0
 * @since 1.8
 */
public enum ValueType {

    /**
     * NULL.
     */
    NULL,
    /**
     * 整数型.
     */
    INTEGER,
    /**
     * 长整数型.
     */
    LONG,
    /**
     * 字符串型.
     */
    STRING,
    /**
     * 查询语句,用于实现嵌套子查询.
     */
    SQL_SELECT,
    /**
     * 数据表字段.
     */
    SQL_FIELD,
    /**
     * 数据库函数.
     */
    SQL_FUNCTION,
    /**
     * 整数型列表.
     */
    LIST_INTEGER,
    /**
     * 长整数型列表.
     */
    LIST_LONG,
    /**
     * 字符串型列表.
     */
    LIST_STRING,
    /**
     * 空列表.
     */
    LIST_EMPTY,
    /**
     * 其它类型.
     */
    OTHER;

    /**
     * 判断此类型是否在预期的值类型中.
     *
     * @param valueTypes 预期的值类型.
     * @return boolean
     * @author eck2016 at 2020/2/13
     */
    public boolean in(ValueType... valueTypes) {
        boolean flag = false;
        for (ValueType valueType : valueTypes) {
            if (valueType.ordinal() == this.ordinal()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
