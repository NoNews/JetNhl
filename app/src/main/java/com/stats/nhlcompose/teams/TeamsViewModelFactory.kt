package com.stats.nhlcompose.teams

import com.example.data.DataProvider
import com.stats.nhlcompose.core_ui.BaseViewModelFactory


class TeamsViewModelFactory() : BaseViewModelFactory<TeamsViewModel>() {

    override fun create(): TeamsViewModel = TeamsViewModel(
        repository = DataProvider.teamsRepository
    )
}
