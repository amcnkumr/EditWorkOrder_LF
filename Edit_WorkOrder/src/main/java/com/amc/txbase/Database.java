package com.amc.txbase;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.Assert;

public class Database extends TxBase {

	public String path = System.getProperty("user.dir");
	public String databaseURL;
	public String user;
	public String passWord;
	public int linenumber;
	public String data;
	
	public static ArrayList<String> ar = new ArrayList<String>();
	public static ArrayList<String> recordon = new ArrayList<String>();
	public static ArrayList<String> armeta = new ArrayList<String>();
	
	
	
	
	public void dataBaseConnection(String databaseURL, String user,  String passWord,String data) throws SQLException, ClassNotFoundException, Exception{
		

		  
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String URL = databaseURL;
				String Username = user;
				String Password = passWord;
				System.out.println("Driver Loaded");
				con = DriverManager.getConnection(URL, Username, Password);

				if (con != null) {
					System.out.println("Connected to the Database...");
					
					logStep("Connected to Databse");
				}
				Statement stmt = con.createStatement();
				System.out.println("Connection successfull" + stmt.toString());
			}

			catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.getMessage();
			}
			// step3 create the statement object
			Statement stmt = con.createStatement();
			// step4 execute query
			ResultSet rs = stmt.executeQuery(data);
			while (rs.next()) {

				ResultSetMetaData metaData = rs.getMetaData();

				int count = metaData.getColumnCount(); // number of column
				
				String columnName[] = new String[count];

				for (int i = 1; i <=count; i++) {
					columnName[i - 1] = metaData.getColumnLabel(i);
					//System.out.println(columnName[i - 1].toString());
					armeta.add(columnName[i - 1]);
					ar.add(rs.getString(i));

				}

				//System.out.println("Meta data is : "+armeta);
				System.out.println("ar data is : "+ar);
				
				String mediatorcount = ar.get(0);
				
				int mediatorresult = Integer.parseInt(mediatorcount);	
				
				if(mediatorresult>0) {
				
					logStep("Login to Mediator Successfull");
				
					logStep("WOP to MP to Portal to Mediator Integration is Success : " + mediatorresult);
				
				}else {
					
					Assert.fail("WOP to MP to Portal to Mediator Integration is Failed");
				}

			}

			con.close();

		}
	}

