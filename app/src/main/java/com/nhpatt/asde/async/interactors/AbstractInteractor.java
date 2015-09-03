package com.nhpatt.asde.async.interactors;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.async.Executor;

import java.io.IOException;

public abstract class AbstractInteractor implements Runnable {

    public abstract void runOnBackground() throws IOException;

    public void execute() {
        Executor.execute(this);
    }

    public void run() {
        try {
            runOnBackground();
        } catch (Exception ex) {
            //TODO send sth meaningful
            EventBusUtil.post(new Exception());
        }
    }

    public boolean checkConnection(Context context) {
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }
}
