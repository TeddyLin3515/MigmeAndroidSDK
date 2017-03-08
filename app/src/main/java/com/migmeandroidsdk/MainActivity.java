package com.migmeandroidsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.migmesdk.dyson.Dyson;
import com.migmesdk.dyson.DysonEventBuilders;
import com.migmesdk.dyson.DysonTracker;
import com.migmesdk.dyson.data.DysonParameter;
import com.migmesdk.dyson.data.DysonSession;

public class MainActivity extends AppCompatActivity {
    DysonTracker mTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTracker = Dyson.getInstance().newTracker(getApplicationContext(), "migme_test", "554433221100");
        Dyson.getInstance().setDebugMode(true);
    }

    public void sendAchievementEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.ACHIEVEMENT));
    }

    public void sendBillingEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.BILLING));
    }

    public void sendShareEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.SHARE));
    }

    public void sendInviteEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.INVITE));
    }

    public void sendTopupEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.TOPUP));
    }

    public void sendScoreEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.SCORE));
    }

    public void resetMigmeId(View view) {
        if (DysonSession.getInstance().getMigmeId() == null || DysonSession.getInstance().getMigmeId().equalsIgnoreCase("999999999")) {
            mTracker.setMigmeId("111111111");
        } else {
            mTracker.setMigmeId("999999999");
        }
    }

    public void sendPresenceEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.PRESENCE));
    }
}
