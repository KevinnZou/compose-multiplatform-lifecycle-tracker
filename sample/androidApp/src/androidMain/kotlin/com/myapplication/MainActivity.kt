package com.myapplication

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.multiplatform.lifecycle.LifecycleTracker
import com.multiplatform.lifecyle.AndroidLifecycleEventObserver

class MainActivity : AppCompatActivity() {
    private val observer = AndroidLifecycleEventObserver(LifecycleTracker)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(observer)

        setContent {
            MainView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(observer)
    }
}
