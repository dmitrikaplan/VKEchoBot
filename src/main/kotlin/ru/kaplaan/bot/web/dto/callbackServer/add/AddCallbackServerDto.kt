package ru.kaplaan.bot.web.dto.callbackServer.add

import com.fasterxml.jackson.annotation.JsonProperty

data class AddCallbackServerDto(
    @field:JsonProperty("server_id")
    val serverId: Int
)