/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

/**
 * 记录SELECT操作、UPDATE操作、DELETE操作的约束条件.
 *
 * @author eck2016 at 2020/2/12
 * @version 1.0.0
 * @since 1.8
 */
public final class IgnoreItemWhere extends AbstractIgnoreItem {

    /**
     * 调用WhereItem.Null()返回null.
     *
     * @return cn.eck2016.expandSql.mysql.item.WhereItem
     * @author eck2016 at 2020/2/12
     */
    public static IgnoreItemWhere Null() {
        return null;
    }

    /**
     * 构造方法.
     *
     * @param ignore     是否忽略.
     * @param expression SELECT操作、UPDATE操作、DELETE操作的约束条件.
     * @return
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemWhere(boolean ignore, String expression) {
        setIgnore(ignore);
        setExpression(expression);
    }

    /**
     * 修改ignore.
     *
     * @param ignore 是否忽略.
     * @return cn.eck2016.expandSql.mysql.item.IgnoreItemWhere
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemWhere ignore(boolean ignore) {
        setIgnore(ignore);
        return this;
    }

}
