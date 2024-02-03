package com.example.realestateapp.data.network

import com.example.realestateapp.domain.ErrorType

sealed class Resource<T>(val data: T? = null, val message: ErrorType? = null) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: ErrorType?, data: T? = null): Resource<T>(data, message)
}