package com.example.calculatorman.util

/**
    We can add more validations later.
 */

fun String.isValidNumber(): Boolean {
    return this.isNotEmpty()
}