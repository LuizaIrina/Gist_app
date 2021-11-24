package com.example.gist_app.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gist_app.R

class MainActivity : AppCompatActivity() {

    private lateinit var gistsAdapter: GistsAdapter
    private lateinit var rvGistsList: RecyclerView

    private lateinit var btnFavGistList: Button

    private val viewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFavGistList = findViewById(R.id.btnFavsList)

        rvGistsList = findViewById(R.id.RvListGists)
        gistsAdapter = GistsAdapter(this)
        rvGistsList.adapter = gistsAdapter
        rvGistsList.layoutManager = LinearLayoutManager(this)

        viewModel.getGists()
        setupObserveGistsList()

        //funcao do botao de chamada da tela3
        btnFavGistList.setOnClickListener{
            val intent = Intent(this, ListFavoritiesActivity::class.java)
            this.startActivity(intent)
        }

    }

    fun setupObserveGistsList() {
        viewModel.gistsLiveData.observe(this,
            { resposta ->
                resposta?.let {
                    gistsAdapter.dataset.addAll(it)
                    gistsAdapter.notifyDataSetChanged()
                }
            }
        )
    }


}