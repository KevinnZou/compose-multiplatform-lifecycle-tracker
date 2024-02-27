package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/2/26
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
     *
     * If this method is called while a state change is being dispatched,
     *
     *  * If the given observer has not yet received that event, it will not receive it.
     *  * If the given observer has more than 1 method that observes the currently dispatched
     * event and at least one of them received the event, all of them will receive the event and
     * the removal will happen afterwards.
     *
     *
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