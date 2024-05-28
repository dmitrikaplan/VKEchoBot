package ru.kaplaan.bot.service

import org.springframework.stereotype.Service
import ru.kaplaan.bot.web.dto.event.EventDto

@Service
interface EventService {
    fun listenEvent(eventDto: EventDto): String
}