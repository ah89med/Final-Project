package com.example.android.fwithtab
import com.google.gson.annotations.SerializedName


data class CharacterClass(

    @SerializedName("mal_id")
    var malId: String = "", // 40491
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/character/40491/Arthur_Milligan
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/characters/9/110362.jpg?s=794a78069b47e2405e32f159b6fae82b
    @SerializedName("name")
    var name: String = "", // Milligan, Arthur
    @SerializedName("alternative_names")
    var alternativeNames: List<Any> = listOf(),
    @SerializedName("anime")
    var anime: List<Anime> = listOf(),
    @SerializedName("manga")
    var manga: List<Any> = listOf()
)

