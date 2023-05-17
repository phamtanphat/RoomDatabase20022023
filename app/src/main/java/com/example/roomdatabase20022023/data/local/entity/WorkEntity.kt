package com.example.roomdatabase20022023.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by pphat on 5/17/2023.
 */
@Entity(tableName = "work")
data class WorkEntity (
    @PrimaryKey val id: Int,
    var description: String,
    var time: Long,
    @ColumnInfo("id_priority") var idPriority: Int
)
