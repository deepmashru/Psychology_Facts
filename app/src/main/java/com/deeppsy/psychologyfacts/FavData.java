package com.deeppsy.psychologyfacts;

public class FavData {
    String factTitle;

    String id;

    String title;

    public FavData(String String1, String String2, String String3) {
        this.title = String2;
        this.id = String1;
        this.factTitle = String3;
    }

    public String getFactTitle() { return this.factTitle; }

    public String getId() { return this.id; }

    public String getTitle() { return this.title; }

    public void setFactTitle(String paramString) { this.factTitle = paramString; }

    public void setId(String paramString) { this.id = paramString; }

    public void setTitle(String paramString) { this.title = paramString; }
}
