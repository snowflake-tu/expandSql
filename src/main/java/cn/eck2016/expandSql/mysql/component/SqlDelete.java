/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

/**
 * 记录执行DELETE操作的表.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlDelete {

    /**
     * 使用StringBuilder记录执行删除操作的表,初始化大小为10
     */
    private StringBuilder builder = new StringBuilder(20);
    /**
     * 计数变量,用于判断是否需要插入分隔符.
     */
    private int count = 0;

    /**
     * 记录执行DELETE操作的表.
     *
     * @param table 执行删除操作的表
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void delete(Table table) {
        if (count > 0) {
            builder.append(SqlChars.CHARS_SPLIT);
        }
        builder.append(table.getAlias());
        count++;
    }

    public StringBuilder getBuilder() {
        return builder;
    }
}
