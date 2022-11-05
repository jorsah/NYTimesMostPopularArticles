package com.example.nytimesmostpopulararticles

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.example.nytimesmostpopulararticles.app.fragments.ArticleListFragment
import com.example.nytimesmostpopulararticles.helpers.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ArticleListFragmentTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        launchFragmentInHiltContainer<ArticleListFragment>()
    }

    @Test
    fun `progress bar is displayed`() {
        sleep(1000)
        assertDisplayed(R.id.progressBar)
    }

    @Test
    fun `articles are displayed`() {
        sleep(3000)
        assertDisplayed("TEST")
        assertDisplayed(R.id.list)
    }
}