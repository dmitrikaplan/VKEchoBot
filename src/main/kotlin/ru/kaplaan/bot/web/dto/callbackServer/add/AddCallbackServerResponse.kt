package ru.kaplaan.bot.web.dto.callbackServer.add

import ru.kaplaan.bot.web.dto.Error
import ru.kaplaan.bot.web.dto.ServerResponse

data class AddCallbackServerResponse(
    override val response: AddCallbackServerDto?,
    override val error: Error?
): ServerResponse<AddCallbackServerDto>(response, error)