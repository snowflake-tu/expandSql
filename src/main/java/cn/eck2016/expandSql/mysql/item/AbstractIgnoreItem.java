/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

/**
 * 可忽略项目,用于实现动态SQL.
 *
 * @author eck2016 at 2020/2/14
 * @version 1.0.0
 * @since 1.8
 */
public abstract class AbstractIgnoreItem {

    /**
     * 忽略标记,为true时表示此项被忽略.
     */
    private boolean ignore;
    /**
     * 使用String记录信息.
     */
    private String expression;

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public String getExpression() {
        return expression;
    }

}
