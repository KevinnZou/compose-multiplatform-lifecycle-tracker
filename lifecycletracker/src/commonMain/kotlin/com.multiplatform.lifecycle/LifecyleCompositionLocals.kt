package com.multiplatform.lifecycle

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Created By Kevin Zou On 2024/2/27
 */
/**
 * The CompositionLocal containing the current [LifecycleTracker].
 */
val LocalLifecycleTracker = staticCompositionLocalOf<LifecycleTracker> {
    noLocalProvidedFor("LocalLifecycleTracker")
}

private fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}