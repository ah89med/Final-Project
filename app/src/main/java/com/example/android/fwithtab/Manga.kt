package com.example.android.fwithtab

import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("mal_id")
    var malId: String = "", // 335
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/anime/335/Matantei_Loki_Ragnarok
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/anime/13/75300.jpg?s=73a332998988f64e81d4c70550b3c9f4
    @SerializedName("title")
    var title: String = "", // Matantei Loki Ragnarok
    @SerializedName("airing")
    var airing: Boolean = false, // false
    @SerializedName("synopsis")
    var synopsis: String = "", // Loki, the Norse god of mischief, has been exiled to the human world for what was apparently a bad joke. Along with being exiled, he's forced to take the form of a child. He's told the only way he can...
    @SerializedName("type")
    var type: String = "", // TV
    @SerializedName("episodes")
    var episodes: Int = 0, // 26
    @SerializedName("score")
    var score: Double = 0.0, // 7.38
    @SerializedName("start_date")
    var startDate: String = "", // 2003-04-05T00:00:00+00:00
    @SerializedName("end_date")
    var endDate: String = "", // 2003-09-27T00:00:00+00:00
    @SerializedName("members")
    var members: Int = 0, // 29561
    @SerializedName("rated")
    var rated: String = "" // PG-13
)