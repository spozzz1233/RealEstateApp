package com.example.realestateapp.ui.Item

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autorus.util.CartSave
import com.example.realestateapp.databinding.ActivityItemBinding
import com.example.realestateapp.domain.model.PropertyResponse
import com.example.realestateapp.domain.`object`.Address


class ItemActivity : AppCompatActivity() {

    private lateinit var cartSave: CartSave
    lateinit var binding: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val bundle = intent.extras!!
        cartSave = CartSave(this)
        val realestate = bundle.getParcelable<PropertyResponse>("realestate")
        val address = realestate?.address

        binding.back.setOnClickListener {
            finish()
        }

        binding.addCart.setOnClickListener {
            if (realestate != null) {
                cartSave.saveCartHistory(realestate)
            }
            Toast.makeText(this, "Товар добавлен в избраное", Toast.LENGTH_SHORT)
                .show()
        }
        if (realestate != null) {
            binding.partName.text = realestate.typeOfEstate
            binding.priceInt.text = realestate.price.toString() + " " + "$"
        }
        if (address != null) {
            binding.cityName.text = address.city
            binding.streetName.text = address.street
        }
    }
}