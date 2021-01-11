package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.cifrelation.CifRelationBO;
import com.path.dbmaps.vo.RELATION_BETWEEN_CIFSVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifrelation.CifRelationSC;

public class RelationBetweenCIFDependencyAction extends RetailBaseAction
{

    private CifRelationBO cifRelationBO;
    private BigDecimal CODE;
    private RELATION_BETWEEN_CIFSVO cifRelationVO;

    public String dependencyByCifRelationCode()
    {
    	try
		{
		    SessionCO sessionCO = returnSessionObject();
		    CifRelationSC criteria = new CifRelationSC();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setCifRelationCode(CODE);
		    cifRelationVO = cifRelationBO.returnCifRelationByCode(criteria);
		    
		}
		catch(Exception e)
		{
		    log.error(e, "Error in dependencyByCifRelationCode method of RelationBetweenCIFDependencyAction");
		    handleException(e, "ERROR in CifRelation Dependency", null);
		}

		return SUCCESS;
    }

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

	public RELATION_BETWEEN_CIFSVO getCifRelationVO()
	{
		return cifRelationVO;
	}

	public void setCifRelationVO(RELATION_BETWEEN_CIFSVO cifRelationVO)
	{
		this.cifRelationVO = cifRelationVO;
	}

	public void setCifRelationBO(CifRelationBO cifRelationBO)
	{
		this.cifRelationBO = cifRelationBO;
	}


}
