package com.OnlineFoodDelivery.service;

import java.util.List;

import com.OnlineFoodDelivery.entities.Customer;



public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer viewCustomerById(int id ) ;
	public List<Customer> viewAllCustomer(String areaname);
	public String removeCustomerById(int id)  ;
	 
}