/*
 * File name: Pagination
 * Author: Dorsey Q F TANG
 * Date: 8/6/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.structs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: DORSEy
 */
public class Pagination<T extends Serializable> {
    private int currentPage = 1;

    private int totalCount;

    private List<T> records;

    /**
     * Empty constructor of {@link Pagination}.
     */
    public Pagination() {
        this(1, 0);
    }

    /**
     * Constructor of {@link Pagination}, with current page and total count specified.
     *
     * @param currentPage the current page.
     * @param totalCount  the total count.
     */
    public Pagination(final int currentPage, final int totalCount) {
        this(currentPage, totalCount, new ArrayList<T>(0));
    }

    /**
     * Constructor of {@link Pagination}, with current page, total count and records specified.
     *
     * @param currentPage the current page.
     * @param totalCount  the total count.
     * @param records     the records.
     */
    public Pagination(final int currentPage, final int totalCount, final List<T> records) {
        setCurrentPage(currentPage);
        setTotalCount(totalCount);
        setRecords(records);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(final int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(final List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "currentPage: " + getCurrentPage() + ", totalCount: " + getTotalCount() + ", records: " + getRecords();
    }
}
