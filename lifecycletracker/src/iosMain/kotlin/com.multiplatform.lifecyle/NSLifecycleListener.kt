package com.multiplatform.lifecyle

import com.multiplatform.lifecycle.LifecycleEvent
import com.multiplatform.lifecycle.LifecycleTracker
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSNotification
import platform.darwin.NSObject

/**
 * Created By Kevin Zou On 2024/2/26
 */
@Suppress("unused")
@OptIn(BetaInteropApi::class)
class NSLifecycleListener(private val lifecycleTracker: LifecycleTracker) : NSObject() {
    @ObjCAction
    fun willEnterForeground(arg: NSNotification) {
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnStartEvent)
    }

    @ObjCAction
    fun didBecomeActive(arg: NSNotification) {
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnResumeEvent)
    }

    @ObjCAction
    fun willResignActive(arg: NSNotification) {
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnPauseEvent)
    }

    @ObjCAction
    fun didEnterBackground(arg: NSNotification) {
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnStopEvent)
    }

    @ObjCAction
    fun willTerminate(arg: NSNotification) {
        lifecycleTracker.handleLifecycleEvent(LifecycleEvent.OnDestroyEvent)
    }
}
