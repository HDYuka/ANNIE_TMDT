package com.dhyuka.tmdt.models;

import android.support.v7.widget.CardView;
import android.widget.ImageView;

/**
 * Created by DH Yuka on 6/3/2016.
 */
public class CatalogModel {

    String Title;
    int Image;
    String Link;

    public CatalogModel(String Title, String Link, int Image) {
        this.Title = Title;
        this.Image = Image;
        this.Link = Link;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }


    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
