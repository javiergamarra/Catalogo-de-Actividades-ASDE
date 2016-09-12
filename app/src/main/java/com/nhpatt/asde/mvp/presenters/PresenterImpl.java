package com.nhpatt.asde.mvp.presenters;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.nhpatt.asde.mvp.activities.PersistedObject;
import com.trello.rxlifecycle.LifecycleTransformer;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class PresenterImpl implements Presenter {

    private PersistedObject persistedObject = new PersistedObject();

    protected Observable getCachedObservable(String key, Observable observable) {
        if (getPersistedObject().getInteractors().containsKey(key)) {
            return getPersistedObject().getInteractors().get(key);
        } else {
            Observable obs = observable.compose(background());
            getPersistedObject().getInteractors().put(key, obs);
            return obs;
        }
    }

    protected void invalidateObservable(String key) {
        getPersistedObject().getInteractors().remove(key);
    }

    @NonNull
    @CheckResult
    protected <T> Observable.Transformer<T, T> background() {
        return obs -> obs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .replay()
                .autoConnect();
    }

    abstract <T> LifecycleTransformer<T> bindToLifecycle();

    @Override
    public PersistedObject getPersistedObject() {
        if (persistedObject == null) {
            persistedObject = new PersistedObject();
        }
        return persistedObject;
    }

    @Override
    public void setPersistedObject(PersistedObject persistedObject) {
        this.persistedObject = persistedObject;
    }

}
