package com.stats.nhlcompose.players

import com.stats.nhlcompose.core_ui.BaseViewModelFactory


class PlayersViewModelFactory(private val inputData: PlayersScreenContract.InputData) :
    BaseViewModelFactory<PlayersViewModel>() {

    override fun create(): PlayersViewModel = PlayersViewModel(inputData)
}
