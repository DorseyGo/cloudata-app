/*
 * File name: HttpClientCreator
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.creator;

import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Author: DORSEy
 */
public interface HttpClientCreator {

    /**
     * Returns an instance of {@link CloseableHttpClient}.
     *
     * @return a CloseableHttpClient.
     */
    CloseableHttpClient creatHttpClient();
}
