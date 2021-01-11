package com.path.bo.core.cardintegration.impl;

import com.path.bo.core.common.base.RetailBaseBO;
import com.path.dao.core.administration.AdministrationDAO;
import com.path.dao.core.cardintegration.CardIntegrationDAO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.S_LINKVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardintegration.CardIntegrationSC;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.cardintegration.CardIntegrationBO;

public class CardIntegrationBOImpl extends RetailBaseBO implements CardIntegrationBO
{
    
    private CardIntegrationDAO cardIntegrationDAO;
    
    
    
    
    
    
    @Override
    public int debitCardTypeLookupCount(CardIntegrationSC criteria) throws BaseException
    {
	return cardIntegrationDAO.debitCardTypeLookupCount(criteria);
    }
    
    
    public List debitCardTypeLookupRecs(CardIntegrationSC criteria) throws BaseException
    {
	return cardIntegrationDAO.debitCardTypeLookupRecs(criteria);
    }
    
    
    
    
  

    
    
    
    
    
    
    
    
    
    
    public CardIntegrationDAO getCardIntegrationDAO()
    {
        return cardIntegrationDAO;
    }
    public void setCardIntegrationDAO(CardIntegrationDAO cardIntegrationDAO)
    {
        this.cardIntegrationDAO = cardIntegrationDAO;
    }

}