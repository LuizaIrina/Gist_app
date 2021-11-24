package com.example.gist_app.data.localDS

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gist_app.data.remoteDS.File
import com.example.gist_app.data.remoteDS.OwnerGit

@Entity(tableName = "gistfav_table")
class GistFav(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    //@ColumnInfo(name = "files") val files: Map<String, File>,
    @ColumnInfo(name = "filetype") val filetype: String,
    @ColumnInfo(name = "filename") val filename: String,
    //@ColumnInfo(name = "owner") val owner: OwnerGit,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "avatar_url") val avatar_url: String,
    //@ColumnInfo(name = "fav") val fav: Boolean
)
