/**
 * 
 */
package com.path.dao.common.requests.csm;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTS_REQUEST_TYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.requests.csm.CtsRequestCO;
import com.path.vo.common.requests.csm.CtsRequestSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          CtsRequestDAO.java used to
 */
public interface CtsRequestDAO
{
    public int returnCtsRequestTypeListCount(CtsRequestSC criteria) throws DAOException;

    public List<CTS_REQUEST_TYPEVO> returnCtsRequestTypeList(CtsRequestSC criteria) throws DAOException;

    public CTS_REQUEST_TYPEVO returnCtsRequestTypeById(CtsRequestSC criteria) throws DAOException;

    public int returnCtsRequestListCount(CtsRequestSC criteria) throws DAOException;

    public List<CtsRequestCO> returnCtsRequestList(CtsRequestSC criteria) throws DAOException;

    public BigDecimal returnLastTrsNbrFromCtsCtr(CtsRequestSC criteria) throws DAOException;

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public BigDecimal returnCtsRequestTypeCodeByReference(CtsRequestSC criteria) throws DAOException;

    public CtsRequestCO returnCtsRqstInfoChargesDet(CtsRequestSC ctsRequestSC) throws DAOException;
    /**
     * used ti delete request charge dtails
     * @author: jihadlamaa
     * @date: Jan 23, 2015
     * @PB:
     * @param criteria
     * @return
     * @throws DAOException
     */
    public Integer deleteRequestChargesDetails(CtsRequestSC criteria) throws DAOException;
}
