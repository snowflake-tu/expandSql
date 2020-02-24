/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql;

import cn.eck2016.expandSql.mysql.component.*;
import cn.eck2016.expandSql.mysql.item.IgnoreItemColumn;
import cn.eck2016.expandSql.mysql.item.IgnoreItemGroup;
import cn.eck2016.expandSql.mysql.item.IgnoreItemOrder;
import cn.eck2016.expandSql.mysql.item.IgnoreItemWhere;
import cn.eck2016.expandSql.mysql.item.lambda.IIgnoreItemWhere;

/**
 * SELECT语句.
 *
 * @author eck2016 at 2020/2/20
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlRBuilder extends SqlBuilder {

    /**
     * SELECT信息.
     */
    private SqlSelect sqlSelect;
    /**
     * 基表.
     */
    private Table tableMain;
    /**
     * 关联表.
     */
    private SqlJoin sqlJoin;
    /**
     * 约束条件.
     */
    private SqlWhere sqlWhere;
    /**
     * 分组信息.
     */
    private SqlGroupBy sqlGroupBy;
    /**
     * 筛选信息.
     */
    private SqlHaving sqlHaving;
    /**
     * 排序信息.
     */
    private SqlOrderBy sqlOrderBy;
    /**
     * 分页信息.
     */
    private SqlLimit sqlLimit;

    /**
     * 私有构造方法.
     *
     * @param table
     * @return
     * @author eck2016 at 2020/2/20
     */
    private SqlRBuilder(Table table) {
        this.sqlSelect = new SqlSelect();
        this.tableMain = table;
        this.sqlJoin = new SqlJoin();
        this.sqlWhere = new SqlWhere();
        this.sqlGroupBy = new SqlGroupBy();
        this.sqlHaving = new SqlHaving();
        this.sqlOrderBy = new SqlOrderBy();
        this.sqlLimit = new SqlLimit();
    }

    /**
     * 代理函数.
     *
     * @param table
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public static SqlRBuilder baseTable(Table table) {
        return new SqlRBuilder(table);
    }

    /**
     * SELECT信息.
     *
     * @param ignoreItemColumns
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder select(IgnoreItemColumn... ignoreItemColumns) {
        sqlSelect.select(ignoreItemColumns);
        return this;
    }

    /**
     * 内连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder innerJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.innerJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 内连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder innerJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.innerJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 左连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder leftJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.leftJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 左连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder leftJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.leftJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 右连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder rightJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.rightJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 右连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder rightJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.rightJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 约束条件.
     *
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder where(IgnoreItemWhere ignoreItemWhere) {
        sqlWhere.where(ignoreItemWhere);
        return this;
    }

    /**
     * 约束条件(lambda).
     *
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder where(IIgnoreItemWhere IIgnoreItemWhere) {
        sqlWhere.where(IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 分组信息.
     *
     * @param ignoreItemGroups
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder groupBy(IgnoreItemGroup... ignoreItemGroups) {
        sqlGroupBy.groupBy(ignoreItemGroups);
        return this;
    }

    /**
     * 筛选信息.
     *
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder having(IgnoreItemWhere ignoreItemWhere) {
        sqlHaving.having(ignoreItemWhere);
        return this;
    }

    /**
     * 筛选信息(lambda).
     *
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder having(IIgnoreItemWhere IIgnoreItemWhere) {
        sqlHaving.having(IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 排序信息.
     *
     * @param ignoreItemOrders
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder orderBy(IgnoreItemOrder... ignoreItemOrders) {
        sqlOrderBy.orderBy(ignoreItemOrders);
        return this;
    }

    /**
     * 分页信息.
     *
     * @param offset
     * @param size
     * @return cn.eck2016.expandSql.mysql.SqlRBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlRBuilder limit(Integer offset, Integer size) {
        sqlLimit.limit(offset, size);
        return this;
    }

    @Override
    public String buildSql() {
        if (isEmpty()) {
            builder.append(SqlChars.CHARS_SELECT)
                    .append(sqlSelect.getBuilder())
                    .append(SqlChars.CHARS_FROM)
                    .append(tableMain.getName())
                    .append(SqlChars.CHARS_AS)
                    .append(tableMain.getAlias())
                    .append(sqlJoin.getBuilder())
                    .append(sqlWhere.getBuilder())
                    .append(sqlGroupBy.getBuilder())
                    .append(sqlHaving.getBuilder())
                    .append(sqlOrderBy.getBuilder())
                    .append(sqlLimit.getBuilder());
        }
        return getSql();
    }
}
