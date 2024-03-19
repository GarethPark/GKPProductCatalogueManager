# GKPProductCatalogueManager


Run locally using -

mvn spring-boot:run

Build

mvn clean install

Run Jar locally - 

java -jar target/GKPProductCatalogueManager-0.0.1-SNAPSHOT.jar

Local Swagger -
http://localhost:8080/swagger-ui/index.html#/hello-world-controller/sayHello

Create Docker Image locally (so correct architecture for openshift) - 

docker buildx build --platform linux/amd64 -t productcm:latest .

Run Docker Image locally - 

docker run -p 8080:8080 productcm:latest

Tag and push to DockerHub -
docker tag productcm garethpark/productcm:latest
docker push garethpark/productcm:latest


Create Helm Chart -
helm create productcm

Deploy to OpenShift 

helm upgrade productcm ./productcm