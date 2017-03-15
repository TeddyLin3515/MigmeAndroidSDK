package com.migme.dyson.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by teddylin on 03/03/2017.
 */
public class AppInfoBean {
    /**
     * type : Android
     * version : 0.0.1
     */

    @SerializedName("type")
    private String type;
    @SerializedName("version")
    private String version;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
