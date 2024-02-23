package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/2/22
 */
sealed class LifecycleEvent {
    data object OnCreateEvent : LifecycleEvent()

    data object OnStartEvent : LifecycleEvent()

    data object OnResumeEvent : LifecycleEvent()

    data object OnPauseEvent : LifecycleEvent()

    data object OnStopEvent : LifecycleEvent()

    data object OnDestroyEvent : LifecycleEvent()
}
