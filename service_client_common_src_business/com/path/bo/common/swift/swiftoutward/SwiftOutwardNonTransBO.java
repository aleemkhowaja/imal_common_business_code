package com.path.bo.common.swift.swiftoutward;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dbmaps.vo.SWIFT_LOGVO;
import com.path.dbmaps.vo.SWIFT_PRINT_HDRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.dynfiles.DynFilesColumnCO;
import com.path.vo.common.swift.swiftoutward.SwiftCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;
import com.path.vo.common.swift.swiftoutward.SwiftRepListCO;
import com.path.vo.common.swift.swiftoutward.SwiftTrxListCO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: CharbelObeidi
 *
 * SwiftOutwardBO.java used to retrieve data related to Swift Outward Engine
 */
public interface SwiftOutwardNonTransBO
{
    public void initEngineBeforeStart(String sLanguage, BigDecimal bdCompanyCode, BigDecimal bdRefreshRate, SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    /**
     * The first method called by Swift Outward Engine to process the scheduled Swift reports
     * @param sLanguage
     * @param bdBranchCode
     * @param sUserId
     * @param swiftOutwardSC
     * @return
     * @throws BaseException
     */
    public Integer processScheduledSwiftReports(int iProcessInd, String sLanguage, BigDecimal bdCompanyCode, BigDecimal bdBranchCode, String sUserId, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC,long threadId) throws BaseException;

    /**
     * Generate Swift Message by Report
     * @param sModule
     * @param bdCompCode
     * @param bdBranchCode
     * @param bdTransFrom
     * @param bdTransTo
     * @param dtDateFrom
     * @param dtDateTo
     * @param sTrxStatus
     * @param sSwiftFile
     * @param dtDbServerDateTime
     * @param sUserId
     * @param bdRepId
     * @param sRepTitle
     * @param cGenMode
     * @param cPreviewSwiftMsg
     * @param sLanguage
     * @param swftCO
     * @param swiftOutwardSC
     * @param swftRepListCO
     * @return
     * @throws BaseException
     */
    public SwiftCO generateByReport(int iProcessInd, String sModule, BigDecimal bdCompCode, BigDecimal bdBranchCode, BigDecimal bdTransFrom, BigDecimal bdTransTo, 
		    Date dtDateFrom, Date dtDateTo, String sTrxStatus, String sSwiftFile, Date dtDbServerDateTime, String sUserId, BigDecimal bdRepId, 
		    String sRepTitle, char cGenMode, char cPreviewSwiftMsg, String sLanguage, String sApplication, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC, ArrayList<SwiftRepListCO> swftRepListCO,BigDecimal bdSwiftTrxNo) throws BaseException;

    /**
     * Fill the SQL input arguments sent as ?
     * @param currSQL
     * @param argValue
     * @param paramNo
     * @return
     * @throws BaseException
     */
    public StringBuffer fillSQLInputArgs(StringBuffer currSQL, String argValue, int paramNo) throws BaseException;
    
    /**
     * Method to write in Swift outward log file
     * @param bdCompCode
     * @param bdRepId
     * @param sRepTitle
     * @param iIndicator
     * @param cGenMode
     * @param sErrorMsg
     * @param sLanguage
     * @param swiftOutwardSC
     * @return
     * @throws BaseException
     */
    
    public String returnFileName(String sMsgCode, String sModule, BigDecimal bdTrxNbr, String sSwiftFile, Integer iGenCntr, BigDecimal bdBranchCode, String sFileExt, String sLanguage,BigDecimal bdCompCode) throws BaseException;//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
    
    public String returnFileNameMode2(String sMsgCode, String sModule, BigDecimal bdTrxNbr, String sSwiftFile,Integer iGenCntr, BigDecimal bdBranchCode, String theSFileExt, String sLanguage) throws BaseException;
    
    public Integer writeLogFile(BigDecimal bdCompCode, BigDecimal bdRepId, String sRepTitle, int iIndicator, char cGenMode, String sErrorMsg, String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    public void updateEngineServiceStatus(BigDecimal bdCompCode, String serviceName, int serviceStatus, String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    public Object returnColumnValue(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount, int SqlColSize, String ColumnName) throws BaseException;
    
    public void updateColumnValue(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount, int sqlColSize, String columnName, Object columnValue) throws BaseException;
    
    public String removeSpecialChar(String theSTagVal,BigDecimal includeArabic,String skipSpecialChars) throws BaseException;
    
    public String trimTag(String sTag) throws BaseException;
    
    public String changeFormat(String sVal) throws BaseException;
    
    public String returnTFSAdviceLCType(BigDecimal bdCompCode, BigDecimal bdBranchCode, BigDecimal bdTfsAdviceNo) throws BaseException;
    
    public SWIFT_PRINT_HDRVO returnPrintSwiftHdr(String sAppName, String sPageRef, String sLCAdviceType, SWIFT_PRINT_HDRVO swiftPrintHdrVO) throws BaseException;
    
    public SwiftCO previewSwiftMessage(String sTrsNo, String sProgRef, BigDecimal bdLoggedInBrCode, String sAppName, String sLanguage, String sUserId, SwiftCO swftCO) throws BaseException;
    
    public String returnPrintSwiftDetSQL(String sTrsNo, String sAppName, String sPageRef, String sLCAdviceType, String sTableName, String sLanguage) throws BaseException;
    
    public int fixNextReplDateTime(SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    public ArrayList<SWIFT_LOGVO> returnOutwardSwiftLogGrid(SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    public Integer returnOutwardSwiftLogGridCount(SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    //efarah 07/04/2017 EWBI170270
    public BigDecimal returnRefreshRate(String language,String serviceName) throws BaseException;
    
    public Integer returnServiceStatus(String sServiceName, String language) throws BaseException;
    
    //efarah 07/04/2017 EWBI170270
    public Integer updateRefreshRate(BigDecimal bdRefRate,String ServiceName) throws BaseException;
    
    public void resetLog() throws BaseException;
    
    public String wrapText(String sTagText, int iCharPerLine, int iNoOfLines) throws BaseException;

    public SwiftCO generateByTrx(int iProcessInd, ArrayList<SwiftTrxListCO> swftTrxListCO, BigDecimal bdCompCode,
	    BigDecimal bdBranchCode, String sSwiftFile, Date dtDbServerDateTime, String sUserId, BigDecimal bdRepId,
	    String sRepTitle, char cPreviewSwiftMsg, String sApplication, String sLanguage, SwiftCO swftCO,
	    SwiftOutwardSC theSwiftOutwardSC, ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, BigDecimal bdFromTrsNo, 
	    BigDecimal bdToTrsNo, Date bdFromTrsDate, Date bdToTrsDate)
	    throws BaseException;
    
 
    public void markAsGenerated(ArrayList<SwiftTrxListCO> swftTrxListCO, ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep,
		   BigDecimal bdCompCode, BigDecimal bdRepId,  String sRepTitle, String sLanguage,  
		   SwiftOutwardSC swiftOutwardSC  ) throws BaseException;

    public BigDecimal returnSwiftSeqValue() throws BaseException;	
    
    /**Convert from ArrayList<Hashmap> to Arraylist<Arraylist>
     *@param ArrayList<Hashmap>      
    */
    public ArrayList<ArrayList<DynFilesColumnCO>> convertFromAListHashMapToAListOfALists(ArrayList<Map<String, Object>> recordList);   

    public int insertIntoAccBalTmp(Date dtDateFrom, String sVT, BigDecimal bdBranchFrom, BigDecimal bdBranchTo,
	    BigDecimal bdCyFrom, BigDecimal bdCyTo, BigDecimal bdGlFrom, BigDecimal bdGlTo, BigDecimal bdCifFrom,
	    BigDecimal bdCifTo, BigDecimal bdSlFrom, BigDecimal bdSlTo, BigDecimal bdCompCode, BigDecimal bdBranchCode,
	    String userId, String sGvUserId, String sLanguage, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    public SwiftCO generateByReportSOA(int iProcessInd, BigDecimal bdBaseCy, BigDecimal bdCyFrom, BigDecimal bdGlFrom,
	    BigDecimal bdCifFrom, BigDecimal bdSlFrom, BigDecimal bdCyTo, BigDecimal bdGlTo, BigDecimal bdCifTo,
	    BigDecimal bdSlTo, Date theDtDateFrom, Date dtDateTo, String sModule, BigDecimal bdCompCode,
	    BigDecimal bdBranchFrom, BigDecimal bdBranchTo, BigDecimal bdCifReceiver, String sSwiftFile,
	    String sUserId, BigDecimal bdRepId, String sRepTitle, char cGenMode, char cPreviewSwiftMsg,
	    String sMsgCode, BigDecimal bdGenerateMsg, BigDecimal bdSchedId, BigDecimal bdBranchCode, String sLanguage,
	    String sApplication, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC,
	    ArrayList<SwiftRepListCO> swftRepSOAListCO) throws BaseException;
    
    public Date returnCutOffTime(BigDecimal bdCompCode, BigDecimal bdBranchCode, String sModule, BigDecimal bdCyCoce,
	    BigDecimal bdCountryCode, Date dtServerAppDateTime, String sValuDate)
	    throws BaseException;
    
    //efarah 07/04/2017 EWBI170270
    public void stopThread() throws BaseException;
    
    //efarah 07/04/2017 EWBI170270
    public void runThread(Long iRefreshRate, String language, BigDecimal companyCode,BigDecimal branchCode, String userName, SwiftCO swftCO, SwiftOutwardSC swiftOutSC) throws BaseException;
    
    //efarah 07/04/2017 EWBI170270
    public String returnLanguage (String appName) throws BaseException;
    /**
     * Return the SWIFT_CONTROLVO by company from cache if it is Enabled, otherwise it will be fetched from database
     * @author LBedrane  on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibBO
     * @return
     * @throws BaseException
     */
    public SWIFT_CONTROLVO returnSwiftCtrlRecValues(BigDecimal compCode) throws BaseException;
    
    /**
	 * Method to return next value sequence from SWIFT_MESSAGE_COUNTER
	 */
    public BigDecimal retSwtMsgCounter() throws BaseException;
    /**
     * Method to return next value sequence from the given table name
     */
    public BigDecimal retSwtMsgCounterByTblName(String tableName) throws BaseException;
    
    public String generateUUID() throws BaseException;
    public SwiftCO returnSwiftMsgHistory(BigDecimal bdCompCode, BigDecimal bdBrCode, BigDecimal bdTrsNo,
	    String trxType, String sModule,  BigDecimal bdMsgOrder,  String sLanguage)  throws BaseException;
	
}
