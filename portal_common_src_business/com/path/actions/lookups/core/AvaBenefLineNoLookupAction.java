package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.avabeneficiaries.AvaBeneficiariesLkpBO;
import com.path.dbmaps.vo.CTS_AVA_BENEFICIARIESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.avabenef.AvaBeneficiariesDefSC;

public class AvaBenefLineNoLookupAction extends LookupBaseAction
{

    private AvaBeneficiariesLkpBO avaBeneficiariesLkpBO;
    private final AvaBeneficiariesDefSC criteria = new AvaBeneficiariesDefSC();

    public String constructLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "avaBeneficiariesVO.LINE_NO", "avaBeneficiariesVO.FILE_CODE",
		    "avaBeneficiariesVO.CIF_NO", "avaBeneficiariesVO.SHORT_NAME", "avaBeneficiariesVO.ID_TYPE",
		    "idTypeDesc", "avaBeneficiariesVO.ID_NO" };
	    String[] colType = { "number", "number", "number", "text", "number", "text", "text" };
	    String[] titles = { getText("Line_No_key"), getText("File_Code_key"), getText("CIF_No_key"),
		    getText("Short_Name_key"), getText("Id_Type_key"), getText("Id_Type_Desc_key"),
		    getText("Id_No_key") };
	    /*
	     * if(returnSessionObject().getHideArabicColumns()) { name = new
	     * String[] { "CODE", "NAME" }; colType = new String[] { "nu0mber",
	     * "text" }; titles = new String[] { getText("Code__key"),
	     * getText("Name_key") };
	     * 
	     * }
	     */
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("FileList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AvaBenefLineNoLookupAction_fillBeneficiariesLkp");
	    lookup(grid, criteria, name, colType, titles);

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
     * 
     */
    public String fillBeneficiariesLkp()
    {
	try
	{
	    List<CTS_AVA_BENEFICIARIESVO> beneficiariesVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);

	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setBenefStatusLov(BigDecimal.valueOf(701));
	    criteria.setLanguage(sessionCO.getLanguage());
	    if(getRecords() == 0)
	    {
		setRecords(avaBeneficiariesLkpBO.returnAvaBeneficiariesLookupCount(criteria));
	    }
	    setGridModel(avaBeneficiariesLkpBO.returnAvaBeneficiariesLookupList(criteria));
	    // set the collection into gridModel attribute defined at JSP grid
	    // setGridModel(beneficiariesVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setAvaBeneficiariesLkpBO(AvaBeneficiariesLkpBO avaBeneficiariesLkpBO)
    {
	this.avaBeneficiariesLkpBO = avaBeneficiariesLkpBO;
    }

    public Object getModel()
    {
	return criteria;
    }

    /**
     * @return the criteria
     */
    public AvaBeneficiariesDefSC getCriteria()
    {
	return criteria;
    }

}