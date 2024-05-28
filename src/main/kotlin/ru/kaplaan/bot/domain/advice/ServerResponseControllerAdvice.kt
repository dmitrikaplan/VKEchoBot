package ru.kaplaan.bot.domain.advice

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.RestClientResponseException
import ru.kaplaan.bot.domain.exception.ServerResponseException

@RestControllerAdvice
class ServerResponseControllerAdvice{

    @Value("\${headers.retry-after.delay-seconds}")
    private lateinit var delaySeconds: String

    @ExceptionHandler(ServerResponseException::class)
    fun serverResponseExceptionHandler(e: ServerResponseException): ResponseEntity<Any> =
        ResponseEntity.status(410).headers { it[HttpHeaders.RETRY_AFTER] = delaySeconds }.build()


    @ExceptionHandler(RestClientResponseException::class)
    fun restClientResponseExceptionHandler(e: RestClientResponseException): ResponseEntity<Any> =
        ResponseEntity.status(410).headers { it[HttpHeaders.RETRY_AFTER] = delaySeconds }.build()

    @ExceptionHandler(BindException::class)
    fun validationExceptionHandler(e: BindException): ResponseEntity<Any> =
        ResponseEntity.status(410).headers { it[HttpHeaders.RETRY_AFTER] = delaySeconds }.build()
}