package com.example.bogoradova3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bogoradova3.models.RecyclerList
import com.example.bogoradova3.network.RetroInstance
import com.example.bogoradova3.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    var recyclerListLiveData : MutableLiveData<RecyclerList>


    init{
        recyclerListLiveData = MutableLiveData()

    }
    fun getRecyclerListObserver(): MutableLiveData<RecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {

        viewModelScope.launch(Dispatchers.IO) {
          val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
          val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)

        }
    }
}