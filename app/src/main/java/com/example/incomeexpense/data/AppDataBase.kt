package com.example.incomeexpense.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = arrayOf(Budget::class), version = 1)
abstract class AppDataBase:RoomDatabase(){

    abstract fun budgetDao(): BudgetDao

    companion object{
        private var INSTANCE: AppDataBase?=null

        fun getInstance(context: Context): AppDataBase{
            if (INSTANCE==null){
                INSTANCE=Room.databaseBuilder(context.getApplicationContext(
                    AppDataBase::class.java, "budget.db")
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE=null
        }

    }

}



