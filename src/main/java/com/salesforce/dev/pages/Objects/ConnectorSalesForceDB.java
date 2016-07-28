package com.salesforce.dev.pages.Objects;

import com.salesforce.dev.framework.soap.APIConnector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import org.apache.log4j.Logger;

/**
 * Created by Veronica Prado on 9/2/2015.
 * This class connect by APi to Sales force to exeecute queries
 */
public class ConnectorSalesForceDB {
    private static final Logger LOGGER = Logger.getLogger(ConnectorSalesForceDB.class.getName());
    private PartnerConnection connection = APIConnector.getInstance().getConnection();

    /*execute a query on sales force
    * @param soqlQuery
    * @return SObject[]
    * */
    public SObject[] executeQuery(String soqlQuery) {
        QueryResult qResult = null;
        SObject[] records = null;
        try {
            qResult = connection.query(soqlQuery);
            boolean done = false;
            if (qResult.getSize() > 0) {
                records = qResult.getRecords();
            }
            LOGGER.info("Executing query on sales force");
        } catch (ConnectionException e) {
            LOGGER.error("Error on Create campaign by Api :", e);
        }
        return records;
    }
}
