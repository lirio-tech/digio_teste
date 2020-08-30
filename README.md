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

![](https://i1.wp.com/www.mountaingoatsoftware.com/uploads/blog/Testpyramid.jpg ) 

### Coverage Test

`Jacoco`:  http://digio-teste.s3-website-us-east-1.amazonaws.com 

### Quality

`Sonar`: http://registry.springhome.com.br/dashboard?id=br.com.digio:digio_teste   

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
`API`: http://ec2-35-170-67-146.compute-1.amazonaws.com:8080/swagger-ui.html#/lancamento-contabil-controller   


### Observability:   
`Log`: No Time      
`Tracing`: http://ec2-35-170-67-146.compute-1.amazonaws.com:16686/          
`Metrics`: http://ec2-35-170-67-146.compute-1.amazonaws.com:3000/d/E1ZtG-NMk/digio-spring-boot?orgId=1 or http://ec2-35-170-67-146.compute-1.amazonaws.com:9090/graph?g0.range_input=15m&g0.expr=system_cpu_usage&g0.tab=0   
   

### Deploy in Kubernetes

```shell script
sudo mvn clean package -P default fabric8:build fabric8:push 
```

```yaml
---
apiVersion: v1
kind: List
items:
- apiVersion: v1
  kind: Service
  metadata:
    labels:
      expose: "true"
      app: digio_teste
      provider: fabric8
      version: 0.0.1-SNAPSHOT
      group: br.com.digio
    name: digio_teste
  spec:
    ports:
    - nodePort: 30080
      port: 8080
      protocol: TCP
      targetPort: 8080
    selector:
      app: digio_teste
      provider: fabric8
      group: br.com.digio
    type: LoadBalancer
- apiVersion: extensions/v1beta1
  kind: Deployment
  metadata:
    labels:
      app: digio_teste
      provider: fabric8
      version: 0.0.1-SNAPSHOT
      group: br.com.digio
    name: digio_teste
  spec:
    replicas: 1
    selector:
      matchLabels:
        app: digio_teste
        provider: fabric8
        group: br.com.digio
    template:
      metadata:
        labels:
          app: digio_teste
          provider: fabric8
          version: 0.0.1-SNAPSHOT
          group: br.com.digio
      spec:
        containers:
        - env:
          - name: KUBERNETES_NAMESPACE
            valueFrom:
              fieldRef:
                fieldPath: metadata.namespace
          - name: SPRING_PROFILES_ACTIVE
            value: default
          image: diegolirio/digio_teste:0.0.1-SNAPSHOT
          imagePullPolicy: Always
          name: spring-boot-starter-parent
          securityContext:
            privileged: false
```   

```shell script
kubectl apply -f kubernetes.yml
```

##### About me
`LinkedIn`: https://www.linkedin.com/in/diegolirio/   
`Twitter`: https://twitter.com/diegolirio   
`Medium`: https://medium.com/@diegolirio     
`Dev.to`: https://dev.to/diegolirio      
`Wordpress`: https://diegolirio.wordpress.com   
`Github`: https://github.com/diegolirio       
`Instagram`: https://www.instagram.com/diegolirio        