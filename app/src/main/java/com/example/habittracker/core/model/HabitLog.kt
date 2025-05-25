package com.example.habittracker.core.model

import java.time.LocalDate


data class HabitLog(
    val id: Int,
    val habitId: Int,
    val date: LocalDate,
    val value: Int = 1,
    val createdAt: LocalDate
)