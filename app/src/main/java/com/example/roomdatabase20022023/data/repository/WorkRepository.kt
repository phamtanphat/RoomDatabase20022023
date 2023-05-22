package com.example.roomdatabase20022023.data.repository

import android.content.Context
import com.example.roomdatabase20022023.data.local.AppDao
import com.example.roomdatabase20022023.data.local.AppDatabase
import com.example.roomdatabase20022023.data.local.entity.Priority
import com.example.roomdatabase20022023.data.local.entity.WorkEntity

/**
 * Created by pphat on 5/22/2023.
 */
class WorkRepository(var context: Context) {
    private var appDao: AppDao? = AppDatabase.createDatabase(context)?.appDao()

    suspend fun insertPriority() {
        val listPriority = Priority.getDataMock()
        appDao?.addPriority(listPriority)
    }

    suspend fun getPriority(): List<Priority>? {
        return appDao?.getPriority()
    }

    suspend fun addWork(workEntity: WorkEntity) {
        appDao?.addWorks(workEntity)
    }

    suspend fun getWorks() : List<WorkEntity>? {
        return appDao?.getListWorks()
    }
}
