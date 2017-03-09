package com.migmeandroidsdk;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.migmeandroidsdk.databinding.ActivityMainBinding;
import com.migmesdk.dyson.Dyson;
import com.migmesdk.dyson.DysonEventBuilders;
import com.migmesdk.dyson.DysonTracker;
import com.migmesdk.dyson.data.DysonParameter;
import com.migmesdk.dyson.data.DysonSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DysonTracker mTracker;
    ActivityMainBinding binding;
    EditText migmeId;
    String mLog = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((TextView) findViewById(R.id.textView4)).setMovementMethod(new ScrollingMovementMethod());
        migmeId = (EditText) findViewById(R.id.editText);
        mTracker = Dyson.getInstance().newTracker(getApplicationContext(), "migme_test", "554433221100", 10000);
        Dyson.getInstance().setDebugMode(true);
        DysonSession
        buildLogMsg("Initialize done...");
        buildLogMsg("Debug mode >>> "+Dyson.getInstance().DEBUG_MODE);
    }

    public void sendAchievementEvent(View view) {
        ArrayList<String> achievementevent = new ArrayList<String>();
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.ACHIEVEMENT)
                .setActionValue(1234)
                .setActionDescription("description qer")
                .setCustomizedInt(1234134)
                .setCustomizedString("fdasdfadsf")
                .setCustomizedStringarray(achievementevent)
                .setUserId("41234gfsdgdsf"));
        buildLogMsg("sendAchievementEvent");
    }

    public void sendBillingEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.BILLING));
        buildLogMsg("sendBillingEvent");
    }

    public void sendShareEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.SHARE));
        buildLogMsg("sendShareEvent");
    }

    public void sendInviteEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.INVITE));
        buildLogMsg("sendInviteEvent");
    }

    public void sendTopupEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.TOPUP));
        buildLogMsg("sendTopupEvent");
    }

    public void sendScoreEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.SCORE));
        buildLogMsg("sendScoreEvent");
    }

    public void setMigmeId(View view) {
        String id = migmeId.getText().toString();
        binding.setMigmeId(id);
        mTracker.setMigmeId(id);
        buildLogMsg("setMigmeId -> " + id);
    }

    public void sendPresenceEvent(View view) {
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.PRESENCE));
        buildLogMsg("sendPresenceEvent");
    }

    public void buildLogMsg(String log) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date date = new Date();
        mLog = String.format("%s%s: %s%s",mLog ,format.format(date), log, "\n");
        setLog();
    }

    public void setLog() {
        binding.setLog(mLog);
    }
}
