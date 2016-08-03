package com.salesforce.dev.framework.soap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.salesforce.dev.framework.utils.DataDrivenManager;
import com.salesforce.dev.framework.dto.Campaign;
import com.salesforce.dev.framework.dto.ViewSalesForce;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import org.apache.log4j.Logger;

/**
 * Class to get data related to Campaign
 *
 * @author Veronica Prado
 */
public class CampaignGenie {

    private static final Logger LOGGER = Logger.getLogger(CampaignGenie.class.getName());

    public static ViewSalesForce getCampaignView(String jsonFile) {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        Iterator<ViewSalesForce[]> iteratorViewData = dataDrivenManager.getDataView(jsonFile);
        List<ViewSalesForce[]> listData = new ArrayList<>();
        while (iteratorViewData.hasNext()) {
            listData.add(iteratorViewData.next());
        }
        ViewSalesForce viewSalesForce = listData.get(0)[0];
        return viewSalesForce;
    }

    public static Campaign getCampaign() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        Iterator<Campaign[]> iteratorCampaignData = dataDrivenManager.getCampaign("CreateCampaign.json");
        List<Campaign[]> listData = new ArrayList<>();
        while (iteratorCampaignData.hasNext()) {
            listData.add(iteratorCampaignData.next());
        }
        Campaign campaign = listData.get(0)[0];
        return campaign;
    }

    public static void createParentCampaign(String nameCampaign) {
        PartnerConnection connection = APIConnector.getInstance().getConnection();
        SObject objectSales = new SObject();
        objectSales.setType("Campaign");
        objectSales.setField("Name", nameCampaign);
        objectSales.setField("IsActive", true);
        try {
            connection.create(new SObject[]{objectSales});
        } catch (ConnectionException e) {
            LOGGER.error("Error on Create parent campaign by Api :", e);
        }
    }
}
