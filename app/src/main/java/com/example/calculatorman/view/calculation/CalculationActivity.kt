package com.example.calculatorman.view.calculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.calculatorman.R
import com.example.calculatorman.databinding.ActivityMainBinding
import com.example.calculatorman.util.collectLatestOnUi
import com.example.calculatorman.util.collectOnUi
import com.example.calculatorman.util.showToast
import com.example.calculatorman.view.result.CalculationResultActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculationActivity : AppCompatActivity() {

    private val calculationViewModel: CalculationViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = calculationViewModel

        collectData()
    }

    private fun collectData() {
        calculationViewModel.calculationResult.collectOnUi(this) { result ->
            CalculationResultActivity.open(this, result)
        }

        calculationViewModel.validationError.collectLatestOnUi(this) { error ->
            showToast(error)
        }
    }
}