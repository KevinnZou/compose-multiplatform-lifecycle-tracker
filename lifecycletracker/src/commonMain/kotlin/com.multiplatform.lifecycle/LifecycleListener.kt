package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/2/22
 */
interface LifecycleListener {
    fun onEvent(event: LifecycleEvent) {
        // handle event
    }
}