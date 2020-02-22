package com.mengqingchang.mysqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;

		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");// .newInstance();

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
					"root", "123456");

			stmt = conn.createStatement();
			// 如果存在testdb数据库，则删除该数据库。
			stmt.addBatch("drop database if exists testdb;");
			// 创建testdb数据
			stmt.addBatch("create database testdb;");
			// 打开数据库
			stmt.addBatch("use testdb;");
			// 如果数据中存在testtable表，则删除该数据
		//	stmt.addBatch("drop table if exists testtable;");
			// 定义StringBuffer对象
			StringBuffer strBuffer = new StringBuffer();
			// -----------------创建testtable表------------------
			strBuffer.append("create table testtable(");
			strBuffer.append("id int(6)unsigned not null auto_increment,");
			strBuffer.append("username varchar(12) ,");
			strBuffer.append("code  varchar(16),");
			strBuffer.append("primary key(id)");
			strBuffer.append(")");
			// 转换为字符串
			stmt.addBatch(strBuffer.toString());
			// 提交创建操作
			stmt.executeBatch();
			// ----------------向表中插入数据-----------------
			String a = "John";
			String b = "123456";
			String strSQL;
			strSQL = "insert into testtable(username,code)values('" + a + "','"
					+ b + "')";
			// 执行插入表数据操作
			stmt.executeUpdate(strSQL);
			// ----------------查询数据操作------------------
			// 选择操作的SQL语句。
			rs = stmt.executeQuery("select * from testtable");
			while (rs.next()) {
				String usename = rs.getString("username");
				String code = rs.getString("code");
				System.out.println("用户名" + '\t' + "密码");
				System.out.println(usename + '\t' + code);

			}

			// -------------------修改表数据操作-------------
			{
				String c = "654321";
				String strUpDate;
				// 修改testtable表的密码
				strUpDate = "update testtable set  code='" + c + "'";
				// 执行修改操作
				stmt.executeUpdate(strUpDate);
				// 查询并输出修改后表数据结果
				rs = stmt.executeQuery("select * from testtable");
				while (rs.next()) {
					String usename = rs.getString("username");
					String code = rs.getString("code");
					System.out.println("用户名" + '\t' + "密码");
					System.out.println(usename + '\t' + code);

				}

			}
			// 关闭执行的操作，释放数据库对象资源
			rs.close();
			stmt.close();
		} catch (Exception ex) {

			System.out.println("ERRO:" + ex.toString());

		}

	}
}