package com.path.bo.core.cardintegration;

import java.util.List;

import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cardintegration.CardIntegrationSC;

public interface CardIntegrationBO
{
    
    
    
    

    
    public int debitCardTypeLookupCount(CardIntegrationSC criteria) throws BaseException;

    public List<CTSCARDSVO> debitCardTypeLookupRecs(CardIntegrationSC criteria)throws BaseException;

    
    } 
