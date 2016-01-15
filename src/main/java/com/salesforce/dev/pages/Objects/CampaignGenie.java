package com.salesforce.dev.pages.Objects;

import com.salesforce.dev.framework.APIConnector;
import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.Campaign;
import com.salesforce.dev.framework.Objects.FieldToDisplayView;
import com.salesforce.dev.framework.Objects.FilterView;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignView;
import com.salesforce.dev.pages.Campaigns.CampaignViewDetail;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.MainPage;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Veronica Prado on 8/25/2015.
 * Class to get data related to Campaign
 */
public class CampaignGenie {
    public static  ViewSalesForce getCampaignView(String jsonFile) {
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
    public static  Campaign getCampaign() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        Iterator<Campaign[]> iteratorCampaignData = dataDrivenManager.getCampaign("CreateCampaign.json");
        List<Campaign[]> listData = new ArrayList<Campaign[]>();
        while (iteratorCampaignData.hasNext()) {
            listData.add(iteratorCampaignData.next());
        }
        Campaign campaign = listData.get(0)[0];
        return campaign ;
    }
    public static void createCampaign(Campaign campaign){
        PartnerConnection connection = APIConnector.getInstance().getConnection();
        //get parentCampaignId
        ConnectorSalesForceDB query = new ConnectorSalesForceDB();
        String parentId = null;
        SObject[] records= query.executeQuery( "SELECT id from Campaign where name='" + campaign.getParentCampaign() + "'");
        if(records!= null){
            parentId = records[0].getField("Id").toString();
        }

        SObject objectSales = new SObject();
        objectSales.setType("Campaign");
        objectSales.setField("Name", campaign.getCampaignName());
        objectSales.setField("IsActive",true);
        objectSales.setField("Type", campaign.getCampaignType());
        objectSales.setField("Status", campaign.getCampaignStatus());
        objectSales.setField("StartDate",campaign.getStartDate());
        objectSales.setField("EndDate",campaign.getEndDate());
        objectSales.setField("ExpectedRevenue",campaign.getExpectedRevenue());
        objectSales.setField("BudgetedCost", campaign.getBudgetedCost());
        objectSales.setField("ActualCost", campaign.getActualCost());
        objectSales.setField("ExpectedResponse", campaign.getExpectedResponse());
        objectSales.setField("NumberSent",campaign.getNumSent());
        objectSales.setField("ParentId", parentId);
        try {
            connection.create(new SObject[]{objectSales});
        }catch(ConnectionException e){
            LoggerManager.getInstance().addErrorLog("CampaignGenie","Error on Create campaign by Api :", e);
        }
    }
    public static void createParentCampaign(String nameCampaign){
        PartnerConnection connection = APIConnector.getInstance().getConnection();
        SObject objectSales = new SObject();
        objectSales.setType("Campaign");
        objectSales.setField("Name", nameCampaign);
        objectSales.setField("IsActive",true);
        try {
            connection.create(new SObject[]{objectSales});
        }catch(ConnectionException e){
            LoggerManager.getInstance().addErrorLog("CampaignGenie","Error on Create parent campaign by Api :", e);
        }
    }

}
