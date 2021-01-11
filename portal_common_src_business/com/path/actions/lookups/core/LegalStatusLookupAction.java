package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.legalstatus.LegalStatusBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.legalstatus.LegalStatusSC;

public class LegalStatusLookupAction extends LookupBaseAction
{
    private List<LEGAL_STATUSVO> legalStatusVOList;
    private BigDecimal CIF_TYPE_CODE; 
    private BigDecimal ECONOMIC_AGENT;
    private LegalStatusBO legalStatusBO;
    private LegalStatusSC legalStatusSC = new LegalStatusSC();

    @Override
    public Object getModel()
    {
	return legalStatusSC;
    }

    /**
     * Construct Legal status Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "STATUS_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };


	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "STATUS_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),  getText("Long_Desc_Eng_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("legal_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/LegalStatus_fillLegalStatusLookup");
	    lookup(grid, legalStatusSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for LegalStatus data filtered by the defined criteria
     * 
     * @return
     */
    public String fillLegalStatusLookup()
    {
	try
	{
	    setSearchFilter(legalStatusSC);
	    copyproperties(legalStatusSC);
	    SessionCO sessionCO = returnSessionObject();
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    if (null != cifControlVO)
	    {
		legalStatusSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
	    }
	    legalStatusSC.setCifType(NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE));
	    legalStatusSC.setEcoAgentCode(NumberUtil.emptyDecimalToNull(ECONOMIC_AGENT));
	    legalStatusSC.setCompCode(sessionCO.getCompanyCode());
	    
	    //DASI170068 
	    if(("1".equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()))
		    && !NumberUtil.isEmptyDecimal(CIF_TYPE_CODE) && !NumberUtil.isEmptyDecimal(ECONOMIC_AGENT))
		    || ("0".equals(StringUtil.nullEmptyToValue(cifControlVO.getUSE_CIF_MATRIX_YN(), "0"))))
	    {
		if(checkNbRec(legalStatusSC))
		{
		    setRecords(legalStatusBO.legalStatusListCount(legalStatusSC));
		}
		legalStatusVOList = legalStatusBO.legalStatusList(legalStatusSC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(legalStatusVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of LegalStatusLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public LegalStatusSC getLegalStatusSC()
    {
	return legalStatusSC;
    }

    public void setLegalStatusSC(LegalStatusSC legalStatusSC)
    {
	this.legalStatusSC = legalStatusSC;
    }

    public void setLegalStatusBO(LegalStatusBO legalStatusBO)
    {
	this.legalStatusBO = legalStatusBO;
    }

    public BigDecimal getCIF_TYPE_CODE()
    {
        return CIF_TYPE_CODE;
    }

    public void setCIF_TYPE_CODE(BigDecimal cIF_TYPE_CODE)
    {
        CIF_TYPE_CODE = cIF_TYPE_CODE;
    }

    public BigDecimal getECONOMIC_AGENT()
    {
        return ECONOMIC_AGENT;
    }

    public void setECONOMIC_AGENT(BigDecimal eCONOMIC_AGENT)
    {
        ECONOMIC_AGENT = eCONOMIC_AGENT;
    }
}
