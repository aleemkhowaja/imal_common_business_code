package com.path.bo.common.swift.swiftreconciliation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconBankStmtCO;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconcileCO;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconcileSC;


/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Elias Farah
 * 
 *          SwiftReconBO.java used to process reconciliation Swift Message
 */
public interface SwiftReconBO
{
    public ArrayList<SwiftReconcileCO> selectFile(String sInputFile, String sLanguage, BigDecimal bdCompCode, BigDecimal bdBaseCy, String sUserId,
	    Date dtSysDate, int iEngFlag) throws BaseException;
    
    public ArrayList<SwiftReconBankStmtCO> selectBankStmtReconcile(BigDecimal bdCompCode, String sVtFlag, ArrayList<SwiftReconcileCO> swiftReconcileCOList, String sLanguage)
    throws BaseException;
    
    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalT(SwiftReconcileSC swiftReconcileSC) throws BaseException;

    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalV(SwiftReconcileSC swiftReconcileSC) throws BaseException;
    
    public ArrayList<SwiftReconcileCO> reconcile(ArrayList<SwiftReconcileCO> swiftReconcileCOList,
	    ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOList, String fullMatchCond,
	    String[] partialMatchCondList, String[] reasonList, String sUserId, Date dtRunDate, String sAppName, String sPageRef)
	    throws BaseException;  

    public int saveRecon(ArrayList<SwiftReconcileCO> swiftReconcileCOList) throws BaseException;
    
    public SwiftReconcileCO returnConditions() throws BaseException;
}
