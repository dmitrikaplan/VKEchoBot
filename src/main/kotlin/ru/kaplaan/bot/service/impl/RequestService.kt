package ru.kaplaan.bot.service.impl

import jakarta.validation.Validator
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import ru.kaplaan.bot.domain.exception.EmptyBodyServerResponseException
import ru.kaplaan.bot.domain.properties.VkApiProperties
import ru.kaplaan.bot.web.validation.group.Error
import ru.kaplaan.bot.web.validation.group.Response

@Service
final class RequestService(
    val restClient: RestClient,
    val vkApiProperties: VkApiProperties,
    private val validator: Validator
) {

    val log = LoggerFactory.getLogger(javaClass)!!

    inline fun <reified T> send(methodEndpoint: String, uriVariables: Map<String, String>): T{
        val response = restClient
            .get()
            .uri("${vkApiProperties.apiUrl}/$methodEndpoint?${buildParams(uriVariables)}")
            .retrieve()
            .body(T::class.java)
            ?.also(::validate)
            ?: throw EmptyBodyServerResponseException()

        log.debug("body: {}", response)
        return response
    }

    fun buildParams(uriVariables: Map<String, String>?): String{
        return uriVariables?.toList()?.joinToString("&") { "${it.first}=${it.second}" } ?: ""
    }

    fun <T> validate(t: T){
        validator.validate(t, Response::class.java, Error::class.java)
    }
}