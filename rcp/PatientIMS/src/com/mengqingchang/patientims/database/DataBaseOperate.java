/**
 *@author MengQingChang
 *Copyright 2007-12-9 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.gjt.mm.mysql.Driver;
import com.mysql.*;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Diagnose;
import com.mengqingchang.patientims.model.Doctor;
import com.mengqingchang.patientims.model.Expense;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;

public class DataBaseOperate {

	public static List getPatientInfo() {
		List list = new ArrayList();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select patient.id,patient.name,patient.sex,patient.age,patient.phone,department.departname,sickroom.sickroomid,sickbed.sickbedid,patient.address,patient.logtime "
					+ "from patient,sickroom,sickbed,department"
					+ " where patient.sickbed_id=sickbed.id and sickbed.sickroom_id=sickroom.id and sickroom.department_id=department.id ";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Patient patient = new Patient();
				SickRoom sickRoom = new SickRoom();
				SickBed sickBed = new SickBed();
				Department depar = new Department();
				patient.setId(new Long(rs.getLong("id")));
				patient.setName(rs.getString("name"));
				patient.setSex(rs.getString("sex"));
				patient.setAge(rs.getInt("age"));
				patient.setPhone(rs.getString("patient.phone"));
				depar.setDepartment(rs.getString("department.departname"));
				patient.setDepartment(depar);
				sickRoom.setSickRoomId(rs.getInt("sickroom.sickroomid"));
				patient.setSickRoom(sickRoom);
				sickBed.setSickBedId(rs.getInt("sickbed.sickbedid"));
				patient.setSickBed(sickBed);
				patient.setAddress(rs.getString("address"));
				patient.setLogDate(rs.getDate("patient.logtime"));
				list.add(patient);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List) Collections.EMPTY_SET;
	}

	public static List getDiagnoseInfo() {
		List list = new ArrayList();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select diagnose.id,patient.name, diagnose.illness,diagnose.therapeutic, diagnose.dignosedate,doctor.name"
					+ " from patient,diagnose,doctor where patient.id=diagnose.patient_id and doctor.id=diagnose.doctor_id ";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {

				Diagnose diagnose = new Diagnose();
				Patient patient = new Patient();
				Doctor doctor = new Doctor();
				diagnose.setId(new Long(rs.getLong("id")));
				patient.setName(rs.getString("name"));
				diagnose.setPatient(patient);
				diagnose.setSickName(rs.getString("illness"));
				diagnose.setTherapeutic(rs.getString("therapeutic"));
				diagnose.setTreatDate(rs.getDate("dignosedate"));
				doctor.setName(rs.getString("doctor.name"));
				diagnose.setDoctor(doctor);
				list.add(diagnose);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List) Collections.EMPTY_SET;
	}

	public static List getExpenseInfo() {
		List list = new ArrayList();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select expense.id,patient.name, expense.expenseillustrate,expense.expensename,expense.unitprice,expense.number,expense.occurexpense,expense.occurtime ,doctor.name from patient,expense,doctor where patient.id=expense.patient_id and doctor.id=expense.doctor_id ";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Expense expense = new Expense();
				Patient patient = new Patient();
				Doctor doctor = new Doctor();
				expense.setId(new Long(rs.getLong("expense.id")));
				patient.setName(rs.getString("patient.name"));
				expense.setPatient(patient);
				expense.setExpenseIllustrate(rs
						.getString("expense.expenseillustrate"));
				expense.setExpenseName(rs.getString("expense.expensename"));
				expense.setUnitPrice(rs.getFloat("expense.unitprice"));
				expense.setNumber(rs.getInt("expense.number"));
				expense.setOccurExpense(rs.getFloat("occurexpense"));
				expense.setTakeDate(rs.getDate("occurtime"));
				doctor.setName(rs.getString("doctor.name"));
				expense.setDoctor(doctor);
				list.add(expense);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List) Collections.EMPTY_SET;
	}

	public static List<Patient> getPatientIdCombo() {
		List<Patient> list = new ArrayList<Patient>();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select  patient.id from patient";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getLong("patient.id"));
				list.add(patient);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static List<Department> getAllDeparCombo() {
		List<Department> list = new ArrayList<Department>();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select  departname from department";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Department department = new Department();
				department.setDepartment(rs.getString("departname"));

				list.add(department);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static List<SickRoom> getAllSickRoomCombo() {
		List<SickRoom> list = new ArrayList<SickRoom>();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select  sickroomid from sickroom";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				SickRoom sickRoom = new SickRoom();
				sickRoom.setSickRoomId(rs.getInt("sickroomid"));

				list.add(sickRoom);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static List<SickBed> getAllSickBedCombo() {
		List<SickBed> list = new ArrayList<SickBed>();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select  distinct sickbedid from sickbed";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				SickBed sickBed = new SickBed();
				sickBed.setSickBedId(rs.getInt("sickbedid"));

				list.add(sickBed);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static List<Doctor> getAllDoctorNameCombo() {
		List<Doctor> list = new ArrayList<Doctor>();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			strSQL = "select  distinct name from doctor";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setName(rs.getString("name"));

				list.add(doctor);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static List getSearchPatienInfo(Department department,
			SickRoom sickRoom, SickBed sickBed) {
		List list = new ArrayList();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		String de = null;
		String sr;
		String sb;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			de = department.getDepartment();
			sr = sickRoom.getSickRoomId() + "";
			sb = sickBed.getSickBedId() + "";
			strSQL = "select patient.id,patient.name,patient.sex,patient.age,patient.phone,  department.departname,sickroom.sickroomid,sickbed.sickbedid,diagnose.illness,diagnose.therapeutic,doctor.name,patient.address,patient.logtime from patient,sickroom,sickbed,doctor,diagnose,department where patient.sickbed_id=sickbed.id and sickroom.department_id=department.id and sickbed.sickroom_id=sickroom.id and patient.id=diagnose.patient_id and doctor.id=diagnose.doctor_id and department.departname='"
					+ de
					+ "' and sickroom.sickroomid ='"
					+ sr
					+ "' and sickbed.sickbedid='" + sb + "'";

			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Patient patient = new Patient();
				Diagnose diagnose = new Diagnose();
				Doctor doctor = new Doctor();
				patient.setId(new Long(rs.getLong("id")));
				patient.setName(rs.getString("name"));
				patient.setSex(rs.getString("sex"));
				patient.setAge(rs.getInt("age"));
				patient.setPhone(rs.getString("phone"));
				department.setDepartment(rs.getString("departname"));
				patient.setDepartment(department);
				sickRoom.setSickRoomId(rs.getInt("sickroomid"));
				patient.setSickRoom(sickRoom);
				sickBed.setSickBedId(rs.getInt("sickbedid"));
				patient.setSickBed(sickBed);
				diagnose.setSickName(rs.getString("illness"));
				patient.setDiagnose(diagnose);
				diagnose.setTherapeutic(rs.getString("therapeutic"));
				patient.setDiagnose(diagnose);
				doctor.setName(rs.getString("doctor.name"));
				patient.setDoctor(doctor);
				patient.setAddress(rs.getString("address"));
				patient.setLogDate(rs.getDate("patient.logtime"));
				list.add(patient);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List) Collections.EMPTY_SET;
	}
	public static List getPatientIdSearchPatienInfo(Patient patient) {
		List list = new ArrayList();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		Long str = null;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			str = patient.getId();
			strSQL = "select patient.id,patient.name,patient.sex,patient.age,patient.phone,  department.departname,sickroom.sickroomid,sickbed.sickbedid,diagnose.illness,diagnose.therapeutic,doctor.name,patient.address,patient.logtime "
					+ "from patient,sickroom,sickbed,doctor,diagnose,department "
					+ "where patient.sickbed_id=sickbed.id and sickbed.sickroom_id=sickroom.id and sickroom.department_id=department.id and patient.id=diagnose.patient_id and doctor.id=diagnose.doctor_id and patient.id='"
					+ str + "'";

			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Department department = new Department();
				SickRoom sickRoom = new SickRoom();
				SickBed sickBed = new SickBed();
				Diagnose diagnose = new Diagnose();
				Doctor doctor = new Doctor();
				patient.setId(new Long(rs.getLong("id")));
				patient.setName(rs.getString("name"));
				patient.setSex(rs.getString("sex"));
				patient.setAge(rs.getInt("age"));
				patient.setPhone(rs.getString("phone"));
				department.setDepartment(rs.getString("departname"));
				patient.setDepartment(department);
				sickRoom.setSickRoomId(rs.getInt("sickroomid"));
				patient.setSickRoom(sickRoom);
				sickBed.setSickBedId(rs.getInt("sickbedid"));
				patient.setSickBed(sickBed);
				diagnose.setSickName(rs.getString("illness"));
				patient.setDiagnose(diagnose);
				diagnose.setTherapeutic(rs.getString("therapeutic"));
				patient.setDiagnose(diagnose);
				doctor.setName(rs.getString("doctor.name"));
				patient.setDoctor(doctor);
				patient.setAddress(rs.getString("address"));
				patient.setLogDate(rs.getDate("patient.logtime"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getDate("patient.logtime"));
				list.add(patient);

			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (List) Collections.EMPTY_SET;
	}

	public static List getSearchPatienExpenseInfo(Department department,
			SickRoom sickRoom, SickBed sickBed) {
		List list = new ArrayList();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		String de = null;
		String sr = null;
		String sb = null;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			de = department.getDepartment();
			sr = sickRoom.getSickRoomId() + "";
			sb = sickBed.getSickBedId() + "";
			strSQL = "select patient.id,patient.name, expense.expenseillustrate,expense.expensename,expense.unitprice,expense.number,expense.occurexpense,expense.occurtime,doctor.name ,sickbed.sickbedid,sickroom.sickroomid, department.departname from patient,expense,doctor ,sickbed,sickroom,department where patient.id=expense.patient_id and doctor.id=expense.doctor_id and patient.sickbed_id=sickbed.id and sickbed.sickroom_id=sickroom.id and sickroom.department_id=department.id and sickbed.sickbedid='"
					+ sb
					+ "' and sickroom.sickroomid='"
					+ sr
					+ "' and department.departname='" + de + "'";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Expense expense = new Expense();
				Patient patient = new Patient();
				Doctor doctor = new Doctor();
				patient.setId(new Long(rs.getLong("patient.id")));
				expense.setPatient(patient);
				patient.setName(rs.getString("patient.name"));
				expense.setPatient(patient);
				expense.setExpenseIllustrate(rs
						.getString("expense.expenseillustrate"));
				expense.setExpenseName(rs.getString("expense.expensename"));
				expense.setUnitPrice(rs.getFloat("expense.unitprice"));
				expense.setNumber(rs.getInt("expense.number"));
				expense.setOccurExpense(rs.getFloat("expense.occurexpense"));
				expense.setTakeDate(rs.getDate("expense.occurtime"));
				doctor.setName(rs.getString("doctor.name"));
				expense.setDoctor(doctor);
				list.add(expense);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List) Collections.EMPTY_SET;
	}

	public static List getPatientIdSearchPatienExpenseInfo(Patient patient) {
		List list = new ArrayList();
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		Long str = null;

		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			str = patient.getId();
			System.out.println(str);
			strSQL = "select patient.id,patient.name, expense.expenseillustrate,expense.expensename,expense.unitprice,expense.number,expense.occurexpense,expense.occurtime,doctor.name from patient,expense,doctor where patient.id=expense.patient_id and doctor.id=expense.doctor_id  and   patient.id='"
					+ str + "'";

			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Expense expense = new Expense();
				Doctor doctor = new Doctor();
				patient.setId(new Long(rs.getLong("patient.id")));
				expense.setPatient(patient);
				patient.setName(rs.getString("patient.name"));
				expense.setPatient(patient);
				expense.setExpenseIllustrate(rs
						.getString("expense.expenseillustrate"));
				expense.setExpenseName(rs.getString("expense.expensename"));
				expense.setUnitPrice(rs.getFloat("expense.unitprice"));
				expense.setNumber(rs.getInt("expense.number"));
				expense.setOccurExpense(rs.getFloat("expense.occurexpense"));
				expense.setTakeDate(rs.getDate("expense.occurtime"));
				doctor.setName(rs.getString("doctor.name"));
				expense.setDoctor(doctor);
				list.add(expense);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List) Collections.EMPTY_SET;
	}

	public static Patient getTest(Department department, SickRoom sickRoom,
			SickBed sickBed) {
		Connection con;
		Statement st;
		ResultSet rs;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			String depar = department.getDepartment();
			String sr = sickRoom.getSickRoomId() + "";
			String sb = sickBed.getSickBedId() + "";
			strSQL = "select patient.id from patient,department,sickbed,sickroom where patient.sickbed_id=sickbed.id and sickroom.department_id=department.id and sickroom.id=sickbed.sickroom_id and department.departname='"
					+ depar
					+ "'and sickroom.sickroomid='"
					+ sr
					+ "'and sickbedid='" + sb + "'";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(new Long(rs.getLong("patient.id")));
				return patient;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean insertPatientInfor(Patient patient,
			Department department, SickRoom sickRoom, SickBed sickBed) {
		Connection con = null;
		Statement st;
		ResultSet rs = null;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			String name = patient.getName();
			int age = patient.getAge();
			String sex = patient.getSex() + "";
			String phone = patient.getPhone() + "";
			String address = patient.getAddress() + "";
			String date = patient.getLogDate().toLocaleString();
			String depar = department.getDepartment();
			String sr = sickRoom.getSickRoomId() + "";
			String sb = sickBed.getSickBedId() + "";
			// 根据条件查询床位的ID值
			strSQL = "select sickbed.id from  department,sickbed,sickroom where sickroom.department_id=department.id and sickroom.id=sickbed.sickroom_id and department.departname='"
					+ depar
					+ "'and sickroom.sickroomid='"
					+ sr
					+ "'and sickbedid='" + sb + "'";
			rs = st.executeQuery(strSQL);
			rs.next();
			// 获得床位的ID值
			int sickbed_id = rs.getInt("sickbed.id");
			// 插入数据操作
			String sql = "insert into patient(name,sex,age,phone,address,logtime,sickbed_id) values('"
					+ name
					+ "','"
					+ sex
					+ "',"
					+ age
					+ ",'"
					+ phone
					+ "','"
					+ address + "','" + date + "'," + sickbed_id + ")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	public boolean DeletePatientInfor(Patient patient) {
		Connection con = null;
		Statement st;
		String strSQL;
		String btrSQL;
		String ctrSQL;
		String str;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			str = patient.getId() + "";
			strSQL = "delete from patient where patient.id='" + str + "'";
			st.executeUpdate(strSQL);
			btrSQL = "delete from diagnose where patient_id='" + str + "'";
			st.executeUpdate(btrSQL);
			ctrSQL = "delete from expense where patient_id='" + str + "'";
			st.executeUpdate(ctrSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean ModifyPatientInfor(Patient patient) {

		Connection con = null;
		Statement st;
		ResultSet rs = null;
		String strSQL;
		String str;
		String de;
		String sr;
		String sb;

		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			Department depart = patient.getDepartment();
			de = depart.getDepartment();
			SickRoom sickRoom = patient.getSickRoom();
			sr = sickRoom.getSickRoomId() + "";
			SickBed sickBed = patient.getSickBed();
			sb = sickBed.getSickBedId() + "";
			str = patient.getId() + "";
			strSQL = "select sickbed.id from department,sickbed,sickroom where sickroom.department_id=department.id and sickroom.id=sickbed.sickroom_id and department.departname='"
					+ de
					+ "'and sickroom.sickroomid='"
					+ sr
					+ "'and sickbedid='" + sb + "'";
			rs = st.executeQuery(strSQL);
			rs.next();
			int bedid = rs.getInt("sickbed.id");
			strSQL = "update patient set sickbed_id='" + bedid
					+ "'where patient.id='" + str + "'";
			st.executeUpdate(strSQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void UpdateUserPassWordInfor(Text userName, Text passWord) {
		Connection con = null;
		Statement st;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			String un = userName.getText();
			String pw = passWord.getText();
	 		strSQL = "update doctor set password='" + pw + "'where username='"
					+ un + "'";
			st.executeUpdate(strSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Doctor getLoginInfor(Doctor doctor) {

		Connection con = null;
		Statement st;
		ResultSet rs = null;
		String strSQL;
		String un;
		String pw;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			un = doctor.getUserName();
			pw = doctor.getPassWord();

			strSQL = "select * from doctor where username='" + un
					+ "' and password='" + pw + "'";
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				doctor.setId(new Long(rs.getLong("id")));
				doctor.setUserName(rs.getString("username"));
				doctor.setPassWord(rs.getString("password"));
				return doctor;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean insertDiagnoseInfor(Diagnose diagnose, Doctor doctor) {
		Connection con = null;
		Statement st;
		ResultSet rs = null;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			Long pd = diagnose.getPatientId();
			String dn = doctor.getName();
			String res = diagnose.getSickName();
			String ex = diagnose.getTherapeutic();
			String date = new Date().toLocaleString();
			// 查询医生的ID值
			strSQL = "select doctor.id from doctor where doctor.name='" + dn
					+ "'";
			rs = st.executeQuery(strSQL);
			rs.next();
			// 获得医生的ID值
			int di = rs.getInt("doctor.id");
			// 将数据插入diagnose表
			String sql = "insert into diagnose(illness,therapeutic,dignosedate,patient_id,doctor_id) values('"
					+ res
					+ "','"
					+ ex
					+ "','"
					+ date
					+ "','"
					+ pd
					+ "','"
					+ di
					+ "')";
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	public boolean DeleteDiagnoseInfor(Diagnose diagnose) {
		Connection con = null;
		Statement st;
		String btrSQL;
		String str;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			str = diagnose.getId() + "";
			System.out.println(str);
			btrSQL = "delete from diagnose where diagnose.id='" + str + "'";
			st.executeUpdate(btrSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean ModifyDiagnoseInfor(Diagnose diagnose) {
		Connection con = null;
		Statement st;
		String strSQL;
		String str;
		String sn;
		String ex;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			str = diagnose.getId() + "";
			sn = diagnose.getSickName();
			ex = diagnose.getTherapeutic();
			strSQL = "update diagnose set illness='" + sn + "', therapeutic='"
					+ ex + "' where diagnose.id='" + str + "'";
			st.executeUpdate(strSQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean insertExpenseInfor(Expense expense, Doctor doctor) {
		Connection con = null;
		Statement st;
		ResultSet rs = null;
		String strSQL;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			String doctorName = doctor.getName();
			String patientId = expense.getPatientId() + "";

			String expenseE = expense.getExpenseIllustrate();
			String expenseN = expense.getExpenseName();
			float unprice = expense.getUnitPrice();
			int number = expense.getNumber();
			String date = new Date().toLocaleString();
			float sum = unprice * number;
			strSQL = "select doctor.id from doctor where doctor.name='"
					+ doctorName + "'";
			rs = st.executeQuery(strSQL);
			rs.next();
			// 获得医生的ID号
			int doctorId = rs.getInt("doctor.id");
			// 向expense表中插入数据
			String sql = "insert into expense(expenseillustrate,expensename,unitprice,number,occurexpense,occurtime,patient_id,doctor_id) values('"
					+ expenseE
					+ "','"
					+ expenseN
					+ "',"
					+ unprice
					+ ",'"
					+ number
					+ "','"
					+ sum
					+ "','"
					+ date
					+ "','"
					+ patientId
					+ "'," + doctorId + ")";
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	public boolean ModifyExpenseInfor(Expense expense) {
		Connection con = null;
		Statement st;
		String strSQL;
		String str;
		String expenseE;
		String expenseN;
		float unitPrice;
		int number;
		float sum;

		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			str = expense.getId() + "";
			expenseE = expense.getExpenseIllustrate();
			expenseN = expense.getExpenseName();
			unitPrice = expense.getUnitPrice();
			number = expense.getNumber();
			sum = expense.getOccurExpense();
			String date = new Date().toLocaleString();
			strSQL = "update expense set expenseillustrate='" + expenseE
					+ "',expensename='" + expenseN + "',unitprice='"
					+ unitPrice + "',number='" + number + "',occurexpense='"
					+ sum + "',occurtime='" + date + "'where expense.id='"
					+ str + "'";
			st.executeUpdate(strSQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean DeleteExpenseInfor(Expense expense) {

		Connection con = null;
		Statement st;
		String strSQL;
		String str;
		try {
			con = DBConnectManager.getDataBaseConnection();
			st = con.createStatement();
			str = expense.getId() + "";
			strSQL = "delete from expense where expense.id='" + str + "'";
			st.executeUpdate(strSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}