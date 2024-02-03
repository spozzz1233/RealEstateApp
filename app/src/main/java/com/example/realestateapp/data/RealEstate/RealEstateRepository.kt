package com.example.realestateapp.data.RealEstate

import com.example.realestateapp.data.network.Resource
import com.example.realestateapp.domain.model.PropertyResponse
import kotlinx.coroutines.flow.Flow

interface RealEstateRepository {
    fun getRealEstate() : Flow<Resource<List<PropertyResponse>>>
}