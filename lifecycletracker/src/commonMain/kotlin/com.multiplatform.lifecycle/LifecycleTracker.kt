package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/2/22
 */
object LifecycleTracker {
    private val lifecycleListeners = mutableListOf<LifecycleObserver>()

    fun addListener(listener: LifecycleObserver) {
        lifecycleListeners.add(listener)
    }

    fun removeListener(listener: LifecycleObserver) {
        lifecycleListeners.remove(listener)
    }

    fun notifyListeners(event: LifecycleEvent) {
        lifecycleListeners.forEach { it.onEvent(event) }
    }
}
