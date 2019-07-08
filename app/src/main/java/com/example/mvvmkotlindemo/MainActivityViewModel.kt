package com.example.mvvmkotlindemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlindemo.model.NicePlace
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel(){
     var mNicePlace : MutableLiveData<List<NicePlace>>? = null
   // lateinit  var mnice : NicePlaceRepository

    init {
       // mnice = NicePlaceRepository
       // mNicePlace = mnice.getPlaces()

    }

    fun getData() : LiveData<List<NicePlace>>
    {
        if (mNicePlace == null)
        {
            mNicePlace = MutableLiveData()
            loadData()
       }
        return mNicePlace as MutableLiveData<List<NicePlace>>
    }


    fun loadData()
    {
        val reterfit : Retrofit = Retrofit.Builder().baseUrl("https://simplifiedcoding.net/demos/").addConverterFactory(GsonConverterFactory.create()).build()
        val api = reterfit.create(Urls::class.java)
        val call = api.getHeroes()

        call.enqueue(object : Callback<List<NicePlace>>{
            override fun onFailure(call: Call<List<NicePlace>>, t: Throwable) {
              t.printStackTrace()
            }

            override fun onResponse(call: Call<List<NicePlace>>, response: Response<List<NicePlace>>) {
                mNicePlace!!.value = response.body()
            }

        })
    }

}



