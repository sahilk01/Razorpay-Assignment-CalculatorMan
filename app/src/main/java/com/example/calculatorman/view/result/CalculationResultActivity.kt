package com.example.calculatorman.view.result

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.calculatorman.R
import com.example.calculatorman.databinding.ActivityCalculationResultBinding

class CalculationResultActivity : AppCompatActivity() {

    lateinit var calculationResult: String

    private lateinit var binding: ActivityCalculationResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        calculationResult = intent.getFloatExtra(RESULT, 0f).toString()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculation_result)
        binding.lifecycleOwner = this
        binding.handler = this
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let {

        }
    }

    companion object {
        const val RESULT = "result"

        fun open(context: Context, result: Float) {
            Intent(context, CalculationResultActivity::class.java).also {
                it.putExtra(RESULT, result)
                context.startActivity(it)
            }
        }
    }
}