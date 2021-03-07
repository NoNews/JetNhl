package com.example.data.models

//should be in domain layer later
data class ShortTeam(
    val id: Int,
    val name: String,
    val link: String,
    val abbreviation: String,
    val teamName: String,
    val locationName: String,
    val fistYearOfPlay: String
)