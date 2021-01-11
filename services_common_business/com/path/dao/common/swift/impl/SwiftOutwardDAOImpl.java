package com.path.dao.common.swift.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.path.bo.common.ConstantsCommon;
import com.path.dao.common.swift.SwiftOutwardDAO;
import com.path.dbmaps.vo.SWFT_SCHED_MANAGERVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dbmaps.vo.SWIFT_DWS_CFVO;
import com.path.dbmaps.vo.SWIFT_HISTORYVOWithBLOBs;
import com.path.dbmaps.vo.SWIFT_LOGVO;
import com.path.dbmaps.vo.SWIFT_PRINT_DETVO;
import com.path.dbmaps.vo.SWIFT_PRINT_HDRVO;
import com.path.dbmaps.vo.SWIFT_REPORTSVO;
import com.path.dbmaps.vo.S_APP_NOTIFICATIONS_MGMTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.common.util.dao.DbCall;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardProcessCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSchedRepCO;
import com.path.vo.common.swift.swiftoutward.SwiftProcNostroCO;
import com.path.vo.common.swift.swiftoutward.SwiftRepListCO;
import com.path.vo.common.yrt.YRTSC;

public class SwiftOutwardDAOImpl extends BaseDAO implements SwiftOutwardDAO
{

    public ArrayList<SwiftOutwardSchedRepCO> returnScheduledSwiftReports(SwiftOutwardSC swiftOutwardSC)
	    throws DAOException
    {
	return (ArrayList<SwiftOutwardSchedRepCO>) getSqlMap().queryForList("swiftMapper.selectScheduledSwiftReports",
		swiftOutwardSC);
    }

    public ArrayList<SwiftOutwardSchedRepCO> returnScheduledSwiftReportsWithPerformance(SwiftOutwardSC swiftOutwardSC)
	    throws DAOException
    {
	return (ArrayList<SwiftOutwardSchedRepCO>) getSqlMap().queryForList(
		"swiftMapper.selectScheduledSwiftReportsWithPerformance", swiftOutwardSC);
    }

    public void deleteSwiftDwSchedReqGen950(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	getSqlMap().delete("swiftMapper.deleteSwiftDwSchedReqGen950", swiftOutwardSC);
    }

//    public ArrayList<SwiftOutwardSchedRepCO> returnSwiftReportsList(SwiftOutwardSC swiftOutwardSC) throws DAOException
//    {
//	return (ArrayList<SwiftOutwardSchedRepCO>) getSqlMap().queryForList("swiftMapper.selectSwiftRepList",
//		swiftOutwardSC);
//    }

    public ArrayList<SwiftRepListCO> returnSwiftSOAReportsList(SwiftOutwardSC swiftOutwardSC)
	    throws DAOException
    {
	return (ArrayList<SwiftRepListCO>) getSqlMap().queryForList("swiftMapper.selectSwiftSOARepList",
		swiftOutwardSC);
    }

    public void returnSwiftHoliday(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	getSqlMap().update("swiftMapper.checkSwiftHoliday", swiftOutwardSC);
    }

    public void updateEngineServiceStatus(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	getSqlMap().update("swiftMapper.updateEasServiceStatus", swiftOutwardSC);
    }

    public void updateEngineNextReplicationdate(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	getSqlMap().update("swiftMapper.updateEngineNextReplicationdate", swiftOutwardSC);
    }

    public int executeUpdateStmt(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	return getSqlMap().update("swiftMapper.executeUpdateStmt", swiftOutwardSC);
    }

    public BigDecimal returnAccMaxTrsNo(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftMapper.selectMaxTrsNoAccHst", swiftOutwardSC);
    }

    public BigDecimal returnCountHstTrsNo(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftMapper.selectMaxTrsNoHst", swiftOutwardSC);
    }

    public ArrayList<SwiftOutwardProcessCO> returnAllocationParameters(SwiftOutwardSC swiftOutwardSC)
	    throws DAOException
    {
	return (ArrayList<SwiftOutwardProcessCO>) getSqlMap().queryForList("swiftMapper.selectSwiftProcess",
		swiftOutwardSC);
    }

    public SWIFT_REPORTSVO returnSwiftReportsDetails(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	    return (SWIFT_REPORTSVO) getSqlMap().queryForObject("swiftMapper.selectSwiftReports", swiftOutwardSC);
    }

    public SWIFT_PRINT_HDRVO returnSwiftPrintHdr(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	return (SWIFT_PRINT_HDRVO) getSqlMap().queryForObject("swiftMapper.selectSwiftPrintHdr", swiftOutwardSC);
    }

    public ArrayList<SWIFT_PRINT_DETVO> returnSwiftPrintDet(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	return (ArrayList<SWIFT_PRINT_DETVO>) getSqlMap().queryForList("swiftMapper.selectSwiftPrintDet",
		swiftOutwardSC);
    }

    public int fixNextReplDateTime(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	return getSqlMap().update("swiftMapper.updateSwiftDwschedNextRepl", swiftOutwardSC);
    }

    public ArrayList<SWIFT_LOGVO> returnOutwardSwiftLogGrid(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(swiftOutwardSC.getSidx()).isEmpty())
	{
	    swiftOutwardSC.setSidx("LOG_DATE");
	    swiftOutwardSC.setSord("ASC");
	}

	DAOHelper.fixGridMaps(swiftOutwardSC, getSqlMap(), "swiftMapper.selectSwiftLogMap");

	if(swiftOutwardSC.getNbRec() == -1)
	{
	    return (ArrayList<SWIFT_LOGVO>) getSqlMap().queryForList("swiftMapper.selectSwiftLog", swiftOutwardSC);
	}
	else
	{
	    return (ArrayList<SWIFT_LOGVO>) getSqlMap().queryForList("swiftMapper.selectSwiftLog", swiftOutwardSC,
		    swiftOutwardSC.getRecToskip(), swiftOutwardSC.getNbRec());
	}
    }

    public Integer returnOutwardSwiftLogGridCount(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	DAOHelper.fixGridMaps(swiftOutwardSC, getSqlMap(), "swiftMapper.selectSwiftLogMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("swiftMapper.selectSwiftOutLogCount", swiftOutwardSC)).intValue();
	return nb;
    }

    public void deleteSwiftLogOutward() throws DAOException
    {
	getSqlMap().delete("swiftMapper.deleteSwiftLogOutward", null);
    }

    public BigDecimal returnMsgCountByGrpNbr(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftMapper.selectMsgCountByGrpNbr", swiftOutwardSC);
    }

    public String returnOpenedDateBranch(YRTSC yrtSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("swiftMapper.returnOpenedDateBranch", yrtSC);
    }

    public BigDecimal returnCountByAccountRange(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("swiftMapper.selectCountByAccountRange", swiftProcNostroCO);
    }
    public void deleteAccBalTmpByAccRange(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().delete("swiftMapper.deleteACCBalTmpByAccRange", swiftProcNostroCO);
    }
    
    public void deleteAccBalTmp1ByAccRange(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().delete("swiftMapper.deleteACCBalTmp1ByAccRange", swiftProcNostroCO);
    }
    
    public void insertACCBalTmpDOFN(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().insert("swiftMapper.insertACCBalTmpDOFN", swiftProcNostroCO);
    }
    
    public void insertACCBalTmpHSTN(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().insert("swiftMapper.insertACCBalTmpHSTN", swiftProcNostroCO);
    }
    
    public void insertACCBalTmpDOFY(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().insert("swiftMapper.insertACCBalTmpDOFY", swiftProcNostroCO);
    }
    
    public void insertACCBalTmpHSTY(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().insert("swiftMapper.insertACCBalTmpHSTY", swiftProcNostroCO);
    }
    
    public void insertACCBalTmpAmfSuppl(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().insert("swiftMapper.insertACCBalTmpAmfSuppl", swiftProcNostroCO);
    }
    
    public void insertACCBalTmpAmf(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().insert("swiftMapper.insertACCBalTmpAmf", swiftProcNostroCO);
    }
    
    public void insertACCBalTmp1(SwiftProcNostroCO swiftProcNostroCO) throws DAOException
    {
	getSqlMap().insert("swiftMapper.insertACCBalTmp1", swiftProcNostroCO);
    }
    
    public ArrayList<Map<String, Object>> returnSwiftLinkedHashMapDynamicSQL(DynFilesSC dynFilesSC,
	    SwiftOutwardSC swiftOutwardSC, String queryType) throws DAOException
    {
	DbCall db = new DbCall(datasourceJNDI);
	LinkedHashMap<String, Object> lhmSqlResult = null;
	ArrayList<Map<String, Object>> aListMapSqlResult = new ArrayList<Map<String, Object>>();
	ArrayList<Map<String, Object>> aListMapSqlResultRows = new ArrayList<Map<String, Object>>();
	Object object;

	try
	{
	    // Case of query
	    if("Q".equals(queryType))
	    {
		// execute the dynamic query and store the result in a ResultSet
		StringBuffer theSql = new StringBuffer(dynFilesSC.getDynamicSQL());

		ResultSet rs = db.executeQuery(theSql.toString());
		// get the column count since being dynamic, we don't know the
		// columns being retrieved
		ResultSetMetaData rsmd = rs.getMetaData();
		int NumOfCol = rsmd.getColumnCount();
		int indx;

		// *******************///
		// get the columns only if swiftOutwardSC.getTrsFromDate is
		// Null--> show mode only not retrieve mode
		if(swiftOutwardSC.getTrsFromDate() == null)
		{
		    lhmSqlResult = new LinkedHashMap<String, Object>();
		    // loop through the columns
		    for(indx = 1; indx <= NumOfCol; indx++)
		    {
			lhmSqlResult.put(rsmd.getColumnLabel(indx), null);
		    }
		    aListMapSqlResult.add(lhmSqlResult);
		}
		// *******************///

		// in case rowcount > 0 --> loop through the rows
		while(rs.next())
		{
		    rsmd = rs.getMetaData();
		    lhmSqlResult = new LinkedHashMap<String, Object>();
		    // loop through the columns
		    for(indx = 1; indx <= NumOfCol; indx++)
		    {
			object = rs.getObject(indx);
			//Chady.A BUG#320994
			if (object instanceof Date) 
			{
			    lhmSqlResult.put(rsmd.getColumnLabel(indx), DateUtil.format((Date)object, "yyyy"));
			}
			else
			{
			    lhmSqlResult.put(rsmd.getColumnLabel(indx), object);
			}
		    }
		    aListMapSqlResultRows.add(lhmSqlResult);
		}
		// return the filled HM
		if(!aListMapSqlResultRows.isEmpty())
		{
		    return aListMapSqlResultRows;
		}

	    }
	    else
	    {
		if(ConstantsCommon.CURR_DBMS_ORACLE == 1)
		{
		    getSqlMap().queryForList("swiftMapperDBMS.executeSwiftReport", swiftOutwardSC);
		    
		    aListMapSqlResult = swiftOutwardSC.getSwiftSpResultList();

		    // get the columns only if swiftOutwardSC.getTrsFromDate is
		    // Null--> show mode only not retrieve mode
		    if(swiftOutwardSC.getTrsFromDate() == null)
		    {
			CallableStatement stmt;
			Connection con = db.getConnection();
			stmt = con.prepareCall("{call " + swiftOutwardSC.getSReportProcedure() + "(?,?,?,?,?,?,?)}");
			stmt.setBigDecimal(1, BigDecimal.ONE);
			stmt.setDate(2, null);
			stmt.setDate(3, null);
			stmt.setBigDecimal(4, BigDecimal.ONE);
			stmt.setBigDecimal(5, new BigDecimal(999999999));
			stmt.setString(6, "P");
			stmt.registerOutParameter(7,-10,"java.sql.ResultSet");//-10 :specific code for resultset 
			stmt.executeQuery();
			ResultSet rs = (ResultSet) stmt.getObject(7);

			// get the column count since being dynamic, we don't
			// know the
			// columns being retrieved
			ResultSetMetaData rsmd = rs.getMetaData();
			int NumOfCol = rsmd.getColumnCount();
			int indx;

			// *******************///
			// get the columns only if swiftOutwardSC.getTrsFromDate
			// is
			// Null--> show mode only not retrieve mode
			if(swiftOutwardSC.getTrsFromDate() == null)
			{
			    lhmSqlResult = new LinkedHashMap<String, Object>();
			    // loop through the columns
			    for(indx = 1; indx <= NumOfCol; indx++)
			    {
				lhmSqlResult.put(rsmd.getColumnLabel(indx), null);
			    }
			    aListMapSqlResult.add(lhmSqlResult);
			}
			// Close all the resources
			rs.close();
			stmt.close();
		    }

		}
		else
		{
		    // case of procedure
		    aListMapSqlResult = (ArrayList<Map<String, Object>>) getSqlMap().queryForList(
			    "swiftMapperDBMS.executeSwiftReport", swiftOutwardSC);

		    // get the columns only if swiftOutwardSC.getTrsFromDate is
		    // Null--> show mode only not retrieve mode
		    if(swiftOutwardSC.getTrsFromDate() == null)
		    {
			StringBuffer sbSpCall = new StringBuffer();
			sbSpCall.append("exec ");
			sbSpCall.append(swiftOutwardSC.getSReportProcedure());
			sbSpCall.append(" ");		
			sbSpCall.append(swiftOutwardSC.getCompCode());
			if(swiftOutwardSC.getTrsFromDate() == null)
			{
			    sbSpCall.append(",'01/01/1999'");
			    // sbSpCall.append(",TO_DATE('01/01/1999','DD/MM/YYYY')");
			}
			else
			{
			    sbSpCall.append(", '");
			    sbSpCall.append(DateUtil.format(swiftOutwardSC.getTrsFromDate(), "MM/dd/yyyy").toString());
			    sbSpCall.append("' ");

			}
			if(swiftOutwardSC.getTrsToDate() == null)
			{
			    sbSpCall.append(",'01/01/1999'");
			    // sbSpCall.append(",TO_DATE('01/01/1999','DD/MM/YYYY')");
			}
			else
			{
			    sbSpCall.append(", '");
			    sbSpCall.append(DateUtil.format(swiftOutwardSC.getTrsToDate(), "MM/dd/yyyy").toString());
			    sbSpCall.append("' ");

			}
			sbSpCall.append(", ");
			sbSpCall.append(swiftOutwardSC.getTrsFromNo());
			sbSpCall.append(", ");
			sbSpCall.append(swiftOutwardSC.getTrsToNo());
			sbSpCall.append(",'");
			sbSpCall.append(swiftOutwardSC.getStatus());
			sbSpCall.append("'");
			

			ResultSet rs = db.executeQuery(sbSpCall.toString());

			// get the column count since being dynamic, we don't
			// know
			// the
			// columns being retrieved
			ResultSetMetaData rsmd = rs.getMetaData();
			int NumOfCol = rsmd.getColumnCount();
			int indx;
			lhmSqlResult = new LinkedHashMap<String, Object>();
			// loop through the columns
			for(indx = 1; indx <= NumOfCol; indx++)
			{
			    lhmSqlResult.put(rsmd.getColumnLabel(indx), null);
			}
			aListMapSqlResult.add(lhmSqlResult);
			
			// Close all the resources
			rs.close();

		    }
		}
	    }
	}
	catch(Exception e)
	{
	    throw new DAOException(e);
	}
	finally
	{
	    db.freeResources();
	}
	return aListMapSqlResult;
    }
    public ArrayList<SWIFT_DWS_CFVO> returnSoaExpressions(SwiftOutwardSC swiftOutwardSC) throws DAOException
    {	
	    return  (ArrayList<SWIFT_DWS_CFVO>)getSqlMap().queryForList("swiftMapper.selectSwiftDwsCF", swiftOutwardSC);	
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
    
    //efarah 07/04/2017 EWBI170270
    public String returnLanguage(String appName) throws DAOException
    {
    	return  (String)getSqlMap().queryForObject("swiftMapper.returnLanguage", appName);
    }
    
    //efarah 23/05/2017 BMO160149
    public SWIFT_CONTROLVO selectSwenOutwardFlag() throws DAOException
    {
	return  (SWIFT_CONTROLVO)getSqlMap().queryForObject("swiftMapper.selectSwenOutwardFlag", null);
    }
    //LBedrane on 18/01/2018 copying KIB170005 US = 605700 from PB to Java
	@Override
	public BigDecimal ReturnGenFileYnValue() throws DAOException 
	{
		
	return (BigDecimal) getSqlMap().queryForObject("swiftMapper.ReturnGenFileYnValue", null);
	
	

	}
	
	@Override
	public void updateThreadStatus(SWFT_SCHED_MANAGERVO SWFT_SCHED_MANAGERVOIN) throws DAOException {
		// TODO Auto-generated method stub
		getSqlMap().update("SWFT_SCHED_MANAGER.updateSWFT_SCHED_MANAGER", SWFT_SCHED_MANAGERVOIN);
	}
	 /**
     * returns the control record by company  -- Added by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibDAOImpl
     */
   public SWIFT_CONTROLVO returnSwiftCtrlByComp(BigDecimal compCode) throws DAOException  
   {
   	return (SWIFT_CONTROLVO) getSqlMap().queryForObject("swiftMapper.returnSwiftCtrlByComp", compCode);
   }

	@Override
	public Connection returnConnection() throws DAOException {
		// TODO Auto-generated method stub
		return sqlMap.returnConnection();
	}
	    
    public void updateSwtMsgCounterByTblName(String tableName) throws DAOException
    {
    	getSqlMap().update("swiftMapper.updateSwtMsgCounterByTblName",tableName);
    }
    public BigDecimal retSwtMsgCounterByTblName(String tableName) throws DAOException
    {
    	return (BigDecimal) getSqlMap().queryForObject("swiftMapper.retSwtMsgCounterByTblName",tableName); 
    }
    
    public int returnGenerateAchFlagOut(SwiftInwardCO swiftInwardCO) throws DAOException{
    	return ((BigDecimal) getSqlMap().queryForObject("swiftMapper.returnGenerateAchFlagOut", swiftInwardCO)).intValue();
        }
        
        public SWIFT_CONTROLVO returnKeyStore() throws DAOException
        {
    	return ((SWIFT_CONTROLVO) getSqlMap().queryForObject("swiftMapper.returnKeyStore", null));
        }
        
        // #558956 SBI170063 - Real Time Gross Settlement (RTGS)   
        public ArrayList<SWIFT_HISTORYVOWithBLOBs> returnSwiftHistoryReport(SwiftOutwardSC swiftOutwardSC)throws DAOException{
        return (ArrayList<SWIFT_HISTORYVOWithBLOBs>) getSqlMap().queryForList("swiftMapper.selectPrint_SWIFT_HISTORY",
        		swiftOutwardSC);
        }
	   // #558956 SBI170063 - Real Time Gross Settlement (RTGS)
	
            
} 
