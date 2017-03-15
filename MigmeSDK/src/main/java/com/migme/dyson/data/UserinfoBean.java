package com.migme.dyson.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by teddylin on 03/03/2017.
 */
public class UserinfoBean {
    /**
     * id : 1234
     */
    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
