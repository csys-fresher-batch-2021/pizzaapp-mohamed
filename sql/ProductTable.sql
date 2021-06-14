CREATE TABLE addproduct(
	productid int  NOT NULL,
	productname varchar(20) NOT NULL,
	productprice float NOT NULL
	
);

select * from addproduct;

insert into addproduct(productid,productname,productprice)
values(104,'ChikenPizza',300);

drop table addproduct;