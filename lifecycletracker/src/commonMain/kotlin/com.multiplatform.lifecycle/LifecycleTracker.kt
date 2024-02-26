package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/2/22
 */
object LifecycleTracker {
    private val lifecycleObservers = mutableListOf<LifecycleObserver>()

    fun addListener(listener: LifecycleObserver) {
        lifecycleObservers.add(listener)
    }

    fun removeListener(listener: LifecycleObserver) {
        lifecycleObservers.remove(listener)
    }

    fun notifyListeners(event: LifecycleEvent) {
        lifecycleObservers.forEach { it.onEvent(event) }
    }
}
