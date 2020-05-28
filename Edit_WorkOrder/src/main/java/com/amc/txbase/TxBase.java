package com.amc.txbase;


import java.awt.Desktop;
import java.awt.HeadlessException;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.Button;

import org.sikuli.script.FindFailed;
import org.sikuli.script.KeyModifier;

import org.sikuli.script.Pattern;

import org.sikuli.script.Screen;




import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class TxBase {

	public static WebDriver driver;
	public static WebDriver driverWOP;
	public static String Exception = "NA";
	public static String ProgramEnv = null;
	public static String programType = null;
	public Screen screen = new Screen();
	public static File index;	
	
	public static String textvalue;
	
	public static String textvalueDecimal;
	
	public static String Mattextvalue;
	
	public static String GeneralMattextvalue;
	
	public static String TempoMattextvalue;
	
	public static String result;
	
	public static ArrayList<String> wopEpisodeVersionData = new ArrayList<String>();
	
	public static ArrayList<String> mpEpisodeVersionData = new ArrayList<String>();
	
	public static ArrayList<String> portalEpisodeVersionData = new ArrayList<String>();

	public static ArrayList<String> WOPGeneralEditWork = new ArrayList<String>();

	public static ArrayList<String> WOPTempoEditWork = new ArrayList<String>();
	
	public static ArrayList<String> MPGeneralEditWork = new ArrayList<String>();
	
	public static ArrayList<String> MPTempoEditWork = new ArrayList<String>();
	
	public static ArrayList<String> portalGeneralEditWork = new ArrayList<String>();
	
	public static ArrayList<String> portalTempoEditWork = new ArrayList<String>();
	
	
	public static String GeneralSourceAsset;
	
	public static String TempoSourceAsset;
	
	public static String generalMatID;
	
	public static String TempoEditMatID;
	
	
	// Allure Generator

	@Step("{0}")

	public static void logStep(String stepName) {

	}

	// Explicit Wait to balance between the Browser and WebElements

	public void timing(WebElement accept) {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(accept));

	}

	
	
		
		public void wopEpisodeVersionData(String field) {
						
		 wopEpisodeVersionData.add(field);
				
		 for(int i=0; i<wopEpisodeVersionData.size(); i++) {
			 
	     System.out.println("WOP Episode Verison Data :" + wopEpisodeVersionData.get(i));
					
		 }			
			
	}
		
		
		public void wopGeneralEditWorkOrderData(String field) {
			
			WOPGeneralEditWork.add(field);
					
			 for(int i=0; i<WOPGeneralEditWork.size(); i++) {
				 
		     System.out.println("WOP General Edit Work Order Data :" + WOPGeneralEditWork.get(i));
						
			 }			
				
		}
		
		
		
		
		
public void wopTempoEditWorkOrderData(String field) {
			
			WOPTempoEditWork.add(field);
					
			 for(int i=0; i<WOPTempoEditWork.size(); i++) {
				 
		     System.out.println("WOP Tempo Edit Work Order Data :" + WOPTempoEditWork.get(i));
						
			 }			
				
		}
		


	public void mpGeneralEditWorkOrderData(String field) {
	
		 generalMatID= field+textvalue;
		
		if(generalMatID.contains("GeneralEditMatID:")) {
			
			generalMatID=generalMatID.replaceAll("GeneralEditMatID:", "");
			
			System.out.println(" MP General Edit Mat ID " + generalMatID );
		}
		
		
		MPGeneralEditWork.add(field+textvalue);
			
	 for(int i=0; i<MPGeneralEditWork.size(); i++) {
		 
    System.out.println("MP General Edit Work Order Data :" + MPGeneralEditWork.get(i));
				
	 }			
		
	}
		
	
	
	public void mpTempoEditWorkOrderData(String field) {
		
		
		TempoEditMatID= field+textvalue;
			
			if(TempoEditMatID.contains("TempoEditMatID:")) {
				
				TempoEditMatID=TempoEditMatID.replaceAll("TempoEditMatID:", "");
				
				System.out.println(" MP Tempo Edit Mat ID " + TempoEditMatID );
			}
		
		
		MPTempoEditWork.add(field+textvalue);
			
	 for(int i=0; i<MPTempoEditWork.size(); i++) {
		 
    System.out.println("MP Tempo Edit Work Order Data :" + MPTempoEditWork.get(i));
				
	 }			
		
	}
	
	
	public void portalGeneralEditWorkOrderData(String field) {
		
		portalGeneralEditWork.add(field);
				
		 for(int i=0; i<portalGeneralEditWork.size(); i++) {
			 
	     System.out.println("Portal General Edit Work Order Data :" + portalGeneralEditWork.get(i));
					
		 }			
			
	}
	
	
public void portalTempoEditWorkOrderData(String field) {
		
	portalTempoEditWork.add(field);
				
		 for(int i=0; i<portalTempoEditWork.size(); i++) {
			 
	     System.out.println("Portal Tempo Edit Work Order Data :" + portalTempoEditWork.get(i));
					
		 }			
			
	}
	
	
	
	
	public void Generalsourcefield(String field) {
		
		GeneralSourceAsset = textvalue;
		
		System.out.println("General Edit Work Order Integration is succes:"+field+GeneralSourceAsset);
		
		//logStep("General Edit Work Order Integration is succes:"+field+GeneralSourceAsset);
		
		GeneralSourceAsset=field+GeneralSourceAsset;
		
	}
	
	
	
	public void Temposourcefield(String field) {
		
		TempoSourceAsset = textvalue;
		
		System.out.println("Tempo Edit Work Order Integration is succes:"+field+TempoSourceAsset);
		
		//logStep("Tempo Edit Work Order Integration is succes:"+field+TempoSourceAsset);
		
		TempoSourceAsset = field+TempoSourceAsset;
		
	}
	
	
	
		
		public void mpEpisodeVersionData(String field) {
			
			 mpEpisodeVersionData.add(field+textvalue);
					
			 for(int i=0; i<mpEpisodeVersionData.size(); i++) {
				 
		     System.out.println("MP Episode Verison Data :" + mpEpisodeVersionData.get(i));
						
			 }			
				
		}
		
		public void mpEpisodeVersionDatavideo(String field) {
			
			 mpEpisodeVersionData.add(field);
					
			 for(int i=0; i<mpEpisodeVersionData.size(); i++) {
				 
		     System.out.println("MP Episode Verison Data :" + mpEpisodeVersionData.get(i));
						
			 }			
				
		}
		
		
		public void mpEpisodeVersionDataAudio(String field) {
			
			 mpEpisodeVersionData.add(field);
					
			 for(int i=0; i<mpEpisodeVersionData.size(); i++) {
				 
		     System.out.println("MP Episode Verison Data :" + mpEpisodeVersionData.get(i));
						
			 }			
				
		}
		
		
		public void mpEpisodeVersionDatafinalTx(String field) {
			
			 mpEpisodeVersionData.add(field);
					
			 for(int i=0; i<mpEpisodeVersionData.size(); i++) {
				 
		     System.out.println("MP Episode Verison Data :" + mpEpisodeVersionData.get(i));
						
			 }			
				
		}
		
		

		public void portalEpisodeVersionData(String field) {
			
			portalEpisodeVersionData.add(field);
					
			 for(int i=0; i<portalEpisodeVersionData.size(); i++) {
				 
		     System.out.println("Portal Episode Verison Data :" + portalEpisodeVersionData.get(i));
						
			 }			
				
		}
		
		
		// Switching to the record locator first frame

		public void switchToFirstFrame() {

			driverWOP.switchTo().frame("content-iframe-container-1");

		}

		// Switching to the record Locator second frame 
		public void switchToSecondFrame() {

			driverWOP.switchTo().frame("content-iframe-container-5017");
		}

		
		// Switching to the View Edit Work Orders screen frame
		
		public void switchToSecondFrameViewEdit() {

			driverWOP.switchTo().frame("content-iframe-container-29298");
		}
		
		
		
		// Switching to the record Locator third frame 
		public void switchToThirdFrame() {
				
			driverWOP.switchTo().frame(2);
		}

		// Coming out from the frames
		public void switchBackFromFrame() {

			driverWOP.switchTo().defaultContent();
		}		
		
		
		// Drop Down Handling Method
		
		public void colorOrBlackAndWhiteField() {
			
			/*JavascriptExecutor js = (JavascriptExecutor)driverWOP;
			
			js.executeScript("window.scrollBy(0,250)");*/
			
			((JavascriptExecutor)driverWOP).executeScript("scroll(0,400)");
		
			Select drpColor = new Select(driver.findElement(By.xpath("(//select[@label_text='Color / B&W'])[1]")));
			
			List<WebElement> options = drpColor.getOptions();
			
			 for (WebElement option : options) {
				
				 System.out.println(option.getText()); 
			 }
			 
		
			 }
		
		
		// Tab Method
		
		public void tabMethod() {
				
				screen.type(Keys.RIGHT);				
				
			}
		
		
		// Keys Down Method
		
		public void keyDownMethod() throws FindFailed {
			
			screen.wait((Double) 1.0);
			
			screen.type(Keys.DOWN);				
			
			screen.wait((Double) 1.0);
		}
		
		
		

	// Reads the Sikuli pictures folder path

	public Pattern fileReaders(String filename) {

		filename = System.getProperty("user.dir") + "\\" + filename;

		Pattern pattern = new Pattern(filename);

		return pattern;
	}



	// Function for take the screen shot in allure report
	@Attachment("Screenshot")
	public static byte[] attachScreen(WebDriver driver) {
		logStep("Taking screenshot");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public File attachScreenFile() {
		logStep("Taking screenshot");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}

	@Attachment("Error_Screenshot")
	public static byte[] attachScreen_TestCaseError(WebDriver driver) {
		logStep("Taking screenshot");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Explicit Wait to balance between the Browser and WebElements

	public void ExplicitWait(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driverWOP, 300);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	
	// Image click using Sikuli
	public void imageClick(String ImagePath, int waitTime) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.click(ProdSearchView);
	}

	// Image click using Sikuli
	public void imageClickMultiple(String ImagePath, int waitTime, int iterations) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		for (int i = 0; i <= iterations; i++) {
			screen.click(ProdSearchView);
		}
	}

	// Image click using Sikuli
	@SuppressWarnings("unused")
	public void imageDragDrop(String startImagePath, String endImagePath) throws FindFailed {
		// Search For the view
		Pattern Startingpoint = fileReaders(startImagePath);
		Pattern endingpoint = fileReaders(endImagePath);
		screen.hover(startImagePath);
		screen.mouseDown(Button.LEFT);
		screen.mouseMove(endingpoint);
		screen.mouseUp(Button.LEFT);

	}

	// Image click using Sikuli
	public void imageFind(String ImagePath, int waitTime) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.find(ProdSearchView);
		screen.doubleClick(ProdSearchView);
		
		
	}

	// Image click using Sikuli
	public String imageFindandread(String ImagePath, int waitTime, String direction, int length) throws FindFailed {
		String textvalue = null;
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		if (direction.equalsIgnoreCase("right")) {
			textvalue = screen.find(ProdSearchView).right(length).text();
		} else if (direction.equalsIgnoreCase("left")) {
			textvalue = screen.find(ProdSearchView).left(length).text();
		}
		return textvalue;
	}

	
	// Image Double Click and Enter Text and Tab and Escape Key Strokes
	public void EnterTextandTab(String ImagePath, String Value, int waitTime) throws FindFailed {
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.doubleClick(ProdSearchView);
		screen.wait((Double) 1.0);
		screen.type(Value);
		screen.type(Keys.TAB);
		
		try {

			inheritaceWindow();

		} catch (Exception e) {

			System.out.println("Inharitance window not populated");
		}

		screen.type(Keys.ESC);
		
		screen.wait((Double) 2.0);
	}

	
	
	// Image Double Click and Enter Text and Tab and Escape Key Strokes
	
	public void EnterTextandTabVersion(String ImagePath, String Value, int waitTime) throws FindFailed {
		
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.doubleClick(ProdSearchView);
		screen.type(Value);
		screen.type(Keys.TAB);
		screen.type(Keys.ESC);
		
		
	}
	
	
	
	// Handling Master Trailer Inheritance window

		public void inheritaceWindow() throws FindFailed {

			String InheritanceOk = "Pictures\\WopImages\\InheritanceOk.PNG";

			Pattern patternInheritanceOk = fileReaders(InheritanceOk);

			screen.wait(patternInheritanceOk, 3);

			screen.click();

			screen.wait((Double) 3.0);
		}

		
	// Select and copy
	
	public String imagecopyText(String ImagePath, int waitTime)
			throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
		//String textvalue = null;
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.click(ProdSearchView);
		screen.wait((double) 1.0 );
		screen.type("a", KeyModifier.CTRL);
		screen.wait((double) 1.0 );
		screen.type("c", KeyModifier.CTRL);
		screen.wait((double) 1.0 );
		textvalue = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);	
		System.out.println("The Value is : " + textvalue);
		return textvalue;
	}

	// Select and copy Mat ID
	
		public String imagecopyMat(String ImagePath, int waitTime)
				throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
			//String textvalue = null;
			// Search For the view
			Pattern ProdSearchView = fileReaders(ImagePath);
			screen.wait(ProdSearchView, waitTime);
			screen.click(ProdSearchView);
			screen.wait((double) 1.0 );
			screen.type("a", KeyModifier.CTRL);
			screen.wait((double) 1.0 );
			screen.type("c", KeyModifier.CTRL);
			screen.wait((double) 1.0 );
			Mattextvalue = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);	
			System.out.println("The Value is : " + Mattextvalue);
			return Mattextvalue;
		}
	
	
		
		// Select and copy Mat ID
		
			public String imagecopyGeneralMat(String ImagePath, int waitTime)
					throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
				//String textvalue = null;
				// Search For the view
				Pattern ProdSearchView = fileReaders(ImagePath);
				screen.wait(ProdSearchView, waitTime);
				screen.click(ProdSearchView);
				screen.wait((double) 1.0 );
				screen.type("a", KeyModifier.CTRL);
				screen.wait((double) 1.0 );
				screen.type("c", KeyModifier.CTRL);
				screen.wait((double) 1.0 );
				GeneralMattextvalue = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);	
				System.out.println("General Edit Work Order Mat ID is : " + GeneralMattextvalue);
				return GeneralMattextvalue;
			}
		
		
			
			// Select and copy Mat ID
			
				public String imagecopyTempoMat(String ImagePath, int waitTime)
						throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
					//String textvalue = null;
					// Search For the view
					Pattern ProdSearchView = fileReaders(ImagePath);
					screen.wait(ProdSearchView, waitTime);
					screen.click(ProdSearchView);
					screen.wait((double) 1.0 );
					screen.type("a", KeyModifier.CTRL);
					screen.wait((double) 1.0 );
					screen.type("c", KeyModifier.CTRL);
					screen.wait((double) 1.0 );
					TempoMattextvalue = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);	
					System.out.println(" Tempo Edit Work Order Mat ID is : " + TempoMattextvalue);
					return TempoMattextvalue;
				}
			
			
		
	
	// Select and copy Decimal Values
		public String imagecopyDecimalText(String ImagePath, int waitTime)
				throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
			//String textvalue = null;
			// Search For the view
			Pattern ProdSearchView = fileReaders(ImagePath);
			screen.wait(ProdSearchView, waitTime);			
			screen.click(ProdSearchView);
			screen.type("a", KeyModifier.CTRL);			
			screen.wait((double) 1.0);		
			screen.type("c", KeyModifier.CTRL);		
			screen.wait((double) 1.0);	
			textvalueDecimal = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			System.out.println("The Decimal Value is : " + textvalueDecimal);
			return textvalueDecimal;
		}
	
	
	// Double click and Copy
	
	public String imagedoubleclickcopyText(String ImagePath, int waitTime)
			throws FindFailed, HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
		//String textvalue = null;
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.doubleClick(ProdSearchView);
		screen.wait((double) 1.0);	
		screen.type("a", KeyModifier.CTRL);
		screen.wait((double) 2.0);		
		screen.type("c", KeyModifier.CTRL);	
		Thread.sleep(2000);
		textvalue = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);	
		
		if(textvalue.contains("1:30:00.__")) {
			
			textvalue = textvalue.replace(".__", "");
		}
		
		System.out.println("The Value is : " + textvalue);
		
		return textvalue;
		
	
	}

	// Image FindAndclick using Sikuli
	public void imageFindClick(String ImagePath, int waitTime) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.find(ProdSearchView);
		screen.click(ProdSearchView);
		screen.wait((double) 1.0);	
		
	}

	
	
	// Image grow and Click
	
	public void imagegrow(String ImagePath, int waitTime) throws FindFailed {
		
		Pattern ProdSearchView = fileReaders(ImagePath);	
		
		screen.wait(ProdSearchView,waitTime).offset(0, 40).grow(15,0).click();
	}
	
	// Image Doubleclick using Sikuli
	public void imageDoubleClick(String ImagePath, int waitTime) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.doubleClick(ProdSearchView);
		
	}

	// Image Rightclick using Sikuli
	public void imageRightClick(String ImagePath, int waitTime) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.rightClick(ProdSearchView);
	}

	// Type Text in Sikuli
	public void imageEnterText(String ImagePath, String Text, int waitTime) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.click(ProdSearchView);
		//screen.type("a", KeyModifier.CTRL);
		//screen.type(Keys.BACKSPACE); // delete selection
		screen.type(Text);

	}
	
	
	// Click and Up ArrowKeys
	
	public void ClickandUpArrow() {
		
		screen.wait((double) 1.0 );
		
		screen.type(Keys.UP);
		
		screen.type(Keys.UP);
				
		screen.type(Keys.UP);
		
		screen.type(Keys.UP);
		
	}
	
	// Clearing the Text
		public void imageClearText(String ImagePath, int waitTime) throws FindFailed {
			// Search For the view
			Pattern ProdSearchView = fileReaders(ImagePath);
			screen.wait(ProdSearchView, waitTime);
			screen.doubleClick(ProdSearchView);
			//screen.type("a", KeyModifier.CTRL);
			screen.type(Keys.BACKSPACE); // delete selection			
			//screen.type(Keys.DELETE);
						
		}

	

	// Type Text in Sikuli
		public void imageClickAndTab(String ImagePath, int waitTime) throws FindFailed {
			// Search For the view
			Pattern ProdSearchView = fileReaders(ImagePath);
			screen.wait(ProdSearchView, waitTime);
			screen.click(ProdSearchView);
			screen.wait((double) 1.0 );
			screen.type("a", KeyModifier.CTRL);
			screen.wait((double) 1.0 );
		    screen.type(Keys.TAB); 
		}
	
	// Type Text in Sikuli
	public void imagedoubleClickEnterText(String ImagePath, String Text, int waitTime) throws FindFailed {
		// Search For the view
		Pattern ProdSearchView = fileReaders(ImagePath);
		screen.wait(ProdSearchView, waitTime);
		screen.doubleClick(ProdSearchView);
		screen.type("a", KeyModifier.CTRL);
		screen.type(Keys.BACKSPACE); // delete selection
		screen.type(Text);
	}

	
	// Tab And Enter
	
	public void Clickenter() {
		
		screen.wait((double) 1.0);
		
		screen.type(Keys.ENTER);
		
		screen.wait((double) 1.0);
	}
	
	
	//Propagate window
	public void propagatewindow() {
		
		screen.type(Keys.UP);	
		screen.type(Keys.TAB);
		screen.type(Keys.UP);
	}
	
	
	//Propagate window
		public void tabforMAVersion() {
				
			screen.type(Keys.TAB);
	        screen.wait((double) 1.0);	

			
		}
	
        public void tabforProductionmode() {
        	
        screen.wait((double) 3.0);	
		
        screen.type(Keys.DOWN);	
		
        screen.type(Keys.DOWN);	
        
        screen.wait((double) 2.0);
	   }
	
        
        // Tempo
        
        public void TempoKeyUp() {
        	
            screen.wait((double) 1.0);	
    		
            screen.type(Keys.UP);
            
            screen.wait((double) 1.0);
    	   }
    	
        
        
        
	// Disoconnect the WOP Program
	
	public void disconnectWop() throws FindFailed {
		
         String Disconnect = "Pictures\\WopImages\\Disconnect.PNG";
		 
		 String LoggOff = "Pictures\\WopImages\\LoggOff.PNG";
		 
		 String WoRightClick = "Pictures\\WopImages\\WoRightClick.PNG";
		 
		 String CloseRight = "Pictures\\\\WopImages\\\\CloseRight.PNG";
		 
         imageFindClick(Disconnect,4);
		 
		 imageFindClick(LoggOff,4);
		 
		 screen.wait((double) 1.0 );
		 
		 imageRightClick(WoRightClick,3);
		 
		 imageFindClick(CloseRight,3);
		 
		 imageFindClick(LoggOff,4);
		 
		 screen.wait((double) 2.0 );
		
	}
	
	
	
	
	// Clear Download folder

	public void cleanFolder(String programName) {

		index = new File(System.getProperty("user.dir") + "\\Downloads\\" + programName);
		if (index.exists()) {
			System.out.println(programName + "Folder exist and need to clear the files in that ");
		} else {
			try {
				index.mkdir();
				System.out.println("Folder Created SUccessFully");
			} catch (SecurityException se) {
				
				System.out.println(se.getMessage());
			}
		}
		String[] entries = index.list();
		try {
			for (String s : entries) {
				File currentFile = new File(index.getPath(), s);
				currentFile.delete();
			}
		} catch (Exception e) {
			System.out.println("No files are there to delete from " + index.toString());
		}
	}

	// Browser Launching

	// Hits the portal URL
	@SuppressWarnings("deprecation")
	public WebDriver launchProgram(String programName, String Env) throws Exception {

		ProgramEnv = Env;
		programType = programName;
		ExcelUtils excelUtils = new ExcelUtils();

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

		cleanFolder(programName);
		String downloadFilepath = index.toString();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driverWOP = new ChromeDriver(cap);
		

		driverWOP.manage().window().maximize();
		driverWOP.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//logStep("Browser Launched Successfully..");

		System.out.println("Browser Launched Successfully..");

		excelUtils.readingexcelFiles("Urls");
		for (int i = 1; i <= excelUtils.lastRow; i++) {
			if (excelUtils.excelData[i][1].toString().equalsIgnoreCase(programName)
					&& excelUtils.excelData[i][2].toString().equalsIgnoreCase(Env)) {
				driverWOP.get(excelUtils.excelData[i][0]);
			} else {
				if (i == excelUtils.lastRow) {
					System.out.println("Program URL is not avilable to test");
				}
			}
		}

		

		return driverWOP;

	}

	
	
	// Remote File Open
	
	public void openRemoteDesktopFile() throws IOException {
		
		
		

		File file = new File( System.getProperty("user.dir") + "\\RemoteFiles\\cpub-WOProgram_DEVUAT-UATDev-CmsRdsh.rdp");

		// first check if Desktop is supported by Platform or not

		if (!Desktop.isDesktopSupported()) {
			
			System.out.println("Desktop is not supported");
			
			return;
		}

		Desktop desktop = Desktop.getDesktop();
		if (file.exists())
			desktop.open(file);

	}

	// Closes the Driver

	public void driverClose() {

		driver.quit();
	}

}
