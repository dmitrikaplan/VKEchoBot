package ru.kaplaan.bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VkEchoBotApplication

fun main(args: Array<String>) {
	runApplication<VkEchoBotApplication>(*args)
}