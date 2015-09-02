package com.nhpatt.asde.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nhpatt.asde.presenters.Presenter;

public abstract class AbstractActivity<P extends Presenter> extends AppCompatActivity {

    private P presenter;

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.presenter = createPresenter();
        presenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}