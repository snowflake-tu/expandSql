/*
 * Thanks for using.
 */

package cn.eck2016.expandSql.mysql.transform.impl;

import cn.eck2016.expandSql.mysql.transform.ObjectTransform;

/**
 * 对象处理器实现类.
 *
 * @author eck2016 at 2020/2/14
 * @version 1.0.0
 * @since 1.8
 */
public final class ObjectTransformImpl implements ObjectTransform {

    @Override
    public String formString(String value) {
        String tmpStr = value.replace("\\", "\\\\");
        tmpStr = tmpStr.replace("'", "\\'");
        return tmpStr;
    }

    @Override
    public String fromObject(Object value) {
        return value.toString();
    }


}
