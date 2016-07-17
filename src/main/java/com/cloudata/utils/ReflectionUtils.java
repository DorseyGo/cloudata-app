/*
 * File name: ReflectionUtils
 * Author: Dorsey Q F TANG
 * Date: 7/15/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Author: DORSEy
 */
public final class ReflectionUtils {

    /**
     * The buffer to fields being searched.
     */
    private static final Map<Class<?>, Field[]> cachedDeclaredFields = new HashMap<Class<?>, Field[]>();

    public static Field[] getAllDeclaredFields(final Class<?> leafClass) {
        final List<Field> result = new LinkedList<>();
        doWithFields(leafClass, new FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalAccessException, IllegalArgumentException {
                result.add(field);
            }
        });

        return result.toArray(new Field[result.size()]);
    }

    public static void doWithFields(final Class<?> leafClass, final FieldCallback callback) {
        doWithFields(leafClass, callback, null);
    }

    public static void doWithFields(final Class<?> leafClass, final FieldCallback callback, final FieldFilter filter) {
        Field[] declaredFields = getDeclaredFields(leafClass);
        for (Field field : declaredFields) {
            try {
                if (filter == null || filter.matches(field)) {
                    callback.doWith(field);
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Not allowed to access field \'" + field.getName() + "\'");
            }
        }

        Class<?> superClass = leafClass.getSuperclass();
        if (superClass != null && !superClass.isInterface() && superClass != Object.class) {
            doWithFields(superClass, callback, filter);
        }
    }

    public static Field[] getDeclaredFields(final Class<?> leafClass) {
        Field[] result = cachedDeclaredFields.get(leafClass);
        if (result != null) {
            return result;
        }

        result = leafClass.getDeclaredFields();
        cachedDeclaredFields.put(leafClass, result);
        return result;
    }

    public static Object getFieldValue(final Object target, final Field field) {
        Object val = null;
        field.setAccessible(true);
        try {
            val = field.get(target);
        } catch (IllegalAccessException ignore) {
            // ignore
        }

        return val;
    }

    public interface FieldCallback {
        void doWith(final Field field) throws IllegalAccessException, IllegalArgumentException;
    }

    public interface FieldFilter {
        /**
         * Tests whether the specific <code>field</code> matched the specific condition. <p> Returns true if and only if
         * it is matched, otherwise false. </p>
         *
         * @param field the field to be tested.
         * @return true if and only if the specified field is acceptable.
         */
        boolean matches(final Field field);
    }
}
