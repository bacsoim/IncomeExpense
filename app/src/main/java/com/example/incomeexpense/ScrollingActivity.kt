package com.example.incomeexpense

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.incomeexpense.adapter.BudgetAdapter
import com.example.incomeexpense.data.BudgetItem
import com.example.incomeexpense.databinding.ActivityScrollingBinding
import com.example.incomeexpense.dialog.BudgetItemDialog

class ScrollingActivity : AppCompatActivity(), BudgetItemDialog.BudgetItemDialogHandler {

    lateinit var binding: ActivityScrollingBinding
    private lateinit var adapter: BudgetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = title

        adapter = BudgetAdapter(this, mutableListOf<BudgetItem>())
        binding.recyclerShopping.adapter = adapter

        binding.fab.setOnClickListener { view ->
            BudgetItemDialog().show(supportFragmentManager, "TAG_SHOP_DIALOG")
        }
    }

    override fun budgetItemCreated(item: BudgetItem) {
        adapter.addItem(item)
    }


    }




}