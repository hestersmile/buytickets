package com.moviepojo;

/**
 * Created by hestersmile on 2016/12/30.
 */
public class OrderAllInfo extends Moviedetail{
    private Moviedetail moviedetail;
    private Movie movie;
    private Movieuser movieuser;

    public Moviedetail getMoviedetail() {
        return moviedetail;
    }

    public void setMoviedetail(Moviedetail moviedetail) {
        this.moviedetail = moviedetail;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movieuser getMovieuser() {
        return movieuser;
    }

    public void setMovieuser(Movieuser movieuser) {
        this.movieuser = movieuser;
    }

    @Override
    public String toString() {
        return "OrderAllInfo{" +
                "moviedetail=" + moviedetail +
                ", movie=" + movie +
                ", movieuser=" + movieuser +
                '}';
    }
}
