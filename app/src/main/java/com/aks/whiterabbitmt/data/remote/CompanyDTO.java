package com.aks.whiterabbitmt.data.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class CompanyDTO implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @SerializedName("bs")
    private String bs;

    public static final Creator<CompanyDTO> CREATOR = new Creator<CompanyDTO>() {
        @Override
        public CompanyDTO createFromParcel(Parcel in) {
            return new CompanyDTO(in);
        }

        @Override
        public CompanyDTO[] newArray(int size) {
            return new CompanyDTO[size];
        }
    };

    protected CompanyDTO(Parcel in) {
        name = in.readString();
        catchPhrase = in.readString();
        bs = in.readString();
    }

    public static CompanyDTO objectFromData(String str) {
        return new Gson().fromJson(str, CompanyDTO.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(catchPhrase);
        parcel.writeString(bs);
    }
}
