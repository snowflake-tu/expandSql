/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemGroup;

/**
 * 记录SELECT操作的分组信息.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlGroupBy {

    /**
     * 使用StringBuilder记录SELECT操作的分组信息,初始化大小为20.
     */
    private StringBuilder builder = new StringBuilder(20);
    /**
     * 计数变量,用于判断是否需要插入分隔符.
     */
    private int count = 0;

    /**
     * 记录查询结果的分组参照字段.
     *
     * @param ignoreItemGroups 分组参照字段.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void groupBy(IgnoreItemGroup... ignoreItemGroups) {
        for (IgnoreItemGroup ignoreItemGroup : ignoreItemGroups) {
            if (!ignoreItemGroup.isIgnore()) {
                if (count == 0) {
                    builder.append(SqlChars.CHARS_GROUP_BY);
                } else {
                    builder.append(SqlChars.CHARS_SPLIT);
                }
                builder.append(ignoreItemGroup.getExpression());
                count++;
            }
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }
}
