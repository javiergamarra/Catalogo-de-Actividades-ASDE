package com.nhpatt.asde.mvp.presenters;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.nhpatt.asde.mvp.activities.PersistedObject;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.ActivityLifecycleProvider;
import com.trello.rxlifecycle.RxLifecycle;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

public class PresenterImpl implements Presenter, ActivityLifecycleProvider {

    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();
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

    @Override
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.asObservable();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> Observable.Transformer<T, T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> Observable.Transformer<T, T> bindToLifecycle() {
        return RxLifecycle.bindActivity(lifecycleSubject);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        lifecycleSubject.onNext(ActivityEvent.CREATE);
    }

    @Override
    public void onStart() {
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override
    public void onResume() {
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    public void onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
    }

    @Override
    public void onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);
    }

    @Override
    public void onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
    }

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
