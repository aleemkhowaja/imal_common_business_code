/**
 * @Auther:Reda Charabaty
 * @Date:01/10/2012
 * @Team:CSM Java Team.
 * @copyright: PathSolution 2012
 */

package com.path.bo.core.entitycharges;


import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSTRS_CHARGES_DETVO;
import com.path.dbmaps.vo.CTS_CHARGES_ENTITYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.entitycharges.EntityChargesSC;
import com.path.vo.core.entitycharges.CtsChargesEntityCO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public interface EntityChargesBO
{
    public EntityChargesCO dependencyByAMT(EntityChargesCO entityChargesCO) throws BaseException;
    public void updateCharges(EntityChargesCO entityChargesCO, String update) throws BaseException;
    public EntityChargesCO fillChargesDetails(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesSC returnChargesWithChargesCurrency(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO selectCharges(EntityChargesCO entityChargesCO) throws BaseException;
    public List<BigDecimal> selectChargesSchemaList(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO setChargeAcc(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO setChargeSchema(EntityChargesCO entityChargesCO) throws BaseException;
    public Boolean checkExemptedCharges(EntityChargesCO entityChargesCO, BigDecimal chargeCode) throws BaseException;
    public EntityChargesCO retrieveTotalCharges(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO fillTypeInd(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO retrieveVatChargesDetails(EntityChargesCO entityChargesCO) throws BaseException;
    public BigDecimal retrieveExchRate(EntityChargesCO entityChargesCO) throws BaseException;
    public CTSCHARGESVO retrieveChargesInfo(BigDecimal compCode, BigDecimal chargeCode) throws BaseException;
    public TrxMgntChargesSC retrieveChargesDetails(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntSC retrieveVATDetails(TrxMgntSC trxMgntSC) throws BaseException;
    public BigDecimal retrieveEntityCount(EntityChargesCO entityChargesCO) throws BaseException;
    public BigDecimal returnCountCharges(EntityChargesCO entityChargesCO) throws BaseException;
    public List<CtsChargesEntityCO> retrieveCtsChargesEntityCOList(EntityChargesCO entityChargesCO)throws BaseException;
    public void deleteEntityCharges(EntityChargesCO entityChargesCO) throws BaseException;
    public BigDecimal calculateExchangedAmount(EntityChargesCO entityChargesCO, BigDecimal amount) throws BaseException;
    public BigDecimal retrieveCountChargesSchema(EntityChargesSC entityChargesSC) throws BaseException;
    public BigDecimal retrieveCountChargesSchemaVAT(EntityChargesSC entityChargesSC) throws BaseException;
    public BigDecimal retrieveSumOfChargesAmountFc(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO retrieveSumsOfChargesAmount(EntityChargesCO entityChargesCO) throws BaseException;
    public TrxMgntSC openChargeTrx(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO) throws BaseException;
    public int checkMultiTrxCompatibility(EntityChargesCO entityChargesCO) throws BaseException;
    public BigDecimal retrieveCountAllChargesSchema(EntityChargesSC entityChargesSC) throws BaseException;
    public EntityChargesCO calculateChargeCurrencyDecimalPoints(EntityChargesCO entityChargesCO) throws BaseException;
    public TrxMgntCO calculateTellerAccount(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO calculateCharges(EntityChargesCO entityChargesCO, EntityChargesSC entityChargesSC) throws BaseException;
    public EntityChargesCO waiveCharges(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO waiveEntityCharges(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO callCalculateCharges(EntityChargesCO entityChargesCO ,String lang, BigDecimal compCode, BigDecimal branchCode, String typeInd, String entityType, BigDecimal entityCode) throws BaseException;
    public List<String> fillReturnMessage(TrxMgntSC trxMgntSC) throws BaseException;
    public void fillMultiTransferDetails(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO) throws BaseException;
    public TrxMgntCO calculateMultiTransfer(TrxMgntCO trxMgntCO) throws BaseException;
    public void processMultiTransfer(TrxMgntCO trxMgntCO) throws BaseException;
    public TrxMgntCO prepareEntityMultiTransferData(EntityChargesCO entityChargesCO) throws BaseException;
    public BigDecimal returnAvailableBalance(EntityChargesCO entityChargesCO) throws BaseException;
    public TrxMgntCO calculateFromToAccounts(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO checkAmountExceedsAvailableBalance(EntityChargesCO entityChargesCO) throws BaseException;
    public AMFVO chooseChargeAccount(EntityChargesCO entityChargesCO) throws BaseException;
    public int checkAllowOverdraw(EntityChargesCO entityChargesCO) throws BaseException;
    public TrxMgntSC reverseChargeTrx(TrxMgntSC trxMgntSC) throws BaseException;
    public void updateCTSTRSEntityInfo(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkAmountRestriction(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO calculateUnifiedCharges(EntityChargesCO entityChargesCO) throws BaseException;
    public BigDecimal returnTrsCurrency(TrxMgntCO trxMgntCO) throws BaseException;
    public EntityChargesCO returnChargesData(TrxMgntCO trxMgntCO, EntityChargesCO entityChargesCO1) throws BaseException;
    public CTS_CHARGES_ENTITYVO copyFromTrxChargeToEntity(CTSTRS_CHARGES_DETVO ctstrsChargesDetVO, CTS_CHARGES_ENTITYVO ctsChargesEntity1VO) throws BaseException;
    public BigDecimal retrieveCountNonExemptedCharges(EntityChargesSC entityChargesSC) throws BaseException;
    public EntityChargesCO checkNonexistingChargesByCurrency(EntityChargesCO entityChargesCO) throws BaseException;
    public void updateCTSTRSCreatedBy(TrxMgntSC trxMgntSC) throws BaseException;
    public EntityChargesCO returnProductCharges(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public BigDecimal cardsCurrency(EntityChargesCO entityChargesCO) throws BaseException;
    public EntityChargesCO calculateUnifiedChargesHash(EntityChargesCO entityChargesCO) throws BaseException;
    public int checkAccountExemptedFromVAT(EntityChargesCO entityChargesCO) throws BaseException;
    public BigDecimal returnCountLostFound(EntityChargesCO entityChargesCO) throws BaseException;
  
}
