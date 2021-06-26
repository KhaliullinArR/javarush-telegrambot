FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=java_artem_bot
ENV BOT_TOKEN=1874067812:AAGYHcvI0woUonrmDdepj_Te3dCagtbeqE0
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}","-Dbot.token=${BOT_TOKEN}","-jar","/app.jar"]
