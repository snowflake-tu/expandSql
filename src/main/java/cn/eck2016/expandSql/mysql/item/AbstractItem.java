/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.item;

import cn.eck2016.expandSql.mysql.SqlRBuilder;
import cn.eck2016.expandSql.mysql.component.SqlChars;
import cn.eck2016.expandSql.mysql.enums.Item;
import cn.eck2016.expandSql.mysql.enums.ValueType;
import cn.eck2016.expandSql.mysql.singleton.BaseTransform;

import java.util.List;

/**
 * 处理SELECT、UPDATE、DELETE语句中跟数据表字段相关的信息.
 *
 * @author eck2016 at 2020/2/13
 * @version 1.0.0
 * @since 1.8
 */
public abstract class AbstractItem {

    /**
     * 使用String记录数据表字段信息.
     */
    private String column;

    /**
     * 传入参数的类型.
     */
    private ValueType valueType = ValueType.OTHER;

    /**
     * 抽象类的构造方法.
     *
     * @param column 数据表字段信息.
     * @return
     * @author eck2016 at 2020/2/13
     */
    public AbstractItem(String column) {
        this.column = column;
    }

    protected StringBuilder createBuilder() {
        return new StringBuilder(30);
    }

    /**
     * 追加整数型数据.
     *
     * @param value
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendInteger(StringBuilder builder, Integer value) {
        builder.append(value.toString());
    }

    /**
     * 追加长整数型数据.
     *
     * @param value
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendLong(StringBuilder builder, Long value) {
        builder.append(value.toString());
    }

    /**
     * 追加字符串型数据.
     *
     * @param value
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendString(StringBuilder builder, String value) {
        BaseTransform baseTransform = BaseTransform.getInstance();
        builder.append(SqlChars.CHARS_QUOTE);
        builder.append(baseTransform.valueOf(value));
        builder.append(SqlChars.CHARS_QUOTE);
    }

    /**
     * 追加查询语句对象.
     *
     * @param value
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendSqlSelect(StringBuilder builder, SqlRBuilder value) {
        builder.append(SqlChars.CHARS_START);
        builder.append(value.buildSql());
        builder.append(SqlChars.CHARS_END);
    }

    /**
     * 追加字段对象.
     *
     * @param value
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendSqlField(StringBuilder builder, ItemField value) {
        builder.append(value.getExpression());
    }

    /**
     * 追加函数对象.
     *
     * @param value
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendSqlFunction(StringBuilder builder, ItemFunction value) {
        builder.append(value.getExpression());
    }

    /**
     * 追加整数列表型数据.
     *
     * @param values
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendIntegerList(StringBuilder builder, List<Integer> values) {
        int count = 0;
        builder.append(SqlChars.CHARS_START);
        for (Integer value : values) {
            if (count > 0) builder.append(SqlChars.CHARS_SPLIT);
            builder.append(value.toString());
            count++;
        }
        builder.append(SqlChars.CHARS_END);
    }

    /**
     * 追加长整数列表型数据.
     *
     * @param values
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendLongList(StringBuilder builder, List<Long> values) {
        int count = 0;
        builder.append(SqlChars.CHARS_START);
        for (Long value : values) {
            if (count > 0) builder.append(SqlChars.CHARS_SPLIT);
            builder.append(value.toString());
            count++;
        }
        builder.append(SqlChars.CHARS_END);
    }

    /**
     * 追加字符串列表型数据.
     *
     * @param values
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendStringList(StringBuilder builder, List<String> values) {
        int count = 0;
        builder.append(SqlChars.CHARS_START);
        BaseTransform baseTransform = BaseTransform.getInstance();
        for (String value : values) {
            if (count > 0) builder.append(SqlChars.CHARS_SPLIT);
            builder.append(SqlChars.CHARS_QUOTE);
            builder.append(baseTransform.valueOf(value));
            builder.append(SqlChars.CHARS_QUOTE);
            count++;
        }
        builder.append(SqlChars.CHARS_END);
    }

    /**
     * 追加其它类型数据.
     *
     * @param object
     * @return void
     * @author eck2016 at 2020/2/13
     */
    private void appendOther(StringBuilder builder, Object object) {
        BaseTransform baseTransform = BaseTransform.getInstance();
        builder.append(baseTransform.valueOf(object));
    }

    /**
     * 根据指定的Item处理策略,判断该项是否被忽略,同时判断并记录传入参数的类型.
     *
     * @param object 参数值.
     * @param item   Item处理策略.
     * @return boolean
     * @author eck2016 at 2020/2/13
     * @see Item Item处理策略.
     */
    protected boolean checkIgnore(Object object, Item item) {
        boolean flag = true;
        if (object == null) {
            valueType = ValueType.NULL;
        } else if (object instanceof Integer) {
            valueType = ValueType.INTEGER;
        } else if (object instanceof Long) {
            valueType = ValueType.LONG;
        } else if (object instanceof String) {
            valueType = ValueType.STRING;
        } else if (object instanceof SqlRBuilder) {
            valueType = ValueType.SQL_SELECT;
        } else if (object instanceof ItemField) {
            valueType = ValueType.SQL_FIELD;
        } else if (object instanceof ItemFunction) {
            valueType = ValueType.SQL_FUNCTION;
        } else if (object instanceof List) {
            List tmpList = (List) object;
            if (tmpList.isEmpty()) {
                valueType = ValueType.LIST_EMPTY;
            } else {
                Object tmpObject = tmpList.get(0);
                if (tmpObject instanceof Integer) {
                    valueType = ValueType.LIST_INTEGER;
                } else if (tmpObject instanceof Long) {
                    valueType = ValueType.LIST_LONG;
                } else if (tmpObject instanceof String) {
                    valueType = ValueType.LIST_STRING;
                } else {
                    valueType = ValueType.OTHER;
                }
            }
        } else {
            valueType = ValueType.OTHER;
        }
        if (item != null) {
            switch (item) {
                case MUST:
                    flag = false;
                    break;
                case IGNORE_NULL:
                    if (object != null) flag = false;
                    break;
                case IGNORE_NULL_EMPTY:
                    if (valueType.in(ValueType.STRING) && !((String) object).isEmpty()) flag = false;
                    if (valueType.in(ValueType.LIST_INTEGER, ValueType.LIST_LONG, ValueType.LIST_STRING)) flag = false;
                    break;
                default:
            }
        }
        return flag;
    }

    /**
     * 追加信息,根据传入参数的类型调用对应的追加函数.
     *
     * @param operator 操作符号,如:"=","<","<="等等...
     * @param object   传入参数.
     * @return void
     * @author eck2016 at 2020/2/13
     */
    protected void appendValue(StringBuilder builder, String operator, Object object) {
        builder.append(column);
        if (operator != null) builder.append(operator);
        switch (valueType) {
            case NULL:
            case LIST_EMPTY:
                break;
            case INTEGER:
                appendInteger(builder, (Integer) object);
                break;
            case LONG:
                appendLong(builder, (Long) object);
                break;
            case STRING:
                appendString(builder, (String) object);
                break;
            case SQL_SELECT:
                appendSqlSelect(builder, (SqlRBuilder) object);
                break;
            case SQL_FIELD:
                appendSqlField(builder, (ItemField) object);
                break;
            case SQL_FUNCTION:
                appendSqlFunction(builder, (ItemFunction) object);
                break;
            case LIST_INTEGER:
                appendIntegerList(builder, (List<Integer>) object);
                break;
            case LIST_LONG:
                appendLongList(builder, (List<Long>) object);
                break;
            case LIST_STRING:
                appendStringList(builder, (List<String>) object);
                break;
            case OTHER:
                appendOther(builder, object);
                break;
            default:
        }
    }

    /**
     * 包装为WHERE条件.
     *
     * @param operator
     * @param object
     * @param item
     * @return cn.eck2016.expandSql.mysql.item.WhereItem
     * @author eck2016 at 2020/2/13
     */
    public IgnoreItemWhere buildWhereItem(String operator, Object object, Item item) {
        boolean ignore = checkIgnore(object, item);
        String expression = null;
        if (!ignore) {
            StringBuilder builder = createBuilder();
            appendValue(builder, operator, object);
            expression = builder.toString();
        }
        return new IgnoreItemWhere(ignore, expression);
    }

    public String getExpression() {
        return column;
    }

}
