package com.aks.whiterabbitmt.data.local;


import com.google.gson.annotations.SerializedName;

public class EmployeeAddress {
    int id;
    @SerializedName("street")
    private String street;
    @SerializedName("suite")
    private String suite;
    @SerializedName("city")
    private String city;
    @SerializedName("zipcode")
    private String zipcode;
}
