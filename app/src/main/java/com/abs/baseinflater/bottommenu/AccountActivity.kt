package com.abs.baseinflater.bottommenu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.abs.baseinflater.R

class AccountActivity : BaseBottomMenuActivity() {
    companion object {
        fun start(callerActivity: AppCompatActivity) {
            val intent = Intent(callerActivity, AccountActivity::class.java)
            callerActivity.startActivity(intent)
        }
    }

    override fun onBottomMenuViewInflated() {
        // Do nothing
    }

    override fun getBottomMenuChildContent(): Int {
        return R.layout.activity_account
    }

    override fun getCheckedBottomMenuAction(): Int {
        return R.id.nav_account
    }

    override fun getToolbarTitle(): String {
        return "Account"
    }

    override fun displayHomeAsUp(): Boolean {
        return true
    }
}
