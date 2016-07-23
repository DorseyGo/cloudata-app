/*
 * File name: ReqConnector
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector;

import com.cloudata.connector.callback.ResultCallback;
import com.cloudata.connector.creator.HttpClientCreator;
import com.cloudata.connector.creator.HttpMethodCreator;
import com.cloudata.connector.creator.impl.SimpleHttpClientCreator;
import com.cloudata.connector.creator.impl.SimpleHttpMethodCreator;
import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.exception.InsufficientReqParamException;
import com.cloudata.connector.filter.ResultFilter;
import com.cloudata.connector.request.ReqParams;
import com.cloudata.connector.response.Resp;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * A utility class, which acts as an client to issue the request to the specific server within required request
 * parameters.
 * <p>
 * <p>
 * Author: DORSEy
 */
public class ReqConnector {

    /**
     * An instance of {@link HttpClientCreator}.
     */
    private HttpClientCreator clientCreator;

    /**
     * An instance of {@link HttpMethodCreator}.
     */
    private HttpMethodCreator methodCreator;

    /**
     * Default constructor of {@link ReqConnector}.
     */
    public ReqConnector() {
        this(new SimpleHttpClientCreator(), SimpleHttpMethodCreator.create(""));
    }

    /**
     * Constructor of {@link ReqConnector}, with client creator and method creator specified.
     *
     * @param clientCreator the client creator.
     * @param methodCreator the method creator.
     */
    public ReqConnector(final HttpClientCreator clientCreator, final HttpMethodCreator methodCreator) {
        if (methodCreator == null || clientCreator == null)
            throw new IllegalArgumentException("Method | Client creator \'" + methodCreator + "|" + clientCreator + "\' should not be null");

        this.methodCreator = methodCreator;
        this.clientCreator = clientCreator;
    }

    /**
     * It will post the parameters specified by <code>reqParams</code> to the specified server. The
     * <code>callback</code> will process the result generated if the filter specified is either <tt>null</tt> or it is
     * not filtered according to certain conditions.
     *
     * @param reqParams    the request parameters.
     * @param callback     the callback to process the generated response.
     * @param resultFilter the filter to filter the result being processed.
     * @throws CommandExecutionException if following condition met: <ul> <li>the status code it returns is not 200</li>
     *                                   <li>I/O error detected during the process</li> <li>the error occurred during
     *                                   processing the result generated</li> </ul>
     */
    public <T extends Resp> T connect(final ReqParams reqParams, final ResultCallback<T> callback, final ResultFilter resultFilter) throws CommandExecutionException {
        if (reqParams == null)
            throw new IllegalArgumentException("Request parameters \'" + reqParams + "\' should not be null");

        HttpPost post = null;
        int statusCode = HttpStatus.SC_OK;
        CloseableHttpClient httpClient = clientCreator.creatHttpClient();
        try {
            StringEntity entity = reqParams.toStringEntity();
            post = methodCreator.createHttpPost(entity);
            CloseableHttpResponse response = httpClient.execute(post);

            // check whether the request succeed.
            if (HttpStatus.SC_OK == (statusCode = response.getStatusLine().getStatusCode())) {
                HttpEntity httpEntity = response.getEntity();
                String result = EntityUtils.toString(httpEntity);
                if (resultFilter == null || resultFilter.accept(result)) {
                    if (callback != null)
                        return callback.doWith(result);
                }
            }

            // an exception is thrown to indicate it failed
            throw new CommandExecutionException("Connect to server specified failed, the status code is: \'" + statusCode + "\'");

        } catch (IOException | InsufficientReqParamException e) {
            throw new CommandExecutionException(e);
        }
    }

    public <T extends Resp> T connect(final ReqParams reqParams, final ResultCallback<T> callback) throws CommandExecutionException {
        return connect(reqParams, callback, null);
    }

    public void setClientCreator(final HttpClientCreator clientCreator) {
        this.clientCreator = clientCreator;
    }

    public void setMethodCreator(final HttpMethodCreator methodCreator) {
        this.methodCreator = methodCreator;
    }
}
