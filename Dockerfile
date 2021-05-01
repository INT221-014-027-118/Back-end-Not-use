FROM maven:3.6.3-openjdk-11 AS MAVEN_BUILD


COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM adoptopenjdk:11-jre-openj9

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/spring-boot-jpa-h2-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-jar", "spring-boot-jpa-h2-0.0.1-SNAPSHOT.jar"]