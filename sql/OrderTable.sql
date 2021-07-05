create table orderpizza(order_id serial primary key,
						 user_id int not null,
						 constraint orderpizza_user_id_fkey foreign key(user_id) references userregister(userid),
						 product_id int not null,
						 constraint orderpizza_product_id_fkey foreign key(product_id) references addproduct(productid),
						 orderDate date,orderTime time,pizzatype varchar (20) not null,
						 quantity int not null,price float not null,totalAmount float not null,
						 gstAmount float not null,deliveryTime time not null,deliverydate date not null);
						 
select * from orderpizza;