package com.nhpatt.asde.mvp.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nhpatt.asde.mvp.activities.PersistedObject;
import com.nhpatt.asde.mvp.presenters.Presenter;


public abstract class AbstractFragment<P extends Presenter> extends Fragment {

    private P presenter;

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    public void showError(String message) {
        View content = getView().findViewById(android.R.id.content);
        Snackbar.make(content, message, Snackbar.LENGTH_LONG).show();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.presenter = createPresenter();
        presenter.onCreate(savedInstanceState);

        presenter.setPersistedObject((PersistedObject) getActivity().getLastCustomNonConfigurationInstance());
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }


}
