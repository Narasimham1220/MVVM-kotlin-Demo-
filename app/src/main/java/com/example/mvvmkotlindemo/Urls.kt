package com.example.mvvmkotlindemo

import com.example.mvvmkotlindemo.model.NicePlace
import retrofit2.Call
import retrofit2.http.GET



interface Urls {

    @GET("marvel")
    fun getHeroes(): Call<List<NicePlace>>
}