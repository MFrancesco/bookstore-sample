# Use OpenJDK 21 JRE Alpine image as the base image
FROM eclipse-temurin:21-jre-alpine

WORKDIR /work

RUN chown 1001:root /work \
    && chmod "g+rwX" /work

COPY --chown=1001:root target/bookstore*.jar /work/app.jar

EXPOSE 8080
USER 1001

ENTRYPOINT ["java", "-jar", "app.jar"]