/**
 * 
 */
package com.path.bo.common.global360view.cheques.impl;

import java.util.List;

import com.path.bo.common.global360view.cheques.DashChequesServicesBO;
import com.path.dao.common.global360view.cheques.DashChequesServicesDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashChequesServicesCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashChequesServicesBOImpl.java used to
 */
public class DashChequesServicesBOImpl extends BaseBO implements DashChequesServicesBO
{
    private DashChequesServicesDAO dashChequesServicesDAO;
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int voidedChequesListCount(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.voidedChequesListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> voidedChequesList(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.voidedChequesList(criteria);
    }
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int chequesForColListCount(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.chequesForColListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> chequesForColList(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.chequesForColList(criteria);
    }
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int postDatedChqWDrawalListCount(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.postDatedChqWDrawalListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> postDatedChqWDrawalList(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.postDatedChqWDrawalList(criteria);
    }
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int postDatedChqDepListCount(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.postDatedChqDepListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashChequesServicesCO> postDatedChqDepList(DashboardSC criteria) throws BaseException
    {
  	return dashChequesServicesDAO.postDatedChqDepList(criteria);
    }

    /**
     * @return the dashChequesServicesDAO
     */
    public DashChequesServicesDAO getDashChequesServicesDAO()
    {
        return dashChequesServicesDAO;
    }

    /**
     * @param dashChequesServicesDAO the dashChequesServicesDAO to set
     */
    public void setDashChequesServicesDAO(DashChequesServicesDAO dashChequesServicesDAO)
    {
        this.dashChequesServicesDAO = dashChequesServicesDAO;
    }

}
