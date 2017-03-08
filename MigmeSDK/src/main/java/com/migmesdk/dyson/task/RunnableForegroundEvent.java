package com.migmesdk.dyson.task;

import android.content.Context;

import com.migmesdk.dyson.DysonEventBuilders;
import com.migmesdk.dyson.utility.AppTools;

/**
 * Created by teddylin on 07/03/2017.
 */

public class RunnableForegroundEvent extends RequestTask implements Runnable {

    public RunnableForegroundEvent(Context context, String topic, DysonEventBuilders.ActionEventBuilder builder) {
        super(context, topic, builder.build());
    }

    @Override
    public void run() {
        if (!AppTools.isAppOnForeground(mContext)) {
            send();
        }
    }

    private void send() {
        sendRequest();
    }
}
