/*
 * File name: QuestionType
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.structs;

/**
 * An enum, which enumerates all possible question types.
 * <p>
 * Author: DORSEy
 */
public enum QuestionType {
    SINGLE_CHOICE("L"),
    SINGLE_CHOICE_WITH_COMMENT("0"),
    MULTIPLE_CHOICES("M");

    private final String value;

    QuestionType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
