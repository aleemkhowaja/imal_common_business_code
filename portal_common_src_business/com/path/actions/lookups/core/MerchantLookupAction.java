package com.path.actions.lookups.core;

import com.path.bo.core.merchant.MerchantBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.merchant.MerchantSC;

public class MerchantLookupAction extends LookupBaseAction
{
    private MerchantBO merchantBO;
    private MerchantSC merchantSC = new MerchantSC();
    
    @Override
    public Object getModel()
    {
        return merchantSC;
    }

    public String constructMerchantCodeLookup()
    {
	try
	{
	    String[] name = { "CODE", "BRANCH_CODE", "CIF_NO", "CONTRACT_NUM" };
	    String[] colType = { "number", "number", "number", "text" };
	    String[] titles = { getText("Code"), getText("Branch_Code_key"), getText("CIF_No_key"), getText("Contract_No_key") };
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRANCH_CODE", "CIF_NO", "CONTRACT_NUM" };
		colType = new String[] { "number", "number", "number", "text" };
		titles = new String[] { getText("Code"), getText("Branch_Code_key"), getText("CIF_No_key"),
			getText("ContractNum") };
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("merchant_code_Key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/merchantLookup_fillMerchantCodeLookup");
	    lookup(grid, merchantSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in MerchantLookupAction of constructMerchantCodeLookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillMerchantCodeLookup()
    {
	try
	{
	    setSearchFilter(merchantSC);
	    copyproperties(merchantSC);
	    SessionCO sessionCO = returnSessionObject();
	    merchantSC.setCompCode(sessionCO.getCompanyCode());
	    merchantSC.setBranchCode(sessionCO.getBranchCode());
	    merchantSC.setCrudMode("K");

	    if(checkNbRec(merchantSC))
	    {
		setRecords(merchantBO.returnMerchantCodeListCount(merchantSC));
	    }
	    setGridModel(merchantBO.returnMerchantCodeList(merchantSC));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    public void setMerchantBO(MerchantBO merchantBO)
    {
	this.merchantBO = merchantBO;
    }

    public MerchantSC getMerchantSC()
    {
        return merchantSC;
    }

    public void setMerchantSC(MerchantSC merchantSC)
    {
        this.merchantSC = merchantSC;
    }

}
