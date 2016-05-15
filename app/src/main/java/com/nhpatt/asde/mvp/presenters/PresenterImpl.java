package com.nhpatt.asde.mvp.presenters;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.nhpatt.asde.mvp.activities.PersistedObject;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.ActivityLifecycleProvider;
import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.FragmentLifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

public class PresenterImpl implements Presenter, ActivityLifecycleProvider, FragmentLifecycleProvider {

    private final BehaviorSubject<ActivityEvent> activityLifecycleEvent = BehaviorSubject.create();
    private final BehaviorSubject<FragmentEvent> fragmentLifecycleEvent = BehaviorSubject.create();
    private PersistedObject persistedObject = new PersistedObject();
    private boolean isFragment;

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
    public final Observable lifecycle() {
        return isFragment ? fragmentLifecycleEvent.asObservable() : activityLifecycleEvent.asObservable();
    }

    @NonNull
    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(@NonNull FragmentEvent event) {
        return RxLifecycle.bindUntilEvent(fragmentLifecycleEvent, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(activityLifecycleEvent, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return isFragment ? RxLifecycle.bindFragment(fragmentLifecycleEvent) : RxLifecycle.bindActivity(activityLifecycleEvent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (isFragment) {
            fragmentLifecycleEvent.onNext(FragmentEvent.CREATE_VIEW);
        } else {
            activityLifecycleEvent.onNext(ActivityEvent.CREATE);
        }
    }

    @Override
    public void onStart() {
        if (isFragment) {
            fragmentLifecycleEvent.onNext(FragmentEvent.START);
        } else {
            activityLifecycleEvent.onNext(ActivityEvent.START);
        }
    }

    @Override
    public void onResume() {
        if (isFragment) {
            fragmentLifecycleEvent.onNext(FragmentEvent.RESUME);
        } else {
            activityLifecycleEvent.onNext(ActivityEvent.RESUME);
        }
    }

    @Override
    public void onPause() {
        if (isFragment) {
            fragmentLifecycleEvent.onNext(FragmentEvent.PAUSE);
        } else {
            activityLifecycleEvent.onNext(ActivityEvent.PAUSE);
        }
    }

    @Override
    public void onStop() {
        if (isFragment) {
            fragmentLifecycleEvent.onNext(FragmentEvent.STOP);
        } else {
            activityLifecycleEvent.onNext(ActivityEvent.STOP);
        }
    }

    @Override
    public void onDestroy() {
        if (isFragment) {
            fragmentLifecycleEvent.onNext(FragmentEvent.DESTROY);
        } else {
            activityLifecycleEvent.onNext(ActivityEvent.DESTROY);
        }
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

    @Override
    public void setFragment(boolean isFragment) {
        this.isFragment = isFragment;
    }


}
