package com.salesforce.dev.pages.Objects;

import com.salesforce.dev.framework.APIConnector;
import com.salesforce.dev.framework.LoggerManager;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

/**
 * Created by Veronica Prado on 9/2/2015.
 * This class connect by APi to Sales force to exeecute queries
 */
public class ConnectorSalesForceDB {
    private PartnerConnection connection = APIConnector.getInstance().getConnection();
    /*execute a query on sales force
    * @param soqlQuery
    * @return SObject[]
    * */
    public SObject[] executeQuery(String soqlQuery)  {
        QueryResult qResult = null;
        SObject[] records = null;
        try {
            qResult = connection.query(soqlQuery);
            boolean done = false;
            if (qResult.getSize() > 0) {
                records = qResult.getRecords();
            }
            LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                    "Executing query on sales force");
            }catch(ConnectionException e){
            LoggerManager.getInstance().addErrorLog(this.getClass().getName(),"Error on Create campaign by Api :", e);
            }
        return records;
    }
}
