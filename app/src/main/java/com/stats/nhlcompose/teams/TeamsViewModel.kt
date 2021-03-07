package com.stats.nhlcompose.teams

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.features.TeamsRepository
import com.stats.nhlcompose.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TeamsViewModel(private val repository: TeamsRepository) : ViewModel() {

    private val state: MutableState<TeamsScreenContract.State> =
        mutableStateOf(TeamsScreenContract.State.Idle)


    init {
        viewModelScope.launch {
            observeTeams()
        }

    }

    private suspend fun observeTeams() {
        repository.observeTeams(forceReload = false)
            .map { data ->
                val state = when {
                    data.content != null -> {
                        val teams = requireNotNull(data.content)
                        TeamsScreenContract.State.Content(
                            teams = teams.map { team ->
                                TeamCardUiModel(
                                    name = team.name,
                                    drawableRes = team.toImageRes(),
                                    subtitle = team.fistYearOfPlay
                                )
                            }
                        )
                    }
                    data.loading && data.content == null -> {
                        TeamsScreenContract.State.Loading
                    }
                    else -> TeamsScreenContract.State.Loading
                }
                state
            }.collect { model ->
                state.value = model
            }
    }


    fun observeState() = state

    override fun onCleared() {
        super.onCleared()
    }
}