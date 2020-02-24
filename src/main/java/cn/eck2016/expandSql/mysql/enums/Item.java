/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.enums;

/**
 * 约束条件或SET操作的处理策略.
 *
 * @author eck2016 at 2020/2/5
 * @version 1.0.0
 * @since 1.8
 */
public enum Item {
    /**
     * MUST:该约束条件或SET操作是必须的.
     */
    MUST,
    /**
     * IGNORE_NULL:当该约束条件或SET操作的值为NULL时,该约束条件或SET操作将被忽略.
     */
    IGNORE_NULL,
    /**
     * IGNORE_NULL_EMPTY:当该约束条件或SET操作的值类型为String类且isEmpty()为true时,该约束条件或SET操作将被忽略.
     */
    IGNORE_NULL_EMPTY
}
