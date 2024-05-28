package ru.kaplaan.bot.web.dto.event

import com.fasterxml.jackson.annotation.JsonProperty

data class Object(
    @field:JsonProperty("message")
    val message: Message
)