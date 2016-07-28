package com.salesforce.dev.pages.Objects;

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
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        Iterator<ViewSalesForce[]> iteratorViewData = dataDrivenManager.getDataView(jsonFile);
        List<ViewSalesForce[]> listData = new ArrayList<ViewSalesForce[]>();
        while (iteratorViewData.hasNext()) {
            listData.add(iteratorViewData.next());
        }
        ViewSalesForce viewSalesForce = listData.get(0)[0];
        SObject account = new SObject();
        return viewSalesForce;
    }

}
