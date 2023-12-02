package sag.project.theeasyfinappsplashscreen

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import sag.project.theeasyfinappsplashscreen.databinding.ActivityActualMainBinding
import sag.project.theeasyfinappsplashscreen.databinding.ActivityTransactionsBinding

class TransactionsActivity : AppCompatActivity() {

    lateinit var binding: ActivityTransactionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabTransactions.setOnClickListener {
            val expenseType = AlertDialog.Builder(this)
            val options = arrayOf("Grocery","Transportation","Baby","Beauty","Bills","Vehicle","Clothing","Education",
                "Food","Health","Insurance","Tax","Sports","Investment","Others")
            expenseType.setTitle("Select Type of Expense:")
            expenseType.setSingleChoiceItems(options,14, DialogInterface.OnClickListener { dialog, which ->
                //What action should be performed on clicking set here
                Toast.makeText(this,"You clicked on ${options[which]}",
                Toast.LENGTH_SHORT).show()
            })

            expenseType.setPositiveButton("Done",DialogInterface.OnClickListener{dialog, which ->
                //What action should be performed on clicking set here
                finish()
            })

            expenseType.setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog, which ->
                //What action should be performed on clicking set here
                finish()
            })
            expenseType.show()
        }

    }
}