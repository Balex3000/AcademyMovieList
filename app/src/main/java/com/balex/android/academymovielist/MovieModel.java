package com.balex.android.academymovielist;

public class MovieModel {
    private String title;
    private int imageResourceId;
    private String desc;

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

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}
