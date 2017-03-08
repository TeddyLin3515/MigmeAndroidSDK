package com.migmesdk.dyson;


import android.content.Context;
import android.text.TextUtils;

import com.migmesdk.BuildConfig;
import com.migmesdk.dyson.data.DysonParameter;
import com.migmesdk.dyson.data.DysonPreference;
import com.migmesdk.dyson.data.DysonSession;
import com.migmesdk.dyson.task.RunnableEvent;
import com.migmesdk.dyson.task.RunnablePresenceEvent;
import com.migmesdk.dyson.utility.DebugLog;

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

    public void setDefaultTopic(String topic) {
        DysonSession.getInstance().setTopic(topic);
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
        mDysonHandler.sendEvent(new RunnableEvent(mContext, builder.topic, builder.build()));
    }

    public void send(String topic, String data) {
        mDysonHandler.sendEvent(new RunnableEvent(mContext, topic, data));
    }

    public void runPresenceEvent() {
        DysonEventBuilders.ActionEventBuilder builder =
                new DysonEventBuilders.ActionEventBuilder()
                        .setActionType(DysonParameter.ACTION.TYPE.PRESENCE);
        mDysonHandler.sendPeriodEvent(new RunnablePresenceEvent(mContext, builder.topic, builder));
    }
}
