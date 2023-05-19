package com.example.roomdatabase20022023.util

import androidx.room.TypeConverter

/**
 * Created by pphat on 5/19/2023.
 */
class PriorityConverter {

    @TypeConverter
    fun toPriority(value: Int) = enumValues<PriorityEnum>()[value]

    @TypeConverter
    fun fromPriority(value: PriorityEnum) = value.ordinal
}
