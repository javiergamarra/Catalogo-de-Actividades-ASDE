package com.nhpatt.asde.mvp.presenters;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class FragmentPresenterImpl extends PresenterImpl implements Presenter, LifecycleProvider<FragmentEvent> {

    private final BehaviorSubject<FragmentEvent> fragmentLifecycleEvent = BehaviorSubject.create();

    @Override
    @NonNull
    @CheckResult
    public final Observable lifecycle() {
        return fragmentLifecycleEvent.asObservable();
    }

    @NonNull
    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(@NonNull FragmentEvent event) {
        return RxLifecycle.bindUntilEvent(fragmentLifecycleEvent, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindFragment(fragmentLifecycleEvent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        fragmentLifecycleEvent.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override
    public void onStart() {
        fragmentLifecycleEvent.onNext(FragmentEvent.START);
    }

    @Override
    public void onResume() {
        fragmentLifecycleEvent.onNext(FragmentEvent.RESUME);
    }

    @Override
    public void onPause() {
        fragmentLifecycleEvent.onNext(FragmentEvent.PAUSE);
    }

    @Override
    public void onStop() {
        fragmentLifecycleEvent.onNext(FragmentEvent.STOP);
    }

    @Override
    public void onDestroy() {
        fragmentLifecycleEvent.onNext(FragmentEvent.DESTROY);
    }


}
