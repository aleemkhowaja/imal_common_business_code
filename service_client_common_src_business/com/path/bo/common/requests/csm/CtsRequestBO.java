/**
 * 
 */
package com.path.bo.common.requests.csm;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTS_REQUESTVO;
import com.path.dbmaps.vo.CTS_REQUEST_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.requests.csm.CtsRequestCO;
import com.path.vo.common.requests.csm.CtsRequestSC;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          CtsRequest.java used to
 */
public interface CtsRequestBO
{
    public int returnCtsRequestTypeListCount(CtsRequestSC criteria) throws BaseException;

    public List<CTS_REQUEST_TYPEVO> returnCtsRequestTypeList(CtsRequestSC criteria) throws BaseException;

    public CTS_REQUEST_TYPEVO returnCtsRequestTypeById(CtsRequestSC criteria) throws BaseException;

    public int returnCtsRequestListCount(CtsRequestSC criteria) throws BaseException;

    public List<CtsRequestCO> returnCtsRequestList(CtsRequestSC criteria) throws BaseException;

    public BigDecimal returnCtsctrCounter(BigDecimal companyCode, BigDecimal branchCode, String trsType, String cbInd)
	    throws BaseException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public BigDecimal returnCtsRequestTypeCodeByReference(CtsRequestSC criteria) throws BaseException;

    public List<StatusCO> generateRequestStatusList(Object obj, List<String> colList, SelectSC lovCriteria)
	    throws BaseException;

    public CtsRequestCO dependencyByPaymentType(CtsRequestCO ctsRequestCO) throws BaseException;

    public CtsRequestCO returnCtsRqstInfoChargesDet(CtsRequestCO ctsRequestCO) throws BaseException;
    
    public CtsRequestCO returnCtsRqstInfoChargesDet(CtsRequestSC criteria) throws BaseException;
    /**
     * added to delete csm char
     * @author: jihadlamaa
     * @date: Mar 4, 2015
     * @PB:
     * @param criteria
     * @return
     * @throws BaseException
     */
    public Integer deleteRequestChargesDetails(CtsRequestSC criteria) throws BaseException;
    
    CTS_REQUESTVO returnCtsRequestData(CTS_REQUESTVO criteria) throws BaseException;

    public CtsRequestCO dependencyByExpiryDate(CtsRequestCO ctsRequestCO) throws BaseException;

    public CtsRequestCO dependencyAccGl(CtsRequestCO ctsRequestCO) throws BaseException;

    public CtsRequestCO dependencyAccCurrency(CtsRequestCO ctsRequestCO) throws BaseException;

    public CtsRequestCO dependencyAccBranch(CtsRequestCO ctsRequestCO) throws BaseException;

}
