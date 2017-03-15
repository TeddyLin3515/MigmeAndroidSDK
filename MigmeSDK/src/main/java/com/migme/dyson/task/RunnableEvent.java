package com.migme.dyson.task;

import android.content.Context;

/**
 * Created by teddylin on 06/03/2017.
 */
public class RunnableEvent extends RequestTask implements Runnable {
    public RunnableEvent(Context context, String topic, String data) {
        super(context, topic, data);
    }

    @Override
    public void run() {
        sendRequest();
    }
}
