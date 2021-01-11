package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.economicsector.EconomicSectorBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.economicsector.EconomicSectorSC;

public class EconomicSectorLookupAction extends LookupBaseAction
{
   
    private EconomicSectorBO economicSectorBO;
    private EconomicSectorSC economicSectorSC = new EconomicSectorSC();
    private List<ECO_SECTORSVO> ecoSectorVOList;
    private BigDecimal CIF_TYPE_CODE;
    private BigDecimal LEGAL_STATUS;
    private String showInPos;
    

    @Override
    public Object getModel()
    {
	return economicSectorSC;
    }

    /**
     * Construct EconomicSector Lookup based on the VO returned in the
     * resultMap.
     * Data window : dddw_cif_eco_sector
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "SECTOR_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Sector_Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "SECTOR_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("Sector_Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("economic_sector_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/EconomicSector_fillEconomicSectorLookup");
	    
	    lookup(grid, economicSectorSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    /***
     * data window : w_lookup_sector_parent
     * @return
     */
    public String constructEconomicSectorLookupAddRef() {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "SECTOR_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB","ADDITIONAL_REFERENCE" };
	    String[] colType = { "number", "text", "text", "text", "text","text" };
	    String[] titles = { getText("Sector_Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key"), getText("Additional_Ref_key")};
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "SECTOR_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" ,"ADDITIONAL_REFERENCE" };
		colType = new String[] { "number", "text", "text", "text"};
		titles = new String[] { getText("Sector_Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") 
					, getText("Additional_Ref_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("economic_sector_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/EconomicSector_fillEconomicSectorLookupAddRef");
	    
	    lookup(grid, economicSectorSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup for EconomicSector data filtered by the defined criteria
     * 
     * @return
     */
    public String fillEconomicSectorLookup()
    {
	try
	{
	    setSearchFilter(economicSectorSC);
	    copyproperties(economicSectorSC);
	    SessionCO sessionCO = returnSessionObject();
	    economicSectorSC.setCompCode(sessionCO.getCompanyCode());
	    economicSectorSC.setCifType(CIF_TYPE_CODE);
	    economicSectorSC.setLegalStatusCode(LEGAL_STATUS);
	    economicSectorSC.setShowInPos(showInPos);
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);	
	    economicSectorSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
	    if (null != cifControlVO)
	    {
		cifControlVO.getUSE_CIF_MATRIX_YN();
	    }	    
	    if(("1".equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()))
		    && !NumberUtil.isEmptyDecimal(CIF_TYPE_CODE) && !NumberUtil.isEmptyDecimal(LEGAL_STATUS))
		    || ("0".equals(StringUtil.nullEmptyToValue(cifControlVO.getUSE_CIF_MATRIX_YN(), "0")))) // DASI170068
	    {
		if(checkNbRec(economicSectorSC))
		{
		    setRecords(economicSectorBO.economicSectorListCount(economicSectorSC));
		}
		ecoSectorVOList = economicSectorBO.economicSectorList(economicSectorSC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(ecoSectorVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of EconomicSectorLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String fillEconomicSectorLookupAddRef()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    economicSectorSC.setCompCode(sessionCO.getCompanyCode());
	    setSearchFilter(economicSectorSC);
	    copyproperties(economicSectorSC);
	    if(checkNbRec(economicSectorSC))
	    {
		setRecords(economicSectorBO.economicSectorAddRefListCount(economicSectorSC));
	    }
	    ecoSectorVOList = economicSectorBO.economicSectorAddRefList(economicSectorSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(ecoSectorVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of EconomicSectorLookupAddRef");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public EconomicSectorSC getEconomicSectorSC()
    {
	return economicSectorSC;
    }

    public void setEconomicSectorSC(EconomicSectorSC economicSectorSC)
    {
	this.economicSectorSC = economicSectorSC;
    }

    public void setEconomicSectorBO(EconomicSectorBO economicSectorBO)
    {
	this.economicSectorBO = economicSectorBO;
    }

	public BigDecimal getCIF_TYPE_CODE()
	{
		return CIF_TYPE_CODE;
	}

	public void setCIF_TYPE_CODE(BigDecimal cIFTYPECODE)
	{
		CIF_TYPE_CODE = cIFTYPECODE;
	}

	public String getShowInPos() {
		return showInPos;
	}

	public void setShowInPos(String showInPos) {
		this.showInPos = showInPos;
	}

	public BigDecimal getLEGAL_STATUS()
	{
	    return LEGAL_STATUS;
	}

	public void setLEGAL_STATUS(BigDecimal lEGAL_STATUS)
	{
	    LEGAL_STATUS = lEGAL_STATUS;
	}

}
