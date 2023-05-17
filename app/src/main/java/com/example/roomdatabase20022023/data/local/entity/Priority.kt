package com.example.roomdatabase20022023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by pphat on 5/17/2023.
 */
@Entity(tableName = "priority")
data class Priority(
    @PrimaryKey val id: Int,
    var name: String,
    var level: Int
)
