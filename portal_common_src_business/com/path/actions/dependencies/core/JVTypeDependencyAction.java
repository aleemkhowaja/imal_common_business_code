package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.jvtypes.JVTypesBO;
import com.path.dbmaps.vo.JV_TYPEVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.jvtypes.JVTypeSC;

public class JVTypeDependencyAction extends RetailBaseAction
{
    private JV_TYPEVO jvTYPEVO = new JV_TYPEVO();
    private JVTypesBO jvTypesBO;

    /**
     * used for the dependency management on JVType management.
     * 
     * @return
     */
    public String dependencyByJVType()
    {
	try
	{
	    JVTypeSC criteria = new JVTypeSC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    // criteria.setBranchCode(account.getBRANCH_CODE());
	    // criteria.setCurrencyCode(account.getCURRENCY_CODE());

	    // BigDecimal compCode = jvTYPEVO.getCOMP_CODE();
	    BigDecimal typeCode = jvTYPEVO.getTYPE_CODE();

	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    // TP#205235; Saheer.Naduthodi; 23/07/2014
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setJvCode(typeCode);

	    jvTYPEVO = jvTypesBO.checkJVTypeValidation(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCYId method of dependencyByJVType ");
	    // TP#205235; Saheer.Naduthodi; 23/07/2014 [START]
	    jvTYPEVO = new JV_TYPEVO();
	    handleException(e, null, null);
	    // TP#205235; Saheer.Naduthodi; 23/07/2014 [END]
	}
	return SUCCESS;
    }
    
    public String checkJVTypeDep()
    {
    	try
    	{
    	    JVTypeSC criteria = new JVTypeSC();
    	    SessionCO sessionCO = returnSessionObject();
    	    
    	    criteria.setCompCode(sessionCO.getCompanyCode());
    	    criteria.setJvCode(jvTYPEVO.getTYPE_CODE());

    	    jvTYPEVO = jvTypesBO.checkJVTypeDep(criteria);
    	}
    	catch(Exception e)
    	{
    	    jvTYPEVO = new JV_TYPEVO();
    	    handleException(e, null, null);
    	}
    	return SUCCESS;
    }

    public JV_TYPEVO getJvTYPEVO()
    {
	return jvTYPEVO;
    }

    public void setJvTYPEVO(JV_TYPEVO jvTYPEVO)
    {
	this.jvTYPEVO = jvTYPEVO;
    }

    public void setJvTypesBO(JVTypesBO jvTypesBO)
    {
	this.jvTypesBO = jvTypesBO;
    }

}
