# islab
Keycloak, Microservice, OpenIDConnect, OAuth2

Generelle Infos:
Basis ist das Baeldung Tutorial zu Spring Boot Keycloak und OpenID Connect
https://www.baeldung.com/spring-boot-keycloak
https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-keycloak

Infos zum Einrichten des Keycloak Docker Containers:
https://hub.docker.com/r/jboss/keycloak

Admin Seite:
http://keycloak:8080/auth/

Login Seite für Produkte-Service:
http://product-service:8090/

# Creating Docker Network 
$ `docker network create my-net`

# Create Infrastructure
`sudo nano /private/etc/hosts`

Im Host-File sind folgende Einträge zu machen:
127.0.0.1       keycloak
127.0.0.1       product-service


URL f�r den Zugriff
http://product-service:8090/customers

