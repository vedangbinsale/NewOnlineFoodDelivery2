package com.OnlineFoodDelivery.ctrl;

 


import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFoodDelivery.entities.Customer;
import com.OnlineFoodDelivery.service.ICustomerService;



@RestController
@RequestMapping(path="customers")
public class CustomerController {

	@Autowired
	ICustomerService service;
	
	
	@PostMapping("/addCustomer") 
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) 
	{
	    Customer customer2=service.addCustomer(customer);
		return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer)
	{
		Customer customer1=service.viewCustomerById(customer.getCustomerId());
		
			Customer customer2=service.updateCustomer(customer);
			return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removeCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") int id) 
	{
		Customer customer=service.viewCustomerById(id);
		
			String result=service.removeCustomerById(id);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		
			
	}
	
	@GetMapping("/viewCustomer/{customerId}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("customerId") int id) 
	{
		Customer customer=service.viewCustomerById(id);
	  
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllCustomerByArea/{areaName}")
	public ResponseEntity<List<Customer>> viewAllCustomer(@PathVariable("areaName") String name) 
	{
	    List<Customer> customer=service.viewAllCustomer(name);
	    
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
}
