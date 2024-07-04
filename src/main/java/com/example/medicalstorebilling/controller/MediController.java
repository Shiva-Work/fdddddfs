package com.example.medicalstorebilling.controller;

import java.util.List;

import com.example.medicalstorebilling.entity.Customers;
import com.example.medicalstorebilling.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicalstorebilling.entity.Medicine;
import com.example.medicalstorebilling.service.MediService;

@RestController
@RequestMapping("/check/medicine")
public class MediController {
	
	@Autowired
	private MediService mServ;

	@Autowired
	public CustomerService cust;
	
	@GetMapping("/list")
	public  List<Medicine> m1()
	{
		try {
			List<Medicine> m= mServ.m1();
		return m ;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@PostMapping("/add")
	public String m2(@RequestBody Medicine medi)
	{
		String servMethod=mServ.m2(medi);
		return servMethod;
	}

	@PostMapping("/reg")
	public ResponseEntity<Long> m1(@RequestBody Customers cu)
	{
//		String k= String.valueOf(cust.add(cu));
		/*
		 * int k=cust.add(cu); return k;
		 */	
		 try {
	            Long customerId = (long) cust.add(cu);
	            return ResponseEntity.ok(customerId);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	}
	@GetMapping("/getCusto")
	public List<Customers> show()
	{
		List<Customers> lst=cust.getDataCust();

		return lst;
	}

}
