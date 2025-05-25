package com.example.habittracker.core.model

import java.time.LocalDate


data class HabitEntity(
    val id: Int,
    val name: String,
    val description: String? = null,
    val frequency: Frequency,
    val startDate: LocalDate = LocalDate.now(),
    val reminderTime: String? = null,
    val isActive: Boolean = true
)
