package ru.kaplaan.bot.web.dto.event

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.group.GroupSequenceProvider
import ru.kaplaan.bot.web.validation.group.MessageNew
import ru.kaplaan.bot.web.validation.groupSequenceProviders.EventDtoGroupSequenceProvider

@GroupSequenceProvider(EventDtoGroupSequenceProvider::class)
data class EventDto(

    @field:JsonProperty("event_id")
    val eventId: String,

    @field:JsonProperty("group_id")
    val groupId: Int,

    @field:JsonProperty("v")
    val v: String,

    @field:JsonProperty("type")
    val type: EventType,

    @field:JsonProperty("object")
    @field:NotNull(groups = [MessageNew::class])
    val obj: Object?
)