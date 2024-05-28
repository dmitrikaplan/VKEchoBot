package ru.kaplaan.bot.web.dto.callbackServer.setSettings

import ru.kaplaan.bot.web.dto.Error
import ru.kaplaan.bot.web.dto.ServerResponse

data class SetSettingsCallbackServerResponse(
    override val response: Int?,
    override val error: Error?
): ServerResponse<Int>(response, error)