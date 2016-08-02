package com.salesforce.dev.pages.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.salesforce.dev.framework.soap.APIConnector;
import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.sobject.SObject;

/**
 * Created by Ariel Mattos on 07/09/2015.
 */
public class LeadGenie {
    public static ViewSalesForce getLeadsView(String jsonFile) {
        PartnerConnection connection = APIConnector.getInstance().getConnection();
        Iterator<Object[]> iteratorViewData = DataDrivenManager.getObjects(jsonFile, ViewSalesForce.class);
        List<ViewSalesForce[]> listData = new ArrayList<ViewSalesForce[]>();
        while (iteratorViewData.hasNext()) {
            listData.add((ViewSalesForce[]) iteratorViewData.next());
        }
        return listData.get(0)[0];
    }

}
