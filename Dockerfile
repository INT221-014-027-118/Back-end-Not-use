FROM maven:3.8.1-jdk-11 AS MAVEN_BUILD

WORKDIR /build/

COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean package
RUN mvn package

FROM openjdk:11

COPY --from=MAVEN_BUILD build/target/*.jar Int221-0.0.1-SNAPSHOT.jar

EXPOSE 9091

CMD ["java", "-jar", "Int221-0.0.1-SNAPSHOT.jar"]