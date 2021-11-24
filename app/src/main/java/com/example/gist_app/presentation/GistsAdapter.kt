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

const val CHOOSED_GIST_ID = "com.example.desafionetshoes.ID"

public class GistsAdapter(var context: Context, var dataset: MutableList<Gist> = mutableListOf()) : RecyclerView.Adapter<GistsAdapter.GistsViewHolder>() {
//public class GistsAdapter(var context: Context, var dataset: MutableList<GistsList> = mutableListOf()) : RecyclerView.Adapter<GistsAdapter.GistsViewHolder>() {
    inner class GistsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gistUserName: TextView = view.findViewById(R.id.TxtGusrName)
        val gistArType: TextView = view.findViewById(R.id.TxtGtype)
        val btnFavorite: ToggleButton = view.findViewById(R.id.BtnFavorite)
        val gistUserPhoto: ImageButton = view.findViewById(R.id.ImbGusrPhoto)
        //val idMovie: TextView = view.findViewById(R.id.idMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistsViewHolder =
        GistsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.gist_item, parent, false)
        )

    override fun onBindViewHolder(holder: GistsViewHolder, position: Int) {
        holder.gistUserName.text = dataset[position].owner.login
        holder.gistUserPhoto.load(dataset[position].owner.avatar_url)
        holder.gistArType.text = dataset[position].files.map { file -> file.value.type }.toString()

        // button toggle
        holder.btnFavorite.setOnCheckedChangeListener(){ _, isChecked ->
            if (isChecked) {
                holder.btnFavorite.setBackgroundResource(R.drawable.baseline_star_20)
                //chamo a funcao de favoritar o gist e mudo o atributo booleano
                Toast.makeText(context,"favoritou", Toast.LENGTH_LONG).show()
                //Textoteste.text = "favoritou"

            } else {
                holder.btnFavorite.setBackgroundResource(R.drawable.baseline_star_border_20)
                //verifico o atributo booleano, se estiver true chamo a funcao de desfavoritar e mudo para false
                Toast.makeText(context,"desfavoritou", Toast.LENGTH_LONG).show()
                //Textoteste.text = "desfavoritou"
            }
        }

        // button 2activity
        holder.gistUserPhoto.setOnClickListener{
            val intent = Intent(context, DetailGistActivity::class.java).apply{
                putExtra(CHOOSED_GIST_ID,dataset[position].id.toString())
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}