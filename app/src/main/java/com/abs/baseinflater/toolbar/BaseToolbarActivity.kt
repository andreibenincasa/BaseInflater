package com.abs.baseinflater.toolbar

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.abs.baseinflater.R
import kotlinx.android.synthetic.main.activity_base_toolbar.*

abstract class BaseToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_toolbar)

        defineToolbar()
        inflateChildLayout()
        onToolbarViewInflated()
    }

    /**
     * Inflates the child layout inside its FrameLayout
     */

    private fun inflateChildLayout() {
        flToolbarContent.addView(layoutInflater.inflate(getToolbarChildContent(), null, false))
    }

    /**
     * Method that setup Toolbar properties like title and enable back button
     */
    private fun defineToolbar() {
        setSupportActionBar(toolbar)

        supportActionBar?.let {
            it.title = getToolbarTitle()

            if (displayHomeAsUp()) {
                it.displayOptions = ActionBar.DISPLAY_HOME_AS_UP or ActionBar.DISPLAY_SHOW_TITLE
            }
        }
    }

    /**
     * Method called when parent activity already loaded its layout
     */
    abstract fun onToolbarViewInflated()

    /**
     * Set the toolbar title inside the parent activity
     */
    abstract fun getToolbarTitle(): String

    /**
     * Set the layoutId to be inflated inside parent activity
     */
    abstract fun getToolbarChildContent(): Int

    /**
     * Flag to setup the back button
     */
    abstract fun displayHomeAsUp(): Boolean

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if (displayHomeAsUp()) {
                    onBackPressed()
                }
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Set the Toolbar title
     */
    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }
}