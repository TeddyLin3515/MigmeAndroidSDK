package com.migmesdk.dyson.task;

import android.content.Context;

import com.migmesdk.dyson.Dyson;
import com.migmesdk.dyson.data.DysonParameter;
import com.migmesdk.dyson.utility.DebugLog;

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
            URL urlToRequest = new URL(String.format("%s%s", DysonParameter.HTTP.URL, mTopic));
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
            DebugLog.d(Dyson.TAG, "Send dyson event >>> \ntopic : " + mTopic + "\nstatusCode : " + statusCode+"\ndata : "+ mData + "\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
