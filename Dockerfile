FROM openjdk:8-jre-alpine

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/brady.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# Add the service itself
ADD TomBradyFacts-0.0.1-SNAPSHOT.jar /usr/share/myservice/brady.jar