/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

/**
 * 常用的SQL字符串.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlChars {

    /**
     * 私有构造方法.
     *
     * @author eck2016 at 2020/2/20
     */
    private SqlChars() {
    }

    public static final String STRING_REGEX_REPLACE = "\\$";
    public static final String STRING_REPLACE = "$";
    public static final String STRING_EQ = " = ";
    public static final String STRING_LT = " < ";
    public static final String STRING_GT = " > ";
    public static final String STRING_LEQ = " <= ";
    public static final String STRING_GEQ = " >= ";
    public static final String STRING_LIKE = " LIKE ";
    public static final String STRING_IN = " IN ";
    public static final char[] CHARS_INSERT_INTO = "INSERT INTO ".toCharArray();
    public static final char[] CHARS_VALUES = " VALUES ".toCharArray();
    public static final char[] CHARS_DELETE = "DELETE ".toCharArray();
    public static final char[] CHARS_SELECT = "SELECT ".toCharArray();
    public static final char[] CHARS_UPDATE = "UPDATE ".toCharArray();
    public static final char[] CHARS_FROM = " FROM ".toCharArray();
    public static final char[] CHARS_SET = " SET ".toCharArray();
    public static final char[] CHARS_DOT = ".".toCharArray();
    public static final char[] CHARS_EQ = " = ".toCharArray();
    public static final char[] CHARS_START = "(".toCharArray();
    public static final char[] CHARS_SPLIT = ",".toCharArray();
    public static final char[] CHARS_END = ")".toCharArray();
    public static final char[] CHARS_INNER_JOIN = " INNER JOIN ".toCharArray();
    public static final char[] CHARS_LEFT_JOIN = " LEFT JOIN ".toCharArray();
    public static final char[] CHARS_RIGHT_JOIN = " RIGHT JOIN ".toCharArray();
    public static final char[] CHARS_AS = " AS ".toCharArray();
    public static final char[] CHARS_ON = " ON ".toCharArray();
    public static final char[] CHARS_AND = " AND ".toCharArray();
    public static final char[] CHARS_OR = " OR ".toCharArray();
    public static final char[] CHARS_WHERE = " WHERE ".toCharArray();
    public static final char[] CHARS_GROUP_BY = " GROUP BY ".toCharArray();
    public static final char[] CHARS_HAVING = " HAVING ".toCharArray();
    public static final char[] CHARS_ORDER_BY = " ORDER BY ".toCharArray();
    public static final char[] CHARS_LIMIT = " LIMIT ".toCharArray();
    public static final char[] CHARS_QUOTE = "'".toCharArray();
    public static final char[] CHARS_ASC = " ASC".toCharArray();
    public static final char[] CHARS_DESC = " DESC".toCharArray();

}
