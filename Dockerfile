FROM openjdk:jdk-alpine

ENV SCALA_VERSION 2.12.4

WORKDIR /app
EXPOSE 80
ADD target/scala-2.12/timeserieslab.jar /app/timeserieslab.jar
ADD static/index.html /app/static/index.html
ADD static/bundle.js /app/static/bundle.js
ADD static/help.html /app/static/help.html
ADD etc/entrypoint.sh /app/entrypoint.sh
ENTRYPOINT ["/bin/sh","/app/entrypoint.sh"]