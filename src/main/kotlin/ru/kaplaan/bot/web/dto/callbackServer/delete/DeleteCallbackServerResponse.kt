package ru.kaplaan.bot.web.dto.callbackServer.delete

import ru.kaplaan.bot.web.dto.Error
import ru.kaplaan.bot.web.dto.ServerResponse

data class DeleteCallbackServerResponse(
    override val response: Int?,
    override val error: Error?
): ServerResponse<Int>(response, error)