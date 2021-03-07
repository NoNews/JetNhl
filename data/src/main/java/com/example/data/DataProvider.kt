package com.example.data

import com.example.data.core.network.NetworkClient
import com.example.data.features.TeamsRepository
import com.example.data.features.TeamsRepositoryImpl
import com.example.data.features.teams.TeamsService
import okhttp3.OkHttpClient

object DataProvider {

    val teamsRepository: TeamsRepository by lazy {
        TeamsRepositoryImpl(
            teamService = teamService
        )
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val networkClient by lazy {
        NetworkClient(okHttpClient)
    }


    private val teamService by lazy {
        networkClient.createService(TeamsService::class.java)
    }

}


