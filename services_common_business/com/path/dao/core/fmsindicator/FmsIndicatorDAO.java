package com.path.dao.core.fmsindicator;

import java.util.List;

import com.path.dbmaps.vo.FMSINDICATORVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.fmsindicator.FmsIndicatorSC;

public interface FmsIndicatorDAO
{
    public int fmsIndicatorListCount(FmsIndicatorSC criteria) throws DAOException;
    public List fmsIndicatorList(FmsIndicatorSC criteria) throws DAOException;
    public FMSINDICATORVO returnFmsIndicatorNameById(FmsIndicatorSC criteria) throws DAOException;
    
    public int fmsCustomerIndicatorListCount(FmsIndicatorSC criteria) throws DAOException;
    public List fmsCustomerIndicatorList(FmsIndicatorSC criteria) throws DAOException;
    public FMSINDICATORVO returnFmsCustomerIndicatorNameById(FmsIndicatorSC criteria) throws DAOException;
}

