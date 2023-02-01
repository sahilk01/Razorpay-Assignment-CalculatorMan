package com.example.calculator

/**
 * Used to do Math matical operations between 2 numbers*/

interface MathOps {

    /**
     * Used to Add 2 number*/

    fun addition(number1: Float, number2: Float): Float

    /**
     * Used to Subtract 2 number*/
    fun subtraction(number1: Float, number2: Float): Float
}