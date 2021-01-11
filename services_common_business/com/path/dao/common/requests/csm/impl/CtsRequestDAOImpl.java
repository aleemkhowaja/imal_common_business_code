/**
 * 
 */
package com.path.dao.common.requests.csm.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.common.requests.csm.CtsRequestDAO;
import com.path.dbmaps.vo.CTS_REQUEST_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.requests.csm.CtsRequestCO;
import com.path.vo.common.requests.csm.CtsRequestSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          CtsRequestDAOImpl.java used to
 */
public class CtsRequestDAOImpl extends BaseDAO implements CtsRequestDAO
{

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.dao.core.ctsrequest.CtsRequestDAO#ctsRequestById(com.path.vo
     * .core.ctsrequest.CtsRequestSC)
     */
    @Override
    public CTS_REQUEST_TYPEVO returnCtsRequestTypeById(CtsRequestSC criteria) throws DAOException
    {
	return (CTS_REQUEST_TYPEVO) getSqlMap().queryForObject("ctsRequestMapper.ctsRequestTypeById", criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.dao.core.ctsrequest.CtsRequestDAO#ctsRequestList(com.path.vo
     * .core.ctsrequest.CtsRequestSC)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<CTS_REQUEST_TYPEVO> returnCtsRequestTypeList(CtsRequestSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTS_REQUEST_TYPE.BaseResultMap");
	if(criteria.getNbRec() == -1)
	{
	    return (List<CTS_REQUEST_TYPEVO>) getSqlMap().queryForList("ctsRequestMapper.ctsRequestTypeList", criteria);
	}
	else
	{
	    return (List<CTS_REQUEST_TYPEVO>) getSqlMap().queryForList("ctsRequestMapper.ctsRequestTypeList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.path.dao.core.ctsrequest.CtsRequestDAO#ctsRequestListCount(com.path
     * .vo.core.ctsrequest.CtsRequestSC)
     */
    @Override
    public int returnCtsRequestTypeListCount(CtsRequestSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTS_REQUEST_TYPE.BaseResultMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("ctsRequestMapper.ctsRequestTypeListCount", criteria)).intValue();
	return nb;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CtsRequestCO> returnCtsRequestList(CtsRequestSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctsRequestMapper.ctsRequestList_ResMap");
	if(criteria.getNbRec() == -1)
	{
	    return (List<CtsRequestCO>) getSqlMap().queryForList("ctsRequestMapper.ctsRequestList", criteria);
	}
	else
	{
	    return (List<CtsRequestCO>) getSqlMap().queryForList("ctsRequestMapper.ctsRequestList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public int returnCtsRequestListCount(CtsRequestSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "ctsRequestMapper.ctsRequestList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("ctsRequestMapper.ctsRequestListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public BigDecimal returnLastTrsNbrFromCtsCtr(CtsRequestSC criteria) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("ctsRequestMapper.returnLastTrsNbrFromCtsCtr", criteria);
    }

    @Override
    public BigDecimal returnCtsRequestTypeCodeByReference(CtsRequestSC criteria) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("ctsRequestMapper.returnCtsRequestTypeCode", criteria);
    }

    /**
     * return list of cts requestInfo Charges
     */
    public CtsRequestCO returnCtsRqstInfoChargesDet(CtsRequestSC criteria) throws DAOException
    {
	//filter by CHARGE_CODE > 0, because when it is negative mean it is related to TVA
	return (CtsRequestCO)getSqlMap().queryForObject("ctsRequestMapper.returnCtsRqstInfoChargesDet", criteria);
    }
    /**
     * 
     * @author: jihadlamaa
     * @date: Mar 4, 2015
     * @PB:
     * @param criteria
     * @return
     * @throws DAOException
     */
    public Integer deleteRequestChargesDetails(CtsRequestSC criteria) throws DAOException
    {
        return getSqlMap().update("ctsRequestMapper.deleteRequestChargesDetails", criteria);
    }

}
