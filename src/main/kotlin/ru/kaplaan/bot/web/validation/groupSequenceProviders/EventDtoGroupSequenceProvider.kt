package ru.kaplaan.bot.web.validation.groupSequenceProviders

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider
import ru.kaplaan.bot.web.dto.event.EventDto
import ru.kaplaan.bot.web.dto.event.EventType
import ru.kaplaan.bot.web.validation.group.MessageNew

class EventDtoGroupSequenceProvider: DefaultGroupSequenceProvider<EventDto> {
    override fun getValidationGroups(eventDto: EventDto): MutableList<Class<*>> {
        return when{

            eventDto.type == EventType.MESSAGE_NEW -> mutableListOf(EventDto::class.java, MessageNew::class.java)

            else ->  mutableListOf(EventDto::class.java)
        }
    }
}