# Digio Teste

### Tecnologies   

- Java 11 - OK
- Spring Boot 2 - OK
- MongoDB - OK
- Swagger - OK
- Jacoco
- Maven - OK
- BeanValidation
- Docker

### Code Arquitecture

<<< Doc Piramide >>>

- Presentation
- Application
- Domain
- Infrastructure

### Coverage Test

Jacoco:   

<<< Doc Piramide >>>

### Run Application

- Maven
```sh
mvn clean package spring-boot:run
```

- Jar
```sh
java -jar digio_teste.jar
```

- Docker
```sh
sudo docker-compose up -d
```

### Deployed in EC2:   
http://ec2/swagger-ui.html   

### Observability:   
Log:    
Tracing:      
Metrics:   