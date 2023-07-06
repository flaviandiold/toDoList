# To Do List
This is a web application to make a note of your 'To Dos', update it, mark them complete, and also to delete them. This application maintains sessions and also has a secure login page. This is built using Spring MVC, JSP, JPA, MySQL, and Docker.

# About
The Frontend (View) of the web application is implemented using JSPs and CSS.
The Backend is entirely implemented using various Java framework and technology, Spring Boot and Spring MVC.
The Database is implemented using Spring data JPA and Docker, therefore in order to work with the database you have to create a docker container.

#Instructions
Download the application as a .zip or pull the repo to your local machine.
Assuming you have docker set up in your machine, start docker's engine.
Run the following command in your terminal
  - docker run --detach --env MYSQL_ROOT_PASSWORD='root-password' --env MYSQL_USER='user-name' --env MYSQL_PASSWORD='user-password' --env MYSQL_DATABASE='user-database-name' --name mysql --publish 3307:3307 mysql:8-oracle
  - To create a new user in your MySql server, open 'MySQL Command Line Client' and run:
    - CREATE USER 'username'@localhost identified by 'password';
    - GRANT ALL PRIVILEGES ON * . * TO 'username'@localhost;
  - Open terminal with the path='C:/Program Files//MySQL/MySQL Server 8.0/bin and run:
    - mysql -u 'username' -p 'password'
    - CREATE database 'user-database-name'
Then run the application.
                                                                                          
       
