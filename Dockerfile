FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/orderprocessor-app-0.0.1.jar app.jar
ENTRYPOINT sh -c 'java -jar app.jar \
  --spring.datasource.url=$SPRING_DATASOURCE_URL \
  --spring.datasource.driver-class-name=org.postgresql.Driver \
  --spring.datasource.username=$SPRING_DATASOURCE_USERNAME \
  --spring.datasource.password=$SPRING_DATASOURCE_PASSWORD'