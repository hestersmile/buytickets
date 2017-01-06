package com.moviepojo;

import java.util.List;

/**
 * Created by hestersmile on 2016/12/22.
 */
public class EUOrderGridResult {

    private long total;
    private List<OrderList> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<OrderList> getRows() {
        return rows;
    }

    public void setRows(List<OrderList> rows) {
        this.rows = rows;
    }


}
