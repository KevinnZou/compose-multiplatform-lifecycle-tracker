package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/3/7
 */
interface DefaultLifecycleObserver : LifecycleObserver {
    override fun onEvent(event: LifecycleEvent) {
        // handle event
        when (event) {
            is LifecycleEvent.OnCreateEvent -> onCreate()
            is LifecycleEvent.OnStartEvent -> onStart()
            is LifecycleEvent.OnResumeEvent -> onResume()
            is LifecycleEvent.OnPauseEvent -> onPause()
            is LifecycleEvent.OnStopEvent -> onStop()
            is LifecycleEvent.OnDestroyEvent -> onDestroy()
        }
    }

    fun onCreate() {
        // handle onCreate event
    }

    fun onStart() {
        // handle onStart event
    }

    fun onResume() {
        // handle onResume event
    }

    fun onPause() {
        // handle onPause event
    }

    fun onStop() {
        // handle onStop event
    }

    fun onDestroy() {
        // handle onDestroy event
    }
}
