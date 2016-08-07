/*
 * File name: Pagination
 * Author: Dorsey Q F TANG
 * Date: 8/7/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.structs;

import com.cloudata.CloudataConstants;
import com.cloudata.connector.annotations.Serialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: DORSEy
 */
public class Pagination<T extends Serializable> implements Serializable {
    /**
     * The current page.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_CURRENT_PAGE)
    private int curPage;

    /**
     * The total number of records.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VEW_NUM_RECORDS)
    private int numRecords;

    /**
     * the records.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_RECORDS)
    private List<T> records;

    /**
     * Empty constructor of {@link Pagination}.
     */
    public Pagination() {
        // empty constructor
        this(1, 0, null);
    }

    /**
     * Constructor of {@link Pagination}, with current page, number of records and records specified.
     *
     * @param curPage    the current page.
     * @param numRecords number of records.
     * @param records    the records.
     */
    public Pagination(final int curPage, final int numRecords, final List<T> records) {
        setCurPage(curPage);
        setNumRecords(numRecords);
        setRecords(records);
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(final int curPage) {
        this.curPage = curPage;
    }

    public int getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(final int numRecords) {
        this.numRecords = numRecords;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(final List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "currentPage: " + getCurPage() + ", numRecords: " + getNumRecords() + ", records: " + getRecords();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof Pagination))
            return false;

        Pagination that = (Pagination) obj;
        boolean isEqualed = (curPage == that.curPage);
        isEqualed = isEqualed && (numRecords == that.numRecords);
        isEqualed = isEqualed && (records == null ? that.records == null : records.equals(that.records));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (curPage);
        hashcode += PRIME + (numRecords);
        hashcode += PRIME + (records == null || records.isEmpty() ? 0 : records.hashCode());

        return hashcode;
    }
}
