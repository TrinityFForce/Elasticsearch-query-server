FROM openjdk:17-jdk
LABEL maintainer="TrinityForce"
ARG JAR_FILE=build/libs/es-query-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} es-query-server.jar
ENTRYPOINT ["java", "-jar", "es-query-server.jar"]