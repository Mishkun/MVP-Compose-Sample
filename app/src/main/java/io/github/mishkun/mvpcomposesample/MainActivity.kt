package io.github.mishkun.mvpcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import io.github.mishkun.mvpcomposesample.presentation.Presenter
import io.github.mishkun.mvpcomposesample.presentation.ViewImpl
import io.github.mishkun.mvpcomposesample.ui.theme.MVPComposeSampleTheme

class MainActivity : ComponentActivity() {
    private val presenter = Presenter(lifecycleScope)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVPComposeSampleTheme {
                ViewImpl(presenter).render()
            }
        }
    }
}
