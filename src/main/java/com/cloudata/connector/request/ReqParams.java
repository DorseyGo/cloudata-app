/*
 * File name: ReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/14/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.exception.InsufficientReqParamException;
import org.apache.http.entity.StringEntity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * An interface, declares all its subclasses are request parameters being sent to make API call on the targeted HTTP
 * server.
 * <p>
 *
 * Author: DORSEy
 */
public interface ReqParams extends Serializable {

    /**
     * Returns a {@link StringEntity} representation of current object.
     *
     * @return a string entity representation.
     */
    StringEntity toStringEntity() throws UnsupportedEncodingException, InsufficientReqParamException;
}
