# Documentation

## Contents
- **Project Name**: F~School V001
- **Type**: E_Learning Plateform
- **Developer Name**: KASSOURI Tahar (0xMsnsnCXI) – alias ‘Msnsn’  
- **Technologies**: Java, Jakarta EE (Servlet & JSP), JDBC, Apache Tomcat, MySQL, JavaScript
- **Start Date**: 25-07-2025
- **Finish Date**: 09-08-2025  

## Introduction

### Why does this project exist?
**Problems**
- Nowadays there are many E-Learning Plateforms, and they are all sharing expensive courses.
- I've created this plateforme to share courses only for free. Because LEARNING SHOULD BE FREE !  

**Goals** 
- This application allows people to publish there courses, and share there knowledge completely for free.  
- Everybody can get knowledge even if he has not money.  
- Everyone can ask people for knowledge in a public Chat Room, and anybody can answer !  

## Requirements

**Objectives** 
- Make Learning Free.  
- Make big connections with people, and start networking for knowledge.  

**Users**
- Everybody

**Main Functionalities**
- Publish Courses completely for free and share your knowledge.
- Search for knowledge and get it for free.
- Ask people in a public Chat Room and get Answers for your questions.

## Functional Analysis

**Diagrams**

> **Actors**:
- Everybody

> **Actions**:
- Add, update, delete and show your own Courses
- Send Messages
- Read others Courses

## Data Analysis

### Database

-- =========================
-- Database
-- =========================

-- =========================
-- Table Chatroom
-- =========================

CREATE TABLE `chatroom` (
  `id` int Primary Key Auto Increment,
  `unm` varchar(50) NOT NULL,
  `msg` text NOT NULL,
  `sent_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB

-- =========================
-- Table Users
-- =========================

 CREATE TABLE `users` (
  `id` int Primary Key AUTO_INCREMENT,
  `fnm` varchar(50) NOT NULL,
  `snm` varchar(50) NOT NULL,
  `unm` varchar(50) NOT NULL,
  `func` varchar(500) NOT NULL,
  `city` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `psw` varchar(100) NOT NULL,
  `avatar` varchar(100) NOT NULL,
  `score` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB

-- =========================
-- Table Courses
-- =========================

CREATE TABLE `courses` (
  `id` int Primary Key Auto Increment,
  `unm` varchar(100) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `content` text NOT NULL,
  `published_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB

### Conception

**Architecture**
- MVC
- Model Design Pattern : DAO
- Data Access : JDBC
- Controller : Servlet
- View : JSP

**Technologies**
- Backend : Java - Jackarta EE (Servlet & JSP)
- Frontend : HTML, JSP, CSS, JS
- Base de donnees : MySql


### Realisation
- 7 JSP Pages for Views with 7 CSS Pages for Style and 7 JS Pages
- 16 Servlet Pages for Controllers
- 4 Java Classes Pages for Model
- 2 Java Classes Pages for Web Sockets

### Tests
- Unit Tests with JUnit

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
