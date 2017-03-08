package com.migmesdk.dyson.data;

import com.migmesdk.dyson.utility.Tools;

/**
 * Created by teddylin on 03/03/2017.
 */
public class DysonSession {
    public static final String DEFAULT_TOPIC = DysonParameter.TOPIC.THIRD_PARTY_GAME;

    private DysonSession(){}

    private static class SingletonHelper {
        private static final DysonSession INSTANCE = new DysonSession();
    }

    public static DysonSession getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private String migmeId;
    private String projectName;
    private String projectUID;
    private String ipAddress;
    private String appType;
    private String sdkVersion;
    private String sessionId;
    private String cookieId;
    private String topic;
    private long presencePeriod;

    public String getMigmeId() {
        return migmeId;
    }

    public void setMigmeId(String migmeId) {
        this.migmeId = migmeId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectUID() {
        return projectUID;
    }

    public void setProjectUID(String projectUID) {
        this.projectUID = projectUID;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public long getPresencePeriod() {
        return presencePeriod;
    }

    public void setPresencePeriod(long presencePeriod) {
        this.presencePeriod = presencePeriod;
    }

    public String getSessionId() {
        return sessionId;
    }

    private void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isSessionExpire(long time) {
        return time >= DysonParameter.HTTP.SESSION_EXPIRE_TIME;
    }

    public void newSessionId() {
        setSessionId(Tools.generateBase62String());
    }

    public void newCookieId() {
        setCookieId(Tools.generateBase62String());
    }
}
