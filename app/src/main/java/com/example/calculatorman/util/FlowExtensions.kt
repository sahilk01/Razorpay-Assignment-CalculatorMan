package com.example.calculatorman.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.collectOnUi(
    lifecycleOwner: LifecycleOwner,
    crossinline onCollect: (T) -> Unit
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            this@collectOnUi.collect {
                onCollect(it)
            }
        }
    }
}

inline fun <T> Flow<T>.collectLatestOnUi(
    lifecycleOwner: LifecycleOwner,
    crossinline onCollect: (T) -> Unit
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            this@collectLatestOnUi.collectLatest {
                onCollect(it)
            }
        }
    }
}