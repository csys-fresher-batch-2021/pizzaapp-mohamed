create database Register_db

CREATE TABLE userregister3(
	userid serial primary key,
	name varchar(20) NOT NULL,
	email varchar(20) unique NOT NULL,
    mobilenumber bigint NOT NULL,
    address varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    confirmpassword varchar(20) NOT NULL
);

select * from userregister3;

insert into userregister3(name,email,mobilenumber,address,password,confirmpassword)
values('sikkandar','sikkandar@gmail.com',9698612143,'trichy','Sikkandar@123','Sikkandar@123');