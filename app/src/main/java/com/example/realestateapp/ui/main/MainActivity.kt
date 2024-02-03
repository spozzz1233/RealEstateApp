package com.example.realestateapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.realestateapp.R
import com.example.realestateapp.databinding.ActivityMainBinding
import com.example.realestateapp.ui.Item.ItemActivity
import com.example.realestateapp.ui.cart.CartActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getRealEstate()
        viewModel.searchResultsListLiveData.observe(this, Observer { tracks ->
            adapter.setItems(tracks)

        })
        binding.button2.setOnClickListener{
            val intent = Intent(this@MainActivity, CartActivity::class.java)
            startActivity(intent)
        }
        initial()
    }

    private fun initial() {
        val recyclerView = binding.recyclerViewHome
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = MainAdapter(clickListener = { realestate ->
            val bundle = Bundle()
            bundle.putParcelable("realestate", realestate)
            val intent = Intent(this@MainActivity, ItemActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}