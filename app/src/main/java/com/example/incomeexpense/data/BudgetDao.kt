package com.example.incomeexpense.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BudgetDao{
    @Query("""SELECT * FROM description """)
    fun getAllBudget() : List<Budget>

    @Insert
    fun insertBudget(vararg budgetitems_database: Budget)

    @Delete
    fun deleteBudget(description: Budget)

    @Query("DELETE FROM description")
    fun deleteAllBudget()
}