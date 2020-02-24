/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql;

import cn.eck2016.expandSql.mysql.component.SqlChars;
import cn.eck2016.expandSql.mysql.component.SqlInsert;
import cn.eck2016.expandSql.mysql.component.Table;
import cn.eck2016.expandSql.mysql.item.ItemFunction;

/**
 * INSERT语句.
 *
 * @author eck2016 at 2020/2/20
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlCBuilder extends SqlBuilder {

    /**
     * 记录fields和values.
     */
    private SqlInsert sqlInsert;
    /**
     * 基表.
     */
    private Table tableMain;

    /**
     * 私有构造方法.
     *
     * @param table
     * @return
     * @author eck2016 at 2020/2/20
     */
    private SqlCBuilder(Table table) {
        sqlInsert = new SqlInsert();
        tableMain = table;
    }


    /**
     * 代理函数.
     *
     * @param table 基表.
     * @return cn.eck2016.expandSql.mysql.SqlCBuilder
     * @author eck2016 at 2020/2/20
     */
    public static SqlCBuilder baseTable(Table table) {
        return new SqlCBuilder(table);
    }

    /**
     * 处理整数型数据.
     *
     * @param field
     * @param value
     * @return cn.eck2016.expandSql.mysql.SqlCBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlCBuilder insert(String field, Integer value) {
        sqlInsert.insert(field, value);
        return this;
    }

    /**
     * 处理长整数型数据.
     *
     * @param field
     * @param value
     * @return cn.eck2016.expandSql.mysql.SqlCBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlCBuilder insert(String field, Long value) {
        sqlInsert.insert(field, value);
        return this;
    }

    /**
     * 处理字符串型数据.
     *
     * @param field
     * @param value
     * @return cn.eck2016.expandSql.mysql.SqlCBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlCBuilder insert(String field, String value) {
        sqlInsert.insert(field, value);
        return this;
    }

    /**
     * 处理SQL函数型数据.
     *
     * @param field
     * @param itemFunction
     * @return cn.eck2016.expandSql.mysql.SqlCBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlCBuilder insert(String field, ItemFunction itemFunction) {
        sqlInsert.insert(field, itemFunction);
        return this;
    }

    /**
     * 插入分隔符.
     *
     * @param
     * @return cn.eck2016.expandSql.mysql.SqlCBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlCBuilder insertSplit() {
        sqlInsert.appendSplit();
        return this;
    }

    @Override
    public String buildSql() {
        if (isEmpty()) {
            builder.append(SqlChars.CHARS_INSERT_INTO)
                    .append(tableMain.getName())
                    .append(sqlInsert.getFieldsBuilder())
                    .append(SqlChars.CHARS_VALUES)
                    .append(sqlInsert.getValuesBuilder());
        }
        return getSql();
    }
}
