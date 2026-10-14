# PROJECT_WHOLE_MINI_APPLICATION
this is an application which contains login register page and note page. In this application userpassword hashing using BCrypt, data encryption using  TextEncryptor and delux and also simple Logger are provided


to run this application:
first open terminal in ide
then run this command:

mvn clean install


in application.properties i have cofigured my db as the name of infoDB. If u wanna change this you have to change it from there
also to secure the application db password and AES password and salt as well as db password are exported to enviromental variables 
but this will be work only in my terminal 

to configure and export the variables:

spring.datasource.password=${DB_PASSWORD}
diary.password=${DIARY_PASSWORD}
diary.salt=${DIARY_SALT}

all of three are containing only keys but you gotta give the variables

to do it open terminal and run these commands:


export DB_PASSWORD='your password'
export DIARY_PASSWORD='your diary_password'
export DIARY_SALT='salt_value'

then to run it just run java from SpringBootSecurityApplication.java





