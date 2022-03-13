package com.aks.whiterabbitmt.data.local;

import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

public class EmployeeAddress {
    @PrimaryKey(autoGenerate = true)
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
