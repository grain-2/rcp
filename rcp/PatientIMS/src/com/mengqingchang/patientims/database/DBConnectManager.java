/**
 *@author MengQingChang
 *Copyright 2007-12-9  ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;
import org.gjt.mm.mysql.*;

public class DBConnectManager {
	private static Connection con;

	private DBConnectManager() {

	}

	public static Connection getDataBaseConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/patientims", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 关闭连接方法
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
	}

}
