package com.jeev.controller;

import com.jeev.pojo.Customer;

public interface ICustomerController {

	public String save(Customer customer);

	public Customer getById(int id);

	public String updateById(Customer customer);

	public String DeleteById(int id);
	
}
