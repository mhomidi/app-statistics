package com.example.kotlinDemo.kotlinappstatisticsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AppStatisticsApplication

fun main(args: Array<String>) {
	runApplication<AppStatisticsApplication>(*args)
}
