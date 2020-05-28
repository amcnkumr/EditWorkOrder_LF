package com.amc.txrepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;

import junit.framework.Assert;

public class PortalLoginObjects extends TxBase {
	
	ExcelUtils excelUtils = new ExcelUtils();
	
	@FindBy(xpath ="//input[@name='username']") WebElement userName;
	
	@FindBy(xpath = "//button[@type='submit']") WebElement nextButton;
	
	@FindBy(xpath = "//input[@name='password']") WebElement passWord;
	
	@FindBy(xpath = "//button[@id='login-body-box-button']") WebElement loginButton;
		
	@FindBy(xpath = "//div[contains(text(), 'Home')]") WebElement homeScreen;

	
	public String NameofTheUser;

	public String UserName;

	public String Password;
	
	
	public void loginPortal(String UsrName) throws Exception {
		
		
		NameofTheUser = UsrName;

		excelUtils.readingexcelFiles("LogIn");

		for (int i = 1; i <= excelUtils.lastRow; i++) {
			if (NameofTheUser.equalsIgnoreCase(excelUtils.excelData[i][2].toString())) {
				UserName = excelUtils.excelData[i][0].toString();
				Password = excelUtils.excelData[i][1].toString();
				break;
			}
		}
		

	   
	    ExplicitWait(userName);
	   
	    userName.sendKeys(UserName);
	    
	    Thread.sleep(2000);
	    
		nextButton.click();
		
		System.out.println("Portal userName entered successfully..");
		
		ExplicitWait(passWord);
		
		passWord.sendKeys(Password);
			
		System.out.println("Portal passWord entered successfully..");
		
		loginButton.click();
		    
	    
		ExplicitWait(homeScreen);
		
		String homeText =homeScreen.getText();
		
		if(homeText.equalsIgnoreCase("Home")) {
			
			Assert.assertEquals("Portal Login Successful..." , "Home", homeText);
			
			logStep("Portal Login Successful..");
			
			System.out.println("Portal Login Successful...");
			
			Thread.sleep(5000);
		} else {
			
			Assert.fail(String.format("Portal Login Not Successful..." , "Home" , homeText)) ;
			
			logStep("Portal Login not Successful..");
			
			System.out.println("Portal Login Successful...");
			

			
		}
		
	}
	
             

	
}
