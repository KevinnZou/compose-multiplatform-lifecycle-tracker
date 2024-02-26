package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/2/22
 */
interface LifecycleObserver {
    fun onEvent(event: LifecycleEvent) {
        // handle event
    }
}
