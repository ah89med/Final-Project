package com.example.android.fwithtab.Scroling

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.android.fwithtab.EX.Consts
import com.example.android.fwithtab.Interface
import com.example.android.fwithtab.Manga
import com.example.android.fwithtab.R

import com.example.android.fwithtab.setImageFromUrl

import kotlinx.android.synthetic.main.activity_manga_scrolling.*

import kotlinx.android.synthetic.main.content_manga_scrolling.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MangaScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_manga_scrolling)
        setSupportActionBar(mangaToolbar)



        val id = intent.getStringExtra(Consts.ID)


        loadMangaData(id)


    }

    private fun loadMangaData(id: String?) {

        id?.let { id ->

            val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val mangaInterface = retrofit.create(Interface::class.java)

            mangaInterface.getMangaInfo(id)
                .enqueue(object : Callback<Manga> {
                    override fun onFailure(call: Call<Manga>, t: Throwable) {
                        Toast.makeText(this@MangaScrollingActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Manga>, response: Response<Manga>) {

                        response.body()?.let {
                            fillInfo(it)

                        }

                    }

                })

        }

    }

    private fun fillInfo(manga: Manga) {
        Toast.makeText(this, "Api connected", Toast.LENGTH_LONG).show()

        mtoolbar_layout.title = manga.title
       mdetails.text = manga.synopsis

        mposterImageView.setImageFromUrl(manga.imageUrl)

        if (manga.url == "N/A")
            mfab.visibility = View.INVISIBLE
        else
            mfab.setOnClickListener { view ->

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(manga.url))
                startActivity(intent)

            }


    }
}
