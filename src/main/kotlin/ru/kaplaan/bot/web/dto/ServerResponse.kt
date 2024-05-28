package ru.kaplaan.bot.web.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import org.hibernate.validator.group.GroupSequenceProvider
import ru.kaplaan.bot.web.dto.confirmation.CodeDto
import ru.kaplaan.bot.web.validation.ServerResponseGroupSequenceProvider
import ru.kaplaan.bot.web.validation.group.Response

@GroupSequenceProvider(ServerResponseGroupSequenceProvider::class)
open class ServerResponse<T>(
    @field:NotNull(message = "Response не должен быть null", groups = [Response::class])
    @field:Null(message = "Response должен быть null", groups = [Error::class])
    open val response: T?,
    @field:NotNull(message = "Error не должен быть null", groups = [Error::class])
    @field:Null(message = "Error должен быть null", groups = [Response::class])
    open val error: Error?
){

    fun isError(): Boolean{
        return error != null
    }

    fun isSuccess(): Boolean{
        return response != null
    }
}