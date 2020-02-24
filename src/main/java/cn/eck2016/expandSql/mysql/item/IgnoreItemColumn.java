/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

/**
 * 记录SELECT操作涉及的字段信息,函数信息.
 *
 * @author eck2016 at 2020/2/5
 * @version 1.0.0
 * @since 1.8
 */
public final class IgnoreItemColumn extends AbstractIgnoreItem {

    /**
     * 构造方法.
     *
     * @param expression SELECT操作涉及的字段信息,函数信息.
     * @return
     * @author eck2016 at 2020/2/5
     */
    public IgnoreItemColumn(String expression) {
        setExpression(expression);
    }

    /**
     * 修改ignore.
     *
     * @param ignore 是否忽略.
     * @return cn.eck2016.expandSql.mysql.item.IgnoreItemColumn
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemColumn ignore(boolean ignore) {
        setIgnore(ignore);
        return this;
    }

}
