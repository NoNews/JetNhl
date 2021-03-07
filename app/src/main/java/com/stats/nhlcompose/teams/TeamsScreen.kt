package com.stats.nhlcompose.teams

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import com.stats.nhlcompose.players.PlayersScreenContract


@ExperimentalFoundationApi
@Composable
fun TeamsScreen(
    viewModel: TeamsViewModel = viewModel(),
    navController: NavController
) {
    val state: TeamsScreenContract.State by viewModel.observeState()
    Scaffold(
        topBar = {
            Toolbar(title = "Teams")
        },
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                when (state) {
                    is TeamsScreenContract.State.Content -> {
                        val teams = (state as TeamsScreenContract.State.Content).teams
                        LazyVerticalGrid(GridCells.Fixed(2)) {
                            items(teams) { team ->
                                TeamCard(team) {
                                    navController.navigate(
                                        PlayersScreenContract.createNavigationCommand(
                                            teamId = 1
                                        )
                                    )
                                }
                            }
                        }
                    }
                    is TeamsScreenContract.State.Error -> {

                    }
                    is TeamsScreenContract.State.Idle -> {

                    }
                    is TeamsScreenContract.State.Loading -> {
                        FullScreenLoading()
                    }
                }
            }
        }
    )

}


