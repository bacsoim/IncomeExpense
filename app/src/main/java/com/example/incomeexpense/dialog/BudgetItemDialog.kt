package com.example.incomeexpense.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.incomeexpense.R
import com.example.incomeexpense.data.BudgetItem


class BudgetItemDialog : DialogFragment() {

    interface BudgetItemDialogHandler {
        fun budgetItemCreated(item: BudgetItem)
    }

    private lateinit var budgetItemHandler: BudgetItemDialogHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is BudgetItemDialogHandler) {
            budgetItemHandler = context
        } else {
            throw RuntimeException("The Activity does not implement the BudgetItemDialogHandler interface")
        }
    }

    private lateinit var etName: EditText
    private lateinit var etPrice: EditText
    private lateinit var spinnerCategory: Spinner


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("New Item")

        val rootView = requireActivity().layoutInflater.inflate(
            R.layout.budget_dialog, null
        )

        etName = rootView.etName
        etPrice = rootView.etPrice
        spinnerCategory = rootView.spinnerCategory
        var categoryAdapter = ArrayAdapter.createFromResource(
           requireActivity(),
            R.array.category_array,
            android.R.layout.simple_spinner_item
        )
        categoryAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerCategory.adapter = categoryAdapter

        builder.setView(rootView)

        builder.setPositiveButton("OK") { dialog, which ->
            //... keep empty
        }
        return builder.create()
    }

    override fun onResume() {
        super.onResume()

        val dialog = dialog as AlertDialog
        val positiveButton = dialog.getButton(Dialog.BUTTON_POSITIVE)

        positiveButton.setOnClickListener {
            if (etName.text.isNotEmpty()) {
                if (etPrice.text.isNotEmpty()) {
                    handleItemCreate()

                    dialog.dismiss()
                } else {
                    etPrice.error = "This field can not be empty"
                }
            } else {
                etName.error = "This field can not be empty"
            }
        }
    }

    fun handleItemCreate() {
        budgetItemHandler.budgetItemCreated(
            BudgetItem(
                etName.text.toString(),
                etPrice.text.toString().toInt(),
                "Demo",
                false,
                spinnerCategory.selectedItemPosition
            )
        )
    }
}