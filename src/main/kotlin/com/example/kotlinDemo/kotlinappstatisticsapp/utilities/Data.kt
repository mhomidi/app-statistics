package com.example.kotlinDemo.kotlinappstatisticsapp.utilities

import com.example.kotlinDemo.kotlinappstatisticsapp.classes.AppStatisticsModel
import com.example.kotlinDemo.kotlinappstatisticsapp.repository.AppStatisticsRepository
import com.github.mfathi91.time.PersianDate


public fun getAllStatisticsModels(startDate: PersianDate,
                                  endDate: PersianDate,
                                  type: Int,
                                  appStatisticsRepository: AppStatisticsRepository): List<AppStatisticsModel> {
    var dateIter: PersianDate = startDate
    var numberDaysPlus: Int = 8 - getDayOfWeek(startDate)
    var models: List<AppStatisticsModel> = emptyList()
    models = models.toMutableList()
    while (dateIter.plusDays(numberDaysPlus.toLong()).isBefore(endDate)) {
        val appStatistics = AppStatisticsModel(type, dateIter, dateIter.plusDays(7), appStatisticsRepository)
        models.add(appStatistics)
        dateIter = dateIter.plusDays(7)
        numberDaysPlus = 7
    }
    models.add(AppStatisticsModel(type, dateIter, endDate, appStatisticsRepository))
    return models
}