package com.deeppsy.psychologyfacts;

public class FactData {
    private String id;

    private int imageRef;

    private boolean state = false;

    private String title;

    public FactData(String title, int imageRef) {
        this.title = title;
        this.imageRef = imageRef;
    }

    public FactData(String title) {
        this.title = title;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public int getImageRef() {
        return this.imageRef;
    }

    public void setImageRef(int paramInt) {
        this.imageRef = paramInt;
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean paramBoolean) {
        this.state = paramBoolean;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

