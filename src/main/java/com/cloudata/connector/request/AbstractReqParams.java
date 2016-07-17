/*
 * File name: AbstractReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/14/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;
import com.cloudata.utils.ReflectionUtils;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The abstraction of {@link ReqParams}, which defines the common services being shared by its subclasses.
 * <p>
 * Author: DORSEy
 */
abstract class AbstractReqParams implements ReqParams {

    /**
     * The class name.
     */
    private static final String CNAME = AbstractReqParams.class.getName();

    /**
     * The log tracker to record level DEBUG message.
     */
    private Log DEBUGGER = LogFactory.getLog(CNAME);

    /**
     * The command to be send to the specific server.
     */
    @Serialize(name = ConConstants.SERIALIZED_METHOD)
    protected final String method;

    @Serialize(name = ConConstants.SERIALIZED_ID)
    private final int id;

    /**
     * Constructor of {@link AbstractReqParams}, with method specified.
     *
     * @param method the method.
     */
    protected AbstractReqParams(final String method) {
        this.method = method;
        this.id = 1;
    }

    @Override
    public StringEntity toStringEntity() throws UnsupportedEncodingException {
        final String METHOD = "toStringEntity()";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY");
        }


        final Map<String, Field> shouldBeSerialized = new HashMap<>(32);
        ReflectionUtils.doWithFields(this.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalAccessException, IllegalArgumentException {
                Serialize serialize = field.getAnnotation(Serialize.class);
                String serializeName = serialize.name();
                if ("".equals(serializeName)) {
                    serializeName = field.getName();
                }

                shouldBeSerialized.put(serializeName, field);
            }
        }, new ReflectionUtils.FieldFilter() {
            @Override
            public boolean matches(Field field) {
                return field.isAnnotationPresent(Serialize.class);
            }
        });


        // divide into two parts
        Map<String, Object> serialized = new LinkedHashMap<>();
        Object methodVal = ReflectionUtils.getFieldValue(this, shouldBeSerialized.remove(ConConstants.SERIALIZED_METHOD));
        serialized.put(ConConstants.SERIALIZED_METHOD, methodVal);
        // the last id part.
        Object idVal = ReflectionUtils.getFieldValue(this, shouldBeSerialized.remove(ConConstants.SERIALIZED_ID));

        Map<String, Object> serializedParams = new LinkedHashMap<>();
        Orderized orderized = this.getClass().getAnnotation(Orderized.class);
        if (orderized != null) {
            String[] orders = orderized.order();
            Field field = null;
            Object val = null;
            for (String item : orders) {
                field = shouldBeSerialized.get(item);
                if (field == null)
                    continue;

                val = ReflectionUtils.getFieldValue(this, field);
                serializedParams.put(item, val);
            }
        } else {
            Iterator<Map.Entry<String, Field>> entries = shouldBeSerialized.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Field> entry = entries.next();
                String serializedName = entry.getKey();
                Object val = ReflectionUtils.getFieldValue(this, entry.getValue());

                serializedParams.put(serializedName, val);
            }
        }

        serialized.put(ConConstants.SERIALIZED_PARAMS, serializedParams);

        // id field
        serialized.put(ConConstants.SERIALIZED_ID, idVal);

        Gson gson = new Gson();
        String content = gson.toJson(serialized);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - content = " + content);
        }

        return new StringEntity(content);
    }
}
