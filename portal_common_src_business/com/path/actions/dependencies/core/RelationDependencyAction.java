package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.relation.RelationBO;
import com.path.dbmaps.vo.RELATIONVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.relation.RelationSC;

public class RelationDependencyAction extends RetailBaseAction
{
    private RelationBO relationBO;
    private BigDecimal RELATION_CODE;
    private RELATIONVO relationVO;
    private String additionalRef;

    public String dependencyByRelationCode()
    {
	try
	{
	    if(NumberUtil.emptyDecimalToNull(RELATION_CODE) == null)
	    {
		relationVO = new RELATIONVO();
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		RelationSC criteria = new RelationSC();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		criteria.setRelationCode(RELATION_CODE);
		if(StringUtil.isNotEmpty(additionalRef))
		{
		    criteria.setAddReference(additionalRef);
		}
		relationVO = relationBO.returnRelationByCode(criteria);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    public BigDecimal getRELATION_CODE()
    {
	return RELATION_CODE;
    }

    public void setRELATION_CODE(BigDecimal rELATIONCODE)
    {
	RELATION_CODE = rELATIONCODE;
    }

    public RELATIONVO getRelationVO()
    {
	return relationVO;
    }

    public void setRelationVO(RELATIONVO relationVO)
    {
	this.relationVO = relationVO;
    }

    public void setRelationBO(RelationBO relationBO)
    {
	this.relationBO = relationBO;
    }

    public String getAdditionalRef()
    {
        return additionalRef;
    }

    public void setAdditionalRef(String additionalRef)
    {
        this.additionalRef = additionalRef;
    }

    
}
