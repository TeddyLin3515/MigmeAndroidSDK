package com.migmesdk.dyson;

import com.migmesdk.dyson.data.DysonParameter;
import com.migmesdk.dyson.utility.Tools;

/**
 * Created by teddylin on 03/03/2017.
 */
public class DysonSession {
    protected static final String DEFAULT_TOPIC = DysonParameter.TOPIC.THIRD_PARTY_GAME;

    private DysonSession(){}

    private static class SingletonHelper {
        private static final DysonSession INSTANCE = new DysonSession();
    }

    protected static DysonSession getInstance() {
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

    protected String getMigmeId() {
        return migmeId;
    }

    protected void setMigmeId(String migmeId) {
        this.migmeId = migmeId;
    }

    protected String getProjectName() {
        return projectName;
    }

    protected void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    protected String getProjectUID() {
        return projectUID;
    }

    protected void setProjectUID(String projectUID) {
        this.projectUID = projectUID;
    }

    protected String getIpAddress() {
        return ipAddress;
    }

    protected void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    protected String getAppType() {
        return appType;
    }

    protected void setAppType(String appType) {
        this.appType = appType;
    }

    protected String getSdkVersion() {
        return sdkVersion;
    }

    protected void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public long getPresencePeriod() {
        return presencePeriod;
    }

    protected void setPresencePeriod(long presencePeriod) {
        if (presencePeriod < DysonParameter.HTTP.MIN_PRESENCE_PERIOD ||
                presencePeriod > DysonParameter.HTTP.MAX_PRESENCE_PERIOD) {
            presencePeriod = DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD;
        }
        this.presencePeriod = presencePeriod;
    }

    protected String getSessionId() {
        return sessionId;
    }

    private void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    protected String getCookieId() {
        return cookieId;
    }

    protected void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    protected String getTopic() {
        return topic;
    }

    protected void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isSessionExpire(long time) {
        return time >= DysonParameter.HTTP.SESSION_EXPIRE_TIME;
    }

    public void newSessionId() {
        setSessionId(Tools.generateBase62String());
    }

    protected void newCookieId() {
        setCookieId(Tools.generateBase62String());
    }
}
