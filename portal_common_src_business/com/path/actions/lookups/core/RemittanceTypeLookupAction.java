package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.remittance.RemittanceBO;
import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.remittance.RemittanceSC;
import com.path.vo.core.trxmgnt.remittancedenom.TrxMgntRemtDenomCO;

@SuppressWarnings("serial")
public class RemittanceTypeLookupAction extends LookupBaseAction
{
  
    private RemittanceSC remittanceSC = new RemittanceSC();
    private RemittanceBO remittanceBO;

    @Override
    public Object getModel()
    {
	return remittanceSC;

    }

    /**
     * Construct vault Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB" };
	    String[] colType = { "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key") };
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG"};
		colType = new String[] { "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("remittances_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/RemittanceTypeLookup_populateRemittanceTypeLookup");
	  /*  int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, null);
	    */
	    lookup(grid,remittanceSC,name,colType,titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup vault data filtered by the defined criteria
     * 
     * @return
     */
    public String populateRemittanceTypeLookup()
    {
	try
	{
	    setSearchFilter(remittanceSC);
	    copyproperties(remittanceSC);
	    SessionCO sessionCO = returnSessionObject();
	    remittanceSC.setCompCode(sessionCO.getCompanyCode());
	    remittanceSC.setBranchCode(sessionCO.getBranchCode());
	    if(StringUtil.nullToEmpty(remittanceSC.getTraceProgRef()).startsWith("L000"))
	    {
		remittanceSC.setRemittanceType(null);
	    }
	    if(getRecords() == 0)
	    {
		setRecords(remittanceBO.returnRemittanceTypeLookupCount(remittanceSC));
	    }
	    List<REMITTANCEVO> remittancevos = remittanceBO.returnRemittanceTypeLookupData(remittanceSC);
	    setGridModel(remittancevos);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VaultLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct Remittance Type by values Lookup based on the
     * VO returned in the resultMap
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     * @PB: w_lookup_remittance_type(tfa01)/dw_lookup_remittance_type(tfa01)
     */
    public String constructRemitTypeLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB"};
            String[] colType = {"text", "text", "text"};
            String[] titles = {getText("Code_key"), getText("Brief_Desc_Eng_key"),
                getText("Brief_Desc_Arab_key")};

            /*
             * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
             * 1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English
             * Mandatory
             * , 3= Arabic Visible and Mandatory English Not Mandatory).
             */
            if(returnSessionObject().getHideArabicColumns())
            {
                name = new String[] {"CODE", "BRIEF_NAME_ENG"};
                colType = new String[] {"text", "text"};
                titles = new String[] {getText("Code_key"), getText("Brief_Desc_Eng_key")};
            }

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption(getText("remittances_key"));
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/RemittanceTypeLookup_fillRemitTypeLookup");
            List<LookupGridColumn> remGridColumn = returnStandarColSpecs(name, colType, titles);
            for(int i = 0; i < name.length; i++)
            {
                if("CODE".equals(remGridColumn.get(i).getName()))
                {
                    remGridColumn.get(i).setLeadZeros("4");
                }
            }
            lookup(grid, remGridColumn, null, remittanceSC);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructRemitTypeLookup of RemittanceTypeLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }

    /**
     * Fill the remittance type by values lookup data filtered
     * by the defined criteria
     * 
     * @author: BoushraFahs
     * @date: 22 Jan 2014
     * @PB: w_lookup_remittance_type(tfa01)/dw_lookup_remittance_type(tfa01)
     */
    public String fillRemitTypeLookup()
    {
        try
        {
            setSearchFilter(remittanceSC);
            copyproperties(remittanceSC);
            SessionCO sessionCO = returnSessionObject();
            remittanceSC.setCompCode(sessionCO.getCompanyCode());
            remittanceSC.setBranchCode(sessionCO.getBranchCode());
            remittanceSC.setRemittanceStr("('" + ConstantsCommon.REMITTANCE_TYPE_DD + "', '"
                + ConstantsCommon.REMITTANCE_TYPE_TC + "')");
            if(checkNbRec(remittanceSC))
            {
                setRecords(remittanceBO.returnRemitTypeLookupCount(remittanceSC));
            }
            setGridModel(remittanceBO.returnRemitTypeLookupData(remittanceSC));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillRemitTypeLookup of RemittanceTypeLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }
    
    /**
     * @author raniaalbitar
     * @return
     * 504699 - SBI170064 - Prize Bond Management
     */
    
    public String constructTrxRemitTypeCodeLookup()
    {

	try
	{
	    String[] name = { "trxRemittCode", "remittanceVO.BRIEF_NAME_ENG", "remittanceVO.BRIEF_NAME_ARAB" };
	    String[] colType = { "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key") };
	    
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "trxRemittCode", "remittanceVO.BRIEF_NAME_ENG"};
		colType = new String[] { "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key")};
	    }

	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("trx_remittances_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/RemittanceTypeLookup_fillTrxRemitTypeCodeLookup");

	    lookup(grid,remittanceSC,name,colType,titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    /**
     * @author raniaalbitar
     * @return
     * 504699 - SBI170064 - Prize Bond Management
     */
    public String fillTrxRemitTypeCodeLookup()
    {
	try
	{
	    setSearchFilter(remittanceSC);
	    copyproperties(remittanceSC);
	    SessionCO sessionCO = returnSessionObject();
	    remittanceSC.setCompCode(sessionCO.getCompanyCode());
	    remittanceSC.setBranchCode(sessionCO.getBranchCode());
	    
	    if(StringUtil.nullToEmpty(remittanceSC.getTraceProgRef()).startsWith("L000"))
	    {
		remittanceSC.setRemittanceType(null);
	    }
	    
	    if(get_pageRef() != null && get_pageRef().contains("L0CV"))
	    {
		remittanceSC.setRemittanceType(ConstantsCommon.REMITT_TYPE_PRIZE_BOND);
	    }
	    
	    if(getRecords() == 0)
	    {
		setRecords(remittanceBO.returnTrxRemitTypeCodeCount(remittanceSC));
	    }
	    List<TrxMgntRemtDenomCO> trxMgntRemtDenomCOs = remittanceBO.returnTrxRemitTypeCodeData(remittanceSC);
	    setGridModel(trxMgntRemtDenomCOs);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VaultLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public RemittanceSC getRemittanceSC()
    {
        return remittanceSC;
    }

    public void setRemittanceSC(RemittanceSC remittanceSC)
    {
        this.remittanceSC = remittanceSC;
    }

    public void setRemittanceBO(RemittanceBO remittanceBO)
    {
        this.remittanceBO = remittanceBO;
    }


}
