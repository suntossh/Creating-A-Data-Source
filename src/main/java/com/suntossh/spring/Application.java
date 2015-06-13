package com.suntossh.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/application-config.xml");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			DataSource dataSource = applicationContext.getBean("datasourceID", DataSource.class);
			connection = dataSource.getConnection();
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "spring", "password");
			preparedStatement = connection.prepareStatement("insert into RENTAL_LOCATION values (?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, 4);
			preparedStatement.setString(2, "Gas Station");
			preparedStatement.setString(3, "Add 11");
			preparedStatement.setString(4, "Add 22");
			preparedStatement.setString(5, "City");
			preparedStatement.setString(6, "State");
			preparedStatement.setString(7, "Postal Code");
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
