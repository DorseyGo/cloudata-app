/*
 * File name: SessionKeyGenerator
 * Author: Dorsey Q F TANG
 * Date: 8/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback;

import com.cloudata.http.view.RespView;

/**
 * Author: DORSEy
 */
public interface SessionCallback<T extends RespView> {

    T doInSession(final String sessionKey);
}
