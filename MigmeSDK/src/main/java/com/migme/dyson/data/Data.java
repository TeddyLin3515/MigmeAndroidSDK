package com.migme.dyson.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by teddylin on 04/03/2017.
 */
public class Data {
    /**
     * appInfo : {"type":"Android","version":"0.0.1"}
     */
    @SerializedName("app_info")
    private AppInfoBean appInfo = new AppInfoBean();

    public AppInfoBean getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfoBean appInfo) {
        this.appInfo = appInfo;
    }

    /**
     * connInfo : {"ipAddress":"192.168.0.1"}
     */
    @SerializedName("conn_info")
    private ConnInfoBean connInfo = new ConnInfoBean();

    public ConnInfoBean getConnInfo() {
        return connInfo;
    }

    public void setConnInfo(ConnInfoBean connInfo) {
        this.connInfo = connInfo;
    }

    /**
     * evenInfo : {"action":{"type":"topup","value":1234,"description":"Topup 1234 MGC","customizedString":"","customizedStringarray":["AA","BB","CC"],"customizedInt":1324}}
     */
    @SerializedName("event_info")
    private EvenInfoBean evenInfo = new EvenInfoBean();

    public EvenInfoBean getEvenInfo() {
        return evenInfo;
    }

    public void setEvenInfo(EvenInfoBean evenInfo) {
        this.evenInfo = evenInfo;
    }

    /**
     * gameInfo : {"id":"1234","server_name":"game name"}
     */
    @SerializedName("game_info")
    private GameInfoBean gameInfo = new GameInfoBean();

    public GameInfoBean getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(GameInfoBean gameInfo) {
        this.gameInfo = gameInfo;
    } /**

     * userinfo : {"id":"1234"}
     */
    @SerializedName("user_info")
    private UserinfoBean userinfo = new UserinfoBean();

    public UserinfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoBean userinfo) {
        this.userinfo = userinfo;
    }

    @SerializedName("cookie_id")
    private String cookieId;

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    @SerializedName("session_id")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
