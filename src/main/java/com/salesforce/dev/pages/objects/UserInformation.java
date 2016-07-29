package com.salesforce.dev.pages.objects;

import com.salesforce.dev.framework.soap.APIConnector;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import org.apache.log4j.Logger;

/**
 * This class wil be used to get User information through the api.
 *
 * @author Bruno Barrios on 7/28/2016.
 */
public class UserInformation {
    public static final String TOKEN_NOT_FOUND = "Token not found";
    private static final Logger LOGGER = Logger.getLogger(UserInformation.class.getName());
    private static final String CONNECTION_TO_API_FAILED = "Connection to api failed";

    /**
     * This method gets the user full name
     *
     * @return the user full name
     */
    public static String getUserFullName() {
        String result = "";
        try {
            PartnerConnection connection = APIConnector.getInstance().getConnection();
            GetUserInfoResult userInfo = connection.getUserInfo();
            result = userInfo.getUserFullName();
        } catch (ConnectionException ce) {
            LOGGER.error(CONNECTION_TO_API_FAILED, ce);
        } catch (NullPointerException e) {
            LOGGER.error(TOKEN_NOT_FOUND, e);
        }
        return result;
    }
}
