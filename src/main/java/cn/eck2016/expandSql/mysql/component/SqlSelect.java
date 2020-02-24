/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemColumn;

/**
 * 记录SELECT操作涉及的字段信息.
 *
 * @author eck2016 at 2020/2/5
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlSelect {

    /**
     * 使用StringBuilder记录SELECT操作涉及的字段信息,初始化大小为100.
     */
    private StringBuilder builder = new StringBuilder(100);
    /**
     * 计数变量,用于判断是否需要插入分隔符.
     */
    private int count = 0;

    /**
     * 记录SELECT操作涉及的字段信息.
     *
     * @param ignoreItemColumns 字段信息,如:table.field,COUNT(table.field),'Constant'.
     * @return void
     * @author eck2016 at 2020/2/5
     */
    public void select(IgnoreItemColumn... ignoreItemColumns) {
        for (IgnoreItemColumn ignoreItemColumn : ignoreItemColumns) {
            if (count > 0) {
                builder.append(SqlChars.CHARS_SPLIT);
            }
            builder.append(ignoreItemColumn.getExpression());
            count++;
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }
}
