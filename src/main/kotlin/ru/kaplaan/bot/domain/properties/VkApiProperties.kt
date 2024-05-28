package ru.kaplaan.bot.domain.properties

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.URL
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import org.springframework.validation.annotation.Validated

@ConfigurationProperties(prefix = "vk")
@Validated
data class VkApiProperties @ConstructorBinding constructor(
    @field:NotBlank
    val apiVersion: String,
    @field:URL
    val apiUrl: String
)