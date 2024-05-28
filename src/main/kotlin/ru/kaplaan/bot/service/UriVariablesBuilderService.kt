package ru.kaplaan.bot.service

import org.springframework.stereotype.Service
import ru.kaplaan.bot.web.dto.event.EventDto

@Service
interface UriVariablesBuilderService {


    fun buildConfirmationUriVariables(): Map<String, String>

    fun buildMessageNewUriVariables(eventDto: EventDto): Map<String, String>

    fun buildGetCallbackServersUriVariables(): Map<String, String>

    fun buildDeleteCallbackServerUriVariables(serverId: Int): Map<String, String>

    fun buildAddCallbackServerUriVariables(): Map<String, String>

    fun buildSetCallbackServerSettings(): Map<String, String>

}