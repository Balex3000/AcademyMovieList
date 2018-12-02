package com.balex.android.academymovielist;

import java.io.Serializable;

public class MovieModel implements Serializable {
    private String title;
    private int imageResourceId;
    private int largeImgResId;
    private String desc;
    private String releaseDate;
    private String trailerURL;

    // Constructor
//    public MovieModel (String pTitle, String pDesc, int pImageResourceId) {
//        title = pTitle;
//        desc = pDesc;
//        imageResourceId = pImageResourceId;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setLargeImgResId(int largeImgResId) {
        this.largeImgResId = largeImgResId;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }

    public int getLargeImgResId() {
        return largeImgResId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTrailerURL() {
        return trailerURL;
    }
}
