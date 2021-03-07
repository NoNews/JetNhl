package com.example.data.features.teams

import com.example.data.features.teams.dto.TeamsResponse
import retrofit2.http.GET

interface TeamsService {

    @GET("/api/v1/teams")
    suspend fun getAllTeams(): TeamsResponse
}