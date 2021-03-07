package com.stats.nhlcompose.players

interface PlayersScreenContract {

    companion object {
        private const val SCREEN_ID = "PlayersScreenId"
        const val KEY_PARAM_TEAM_ID = "teamId"

        fun screenIdTemplate() = "$SCREEN_ID/{$KEY_PARAM_TEAM_ID}"
        fun createNavigationCommand(teamId: Int): String = "$SCREEN_ID/$teamId"
    }

    data class InputData(val teamId: Int)

    sealed class State {
        data class Content(
            val uiElements: List<PlayerSection>
        ) : State()

        object Idle : State()
        object Loading : State()
        object Error : State()
    }

    data class PlayerSection(val name: String, val players: List<PlayerRowUiModel>)
}