package com.example.deltahackathonui;

public class ViewItemModel {

    private String name;
    private int resid;
    private String desc;
    private String genre;
    private String rating;

    public ViewItemModel(String name, int resid, String desc, String genre, String rating) {
        this.name = name;
        this.resid = resid;
        this.desc = desc;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
