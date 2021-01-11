package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.race.RaceBO;
import com.path.dbmaps.vo.RACEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.race.RaceSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * RaceDependencyAction.java used to
 */
public class RaceDependencyAction extends RetailBaseAction
{
	private RaceBO raceBO;
	private RACEVO raceVO;
    private BigDecimal RACE_CODE;
	
	public String dependencyByRaceCode() {

		try 
		{
			if (NumberUtil.emptyDecimalToNull(RACE_CODE) != null)
			{
				
				SessionCO sessionCO = returnSessionObject();
				RaceSC criteria = new RaceSC();
				criteria.setCompCode(sessionCO.getCompanyCode());
				criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
				criteria.setRaceCode(RACE_CODE);
				
				raceVO = raceBO.returnRaceById(criteria);
			}
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByRaceCode method of RaceDependencyAction");
			handleException(e, "ERROR in Race Dependency", null);
		}

		return SUCCESS;

	}

	public RACEVO getRaceVO()
	{
		return raceVO;
	}

	public void setRaceVO(RACEVO raceVO)
	{
		this.raceVO = raceVO;
	}

	public BigDecimal getRACE_CODE()
	{
		return RACE_CODE;
	}

	public void setRACE_CODE(BigDecimal rACECODE)
	{
		RACE_CODE = rACECODE;
	}

	public void setRaceBO(RaceBO raceBO)
	{
		this.raceBO = raceBO;
	}




	
	
}
