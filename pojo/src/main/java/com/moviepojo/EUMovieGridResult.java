package com.moviepojo;

import java.util.List;

/**
 * Created by hestersmile on 2016/12/22.
 */
public class EUMovieGridResult {

    private long total;
    private List<Movie> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Movie> getRows() {
        return rows;
    }

    public void setRows(List<Movie> rows) {
        this.rows = rows;
    }


}
