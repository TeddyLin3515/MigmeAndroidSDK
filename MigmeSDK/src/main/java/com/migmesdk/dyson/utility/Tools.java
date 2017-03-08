package com.migmesdk.dyson.utility;

import java.util.Random;

/**
 * Created by teddylin on 07/03/2017.
 */

public class Tools {

    public static String generateBase62String() {
        CharSequence BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int BASE_LENGTH = 8;
        Random mRandom = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < BASE_LENGTH; i++) {
            int idx = mRandom.nextInt(BASE.length());
            buffer.append(BASE.charAt(idx));
        }
        return buffer.toString();
    }
}
