package com.path.dao.common.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.common.CoreCommonChargesDAO;
import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DETVO;
import com.path.dbmaps.vo.CTS_CHARGES_UNIFIEDVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * CoreCommonChargesDAOImpl.java used to
 */
public class CoreCommonChargesDAOImpl extends BaseDAO implements CoreCommonChargesDAO
{

    /**
     * 
     * @param trxMgntChargesCO
     * @return
     * @throws DAOException
     */
    public BigDecimal returnChargeSchema(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	BigDecimal nb;
	nb = new BigDecimal((Integer)getSqlMap().queryForObject("coreCommonChargesMapper.returnChargeSchema", trxMgntChargesSC));
	return nb;
	
    }
    
    public List<BigDecimal> retrieveSeparateChargesSchema(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	List<BigDecimal> i = null;
	
	try
	{
	    i = (List)getSqlMap().queryForList("coreCommonChargesMapper.retrieveSeparateChargesSchema", trxMgntChargesSC);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	
	return i;
    }
    
    public List<CTS_CHARGES_UNIFIEDVO> retrieveCtsChargesUnifiedList(TrxMgntSC trxMgntSC) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonChargesMapper.retrieveCtsChargesUnifiedList", trxMgntSC);
    }
    
    public void deleteCtsChargesUnified(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	getSqlMap().delete("coreCommonChargesMapper.deleteCtsChargesUnified", trxMgntChargesSC);
    }
    
    
    public List<CTSCHARGESVO> retrieveChargeAccounts(TrxMgntSC trxMgntSC) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonChargesMapper.retrieveChargeAccounts", trxMgntSC);
    }
    
    public List<CTSTRS_ACC_DETVO> retrieveBatchChargeAccounts(TrxMgntSC trxMgntSC) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonChargesMapper.retrieveBatchChargeAccounts", trxMgntSC);
    }
    
    public BigDecimal retrievePMSCifNo(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	BigDecimal nb;
	nb = new BigDecimal((Integer)getSqlMap().queryForObject("coreCommonChargesMapper.retrievePMSCifNo", trxMgntChargesSC));
	return nb;
	
    }
    
    public void deleteBatchCtsChargesUnified(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	getSqlMap().delete("coreCommonChargesMapper.deleteBatchCtsChargesUnified", trxMgntChargesSC);
    }
    

    public void insertHashCtsChargesUnified(CTS_CHARGES_UNIFIEDVO ctsChargesUnifiedVO) throws DAOException
    {
    getSqlMap().insert("coreCommonChargesMapper.insertHashCtsChargesUnified", ctsChargesUnifiedVO);
    }
}
