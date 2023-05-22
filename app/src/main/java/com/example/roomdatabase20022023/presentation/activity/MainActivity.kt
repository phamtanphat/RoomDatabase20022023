package com.example.roomdatabase20022023.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase20022023.R
import com.example.roomdatabase20022023.data.local.entity.Priority
import com.example.roomdatabase20022023.data.repository.WorkRepository
import com.example.roomdatabase20022023.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var workRepository: WorkRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workRepository = WorkRepository(this)
        mainViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainViewModel(workRepository) as T
            }
        })[MainViewModel::class.java]

        mainViewModel.getListPriorityLiveData().observe(this, object : Observer<List<Priority>> {
            override fun onChanged(listPriority: List<Priority>?) {
                if (!listPriority.isNullOrEmpty()) {
                    for (priority in listPriority) {
                        Log.d("BBB", priority.toString())
                    }
                }
            }

        })

        mainViewModel.getPriority()
    }
}
