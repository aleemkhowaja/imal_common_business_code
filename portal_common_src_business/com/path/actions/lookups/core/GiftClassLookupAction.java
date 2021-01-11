package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.giftclass.GiftClassLookupBO;
import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.giftclass.GiftClassLookupSC;

public class GiftClassLookupAction extends LookupBaseAction
{
    private GiftClassLookupBO giftClassLookupBO;
    private GiftClassLookupSC giftClassLookupSC = new GiftClassLookupSC();

    @Override
    public Object getModel()
    {
	return giftClassLookupSC;
    }

    public String constructGiftClassLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB" };
	    String[] colType = { "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Name_Eng_key"), getText("Long_Name_Eng_key"),
		    getText("Brief_Name_Arab_key"), getText("Long_Name_Arab_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Gift Glass"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/GiftClass_fillGiftClassLookup");
	    lookup(grid, giftClassLookupSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillGiftClassLookup()
    {
	try
	{
	    List<CRM_PARAMVO> crmParamVOList;
	    setSearchFilter(giftClassLookupSC);
	    copyproperties(giftClassLookupSC);
	    SessionCO sessionCO = returnSessionObject();
	    giftClassLookupSC.setCompCode(sessionCO.getCompanyCode());
	    giftClassLookupSC.setBranchCode(sessionCO.getBranchCode());
	    giftClassLookupSC.setCode(sessionCO.getCtsTellerVO().getCODE());
	    giftClassLookupSC.setUserId(sessionCO.getUserName());
	    giftClassLookupSC.setTellerCode(sessionCO.getCtsTellerVO().getCODE());

	    if(checkNbRec(giftClassLookupSC))
	    {
		setRecords(giftClassLookupBO.returnGiftClassLookupCount(giftClassLookupSC));
	    }
	    crmParamVOList = giftClassLookupBO.returnGiftClassLookup(giftClassLookupSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(crmParamVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillGiftClassLookup of GiftClassLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public GiftClassLookupSC getGiftClassLookupSC()
    {
	return giftClassLookupSC;
    }

    public void setGiftClassLookupSC(GiftClassLookupSC giftClassLookupSC)
    {
	this.giftClassLookupSC = giftClassLookupSC;
    }

    public void setGiftClassLookupBO(GiftClassLookupBO giftClassLookupBO)
    {
	this.giftClassLookupBO = giftClassLookupBO;
    }
}
