package com.example.android.fwithtab.Scroling

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.android.fwithtab.*
import com.example.android.fwithtab.EX.Consts
import kotlinx.android.synthetic.main.activity_anime_details.*
import kotlinx.android.synthetic.main.content_anime_detailss.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_details)
        setSupportActionBar(toolbar)

        val id = intent.getStringExtra(Consts.ID)


        loadAnimeData(id)


    }

    private fun loadAnimeData(id: String?) {

        id?.let { id ->

            val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val animeInterface = retrofit.create(Interface::class.java)

            animeInterface.getAnimeInfo(id)
                .enqueue(object : Callback<Anime> {
                    override fun onFailure(call: Call<Anime>, t: Throwable) {
                        Toast.makeText(this@AnimeDetailsActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Anime>, response: Response<Anime>) {

                        response.body()?.let {
                            fillInfo(it)
                        }

                    }

                })

        }

    }

    private fun fillInfo(anime: Anime) {
        Toast.makeText(this, "Api connected", Toast.LENGTH_LONG).show()

        toolbar_layout.title = anime.title
        details.text = anime.synopsis

        posterImageView.setImageFromUrl(anime.imageUrl)

        if (anime.url == "N/A")
            fab.visibility = View.INVISIBLE
        else
            fab.setOnClickListener { view ->

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(anime.url))
                startActivity(intent)

            }


    }
}
