# Spring Native Playground

This repository contains a sample application using Spring Data JDBC, Spring Web, Testcontainers and the required configuration to compile and run a native image build.

# Structure

This application contains two separate domains: movies and books. One of the goals of this project is to demonstrate how to support multiple data sources for different purposes.
In this application, this means that the movies and books domain have their own database connections, but this can also be used for a primary / secondary database split that can be controlled on a per-repository basis.

In development, only a single database is used. The support for multiple databases is demonstrated in the integration tests.

A second goal of this application is demonstrating the usage of Test Containers in a Spring centric way. This is achieved by creating Beans that initialize the containers and having Spring manage the lifecycles.
Note that the Spring Initializer by default also generates these tests in a similar manner, but this structure is not yet commonly shown in documentation or blog posts.

# Building

This application is build using Maven. For convenience, the Maven wrapper script is included in this repository.

For a normal JAR build, use the following command:

```bash
./mvnw clean install
```

Native images can be build using Spring's native profile:

```bash
./mvnw -Pnative clean install spring-boot:process-aot spring-boot:process-test-aot spring-boot:build-image
```

# Running

In development, this application will automatically start the required Docker containers as configured in `compose.yml`.
This is handled by the `spring-boot-docker-compose` library.

For running the application as a native image, the `compose.yml` file has to be started manually.
After that, the image can be run. For ease of use, this example will bind the image to the host network.

```bash
docker compose up -d
docker run \
  --volume ./src/main/resources/application-container.properties:/application.properties \
  --publish 8080:8080 \
  --net=host \
  docker.io/library/native-playground:0.0.1-SNAPSHOT \
  -Dspring.config.location=/application.properties
```

# Testing

This application uses Testcontainers to provide the required databases during the tests.
As a result, this does require Docker or another compatible container runtime, such as Podman, to be present.

The application can be tested by running the following command:

```bash
./mvnw clean verify
```