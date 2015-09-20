package com.nhpatt.asde.mvp.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;

import com.nhpatt.asde.R;
import com.nhpatt.asde.mvp.presenters.MainPresenter;
import com.nhpatt.asde.mvp.views.MainView;

public class MainActivity extends AbstractActivity<MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPresenter().lookForThings("liferay", "liferay-screens");
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showResponse(String text) {
        Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_SHORT).show();
    }
}
