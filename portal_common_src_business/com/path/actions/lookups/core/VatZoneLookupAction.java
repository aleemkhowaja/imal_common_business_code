package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.bo.core.vatzone.VatZoneBO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.CTS_AVA_BENEFICIARIESVOKey;
import com.path.dbmaps.vo.CTS_VAT_ZONEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.countries.CountriesCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.core.vatzone.VatZoneSC;

public class VatZoneLookupAction extends LookupBaseAction
{

    private VatZoneBO vatZoneBO;
    private VatZoneSC vatZoneSC = new VatZoneSC();
    private BigDecimal VAT_ZONE;
    private CTS_VAT_ZONEVO ctsVatZoneVO = new CTS_VAT_ZONEVO();

    @Override
    public Object getModel()
    {
	return vatZoneSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "ZONE_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Name_key"), getText("Long_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/VatZoneLookup_fillZoneCodeLookup");
	    lookup(grid, vatZoneSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillZoneCodeLookup()
    {
	try
	{
/*	    if(vatZoneSC == null)
	    {
		vatZoneSC = new VatZoneSC();
	    }*/
	    List<CTS_VAT_ZONEVO> vatZoneVOList;
	    setSearchFilter(vatZoneSC);
	    copyproperties(vatZoneSC);
	    SessionCO sessionCO = returnSessionObject();
	    vatZoneSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(vatZoneSC))
	    {
		setRecords(vatZoneBO.vatZoneListCount(vatZoneSC));
	    }
	    vatZoneVOList = vatZoneBO.vatZoneList(vatZoneSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(vatZoneVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of VatZoneLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyByVatCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    vatZoneSC.setCompCode(sessionCO.getCompanyCode());
	    vatZoneSC.setZoneCode(VAT_ZONE);
	    ctsVatZoneVO = vatZoneBO.returnZoneCodeById(vatZoneSC);
	   
	}
	catch(Exception e)
	{
		ctsVatZoneVO = new CTS_VAT_ZONEVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public VatZoneSC getVatZoneSC()
    {
	return vatZoneSC;
    }

    public void setVatZoneSC(VatZoneSC vatZoneSC)
    {
	this.vatZoneSC = vatZoneSC;
    }

    public void setVatZoneBO(VatZoneBO vatZoneBO)
    {
	this.vatZoneBO = vatZoneBO;
    }

	public CTS_VAT_ZONEVO getCtsVatZoneVO() {
		return ctsVatZoneVO;
	}

	public void setCtsVatZoneVO(CTS_VAT_ZONEVO ctsVatZoneVO) {
		this.ctsVatZoneVO = ctsVatZoneVO;
	}

	public BigDecimal getVAT_ZONE() {
		return VAT_ZONE;
	}

	public void setVAT_ZONE(BigDecimal vAT_ZONE) {
		VAT_ZONE = vAT_ZONE;
	}

}
