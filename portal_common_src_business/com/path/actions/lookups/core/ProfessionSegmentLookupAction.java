package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.professionsegment.ProfessionSegmentBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CTS_PROFESSION_SEGMENTVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.professionsegment.ProfessionSegmentSC;
             
public class ProfessionSegmentLookupAction extends LookupBaseAction
{
   
    private ProfessionSegmentSC professionSegmentSC = new ProfessionSegmentSC();
    private BigDecimal CIF_TYPE_CODE;  
    private BigDecimal PROFESSION_CATEGORY;
    private List<CTS_PROFESSION_SEGMENTVO> professionSegmentVOList;
    private ProfessionSegmentBO professionSegmentBO;

    @Override
    public Object getModel()
    {
	return professionSegmentSC;
    }

    /**
     * Construct ProfessionSegment Lookup based on the VO returned in the
     * resultMap.
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("prof_segmet_code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"),
		    getText("Long_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG" };
		colType = new String[] { "number", "text", "text"};
		titles = new String[] { getText("prof_segmet_code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("profession_segment_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ProfessionSegment_fillProfessionSegmentLookup");
	    
	    lookup(grid, professionSegmentSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    /**
     * Fill the lookup for ProfessionSegment data filtered by the defined criteria
     * 
     * @return
     */
    public String fillProfessionSegmentLookup()
    {
	try
	{
	    setSearchFilter(professionSegmentSC);
	    copyproperties(professionSegmentSC);
	    SessionCO sessionCO = returnSessionObject();
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    professionSegmentSC.setCompCode(sessionCO.getCompanyCode());
	    professionSegmentSC.setCifType(NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE));
	    professionSegmentSC.setCategoryCode(NumberUtil.emptyDecimalToNull(PROFESSION_CATEGORY));
	    professionSegmentSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
	    if((NumberUtil.emptyDecimalToNull(CIF_TYPE_CODE) != null) && ((NumberUtil.emptyDecimalToNull(PROFESSION_CATEGORY) != null)
		    && ("1").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())))
		    || ("0").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())))
	    {
        	    if(checkNbRec(professionSegmentSC))
        	    {
        		setRecords(professionSegmentBO.professionSegmentListCount(professionSegmentSC));
        	    }
        	    professionSegmentVOList = professionSegmentBO.professionSegmentList(professionSegmentSC);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(professionSegmentVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ProfessionSegmentLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setProfessionSegmentBO(ProfessionSegmentBO professionSegmentBO)
    {
        this.professionSegmentBO = professionSegmentBO;
    }

    public BigDecimal getCIF_TYPE_CODE()
    {
        return CIF_TYPE_CODE;
    }

    public void setCIF_TYPE_CODE(BigDecimal CIF_TYPE_CODE)
    {
        this.CIF_TYPE_CODE = CIF_TYPE_CODE;
    }

    public ProfessionSegmentSC getProfessionSegmentSC()
    {
        return professionSegmentSC;
    }

    public void setProfessionSegmentSC(ProfessionSegmentSC professionSegmentSC)
    {
        this.professionSegmentSC = professionSegmentSC;
    }

    public ProfessionSegmentBO getProfessionSegmentBO()
    {
        return professionSegmentBO;
    }

    public BigDecimal getPROFESSION_CATEGORY()
    {
        return PROFESSION_CATEGORY;
    }

    public void setPROFESSION_CATEGORY(BigDecimal pROFESSION_CATEGORY)
    {
        PROFESSION_CATEGORY = pROFESSION_CATEGORY;
    }
}