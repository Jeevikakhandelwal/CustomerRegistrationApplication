package com.jeev.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jeev.controller.ICustomerController;
import com.jeev.factory.CustomerControllerFactory;
import com.jeev.pojo.Customer;
import com.jeev.utility.JdbcUtil;

public class MainApp {

	public static void main(String[] args) {

		// JDBCAPI required parameters
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// collect the query from user and process for execution
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String query=br.readLine();

		try {
			// Establishing the connection with DB
			connection = JdbcUtil.getDbConnection();
			if (connection != null) {

				// Create a statement object to transfer with DB
				statement = connection.createStatement();

				if (statement != null) {

					// Processing given query and get updated result
					System.out.print("Enter your username:: ");
					String username = br.readLine();

					System.out.print("Enter your password:: ");
					String pwd = br.readLine();

					String SQLSELECTQUERY = "select count(*) from Login where username='" + username
							+ "' and password='" + pwd + "'";

					System.out.println(SQLSELECTQUERY);
					resultSet = statement.executeQuery(SQLSELECTQUERY);
					if (resultSet != null) {

						// step=>process the resultSet
						if (resultSet.next()) {
							int rowAffected = resultSet.getInt(1);

							if (rowAffected == 0) {
								System.out.println("Invalid Credentials....");
							} else {

								System.out.println("Valid Credentials...");

								String name, age, address, number, email = null, id = null;
								ICustomerController customerController = null;
								Customer custRecord = null;

								while (true) {
									System.out.println("WELCOME TO OUR APPLICATION");
									System.out.println("===========================");
									System.out.println();
									System.out.println("1.CREATE");
									System.out.println("2.READ");
									System.out.println("3.UPDATE");
									System.out.println("4.DELETE");
									System.out.print("Plz Enter ur choice:: ");

									int option = 0;
									try {
										option = Integer.parseInt(br.readLine());

										switch (option) {
										case 1:
											// Collecting the inputs for updating record
											System.out.println("Enter your Name:: ");
											name = br.readLine();

											System.out.println("Enter your Age:: ");
											age = br.readLine();

											System.out.println("Enter your Address:: ");
											address = br.readLine();

											System.out.println("Enter your Phone Number:: ");
											number = br.readLine();

											System.out.println("Enter your Email:: ");
											email = br.readLine();

											// sending data to the controller using POJO
											Customer customer = new Customer();

											customer.setCname(name);
											customer.setCage(Integer.parseInt(age));
											customer.setCaddress(address);
											customer.setCmobile(Integer.parseInt(number));
											customer.setCmail(email);

											// pure Abstraction (hiding the internal implementation just exposing the
											// service name)
											customerController = CustomerControllerFactory.getController();
											String status = customerController.save(customer);
											System.out.println(status);

											break;
										case 2:
											System.out.println("Enter your Id :: ");
											id = br.readLine();

											// pure Abstraction (hiding the internal implementation just exposing the
											// service name)
											customerController = CustomerControllerFactory.getController();

											custRecord = customerController.getById(Integer.parseInt(id));
											System.out.println(custRecord);

											if (custRecord != null) {
												System.out.println(custRecord);
											} else {
												System.out.println("Record not available for given id:: " + id);
											}
											break;
										case 3:
											System.out.println("Enter your Id :: ");
											id = br.readLine();

											// pure Abstraction (hiding the internal implementation just exposing the
											// service name)
											customerController = CustomerControllerFactory.getController();

											// Invoking the controller to get service
											custRecord = customerController.getById(Integer.parseInt(id));
											System.out.println(custRecord);

											if (custRecord != null) {
												System.out.println("Enter your Current Name:: " + custRecord.getCname()
														+ "Enter your Updating Name:: ");
												String newName = br.readLine();

												System.out.println("Enter your age:: " + custRecord.getCage()
														+ "Enter your Updating Name:: ");
												String newAge = br.readLine();

												System.out.println("Enter your address:: " + custRecord.getCaddress()
														+ "Enter your Updating Address:: ");
												String newAddress = br.readLine();

												System.out.println("Enter your Mobile number:: "
														+ custRecord.getCmobile() + "Enter your Updating Number:: ");
												String newMobile = br.readLine();

												System.out.println("Enter your Email:: " + custRecord.getCmail()
														+ "Enter your Updating EmailId:: ");
												String newEmail = br.readLine();

												Customer newCustomer = new Customer();

												System.out.println(newCustomer);

												// Setting cid value to the POJO object
												newCustomer.setCid(custRecord.getCid());

												// Perform validation based on the input provided by the user for name
												if (newName.equals("") || newName == null) {
													newCustomer.setCname(custRecord.getCname());
												} else {
													newCustomer.setCname(newName);
												}

												// Perform validation based on the input provided by the user for age
												if (newAge.equals("") || newAge == null) {
													newCustomer.setCage(custRecord.getCage());
												} else {
													newCustomer.setCage(Integer.parseInt(newAge));
												}

												// Perform validation based on the input provided by the user for
												// address
												if (newAddress.equals("") || newAddress == null) {
													newCustomer.setCaddress(custRecord.getCaddress());
												} else {
													newCustomer.setCaddress(newAddress);
												}

												// Perform validation based on the input provided by the user for mobile
												if (newMobile.equals("") || newMobile == null) {
													newCustomer.setCmobile(custRecord.getCmobile());
												} else {
													newCustomer.setCmobile(Integer.parseInt(newMobile));
												}

												// Perform validation based on the input provided by the user for email
												if (newEmail.equals("") || newEmail == null) {
													newCustomer.setCmail(custRecord.getCmail());
												} else {
													newCustomer.setCmail(newEmail);
												}
												System.out.println(newCustomer);
												status = customerController.updateById(newCustomer);
												System.out.println(status);
											} else {
												System.out.println("Record not available for the updation" + id);
											}
											break;
										case 4:
											System.out.println("Enter your id:: ");
											id = br.readLine();

											// pure Abstraction (hiding the internal implementation just exposing the
											// service name)
											customerController = CustomerControllerFactory.getController();

											status = customerController.DeleteById(Integer.parseInt(id));
											System.out.println(status);
											break;
										}
									} catch (NumberFormatException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}

				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
