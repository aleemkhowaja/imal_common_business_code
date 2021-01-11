package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.tfsdoctype.TFSDocTypeBO;
import com.path.dbmaps.vo.TFSDOCTYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.tfsdoctype.TFSDocTypeSC;

public class TfsDocTypeLookupAction extends LookupBaseAction {
	
    private List<TFSDOCTYPEVO> tfsDocTypeVOList;
    private TFSDocTypeSC criteria = new TFSDocTypeSC();
    private String tfsDocTypeGridUrl;
    private String fromWhere;
    private TFSDocTypeBO tfsDocTypeBO;

    @Override
    public Object getModel()
    {
	return criteria;
    }
	 
    public String constructLookup()
    {
	try
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
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of TfsDocTypeLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    
    /**
     * Fill the lookup TFS Doc Type data filtered by the defined criteria
     * 
     * @return
     */
    public String fillTFSTypeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    //added by rany for tpid:715911 called from link schema screen
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setUserId(sessionCO.getUserName());
	    //end rany
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(tfsDocTypeBO.tfsDocTypeListCount(criteria));
	    }
	    tfsDocTypeVOList = tfsDocTypeBO.tfsDocTypeList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(tfsDocTypeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillTFSTypeLookup of TfsDocTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String getFromWhere()
    {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }

    public void setTfsDocTypeBO(TFSDocTypeBO tfsDocTypeBO)
    {
        this.tfsDocTypeBO = tfsDocTypeBO;
    }

    public TFSDocTypeSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(TFSDocTypeSC criteria)
    {
        this.criteria = criteria;
    }

    public String getTfsDocTypeGridUrl()
    {
        return tfsDocTypeGridUrl;
    }

    public void setTfsDocTypeGridUrl(String tfsDocTypeGridUrl)
    {
        this.tfsDocTypeGridUrl = tfsDocTypeGridUrl;
    }
   
}
