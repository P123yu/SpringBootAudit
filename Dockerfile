# --- STAGE 1: Build the application ---
# We are now using a Maven base image that includes both Maven and a JDK.
# This fixes the "mvn: not found" error in the previous build attempt.
FROM maven:3.9-eclipse-temurin-21-jammy AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (pom.xml) first.
# This is a key optimization. Docker will cache this layer, and only re-run
# the `RUN` command if the pom.xml changes, speeding up subsequent builds.
COPY pom.xml .

# Download project dependencies based on the pom.xml.
# This also gets cached and saves time.
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline

# Copy the source code (the rest of the project files)
COPY src ./src

# Build the Spring Boot application. This will create the executable JAR.
RUN mvn package -DskipTests

# --- STAGE 2: Create the final, lightweight runtime image ---
# We switch to a JRE image, which is much smaller than the JDK image.
# This image only contains the necessary runtime environment to run the Java application.
FROM eclipse-temurin:21-jre-jammy

# Set the working directory for the final image.
WORKDIR /app

# Copy the executable JAR from the 'builder' stage into this final image.
# The JAR file is located in the target directory after the Maven build.
# We rename it to 'app.jar' for simplicity.
COPY --from=builder /app/target/*.jar ./app.jar

# Expose the port that the Spring Boot application runs on.
# By default, Spring Boot uses port 8080.
EXPOSE 8080

# The command to run when the container starts.
# 'java -jar app.jar' is the standard way to run a Spring Boot executable JAR.
ENTRYPOINT ["java", "-jar", "app.jar"]

# This is an optional, but useful, instruction to specify a non-root user.
# It enhances security by not running the application as 'root'.
# However, this depends on the base image having a non-root user available.
# USER 1000
