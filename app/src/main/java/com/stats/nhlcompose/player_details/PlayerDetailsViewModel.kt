package com.stats.nhlcompose.player_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PlayerDetailsViewModel : ViewModel() {

    private val state: MutableState<PlayerDetailsScreenContract.State> =
        mutableStateOf(PlayerDetailsScreenContract.State.Idle)


    init {

    }


    fun observeState() = state

    override fun onCleared() {
        super.onCleared()
    }
}