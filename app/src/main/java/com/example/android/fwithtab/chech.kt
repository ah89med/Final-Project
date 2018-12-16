package com.example.android.fwithtab
import com.google.gson.annotations.SerializedName


data class check(
    @SerializedName("request_hash")
    var requestHash: String = "", // request:anime:e35e3e0b82c976e7a004df305f6a699a48fed03f
    @SerializedName("request_cached")
    var requestCached: Boolean = false, // true
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int = 0, // 35188
    @SerializedName("mal_id")
    var malId: Int = 0, // 20
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/anime/20/Naruto
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/anime/13/17405.jpg
    @SerializedName("trailer_url")
    var trailerUrl: String = "", // https://www.youtube.com/embed/j2hiC9BmJlQ?enablejsapi=1&wmode=opaque&autoplay=1
    @SerializedName("title")
    var title: String = "", // Naruto
    @SerializedName("title_english")
    var titleEnglish: String = "", // Naruto
    @SerializedName("title_japanese")
    var titleJapanese: String = "", // ナルト
    @SerializedName("title_synonyms")
    var titleSynonyms: List<String> = listOf(),
    @SerializedName("type")
    var type: String = "", // TV
    @SerializedName("source")
    var source: String = "", // Manga
    @SerializedName("episodes")
    var episodes: Int = 0, // 220
    @SerializedName("status")
    var status: String = "", // Finished Airing
    @SerializedName("airing")
    var airing: Boolean = false, // false
    @SerializedName("aired")
    var aired: Aired = Aired(),
    @SerializedName("duration")
    var duration: String = "", // 23 min per ep
    @SerializedName("rating")
    var rating: String = "", // PG-13 - Teens 13 or older
    @SerializedName("score")
    var score: Double = 0.0, // 7.89
    @SerializedName("scored_by")
    var scoredBy: Int = 0, // 701483
    @SerializedName("rank")
    var rank: Int = 0, // 714
    @SerializedName("popularity")
    var popularity: Int = 0, // 10
    @SerializedName("members")
    var members: Int = 0, // 1066567
    @SerializedName("favorites")
    var favorites: Int = 0, // 38415
    @SerializedName("synopsis")
    var synopsis: String = "", // Moments prior to Naruto Uzumaki's birth, a huge demon known as the Kyuubi, the Nine-Tailed Fox, attacked Konohagakure, the Hidden Leaf Village, and wreaked havoc. In order to put an end to the Kyuubi's rampage, the leader of the village, the Fourth Hokage, sacrificed his life and sealed the monstrous beast inside the newborn Naruto. Now, Naruto is a hyperactive and knuckle-headed ninja still living in Konohagakure. Shunned because of the Kyuubi inside him, Naruto struggles to find his place in the village, while his burning desire to become the Hokage of Konohagakure leads him not only to some great new friends, but also some deadly foes. [Written by MAL Rewrite]
    @SerializedName("background")
    var background: String = "", // Naruto received numerous awards during its airing, including the "Best Full-Length Animation Program Award" in the Third UStv Awards and the 38th "Best Animated Show" in IGN's Top 100 Animated Series.
    @SerializedName("premiered")
    var premiered: String = "", // Fall 2002
    @SerializedName("broadcast")
    var broadcast: String = "", // Thursdays at 19:30 (JST)
    @SerializedName("related")
    var related: Related = Related(),
    @SerializedName("producers")
    var producers: List<Producer> = listOf(),
    @SerializedName("licensors")
    var licensors: List<Licensor> = listOf(),
    @SerializedName("studios")
    var studios: List<Studio> = listOf(),
    @SerializedName("genres")
    var genres: List<Genre> = listOf(),
    @SerializedName("opening_themes")
    var openingThemes: List<String> = listOf(),
    @SerializedName("ending_themes")
    var endingThemes: List<String> = listOf()
)

data class Licensor(
    @SerializedName("mal_id")
    var malId: Int = 0, // 119
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Viz Media
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/producer/119/Viz_Media
)

data class Studio(
    @SerializedName("mal_id")
    var malId: Int = 0, // 1
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Studio Pierrot
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/producer/1/Studio_Pierrot
)

data class Aired(
    @SerializedName("from")
    var from: String = "", // 2002-10-03T00:00:00+00:00
    @SerializedName("to")
    var to: String = "", // 2007-02-08T00:00:00+00:00
    @SerializedName("prop")
    var prop: Prop = Prop(),
    @SerializedName("string")
    var string: String = "" // Oct 3, 2002 to Feb 8, 2007
)

data class Prop(
    @SerializedName("from")
    var from: From = From(),
    @SerializedName("to")
    var to: To = To()
)

data class To(
    @SerializedName("day")
    var day: Int = 0, // 8
    @SerializedName("month")
    var month: Int = 0, // 2
    @SerializedName("year")
    var year: Int = 0 // 2007
)

data class From(
    @SerializedName("day")
    var day: Int = 0, // 3
    @SerializedName("month")
    var month: Int = 0, // 10
    @SerializedName("year")
    var year: Int = 0 // 2002
)

data class Producer(
    @SerializedName("mal_id")
    var malId: Int = 0, // 1365
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Shueisha
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/producer/1365/Shueisha
)

data class Related(
    @SerializedName("Adaptation")
    var adaptation: List<Adaptation> = listOf(),
    @SerializedName("Side story")
    var sideStory: List<SideStory> = listOf(),
    @SerializedName("Sequel")
    var sequel: List<Sequel> = listOf(),
    @SerializedName("Alternative version")
    var alternativeVersion: List<Any> = listOf()
)

data class SideStory(
    @SerializedName("mal_id")
    var malId: Int = 0, // 7367
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Naruto: The Cross Roads
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/7367/Naruto__The_Cross_Roads
)

data class Sequel(
    @SerializedName("mal_id")
    var malId: Int = 0, // 1735
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Naruto: Shippuuden
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/1735/Naruto__Shippuuden
)

data class Adaptation(
    @SerializedName("mal_id")
    var malId: Int = 0, // 11
    @SerializedName("type")
    var type: String = "", // manga
    @SerializedName("name")
    var name: String = "", // Naruto
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/manga/11/Naruto
)

data class Genre(
    @SerializedName("mal_id")
    var malId: Int = 0, // 27
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Shounen
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/genre/27/Shounen
)