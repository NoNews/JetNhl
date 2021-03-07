package com.stats.nhlcompose.teams

interface TeamsScreenContract {

    companion object {
        const val SCREEN_ID = "TeamsScreenId"
    }

    sealed class State {
        data class Content(
            val teams: List<TeamCardUiModel>
        ) : State()

        object Idle : State()
        object Loading : State()
        object Error : State()
    }
}