# PROJECT_WHOLE_MINI_APPLICATION

This is an application which contains a login/register page and a note page.
- User passwords are hashed using **BCrypt**
- Data is encrypted using **TextEncryptor** (AES)
- A simple **Logger** is also provided

## How to run

1. Open the terminal in your IDE
2. Run this command:

```bash
mvn clean install
```

## Database configuration

In `application.properties` the database is configured with the name `infoDB`.
If you want to use another name, change it there.

## Environment variables

To keep the application secure, the DB password, the AES password and the salt are exported as environment variables.
These variables work only in the terminal where you export them.

`application.properties` contains only the keys:

```properties
spring.datasource.password=${DB_PASSWORD}
diary.password=${DIARY_PASSWORD}
diary.salt=${DIARY_SALT}
```

You need to provide the values yourself. Open the terminal and run:

```bash
export DB_PASSWORD='your password'
export DIARY_PASSWORD='your diary_password'
export DIARY_SALT='salt_value'
```

## Start the application

Run `SpringBootSecurityApplication.java` from your IDE (or from the same terminal where you exported the variables):

```bash
mvn spring-boot:run
```





