package in.sikkandar.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import in.sikkandar.model.Order;
import in.sikkandar.model.Gst;
import in.sikkandar.model.Product;
import in.sikkandar.validator.OrederSheetValidation;

public class OrderSheetService {
	private OrderSheetService() {

	}

	private static final List<Order> orders = new ArrayList<>();

	public static boolean orderList(String pizzaType1, int Quantity) {
		boolean isAdd = false;
		double price = 0;
		for (Product add : ProductService.getProducts()) {

			if (add.getName().equalsIgnoreCase(pizzaType1) && OrederSheetValidation.isValidProductQuantity(Quantity)) {

				price = add.getPrice();
				double totalAmount = price * Quantity;
				LocalTime time = LocalTime.now();
				LocalTime deliveryTime = time.plusMinutes(30);
				LocalDate date = LocalDate.now();
				Order order = new Order(pizzaType1, Quantity, price, totalAmount, date, time, deliveryTime);
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

	private static final List<Gst> orders1 = new ArrayList<>();

	public static boolean gstCalculation(String pizzaType1, double gst) {
		double totalAmount = 0;
		for (Order add : OrderSheetService.getOrders()) {
			if (add.getPizzaName().equalsIgnoreCase(pizzaType1)) {
				totalAmount = add.getTotalAmount();
				double gstAmount = (totalAmount * gst) + totalAmount;
				Gst gstamount = new Gst(gstAmount);
				orders1.add(gstamount);
			}
		}
		return false;
	}

	public static List<Gst> getOrders1() {
		return orders1;
	}

}
