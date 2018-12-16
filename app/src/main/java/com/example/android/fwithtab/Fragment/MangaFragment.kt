package com.example.android.fwithtab.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android.fwithtab.*
import com.example.android.fwithtab.EX.Consts
import com.example.android.fwithtab.EX.setTextChangedListener
import com.example.android.fwithtab.SearchResponse.MangaSearchResponse
import com.example.android.fwithtab.adapter.MangaAdapter
import kotlinx.android.synthetic.main.fragment_anime.*
import kotlinx.android.synthetic.main.fragment_manga.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MangaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mangaEditText.setTextChangedListener{
            search(it)

        }
    }
    private fun search(searchQuery: String) {


        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val animeInterace = retrofit.create(Interface::class.java)

        animeInterace.searchManga(searchQuery)
            .enqueue(object : Callback<MangaSearchResponse> {
                override fun onFailure(call: Call<MangaSearchResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<MangaSearchResponse>, response: Response<MangaSearchResponse>) {
                    response.body()?.results?.let {
                        prepareRecyclerView(it)
                    }
                }

            })

    }

    private fun prepareRecyclerView(mangaList: List<Manga>) {
        mangaRecyclerView.layoutManager = GridLayoutManager(activity,2)
        mangaRecyclerView.adapter = MangaAdapter(mangaList)
    }
}

