/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

import cn.eck2016.expandSql.mysql.component.SqlChars;
import cn.eck2016.expandSql.mysql.enums.Item;

import java.util.List;

/**
 * 函数对象.
 *
 * @author eck2016 at 2020/2/13
 * @version 1.0.0
 * @since 1.8
 */
public class ItemFunction extends AbstractItem {

    public ItemFunction(String column) {
        super(column);
    }

    public IgnoreItemWhere eq(Object object) {
        return eq(object, Item.MUST);
    }

    public IgnoreItemWhere eq(Object object, Item item) {
        return buildWhereItem(SqlChars.STRING_EQ, object, item);
    }

    public IgnoreItemWhere lt(Object object) {
        return lt(object, Item.MUST);
    }

    public IgnoreItemWhere lt(Object object, Item item) {
        return buildWhereItem(SqlChars.STRING_LT, object, item);
    }

    public IgnoreItemWhere gt(Object object) {
        return gt(object, Item.MUST);
    }

    public IgnoreItemWhere gt(Object object, Item item) {
        return buildWhereItem(SqlChars.STRING_GT, object, item);
    }

    public IgnoreItemWhere geq(Object object) {
        return geq(object, Item.MUST);
    }

    public IgnoreItemWhere geq(Object object, Item item) {
        return buildWhereItem(SqlChars.STRING_GEQ, object, item);
    }

    public IgnoreItemWhere leq(Object object) {
        return leq(object, Item.MUST);
    }

    public IgnoreItemWhere leq(Object object, Item item) {
        return buildWhereItem(SqlChars.STRING_LEQ, object, item);
    }

    public IgnoreItemWhere like(String object) {
        return like(object, Item.MUST);
    }

    public IgnoreItemWhere like(String object, Item item) {
        return buildWhereItem(SqlChars.STRING_LIKE, object, item);
    }

    public IgnoreItemWhere in(List<String> value) {
        return buildWhereItem(SqlChars.STRING_IN, value, Item.MUST);
    }

}