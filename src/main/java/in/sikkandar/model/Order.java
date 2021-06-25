package in.sikkandar.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * set variables in private
 * 
 * @author moha2636
 *
 */
public class Order {
	private Integer id;
	private User user;
	private Product product;
	private String pizzaName;
	private Integer Quantity;
	private Double price;
	private Double totalAmount;
	private LocalDate date;
	private LocalTime time;
	private LocalTime deliveryTime;
	private Double gstAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(Double gstAmount) {
		this.gstAmount = gstAmount;
	}

	public Order() {

	}

	/**
	 * set a to-string method
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", product=" + product + ", pizzaName=" + pizzaName
				+ ", Quantity=" + Quantity + ", price=" + price + ", totalAmount=" + totalAmount + ", date=" + date
				+ ", time=" + time + ", deliveryTime=" + deliveryTime + ", gstAmount=" + gstAmount + "]";
	}

}
