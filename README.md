# GKPProductCatalogueManager


Run locally using -

mvn spring-boot:run

Run Jar locally - 

java -jar target/GKPProductCatalogueManager-0.0.1-SNAPSHOT.jar

Local Swagger -
http://localhost:8080/swagger-ui/index.html#/hello-world-controller/sayHello

Create Docker Image locally - 

docker build -t productcm .

Run Docker Image locally - 

docker run -p 8080:8080 productcm:latest

Tag and push to DockerHub -
docker tag productcm garethpark/productcm:latest
docker push garethpark/productcm:latest


