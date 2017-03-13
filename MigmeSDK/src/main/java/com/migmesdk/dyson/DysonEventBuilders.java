package com.migmesdk.dyson;

import com.google.gson.Gson;
import com.migmesdk.dyson.data.Event;

import java.util.List;


/**
 * Created by teddylin on 03/03/2017.
 */
public class DysonEventBuilders {

    public static class ActionEventBuilder extends EventBuilder {

        public ActionEventBuilder() {}

        public ActionEventBuilder setActionType(String actionType) {
            event.getData().getEvenInfo().getAction().setType(actionType);
            return this;
        }

        public ActionEventBuilder setActionValue(int value) {
            event.getData().getEvenInfo().getAction().setValue(value);
            return this;
        }

        public ActionEventBuilder setActionDescription(String description) {
            event.getData().getEvenInfo().getAction().setDescription(description);
            return this;
        }

        public ActionEventBuilder setCustomizedString(String customizedString) {
            event.getData().getEvenInfo().getAction().setCustomizedString(customizedString);
            return this;
        }

        public ActionEventBuilder setCustomizedInt(int customizedInt) {
            event.getData().getEvenInfo().getAction().setCustomizedInt(customizedInt);
            return this;
        }

        public ActionEventBuilder setCustomizedStringarray(List<String> customizedStringArray) {
            event.getData().getEvenInfo().getAction().setCustomizedStringarray(customizedStringArray);
            return this;
        }

        public ActionEventBuilder setUserId(String userId) {
            event.getData().getUserinfo().setId(userId);
            return this;
        }
    }

    public static class EventBuilder {
        Event event = new Event();
        String topic;

        public EventBuilder() {
            init();
        }

        public void refresh() {
            init();
        }

        private void init() {
            event.getData().getUserinfo().setId(DysonSession.getInstance().getMigmeId());
            event.getData().getGameInfo().setServerName(DysonSession.getInstance().getProjectName());
            event.getData().getGameInfo().setId(DysonSession.getInstance().getProjectUID());
            event.getData().getAppInfo().setVersion(DysonSession.getInstance().getSdkVersion());
            event.getData().getAppInfo().setType(DysonSession.getInstance().getAppType());
            event.getData().getConnInfo().setIpAddress(DysonSession.getInstance().getIpAddress());
            event.getData().setSessionId(DysonSession.getInstance().getSessionId());
            event.getData().setCookieId(DysonSession.getInstance().getCookieId());
            topic = DysonSession.getInstance().getTopic();
        }

        public String build() {
            return new Gson().toJson(event.getData());
        }
    }
}
