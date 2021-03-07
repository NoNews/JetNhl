package com.stats.nhlcompose.core_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
abstract class BaseViewModelFactory<VM : ViewModel> : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return create() as T
    }

    abstract fun create(): VM
}