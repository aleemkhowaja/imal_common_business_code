package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.vault.VaultBO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.vault.VaultSC;

public class VaultLookupAction extends LookupBaseAction
{

    private final VaultSC vaultSC = new VaultSC();
    private VaultBO vaultBO;

    @Override
    public Object getModel()
    {
	return vaultSC;

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
	    String[] name = { "CODE", "USER_ID", "TELLER_TYPE", "PRIVILEGE_LEVEL", "DIVISION_CODE", "DEPT_CODE",
		    "ROLE_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "STATUS", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text", "text", "text", "text","text",
		    "text" };
	    String[] titles = { getText("vaultLookup.vaultCode"), getText("vaultLookup.userId"),
		    getText("vaultLookup.userType"), getText("vaultLookup.privilegeId"),
		    getText("vaultLookup.divisionCode"), getText("vaultLookup.deptCode"),
		    getText("vaultLookup.roleCode"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("vaultLookup.status"), getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "USER_ID", "TELLER_TYPE", "PRIVILEGE_LEVEL", "DIVISION_CODE", "DEPT_CODE",
			"ROLE_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "STATUS" };
		colType = new String[] { "text", "text", "text", "text", "text", "text", "text", "text", "text",
			"text" };
		titles = new String[] { getText("vaultLookup.vaultCode"), getText("vaultLookup.userId"),
			getText("vaultLookup.userType"), getText("vaultLookup.privilegeId"),
			getText("vaultLookup.divisionCode"), getText("vaultLookup.deptCode"),
			getText("vaultLookup.roleCode"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			getText("vaultLookup.status") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("vaultLookup.vault"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/VaultLookup_populateVaultLookup");
	    /*
	     * int cols = name.length;
	     * 
	     * for(int i = 0; i < cols; i++) { // Defining each column
	     * LookupGridColumn gridColumn = new LookupGridColumn();
	     * gridColumn.setName(name[i]); gridColumn.setIndex(name[i]);
	     * gridColumn.setColType(colType[i]);
	     * gridColumn.setTitle(titles[i]); gridColumn.setSearch(true); //
	     * adding column to the list lsGridColumn.add(gridColumn); }
	     * lookup(grid, lsGridColumn, null, null);
	     */
	    lookup(grid, vaultSC, name, colType, titles);
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
    public String populateVaultLookup()
    {
	try
	{
	    setSearchFilter(vaultSC);
	    copyproperties(vaultSC);
	    SessionCO sessionCO = returnSessionObject();
	    vaultSC.setCompCode(sessionCO.getCompanyCode());
	    // added by nancy -505143-SBI170030 - Restriction required to access
	    // other branch cash vaults
	    vaultSC.setAlBranchCode(sessionCO.getBranchCode());
	    String originalProgRef = StringUtil.nullEmptyToValue(
		    returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()),
		    get_pageRef());
	    vaultSC.setReference(originalProgRef.substring(0, 4));
	    // end nancy
	    if(vaultSC.getFromTransferCashVaultToVault() != null
		    && vaultSC.getFromTransferCashVaultToVault().equals("true"))
	    {
		vaultSC.setBranchCode(sessionCO.getBranchCode());
		
		/*
		 * Changed conditions and added one for vaultSC.getVaultBranch() - Reda 17/10/2017
		 */
		if(ConstantsCommon.TRUE.equals(vaultSC.getDependencyOfFromVaultBranch()) && !NumberUtil.isEmptyDecimal(vaultSC.getFromVaultBranch()))
		{
		    vaultSC.setBranchCode(vaultSC.getFromVaultBranch());
		}
		else if(!NumberUtil.isEmptyDecimal(vaultSC.getVaultBranch()) 
			&& (vaultSC.getOperationNature() == null && !"false".equals(vaultSC.getDependencyOfFromVaultBranch())))
		{
		    vaultSC.setBranchCode(vaultSC.getVaultBranch());
		}
	    }
	    else
	    {
		vaultSC.setBranchCode(sessionCO.getBranchCode());
	    }
	    vaultSC.setStatus("T");
	    vaultSC.setPrivilege(BigDecimal.ZERO);
	    vaultSC.setVaultType("V");
	    if(vaultSC.getFromTransferCashVaultToVault() != null
		    && vaultSC.getFromTransferCashVaultToVault().equals("true"))
	    {
		vaultSC.setFromTransferCashVaultToVault("true");
	    }
	    else
	    {
		vaultSC.setFromTransferCashVaultToVault("false");
	    }

	    if(getRecords() == 0)
	    {
		setRecords(vaultBO.returnVaultLookupCount(vaultSC));
	    }
	    List<CTSTELLERVO> ctstellervos = vaultBO.returnVaultLookupData(vaultSC);
	    setGridModel(ctstellervos);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VaultLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setVaultBO(VaultBO vaultBO)
    {
	this.vaultBO = vaultBO;
    }

}
