# Java REST service with Spring Boost

## What is this?
This is the result of following [this guide](https://spring.io/guides/tutorials/rest/) on spring.io.

I also used bits and tips from [here](https://fullstackdeveloper.guru/2020/05/01/how-to-integrate-sqlite-database-with-spring-boot/) to setup SQLite as the database.

This tutorial guides a new developer through the task of building an endpoint to handle the backend of an employee payroll application.

## Why?
To learn spring boot basics for current and future work.

## How?
Without any help from an IDE, just vscode and maven.

Why would you ask?
Because I have seen this tendency on myself and other developers to rely on intelligent tools to do their work and suffer as a consequence.

I believe a builder should master his tools, be able to build uppon them, and understand each layer of his stack.

Otherwise we are doomed to see how those tools fall to automation entropy and codebases grow into higly complex constructs designed to be parsed and analyzed by machines, not humans.

I think we will eventually get there, but hopefully the limits of human cognition will be amplified to understand such codebases.

For now, we will need to keep it as simple as possible, and that means getting really deep knowledge about our tools or simply not use them.

## How to run it?
`mvn clean spring-boot:run`

## What I learned.
This exercise is used as a tool to learn the following concepts:
- JPA repositories
- Spring Boot Controllers
- Spring Boot Controller advices
- How to setup a SQLite database with Spring Boot.
- Spring HATEOAS
- How to build a RESTful service with Spring Boot.