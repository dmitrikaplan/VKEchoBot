FROM bellsoft/liberica-openjdk-alpine as build

WORKDIR /source
COPY /gradle /source/gradle
COPY /src /source/src
COPY build.gradle.kts /source/
COPY gradlew /source
COPY settings.gradle.kts /source

RUN ./gradlew build

#--------------------------------------------------------------------------#

FROM bellsoft/liberica-openjdk-alpine

COPY --from=build /source/build/libs/VkEchoBot.jar /vk-echo-bot.jar
CMD java -jar vk-echo-bot.jar --spring.profiles.active=prod
