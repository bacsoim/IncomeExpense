package com.example.incomeexpense.data

data class BudgetItem(
    var name: String,
    var value: Number,
    var selectedItemPosition: Int,
    var expense_type: Boolean,
    var income_type: Boolean
)
