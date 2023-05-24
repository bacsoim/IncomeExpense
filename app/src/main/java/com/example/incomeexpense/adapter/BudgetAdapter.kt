package com.example.incomeexpense.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.incomeexpense.data.BudgetItem
import com.example.incomeexpense.databinding.BudgetItemBinding

class BudgetAdapter : RecyclerView.Adapter<BudgetAdapter.ViewHolder> {

    private val items = mutableListOf<BudgetItem>()
    private val context: Context

    constructor(context: Context, itemsList: List<BudgetItem>) : super() {
        this.context = context
        items.addAll(itemsList)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val budgetItemBinding = BudgetItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(budgetItemBinding)}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    private fun deleteItem(adapterPosition: Int) {
        items.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(item: BudgetItem) {
        items.add(item)
        notifyItemInserted(items.lastIndex)
        //notifyDataSetChanged()
    }

    inner class ViewHolder(val budgetItemBinding: BudgetItemBinding): RecyclerView.ViewHolder(budgetItemBinding.root) {

        fun bind(budgetItem: BudgetItem) {
            budgetItemBinding.tvName.text = budgetItem.name
            budgetItemBinding.tvPrice.text = budgetItem.value.toString()
            budgetItemBinding.rbtnIncome.isChecked = budgetItem.income_type
            budgetItemBinding.rbtnExpense.isChecked = budgetItem.expense_type

            //when (BudgetItem.category) {
           //     0 -> {
            //        shopItemBinding.ivItemLogo.setImageResource(R.drawable.food)
            //    }
           //     1 -> {
           //         shopItemBinding.ivItemLogo.setImageResource(R.drawable.clothes)
           //     }
           //     2 -> {
           //         shopItemBinding.ivItemLogo.setImageResource(R.drawable.sport)
           //     }
          //  }

            budgetItemBinding.btnSave.setOnClickListener {
                addItem(adapterPosition)
            }

            budgetItemBinding.btnDelete.setOnClickListener {
                deleteItem(adapterPosition)
            }
        }

    }

}