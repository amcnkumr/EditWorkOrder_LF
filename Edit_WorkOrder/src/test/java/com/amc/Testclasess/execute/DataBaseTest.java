package com.amc.Testclasess.execute;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amc.txbase.TxBase;
import com.amc.txrepo.DatabaseConnection;
import com.amc.txrepo.WOPEpisodeVersion;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class DataBaseTest extends TxBase {
	
	DatabaseConnection dbTest= new DatabaseConnection();
	
	
	@Features("Edit Work Order")

	@Stories("Mediator")

	@Title("Connecting to DataBase and Mediator")
	
	@Test
	public void DataBaseConnectionTest() throws ClassNotFoundException, SQLException, java.lang.Exception {
		
		
		if(WOPEpisodeVersion.Execution.equalsIgnoreCase("Fail")) {
			
			logStep("WOP is Not Up and Running");
			
			Assert.fail("WOP is Not Up and Running");
			
		}else {
		
		dbTest.databaseConnection();
			
	}
	
	}
}
