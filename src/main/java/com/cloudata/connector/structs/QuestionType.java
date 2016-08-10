/*
 * File name: QuestionType
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.structs;

import java.util.HashMap;
import java.util.Map;

/**
 * An enum, which enumerates all possible question types.
 * <p>
 * Author: DORSEy
 */
public enum QuestionType {
    // 5 points question.
    FIVE_POINTS("5"),

    // single choice without comment question
    SINGLE_CHOICE("L"),

    // single choice with comment question.
    SINGLE_CHOICE_WITH_COMMENT("O"),

    // multiple choices without comments question.
    MULTIPLE_CHOICES("M"),

    // multiple choices with comments question.
    MULTIPLE_CHOICES_WITH_COMMENT("P"),

    // multiple choices with comments question
    MATRIX_YES_UNCERTAIN_NO("C");

    private static final Map<String, QuestionType> cache = new HashMap<>(QuestionType.values().length);

    static {
        cache.put(QuestionType.FIVE_POINTS.getValue(), QuestionType.FIVE_POINTS);
        cache.put(QuestionType.SINGLE_CHOICE.getValue(), QuestionType.SINGLE_CHOICE);
        cache.put(QuestionType.SINGLE_CHOICE_WITH_COMMENT.getValue(), QuestionType.SINGLE_CHOICE_WITH_COMMENT);
        cache.put(QuestionType.MULTIPLE_CHOICES.getValue(), QuestionType.MULTIPLE_CHOICES);
        cache.put(QuestionType.MULTIPLE_CHOICES_WITH_COMMENT.getValue(), QuestionType.MULTIPLE_CHOICES_WITH_COMMENT);
        cache.put(QuestionType.MATRIX_YES_UNCERTAIN_NO.getValue(), QuestionType.MATRIX_YES_UNCERTAIN_NO);
    }

    private final String value;

    QuestionType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static QuestionType typeOf(final String type) {
        return cache.get(type);
    }
}
