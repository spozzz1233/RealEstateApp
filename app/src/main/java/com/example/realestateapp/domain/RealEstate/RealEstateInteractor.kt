package com.example.realestateapp.domain.RealEstate

import com.example.realestateapp.data.network.Resource
import com.example.realestateapp.domain.model.PropertyResponse
import kotlinx.coroutines.flow.Flow

interface RealEstateInteractor {
    fun getRealEstate(): Flow<Resource<List<PropertyResponse>>>
}