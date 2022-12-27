# Simple Student Management 

## Introduction

This web application was developed to enable the insertion of student data into a database and its retrieval through REST APIs. The application is cloud-native and can be easily deployed to any Kubernetes environment with no code changes required.

To develop this application, a range of technologies were used, including Java and Spring Boot for the web server, Hibernate/JPA for object-relational mapping, H2DB for data persistence, Github Actions for the CI pipeline, Docker for containerization, and Kubernetes service and deployment YAML files to expose the service to the internet and deploy it on Kubernetes, respectively.

Overall, this application aims to provide a robust and scalable platform for storing and accessing student data in a cloud environment.

## Solution Architecture
![studentmangement](https://user-images.githubusercontent.com/57875037/209705087-af7c7cba-16c2-42e5-aa61-bb94fa73b27c.png)

This application was developed with a focus on design principles that aim to improve code quality and handle design complexity effectively. These principles include:

Single Responsibility Principle (SRP) </br>
Open/Closed Principle (OCP) </br>
Liskov Substitution Principle (LSP) </br>
Interface Segregation Principle (ISP) </br>
Dependency Inversion Principle (DIP) </br>
</br>
The application contains two different REST endpoints, one for POST requests and one for GET requests. These endpoints are capable of persisting student data into the database and retrieving it, respectively. Both endpoints were designed with best practices and REST naming conventions in mind, ensuring their ease of use and maintainability.

## Insert Student Data
![test1](https://user-images.githubusercontent.com/57875037/209705357-c5cd3c28-7efe-44f1-a02d-29bcad2fe440.png)

## Retrieve Student Data
![test2](https://user-images.githubusercontent.com/57875037/209705469-45bc0ae1-1111-44c0-9b88-e2ab9b789e12.png)

As above screenshots depict, even though password was inserted, it was not returning with the GET request since password consider as sensitive field and ignored.

All the possible exceptions were handled with try catch statements which will help to keep the application up and running all the time even though exception occurred. It increases the stability and availability of the system.

## Containerization
Application was containerized using Docker and could be deployed on any Kubernetes cluster without changing single line of code.

## Containerize Architecture
![docker](https://user-images.githubusercontent.com/57875037/209705616-2901a7b9-8ff2-43fc-b2ef-04355c77233a.png)

## Dockerize commands
```
docker build -f Dockerfile -t student-management-service .
```
```
docker run --rm -p 8080:8080 student-management-service:latest
```

## Deployment on Kubernetes
Application is cloud native and supports Kubernetes by nature since the containerization. Application is being deployed as pod inside the cluster and exposed it as Kubernetes service which allow outsiders to access the application endpoints. Pod will be replication which will provide high availability and ensure the reliability of the system. Kubernetes pod resource configuration were done to respond and replicate on demand in order to keep the availability and stability of the system.

## Deployment Architecture
![Design3](https://user-images.githubusercontent.com/57875037/136676867-19bd6a29-d96f-4eed-b031-cc71dea0e306.png)

## Deployment Commands
```
kubectl apply -f deployment.yaml
```
```
kubectl apply -f pod.yaml
```
```
kubectl apply -f service.yaml
```
```
kubectl apply -f ingress.yaml
```

Above command will deploy entire application on Kubernetes cluster
