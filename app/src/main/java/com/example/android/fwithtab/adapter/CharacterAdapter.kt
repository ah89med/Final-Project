package com.example.android.fwithtab.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.fwithtab.CharacterClass
import com.example.android.fwithtab.EX.Consts
import com.example.android.fwithtab.R
import com.example.android.fwithtab.Scroling.CharacterScrollingActivity

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    val characterList: List<CharacterClass>

    constructor(characterList: List<CharacterClass>) {
        this.characterList = characterList

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        holder.setCharacter(characterList[position])
    }

    inner class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {



        init {

            view.setOnClickListener {
                val id = characterList[layoutPosition].malId

                val intent = Intent(it.context, CharacterScrollingActivity::class.java)
                intent.putExtra(Consts.ID, id)
                it.context.startActivity(intent)

            }

        }


        fun setCharacter(character: CharacterClass) {
            view.titelTextViewCharacter.text = character.name
            //  view.ddd.text = character.synopsis
            Picasso.get().load(character.imageUrl).into(view.characterImigeView)
        }
    }


}