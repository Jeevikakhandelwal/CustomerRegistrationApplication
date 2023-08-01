package com.jeev.controller;

import com.jeev.factory.CustomerServiceFactory;
import com.jeev.pojo.Customer;
import com.jeev.service.ICustomerService;

public class CustomerControllerImpl implements ICustomerController {

	@Override
	public String save(Customer customer) {
		ICustomerService customerService = CustomerServiceFactory.getService();
		return customerService.save(customer);
	}

	@Override
	public Customer getById(int id) {
		ICustomerService customerService = CustomerServiceFactory.getService();
		return customerService.getById(id);
	}

	@Override
	public String updateById(Customer customer) {
		ICustomerService customerService = CustomerServiceFactory.getService();
		return customerService.updateById(customer);
	}

	@Override
	public String DeleteById(int id) {
		ICustomerService customerService = CustomerServiceFactory.getService();
		return customerService.DeleteById(id);
	}

}
