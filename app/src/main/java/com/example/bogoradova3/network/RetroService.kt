package com.example.bogoradova3.network

import android.widget.AbsListView.RecyclerListener
import com.example.bogoradova3.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query : String): RecyclerList


}