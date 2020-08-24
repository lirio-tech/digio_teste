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

- Presentation
- Application
- Domain
- Infrastructure

### Tests

![](https://docs.microsoft.com/pt-br/dotnet/architecture/modern-web-apps-azure/media/image9-1.png ) 

### Coverage Test

Jacoco: http://digio-teste.s3-website-us-east-1.amazonaws.com

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
cd devops/
sudo docker-compose up -d
```

### Deployed in EC2:   
http://ec2/swagger-ui.html   <LINK>

### Observability:   
Log: ...   
Tracing:       
Metrics: ...   

##### About me
LinkedIn: https://www.linkedin.com/in/diegolirio/   
Twitter: https://twitter.com/diegolirio   
Medium: https://medium.com/@diegolirio     
Dev.to: https://dev.to/diegolirio      
Wordpress: https://diegolirio.wordpress.com       
Github: https://github.com/diegolirio       
Instagram: https://www.instagram.com/diegolirio        