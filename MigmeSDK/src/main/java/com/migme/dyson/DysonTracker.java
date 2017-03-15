package com.migme.dyson;


import android.content.Context;
import android.text.TextUtils;

import com.migme.BuildConfig;
import com.migme.dyson.data.DysonParameter;
import com.migme.dyson.task.RunnableEvent;
import com.migme.dyson.task.RunnablePresenceEvent;
import com.migme.dyson.utility.DebugLog;

/**
 * Created by teddylin on 04/03/2017.
 */
public class DysonTracker {
    private DysonHandler mDysonHandler;
    private Context mContext;

    protected DysonTracker() {
        mDysonHandler = new DysonHandler();
    }

    protected void initialize(Context context, String projectName, String projectUID, String topic, long presencePeriod) {
        mContext = context;
        DysonPreference.getInstance().init(context);
        DysonSession.getInstance().setProjectName(projectName);
        DysonSession.getInstance().setProjectUID(projectUID);
        DysonSession.getInstance().setTopic(topic);
        DysonSession.getInstance().setAppType(DysonParameter.APP.TYPE.ANDROID);
        DysonSession.getInstance().setSdkVersion(BuildConfig.VERSION_NAME);
        DysonSession.getInstance().setPresencePeriod(presencePeriod);
        DysonSession.getInstance().newSessionId();
        initCookieId();
        runPresenceEvent();
    }

    private void initCookieId() {
        String cookieId = DysonPreference.getInstance().getCookieId();
        DebugLog.d(Dyson.TAG, "Cookie Id : "+cookieId);
        if (TextUtils.isEmpty(cookieId)) {
            DysonSession.getInstance().newCookieId();
            DysonPreference.getInstance().setCookieId(DysonSession.getInstance().getCookieId());
        } else {
            DysonSession.getInstance().setCookieId(cookieId);
        }
    }

    private void setDefaultTopic(String topic) {
        DysonSession.getInstance().setTopic(topic);
    }

    public void setProjectUserId(String uid) {
        DysonSession.getInstance().setProjectUID(uid);
    }

    public void clearProjectUserId() {
        DysonSession.getInstance().setProjectUID(null);
    }

    public void setMigmeId(String migmeId) {
        DysonSession.getInstance().setMigmeId(migmeId);
    }

    public void setIpAddress(String ipAddress) {
        DysonSession.getInstance().setIpAddress(ipAddress);
    }

    public void clearMigmeId() {
        DysonSession.getInstance().setMigmeId(null);
    }

    public void send(DysonEventBuilders.ActionEventBuilder builder) {
        DebugLog.d(Dyson.TAG, "Send dyson event >>> " + builder.getEvent().getData().getEvenInfo().getAction().getType() + "\n");
        mDysonHandler.sendEvent(new RunnableEvent(mContext, builder.topic, builder.build()));
    }

    public void runPresenceEvent() {
        DysonEventBuilders.ActionEventBuilder builder =
                new DysonEventBuilders.ActionEventBuilder()
                        .setActionType(DysonParameter.ACTION.TYPE.PRESENCE);
        mDysonHandler.sendPeriodEvent(new RunnablePresenceEvent(mContext, builder.topic, builder, DysonSession.getInstance()));
    }
}
