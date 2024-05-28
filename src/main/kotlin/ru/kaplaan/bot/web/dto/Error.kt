package ru.kaplaan.bot.web.dto

import com.fasterxml.jackson.annotation.JsonProperty
import ru.kaplaan.bot.web.dto.confirmation.RequestParamsItem

data class Error(
    @field:JsonProperty("error_code")
    val errorCode: Int,
    @field:JsonProperty("error_msg")
    val errorMessage: String,
    @field:JsonProperty("request_params")
    val requestParams: List<RequestParamsItem>
)