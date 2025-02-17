/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.bald.uriah.baldphone.activities;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.bald.uriah.baldphone.R;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TutorialsActivityTest extends BaseActivityTest {

    @Rule
    public ActivityTestRule<TutorialActivity> mActivityTestRule = new ActivityTestRule<>(TutorialActivity.class, true, false);

    @Test public void tutorialsActivityTest() {
        mActivityTestRule.launchActivity(new Intent());
        sleep();
        ViewInteraction baldImageButton = onView(allOf(withId(R.id.right_arrow), childAtPosition(childAtPosition(withId(R.id.view_pager_holder), 1), 1), isDisplayed()));
        baldImageButton.perform(longClick());
        sleep();
        ViewInteraction appCompatTextView = onView(allOf(withId(R.id.short_presses), withText("Regular level"), childAtPosition(childAtPosition(withId(R.id.id_dummy), 1), 6), isDisplayed()));
        appCompatTextView.perform(click());
        sleep();
        ViewInteraction appCompatTextView2 = onView(allOf(withId(R.id.long_presses), withText("High Level"), childAtPosition(childAtPosition(withId(R.id.id_dummy), 1), 2), isDisplayed()));
        appCompatTextView2.perform(longClick());
        sleep();
        ViewInteraction baldImageButton2 = onView(allOf(withId(R.id.right_arrow), childAtPosition(childAtPosition(withId(R.id.view_pager_holder), 1), 1), isDisplayed()));
        baldImageButton2.perform(longClick());
        sleep();
        ViewInteraction baldImageButton3 = onView(allOf(withId(R.id.left_arrow), childAtPosition(childAtPosition(withId(R.id.view_pager_holder), 1), 0), isDisplayed()));
        baldImageButton3.perform(longClick());
        sleep();
        ViewInteraction baldImageButton4 = onView(allOf(withId(R.id.right_arrow), childAtPosition(childAtPosition(withId(R.id.view_pager_holder), 1), 1), isDisplayed()));
        baldImageButton4.perform(longClick());
        sleep();
        ViewInteraction baldImageButton5 = onView(allOf(withId(R.id.right_arrow), childAtPosition(childAtPosition(withId(R.id.view_pager_holder), 1), 1), isDisplayed()));
        baldImageButton5.perform(longClick());
    }

    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {
        return new TypeSafeMatcher<View>() {
            @Override public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
