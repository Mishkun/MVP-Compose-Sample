package io.github.mishkun.mvpcomposesample.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Presenter(private val scope: CoroutineScope) {
    var view: View? = null
    private val names = listOf("Peter", "John", "Elis", "Katie")

    fun onClick() = scope.launch {
        view?.setLoading()
        withContext(Dispatchers.IO) {
            delay(1000)
        }
        view?.setContent(names.random())
    }
}
