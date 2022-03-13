package com.aks.whiterabbitmt.data.remote;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class AddressDTO {
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

}