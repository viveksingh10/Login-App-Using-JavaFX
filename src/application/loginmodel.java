package application;
import java.sql.*;
public class loginmodel {
	Connection connection;
	public loginmodel() {
		connection = sqliteconnection.Connector();
		if(connection == null) {
			System.out.println("Path is not connected");
			System.exit(1);
		}
	}

	public boolean isDbConnected() {
		try {
			return !connection.isClosed();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLogin(String user, String pass) throws SQLException {
		PreparedStatement preparedStatment = null;
		ResultSet resultSet= null;
		String query = "select * from employee where USERNAME = ? and PASSWORD = ?";
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, user);
			preparedStatment.setString(2, pass);
			resultSet = preparedStatment.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			preparedStatment.close();
			resultSet.close();
		}
	}
}