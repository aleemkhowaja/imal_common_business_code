package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.professioncategory.ProfessionCategoryBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.professioncategory.ProfessionCategorySC;

public class ProfessionCategoryLookupAction extends LookupBaseAction
{
   
    private ProfessionCategorySC professionCategorySC = new ProfessionCategorySC();
    private BigDecimal CIF_TYPE_CODE;  
    private BigDecimal LEGAL_STATUS;
    private List<CTS_PROFESSION_CATEGORYVO> professionCategoryVOList;
    private ProfessionCategoryBO professionCategoryBO;

    @Override
    public Object getModel()
    {
	return professionCategorySC;
    }

    /**
     * Construct ProfessionCategory Lookup based on the VO returned in the
     * resultMap.
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("prof_category_code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("prof_category_code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("profession_category_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ProfessionCategory_fillProfessionCategoryLookup");
	    
	    lookup(grid, professionCategorySC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    /**
     * Fill the lookup for ProfessionCategory data filtered by the defined criteria
     * 
     * @return
     */
    public String fillProfessionCategoryLookup()
    {
	try
	{
	    setSearchFilter(professionCategorySC);
	    copyproperties(professionCategorySC);
	    SessionCO sessionCO = returnSessionObject();
	    professionCategorySC.setCompCode(sessionCO.getCompanyCode());
	    professionCategorySC.setCifType(NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE));
	    professionCategorySC.setLegalStatusCode(NumberUtil.emptyDecimalToNull(LEGAL_STATUS));
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    professionCategorySC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
	    if (null != cifControlVO)
	    {
		cifControlVO.getUSE_CIF_MATRIX_YN();
	    }	    
	    if(NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE) != null 
		    &&((NumberUtil.emptyDecimalToNull(LEGAL_STATUS) != null && ("1").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())))
			    || ("0").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()))))
	    {       
        	    if(checkNbRec(professionCategorySC))
        	    {
        		setRecords(professionCategoryBO.professionCategoryListCount(professionCategorySC));
        	    }
        	    professionCategoryVOList = professionCategoryBO.professionCategoryList(professionCategorySC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(professionCategoryVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ProfessionCategoryLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setProfessionCategoryBO(ProfessionCategoryBO professionCategoryBO)
    {
        this.professionCategoryBO = professionCategoryBO;
    }

    public BigDecimal getCIF_TYPE_CODE()
    {
        return CIF_TYPE_CODE;
    }

    public void setCIF_TYPE_CODE(BigDecimal CIF_TYPE_CODE)
    {
        this.CIF_TYPE_CODE = CIF_TYPE_CODE;
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