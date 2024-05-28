package ru.kaplaan.bot.web.dto.callbackServer.getAll

data class GetCallBackServersResponse(
    val count: Int,
    val items: List<CallbackServerDto>
)