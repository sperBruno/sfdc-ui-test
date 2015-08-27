package com.salesforce.dev.framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jimmy Vargas on 6/4/2015.
 */
public class DriverManager {
    private WebDriver driver;
    private WebDriverWait wait;

    private static DriverManager instance = null;
    private String browser = Environment.getInstance().getBrowser();
    private String mode = Environment.getInstance().getMode();
    private String username =Environment.getInstance().getUserName();
    private String key =Environment.getInstance().getKey();

    private DriverManager(){
        browser = Environment.getInstance().getBrowser();
        this.initializer();

    }

    private void initializer(){
        if (mode.equalsIgnoreCase("Local")) {
            if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("Safari")) {
                driver = new SafariDriver();
            }
        }else if (mode.equalsIgnoreCase("Remote")){
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows 8.1");
            caps.setCapability("version", "39.0");
            // Create the connection to Sauce Labs to run the tests
            try {
                this.driver = new RemoteWebDriver(
                        new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
                        caps);
            }catch(MalformedURLException e){}
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,30);

        driver.get("https://www.salesforce.com");

        driver.manage().window().maximize();

    }

    public static DriverManager getInstance(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriverWait getWait(){
        return this.wait;

    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void quit(){
        try{

            driver.quit();

        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
    }

    public void close(){
        try{

            driver.close();

        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
    }
}
