package com.multiplatform.lifecyle

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import com.multiplatform.lifecycle.LifecycleEvent
import com.multiplatform.lifecycle.LifecycleTracker

/**
 * Created By Kevin Zou On 2024/2/22
 */
class LifecycleComposeUIVCDelegate(private val lifecycleTracker: LifecycleTracker) : ComposeUIViewControllerDelegate {
    override fun viewDidAppear(animated: Boolean) {
        super.viewDidAppear(animated)
        lifecycleTracker.notifyListeners(LifecycleEvent.OnResumeEvent)
    }

    override fun viewDidDisappear(animated: Boolean) {
        super.viewDidDisappear(animated)
        lifecycleTracker.notifyListeners(LifecycleEvent.OnStopEvent)
        lifecycleTracker.notifyListeners(LifecycleEvent.OnDestroyEvent)
    }

    override fun viewDidLoad() {
        super.viewDidLoad()
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
