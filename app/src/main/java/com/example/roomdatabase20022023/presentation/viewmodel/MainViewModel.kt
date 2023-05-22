package com.example.roomdatabase20022023.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase20022023.data.local.entity.Priority
import com.example.roomdatabase20022023.data.repository.WorkRepository
import kotlinx.coroutines.*

/**
 * Created by pphat on 5/22/2023.
 */
class MainViewModel(
    private var workRepository: WorkRepository
) : ViewModel() {
    private val viewModelJob = Job()
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO + viewModelJob)
    private var mutableLiveDataListPriority: MutableLiveData<List<Priority>> = MutableLiveData()

    fun getListPriorityLiveData(): LiveData<List<Priority>> {
        return mutableLiveDataListPriority
    }

    fun addPriority() {
        coroutineScope.launch {
            workRepository.insertPriority()
        }
    }

    fun getPriority() {
        coroutineScope.launch {
            try {
                val result = async { workRepository.getPriority() }
                val listPriority = result.await()
                withContext(Dispatchers.Main) {
                    mutableLiveDataListPriority.value = listPriority
                }
            } catch (e: java.lang.Exception) {
                Log.d("BBB", e.toString())
            }
        }
    }
}
