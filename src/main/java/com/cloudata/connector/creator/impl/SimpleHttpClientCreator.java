/*
 * File name: SimpleHttpClientCreator
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.creator.impl;

import com.cloudata.connector.creator.HttpClientCreator;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * An implementation of {@link HttpClientCreator}, with the simplest configuration.
 *
 * Author: DORSEy
 */
public class SimpleHttpClientCreator implements HttpClientCreator {

    @Override
    public CloseableHttpClient creatHttpClient() {
        HttpClientBuilder builder = HttpClientBuilder.create();

        return builder.build();
    }
}
