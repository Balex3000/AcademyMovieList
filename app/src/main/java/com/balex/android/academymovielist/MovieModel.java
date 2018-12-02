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

    void setDesc(String desc) {
        this.desc = desc;
    }

    void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    void setLargeImgResId(int largeImgResId) {
        this.largeImgResId = largeImgResId;
    }

    void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    int getImageResourceId() {
        return imageResourceId;
    }

    String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }

    int getLargeImgResId() {
        return largeImgResId;
    }

    String getReleaseDate() {
        return releaseDate;
    }

    String getTrailerURL() {
        return trailerURL;
    }
}
