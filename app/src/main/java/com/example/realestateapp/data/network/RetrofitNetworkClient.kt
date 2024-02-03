package com.example.realestateapp.data.network

import com.example.realestateapp.data.api.RealEstateApi
import com.example.realestateapp.data.dto.RealEstateResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitNetworkClient(
    private val Service: RealEstateApi,
) : NetworkClient {
    override suspend fun doRequest(): Response {

        return withContext(Dispatchers.IO) {
            val response = RealEstateResponse(Service.getRealEstate())
            try {
                response.apply { resultCode = 200 }
            } catch (e: Throwable) {
                Response().apply { resultCode = 500 }
            }
        }
    }
}

