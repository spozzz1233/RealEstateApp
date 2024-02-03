package com.example.realestateapp.domain.model

import android.os.Parcelable
import com.example.realestateapp.domain.`object`.Address
import kotlinx.parcelize.Parcelize


@Parcelize
data class PropertyResponse(
    val address: Address,
    val price: Int,
    val typeOfEstate: String
): Parcelable

var property = ArrayList<PropertyResponse>()

var cart = ArrayList<PropertyResponse>()