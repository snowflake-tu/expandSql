/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemWhere;

/**
 * 记录SELECT操作的过滤条件.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlHaving {

    /**
     * 使用StringBuilder记录SELECT操作的过滤条件,初始化大小为30.
     */
    private StringBuilder builder = new StringBuilder(30);

    /**
     * 记录SELECT操作的过滤条件.
     *
     * @param ignoreItemWhere 过滤条件,如:fieldName > 10 AND COUNT(fieldName) > 3.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void having(IgnoreItemWhere ignoreItemWhere) {
        if (ignoreItemWhere != null && !ignoreItemWhere.isIgnore()) {
            builder.append(SqlChars.CHARS_HAVING);
            builder.append(ignoreItemWhere.getExpression());
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }
}
