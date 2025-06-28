# Spring CRUD Console Application

This is a simple Java console-based CRUD (Create, Read, Update, Delete) application using the **Spring Framework** and **MySQL** database.

## 📌 Features

- Add new users
- View all users
- Search user by ID
- Update user information
- Delete user and reorder IDs (optional)

## 🛠️ Tech Stack

- Java
- Spring Framework (Core + JDBC)
- MySQL
- IntelliJ IDEA
- Maven

## 🧱 Database Setup

```sql
CREATE DATABASE spring_crud;

USE spring_crud;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);
