package com.aks.whiterabbitmt.data.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class AddressDTO implements Parcelable {
    @SerializedName("street")
    private String street;
    @SerializedName("suite")
    private String suite;
    @SerializedName("city")
    private String city;
    @SerializedName("zipcode")
    private String zipcode;
    /**
     * lat : -37.3159
     * lng : 81.1496
     */

    @SerializedName("geo")
    private GeoDTO geo;

    public static final Creator<AddressDTO> CREATOR = new Creator<AddressDTO>() {
        @Override
        public AddressDTO createFromParcel(Parcel in) {
            return new AddressDTO(in);
        }

        @Override
        public AddressDTO[] newArray(int size) {
            return new AddressDTO[size];
        }
    };

    protected AddressDTO(Parcel in) {
        street = in.readString();
        suite = in.readString();
        city = in.readString();
        zipcode = in.readString();
    }

    public static AddressDTO objectFromData(String str) {

        return new Gson().fromJson(str, AddressDTO.class);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public GeoDTO getGeo() {
        return geo;
    }

    public void setGeo(GeoDTO geo) {
        this.geo = geo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(street);
        parcel.writeString(suite);
        parcel.writeString(city);
        parcel.writeString(zipcode);
    }
}