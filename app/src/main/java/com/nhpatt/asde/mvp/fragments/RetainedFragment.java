package com.nhpatt.asde.mvp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.nhpatt.asde.mvp.activities.PersistedObject;

/**
 * @author Javier Gamarra
 */
public class RetainedFragment extends Fragment {

    private PersistedObject persistedObject;

    public static RetainedFragment findOrCreate(FragmentManager fragmentManager, String tag) {
        RetainedFragment retainFragment = (RetainedFragment) fragmentManager.findFragmentByTag(tag);

        if (retainFragment == null) {
            retainFragment = new RetainedFragment();
            fragmentManager.beginTransaction().add(retainFragment, tag).commitAllowingStateLoss();
        }

        return retainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    public void remove(FragmentManager fragmentManager) {
        if (!fragmentManager.isDestroyed()) {
            fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
            persistedObject = null;
        }
    }

    public PersistedObject getPersistedObject() {
        return persistedObject;
    }

    public void setPersistedObject(PersistedObject persistedObject) {
        this.persistedObject = persistedObject;
    }

}
