package com.multiplatform.lifecycle

/**
 * Lifecycle events. These events can be used by developers to listen to the lifecycle of the application.
 */
sealed class LifecycleEvent {
    data object OnCreateEvent : LifecycleEvent()

    data object OnStartEvent : LifecycleEvent()

    data object OnResumeEvent : LifecycleEvent()

    data object OnPauseEvent : LifecycleEvent()

    data object OnStopEvent : LifecycleEvent()

    data object OnDestroyEvent : LifecycleEvent()

    /**
     * Returns the new [Lifecycle.State] of a [Lifecycle] that just reported
     * this [Lifecycle.Event].
     *
     * Throws [IllegalArgumentException] if called on [.ON_ANY], as it is a special
     * value used by [OnLifecycleEvent] and not a real lifecycle event.
     *
     * @return the state that will result from this event
     */
    val targetState: State
        get() {
            return when (this) {
                OnCreateEvent, OnStopEvent -> State.CREATED
                OnStartEvent, OnPauseEvent -> State.STARTED
                OnResumeEvent -> State.RESUMED
                OnDestroyEvent -> State.DESTROYED
            }
        }
}
