package com.example.roomdatabase20022023.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase20022023.R
import com.example.roomdatabase20022023.data.local.entity.Priority
import com.example.roomdatabase20022023.data.local.entity.WorkEntity
import com.example.roomdatabase20022023.data.repository.WorkRepository
import com.example.roomdatabase20022023.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var workRepository: WorkRepository
    private var listPriority: List<Priority>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workRepository = WorkRepository(this)
        mainViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainViewModel(workRepository) as T
            }
        })[MainViewModel::class.java]

//        mainViewModel.getListPriorityLiveData().observe(this, object : Observer<List<Priority>> {
//            override fun onChanged(listPriority: List<Priority>?) {
//                this@MainActivity.listPriority = listPriority
//            }
//        })
//
//        mainViewModel.getPriority()

//        CoroutineScope(Dispatchers.IO).launch {
//            delay(500)
//            mainViewModel.addWork(WorkEntity(null, "Do something 1", System.currentTimeMillis(), listPriority?.get(0)?.id ?: 0))
//        }

        mainViewModel.getListWorkLiveData().observe(this, object : Observer<List<WorkEntity>> {
            override fun onChanged(listWork: List<WorkEntity>?) {
                if (!listWork.isNullOrEmpty()) {
                    for (work in listWork) {
                        Log.d("BBB", work.toString())
                    }
                }
            }
        })

        mainViewModel.getWorks()
    }
}
