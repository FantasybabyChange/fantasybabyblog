/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015-11-15 21:25:18                          */
/*author: FantasyBaby*/
/*==============================================================*/

 DROP DATABASE IF EXISTS `fantasybabyblog`;
 CREATE DATABASE `fantasybabyblog` 
 DEFAULT CHARACTER SET utf8 
 COLLATE utf8_general_ci;
 USE fantasybabyblog;

DROP TABLE IF EXISTS _article;

DROP TABLE IF EXISTS _category;

DROP TABLE IF EXISTS _privilege;

DROP TABLE IF EXISTS _tag;

DROP TABLE IF EXISTS article_tag;

DROP TABLE IF EXISTS blog_user;

DROP TABLE IF EXISTS category_privilege;

DROP TABLE IF EXISTS category_type;

DROP TABLE IF EXISTS user_detail;

/*==============================================================*/
/* Table: _article                                              */
/*==============================================================*/
CREATE TABLE _article
(
   _uuid                CHAR(36),
   _id                  SMALLINT NOT NULL AUTO_INCREMENT,
   title                VARCHAR(100),
   abstract             VARCHAR(300),
   author               VARCHAR(50),
   publish_user         SMALLINT,
   content              TEXT,
   STATUS               SMALLINT,
   category             SMALLINT,
   create_date          DATETIME,
   modify_date          DATETIME,
   publish_date         DATETIME,
   PRIMARY KEY (_id)
)ENGINE = INNODB;

/*==============================================================*/
/* Table: _category                                             */
/*==============================================================*/
CREATE TABLE _category
(
   _uuid                CHAR(36),
   _id                  SMALLINT NOT NULL AUTO_INCREMENT,
   categoryname          VARCHAR(30),
   categorycode          VARCHAR(30) UNIQUE,
   parentcode         VARCHAR(30),
   create_date          DATETIME,
   PRIMARY KEY (_id)
)ENGINE = INNODB;

/*==============================================================*/
/* Table: _privilege                                            */
/*==============================================================*/
CREATE TABLE _privilege
(
   _uuid                CHAR(36) NOT NULL,
   pid                  SMALLINT NOT NULL AUTO_INCREMENT,
   pname                VARCHAR(30),
   pcode                VARCHAR(30) UNIQUE,
   ppath                VARCHAR(300),
   parentcode             VARCHAR(30) ,
   is_show                TINYINT,
   `order`                  SMALLINT,
   PRIMARY KEY (pid)
)ENGINE = INNODB;

/*==============================================================*/
/* Table: _tag                                                  */
/*==============================================================*/
CREATE TABLE _tag
(
   _uuid               CHAR(36),
   _id                  SMALLINT NOT NULL AUTO_INCREMENT,
   tagName              VARCHAR(30),
   PRIMARY KEY (_id)
)ENGINE = INNODB;

/*==============================================================*/
/* Table: article_tag                                           */
/*==============================================================*/
CREATE TABLE article_tag
(
   _uuid               CHAR(36) NOT NULL,
   tagid                SMALLINT,
   userid               SMALLINT,
   PRIMARY KEY (_uuid)
)ENGINE = INNODB;

/*==============================================================*/
/* Table: blog_user                                             */
/*==============================================================*/
CREATE TABLE blog_user
(
   _uuid               CHAR(36) NOT NULL,
   _id                  SMALLINT NOT NULL AUTO_INCREMENT,
   username             VARCHAR(20),
   PASSWORD             VARCHAR(300),
   categorycode         VARCHAR(30),
   STATUS               TINYINT,
   create_date          DATETIME,
   modify_date          DATETIME,
   login_date           DATETIME,
   PRIMARY KEY (_id)
)ENGINE = INNODB;

ALTER TABLE blog_user COMMENT 'user in blog.they have their own category.like admin or view';

/*==============================================================*/
/* Table: category_privilege                                    */
/*==============================================================*/
CREATE TABLE category_privilege
(
   _uuid               CHAR(36) NOT NULL,
   privilegecode          VARCHAR(30),
   categorycode           VARCHAR(30),
   PRIMARY KEY (_uuid)
)ENGINE = INNODB;


/*==============================================================*/
/* Table: user_detail                                           */
/*==============================================================*/
CREATE TABLE user_detail
(
   _uuid               CHAR(36) NOT NULL,
   userid               SMALLINT,
   NAME                 VARCHAR(20),
   sex                  BOOL,
   phone                VARCHAR(12),
   email                VARCHAR(30),
   address              VARCHAR(50),
   hometown             VARCHAR(50),
   profession           VARCHAR(38),
   nickname             VARCHAR(20),
   image                VARCHAR(40),
   PRIMARY KEY (_uuid)
)ENGINE = INNODB;

ALTER TABLE user_detail COMMENT 'use to recording user''s information';

