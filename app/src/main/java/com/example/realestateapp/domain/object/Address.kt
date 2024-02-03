package com.example.realestateapp.domain.`object`

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val id: Int,
    val city: String,
    val street: String,
    val houseNumber: String,
    val flatNumber: Int
) : Parcelable