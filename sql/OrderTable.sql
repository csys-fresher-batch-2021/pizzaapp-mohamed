create table OrderPizza1(order_id serial primary key,
						 user_id int not null,
						 constraint orderpizza1_user_id_fkey foreign key(user_id) references userregister3(userid),
						 product_id int not null,
						 constraint orderpizza1_product_id_fkey foreign key(product_id) references addproduct(productid),
						 orderDate date,orderTime time,pizzatype1 varchar (20) not null,
						 quantity int not null,price float not null,totalAmount float not null,
						 gstAmount float not null,deliveryTime time not null);
						 
select * from OrderPizza1;