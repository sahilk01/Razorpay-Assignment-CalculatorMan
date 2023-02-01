package com.example.calculatorman.view.calculation

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculatorman.repository.CalculationRepository
import com.example.calculatorman.util.isValidNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculationViewModel @Inject constructor(
    private val calculationRepository: CalculationRepository
) : ViewModel() {

    val number1 = MutableStateFlow("")
    val number2 = MutableStateFlow("")

    private val _calculationResult = MutableSharedFlow<Float>()
    val calculationResult get() = _calculationResult

    private val _validationError = MutableSharedFlow<String>()
    val validationError get() = _validationError

    fun performAddition() {
        viewModelScope.launch(Dispatchers.IO) {
            if (areNumbersValid()) {
                val result = calculationRepository.performAddition(number1.value, number2.value)
                calculationResult.emit(result)
            }
        }
    }

    fun performSubtraction() {
        viewModelScope.launch(Dispatchers.IO) {
            if (areNumbersValid()) {
                val result = calculationRepository.performSubtraction(number1.value, number2.value)
                calculationResult.emit(result)
            }
        }
    }

    private suspend fun areNumbersValid(): Boolean {
        return if (number1.value.isValidNumber() && number2.value.isValidNumber()) {
            true
        } else {
            _validationError.emit("Please Enter Correct Numbers")
            false
        }
    }
}