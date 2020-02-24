/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemOrder;
import cn.eck2016.expandSql.mysql.item.IgnoreItemWhere;
import cn.eck2016.expandSql.mysql.item.ItemFunction;

/**
 * 处理嵌套的逻辑条件.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class Sql {

    /**
     * 私有构造方法.
     *
     * @author eck2016 at 2020/2/20
     */
    private Sql() {
    }

    private static StringBuilder createBuilder() {
        return new StringBuilder(30);
    }

    /**
     * 处理嵌套的逻辑条件.
     *
     * @param limit "AND"或者"OR".
     * @param items SQL筛选条件.
     * @return cn.eck2016.expandSql.mysql.item.WhereItem
     * @author eck2016 at 2020/2/4
     */
    private static IgnoreItemWhere limit(char[] limit, IgnoreItemWhere... items) {
        StringBuilder builder = createBuilder();
        int itemCount = 0;
        for (IgnoreItemWhere item : items) {
            if (item != null && !item.isIgnore()) itemCount++;
        }
        if (itemCount > 1) builder.append(SqlChars.CHARS_START);
        boolean itemFlag = false;
        boolean ignore = true;
        for (IgnoreItemWhere item : items) {
            if (item != null && !item.isIgnore()) {
                if (itemFlag && itemCount > 1) builder.append(limit);
                builder.append(item.getExpression());
                itemFlag = true;
                ignore = false;
            }
        }
        if (itemCount > 1) builder.append(SqlChars.CHARS_END);
        return new IgnoreItemWhere(ignore, builder.toString());
    }

    /**
     * 并列AND关系的处理.
     *
     * @param items SQL筛选条件.
     * @return cn.eck2016.expandSql.mysql.item.WhereItem
     * @author eck2016 at 2020/2/4
     */
    public static IgnoreItemWhere and(IgnoreItemWhere... items) {
        if (items.length == 1) {
            return items[0];
        } else if (items.length > 1) {
            return limit(SqlChars.CHARS_AND, items);
        } else {
            return null;
        }
    }

    /**
     * 并列OR关系的处理.
     *
     * @param items SQL筛选条件.
     * @return cn.eck2016.expandSql.mysql.item.WhereItem
     * @author eck2016 at 2020/2/4
     */
    public static IgnoreItemWhere or(IgnoreItemWhere... items) {
        if (items.length == 1) {
            System.out.println(1);
            return items[0];
        } else if (items.length > 1) {
            return limit(SqlChars.CHARS_OR, items);
        } else {
            return null;
        }
    }

    /**
     * 处理SQL函数信息.
     *
     * @param expression 函数信息.
     * @return cn.eck2016.expandSql.mysql.item.ColumnItem
     * @author eck2016 at 2020/2/5
     */
    public ItemFunction function(String expression) {
        return new ItemFunction(expression);
    }

    /**
     * 处理排序信息.
     *
     * @param field 排序参照.
     * @return cn.eck2016.expandSql.mysql.item.ColumnItem
     * @author eck2016 at 2020/2/5
     */
    public IgnoreItemOrder asc(String field) {
        StringBuilder builder = createBuilder();
        builder.append(field);
        builder.append(SqlChars.CHARS_ASC);
        return new IgnoreItemOrder(builder.toString());
    }

    /**
     * 处理排序信息.
     *
     * @param field 排序参照.
     * @return cn.eck2016.expandSql.mysql.item.ColumnItem
     * @author eck2016 at 2020/2/5
     */
    public IgnoreItemOrder desc(String field) {
        StringBuilder builder = createBuilder();
        builder.append(field);
        builder.append(SqlChars.CHARS_DESC);
        return new IgnoreItemOrder(builder.toString());
    }

}
