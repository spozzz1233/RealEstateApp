package com.example.realestateapp.data.api

import com.example.realestateapp.domain.model.PropertyResponse
import retrofit2.http.GET

interface RealEstateApi {
    @GET("/api/real-estate")
    suspend fun getRealEstate(): List<PropertyResponse>
}
