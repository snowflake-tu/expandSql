/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemWhere;

/**
 * 记录关联表信息.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlJoin {

    /**
     * 使用StringBuilder记录关联表信息,初始化大小为100.
     */
    StringBuilder builder = new StringBuilder(100);

    /**
     * 内关联.
     *
     * @param tableJoin 数据表.
     * @param ignoreItemWhere 关联条件.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void innerJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        builder.append(SqlChars.CHARS_INNER_JOIN);
        builder.append(tableJoin.getName());
        builder.append(SqlChars.CHARS_AS);
        builder.append(tableJoin.getAlias());
        builder.append(SqlChars.CHARS_ON);
        builder.append(ignoreItemWhere.getExpression());
    }

    /**
     * 左外关联.
     *
     * @param tableJoin 数据表.
     * @param ignoreItemWhere 关联条件.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void leftJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        builder.append(SqlChars.CHARS_LEFT_JOIN);
        builder.append(tableJoin.getName());
        builder.append(SqlChars.CHARS_AS);
        builder.append(tableJoin.getAlias());
        builder.append(SqlChars.CHARS_ON);
        builder.append(ignoreItemWhere.getExpression());
    }

    /**
     * 右外关联.
     *
     * @param tableJoin 数据表.
     * @param ignoreItemWhere 关联条件.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void rightJoin(Table tableJoin, IgnoreItemWhere ignoreItemWhere) {
        builder.append(SqlChars.CHARS_RIGHT_JOIN);
        builder.append(tableJoin.getName());
        builder.append(SqlChars.CHARS_AS);
        builder.append(tableJoin.getAlias());
        builder.append(SqlChars.CHARS_ON);
        builder.append(ignoreItemWhere.getExpression());
    }

    public StringBuilder getBuilder() {
        return builder;
    }

}
