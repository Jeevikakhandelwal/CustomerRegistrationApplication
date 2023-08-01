package com.jeev.factory;

import com.jeev.persistence.CustomerPersistenceImpl;
import com.jeev.persistence.ICustomerPersistence;

public class CustomerPersistenceFactory {

	private static ICustomerPersistence customerPersistence;

	static {
		customerPersistence = new CustomerPersistenceImpl();
	}

	public static ICustomerPersistence getPersistence() {
		return customerPersistence;
	}
}
