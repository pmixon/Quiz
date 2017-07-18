package com.phillipmixon.quiz;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.question_one_brown_answer), withText("brown")));
        appCompatCheckBox.perform(scrollTo(), click());

        ViewInteraction appCompatCheckBox2 = onView(
                allOf(withId(R.id.question_one_brown_answer), withText("brown")));
        appCompatCheckBox2.perform(scrollTo(), click());

        ViewInteraction appCompatCheckBox3 = onView(
                allOf(withId(R.id.question_one_brown_answer), withText("brown")));
        appCompatCheckBox3.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withText("purple"),
                        withParent(withId(R.id.question_three_radio_group))));
        appCompatRadioButton.perform(scrollTo(), click());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.question_four_edit_text));
        appCompatEditText.perform(scrollTo(), replaceText("red"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                withText("Submit Answers"));
        appCompatButton.perform(scrollTo(), click());

    }

}
