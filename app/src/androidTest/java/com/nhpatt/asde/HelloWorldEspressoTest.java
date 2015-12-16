package com.nhpatt.asde;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.nhpatt.asde.mvp.activities.CatalogListActivity;

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
	public ActivityTestRule<CatalogListActivity> mActivityRule = new ActivityTestRule(CatalogListActivity.class);

	public HelloWorldEspressoTest() {
		super();
	}

	@Test
	public void listGoesOverTheFold() {
		onView(withText("Get Catalog List")).check(matches(isDisplayed()));
	}

}