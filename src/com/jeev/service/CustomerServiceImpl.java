package com.jeev.service;

import com.jeev.factory.CustomerPersistenceFactory;
import com.jeev.persistence.ICustomerPersistence;
import com.jeev.pojo.Customer;

public class CustomerServiceImpl implements ICustomerService {

	@Override
	public String save(Customer customer) {
		ICustomerPersistence customerPersistence = CustomerPersistenceFactory.getPersistence();
		return customerPersistence.save(customer);
	}

	@Override
	public Customer getById(int id) {
		ICustomerPersistence customerPersistence = CustomerPersistenceFactory.getPersistence();
		return customerPersistence.getById(id);
	}

	@Override
	public String updateById(Customer customer) {
		ICustomerPersistence customerPersistence = CustomerPersistenceFactory.getPersistence();
		return customerPersistence.updateById(customer);
	}

	@Override
	public String DeleteById(int id) {
		ICustomerPersistence customerPersistence = CustomerPersistenceFactory.getPersistence();
		return customerPersistence.DeleteById(id);
	}

}
