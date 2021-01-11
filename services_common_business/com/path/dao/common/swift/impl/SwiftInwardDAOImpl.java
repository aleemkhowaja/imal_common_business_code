package com.path.dao.common.swift.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dao.common.swift.SwiftInwardDAO;
import com.path.dbmaps.vo.DF_FILE_PRC_INP_PARMVO;
import com.path.dbmaps.vo.SWIFT_LOG_INVO;
import com.path.dbmaps.vo.SWIFT_MANUAL_PROCESSVOKey;
import com.path.dbmaps.vo.SWIFT_MSGDET_INVO;
import com.path.dbmaps.vo.SWIFT_MSGHDR_INVO;
import com.path.dbmaps.vo.SWIFT_MSG_REFVO;
import com.path.dbmaps.vo.S_APP_NOTIFICATIONS_MGMTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.lib.common.util.dao.DbCall;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardProcessCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardSC;
import com.path.dbmaps.vo.SWFT_SCHED_MANAGER_INVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;


public class SwiftInwardDAOImpl extends BaseDAO implements SwiftInwardDAO
{

    public BigDecimal returnCountManualMsg(SWIFT_MANUAL_PROCESSVOKey swiftManualProcess) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftInwardMapper.returnCountManualMsg", swiftManualProcess);
    }
    
    /*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
    public BigDecimal returnCountActiveThreads(SWFT_SCHED_MANAGER_INVO swiftMangVO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftInwardMapper.returnCountActiveThreads",swiftMangVO);
    }
    
    /*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
    public BigDecimal returnIsActiveThreads(SWFT_SCHED_MANAGER_INVO swiftMangVO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftInwardMapper.returnIsActiveThreads",swiftMangVO);
    }
    
    /*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
    public long returnThreadWithMinDate(SWFT_SCHED_MANAGER_INVO swiftMangVO) throws DAOException
    {
	return (Long) getSqlMap().queryForObject("swiftInwardMapper.returnThreadWithMinDate",swiftMangVO);
    }


    public BigDecimal returnAccMaxTrsNo() throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftInwardMapper.selectMaxTrsNoAccHst", null);
    }

    public BigDecimal returnMaxSeq(SWIFT_MSGHDR_INVO swiftMsghdrIn) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftInwardMapper.returnMaxSeq", swiftMsghdrIn);
    }

    public ArrayList<SwiftInwardProcessCO> returnSwiftMsghdrIn(SwiftInwardSC swiftInwardSC) throws DAOException
    {
	return ((ArrayList<SwiftInwardProcessCO>) getSqlMap().queryForList("swiftInwardMapper.returnSwiftMsghdrIn",
		swiftInwardSC));
    }

    public int returnSwiftMsghdrInCount(SwiftInwardSC swiftInwardSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("swiftInwardMapper.returnSwiftMsghdrInCount", swiftInwardSC);
    }

    public String returnProcName(SWIFT_MSGHDR_INVO swiftMsghdrIn) throws DAOException
    {
	return (String) getSqlMap().queryForObject("swiftInwardMapper.returnProcName", swiftMsghdrIn);
    }

    public String returnTag(SWIFT_MSG_REFVO swiftMsgRef) throws DAOException
    {
	return (String) getSqlMap().queryForObject("swiftInwardMapper.returnTag", swiftMsgRef);
    }

    public BigDecimal returnCountMsgdetIn(SWIFT_MSGDET_INVO swiftMsgdetIn) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftInwardMapper.returnCountManualMsg", swiftMsgdetIn);
    }

    public SWIFT_MSGDET_INVO returnMsgdetIn(SWIFT_MSGDET_INVO swiftMsgdetIn) throws DAOException
    {
	return (SWIFT_MSGDET_INVO) getSqlMap().queryForObject("swiftInwardMapper.returnMsgdetIn", swiftMsgdetIn);
    }

    private SwiftInwardCO executeProcedure(StringBuffer prepareProc, int fromIndexParam,
	    List<DF_FILE_PRC_INP_PARMVO> paramList, int procParamIndex, String sProcName, SwiftInwardCO swiftInwardCO)
	    throws DAOException
    {
	DbCall db = new DbCall(datasourceJNDI);
	CallableStatement st;
	int indx = 1;
	// remove the last "," and add ")}" to it instead

	
	try
	{
	    if(ConstantsCommon.CURR_DBMS_ORACLE == 1)
	    {
		// get the output parameters:
		SwiftInwardSC swiftInwardSC = new SwiftInwardSC();
		swiftInwardSC.setStoredProcedure(sProcName);
		swiftInwardSC.setInOutParam(2);

		ArrayList<SwiftInwardProcessCO> swiftSpOut = (ArrayList<SwiftInwardProcessCO>) getSqlMap().queryForList(
			"swiftInwardMapper.selectSwiftSpOut", swiftInwardSC);
		for(int i = 0; i < swiftSpOut.size(); i++)
		{
		    prepareProc.append("?,");
		}

		prepareProc.deleteCharAt(prepareProc.length() - 1);
		prepareProc.append(")}");

		st = db.getConnection().prepareCall(prepareProc.toString());

		// loop through the parameters to set the data type for each one
		for(int j = fromIndexParam; j < procParamIndex; j++)
		{
		    st.setString(indx, paramList.get(j).getINP_PARM_VALUE());
		    indx++;
		}

		String sColType = "";
		int iColType = 0;
		for(int k = 0; k < swiftSpOut.size(); k++)
		{
		    sColType = swiftSpOut.get(k).getSwiftMsgdetInVO().getARG_TYPE();
		    
		    if("VARCHAR2".equals(sColType))
		    {
			iColType = 12;
		    }
		    if("NUMBER".equals(sColType))
		    {
			iColType = 2;
		    }
		    if("DATE".equals(sColType))
		    {
			iColType = 91;
		    }
		    st.registerOutParameter(procParamIndex + k + 1, iColType);
		}

		// execute the procedure
		if(st != null)
		{
		    db.getConnection().setAutoCommit(false);
		    st.execute();
		    db.getConnection().commit();

		    //get the outputs
		    String[] sOutValues = new String[swiftSpOut.size()];
		    for(int k = 0; k < swiftSpOut.size(); k++)
		    {
			sOutValues[k] = st.getString(procParamIndex + k + 1);
		    }
		    swiftInwardCO.setOutputParams(sOutValues);
		}
		st.close();
	    }
	    else
	    {
		prepareProc.deleteCharAt(prepareProc.length() - 1);
		prepareProc.append(")}");

		st = db.getConnection().prepareCall(prepareProc.toString());

		// loop through the parameters to set the data type for each one
		for(int j = fromIndexParam; j < procParamIndex; j++)
		{
		    st.setString(indx, paramList.get(j).getINP_PARM_VALUE());
		    indx++;
		}
		// execute the statement
		ResultSet rs = null;
		if(st != null)
		{
		    db.getConnection().setAutoCommit(false);
		    rs = st.executeQuery();
		    db.getConnection().commit();
		    // mhmd
		    // getting output parameters
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int iColumnCount = rsmd.getColumnCount();
		    String[] sOutValues = new String[iColumnCount];

		    while(rs.next())
		    {
			int iCount1 = 0;
			for(int j = 1; j <= iColumnCount; j++)
			{
			    if(rs.getObject(j) != null)
			    {
				sOutValues[iCount1] = rs.getObject(j).toString();
				iCount1++;
			    }
			}
		    }
		    swiftInwardCO.setOutputParams(sOutValues);
		}
		st.close();
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "ERROR in DynFiles Procedure execution:" + e.getMessage());
	    if(db != null)
	    {
		try
		{
		    db.getConnection().rollback();

		}
		catch(Exception e1)
		{
		    log.error(e1, "ERROR in rollback upon Exception DynFiles Procedure:" + e1.getMessage());
		    //throw new DAOException(e.getMessage().concat(e1.getMessage()), e1) ;
		}
	    }
	    db.freeResources();
	    throw new DAOException(e);
	}
	finally
	{
	    db.freeResources();

	}
	return swiftInwardCO;
    }

    public SwiftInwardCO executeDynProcedure(List<DF_FILE_PRC_INP_PARMVO> paramList, String sProcName,
	    SwiftInwardCO swiftInwardCO) throws DAOException
    {
	StringBuffer prepareProc = new StringBuffer();
	int fromIndexParam = 0, toIndex = 0;
	SwiftInwardCO swiftInwardCOReturned = new SwiftInwardCO();

	// loop through the procedures
	for(int i = 0; i < paramList.size(); i++)
	{
	    // check if this a procedure and not a misc sql parameter
	    if(StringUtil.nullToEmpty(sProcName).length() > 0)
	    {
		// if the proc is not initialized yet then do so
		if(prepareProc.length() == 0)
		{
		    fromIndexParam = i;
		    toIndex = i;
		    prepareProc = new StringBuffer("{call " + sProcName + "(");
		}
		prepareProc.append("?,");
		toIndex++;
	    }

	    // if this is the last item of the list or next item is a misc sql
	    // parameter then execute the statement
	    if((i + 1 == paramList.size() || StringUtil.nullToEmpty(sProcName).length() == 0)
		    && prepareProc.length() != 0)
	    {
		swiftInwardCOReturned = executeProcedure(prepareProc, fromIndexParam, paramList, toIndex, sProcName,
			swiftInwardCO);
	    }
	}
	return swiftInwardCOReturned;
    }

    public int returnInwardSwiftLogGridCount(SwiftInwardSC swiftInwardSC) throws DAOException
    {
	DAOHelper.fixGridMaps(swiftInwardSC, getSqlMap(), "swiftInwardMapper.selectSwiftLogInMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("swiftInwardMapper.selectSwiftInLogCount", swiftInwardSC))
		.intValue();
	return nb;
    }

    public ArrayList<SWIFT_LOG_INVO> returnInwardSwiftLogGrid(SwiftInwardSC swiftInwardSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(swiftInwardSC.getSidx()).isEmpty())
	{
	    swiftInwardSC.setSidx("LOG_DATE");
	    swiftInwardSC.setSord("ASC");
	}

	DAOHelper.fixGridMaps(swiftInwardSC, getSqlMap(), "swiftInwardMapper.selectSwiftLogInMap");

	if(swiftInwardSC.getNbRec() == -1)
	{
	    return (ArrayList<SWIFT_LOG_INVO>) getSqlMap().queryForList("swiftInwardMapper.selectSwiftLogIn",
		    swiftInwardSC);
	}
	else
	{
	    return (ArrayList<SWIFT_LOG_INVO>) getSqlMap().queryForList("swiftInwardMapper.selectSwiftLogIn",
		    swiftInwardSC, swiftInwardSC.getRecToskip(), swiftInwardSC.getNbRec());
	}
    }

    public void updateEngineServiceStatusIn(SwiftInwardSC swiftInwardSC) throws DAOException
    {
	getSqlMap().update("swiftInwardMapper.updateEasServiceStatusIn", swiftInwardSC);
    }

    public void deleteSwiftLogInward() throws DAOException
    {
	getSqlMap().delete("swiftInwardMapper.deleteSwiftLogInward", null);
    }
    
    //HGhazal - BMOI140016
    public S_APP_NOTIFICATIONS_MGMTVO returnAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException{
    	
    	return (S_APP_NOTIFICATIONS_MGMTVO) getSqlMap().queryForObject("S_APP_NOTIFICATIONS_MGMT.selectS_APP_NOTIFICATIONS_MGMT", S_APP_NOTIFICATIONS_MGMTVOIn);
    }
    //HGhazal - BMOI140016
    public void updateAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException{
    	
    	getSqlMap().update("S_APP_NOTIFICATIONS_MGMT.updateS_APP_NOTIFICATIONS_MGMT", S_APP_NOTIFICATIONS_MGMTVOIn);
    }
    //HGhazal - BMOI140016
    public void insertAppNotifMgmt(S_APP_NOTIFICATIONS_MGMTVO S_APP_NOTIFICATIONS_MGMTVOIn) throws DAOException{
    	getSqlMap().insert("S_APP_NOTIFICATIONS_MGMT.insertS_APP_NOTIFICATIONS_MGMT", S_APP_NOTIFICATIONS_MGMTVOIn);
    }

	@Override
	public String getDoNotArchFlag() throws DAOException {
		// TODO Auto-generated method stub
		return (String) getSqlMap().queryForObject("swiftInwardMapper.getDoNotArchFlag",null);
	}
	  //LBedrane - BMO180040 - TP#692469 - 26/07/2018 <Start>
   	public Integer returnValueOfEnableQueueYn() throws DAOException {
   		return (Integer) getSqlMap().queryForObject("swiftInwardMapper.returnValueOfEnableQueueYn", null);
   	}
   	
   	//LBedrane as per hojeij - BMO180040  - TP#692469 - 26/07/2018
   	@Override
	public SWIFT_CONTROLVO readMQSettings() throws DAOException {
		// TODO Auto-generated method stub
		return ((SWIFT_CONTROLVO) getSqlMap().queryForObject("swiftMapper.readMQSettings", null));
	}

    public int returnGenerateAchFlag(SwiftInwardCO swiftInwardCO) throws DAOException{
	return ((BigDecimal) getSqlMap().queryForObject("swiftMapper.returnGenerateAchFlag", swiftInwardCO)).intValue();
    }
    
    public SWIFT_CONTROLVO returnKeyStore() throws DAOException
    {
	return ((SWIFT_CONTROLVO) getSqlMap().queryForObject("swiftMapper.returnKeyStore", null));
    }
}
