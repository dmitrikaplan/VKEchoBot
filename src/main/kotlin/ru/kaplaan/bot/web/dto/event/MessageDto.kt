package ru.kaplaan.bot.web.dto.event

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageDto(

    @field:JsonProperty("from_id")
    val fromId: Int,

    @field:JsonProperty("peer_id")
    val peerId: Int,

    @field:JsonProperty("fwd_messages")
    val fwdMessages: List<Any>,

    @field:JsonProperty("random_id")
    val randomId: Int,

    @field:JsonProperty("text")
    val text: String
)