/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql;

import cn.eck2016.expandSql.mysql.component.*;
import cn.eck2016.expandSql.mysql.item.IgnoreItemSet;
import cn.eck2016.expandSql.mysql.item.IgnoreItemWhere;
import cn.eck2016.expandSql.mysql.item.lambda.IIgnoreItemWhere;

/**
 * UPDATE语句.
 *
 * @author eck2016 at 2020/2/20
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlUBuilder extends SqlBuilder {

    /**
     * 基表。
     */
    private Table tableMain;
    /**
     * 关联表.
     */
    private SqlJoin sqlJoin;
    /**
     * UPDATE信息.
     */
    private SqlUpdate sqlUpdate;
    /**
     * 约束信息.
     */
    private SqlWhere sqlWhere;

    /**
     * 私有构造方法.
     *
     * @param table
     * @return
     * @author eck2016 at 2020/2/20
     */
    private SqlUBuilder(Table table) {
        this.tableMain = table;
        this.sqlJoin = new SqlJoin();
        this.sqlUpdate = new SqlUpdate();
        this.sqlWhere = new SqlWhere();
    }

    /**
     * 代理函数.
     *
     * @param table
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public static SqlUBuilder baseTable(Table table) {
        return new SqlUBuilder(table);
    }

    /**
     * UPDATE信息.
     *
     * @param ignoreItemSets
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder update(IgnoreItemSet... ignoreItemSets) {
        sqlUpdate.update(ignoreItemSets);
        return this;
    }

    /**
     * 内连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder innerJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.innerJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 内连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder innerJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.innerJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 左连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder leftJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.leftJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 左连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder leftJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.leftJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 右连接.
     *
     * @param tableJoin
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder rightJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        sqlJoin.rightJoin(tableJoin, ignoreItemWhere);
        return this;
    }

    /**
     * 右连接(lambda).
     *
     * @param tableJoin
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder rightJoin(Table tableJoin, IIgnoreItemWhere IIgnoreItemWhere) {
        sqlJoin.rightJoin(tableJoin, IIgnoreItemWhere.createInstance());
        return this;
    }

    /**
     * 约束条件.
     *
     * @param ignoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder where(IgnoreItemWhere ignoreItemWhere) {
        sqlWhere.where(ignoreItemWhere);
        return this;
    }

    /**
     * 约束条件(lambda).
     *
     * @param IIgnoreItemWhere
     * @return cn.eck2016.expandSql.mysql.SqlUBuilder
     * @author eck2016 at 2020/2/20
     */
    public SqlUBuilder where(IIgnoreItemWhere IIgnoreItemWhere) {
        sqlWhere.where(IIgnoreItemWhere.createInstance());
        return this;
    }


    @Override
    public String buildSql() {
        if (isEmpty()) {
            builder.append(SqlChars.CHARS_UPDATE)
                    .append(tableMain.getName())
                    .append(SqlChars.CHARS_AS)
                    .append(tableMain.getAlias())
                    .append(sqlJoin.getBuilder())
                    .append(SqlChars.CHARS_SET)
                    .append(sqlUpdate.getBuilder())
                    .append(sqlWhere.getBuilder());
        }
        return getSql();
    }
}
