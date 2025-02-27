FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests -Dmaven.repo.local=/app/.m2/repository


EXPOSE 9191

CMD ["java", "-jar", "target/starLife-0.0.1-SNAPSHOT.jar"]