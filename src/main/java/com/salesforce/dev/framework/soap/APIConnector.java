package com.salesforce.dev.framework.soap;

import com.salesforce.dev.framework.utils.Environment;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.apache.log4j.Logger;

/**
 * Created by Veronica Prado on 8/25/2015.
 * class to connect by API to sales force
 */
public class APIConnector {

    private static APIConnector instance;
    private static final Logger LOGGER = Logger.getLogger (APIConnector.class.getName ());
    private ConnectorConfig config;
    private PartnerConnection connection;
    private String primaryUserName = Environment.getInstance ().getPrimaryUser ();
    private String primaryUserPasswordToken = Environment.getInstance ().getPrimaryUserPasswordToken ();
    private String urlApi = Environment.getInstance ().getUrlApi ();
    private String proxyHost = Environment.getInstance ().getProxyHost ();
    private int proxyPort = Environment.getInstance ().getProxyPort ();

    private APIConnector () {
        this.initializer ();
    }

    private void initializer () {
        config = new ConnectorConfig ();
        if (proxyHost != null && proxyPort != 0) {
            config.setUsername (primaryUserName);
            config.setPassword (primaryUserPasswordToken);
            config.setAuthEndpoint (urlApi);
            config.setServiceEndpoint (urlApi);
            config.setProxy (proxyHost, proxyPort);
        } else {
            config.setUsername (primaryUserName);
            config.setPassword (primaryUserPasswordToken);
            config.setAuthEndpoint (urlApi);
            config.setServiceEndpoint (urlApi);
        }
        try {
            connection = com.sforce.soap.partner.Connector.newConnection (config);
        } catch (ConnectionException e) {

            LOGGER.error ("Error on Connect to Api :", e);

        }
    }

    public static APIConnector getInstance () {
        if (instance == null) {
            instance = new APIConnector ();
        }
        return instance;
    }

    public PartnerConnection getConnection () {
        return this.connection;
    }
}
