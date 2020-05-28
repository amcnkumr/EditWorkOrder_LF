package com.amc.txrepo;

import java.sql.SQLException;

import com.amc.txbase.Database;
import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;

public class DatabaseConnection extends TxBase {
	
	
	ExcelUtils databaseexcel = new ExcelUtils();
	ExcelUtils databasequery = new ExcelUtils();
	
	
	Database  database = new Database();
	
	
	  public void databaseConnection() throws ClassNotFoundException, SQLException, java.lang.Exception {
		  
		  databaseexcel.readingexcelFiles("DataBase");
		  
		  String url  = databaseexcel.excelData[1][0];
		  String user = databaseexcel.excelData[1][1];
		  String pass = databaseexcel.excelData[1][2];	
		  String query = databaseexcel.excelData[1][3];
		 
		String MatID = TxBase.Mattextvalue;
		
		//String MatID = "LSIT01021711";
		 
		String[] querySplits = query.split("MATID");

		String finalQuery = querySplits[0].toString() + MatID + querySplits[1].toString();
		  
		database.dataBaseConnection(url,user, pass,finalQuery);
		  
	  }
			
			
			
			
			
			

}
