/**
 *
 */
package com.path.bo.core.common;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DETVO;
import com.path.dbmaps.vo.CTSTRS_CHARGES_DETVO;
import com.path.dbmaps.vo.CTS_CHARGES_UNIFIEDVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxmgnt.WithholdingSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 *
 * @author: nabilfeghali
 *
 * CoreCommonChargesBO.java used to
 */
public interface CoreCommonChargesBO
{
    public TrxMgntChargesSC returnChargeAcc(TrxMgntChargesSC trxMgntChargesSC, TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal selectChargeBr(TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal selectChargeCy(TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal selectChargeSchema(TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal returnCIFNumber(TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal checkInternalGL(BigDecimal compCode, BigDecimal glCode) throws BaseException;
    public BigDecimal returnChargeSchema(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public List<BigDecimal> retrieveChargesSchemaLine(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public List<BigDecimal> retrieveSeparateChargesSchema(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntCO returnCurrenciesDecimalPoints(TrxMgntCO trxMgntCO) throws BaseException;
    public TrxMgntChargesSC retrieveChargesDetails(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntCO retrieveVatChargesDetails(TrxMgntCO trxMgntCO) throws BaseException;
    public TrxMgntSC retrieveVATDetails(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntCO returnFormatAmounts(TrxMgntCO trxMgntCO) throws BaseException;
    public TrxMgntCO retrieveTotalCharges(TrxMgntCO trxMgntCO) throws BaseException;
    public TrxMgntCO selectUnifiedCharges(TrxMgntCO trxMgntCO) throws BaseException;
    public TrxMgntCO retrieveTempChargeData(TrxMgntCO trxMgntCO) throws BaseException;
    public void emptyCharges(BigDecimal compCode, BigDecimal barnchCode, BigDecimal sessionID, String actionType, BigDecimal batchNo) throws BaseException;
    public List<CTS_CHARGES_UNIFIEDVO> retrieveCtsChargesUnifiedList(TrxMgntSC trxMgntSC) throws BaseException;
    public CTSTRS_CHARGES_DETVO copyChargesToVO(CTS_CHARGES_UNIFIEDVO retrievedCtsChargesUnified, CTSTRS_CHARGES_DETVO ctstrsChargesDetVO) throws BaseException;
    public CTS_CHARGES_UNIFIEDVO fillFirstChargeLine(TrxMgntCO trxMgntCO) throws BaseException;
    public void removeFirstChargeLine(TrxMgntCO trxMgntCO) throws BaseException;
    public Boolean proceedWithCalculation(TrxMgntCO trxMgntCO) throws BaseException;
    public void removeUselessData(TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal calculateSessionID() throws BaseException;
    public String calculateProductType(TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal calculateEntityTypeCode(TrxMgntCO trxMgntCO) throws BaseException;
    public TrxMgntCO calculateTotalCharges(TrxMgntCO trxMgntCO) throws BaseException;
    public List<CTSCHARGESVO> retrieveChargeAccounts(TrxMgntSC trxMgntSC) throws BaseException;
    public List<CTSTRS_ACC_DETVO> retrieveBatchChargeAccounts(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntCO fillBatchMultiAccounts(TrxMgntCO trxMgntCO) throws BaseException;
    public BigDecimal retrievePMSCifNo(TrxMgntCO trxMgntCO) throws BaseException;
    public WithholdingSC processWithholding(WithholdingSC withholdingSC) throws BaseException;
    public TrxMgntCO CalculateNewGainLossCharge(TrxMgntCO argTrxMgntCO)  throws BaseException;
}
