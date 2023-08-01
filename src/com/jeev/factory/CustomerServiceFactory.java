package com.jeev.factory;

import com.jeev.service.CustomerServiceImpl;
import com.jeev.service.ICustomerService;

public class CustomerServiceFactory {

	private static ICustomerService customerService;

	static {
		customerService = new CustomerServiceImpl();
	}

	public static ICustomerService getService() {
		return customerService;
	}
}
