package com.dxc.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.bankapp.dao.CustomerDao;
import com.dxc.bankapp.entity.Customer;

@Service
public class CustomerService
{

	@Autowired
	CustomerDao customerDao;
	
	public List<Customer> getAllCustomers() {
		return this.customerDao.findAll();
	}
	
	public Customer addCustomer(Customer customer) {
		return this.customerDao.save(customer);
	}
	
	// Optional is a Container object which may or may not contain non null values
	public Optional <Customer> getCustomerById(int id ) {
		return this.customerDao.findById(id);
	}
	
	public Customer updateCustomer(Customer customer) {
		return this.customerDao.save(customer);
	}
	
	public void deleteCustomerById(int id) {
		this.customerDao.deleteById(id);
	}
	
	public void deleteAllCustomers() {
		this.customerDao.deleteAll();
	}
	
}
