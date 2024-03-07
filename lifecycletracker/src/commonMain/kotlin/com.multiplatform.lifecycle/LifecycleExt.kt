package com.multiplatform.lifecycle

/**
 * Created By Kevin Zou On 2024/3/7
 */
fun Lifecycle.addObserver(
    onCreate: (() -> Unit)? = null,
    onStart: (() -> Unit)? = null,
    onResume: (() -> Unit)? = null,
    onPause: (() -> Unit)? = null,
    onStop: (() -> Unit)? = null,
    onDestroy: (() -> Unit)? = null,
) {
    val observer =
        object : DefaultLifecycleObserver {
            override fun onCreate() {
                onCreate?.invoke()
            }

            override fun onStart() {
                onStart?.invoke()
            }

            override fun onResume() {
                onResume?.invoke()
            }

            override fun onPause() {
                onPause?.invoke()
            }

            override fun onStop() {
                onStop?.invoke()
            }

            override fun onDestroy() {
                onDestroy?.invoke()
            }
        }
    addObserver(observer)
}
