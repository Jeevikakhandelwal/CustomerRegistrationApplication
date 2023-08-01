package com.jeev.factory;

import com.jeev.controller.CustomerControllerImpl;
import com.jeev.controller.ICustomerController;

public class CustomerControllerFactory {

	private static ICustomerController customerController;

	static {
		customerController = new CustomerControllerImpl();
	}

	public static ICustomerController getController() {
		return customerController;
	}
}
