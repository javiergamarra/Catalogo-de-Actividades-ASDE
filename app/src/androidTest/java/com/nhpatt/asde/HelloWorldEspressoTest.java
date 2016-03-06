package com.nhpatt.asde;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.nhpatt.asde.mvp.activities.EventListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloWorldEspressoTest {

    @Rule
    public ActivityTestRule<EventListActivity> mActivityRule = new ActivityTestRule(EventListActivity.class);

    public HelloWorldEspressoTest() {
        super();
    }

    @Test
    public void listGoesOverTheFold() {
        onView(withText("Get Catalog List")).check(matches(isDisplayed()));

        //TODO click button
        //TODO results shown
    }

}