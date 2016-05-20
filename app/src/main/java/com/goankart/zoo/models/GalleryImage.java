package com.goankart.zoo.models;

/**
 * Created by user on 17/11/2015.
 */
public class GalleryImage {

    private String image;
    private String thumbnail;
    private String caption;

    public GalleryImage(){

    }

    public GalleryImage(String thumbnail, String image, String caption){
        this.thumbnail = thumbnail;
        this.image = image;
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
