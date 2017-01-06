package com.moviepojo;

import java.util.List;

/**
 * Created by hestersmile on 2016/12/22.
 */
public class EUUserGridResult {

    private long total;
    private List<Movieuser> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Movieuser> getRows() {
        return rows;
    }

    public void setRows(List<Movieuser> rows) {
        this.rows = rows;
    }


}
