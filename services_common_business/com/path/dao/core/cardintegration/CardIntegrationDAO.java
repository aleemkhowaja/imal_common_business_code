package  com.path.dao.core.cardintegration;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cardintegration.CardIntegrationSC;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Hussein Elhajj
 *
 * CardIntegrationDAO.java used to
 */
public interface CardIntegrationDAO
{

    public int debitCardTypeLookupCount(CardIntegrationSC criteria)throws DAOException;
    public List debitCardTypeLookupRecs(CardIntegrationSC criteria)throws DAOException;
  
    }
