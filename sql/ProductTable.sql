CREATE TABLE addproduct(
	productid int not null primary key,
	productname varchar(20) NOT NULL,
	productprice float NOT NULL
);
select * from addproduct;

drop table addproduct;