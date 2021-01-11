/**
 * 
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.reason.ReasonBO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.reason.ReasonSC;

public class ReasonDependencyAction extends RetailBaseAction
{
    private ReasonBO reasonBO;
    private ReasonSC criteria = new ReasonSC();
    private CTSREASONSVO reasonVO;
    private BigDecimal reasonCode;

    public String dependencyByCode()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(reasonCode))
	    {
		criteria.setCompCode(returnSessionObject().getCompanyCode());
		criteria.setCode(reasonCode);
		String originOptRef = "";
		if(StringUtil.isNotEmpty(get_pageRef()))
		{
		    originOptRef = returnCommonLibBO().returnOrginProgRef(returnSessionObject().getCurrentAppName(), get_pageRef());
		}
		if(FomConstant.MAINTENANCE_OPT.equals(originOptRef) && null == criteria.getScreenSrc())
		{
		    criteria.setReason_type(FomConstant.CIF_FATCA_REASON_TYPE_DEFAULT);
		    if(FomConstant.CIF_FATCA_STATUS_US_ACC_Holder.equals(criteria.getStatus()))
		    {
			criteria.setReason_type(FomConstant.CIF_FATCA_REASON_TYPE_US_ACC_Holder);
		    }
		}
		reasonVO = reasonBO.returnReasonByCode(criteria);
		if(null == reasonVO)
		{
		    reasonVO = new CTSREASONSVO();
		}
	    }
	}
	catch(Exception e)
	{

	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return criteria;
    }

    public ReasonSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ReasonSC criteria)
    {
	this.criteria = criteria;
    }

    public CTSREASONSVO getReasonVO()
    {
	return reasonVO;
    }

    public void setReasonVO(CTSREASONSVO reasonVO)
    {
	this.reasonVO = reasonVO;
    }

    public BigDecimal getReasonCode()
    {
	return reasonCode;
    }

    public void setReasonCode(BigDecimal reasonCode)
    {
	this.reasonCode = reasonCode;
    }

    public void setReasonBO(ReasonBO reasonBO)
    {
	this.reasonBO = reasonBO;
    }

}
