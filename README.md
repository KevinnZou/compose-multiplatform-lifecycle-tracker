# Compose Multiplatform Lifecycle Tracker

[![Maven Central](https://img.shields.io/maven-central/v/io.github.kevinnzou/compose-multiplatform-lifecycle-tracker.svg)](https://search.maven.org/artifact/io.github.kevinnzou/compose-multiplatform-lifecycle-tracker)
[![Kotlin](https://img.shields.io/badge/kotlin-v1.9.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.5.11-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)

A library to track the lifecycle of page in Compose Multiplatform.

# Setup
To use this library, you need some setup in your project.

## Android 
This library uses the `androidx.lifecycle:lifecycle-runtime-ktx` library to track the lifecycle of the page. You need to add the following dependency to your `build.gradle.kts` file.
```kotlin
val androidMain by getting {
   dependencies {
      implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
   }
}
```

Then, you need to add the `AndroidLifecycleEventObserver` to your `Activity` or `Fragment` to track the lifecycle of the page. 
```kotlin
class MainActivity : AppCompatActivity() {
    private val observer = AndroidLifecycleEventObserver(LifecycleTracker)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(observer)

        setContent {
            MainView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(observer)
    }
}
```

## iOS
For iOS, you just need to set the 'LifecycleComposeUIVCDelegate' as the delegate of the `UIComposeViewController` to track the lifecycle of the page. 
```kotlin
fun MainViewController() = ComposeUIViewController({
    delegate = LifecycleComposeUIVCDelegate(LifecycleTracker)
}) { App() }
```

# Usage
The usage is quite simple, you just need to create a 'LifecycleListener' and add it to the `LifecycleTracker`. 
```kotlin
@Composable
private fun LifecycleTest() {
    DisposableEffect(Unit) {
        val listener = object : LifecycleListener {
            override fun onEvent(event: LifecycleEvent) {
                println("Lifecycle: onEvent: $event")
            }
        }
        LifecycleTracker.addListener(listener)
        onDispose {
            LifecycleTracker.removeListener(listener)
        }
    }
}
```

# Download
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kevinnzou/compose-multiplatform-lifecycle-tracker.svg)](https://search.maven.org/artifact/io.github.kevinnzou/compose-multiplatform-lifecycle-tracker)

This library is available on Maven Central. You can add it to your project by adding the following dependency to your `build.gradle.kts` file.

```kotlin
repositories {
    mavenCentral()
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
              implementation("io.github.kevinnzou:compose-multiplatform-lifecycle-tracker:0.0.1")
            }
        }
    }
}
```