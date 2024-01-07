create database film_db;

use film_db;

create table filmkatalogus (

	azonosito varchar(10) NOT NULL PRIMARY KEY,
    megnevezes varchar(50) NOT NULL,
    bemutatas int NOT NULL,
    bevetel int NOT NULL,
    oscar bit NOT NULL);
    
insert into filmkatalogus VALUES ('F0000001','Avatar',2009,750000000,1);
insert into filmkatalogus VALUES ('F0000002','Titanic',1997,600000000,1);
insert into filmkatalogus VALUES ('F0000003','Pókember',2002,403000000,0); 
insert into filmkatalogus VALUES ('F0000004','A vasember',2008,318000000,0);
insert into filmkatalogus VALUES ('F0000005','Fel!',2009,293000000,1);
insert into filmkatalogus VALUES ('F0000006','Gravitáció',2013,274000000,1); 
insert into filmkatalogus VALUES ('F0000007','Legenda vagyok',2007,256000000,0);




