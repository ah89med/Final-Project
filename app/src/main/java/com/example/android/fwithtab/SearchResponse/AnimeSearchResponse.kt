package com.example.android.fwithtab.SearchResponse
import com.example.android.fwithtab.Anime
import com.google.gson.annotations.SerializedName


data class AnimeSearchResponse(

    @SerializedName("results")
    var results: List<Anime> = listOf()
)


