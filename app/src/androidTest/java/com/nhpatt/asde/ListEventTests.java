package com.nhpatt.asde;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.test.suitebuilder.annotation.LargeTest;

import com.nhpatt.asde.mvp.activities.MainActivity;
import com.nhpatt.asde.mvp.fragments.EventListFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListEventTests {

    public static final String SAMPLE_ACTIVITY = "JUEGOS ROMPEHIELOS";

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule(MainActivity.class);
    private EventListFragment eventListFragment;

    public ListEventTests() {
        super();
    }

    @Test
    public void whenIloadTheAppISeeTheItemResultsTest() {
        onView(withText(SAMPLE_ACTIVITY)).check(matches(isDisplayed()));
    }

    @Test
    public void whenIClickAnItemILoadTheDetails() {
        onView(withText(SAMPLE_ACTIVITY)).perform(click());
        onView(withId(R.id.description_content_textview)).check(matches(isDisplayed()));
    }

    @Test
    public void whenIGoBackInDetailISeeTheListAgain() {
        onView(withText(SAMPLE_ACTIVITY)).perform(click());
        onView(withId(R.id.description_content_textview)).check(matches(isDisplayed()));
        onView(withText(SAMPLE_ACTIVITY)).check(doesNotExist());
        pressBack();
        onView(withText(SAMPLE_ACTIVITY)).check(matches(isDisplayed()));
    }

    @Before
    public void registerIntentServiceIdlingResource() {

        MainActivity activity = activityTestRule.getActivity();
        eventListFragment = (EventListFragment)
                activity.getSupportFragmentManager().findFragmentById(R.id.fragment_placeholder);

        Espresso.registerIdlingResources(eventListFragment);
    }

    @After
    public void unregisterIntentServiceIdlingResource() {
        Espresso.unregisterIdlingResources(eventListFragment);
    }

}