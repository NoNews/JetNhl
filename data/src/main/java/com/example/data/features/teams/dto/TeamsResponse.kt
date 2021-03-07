package com.example.data.features.teams.dto

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @SerializedName("teams")
    val teams: List<TeamDto>
)