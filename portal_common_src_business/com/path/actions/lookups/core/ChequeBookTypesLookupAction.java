package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.chequebooktypes.ChequeBookTypesBO;
import com.path.dbmaps.vo.CTSCHEQUEBOOK_TYPESVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.chequebooktypes.ChequeBookTypesSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author CHADY ASSAF
 *
 *  ChequeBookTypesLookupAction.java used to load Types Lookup
 */
public class ChequeBookTypesLookupAction extends LookupBaseAction 
{
    private final ChequeBookTypesSC chequeBookTypesSC = new ChequeBookTypesSC();
    private List<CTSCHEQUEBOOK_TYPESVO> typesVOList;
    CTSCHEQUEBOOK_TYPESVO temp;
    private ChequeBookTypesBO chequeBookTypesBO;

    @Override
    public Object getModel()
    {
	return chequeBookTypesSC;
    }


    /**
     * Construct Types Lookup
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "CODE", "DESC_ENG", "DESC_ARAB" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code__key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key") };

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "DESC_ENG" };
		colType = new String[] { "number", "text"};
		titles = new String[] { getText("Code__key"), getText("Brief_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("TypesList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ChequeBookTypesLookup_fillLookupTypesByCompany");
	    lookup(grid, chequeBookTypesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup Types data filtered by user.
     * 
     * @return
     * @throws BaseException
     */
    public String fillLookupTypesByCompany()
    {
	try
	{
	    setSearchFilter(chequeBookTypesSC);
	    copyproperties(chequeBookTypesSC);

	    SessionCO sessionCO = returnSessionObject();
	    chequeBookTypesSC.setUserId(sessionCO.getUserName());
	    chequeBookTypesSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(chequeBookTypesBO.getTypesByCompanyCount(chequeBookTypesSC));
	    }
	    typesVOList = chequeBookTypesBO.getTypesByCompanyList(chequeBookTypesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(typesVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    public List<CTSCHEQUEBOOK_TYPESVO> getTypesVOList()
    {
	return typesVOList;
    }

    public void setTypesVOList(List<CTSCHEQUEBOOK_TYPESVO> typesVOList)
    {
	this.typesVOList = typesVOList;
    }

    public void setChequeBookTypesBO(ChequeBookTypesBO chequeBookTypesBO)
    {
	this.chequeBookTypesBO = chequeBookTypesBO;
    }


}
