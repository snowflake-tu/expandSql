/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理SQL语句.
 *
 * @author eck2016 at 2020/2/14
 * @version 1.0.0
 * @since 1.8
 */
public abstract class SqlBuilder {

    /**
     * 日志记录.
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(SqlBuilder.class);
    /**
     * DebugEnable-Flag.
     */
    private boolean logDebugEnabled = LOGGER.isDebugEnabled();
    /**
     * 记录SQL语句.
     */
    protected StringBuilder builder = new StringBuilder(200);

    protected String getSql() {
        String sql = builder.toString();
        if (logDebugEnabled) {
            LOGGER.debug(sql);
        }
        return sql;
    }

    protected boolean isEmpty() {
        return builder.length() == 0;
    }

    public abstract String buildSql();

}
