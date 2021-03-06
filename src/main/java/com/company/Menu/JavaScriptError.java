package com.company.Menu;


import com.company.Base.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.logging.Level;

public class JavaScriptError {
	private WebDriver driver;
	@BeforeMethod
    public void setUp() {
		System.setProperty("webdriver.chrome.driver", "P:\\Software\\chromedriver_win32\\chromedriver.exe");
        
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        driver = new ChromeDriver(capabilities);
        driver.get(BaseUrl.javaScriptErrorPageUrl);
    }

   
    @Test
    public void ExtractJSErrorLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        
        driver.quit();
    }
    
	
}
