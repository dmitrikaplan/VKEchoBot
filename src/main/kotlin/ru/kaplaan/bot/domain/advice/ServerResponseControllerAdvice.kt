package ru.kaplaan.bot.domain.advice

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.RestClientResponseException
import ru.kaplaan.bot.domain.exception.ServerResponseException

@RestControllerAdvice
class ServerResponseControllerAdvice {

    @ExceptionHandler(ServerResponseException::class)
    fun serverResponseExceptionHandler(e: ServerResponseException): ResponseEntity<ProblemDetail> =
        ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.message).let {
            ResponseEntity.status(HttpStatusCode.valueOf(it.status)).body(it)
        }


    @ExceptionHandler(RestClientResponseException::class)
    fun restClientResponseExceptionHandler(e: RestClientResponseException) {
        ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.message).let {
            ResponseEntity.status(HttpStatusCode.valueOf(it.status)).body(it)
        }
    }

    @ExceptionHandler(BindException::class)
    fun validationExceptionHandler(e: BindException): ResponseEntity<ProblemDetail> {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.message)
            .also {
                it.setProperty("errors", e.allErrors.map { error -> error.defaultMessage })
            }
            .let {
                ResponseEntity.status(HttpStatusCode.valueOf(it.status)).body(it)
            }
    }
}