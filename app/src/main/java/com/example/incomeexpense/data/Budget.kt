package com.example.incomeexpense.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget")
data class Budget(
    @PrimaryKey(autoGenerate = true) var val rowId: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "value") var value: Number,
    @ColumnInfo(name="type income") var income_type: Boolean,
    @ColumnInfo(name="type expense") var expense_type: Boolean
)