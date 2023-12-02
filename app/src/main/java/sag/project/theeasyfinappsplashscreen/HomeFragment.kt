package sag.project.theeasyfinappsplashscreen

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import sag.project.theeasyfinappsplashscreen.databinding.ActivityTransactionsBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)
        val transactionbtn = view?.findViewById<Button>(R.id.btnTransactions)

        transactionbtn?.setOnClickListener { view ->
            Log.d("transactionbtn", "Selected")
        }

    }}