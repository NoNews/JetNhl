package com.stats.nhlcompose.player_details

interface PlayerDetailsScreenContract {

    companion object {
        private const val SCREEN_ID = "PlayerDetailsScreenId"
        const val KEY_PARAM_PLAYER_ID = "player_id"

        fun screenIdTemplate() = "$SCREEN_ID/{$KEY_PARAM_PLAYER_ID}"
        fun createNavigationCommand(playerId: Int): String = "$SCREEN_ID/$playerId"
    }

    data class InputData(val playerId: Int)

    sealed class State {
        data class Content(
            val uiElements: List<Any>
        ) : State()

        object Idle : State()
        object Loading : State()
        object Error : State()
    }

}