package ru.kaplaan.bot.web.dto.event

import com.fasterxml.jackson.annotation.JsonProperty

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
    val obj: ObjectDto
)