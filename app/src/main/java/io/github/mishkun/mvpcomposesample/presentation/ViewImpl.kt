package io.github.mishkun.mvpcomposesample.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class ViewImpl(private val presenter: Presenter) {

    @Composable
    fun render() {
        var loading: Boolean by remember { mutableStateOf(false) }
        var somecontent: String by remember { mutableStateOf("") }
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Column {
                if (loading) {
                    CircularProgressIndicator()
                } else {
                    Greeting(somecontent)
                }
                Button(onClick = { presenter.onClick() }) {
                    Text(text = "Change name")
                }
            }
        }

        DisposableEffect(presenter) {
            presenter.view = object : View {
                override fun setLoading() {
                    loading = true
                }

                override fun setContent(name: String) {
                    somecontent = name
                    loading = false
                }
            }
            onDispose {
                presenter.view = null
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

