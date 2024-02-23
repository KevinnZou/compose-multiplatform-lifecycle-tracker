import androidx.compose.ui.window.ComposeUIViewController
import com.multiplatform.lifecycle.LifecycleTracker
import com.multiplatform.lifecyle.LifecycleComposeUIVCDelegate

actual fun getPlatformName(): String = "iOS"

fun MainViewController() =
    ComposeUIViewController({
        delegate = LifecycleComposeUIVCDelegate(LifecycleTracker)
    }) { App() }
