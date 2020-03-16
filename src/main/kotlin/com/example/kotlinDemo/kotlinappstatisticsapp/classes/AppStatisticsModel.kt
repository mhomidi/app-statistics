package com.example.kotlinDemo.kotlinappstatisticsapp.classes
import com.example.kotlinDemo.kotlinappstatisticsapp.repository.AppStatisticsRepository
import com.example.kotlinDemo.kotlinappstatisticsapp.utilities.getWeek
import com.github.mfathi91.time.PersianDate

class AppStatisticsModel(
        private val app_type: Int,
        private val startDate: PersianDate,
        private val endDate: PersianDate,
        private val repository: AppStatisticsRepository
) {
    private val apps = this.repository.findAll().filter {
        it.reportTime.isAfter(startDate.toGregorian())
                && it.reportTime.isBefore(endDate.toGregorian())
    }
    val weekNum: Long = getWeek(startDate)
    val year: Int = startDate.year
    val requests: Int
        get() {
            var requestNum = 0
            for (app in apps) {
                if (app.type == this.app_type)
                    requestNum += (app.videoRequest + app.webViewRequest)
            }
            return requestNum
        }

    val clicks: Int
        get() {
            var requestNum = 0
            for (app in apps) {
                if (app.type == this.app_type)
                    requestNum += (app.videoClicks + app.webViewClicks)
            }
            return requestNum
        }

    val installs: Int
        get() {
            var requestNum = 0
            for (app in apps) {
                if (app.type == this.app_type)
                    requestNum += (app.videoInstalls + app.webViewInstalls)
            }
            return requestNum
        }
}