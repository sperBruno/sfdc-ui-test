package com.salesforce.dev.pages.Objects;

import com.salesforce.dev.framework.APIConnector;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;

/**
 * Created by mijhailvillarroel on 7/28/2016.
 */
public class UserInformation {

    public static String getFullName() {
        String result = "";
        try {
            PartnerConnection connection = APIConnector.getInstance().getConnection();
            GetUserInfoResult userInfo = connection.getUserInfo();
            result = userInfo.getUserFullName();
        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }
        return result;
    }
}
