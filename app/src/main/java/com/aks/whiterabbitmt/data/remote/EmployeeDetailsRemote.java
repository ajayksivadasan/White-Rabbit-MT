package com.aks.whiterabbitmt.data.remote;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class EmployeeDetailsRemote implements Serializable {

    /**
     * id : 1
     * name : Leanne Graham
     * username : Bret
     * email : Sincere@april.biz
     * profile_image : https://randomuser.me/api/portraits/men/1.jpg
     * address : {"street":"Kulas Light","suite":"Apt. 556","city":"Gwenborough","zipcode":"92998-3874","geo":{"lat":"-37.3159","lng":"81.1496"}}
     * phone : null
     * website : hildegard.org
     * company : {"name":"Romaguera-Crona","catchPhrase":"Multi-layered client-server neural-net","bs":"harness real-time e-markets"}
     */

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("profile_image")
    private String profileImage;
    /**
     * street : Kulas Light
     * suite : Apt. 556
     * city : Gwenborough
     * zipcode : 92998-3874
     * geo : {"lat":"-37.3159","lng":"81.1496"}
     */

    @SerializedName("address")
    private AddressDTO address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("website")
    private String website;
    /**
     * name : Romaguera-Crona
     * catchPhrase : Multi-layered client-server neural-net
     * bs : harness real-time e-markets
     */

    @SerializedName("company")
    private CompanyDTO company;

    public static String getStringFromList(List<EmployeeDetailsRemote> remoteList) {
        return new Gson().toJson(remoteList);
    }

    public static EmployeeDetailsRemote objectFromData(String str) {
        return new Gson().fromJson(str, EmployeeDetailsRemote.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
