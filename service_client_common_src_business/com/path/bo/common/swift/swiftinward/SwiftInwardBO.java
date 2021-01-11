package com.path.bo.common.swift.swiftinward;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.path.dbmaps.vo.SWIFT_LOG_INVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardSC;
import com.path.vo.common.swift.swiftoutward.SwiftCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:MHMD ITANI,Elias Farah
 * 
 *          SwiftOutwardTransBO.java used to retrieve data related to Swift
 *          Outward Engine
 */
public interface SwiftInwardBO
{
    public Integer writeLogFile(BigDecimal bdCompCode, int iIndicator, String theSErrorMsg, String sLanguage,
	    SwiftInwardCO swiftInwardCO) throws BaseException;
    
    public ArrayList<SwiftInwardCO> readTextFile(String sFileLocation, String sLanguage, BigDecimal bdCompCode,
	    String ackNackSource) throws BaseException;

    public SwiftCO parseMessage(ArrayList<SwiftInwardCO> swiftInwardCO, String sMsgCode, Long lCtrMsg,
	    BigDecimal bdCompCode, BigDecimal bdBranchCode, String sUserId, Date dSysDate, BigDecimal bdAckMode,
	    String sSwiftMsgIn, String sMode, String sProcessed, Long lTrsNo, String sModule, String sMsgStatus,
	    String sLanguage, ArrayList<Map<String, Object>> aListMapSqlRep) throws BaseException;

    public ArrayList<Map<String, String>> loadInwardFiles(String ackNackFilesFlag, String sLanguag,BigDecimal bdCompCode)
    	    throws BaseException;//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter

    public void moveFile(String fileName, String ackNackFlag, String sLanguage,  BigDecimal bdCompCode) throws BaseException;//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter


    public ArrayList<SwiftInwardCO> saveAndReadTextFile(String SwiftMsgBlob, String sLanguage, BigDecimal bdCompCode)
	    throws BaseException;

    public int returnInwardSwiftLogGridCount(SwiftInwardSC swiftInwardSC)throws BaseException;
    
    public ArrayList<SWIFT_LOG_INVO> returnInwardSwiftLogGrid(SwiftInwardSC swiftInwardSC) throws BaseException;
    
    public int swenEngineProcessIn(String sLanguage,BigDecimal bdCompCode,BigDecimal bdBranchCode,String sUserId,BigDecimal bdBaseCurrency,Date dSysDate)throws BaseException;
    
    public void updateEngineServiceStatusIn(BigDecimal bdCompCode, String serviceName, int serviceStatus,
	    String sLanguage, SwiftInwardSC swiftInwardSC)throws BaseException;
    
    public void resetLog()throws BaseException;
    
    //efarah 07/04/2017 EWBI170270
    public void runThread(Long iRefreshRate, String language,
    		BigDecimal companyCode, BigDecimal branchCode, String userName,
    		SwiftInwardCO swiftInwardCO, BigDecimal bdBaseCurrency,Date dSysDate) throws BaseException;
    //efarah 07/04/2017 EWBI170270
    public void stopThread() throws BaseException;
    
    //efarah 07/04/2017 EWBI170270
    public Integer updateRefreshRate(BigDecimal bdRefRate,String serviceName) throws BaseException;
    public boolean checkIfFileDeletedFromRepository(String fileName,BigDecimal compCode) throws BaseException;
    
    //LBedrane - BMO180040 - TP#690676 - 12/07/2018 
   	public Integer returnValueOfEnableQueueYn()throws BaseException;
   	//LBedrane to fill the inward grid
   	public HashMap<String, Object> fillInwardQueueGrid() throws BaseException;
   	//LBedrane - BMO180040 - TP#690676 - 12/07/2018
   	public ArrayList<SwiftInwardCO> readMqFile(String fileNameParam, String language, BigDecimal companyCode)throws BaseException;
}
