package com.example.kotlinDemo.kotlinappstatisticsapp.controller

import com.example.kotlinDemo.kotlinappstatisticsapp.classes.AppStatisticsModel
import com.example.kotlinDemo.kotlinappstatisticsapp.models.AppStatistics
import com.example.kotlinDemo.kotlinappstatisticsapp.repository.AppStatisticsRepository
import com.example.kotlinDemo.kotlinappstatisticsapp.utilities.getAllStatisticsModels
import com.github.mfathi91.time.PersianDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.validation.Valid


@RestController
@RequestMapping("/statistics")
class AppStatisticsController (@Autowired private val appStatisticsRepository: AppStatisticsRepository) {

    @GetMapping("/{appId}")
    fun getStatisticsApp(@PathVariable appId : Long) : ResponseEntity<AppStatistics> {
        val app = appStatisticsRepository.findById(appId)
        return app.map { ResponseEntity.ok(it) }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/create")
    fun createStatisticsApp(@Valid @RequestBody appStatistics: AppStatistics): AppStatistics =
            appStatisticsRepository.save(appStatistics)

    @GetMapping("/sss/{type}")
    fun sss(@PathVariable type: Int, @RequestParam startDate: String,
            @RequestParam endDate: String): List<AppStatisticsModel> {
        val dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        val sd = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE)
        val sdate = PersianDate.of(sd.year, sd.monthValue, sd.dayOfMonth)
        val ed = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE)
        val edate = PersianDate.of(ed.year, ed.monthValue, ed.dayOfMonth)
        return getAllStatisticsModels(type = type,
                startDate = sdate, endDate = edate, appStatisticsRepository = appStatisticsRepository)
    }

}