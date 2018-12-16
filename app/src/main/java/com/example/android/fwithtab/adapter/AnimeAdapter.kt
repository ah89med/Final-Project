package com.example.android.fwithtab.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.fwithtab.Anime
import com.example.android.fwithtab.Scroling.AnimeDetailsActivity
import com.example.android.fwithtab.EX.Consts
import com.example.android.fwithtab.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_anime.view.*


class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    val animeList: List<Anime>

    constructor(animeList: List<Anime>) {
        this.animeList = animeList

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {

        holder.setAnime(animeList[position])
    }

    inner class AnimeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
       // val view: View


//        constructor(view: View) : super(view) {
//
//            this.view = view
//            this.view.setOnClickListener {
//                val anime = animeList[layoutPosition]
//                val url = anime.url
//
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//
//                it.context.startActivity(intent)
//            }
//
//        }


        init {

            view.setOnClickListener {
                val id = animeList[layoutPosition].malId

                val intent = Intent(it.context, AnimeDetailsActivity::class.java)
                intent.putExtra(Consts.ID, id)
                it.context.startActivity(intent)

            }

        }




        fun setAnime(anime: Anime) {
            view.aaa.text = anime.title
            view.ddd.text = anime.synopsis
            Picasso.get().load(anime.imageUrl).into(view.animeImageView)
        }
    }


}