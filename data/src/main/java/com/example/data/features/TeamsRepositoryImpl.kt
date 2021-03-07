package com.example.data.features

import com.example.data.core.flow.Data
import com.example.data.core.flow.DataFlowDelegate
import com.example.data.features.teams.TeamsService
import com.example.data.features.teams.dto.TeamDto
import com.example.data.models.ShortTeam
import kotlinx.coroutines.flow.Flow

internal class TeamsRepositoryImpl(teamService: TeamsService) : TeamsRepository {

    private val teamsDelegate = DataFlowDelegate<Unit, List<ShortTeam>>(
        fromNetwork = {
            teamService.getAllTeams()
                .teams
                .map { team -> team.toDomain() }
        },
        fromMemory = {
            null
        },
        fromStorage = {
            null
        }
    )


    override suspend fun observeTeams(forceReload: Boolean): Flow<Data<List<ShortTeam>>> =
        teamsDelegate.observe(params = Unit, forceReload = forceReload)


    private fun TeamDto.toDomain(): ShortTeam = ShortTeam(
        id = id ?: Integer.MAX_VALUE,
        name = name ?: "",
        link = link ?: "",
        abbreviation = abbreviation ?: "",
        teamName = teamName ?: "",
        locationName = locationName ?: "",
        fistYearOfPlay = firstYearOfPlay ?: ""
    )
}





