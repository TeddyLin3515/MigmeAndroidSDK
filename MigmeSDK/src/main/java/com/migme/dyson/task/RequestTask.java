package com.migme.dyson.task;

import android.content.Context;
import android.util.Base64;

import com.migme.BuildConfig;
import com.migme.dyson.Dyson;
import com.migme.dyson.data.DysonParameter;
import com.migme.dyson.utility.DebugLog;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by teddylin on 07/03/2017.
 */

public class RequestTask {
    Context mContext;
    String mTopic;
    String mData;

    public void setData(String data) {
        this.mData = data;
    }

    RequestTask(Context context, String topic, String data) {
        mContext = context;
        mTopic = topic;
        mData = data;
    }

    void sendRequest() {
        HttpURLConnection urlConnection = null;
        try {
            // create connection
            URL urlToRequest = new URL(String.format("%s%s", new String(Base64.decode(BuildConfig.DYSON_PARAM_A, Base64.DEFAULT)), mTopic));
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setConnectTimeout(DysonParameter.HTTP.CONNECTION_TIMEOUT);
            urlConnection.setReadTimeout(DysonParameter.HTTP.DATA_RETRIEVAL_TIMEOUT);
            // handle POST parameters
            if (mData != null) {
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod(DysonParameter.HTTP.METHOD);
                urlConnection.setFixedLengthStreamingMode(mData.getBytes().length);
                urlConnection.setRequestProperty("Content-Type", DysonParameter.HTTP.CONTENT_TYPE);

                //send the POST out
                PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                out.print(mData);
                out.close();
            }

            int statusCode = urlConnection.getResponseCode();
            DebugLog.d(Dyson.TAG, "Dyson event sent >>> statusCode : " + statusCode+"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            DebugLog.d(Dyson.TAG, "Dyson event send fail >>> " + e.getMessage() + "\n");
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            DebugLog.d(Dyson.TAG, "Dyson event send fail >>> " + e.getMessage() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            DebugLog.d(Dyson.TAG, "Dyson event send fail >>> " + e.getMessage() + "\n");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
