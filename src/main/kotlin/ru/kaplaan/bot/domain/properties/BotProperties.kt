package ru.kaplaan.bot.domain.properties

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import org.springframework.validation.annotation.Validated

@ConfigurationProperties(prefix = "bot")
@Validated
data class BotProperties @ConstructorBinding constructor(
    @field:NotBlank
    val accessToken: String,
    @field:Min(0)
    val groupId: Int,
)