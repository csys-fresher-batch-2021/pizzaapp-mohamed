package in.sikkandar.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import in.sikkandar.model.Order;
import in.sikkandar.model.Product;
import in.sikkandar.validator.OrederSheetValidation;

public class OrderSheetService {
	private OrderSheetService() {

	}

	private static final List<Order> orders = new ArrayList<>();

	public static boolean orderList(String pizzaType1, int quantity) {
		boolean isAdd = false;
		double price = 0;
		double gst=0.07;
		for (Product add : ProductService.getProducts()) {

			if (add.getName().equalsIgnoreCase(pizzaType1) && OrederSheetValidation.isValidProductQuantity(quantity)) {

				price = add.getPrice();
				double totalAmount = price * quantity;
				double gstAmount = (totalAmount * gst) + totalAmount;
				LocalTime orderTime = LocalTime.now();
				LocalTime deliveryTime = orderTime.plusMinutes(30);
				LocalDate date = LocalDate.now();
				Order order = new Order(pizzaType1, quantity, price, totalAmount, date, orderTime, deliveryTime,gstAmount);
				orders.add(order);
				
				isAdd = true;
				break;
			}
		}

		return isAdd;
	}

	
	public static List<Order> getOrders() {
		return orders;
	}

}
