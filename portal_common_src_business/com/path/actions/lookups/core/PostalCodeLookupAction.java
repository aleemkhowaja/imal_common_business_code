package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.postalcode.PostalCodeBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.postalcode.PostalCodeSC;

public class PostalCodeLookupAction extends LookupBaseAction
{

    private PostalCodeSC criteria = new PostalCodeSC();
    private PostalCodeBO postalCodeBO;
    private BigDecimal countryCode;
    private BigDecimal regionCode;
    private BigDecimal postboxArea;
    private String postboxAreaFlag;

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
	    String[] name = { "POST_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB",
		    "ADDITIONAL_REFERENCE", "REGION_CODE" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text" };
	    // Boolean[] hidden = {false,false,false,false,false,true};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("Additional_Reference_key"),
		    getText("Region_key") };

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
	    , 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "POST_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "ADDITIONAL_REFERENCE",
			"REGION_CODE" };
		colType = new String[] { "text", "text", "text", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("Additional_Reference_key"), getText("Region_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Postal_Code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/PostalCodeLookup_fillPostalCodeLookup");
	    List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Postal Code data filtered by the defined criteria
     * 
     * @return
     */
    public String fillPostalCodeLookup()
    {
	try
	{
	    List<POSTAL_CODEVO> postalCodeVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(!NumberUtil.isEmptyDecimal(countryCode))
	    {
		criteria.setCountry_code(countryCode);
	    }
	    if(!NumberUtil.isEmptyDecimal(regionCode))
	    {
		criteria.setRegion_code(regionCode);
	    }
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    if("1".equals(StringUtil.nullToEmpty(cifControlVO.getUSE_ADDRESS_DESC()))
		    && "true".equals(postboxAreaFlag))
	    {
		setRegionCode(postboxArea);
		criteria.setRegion_code(postboxArea);
	    }

	    if(!NumberUtil.isEmptyDecimal(countryCode)
		    && (("").equals(StringUtil.nullToEmpty(postboxAreaFlag)) || (("true").equals(postboxAreaFlag) && !NumberUtil.isEmptyDecimal(regionCode)))) //Hala DBU190317
	    {
		if(checkNbRec(criteria))
		{
		    setRecords(postalCodeBO.postalCodeListCount(criteria));
		}
		postalCodeVOList = postalCodeBO.postalCodeList(criteria);
		// set the collection into gridModel attribute defined at JSP
		// grid
		setGridModel(postalCodeVOList);
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillPostalCodeLookup of PostalCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fmsConstructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "POST_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB",
		    "ADDITIONAL_REFERENCE", "REGION_CODE" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text" };
	    // Boolean[] hidden = {false,false,false,false,false,true};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("Additional_Reference_key"),
		    getText("Region_key") };

	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "POST_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "ADDITIONAL_REFERENCE",
			"REGION_CODE" };
		colType = new String[] { "text", "text", "text", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("Additional_Reference_key"), getText("Region_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Postal_Code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/PostalCodeLookup_fmsFillPostalCodeLookup");
	    List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Postal Code data filtered by the defined criteria
     * 
     * @return
     */
    public String fmsFillPostalCodeLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(criteria))
	    {
		setRecords(postalCodeBO.postalCodeListCount(criteria));
	    }
	    setGridModel(postalCodeBO.postalCodeList(criteria));

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fmsFillPostalCodeLookup of PostalCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public PostalCodeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(PostalCodeSC criteria)
    {
	this.criteria = criteria;
    }

    public void setPostalCodeBO(PostalCodeBO postalCodeBO)
    {
	this.postalCodeBO = postalCodeBO;
    }

    public BigDecimal getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(BigDecimal countryCode)
    {
        this.countryCode = countryCode;
    }

    public BigDecimal getRegionCode()
    {
        return regionCode;
    }

    public void setRegionCode(BigDecimal regionCode)
    {
        this.regionCode = regionCode;
    }

    public BigDecimal getPostboxArea()
    {
        return postboxArea;
    }

    public void setPostboxArea(BigDecimal postboxArea)
    {
        this.postboxArea = postboxArea;
    }
    public String getPostboxAreaFlag()
    {
        return postboxAreaFlag;
    }

    public void setPostboxAreaFlag(String postboxAreaFlag)
    {
        this.postboxAreaFlag = postboxAreaFlag;
    }    
}
