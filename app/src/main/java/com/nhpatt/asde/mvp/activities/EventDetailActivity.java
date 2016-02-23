package com.nhpatt.asde.mvp.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Commit;
import com.nhpatt.asde.mvp.presenters.EventDetailPresenter;
import com.nhpatt.asde.mvp.views.RiskDetailView;

/**
 * @author Javier Gamarra
 */
public class EventDetailActivity extends AbstractActivity<EventDetailPresenter>
        implements RiskDetailView {

    private TextView activityNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.risk_detail);

        bindViews();

        if (null != getIntent()) {
            Commit commit = (Commit) getIntent().getExtras().get("commit");
            assert commit != null;
            activityNameTextView.setText(commit.getAuthor().getName());
        }

    }

    private void bindViews() {
        activityNameTextView = (TextView) findViewById(R.id.activity_name_textview);
    }

    @Override
    protected EventDetailPresenter createPresenter() {
        return new EventDetailPresenter(this);
    }


    @Override
    public void show(String object) {

    }
}
