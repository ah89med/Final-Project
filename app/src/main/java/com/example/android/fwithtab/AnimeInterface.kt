package com.example.android.fwithtab

import com.example.android.fwithtab.SearchResponse.AnimeSearchResponse
import com.example.android.fwithtab.SearchResponse.CharacterSearchResponse
import com.example.android.fwithtab.SearchResponse.MangaSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Interface {
    @GET("search/anime")
    fun searchAnime(@Query("q")serchQuery: String) : Call<AnimeSearchResponse>

    // https://api.jikan.moe/v3/search/anime/?q=  (after that need 3letters 4eg: nar)

    @GET("search/manga")
    fun searchManga(@Query("q")serchQuery: String) : Call<MangaSearchResponse>



    @GET("search/character")
    fun searchCharacter(@Query("q") searchQuery: String): Call<CharacterSearchResponse>



    @GET("anime/{id}/")
    fun getAnimeInfo(@Path("id") id: String): Call<Anime>

    @GET("manga/{id}/")
    fun getMangaInfo(@Path("id") id: String): Call<Manga>

    @GET("character/{id}/")
    fun getCharacterInfo(@Path("id") id: String): Call<CharacterClass>






}