package sag.project.theeasyfinappsplashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import android.widget.TextView

class InvestFragment : Fragment() {

    private lateinit var etSIPAmount: EditText
    private lateinit var etNumberOfYears: EditText
    private lateinit var calculateButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_invest, container, false)

        etSIPAmount = view.findViewById(R.id.etSIPAmount)
        etNumberOfYears = view.findViewById(R.id.etNumberOfYears)
        calculateButton = view.findViewById(R.id.calculateButton)

        // Set the click listener using the View.OnClickListener interface
        calculateButton.setOnClickListener(View.OnClickListener {
            calculateCorpus()
        })

        return view
    }

    private fun calculateCorpus() {
        val sipAmountStr = etSIPAmount.text.toString()
        val numberOfYearsStr = etNumberOfYears.text.toString()

        if (sipAmountStr.isNotEmpty() && numberOfYearsStr.isNotEmpty()) {
            val sipAmount = sipAmountStr.toDouble()
            val numberOfYears = numberOfYearsStr.toDouble()

            val stockCorpus = calculateCorpus(sipAmount, 0.15, numberOfYears)
            val bondCorpus = calculateCorpus(sipAmount, 0.10, numberOfYears)
            val fdCorpus = calculateCorpus(sipAmount, 0.06, numberOfYears)

            // Display the results
            view?.findViewById<TextView>(R.id.tvStockCorpus)?.apply {
                text = "Stock Corpus: $stockCorpus"
                visibility = View.VISIBLE
            }

            view?.findViewById<TextView>(R.id.tvBondCorpus)?.apply {
                text = "Bond Corpus: $bondCorpus"
                visibility = View.VISIBLE
            }

            view?.findViewById<TextView>(R.id.tvFDCorpus)?.apply {
                text = "FD Corpus: $fdCorpus"
                visibility = View.VISIBLE
            }
        }
    }


    private fun calculateCorpus(sipAmount: Double, annualReturnRate: Double, numberOfYears: Double): Double {
        val monthlyReturnRate = Math.pow(1 + annualReturnRate, 1.0 / 12.0) - 1
        val totalMonths = numberOfYears * 12

        var corpus = 0.0
        repeat(totalMonths.toInt()) {
            corpus = (corpus + sipAmount) * (1 + monthlyReturnRate)
        }

        return corpus
    }

}
