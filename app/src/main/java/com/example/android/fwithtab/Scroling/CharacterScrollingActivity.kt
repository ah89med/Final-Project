package com.example.android.fwithtab.Scroling

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.android.fwithtab.*
import com.example.android.fwithtab.EX.Consts
import kotlinx.android.synthetic.main.activity_character_scrolling.*
import kotlinx.android.synthetic.main.activity_manga_scrolling.*
import kotlinx.android.synthetic.main.content_character_scrolling.*
import kotlinx.android.synthetic.main.content_manga_scrolling.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_scrolling)
        setSupportActionBar(characterToolbar)



        val id = intent.getStringExtra(Consts.ID)


        loadCharacterData(id)


    }

    private fun loadCharacterData(id: String?) {

        id?.let { id ->

            val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val characterInterface = retrofit.create(Interface::class.java)

            characterInterface.getCharacterInfo(id)
                .enqueue(object : Callback<CharacterClass> {
                    override fun onFailure(call: Call<CharacterClass>, t: Throwable) {
                        Toast.makeText(this@CharacterScrollingActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<CharacterClass>, response: Response<CharacterClass>) {

                        response.body()?.let {
                            fillInfo(it)

                        }

                    }

                })

        }

    }

    private fun fillInfo(character: CharacterClass) {
        Toast.makeText(this, "Api connected", Toast.LENGTH_LONG).show()

        ctoolbar_layout.title = character.name
        cdetails.text = character.url

        cposterImageView.setImageFromUrl(character.imageUrl)

        if (character.url == "N/A")
            mfab.visibility = View.INVISIBLE
        else
            cfab.setOnClickListener { view ->

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(character.url))
                startActivity(intent)

            }


    }
}

