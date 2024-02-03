package com.example.realestateapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realestateapp.domain.ErrorType
import com.example.realestateapp.domain.RealEstate.RealEstateInteractor
import com.example.realestateapp.domain.model.PropertyResponse
import com.example.realestateapp.domain.model.property
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val interactor: RealEstateInteractor
) : ViewModel() {

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private val _noInternetLiveData = MutableLiveData<Boolean>()
    val noInternetLiveData: LiveData<Boolean> = _noInternetLiveData

    private val _searchResultsListLiveData = MutableLiveData<ArrayList<PropertyResponse>>()
    val searchResultsListLiveData: LiveData<ArrayList<PropertyResponse>> =
        _searchResultsListLiveData


    fun getRealEstate() {
        _loadingLiveData.value = true
        viewModelScope.launch {
            interactor
                .getRealEstate()
                .collect {
                    when (it.message) {
                        ErrorType.CONNECTION_ERROR -> {
                            _noInternetLiveData.value = false
                        }

                        else -> {
                            processResult(it.data)
                        }
                    }
                }
        }
        _searchResultsListLiveData.value = property

    }

    fun processResult(track: List<PropertyResponse>?) {
        val realEstate = ArrayList<PropertyResponse>()
        if (track != null) {
            realEstate.addAll(track)
            _searchResultsListLiveData.value = realEstate
        }
        _loadingLiveData.value = false
        _noInternetLiveData.value = true

    }

}

