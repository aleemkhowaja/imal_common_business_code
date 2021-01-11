package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.cardsmessage.CardsMessageBO;
import com.path.dbmaps.vo.CTSCARDS_MESSAGEVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardtype.CardTypeSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * CardsMessageDependencyAction.java used to
 */
public class CardsMessageDependencyAction extends RetailBaseAction
{
	private CardsMessageBO cardsMessageBO;
	private CTSCARDS_MESSAGEVO ctsCardsMessageVO;
	private BigDecimal CODE;

	public String dependencyByCardsMessageCode() 
    {
		try 
		{
        	    SessionCO sessionCO = returnSessionObject();
        	    if(NumberUtil.emptyDecimalToNull(CODE) == null)
        	    {
        		ctsCardsMessageVO = new CTSCARDS_MESSAGEVO();
        	    }
        	    else
        	    {
        		CardTypeSC criteria = new CardTypeSC();
        		criteria.setCompCode(sessionCO.getCompanyCode());
        		criteria.setCode(CODE);
        		ctsCardsMessageVO = cardsMessageBO.returnCardsMessageById(criteria);
        	    }
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByCardsMessageCode method of CardsMessageDependencyAction");
			handleException(e, null, null);
		}
		
		return SUCCESS;
    }

    public CTSCARDS_MESSAGEVO getCtsCardsMessageVO()
	{
		return ctsCardsMessageVO;
	}

	public void setCtsCardsMessageVO(CTSCARDS_MESSAGEVO ctsCardsMessageVO)
	{
		this.ctsCardsMessageVO = ctsCardsMessageVO;
	}

	public BigDecimal getCODE()
	{
		return CODE;
	}

	public void setCODE(BigDecimal cODE)
	{
		CODE = cODE;
	}

	public void setCardsMessageBO(CardsMessageBO cardsMessageBO)
	{
		this.cardsMessageBO = cardsMessageBO;
	}

	}
