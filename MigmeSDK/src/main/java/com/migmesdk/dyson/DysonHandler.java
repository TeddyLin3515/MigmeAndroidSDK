package com.migmesdk.dyson;

import com.migmesdk.dyson.data.DysonParameter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by teddylin on 06/03/2017.
 */
public class DysonHandler {
    protected void sendEvent(Runnable runnable) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.execute(runnable);
    }

    protected void sendPeriodEvent(Runnable runnable) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(runnable, 0, DysonParameter.RUNNABLE.DEFAULT_PERIOD, TimeUnit.MILLISECONDS);
    }
}
