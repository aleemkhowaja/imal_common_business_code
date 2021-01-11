/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.chargesschema.ChargesSchemaBO;
import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.chargesschema.ChargesSchemaSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * ChargesSchemaDependencyAction.java used to
 */
public class ChargesSchemaDependencyAction extends RetailBaseAction
{
    private final ChargesSchemaSC criteria = new ChargesSchemaSC();
    private ChargesSchemaBO chargesSchemaBO;
    private CTSCHARGES_SCHEMAVO chargesSchemaVO;
    
    public String dependencyByCode() {

	try 
	{
	    if(criteria.getCode() != null){
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());

		chargesSchemaVO = chargesSchemaBO.returnDependencyByCode(criteria);
	    }
	    if(chargesSchemaVO == null)
	    {
		chargesSchemaVO = new CTSCHARGES_SCHEMAVO();
	    }
	} 
	catch (Exception e) 
	{
	    
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * @return the chargesSchemaVO
     */
    public CTSCHARGES_SCHEMAVO getChargesSchemaVO()
    {
        return chargesSchemaVO;
    }

    /**
     * @param chargesSchemaBO the chargesSchemaBO to set
     */
    public void setChargesSchemaBO(ChargesSchemaBO chargesSchemaBO)
    {
        this.chargesSchemaBO = chargesSchemaBO;
    }
}
