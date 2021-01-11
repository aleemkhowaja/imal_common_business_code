package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.reference.ReferenceSC;

public class ReferenceDependencyAction extends RetailBaseAction
{
    private ReferenceSC referenceSC = new ReferenceSC();

    @Override
    public Object getModel()
    {
	return referenceSC;
    }
	
    public String dependencyByReference()
    {

	try
	{
	    if(referenceSC.getReferenceNo() != null)
	    {
		SessionCO sessionCO = returnSessionObject();
		referenceSC.setCompCode(sessionCO.getCompanyCode());
		referenceSC.setBranchCode(sessionCO.getBranchCode());
				
//				criteria.setDivisionCode(DIVISION_CODE);

//		LNK_REFERENCE = referenceBO.returnReference(referenceSC);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByReference method of ReferenceDependencyAction");
	    handleException(e, "ERROR in Reference Dependency", null);
//	    LNK_REFERENCE = null;
	}

	return SUCCESS;

    }


    public ReferenceSC getReferenceSC()
    {
	return referenceSC;
    }

    public void setReferenceSC(ReferenceSC referenceSC)
    {
	this.referenceSC = referenceSC;
    }

}
