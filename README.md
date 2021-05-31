# Test

-	Во решавањето на задачата е користена Јава 8 (1.8) верзија.  Сите 3 задачки се решени во еден проект во Spring Boot Java или во Spring Tool Suite. Задачите се решени со користење на back-end java и Spring Boot java, database со користење на PostgreSQL, и  front-end со користење на Thymeleaf, Bootstrap, HTML и CSS.

-	Прво се импортира проектот во Spring Tool Suite. Пред  да се стартува проектот во Spring Tool Suite треба да креираме датабаза во PostgreSQL  со истото име Book1 како во application.properties . Додека application.properties  се наоѓа во src/main/resources. Во application.properties  ги сетираме :
spring.jpa.hibernate.ddl-auto = create
spring.datasource.initialization-mode=always spring.datasource.data=file:src/main/resources/data_in_db.sql


 Откако ќе се стартува апликацијата и ќе се формираат табелите во датабазата со вредностите кои се импортирани во data_in_db.sql  за табелите type и formats тогаш сетираме во application.properties  :
spring.jpa.hibernate.ddl-auto = update
spring.datasource.initialization-mode = embedded


-	Откако веќе е стартувана апликацијата, за да ја гледаме на екран, тогаш на Google Chrome на address bar пишуваме http://localhost:8088/

-	Сега веќе ја гледаме апликацијата на Google Chrome и почнуваме да креираме листа на со автори. Откако ќе креираме листа со автори тогаш креираме листа со книги. И натаму ги тестираме сите webservices  од задача 3

-	Функциите од задача2 се решени со Query кои се наоѓаат во BookRepository. Кога се стартува апликацијата активно е само едно Query, кое може да се тестира во Search полето. 

-	Во пакетот com.example.book.entity, од задача 1 се креирани сите Еntities и сите потребни релации меѓу нив, кои се дефинирани во задачата.

Во секоја класа од пакетот com.example.book.entity се креирани, Constructors, Getters and Setters.
