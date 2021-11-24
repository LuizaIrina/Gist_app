package com.example.gist_app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gist_app.R
import com.example.gist_app.data.localDS.GistFavRoomDatabase

class ListFavoritiesActivity : AppCompatActivity() {
    private lateinit var rvFavList: RecyclerView
    private lateinit var adapterFavList: FavsListAdapter

    private val viewModel = ListFavoritiesActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_favorities)

        rvFavList = findViewById(R.id.RvFavsList)
        adapterFavList = FavsListAdapter(this)
        rvFavList.adapter = adapterFavList
        rvFavList.layoutManager = LinearLayoutManager(this)

        var dataBaseInstance = GistFavRoomDatabase.getDatabase(this)
        viewModel.setInstanceOfDb(dataBaseInstance)

        viewModel.getFavsData()
        setupObserveFav()

    }
    fun setupObserveFav() {
        viewModel.favsLiveData.observe(this,
            { resposta ->
                resposta?.let {
                    adapterFavList.dataset.addAll(it)
                    adapterFavList.notifyDataSetChanged()
                }
            }
        )
    }
}