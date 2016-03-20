package com.nhpatt.asde.mvp.presenters;

import android.os.Bundle;

import com.nhpatt.asde.mvp.activities.PersistedObject;

public interface Presenter {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    PersistedObject getPersistedObject();

    void setPersistedObject(PersistedObject lastCustomNonConfigurationInstance);
}
