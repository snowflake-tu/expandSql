/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.component;

import cn.eck2016.expandSql.mysql.item.ItemFunction;
import cn.eck2016.expandSql.mysql.singleton.BaseTransform;

/**
 * 记录INSERT操作涉及的字段信息与数据信息.
 *
 * @author eck2016 at 2020/2/4
 * @version 1.0.0
 * @since 1.8
 */
public final class SqlInsert {

    /**
     * 字段信息追加标记,为true时表示需要追加字段信息.
     * 为false时表示不再追加字段信息.
     */
    private boolean fieldFlag = true;
    /**
     * 字段信息计数,用于判断是否需要插入分隔符.
     */
    private int fieldCount = 0;
    /**
     * 数据信息计数,用于判断是否需要插入分隔符.
     */
    private int valueCount = 0;
    /**
     * 使用StringBuilder记录INSERT操作涉及的字段信息.
     */
    private StringBuilder fieldsBuilder = new StringBuilder();
    /**
     * 使用StringBuilder记录INSERT操作涉及的数据信息.
     */
    private StringBuilder valuesBuilder = new StringBuilder();

    /**
     * 追加字段信息.
     *
     * @param field 字段信息.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    private void appendFields(String field) {
        if (fieldFlag) {
            if (fieldCount == 0) {
                fieldsBuilder.append(SqlChars.CHARS_START);
            } else {
                fieldsBuilder.append(SqlChars.CHARS_SPLIT);
            }
            fieldsBuilder.append(field);
            fieldCount++;
        }
    }

    /**
     * 追加数据信息的前置处理.
     *
     * @return void
     * @author eck2016 at 2020/2/4
     */
    private void beforeAppendValues() {
        if (!fieldFlag && valueCount == 0) {
            valuesBuilder.append(SqlChars.CHARS_SPLIT);
        }
        if (valueCount == 0) {
            valuesBuilder.append(SqlChars.CHARS_START);
        } else {
            valuesBuilder.append(SqlChars.CHARS_SPLIT);
        }
        valueCount++;
    }

    /**
     * 数据信息追加完毕.
     *
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void appendSplit() {
        if (fieldFlag) {
            fieldFlag = false;
            fieldsBuilder.append(SqlChars.CHARS_END);
        }
        valueCount = 0;
        valuesBuilder.append(SqlChars.CHARS_END);
    }

    /**
     * 追加整数型数据信息.
     *
     * @param field 字段信息.
     * @param value 整数型数据信息.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void insert(String field, Integer value) {
        appendFields(field);
        beforeAppendValues();
        valuesBuilder.append(value.toString());
    }

    /**
     * 追加长整数型数据信息.
     *
     * @param field 字段信息.
     * @param value 长整数型数据信息.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void insert(String field, Long value) {
        appendFields(field);
        beforeAppendValues();
        valuesBuilder.append(value.toString());
    }

    /**
     * 追加字符串型数据信息.
     *
     * @param field 字段信息.
     * @param value 字符串型数据信息.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void insert(String field, String value) {
        appendFields(field);
        beforeAppendValues();
        String tmpStr = BaseTransform.getInstance().valueOf(value);
        valuesBuilder.append("'");
        valuesBuilder.append(tmpStr);
        valuesBuilder.append("'");
    }

    /**
     * 追加SQL函数表达式.
     *
     * @param field        字段信息.
     * @param itemFunction SQL函数表达式.
     * @return void
     * @author eck2016 at 2020/2/4
     */
    public void insert(String field, ItemFunction itemFunction) {
        appendFields(field);
        beforeAppendValues();
        valuesBuilder.append(itemFunction.getExpression());
    }

    public StringBuilder getFieldsBuilder() {
        return fieldsBuilder;
    }

    public StringBuilder getValuesBuilder() {
        return valuesBuilder;
    }

}
