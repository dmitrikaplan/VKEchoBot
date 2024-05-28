package ru.kaplaan.bot.web.dto.messageNew

import ru.kaplaan.bot.web.dto.Error
import ru.kaplaan.bot.web.dto.ServerResponse

data class MessageNewResponseDto(
    override val response: SendAnswerData?,
    override val error: Error?
): ServerResponse<SendAnswerData>(response, error)