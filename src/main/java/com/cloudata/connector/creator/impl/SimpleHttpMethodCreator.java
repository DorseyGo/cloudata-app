/*
 * File name: SimpleHttpMethodCreator
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.creator.impl;

import com.cloudata.connector.creator.HttpMethodCreator;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

/**
 * Author: DORSEy
 */
public class SimpleHttpMethodCreator implements HttpMethodCreator {

    /**
     * The url address that this request posted to.
     */
    private final String url;

    /**
     * The sole singleton instance.
     */
    private static SimpleHttpMethodCreator creator = null;

    /**
     * Sole constructor of {@link SimpleHttpMethodCreator}, with <code>url</code> specified.
     *
     * @param url the url.
     */
    private SimpleHttpMethodCreator(final String url) {
        if (url == null || url.isEmpty())
            throw new IllegalArgumentException("URL address \'" + url + "\' should not be null or empty");

        this.url = url;
    }

    /**
     * Returns a sole instance of {@link SimpleHttpMethodCreator}, with <code>url</code> specified.
     *
     * @param url the url.
     * @return a sole instance of {@link SimpleHttpMethodCreator}.
     */
    public static SimpleHttpMethodCreator create(final String url) {
        if (creator == null) {
            creator = new SimpleHttpMethodCreator(url);
        }

        return creator;
    }

    @Override
    public HttpPost createHttpPost(final StringEntity entity) {
        if (entity == null)
            throw new IllegalArgumentException("Entity within rich information \'" + entity + "\' should not be null");

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        post.setHeader(CONTENT_TYPE_NAME, CONTENT_TYPE_VALUE);

        return post;
    }
}
