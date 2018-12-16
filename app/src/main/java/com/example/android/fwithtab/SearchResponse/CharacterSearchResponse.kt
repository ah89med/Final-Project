package com.example.android.fwithtab.SearchResponse

import com.example.android.fwithtab.CharacterClass
import com.google.gson.annotations.SerializedName




data class CharacterSearchResponse(

    @SerializedName("results")
    var results: List<CharacterClass> = listOf()

)



