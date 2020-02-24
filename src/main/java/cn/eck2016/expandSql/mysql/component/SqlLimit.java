/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

/**
 * 记录限制查询结果返回的数量.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlLimit {

    /**
     * 使用StringBuilder记录限制查询结果返回的数量,初始化大小为30.
     */
    private StringBuilder builder = new StringBuilder(30);

    /**
     * 记录限制查询结果返回的数量.
     *
     * @param offset 起始索引.
     * @param size   取出记录数量.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void limit(Integer offset, Integer size) {
        builder.append(SqlChars.CHARS_LIMIT);
        builder.append(offset);
        builder.append(SqlChars.CHARS_SPLIT);
        builder.append(size);
    }

    public StringBuilder getBuilder() {
        return builder;
    }

}
