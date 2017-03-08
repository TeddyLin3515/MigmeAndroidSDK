package com.migmesdk.dyson.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by teddylin on 03/03/2017.
 */
public class ConnInfoBean {
    /**
     * ipAddress : 192.168.0.1
     * country : TW
     * city : Taipei
     * lat :
     * lng :
     */
    @SerializedName("ip_address")
    private String ipAddress;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
