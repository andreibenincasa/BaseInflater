package com.abs.baseinflater

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abs.baseinflater.bottommenu.AccountActivity
import com.abs.baseinflater.toolbar.WhateverActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btToolbar.setOnClickListener { WhateverActivity.start(this) }

        btToolbarPlusBottomMenu.setOnClickListener { AccountActivity.start(this) }
    }
}
