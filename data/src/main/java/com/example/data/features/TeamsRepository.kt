package com.example.data.features

import com.example.data.core.flow.Data
import com.example.data.models.ShortTeam
import kotlinx.coroutines.flow.Flow

interface TeamsRepository {
    suspend fun observeTeams(forceReload: Boolean): Flow<Data<List<ShortTeam>>>
}