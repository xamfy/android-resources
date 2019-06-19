package com.xamfy.lifecycleaware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "Owner onCreate")
        lifecycle.addObserver(MainActivityObserver())
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
