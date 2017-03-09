package com.migmesdk.dyson.data;

/**
 * Created by teddylin on 06/03/2017.
 */
public class DysonParameter {
    public static class HTTP {
        public static final int CONNECTION_TIMEOUT = 3000;
        public static final int DATA_RETRIEVAL_TIMEOUT = 3000;
        public static final int MAX_PRESENCE_PERIOD = 300000; //5 minutes [unit:millisecond]
        public static final int MIN_PRESENCE_PERIOD = 10000; //10 seconds [unit:millisecond]
        public static final int DEFAULT_PRESENCE_PERIOD = 60000; //one minute [unit:millisecond]
        public static final long SESSION_EXPIRE_TIME = 1800000; //30min[milliseconds]
        public static final String URL = "http://i13n.mig.me/dyson";
        public static final String CONTENT_TYPE = "application/json";
        public static final String METHOD = "POST";
    }
    public static class RUNNABLE {
        public static final int DEFAULT_PERIOD = 1000; //one second [unit:millisecond]
    }

    public static class TOPIC {
        public static final String THIRD_PARTY_GAME = "/3pty_game";
        public static final String USER_INFO = "/cli_user_info";
        public static final String PAGE_VIEW = "/cli_page_view";
        public static final String SEARCH = "/cli_search";
        public static final String SCROLL = "/cli_scroll";
        public static final String CLICK = "/cli_click";
    }

    public static class ACTION {
        public static class TYPE {
            public static final String BILLING = "billing";
            public static final String TOPUP = "topup";
            public static final String SHARE = "share";
            public static final String INVITE = "invite";
            public static final String PRESENCE = "presence";
            public static final String SCORE = "score";
            public static final String ACHIEVEMENT = "achievement";
        }
    }

    public static class APP {
        public static class TYPE {
            public static final String ANDROID = "Android";
        }
    }
}
