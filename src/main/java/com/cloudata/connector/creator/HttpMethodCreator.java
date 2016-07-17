/*
 * File name: HttpMethodCreator
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.creator;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

/**
 * Author: DORSEy
 */
public interface HttpMethodCreator {

    /**
     * The constant of content type name.
     */
    String CONTENT_TYPE_NAME = "Content-Type";

    /**
     * The content type value, which represents it is a request with json data being sent with.
     */
    String CONTENT_TYPE_VALUE = "application/json;charset=utf8";

    /**
     * Returns a created HTTP post, with rich information specified by <code>entity</code>.
     *
     * @param entity the entity.
     * @return a created HTTP post.
     */
    HttpPost createHttpPost(final StringEntity entity);
}
