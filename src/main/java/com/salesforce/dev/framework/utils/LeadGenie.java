package com.salesforce.dev.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.salesforce.dev.framework.dto.ViewSalesForce;

/**
 * @author Ariel Mattos
 * @since 07/09/2015.
 */
public class LeadGenie {
    public static ViewSalesForce getLeadsView(String jsonFile) {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        Iterator<ViewSalesForce[]> iteratorViewData = dataDrivenManager.getDataView(jsonFile);
        List<ViewSalesForce[]> listData = new ArrayList<ViewSalesForce[]>();
        while (iteratorViewData.hasNext()) {
            listData.add(iteratorViewData.next());
        }
        ViewSalesForce viewSalesForce = listData.get(0)[0];
        return viewSalesForce;
    }

}
