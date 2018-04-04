FROM openjdk:8-jre-alpine

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/brady.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/myservice/brady.jar