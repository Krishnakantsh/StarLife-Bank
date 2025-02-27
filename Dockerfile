FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy only essential files first
COPY pom.xml mvnw .mvn/ ./

# Ensure proper permissions and format for `mvnw`
RUN apt-get update && apt-get install -y dos2unix \
    && dos2unix mvnw \
    && chmod +x mvnw

COPY . .

RUN ./mvnw clean package -DskipTests 

EXPOSE 9191

ENTRYPOINT  ["java", "-jar", "target/starLife-0.0.1-SNAPSHOT.jar"]