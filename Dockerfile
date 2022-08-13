FROM openjdk:17-jdk-alpine
ENV WD /usr/local/report-builder-api
ENV JAVA_OPTS "-Xms128m -Xmx2048m"
WORKDIR $WD
COPY ./build/libs $WD
EXPOSE 8080
ENTRYPOINT java -jar $JAVA_OPTS report-builder-api.jar