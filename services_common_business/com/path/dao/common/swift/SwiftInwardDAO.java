package com.path.dao.common.swift;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.DF_FILE_PRC_INP_PARMVO;
import com.path.dbmaps.vo.SWFT_SCHED_MANAGER_INVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dbmaps.vo.SWIFT_LOG_INVO;
import com.path.dbmaps.vo.SWIFT_MANUAL_PROCESSVOKey;
import com.path.dbmaps.vo.SWIFT_MSGDET_INVO;
import com.path.dbmaps.vo.SWIFT_MSGHDR_INVO;
import com.path.dbmaps.vo.SWIFT_MSG_REFVO;
import com.path.dbmaps.vo.S_APP_NOTIFICATIONS_MGMTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardProcessCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardSC;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: CharbelObeidi
 *
 * SwiftOutwardDAO.java used to access the database to retrieve Swift Outward Parameters
 */

public interface SwiftInwardDAO
{
    public BigDecimal returnCountManualMsg(SWIFT_MANUAL_PROCESSVOKey swiftManualProcess) throws DAOException;
    
    /*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
	public BigDecimal returnCountActiveThreads(SWFT_SCHED_MANAGER_INVO swiftMangVO) throws DAOException;
	
	/*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
	public BigDecimal returnIsActiveThreads(SWFT_SCHED_MANAGER_INVO swiftMangVO) throws DAOException;
	
	/*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
	public long returnThreadWithMinDate(SWFT_SCHED_MANAGER_INVO swiftMangVO) throws DAOException;
    
    public BigDecimal returnAccMaxTrsNo() throws DAOException;
    
    public BigDecimal returnMaxSeq(SWIFT_MSGHDR_INVO swiftMsghdrIn) throws DAOException;
    
    public ArrayList<SwiftInwardProcessCO> returnSwiftMsghdrIn(SwiftInwardSC swiftInwardSC) throws DAOException;
    
    public int returnSwiftMsghdrInCount(SwiftInwardSC swiftInwardSC) throws DAOException;
    
    public String returnProcName(SWIFT_MSGHDR_INVO swiftMsghdrIn) throws DAOException;
    
    public String returnTag(SWIFT_MSG_REFVO swiftMsgRef) throws DAOException;
    
    public BigDecimal returnCountMsgdetIn(SWIFT_MSGDET_INVO swiftMsgdetIn) throws DAOException;
    
    public SWIFT_MSGDET_INVO returnMsgdetIn(SWIFT_MSGDET_INVO swiftMsgdetIn) throws DAOException;
    
    public SwiftInwardCO executeDynProcedure(List<DF_FILE_PRC_INP_PARMVO> paramList, String sProcName, SwiftInwardCO swiftInwardCO) throws DAOException;
    
    public int returnInwardSwiftLogGridCount(SwiftInwardSC swiftInwardSC) throws DAOException;
    
    public ArrayList<SWIFT_LOG_INVO> returnInwardSwiftLogGrid(SwiftInwardSC swiftInwardSC) throws DAOException;
    
    public void updateEngineServiceStatusIn(SwiftInwardSC swiftInwardSC) throws DAOException;
    
    public void deleteSwiftLogInward() throws DAOException;
    
    //HGhazal - BMOI140016
    public S_APP_NOTIFICATIONS_MGMTVO returnAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException;
    
    //HGhazal - BMOI140016
    public void updateAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException;
    
  //HGhazal - BMOI140016
    public void insertAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException;
    public int returnGenerateAchFlag(SwiftInwardCO swiftInwardCO) throws DAOException;
    
    //Mohamad Hojeij 25/07/2018 - Copy NBK
    public String getDoNotArchFlag() throws DAOException;
    //LBedrane - BMO180040 - TP#690676 - 12/07/2018 
    public Integer returnValueOfEnableQueueYn()throws DAOException;
  //LBedrane - BMO180040 - TP# --ASK per mohammad hojeij to fill the grid
    public SWIFT_CONTROLVO readMQSettings() throws DAOException;
    public SWIFT_CONTROLVO returnKeyStore() throws DAOException;
}
