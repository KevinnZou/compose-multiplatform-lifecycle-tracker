package com.multiplatform.lifecycle

/**
 * A lifecycle tracker that can be used to track the lifecycle of the application.
 */
open class LifecycleTracker : Lifecycle() {
    /**
     * Current state
     */
    private var state: State = State.INITIALIZED
    private val lifecycleObservers = mutableListOf<LifecycleObserver>()

    private fun notifyListeners(event: LifecycleEvent) {
        lifecycleObservers.forEach { it.onEvent(event) }
    }

    override fun addObserver(observer: LifecycleObserver) {
        if (state >= State.CREATED) {
            observer.onEvent(LifecycleEvent.OnCreateEvent)
        }
        if (state >= State.STARTED) {
            observer.onEvent(LifecycleEvent.OnStartEvent)
        }
        if (state >= State.RESUMED) {
            observer.onEvent(LifecycleEvent.OnResumeEvent)
        }

        lifecycleObservers.add(observer)
    }

    override fun removeObserver(observer: LifecycleObserver) {
        lifecycleObservers.remove(observer)
    }

    override var currentState: State
        get() = state

        set(state) {
            moveToState(state)
        }

    /**
     * Sets the current state and notifies the observers.
     *
     * Note that if the `currentState` is the same state as the last call to this method,
     * calling this method has no effect.
     *
     * @param event The event that was received
     */
    open fun handleLifecycleEvent(event: LifecycleEvent) {
        moveToState(event.targetState)
        notifyListeners(event)
    }

    private fun moveToState(next: State) {
        if (state == next) {
            return
        }
        state = next
    }
}
