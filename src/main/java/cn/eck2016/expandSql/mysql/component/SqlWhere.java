/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemWhere;

/**
 * 记录SELECT操作、UPDATE操作、DELETE操作的约束条件.
 *
 * @author eck2016 at 2020/2/5
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlWhere {

    /**
     * 使用StringBuilder记录SELECT操作、UPDATE操作、DELETE操作的约束条件,初始化大小为100.
     */
    private StringBuilder builder = new StringBuilder(100);
    /**
     * 计数变量,用于判断是否需要强制性添加WHERE关键字.
     */
    private int count = 0;

    /**
     * 记录SELECT操作、UPDATE操作、DELETE操作的约束条件.
     * 注意:在不调用该方法时,会强制性添加WHERE关键字,以防因为疏忽而导致操作全表的情况发生.
     * 如果需要操作全表,可传递NULL作为参数.
     *
     * @param ignoreItemWhere 约束条件.
     * @return void
     * @author eck2016 at 2020/2/5
     */
    public void where(IgnoreItemWhere ignoreItemWhere) {
        count++;
        if (ignoreItemWhere != null && !ignoreItemWhere.isIgnore()) {
            builder.append(SqlChars.CHARS_WHERE);
            builder.append(ignoreItemWhere.getExpression());
        }
    }

    public StringBuilder getBuilder() {
        if (count == 0) builder.append(SqlChars.CHARS_WHERE);
        return builder;
    }
}
