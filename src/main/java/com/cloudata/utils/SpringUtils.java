/*
 * File name: SpringUtils
 * Author: Dorsey Q F TANG
 * Date: 8/4/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: DORSEy
 */
public final class SpringUtils {
    /**
     * The resource configuration.
     */
    private static final String APP_CONTEXT_XML = "classpath*:applicationContext*.xml";

    /**
     * The cached.
     */
    private static Map<Class<?>, Object> cached = new HashMap<>();

    /**
     * Returns an instance of object with <tt>type</tt> specified.
     *
     * @param type the type.
     * @param <T> the type of object.
     * @return the instance if existed.
     */
    public static <T> T getBean(final Class<T> type) {
        T bean = null;
        if ((bean = (T) cached.get(type)) != null) {
            return bean;
        }

        ApplicationContext context = new ClassPathXmlApplicationContext(APP_CONTEXT_XML);
        bean = context.getBean(type);
        cached.put(type, bean);

        return bean;
    }
}
