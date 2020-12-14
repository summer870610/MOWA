package com.zyy.mowa.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具类.
 *
 * @author bojiangzhou 2018-01-06
 * @version 1.0
 */

public abstract class Reflections {

    private final static Logger LOGGER = LoggerFactory.getLogger(Reflections.class);

    /**
     * 通过反射, 获得Class定义中声明的泛型参数的类型, 注意泛型必须定义在父类处. 如无法找到, 返回Object.class.
     *
     * @param clazz
     *            class类
     * @return the 返回第一个声明的泛型类型. 如果没有,则返回Object.class
     */
    @SuppressWarnings("unchecked")
    public static Class getClassGenericType(final Class clazz) {
        return getClassGenericType(clazz, 0);
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     *
     * @param clazz
     *            class类
     * @param index
     *            获取第几个泛型参数的类型,默认从0开始,即第一个
     * @return 返回第index个泛型参数类型.
     */
    public static Class getClassGenericType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            LOGGER.warn(
                "Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            LOGGER.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class)params[index];
    }

    /**
     * 根据注解类型获取实体的Field
     *
     * @param entityClass
     *            实体类型
     * @param annotationClass
     *            注解类型
     * @return 返回第一个有该注解类型的Field, 如果没有则返回null.
     */
    @SuppressWarnings("unchecked")
    public static Field getFieldByAnnotation(Class entityClass, Class annotationClass) {
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(annotationClass) != null) {
                makeAccessible(field);
                return field;
            }
        }
        return null;
    }

    /**
     * 获取实体的字段
     *
     * @param entityClass
     *            实体类型
     * @param fieldName
     *            字段名称
     * @return 该字段名称对应的字段, 如果没有则返回null.
     */
    public static Field getField(Class entityClass, String fieldName) {
        try {
            Field field = entityClass.getDeclaredField(fieldName);
            makeAccessible(field);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 改变private/protected的成员变量为public.
     */
    public static void makeAccessible(Field field) {
        if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            field.setAccessible(true);
        }
    }

    public static Object operationClass(Object o, String methodName, String attName, Class<?> paramType, Object value) {
        // 方法赋值出错标志
        boolean opErr = false;
        Object res = null;
        Class<?> type = o.getClass();
        try {
            Method method = null;
            if (methodName.indexOf("get") != -1) {
                // get方法 获取方法
                method = type.getMethod(methodName);
                // 执行
                res = method.invoke(o);
            } else {
                // set方法
                // 当没有传入参数类型时通过value获取参数类型
                paramType = paramType == null ? value.getClass() : paramType;
                // 获取方法
                method = type.getMethod(methodName, paramType);
                // 执行
                method.invoke(o, value);
                res = o;
            }
        } catch (Exception e) {
            // 通过get/set方法操作属性失败
            opErr = true;

            LOGGER.error(attName + ": [WARN] 直接对属性'" + attName + "进行操作(不借助get/set方法).");

        }

        if (opErr) {
            // 通过打破封装方式直接对值进行操作
            try {
                Field field = null;
                // 获取属性
                field = type.getDeclaredField(attName);
                // 打破封装
                field.setAccessible(true);

                if (methodName.indexOf("get") != -1) {
                    // get方法
                    // 获取属性值
                    res = field.get(o);
                } else {
                    // set方法
                    // 设置属性值
                    field.set(o, value);
                    res = o;
                }
            } catch (Exception e) {
                // 两种方法都操作失败

                LOGGER.error(attName + ": [ERROR] 属性'" + attName + "'操作失败.");

            }
        }

        return res;

    }

    public static <T> String[] getFiledName(T o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            // System.out.println(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    public static <T> T set(T o, String attName, Object value, Class<?> paramType) {
        if (o == null || attName == null || attName.isEmpty()) {
            return null;
        }
        String methodName = attNameHandle("set", attName);

        return (T)operationClass(o, methodName, attName, paramType, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Object o, String attName, Class<T> returnType) {
        if (o == null || attName == null || attName.isEmpty()) {
            return null;
        }
        String methodName = attNameHandle("get", attName);

        return (T)operationClass(o, methodName, attName, null, null);
    }

    private static String attNameHandle(String method, String attName) {
        StringBuffer res = new StringBuffer(method);
        // 属性只有一个字母
        if (attName.length() == 1) {
            res.append(attName.toUpperCase());
        } else {
            // 属性包含两个字母及以上
            char[] charArray = attName.toCharArray();
            // 当前两个字符为小写时,将首字母转换为大写
            if (Character.isLowerCase(charArray[0]) && Character.isLowerCase(charArray[1])) {
                res.append(Character.toUpperCase(charArray[0]));
                res.append(attName.substring(1));
            } else {
                res.append(attName);
            }
        }

        return res.toString();
    }
}
