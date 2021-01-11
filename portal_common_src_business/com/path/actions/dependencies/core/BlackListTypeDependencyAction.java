package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.blacklisttype.BlackListTypeBO;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;

public class BlackListTypeDependencyAction extends RetailBaseAction
{
	private BlackListTypeBO blackListTypeBO;
	private MOSBLACKLIST_TYPEVO blackListTypeVO;
	private BigDecimal CODE;
	
    public String dependencyByBlackListTypeCode() {

		try 
		{
			if (NumberUtil.emptyDecimalToNull(CODE) != null )
        	    {
					SessionCO sessionCO = returnSessionObject();
					BlackListTypeSC criteria = new BlackListTypeSC();
					criteria.setCompCode(sessionCO.getCompanyCode());
					criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
					criteria.setCode(CODE);
					blackListTypeVO = blackListTypeBO.returnBlackLstTypeById(criteria);
        	    }
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByBlackListTypeCode method of BlackListTypeDependencyAction");
			handleException(e, null, null);
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

	public MOSBLACKLIST_TYPEVO getBlackListTypeVO()
	{
		return blackListTypeVO;
	}

	public void setBlackListTypeVO(MOSBLACKLIST_TYPEVO blackListTypeVO)
	{
		this.blackListTypeVO = blackListTypeVO;
	}

	public void setBlackListTypeBO(BlackListTypeBO blackListTypeBO)
	{
		this.blackListTypeBO = blackListTypeBO;
	}
}
