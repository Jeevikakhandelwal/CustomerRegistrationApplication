package com.jeev.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jeev.pojo.Customer;
import com.jeev.utility.JdbcUtil;

public class CustomerPersistenceImpl implements ICustomerPersistence {

	@Override
	public String save(Customer customer) {
		Connection connection = null;
		PreparedStatement pstmt = null;

		// Establishing a connection between DB software
		connection = JdbcUtil.getDbConnection();

		try {
			if (connection != null) {
				String INSERT_QUERY = "INSERT INTO CUSTOMER (CNAME,CAGE,CADDRESS,CMOBILE,CMAIL) VALUES (?,?,?,?,?)";

				// Create an PreparedStatement Object
				pstmt = connection.prepareStatement(INSERT_QUERY);
			}

			if (pstmt != null) {

				// inserting the user values into table
				pstmt.setString(1, customer.getCname());
				pstmt.setInt(2, customer.getCage());
				pstmt.setString(3, customer.getCaddress());
				pstmt.setInt(4, customer.getCmobile());
				pstmt.setString(5, customer.getCmail());

				// process and execute query
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected > 0) {
					return "record inserted sucessfully....";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "record insertion failed....";
	}

	@Override
	public Customer getById(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		// Establishing a connection between DB software
		connection = JdbcUtil.getDbConnection();
		try {
			if (connection != null) {
				String SQL_SELECT_QUERY = "SELECT CID,CNAME,CAGE,CADDRESS,CMOBILE,CMAIL FROM CUSTOMER WHERE CID=?";
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}

			if (pstmt != null) {
				pstmt.setInt(1, id);
				resultSet = pstmt.executeQuery();
			}

			if (resultSet.next()) {

				Customer customer = new Customer();

				customer.setCid(1);
				customer.setCname(resultSet.getString(2));
				customer.setCage(resultSet.getInt(3));
				customer.setCaddress(resultSet.getString(4));
				customer.setCmobile(resultSet.getInt(5));
				customer.setCmail(resultSet.getString(6));

				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateById(Customer customer) {
		Connection connection = null;
		PreparedStatement pstmt = null;

		// Establishing a connection between DB software
		connection = JdbcUtil.getDbConnection();

		try {
			if (connection != null) {
				String UPDATE_QUERY = "UPDATE CUSTOMER SET CNAME=?,CAGE=?,CADDRESS=?,CMOBILE=?,CMAIL=? WHERE CID=?;";

				// Create an PreparedStatement Object
				pstmt = connection.prepareStatement(UPDATE_QUERY);
			}

			if (pstmt != null) {

				pstmt.setString(1, customer.getCname());
				pstmt.setInt(2, customer.getCage());
				pstmt.setString(3, customer.getCaddress());
				pstmt.setInt(4, customer.getCmobile());
				pstmt.setString(5, customer.getCmail());
				pstmt.setInt(6, customer.getCid());

				pstmt.executeUpdate();

				return "Updated sucessfully.....";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Updation Failed...";
	}

	@Override
	public String DeleteById(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;

		if (getById(id) == null) {
			return "Record not available for deleting the record with the id :: " + id;
		} else {
			try {
				// Establishing a connection between DB software
				connection = JdbcUtil.getDbConnection();

				String SQL_DELETE_QUERY = "DELETE FROM CUSTOMER WHERE CID=?";

				if (connection != null) {

					pstmt = connection.prepareStatement(SQL_DELETE_QUERY);
				}

				if (pstmt != null) {

					pstmt.setInt(1, id);
					pstmt.executeUpdate();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Record deleted succesfully for the given id :: " + id;
	}
}
