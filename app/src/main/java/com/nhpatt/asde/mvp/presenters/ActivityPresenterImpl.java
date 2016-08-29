package com.nhpatt.asde.mvp.presenters;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ActivityPresenterImpl extends PresenterImpl implements LifecycleProvider<ActivityEvent> {

    private final BehaviorSubject<ActivityEvent> activityLifecycleEvent = BehaviorSubject.create();

    @Override
    @NonNull
    @CheckResult
    public final Observable lifecycle() {
        return activityLifecycleEvent.asObservable();
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
        return RxLifecycleAndroid.bindActivity(activityLifecycleEvent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        activityLifecycleEvent.onNext(ActivityEvent.CREATE);
    }

    @Override
    public void onStart() {
        activityLifecycleEvent.onNext(ActivityEvent.START);
    }

    @Override
    public void onResume() {
        activityLifecycleEvent.onNext(ActivityEvent.RESUME);
    }

    @Override
    public void onPause() {
        activityLifecycleEvent.onNext(ActivityEvent.PAUSE);
    }

    @Override
    public void onStop() {
        activityLifecycleEvent.onNext(ActivityEvent.STOP);
    }

    @Override
    public void onDestroy() {
        activityLifecycleEvent.onNext(ActivityEvent.DESTROY);
    }

}
