/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.IgnoreItemSet;

/**
 * 记录UPDATE操作涉及的字段信息.
 *
 * @author eck2016 at 2020/2/5
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlUpdate {

    /**
     * 使用StringBuilder记录UPDATE操作涉及的字段信息,初始化大小为100.
     */
    private StringBuilder builder = new StringBuilder(100);
    /**
     * 计数变量,用于判断是否需要插入分隔符.
     */
    private int count = 0;

    /**
     * 记录UPDATE操作涉及的字段信息.
     *
     * @param ignoreItemSets UPDATE操作涉及的字段信息.
     * @return void
     * @author eck2016 at 2020/2/5
     */
    public void update(IgnoreItemSet... ignoreItemSets) {
        for (IgnoreItemSet ignoreItemSet : ignoreItemSets) {
            if (!ignoreItemSet.isIgnore()) {
                if (count > 0) {
                    builder.append(SqlChars.CHARS_SPLIT);
                }
                builder.append(ignoreItemSet.getExpression());
                count++;
            }
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }
}
