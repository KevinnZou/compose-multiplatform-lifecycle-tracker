package com.myapplication

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.CompositionLocalProvider
import com.multiplatform.lifecycle.LifecycleTracker
import com.multiplatform.lifecycle.LocalLifecycleTracker
import com.multiplatform.lifecyle.AndroidLifecycleEventObserver

class MainActivity : AppCompatActivity() {
    private val lifecycleTracker = LifecycleTracker()
    private val observer = AndroidLifecycleEventObserver(lifecycleTracker)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(observer)

        setContent {
            CompositionLocalProvider(LocalLifecycleTracker provides lifecycleTracker) {
                MainView()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(observer)
    }
}
