package com.path.bo.core.fmsindicator;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.FMSINDICATORVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.fmsindicator.FmsIndicatorSC;

public interface FmsIndicatorBO
{
    public int fmsIndicatorListCount(FmsIndicatorSC criteria) throws BaseException;
    public List fmsIndicatorList(FmsIndicatorSC criteria) throws BaseException;
    public FMSINDICATORVO returnFmsIndicatorNameById(FmsIndicatorSC criteria) throws BaseException;
    public BigDecimal dependencyOfFmsGrossValue(FmsIndicatorSC criteria) throws BaseException;
    
    public int fmsCustomerIndicatorListCount(FmsIndicatorSC criteria) throws BaseException;
    public List fmsCustomerIndicatorList(FmsIndicatorSC criteria) throws BaseException;
    public FMSINDICATORVO returnFmsCustomerIndicatorNameById(FmsIndicatorSC criteria) throws BaseException;
}
