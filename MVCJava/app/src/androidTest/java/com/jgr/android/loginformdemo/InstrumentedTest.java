package com.jgr.android.loginformdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testUIAttributes(){
        onView(withId(R.id.title_form)).check(matches(withText(R.string.validate_user_title)));
        onView(withId(R.id.username_text)).check(matches(withHint(R.string.username_hint)));
        onView(withId(R.id.password_text)).check(matches(withHint(R.string.password_hint)));
        onView(withId(R.id.action_button)).check(matches(withText(R.string.button_name)));
        onView(withId(R.id.person_type_switch)).perform(click());
        onView(withId(R.id.action_result));
    }

    @Test
    public void isValidProfessor() {
        onView(withId(R.id.username_text)).perform(typeText("Jason"));
        onView(withId(R.id.password_text)).perform(typeText("password1234"), closeSoftKeyboard());
        onView(withId(R.id.action_button)).perform(click());
        onView(withId(R.id.action_result)).check(matches(withText(R.string.correct_user_message)));
    }

    @Test
    public void isValidStudent() {
        onView(withId(R.id.username_text)).perform(typeText("Maria"));
        onView(withId(R.id.password_text)).perform(typeText("M1234Pas$"), closeSoftKeyboard());
        onView(withId(R.id.person_type_switch)).perform(click());
        onView(withId(R.id.action_button)).perform(click());
        onView(withId(R.id.action_result)).check(matches(withText(R.string.correct_user_message)));
    }

    @Test
    public void incorrectPersonTypeProfessor() {
        onView(withId(R.id.username_text)).perform(typeText("Jason"));
        onView(withId(R.id.password_text)).perform(typeText("password1234"), closeSoftKeyboard());
        onView(withId(R.id.person_type_switch)).perform(click());
        onView(withId(R.id.action_button)).perform(click());
        onView(withId(R.id.action_result)).check(matches(withText(R.string.incorrect_user_message)));
    }

    @Test
    public void incorrectPersonTypeStudent() {
        onView(withId(R.id.username_text)).perform(typeText("Maria"));
        onView(withId(R.id.password_text)).perform(typeText("M1234Pas$"), closeSoftKeyboard());
        onView(withId(R.id.action_button)).perform(click());
        onView(withId(R.id.action_result)).check(matches(withText(R.string.incorrect_user_message)));
    }

    @Test
    public void incorrectCredentialsProfessor() {
        onView(withId(R.id.username_text)).perform(typeText("Jason"));
        onView(withId(R.id.password_text)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.action_button)).perform(click());
        onView(withId(R.id.action_result)).check(matches(withText(R.string.incorrect_user_message)));
    }

    @Test
    public void incorrectCredentialsStudent() {
        onView(withId(R.id.username_text)).perform(typeText("Maria"));
        onView(withId(R.id.password_text)).perform(typeText("M1234Pas$sdfa"), closeSoftKeyboard());
        onView(withId(R.id.person_type_switch)).perform(click());
        onView(withId(R.id.action_button)).perform(click());
        onView(withId(R.id.action_result)).check(matches(withText(R.string.incorrect_user_message)));
    }
}
