package com.path.actions.common.reservedcif;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.reservedcif.ReservedCifBO;
import com.path.dbmaps.vo.CIF_RESERVEDVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.reservedcif.ReservedCifSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * ReservedCifListAction.java used to
 */
public class ReservedCifListAction extends GridBaseAction
{
    private ReservedCifBO reservedCifBO;
    private ReservedCifSC criteria = new ReservedCifSC();
    private BigDecimal cifTypeCode;

    public String loadReservedCifGrid()
    {
	String[] searchCol = { "CIF_NO" };
	try
	{
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    	  
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);

	    copyproperties(criteria);

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    // criteria.setCifType(cifTypeCode);
			
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(criteria))
	    {
		setRecords(reservedCifBO.getReservedCifListCount(criteria));
	    }

	    /**
	     * return the collection of records
	     */
	    List<CIF_RESERVEDVO> reservedCifList = reservedCifBO.getReservedCifList(criteria);
			
	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
//	    for(int i = 0; i < 10; i++)
//	    {
//		CIF_RESERVEDVO revVO = new CIF_RESERVEDVO();
//		revVO.setCIF_NO(new BigDecimal(i));
//		reservedCifList.add(i, revVO);
//	    }
	    setGridModel(reservedCifList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in Reserved Cif List Grid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // Action called when More Address button in FOM Screen is clicked
    public String populateReservedCifPopup()
    {
	return "populateReservedCifPopup";
    }

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public void setReservedCifBO(ReservedCifBO reservedCifBO)
    {
	this.reservedCifBO = reservedCifBO;
    }

    public ReservedCifSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ReservedCifSC criteria)
    {
	this.criteria = criteria;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

}
