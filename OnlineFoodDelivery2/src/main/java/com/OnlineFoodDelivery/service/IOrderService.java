package com.OnlineFoodDelivery.service;


import java.util.List;

import com.OnlineFoodDelivery.entities.OrderDetails;

public interface IOrderService {

	public OrderDetails addOrder(int cartId);
	public OrderDetails updateOrder(OrderDetails order);
	public String removeOrderById(OrderDetails order);
	public OrderDetails viewOrderById(int id);
	//public List<OrderDetails> viewAllOrders(int id);
	public List<OrderDetails> viewAllOrdersByCustomer(int id);
	public List<OrderDetails> viewAllOrdersByRestaurant(String resName);
	
	
}
