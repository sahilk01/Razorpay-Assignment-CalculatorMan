package com.example.calculatorman.repository

import com.example.calculator.MathOps
import javax.inject.Inject

class CalculationRepository @Inject constructor(
    private val mathOps: MathOps
) {

    fun performAddition(number1: String, number2: String): Float {
        return mathOps.addition(number1.toFloat(), number2.toFloat())
    }

    fun performSubtraction(number1: String, number2: String): Float {
        return mathOps.subtraction(number1.toFloat(), number2.toFloat())
    }
}