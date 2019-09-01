FROM java:8-jre
MAINTAINER HiCooper <berry_cooper@163.com>

VOLUME /logs:/logs

ADD ./build/libs/*.jar /app/app.jar
CMD ["java", "-Xmx200m", "-jar", "/app/app.jar"]

EXPOSE 8761
