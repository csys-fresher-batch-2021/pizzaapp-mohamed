create table cartdetails(id serial primary key,
						 user_id int not null,
						 constraint cartdetails_user_id_fkey foreign key(user_id) references userregister(userid),
						 product_id int not null,
						 constraint cartdetails_product_id_fkey foreign key(product_id) references addproduct(productid)
    );
	
select *from cartdetails;