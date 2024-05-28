package ru.kaplaan.bot.web.dto.callbackServer.getAll

import ru.kaplaan.bot.web.dto.Error
import ru.kaplaan.bot.web.dto.ServerResponse


data class GetCallBackServersDto(
    override val response: GetCallBackServersResponse?,
    override val error: Error?
): ServerResponse<GetCallBackServersResponse>(response, error)