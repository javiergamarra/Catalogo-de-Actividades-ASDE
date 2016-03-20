package com.nhpatt.asde.mvp.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nhpatt.asde.mvp.presenters.Presenter;

public abstract class AbstractActivity<P extends Presenter> extends AppCompatActivity {

    private P presenter;

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    public void showError(String message) {
        View content = findViewById(android.R.id.content);
        Snackbar.make(content, message, Snackbar.LENGTH_LONG).show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.presenter = createPresenter();
        presenter.onCreate(savedInstanceState);

        presenter.setPersistedObject((PersistedObject) getLastCustomNonConfigurationInstance());
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

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter.getPersistedObject();
    }
}
