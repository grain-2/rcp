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
			// ������������
			Class.forName("com.mysql.jdbc.Driver");// .newInstance();

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
					"root", "123456");

			stmt = conn.createStatement();
			// �������testdb���ݿ⣬��ɾ�������ݿ⡣
			stmt.addBatch("drop database if exists testdb;");
			// ����testdb����
			stmt.addBatch("create database testdb;");
			// �����ݿ�
			stmt.addBatch("use testdb;");
			// ��������д���testtable����ɾ��������
		//	stmt.addBatch("drop table if exists testtable;");
			// ����StringBuffer����
			StringBuffer strBuffer = new StringBuffer();
			// -----------------����testtable��------------------
			strBuffer.append("create table testtable(");
			strBuffer.append("id int(6)unsigned not null auto_increment,");
			strBuffer.append("username varchar(12) ,");
			strBuffer.append("code  varchar(16),");
			strBuffer.append("primary key(id)");
			strBuffer.append(")");
			// ת��Ϊ�ַ���
			stmt.addBatch(strBuffer.toString());
			// �ύ��������
			stmt.executeBatch();
			// ----------------����в�������-----------------
			String a = "John";
			String b = "123456";
			String strSQL;
			strSQL = "insert into testtable(username,code)values('" + a + "','"
					+ b + "')";
			// ִ�в�������ݲ���
			stmt.executeUpdate(strSQL);
			// ----------------��ѯ���ݲ���------------------
			// ѡ�������SQL��䡣
			rs = stmt.executeQuery("select * from testtable");
			while (rs.next()) {
				String usename = rs.getString("username");
				String code = rs.getString("code");
				System.out.println("�û���" + '\t' + "����");
				System.out.println(usename + '\t' + code);

			}

			// -------------------�޸ı����ݲ���-------------
			{
				String c = "654321";
				String strUpDate;
				// �޸�testtable�������
				strUpDate = "update testtable set  code='" + c + "'";
				// ִ���޸Ĳ���
				stmt.executeUpdate(strUpDate);
				// ��ѯ������޸ĺ�����ݽ��
				rs = stmt.executeQuery("select * from testtable");
				while (rs.next()) {
					String usename = rs.getString("username");
					String code = rs.getString("code");
					System.out.println("�û���" + '\t' + "����");
					System.out.println(usename + '\t' + code);

				}

			}
			// �ر�ִ�еĲ������ͷ����ݿ������Դ
			rs.close();
			stmt.close();
		} catch (Exception ex) {

			System.out.println("ERRO:" + ex.toString());

		}

	}
}