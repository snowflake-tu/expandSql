/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

import cn.eck2016.expandSql.mysql.component.SqlChars;
import cn.eck2016.expandSql.mysql.enums.Item;

/**
 * 字段对象,与FunctionItem的唯一区别在于:FieldItem可作为UPDATE-SET的主体对象.
 *
 * @author eck2016 at 2020/2/13
 * @version 1.0.0
 * @since 1.8
 */
public final class ItemField extends ItemFunction {

    public ItemField(String column) {
        super(column);
    }

    /**
     * 包装为SET操作.
     *
     * @param value
     * @param item
     * @return cn.eck2016.expandSql.mysql.item.UpdateItem
     * @author eck2016 at 2020/2/13
     */
    public IgnoreItemSet buildUpdateItem(Object value, Item item) {
        boolean flag = checkIgnore(value, item);
        String expression = null;
        if (!flag) {
            StringBuilder builder = createBuilder();
            appendValue(builder, SqlChars.STRING_EQ, value);
            expression = builder.toString();
        }
        return new IgnoreItemSet(flag, expression);
    }

    public IgnoreItemSet setValue(Integer value, Item item) {
        return buildUpdateItem(value, item);
    }

    public IgnoreItemSet setValue(Integer value) {
        return buildUpdateItem(value, Item.MUST);
    }

    public IgnoreItemSet setValue(Long value, Item item) {
        return buildUpdateItem(value, item);
    }

    public IgnoreItemSet setValue(Long value) {
        return buildUpdateItem(value, Item.MUST);
    }

    public IgnoreItemSet setValue(String value, Item item) {
        return buildUpdateItem(value, item);
    }

    public IgnoreItemSet setValue(String value) {
        return buildUpdateItem(value, Item.MUST);
    }

    public IgnoreItemSet setValue(ItemField value, Item item) {
        return buildUpdateItem(value, item);
    }

    public IgnoreItemSet setValue(ItemField value) {
        return buildUpdateItem(value, Item.MUST);
    }

    public IgnoreItemSet setValue(ItemFunction value, Item item) {
        return buildUpdateItem(value, item);
    }

    public IgnoreItemSet setValue(ItemFunction value) {
        return buildUpdateItem(value, Item.MUST);
    }

}
