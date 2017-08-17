package me.alent.core.po;

import java.util.List;

/**
 * Created by Alent on 2017/7/13.
 */
public class PaginationBean<T> {

    private long total;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
