package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/2/22
 */
object LifecycleTracker {
    private val lifecycleListeners = mutableListOf<LifecycleListener>()

    fun addListener(listener: LifecycleListener) {
        lifecycleListeners.add(listener)
    }

    fun removeListener(listener: LifecycleListener) {
        lifecycleListeners.remove(listener)
    }

    fun notifyListeners(event: LifecycleEvent) {
        lifecycleListeners.forEach { it.onEvent(event) }
    }
}