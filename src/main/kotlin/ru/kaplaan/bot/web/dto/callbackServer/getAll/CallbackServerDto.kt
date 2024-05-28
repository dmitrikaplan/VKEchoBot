package ru.kaplaan.bot.web.dto.callbackServer.getAll

data class CallbackServerDto(
    val id: Int,
    val title: String,
    val creatorId: Int,
    val url: String,
    val status: String
)