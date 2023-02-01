package com.example.calculator

/**
 * Implementation for Math Ops Interface.
 * */

class MathOpsImpl: MathOps {
    override fun addition(number1: Float, number2: Float): Float {
        return number1 + number2
    }

    override fun subtraction(number1: Float, number2: Float): Float {
        return number1 - number2
    }
}