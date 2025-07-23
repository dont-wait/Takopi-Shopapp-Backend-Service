FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} shopapp.jar

ENTRYPOINT ["java", "-jar", "shopapp.jar"]

EXPOSE 6789
