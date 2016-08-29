package com.nhpatt.asde.mvp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nhpatt.asde.mvp.presenters.BaseView;
import com.nhpatt.asde.mvp.presenters.FragmentPresenterImpl;


public abstract class AbstractFragment<P extends FragmentPresenterImpl> extends Fragment implements IdlingResource, BaseView {

    protected boolean destroyedBySystem;
    private P presenter;
    private RetainedFragment retainFragment;
    private String tag = getClass().getCanonicalName();

    private IdlingResource.ResourceCallback callback;
    private boolean idle = false;

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    @Override
    public void onSuccess() {
        idle = true;
    }

    @Override
    public void onError(String error) {
        View content = getView().findViewById(android.R.id.content);
        Snackbar.make(content, error, Snackbar.LENGTH_LONG).show();
        idle = true;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = createPresenter();
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

    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        if (idle && callback != null) {
            callback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.callback = callback;
    }

}