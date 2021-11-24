package com.example.gist_app.data.localDS

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(GistFav::class), version = 1, exportSchema = false)
public abstract class GistFavRoomDatabase : RoomDatabase() {
     abstract fun gistFavDao(): GistFavDao

     companion object {
          // Singleton prevents multiple instances of database opening at the
          // same time.
          @Volatile
          private var INSTANCE: GistFavRoomDatabase? = null

          fun getDatabase(context: Context): GistFavRoomDatabase {
               // if the INSTANCE is not null, then return it,
               // if it is, then create the database
               return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                         context.applicationContext,
                         GistFavRoomDatabase::class.java,
                         "favorites_database"
                    ).build()
                    INSTANCE = instance
                    // return instance
                    instance
               }
          }
     }
}
