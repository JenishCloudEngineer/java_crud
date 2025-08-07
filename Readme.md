Java Spring Boot CRUD Web Application

Overview:
This is a full-stack Java Spring Boot CRUD (Create, Read, Update, Delete) web application.
It allows users to:
- Add records with names
- View all records in a table
- Edit existing records
- Delete records from the database

Technologies Used:
- Java 21
- Spring Boot
- Spring Data JPA
- HTML, CSS (Bootstrap)
- Thymeleaf 
- MySQL(can be configured)
- Git for version control
- Nginx (for reverse proxy)

Setup Instructions:

1. Clone the Project
$ git clone https://github.com/your-username/java_crud.git
$ cd java_crud

2. Configure Database MYSQL :
In application.properties:   src/main/resources/application.properties
spring.application.name=java_crud
spring.datasource.url=jdbc:mysql://localhost:3306/java
spring.datasource.username=your_dbusername	
spring.datasource.password=your_dbuserpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080

3. Run the Application
$ ./mvnw spring-boot:run
Access UI at: http://localhost:8080/ui/records

API Endpoints:
| Method | Endpoint               | Description         |
|--------|------------------------|---------------------|
| GET    | /api/records           | Get all records     |
| POST   | /api/records           | Create new record   |
| PUT    | /api/records/{id}      | Update record       |
| DELETE | /api/records/{id}      | Delete record       |
| GET    | /api/records/health    | Health check        |

UI Access:
http://localhost:8080/ui/records

Reverse Proxy with Nginx:
To expose this app on port 80 using Nginx, use the following config:

server {
    listen 80;
    server_name localhost;

    location / {
        proxy_pass http://localhost:8080/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}

This allows you to access the application via http://localhost instead of specifying the port.
