package com.amc.txrepo;


import java.awt.Toolkit;

import java.awt.datatransfer.DataFlavor;


import java.io.File;
import java.io.IOException;

import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.sikuli.script.App;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;



public class WOPObjets extends TxBase {

	public String UserName;
	public String Password;
	public String NameofTheUser;
	public String LauncherTop;
	public String startDate;
	public String endDate;
	ExcelUtils excelUtils = new ExcelUtils();
	ExcelUtils excelUtilsRemote = new  ExcelUtils();
	ExcelUtils exceldata = new ExcelUtils();
	TxBase baseTest = new TxBase();

	Screen screen = new Screen();

	TxBase wop = new TxBase();

	// Created constructor to Initializing the page objects

	public WOPObjets(WebDriver driverWOP) {

		PageFactory.initElements(driverWOP, this);
	}

	// Captured the CMSNV Test Application objects
	// element for Username textbox
	@FindBy(name = "DomainUserName")
	WebElement UName;

	// element for Password text box
	@FindBy(name = "UserPass")
	WebElement Pword;

	// element for Sigh in Button
	@FindBy(id = "btnSignIn")
	WebElement SignIn;

	// Select and download Program

	@FindBy(xpath = "//*[@class=\"tswa_boss\"]")
	WebElement WopProgram;

	@FindBy(xpath = "//*[@class=\"tswa_appboard tswa_appdisplay\"]")
	WebElement ListOfWopEnvs;

	// Login into the WOP Portal
	public void Login(String UsrName) throws Exception {
		// excelUtils.readingexcelFiles("Urls");
		// Wait for Username and enter
		NameofTheUser = UsrName;
		excelUtils.readingexcelFiles("LogIn");
		for (int i = 1; i <= excelUtils.lastRow; i++) {
			if (NameofTheUser.equalsIgnoreCase(excelUtils.excelData[i][2].toString())) {
				UserName = excelUtils.excelData[i][0].toString();
				Password = excelUtils.excelData[i][1].toString();
				break;
			}
		}

		UName.clear();
		UName.sendKeys(UserName);

		// Enter password
		Pword.clear();
		Pword.sendKeys(Password);

		// Click on Signin Button
		SignIn.click();
		
		logStep(" WOP Login Success..");

	}

	public void selectProgrameType() throws Exception {
		excelUtils.readingexcelFiles("WOPScedulingImages");
		List<WebElement> WopEnvs = ListOfWopEnvs.findElements(By.xpath("//*[@class=\"tswa_ttext\"]"));
		// Select Environment based on the selection
		if (TxBase.ProgramEnv.equalsIgnoreCase("Test")) {
			for (WebElement EnvType : WopEnvs) {
				if (EnvType.getText().equalsIgnoreCase("Test")) {
					EnvType.click();
					
					break;
				}
			}
		} else if (TxBase.ProgramEnv.equalsIgnoreCase("Stage")) {
			for (WebElement EnvType : WopEnvs) {
				if (EnvType.getText().equalsIgnoreCase("PrdDebug")) {
					EnvType.click();
					break;
				}
			}
		}
		

		// Launch Program from Download
		
      
		
		openRemoteDesktopFile();
		
		Thread.sleep(5000);

		try {
			// Reeneter Password
			String ReenterPswd = excelUtils.excelData[59][1].toString(); // Re-Entering Password For windows Authentication
			imageEnterText(ReenterPswd, Password, 20);

			String ReenterOK = excelUtils.excelData[60][1].toString(); //  Windows Authentication Ok Selection
			Pattern reneterOK = baseTest.fileReaders(ReenterOK);
			screen.wait(reneterOK, 10);
			screen.click(reneterOK);

		} catch (Exception e) {
			
			System.out.println("Application alreday launched");
		}
		
		driverWOP.close();

		screen.wait((double) 49);

		// click on WOP Browse Launch icon
		
		String WOPProgramLaunch = excelUtils.excelData[62][1].toString(); // WOP Program Start Icon Selection
		
		imageClick(WOPProgramLaunch, 20);

		

		// click on OK for SSO Login
		
		String SSOLoginOK = excelUtils.excelData[63][1].toString(); // SSOLogin window Ok Selection
		
		imageClick(SSOLoginOK, 20);
		
		logStep("Launch Success..");

		// screen.click(SSOLoginOK, 10);

	}

	// Close applications
	public void closeWOPApps() throws FindFailed {
		String WOPOnTaskBar = excelUtils.excelData[13][1].toString();// Opening WOP Launch Programmer
		imageRightClick(WOPOnTaskBar, 10);
		String CloseApplication = excelUtils.excelData[64][1].toString(); // Close WOP Windows
		imageClick(CloseApplication, 10);

		String NotoClose = "Pictures\\WopImages\\NotoClose.PNG";
		imageClick(NotoClose, 10);// Clik on Yes to close apps
	}

	// Take screenshot
	public void takescreenshot(String application, String Screename) throws IOException {
		String Folderpath = System.getProperty("user.dir") + "\\Downloads\\TakeSceenShots_" + application;
		cleanFolder(Folderpath);
		Region appRegion = App.focusedWindow();
		ImageIO.write(screen.capture(appRegion).getImage(), "png", new File(Folderpath + "\\Screename.png"));
	}

	// Valdidating the fields
	public void validateFields() throws Exception {
		
		excelUtils.readingexcelFiles("WOPScedulingImages");
		
		LauncherTop = excelUtils.excelData[1][1].toString(); // search for TransmissionScreen
		try {
			//imageFind(LauncherTop, 10);
			System.out.println("======= Transmission View found ==========");
		} catch (Exception e) {
			String WOPOnTaskBar = excelUtils.excelData[13][1].toString();// Opening WOP Launch Programmer
			imageClick(WOPOnTaskBar, 10);
			String TrmsViewLuanchfromTaskBar = excelUtils.excelData[65][1].toString(); // launch
																											// TransmissionView
																											// from
																											// TaskBar
			try {
				imageClick(TrmsViewLuanchfromTaskBar, 10);
			} catch (Exception lanch) {
				String WOPLuanchfromTaskBar = excelUtils.excelData[66][1].toString(); // Wop Launch From task bar
				imageClick(WOPLuanchfromTaskBar, 10); 
				String ProdSearch = excelUtils.excelData[2][1].toString();
				imageEnterText(ProdSearch, "Transmission", 30);

				// Double click on View / browse
				String TransMission = excelUtils.excelData[3][1].toString();
				imageDoubleClick(TransMission, 10);

				// Select Channel
				String ChannelSelection = excelUtils.excelData[4][1].toString();
				imageEnterText(ChannelSelection, "AMC Linear", 10);

				String StartDate = excelUtils.excelData[7][1].toString(); // Select StartDate and Click OK
				imageEnterText(StartDate, "10/01/2019", 10);

				String EndDate = excelUtils.excelData[8][1].toString(); // Select EndDate and Click OK
				imageEnterText(EndDate, "10/20/2019", 10);

				String ChannelOpen = excelUtils.excelData[9][1].toString(); // click on Open to view Transmission View
				imageClick(ChannelOpen, 10);

				// Select any Schedule in the grid
				String SelectExistingSchedule = excelUtils.excelData[67][1].toString(); // Existing Schedule Selection
																							
				imageClick(SelectExistingSchedule, 10);

			}

		}
		// Validate StartDate

		String Validate_StartDate = excelUtils.excelData[68][1].toString(); // Selecting start Date
																					
		String StartDate = imagecopyText(Validate_StartDate, 10);

		System.out.println("Start date is ======================= : " + StartDate);
	}

	// Launch transmission View
	
	@SuppressWarnings("unused")
	public void launchTransmissionView() throws Exception {
		// Transmission View Open
		excelUtils.readingexcelFiles("WOPScedulingImages");
		exceldata.readingexcelFiles("");
		String TransmissionViewType = "Series";
		String Title = null;
		Thread.sleep(5000);

		// Click on Launcher
		LauncherTop = excelUtils.excelData[1][1].toString();
		try {
			imageFind(LauncherTop, 10);
		} catch (Exception e) {
			String WOPOnTaskBar = excelUtils.excelData[13][1].toString();// Opening WOP Launch Programmer
			imageClick(WOPOnTaskBar, 10);
			String WOPLuanchfromTaskBar = "Pictures\\WopImages\\WOPLaunchFromTaskBar.PNG";
			imageClick(WOPLuanchfromTaskBar, 10);
		}

		LauncherTop = excelUtils.excelData[1][1].toString();
		imageClick(LauncherTop, 10);
		// search for View
		String ProdSearch = excelUtils.excelData[2][1].toString();
		imageEnterText(ProdSearch, "Transmission", 30);

		// Double click on View / browse
		String TransMission = excelUtils.excelData[3][1].toString();
		imageDoubleClick(TransMission, 10);

		// Select Channel
		String ChannelSelection = excelUtils.excelData[4][1].toString();
		imageEnterText(ChannelSelection, "AMC Linear", 10);

		String StartDate = excelUtils.excelData[7][1].toString(); // Select StartDate and Click OK
		imageEnterText(StartDate, startDate, 10);

		String EndDate = excelUtils.excelData[8][1].toString(); // Select EndDate and Click OK
		imageEnterText(EndDate, endDate, 10);

		String ChannelOpen = excelUtils.excelData[9][1].toString(); // click on Open to view Transmission View
		imageClick(ChannelOpen, 10);
		try {
			String YesButton = "Pictures\\WopImages\\YesButton.PNG"; // click on Yes to view more then one year data
																		// Transmission View
			imageClick(YesButton, 10);
			Thread.sleep(5000);
			System.out.println("Transmission view was opened for " + startDate + " to " + EndDate);
		} catch (Exception e) {
			System.out.println("Transmission view was opened for " + startDate + " to " + EndDate);
		}

	}

	// scheduleThroughExploitationWindowBrowser

	public void scheduleThroughExploitationWindowBrowser() throws Exception {

		// Transmission View Open
		excelUtils.readingexcelFiles("WOPScedulingImages");
		// exceldata.readingexcelFiles("");
		@SuppressWarnings("unused")
		String TransmissionViewType = "Series";
		@SuppressWarnings("unused")
		String Title = null;
		Thread.sleep(4000);
		String[] words = null;

		// Start explotation Browser

		Thread.sleep(4000);
		// Click on Launcher
		LauncherTop = excelUtils.excelData[1][1].toString(); // Click on WOP Launcher for bring front select browse
																// types

		try {
			imageFind(LauncherTop, 20);
		} catch (Exception e) {
			String WOPOnTaskBar = excelUtils.excelData[13][1].toString();// Opening WOP Launch Programmer

			// "Pictures\\WopImages\\WOPonTaskBar.PNG";// Search for all records

			imageClick(WOPOnTaskBar, 20);

		}
		imageClick(LauncherTop, 20);

		// Search For the view

		String ProdSearch = excelUtils.excelData[2][1].toString();// Search for Browse in searchbox

		imageFind(ProdSearch, 20);

		imageEnterText(ProdSearch, "Exploitation", 20);

		String Exploitation = excelUtils.excelData[14][1].toString();// Launching Expoitation Window Browser

		// "Pictures\\WopImages\\ExploitationWindowBrowser.PNG";
		imageDoubleClick(Exploitation, 20);

		String FilterChannel = excelUtils.excelData[15][1].toString();// Filling Filter Channel Field

		imageEnterText(FilterChannel, "AMC Linear", 20);

		String SelectContractTab = excelUtils.excelData[16][1].toString();// Select Contratct Tab for enter DealID

		imageClick(SelectContractTab, 20);

		String EnterDealID = excelUtils.excelData[17][1].toString(); // enter DealID

		imageEnterText(EnterDealID, "59672", 20);

		String ExploitationSearch = excelUtils.excelData[18][1].toString(); // Search for all records

		imageClick(ExploitationSearch, 20);
		try {
			String ExploitationSelectAll = excelUtils.excelData[19][1].toString(); // Selecting 250 Records Button

			imageClick(ExploitationSelectAll, 20);
		} catch (Exception e) {

			System.out.println("List Not more then 250");
		}
		Thread.sleep(5000);

		String ProductVersioninonView = excelUtils.excelData[20][1].toString(); // Product Version View
		try {
			imageFind(ProductVersioninonView, 20);
		} catch (Exception e) {
			String Productgadget = excelUtils.excelData[21][1].toString(); // Selecting Add gadegt

			imageClick(Productgadget, 20);

			String SelectProductversion = excelUtils.excelData[22][1].toString(); // Selecting Product Version in gadget

			imageClick(SelectProductversion, 20);
		}

		String rightClickonAsset = excelUtils.excelData[23][1].toString(); // Right clicking on Asset
		imageClick(rightClickonAsset, 20);
		String findProductVersioninProduct = excelUtils.excelData[24][1].toString(); // finding Product Versioon
		String copyClipboard = excelUtils.excelData[25][1].toString(); // Copy the info/value

		outer: for (int i = 1; i < 250; i++) {
			try {
				imageFind(findProductVersioninProduct, 5);

				imageRightClick(rightClickonAsset, 10);
				imageClick(copyClipboard, 10);
				Thread.sleep(2000);
				try {
					String result = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
							.getData(DataFlavor.stringFlavor);

					System.out.println("result  is :============ " + result.trim());
					words = result.split("		");
					startDate = words[2].toString();
					words = startDate.split("	");
					startDate = words[0];
					endDate = words[1];

					System.out.println("StartDate is --- : " + startDate + "---- End Date is ---: " + endDate);
				} catch (Exception e) {
					e.printStackTrace();
				}

				launchTransmissionView();
				Thread.sleep(2000);
				String WOPOnTaskBar = excelUtils.excelData[13][1].toString();// Opening WOP Launch Programmer
				imageClick(WOPOnTaskBar, 10);
				String WOPLuanchfromTaskBar = excelUtils.excelData[26][1].toString(); // Select Exploit window from task bar.
				imageClick(WOPLuanchfromTaskBar, 10);
				String DropPlace = excelUtils.excelData[27][1].toString(); // select dropplace for target

				for (int j = 1; j <= 10; j++) {
					try {
						imageDragDrop(findProductVersioninProduct, DropPlace);
						Thread.sleep(3000);
						break outer;
					} catch (Exception e) {
						String ScrollRight = excelUtils.excelData[28][1].toString();
						imageClickMultiple(ScrollRight, 10, 4); // Scroll right for Slot availability
						String Explotwindow = excelUtils.excelData[29][1].toString(); // SelectingExploit window
						WOPOnTaskBar = excelUtils.excelData[13][1].toString();// Opening WOP Launch Programmer
						imageClick(WOPOnTaskBar, 10);// Click on WOP on taskbar
						imageClick(Explotwindow, 10);// Launch WOP Explot window
					}
				}

			} catch (Exception e) {
				screen.type(null, Key.DOWN);
			}
		}

		String EnterTxSeqTitle = excelUtils.excelData[30][1].toString(); // Enter Tx sequency Title
		imageEnterText(EnterTxSeqTitle, "Trans and Explot schedule", 10);
		System.out.println("======= Check for Valid Contract  ==========");
		// No Valid contract exist
		String ClickOncreate = excelUtils.excelData[31][1].toString(); // Create button Selection

		imageClick(ClickOncreate, 10);
		try {
			System.out.println("======= Valid Contract found ==========");
			// Linking successfully

			Thread.sleep(5000);
			String ClickOnLinkButton = excelUtils.excelData[32][1].toString();// Link button Selection

			imageClick(ClickOnLinkButton, 10);
			// screen.type(Key.ENTER);

		} catch (Exception e) {
			try {
				System.out.println("==================NO Valid contract available on this===================");
				String KeepTransmission = excelUtils.excelData[33][1].toString(); // Select KeepTrnsmission to
																						// create
				imageClick(KeepTransmission, 10);

				String ContinuAndVerify = excelUtils.excelData[34][1].toString(); // Select ContinuAndVerify to
																						// create
				imageClick(ContinuAndVerify, 10);

				String CloseverifyWindow = excelUtils.excelData[35][1].toString(); // Select first one from the
																						// list
				imageClick(CloseverifyWindow, 10);

			} catch (Exception invalidContract) {
				System.out.println("==================NO Valid contract available on this===================");

				String ContinuAndVerify = excelUtils.excelData[34][1].toString(); // Select ContinuAndVerify to
																						// create
				imageClick(ContinuAndVerify, 10);

				String CloseverifyWindow = excelUtils.excelData[35][1].toString(); // Select first one from the
																						// list
				imageClick(CloseverifyWindow, 10);

			}

		}

		String NavigateToBelowWindow = excelUtils.excelData[36][1].toString(); // Select KeepTrnsmission to
																							// create
		imageClick(NavigateToBelowWindow, 10);

		// validateFields();
		screen.type(Key.F12);
		Thread.sleep(5000);

		imageRightClick(rightClickonAsset, 10);
		imageClick(copyClipboard, 10);
		Thread.sleep(2000);
		try {
			String result = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

			System.out.println("result  is :============ " + result);
			String[] ResultValues = result.toString().split(" 	");
			int rcount = 0;
			for (String rVal : ResultValues) {
				System.err.println("rVal is ---" + rcount + "  : " + rVal.trim());
				rcount = rcount + 1;

			}

		} catch (Exception e) {
           System.out.println(e.getMessage());
		}

		// Validate Green progressbar
		String progressbar = excelUtils.excelData[37][1].toString(); // Right selection on Progress Bar
		imageRightClick(progressbar, 10);
		imageClick(copyClipboard, 10);
		Thread.sleep(2000);
		try {
			String GreenStatus = excelUtils.excelData[38][1].toString(); // Finding green status
			imageFind(GreenStatus, 10);
			takescreenshot("WOP", "TransmissionViewWithValidContract");
			String result = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

			System.out.println("result  is :============ " + result.trim());
			String[] ResultValues = result.toString().trim().split("	");
			int rcount = 0;
			for (String rVal : ResultValues) {
				if (rVal.trim().equalsIgnoreCase("4CB34C")) {
					System.err.println("Valid Contract attached====");
					break;
				} else if (rVal.trim().equalsIgnoreCase("FF0000")) {
					System.out.println("Invalid contract attached please check it once");
				}
				rcount = rcount + 1;

			}

		} catch (Exception e) {
        
			System.out.println(e.getMessage());
		}
		String CloseVerification = excelUtils.excelData[39][1].toString(); // Closing verification window.
		imageClick(CloseVerification, 10);
		System.out.println("========End ========");

	}

	// scheduleThroughPrellminaryGenaricPrograme
	public void scheduleThroughPrellminaryGenaricPrograme() throws Exception {
		excelUtils.readingexcelFiles("WOPScedulingImages");
		String TransmissionViewType = "Series";
		String Title = null;
		Thread.sleep(15000);
		excelUtils.readingexcelFiles("WOPScedulingImages");

		// Click on Launcher

		String LauncherTop = excelUtils.excelData[1][1].toString();
		imageClick(LauncherTop, 10);
		// search for View
		String ProdSearch = excelUtils.excelData[2][1].toString();
		imageEnterText(ProdSearch, "Transmission", 30);

		// Double click on View / browse
		String TransMission = excelUtils.excelData[3][1].toString();
		imageDoubleClick(TransMission, 10);

		// Select Channel
		String ChannelSelection = excelUtils.excelData[4][1].toString();
		imageEnterText(ChannelSelection, "AMC Linear", 10);

		String StartDate = excelUtils.excelData[7][1].toString(); // Select StartDate and Click OK
		imageEnterText(StartDate, "10/01/2019", 10);

		String EndDate = excelUtils.excelData[8][1].toString(); // Select EndDate and Click OK
		imageEnterText(EndDate, "10/30/2019", 10);

		String ChannelOpen = excelUtils.excelData[9][1].toString(); // click on Open to view Transmission View
		imageClick(ChannelOpen, 10);

		Thread.sleep(5000);
		// Create geanric Schedule
		String TransType = excelUtils.excelData[10][1].toString(); // click on Open to Transmission Views
		imageClick(TransType, 10);

		String MovieType;
		if (TransmissionViewType.equalsIgnoreCase("Movie")) {
			MovieType = excelUtils.excelData[11][1].toString(); // Select Movie Transmission View
			imageClick(MovieType, 10);
			Title = "Dead Snow";
		} else if (TransmissionViewType.equalsIgnoreCase("Series")) {

			MovieType = excelUtils.excelData[12][1].toString(); // Select Movie Transmission View
			imageClick(MovieType, 10);
			Title = "Voice of a Generation";
		}
		// Start point to create schedule
		String StartPoint = excelUtils.excelData[40][1].toString(); // StartPoint for schedule create
		// End point to create schedule
		String EndPoint = excelUtils.excelData[41][1].toString();// Endpoint for schedule create

		imageDragDrop(StartPoint, EndPoint);

		// Enter Details
		if (TransmissionViewType.equalsIgnoreCase("Movie") || TransmissionViewType.equalsIgnoreCase("Series")) {

			String TxSqnsTitle = excelUtils.excelData[42][1].toString(); // Enter TxSequence Title
			imageEnterText(TxSqnsTitle, TransmissionViewType, 10);

			String GroupingTitle = excelUtils.excelData[43][1].toString(); // Enter Grouping Title
			imageEnterText(GroupingTitle, TransmissionViewType, 10);

			String HeadTitle = excelUtils.excelData[44][1].toString(); // Enter Head Title
			imagedoubleClickEnterText(HeadTitle, TransmissionViewType, 10);

			String TitleText = excelUtils.excelData[45][1].toString(); // Enter Title
			imageEnterText(TitleText, TransmissionViewType, 10);

		}

		screen.type(null, "L", KeyModifier.ALT);
		String LinkProduct = excelUtils.excelData[46][1].toString(); // Select Link Product option
		imageClick(LinkProduct, 10);
		Thread.sleep(3000);
		String ExploitationSearch = excelUtils.excelData[47][1].toString();// Search for all records
		imageClick(ExploitationSearch, 10);
		Thread.sleep(3000);
		try {
			String ExploitationSelectYes = excelUtils.excelData[57][1].toString(); // Select Yes
			imageClick(ExploitationSelectYes, 10);
		} catch (Exception e) {
			System.out.println("Direct click on 250 button");
		}
		String ExploitationSelectAll = excelUtils.excelData[19][1].toString(); // Select 250 from the list
		imageClick(ExploitationSelectAll, 10);
		Thread.sleep(5000); // wait till the list loaded

		String SearchTitle = excelUtils.excelData[48][1].toString(); // Enter Title for search
		imageEnterText(SearchTitle, Title, 10);
		screen.type(null, Key.ENTER, KeyModifier.ALT);

		try {
			String SearchforRightrecord = null;
			if (TransmissionViewType.equalsIgnoreCase("Movie")) {
				SearchforRightrecord = excelUtils.excelData[49][1].toString(); // Enter Movie Title for search


			} else if (TransmissionViewType.equalsIgnoreCase("Series")) {
				SearchforRightrecord = excelUtils.excelData[50][1].toString(); // Enter Series Title for search

			}
			imageFind(SearchforRightrecord, 10);
			String ClosetheWindow = excelUtils.excelData[57][1].toString(); // Close the window
			imageClick(ClosetheWindow, 10);

			String SelectonefromList = excelUtils.excelData[51][1].toString(); // Select first one from the
																							// list
			imageClick(SelectonefromList, 10);

			String SelectlinkOption = excelUtils.excelData[52][1].toString(); // Select Link option
			imageClick(SelectlinkOption, 10);

			try {
				String SelectYes = excelUtils.excelData[53][1].toString(); // Select Yes
				imageClick(SelectYes, 10);

			} catch (Exception e) {
				System.out.println("Navigated to Continue Window to create schedule");
			}
			String SelectContinue = excelUtils.excelData[54][1].toString(); // Select Contiue to link
			imageClick(SelectContinue, 10);

			String PlanSchedule = excelUtils.excelData[55][1].toString(); // Select PlanSchedule to create
			imageClick(PlanSchedule, 10);

			String KeepTransmission =  excelUtils.excelData[33][1].toString(); // Select KeepTrnsmission to create
			imageClick(KeepTransmission, 10);

			String ContinuAndVerify =  excelUtils.excelData[34][1].toString(); // Select ContinuAndVerify to create
			imageClick(ContinuAndVerify, 10);

			String CloseverifyWindow =  excelUtils.excelData[35][1].toString(); // Select first one from the list
			imageClick(CloseverifyWindow, 10);

		} catch (Exception e) {
			System.out.println("Record not matched with " + TransmissionViewType + " Type");
			String ClosetheWindow = excelUtils.excelData[56][1].toString(); // Close the window
			imageClick(ClosetheWindow, 10);

			
		}

	}

}
