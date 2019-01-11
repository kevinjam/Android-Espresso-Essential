package com.thinkdevs.EspressoAndroid

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.Toolbar
import android.view.View
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher

import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun greet() {
        //check the String is Empty
        onView(withId(R.id.greeting))
            .check(matches(withText("")))

//check if the button is click and hide the button
        onView(withId(R.id.greet_button))
            .perform(click())
            .check(matches(not(isEnabled())))

        //check if the string contain hello after is the button is clicked
        onView(withId(R.id.greeting))
            .check(matches(withText(R.string.hello)))
    }

    @Test
    fun toolbarTitle(){
//        onView(
//            allOf(
//                isAssignableFrom(TextView::class.java),
//                withParent(isAssignableFrom(Toolbar::class.java))
//            )
//        ).check(matches(withText(R.string.title)))
//        //we need to find the toolbar

        //get a string and convert it
        val title = InstrumentationRegistry.getTargetContext().getString(R.string.title)

        onView(isAssignableFrom(Toolbar::class.java))
            .check(matches(withToolbarTitle(title)))

    }

    private fun withToolbarTitle(expectedTitle:CharSequence):Matcher<View>{

        return object :BoundedMatcher<View,Toolbar>(Toolbar::class.java){

            //Is call when the matching fail
            override fun describeTo(description: Description?) {

                description!!.appendText("with toolbar tile: $expectedTitle")
            }

            //get a toolbar as parameter
            //check if toolbar return the title we expect
            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                return expectedTitle == toolbar!!.title

            }

        }
    }
}