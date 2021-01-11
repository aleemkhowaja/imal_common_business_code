package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.ranking.RankingBO;
import com.path.dbmaps.vo.RIFPCTVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ranking.RankingSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * RankingDependencyAction.java used to
 */
public class RankingDependencyAction extends RetailBaseAction
{
	private RankingBO rankingBO;
	private RIFPCTVO rankingVO;
    private BigDecimal PRIORITY_CODE;
	
	public String dependencyByPriorityCode() {

		try 
		{
			SessionCO sessionCO = returnSessionObject();
			RankingSC criteria = new RankingSC();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
			criteria.setPriorityCode(PRIORITY_CODE);
			
			rankingVO = rankingBO.returnRankingById(criteria);
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByPriorityCode method of RankingDependencyAction");
			handleException(e, "ERROR in Ranking Dependency", null);
		}

		return SUCCESS;

	}

	public RIFPCTVO getRankingVO()
	{
		return rankingVO;
	}

	public void setRankingVO(RIFPCTVO rankingVO)
	{
		this.rankingVO = rankingVO;
	}

	public BigDecimal getPRIORITY_CODE()
	{
		return PRIORITY_CODE;
	}

	public void setPRIORITY_CODE(BigDecimal pRIORITYCODE)
	{
		PRIORITY_CODE = pRIORITYCODE;
	}

	public void setRankingBO(RankingBO rankingBO)
	{
		this.rankingBO = rankingBO;
	}


	
	
}
