# Stage: build
FROM maven:3.6.3-openjdk-14-slim AS ship-monitoring-build-stage

RUN useradd -m docker && echo "docker:docker" | chpasswd

COPY pom.xml /tmp/app/

RUN chown -R docker:docker /tmp/app

USER docker
RUN mvn -f /tmp/app/pom.xml dependency:resolve-plugins dependency:resolve

COPY src /tmp/app/src

RUN mvn -f /tmp/app/pom.xml clean package


#------------------------------
# Stage: run

FROM openjdk:14-slim

RUN apt-get update && apt-get -y install sudo
RUN useradd -m docker && echo "docker:docker" | chpasswd && adduser docker sudo
USER docker

COPY --from=ship-monitoring-build-stage /tmp/app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=80", "-jar","/app/app.jar"]
