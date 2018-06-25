package com.abs.baseinflater.bottommenu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.abs.baseinflater.R

class SettingsActivity : BaseBottomMenuActivity() {
    companion object {
        fun start(callerActivity: AppCompatActivity) {
            val intent = Intent(callerActivity, SettingsActivity::class.java)
            callerActivity.startActivity(intent)
        }
    }

    override fun onBottomMenuViewInflated() {
        // Do nothing
    }

    override fun getBottomMenuChildContent(): Int {
        return R.layout.activity_settings
    }

    override fun getCheckedBottomMenuAction(): Int {
        return R.id.nav_settings
    }

    override fun getToolbarTitle(): String {
        return "Settings"
    }

    override fun displayHomeAsUp(): Boolean {
        return true
    }
}
