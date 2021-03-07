package com.stats.nhlcompose.players

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PlayersViewModel : ViewModel() {

    private val state: MutableState<PlayersScreenContract.State> =
        mutableStateOf(PlayersScreenContract.State.Idle)


    init {
        state.value = PlayersScreenContract.State.Loading

        state.value = PlayersScreenContract.State.Content(
            uiElements = listOf(
                PlayersScreenContract.PlayerSection(
                    name = "Goalies",
                    players = listOf(
                        PlayerRowUiModel(
                            name = "Alex Ovechkin",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Alex Ovechkin Alex Ovechkin Alex Ovechkin Alex Ovechkin Alex Ovechkin Alex Ovechkin Alex Ovechkin Alex Ovechkin",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        )
                    )
                ),
                PlayersScreenContract.PlayerSection(
                    name = "Defense",
                    players = listOf(
                        PlayerRowUiModel(
                            name = "Alex Ovechkin",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Player",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Player",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Player",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Alex Ovechkin",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Player",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Player",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                        PlayerRowUiModel(
                            name = "Player",
                            position = "defense",
                            "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg"
                        ),
                    ),
                ),
                PlayersScreenContract.PlayerSection(
                    name = "Napada",
                    players = listOf(
                    )
                )
            )
        )

    }


    fun observeState() = state

    override fun onCleared() {
        super.onCleared()
    }
}