package com.fransoufil.kotlincourse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinCourseApplication

fun main(args: Array<String>) {
	runApplication<KotlinCourseApplication>(*args)
}
