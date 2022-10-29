package com.github.hemoptysisheart.core.model

import android.util.Log

object DummyLocationModel : LocationModel {
    private val TAG = DummyLocationModel::class.simpleName

    override fun init() {
        Log.v(TAG, "#init called.")
    }

    override fun test() {
        Log.v(TAG, "#test called.")
    }
}