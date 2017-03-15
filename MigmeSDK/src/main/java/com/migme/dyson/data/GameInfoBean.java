package com.migme.dyson.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by teddylin on 03/03/2017.
 */
public class GameInfoBean {
    /**
     * id : 1234
     * serverName : game name
     */
    @SerializedName("id")
    private String id;

    @SerializedName("server_name")
    private String serverName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
