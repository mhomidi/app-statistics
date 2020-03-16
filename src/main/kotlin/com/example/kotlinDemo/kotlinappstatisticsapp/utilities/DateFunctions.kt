package com.example.kotlinDemo.kotlinappstatisticsapp.utilities

import com.github.mfathi91.time.PersianDate
import java.time.temporal.ChronoUnit

fun getWeek(date: PersianDate): Long {
    val startDate = PersianDate.of(date.year, 1, 1)
    return ChronoUnit.WEEKS.between(startDate, date) + 1
}

fun getDayOfWeek(date: PersianDate): Int {
    return (date.dayOfWeek.value + 1) % 7 + 1
}