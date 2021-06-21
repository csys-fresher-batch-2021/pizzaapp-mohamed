package in.sikkandar.service;

import java.time.LocalTime;

import in.sikkandar.dao.ProductDao;
import in.sikkandar.exception.ServiceException;
import in.sikkandar.model.Order;
import in.sikkandar.model.Product;
import in.sikkandar.validator.OrederSheetValidation;

public class OrderSheetService {
	private OrderSheetService() {

	}

	public static Order orderList(String pizzaType1, int quantity) {
		double price = 0;
		double gst = 0.07;
		Order order = new Order();
		for (Product add : ProductDao.getProduct()) {

			try {
				if (add.getName().equalsIgnoreCase(pizzaType1) && OrederSheetValidation.isValidProductQuantity(quantity)) {
					
					price = add.getPrice();
					double amount = price * quantity;
					double gstAmount = amount * gst;
					double totalAmount = gstAmount + amount;
					LocalTime deliveryTime = LocalTime.now().plusMinutes(30);
					/*
					 * LocalTime orderTime = LocalTime.now(); LocalTime deliveryTime =
					 * orderTime.plusMinutes(30); LocalDate date = LocalDate.now();
					 */
					order.setPizzaName(pizzaType1);
					order.setQuantity(quantity);
					order.setPrice(price);
					order.setGstAmount(gstAmount);
					order.setTotalAmount(totalAmount);
					order.setDeliveryTime(deliveryTime);

					//OrderDao.addOrder(pizzaType1, quantity, price, totalAmount, date, orderTime, deliveryTime, gstAmount);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException(e.getMessage());
			}
		}

		return order;
	}
}
