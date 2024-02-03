package com.example.realestateapp.data.RealEstate.impl

import com.example.realestateapp.data.RealEstate.RealEstateRepository
import com.example.realestateapp.data.dto.RealEstateResponse
import com.example.realestateapp.data.network.NetworkClient
import com.example.realestateapp.data.network.Resource
import com.example.realestateapp.domain.ErrorType
import com.example.realestateapp.domain.model.PropertyResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RealEstateRepositoryImpl(private val networkClient: NetworkClient): RealEstateRepository {
    override fun getRealEstate(): Flow<Resource<List<PropertyResponse>>> = flow {
        try {
            val response = networkClient.doRequest()
            when (response.resultCode) {
                -1 -> {
                    emit(Resource.Error(ErrorType.CONNECTION_ERROR))
                }
                200 -> {
                    val partsList = (response as RealEstateResponse).results
                    emit(Resource.Success(partsList))
                }
                else -> {
                    emit(Resource.Error(ErrorType.CONNECTION_ERROR))
                }
            }
        } catch (error: Error) {
            throw Exception(error)
        }
    }
}