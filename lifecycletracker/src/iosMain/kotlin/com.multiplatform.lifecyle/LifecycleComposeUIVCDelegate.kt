package com.multiplatform.lifecyle

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import com.multiplatform.lifecycle.LifecycleEvent
import com.multiplatform.lifecycle.LifecycleTracker
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSNotificationName
import platform.Foundation.NSSelectorFromString
import platform.UIKit.UIApplicationDidBecomeActiveNotification
import platform.UIKit.UIApplicationDidEnterBackgroundNotification
import platform.UIKit.UIApplicationWillEnterForegroundNotification
import platform.UIKit.UIApplicationWillResignActiveNotification
import platform.UIKit.UIApplicationWillTerminateNotification

/**
 * Created By Kevin Zou On 2024/2/22
 */
class LifecycleComposeUIVCDelegate(private val lifecycleTracker: LifecycleTracker) :
    ComposeUIViewControllerDelegate {

    private val nsLifecycleListener = NSLifecycleListener(lifecycleTracker)

    @OptIn(ExperimentalForeignApi::class)
    fun addObserver(name: NSNotificationName, selectorName: String) {
        NSNotificationCenter.defaultCenter.addObserver(
            nsLifecycleListener,
            selector = NSSelectorFromString("$selectorName:"),
            name = name,
            `object` = null,
        )
    }

    private fun addLifecycleObservers() {
        addObserver(UIApplicationWillEnterForegroundNotification, "willEnterForeground")
        addObserver(UIApplicationDidBecomeActiveNotification, "didBecomeActive")
        addObserver(UIApplicationWillResignActiveNotification, "willResignActive")
        addObserver(UIApplicationDidEnterBackgroundNotification, "didEnterBackground")
        addObserver(UIApplicationWillTerminateNotification, "willTerminate")
    }

    override fun viewDidAppear(animated: Boolean) {
        super.viewDidAppear(animated)
    }

    override fun viewDidDisappear(animated: Boolean) {
        super.viewDidDisappear(animated)
        lifecycleTracker.notifyListeners(LifecycleEvent.OnStopEvent)
    }

    override fun viewDidLoad() {
        super.viewDidLoad()
        addLifecycleObservers()
        lifecycleTracker.notifyListeners(LifecycleEvent.OnCreateEvent)
    }

    override fun viewWillAppear(animated: Boolean) {
        super.viewWillAppear(animated)
        lifecycleTracker.notifyListeners(LifecycleEvent.OnStartEvent)
    }

    override fun viewWillDisappear(animated: Boolean) {
        super.viewWillDisappear(animated)
        lifecycleTracker.notifyListeners(LifecycleEvent.OnPauseEvent)
    }
}
