package ru.kaplaan.bot.service.impl

import org.springframework.stereotype.Service
import ru.kaplaan.bot.domain.properties.BotProperties
import ru.kaplaan.bot.domain.properties.CallbackServerProperties
import ru.kaplaan.bot.domain.properties.CallbackServerSettingsProperties
import ru.kaplaan.bot.domain.properties.VkApiProperties
import ru.kaplaan.bot.service.UriVariablesBuilderService
import ru.kaplaan.bot.web.dto.event.EventDto

@Service
class UriVariablesBuilderServiceImpl(
    private val botProperties: BotProperties,
    private val vkApiProperties: VkApiProperties,
    private val callBackServerProperties: CallbackServerProperties,
    private val callbackServerSettingsProperties: CallbackServerSettingsProperties
): UriVariablesBuilderService {


    override fun buildConfirmationUriVariables(): Map<String, String>{
        return buildDefaultUriVariables().apply {
            this["group_id"] = botProperties.groupId.toString()
        }
    }

    override fun buildMessageNewUriVariables(eventDto: EventDto): Map<String, String>{
        return buildDefaultUriVariables().apply {
            this["peer_id"] = eventDto.obj.message!!.peerId.toString()
            this["message"]  = "Вы сказали: ${eventDto.obj.message!!.text}".let {
                if(it.length <= 4096)
                    it
                else
                    "Сообщение слишком длинное !"
            }
            this["random_id"] = eventDto.obj.message.randomId.toString()
        }

    }

    override fun buildGetCallbackServersUriVariables(): Map<String, String>{
        return buildDefaultUriVariables().apply {
            this["group_id"] = botProperties.groupId.toString()
        }
    }


    override fun buildDeleteCallbackServerUriVariables(serverId: Int): Map<String, String>{
        return buildDefaultUriVariables().apply {
            this["group_id"] = botProperties.groupId.toString()
            this["server_id"] = serverId.toString()
        }
    }

    override fun buildAddCallbackServerUriVariables(): Map<String, String>{
        return buildDefaultUriVariables().apply {
            this["group_id"] = botProperties.groupId.toString()
            this["title"] = callBackServerProperties.title
            this["url"] = callBackServerProperties.url
        }
    }

    override fun buildSetCallbackServerSettings(serverId: Int): Map<String, String> {
        return buildDefaultUriVariables().apply {
            this["server_id"] = serverId.toString()
            this["group_id"] = botProperties.groupId.toString()
            this["api_version"] = vkApiProperties.apiVersion

            callbackServerSettingsProperties.also {
                this["message_new"] = it.messageNew.toString()
                this["message_reply"] = it.messageReply.toString()
                this["message_allow"] = it.messageAllow.toString()
                this["message_edit"] = it.messageEdit.toString()
                this["message_deny"] = it.messageDeny.toString()
                this["message_typing_state"] = it.messageTypingState.toString()
                this["message_read"] = it.messageRead.toString()
            }

        }
    }


    private fun buildDefaultUriVariables(): HashMap<String, String>{
        return hashMapOf<String, String>().apply {
            this["access_token"] = botProperties.accessToken
            this["v"] = vkApiProperties.apiVersion
        }
    }


}