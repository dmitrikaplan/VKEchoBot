package ru.kaplaan.bot.web.validation

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider
import ru.kaplaan.bot.web.dto.ServerResponse
import ru.kaplaan.bot.web.validation.group.Error
import ru.kaplaan.bot.web.validation.group.Response

class ServerResponseGroupSequenceProvider<T>: DefaultGroupSequenceProvider<ServerResponse<T>> {
    override fun getValidationGroups(serverResponse:  ServerResponse<T>?): MutableList<Class<*>> {
        return when{

            serverResponse == null -> mutableListOf(ServerResponse::class.java)

            serverResponse.response != null -> mutableListOf(ServerResponse::class.java, Response::class.java)

            else ->  mutableListOf(ServerResponse::class.java, Error::class.java)
        }
    }
}