package com.nhpatt.asde.presenters;

import android.os.Bundle;

public interface Presenter {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}