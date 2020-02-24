/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

/**
 * 记录SELECT操作的排序信息.
 *
 * @author eck2016 at 2020/2/12
 * @version 1.0.0
 * @since 1.8
 */
public final class IgnoreItemOrder extends AbstractIgnoreItem {

    /**
     * 唯一构造方法.
     *
     * @param expression SELECT操作的排序信息.
     * @return
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemOrder(String expression) {
        setExpression(expression);
    }

    /**
     * 修改ignore.
     *
     * @param ignore 是否忽略.
     * @return cn.eck2016.expandSql.mysql.item.IgnoreItemOrder
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemOrder ignore(boolean ignore) {
        setIgnore(ignore);
        return this;
    }


}
