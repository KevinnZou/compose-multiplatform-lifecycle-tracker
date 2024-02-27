package com.multiplatform.lifecycle

/**
 * A class that has an Android-like lifecycle.
 */
abstract class Lifecycle {
    /**
     * Adds a LifecycleObserver that will be notified when the LifecycleOwner changes
     * state.
     *
     * The given observer will be brought to the current state of the LifecycleOwner.
     * For example, if the LifecycleOwner is in [State.STARTED] state, the given observer
     * will receive [Event.ON_CREATE], [Event.ON_START] events.
     *
     * @param observer The observer to notify.
     */
    abstract fun addObserver(observer: LifecycleObserver)

    /**
     * Removes the given observer from the observers list.
     * @param observer The observer to be removed.
     */
    abstract fun removeObserver(observer: LifecycleObserver)

    /**
     * Returns the current state of the Lifecycle.
     *
     * @return The current state of the Lifecycle.
     */
    abstract val currentState: State
}
