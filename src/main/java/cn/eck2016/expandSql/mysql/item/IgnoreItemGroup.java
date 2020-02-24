/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

/**
 * 记录SELECT操作的分组信息.
 *
 * @author eck2016 at 2020/2/12
 * @version 1.0.0
 * @since 1.8
 */
public final class IgnoreItemGroup extends AbstractIgnoreItem {

    /**
     * 唯一构造方法.
     *
     * @param expression SELECT操作的分组信息.
     * @return
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemGroup(String expression) {
        setExpression(expression);
    }

    /**
     * 修改ignore.
     *
     * @param ignore 是否忽略.
     * @return cn.eck2016.expandSql.mysql.item.IgnoreItemGroup
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemGroup ignore(boolean ignore) {
        setIgnore(ignore);
        return this;
    }

}
