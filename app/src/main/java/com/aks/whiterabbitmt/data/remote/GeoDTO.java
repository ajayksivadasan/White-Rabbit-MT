package com.aks.whiterabbitmt.data.remote;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class GeoDTO {
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;

    public static GeoDTO objectFromData(String str) {

        return new Gson().fromJson(str, GeoDTO.class);
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}