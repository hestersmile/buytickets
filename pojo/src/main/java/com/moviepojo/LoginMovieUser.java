package com.moviepojo;

public class LoginMovieUser {
    private String musername;

    private String muserpassword;


    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public String getMuserpassword() {
        return muserpassword;
    }

    public void setMuserpassword(String muserpassword) {
        this.muserpassword = muserpassword;
    }

    @Override
    public String toString() {
        return "LoginMovieUser{" +
                "musername='" + musername + '\'' +
                ", muserpassword='" + muserpassword + '\'' +
                '}';
    }
}