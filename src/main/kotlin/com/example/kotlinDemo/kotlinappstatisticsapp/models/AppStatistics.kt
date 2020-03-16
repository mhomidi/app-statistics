package com.example.kotlinDemo.kotlinappstatisticsapp.models

import java.time.LocalDate
import javax.persistence.*

@Entity(name = "statistics")
data class AppStatistics(
        @Id @GeneratedValue(
                strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        val reportTime: LocalDate = LocalDate.now(),
        val type: Int = 0,
        val videoRequest: Int = 0,
        val webViewRequest: Int = 0,
        val videoClicks: Int = 0,
        val webViewClicks: Int = 0,
        val videoInstalls: Int = 0,
        val webViewInstalls: Int = 0
)