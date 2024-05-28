package ru.kaplaan.bot.web.dto.event

import com.fasterxml.jackson.annotation.JsonCreator

enum class EventType {
    CONFIRMATION, MESSAGE_NEW, IGNORED_EVENT;

    override fun toString(): String {
        return this.name.lowercase()
    }

    companion object{
        @JvmStatic
        @JsonCreator
        fun fromString(typeString: String): EventType {
            return entries.toTypedArray().forEach {
                if(typeString.uppercase() == it.name)
                    return it
            }.let {
                IGNORED_EVENT
            }
        }
    }

}