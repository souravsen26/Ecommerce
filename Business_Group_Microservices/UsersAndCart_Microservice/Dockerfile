FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 8353
EXPOSE 8353
COPY target/*.jar /opt/UserandCart.jar
ENTRYPOINT exec java $JAVA_OPTS -jar UserandCart.jar