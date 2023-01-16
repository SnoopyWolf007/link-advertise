package cn.link.kit.core.util;

import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Objects;

/**
 * @author g
 */
public class IBeanUtils {

    private IBeanUtils() {
    }

    /**
     * 获取id
     */
    public static Long getId(Object bean) {
        try {
            Class<?> clazz = bean.getClass();
            Method getId = clazz.getMethod("getId");
            return (Long) getId.invoke(bean);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取userId
     */
    public static Long getUserId(Object bean) {
        try {
            Class<?> clazz = bean.getClass();
            Method getId = clazz.getMethod("getUserId");
            return (Long) getId.invoke(bean);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getTableName(Object bean) {
        try {
            Class<?> clazz = bean.getClass();
            Table table = clazz.getAnnotation(Table.class);
            if (table != null) {
                return table.name();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getGetterMethod(String fieldName) {
        String part1 = fieldName.substring(0, 1).toUpperCase(Locale.ROOT);
        String part2 = fieldName.substring(1);
        return "get" + part1 + part2;
    }

    public static String getSetterMethod(String fieldName) {
        String part1 = fieldName.substring(0, 1).toUpperCase(Locale.ROOT);
        String part2 = fieldName.substring(1);
        return "set" + part1 + part2;
    }

    public static void update(Object oldBean, Object newBean) {
        Class<?> aClass = newBean.getClass();
        Field[] declaredFields = newBean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                String getterMethod = IBeanUtils.getGetterMethod(field.getName());
                Method getter = aClass.getDeclaredMethod(getterMethod);
                getter.setAccessible(true);
                Object val = getter.invoke(newBean);
                if (!Objects.isNull(val)) {
                    String setterMethod = IBeanUtils.getSetterMethod(field.getName());
                    Method setter = aClass.getDeclaredMethod(setterMethod, field.getType());
                    setter.setAccessible(true);
                    setter.invoke(oldBean, val);
                }
            } catch (Exception ignore) {
            }
        }
    }

    public static void main(String[] args) {
        String fieldName = "name";
        System.out.println(getGetterMethod(fieldName));

        String x = "姜排排(*明)";
        String substring = x.substring(0, x.lastIndexOf("("));
        System.out.println(substring);
    }
}
