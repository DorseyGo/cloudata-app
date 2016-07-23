/*
 * File name: GetSessionKeyReqParamsTest
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.exception.InsufficientReqParamException;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * A test for {@link GetSessionKeyReqParams}.
 *
 * Author: DORSEy
 */
public class GetSessionKeyReqParamsTest {
    @Test
    public void testToStringEntity() throws UnsupportedEncodingException, InsufficientReqParamException {
        GetSessionKeyReqParams getSessionKeyReqParams = new GetSessionKeyReqParams("Dorsey", "tong");
        StringEntity entity = getSessionKeyReqParams.toStringEntity();

        Assert.assertNotNull(entity);
    }
}
