package ru.kaplaan.bot.service.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.kaplaan.bot.domain.exception.VkApiServerResponseException
import ru.kaplaan.bot.domain.method.Method
import ru.kaplaan.bot.domain.properties.CallbackServerProperties
import ru.kaplaan.bot.service.CallBackServerService
import ru.kaplaan.bot.service.UriVariablesBuilderService
import ru.kaplaan.bot.web.dto.callbackServer.add.AddCallbackServerResponse
import ru.kaplaan.bot.web.dto.callbackServer.delete.DeleteCallbackServerResponse
import ru.kaplaan.bot.web.dto.callbackServer.getAll.CallbackServerDto
import ru.kaplaan.bot.web.dto.callbackServer.getAll.GetCallBackServersDto
import ru.kaplaan.bot.web.dto.callbackServer.setSettings.SetSettingsCallbackServerResponse

@Service
class CallbackServerServiceImpl(
    private val requestService: RequestService,
    private val uriVariablesBuilderService: UriVariablesBuilderService,
    private val callBackServerProperties: CallbackServerProperties
) : CallBackServerService {


    private val log = LoggerFactory.getLogger(javaClass)

    override fun getCallbackServers(): List<CallbackServerDto> {
        return requestService.send<GetCallBackServersDto>(
            methodEndpoint = Method.GET_CALLBACK_SERVERS.endpoint,
            uriVariables = uriVariablesBuilderService.buildGetCallbackServersUriVariables()
        )
            .also {
                if (it.isError()){
                    log.error(it.error!!.toString())
                    throw VkApiServerResponseException(it.error.toString())
                }

            }.response!!.items
    }

    override fun deleteCallbackServer(serverId: Int): Int {
        return requestService.send<DeleteCallbackServerResponse>(
            methodEndpoint = Method.DELETE_CALLBACK_SERVER.endpoint,
            uriVariables = uriVariablesBuilderService.buildDeleteCallbackServerUriVariables(serverId)
        ).also {
            if(it.isError()){
                log.error(it.error!!.toString())
                throw VkApiServerResponseException(it.error.toString())
            }
        }.response!!
    }

    override fun addCallbackServer(): Int {
        return requestService.send<AddCallbackServerResponse>(
            methodEndpoint = Method.ADD_CALLBACK_SERVER.endpoint,
            uriVariables = uriVariablesBuilderService.buildAddCallbackServerUriVariables()
        ).also {
            if(it.isError()){
                log.error(it.error!!.toString())
                throw VkApiServerResponseException(it.error.toString())
            }

        }.response!!.serverId

    }

    override fun setCallbackSettings(serverId: Int): Int {
        return requestService.send<SetSettingsCallbackServerResponse>(
            methodEndpoint = Method.SET_CALLBACK_SERVER_SETTINGS.endpoint,
            uriVariables =  uriVariablesBuilderService.buildSetCallbackServerSettings(serverId)
        ).also {
            if(it.isError()){
                log.error(it.error!!.toString())
                throw VkApiServerResponseException(it.error.toString())
            }
        }.let {
            it.response!!
        }
    }

}