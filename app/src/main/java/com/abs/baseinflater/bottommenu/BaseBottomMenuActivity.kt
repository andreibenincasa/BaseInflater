package com.abs.baseinflater.bottommenu

import android.support.design.widget.BottomNavigationView
import android.view.Menu
import com.abs.baseinflater.toolbar.BaseToolbarActivity
import com.abs.baseinflater.R
import kotlinx.android.synthetic.main.activity_base_bottom_menu.*

abstract class BaseBottomMenuActivity : BaseToolbarActivity() {

    override fun onToolbarViewInflated() {
        defineBottomMenu()
        inflateChildLayout()
        onBottomMenuViewInflated()
    }

    /**
     * Inflates the child layout inside its FrameLayout
     */

    private fun inflateChildLayout() {
        flBottomMenuContent.addView(layoutInflater.inflate(getBottomMenuChildContent(), null, false))
    }

    override fun getToolbarChildContent(): Int {
        return R.layout.activity_base_bottom_menu
    }

    private fun defineBottomMenu() {
        bnvBottomMenu.selectedItemId = getCheckedBottomMenuAction()
        bnvBottomMenu.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_account -> AccountActivity.start(this)
                R.id.nav_dashboard -> DashboardActivity.start(this)
                R.id.nav_settings -> SettingsActivity.start(this)
            }
            return@OnNavigationItemSelectedListener true
        })
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    /**
     * Method called when parent activity already loaded its layout
     */
    abstract fun onBottomMenuViewInflated()

    /**
     * Set the layoutId to be inflated inside parent activity
     */
    abstract fun getBottomMenuChildContent(): Int

    /**
     * Method called to get the checked bottom menu tab
     */
    abstract fun getCheckedBottomMenuAction(): Int
}