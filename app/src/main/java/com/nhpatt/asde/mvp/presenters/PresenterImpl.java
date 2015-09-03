package com.nhpatt.asde.mvp.presenters;

import android.os.Bundle;

import com.nhpatt.asde.async.EventBusUtil;

public class PresenterImpl implements Presenter {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onResume() {
        EventBusUtil.register(this);
    }

    @Override
    public void onPause() {
        EventBusUtil.unregister(this);
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }
}
