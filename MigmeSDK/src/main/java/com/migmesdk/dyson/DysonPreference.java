package com.migmesdk.dyson;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by teddylin on 08/03/2017.
 */

public class DysonPreference {
    public static final String DYSON_PREFERENCES = "DysonPreference" ;
    public static final String DYSON_COOKIE_ID = "dyson_cookie_id" ;
    SharedPreferences mPreferences;

    private static class DysonPreferenceHolder {
        static final DysonPreference sINSTANCE = new DysonPreference();
    }

    protected static DysonPreference getInstance() {
        return DysonPreferenceHolder.sINSTANCE;
    }

    public void init(Context context) {
        mPreferences = context.getSharedPreferences(DYSON_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setCookieId(String cookieId) {
        if (mPreferences != null) {
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putString(DYSON_COOKIE_ID, cookieId);
            editor.commit();
        }
    }

    public String getCookieId() {
        if (mPreferences != null) {
            return mPreferences.getString(DYSON_COOKIE_ID, null);
        }
        return null;
    }
}
