package com.example.data.core.flow

data class Data<T>(
    val content: T? = null,
    val error: Throwable? = null,
    val loading: Boolean = false
)