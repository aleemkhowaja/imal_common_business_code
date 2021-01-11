package com.path.dao.common.swift;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.path.dbmaps.vo.SWFT_SCHED_MANAGERVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dbmaps.vo.SWIFT_DWS_CFVO;
import com.path.dbmaps.vo.SWIFT_HISTORYVOWithBLOBs;
import com.path.dbmaps.vo.SWIFT_LOGVO;
import com.path.dbmaps.vo.SWIFT_PRINT_DETVO;
import com.path.dbmaps.vo.SWIFT_PRINT_HDRVO;
import com.path.dbmaps.vo.SWIFT_REPORTSVO;
import com.path.dbmaps.vo.S_APP_NOTIFICATIONS_MGMTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardProcessCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSchedRepCO;
import com.path.vo.common.swift.swiftoutward.SwiftProcNostroCO;
import com.path.vo.common.swift.swiftoutward.SwiftRepListCO;
import com.path.vo.common.yrt.YRTSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: CharbelObeidi
 *
 * SwiftOutwardDAO.java used to access the database to retrieve Swift Outward Parameters
 */

public interface SwiftOutwardDAO
{
    public ArrayList<SwiftOutwardSchedRepCO> returnScheduledSwiftReports(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public ArrayList<SwiftOutwardSchedRepCO> returnScheduledSwiftReportsWithPerformance(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public void deleteSwiftDwSchedReqGen950 (SwiftOutwardSC swiftOutwardSC) throws DAOException;
//    public ArrayList<SwiftOutwardSchedRepCO> returnSwiftReportsList(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public ArrayList<SwiftRepListCO> returnSwiftSOAReportsList(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public void returnSwiftHoliday(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public void updateEngineServiceStatus(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public void updateEngineNextReplicationdate(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public int executeUpdateStmt(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public BigDecimal returnAccMaxTrsNo(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public BigDecimal returnCountHstTrsNo(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public ArrayList<SwiftOutwardProcessCO> returnAllocationParameters(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public SWIFT_REPORTSVO returnSwiftReportsDetails(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public SWIFT_PRINT_HDRVO returnSwiftPrintHdr(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public ArrayList<SWIFT_PRINT_DETVO> returnSwiftPrintDet(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public int fixNextReplDateTime(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public ArrayList<SWIFT_LOGVO> returnOutwardSwiftLogGrid(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public Integer returnOutwardSwiftLogGridCount(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public void deleteSwiftLogOutward() throws DAOException;
    public BigDecimal returnMsgCountByGrpNbr(SwiftOutwardSC swiftOutwardSC) throws DAOException;
    public String returnOpenedDateBranch(YRTSC yrtSC) throws DAOException;
    public ArrayList<Map<String, Object>> returnSwiftLinkedHashMapDynamicSQL(DynFilesSC dynFilesSC,SwiftOutwardSC swiftOutwardSC,String queryType ) throws DAOException;
    public BigDecimal returnCountByAccountRange(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void deleteAccBalTmpByAccRange(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void deleteAccBalTmp1ByAccRange(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void insertACCBalTmpDOFN(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void insertACCBalTmpHSTN(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void insertACCBalTmpDOFY(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void insertACCBalTmpHSTY(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void insertACCBalTmpAmfSuppl(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void insertACCBalTmpAmf(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public void insertACCBalTmp1(SwiftProcNostroCO swiftProcNostroCO) throws DAOException;
    public ArrayList<SWIFT_DWS_CFVO> returnSoaExpressions(SwiftOutwardSC swiftOutwardSC) throws DAOException;
  //HGhazal - BMOI140016
    public S_APP_NOTIFICATIONS_MGMTVO returnAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException;
    
    //HGhazal - BMOI140016
    public void updateAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException;
    
  //HGhazal - BMOI140016
    public void insertAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException;
    public String returnLanguage(String appName) throws DAOException;//efarah 07/04/2017 EWBI170270
    public SWIFT_CONTROLVO selectSwenOutwardFlag() throws DAOException;//efarah 23/05/2017 BMO160149
	public BigDecimal ReturnGenFileYnValue() throws DAOException;//LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java 
	public void updateThreadStatus(SWFT_SCHED_MANAGERVO SWFT_SCHED_MANAGERVOIN) throws DAOException;
	public SWIFT_CONTROLVO returnSwiftCtrlByComp( BigDecimal compCode) throws DAOException;  //Added by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibDAO
	public Connection returnConnection() throws DAOException;
    public void updateSwtMsgCounterByTblName(String tableName) throws DAOException;
    public BigDecimal retSwtMsgCounterByTblName(String tableName) throws DAOException;
    public int returnGenerateAchFlagOut(SwiftInwardCO swiftInwardCO) throws DAOException;
    public SWIFT_CONTROLVO returnKeyStore() throws DAOException;
    public ArrayList<SWIFT_HISTORYVOWithBLOBs> returnSwiftHistoryReport(SwiftOutwardSC swiftOutwardSC)
	    throws DAOException;
    
}
