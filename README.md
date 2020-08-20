# Digio Teste

### Tecnologies   

- Java 11 
- Spring Boot 2 
- MongoDB 
- Swagger 
- Jacoco 
- Maven 
- BeanValidation
- Docker

### Code Arquitecture

<<< Doc Piramide >>>

- Presentation
- Application
- Domain
- Infrastructure

### Coverage Test

Jacoco:   <LINK>

Ref.: https://mkyong.com/maven/maven-jacoco-code-coverage-example/

### Quality

Sonar: http://registry.springhome.com.br/dashboard?id=br.com.digio:digio_teste   

### Run Application

- Maven
```sh
mvn clean package spring-boot:run
```

- Jar
```sh
mvn clean package
cd target/
java -jar -Dspring.profiles.active=default digio_teste-0.0.1-SNAPSHOT.jar
```

- Docker
```sh
sudo mvn clean verify sonar:sonar docker:build
sudo docker-compose up -d
```

### Deployed in EC2:   
http://ec2/swagger-ui.html   <LINK>

### Observability:   
Log: <LINK>   
Tracing: <LINK>      
Metrics: <LINK>   

##### About me
LinkedIn:   
Twitter:   
Medium:   
Dev.to:   
Wordpress:   
Github:   
Instagram:   

### Tasks - Delete me

- BeanValidation OK   

- Internacionalizon BeanValidation ?
- Prometheus
- Docker -> Dockerhub -> docker-compose.yml ?   
- Doc :: Piramide de Teste
- Doc :: Jacoco Link (S3)
- Deploy EC2 
- Link :: ELK
- Link :: Jaeger
- Link :: Grafana
- Link :: Sonar