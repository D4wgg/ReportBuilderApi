FROM openjdk:17-jdk-alpine
ENV WD /usr/local/report-builder-api
ENV JAVA_OPTS "-Xms128m -Xmx1024m"
WORKDIR $WD
COPY ./build/libs $WD
EXPOSE 9081
ENTRYPOINT java -jar $JAVA_OPTS report-builder-api.jar