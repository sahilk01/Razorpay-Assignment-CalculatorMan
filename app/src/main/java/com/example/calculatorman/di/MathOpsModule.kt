package com.example.calculatorman.di

import com.example.calculator.MathOps
import com.example.calculator.MathOpsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MathOpsModule {

    @Provides
    @Singleton
    fun provideMathOps(): MathOps = MathOpsImpl()

}