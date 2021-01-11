package com.path.dao.common.swift.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;

import com.path.dao.common.swift.SwiftReconDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconBankStmtCO;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconcileSC;

public class SwiftReconDAOImpl extends BaseDAO implements SwiftReconDAO
{
    public BigDecimal selectCurrencyDecimalPoints(CURRENCIESVO currenciesVO, String sExtract) throws DAOException
    {
	String cyName;
	cyName = sExtract.substring(7, 10).toUpperCase(Locale.ENGLISH);
	currenciesVO.setBRIEF_DESC_ENG(cyName);
	return (BigDecimal) getSqlMap().queryForObject("swiftReconMapper.selectCurrencyDecimalPoints", currenciesVO);
    }

    public AMFVO selectAccountNoDet (SwiftReconcileSC swiftReconcileSC) throws DAOException
    {     
       return (AMFVO) getSqlMap().queryForObject("swiftReconMapper.selectAccountNoDet", swiftReconcileSC);            
    } 
    
    public ArrayList<SwiftReconBankStmtCO> selectBankStmtReconcile(SwiftReconcileSC swiftReconcileSC)
	    throws DAOException
    {
	return (ArrayList<SwiftReconBankStmtCO>) getSqlMap().queryForList("swiftReconMapper.selectBankStmtReconcile",
		swiftReconcileSC);
    }

    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalT(SwiftReconcileSC swiftReconcileSC) throws DAOException
    {
	return (ArrayList<SwiftReconBankStmtCO>) getSqlMap().queryForList("swiftReconMapper.selectOpeningBalT",
		swiftReconcileSC);
    }
    
    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalV(SwiftReconcileSC swiftReconcileSC) throws DAOException
    {
	return (ArrayList<SwiftReconBankStmtCO>) getSqlMap().queryForList("swiftReconMapper.selectOpeningBalV",
		swiftReconcileSC);
    }

}
