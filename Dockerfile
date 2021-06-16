# This file is a template, and might need editing before it works on your project.

FROM maven:3.5-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jdk
ENV PORT 4567
EXPOSE 4567
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target

CMD ["java", "-jar", "find -type f -name '*-with-dependencies.jar' | xargs java -jar"]
