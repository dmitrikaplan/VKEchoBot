package ru.kaplaan.bot.web.dto.event

import com.fasterxml.jackson.annotation.JsonProperty

data class ObjectDto(
    @field:JsonProperty("message")
    val message: MessageDto?
)