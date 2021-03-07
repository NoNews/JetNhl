package com.example.data.features.teams.dto

import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("abbreviation")
    val abbreviation: String?,
    @SerializedName("teamName")
    val teamName: String?,
    @SerializedName("locationName")
    val locationName: String?,
    @SerializedName("firstYearOfPlay")
    val firstYearOfPlay: String?
)
