package ru.kaplaan.bot.domain.properties

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@ConfigurationProperties(prefix = "callback-server.settings")
@Validated
data class CallbackServerSettingsProperties(
    @field:Min(0)
    @field:Max(1)
    val messageNew: Int,

    @field:Min(0)
    @field:Max(1)
    val messageReply: Int,

    @field:Min(0)
    @field:Max(1)
    val messageAllow: Int,

    @field:Min(0)
    @field:Max(1)
    val messageEdit: Int,

    @field:Min(0)
    @field:Max(1)
    val messageDeny: Int,

    @field:Min(0)
    @field:Max(1)
    val messageTypingState: Int,

    @field:Min(0)
    @field:Max(1)
    val messageRead: Int
)