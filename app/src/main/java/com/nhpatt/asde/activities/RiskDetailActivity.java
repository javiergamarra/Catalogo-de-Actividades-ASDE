package com.nhpatt.asde.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nhpatt.asde.R;
import com.nhpatt.asde.presenters.RiskDetailPresenter;

/**
 * @author Javier Gamarra
 */
public class RiskDetailActivity extends AbstractActivity<RiskDetailPresenter>
        implements RiskDetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.risk_detail);
    }

    @Override
    protected RiskDetailPresenter createPresenter() {
        return new RiskDetailPresenter(this);
    }

    public void search(View view) {
        getPresenter().search();
    }

    @Override
    public void show(String object) {
        ((Button) findViewById(R.id.button)).setText(object);
    }
}
