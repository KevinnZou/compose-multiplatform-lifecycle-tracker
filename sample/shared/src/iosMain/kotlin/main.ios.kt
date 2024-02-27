import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import com.multiplatform.lifecycle.LifecycleTracker
import com.multiplatform.lifecycle.LocalLifecycleTracker
import com.multiplatform.lifecyle.LifecycleComposeUIVCDelegate
import platform.UIKit.UIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController(): UIViewController {
    val lifecycleTracker = LifecycleTracker()
    return ComposeUIViewController({
        delegate = LifecycleComposeUIVCDelegate(lifecycleTracker)
    }) {
        CompositionLocalProvider(LocalLifecycleTracker provides lifecycleTracker) {
            App()
        }
    }
}
