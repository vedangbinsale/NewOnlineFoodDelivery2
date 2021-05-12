package com.OnlineFoodDelivery.ctrl;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFoodDelivery.entities.Bill;
import com.OnlineFoodDelivery.entities.OrderDetails;
import com.OnlineFoodDelivery.service.IBillService;
import com.OnlineFoodDelivery.service.IOrderService;




@RestController
@RequestMapping(path="bill")
public class BillController {
	
	@Autowired
	IBillService service;
	
	@Autowired
	IOrderService ser;
	
	
	@PostMapping("/addBill/{Order_id}")
	public ResponseEntity<Bill> addBill(@PathVariable("Order_id") int id) 
	{ 
		OrderDetails order=ser.viewOrderById(id);
		Bill bill2=service.addBill(order);
		
		return new ResponseEntity<Bill>(bill2,HttpStatus.OK);
		
	}
		
	@DeleteMapping("/removeBill/{Bill_id}")
	public ResponseEntity<String> removeBill(@PathVariable("Bill_id") int id)
	{ 
		Bill bill=service.viewBillById(id);
		
			String msg=service.removeBill(bill);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/viewBillByBillId/{Bill_id}")
	public ResponseEntity<Bill> viewBillById(@PathVariable("Bill_id") int id) 
	{ 
		Bill bill2=service.viewBillById(id);
	
			return new ResponseEntity<Bill>(bill2,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/viewBillByCustomerId/{Customer_id}")
	public ResponseEntity<List<Bill>>  viewBillsByCustomerId(@PathVariable("Customer_id") int id) {
		
		List<Bill> billList = service.viewBillsByCustomerId(id);
		
			return new ResponseEntity<List<Bill>>(billList, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/viewBillByOrderDate/{Start_date}/{End_date}")
	public ResponseEntity<List<Bill>> viewBillsBetweenDates(@PathVariable String Start_date, @PathVariable String End_date){
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(Start_date, dateTimeFormatter);
		LocalDate endDate = LocalDate.parse(End_date, dateTimeFormatter);
		List<Bill> billList = service.viewBillsBetweenDates(startDate,endDate);
	
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.OK);
	}
	
	
	@GetMapping("/calculateTotalCost/{Bill_id}")
	public ResponseEntity<String> calculateTotalCost(@PathVariable("Bill_id") int id) {
		
		Bill bill=service.viewBillById(id);
		
			String billList = service.calculateTotalCost(bill);
		    return new ResponseEntity<String>(billList, HttpStatus.OK);
		
		    
	}
}

