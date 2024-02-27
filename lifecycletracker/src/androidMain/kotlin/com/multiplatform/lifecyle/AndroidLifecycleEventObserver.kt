package com.multiplatform.lifecyle

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.multiplatform.lifecycle.LifecycleEvent
import com.multiplatform.lifecycle.LifecycleTracker

/**
 * An observer for Android lifecycle events.
 */
class AndroidLifecycleEventObserver(private val lifecycleTracker: LifecycleTracker) :
    DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnCreateEvent)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnDestroyEvent)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnPauseEvent)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnResumeEvent)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnStartEvent)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnStopEvent)
    }
}
