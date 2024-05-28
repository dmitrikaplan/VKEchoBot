package ru.kaplaan.bot.domain.exception

abstract class ServerResponseException(message: String): RuntimeException(message){
    override val message: String
        get() = super.message!!
}