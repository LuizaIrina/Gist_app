package com.example.gist_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gist_app.data.localDS.GistFav
import com.example.gist_app.data.localDS.GistFavRoomDatabase
import com.example.gist_app.data.remoteDS.Gist
import com.example.gist_app.data.remoteDS.NetworkGist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListFavoritiesActivityViewModel : ViewModel() {

    //QUEM VÊ É A VIEWMODEL
    private val _favsLiveData = MutableLiveData<List<GistFav>>()
    //QUEM VÊ É A ACTIVITY
    val favsLiveData : LiveData<List<GistFav>> = _favsLiveData
    //var favsList = MutableLiveData<List<GistFav>>()

    private var dataBaseInstance: GistFavRoomDatabase ?= null
    fun setInstanceOfDb(dataBaseInstance: GistFavRoomDatabase) {
        this.dataBaseInstance = dataBaseInstance
    }
    fun getFavsData(){
        dataBaseInstance?.gistFavDao()?.getAllFavGist()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
                if(!it.isNullOrEmpty()){
                    _favsLiveData.postValue(it)
                }else{
                    _favsLiveData.postValue(listOf())
                }
            },{
            })
    }
}