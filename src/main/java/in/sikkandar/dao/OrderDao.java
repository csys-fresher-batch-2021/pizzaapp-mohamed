package in.sikkandar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import in.sikkandar.exception.DBException;
import in.sikkandar.model.Order;
import in.sikkandar.model.Product;
import in.sikkandar.model.User;
import in.sikkandar.util.ConnectionUtil;

public class OrderDao {

	public static void addOrder(Order orders) {

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into OrderPizza1(user_id,product_id,orderdate,ordertime,pizzatype1,quantity,price,totalamount,gstamount,deliverytime) values(?,?,?,?,?,?,?,?,?,?)";
			User user = orders.getUser();
			Product product = orders.getProduct();
			Date orderDate = java.sql.Date.valueOf(orders.getDate());
			Time orderTime = java.sql.Time.valueOf(orders.getTime());
			Time deliveryTime = java.sql.Time.valueOf(orders.getDeliveryTime());
			pst = connection.prepareStatement(sql);
			
			pst.setInt(1,user.getUserid());
			pst.setInt(2,product.getId());
			pst.setDate(3, (java.sql.Date) orderDate);
			pst.setTime(4, orderTime);
			pst.setString(5, orders.getPizzaName());
			pst.setInt(6, orders.getQuantity());
			pst.setDouble(7,orders.getPrice());
			pst.setDouble(8, orders.getTotalAmount());
			pst.setDouble(9, orders.getGstAmount());
			pst.setTime(10, deliveryTime);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst);

		}

	}

	public static List<Order> getBillList() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<Order> list = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select * from OrderPizza1";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				Order order = new Order();

				Date date = result.getDate("orderDate");
				Time orderTime = result.getTime("orderTime");
				String pizzaType = result.getString("pizzaType1");
				int quantity = result.getInt("quantity");
				float price = result.getFloat("price");
				float totalAmount = result.getFloat("totalAmount");
				Double gstAmount = result.getDouble("gstAmount");
				Time deliveryTime = result.getTime("deliveryTime");

				LocalDate orderDate = ((java.sql.Date) date).toLocalDate();
				LocalTime orderTime1 = orderTime.toLocalTime();
				LocalTime deliveryTime1 = deliveryTime.toLocalTime();

				order.setDate(orderDate);
				order.setTime(orderTime1);
				order.setPizzaName(pizzaType);
				order.setQuantity(quantity);
				order.setPrice(price);
				order.setTotalAmount(totalAmount);
				order.setGstAmount(gstAmount);
				order.setDeliveryTime(deliveryTime1);

				list.add(order);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to show bill");
		} finally {
			ConnectionUtil.close(connection, pst);

		}
		return list;
	}
	
	public static List<Order> getAdminBillList() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<Order> list = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select u.name as username,ap.productname as productname,o.product_id,o.orderdate,o.ordertime,o.pizzatype1,o.quantity,\r\n"
					+ "o.price,o.totalamount,o.gstamount,o.deliverytime \r\n"
					+ "from orderpizza1 o,addproduct ap,userregister3 u where o.user_id = u.userid and o.product_id = ap.productid;";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				Order order = new Order();

				User user = new User();
				String userName=result.getString("username");
				user.setName(userName);
				Product product = new Product();
				int productId=result.getInt("product_id");
				product.setId(productId);
				Date date = result.getDate("orderdate");
				Time orderTime = result.getTime("ordertime");
				String pizzaType = result.getString("pizzatype1");
				int quantity = result.getInt("quantity");
				float price = result.getFloat("price");
				float totalAmount = result.getFloat("totalamount");
				Double gstAmount = result.getDouble("gstamount");
				Time deliveryTime = result.getTime("deliverytime");

				LocalDate orderDate = ((java.sql.Date) date).toLocalDate();
				LocalTime orderTime1 = orderTime.toLocalTime();
				LocalTime deliveryTime1 = deliveryTime.toLocalTime();

				order.setUser(user);
				order.setProduct(product);
				order.setDate(orderDate);
				order.setTime(orderTime1);
				order.setPizzaName(pizzaType);
				order.setQuantity(quantity);
				order.setPrice(price);
				order.setTotalAmount(totalAmount);
				order.setGstAmount(gstAmount);
				order.setDeliveryTime(deliveryTime1);

				list.add(order);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to show bill");
		} finally {
			ConnectionUtil.close(connection, pst);

		}
		return list;
	}

	public static List<Order> getUserOrders(Integer userid) {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<Order> list = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select u.name as username,ap.productname as productname,o.product_id,o.orderdate,o.ordertime,o.pizzatype1,o.quantity,\r\n"
					+ "o.price,o.totalamount,o.gstamount,o.deliverytime \r\n"
					+ "from orderpizza1 o,addproduct ap,userregister3 u where o.user_id = u.userid and o.product_id = ap.productid and u.userid=?;";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userid);
			result = pst.executeQuery();
			while (result.next()) {
				Order order = new Order();

				User user = new User();
				String userName=result.getString("username");
				user.setName(userName);
				Product product = new Product();
				int productId=result.getInt("product_id");
				product.setId(productId);
				Date date = result.getDate("orderdate");
				Time orderTime = result.getTime("ordertime");
				String pizzaType = result.getString("pizzatype1");
				int quantity = result.getInt("quantity");
				float price = result.getFloat("price");
				float totalAmount = result.getFloat("totalamount");
				Double gstAmount = result.getDouble("gstamount");
				Time deliveryTime = result.getTime("deliverytime");

				LocalDate orderDate = ((java.sql.Date) date).toLocalDate();
				LocalTime orderTime1 = orderTime.toLocalTime();
				LocalTime deliveryTime1 = deliveryTime.toLocalTime();

				order.setUser(user);
				order.setProduct(product);
				order.setDate(orderDate);
				order.setTime(orderTime1);
				order.setPizzaName(pizzaType);
				order.setQuantity(quantity);
				order.setPrice(price);
				order.setTotalAmount(totalAmount);
				order.setGstAmount(gstAmount);
				order.setDeliveryTime(deliveryTime1);

				list.add(order);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to show bill");
		} finally {
			ConnectionUtil.close(connection, pst);

		}
		return list;
	}

}
