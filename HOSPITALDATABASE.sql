

create table doctor( 
D_ID int NOT NULL,
Firstname varchar(500) NOT NULL,
speciliaze varchar(500) NOT NULL,
gender varchar(1),
fromworkingHours Varchar(500) not null,
toWorkingHours varchar(500) not null,
NumOfPatients int,
primary key(D_ID)
);

create table Patients(
P_ID int NOT NULL,
Firstname varchar(500) NOT NULL,
gender varchar(1),
Pcase varchar(500) not null,
illnessDescription varchar(500) not null,
primary key(P_ID)
);
create table nurse(
N_ID int NOT NULL,
Firstname varchar(500) NOT NULL,
gender varchar(1),
postion varchar(500),
fromworkingHours Varchar(500) not null,
toWorkingHours varchar(500) not null,
primary key(N_ID)
);
create table medicine(
serialNUmber int NOT NULL,
Mname varchar(500) NOT NULL,
price int NOT NULL,
stock varchar(500) not null,
quantity int,
EXdate int,
primary key(serialNUmber)
);
create table manager(
M_ID int NOT NULL,
Firstname varchar(500) NOT NULL,
gender varchar(1) not null,
primary key(M_ID )
);




Insert into doctor Values
(1,'abdulaziz al-momen','Surgery','M','8:00am','6:00pm',2),
(2,'ghazy al-shaikh','Neurology','M','8:00am','9:00pm',4),
(3,'hassan symbol','Anesthesiology','M','11:00am','12:00am',5),
(4,'james william','Surgery','M','9:00am','10:00am',6),
(5,'tariq al-malik','Neurology','M','7:00pm','8:00pm',1),
(6,'yasir al-qasir','Anesthesiology','M','11:00am','12:00am',10),
(7,'Zaina al-Iqbal','Surgery','F','9:00am','10:00am',8),
(8,'Kamal al-Hisham','Neurology','M','11:00am','12:00am',6),
(9,'Zahra al-Nadeem','Dermatology','F','8:00am','9:00pm',9),
(10,'Othman al-Rayan','Anesthesiology','M','8:00am','5:00pm',6),
(11,'hassan al-shaikh','Psychiatry','M','11:00am','12:00am',8);
Insert into Patients Values
(10,'Elham al-Nabila','F','Good','cold'),
(20,'Deen al-Fadel','M','Serious','HIV'),
(30,'Faheem al-Hakim','M','Critical','covid-19'),
(40,'ahmed al-mansur','M','Serious','covid-19'),
(50,'Amani al-wakil','F','Critical','amputee'),
(60,'Farah amari','F','Good','flesh wound'),
(70,'Qasim al-Najib','M','Good','broken arm'),
(80,'Sayf al-Suleiman','M','Critical','tuberculosis'),
(90,'Layla al-Salah','F','Critical','gunshot'),
(100,'Malika al-Shadi','F','Serious','cancer');
Insert into nurse Values
(101,'fatima Habib','F','Surgery','8:00am','6:00pm'),
(200,'nora Faheem','F','Neurology','11:00am','12:00am'),
(300,'latifa Burhan','F','Anesthesiology','11:00am','12:00am'),
(400,'Hafeez al-Alim','M','Surgery','11:00am','12:00am'),
(500,'Nasir al-Adnan','M','Dermatology','8:00am','6:00pm'),
(600,'Abdulwahab galil','M','Psychiatry','8:00am','6:00pm'),
(700,'Salim al-Shafiq','M','Psychiatry','11:00am','12:00am'),
(800,'Khadija al-Zayn','F','Anesthesiology','8:00am','6:00pm'),
(900,'Yusef al-Yunus','M','Psychiatry','11:00am','12:00am'),
(1000,'Nasira al-Zakariah','F','Neurology','8:00am','6:00pm');
Insert into medicine Values
(1001,'dolutegravir'  ,40,'available',50,2022),
(2002,'lamivudine'    ,50,'available',80,2070),
(3003,'Prezista'      ,90,'unavailable',0,2050),
(4004,'rituximab'     ,71,'available',50,2030),
(5005,'pregabalin'    ,15,'available',80,2057),
(6006,'Rosuvastatin'  ,78,'unavailable',0,2025),
(7007,'Fentanyl'      ,51,'available',50,2069),
(8008,'Omeprazole'    ,78,'available',90,2034),
(9009,'Trazodone'    ,33,'available',18,2045),
(100001,'Xanax'      ,10,'available',100,2034);
Insert into manager Values
(5,'jabir al-jabir','M'),
(4,'ahmed al-alsaif','M');
