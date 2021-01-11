package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.core.trxtype.TrxTypeSC;

public class EntityCodeLookupAction extends LookupBaseAction
{
    private TrxTypeSC criteria = new TrxTypeSC();
    private List<CTSTRXTYPEVO> trxVOList;
    private String entityType;
    private String docType;
    
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    public String constructLookup()
    {
	try
	{
	    if(entityType != null && "CSM".equals(entityType))
	    {

		// Design the Grid by defining the column model and column names
		String[] name = { "CODE", "SHORT_DESC_ENG", "LONG_DESC_ENG", "SHORT_DESC_ARAB", "LONG_DESC_ARAB",
			"REFERENCE" };
		String[] colType = { "text", "text", "text", "text", "text", "text" };
		String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
			getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("_Reference_key") };

		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "CODE", "SHORT_DESC_ENG", "LONG_DESC_ENG", "REFERENCE" };
		    colType = new String[] { "text", "text", "text", "text" };
		    titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			    getText("Long_Desc_Eng_key"), getText("_Reference_key") };
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Trx_Type_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/CtsTrxTypeLookup_fillTrxTypeLookup");
		lookup(grid, criteria, name, colType, titles);
	    }
	    else if(entityType != null && ConstantsCommon.IIS_APP_NAME.equals(entityType))
	    {
		// Design the Grid by defining the column model and column names
		String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "DESC_ENG" };
		String[] colType = { "number", "text", "text", "text" };
		String[] titles = { getText("code_key"), getText("Short_name_eng_key"), getText("Short_Name_Arab_key"),
			getText("Category_key") };

		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] { "CODE", "BRIEF_NAME_ENG", "DESC_ENG" };
		    colType = new String[] { "number", "text", "text" };
		    titles = new String[] { getText("code_key"), getText("Short_name_eng_key"), getText("Category_key") };
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("cifList_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/productClassLookup_fillProductClassLookupWithoutApp");
		lookup(grid, criteria, name, colType, titles);
		
	    }
	    else if(entityType != null && ConstantsCommon.TFA_APP_NAME.equals(entityType))
	    {
		
		// Design the Grid by defining the column model and column names
		String[] name = {"CODE","BRIEF_NAME_ENG","LONG_NAME_ENG","BRIEF_NAME_ARAB","LONG_NAME_ARAB"};
		String[] colType = {"number","text","text","text","text"};
		String[] titles = {getText("code_key"),getText("Short_name_eng_key"),getText("Long_Name_eng_key"),
				   getText("Short_Name_Arab_key"),getText("Long_Name_Arab_key")};

		
		/* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
			, 3= Arabic Visible and Mandatory English Not Mandatory). */
		if(returnSessionObject().getHideArabicColumns())
		{
		    name = new String[] {"CODE","BRIEF_NAME_ENG","LONG_NAME_ENG"};
		    colType = new String[] {"number","text","text"};
		    titles = new String[] {getText("code_key"), getText("Short_name_eng_key"),getText("Long_Name_eng_key")};
		}

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Doc_Type_key"));
		grid.setRowNum("5");
		grid.setUrl("/pathdesktop/tfsDocTypeLookup_fillTFSTypeLookup");
		lookup(grid, criteria, name, colType, titles);
	    }
	    
	}
	catch(Exception e)
	{
	    log.error(e, "Error in construct Lookup of Entity Lookup Action");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public TrxTypeSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(TrxTypeSC criteria)
    {
        this.criteria = criteria;
    }

    public List<CTSTRXTYPEVO> getTrxVOList()
    {
        return trxVOList;
    }

    public void setTrxVOList(List<CTSTRXTYPEVO> trxVOList)
    {
        this.trxVOList = trxVOList;
    }

    public String getEntityType()
    {
        return entityType;
    }

    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    public String getDocType()
    {
        return docType;
    }

    public void setDocType(String docType)
    {
        this.docType = docType;
    }
}
