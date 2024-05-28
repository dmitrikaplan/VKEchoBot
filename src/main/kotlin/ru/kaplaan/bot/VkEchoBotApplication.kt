package ru.kaplaan.bot

import jakarta.annotation.PostConstruct
import org.springframework.boot.ExitCodeGenerator
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import ru.kaplaan.bot.service.CallBackServerService
import kotlin.system.exitProcess


@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = ["ru.kaplaan.bot.domain.properties"])
class VkEchoBotApplication(
    private val callBackServerService: CallBackServerService,
    private val applicationContext: ApplicationContext,
) {

    @PostConstruct
    fun onStart() {
        runCatching {
            callBackServerService.also {
                it.getCallbackServers()
                    .map { callbackServer -> callbackServer.id }
                    .forEach { id ->
                        callBackServerService.deleteCallbackServer(id)
                    }

                val serverId = it.addCallbackServer()
                it.setCallbackSettings(serverId)
            }
        }.onFailure {
            exitProcess(
                status = SpringApplication.exit(
                    applicationContext,
                    ExitCodeGenerator {
                        1
                    }
                )
            )
        }

    }
}

fun main(args: Array<String>) {
    runApplication<VkEchoBotApplication>(*args)
}