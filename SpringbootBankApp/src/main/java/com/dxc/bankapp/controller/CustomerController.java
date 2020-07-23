package com.dxc.bankapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.bankapp.entity.Customer;
import com.dxc.bankapp.service.CustomerService;

public class CustomerController
{

	@RestController
	@RequestMapping("/customer")
	public class EmployeeController 
	{

		@Autowired
		CustomerService customerservice;

		// http://localhost:8562/customer/all
		@RequestMapping(value = "/all", method = RequestMethod.GET)
		public List<Customer> getAllCustomers() {
			return this.customerservice.getAllCustomers();
		}

		// http://localhost:8562/customer/addCustomer
		@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Customer addMovie(@RequestBody Customer customer) {
			return this.customerservice.addCustomer(customer);
		}

		
		@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Customer updateCustomer(@RequestBody Customer customer) {
			return this.customerservice.updateCustomer(customer);
		}

		// http://localhost:8562/customer/1
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public Optional<Customer> getCustomer(@PathVariable int id) {
			return this.customerservice.getCustomerById(id);
		}

		
		@RequestMapping(value = "/all", method = RequestMethod.DELETE)
		public void deleteAllCustomers() {
			this.customerservice.deleteAllCustomers();
		}

		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public void deleteCustomer(@PathVariable int id) {
			this.customerservice.deleteCustomerById(id);
		}
	}
	
}
