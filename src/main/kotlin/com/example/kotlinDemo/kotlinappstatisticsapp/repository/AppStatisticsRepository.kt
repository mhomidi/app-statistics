package com.example.kotlinDemo.kotlinappstatisticsapp.repository

import com.example.kotlinDemo.kotlinappstatisticsapp.models.AppStatistics
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface AppStatisticsRepository: JpaRepository<AppStatistics, Long> {
}