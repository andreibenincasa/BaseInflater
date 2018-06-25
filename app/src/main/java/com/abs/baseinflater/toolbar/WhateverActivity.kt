package com.abs.baseinflater.toolbar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.abs.baseinflater.R
import kotlinx.android.synthetic.main.activity_whatever.*

class WhateverActivity : BaseToolbarActivity() {
    companion object {
        fun start(callerActivity: AppCompatActivity) {
            val intent = Intent(callerActivity, WhateverActivity::class.java)
            callerActivity.startActivity(intent)
        }
    }


    override fun onToolbarViewInflated() {
        // Now that BaseToolbarActivity already inflated the whole layout
        // we can setup the views

        btChangeToolbarTitle.setOnClickListener {
            val newToolbarTitle: String = tietTitle.text.toString()
            setToolbarTitle(newToolbarTitle)
        }
    }

    override fun getToolbarTitle(): String {
        return "Whatever dude..."
    }

    override fun getToolbarChildContent(): Int {
        return R.layout.activity_whatever
    }

    override fun displayHomeAsUp(): Boolean {
        return true
    }
}
