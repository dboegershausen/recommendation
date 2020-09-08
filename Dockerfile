FROM openjdk:11-jre-slim

ENV TZ America/Sao_Paulo

COPY ./target/recommendation.jar /app/

ENTRYPOINT exec java $JAVA_OPTIONS -jar /app/recommendation.jar

EXPOSE 9000
