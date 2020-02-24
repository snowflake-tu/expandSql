/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;


/**
 * 记录UPDATE操作涉及的字段信息.
 *
 * @author eck2016 at 2020/2/12
 * @version 1.0.0
 * @since 1.8
 */
public final class IgnoreItemSet extends AbstractIgnoreItem {


    /**
     * 唯一构造方法.
     *
     * @param ignore     是否忽略.
     * @param expression UPDATE操作涉及的字段信息.
     * @return
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemSet(boolean ignore, String expression) {
        setIgnore(ignore);
        setExpression(expression);
    }

    /**
     * 修改ignore.
     *
     * @param ignore 是否忽略.
     * @return cn.eck2016.expandSql.mysql.item.IgnoreItemSet
     * @author eck2016 at 2020/2/12
     */
    public IgnoreItemSet ignore(boolean ignore) {
        setIgnore(ignore);
        return this;
    }

}
