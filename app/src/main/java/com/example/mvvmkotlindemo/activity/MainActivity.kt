package com.example.mvvmkotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmkotlindemo.MainActivityViewModel
import com.example.mvvmkotlindemo.R
import com.example.mvvmkotlindemo.adapter.RecyclerviewAdap
import com.example.mvvmkotlindemo.model.NicePlace
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    var madapter : RecyclerviewAdap? = null
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this@MainActivity,3)

        showProgressBar()
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        val livedata : LiveData<List<NicePlace>> = mainActivityViewModel.getData()
        livedata.observe(this, Observer {
            madapter = RecyclerviewAdap(it,this@MainActivity)
            recyclerView.adapter =  madapter
            hideProgressBar()
        })
    }

    fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }
}
