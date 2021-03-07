package com.stats.nhlcompose.players

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.stats.nhlcompose.core_ui.FullScreenLoading
import com.stats.nhlcompose.core_ui.Toolbar
import com.stats.nhlcompose.player_details.PlayerDetailsScreenContract

@ExperimentalFoundationApi
@Composable
fun PlayersScreen(
    inputData: PlayersScreenContract.InputData,
    navController: NavController,
    viewModel: PlayersViewModel = viewModel()
) {
    val state: PlayersScreenContract.State by viewModel.observeState()

    Scaffold(
        topBar = {
            Toolbar(
                title = inputData.teamId.toString(),
                onClickBack = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                when (state) {
                    is PlayersScreenContract.State.Content -> {
                        val elements = (state as PlayersScreenContract.State.Content).uiElements
                        LazyColumn() {
                            elements.forEach { header ->
                                stickyHeader {
                                    Header(model = HeaderUiModel(header.name))
                                }
                                items(header.players) { player ->
                                    PlayerRow(model = player) {
                                        navController.navigate(
                                            PlayerDetailsScreenContract.createNavigationCommand(
                                                1
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                    is PlayersScreenContract.State.Error -> {

                    }
                    is PlayersScreenContract.State.Idle -> {

                    }
                    is PlayersScreenContract.State.Loading -> {
                        FullScreenLoading()
                    }
                }
            }
        }
    )


}