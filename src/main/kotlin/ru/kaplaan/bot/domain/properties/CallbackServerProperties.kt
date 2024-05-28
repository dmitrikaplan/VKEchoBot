package ru.kaplaan.bot.domain.properties

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.URL
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@ConfigurationProperties(prefix = "callback-server.info")
@Validated
data class CallbackServerProperties (
    @field:NotBlank
    @field:Length(max = 14)
    val title: String,
    @field:URL
    val url: String
)