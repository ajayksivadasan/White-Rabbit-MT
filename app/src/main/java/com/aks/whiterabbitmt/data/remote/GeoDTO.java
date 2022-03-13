package com.aks.whiterabbitmt.data.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class GeoDTO implements Parcelable {
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;

    public static final Creator<GeoDTO> CREATOR = new Creator<GeoDTO>() {
        @Override
        public GeoDTO createFromParcel(Parcel in) {
            return new GeoDTO(in);
        }

        @Override
        public GeoDTO[] newArray(int size) {
            return new GeoDTO[size];
        }
    };

    protected GeoDTO(Parcel in) {
        lat = in.readString();
        lng = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(lat);
        parcel.writeString(lng);
    }
}