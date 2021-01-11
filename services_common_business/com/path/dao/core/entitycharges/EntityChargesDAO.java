package com.path.dao.core.entitycharges;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.entitycharges.EntityChargesSC;
import com.path.vo.core.entitycharges.CtsChargesEntityCO;
import com.path.vo.core.entitycharges.EntityChargesCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Reda Charabaty
 *
 * 
 */
public interface EntityChargesDAO
{
    public void deleteEntityCharges(EntityChargesCO entityChargesCO) throws DAOException;
    public EntityChargesSC returnChargesWithChargesCurrency(EntityChargesCO entityChargesCO) throws DAOException;
    public BigDecimal returnCountCharges(EntityChargesCO entityChargesCO) throws DAOException;
    public List<BigDecimal> retrieveChargesSchema(EntityChargesCO entityChargesCO) throws DAOException;
    public List<CtsChargesEntityCO> retrieveCtsChargesEntityCOList(EntityChargesCO entityChargesCO)throws DAOException;
    public BigDecimal retrieveCountChargesSchemaVAT(EntityChargesSC entityChargesSC) throws DAOException;
    public BigDecimal retrieveCountChargesSchema(EntityChargesSC entityChargesSC) throws DAOException;
    public BigDecimal retrieveSumOfChargesAmountFc(EntityChargesCO entityChargesCO) throws DAOException;
    public EntityChargesCO retrieveSumsOfChargesAmount(EntityChargesCO entityChargesCO) throws DAOException;
    public BigDecimal retrieveCountAllChargesSchema(EntityChargesSC entityChargesSC) throws DAOException;
    public int deleteCTSTRS_ACC_DET_TMP(TrxMgntSC trxMgntSC) throws DAOException;
    public int updateCTSTRSEntityInfo(TrxMgntSC trxMgntSC) throws DAOException;
    public BigDecimal retrieveCountNonExemptedCharges(EntityChargesSC entityChargesSC) throws DAOException;
    public int waiveEntityCharges(EntityChargesCO entityChargesCO) throws DAOException;
    public BigDecimal checkNonexistingChargesByCurrency(EntityChargesSC entityChargesSC) throws DAOException;
    public List<CtsChargesEntityCO> retrieveReqChargesEntityCOList(EntityChargesCO entityChargesCO) throws DAOException;
    public int updateCTSTRSCreatedBy(TrxMgntSC trxMgntSC) throws DAOException;
    public int updateDOFCreatedBy(TrxMgntSC trxMgntSC) throws DAOException;
    public BigDecimal returnCountAccountLimits(EntityChargesSC entityChargesSC) throws DAOException;
    public BigDecimal returnCountLostFound(EntityChargesCO entityChargesCO) throws DAOException;
}
	