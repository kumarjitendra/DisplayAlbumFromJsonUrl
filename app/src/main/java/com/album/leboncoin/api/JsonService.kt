package com.album.leboncoin.api

import com.album.leboncoin.data.AlbumItem
import retrofit2.Call
import retrofit2.http.GET

interface JsonService {

    //ToDo: path : img/shared/technical-test?q=title returns json array with null values
   /* @GET("img/shared/technical-test?q=title")
    fun fetchJson(): Call<AlbumItem>*/

    @GET("/search/repositories?q=title")
    fun fetchJson(): Call<AlbumItem>
}