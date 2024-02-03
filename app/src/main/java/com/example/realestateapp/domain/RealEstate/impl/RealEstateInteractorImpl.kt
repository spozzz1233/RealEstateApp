package com.example.realestateapp.domain.RealEstate.impl

import com.example.realestateapp.data.RealEstate.RealEstateRepository
import com.example.realestateapp.data.network.Resource
import com.example.realestateapp.domain.RealEstate.RealEstateInteractor
import com.example.realestateapp.domain.model.PropertyResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RealEstateInteractorImpl(private val repository: RealEstateRepository): RealEstateInteractor {
    override fun getRealEstate(): Flow<Resource<List<PropertyResponse>>> {
        return repository.getRealEstate().map { result ->
            when (result) {
                is Resource.Success -> {
                    (Resource.Success(result.data))
                }
                is Resource.Error<*> -> {
                    Resource.Error(result.message, null)
                }
            } as Resource<List<PropertyResponse>>
        }
    }
}