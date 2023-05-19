package com.example.roomdatabase20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdatabase20022023.data.local.AppDatabase
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val appDao = AppDatabase.createDatabase(this@MainActivity)?.appDao()
//            val listWorks = appDao?.getListWorks()
//            Log.d("BBB", listWorks?.size.toString())
//            appDao?.addWorks(WorkEntity(0, "Do something", System.currentTimeMillis(), Priority(0, PriorityEnum.LOW)))

            val result = async { appDao?.getPriority() }
            withContext(Dispatchers.Main) {
               Toast.makeText(this@MainActivity,  result.await()?.size.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
