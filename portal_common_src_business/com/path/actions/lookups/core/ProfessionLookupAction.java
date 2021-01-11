package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.profession.ProfessionBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CTS_PROFESSIONVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.profession.ProfessionSC;

public class ProfessionLookupAction extends LookupBaseAction
{
   
    private ProfessionSC professionSC = new ProfessionSC();
    private BigDecimal CIF_TYPE_CODE;  
    private List<CTS_PROFESSIONVO> professionVOList;
    private ProfessionBO professionBO;
    private BigDecimal PROFESSION_CATEGORY;
    private BigDecimal PROFESSION_SEGMENT;

    @Override
    public Object getModel()
    {
	return professionSC;
    }

    /**
     * Construct Profession Lookup based on the VO returned in the
     * resultMap.
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("profession_code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("profession_code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("profession_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/Profession_fillProfessionLookup");
	    
	    lookup(grid, professionSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    /**
     * Fill the lookup for Profession data filtered by the defined criteria
     * 
     * @return
     */
    public String fillProfessionLookup()
    {
	try
	{
	    setSearchFilter(professionSC);
	    copyproperties(professionSC);
	    SessionCO sessionCO = returnSessionObject();
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    professionSC.setCompCode(sessionCO.getCompanyCode());
	    professionSC.setCifType(NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE));
	    professionSC.setCategoryCode(NumberUtil.emptyDecimalToNull(PROFESSION_CATEGORY));
	    professionSC.setSegmentCode(NumberUtil.emptyDecimalToNull(PROFESSION_SEGMENT));
	    professionSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
	    
	    if(NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE) != null && ((NumberUtil.emptyDecimalToNull(PROFESSION_CATEGORY) != null) &&
		    (NumberUtil.emptyDecimalToNull(PROFESSION_SEGMENT) != null) && ("1").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())))
		    || ("0").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())))
	    {		    
        	    if(checkNbRec(professionSC))
        	    {
        		setRecords(professionBO.professionListCount(professionSC));
        	    }
        	    professionVOList = professionBO.professionList(professionSC);
	    } 	    
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(professionVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ProfessionLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setProfessionBO(ProfessionBO professionBO)
    {
        this.professionBO = professionBO;
    }

    public BigDecimal getCIF_TYPE_CODE()
    {
        return CIF_TYPE_CODE;
    }

    public void setCIF_TYPE_CODE(BigDecimal CIF_TYPE_CODE)
    {
        this.CIF_TYPE_CODE = CIF_TYPE_CODE;
    }

    public ProfessionSC getProfessionSC()
    {
        return professionSC;
    }

    public void setProfessionSC(ProfessionSC professionSC)
    {
        this.professionSC = professionSC;
    }

    public ProfessionBO getProfessionBO()
    {
        return professionBO;
    }

    public BigDecimal getPROFESSION_CATEGORY()
    {
        return PROFESSION_CATEGORY;
    }

    public void setPROFESSION_CATEGORY(BigDecimal pROFESSION_CATEGORY)
    {
        PROFESSION_CATEGORY = pROFESSION_CATEGORY;
    }

    public BigDecimal getPROFESSION_SEGMENT()
    {
        return PROFESSION_SEGMENT;
    }

    public void setPROFESSION_SEGMENT(BigDecimal pROFESSION_SEGMENT)
    {
        PROFESSION_SEGMENT = pROFESSION_SEGMENT;
    }
}