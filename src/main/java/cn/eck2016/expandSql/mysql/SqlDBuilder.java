/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql;

import cn.eck2016.expandSql.mysql.component.*;
import cn.eck2016.expandSql.mysql.item.IgnoreItemWhere;
import cn.eck2016.expandSql.mysql.item.lambda.IIgnoreItemWhere;

/**
 * DELETE语句.
 *
 * @author eck2016 at 2020/2/20
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlDBuilder extends SqlBuilder {

    /**
     * DELETE信息.
     */
    private SqlDelete sqlDelete;
    /**
     * 基表.
     */
    private Table tableMain;
    /**
     * 关联表.
     */
    private SqlJoin sqlJoin;
    /**
     * DELETE约束条件.
     */
    private SqlWhere sqlWhere;

    /**
     * 私有构造方法.
     *
     * @param table
     * @return
     * @author eck2016 at 2020/2/20
     */
    private SqlDBuilder(Table table) {
        this.sqlDelete = new SqlDelete();
        this.tableMain = table;
        this.sqlJoin = new SqlJoin();
        this.sqlWhere = new SqlWhere();
    }

    /**
     * 代理函数.
     *
     * @param table
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public static SqlDBuilder baseTable(Table table) {
        return new SqlDBuilder(table);
    }

    /**
     * 删除信息.
     *
     * @param tables
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder delete(Table... tables) {
        for (Table table : tables) {
            sqlDelete.delete(table);
        }
        return this;
    }

    /**
     * 内连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder innerJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.innerJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 内连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder innerJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.innerJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 左连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder leftJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.leftJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 左连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder leftJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.leftJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 右连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder rightJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.rightJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 右连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder rightJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.rightJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 约束条件.
     *
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder where(IgnoreItemWhere ignoreItemWhere) {
        sqlWhere.where(ignoreItemWhere);
        return this;
    }

    /**
     * 约束条件(lambda).
     *
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlDBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlDBuilder where(IIgnoreItemWhere IIgnoreItemWhere) {
        sqlWhere.where(IIgnoreItemWhere.createInstance());
        return this;
    }

    @Override
    public String buildSql() {
        if (isEmpty()) {
            builder.append(SqlChars.CHARS_DELETE)
                    .append(sqlDelete.getBuilder())
                    .append(SqlChars.CHARS_FROM)
                    .append(tableMain.getName())
                    .append(SqlChars.CHARS_AS)
                    .append(tableMain.getAlias())
                    .append(sqlJoin.getBuilder())
                    .append(sqlWhere.getBuilder());
        }
        return getSql();
    }
}
