package com.stats.nhlcompose.teams

import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.stats.nhlcompose.R

class TeamsViewModel : ViewModel() {

    private val state: MutableState<TeamsScreenContract.State> = mutableStateOf(TeamsScreenContract.State.Idle)


    init {
        state.value = TeamsScreenContract.State.Loading

        Handler(Looper.getMainLooper()).postDelayed(
            {
                state.value = TeamsScreenContract.State.Content(
                    teams = listOf(
                        TeamCardUiModel(
                            "Arizona Coyotis",
                            R.drawable.ic_arizona
                        ),
                        TeamCardUiModel(
                            "Sent Luis Blues",
                            R.drawable.ic_blues
                        ),

                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        ),
                        TeamCardUiModel(
                            "Bostom Bruins",
                            R.drawable.ic_bruins
                        )
                    )
                )
            }, 2000
        )
    }


    fun observeState() = state

    override fun onCleared() {
        super.onCleared()
    }
}