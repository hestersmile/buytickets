package com.moviepojo;

public class Movieuser {
    private Integer id;

    private String memail;

    private String muserpassword;

    private String musername;

    private Integer loginType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail == null ? null : memail.trim();
    }

    public String getMuserpassword() {
        return muserpassword;
    }

    public void setMuserpassword(String muserpassword) {
        this.muserpassword = muserpassword == null ? null : muserpassword.trim();
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername == null ? null : musername.trim();
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "Movieuser{" +
                "id=" + id +
                ", memail='" + memail + '\'' +
                ", muserpassword='" + muserpassword + '\'' +
                ", musername='" + musername + '\'' +
                ", loginType=" + loginType +
                '}';
    }
}