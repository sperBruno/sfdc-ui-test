package com.salesforce.dev.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.salesforce.dev.framework.dto.ViewSalesForce;

/**
 * @author Ariel Mattos
 * @author DanielGonzales
 * @since 07/09/2015.
 */
public class LeadGenie {

    private LeadGenie() {
    }

    public static ViewSalesForce getLeadsView(String jsonFile) {
        Iterator<Object[]> iteratorViewData = DataDrivenManager.getObjects(jsonFile, ViewSalesForce.class);
        List<ViewSalesForce[]> listData = new ArrayList<>();
        while (iteratorViewData.hasNext()) {
            listData.add((ViewSalesForce[]) iteratorViewData.next());
        }
        return listData.get(0)[0];
    }

}
