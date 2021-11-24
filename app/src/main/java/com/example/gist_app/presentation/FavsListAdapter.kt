package com.example.gist_app.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gist_app.R
import com.example.gist_app.data.localDS.GistFav
import com.example.gist_app.data.remoteDS.Gist

public class FavsListAdapter(var context: Context, var dataset: MutableList<GistFav> = mutableListOf()) : RecyclerView.Adapter<FavsListAdapter.GistsViewHolder>() {
    //public class GistsAdapter(var context: Context, var dataset: MutableList<GistsList> = mutableListOf()) : RecyclerView.Adapter<GistsAdapter.GistsViewHolder>() {
    inner class GistsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gistUserName: TextView = view.findViewById(R.id.TxtGusrName)
        val gistArType: TextView = view.findViewById(R.id.TxtGtype)
        val btnFavorite: ToggleButton = view.findViewById(R.id.BtnFavorite)
        val gistUserPhoto: ImageButton = view.findViewById(R.id.ImbGusrPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistsViewHolder =
        GistsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.gist_item, parent, false)
        )

    override fun onBindViewHolder(holder: GistsViewHolder, position: Int) {
        holder.gistUserName.text = dataset[position].filename
        holder.gistUserPhoto.load(dataset[position].avatar_url)
        holder.gistArType.text = dataset[position].filetype

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}