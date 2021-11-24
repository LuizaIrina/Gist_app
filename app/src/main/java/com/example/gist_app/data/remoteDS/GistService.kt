package com.example.gist_app.data.remoteDS

import com.example.gist_app.data.remoteDS.Gist
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GistService {
    @GET("gists")
    fun listingGists(): Observable<List<Gist>>

    @GET("gists/{gist_id}")
    fun detailingGists(@Path("gist_id") id: String): Observable<Gist>

}