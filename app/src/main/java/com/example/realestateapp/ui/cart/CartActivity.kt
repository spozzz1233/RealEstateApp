package com.example.realestateapp.ui.cart

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.autorus.ui.cart.CartAdapter
import com.example.autorus.util.CartSave
import com.example.realestateapp.R
import com.example.realestateapp.databinding.ActivityCartBinding
import com.example.realestateapp.databinding.ActivityItemBinding
import com.example.realestateapp.domain.model.cart
import com.example.realestateapp.ui.Item.ItemActivity

class CartActivity : AppCompatActivity() {

    private lateinit var cartHistory: CartSave
    lateinit var binding: ActivityCartBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        binding = ActivityCartBinding.inflate(layoutInflater)

        setContentView(binding.root)
        cartHistory = CartSave(this)
        cartHistory.getHistoryCart()
        initial()
        checkCart()
        binding.clear.setOnClickListener {
            cartHistory.clearSharedPreferences()
            cartAdapter.updateData()
            checkCart()
        }
        binding.back.setOnClickListener{
            finish()
        }

    }
    private fun initial() {
        cartAdapter = CartAdapter(clickListener = { realestate ->
            val bundle = Bundle()
            bundle.putParcelable("realestate", realestate)
            val intent = Intent(this@CartActivity, ItemActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })
        binding.recyclerViewHome.adapter = cartAdapter

    }
    fun checkCart(){
        if(cart.isEmpty()){
            binding.placeholder.visibility = View.VISIBLE
            binding.price.visibility = View.GONE
            binding.clear.visibility = View.GONE
            binding.recyclerViewHome.visibility = View.GONE
        }else{
            binding.placeholder.visibility = View.GONE
            binding.price.visibility = View.VISIBLE
            binding.clear.visibility = View.VISIBLE
            binding.recyclerViewHome.visibility = View.VISIBLE
        }
    }
}