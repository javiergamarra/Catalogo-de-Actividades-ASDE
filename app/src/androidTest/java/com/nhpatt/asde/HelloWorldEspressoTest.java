package com.nhpatt.asde;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.nhpatt.asde.mvp.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloWorldEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule(MainActivity.class);

    public HelloWorldEspressoTest() {
        super();
    }

    @Test
    public void listGoesOverTheFold() {
//        onView(withText("Get Catalog List")).check(matches(isDisplayed()));

        //TODO click button
        //TODO results shown
    }

}