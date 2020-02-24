/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.*;

/**
 * 记录数据表名,数据表别名.
 *
 * @author eck2016 at 2020/2/5
 * @version 1.0.0
 * @since 1.8
 */
public class Table {

    /**
     * 数据表名.
     */
    private String name;
    /**
     * 数据表别名.
     */
    private String alias;

    /**
     * 私有构造方法.
     *
     * @author eck2016 at 2020/2/5
     */
    private Table(String tableName, String tableAlias) {
        this.name = tableName;
        this.alias = tableAlias;
    }

    /**
     * 代理函数.
     *
     * @param tableName  数据表名.
     * @param tableAlias 数据表别名.
     * @return
     * @author eck2016 at 2020/2/5
     */
    public static Table define(String tableName, String tableAlias) {
        return new Table(tableName, tableAlias);
    }

    /**
     * 将被替换字符串中的$符号替换为数据表别名,如:$.id替换后为tableAlias.id.
     *
     * @param tableAlias 数据表别名.
     * @param format     被替换字符串.
     * @return java.lang.String
     * @author eck2016 at 2020/2/5
     */
    private String replaceColumn(String tableAlias, String format) {
        return format.replaceAll(SqlChars.STRING_REGEX_REPLACE, tableAlias);
    }

    private StringBuilder createBuilder() {
        return new StringBuilder(30);
    }

    /**
     * 处理与数据表相关的多个字段信息.
     *
     * @param columns 字段信息.
     * @return cn.eck2016.expandSql.mysql.item.ColumnItem
     * @author eck2016 at 2020/2/5
     */
    public IgnoreItemColumn column(String... columns) {
        StringBuilder builder = createBuilder();
        int count = 0;
        for (String column : columns) {
            if (count > 0) builder.append(SqlChars.CHARS_SPLIT);
            if (column.contains(SqlChars.STRING_REPLACE)) {
                builder.append(replaceColumn(alias, column));
            } else {
                builder.append(alias);
                builder.append(SqlChars.CHARS_DOT);
                builder.append(column);
            }
            count++;
        }
        return new IgnoreItemColumn(builder.toString());
    }

    /**
     * 处理与数据表相关的字段信息.
     *
     * @param field 字段信息.
     * @return cn.eck2016.expandSql.mysql.item.ColumnItem
     * @author eck2016 at 2020/2/5
     */
    public ItemField field(String field) {
        StringBuilder builder = createBuilder();
        builder.append(alias);
        builder.append(SqlChars.CHARS_DOT);
        builder.append(field);
        return new ItemField(builder.toString());
    }

    /**
     * 处理与数据表相关的函数信息.
     *
     * @param format 函数信息.
     * @return cn.eck2016.expandSql.mysql.item.ColumnItem
     * @author eck2016 at 2020/2/5
     */
    public ItemFunction function(String format) {
        return new ItemFunction(replaceColumn(alias, format));
    }

    /**
     * 处理分组信息.
     *
     * @param field 分组字段.
     * @return cn.eck2016.expandSql.mysql.item.ColumnItem
     * @author eck2016 at 2020/2/5
     */
    public IgnoreItemGroup group(String field) {
        StringBuilder builder = createBuilder();
        builder.append(alias);
        builder.append(SqlChars.CHARS_DOT);
        builder.append(field);
        return new IgnoreItemGroup(builder.toString());
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
        builder.append(alias);
        builder.append(SqlChars.CHARS_DOT);
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
        builder.append(alias);
        builder.append(SqlChars.CHARS_DOT);
        builder.append(field);
        builder.append(SqlChars.CHARS_DESC);
        return new IgnoreItemOrder(builder.toString());
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

}
