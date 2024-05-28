package ru.kaplaan.bot.service.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.kaplaan.bot.domain.exception.VkApiServerResponseException
import ru.kaplaan.bot.domain.method.Method
import ru.kaplaan.bot.service.EventService
import ru.kaplaan.bot.service.UriVariablesBuilderService
import ru.kaplaan.bot.web.dto.confirmation.ConfirmationCodeDto
import ru.kaplaan.bot.web.dto.event.EventDto
import ru.kaplaan.bot.web.dto.event.EventType
import ru.kaplaan.bot.web.dto.messageNew.MessageNewResponseDto

@Service
class EventServiceImpl(
    private val requestService: RequestService,
    private val uriVariablesBuilderService: UriVariablesBuilderService
): EventService {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun listenEvent(eventDto: EventDto): String {

        return when(eventDto.type){

            EventType.CONFIRMATION -> {
                requestService.send<ConfirmationCodeDto>(
                    methodEndpoint = Method.GET_CALLBACK_CONFIRMATION_CODE.endpoint,
                    uriVariables = uriVariablesBuilderService.buildConfirmationUriVariables()
                ).also { confirmationCodeDto ->
                    //TODO("Добавить exception handling")
                    if (confirmationCodeDto.isError()){
                        log.error(confirmationCodeDto.error!!.toString())
                        throw VkApiServerResponseException(confirmationCodeDto.error.toString())

                    }

                }.response!!.code
            }

            EventType.MESSAGE_NEW -> {
                requestService.send<MessageNewResponseDto>(
                    methodEndpoint = Method.MESSAGES_SEND.endpoint,
                    uriVariables = uriVariablesBuilderService.buildMessageNewUriVariables(eventDto)
                ).also { messageNewResponseDto ->
                    if(messageNewResponseDto.isError()){
                        log.error(messageNewResponseDto.error!!.toString())
                        throw VkApiServerResponseException(messageNewResponseDto.error.toString())
                    }

                }
                "ok"
            }

            EventType.IGNORED_EVENT -> "ok"
        }
    }

}

