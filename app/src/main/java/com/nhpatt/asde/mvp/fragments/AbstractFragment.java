package com.nhpatt.asde.mvp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nhpatt.asde.mvp.presenters.Presenter;


public abstract class AbstractFragment<P extends Presenter> extends Fragment {

    protected boolean destroyedBySystem;
    private P presenter;
    private RetainedFragment retainFragment;
    private String tag = getClass().getCanonicalName();

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    public void showError(String message) {
        View content = getView().findViewById(android.R.id.content);
        Snackbar.make(content, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = createPresenter();
        presenter.setFragment(true);
        presenter.onCreate(savedInstanceState);

        retainFragment = RetainedFragment.findOrCreate(getFragmentManager(), tag);
        presenter.setPersistedObject(retainFragment.getPersistedObject());
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        destroyedBySystem = false;
        presenter.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        destroyedBySystem = true;
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
        if (destroyedBySystem) {
            retainFragment.setPersistedObject(presenter.getPersistedObject());
        } else {
            retainFragment.remove(getFragmentManager());
            retainFragment.setPersistedObject(null);
            retainFragment = null;
        }
        super.onDestroy();
        presenter.onDestroy();
    }

}