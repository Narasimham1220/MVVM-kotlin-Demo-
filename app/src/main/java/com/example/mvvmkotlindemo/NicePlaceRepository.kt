package com.example.mvvmkotlindemo

import androidx.lifecycle.MutableLiveData
import com.example.mvvmkotlindemo.model.NicePlace

object NicePlaceRepository {

    var mlist =  ArrayList<NicePlace>()

    fun getPlaces() : MutableLiveData<List<NicePlace>>
    {
        setplaces()
        val data  = MutableLiveData<List<NicePlace>>()
        data.value = mlist
        return  data
    }

    fun setplaces(){
        mlist.add(NicePlace("simham","snda"))
        mlist.add(NicePlace("simham","snda"))
        mlist.add(NicePlace("simham","snda"))
        mlist.add(NicePlace("simham","snda"))
        mlist.add(NicePlace("simham","snda"))
        mlist.add(NicePlace("simham","snda"))
        mlist.add(NicePlace("simham","snda"))
        mlist.add(NicePlace("simham","snda"))
    }
}