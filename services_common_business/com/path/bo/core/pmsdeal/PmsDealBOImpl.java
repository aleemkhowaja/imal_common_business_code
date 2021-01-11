/**
 * 
 */
package com.path.bo.core.pmsdeal;

import java.util.List;

import com.path.dao.core.pmsdeal.PmsDealDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.pmsdeal.PmsDealCO;
import com.path.vo.core.pmsdeal.PmsDealSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          PmsDealBOImpl.java used to
 */
public class PmsDealBOImpl extends BaseBO implements PmsDealBO
{
    private PmsDealDAO pmsDealDAO;

    @Override
    public List<PmsDealCO> pmsDealList(PmsDealSC criteria) throws BaseException
    {
	return pmsDealDAO.pmsDealList(criteria);
    }

    @Override
    public int pmsDealListCount(PmsDealSC criteria) throws BaseException
    {
	return pmsDealDAO.pmsDealListCount(criteria);
    }

    @Override
    public PmsDealCO returnDependencyByDealNo(PmsDealSC criteria) throws BaseException
    {
	return pmsDealDAO.returnDependencyByDealNo(criteria);
    }

    public PmsDealCO returnDealAndDealCyDetail(PmsDealSC criteria) throws BaseException
    {
	return pmsDealDAO.returnDealAndDealCyDetail(criteria);
    }

    /**
     * @return the pmsDealDAO
     */
    public PmsDealDAO getPmsDealDAO()
    {
	return pmsDealDAO;
    }

    /**
     * @param pmsDealDAO the pmsDealDAO to set
     */
    public void setPmsDealDAO(PmsDealDAO pmsDealDAO)
    {
	this.pmsDealDAO = pmsDealDAO;
    }

}
