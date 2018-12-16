package com.example.android.fwithtab.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.android.fwithtab.Scroling.MangaScrollingActivity
import com.example.android.fwithtab.EX.Consts
import com.example.android.fwithtab.Manga
import com.example.android.fwithtab.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_manga.view.*

class MangaAdapter : RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {
    val mangalist: List<Manga>

    constructor(mangalist: List<Manga>) {
        this.mangalist = mangalist

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_manga, parent, false)
        return MangaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mangalist.size
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {

        holder.setManga(mangalist[position])
    }

    inner class MangaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {

            view.setOnClickListener {
                val id = mangalist[layoutPosition].malId

                val intent = Intent(it.context, MangaScrollingActivity::class.java)
                intent.putExtra(Consts.ID, id)
                it.context.startActivity(intent)

            }

        }





        fun setManga(manga: Manga) {
            view.titleTextView.text = manga.title
         //   view.ddd.text = manga.synopsis
            Picasso.get().load(manga.imageUrl).into(view.mangaImageView)
        }
    }


}