package com.path.dao.common.swift;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconBankStmtCO;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconcileSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: OliviaGhazal
 * 
 *          SwiftReconDAO.java used to access the database for reconciliation
 *          process
 */

public interface SwiftReconDAO
{
    public BigDecimal selectCurrencyDecimalPoints(CURRENCIESVO currenciesVO, String sExtract) throws DAOException;

    public AMFVO selectAccountNoDet(SwiftReconcileSC swiftReconcileSC) throws DAOException;

    public ArrayList<SwiftReconBankStmtCO> selectBankStmtReconcile(SwiftReconcileSC swiftReconcileSC)
	    throws DAOException;

    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalT(SwiftReconcileSC swiftReconcileSC) throws DAOException;

    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalV(SwiftReconcileSC swiftReconcileSC) throws DAOException;
}
