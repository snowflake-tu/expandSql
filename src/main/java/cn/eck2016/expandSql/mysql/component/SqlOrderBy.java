/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemOrder;

/**
 * 记录查询结果的排序参照字段.
 *
 * @author eck2016 at 2020/2/5
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlOrderBy {

    /**
     * 使用StringBuilder记录查询结果的排序参照字段,初始化大小为20.
     */
    private StringBuilder builder = new StringBuilder(20);
    /**
     * 计数变量,用于判断是否需要插入分隔符.
     */
    private int count = 0;

    /**
     * 记录查询结果的排序参照字段.
     *
     * @param ignoreItemOrders 排序参照字段,如:fieldName ASC|DESC.
     * @return void
     * @author eck2016 at 2020/2/5
     */
    public void orderBy(IgnoreItemOrder... ignoreItemOrders) {
        for (IgnoreItemOrder ignoreItemOrder : ignoreItemOrders) {
            if (!ignoreItemOrder.isIgnore()) {
                if (count > 0) {
                    builder.append(SqlChars.CHARS_SPLIT);
                } else {
                    builder.append(SqlChars.CHARS_ORDER_BY);
                }
                builder.append(ignoreItemOrder.getExpression());
                count++;
            }
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }
}

