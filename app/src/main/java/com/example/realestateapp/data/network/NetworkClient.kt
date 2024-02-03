package com.example.realestateapp.data.network

interface NetworkClient {
    suspend fun doRequest(): Response
}