package com.hintdesk.De_De_Dict.contract.util.common;

import com.hintdesk.De_De_Dict.contract.constants.enumerations.WordType;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 6/2/13
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class EnumUtil {
    public static <E extends Enum<E>> Enum<E> getValue(String enumString, Class<E> enumClass )
    {
        for(Enum<E> enumValue: enumClass.getEnumConstants())
        {
            if (enumValue.toString().equals(enumString))
            {
                return enumValue;
            }
        }
        return  null;
    }


}
