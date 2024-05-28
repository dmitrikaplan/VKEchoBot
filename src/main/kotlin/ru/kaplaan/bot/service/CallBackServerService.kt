package ru.kaplaan.bot.service

import org.springframework.stereotype.Service
import ru.kaplaan.bot.web.dto.callbackServer.getAll.CallbackServerDto


@Service
interface CallBackServerService {

    fun deleteCallbackServer(serverId: Int): Int
    fun addCallbackServer(): Int

    fun setCallbackSettings(serverId: Int): Int

    fun getCallbackServers(): List<CallbackServerDto>
}