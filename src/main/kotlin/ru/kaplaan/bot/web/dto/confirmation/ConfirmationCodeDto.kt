package ru.kaplaan.bot.web.dto.confirmation

import ru.kaplaan.bot.web.dto.Error
import ru.kaplaan.bot.web.dto.ServerResponse

data class ConfirmationCodeDto(
    override val response: CodeDto?,
    override val error: Error?
): ServerResponse<CodeDto>(response, error)