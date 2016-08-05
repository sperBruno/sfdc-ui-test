package com.salesforce.dev.framework.soap;

import com.salesforce.dev.framework.utils.Environment;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.apache.log4j.Logger;

/**
 * class to connect by API to sales force.
 *
 * @author Veronica Prado
 * @author DanielGonzales
 */
public class APIConnector {

    private static final Logger LOGGER = Logger.getLogger(APIConnector.class.getName());

    private static APIConnector instance;

    private PartnerConnection connection;

    private final Environment environmentInstance = Environment.getInstance();

    private APIConnector() {
        this.initializer();
    }

    public static APIConnector getInstance() {
        if (instance == null) {
            instance = new APIConnector();
        }
        return instance;
    }

    private void initializer() {
        ConnectorConfig config = new ConnectorConfig();
        config.setUsername(environmentInstance.getPrimaryUser());
        config.setPassword(environmentInstance.getPrimaryUserPasswordToken());
        config.setAuthEndpoint(environmentInstance.getUrlApi());
        config.setServiceEndpoint(environmentInstance.getUrlApi());
        if (environmentInstance.getProxyHost() != null && environmentInstance.getProxyPort() != null) {
            config.setProxy(environmentInstance.getProxyHost(), Integer.valueOf(environmentInstance.getProxyPort()));
        }
        try {
            connection = com.sforce.soap.partner.Connector.newConnection(config);
        } catch (ConnectionException e) {
            LOGGER.error("Error on Connect to Api :", e);
        }
    }

    public PartnerConnection getConnection() {
        return this.connection;
    }
}
