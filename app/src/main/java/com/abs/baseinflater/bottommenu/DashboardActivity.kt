package com.abs.baseinflater.bottommenu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.abs.baseinflater.R

class DashboardActivity : BaseBottomMenuActivity() {
    companion object {
        fun start(callerActivity: AppCompatActivity) {
            val intent = Intent(callerActivity, DashboardActivity::class.java)
            callerActivity.startActivity(intent)
        }
    }

    override fun onBottomMenuViewInflated() {
        // Do nothing
    }

    override fun getBottomMenuChildContent(): Int {
        return R.layout.activity_dashboard
    }

    override fun getCheckedBottomMenuAction(): Int {
        return R.id.nav_dashboard
    }

    override fun getToolbarTitle(): String {
        return "Dashboard"
    }

    override fun displayHomeAsUp(): Boolean {
        return false
    }
}
