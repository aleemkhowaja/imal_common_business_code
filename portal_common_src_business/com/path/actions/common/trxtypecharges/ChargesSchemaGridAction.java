package com.path.actions.common.trxtypecharges;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.chargesschema.ChargesSchemaBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.chargesschema.ChargesSchemaSC;
import com.path.vo.core.csmfom.CTSChargesSchemaCO;

public class ChargesSchemaGridAction extends GridBaseAction
{
    
    private ChargesSchemaBO chargesSchemaBO;
    private ChargesSchemaSC criteria = new ChargesSchemaSC();
    private BigDecimal schemaCode;
    private List chargeTypeList = new ArrayList<SelectCO>();
	 
    public String chargesSchemaGrid()
    {	 
	try
	{
	    criteria.setCode(schemaCode);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    copyproperties(criteria);
		    
		    
	    if(checkNbRec(criteria))
	    {
		setRecords(chargesSchemaBO.trxChargesSchemaListCount(criteria));
	    }
	    List<CTSChargesSchemaCO> chargesSchemaVOList = chargesSchemaBO.trxChargesSchemaList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(chargesSchemaVOList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
		
	return "success";
    }
	
    public String loadChargeType()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(88)); // 88
	    chargeTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    public void setChargesSchemaBO(ChargesSchemaBO chargesSchemaBO)
    {
	this.chargesSchemaBO = chargesSchemaBO;
    }

    public ChargesSchemaSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ChargesSchemaSC criteria)
    {
	this.criteria = criteria;
    }

    public BigDecimal getSchemaCode()
    {
	return schemaCode;
    }

    public void setSchemaCode(BigDecimal schemaCode)
    {
	this.schemaCode = schemaCode;
    }

    public List getChargeTypeList()
    {
	return chargeTypeList;
    }

    public void setChargeTypeList(List chargeTypeList)
    {
	this.chargeTypeList = chargeTypeList;
    }
}
