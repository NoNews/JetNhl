package com.stats.nhlcompose.player_details

import com.stats.nhlcompose.core_ui.BaseViewModelFactory


class PlayerDetailsViewModelFactory(private val inputData: PlayerDetailsScreenContract.InputData) :
    BaseViewModelFactory<PlayerDetailsViewModel>() {

    override fun create(): PlayerDetailsViewModel = PlayerDetailsViewModel(inputData)
}
