package com.example.android.fwithtab.SearchResponse
import com.example.android.fwithtab.Manga
import com.google.gson.annotations.SerializedName


data class MangaSearchResponse(

    @SerializedName("results")
    var results: List<Manga> = listOf()

)

