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

	private OrderDao() {
		// Default Constructor
	}

	/**
	 * Connect to connection util then set values in model class variables and
	 * insert in a db
	 * 
	 * @param orders
	 */
	public static void addOrder(Order orders) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into orderpizza(user_id,product_id,orderdate,ordertime,pizzatype,quantity,price,totalamount,gstamount,deliverytime,deliverydate) values(?,?,?,?,?,?,?,?,?,?,?)";
			User user = orders.getUser();
			Product product = orders.getProduct();
			Date orderDate = java.sql.Date.valueOf(orders.getDate());
			Date deliveryDate = java.sql.Date.valueOf(orders.getDeliveryDate());
			Time orderTime = java.sql.Time.valueOf(orders.getTime());
			Time deliveryTime = java.sql.Time.valueOf(orders.getDeliveryTime());
			pst = connection.prepareStatement(sql);
			pst.setInt(1, user.getUserid());
			pst.setInt(2, product.getId());
			pst.setDate(3, (java.sql.Date) orderDate);
			pst.setTime(4, orderTime);
			pst.setString(5, orders.getPizzaName());
			pst.setInt(6, orders.getQuantity());
			pst.setDouble(7, orders.getPrice());
			pst.setDouble(8, orders.getTotalAmount());
			pst.setDouble(9, orders.getGstAmount());
			pst.setTime(10, deliveryTime);
			pst.setDate(11, (java.sql.Date) deliveryDate);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to show bill");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

	/**
	 * get all values in db
	 * 
	 * @return
	 * @throws DBException
	 */

	public static List<Order> getBillList() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<Order> list = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from orderpizza";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				Order order = new Order();
				Date date = result.getDate("orderDate");
				Time orderTime = result.getTime("orderTime");
				String pizzaType = result.getString("pizzaType");
				int quantity = result.getInt("quantity");
				float price = result.getFloat("price");
				float totalAmount = result.getFloat("totalAmount");
				Double gstAmount = result.getDouble("gstAmount");
				Time deliveryTime = result.getTime("deliveryTime");
				Date deliveryDate= result.getDate("deliveryDate");
				LocalDate orderDate = ((java.sql.Date) date).toLocalDate();
				//LocalDate deliveryDate1=((java.sql.Date) deliveryDate).toLocalDate();
				//LocalTime orderTime1 = orderTime.toLocalTime();
				//LocalTime deliveryTime1 = deliveryTime.toLocalTime();
				order.setDate(orderDate);
				order.setTime( orderTime.toLocalTime());
				order.setPizzaName(pizzaType);
				order.setQuantity(quantity);
				order.setPrice(price);
				order.setTotalAmount(totalAmount);
				order.setGstAmount(gstAmount);
				order.setDeliveryTime(deliveryTime.toLocalTime());
				order.setDeliveryDate(((java.sql.Date) deliveryDate).toLocalDate());
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

	/**
	 * get all list in db for admin use
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<Order> getAdminBillList() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<Order> list = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select u.name as username,ap.productname as productname,o.product_id,o.orderdate,o.ordertime,o.pizzatype,o.quantity,\r\n"
					+ "o.price,o.totalamount,o.gstamount,o.deliverytime,o.deliverydate \r\n"
					+ "from orderpizza o,addproduct ap,userregister u where o.user_id = u.userid and o.product_id = ap.productid;";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				Order order = new Order();
				User user = new User();
				String userName = result.getString("username");
				user.setName(userName);
				Product product = new Product();
				int productId = result.getInt("product_id");
				product.setId(productId);
				Date date = result.getDate("orderdate");
				Time orderTime = result.getTime("ordertime");
				String pizzaType = result.getString("pizzatype");
				int quantity = result.getInt("quantity");
				float price = result.getFloat("price");
				float totalAmount = result.getFloat("totalamount");
				Double gstAmount = result.getDouble("gstamount");
				Time deliveryTime = result.getTime("deliverytime");
				Date deliveryDate= result.getDate("deliveryDate");
				LocalDate orderDate = ((java.sql.Date) date).toLocalDate();
				LocalDate deliveryDate1=((java.sql.Date) deliveryDate).toLocalDate();
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
				order.setDeliveryDate(deliveryDate1);
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

	/**
	 * get all values in db for use in user
	 * 
	 * @param userid
	 * @return
	 */
	public static List<Order> getUserOrders(Integer userid) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<Order> list = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select u.name as username,ap.productname as productname,o.product_id,o.orderdate,o.ordertime,o.pizzatype,o.quantity,\r\n"
					+ "o.price,o.totalamount,o.gstamount,o.deliverytime,o.deliverydate \r\n"
					+ "from orderpizza o,addproduct ap,userregister u where o.user_id = u.userid and o.product_id = ap.productid and u.userid=?;";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userid);
			result = pst.executeQuery();
			while (result.next()) {
				Order order = new Order();
				User user = new User();
				String userName = result.getString("username");
				user.setName(userName);
				Product product = new Product();
				int productId = result.getInt("product_id");
				product.setId(productId);
				Date date = result.getDate("orderdate");
				Time orderTime = result.getTime("ordertime");
				String pizzaType = result.getString("pizzatype");
				int quantity = result.getInt("quantity");
				float price = result.getFloat("price");
				float totalAmount = result.getFloat("totalamount");
				Double gstAmount = result.getDouble("gstamount");
				Time deliveryTime = result.getTime("deliverytime");
				Date deliveryDate= result.getDate("deliveryDate");
				LocalDate orderDate = ((java.sql.Date) date).toLocalDate();
				LocalDate deliveryDate1=((java.sql.Date) deliveryDate).toLocalDate();
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
				order.setDeliveryDate(deliveryDate1);
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
