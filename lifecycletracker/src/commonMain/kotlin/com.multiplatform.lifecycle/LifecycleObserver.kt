package com.multiplatform.lifecycle

/**
 * A lifecycle tracker that can be used to track the lifecycle of a component.
 */
interface LifecycleObserver {
    fun onEvent(event: LifecycleEvent) {
        // handle event
    }
}
