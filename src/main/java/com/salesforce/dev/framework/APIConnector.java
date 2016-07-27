package com.salesforce.dev.framework;
import com.sforce.soap.partner.*;
import com.sforce.soap.partner.sobject.*;
import com.sforce.ws.*;
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
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Veronica Prado on 8/25/2015.
 * class to connect by API to sales force
 */
public class APIConnector {
    private static APIConnector instance;
    private ConnectorConfig config;
    private PartnerConnection connection;
    private String primaryUserName = Environment.getInstance().getPrimaryUser();
    private String primaryUserPasswordToken = Environment.getInstance().getPrimaryUserPasswordToken();
    private String urlApi = Environment.getInstance().getUrlApi();
    private APIConnector(){
        this.initializer();
    }

    private void initializer(){
        config  = new ConnectorConfig();
        config.setUsername(primaryUserName);
        config.setPassword(primaryUserPasswordToken);
        config.setAuthEndpoint(urlApi);
        config.setServiceEndpoint(urlApi);
        config.setProxy("172.20.240.5",8080);
        try {
            connection = com.sforce.soap.partner.Connector.newConnection(config);
        }catch (ConnectionException e){
            LoggerManager.getInstance().addErrorLog(this.getClass().getName(),"Error on Connect to Api :", e);
    }

    }

    public static APIConnector getInstance(){
        if(instance == null){
            instance = new APIConnector();
        }
        return instance;
    }

    public PartnerConnection getConnection(){
        return this.connection;

    }

}
