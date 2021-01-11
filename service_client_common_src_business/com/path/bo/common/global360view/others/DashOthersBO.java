/**
 * 
 */
package com.path.bo.common.global360view.others;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashOthersCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashChequesServicesBO.java used to
 */
public interface DashOthersBO
{
    public int remittancesListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> remittancesList(DashboardSC criteria) throws BaseException;
    
    public int specialCondAccListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> specialCondAccList(DashboardSC criteria) throws BaseException;
    
    public int specialCondCifListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> specialCondCifList(DashboardSC criteria) throws BaseException;
    
    public int authorizedSigListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> authorizedSigList(DashboardSC criteria) throws BaseException;
    
    public int linksCifCifListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> linksCifCifList(DashboardSC criteria) throws BaseException;
    
    public int linksAccAccListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> linksAccAccList(DashboardSC criteria) throws BaseException;

    public int linksAccCifListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> linksAccCifList(DashboardSC criteria) throws BaseException;

    public int linksCifAccListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> linksCifAccList(DashboardSC criteria) throws BaseException;
    
    public int soListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> soList(DashboardSC criteria) throws BaseException;
    
    public DashOthersCO returnLinksExistanceQueryList(DashboardSC criteria) throws BaseException;
    
    public int memosListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> memosList(DashboardSC criteria) throws BaseException;
    
    
    public int childCifListCount(DashboardSC criteria) throws BaseException;
    public List<DashOthersCO> childCifList(DashboardSC criteria) throws BaseException;

}
