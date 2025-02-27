FROM openjdk:21.0.2

WORKDIR /app

COPY --from=build /app/target/starLife-0.0.1-SNAPSHOT.jar app.jar

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests -Dmaven.repo.local=/app/.m2/repository


EXPOSE 9191

CMD ["java", "-jar", "app.jar"]