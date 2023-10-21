FROM maven:3.8.3-openjdk-11-slim AS maven_build

WORKDIR /build

# Copy the dependency specifications
COPY pom.xml pom.xml
COPY common/pom.xml common/pom.xml
COPY domain/pom.xml domain/pom.xml
COPY application/pom.xml application/pom.xml

#RUN mvn -q -pl common -am dependency:go-offline

COPY common common

RUN mvn -q -pl common install -DskipTests

#RUN mvn -q -pl domain -am dependency:go-offline

COPY domain domain

RUN mvn -q -pl domain install -DskipTests

#RUN mvn -q -pl application -am dependency:go-offline

COPY application application

RUN mvn package -DskipTests

FROM openjdk:11.0.15-slim as arithmetic-calculator-api

WORKDIR /app

COPY --from=maven_build /build/application/target/*.jar /app/arithmetic-calculator-api

EXPOSE 8080

CMD ["java", "-jar", "/app/arithmetic-calculator-api.jar"]
