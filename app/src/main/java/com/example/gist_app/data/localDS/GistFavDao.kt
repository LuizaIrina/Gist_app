package com.example.gist_app.data.localDS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface GistFavDao {
    @Query("SELECT * FROM gistfav_table")
    fun getAllFavGist(): Single<List<GistFav>>

    @Insert
    fun insertFavGist(favgist: GistFav) : Completable

    @Delete
    fun deleteFavGist(favgist: GistFav) : Completable

    //@Query("DELETE FROM gistfav_table")
    //fun deleteFavGist(favgist: GistFav)
}