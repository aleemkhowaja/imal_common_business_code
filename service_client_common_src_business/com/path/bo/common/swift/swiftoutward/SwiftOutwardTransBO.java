package com.path.bo.common.swift.swiftoutward;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.dynfiles.DynFilesColumnCO;
import com.path.vo.common.swift.swiftoutward.SwiftCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: CharbelObeidi
 *
 * SwiftOutwardTransBO.java used to retrieve data related to Swift Outward Engine
 */
public interface SwiftOutwardTransBO
{
    /*public Integer processSwiftBySchedRep(String sModule, BigDecimal bdRepId, String sRepTitle, String sApplication, String sRepObj, 
	           BigDecimal bdPeriod, String sPeriodType, BigDecimal bdPeriodDay, String sSchedTime, BigDecimal bdCompCode, BigDecimal bdStatAcc, 
		   Date dtNextReplDate, BigDecimal bdSchedId, BigDecimal bdBaseCy, BigDecimal bdBranchFrom, BigDecimal bdBranchTo,
		   BigDecimal bdCyFrom, BigDecimal bdCyTo, BigDecimal bdGlFrom, BigDecimal bdGlTo, BigDecimal bdCifFrom, BigDecimal bdCifTo, 
		   BigDecimal bdSlFrom, BigDecimal bdSlTo, BigDecimal bdCifReceiver, String sMsgCode, BigDecimal bdGenerateMsg,
		   Date dtDbServerDateTime, String sSwiftFile, BigDecimal bdPerformance, String sDateFrom, String sDateTo, 
		   BigDecimal bdTransFrom, BigDecimal bdTransTo, String sLanguage, BigDecimal bdBranchCode, String sUserId, 
		   SWIFT_TRS_LOGVO swiftTrsLogVO, SWIFT_DWSCHEDVO swiftDwSchedVO, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC) throws BaseException;*/
    
    public BigDecimal  updateSwiftTrxNo(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, String isSetSwiftTrxNoToNull, String sUpdateStmt, int sqlRowCount, int SqlColSize, String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    public void updateStmtNbr(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, String sUpdateStmt, int sqlRowCount, int SqlColSize, String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    public Integer createMessage(int iProcessInd, ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount, int SqlColSize, BigDecimal bdCompCode, String sSkipCond, String sErrorCond, String sSwiftFile, char cPreviewSwiftMsg, char cGenMode, String sApplication, SwiftCO swftCO, String sLanguage, BigDecimal bdRepId, String sRepTitle, SwiftOutwardSC swiftOutwardSC, ArrayList<Map<String, Object>> aListMapSqlRep, BigDecimal swiftTrxNo) throws BaseException;
    
    public void markAsGeneratedByTrx(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount, 
	    int sqlColSize, BigDecimal bdCompCode,  BigDecimal bdRepId,  String sRepTitle,
	    String sLanguage,  SwiftOutwardSC swiftOutwardSC  ) throws BaseException;

	public BigDecimal ReturnGenFileYnValue() throws BaseException;
}
