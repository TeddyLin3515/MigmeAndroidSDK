package com.migmeandroidsdk;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.migme.dyson.Dyson;
import com.migme.dyson.DysonEventBuilders;
import com.migme.dyson.DysonTracker;
import com.migme.dyson.data.DysonParameter;
import com.migmeandroidsdk.databinding.ActivityMainBinding;

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
        mTracker = Dyson.getInstance().newTracker(getApplicationContext(), "Migme game");
        mTracker.setProjectUserId("Migme game user id");
        Dyson.getInstance().setDebugMode(true);
        buildLogMsg("Initialize done...");
        buildLogMsg("Debug mode >>> "+Dyson.getInstance().isDebugMode());
    }

    public void sendAchievementEvent(View view) {
        ArrayList<String> achievementevent = new ArrayList<>();
        mTracker.send(new DysonEventBuilders.ActionEventBuilder()
                .setActionType(DysonParameter.ACTION.TYPE.ACHIEVEMENT)
                .setActionValue(4893311)
                .setActionDescription("description qer")
                .setCustomizedInt(239853)
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
        buildLogMsg("disable sendScoreEvent");
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

    public void cleanMigmeId(View view) {
        mTracker.clearMigmeId();
        binding.setMigmeId("");
        migmeId.setText("");
        buildLogMsg("clearMigmeId");
    }

    public void changeMode(View view) {
        CheckBox checkBox = (CheckBox) view;
        buildLogMsg((checkBox.isChecked() ? "Enable" : "Disable") + " debug mode.");
        Dyson.getInstance().setDebugMode(checkBox.isChecked());
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
