package ru.kaplaan.bot.domain.method

enum class Method(val endpoint: String) {
    GET_CALLBACK_CONFIRMATION_CODE("/method/groups.getCallbackConfirmationCode"),
    MESSAGES_SEND("/method/messages.send"),
    GET_CALLBACK_SERVERS("/method/groups.getCallbackServers"),
    DELETE_CALLBACK_SERVER("/method/groups.deleteCallbackServer"),
    ADD_CALLBACK_SERVER("/method/groups.addCallbackServer"),
    SET_CALLBACK_SERVER_SETTINGS("/method/groups.setCallbackSettings"),
}