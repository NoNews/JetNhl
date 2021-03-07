package com.stats.nhlcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.stats.nhlcompose.core.theme.MyTheme
import com.stats.nhlcompose.player_details.PlayerDetailsScreen
import com.stats.nhlcompose.player_details.PlayerDetailsScreenContract
import com.stats.nhlcompose.players.PlayersScreen
import com.stats.nhlcompose.players.PlayersScreenContract
import com.stats.nhlcompose.teams.TeamsScreen
import com.stats.nhlcompose.teams.TeamsScreenContract

class ApplicationActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme(false) {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = TeamsScreenContract.SCREEN_ID
                    ) {
                        composable(TeamsScreenContract.SCREEN_ID) {
                            TeamsScreen(navController = navController)
                        }
                        composable(
                            route = PlayersScreenContract.screenIdTemplate(),
                            arguments = listOf(
                                navArgument(PlayersScreenContract.KEY_PARAM_TEAM_ID) {
                                    type = NavType.IntType
                                }
                            )
                        ) { backStackEntry ->
                            val teamId =
                                backStackEntry.arguments?.getInt(PlayersScreenContract.KEY_PARAM_TEAM_ID)
                                    ?: error("Can't proceed without team id")

                            PlayersScreen(
                                inputData = PlayersScreenContract.InputData(teamId = teamId),
                                navController = navController
                            )
                        }

                        composable(
                            route = PlayerDetailsScreenContract.screenIdTemplate(),
                            arguments = listOf(
                                navArgument(
                                    PlayerDetailsScreenContract.KEY_PARAM_PLAYER_ID
                                ) {
                                    type = NavType.IntType
                                }
                            )
                        ) { backStackEntry ->
                            val playerId =
                                backStackEntry.arguments?.getInt(PlayerDetailsScreenContract.KEY_PARAM_PLAYER_ID)
                                    ?: error("Can't proceed without team id")

                            PlayerDetailsScreen(
                                inputData = PlayerDetailsScreenContract.InputData(playerId)
                            )
                        }
                    }
                }
            }
        }
    }

}

