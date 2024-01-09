# Starta från en base image som innehåller JDK 8
FROM openjdk:21-jdk

# Sätt arbetsmappen (där vi jobbar) till /app
WORKDIR /app

# Kopiera Maven till där vi är (.)
COPY mvnw .
COPY .mvn .mvn

# Kopiera pom-filen och källkoden
COPY pom.xml .
COPY src src

# Bygg applikationen
RUN ./mvnw clean package -DskipTests

# Kör applikationen
CMD ["java", "-jar", "target/2024_users_api-0.0.1-SNAPSHOT.jar"]

