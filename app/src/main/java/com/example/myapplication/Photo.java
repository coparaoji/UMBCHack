package com.example.myapplication;

import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.media.Image;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Photo {
    private String url;
    private User owner;
    private Event event;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Photo(String url, User owner, Event event) {
        this.url = url;
        this.owner = owner;
        this.event = event;
    }


}
