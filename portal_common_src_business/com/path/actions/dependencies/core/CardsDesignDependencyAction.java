package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.cardsdesign.CardsDesignBO;
import com.path.dbmaps.vo.CTSCARDS_DESIGNVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardtype.CardTypeSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * CardsDesignDependencyAction.java used to
 */
public class CardsDesignDependencyAction extends RetailBaseAction
{
	private CardsDesignBO cardsDesignBO;
	private CTSCARDS_DESIGNVO ctsCardsDesignVO;
	private BigDecimal CODE;

	public String dependencyByCardsDesignCode() 
    {
		try 
		{
			SessionCO sessionCO = returnSessionObject();
            	    if(NumberUtil.emptyDecimalToNull(CODE) == null)
            	    {
            		ctsCardsDesignVO = new CTSCARDS_DESIGNVO();
            	    }
            	    else
            	    {
            		CardTypeSC criteria = new CardTypeSC();
            		criteria.setCompCode(sessionCO.getCompanyCode());
            		criteria.setCode(CODE);
            		ctsCardsDesignVO = cardsDesignBO.returnCardsDesignById(criteria);
            	    }
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByCardsDesignCode method of CardsDesignDependencyAction");
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

	public CTSCARDS_DESIGNVO getCtsCardsDesignVO()
	{
		return ctsCardsDesignVO;
	}

	public void setCtsCardsDesignVO(CTSCARDS_DESIGNVO ctsCardsDesignVO)
	{
		this.ctsCardsDesignVO = ctsCardsDesignVO;
	}

	public void setCardsDesignBO(CardsDesignBO cardsDesignBO)
	{
		this.cardsDesignBO = cardsDesignBO;
	}

	}
