package com.amc.txrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.Screen;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;

public class MPObjects extends TxBase {

	TxBase wop = new TxBase();

	Screen WopScreen = new Screen();

	ExcelUtils excelUtils = new ExcelUtils();
	
	ExcelUtils excelUtilsRemote = new  ExcelUtils();
	

	public String NameofTheUser;

	public String UserName;

	public String Password;

	@FindBy(xpath = "//a[@class='dialog button default']")
	WebElement accept;

	@FindBy(xpath = "//*[@class='box-links detection-right-links']/a[contains(text(),'Detect Receiver')]")
	WebElement detectReceiver;

	@FindBy(xpath = "(//a[contains(text(),'Already installed')])[1]")
	WebElement alreadyInstalled;

	@FindBy(xpath = "//input[@name='username']")
	WebElement usename;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//a[@id='loginBtn']")
	WebElement login;

	@FindBy(xpath = "//a[@id='allAppsBtn']")
	WebElement allAppsBtn;

	@FindBy(xpath = "//img[@alt='MediaPulse-DEV']")
	WebElement mpdev;

	@FindBy(xpath = "//a[@id='userMenuBtn']")
	WebElement userMenuBtn;

	@FindBy(xpath = "//a[@id='menuLogOffBtn']")
	WebElement menuLogOffBtn;

	
	// Logging into Non Prod Portal 
	
	public void NonProdLogin(String UsrName) throws java.lang.Exception {

		accept.click();

		detectReceiver.click();

		String cancel = "Pictures\\WopImages\\Cancel.PNG";

		imageFindClick(cancel, 3);

		alreadyInstalled.click();

		NameofTheUser = UsrName;

		excelUtils.readingexcelFiles("LogIn");

		for (int i = 1; i <= excelUtils.lastRow; i++) {
			if (NameofTheUser.equalsIgnoreCase(excelUtils.excelData[i][2].toString())) {
				UserName = excelUtils.excelData[i][0].toString();
				Password = excelUtils.excelData[i][1].toString();
				break;
			}
		}

		usename.sendKeys(UserName);

		password.sendKeys(Password);

		login.click();
		
		logStep("MP Login Success");

		allAppsBtn.click();

	}

	
	
	// Select Environment based on the selection
	
	public void selectProgrameType(String Envi) throws Exception {

		WebElement element = driverWOP.findElement(By.xpath("//img[@alt='"+Envi+"']"));

		if (Envi.equalsIgnoreCase("MediaPulse-TEST")) {

			element.click();
			
		} else if (Envi.equalsIgnoreCase("MediaPulse-DEV")) {

			element.click();

		}

		screen.wait((double) 3.0);
		
		String mpfile = "Pictures\\WopImages\\mpfile.PNG";

		imageFindClick(mpfile, 5);
		
		screen.wait((double) 5.0);
		
	    screen.wait((double) 40.0);

		String MpOK = "Pictures\\WopImages\\MpOK.PNG";

		imageFindClick(MpOK, 4);
		
		screen.wait((double) 25.0);
		
		driverWOP.quit();

		

	}

}
