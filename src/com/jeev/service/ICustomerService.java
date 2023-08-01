package com.jeev.service;

import com.jeev.pojo.Customer;

public interface ICustomerService {
	
	public String save(Customer customer);

	public Customer getById(int id);

	public String updateById(Customer customer);

	public String DeleteById(int id);
}
