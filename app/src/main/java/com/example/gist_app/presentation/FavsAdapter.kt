package com.example.gist_app.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gist_app.R
import com.example.gist_app.data.localDS.GistFav

public class FavsAdapter (var context: Context, var dataset: MutableList<GistFav> = mutableListOf()) : RecyclerView.Adapter<FavsAdapter.FavsViewHolder>() {

        inner class FavsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val favUserName: TextView = view.findViewById(R.id.textNameFavsTeste)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavsViewHolder =
            FavsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.favs_item_teste, parent, false)
            )

        override fun onBindViewHolder(holder: FavsViewHolder, position: Int) {
            holder.favUserName.text = dataset[position].filename

            //holder.gistArType.text = dataset[position].files.map { file -> file.value.type }.toString()


        }

        override fun getItemCount(): Int {
            return dataset.size
        }
    }
