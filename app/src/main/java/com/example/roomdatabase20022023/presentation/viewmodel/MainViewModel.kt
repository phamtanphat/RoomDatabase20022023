package com.example.roomdatabase20022023.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase20022023.data.local.entity.Priority
import com.example.roomdatabase20022023.data.local.entity.WorkEntity
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
    private var mutableLiveDataListWork: MutableLiveData<List<WorkEntity>> = MutableLiveData()

    fun getListPriorityLiveData(): LiveData<List<Priority>> {
        return mutableLiveDataListPriority
    }

    fun getListWorkLiveData(): LiveData<List<WorkEntity>> {
        return mutableLiveDataListWork
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

    fun addWork(workEntity: WorkEntity) {
        coroutineScope.launch {
            workRepository.addWork(workEntity)
        }
    }

    fun getWorks() {
        coroutineScope.launch {
            try {
                val result = async { workRepository.getWorks() }
                val listWork = result.await()
                withContext(Dispatchers.Main) {
                    mutableLiveDataListWork.value = listWork
                }
            } catch (e: java.lang.Exception) {
                Log.d("BBB", e.toString())
            }
        }
    }
}
