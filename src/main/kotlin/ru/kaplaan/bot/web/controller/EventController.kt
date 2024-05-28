package ru.kaplaan.bot.web.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.kaplaan.bot.service.EventService
import ru.kaplaan.bot.web.dto.event.EventDto

@RestController
@RequestMapping("/api")
class EventController(
    private val eventService: EventService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun api(@RequestBody eventDto: EventDto): String{
        return eventService.listenEvent(eventDto)
    }
}