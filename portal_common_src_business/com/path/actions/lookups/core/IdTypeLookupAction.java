package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.idtype.IdTypeBO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.idtype.IdTypeSC;

public class IdTypeLookupAction extends LookupBaseAction
{
  
    private IdTypeSC idTypeSC = new IdTypeSC();
    private IdTypeBO idTypeBO;
    private List<ID_TYPESVO> idTypeVOList;
    private BigDecimal CIF_TYPE;

    @Override
    public Object getModel()
    {
	return idTypeSC;
    }

    /**
     * Construct IdType Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "DESC_ENG", "DESC_ARAB" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key") };
	    

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "DESC_ENG"};
		colType = new String[] { "number", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("sub_ecosector_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/IdType_fillIdTypeLookup");
	    lookup(grid, idTypeSC, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	

	return SUCCESS;

    }

    /**
     * Fill the lookup for IdType data filtered by the defined criteria
     * 
     * @return
     */
    public String fillIdTypeLookup()
    {
	try
	{
	    setSearchFilter(idTypeSC);
	    copyproperties(idTypeSC);
	    SessionCO sessionCO = returnSessionObject();
	    idTypeSC.setCompCode(sessionCO.getCompanyCode());
	    if(checkNbRec(idTypeSC))
	    {
		setRecords(idTypeBO.idTypeListCount(idTypeSC));
	    }
	    idTypeVOList = idTypeBO.idTypeList(idTypeSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(idTypeVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of IdTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructIdTypeListByCIFTypeLookup()
    {
		try
		{
		    // Design the Grid by defining the column model and column names
		    String[] name = { "CODE", "DESC_ENG", "DESC_ARAB","ENABLE_MCR" };
		    String[] colType = { "number", "text", "text", "text" };
		  //  Boolean[] hidden  = {false,false,false,true};
		    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			    getText("Brief_Desc_Arab_key"),getText("Code_key")};
		    
		    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
		       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
			, 3= Arabic Visible and Mandatory English Not Mandatory). */
		    if(returnSessionObject().getHideArabicColumns())
		    {
			name = new String[] { "CODE", "DESC_ENG", "ENABLE_MCR" };
			colType = new String[] { "number", "text", "text" };
			titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),getText("Code_key")};
		    }
	
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("sub_ecosector_status_key "));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/IdType_fillIdTypeListByCIFTypeLookup");
		    List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);

		    if(returnSessionObject().getHideArabicColumns())//BUG#800812 copied from BUG#492803
		    {
			if(lsGridColumn.size() > 2)
			{
			    lsGridColumn.get(2).setHidden(true);
			}
		    }
		    else
		    {
			if(lsGridColumn.size() > 3)
			{
			    lsGridColumn.get(3).setHidden(true);
			}
		    }
		    
		    lookup(grid, lsGridColumn, null, idTypeSC);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}

		return SUCCESS;

    }
    
    public String fillIdTypeListByCIFTypeLookup()
    {
		try
		{
		    setSearchFilter(idTypeSC);
		    copyproperties(idTypeSC);
		    SessionCO sessionCO = returnSessionObject();
		    idTypeSC.setCompCode(sessionCO.getCompanyCode());
		    idTypeSC.setCifTypeCode(CIF_TYPE);
		    if(checkNbRec(idTypeSC))
		    {
			setRecords(idTypeBO.idTypeByCIFTypeListCount(idTypeSC));
		    }
		    idTypeVOList = idTypeBO.idTypeByCIFTypeList(idTypeSC);
		    // set the collection into gridModel attribute defined at JSP grid
		    setGridModel(idTypeVOList);
	
		}
		catch(Exception e)
		{
		    log.error(e, "Error in fillLookupData of IdTypeLookupAction");
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
    
    public void setIdTypeBO(IdTypeBO idTypeBO)
    {
        this.idTypeBO = idTypeBO;
    }
    
    public IdTypeSC getIdTypeSC()
    {
        return idTypeSC;
    }

    public void setIdTypeSC(IdTypeSC idTypeSC)
    {
        this.idTypeSC = idTypeSC;
    }

	public BigDecimal getCIF_TYPE()
	{
		return CIF_TYPE;
	}

	public void setCIF_TYPE(BigDecimal cIFTYPE)
	{
		CIF_TYPE = cIFTYPE;
	}
}
