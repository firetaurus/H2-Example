# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
RUN apk add --no-cache bash
# copy WAR into image
COPY /target/h2-example-0.0.1-SNAPSHOT.jar /app.jar
# copy xml file into image
COPY logback.xml /logback.xml
# copy sh file into image
#COPY run.sh /run.sh
## run application with this command line
#ENTRYPOINT ["/run.sh"]

CMD java -Dspring.profiles.active=dev -Dlogging.config=/logback.xml -jar /app.jar
