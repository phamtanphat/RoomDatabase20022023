package com.example.roomdatabase20022023.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.roomdatabase20022023.util.PriorityEnum

/**
 * Created by pphat on 5/17/2023.
 */
@Entity(tableName = "priority")
data class Priority(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @TypeConverters(PriorityEnum::class)
    @ColumnInfo(name = "name")
    val priorityEnum: PriorityEnum
)
