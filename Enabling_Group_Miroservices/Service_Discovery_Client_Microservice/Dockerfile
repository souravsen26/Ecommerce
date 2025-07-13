FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 8761
EXPOSE 8761


COPY target/*.jar /opt/discover-app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar discover-app.jar