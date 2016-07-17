/*
 * File name: SurveyFormat
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.structs;

/**
 * An enumeration of certain survey format.
 *
 * Author: DORSEy
 */
public enum SurveyFormat {
    G_FORMAT("G"),
    A_FORMAT("A"),
    S_FORMAT("S");

    private String value;

    SurveyFormat(final String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
