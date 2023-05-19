package com.example.roomdatabase20022023.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase20022023.data.local.entity.Priority
import com.example.roomdatabase20022023.data.local.entity.WorkEntity

/**
 * Created by pphat on 5/17/2023.
 */

@Dao
interface AppDao {

    @Query("SELECT * FROM work")
    suspend fun getListWorks(): List<WorkEntity>

    @Insert(entity = WorkEntity::class)
    suspend fun addWorks(workEntity: WorkEntity)

    @Insert(entity = Priority::class)
    suspend fun addPriority(priority: Priority): Long

    @Query("SELECT * FROM priority")
    suspend fun getPriority(): List<Priority>
}
