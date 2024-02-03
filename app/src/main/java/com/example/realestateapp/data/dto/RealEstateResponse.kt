package com.example.realestateapp.data.dto

import com.example.realestateapp.data.network.Response
import com.example.realestateapp.domain.model.PropertyResponse

class RealEstateResponse(val results: List<PropertyResponse>): Response()
