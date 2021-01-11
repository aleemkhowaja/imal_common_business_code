package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.subecosector.SubEcoSectorBO;
import com.path.dbmaps.vo.RIFSECVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.subecosector.SubEcoSectorSC;

public class SubEcoSectorLookupAction extends LookupBaseAction
{

    private SubEcoSectorSC subEcoSectorSC = new SubEcoSectorSC();
    private SubEcoSectorBO subEcoSectorBO;
    private List<RIFSECVO> subEcoSectorVOList;
    private BigDecimal CIF_TYPE_CODE;
    private BigDecimal SECTOR_CODE;

    @Override
    public Object getModel()
    {
	return subEcoSectorSC;
    }

    /**
     * Construct SubEcoSector Lookup based on the VO returned in the resultMap.
     * dddw_cif_sub_eco_sector
     * 
     * @return
     */

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "SUB_SECTOR_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG",
		    "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "SUB_SECTOR_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("sub_ecosector_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/SubEcoSector_fillSubEcoSectorLookup");
	    /*
	     * int cols = name.length;
	     * 
	     * for(int i = 0; i < cols; i++) { // Defining each column
	     * LookupGridColumn gridColumn = new LookupGridColumn();
	     * gridColumn.setName(name[i]); gridColumn.setIndex(name[i]);
	     * gridColumn.setColType(colType[i]);
	     * gridColumn.setTitle(titles[i]); gridColumn.setSearch(true); //
	     * adding column to the list lsGridColumn.add(gridColumn); }
	     * lookup(grid, lsGridColumn, null, subEcoSectorSC);
	     */
	    lookup(grid, subEcoSectorSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for SubEcoSector data filtered by the defined criteria
     * 
     * @return
     */
    public String fillSubEcoSectorLookup()
    {
	try
	{
	    setSearchFilter(subEcoSectorSC);
	    copyproperties(subEcoSectorSC);
	    SessionCO sessionCO = returnSessionObject();
	    subEcoSectorSC.setCompCode(sessionCO.getCompanyCode());
	    subEcoSectorSC.setCifType(CIF_TYPE_CODE);/** @todo */
	    subEcoSectorSC.setSectorCode(SECTOR_CODE);/** @todo */
	    subEcoSectorSC.setAllTypes(getText("All_types_key"));
	    if(checkNbRec(subEcoSectorSC))
	    {
		setRecords(subEcoSectorBO.subEcoSectorListCount(subEcoSectorSC));
	    }
	    subEcoSectorVOList = subEcoSectorBO.subEcoSectorList(subEcoSectorSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(subEcoSectorVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of SubEcoSectorLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct SubEcoSector Lookup based on the VO returned in the resultMap.
     * dw_lookup_subsec_ecosect_parent
     * 
     * @return
     */

    public String constructLookupSubEcoSecParent()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "SUB_SECTOR_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG",
		    "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "SUB_SECTOR_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("sub_ecosector_status_key "));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/SubEcoSector_fillSubEcoSecParentLookup");
	    /*
	     * int cols = name.length;
	     * 
	     * for(int i = 0; i < cols; i++) { // Defining each column
	     * LookupGridColumn gridColumn = new LookupGridColumn();
	     * gridColumn.setName(name[i]); gridColumn.setIndex(name[i]);
	     * gridColumn.setColType(colType[i]);
	     * gridColumn.setTitle(titles[i]); gridColumn.setSearch(true); //
	     * adding column to the list lsGridColumn.add(gridColumn); }
	     * lookup(grid, lsGridColumn, null, subEcoSectorSC);
	     */
	    lookup(grid, subEcoSectorSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for SubEcoSector data filtered by the defined criteria
     * 
     * @return
     */
    public String fillSubEcoSecParentLookup()
    {
	try
	{
	    setSearchFilter(subEcoSectorSC);
	    copyproperties(subEcoSectorSC);
	    SessionCO sessionCO = returnSessionObject();
	    subEcoSectorSC.setCompCode(sessionCO.getCompanyCode());
	    subEcoSectorSC.setCifType(CIF_TYPE_CODE);/** @todo */
	    subEcoSectorSC.setSectorCode(SECTOR_CODE);/** @todo */
	    if(checkNbRec(subEcoSectorSC))
	    {
		setRecords(subEcoSectorBO.subEcoSectorParentListCount(subEcoSectorSC));
	    }
	    subEcoSectorVOList = subEcoSectorBO.subEcoSectorParentList(subEcoSectorSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(subEcoSectorVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of SubEcoSecParent");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public SubEcoSectorSC getSubEcoSectorSC()
    {
	return subEcoSectorSC;
    }

    public void setSubEcoSectorSC(SubEcoSectorSC subEcoSectorSC)
    {
	this.subEcoSectorSC = subEcoSectorSC;
    }

    public void setSubEcoSectorBO(SubEcoSectorBO subEcoSectorBO)
    {
	this.subEcoSectorBO = subEcoSectorBO;
    }

    public BigDecimal getCIF_TYPE_CODE()
    {
	return CIF_TYPE_CODE;
    }

    public void setCIF_TYPE_CODE(BigDecimal cIFTYPECODE)
    {
	CIF_TYPE_CODE = cIFTYPECODE;
    }

    public BigDecimal getSECTOR_CODE()
    {
	return SECTOR_CODE;
    }

    public void setSECTOR_CODE(BigDecimal sECTORCODE)
    {
	SECTOR_CODE = sECTORCODE;
    }

}
