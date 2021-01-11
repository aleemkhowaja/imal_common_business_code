package com.path.dao.core.entitycharges.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.core.entitycharges.EntityChargesDAO;
import com.path.lib.common.base.BaseDAO;
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
public class EntityChargesDAOImpl extends BaseDAO implements EntityChargesDAO
{
    /**
     * Deletes the Entity Charges related to a certain Entity
     * 
     * @param entityChargesCO
     * @return
     * @throws DAOException
     */
    public void deleteEntityCharges(EntityChargesCO entityChargesCO) throws DAOException
    {
	getSqlMap().delete("entityChargesMapper.deleteEntityCharges", entityChargesCO);
    }
    
    /**
     * returns data from CTSCHARGES and CTSCHARGES_CURRENCY
     * 
     * @param entityChargesCO
     * @return
     * @throws DAOException
     */
    public EntityChargesSC returnChargesWithChargesCurrency(EntityChargesCO entityChargesCO) throws DAOException
    {	
	return (EntityChargesSC)getSqlMap().queryForObject("entityChargesMapper.returnChargesWithChargesCurrency", entityChargesCO);
    }
    
    public BigDecimal returnCountCharges(EntityChargesCO entityChargesCO) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.returnCountCharges", entityChargesCO));
    }
    
    /**
     * returns list of charges schema charge codes from CTSCHARGES_SCHEMA
     * 
     * @param entityChargesCO
     * @return entityChargesCO
     * @throws DAOException
     */
    public List<BigDecimal> retrieveChargesSchema(EntityChargesCO entityChargesCO) throws DAOException
    {
	List<BigDecimal> i = null;

	try
	{
	    i = (List) getSqlMap().queryForList("entityChargesMapper.retrieveChargesSchema", entityChargesCO);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}

	return i;
	
    }
    
    public List<CtsChargesEntityCO> retrieveCtsChargesEntityCOList(EntityChargesCO entityChargesCO)throws DAOException
    {        		
    	return getSqlMap().queryForList("entityChargesMapper.retrieveCtsChargesEntityCOList", entityChargesCO);
    }
    
    public List<CtsChargesEntityCO> retrieveReqChargesEntityCOList(EntityChargesCO entityChargesCO)throws DAOException
    {        		
	return getSqlMap().queryForList("entityChargesMapper.retrieveReqChargesEntityCOList", entityChargesCO);
    }
    
    /**
     * returns a count of charges in the charge schema that correspond to all Charges
     * 
     * @param entityChargesSC
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal retrieveCountChargesSchema(EntityChargesSC entityChargesSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.retrieveCountChargesSchema", entityChargesSC));
    }

    /**
     * returns a count of charges in the charge schema that correspond to VAT Charges
     * 
     * @param entityChargesSC
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal retrieveCountChargesSchemaVAT(EntityChargesSC entityChargesSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.retrieveCountChargesSchemaVAT", entityChargesSC));
    }

    /**
     * This function returns the sum of AMOUNT_FC related to a specified entity.
     * @author nabilfeghali
     * @param entityChargesSC
     * @return
     * @throws DAOException
     */
    public BigDecimal retrieveSumOfChargesAmountFc(EntityChargesCO entityChargesCO) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.retrieveSumOfChargesAmountFc", entityChargesCO));
    }
    
    /**
     * Retrieves the sum of CV and FC Amounts of charges of a certain Entity
     * @author Reda Charabaty
     * @param entityChargesCO
     * @return
     * @throws DAOException
     */
    public EntityChargesCO retrieveSumsOfChargesAmount(EntityChargesCO entityChargesCO) throws DAOException
    {	
	EntityChargesCO returnEntityChargesCO = (EntityChargesCO)getSqlMap().queryForObject("entityChargesMapper.retrieveSumsOfChargesAmount", entityChargesCO);
	
	entityChargesCO.setTotalAllAmount(returnEntityChargesCO.getTotalAllAmount());
	entityChargesCO.setTotalAllAmountFc(returnEntityChargesCO.getTotalAllAmountFc());
	
	return entityChargesCO;
    }
    
    /**
     * returns a count of charges in the charge schema that correspond to all Charges without join to CTSCHARGES
     * 
     * @param entityChargesSC
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal retrieveCountAllChargesSchema(EntityChargesSC entityChargesSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.retrieveCountAllChargesSchema", entityChargesSC));
    }
    
    /**
     * This function will delete the content of CTSTRS_ACC_DET_TMP by compCode, branchCode and tellerCode
     */
    public int deleteCTSTRS_ACC_DET_TMP(TrxMgntSC trxMgntSC) throws DAOException
    {
	return getSqlMap().delete("entityChargesMapper.deleteCtsTrsAccDetTmp", trxMgntSC);
    }
    
    /**
     * Updates INSTRUCTIONS1 and REFERENCE1 columns of CTSTRS
     * 
     * @param trxMgntSC
     * @return int
     * @throws DAOException
     */
    public int updateCTSTRSEntityInfo(TrxMgntSC trxMgntSC) throws DAOException
    {
	return getSqlMap().update("entityChargesMapper.updateCTSTRSEntityInfo", trxMgntSC);
    }

    /**
     * returns a count of charges that are not exempted in logged in branch or account branch
     * 
     * @param entityChargesSC
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal retrieveCountNonExemptedCharges(EntityChargesSC entityChargesSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.retrieveCountNonExemptedCharges", entityChargesSC));
    }

    /**
     * waiveEntityCharges
     */
    public int waiveEntityCharges(EntityChargesCO entityChargesCO) throws DAOException
    {
	return getSqlMap().update("entityChargesMapper.waiveEntityCharges", entityChargesCO);
	
    }
    
    /**
     * returns a count of charges that are not found in the Currency Charge table
     * 
     * @param entityChargesSC
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal checkNonexistingChargesByCurrency(EntityChargesSC entityChargesSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.checkNonexistingChargesByCurrency", entityChargesSC));
    }
    
    /**
     * Updates CREATED_BY column of CTSTRS
     * 
     * @param trxMgntSC
     * @return int
     * @throws DAOException
     */
    public int updateCTSTRSCreatedBy(TrxMgntSC trxMgntSC) throws DAOException
    {
	return getSqlMap().update("entityChargesMapper.updateCTSTRSCreatedBy", trxMgntSC);
    }
    
    public int updateDOFCreatedBy(TrxMgntSC trxMgntSC) throws DAOException
    {
	return getSqlMap().update("entityChargesMapper.updateDOFCreatedBy", trxMgntSC);
    }    
    
    public BigDecimal returnCountAccountLimits(EntityChargesSC entityChargesSC) throws DAOException
    {
	return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.returnCountAccountLimits", entityChargesSC));
    }
    
    public BigDecimal returnCountLostFound(EntityChargesCO entityChargesCO) throws DAOException
    {
       return ((BigDecimal) getSqlMap().queryForObject("entityChargesMapper.returnCountLostFound", entityChargesCO));
    }
}