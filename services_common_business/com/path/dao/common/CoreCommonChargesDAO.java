/**
 * 
 */
package com.path.dao.common;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DETVO;
import com.path.dbmaps.vo.CTS_CHARGES_UNIFIEDVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;


/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * CoreCommonChargesDAO.java used to
 */
public interface CoreCommonChargesDAO
{
    public BigDecimal returnChargeSchema(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    public List<BigDecimal> retrieveSeparateChargesSchema(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    public List<CTS_CHARGES_UNIFIEDVO> retrieveCtsChargesUnifiedList(TrxMgntSC trxMgntSC) throws DAOException;
    public void deleteCtsChargesUnified(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    public List<CTSCHARGESVO> retrieveChargeAccounts(TrxMgntSC trxMgntSC) throws DAOException;
    public List<CTSTRS_ACC_DETVO> retrieveBatchChargeAccounts(TrxMgntSC trxMgntSC) throws DAOException;
    public BigDecimal retrievePMSCifNo(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    public void deleteBatchCtsChargesUnified(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    public void insertHashCtsChargesUnified(CTS_CHARGES_UNIFIEDVO ctsChargesUnifiedVO) throws DAOException;
}
