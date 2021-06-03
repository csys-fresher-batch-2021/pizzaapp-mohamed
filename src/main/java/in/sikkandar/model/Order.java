package in.sikkandar.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
	private String pizzaName;
	private Integer Quantity;
	private double price;
	private double totalAmount ;
	private LocalDate date;
	private LocalTime time;
	private LocalTime deliveryTime;
	

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
	@Override
	public String toString() {
		return "Order [pizzaName=" + pizzaName + ", Quantity=" + Quantity + ", price=" + price + ", totalAmount="
				+ totalAmount + ", date=" + date + ", time=" + time + ", deliveryTime=" + deliveryTime + "]";
	}
	public Order(String pizzaName, Integer quantity, double price, double totalAmount, LocalDate date, LocalTime time,
			LocalTime deliveryTime) {
		super();
		this.pizzaName = pizzaName;
		this.Quantity = quantity;
		this.price = price;
		this.totalAmount = totalAmount;
		this.date = date;
		this.time = time;
		this.deliveryTime = deliveryTime;
	}
}



