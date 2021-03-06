## javaweb_asm4
## PRJ321x_02 ASM 4

# HOW TO CONFIGURE DATABASE LOCALLY TO RUN THIS PROJECT ON YOUR LOCAL MACHINE

This project is using MySQL as local database.
The default configure infromation as below:

```
MySQL
port: 3306
user: root
password: password
schema name: mysql_database
```
Other configure:
```
IDE: Spring-tool-suite-4
Java version: 11
Tomcat 9.0
Packing: JAR
```

If you set up a database to run with difference information, please reconfigure file as steps below
1. Open the project by your favorite IDE (Spring-tool-suite 4 is recommended):
Go to > PRJ321x_Asm4 > src/main/resources > open file application.properties
```
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/[your_schema_name]
spring.datasource.username=[your_user_name]
spring.datasource.password=[your_pass_word]
spring.jpa.properties.hibernate.format_sql=true
```

2. Open MySQL Workbench, in your schema create a new table named "accounts"
```
CREATE TABLE accounts (
    id INT,
    email varchar(255),
    password varchar(255),
    FirstName varchar(255),
    LastName varchar(255)
);
```

Thank you very much!
FX03283 | HO Nhat Minh
