package com.path.bo.common.swift.swiftoutward;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.springframework.beans.BeansException;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dynfiles.DynFilesConstant;
import com.path.dao.common.dynfiles.DynFilesDAO;
import com.path.dao.common.swift.SwiftOutwardDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.EAS_SERVICESVO;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.dbmaps.vo.SWFT_SCHED_MANAGERVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dbmaps.vo.SWIFT_CUT_OFFVO;
import com.path.dbmaps.vo.SWIFT_DWSCHEDVO;
import com.path.dbmaps.vo.SWIFT_DWSVO;
import com.path.dbmaps.vo.SWIFT_DWS_CFVO;
import com.path.dbmaps.vo.SWIFT_HISTORYVOWithBLOBs;
import com.path.dbmaps.vo.SWIFT_LOGVO;
import com.path.dbmaps.vo.SWIFT_PRINT_DETVO;
import com.path.dbmaps.vo.SWIFT_PRINT_HDRVO;
import com.path.dbmaps.vo.SWIFT_REPORTSVO;
import com.path.dbmaps.vo.SWIFT_TRS_LOGVO;
import com.path.dbmaps.vo.S_APP_NOTIFICATIONS_MGMTVO;
import com.path.dbmaps.vo.TFSADVICEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.BaseObject;
import com.path.vo.common.DBSequenceSC;
import com.path.vo.common.dynfiles.DynFilesColumnCO;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.common.swift.swiftoutward.SwiftCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSchedRepCO;
import com.path.vo.common.swift.swiftoutward.SwiftProcNostroCO;
import com.path.vo.common.swift.swiftoutward.SwiftRepListCO;
import com.path.vo.common.swift.swiftoutward.SwiftTrxListCO;
import com.path.vo.common.yrt.YRTSC;

public class SwiftOutwardNonTransBOImpl extends BaseBO implements SwiftOutwardNonTransBO
{
    private SwiftOutwardDAO swiftOutwardDAO;
    private SwiftOutwardTransBO swiftOutwardTransBO;
    private DynFilesDAO dynFilesDAO;
    private static Object lock = new Object();
    //HGhazal - BMOI140016
    private static final String SWEN_SERVICES	= "PathSwenServices.properties";
    private static final String NOTIFICATION_TIMER = "notificationTimer";
    //
    public void setDynFilesDAO(DynFilesDAO dynFilesDAO)
    {
	this.dynFilesDAO = dynFilesDAO;
    }

    public void setSwiftOutwardTransBO(SwiftOutwardTransBO swiftOutwardTransBO)
    {
	this.swiftOutwardTransBO = swiftOutwardTransBO;
    }

    public void setSwiftOutwardDAO(SwiftOutwardDAO swiftOutwardDAO)
    {
	this.swiftOutwardDAO = swiftOutwardDAO;
    }

    public void initEngineBeforeStart(String sLanguage, BigDecimal bdCompanyCode, BigDecimal bdRefreshRate,
	    SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	StringBuffer sbsSwiftMsgFile = new StringBuffer();
	String sSwiftMsgFile = "", sSwiftLogFile, sRepoSwift;

	// Check if folder exists and make directories in case of not
	sRepoSwift = FileUtil.getFileURLByName("repository");

	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("1"))
	{
		 sSwiftMsgFile = returnSwiftCtrlRecValues(bdCompanyCode).getSAVE_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter after creating same function existing in common files 
	    // Remove the file name from the save path to be able to create the
	    // save folder properly
	    int i = sSwiftMsgFile.lastIndexOf("/");
	    sbsSwiftMsgFile.append(sSwiftMsgFile.substring(0, i));
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftMsgFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftMsgFile.insert(0, "/");
		sbsSwiftMsgFile.insert(0, sRepoSwift);
	    }
	}

	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("2"))
	{
	    sSwiftMsgFile = returnSwiftCtrlRecValues(bdCompanyCode).getDYNAMIC_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    sbsSwiftMsgFile.append(sSwiftMsgFile);
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftMsgFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftMsgFile.insert(0, "/");
		sbsSwiftMsgFile.insert(0, sRepoSwift);

	    }
	}

	StringBuffer sbsSwiftLogFile = new StringBuffer();

	sSwiftLogFile = returnSwiftCtrlRecValues(bdCompanyCode).getLOG_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter

	// Remove the file name from the log path to be able to create the log
	// folder properly
	int j = sSwiftLogFile.lastIndexOf("/");
	// sSwiftLogFile = sSwiftLogFile.substring(0, j);//olivia
	if (j==-1) //HGhazal - Case of Windows OS - 05/05/2016
	{
		j = sSwiftLogFile.lastIndexOf("\\");
	}
	sbsSwiftLogFile.append(sSwiftLogFile.substring(0, j));

	if(sRepoSwift.endsWith("/"))
	{
	    // sSwiftLogFile = sRepoSwift + sSwiftLogFile;
	    sbsSwiftLogFile.insert(0, sRepoSwift);
	}
	else
	{
	    // sSwiftLogFile = sRepoSwift + "/" + sSwiftLogFile;
	    sbsSwiftLogFile.insert(0, "/");
	    sbsSwiftLogFile.insert(0, sRepoSwift);
	}

	File flSwiftMsg = null;
	try {
		flSwiftMsg = new PathFileSecure(sbsSwiftMsgFile.toString());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	if(flSwiftMsg != null && !flSwiftMsg.exists())
	{
	    try
	    {
		FileUtil.makeDirectories(sbsSwiftMsgFile.toString());
	    }
	    catch(Exception e)
	    {
		throw new BOException(e);
	    }
	}

	File flLogMsg = null;
	try {
		flLogMsg = new PathFileSecure(sbsSwiftLogFile.toString());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	if(flLogMsg != null && !flLogMsg.exists())
	{
	    try
	    {
		FileUtil.makeDirectories(sSwiftLogFile);
	    }
	    catch(Exception e)
	    {
		throw new BOException(e);
	    }
	}
	//

	// Update the next replication field with the same date but with the
	// sched time
	SwiftOutwardSC swiftOutSC = new SwiftOutwardSC();
	fixNextReplDateTime(swiftOutSC);

	// Update the Swift Engine Status to "ON - Swift Engine Started"
	updateEngineServiceStatus(bdCompanyCode, "SWIFT", 1, sLanguage, swiftOutSC);

	// Update the Swift Engine Refresh Rate
	updateRefreshRate(bdRefreshRate,"SWIFT");
    }

    @Override
    public Integer processScheduledSwiftReports(int iProcessInd, String sLanguage, BigDecimal bdCompanyCode,
	    BigDecimal bdBranchCode, String sUserId, SwiftCO theSwftCO, SwiftOutwardSC swiftOutwardSC,long threadId)
	    throws BaseException
    {
	int repCount;
	Date dtDbServerDateTime, dtNextReplDate;
	String sModule, sRepTitle = null, sApplication, sRepObj = null, sPeriodType, sSchedTime = null, sDateFrom = null, sDateTo = null, sMsgCode, sErrMsg, sSwiftFile = "";
	BigDecimal bdRepId, bdPeriod, bdPeriodDay, bdPerformance, bdCompCode = null, bdStatAcc, bdSchedId, bdBaseCy, bdTransFrom, bdTransTo;
	BigDecimal bdBranchFrom, bdBranchTo, bdCyFrom, bdCyTo, bdGlFrom, bdGlTo, bdCifFrom, bdCifTo, bdSlFrom, bdSlTo, bdCifReceiver, bdGenerateMsg, bdReqGen950, bdSuspendRepl, bdCheck950Trx;
	Long lReturnRes = null;
	int iSchedTime;
	Date dtDateFrom = null, dtDateTo = null, dtLastReplDate = null, dtDateFromTmp;
	Integer iReturnRes = null;
	String sVTDate, sNextTime, sRepoSwift;
	BigDecimal bdTrxCountBefore = null, bdTrxCountAfter,swenOutTrace = BigDecimal.ZERO;
	String[] saTransMsgArr;
	String sSchedTimeDB;

	SwiftCO swftCO = theSwftCO;
	String threadStatus;
	ArrayList<SwiftOutwardSchedRepCO> swiftOutSchedRepCO = new ArrayList<SwiftOutwardSchedRepCO>();
	
	threadStatus = returnThreadStatus(threadId);
	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus)))
		return 0;//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
	// SwiftCO swftCO = new SwiftCO(); // Create a new instance of this
	// object inside the method and not outside (at the level of the class)
	// in order not to overwrite the object properties in case 2 users are
	// calling the same method

	// Create the VOs objects outside the for loop in order not to create a
	// new instance in each iteration but there are some cases
	// where VOs must be created inside the for loop (e.g: a query is using
	// 3 fields in the where condition. If I set f1, f2 and f3 in the
	// first iteration, my query will return correct results. Now say, in
	// the 2nd iteration I set only f1 and f2, my query will return bad
	// results since f3 will have the same values as in the first iteration.
	// To avoid this malfunctioning, the VO must be created inside the for
	// loop in order to reset the object in each iteration
	COMPANIESVO companiesvo = new COMPANIESVO();
	SWIFT_TRS_LOGVO swiftTrsLogVO = new SWIFT_TRS_LOGVO();
	SWIFT_DWSCHEDVO swiftDwSchedVO = new SWIFT_DWSCHEDVO();

	SWIFT_TRS_LOGVO swftTrsLogVO;
	SWIFT_DWSCHEDVO swftDwSchedVO;

	// Create this dummy object here and send it to generateByReport as an
	// empty object. N.B: Send it as empty from processScheduledSwiftReports
	// only.
	ArrayList<SwiftRepListCO> swftRepListCO = new ArrayList<SwiftRepListCO>();

	char cPreviewSwiftMsg = 'N';

	dtDbServerDateTime = commonLibBO.returnSystemDateWithTime();
	swiftOutwardSC.setNextReplication(dtDbServerDateTime);

	swenOutTrace = selectSwenOutwardFlag();//efarah 23/05/2017 BMO160149
	
	sRepoSwift = FileUtil.getFileURLByName("repository");
	StringBuffer sbsSwiftFile = new StringBuffer();
	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("1"))
	{
		sSwiftFile = returnSwiftCtrlRecValues(bdCompanyCode).getSAVE_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    sbsSwiftFile.append(sSwiftFile);
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftFile.insert(0, "/"); // olivia
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	}

	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("2"))
	{
	    sSwiftFile = returnSwiftCtrlRecValues(bdCompanyCode).getDYNAMIC_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    sbsSwiftFile.append(sSwiftFile);
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftFile.insert(0, sRepoSwift);// olivia
	    }
	    else
	    {
		sbsSwiftFile.insert(0, "/"); // olivia
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	}

	//HGhazal - BMOI140016 - Engine Disconnection - 23/01/2017
	try {
	    updateLastPingDate();
	} catch (Exception e1) {
	    throw new BOException(e1);
	}
		
	bdPerformance = NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getPERFORMANCE());
	
	threadStatus = returnThreadStatus(threadId);
	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus)))
		return 0;//Mohamad Hojeij - 10/01/2018 - BMOUPI170756


	if(bdPerformance.equals(BigDecimal.ZERO))
	{
	    swiftOutSchedRepCO = swiftOutwardDAO.returnScheduledSwiftReports(swiftOutwardSC);
	}
	else
	{
	    swiftOutSchedRepCO = swiftOutwardDAO.returnScheduledSwiftReportsWithPerformance(swiftOutwardSC);
	}
	synchronized(lock)
	{
	    for(repCount = 0; repCount < swiftOutSchedRepCO.size(); repCount++)
	    {
	    	swftCO.setMsgFileName(null);//Mohamad Hojeij -- 26/09/2018
		//HGhazal - BMOI140016 - Engine Disconnection - 23/01/2017
	    	threadStatus = returnThreadStatus(threadId);
	    	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus)))
	    		return 0;//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
		try {
		    updateLastPingDate();
		} catch (Exception e1) {
		    throw new BOException(e1);
		}
		
		bdRepId = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwsVO().getREP_ID());
		bdCompCode = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getCOMP_CODE());
		sRepTitle = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftReportsVO().getREP_TITLE());
		
		if (swenOutTrace.equals(BigDecimal.ONE))
		{
		    sErrMsg = commonLibBO.returnTranslErrorMessage(5600, new String[] { bdRepId.toString()}, sLanguage);
		    writeLogFile(bdCompCode, BigDecimal.ZERO, "SWEN", 1, 'S', sErrMsg, sLanguage,swiftOutwardSC);
		}
		
		sModule = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftDwsVO().getMODULE());
		sApplication = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftReportsVO()
			.getAPP_NAME());
		sRepObj = StringUtil
			.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftReportsVO().getREP_OBJ_NAME());
		bdPeriod = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getPERIOD());
		sPeriodType = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			.getPERIOD_TYPE());
		bdPeriodDay = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			.getPERIOD_DAY());
		sSchedTime = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			.getSCHED_TIME());
		
		sSchedTimeDB = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getSCHED_TIME());

		sDateFrom = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getDATE_FROM());
		sDateTo = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getDATE_TO());
		bdTransFrom = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			.getTRANS_FROM());
		bdTransTo = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getTRANS_TO());

		bdStatAcc = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwsVO().getSTAT_ACC());
		dtNextReplDate = DateUtil.nullToInitDate(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			.getNEXT_REPLICATION());
		bdSchedId = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getSCHED_ID());

		// Get Company Base Currency
		companiesvo.setCOMP_CODE(bdCompCode);
		companiesvo = commonLibBO.returnCompany(companiesvo);
		bdBaseCy = companiesvo.getBASE_CURRENCY();
		//

		// Start KIB120007
		iSchedTime = 0;
		if(sSchedTime.trim().equals(""))
		{
		    iSchedTime = 1; // means that the user has explicitly filled
		    // the
		    // sched time with null or empty value.
		    // this indicates that we should not fill the sched time
		    // while
		    // we update the next replication
		    // in order to reserve the next replication time in case the
		    // message has to be generated every 2 minutes for e.g.
		}
		// End KIB120007

		if(bdPerformance.equals(BigDecimal.ONE))
		{
		    swiftTrsLogVO.setDW_NAME(sRepObj);
		    swftTrsLogVO = (SWIFT_TRS_LOGVO) genericDAO.selectByPK(swiftTrsLogVO);
		    bdTrxCountBefore = swftTrsLogVO.getTRX_COUNT();
		}

		if("LM".equals(sDateFrom)) // Beginning of Month
		{
		    dtDateFrom = DateUtil.getMonthFirstDay(dtDbServerDateTime);
		}

		else if("LN".equals(sDateFrom)) // Beginning of Month -1
		{
		    dtDateFrom = DateUtil.relativeDate(DateUtil.getMonthFirstDay(dtDbServerDateTime), -1);
		}

		else if("LD".equals(sDateFrom)) // Yesterday
		{
		    dtDateFrom = DateUtil.relativeDate(dtDbServerDateTime, -1);
		}

		else if("LW".equals(sDateFrom)) // Last Week
		{
		    dtDateFrom = DateUtil.relativeDate(dtDbServerDateTime, -7);
		}

		else if("LY".equals(sDateFrom)) // Last Year
		{
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(dtDbServerDateTime);
		    cal.set(cal.get(Calendar.YEAR), 0, 1);
		    dtDateFrom = cal.getTime();
		}

		else if("TD".equals(sDateFrom)) // Today
		{
		    dtDateFrom = dtDbServerDateTime;
		}

		else
		// Any Other Date
		{
		    if(!"".equals(sDateFrom))
		    {
			dtDateFrom = DateUtil.getFormatedDate(sDateFrom);
		    }
		}

		if("N".equals(sDateTo)) // Now
		{
		    dtDateTo = dtDbServerDateTime;
		}

		else
		// Any Other Date
		{
		    if(!"".equals(sDateTo))
		    {
			dtDateTo = DateUtil.getFormatedDate(sDateTo);
		    }
		}

		dtDateFrom = DateUtil.removeTimeFromDate(dtDateFrom);
		dtDateTo = DateUtil.removeTimeFromDate(dtDateTo);

		if(bdStatAcc.equals(BigDecimal.ONE)) // Process Statement of
		// Account
		// Swift Reports
		{
		    // SOA Parameterization Values
		    bdBranchFrom = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			    .getBRANCH_FROM());
		    bdBranchTo = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			    .getBRANCH_TO());
		    bdCyFrom = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getCY_FROM());
		    bdCyTo = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getCY_TO());
		    bdGlFrom = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getGL_FROM());
		    bdGlTo = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getGL_TO());
		    bdCifFrom = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			    .getCIF_FROM());
		    bdCifTo = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getCIF_TO());
		    bdSlFrom = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getSL_FROM());
		    bdSlTo = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO().getSL_TO());
		    bdCifReceiver = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			    .getRECEIVER_CIF());
		    sMsgCode = StringUtil.nullToEmpty(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			    .getMSG_CODE());
		    bdGenerateMsg = NumberUtil.nullToZero(swiftOutSchedRepCO.get(repCount).getSwiftDwschedVO()
			    .getGENERATE_MESSAGE());
		    //

		    // is_userid = as_userid // TODO

		    sVTDate = commonLibBO.returnSwiftCtrlRecValues().getCHECK_950_DATE();
		    
		    
		    SwiftProcNostroCO swiftProcNostroCO = new SwiftProcNostroCO();
		    swiftProcNostroCO.setCompCode(bdCompCode);
		    swiftProcNostroCO.getAmfVOFrom().setBRANCH_CODE(bdBranchFrom);
		    swiftProcNostroCO.getAmfVOFrom().setCURRENCY_CODE(bdCyFrom);
		    swiftProcNostroCO.getAmfVOFrom().setGL_CODE(bdGlFrom);
		    swiftProcNostroCO.getAmfVOFrom().setCIF_SUB_NO(bdCifFrom);
		    swiftProcNostroCO.getAmfVOFrom().setSL_NO(bdSlFrom);

		    swiftProcNostroCO.getAmfVOTo().setBRANCH_CODE(bdBranchTo);
		    swiftProcNostroCO.getAmfVOTo().setCURRENCY_CODE(bdCyTo);
		    swiftProcNostroCO.getAmfVOTo().setGL_CODE(bdGlTo);
		    swiftProcNostroCO.getAmfVOTo().setCIF_SUB_NO(bdCifTo);
		    swiftProcNostroCO.getAmfVOTo().setSL_NO(bdSlTo);
		    threadStatus = returnThreadStatus(threadId);
	    	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus)))
	    		return 0;//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
		    swiftOutwardDAO.deleteAccBalTmpByAccRange(swiftProcNostroCO);//commited apart

		    swiftOutwardDAO.deleteAccBalTmp1ByAccRange(swiftProcNostroCO);//commited apart
		    	

		    iReturnRes = insertIntoAccBalTmp(dtDateFrom, sVTDate, bdBranchFrom, bdBranchTo, bdCyFrom, bdCyTo,
			    bdGlFrom, bdGlTo, bdCifFrom, bdCifTo, bdSlFrom, bdSlTo, bdCompCode, bdBranchCode, sUserId,
			    sUserId, sLanguage, swftCO, swiftOutwardSC);

		    if(iReturnRes == -1)
		    {
			sErrMsg = swftCO.getErrorMsg().substring(0, 900);
			writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
			if (swenOutTrace.equals(BigDecimal.ONE))
			{
			    sErrMsg = commonLibBO.returnTranslErrorMessage(5601, new String[] { bdRepId.toString()}, sLanguage);
			    writeLogFile(bdCompCode, BigDecimal.ZERO, "SWEN", 1, 'S', sErrMsg, sLanguage,swiftOutwardSC);
			}
			continue;
		    }

		    iReturnRes = insertIntoAccBalTmp(dtDateTo, "V", bdBranchFrom, bdBranchTo, bdCyFrom, bdCyTo,
			    bdGlFrom, bdGlTo, bdCifFrom, bdCifTo, bdSlFrom, bdSlTo, bdCompCode, bdBranchCode, "AVAIL",
			    sUserId, sLanguage, swftCO, swiftOutwardSC);

		    if(iReturnRes == -1)
		    {
			sErrMsg = swftCO.getErrorMsg().substring(0, 900);
			writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
			if (swenOutTrace.equals(BigDecimal.ONE))
			{
			    sErrMsg = commonLibBO.returnTranslErrorMessage(5601, new String[] { bdRepId.toString()}, sLanguage);
			    writeLogFile(bdCompCode, BigDecimal.ZERO, "SWEN", 1, 'S', sErrMsg, sLanguage,swiftOutwardSC);
			}
			continue;
		    }

		    // Set the opening date in MT 950 in case of no transactions
		    // in
		    // server mode only
		    bdCheck950Trx = NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getCHECK_950_TRX());

		    if(bdCheck950Trx.equals(BigDecimal.ONE))
		    {
			swiftDwSchedVO.setREP_ID(bdRepId);
			swiftDwSchedVO.setMODULE(sModule);
			swiftDwSchedVO.setSCHED_ID(bdSchedId);

			swftDwSchedVO = (SWIFT_DWSCHEDVO) genericDAO.selectByPK(swiftDwSchedVO);
			dtLastReplDate = swftDwSchedVO.getLAST_REPLICATION();

			if(dtLastReplDate != null)
			{
			    dtDateFromTmp = DateUtil.relativeDate(dtLastReplDate, 1);
			    // Added the condition ldt_date_from_tmp >
			    // ldt_date_to in order to maintain same from date
			    // and to date in case the option was set to Today -
			    // BLME100071
			    if(dtDateFromTmp.compareTo(dtDateTo) < 0 || dtDateFromTmp.compareTo(dtDateTo) == 0)
			    {
				dtDateFrom = dtDateFromTmp;
			    }
			}
		    }

		    threadStatus = returnThreadStatus(threadId);
	    	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus)))
	    		return 0;//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
		    swftCO = generateByReportSOA(iProcessInd, bdBaseCy, bdCyFrom, bdGlFrom, bdCifFrom, bdSlFrom,
			    bdCyTo, bdGlTo, bdCifFrom, bdSlTo, dtDateFrom, dtDateTo, "ACC", bdCompCode, bdBranchFrom,
			    bdBranchTo, bdCifReceiver, sbsSwiftFile.toString(), sUserId, bdRepId, sRepTitle, 'S',
			    cPreviewSwiftMsg, sMsgCode, bdGenerateMsg, bdSchedId, bdBranchCode, sLanguage,
			    sApplication, swftCO, swiftOutwardSC, swftRepListCO,threadId);
		    
		    lReturnRes = swftCO.getReturnVar();
		    if(lReturnRes == -10)
		    {
		    	return 0;
		    }
		    if(lReturnRes == -1)
		    {
			sErrMsg = swftCO.getErrorMsg();
			writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
			if (swenOutTrace.equals(BigDecimal.ONE))
			{
			    sErrMsg = commonLibBO.returnTranslErrorMessage(5601, new String[] { bdRepId.toString()}, sLanguage);
			    writeLogFile(bdCompCode, BigDecimal.ZERO, "SWEN", 1, 'S', sErrMsg, sLanguage,swiftOutwardSC);
			}
			continue;
		    }

		    if(swftCO.getNbrTrxSOA().compareTo(BigDecimal.ZERO) == 1)
		    {
			// Update SWIFT_DWSCHED.LAST_REPLICATION
			swiftDwSchedVO.setREP_ID(bdRepId);
			swiftDwSchedVO.setMODULE(sModule);
			swiftDwSchedVO.setSCHED_ID(bdSchedId);
			swiftDwSchedVO.setLAST_REPLICATION(dtDateTo);

			try
			{
			    genericDAO.update(swiftDwSchedVO);
			}
			catch(DAOException e)
			{
			    sErrMsg = e.getMessage().substring(0, 900);
			    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
			}
		    }
		} // End Process Statement of Account Swift Reports

		else
		// Process Regular Reports (Not SOA)
		{
		    swftCO = generateByReport(iProcessInd, sModule, bdCompCode, bdBranchCode, bdTransFrom, bdTransTo,
			    dtDateFrom, dtDateTo, "P", sbsSwiftFile.toString(), dtDbServerDateTime, sUserId, bdRepId,
			    sRepTitle, 'S', cPreviewSwiftMsg, sLanguage, sApplication, swftCO, swiftOutwardSC,
			    swftRepListCO, BigDecimal.ZERO);

		    if(swftCO.getReturnVar() == -1)
		    {
			sErrMsg = swftCO.getErrorMsg();
			writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
			if (swenOutTrace.equals(BigDecimal.ONE))
			{
			    sErrMsg = commonLibBO.returnTranslErrorMessage(5601, new String[] { bdRepId.toString()}, sLanguage);
			    writeLogFile(bdCompCode, BigDecimal.ZERO, "SWEN", 1, 'S', sErrMsg, sLanguage,swiftOutwardSC);
			}
			continue;
		    }
		}

		if(bdPerformance.equals(BigDecimal.ONE) && iReturnRes != -1 && lReturnRes != -1
			&& !bdStatAcc.equals(BigDecimal.ONE))
		{
		    swiftTrsLogVO.setDW_NAME(sRepObj);
		    swftTrsLogVO = (SWIFT_TRS_LOGVO) genericDAO.selectByPK(swiftTrsLogVO);
		    bdTrxCountAfter = swftTrsLogVO.getTRX_COUNT();

		    if(NumberUtil.nullToZero(bdTrxCountBefore).equals(NumberUtil.nullToZero(bdTrxCountAfter)))
		    {
			swiftTrsLogVO.setCOUNTER(BigDecimal.ZERO);
			swiftTrsLogVO.setTRX_COUNT(BigDecimal.ZERO);
			try
			{
			    genericDAO.update(swiftTrsLogVO);
			}
			catch(DAOException e)
			{
			    sErrMsg = e.getMessage().substring(0, 900);
			    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
			}
		    }
		    else
		    {
			swiftTrsLogVO.setTRX_COUNT(bdTrxCountAfter.subtract(bdTrxCountBefore));
			try
			{
			    genericDAO.update(swiftTrsLogVO);
			}
			catch(DAOException e)
			{
			    sErrMsg = e.getMessage().substring(0, 900);
			    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
			}
		    }
		}

		iReturnRes = returnNextReplDateTime(dtNextReplDate, bdPeriod, sPeriodType, bdPeriodDay,
			dtDbServerDateTime, sLanguage, swftCO,sSchedTimeDB);

		if(iReturnRes == -1)
		{
		    saTransMsgArr = commonLibBO.returnTranslMessage(66670, sLanguage);
		    sErrMsg = saTransMsgArr[0]; // "Error Getting Next Scheduled Date"
		    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);

		}
		else
		{
		    // Start KIB120007
		    if(iSchedTime == 1)
		    {
			sNextTime = null;
		    }
		    else
		    {
			sNextTime = swftCO.getSchedTime();
		    }
		    // End KIB120007

		    // Get the value of REQ_GEN_950 before update
		    swiftDwSchedVO.setREP_ID(bdRepId);
		    swiftDwSchedVO.setMODULE(sModule);
		    swiftDwSchedVO.setSCHED_ID(bdSchedId);
		    swftDwSchedVO = (SWIFT_DWSCHEDVO) genericDAO.selectByPK(swiftDwSchedVO);
		    bdReqGen950 = NumberUtil.nullToZero(swftDwSchedVO.getREQ_GEN_950());
		    bdSuspendRepl = swftDwSchedVO.getSUSPEND_REPLICATION();
		    //

		    // Update the Next Replication and Time
		    if(bdReqGen950.equals(BigDecimal.ONE))
		    {
			swiftDwSchedVO.setSUSPEND_REPLICATION(BigDecimal.ONE);
		    }
		    else
		    {
			swiftDwSchedVO.setSUSPEND_REPLICATION(bdSuspendRepl);
		    }
		    //

		    swiftDwSchedVO.setNEXT_REPLICATION(swftCO.getNextReplication());
		    swiftDwSchedVO.setSCHED_TIME(sNextTime);

		    try
		    {
			genericDAO.update(swiftDwSchedVO);
		    }
		    catch(DAOException e)
		    {
			sErrMsg = e.getMessage().substring(0, 900);
			writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
		    }
		}
		if (swenOutTrace.equals(BigDecimal.ONE))
		{
		    sErrMsg = commonLibBO.returnTranslErrorMessage(5601, new String[] { bdRepId.toString()}, sLanguage);
		    writeLogFile(bdCompCode, BigDecimal.ZERO, "SWEN", 1, 'S', sErrMsg, sLanguage,swiftOutwardSC);
		}
	    }

	    if(repCount > 0)
	    {
		try
		{
		    swiftOutwardDAO.deleteSwiftDwSchedReqGen950(swiftOutwardSC);
		}
		catch(DAOException e)
		{
		    sErrMsg = e.getMessage().substring(0, 900);
		    writeLogFile(bdCompCode, BigDecimal.ZERO, sRepTitle, 0, 'S', sErrMsg, sLanguage, swiftOutwardSC);
		}
	    }
	}
	return 1;
    }
    
    public SwiftCO generateByReport(int iProcessInd, String sModule, BigDecimal bdCompCode, BigDecimal bdBranchCode,
    	    BigDecimal bdTransFrom, BigDecimal bdTransTo, Date theDtDateFrom, Date dtDateTo, String sTrxStatus,
    	    String theSwiftFile, Date dtDbServerDateTime, String sUserId, BigDecimal theRepId, String theSrepTitle,
    	    char cGenMode, char cPreviewSwiftMsg, String sLanguage, String sApplication, SwiftCO swftCO,
    	    SwiftOutwardSC swiftOutwardSC, ArrayList<SwiftRepListCO> swftRepListCO, BigDecimal bdSwiftTrxNo,long threadId)
    	    throws BaseException
        {
    	Integer iRepListCount;
    	boolean bRepSelected;
    	BigDecimal bdReportId = null, bdTrsNo, bdBrCode, bdNextTrsNo = null, bdNextBrCode = null;
    	String sReportTitle = null, sUpdateStmt = null, sSkipCond = null, sErrorCond = null, sRepSQL = null, sStr1, sStr2, sErrMsg ;
    	String[] saTransMsgArr;
    	ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep;
    	StringBuffer sSwiftMsg = new StringBuffer("");
    	int iSqlRowSize, iSqlColSize, iReturnRes;
    	String sSwiftFile = theSwiftFile;
    	BigDecimal bdRepId = theRepId;
    	String threadStatus;

    	String sRepTitle = theSrepTitle;
    	Date dtDateFrom = theDtDateFrom;

    	swftCO.setFileMode(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE());
    	swftCO.setSavePathJava(returnSwiftCtrlRecValues(bdCompCode).getSAVE_PATH_JAVA());//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
    	swftCO.setReturnVar(Long.valueOf(1));// olivia

    	
    	threadStatus = returnThreadStatus(threadId);
    	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    		swftCO.setReturnVar((long) -10);
    	}
    		//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
    	if("".equals(StringUtil.nullToEmpty(sSwiftFile)))
    	{
    		sSwiftFile = returnSwiftFileLocation(bdCompCode);//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter after creating same function existing in common files 
    	}

    	if(cGenMode == 'S')
    	{
    	    iRepListCount = 1;
    	    bdReportId = bdRepId;
    	    sReportTitle = sRepTitle;
    	}
    	else
    	{
    	    iRepListCount = swftRepListCO.size();
    	}
    	
    	threadStatus = returnThreadStatus(threadId);
    	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    		swftCO.setReturnVar((long) -10);
    	}
    		//Mohamad Hojeij - 10/01/2018 - BMOUPI170756

    	for(int repCount = 0; repCount < iRepListCount; repCount++)
    	{
    	    if(cGenMode == 'S')
    	    {
    		bRepSelected = true;
    	    }
    	    else
    	    {
    		bRepSelected = swftRepListCO.get(repCount).isRepSelected();
    	    }

    	    if(bRepSelected)
    	    {
    		if(cGenMode != 'S')
    		{
    		    bdReportId = swftRepListCO.get(repCount).getSwiftReportsVO().getREP_ID();
    		    bdRepId = bdReportId;
    		}

    		if(bdReportId.compareTo(BigDecimal.ZERO) == 1) // bdReportId > 0
    		{
    		    if(cGenMode != 'S')
    		    {
    			sReportTitle = swftRepListCO.get(repCount).getSwiftReportsVO().getREP_TITLE();
    		    }
    		    StringBuffer sbsReportTitle = new StringBuffer();
    		    if(cPreviewSwiftMsg == 'Y')
    		    {
    			saTransMsgArr = commonLibBO.returnTranslMessage(66671, sLanguage);
    			sbsReportTitle.append(saTransMsgArr[1]);
    			sbsReportTitle.append(" ");
    			sbsReportTitle.append(sReportTitle);
    			sRepTitle = sbsReportTitle.toString();
    		    }

    		    SWIFT_DWSVO swiftDws2VO = new SWIFT_DWSVO();
    		    swiftDws2VO.setREP_ID(bdReportId);
    		    SWIFT_DWSVO swftDws2VO;
    		    swftDws2VO = (SWIFT_DWSVO) genericDAO.selectByPK(swiftDws2VO);

    		    if(swftDws2VO != null)
    		    {
    			sUpdateStmt = swftDws2VO.getUPDATE_STMT();
    			sSkipCond = swftDws2VO.getSKIP_COND();
    			sErrorCond = swftDws2VO.getERROR_COND();
    		    }

    		    SWIFT_REPORTSVO swftRep2VO;
    		    swiftOutwardSC.setRepId(bdReportId);
    		    swftRep2VO = swiftOutwardDAO.returnSwiftReportsDetails(swiftOutwardSC);
    		    String queryType = "";
    		    
    		    

    		    if(swftRep2VO != null)
    		    {
    			sRepSQL = swftRep2VO.getREP_SQL();
    			queryType = StringUtil.nullToEmpty(swftRep2VO.getQUERY_TYPE());
    			if(!"Q".equals(queryType.toUpperCase(Locale.ENGLISH))
    				&& !"P".equals(queryType.toUpperCase(Locale.ENGLISH)))
    			{
    			    queryType = "Q";
    			}

    			if("Q".equals(queryType.toUpperCase(Locale.ENGLISH)))
    			{
    			    // CEO 26/03/2014 - Changed the logic of replacing ?
    			    // to
    			    // replace the argument name whenever used in SQL
    			    sRepSQL = sRepSQL.replaceAll(":ra_comp_code", bdCompCode.toString());
    			    sRepSQL = sRepSQL.replaceAll(":ra_trs_fr", bdTransFrom.toString());
    			    sRepSQL = sRepSQL.replaceAll(":ra_trs_to", bdTransTo.toString());
    			    sRepSQL = sRepSQL.replaceAll(":ra_trs_date_from", DateUtil.format(dtDateFrom, "dd-MMM-yyyy")
    				    .toString());
    			    sRepSQL = sRepSQL.replaceAll(":ra_trs_date_to", DateUtil.format(dtDateTo, "dd-MMM-yyyy")
    				    .toString());

    			    if(NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getPRINT_SWIFT()).equals(
    				    BigDecimal.ONE))
    			    {
    				sRepSQL = sRepSQL.replaceAll(":ra_status", sTrxStatus);
    			    }
    			    
    			    swiftOutwardSC.setTrsFromDate(dtDateFrom);
    			}
    			DynFilesSC dynFilesSC = new DynFilesSC();
    			threadStatus = returnThreadStatus(threadId);
    			if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    				swftCO.setReturnVar((long) -10);
    			}
    				//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
    			dynFilesSC.setDynamicSQL(sRepSQL);
    			
    			

    			// this line commented and replaced by the conversion
    			// function MItani 02/04/2014
    			// selectResultSqlRep =
    			// dynFilesDAO.returnDynFilesExecuteExportDynamicSQL(dynFilesSC);

    			ArrayList<Map<String, Object>> aListMapSqlRep;

    			// Added By MItani 31/01/2014
    			if("P".equals(queryType.toUpperCase(Locale.ENGLISH)))
    			{

    			    swiftOutwardSC.setCompCode(bdCompCode);
    			    swiftOutwardSC.setTrsFromNo(bdTransFrom);
    			    swiftOutwardSC.setTrsToNo(bdTransTo);
    			    swiftOutwardSC.setTrsFromDate(dtDateFrom);
    			    swiftOutwardSC.setTrsToDate(dtDateTo);
    			    swiftOutwardSC.setSReportProcedure(sRepSQL);
    			    swiftOutwardSC.setStatus(sTrxStatus);
    			}
    			
    			threadStatus = returnThreadStatus(threadId);
    			if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    				swftCO.setReturnVar((long) -10);
    			}
    				//Mohamad Hojeij - 10/01/2018 - BMOUPI170756

    			aListMapSqlRep = swiftOutwardDAO.returnSwiftLinkedHashMapDynamicSQL(dynFilesSC, swiftOutwardSC,
    				queryType);
    			
    			threadStatus = returnThreadStatus(threadId);
    			if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    				swftCO.setReturnVar((long) -10);
    			}
    				//Mohamad Hojeij - 10/01/2018 - BMOUPI170756

    			/**
    			 * Check if bdSwiftTrxNo is one => message already
    			 * generated or if iSqlRowSize = 0 => no message MItani
    			 * 01/04/2014
    			 **/
    			if(aListMapSqlRep != null && "P".equals(queryType.toUpperCase(Locale.ENGLISH)))
    			{
    			    iSqlRowSize = aListMapSqlRep.size();
    			    // Check if the swift message has been already
    			    // generated and
    			    // display a message accordingly
    			    if(NumberUtil.nullToZero(bdSwiftTrxNo).equals(BigDecimal.ONE))
    			    {
//    				saTransMsgArr = commonLibBO.returnTranslMessage(66701, sLanguage);
//    				//throw new BOException(saTransMsgArr[0]); // Swift
//    				writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', saTransMsgArr[0], sLanguage,
//    						swiftOutwardSC);
//    					swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    					//continue;
    				// Message
    				// has been already
    				// generated!
    			    }
    			    if(iSqlRowSize == 0)
    			    {
//    					saTransMsgArr = commonLibBO.returnTranslMessage(66699, sLanguage);//efarah 28/04/2017 stoppin the engine
//    					//throw new BOException(saTransMsgArr[0]); // No
//    					writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', saTransMsgArr[0], sLanguage,
//    							swiftOutwardSC);
//    						swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    						//continue;
    				// SWIFT
    				// Message
    				// To be Printed!
    			    }
    			}

    			
    			selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);
    			
    			threadStatus = returnThreadStatus(threadId);
    			if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    				swftCO.setReturnVar((long) -10);
    			}
    				//Mohamad Hojeij - 10/01/2018 - BMOUPI170756

    			if(selectResultSqlRep != null)
    			{
    			    iSqlRowSize = selectResultSqlRep.size();
    			    
    			    if (NumberUtil.nullToZero(bdSwiftTrxNo).equals(BigDecimal.ONE)) {
//    					saTransMsgArr = commonLibBO.returnTranslMessage(66701, sLanguage);
//    					//throw new BOException(saTransMsgArr[0]); // Swift
//    					writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', saTransMsgArr[0], sLanguage,
//    							swiftOutwardSC);
//    						swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    						//continue;
    					// Message
    					// has been already
    					// generated!
    				}
    			    
    			    if (iSqlRowSize == 0) {
//    					saTransMsgArr = commonLibBO.returnTranslMessage(66701, sLanguage);
//    					//throw new BOException(saTransMsgArr[0]); // No SWIFT
//    					writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', saTransMsgArr[0], sLanguage,
//    							swiftOutwardSC);
//    						swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    						//continue;
    					// Message
    					// To be Printed!
    				}

    			  //get the report expressions of computed fields Mhmd Itani 05/05/2014
    			    ArrayList<SWIFT_DWS_CFVO> alExpressionList= swiftOutwardDAO.returnSoaExpressions(swiftOutwardSC);
    			    // Loop on transactions retrieved between a range of
    			    // number and date		    
    				   
    			    for(SWIFT_DWS_CFVO expression :alExpressionList)
    			    {
    				String computedField, computedFieldExpression;
    				computedField = expression.getCF_NAME();
    				Object expressionValue;
    				Map<String, Object> mp;
    				for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
    				{
    				    mp = aListMapSqlRep.get(sqlRowCount);
    				    computedFieldExpression = expression.getCF_EXPRESSION();
    				    expressionValue = commonLibBO.executeExpression(computedFieldExpression,
    					    sqlRowCount, aListMapSqlRep);
    				    mp.put(computedField, expressionValue);
    				    aListMapSqlRep.set(sqlRowCount, mp);
    				}
    					
    			    }			   
    			    selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);
    			    
    			    threadStatus = returnThreadStatus(threadId);
    				if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    					swftCO.setReturnVar((long) -10);
    				}
    				StringBuffer sbsSwiftMsg = new StringBuffer();
    					//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
    			    for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
    			    {
    			    	BigDecimal swiftTrxNo = BigDecimal.ZERO;//LBedrane when copying KIB170005 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
//    				String computedField,computedFieldExpression ;				
//    				Map<String,Object> mp=aListMapSqlRep.get(sqlRowCount);
    //
//    				//executing expressions of computed fields Mhmd Itani 05/05/2014    
//    				for(SWIFT_DWS_CFVO expression :alExpressionList)
//    				{				   				
//    					computedField =expression.getCF_NAME();
//    					computedFieldExpression = expression.getCF_EXPRESSION();
//    					mp.put(computedField, commonLibBO.executeExpression(computedFieldExpression, sqlRowCount, aListMapSqlRep));	
//                                           aListMapSqlRep.set(sqlRowCount, mp);				    
//    				}				
//    				selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);				
    				
    				swftCO.setSkipRepetitiveMsg(0);
    				iSqlColSize = selectResultSqlRep.get(sqlRowCount).size();

    				// Set the ACK/NACK counter in Engine -
    				// ASYAI120129
    				setSeqValue(selectResultSqlRep, sqlRowCount, iSqlColSize, "CF_ACK_NACK");

    				// bdSeqAckNak = (BigDecimal)
    				// returnColumnValue(selectResultSqlRep,
    				// sqlRowCount,
    				// iSqlColSize, "CF_ACK_NACK");////commented by
    				// Olivia due to Jenkin issues
    				// "UnusedLocalVariable"

    				bdTrsNo = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,
    					"TRS_NO");
    				bdBrCode = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,
    					"BRANCH_CODE");

    				if(sqlRowCount + 1 < iSqlRowSize)
    				{
    				    bdNextTrsNo = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount + 1,
    					    iSqlColSize, "TRS_NO");
    				    bdNextBrCode = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount + 1,
    					    iSqlColSize, "BRANCH_CODE");
    				}

    				sStr1 = "00" + StringUtil.nullToEmpty(bdBrCode).toString() + " - "
    					+ StringUtil.nullToEmpty(bdTrsNo).toString();
    				sStr2 = "00" + StringUtil.nullToEmpty(bdNextBrCode).toString() + " - "
    					+ StringUtil.nullToEmpty(bdNextTrsNo).toString();

    				if((!StringUtil.nullToEmpty(sStr1).equals(sStr2) || sqlRowCount == iSqlRowSize - 1)
    					&& cPreviewSwiftMsg == 'N')
    				{

    				    try
    				    {
    					swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "N", sUpdateStmt,
    						sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
    				    }
    				    catch(Exception e)
    				    {
    					sErrMsg = e.getMessage();
    					writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
    						swiftOutwardSC);
    					swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    					continue;
    				    }

    				}

    				try
    				{
    					try
    					{
    					  
    						//LBedrane when copying KIB170005 605700  we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<Start>
    						//swiftOutwardTransBO.updateSwiftTrxNo(selectedTransactionsList, "N", sUpdateStmt, iTrxCount,  iSqlColSize, sLanguage, swiftOutwardSC);
    						swiftTrxNo = swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "N",sUpdateStmt, sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
    						//LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<End>
    					}
    					catch(Exception e)
    					{
    					    sErrMsg = e.getMessage();
    					    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'M', sErrMsg, sLanguage, swiftOutwardSC);
    					    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    					    continue;
    					}
    					threadStatus = returnThreadStatus(threadId);
    					if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
    						swftCO.setReturnVar((long) -10);
    					}
    						//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
    				    iReturnRes = swiftOutwardTransBO.createMessage(iProcessInd, selectResultSqlRep,
    					    sqlRowCount, iSqlColSize, bdCompCode, sSkipCond, sErrorCond, sSwiftFile,
    					    cPreviewSwiftMsg, cGenMode, sApplication, swftCO, sLanguage, bdRepId,
    					    sRepTitle, swiftOutwardSC, aListMapSqlRep,swiftTrxNo);
    				    swftCO.setReturnVar(Long.valueOf(iReturnRes));
    				    if(iReturnRes == -1)
    				    {
    					// Reset SWIFT_TRX_NO to NULL since it
    					// was updated to 1 one step above
    					swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "Y", sUpdateStmt,
    						sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
    					swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());// olivia

    				    }

    				    sSwiftMsg = new StringBuffer(StringUtil.nullToEmpty(swftCO.getSwiftMessage()));
    				    sbsSwiftMsg.append(sSwiftMsg);
    				    if("".equals(sSwiftMsg) || "null".equals(sSwiftMsg))
    				    {
    					// Return the error message to
    					// PrintSwiftMainAction
    					swftCO.setSwiftMessage("");
    				    }
    				    else
    				    {
    					// Return the swift message to
    					// PrintSwiftMainAction
    					if(sqlRowCount < iSqlRowSize - 1 && swftCO.getSkipRepetitiveMsg() == 0)
    					{
    					    sbsSwiftMsg.append("\r\n");
    					    sbsSwiftMsg.append("$");
    					    sbsSwiftMsg.append("\r\n");
    					}
    					sSwiftMsg = sbsSwiftMsg;
    					swftCO.setSwiftMessage(sbsSwiftMsg.toString());
    				    }
    				}
    				catch(BOException ex)	
    				{
    				    // Reset SWIFT_TRX_NO to NULL since it was
    				    // updated to 1
    				    // one step above
    				    swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "Y", sUpdateStmt,
    					    sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);// olivia

    				    String theMessage = commonLibBO.translateErrorMessage(ex, sLanguage)[0];
    				    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', theMessage, sLanguage,
    					    swiftOutwardSC);
    				    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    				    swftCO.setReturnVar(-1L);// olivia
    				    if(cPreviewSwiftMsg == 'Y')
    				    {
    					throw ex;
    				    }
    				    else
    				    {
    					continue;
    				    }
    				}
    				catch(Exception e)
    				{
    				    // Reset SWIFT_TRX_NO to NULL since it was
    				    // updated to 1
    				    // one step above
    				    swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "Y", sUpdateStmt,
    					    sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);// olivia
    				    sErrMsg = e.getMessage();
    				    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
    					    swiftOutwardSC);
    				    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
    				    swftCO.setReturnVar(-1L);// olivia
    				    // Display the error message on the screen
    				    // in case of Print Swift Action
    				    if(cPreviewSwiftMsg == 'Y')
    				    {
    					throw new BOException(sErrMsg, e);
    				    }
    				    else
    				    {
    					continue;
    				    }
    				    //
    				}
    			    }// End Loop
    			}
    		    }

    		    /*
    		     * LinkedHashMap<String, BigDecimal> columns = new
    		     * LinkedHashMap<String, BigDecimal>();
    		     * columns=dynFilesBO.retrieveColumnsFromSelect
    		     * (columns,sRepSQL.replace(DynFilesConstant.CARRIAGE_RETURN
    		     * + DynFilesConstant.NEW_LINE, " "), false); Iterator it =
    		     * columns.entrySet().iterator(); while(it.hasNext()) {
    		     * Map.Entry element = (Map.Entry) it.next();
    		     * System.out.println(element.getKey());
    		     * System.out.println(element.getValue()); }
    		     */
    		}
    	    }
    	}
    	
    	swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());//HGhazal - add in all cases - 19/02/2016

    	// delete the Swift file if empty
    	if(cPreviewSwiftMsg == 'N' && swftCO.getMsgFileName() != null)
    	{
    	    deleteEmptyFile(swftCO.getMsgFileName(), bdCompCode, bdRepId, sRepTitle, sLanguage, swiftOutwardSC);
    	}

    	/*
    	 * CEO 31-01-2014 commented the below and used Long.valueOf(long)
    	 * instead since it allows caching by JVM and code will be faster
    	 */
    	 /*swftCO.setReturnVar(new Long(1)); */
    	// swftCO.setReturnVar(Long.valueOf(1));//olivia

    	return swftCO;
        }

    public SwiftCO generateByReport(int iProcessInd, String sModule, BigDecimal bdCompCode, BigDecimal bdBranchCode,
	    BigDecimal bdTransFrom, BigDecimal bdTransTo, Date theDtDateFrom, Date dtDateTo, String sTrxStatus,
	    String theSwiftFile, Date dtDbServerDateTime, String sUserId, BigDecimal theRepId, String theSrepTitle,
	    char cGenMode, char cPreviewSwiftMsg, String sLanguage, String sApplication, SwiftCO swftCO,
	    SwiftOutwardSC swiftOutwardSC, ArrayList<SwiftRepListCO> swftRepListCO, BigDecimal bdSwiftTrxNo)
	    throws BaseException
    {
	Integer iRepListCount;
	boolean bRepSelected;
	BigDecimal bdReportId = null, bdTrsNo, bdBrCode, bdNextTrsNo = null, bdNextBrCode = null;
	String sReportTitle = null, sUpdateStmt = null, sSkipCond = null, sErrorCond = null, sRepSQL = null, sStr1, sStr2, sErrMsg;
	String[] saTransMsgArr;
	ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep;
	int iSqlRowSize, iSqlColSize, iReturnRes;
	String sSwiftFile = theSwiftFile;
	BigDecimal bdRepId = theRepId;
	BigDecimal swiftTrxNo = BigDecimal.ZERO;//LBedrane when copying KIB170005 605700  we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<Start>
	StringBuffer sSwiftMsg = new StringBuffer("");
	String sRepTitle = theSrepTitle;
	Date dtDateFrom = theDtDateFrom;

	StringBuffer sbsSwiftLogFile = new StringBuffer();
	String sRepoSwift;
	swftCO.setFileMode(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE());// olivia
	swftCO.setSavePathJava(commonLibBO.returnSwiftCtrlRecValues().getSAVE_PATH_JAVA());// olivia
	swftCO.setReturnVar(Long.valueOf(1));// olivia
	
    sRepoSwift = FileUtil.getFileURLByName("repository");
    sbsSwiftLogFile.append(commonLibBO.returnSwiftCtrlRecValues().getLOG_PATH_JAVA());
    if(sRepoSwift.endsWith("/"))
    {
    	sbsSwiftLogFile.insert(0, sRepoSwift);
    }
    else
    {
		sbsSwiftLogFile.insert(0, "/");
		sbsSwiftLogFile.insert(0, sRepoSwift);
    }
    
	//Fares Kassab - 05/09/2018 - RIDB180231 - SWIFT message preview on ITRS PI 
    swiftOutwardSC.setLogFileLocation(sbsSwiftLogFile.toString());
    
	swftCO.setFileMode(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE());
	swftCO.setSavePathJava(returnSwiftCtrlRecValues(bdCompCode).getSAVE_PATH_JAVA());//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	swftCO.setReturnVar(Long.valueOf(1));// olivia

	if("".equals(StringUtil.nullToEmpty(sSwiftFile)))
	{
	    sSwiftFile = returnSwiftFileLocation(bdCompCode);//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	}

	if(cGenMode == 'S')
	{
	    iRepListCount = 1;
	    bdReportId = bdRepId;
	    sReportTitle = sRepTitle;
	}
	else
	{
	    iRepListCount = swftRepListCO.size();
	}

	for(int repCount = 0; repCount < iRepListCount; repCount++)
	{
	    if(cGenMode == 'S')
	    {
		bRepSelected = true;
	    }
	    else
	    {
		bRepSelected = swftRepListCO.get(repCount).isRepSelected();
	    }

	    if(bRepSelected)
	    {
		if(cGenMode != 'S')
		{
		    bdReportId = swftRepListCO.get(repCount).getSwiftReportsVO().getREP_ID();
		    bdRepId = bdReportId;
		}

		if(bdReportId.compareTo(BigDecimal.ZERO) == 1) // bdReportId > 0
		{
		    if(cGenMode != 'S')
		    {
			sReportTitle = swftRepListCO.get(repCount).getSwiftReportsVO().getREP_TITLE();
		    }
		    StringBuffer sbsReportTitle = new StringBuffer();
		    if(cPreviewSwiftMsg == 'Y')
		    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66671, sLanguage);
			sbsReportTitle.append(saTransMsgArr[1]);
			sbsReportTitle.append(" ");
			sbsReportTitle.append(sReportTitle);
			sRepTitle = sbsReportTitle.toString();
		    }

		    SWIFT_DWSVO swiftDws2VO = new SWIFT_DWSVO();
		    swiftDws2VO.setREP_ID(bdReportId);
		    SWIFT_DWSVO swftDws2VO;
		    swftDws2VO = (SWIFT_DWSVO) genericDAO.selectByPK(swiftDws2VO);

		    if(swftDws2VO != null)
		    {
			sUpdateStmt = swftDws2VO.getUPDATE_STMT();
			sSkipCond = swftDws2VO.getSKIP_COND();
			sErrorCond = swftDws2VO.getERROR_COND();
		    }

		    SWIFT_REPORTSVO swftRep2VO;
		    swiftOutwardSC.setRepId(bdReportId);
		    swftRep2VO = swiftOutwardDAO.returnSwiftReportsDetails(swiftOutwardSC);
		    String queryType = "";

		    if(swftRep2VO != null)
		    {
			sRepSQL = swftRep2VO.getREP_SQL();
			queryType = StringUtil.nullToEmpty(swftRep2VO.getQUERY_TYPE());
			if(!"Q".equals(queryType.toUpperCase(Locale.ENGLISH))
				&& !"P".equals(queryType.toUpperCase(Locale.ENGLISH)))
			{
			    queryType = "Q";
			}

			if("Q".equals(queryType.toUpperCase(Locale.ENGLISH)))
			{
			    // CEO 26/03/2014 - Changed the logic of replacing ?
			    // to
			    // replace the argument name whenever used in SQL
			    sRepSQL = sRepSQL.replaceAll(":ra_comp_code", bdCompCode.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_trs_fr", bdTransFrom.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_trs_to", bdTransTo.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_trs_date_from", DateUtil.format(dtDateFrom, "dd-MMM-yyyy")
				    .toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_trs_date_to", DateUtil.format(dtDateTo, "dd-MMM-yyyy")
				    .toString());

			    if(NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getPRINT_SWIFT()).equals(
				    BigDecimal.ONE))
			    {
				sRepSQL = sRepSQL.replaceAll(":ra_status", sTrxStatus);
			    }
			    
			    swiftOutwardSC.setTrsFromDate(dtDateFrom);
			}
			DynFilesSC dynFilesSC = new DynFilesSC();
			dynFilesSC.setDynamicSQL(sRepSQL);

			// this line commented and replaced by the conversion
			// function MItani 02/04/2014
			// selectResultSqlRep =
			// dynFilesDAO.returnDynFilesExecuteExportDynamicSQL(dynFilesSC);

			ArrayList<Map<String, Object>> aListMapSqlRep;

			// Added By MItani 31/01/2014
			if("P".equals(queryType.toUpperCase(Locale.ENGLISH)))
			{

			    swiftOutwardSC.setCompCode(bdCompCode);
			    swiftOutwardSC.setTrsFromNo(bdTransFrom);
			    swiftOutwardSC.setTrsToNo(bdTransTo);
			    swiftOutwardSC.setTrsFromDate(dtDateFrom);
			    swiftOutwardSC.setTrsToDate(dtDateTo);
			    swiftOutwardSC.setSReportProcedure(sRepSQL);
			    swiftOutwardSC.setStatus(sTrxStatus);
			}
			
			//Mohamad Hojeij apply trace props 22/03/2018
			BaseObject baseObj=new BaseObject();
			/*LBedrane 27/04/2018 #661072 - Error at the level of print swift <start>*/
			//baseObj.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
			//swiftOutwardSC.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
			if (swiftOutwardSC.getTraceAppName()== null || swiftOutwardSC.getTraceAppName().isEmpty()){
				
				baseObj.applyTraceProps(swftCO.getTraceAppName(),swftCO.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
			}
			else {
				baseObj.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
			}
			/*LBedrane 27/04/2018 #661072 - Error at the level of print swift <End>*/
			
		    //genericDAO.callSqlSessionTrace(baseObj, "r:" + swiftOutwardSC.getProgRef() +" ra:SWFT", swiftOutwardDAO.returnConnection());//conn :null;   in sched : sessionId nul

			aListMapSqlRep = swiftOutwardDAO.returnSwiftLinkedHashMapDynamicSQL(dynFilesSC, swiftOutwardSC,
				queryType);

			/**
			 * Check if bdSwiftTrxNo is one => message already
			 * generated or if iSqlRowSize = 0 => no message MItani
			 * 01/04/2014
			 **/
			if(aListMapSqlRep != null && "P".equals(queryType.toUpperCase(Locale.ENGLISH)))
			{
			    iSqlRowSize = aListMapSqlRep.size();
			    // Check if the swift message has been already
			    // generated and
			    // display a message accordingly
			    if(NumberUtil.nullToZero(bdSwiftTrxNo).equals(BigDecimal.ONE))
			    {
//				saTransMsgArr = commonLibBO.returnTranslMessage(66701, sLanguage);
//				throw new BOException(saTransMsgArr[0]); // Swift
				// Message
				// has been already
				// generated!
			    }
			    if(iSqlRowSize == 0)
			    {
//				saTransMsgArr = commonLibBO.returnTranslMessage(66699, sLanguage);
//				throw new BOException(saTransMsgArr[0]); // No
				// SWIFT
				// Message
				// To be Printed!
			    }
			}

			
			selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);

			if(selectResultSqlRep != null)
			{
			    iSqlRowSize = selectResultSqlRep.size();

			  //get the report expressions of computed fields Mhmd Itani 05/05/2014
			    ArrayList<SWIFT_DWS_CFVO> alExpressionList= swiftOutwardDAO.returnSoaExpressions(swiftOutwardSC);
			    // Loop on transactions retrieved between a range of
			    // number and date		    
				   
			    for(SWIFT_DWS_CFVO expression :alExpressionList)
			    {
				String computedField, computedFieldExpression;
				computedField = expression.getCF_NAME();
				Object expressionValue;
				Map<String, Object> mp;
				for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
				{
				    mp = aListMapSqlRep.get(sqlRowCount);
				    computedFieldExpression = expression.getCF_EXPRESSION();
				    expressionValue = commonLibBO.executeExpression(computedFieldExpression,
					    sqlRowCount, aListMapSqlRep);
				    mp.put(computedField, expressionValue);
				    aListMapSqlRep.set(sqlRowCount, mp);
				}
					
			    }			   
			    selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);
			    StringBuffer sbsSwiftMsg = new StringBuffer();
			    for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
			    {
//				String computedField,computedFieldExpression ;				
//				Map<String,Object> mp=aListMapSqlRep.get(sqlRowCount);
//
//				//executing expressions of computed fields Mhmd Itani 05/05/2014    
//				for(SWIFT_DWS_CFVO expression :alExpressionList)
//				{				   				
//					computedField =expression.getCF_NAME();
//					computedFieldExpression = expression.getCF_EXPRESSION();
//					mp.put(computedField, commonLibBO.executeExpression(computedFieldExpression, sqlRowCount, aListMapSqlRep));	
//                                       aListMapSqlRep.set(sqlRowCount, mp);				    
//				}				
//				selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);				
				
				swftCO.setSkipRepetitiveMsg(0);
				iSqlColSize = selectResultSqlRep.get(sqlRowCount).size();

				// Set the ACK/NACK counter in Engine -
				// ASYAI120129
				setSeqValue(selectResultSqlRep, sqlRowCount, iSqlColSize, "CF_ACK_NACK");

				// bdSeqAckNak = (BigDecimal)
				// returnColumnValue(selectResultSqlRep,
				// sqlRowCount,
				// iSqlColSize, "CF_ACK_NACK");////commented by
				// Olivia due to Jenkin issues
				// "UnusedLocalVariable"

				bdTrsNo = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,
					"TRS_NO");
				bdBrCode = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,
					"BRANCH_CODE");

				if(sqlRowCount + 1 < iSqlRowSize)
				{
				    bdNextTrsNo = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount + 1,
					    iSqlColSize, "TRS_NO");
				    bdNextBrCode = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount + 1,
					    iSqlColSize, "BRANCH_CODE");
				}

				sStr1 = "00" + StringUtil.nullToEmpty(bdBrCode).toString() + " - "
					+ StringUtil.nullToEmpty(bdTrsNo).toString();
				sStr2 = "00" + StringUtil.nullToEmpty(bdNextBrCode).toString() + " - "
					+ StringUtil.nullToEmpty(bdNextTrsNo).toString();

				if((!StringUtil.nullToEmpty(sStr1).equals(sStr2) || sqlRowCount == iSqlRowSize - 1)
					&& cPreviewSwiftMsg == 'N')
				{

				    try
				    {
				    //updated by LBedrane when copying KIB170005 605700  we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
				    	swiftTrxNo = 	swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "N", sUpdateStmt,
						sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
				    }
				    catch(Exception e)
				    {
					sErrMsg = e.getMessage();
					writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
						swiftOutwardSC);
					swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
					continue;
				    }

				}

				try
				{
				    iReturnRes = swiftOutwardTransBO.createMessage(iProcessInd, selectResultSqlRep,
					    sqlRowCount, iSqlColSize, bdCompCode, sSkipCond, sErrorCond, sSwiftFile,
					    cPreviewSwiftMsg, cGenMode, sApplication, swftCO, sLanguage, bdRepId,
					    sRepTitle, swiftOutwardSC, aListMapSqlRep,swiftTrxNo);//Updated by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9) 
				    swftCO.setReturnVar(Long.valueOf(iReturnRes));
				    if(iReturnRes == -1)
				    {
					// Reset SWIFT_TRX_NO to NULL since it
					// was updated to 1 one step above
					swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "Y", sUpdateStmt,
						sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
					swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());// olivia

				    }

				    sSwiftMsg = new StringBuffer(StringUtil.nullToEmpty(swftCO.getSwiftMessage()));
				    sbsSwiftMsg.append(sSwiftMsg);
				    if("".equals(sSwiftMsg.toString()) || "null".equals(sSwiftMsg.toString()))
				    {
					// Return the error message to
					// PrintSwiftMainAction
					swftCO.setSwiftMessage("");
				    }
				    else
				    {
					// Return the swift message to
					// PrintSwiftMainAction
					if(sqlRowCount < iSqlRowSize - 1 && swftCO.getSkipRepetitiveMsg() == 0)
					{
					    sbsSwiftMsg.append("\r\n");
					    sbsSwiftMsg.append("$");
					    sbsSwiftMsg.append("\r\n");
					}
					sSwiftMsg = sbsSwiftMsg;
					swftCO.setSwiftMessage(sbsSwiftMsg.toString());
				    }
				}
				catch(BOException ex)
				{
				    // Reset SWIFT_TRX_NO to NULL since it was
				    // updated to 1
				    // one step above
				    swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "Y", sUpdateStmt,
					    sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);// olivia

				    String theMessage = commonLibBO.translateErrorMessage(ex, sLanguage)[0];
				    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', theMessage, sLanguage,
					    swiftOutwardSC);
				    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
				    swftCO.setReturnVar(-1L);// olivia
				    if(cPreviewSwiftMsg == 'Y')
				    {
					throw ex;
				    }
				    else
				    {
					continue;
				    }
				}
				catch(Exception e)
				{
				    // Reset SWIFT_TRX_NO to NULL since it was
				    // updated to 1
				    // one step above
				    swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "Y", sUpdateStmt,
					    sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);// olivia
				    sErrMsg = e.getMessage();
				    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
					    swiftOutwardSC);
				    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
				    swftCO.setReturnVar(-1L);// olivia
				    // Display the error message on the screen
				    // in case of Print Swift Action
				    if(cPreviewSwiftMsg == 'Y')
				    {
					throw new BOException(sErrMsg, e);
				    }
				    else
				    {
					continue;
				    }
				    //
				}
			    }// End Loop
			}
		    }

		    /*
		     * LinkedHashMap<String, BigDecimal> columns = new
		     * LinkedHashMap<String, BigDecimal>();
		     * columns=dynFilesBO.retrieveColumnsFromSelect
		     * (columns,sRepSQL.replace(DynFilesConstant.CARRIAGE_RETURN
		     * + DynFilesConstant.NEW_LINE, " "), false); Iterator it =
		     * columns.entrySet().iterator(); while(it.hasNext()) {
		     * Map.Entry element = (Map.Entry) it.next();
		     * System.out.println(element.getKey());
		     * System.out.println(element.getValue()); }
		     */
		}
	    }
	}
	
	swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());//HGhazal - add in all cases - 19/02/2016

	// delete the Swift file if empty
	if(cPreviewSwiftMsg == 'N' && swftCO.getMsgFileName() != null)
	{
	    deleteEmptyFile(swftCO.getMsgFileName(), bdCompCode, bdRepId, sRepTitle, sLanguage, swiftOutwardSC);
	}

	 /*
	 * CEO 31-01-2014 commented the below and used Long.valueOf(long)
	 * instead since it allows caching by JVM and code will be faster
	 */
	 /*swftCO.setReturnVar(new Long(1));*/ 
	// swftCO.setReturnVar(Long.valueOf(1));//olivia

	return swftCO;
    }

    public SwiftCO generateByReportSOA(int iProcessInd, BigDecimal bdBaseCy, BigDecimal bdCyFrom, BigDecimal bdGlFrom,
	    BigDecimal bdCifFrom, BigDecimal bdSlFrom, BigDecimal bdCyTo, BigDecimal bdGlTo, BigDecimal bdCifTo,
	    BigDecimal bdSlTo, Date theDtDateFrom, Date dtDateTo, String sModule, BigDecimal bdCompCode,
	    BigDecimal bdBranchFrom, BigDecimal bdBranchTo, BigDecimal bdCifReceiver, String theSwiftFile,
	    String sUserId, BigDecimal bdRepId, String sRepTitle, char cGenMode, char cPreviewSwiftMsg,
	    String sMsgCode, BigDecimal bdGenerateMsg, BigDecimal bdSchedId, BigDecimal bdBranchCode, String sLanguage,
	    String sApplication, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC,
	    ArrayList<SwiftRepListCO> theSwftRepSOAListCO,long threadId) throws BaseException
    {

	Integer iRepListCount, iCheck950Trx = 0;
	BigDecimal bdReportId = null, bdSeq, bdSoaNbrTrx;
	
	
	String[] saTransMsgArr;
	String sSwiftFile = theSwiftFile;
	ArrayList<SwiftRepListCO> swftRepSOAListCO = theSwftRepSOAListCO;
	StringBuffer sbsSwiftLogFile = new StringBuffer();
	String sRepoSwift;
	String threadStatus;
	swftCO.setFileMode(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE());// olivia
	swftCO.setSavePathJava(commonLibBO.returnSwiftCtrlRecValues().getSAVE_PATH_JAVA());// olivia
	swftCO.setReturnVar(Long.valueOf(1));// olivia
	
    sRepoSwift = FileUtil.getFileURLByName("repository");
    sbsSwiftLogFile.append(commonLibBO.returnSwiftCtrlRecValues().getLOG_PATH_JAVA());
    if(sRepoSwift.endsWith("/"))
    {
	sbsSwiftLogFile.insert(0, sRepoSwift);
    }
    else
    {
	sbsSwiftLogFile.insert(0, "/");
	sbsSwiftLogFile.insert(0, sRepoSwift);
    }
    
    threadStatus = returnThreadStatus(threadId);
   	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
   		swftCO.setReturnVar((long) -10);
   	}
   		//Mohamad Hojeij - 10/01/2018 - BMOUPI170756

    swiftOutwardSC.setLogFileLocation(sbsSwiftLogFile.toString());
	

	
	if("".equals(StringUtil.nullToEmpty(sSwiftFile)))// olivia
	{
	    sSwiftFile = returnSwiftFileLocation(bdCompCode);// olivia
	}
	
	swftCO.setNbrTrxSOA(BigDecimal.ZERO);

	if(cGenMode == 'S')
	{
	    iRepListCount = 1;
	    bdReportId = bdRepId;
	    // sReportTitle = sRepTitle;//commented by Olivia due to Jenkin
	    // issues "UnusedLocalVariable"
	}
	else
	{
	    swftRepSOAListCO = swiftOutwardDAO.returnSwiftSOAReportsList(swiftOutwardSC);
	    iRepListCount = swftRepSOAListCO.size();
	}
	threadStatus = returnThreadStatus(threadId);
	if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
		swftCO.setReturnVar((long) -10);
	}
		//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
	

//	if(iRepListCount == 0)
//	{
//	    saTransMsgArr = commonLibBO.returnTranslMessage(66768, sLanguage);
//	    writeLogFile(bdCompCode, BigDecimal.ZERO, "", 0, cGenMode, saTransMsgArr[0], sLanguage, swiftOutwardSC);
//	    swftCO.setErrorMsg(saTransMsgArr[0]);
//	    swftCO.setReturnVar(-1L);
//	    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
//	    return swftCO;
//	}
	
	int iReturnHol = callSwiftHolidaySP(bdCompCode, bdBranchCode, null, swiftOutwardSC);
	
	String sUpdateStmt = null, sRepSQL = null;
	String sErrMsg, sHdrDet, sSkipCond = "", sErrorCond = "";
	ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep;
	int iSqlRowSize, iSqlColSize = 0;
	Date dtNextDateAfterHol;
	Date dtDateFrom = theDtDateFrom;
	
	for(int repCount = 0; repCount < iRepListCount; repCount++)
	{
	    if(cGenMode != 'S')
	    {
		bdReportId = swftRepSOAListCO.get(repCount).getSwiftReportsVO().getREP_ID();
		// sReportTitle =
		// swftRepSOAListCO.get(repCount).getSwiftReportsVO().getREP_TITLE();//commented
		// by Olivia due to Jenkin issues "UnusedLocalVariable"
	    }

	    if(bdReportId.compareTo(BigDecimal.ZERO) == 1) // bdReportId > 0
	    {		
		swiftOutwardSC.setRepId(bdReportId);
		SWIFT_DWSVO swiftDws2VO = new SWIFT_DWSVO();
		swiftDws2VO.setREP_ID(bdReportId);
		SWIFT_DWSVO swftDws2VO;
		swftDws2VO = (SWIFT_DWSVO) genericDAO.selectByPK(swiftDws2VO);
   
		if(swftDws2VO != null)
		{
		    sUpdateStmt = swftDws2VO.getUPDATE_STMT();
		    sSkipCond = swftDws2VO.getSKIP_COND();
		    sErrorCond = swftDws2VO.getERROR_COND();
		}

		if(bdGenerateMsg != null && bdGenerateMsg.intValue() == 2 && iReturnHol == 0)
		{
		    SWIFT_DWSCHEDVO swiftDwSched2VO = new SWIFT_DWSCHEDVO();
		    swiftDwSched2VO.setREP_ID(bdReportId);
		    swiftDwSched2VO.setMODULE(sModule);
		    swiftDwSched2VO.setSCHED_ID(bdSchedId);

		    SWIFT_DWSCHEDVO swftDwSched2VO = (SWIFT_DWSCHEDVO) genericDAO.selectByPK(swiftDwSched2VO);
		    dtNextDateAfterHol = swftDwSched2VO.getNEXT_DATE_AFTER_HOL();

		    if(dtNextDateAfterHol == null)
		    {
			dtDateFrom = commonLibBO.returnSystemDateWithTime();
		    }
		    else
		    {
			dtDateFrom = DateUtil.relativeDate(dtNextDateAfterHol, 1);
		    }
		}

		// bdGenerateMsg 1: Always 2: Business Days Only
		// iReturnHol 1: Holiday 0: Not Holiday

		if(bdGenerateMsg != null && bdGenerateMsg.intValue() == 2 && iReturnHol == 1)
		{
		    saTransMsgArr = commonLibBO.returnTranslMessage(66676, sLanguage); // SWIFT
		    // Message
		    // cannot
		    // be
		    // generated
		    // on
		    // Holidays
		    writeLogFile(bdCompCode, bdReportId, sRepTitle, 2, cGenMode, saTransMsgArr[0], sLanguage,
			    swiftOutwardSC);
		}
		else
		{
		    SWIFT_REPORTSVO swiftRep2VO = new SWIFT_REPORTSVO();
		    swiftRep2VO.setREP_ID(bdReportId);
		    SWIFT_REPORTSVO swftRep2VO;
		    swftRep2VO = (SWIFT_REPORTSVO) genericDAO.selectByPK(swiftRep2VO);
		    String queryType = "";
		    if(swftRep2VO != null)
		    {
			queryType = StringUtil.nullToEmpty(swftRep2VO.getQUERY_TYPE());
			if(!"Q".equals(queryType.toUpperCase(Locale.ENGLISH))
				&& !"P".equals(queryType.toUpperCase(Locale.ENGLISH)))
			{
			    queryType = "Q";
			}
			sRepSQL = swftRep2VO.getREP_SQL();

			if("Q".equals(queryType.toUpperCase(Locale.ENGLISH)))
			{
			    sRepSQL = sRepSQL.replaceAll(":ra_comp_code", bdCompCode.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_fr_cy", bdCyFrom.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_fr_gl", bdGlFrom.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_fr_cif", bdCifFrom.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_fr_sl", bdSlFrom.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_to_cy", bdCyTo.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_to_gl", bdGlTo.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_to_cif", bdCifTo.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_to_sl", bdSlTo.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_date_fr", DateUtil.format(dtDateFrom, "dd-MMM-yyyy").toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_date_to", DateUtil.format(dtDateTo, "dd-MMM-yyyy").toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_base_cy", bdBaseCy.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_branch_fr", bdBranchFrom.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_branch_to", bdBranchTo.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_cif_receiver", bdCifReceiver.toString());
			    sRepSQL = sRepSQL.replaceAll(":ra_userid",sUserId);
			    sRepSQL = sRepSQL.replaceAll(":ra_msg_code",sMsgCode);
			    sRepSQL = sRepSQL.replaceAll(":ra_log_in_branch", bdBranchCode.toString());
			    
			    swiftOutwardSC.setTrsFromDate(dtDateFrom);
			    
			}
			
			threadStatus = returnThreadStatus(threadId);
			if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
				swftCO.setReturnVar((long) -10);
			}
				//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
			


			DynFilesSC dynFilesSC = new DynFilesSC();
			dynFilesSC.setDynamicSQL(sRepSQL);
			ArrayList<Map<String, Object>> aListMapSqlRep; // = new
			// ArrayList<Map<String,
			// Object>>();olivia
			// Added By MItani 31/03/2014
//			if("P".equals(queryType.toUpperCase(Locale.ENGLISH)))
//			{
////			   not done
//			}

			swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
			aListMapSqlRep = swiftOutwardDAO.returnSwiftLinkedHashMapDynamicSQL(dynFilesSC, swiftOutwardSC,
				queryType);
			
			threadStatus = returnThreadStatus(threadId);
			if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
				swftCO.setReturnVar((long) -10);
			}
				//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
			

			
			if( aListMapSqlRep == null || (aListMapSqlRep.isEmpty()))
			{
			    selectResultSqlRep = null;
			    //saTransMsgArr = commonLibBO.returnTranslMessage(????, sLanguage);
			    sErrMsg = commonLibBO.returnTranslErrorMessage(66770, new String[] {bdRepId.toString()}, sLanguage);
				
			    writeLogFile(bdCompCode, BigDecimal.ZERO, "", 0, cGenMode, sErrMsg, sLanguage, swiftOutwardSC);
			    swftCO.setErrorMsg(sErrMsg);
			    swftCO.setReturnVar(-1L);
			    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
			    return swftCO;
			}
			else
			{
			    selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);
			}
			threadStatus = returnThreadStatus(threadId);
			if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
				swftCO.setReturnVar((long) -10);
			}
				//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
			

			
			if(selectResultSqlRep != null)
			{
			    iSqlRowSize = selectResultSqlRep.size();  
			    //get the report expressions of computed fields Mhmd Itani 05/05/2014
			    ArrayList<SWIFT_DWS_CFVO> alExpressionList= swiftOutwardDAO.returnSoaExpressions(swiftOutwardSC);
			   
			    for(SWIFT_DWS_CFVO expression :alExpressionList)
			    {
				String computedField, computedFieldExpression;
				computedField = expression.getCF_NAME();
				Object expressionValue;
				Map<String, Object> mp;
				for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
				{
				    mp = aListMapSqlRep.get(sqlRowCount);
				    computedFieldExpression = expression.getCF_EXPRESSION();
				    expressionValue = commonLibBO.executeExpression(computedFieldExpression,
					    sqlRowCount, aListMapSqlRep);
				    mp.put(computedField, expressionValue);
				    aListMapSqlRep.set(sqlRowCount, mp);
				}
					
			    }
			    selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);
			    for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
			    {		
				iSqlColSize = selectResultSqlRep.get(sqlRowCount).size();
				
				sHdrDet = (String) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,"CF_HDR_DET");	
					
				bdSeq =(BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,"seq");
								
				if(sHdrDet == "H")
				{
				    bdSoaNbrTrx = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount,iSqlColSize, "NBR_TRX");
				    swftCO.setNbrTrxSOA(bdSoaNbrTrx);
				    if(commonLibBO.returnSwiftCtrlRecValues().getCHECK_950_TRX() == null)
				    {
					iCheck950Trx = 1; // 1 means 'No' as per
					// Swift Control
					// Record
				    }
				    if((bdSoaNbrTrx.compareTo(BigDecimal.ZERO) == 1) || (iCheck950Trx == 0))
				    {
					try
					{
					  //HGhazal- catch return value - 17/02/2016
						int iReturnRes;
						threadStatus = returnThreadStatus(threadId);
						if ("K".equals(StringUtil.nullToEmpty(threadStatus)) || "".equals(StringUtil.nullToEmpty(threadStatus))){
							swftCO.setReturnVar((long) -10);
						}
							//Mohamad Hojeij - 10/01/2018 - BMOUPI170756

						iReturnRes = swiftOutwardTransBO.createMessage(iProcessInd, selectResultSqlRep,
						    sqlRowCount, iSqlColSize, bdCompCode, sSkipCond, sErrorCond,
						    sSwiftFile, cPreviewSwiftMsg, cGenMode, sApplication, swftCO,
						    sLanguage, bdReportId, sRepTitle, swiftOutwardSC, aListMapSqlRep,BigDecimal.ZERO);//Updated by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9) 
						
						if (iReturnRes == -1)
						{
						    swftCO.setReturnVar(Long.valueOf(iReturnRes));
							swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
							return swftCO;
						}
					}
					catch(BOException ex) // olivia added this exception
					// this exception
					{

					    String theMessage = commonLibBO.translateErrorMessage(ex, sLanguage)[0];
					    writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', theMessage, sLanguage,
						    swiftOutwardSC);
					}
					catch(Exception e)
					{
					    sErrMsg = e.getMessage();
					    writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
						    swiftOutwardSC);
					}

					try
					{
					    if(NumberUtil.nullToZero(bdSeq).equals(BigDecimal.ONE))
					    {
						swiftOutwardTransBO.updateStmtNbr(selectResultSqlRep, sUpdateStmt,
							sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
					    }
					}
					catch(Exception e)
					{
					    sErrMsg = e.getMessage();
					    writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
						    swiftOutwardSC);
					}
				    }
				    else
				    {
					saTransMsgArr = commonLibBO.returnTranslMessage(66678, sLanguage); // Statement
					// of
					// Account
					// Message
					// was
					// not
					// generated.
					// No
					// transactions
					// in
					// the
					// given
					// range
					writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', saTransMsgArr[0],
						sLanguage, swiftOutwardSC);
				    }
				}
			    }// End Loop
			}
		    }
		}
	    }
	}

	if(bdGenerateMsg.equals(new BigDecimal(2)) && iReturnHol == 0 && iSqlColSize > 0)
	{
	    // Update SWIFT_DWSCHED.NEXT_DATE_AFTER_HOL
	    SWIFT_DWSCHEDVO swiftDwSched3VO = new SWIFT_DWSCHEDVO();
	    swiftDwSched3VO.setREP_ID(bdReportId);
	    swiftDwSched3VO.setMODULE(sModule);
	    swiftDwSched3VO.setSCHED_ID(bdSchedId);
	    swiftDwSched3VO.setNEXT_DATE_AFTER_HOL(dtDateTo);

	    try
	    {
		genericDAO.update(swiftDwSched3VO);
	    }
	    catch(DAOException e)
	    {
		sErrMsg = e.getMessage().substring(0, 900);
		swftCO.setErrorMsg(sErrMsg);

		/*
		 * CEO 31-01-2014 commented the below and used
		 * Long.valueOf(long) instead since it allows caching by JVM and
		 * code will be faster
		 */
		/* return new Long(-1); */
		swftCO.setReturnVar(-1L);// olivia
		swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
		return swftCO;
	    }
	}
	
	swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());//HGhazal - add in all cases - 19/02/2016

	// delete the Swift file if empty
	if(cPreviewSwiftMsg == 'N' && swftCO.getMsgFileName() != null)
	{
	    deleteEmptyFile(swftCO.getMsgFileName(), bdCompCode, bdReportId, sRepTitle, sLanguage, swiftOutwardSC);
	}

	return swftCO;
    }

    public SwiftCO generateByTrx(int iProcessInd, ArrayList<SwiftTrxListCO> swftTrxListCO, BigDecimal bdCompCode,
	    BigDecimal bdBranchCode, String theSwiftFile, Date dtDbServerDateTime, String sUserId, BigDecimal bdRepId,
	    String sRepTitle, char cPreviewSwiftMsg, String sApplication, String sLanguage, SwiftCO swftCO,
	    SwiftOutwardSC theSwiftOutwardSC, ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep,
	    BigDecimal bdFromTrsNo, BigDecimal bdToTrsNo, Date dtFromTrsDate, Date dtToTrsDate) throws BaseException
    {
	boolean bTrxSelected;
	
	BigDecimal bdTrsNo, bdBrCode, bdNextTrsNo = null, bdNextBrCode = null;
	String sUpdateStmt = null, sSkipCond = null, sErrorCond = null, sStr1, sStr2 = "", sErrMsg, sSwiftMsg = "", sRepSQL;
	int iReturnRes, iSqlColSize, iSqlRowSize;
	SwiftOutwardSC swiftOutwardSC = theSwiftOutwardSC;
	String sSwiftFile = theSwiftFile;

	DynFilesSC dynFilesSC = new DynFilesSC();
	swftCO.setFileMode(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE());
	swftCO.setSavePathJava(returnSwiftCtrlRecValues(bdCompCode).getSAVE_PATH_JAVA());//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter

	if("".equals(StringUtil.nullToEmpty(sSwiftFile)))
	{
	    sSwiftFile = returnSwiftFileLocation(bdCompCode);//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	}

	// Get Swift Report SQL to send to createMessage
	String queryType = "";
	SWIFT_REPORTSVO swftRepVO;
	swiftOutwardSC.setRepId(bdRepId);
	swftRepVO = swiftOutwardDAO.returnSwiftReportsDetails(swiftOutwardSC);
	if(swftRepVO != null)
	{
	    sRepSQL = swftRepVO.getREP_SQL();

	    queryType = StringUtil.nullToEmpty(swftRepVO.getQUERY_TYPE());
	    if(!"Q".equals(queryType.toUpperCase(Locale.ENGLISH)) && !"P".equals(queryType.toUpperCase(Locale.ENGLISH)))
	    {
		queryType = "Q";
	    }

	    if("Q".equals(queryType.toUpperCase(Locale.ENGLISH)))

	    {
		// CEO 26/03/2014 - Changed the logic of replacing ? to replace
		// the
		// argument name whenever used in SQL
		sRepSQL = sRepSQL.replaceAll(":ra_comp_code", bdCompCode.toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_fr", bdFromTrsNo.toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_to", bdToTrsNo.toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_date_from", DateUtil.format(dtFromTrsDate, "dd-MMM-yyyy")
			.toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_date_to", DateUtil.format(dtToTrsDate, "dd-MMM-yyyy").toString());

		if(NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getPRINT_SWIFT())
			.equals(BigDecimal.ONE))
		{
		    sRepSQL = sRepSQL.replaceAll(":ra_status", "P");
		}
		swiftOutwardSC.setTrsFromDate(dtFromTrsDate);
	    }
	    dynFilesSC.setDynamicSQL(sRepSQL);
	}

	ArrayList<Map<String, Object>> aListMapSqlRep;// = new
	// ArrayList<Map<String,Object>>(); Added By MItani 31/03/2014
	if("P".equals(queryType.toUpperCase(Locale.ENGLISH)))
	{
	    swiftOutwardSC.setCompCode(bdCompCode);
	    swiftOutwardSC.setTrsFromNo(bdFromTrsNo);
	    swiftOutwardSC.setTrsToNo(bdToTrsNo);
	    swiftOutwardSC.setTrsFromDate(dtFromTrsDate);
	    swiftOutwardSC.setTrsToDate(dtToTrsDate);
	    swiftOutwardSC.setSReportProcedure(dynFilesSC.getDynamicSQL());
	    swiftOutwardSC.setStatus("P");
	}
	//mOHAMAD Hojeij apply trace props
	BaseObject baseObj=new BaseObject();
	baseObj.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
    //swiftOutwardSC.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
    //genericDAO.callSqlSessionTrace(baseObj, "r:" + swiftOutwardSC.getProgRef() +" ra:SWFT", swiftOutwardDAO.returnConnection());//conn :null;   in sched : sessionId nul
//    genericDAO.insertTempSessionDetails(language, runningDate, userId, appName)

	aListMapSqlRep = swiftOutwardDAO.returnSwiftLinkedHashMapDynamicSQL(dynFilesSC, swiftOutwardSC, queryType);
	ArrayList<Map<String,Object>> filteredList = filterByTrsNo(swftTrxListCO,aListMapSqlRep);
	aListMapSqlRep = filteredList;	
	
	// if(cPreviewSwiftMsg == 'Y')
	// {
	// saTransMsgArr = commonLibBO.returnTranslMessage(66671, sLanguage);
	// }commented by olivia 12/03/2014 jenkin DLS_DEAD_LOCAL_STORE

	iSqlRowSize = swftTrxListCO.size();

	//get the report expressions of computed fields Mhmd Itani 05/05/2014
	    ArrayList<SWIFT_DWS_CFVO> alExpressionList= swiftOutwardDAO.returnSoaExpressions(swiftOutwardSC);
	    String computedField,computedFieldExpression ;				
	   

	//executing expressions of computed fields Mhmd Itani 05/05/2014 
	ArrayList<ArrayList<DynFilesColumnCO>> selectedTransactionsList = selectResultSqlRep;   
	if(iSqlRowSize > 0)
	{
	    for(SWIFT_DWS_CFVO expression : alExpressionList)
	    {
		Map<String, Object> mp;
		for(int iTrxCount = 0; iTrxCount < iSqlRowSize; iTrxCount++)
		{
		    mp = aListMapSqlRep.get(iTrxCount);
		    computedField = expression.getCF_NAME();
		    computedFieldExpression = expression.getCF_EXPRESSION();
		    mp.put(computedField, commonLibBO.executeExpression(computedFieldExpression, iTrxCount,
			    aListMapSqlRep));
		    aListMapSqlRep.set(iTrxCount, mp);
		}
	    }
	    selectedTransactionsList = convertFromAListHashMapToAListOfALists(aListMapSqlRep);	
	}
	
	for(int iTrxCount = 0; iTrxCount < iSqlRowSize; iTrxCount++)
	{
		BigDecimal swiftTrxNo = BigDecimal.ZERO;//LBedrane when copying KIB170005 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
	    
	    iSqlColSize = selectedTransactionsList.get(iTrxCount).size();

	    bTrxSelected = swftTrxListCO.get(iTrxCount).isTrxSelected();

	    if(bTrxSelected)
	    {
		bdTrsNo = swftTrxListCO.get(iTrxCount).getTrsNo();
		bdBrCode = swftTrxListCO.get(iTrxCount).getBranchCode();

		SWIFT_DWSVO swiftDwsVO = new SWIFT_DWSVO();
		swiftDwsVO.setREP_ID(bdRepId);
		SWIFT_DWSVO swftDwsVO;
		swftDwsVO = (SWIFT_DWSVO) genericDAO.selectByPK(swiftDwsVO);

		if(swftDwsVO != null)
		{
		    sUpdateStmt = swftDwsVO.getUPDATE_STMT();
		    sSkipCond = swftDwsVO.getSKIP_COND();
		    sErrorCond = swftDwsVO.getERROR_COND();
		}

		/*if(iTrxCount + 1 < iSqlRowSize)
		{
		    bdNextTrsNo = swftTrxListCO.get(iTrxCount + 1).getTrsNo();
		    bdNextBrCode = swftTrxListCO.get(iTrxCount + 1).getBranchCode();
		    sStr2 = "00" + bdNextBrCode.toString() + " - " + bdNextTrsNo.toString();// olivia
		}

		sStr1 = "00" + bdBrCode.toString() + " - " + bdTrsNo.toString();
		// sStr2 = "00" + bdNextBrCode.toString() + " - " +
		// bdNextTrsNo.toString();olivia

		if((!sStr1.equals(sStr2) || iTrxCount == iSqlRowSize - 1) && cPreviewSwiftMsg == 'N')*/
		if(iTrxCount + 1 < iSqlRowSize)
		{
		    bdNextTrsNo = (BigDecimal) returnColumnValue(selectResultSqlRep, iTrxCount + 1,
			    iSqlColSize, "TRS_NO");
		    bdNextBrCode = (BigDecimal) returnColumnValue(selectResultSqlRep, iTrxCount + 1,
			    iSqlColSize, "BRANCH_CODE");
		}

		sStr1 = "00" + StringUtil.nullToEmpty(bdBrCode).toString() + " - "
			+ StringUtil.nullToEmpty(bdTrsNo).toString();
		sStr2 = "00" + StringUtil.nullToEmpty(bdNextBrCode).toString() + " - "
			+ StringUtil.nullToEmpty(bdNextTrsNo).toString();

		if((!StringUtil.nullToEmpty(sStr1).equals(sStr2) || iTrxCount == iSqlRowSize - 1)
			&& cPreviewSwiftMsg == 'N')
		{

		    try
		    {
			try
			{
			  
				//LBedrane when copying KIB170005 605700  we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<Start>
				//swiftOutwardTransBO.updateSwiftTrxNo(selectedTransactionsList, "N", sUpdateStmt, iTrxCount,  iSqlColSize, sLanguage, swiftOutwardSC);
				swiftTrxNo = swiftOutwardTransBO.updateSwiftTrxNo(selectedTransactionsList, "N",sUpdateStmt, iTrxCount, iSqlColSize, sLanguage, swiftOutwardSC);
				//LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<End>
			}
			catch(Exception e)
			{
			    sErrMsg = e.getMessage();
			    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'M', sErrMsg, sLanguage, swiftOutwardSC);
			    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
			    continue;
			}

		    }
		    catch(Exception e)
		    {
			sErrMsg = e.getMessage();
			writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'M', sErrMsg, sLanguage, swiftOutwardSC);
			continue;
		    }

		}

		try
		{
		    iReturnRes = swiftOutwardTransBO.createMessage(iProcessInd, selectedTransactionsList, iTrxCount,
			    iSqlColSize, bdCompCode, sSkipCond, sErrorCond, sSwiftFile, cPreviewSwiftMsg, 'M',
			    sApplication, swftCO, sLanguage, bdRepId, sRepTitle, swiftOutwardSC, aListMapSqlRep,swiftTrxNo);//Updated by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9) 

		    swftCO.setReturnVar(Long.valueOf(iReturnRes));
		    if(iReturnRes == -1)// olivia
		    // if(iReturnRes != -1)

		    {
			// Reset SWIFT_TRX_NO to NULL since it was updated to 1
			// one step above
			swiftOutwardTransBO.updateSwiftTrxNo(selectedTransactionsList, "Y", sUpdateStmt, iTrxCount,
				iSqlColSize, sLanguage, swiftOutwardSC);

			sErrMsg = swftCO.getErrorMsg();
			//writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'M', sErrMsg, sLanguage, swiftOutwardSC);
			swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
		    }
		    sSwiftMsg = StringUtil.nullToEmpty(sSwiftMsg + swftCO.getSwiftMessage());
		    StringBuffer sbsSwiftMsg = new StringBuffer();
		    sbsSwiftMsg.append(sSwiftMsg);
		    if("".equals(sSwiftMsg.toString()) || "null".equals(sSwiftMsg.toString()))
		    {
			// Return the error message to
			// PrintSwiftMainAction
			swftCO.setSwiftMessage("");
		    }
		    else
		    {
			// Return the swift message to
			// PrintSwiftMainAction
			if(iTrxCount < iSqlRowSize - 1 && swftCO.getSkipRepetitiveMsg() == 0)
			{
			    sbsSwiftMsg.append("\r\n");
			    sbsSwiftMsg.append("$");
			    sbsSwiftMsg.append("\r\n");
			}
			sSwiftMsg = sbsSwiftMsg.toString();
			swftCO.setSwiftMessage(sbsSwiftMsg.toString());
		    }
		    
		}
		catch(BOException ex) // olivia added this exception
		{
		    // Reset SWIFT_TRX_NO to NULL since it was updated to 1
		    // one step above
		    swiftOutwardTransBO.updateSwiftTrxNo(selectedTransactionsList, "Y", sUpdateStmt, iTrxCount, iSqlColSize,
			    sLanguage, swiftOutwardSC);
		    swftCO.setReturnVar(-1L);
		    String theMessage = commonLibBO.translateErrorMessage(ex, sLanguage)[0];
		    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'M', theMessage, sLanguage, swiftOutwardSC);
		    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
		    // Display the error message on the screen in case of Print
		    // Swift Action
		    if(cPreviewSwiftMsg == 'Y')
		    {
			throw ex;
		    }
		    else
		    {
			continue;
		    }
		    //
		}
		catch(Exception e)
		{
		    // Reset SWIFT_TRX_NO to NULL since it was updated to 1
		    // one step above
		    swiftOutwardTransBO.updateSwiftTrxNo(selectedTransactionsList, "Y", sUpdateStmt, iTrxCount, iSqlColSize,
			    sLanguage, swiftOutwardSC);
		    swftCO.setReturnVar(-1L);
		    sErrMsg = e.getMessage();
		    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'M', sErrMsg, sLanguage, swiftOutwardSC);
		    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
		    // Display the error message on the screen in case of Print
		    // Swift Action
		    if(cPreviewSwiftMsg == 'Y')
		    {
			throw new BOException(sErrMsg, e);
		    }
		    else
		    {
			continue;
		    }
		    //
		}
	    }
	}
	
	swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());//HGhazal - add in all cases - 19/02/2016

	// delete the Swift file if empty
	if(cPreviewSwiftMsg == 'N' && swftCO.getMsgFileName() != null)
	{
	    deleteEmptyFile(swftCO.getMsgFileName(), bdCompCode, bdRepId, sRepTitle, sLanguage, swiftOutwardSC);
	}

	return swftCO;
    }

    private int callSwiftHolidaySP(BigDecimal bdCompCode, BigDecimal bdBranchCode, Date theDtValueDate,
	    SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	Date dtValueDate = theDtValueDate;

	if(dtValueDate == null)
	{
	    dtValueDate = commonLibBO.returnSystemDateWithTime();
	}

	swiftOutwardSC.setCompCode(bdCompCode);
	swiftOutwardSC.setBranchCode(bdBranchCode);
	swiftOutwardSC.setHolValueDate(dtValueDate);

	swiftOutwardDAO.returnSwiftHoliday(swiftOutwardSC);

	int iHolidayCode = swiftOutwardSC.getHolidayCode();

	return iHolidayCode;
    }

    public Object returnColumnValue(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount,
	    int sqlColSize, String columnNameIn)
    {
	String sColName, columnName = columnNameIn;
	Object objVal = null;
	for(int sqlColCount = 0; sqlColCount < sqlColSize; sqlColCount++)
	{
	    sColName = selectResultSqlRep.get(sqlRowCount).get(sqlColCount).getColumnName();
	    if(StringUtil.nullToEmpty(sColName.toUpperCase(Locale.ENGLISH)).equals(
		    columnName.toUpperCase(Locale.ENGLISH)))
	    {
		objVal = selectResultSqlRep.get(sqlRowCount).get(sqlColCount).getColumnValue();
		break;
	    }
	}
	return objVal;
    }

    public void updateColumnValue(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount,
	    int sqlColSize, String columnName, Object columnValue)
    {
	String sColName;
	for(int sqlColCount = 0; sqlColCount < sqlColSize; sqlColCount++)
	{
	    sColName = selectResultSqlRep.get(sqlRowCount).get(sqlColCount).getColumnName();
	    if(StringUtil.nullToEmpty(sColName.toUpperCase(Locale.ENGLISH)).equals(
		    columnName.toUpperCase(Locale.ENGLISH)))
	    {
		selectResultSqlRep.get(sqlRowCount).get(sqlColCount).setColumnValue(columnValue);
		break;
	    }
	}
    }

    private void setSeqValue(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount,
	    int sqlColSize, String columnName) throws BaseException
    {
	String sColName;
	BigDecimal bdVal = null;
	DBSequenceSC dbSeqSC = new DBSequenceSC();
	dbSeqSC.setSequenceName("SWIFT_ID_SEQ");
	dbSeqSC.setTableName("SWIFT_IDENTITY");

	for(int sqlColCount = 0; sqlColCount < sqlColSize; sqlColCount++)
	{
	    sColName = selectResultSqlRep.get(sqlRowCount).get(sqlColCount).getColumnName();
	    if(StringUtil.nullToEmpty(sColName.toUpperCase(Locale.ENGLISH)).equals(
		    columnName.toUpperCase(Locale.ENGLISH)))
	    {
		bdVal = commonLibBO.returnTableSequence(dbSeqSC);
		selectResultSqlRep.get(sqlRowCount).get(sqlColCount).setColumnValue(bdVal);
		break;
	    }
	}
    }

    public StringBuffer fillSQLInputArgs(StringBuffer currSQL, String argValue, int paramNo)
    {
	int loop = 0;
	int indexOfInputParam = 0;
	int controlCharLength = DynFilesConstant.CONTROL_CHAR.length();

	// loop to get the position of this tag
	while(loop < paramNo)
	{
	    indexOfInputParam = currSQL.indexOf(DynFilesConstant.CONTROL_CHAR, indexOfInputParam + 1);
	    loop++;
	}

	// if the value is null then replace accordingly
	if(argValue == null)
	{
	    // if the value is null, we need to check if a ' character exists,
	    // meaning this is a text
	    // we need to remove the control character and the ' to place the
	    // null
	    if(currSQL.substring(indexOfInputParam - 1, indexOfInputParam).equals("'")
		    && currSQL.substring(indexOfInputParam + controlCharLength,
			    indexOfInputParam + controlCharLength + 1).equals("'"))
	    {
		currSQL.replace(indexOfInputParam - 1, indexOfInputParam + controlCharLength + 2, "null"
			+ DynFilesConstant.CONTROL_CHAR);
	    }
	    else
	    {
		currSQL.replace(indexOfInputParam, indexOfInputParam + controlCharLength + 1, "null"
			+ DynFilesConstant.CONTROL_CHAR);
	    }
	}
	// replace the value where applicable
	else
	{
	    currSQL.replace(indexOfInputParam, indexOfInputParam + controlCharLength, argValue
		    + DynFilesConstant.CONTROL_CHAR);
	}

	return currSQL;
    }

    /**
     * This function will get the sched_time and update the next replication
     * field with the same date but with the sched time
     * 
     * @param
     * @throws BaseException
     */
    public int fixNextReplDateTime(SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	return swiftOutwardDAO.fixNextReplDateTime(swiftOutwardSC);
    }

    public String wrapText(String sTagText, int iCharPerLine, int iNoOfLines) throws BaseException
    {
	StringBuffer sText = new StringBuffer();
	String sTextStr, sRemaining, sRemainingTmp, sLine, sReversed;
	int iCrLfPos, iLineLen, iLineCount, iFound, iPos;

	sRemaining = sTagText;
	iLineCount = 1;

	while((sRemaining.length() >= iCharPerLine) && (iLineCount <= iNoOfLines))
	{
	    sRemainingTmp = StringUtil.substring(sRemaining, iCharPerLine + 1);
	    iCrLfPos = sRemainingTmp.indexOf("\r");

	    if(iCrLfPos > 0)
	    {
		iLineCount++;
		sLine = StringUtil.substring(sRemaining, iCrLfPos + 1);
		// sText = sText + sLine;
		sText.append(sLine);
		sRemaining = sRemaining.substring(iCrLfPos + 2);
		continue;
	    }

	    // CEO 21/03/2014 issue reported by Boushra Fahs TFA
	    // if(sRemaining.substring(iCharPerLine + 1, 1).equals(" "))
	    if(StringUtil.substring(sRemaining, iCharPerLine + 1, 1).equals(" "))
	    {
		sLine = StringUtil.substring(sRemaining, iCharPerLine);
		iLineLen = iCharPerLine;
	    }
	    else
	    {
		sLine = StringUtil.substring(sRemaining, iCharPerLine);
		StringBuffer sb = new StringBuffer(sLine);
		sReversed = sb.reverse().toString();
		iLineLen = iCharPerLine - (sReversed.indexOf(" "));
		sLine = StringUtil.substring(sRemaining, iLineLen);
	    }

	    // sText = sText + sLine + "\r\n";
	    sText.append(sLine + "\r\n");
	    sRemaining = StringUtil.substring(sRemaining, iLineLen + 1).trim();
	    iLineCount++;
	}

	if(iLineCount <= iNoOfLines)
	{
	    // sText = sText + sRemaining.trim();
	    sText.append(sRemaining.trim());
	}

	iFound = 0;
	iPos = 0;

	iPos = sText.indexOf("\r", iPos);

	while((iPos > 0) && (iFound < iNoOfLines - 1))
	{
	    iFound++;
	    iPos = sText.indexOf("\r", iPos + 1);
	}

	if(iPos > 0)
	{
	    sTextStr = sText.toString().substring(1, iPos);
	}

	sTextStr = sText.toString().trim();

	return sTextStr;
    }

    public String trimTag(String sTag) throws BaseException
    {
	// String[] saSpecialCharBegin;

	if(sTag == null)
	{
	    return "";
	}
	String sFinalTag = "", sBadCharAtBegin, sParsedBadCharAtBegin;
	sFinalTag = StringUtil.replaceEmptyLinesAndTrimLines(sTag);

	// Characters to be Removed From Beginning of Tag Lines - IIAB080056
	sBadCharAtBegin = StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getRMV_CHAR_BEGIN());

	if(!"".equals(sBadCharAtBegin))
	{
	    sParsedBadCharAtBegin = sBadCharAtBegin.replaceAll(",", "");
	    sFinalTag = sFinalTag.replaceAll("\\n[" + sParsedBadCharAtBegin + "]*", "\n");
	}

	return sFinalTag.trim();
    }

    public Date returnCutOffTime(BigDecimal bdCompCode, BigDecimal bdBranchCode, String sModule, BigDecimal bdCyCoce,
	    BigDecimal bdCountryCode, Date dtServerAppDateTime, String sValuDate)
	    throws BaseException
    {
	Date dtFinalCutOffDate, dtCutOffTime, dtTrxTime, dtCutOffDateTime;
	BigDecimal bdValBeforeCutOff, bdValAfterCutOff;
	int iReturnHol;
	SwiftOutwardSC swiftOutwardSC = new SwiftOutwardSC();
	
	dtFinalCutOffDate = DateUtil.parseDate(sValuDate, "dd-MMM-yyyy");

	SWIFT_CUT_OFFVO swiftCutOffVO = new SWIFT_CUT_OFFVO();
	swiftCutOffVO.setCOMP_CODE(bdCompCode);
	swiftCutOffVO.setMODULE(sModule);
	swiftCutOffVO.setCY_CODE(bdCyCoce);
	swiftCutOffVO.setCOUNTRY_CODE(bdCountryCode);

	SWIFT_CUT_OFFVO swftCutOffVO;
	swftCutOffVO = (SWIFT_CUT_OFFVO) genericDAO.selectByPK(swiftCutOffVO);
	dtCutOffDateTime = swftCutOffVO.getCUTOFF_DATE();
	bdValBeforeCutOff = NumberUtil.nullToZero(swftCutOffVO.getBEFORE_CUTOFF());
	bdValAfterCutOff = NumberUtil.nullToZero(swftCutOffVO.getAFTER_CUTOFF());

	dtTrxTime = DateUtil.parseDate(DateUtil.format(dtServerAppDateTime, "HH:mm"), "HH:mm");
	dtCutOffTime = DateUtil.parseDate(DateUtil.format(dtCutOffDateTime, "HH:mm"), "HH:mm");

	if((dtTrxTime.before(dtCutOffTime)) || (dtCutOffTime.equals(dtTrxTime)))
	{
	    dtFinalCutOffDate = DateUtil.relativeDate(dtFinalCutOffDate, bdValBeforeCutOff.intValue());
	}
	else
	{
	    dtFinalCutOffDate = DateUtil.relativeDate(dtFinalCutOffDate, bdValAfterCutOff.intValue());
	}

	iReturnHol = callSwiftHolidaySP(bdCompCode, bdBranchCode, dtFinalCutOffDate, swiftOutwardSC);

	while(iReturnHol == 1)
	{
	    dtFinalCutOffDate = DateUtil.relativeDate(dtFinalCutOffDate, 1);
	    iReturnHol = callSwiftHolidaySP(bdCompCode, bdBranchCode, dtFinalCutOffDate, swiftOutwardSC);
	}

	return dtFinalCutOffDate;
    }

    public Integer returnNextReplDateTime(Date dtNextReplDate, BigDecimal bdPeriod, String theSPeriodType,
	    BigDecimal theBdPeriodDay, Date dtDbServerDateTime, String sLanguage, SwiftCO swftCO,String sSchedTimeDB) throws BaseException
    {
	String sSchedTime = "", dateField = "";
	Long value = null;
	Date dtNextReplicationDateTime;
	String sPeriodType = theSPeriodType;
	BigDecimal bdPeriodDay = theBdPeriodDay;

	Calendar calendar = Calendar.getInstance();
	calendar.setTime(dtNextReplDate);
	
	
	
	


	sPeriodType = StringUtil.nullToEmpty(sPeriodType).toUpperCase();
	bdPeriodDay = NumberUtil.nullToZero(bdPeriodDay);
	
	try{
		if (! StringUtil.nullToEmpty(sSchedTimeDB).isEmpty() && "D".equals(sPeriodType)){
			calendar.set(Calendar.HOUR_OF_DAY,NumberUtil.parseInt(sSchedTimeDB.substring(0, 2)));
			calendar.set(Calendar.MINUTE,NumberUtil.parseInt(sSchedTimeDB.substring(3, 5)));
			calendar.set(Calendar.SECOND,NumberUtil.parseInt(sSchedTimeDB.substring(6, 8)));
		}
	}
	catch(Exception e){
		
	}


	if("Y".equals(sPeriodType))
	{
	    dateField = "yy";
	}
	else if("M".equals(sPeriodType))
	{
	    if(bdPeriodDay.equals(BigDecimal.ZERO))
	    {
		dateField = "mm";
	    }
	    else
	    {
		dateField = "mmCustom";
	    }
	}
	else if("W".equals(sPeriodType))
	{
	    dateField = "ww";
	}
	else if("D".equals(sPeriodType))
	{
	    dateField = "dd";
	}
	else if("H".equals(sPeriodType))
	{
	    dateField = "hh";
	}
	else if("N".equals(sPeriodType))
	{
	    dateField = "mi";
	}
	else if("S".equals(sPeriodType))
	{
	    dateField = "ss";
	}

	int periodicity = 0;

	if("yy".equalsIgnoreCase(dateField))
	{
	    periodicity = Calendar.YEAR;
	    value = (1 * bdPeriod.longValue());
	}
	else if("mm".equalsIgnoreCase(dateField))
	{
	    periodicity = Calendar.MONTH;
	    value = bdPeriod.longValue();
	}
	else if("mmCustom".equalsIgnoreCase(dateField))
	{
	    periodicity = Calendar.MONTH;
	    value = bdPeriod.longValue();
	    calendar.set(Calendar.DAY_OF_MONTH, bdPeriodDay.intValue());
	}
	else if("ww".equalsIgnoreCase(dateField))
	{
	    if(bdPeriodDay.equals(BigDecimal.ONE))
	    {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	    }
	    else if(bdPeriodDay.equals(new BigDecimal(2)))
	    {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
	    }
	    else if(bdPeriodDay.equals(new BigDecimal(3)))
	    {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
	    }
	    else if(bdPeriodDay.equals(new BigDecimal(4)))
	    {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
	    }
	    else if(bdPeriodDay.equals(new BigDecimal(5)))
	    {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
	    }
	    else if(bdPeriodDay.equals(new BigDecimal(6)))
	    {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	    }
	    else if(bdPeriodDay.equals(new BigDecimal(7)))
	    {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	    }

	    periodicity = Calendar.DATE;
	    value = (bdPeriod.longValue() * 7);
	}
	else if("dd".equalsIgnoreCase(dateField))
	{
	    periodicity = Calendar.DATE;
	    value = bdPeriod.longValue();
	}
	else if("hh".equalsIgnoreCase(dateField))
	{
	    periodicity = Calendar.HOUR;
	    value = bdPeriod.longValue();
	}
	else if("mi".equalsIgnoreCase(dateField))
	{
	    periodicity = Calendar.MINUTE;
	    value = bdPeriod.longValue();
	}
	else if("ss".equalsIgnoreCase(dateField))
	{
	    periodicity = Calendar.SECOND;
	    value = bdPeriod.longValue();
	}

	calendar.add(periodicity, value.intValue());

	// returning the new date calculated
	dtNextReplicationDateTime = calendar.getTime();
	swftCO.setNextReplication(dtNextReplicationDateTime);

	if (sSchedTimeDB.isEmpty() || "mi".equalsIgnoreCase(dateField))
		sSchedTime = DateUtil.format(dtNextReplicationDateTime, "HH:mm:ss").toString();
	else
		sSchedTime = sSchedTimeDB;
	swftCO.setSchedTime(sSchedTime);

	return 1;
    }

    public int insertIntoAccBalTmp(Date dtDateFrom, String sVT, BigDecimal bdBranchFrom, BigDecimal bdBranchTo,
	    BigDecimal bdCyFrom, BigDecimal bdCyTo, BigDecimal bdGlFrom, BigDecimal bdGlTo, BigDecimal bdCifFrom,
	    BigDecimal bdCifTo, BigDecimal bdSlFrom, BigDecimal bdSlTo, BigDecimal bdCompCode, BigDecimal bdBranchCode,
	    String sUserId, String sGvUserId, String sLanguage, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC)
	    throws BaseException
    {
	Date dtPrev, dtOpened = null;
	int month, year;
	YRTSC yrtSC = new YRTSC();
	SwiftProcNostroCO swiftProcNostroCO = new SwiftProcNostroCO();
	String sOption;
	
	AMFVO amfVOFrom = new AMFVO();
	AMFVO amfVOTo = new AMFVO();
	amfVOFrom.setBRANCH_CODE(bdBranchFrom);
	amfVOFrom.setCURRENCY_CODE(bdCyFrom);
	amfVOFrom.setGL_CODE(bdGlFrom);
	amfVOFrom.setCIF_SUB_NO(bdCifFrom);
	amfVOFrom.setSL_NO(bdSlFrom);
	amfVOTo.setBRANCH_CODE(bdBranchTo);
	amfVOTo.setCURRENCY_CODE(bdCyTo);
	amfVOTo.setGL_CODE(bdGlTo);
	amfVOTo.setCIF_SUB_NO(bdCifTo);
	amfVOTo.setSL_NO(bdSlTo);
	swiftProcNostroCO.setCompCode(bdCompCode);

	if("AVAIL".equals(sUserId))
	{
	    dtPrev = dtDateFrom;
	}
	else
	{
	    dtPrev = DateUtil.relativeDate(dtDateFrom, -1);
	}

	yrtSC.setCompCode(bdCompCode);
	yrtSC.setBranchCode(bdBranchCode);
	String sYrtMonth = NumberUtil.addLeadingZeros(DateUtil.getDayYearMonth(dtDateFrom, "Y"), 4).concat(
		NumberUtil.addLeadingZeros(DateUtil.getDayYearMonth(dtDateFrom, "M"), 2));
	yrtSC.setYrMonth(sYrtMonth);
	
	String sOpened = StringUtil.nullToEmpty(swiftOutwardDAO.returnOpenedDateBranch(yrtSC));
        if("".equals(sOpened))
        {
            sOption = "N";
            month = 0;
            year = 0;
        }
        else
        {           
            dtOpened = DateUtil.parseDate(sOpened.concat("01"), "yyyyMMdd");          
	    if(dtPrev.compareTo(dtOpened) < 0)
	    {
		sOption = "N";
	    }
	    else
	    {
		sOption = "Y";
	    }
	    month = DateUtil.getDayYearMonth(DateUtil.relativeDate(dtOpened, -1), "M" + 1);
	    year = DateUtil.getDayYearMonth(DateUtil.relativeDate(dtOpened, -1), "Y");
        }
        

	swiftProcNostroCO.setvT(sVT);
	swiftProcNostroCO.setUserId(sUserId);
	swiftProcNostroCO.setGvUserId(sGvUserId);
	swiftProcNostroCO.setReqDate(dtDateFrom);
	swiftProcNostroCO.setOpenedDate(dtOpened);
	swiftProcNostroCO.setPrevDate(dtPrev);
	swiftProcNostroCO.setYear(year);
	swiftProcNostroCO.setMonth(month);
	swiftProcNostroCO.setAmfVOFrom(amfVOFrom);
	swiftProcNostroCO.setAmfVOTo(amfVOTo);


	// each insert is commited apart
	if("N".equals(sOption))
	{
	    swiftOutwardDAO.insertACCBalTmpDOFN(swiftProcNostroCO);
	    swiftOutwardDAO.insertACCBalTmpHSTN(swiftProcNostroCO);
	}

	if("Y".equals(sOption))
	{
	    swiftOutwardDAO.insertACCBalTmpDOFY(swiftProcNostroCO);
	    swiftOutwardDAO.insertACCBalTmpHSTY(swiftProcNostroCO);
	    swiftOutwardDAO.insertACCBalTmpAmfSuppl(swiftProcNostroCO);
	}

	swiftOutwardDAO.insertACCBalTmpAmf(swiftProcNostroCO);

	swiftOutwardDAO.insertACCBalTmp1(swiftProcNostroCO);

	swftCO.setErrorMsg("Returning the error message similar to byReference in PB");
	return 1;
    }

    /**
     * used to write inside the swift outward log file Use FileWriter class with
     * argument 'true' to append the data inside the log file since the FileUtil
     * class doesn't have the append option
     * 
     * @param compCode
     * @param repId
     * @param repTitle
     * @param indicator
     * @param genMode
     * @param errorMsg
     * @throws BaseException
     */
    public Integer writeLogFile(BigDecimal bdCompCode, BigDecimal bdRepId, String sRepTitle, int iIndicator,
	    char cGenMode, String theSErrorMsg, String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	try
	{
	    StringBuffer sbsSwiftLogFile = new StringBuffer();
	    String sSeverity, sLogMsg, sLogDateTime, sRepoSwift;
	    String[] saTransMsgArr;
	    Date dtLogDateTime;
	    String sErrorMsg = theSErrorMsg;

	    sRepoSwift = FileUtil.getFileURLByName("repository");
	    sbsSwiftLogFile.append(returnSwiftCtrlRecValues(bdCompCode).getLOG_PATH_JAVA());//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftLogFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftLogFile.insert(0, "/");
		sbsSwiftLogFile.insert(0, sRepoSwift);
	    }

	    swiftOutwardSC.setLogFileLocation(sbsSwiftLogFile.toString());

	    dtLogDateTime = commonLibBO.returnSystemDateWithTime();
	    sLogDateTime = DateUtil.format(dtLogDateTime, "dd-MMM-yyyy HH:mm:ss");

	    switch (iIndicator)
	    {
		case 0:
		    saTransMsgArr = commonLibBO.returnTranslMessage(2, sLanguage);
		    sSeverity = saTransMsgArr[1]; // Error
		    break;
		case 1:
		    saTransMsgArr = commonLibBO.returnTranslMessage(8, sLanguage);
		    sSeverity = saTransMsgArr[1]; // Information
		    break;
		case 2:
		    saTransMsgArr = commonLibBO.returnTranslMessage(12, sLanguage);
		    sSeverity = saTransMsgArr[1]; // Warning
		    break;
		default:
		    sSeverity = "";
		    break;
	    }

	    // FileWriter fw = new FileWriter(sSwiftLogFile, true);
	    FileOutputStream fw = new FileOutputStream(sbsSwiftLogFile.toString(), true);
	    sLogMsg = sLogDateTime + "\t" + bdCompCode.toString() + "\t" + bdRepId.toString() + "\t" + sRepTitle + "\t"
		    + sSeverity + "\t" + sErrorMsg + "\r\n";
	    // fw.write(sLogMsg);
	    fw.write(sLogMsg.getBytes("UTF-8"));
	    fw.flush();
	    fw.close();

	    // insert the logging into DB with DAOException handling
	    try
	    {
		// Create new instance of SWIFT_LOGVO
		SWIFT_LOGVO swiftLogVO = new SWIFT_LOGVO();

		// set the values to be inserted into DB
		swiftLogVO.setCOMP_CODE(bdCompCode);
		swiftLogVO.setREPID(bdRepId);
		swiftLogVO.setTITLE(sRepTitle);
		swiftLogVO.setSEVERITY(sSeverity);
		swiftLogVO.setLOG_DATE(dtLogDateTime);
		swiftLogVO.setMSG(sErrorMsg);

		// Insert into DB
		genericDAO.insert(swiftLogVO);
	    }
	    catch(DAOException e)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(2, sLanguage);
		sSeverity = saTransMsgArr[1];
		sErrorMsg = e.getMessage().substring(0, 900);
		sLogMsg = sLogDateTime + "\t" + bdCompCode.toString() + "\t" + bdRepId.toString() + "\t" + sRepTitle
			+ "\t" + sSeverity + "\t" + sErrorMsg + "\r\n";
		fw.write(sLogMsg.getBytes("UTF-8"));
		fw.flush();
		fw.close();
	    }
       }

	catch(Exception e)
	{
	    throw new BOException(e);
	}

	return 1;
    }

    private void deleteEmptyFile(String sSwiftFile, BigDecimal bdCompCode, BigDecimal bdRepId, String sRepTitle,
	    String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	File fw = null;
	try {
		fw = new PathFileSecure(sSwiftFile);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(fw !=null && fw.length() == 0 && !fw.delete())
	{

	    String[] saTransMsgArr = commonLibBO.returnTranslMessage(66731, sLanguage);
	    String sErrMsg = saTransMsgArr[0]; // "Unable to delete empty file"
	    writeLogFile(bdCompCode, bdRepId, sRepTitle, 2, 'S', sErrMsg, sLanguage, swiftOutwardSC);

	}
    }

    public String returnFileName(String sMsgCode, String sModule, BigDecimal bdTrxNbr, String sSwiftFile,
	    Integer iGenCntr, BigDecimal bdBranchCode, String theSFileExt, String sLanguage,BigDecimal bdCompCode) throws BaseException //Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
    {
	String sCurrentDate, sFileMode, sGenCtrFlag, sSwiftFileName = "",sSwiftFolder;
	String[] saTransMsgArr;
	Date dtDateTime;
	dtDateTime = commonLibBO.returnSystemDateWithTime();
	sCurrentDate = DateUtil.format(dtDateTime, "ddMMyyyy");
        File swiftFolder = null ;
        Boolean bRetun;
        
	//mhmd added for case of weblogic create folder if not exists
	if(sSwiftFile != null && sSwiftFile.lastIndexOf('.') < 0)
	{
	    try 
		{
			swiftFolder =  new PathFileSecure(sSwiftFile);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(swiftFolder != null && !swiftFolder.exists())
	    {//olivia 31/07/2014 jenkin issues
		bRetun = swiftFolder.mkdir();
		if (!bRetun) 
		{
		    saTransMsgArr = commonLibBO.returnTranslMessage(66761, sLanguage);
		    throw new BOException(saTransMsgArr[0]);
		}
	    }
	}
	else
	{
	    sSwiftFolder = sSwiftFile.substring(0, sSwiftFile.lastIndexOf("/"));
	    try 
		{
			swiftFolder =  new PathFileSecure(sSwiftFolder);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//olivia 31/07/2014 jenkin issues
	    if(swiftFolder != null && !swiftFolder.exists())
	    {//olivia 31/07/2014 jenkin issues
		bRetun = swiftFolder.mkdir();
		if (!bRetun) 
		{
		    saTransMsgArr = commonLibBO.returnTranslMessage(66761, sLanguage);
		    throw new BOException(saTransMsgArr[0]);
		}
	    }
	}    
	
	String sFileExt = theSFileExt ;
	if("".equals(sFileExt))
	{
	    sFileExt = ".txt";
	}

	sFileMode = commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE();

	switch (iGenCntr)
	{
	    case 0:
		sGenCtrFlag = "";
		break;
	    case 1:
		sGenCtrFlag = "A";
		break;
	    case 2:
		sGenCtrFlag = "B";
		break;
	    case 3:
		sGenCtrFlag = "C";
		break;
	    case 4:
		sGenCtrFlag = "D";
		break;
	    case 5:
		sGenCtrFlag = "E";
		break;
	    case 6:
		sGenCtrFlag = "F";
		break;
	    case 7:
		sGenCtrFlag = "G";
		break;
	    case 8:
		sGenCtrFlag = "H";
		break;
	    case 9:
		sGenCtrFlag = "I";
		break;
	    case 10:
		sGenCtrFlag = "G";
		break;
	    case 11:
		sGenCtrFlag = "K";
		break;
	    case 12:
		sGenCtrFlag = "L";
		break;
	    case 13:
		sGenCtrFlag = "M";
		break;
	    case 14:
		sGenCtrFlag = "N";
		break;
	    case 15:
		sGenCtrFlag = "O";
		break;
	    case 16:
		sGenCtrFlag = "P";
		break;
	    case 17:
		sGenCtrFlag = "Q";
		break;
	    case 18:
		sGenCtrFlag = "R";
		break;
	    case 19:
		sGenCtrFlag = "S";
		break;
	    case 20:
		sGenCtrFlag = "T";
		break;
	    case 21:
		sGenCtrFlag = "U";
		break;
	    case 22:
		sGenCtrFlag = "V";
		break;
	    case 23:
		sGenCtrFlag = "W";
		break;
	    case 24:
		sGenCtrFlag = "X";
		break;
	    case 25:
		sGenCtrFlag = "Y";
		break;
	    case 26:
		sGenCtrFlag = "Z";
		break;
	    default:
		sGenCtrFlag = "";
		break;
	}

	if(StringUtil.nullToEmpty(sFileMode).equals("2"))
	{
	    if(sSwiftFile.substring(sSwiftFile.length()).equals("//"))
	    {
		sSwiftFileName = sSwiftFile + StringUtil.substring(sMsgCode, 4, 3) + sModule + bdTrxNbr.toString()
			+ bdBranchCode.toString() + sGenCtrFlag + sCurrentDate + sFileExt;
	    }
	    else
	    {
		sSwiftFileName = sSwiftFile + File.separator + StringUtil.substring(sMsgCode, 4, 3) + sModule
			+ bdTrxNbr.toString() + bdBranchCode.toString() + sGenCtrFlag + sCurrentDate + sFileExt;
	    }
	}

	 int slachIndex = 0 ;
	 String swiftTxtFile ="";
	 StringBuffer  sbSwiftFileName = new StringBuffer("");
	if(StringUtil.nullToEmpty(sFileMode).equals("1"))
	{
	   String sOneFileMode = returnSwiftCtrlRecValues(bdCompCode).getSAVE_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	   //retrieve repo folder path Fares kassab 720652 TFA swift messages not proceed successfully
	   String repoPath = FileUtil.getFileURLByName("repository");
	   sSwiftFile = sSwiftFile.replace(repoPath, "");
	   if(sOneFileMode != null && sSwiftFile.lastIndexOf('.') < 0)
	   {
	       slachIndex = sOneFileMode.lastIndexOf('/');
	       swiftTxtFile =sOneFileMode.substring(slachIndex, sOneFileMode.length());
	       sbSwiftFileName.append(sSwiftFile);
	       sbSwiftFileName.append(swiftTxtFile);
	       sSwiftFileName = repoPath + sbSwiftFileName.toString();//Fares kassab 720652 TFA swift messages not proceed successfully
	   }
	   else
	   {
	       sSwiftFileName = sSwiftFile;
	   }
	  
	}

	return sSwiftFileName;
    }
    
    public String returnFileNameMode2(String sMsgCode, String sModule, BigDecimal bdTrxNbr, String sSwiftFile,
    	    Integer iGenCntr, BigDecimal bdBranchCode, String theSFileExt, String sLanguage) throws BaseException
        {
    	String sCurrentDate, sFileMode, sGenCtrFlag, sSwiftFileName = "",sSwiftFolder;
    	String[] saTransMsgArr;
    	Date dtDateTime;
    	dtDateTime = commonLibBO.returnSystemDateWithTime();
    	sCurrentDate = DateUtil.format(dtDateTime, "ddMMyyyy");
            File swiftFolder  = null ;
            Boolean bRetun;
            
    	//mhmd added for case of weblogic create folder if not exists
    	if(sSwiftFile != null && sSwiftFile.lastIndexOf('.') < 0)
    	{
    	    try 
			{
				swiftFolder =  new PathFileSecure(sSwiftFile);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    if(swiftFolder!= null && !swiftFolder.exists())
    	    {//olivia 31/07/2014 jenkin issues
    		bRetun = swiftFolder.mkdir();
    		if (!bRetun) 
    		{
    		    saTransMsgArr = commonLibBO.returnTranslMessage(66761, sLanguage);
    		    throw new BOException(saTransMsgArr[0]);
    		}
    	    }
    	}
    	else
    	{
    	    sSwiftFolder = sSwiftFile.substring(0, sSwiftFile.lastIndexOf("/"));
    	    try 
			{
				swiftFolder =  new PathFileSecure(sSwiftFolder);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//olivia 31/07/2014 jenkin issues
    	    if(swiftFolder != null && !swiftFolder.exists())
    	    {//olivia 31/07/2014 jenkin issues
    		bRetun = swiftFolder.mkdir();
    		if (!bRetun) 
    		{
    		    saTransMsgArr = commonLibBO.returnTranslMessage(66761, sLanguage);
    		    throw new BOException(saTransMsgArr[0]);
    		}
    	    }
    	}    
    	
    	String sFileExt = theSFileExt ;
    	if("".equals(sFileExt))
    	{
    	    sFileExt = ".txt";
    	}

    	sFileMode = commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE();

    	switch (iGenCntr)
    	{
    	    case 0:
    		sGenCtrFlag = "";
    		break;
    	    case 1:
    		sGenCtrFlag = "A";
    		break;
    	    case 2:
    		sGenCtrFlag = "B";
    		break;
    	    case 3:
    		sGenCtrFlag = "C";
    		break;
    	    case 4:
    		sGenCtrFlag = "D";
    		break;
    	    case 5:
    		sGenCtrFlag = "E";
    		break;
    	    case 6:
    		sGenCtrFlag = "F";
    		break;
    	    case 7:
    		sGenCtrFlag = "G";
    		break;
    	    case 8:
    		sGenCtrFlag = "H";
    		break;
    	    case 9:
    		sGenCtrFlag = "I";
    		break;
    	    case 10:
    		sGenCtrFlag = "G";
    		break;
    	    case 11:
    		sGenCtrFlag = "K";
    		break;
    	    case 12:
    		sGenCtrFlag = "L";
    		break;
    	    case 13:
    		sGenCtrFlag = "M";
    		break;
    	    case 14:
    		sGenCtrFlag = "N";
    		break;
    	    case 15:
    		sGenCtrFlag = "O";
    		break;
    	    case 16:
    		sGenCtrFlag = "P";
    		break;
    	    case 17:
    		sGenCtrFlag = "Q";
    		break;
    	    case 18:
    		sGenCtrFlag = "R";
    		break;
    	    case 19:
    		sGenCtrFlag = "S";
    		break;
    	    case 20:
    		sGenCtrFlag = "T";
    		break;
    	    case 21:
    		sGenCtrFlag = "U";
    		break;
    	    case 22:
    		sGenCtrFlag = "V";
    		break;
    	    case 23:
    		sGenCtrFlag = "W";
    		break;
    	    case 24:
    		sGenCtrFlag = "X";
    		break;
    	    case 25:
    		sGenCtrFlag = "Y";
    		break;
    	    case 26:
    		sGenCtrFlag = "Z";
    		break;
    	    default:
    		sGenCtrFlag = "";
    		break;
    	}

	    if(sSwiftFile.substring(sSwiftFile.length()).equals("//"))
	    {
		sSwiftFileName = commonLibBO.returnSwiftCtrlRecValues().getDYNAMIC_PATH_JAVA() + StringUtil.substring(sMsgCode, 4, 3) + sModule + bdTrxNbr.toString()
			+ bdBranchCode.toString() + sGenCtrFlag + sCurrentDate + sFileExt;
	    }
	    else
	    {
		sSwiftFileName = commonLibBO.returnSwiftCtrlRecValues().getDYNAMIC_PATH_JAVA() + File.separator + StringUtil.substring(sMsgCode, 4, 3) + sModule
			+ bdTrxNbr.toString() + bdBranchCode.toString() + sGenCtrFlag + sCurrentDate + sFileExt;
	    }

    return sSwiftFileName;
    }

    private String[] returnArrayOfSpecialChar() throws BaseException
    {
	String sSpecialChar;
	String[] saSpecialChar;
	sSpecialChar = commonLibBO.returnSwiftCtrlRecValues().getRMV_SPCAR();
	saSpecialChar = StringUtil.toStringArray(sSpecialChar, ",");
	return saSpecialChar;
    }

    public String removeSpecialChar(String theSTagVal,BigDecimal includeArabic,String skipSpecialChars) throws BaseException
    {
	char cReplace = 'n';
	String sSpecialChar;
	String[] saArrayOfSpecialChar;
	String sTagVal = theSTagVal;

	saArrayOfSpecialChar = returnArrayOfSpecialChar();

	if("Y".equalsIgnoreCase(skipSpecialChars))
	{
		// Remove Special Characters from the message
		for(int i = 0; i < saArrayOfSpecialChar.length; i++)
		{
		    sSpecialChar = saArrayOfSpecialChar[i];
		    // BOK110212
		    if(sTagVal.indexOf(sSpecialChar) >= 0)
		    {
			cReplace = 'y';
		    }
		    //
		    sTagVal = sTagVal.replace(sSpecialChar, "");
		}
	}
	// Remove Non English Characters from the message
	// BOK110212
	// Check if remove arabic characters or not from message 652367 ZBI180016
	if(BigDecimal.ONE.compareTo(NumberUtil.nullToZero(includeArabic))!=0)
	{
		if(sTagVal.matches(".*[\\p{ASCII}].*"))
		{
		    cReplace = 'y';
		}
		//
		sTagVal = sTagVal.replaceAll("[^\\p{ASCII}]", "");
	}
	// BOK110212
	if(sTagVal.length() == 0 && cReplace == 'y')
	{
	    sTagVal = "@@#";
	}
	//

	return sTagVal;
    }

    public void resetLog() throws BaseException
    {
	swiftOutwardDAO.deleteSwiftLogOutward();
    }

    public String changeFormat(String theSVal) throws BaseException
    {
	boolean isBigDecimal;
	String sVal = theSVal;

	sVal = StringUtil.nullToEmpty(sVal);
	if(sVal.length() > 0)
	{
	    isBigDecimal = NumberUtil.isNumber(sVal);
	    if(isBigDecimal)
	    {
		sVal = sVal.replace(".", ",");
	    }
	}
	return sVal;
    }

    //efarah 07/04/2017 EWBI170270
    public Integer updateRefreshRate(BigDecimal bdRefRate,String ServiceName) throws BaseException
    {
	if(NumberUtil.isNumberNegative(bdRefRate) || bdRefRate.compareTo(new BigDecimal(999999999)) == 1)
	{
	    return -1;
	}

	EAS_SERVICESVO easServicesVO = new EAS_SERVICESVO();
	easServicesVO.setREFRESH_RATE(bdRefRate);
	easServicesVO.setSERVICE_NAME(ServiceName);//efarah 07/04/2017 EWBI170270

	try
	{
	    genericDAO.update(easServicesVO);
	    return 1;
	}
	catch(DAOException e)
	{
	    return -1;
	}
    }

    public Integer returnServiceStatus(String sServiceName, String language) throws BaseException
    {
	int iResult;
	if(StringUtil.nullToEmpty(sServiceName).trim().equals(""))
	{
	    iResult = -1;
	}
	else
	{
	    String sServiceStatus, sErrMsg = "";
	    String[] saTransMsgArr;
	    EAS_SERVICESVO easServicesVO = new EAS_SERVICESVO();
	    easServicesVO.setSERVICE_NAME(sServiceName);
	    EAS_SERVICESVO easServVO;
	    try
	    {
		easServVO = (EAS_SERVICESVO) genericDAO.selectByPK(easServicesVO);
		if(easServVO == null)
		{
		    saTransMsgArr = commonLibBO.returnTranslMessage(66733, language);
		    sErrMsg = saTransMsgArr[0]; // Unable to get SWIFT service
		    // status
		    throw new BOException(sErrMsg);
		}
		sServiceStatus = easServVO.getSTATUS();
		if(StringUtil.nullToEmpty(sServiceStatus).equals("ON"))
		{
		    iResult = 1;
		}
		else
		{
		    iResult = 0;
		}
	    }
	    catch(DAOException e)
	    {
		iResult = -1;
	    }

	}

	return iResult;
    }

    public BigDecimal returnRefreshRate(String language,String serviceName) throws BaseException
    {
	EAS_SERVICESVO easServicesVO = new EAS_SERVICESVO();
	easServicesVO.setSERVICE_NAME(serviceName);//efarah 07/04/2017 EWBI170270
	EAS_SERVICESVO easServVO;
	String[] saTransMsgArr;
	String sErrMsg = "";

	easServVO = (EAS_SERVICESVO) genericDAO.selectByPK(easServicesVO);
	if(easServVO == null)
	{
	    saTransMsgArr = commonLibBO.returnTranslMessage(66732, language);
	    sErrMsg = saTransMsgArr[0]; // Refresh Rate is not defined for SWIFT
	    // service
	    throw new BOException(sErrMsg);
	}
	BigDecimal bdResult;
	bdResult = easServVO.getREFRESH_RATE();

	return bdResult;
    }

    public void updateEngineServiceStatus(BigDecimal bdCompCode, String serviceName, int serviceStatus,
	    String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	String[] saTransMsgArr;
	String logMsg;

	if(serviceStatus == 1)
	{
	    swiftOutwardSC.setServiceStatus("ON");
	    saTransMsgArr = commonLibBO.returnTranslMessage(66674, sLanguage);
	    logMsg = saTransMsgArr[0]; // Swift Engine Started
	}
	else
	{
	    swiftOutwardSC.setServiceStatus("OFF");
	    saTransMsgArr = commonLibBO.returnTranslMessage(66675, sLanguage);
	    logMsg = saTransMsgArr[0]; // Swift Engine Stopped
	}

	swiftOutwardSC.setServiceName(serviceName);

	swiftOutwardDAO.updateEngineServiceStatus(swiftOutwardSC);

	writeLogFile(bdCompCode, BigDecimal.ZERO, "SWIFT", 1, 'S', logMsg, sLanguage, swiftOutwardSC);

    }
    
 // #558956 SBI170063 - Real Time Gross Settlement (RTGS)
    public SwiftCO returnSwiftMsgHistory(BigDecimal bdCompCode, BigDecimal bdBrCode, BigDecimal bdTrsNo,
	    String trxType, String sModule,  BigDecimal bdMsgOrder,  String sLanguage)
	    throws BaseException
    {
	
	      
	CTSTRXTYPEVO ctstrxtypevo=new CTSTRXTYPEVO();
	ctstrxtypevo.setCOMP_CODE(bdCompCode);
	ctstrxtypevo.setCODE(new BigDecimal(trxType));
	ctstrxtypevo=(CTSTRXTYPEVO)genericDAO.selectByPK(ctstrxtypevo);
	String msgCode=ctstrxtypevo.getSWIFT_CODE();
	
	CTSTRSVO ctstrsvo=new CTSTRSVO();
	ctstrsvo.setBRANCH_CODE(bdBrCode);
	ctstrsvo.setCOMP_CODE(bdCompCode);
	ctstrsvo.setTRS_NO(bdTrsNo);
	ctstrsvo.setCB_IND("C");
	ctstrsvo.setTRS_TYPE("R");
	
	 ctstrsvo=(CTSTRSVO)genericDAO.selectByPK(ctstrsvo);
	 BigDecimal swiftTrxNo=ctstrsvo.getSWIFT_TRX_NO();
	String[] saTransMsgArr;
	
	SwiftOutwardSC swiftOutwardSC=new SwiftOutwardSC();

	
	swiftOutwardSC.setCompCode(bdCompCode);
	swiftOutwardSC.setBranchCode(bdBrCode);
	swiftOutwardSC.setTrsNo(swiftTrxNo);
	
	swiftOutwardSC.setMsgCode(msgCode);
	swiftOutwardSC.setModule(sModule);
	
	swiftOutwardSC.setMsgOrder(bdMsgOrder);
	SwiftCO swiftHistoryCO = new SwiftCO();
	if(swiftTrxNo != null) //Hala Al Sheikh - 885941
	{
	    List<SWIFT_HISTORYVOWithBLOBs> result = swiftOutwardDAO.returnSwiftHistoryReport(swiftOutwardSC);
	    if(bdCompCode == null || result.isEmpty())
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66753, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }

	    /*
	     * for(SWIFT_HISTORYVOWithBLOBs swiftHstVOWithBLOBs : result) {
	     * 
	     * }
	     */

	    if(result.get(0).getSWIFT_MSG_BLOB() != null)
	    {
		swiftHistoryCO.setSwiftMessage(result.get(0).getSWIFT_MSG_BLOB());
	    }
	}
	else
	{
	    swiftHistoryCO.setSwiftMessage("");
	}
	return swiftHistoryCO;
    }
// #558956 SBI170063 - Real Time Gross Settlement (RTGS)

    
    
    

    public SwiftCO previewSwiftMessage(String theSTrsNo, String theSProgRef, BigDecimal theBdLoggedInBrCode,
	    String theSAppName, String sLanguage, String sUserId, SwiftCO swftCO) throws BaseException
    {
	
	if("H".equals(swftCO.getPrintSwiftHistory()))
	{
	    return returnSwiftMsgHistory(swftCO.getBdCompCode(), theBdLoggedInBrCode,swftCO.getBdTrsNO(), swftCO.getTrxType(), swftCO.getsModule(), swftCO.getBdMsgOrder(), sLanguage);
	}
	String[] saTransMsgArr;
	String sTrsNo = theSTrsNo;
	String sProgRef = theSProgRef;
	BigDecimal bdLoggedInBrCode = theBdLoggedInBrCode;
	String sAppName = theSAppName;

	sTrsNo = StringUtil.nullToEmpty(sTrsNo);
	sProgRef = StringUtil.nullToEmpty(sProgRef);
	sAppName = StringUtil.nullToEmpty(sAppName);
	bdLoggedInBrCode = NumberUtil.nullToZero(bdLoggedInBrCode);

	String sErrMsg;
	if(sTrsNo.substring(8).equals(""))
	{
	    saTransMsgArr = commonLibBO.returnTranslMessage(66696, sLanguage);
	    sErrMsg = saTransMsgArr[0]; // "SWIFT Message Must be Related To a Transaction!"
	    throw new BOException(sErrMsg);
	}
	BigDecimal bdCompCode, bdBranchCode;
	bdCompCode = new BigDecimal(sTrsNo.substring(0, 4));
	bdBranchCode = new BigDecimal(sTrsNo.substring(4, 8));

	// In case the Branch Code is not a key in the table
	bdBranchCode = NumberUtil.nullToZero(bdBranchCode);
	if(bdBranchCode.compareTo(BigDecimal.ZERO) == 0)
	{
	    bdBranchCode = bdLoggedInBrCode;
	}

	String sLCType = "";
	BigDecimal bdTfsAdviceNo;
	if("TFA".equals(sAppName) && ("AD01".equals(sProgRef) || "AD01MT".equals(sProgRef)))
	{
	    bdTfsAdviceNo = new BigDecimal(sTrsNo.substring(8));
	    sLCType = StringUtil.nullToEmpty(returnTFSAdviceLCType(bdCompCode, bdBranchCode, bdTfsAdviceNo));

	    if("".equals(sLCType))
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66695, sLanguage);
		sErrMsg = saTransMsgArr[0]; // "Document Type is not set!"
		throw new BOException(sErrMsg);
	    }
	    else
	    {
		if("O".equals(sLCType) || "I".equals(sLCType))
		{
		    sLCType = "LC";
		}
		else if("U".equals(sLCType) || "N".equals(sLCType))
		{
		    sLCType = "B";
		}
		else
		{
		    sLCType = "LG";
		}
	    }
	}

	// Get the Report Id and Table Name from Swift Print Hdr
	String sTableName = "";
	SWIFT_PRINT_HDRVO swiftPrintHdrVO = new SWIFT_PRINT_HDRVO();
	swiftPrintHdrVO = returnPrintSwiftHdr(sAppName, sProgRef, sLCType, swiftPrintHdrVO);
	BigDecimal bdRepId = null;
	if(swiftPrintHdrVO != null)
	{
	    bdRepId = NumberUtil.nullToZero(swiftPrintHdrVO.getREP_ID());
	    sTableName = StringUtil.nullToEmpty(swiftPrintHdrVO.getTABLE_NAME());

	    if(bdRepId.compareTo(BigDecimal.ZERO) == 0 || "".equals(sTableName))
	    {
		// Missing Report Id/Table Name for Module <PARAM1> - Prog Ref
		// <PARAM2>
		sErrMsg = commonLibBO.returnTranslErrorMessage(66697, new String[] { bdRepId.toString(), sTableName },
			sLanguage);
		throw new BOException(sErrMsg);
	    }
	}
	String sSQL;
	DynFilesSC dynFilesSC = new DynFilesSC();
	// Get SQL String from Swift Print Details
	sSQL = returnPrintSwiftDetSQL(sTrsNo, sAppName, sProgRef, sLCType, sTableName, sLanguage);
	dynFilesSC.setDynamicSQL(sSQL);
	ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlPrt;
	selectResultSqlPrt = dynFilesDAO.returnDynFilesExecuteExportDynamicSQL(dynFilesSC);
	String sColNameTrsDate, sColNameTrsNo, sTrsStatus = "", sColNameTrsStatus, sColNameSwiftTrxNo;
	BigDecimal bdTrsNo = null, bdSwiftTrxNo = null;
	Integer iSqlRowSize, iSqlColSize;
	Date dtTrsDate = null;
	if(selectResultSqlPrt != null)
	{
	    iSqlRowSize = selectResultSqlPrt.size();

	    for(int sqlPrtCount = 0; sqlPrtCount < iSqlRowSize; sqlPrtCount++)
	    {
		iSqlColSize = selectResultSqlPrt.get(sqlPrtCount).size();

		sColNameTrsDate = selectResultSqlPrt.get(sqlPrtCount).get(0).getColumnName();
		dtTrsDate = (Date) returnColumnValue(selectResultSqlPrt, sqlPrtCount, iSqlColSize, sColNameTrsDate);

		sColNameTrsNo = selectResultSqlPrt.get(sqlPrtCount).get(1).getColumnName();
		bdTrsNo = (BigDecimal) returnColumnValue(selectResultSqlPrt, sqlPrtCount, iSqlColSize, sColNameTrsNo);

		sColNameTrsStatus = selectResultSqlPrt.get(sqlPrtCount).get(2).getColumnName();
		sTrsStatus = (String) returnColumnValue(selectResultSqlPrt, sqlPrtCount, iSqlColSize, sColNameTrsStatus);

		sColNameSwiftTrxNo = selectResultSqlPrt.get(sqlPrtCount).get(3).getColumnName();
		bdSwiftTrxNo = (BigDecimal) returnColumnValue(selectResultSqlPrt, sqlPrtCount, iSqlColSize,
			sColNameSwiftTrxNo);
	    }
	}

	// Check whether the trx has a swift message to be previewed or not
	SWIFT_REPORTSVO swftRepVO;
	SwiftOutwardSC swiftOutwardSC = new SwiftOutwardSC();
	swiftOutwardSC.setRepId(bdRepId);
	swftRepVO = swiftOutwardDAO.returnSwiftReportsDetails(swiftOutwardSC);
	String queryType = null;
	String sRepSQL;
	if(swftRepVO != null)
	{
	    sRepSQL = swftRepVO.getREP_SQL();
	    queryType = swftRepVO.getQUERY_TYPE();
	    // sRepSQL = sRepSQL.replace("?", DynFilesConstant.CONTROL_CHAR);
	    // iQmNbr = StringUtils.countMatches(sRepSQL,
	    // DynFilesConstant.CONTROL_CHAR);

	    // Just In case of Query MItani 01/04/2014
	    if("Q".equals(queryType.toUpperCase(Locale.ENGLISH)))
	    {
		// CEO 26/03/2014 - Changed the logic of replacing ? to replace
		// the
		// argument name whenever used in SQL
		sRepSQL = sRepSQL.replaceAll(":ra_comp_code", bdCompCode.toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_fr", bdTrsNo.toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_to", bdTrsNo.toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_date_from", DateUtil.format(dtTrsDate, "dd-MMM-yyyy").toString());
		sRepSQL = sRepSQL.replaceAll(":ra_trs_date_to", DateUtil.format(dtTrsDate, "dd-MMM-yyyy").toString());

		if(NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getPRINT_SWIFT())
			.equals(BigDecimal.ONE))
		{
		    sRepSQL = sRepSQL.replaceAll(":ra_status", sTrsStatus);

		}

		dynFilesSC.setDynamicSQL(sRepSQL);
		ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep = dynFilesDAO.returnDynFilesExecuteExportDynamicSQL(dynFilesSC);

		if(selectResultSqlRep != null)
		{
		    iSqlRowSize = selectResultSqlRep.size();

		    // Check if the swift message has been already generated and
		    // display a message accordingly
		   // #558956 SBI170063 - Real Time Gross Settlement (RTGS) history case

		    if(NumberUtil.nullToZero(bdSwiftTrxNo).equals(BigDecimal.ONE)&&!"D001HIS".equals(sProgRef))
		    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66701, sLanguage);
			throw new BOException(saTransMsgArr[0]); // Swift
			// Message
			// has been already
			// generated!
		    }

		    if(iSqlRowSize == 0)
		    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66699, sLanguage);
			throw new BOException(saTransMsgArr[0]); // No SWIFT
			// Message
			// To be Printed!
		    }
		}
	    }
		// Added By MItani 31/01/2014
		if("P".equals(queryType.toUpperCase(Locale.ENGLISH)))
		{

		    swiftOutwardSC.setCompCode(bdCompCode);
		    swiftOutwardSC.setTrsFromNo(bdTrsNo);
		    swiftOutwardSC.setTrsToNo(bdTrsNo);
		    swiftOutwardSC.setTrsFromDate(dtTrsDate);
		    swiftOutwardSC.setTrsToDate(dtTrsDate);
		    swiftOutwardSC.setSReportProcedure(sRepSQL);
		    swiftOutwardSC.setStatus(sTrsStatus);
		
		    dynFilesSC.setDynamicSQL(sRepSQL);
		    ArrayList<Map<String, Object>> aListMapSqlRep = swiftOutwardDAO.returnSwiftLinkedHashMapDynamicSQL(dynFilesSC, swiftOutwardSC,
					queryType);

			if(aListMapSqlRep != null && "P".equals(queryType.toUpperCase(Locale.ENGLISH)))
			{
			    iSqlRowSize = aListMapSqlRep.size();
			    
			    if(NumberUtil.nullToZero(bdSwiftTrxNo).equals(BigDecimal.ONE))
			    {
			    	saTransMsgArr = commonLibBO.returnTranslMessage(66701, sLanguage);
					throw new BOException(saTransMsgArr[0]); // Swift
				// Message
				// has been already
				// generated!
			    }
			    if(iSqlRowSize == 0)
			    {
			    	saTransMsgArr = commonLibBO.returnTranslMessage(66699, sLanguage);
					throw new BOException(saTransMsgArr[0]); // No SWIFT
				// To be Printed!
			    }
			}

		}

	}
	//
	String sRepoSwift;
	sRepoSwift = FileUtil.getFileURLByName("repository");
	String sSwiftFile = "";
	StringBuffer sbsSwiftFile = new StringBuffer("");
	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("1"))
	{
	    sSwiftFile = returnSwiftCtrlRecValues(bdCompCode).getSAVE_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    // Remove the file name from the save path to be able to create the
	    // save folder properly
	    int i = sSwiftFile.lastIndexOf("/");
	    sbsSwiftFile.append(sSwiftFile.substring(0, i));
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftFile.insert(0, "/");
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	}

	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("2"))
	{
	    sSwiftFile = returnSwiftCtrlRecValues(bdCompCode).getDYNAMIC_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    sbsSwiftFile.append(sSwiftFile);
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftFile.insert(0, "/");
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	}
	String sRepTitle;
	sRepTitle = swftRepVO.getREP_TITLE();

	ArrayList<SwiftRepListCO> swftRepListCO = new ArrayList<SwiftRepListCO>();
	
//	BaseObject baseObj=new BaseObject();
//	baseObj.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
//    //swiftOutwardSC.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
//    genericDAO.callSqlSessionTrace(baseObj, "r:" + swiftOutwardSC.getProgRef() +" ra:SWFT", swiftOutwardDAO.returnConnection());//conn :null;   in sched : sessionId nul
	generateByReport(0, sAppName, bdCompCode, bdBranchCode, bdTrsNo, bdTrsNo, dtTrsDate, dtTrsDate, sTrsStatus,

	sbsSwiftFile.toString(), null, sUserId, bdRepId, sRepTitle, 'S', 'Y', sLanguage, sAppName, swftCO,
		swiftOutwardSC, swftRepListCO, bdSwiftTrxNo);

	return swftCO;
    }

    public String returnTFSAdviceLCType(BigDecimal bdCompCode, BigDecimal bdBranchCode, BigDecimal bdTfsAdviceNo)
	    throws BaseException
    {
	String sLCType;
	TFSADVICEVO tfsAdviceVO = new TFSADVICEVO();
	TFSADVICEVO tfsadvVO;

	tfsAdviceVO.setCOMP_CODE(bdCompCode);
	tfsAdviceVO.setBRANCH_CODE(bdBranchCode);
	tfsAdviceVO.setSERIAL_NO(bdTfsAdviceNo);

	tfsadvVO = (TFSADVICEVO) genericDAO.selectByPK(tfsAdviceVO);
	sLCType = tfsadvVO.getLC_TYPE();

	return sLCType;
    }

    public SWIFT_PRINT_HDRVO returnPrintSwiftHdr(String sAppName, String sPageRef, String theSLCAdviceType,
	    SWIFT_PRINT_HDRVO theSwiftPrintHdrVO) throws BaseException
    {
	String sLCAdviceType = theSLCAdviceType;
	SWIFT_PRINT_HDRVO swiftPrintHdrVO = theSwiftPrintHdrVO;
	SwiftOutwardSC swiftOutwardSC = new SwiftOutwardSC();

	swiftOutwardSC.setAppName(sAppName);
	swiftOutwardSC.setProgRef(sPageRef);

	sLCAdviceType = StringUtil.nullToEmpty(sLCAdviceType);
	if("".equals(sLCAdviceType))
	{
	    swiftOutwardSC.setProgType("");
	}
	else
	{
	    swiftOutwardSC.setProgType(sLCAdviceType);
	}

	swiftPrintHdrVO = swiftOutwardDAO.returnSwiftPrintHdr(swiftOutwardSC);

	return swiftPrintHdrVO;
    }

    public String returnPrintSwiftDetSQL(String sTrsNo, String sAppName, String sPageRef, String theSLCAdviceType,
	    String sTableName, String sLanguage) throws BaseException
    {
	String[] saTransMsgArr;
	String sErrMsg, sColumnName, sColumnType, sKeyValueType, sColNameV = "", sColNameK = "", sDelimV, sDelimK, sSql;
	SwiftOutwardSC swiftOutwardSC = new SwiftOutwardSC();
	ArrayList<SWIFT_PRINT_DETVO> swiftPrintDetVO;
	String sLCAdviceType = theSLCAdviceType;

	swiftOutwardSC.setAppName(sAppName);
	swiftOutwardSC.setProgRef(sPageRef);

	sLCAdviceType = StringUtil.nullToEmpty(sLCAdviceType);
	if("".equals(sLCAdviceType))
	{
	    swiftOutwardSC.setProgType("");
	}
	else
	{
	    swiftOutwardSC.setProgType(sLCAdviceType);
	}

	swiftPrintDetVO = swiftOutwardDAO.returnSwiftPrintDet(swiftOutwardSC);

	if(swiftPrintDetVO.isEmpty())
	{
	    saTransMsgArr = commonLibBO.returnTranslMessage(66698, sLanguage);
	    sErrMsg = saTransMsgArr[0]; // "Print Swift Details are not defined!"
	    throw new BOException(sErrMsg);
	}

	StringBuffer sbsColNameV = new StringBuffer("");
	StringBuffer sbsColumnName = new StringBuffer("");
	StringBuffer sbsColNameK = new StringBuffer("");
	BigDecimal bdPositionFr, bdPositionTo;
	for(int i = 0; i < swiftPrintDetVO.size(); i++)
	{
	    sColumnName = StringUtil.nullToEmpty(swiftPrintDetVO.get(i).getCOLUMN_NAME());
	    sColumnType = StringUtil.nullToEmpty(swiftPrintDetVO.get(i).getCOLUMN_TYPE());
	    bdPositionFr = NumberUtil.nullToZero(swiftPrintDetVO.get(i).getPOSITION_FR());
	    bdPositionTo = NumberUtil.nullToZero(swiftPrintDetVO.get(i).getPOSITION_TO());
	    sKeyValueType = StringUtil.nullToEmpty(swiftPrintDetVO.get(i).getKEY_VALUE_TYPE());
	    // sColNameV = StringUtil.nullToEmpty(sColNameV);

	    // if("".equals(sbsColNameV))
	    if(sbsColNameV.length() == 0)
	    {
		sDelimV = "";
	    }
	    else
	    {
		sDelimV = ",";
	    }

	    if("V".equals(sKeyValueType))
	    {
		sbsColNameV.append(sColNameV);
		sbsColNameV.append(sDelimV);
		sbsColNameV.append(sColumnName);
	    }

	    // sColNameK = StringUtil.nullToEmpty(sColNameK);

	    // if("".equals(sColNameK))
	    if(sbsColNameK.length() == 0)
	    {
		sDelimK = "";
	    }
	    else
	    {
		sDelimK = " AND ";
	    }

	    if("K".equals(sKeyValueType))
	    {
		if("S".equals(sColumnType))
		{
		    sbsColumnName.append(sColumnName);
		    sbsColumnName.append(" = ");
		    sbsColumnName.append("'");
		    sbsColumnName
			    .append(StringUtil.substring(sTrsNo, bdPositionFr.intValue(), bdPositionTo.intValue()));
		    sbsColumnName.append("'");
		}
		else
		{
		    sbsColumnName.append(sColumnName);
		    sbsColumnName.append(" = ");
		    sbsColumnName
			    .append(StringUtil.substring(sTrsNo, bdPositionFr.intValue(), bdPositionTo.intValue()));
		}
		sbsColNameK.append(sColNameK);
		sbsColNameK.append(sDelimK);
		sbsColNameK.append(sbsColumnName.toString());
	    }
	    sbsColumnName.delete(0, sbsColumnName.length());
	}
	StringBuffer sbsSql = new StringBuffer("");
	sbsSql.append("SELECT ");
	sbsSql.append(sbsColNameV);
	sbsSql.append(" FROM ");
	sbsSql.append(sTableName);
	sbsSql.append(" WHERE ");
	sbsSql.append(sbsColNameK.toString());

	sSql = sbsSql.toString().toUpperCase(Locale.ENGLISH);

	return sSql;
    }

    public ArrayList<SWIFT_LOGVO> returnOutwardSwiftLogGrid(SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	ArrayList<SWIFT_LOGVO> swiftLogVO;
	swiftLogVO = swiftOutwardDAO.returnOutwardSwiftLogGrid(swiftOutwardSC);
	return swiftLogVO;
    }

    public Integer returnOutwardSwiftLogGridCount(SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	return swiftOutwardDAO.returnOutwardSwiftLogGridCount(swiftOutwardSC);
    }

    public BigDecimal returnSwiftSeqValue() throws BaseException
    {
	DBSequenceSC dbSeqSC = new DBSequenceSC();
	dbSeqSC.setSequenceName("SWIFT_ID_SEQ");
	dbSeqSC.setTableName("SWIFT_IDENTITY");
	return commonLibBO.returnTableSequence(dbSeqSC);
    }

    public void markAsGenerated(ArrayList<SwiftTrxListCO> swftTrxListCO,
	    ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, BigDecimal bdCompCode, BigDecimal bdRepId,
	    String sRepTitle, String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	int iSqlColSize, iSqlRowSize;

	iSqlRowSize = swftTrxListCO.size();

	for(int iTrxCount = 0; iTrxCount < iSqlRowSize; iTrxCount++)
	{
	    iSqlColSize = selectResultSqlRep.get(iTrxCount).size();
	    swiftOutwardTransBO.markAsGeneratedByTrx(selectResultSqlRep, iTrxCount, iSqlColSize, bdCompCode, bdRepId,
		    sRepTitle, sLanguage, swiftOutwardSC);
	}

    }

    private String returnSwiftFileLocation(BigDecimal bdCompCode) throws BaseException //Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
    {
	String sRepoSwift = FileUtil.getFileURLByName("repository");
	String sSwiftFile = "";
	StringBuffer sbsSwiftFile = new StringBuffer("");

	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("1"))
	{
	    sSwiftFile = returnSwiftCtrlRecValues(bdCompCode).getSAVE_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    // Remove the file name from the save path to be able to create the
	    // save folder properly
	    int i = sSwiftFile.lastIndexOf("/");
	    sbsSwiftFile.append(sSwiftFile.substring(0, i));
	    if(sRepoSwift.endsWith("/")|| sbsSwiftFile.toString().startsWith("/"))
	    {
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftFile.insert(0, "/");
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	}

	if(StringUtil.nullToEmpty(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE()).equals("2"))
	{
		 sSwiftFile = returnSwiftCtrlRecValues(bdCompCode).getDYNAMIC_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    sbsSwiftFile.append(sSwiftFile);
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftFile.insert(0, "/");
		sbsSwiftFile.insert(0, sRepoSwift);
	    }
	}
	return sbsSwiftFile.toString();
    }

    // Added By MItani to convert ArrayList<HashMap> to ArrayList<ArrayList>
    public ArrayList<ArrayList<DynFilesColumnCO>> convertFromAListHashMapToAListOfALists(
	    ArrayList<Map<String, Object>> recordList)
    {
	Iterator it;
	ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep = new ArrayList<ArrayList<DynFilesColumnCO>>();
	ArrayList<DynFilesColumnCO> dynFilesColumnCOList;
	DynFilesColumnCO dynFilesColumnCO;
	for(int i = 0; i < recordList.size(); i++)
	{
	    Map<String, Object> hm;
	    dynFilesColumnCOList = new ArrayList<DynFilesColumnCO>();
	    hm = recordList.get(i);
	    it = hm.entrySet().iterator();
	    while(it.hasNext())
	    {
		Map.Entry element = (Map.Entry) it.next();
		dynFilesColumnCO = new DynFilesColumnCO();
		dynFilesColumnCO.setColumnName((String) element.getKey());
		dynFilesColumnCO.setColumnValue(element.getValue());
		dynFilesColumnCOList.add(dynFilesColumnCO);
	    }
	    selectResultSqlRep.add(dynFilesColumnCOList);
	}
	return selectResultSqlRep;

    }

    
    private ArrayList<Map<String, Object>> filterByTrsNo(ArrayList<SwiftTrxListCO> swftTrxListCO, ArrayList<Map<String, Object>> allSqlMapList)
    {
	int iSqlMapSize = 0;
	while(iSqlMapSize < allSqlMapList.size())
	{
	    Map<String, Object> mp;
	    mp = allSqlMapList.get(iSqlMapSize);
	    Iterator it = mp.entrySet().iterator();
	    String ColumnKey;
	    BigDecimal Columnvalue = null;
	    Boolean exists = false;
	    while(it.hasNext())
	    {
		Map.Entry element = (Map.Entry) it.next();
		ColumnKey = (String) element.getKey();
		if("TRS_NO".equals(ColumnKey.toUpperCase(Locale.ENGLISH)))
		{
		    Columnvalue = (BigDecimal) element.getValue();
		    break;
		}
	    }
	    for(SwiftTrxListCO swifttrs : swftTrxListCO)
	    {
		if(Columnvalue.equals(swifttrs.getTrsNo()))
		{
		    exists = true;
		    iSqlMapSize++;
		    break;
		}
	    }
	    if(!exists)
	    {
		allSqlMapList.remove(mp);
	    }
	}

	return allSqlMapList;
    }
  //HGhazal - BMOI140016 - Engine Disconnection - 23/01/2017
    public void updateLastPingDate() throws BaseException, Exception
    {
    	BigDecimal timer= new BigDecimal("30");//Default 30 seconds
    	
    	//Get Timer value
	try{
	    String stringTimer = StringUtil.nullToEmpty(
				PathPropertyUtil.returnPathPropertyFromFile(
				SWEN_SERVICES,NOTIFICATION_TIMER));
	    if (!"".equals(stringTimer))
		timer = new BigDecimal(stringTimer);
	}catch (NullPointerException e)
	{
	    throw new BOException(SWEN_SERVICES + " not defined");
	}
	
    	//Get Last Ping Date
    	S_APP_NOTIFICATIONS_MGMTVO appNotifMgmt = new S_APP_NOTIFICATIONS_MGMTVO();
    	appNotifMgmt.setAPP_NAME("SWEN");
    	appNotifMgmt = swiftOutwardDAO.returnAppNotifMgmt(appNotifMgmt);
    	
    	if(appNotifMgmt == null)//no data -> insert
    	{
    		appNotifMgmt = new S_APP_NOTIFICATIONS_MGMTVO();
    		appNotifMgmt.setAPP_NAME("SWEN");
    		appNotifMgmt.setLAST_PING_DATE(commonLibBO.returnSystemDateWithTime());
    		swiftOutwardDAO.insertAppNotifMgmt(appNotifMgmt);
    	}
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(appNotifMgmt.getLAST_PING_DATE());
    	calendar.add(Calendar.SECOND, timer.intValue());
    	
    	Date nextNotif =  calendar.getTime();
    	
    	//If Next notification time <= Current time --> Update
    	if(nextNotif.compareTo(commonLibBO.returnSystemDateWithTime())<=0)
    	{
    		appNotifMgmt.setLAST_PING_DATE(commonLibBO.returnSystemDateWithTime());
    		swiftOutwardDAO.updateAppNotifMgmt(appNotifMgmt);
    	}
    	
    }
    
  //efarah 07/04/2017 EWBI170270
    public void stopThread() throws BaseException {

		if (ConstantsCommon.timerExec != null) {
			synchronized (ConstantsCommon.timerExec) {
				SWFT_SCHED_MANAGERVO swiftSchedVO = new SWFT_SCHED_MANAGERVO();
				
				swiftSchedVO.setTHREAD_STATUS("K");
				swiftOutwardDAO.updateThreadStatus(swiftSchedVO);

				ConstantsCommon.timerExec.cancel();
				ConstantsCommon.timerExec = null;
			}
		}
	}
    
    //efarah 07/04/2017 EWBI170270
    public void runThread(Long iRefreshRate, String language,
			BigDecimal companyCode, BigDecimal branchCode, String userName,
			SwiftCO swftCO, SwiftOutwardSC swiftOutSC) throws BaseException {
    	
    	long idThread;

		if (ConstantsCommon.timerExec == null) {
			synchronized (lock) {
				idThread = System.currentTimeMillis();
				SWFT_SCHED_MANAGERVO swiftSchedVO = new SWFT_SCHED_MANAGERVO();
				
				swiftSchedVO.setTHREAD_STATUS("K");
				swiftOutwardDAO.updateThreadStatus(swiftSchedVO);
				idThread = System.currentTimeMillis();
				swiftSchedVO = new SWFT_SCHED_MANAGERVO();
				swiftSchedVO.setTHREAD_ID(idThread);
				swiftSchedVO.setTHREAD_STATUS("A");
				genericDAO.insert(swiftSchedVO);
				ConstantsCommon.timerExec = new Timer();
			}
		} else {
			synchronized (ConstantsCommon.timerExec) {
				ConstantsCommon.timerExec.cancel();
				//update all the existing rows status to killed* K Mohamad Hojeij - 10/01/2018 - BMOUPI170756
				SWFT_SCHED_MANAGERVO swiftSchedVO = new SWFT_SCHED_MANAGERVO();
				swiftSchedVO.setTHREAD_STATUS("K");
				swiftOutwardDAO.updateThreadStatus(swiftSchedVO);
				
				
				//take new id for the new thread to be ran Mohamad Hojeij - 10/01/2018 - BMOUPI170756
				swiftSchedVO = new SWFT_SCHED_MANAGERVO();
				
				idThread = System.currentTimeMillis();
				swiftSchedVO.setTHREAD_ID(idThread);
				swiftSchedVO.setTHREAD_STATUS("A");
				genericDAO.insert(swiftSchedVO);

				ConstantsCommon.timerExec = new Timer();
			}
		}
		ConstantsCommon.timerExec.scheduleAtFixedRate(
				new SwenOUTTaskRunner(language, companyCode, branchCode,
						userName, swftCO, swiftOutSC,idThread), iRefreshRate,
				iRefreshRate);
	}
    
    //efarah 07/04/2017 EWBI170270
	public class SwenOUTTaskRunner extends TimerTask {
		String language;
		BigDecimal companyCode;
		BigDecimal branchCode;
		String userName;
		SwiftCO swftCO;
		SwiftOutwardSC swiftOutSC;
		
		long idThread;

		public SwenOUTTaskRunner(String language, BigDecimal companyCode,
				BigDecimal branchCode, String userName, SwiftCO swftCO,
				SwiftOutwardSC swiftOutSC,long threadId) {

			this.language = language;
			this.companyCode = companyCode;
			this.branchCode = branchCode;
			this.userName = userName;
			this.swftCO = swftCO;
			this.swiftOutSC = swiftOutSC;
			this.idThread = threadId;
		}

		@Override
		public void run() {
			try {
				CommonLibBO commonLibBO = (CommonLibBO) ApplicationContextProvider
						.getApplicationContext().getBean("commonLibBO");

				if (commonLibBO 
						.clusterOperationControl("SwenProcessOut", false)) {
					
				
					SwiftOutwardNonTransBO swiftOutwardNonTransBO = (SwiftOutwardNonTransBO) ApplicationContextProvider
							.getApplicationContext().getBean(
									"swiftOutwardNonTransBO");

					try {
						int returnedVal;
						returnedVal = processScheduledSwiftReports(1, language, companyCode,
								branchCode, userName, swftCO, new SwiftOutwardSC(),idThread);
						
						if(returnedVal == 0){//Mohamad Hojeij - 10/01/2018 - BMOUPI170756
							this.cancel();
						}
					} catch (Exception e) {
						// Cancel the Timer in order not to stop the task
						// execution
						//this.cancel();

						try {
							writeLogFile(companyCode, BigDecimal.ONE, "", 0, 'S', e.getMessage()
											, language,
									swiftOutSC);
						} catch (Exception e1) {
							 
							e1.printStackTrace();
						}
						e.printStackTrace();
					}
				}
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private String returnThreadStatus(long threadId) throws BaseException{
		SWFT_SCHED_MANAGERVO swftMangVO = new SWFT_SCHED_MANAGERVO();
		swftMangVO.setTHREAD_ID(threadId);
		swftMangVO = (SWFT_SCHED_MANAGERVO) genericDAO.selectByPK(swftMangVO);
		return StringUtil.nullToEmpty(swftMangVO.getTHREAD_STATUS());
		
		
	}

	
	
	@Override
	public SwiftCO generateByReportSOA(int iProcessInd, BigDecimal bdBaseCy, BigDecimal bdCyFrom, BigDecimal bdGlFrom,
		    BigDecimal bdCifFrom, BigDecimal bdSlFrom, BigDecimal bdCyTo, BigDecimal bdGlTo, BigDecimal bdCifTo,
		    BigDecimal bdSlTo, Date theDtDateFrom, Date dtDateTo, String sModule, BigDecimal bdCompCode,
		    BigDecimal bdBranchFrom, BigDecimal bdBranchTo, BigDecimal bdCifReceiver, String theSwiftFile,
		    String sUserId, BigDecimal bdRepId, String sRepTitle, char cGenMode, char cPreviewSwiftMsg,
		    String sMsgCode, BigDecimal bdGenerateMsg, BigDecimal bdSchedId, BigDecimal bdBranchCode, String sLanguage,
		    String sApplication, SwiftCO swftCO, SwiftOutwardSC swiftOutwardSC,
		    ArrayList<SwiftRepListCO> theSwftRepSOAListCO) throws BaseException {
		
			Integer iRepListCount, iCheck950Trx = 0;
			BigDecimal bdReportId = null, bdSeq, bdSoaNbrTrx;
			StringBuffer sbsSwiftLogFile = new StringBuffer();
			String sRepoSwift;
			String[] saTransMsgArr;
			String sSwiftFile = theSwiftFile;
			ArrayList<SwiftRepListCO> swftRepSOAListCO = theSwftRepSOAListCO;
			String threadStatus;
			swftCO.setFileMode(commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE());// olivia
			swftCO.setSavePathJava(commonLibBO.returnSwiftCtrlRecValues().getSAVE_PATH_JAVA());// olivia
			swftCO.setReturnVar(Long.valueOf(1));// olivia
			
		    sRepoSwift = FileUtil.getFileURLByName("repository");
		    sbsSwiftLogFile.append(commonLibBO.returnSwiftCtrlRecValues().getLOG_PATH_JAVA());
		    if(sRepoSwift.endsWith("/"))
		    {
			sbsSwiftLogFile.insert(0, sRepoSwift);
		    }
		    else
		    {
			sbsSwiftLogFile.insert(0, "/");
			sbsSwiftLogFile.insert(0, sRepoSwift);
		    }
		    
		    

		    swiftOutwardSC.setLogFileLocation(sbsSwiftLogFile.toString());
			
			if("".equals(StringUtil.nullToEmpty(sSwiftFile)))// olivia
			{
			    sSwiftFile = returnSwiftFileLocation(bdCompCode);// olivia//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter after creating same function existing in common files 
			}
			
			swftCO.setNbrTrxSOA(BigDecimal.ZERO);

			if(cGenMode == 'S')
			{
			    iRepListCount = 1;
			    bdReportId = bdRepId;
			    // sReportTitle = sRepTitle;//commented by Olivia due to Jenkin
			    // issues "UnusedLocalVariable"
			}
			else
			{
			    swftRepSOAListCO = swiftOutwardDAO.returnSwiftSOAReportsList(swiftOutwardSC);
			    iRepListCount = swftRepSOAListCO.size();
			}
			
//			if(iRepListCount == 0)
//			{
//			    saTransMsgArr = commonLibBO.returnTranslMessage(66768, sLanguage);
//			    writeLogFile(bdCompCode, BigDecimal.ZERO, "", 0, cGenMode, saTransMsgArr[0], sLanguage, swiftOutwardSC);
//			    swftCO.setErrorMsg(saTransMsgArr[0]);
//			    swftCO.setReturnVar(-1L);
//			    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
//			    return swftCO;
//			}
			
			int iReturnHol = callSwiftHolidaySP(bdCompCode, bdBranchCode, null, swiftOutwardSC);
			
			String sUpdateStmt = null, sRepSQL = null;
			String sErrMsg, sHdrDet, sSkipCond = "", sErrorCond = "";
			ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep;
			int iSqlRowSize, iSqlColSize = 0;
			Date dtNextDateAfterHol;
			Date dtDateFrom = theDtDateFrom;
			
			for(int repCount = 0; repCount < iRepListCount; repCount++)
			{
			    if(cGenMode != 'S')
			    {
				bdReportId = swftRepSOAListCO.get(repCount).getSwiftReportsVO().getREP_ID();
				// sReportTitle =
				// swftRepSOAListCO.get(repCount).getSwiftReportsVO().getREP_TITLE();//commented
				// by Olivia due to Jenkin issues "UnusedLocalVariable"
			    }

			    if(bdReportId.compareTo(BigDecimal.ZERO) == 1) // bdReportId > 0
			    {		
				swiftOutwardSC.setRepId(bdReportId);
				SWIFT_DWSVO swiftDws2VO = new SWIFT_DWSVO();
				swiftDws2VO.setREP_ID(bdReportId);
				SWIFT_DWSVO swftDws2VO;
				swftDws2VO = (SWIFT_DWSVO) genericDAO.selectByPK(swiftDws2VO);
		   
				if(swftDws2VO != null)
				{
				    sUpdateStmt = swftDws2VO.getUPDATE_STMT();
				    sSkipCond = swftDws2VO.getSKIP_COND();
				    sErrorCond = swftDws2VO.getERROR_COND();
				}

				if(bdGenerateMsg != null && bdGenerateMsg.intValue() == 2 && iReturnHol == 0)
				{
				    SWIFT_DWSCHEDVO swiftDwSched2VO = new SWIFT_DWSCHEDVO();
				    swiftDwSched2VO.setREP_ID(bdReportId);
				    swiftDwSched2VO.setMODULE(sModule);
				    swiftDwSched2VO.setSCHED_ID(bdSchedId);

				    SWIFT_DWSCHEDVO swftDwSched2VO = (SWIFT_DWSCHEDVO) genericDAO.selectByPK(swiftDwSched2VO);
				    dtNextDateAfterHol = swftDwSched2VO.getNEXT_DATE_AFTER_HOL();

				    if(dtNextDateAfterHol == null)
				    {
					dtDateFrom = commonLibBO.returnSystemDateWithTime();
				    }
				    else
				    {
					dtDateFrom = DateUtil.relativeDate(dtNextDateAfterHol, 1);
				    }
				}

				// bdGenerateMsg 1: Always 2: Business Days Only
				// iReturnHol 1: Holiday 0: Not Holiday

				if(bdGenerateMsg != null && bdGenerateMsg.intValue() == 2 && iReturnHol == 1)
				{
				    saTransMsgArr = commonLibBO.returnTranslMessage(66676, sLanguage); // SWIFT
				    // Message
				    // cannot
				    // be
				    // generated
				    // on
				    // Holidays
				    writeLogFile(bdCompCode, bdReportId, sRepTitle, 2, cGenMode, saTransMsgArr[0], sLanguage,
					    swiftOutwardSC);
				}
				else
				{
				    SWIFT_REPORTSVO swiftRep2VO = new SWIFT_REPORTSVO();
				    swiftRep2VO.setREP_ID(bdReportId);
				    SWIFT_REPORTSVO swftRep2VO;
				    swftRep2VO = (SWIFT_REPORTSVO) genericDAO.selectByPK(swiftRep2VO);
				    String queryType = "";
				    if(swftRep2VO != null)
				    {
					queryType = StringUtil.nullToEmpty(swftRep2VO.getQUERY_TYPE());
					if(!"Q".equals(queryType.toUpperCase(Locale.ENGLISH))
						&& !"P".equals(queryType.toUpperCase(Locale.ENGLISH)))
					{
					    queryType = "Q";
					}
					sRepSQL = swftRep2VO.getREP_SQL();

					if("Q".equals(queryType.toUpperCase(Locale.ENGLISH)))
					{
					    sRepSQL = sRepSQL.replaceAll(":ra_comp_code", bdCompCode.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_fr_cy", bdCyFrom.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_fr_gl", bdGlFrom.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_fr_cif", bdCifFrom.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_fr_sl", bdSlFrom.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_to_cy", bdCyTo.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_to_gl", bdGlTo.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_to_cif", bdCifTo.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_to_sl", bdSlTo.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_date_fr", DateUtil.format(dtDateFrom, "dd/MM/yyyy").toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_date_to", DateUtil.format(dtDateTo, "dd/MM/yyyy").toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_base_cy", bdBaseCy.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_branch_fr", bdBranchFrom.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_branch_to", bdBranchTo.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_cif_receiver", bdCifReceiver.toString());
					    sRepSQL = sRepSQL.replaceAll(":ra_userid",sUserId);
					    sRepSQL = sRepSQL.replaceAll(":ra_msg_code",sMsgCode);
					    sRepSQL = sRepSQL.replaceAll(":ra_log_in_branch", bdBranchCode.toString());
					    
					    swiftOutwardSC.setTrsFromDate(dtDateFrom);
					    
					}

					DynFilesSC dynFilesSC = new DynFilesSC();
					dynFilesSC.setDynamicSQL(sRepSQL);
					ArrayList<Map<String, Object>> aListMapSqlRep; // = new
					// ArrayList<Map<String,
					// Object>>();olivia
					// Added By MItani 31/03/2014
//					if("P".equals(queryType.toUpperCase(Locale.ENGLISH)))
//					{
////					   not done
//					}
					swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
					//Mohamad Hojeij apply trace props 22/03/2018
					BaseObject baseObj=new BaseObject();
					/*LBedrane 27/04/2018 #661072 - Error at the level of print swift <start>*/
					//baseObj.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
					if (swiftOutwardSC.getTraceAppName()== null || swiftOutwardSC.getTraceAppName().isEmpty()){
						
						baseObj.applyTraceProps(swftCO.getTraceAppName(),swftCO.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
					}
					else {
						
						baseObj.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
						
					}
					/*LBedrane 27/04/2018 #661072 - Error at the level of print swift <End>*/
					
					
				    //swiftOutwardSC.applyTraceProps(swiftOutwardSC.getTraceAppName(),swiftOutwardSC.getTraceUserId(),swiftOutwardSC.getProgRef(),swiftOutwardSC.getHttpSessionIdForLink());
				    //genericDAO.callSqlSessionTrace(baseObj, "r:" + swiftOutwardSC.getProgRef() +" ra:SWFT", swiftOutwardDAO.returnConnection());//conn :null;   in sched : sessionId nul
					aListMapSqlRep = swiftOutwardDAO.returnSwiftLinkedHashMapDynamicSQL(dynFilesSC, swiftOutwardSC,
						queryType);
					
					if( aListMapSqlRep == null || (aListMapSqlRep.isEmpty()))
					{
					    selectResultSqlRep = null;
//					    //saTransMsgArr = commonLibBO.returnTranslMessage(????, sLanguage);
//					    sErrMsg = commonLibBO.returnTranslErrorMessage(66770, new String[] {bdRepId.toString(),bdSchedId.toString()}, sLanguage);
//						
//					    writeLogFile(bdCompCode, BigDecimal.ZERO, "", 0, cGenMode, sErrMsg, sLanguage, swiftOutwardSC);
//					    swftCO.setErrorMsg(sErrMsg);
//					    swftCO.setReturnVar(-1L);
//					    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
//					    return swftCO;
					}
					else
					{
					    selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);
					}
					
					if(selectResultSqlRep != null)
					{
					    iSqlRowSize = selectResultSqlRep.size();  
					    //get the report expressions of computed fields Mhmd Itani 05/05/2014
					    ArrayList<SWIFT_DWS_CFVO> alExpressionList= swiftOutwardDAO.returnSoaExpressions(swiftOutwardSC);
					   
					    for(SWIFT_DWS_CFVO expression :alExpressionList)
					    {
					    	
						String computedField, computedFieldExpression;
						computedField = expression.getCF_NAME();
						Object expressionValue;
						Map<String, Object> mp;
						for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
						{
						    mp = aListMapSqlRep.get(sqlRowCount);
						    computedFieldExpression = expression.getCF_EXPRESSION();
						    //log.error("MH>> computed expression: " + computedFieldExpression + ",sched id:" + bdSchedId.toString() + ",CF id:" + expression.getCF_NAME());
						    expressionValue = commonLibBO.executeExpression(computedFieldExpression,
							    sqlRowCount, aListMapSqlRep);
						    mp.put(computedField, expressionValue);
						    aListMapSqlRep.set(sqlRowCount, mp);
						}
							
					    }
					    selectResultSqlRep = convertFromAListHashMapToAListOfALists(aListMapSqlRep);
					    for(int sqlRowCount = 0; sqlRowCount < iSqlRowSize; sqlRowCount++)
					    {	
					    	BigDecimal swiftTrxNo = BigDecimal.ZERO;//LBedrane when copying KIB170005 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
						iSqlColSize = selectResultSqlRep.get(sqlRowCount).size();
						
						sHdrDet = (String) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,"CF_HDR_DET");	
							
						bdSeq =(BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,"seq");
						BigDecimal abc = new BigDecimal(0);
						String desc = "";
						abc = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,"abc");
						desc = (String) returnColumnValue(selectResultSqlRep, sqlRowCount, iSqlColSize,"description");
						if(sHdrDet == "H")
						{
						    bdSoaNbrTrx = (BigDecimal) returnColumnValue(selectResultSqlRep, sqlRowCount,iSqlColSize, "NBR_TRX");
						    swftCO.setNbrTrxSOA(bdSoaNbrTrx);
						    if(commonLibBO.returnSwiftCtrlRecValues().getCHECK_950_TRX() == null)
						    {
							iCheck950Trx = 1; // 1 means 'No' as per
							// Swift Control
							// Record
						    }
						    if((bdSoaNbrTrx.compareTo(BigDecimal.ZERO) == 1) || (iCheck950Trx == 0))
						    {
							try
							{
								
							  //HGhazal- catch return value - 17/02/2016
								int iReturnRes;
								try
		    					{
		    					  
		    						//LBedrane when copying KIB170005 605700  we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<Start>
		    						//swiftOutwardTransBO.updateSwiftTrxNo(selectedTransactionsList, "N", sUpdateStmt, iTrxCount,  iSqlColSize, sLanguage, swiftOutwardSC);
		    						swiftTrxNo = swiftOutwardTransBO.updateSwiftTrxNo(selectResultSqlRep, "N",sUpdateStmt, sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
		    						//LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<End>
		    					}
		    					catch(Exception e)
		    					{
		    					    sErrMsg = e.getMessage();
		    					    writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, 'M', sErrMsg, sLanguage, swiftOutwardSC);
		    					    swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
		    					    continue;
		    					}
								
								iReturnRes = swiftOutwardTransBO.createMessage(iProcessInd, selectResultSqlRep,
								    sqlRowCount, iSqlColSize, bdCompCode, sSkipCond, sErrorCond,
								    sSwiftFile, cPreviewSwiftMsg, cGenMode, sApplication, swftCO,
								    sLanguage, bdReportId, sRepTitle, swiftOutwardSC, aListMapSqlRep,swiftTrxNo);
								
								if (iReturnRes == -1)
								{
								    swftCO.setReturnVar(Long.valueOf(iReturnRes));
									swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
									return swftCO;
								}
							}
							catch(BOException ex) // olivia added this exception
							// this exception
							{

							    String theMessage = commonLibBO.translateErrorMessage(ex, sLanguage)[0];
							    writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', theMessage, sLanguage,
								    swiftOutwardSC);
							}
							catch(Exception e)
							{
							    sErrMsg = e.getMessage();
							    writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
								    swiftOutwardSC);
							}

							try
							{
							    if(NumberUtil.nullToZero(bdSeq).equals(BigDecimal.ONE))
							    {
								swiftOutwardTransBO.updateStmtNbr(selectResultSqlRep, sUpdateStmt,
									sqlRowCount, iSqlColSize, sLanguage, swiftOutwardSC);
							    }
							}
							catch(Exception e)
							{
							    sErrMsg = e.getMessage();
							    writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', sErrMsg, sLanguage,
								    swiftOutwardSC);
							}
						    }
						    else
						    {
							saTransMsgArr = commonLibBO.returnTranslMessage(66678, sLanguage); // Statement
							// of
							// Account
							// Message
							// was
							// not
							// generated.
							// No
							// transactions
							// in
							// the
							// given
							// range
							writeLogFile(bdCompCode, bdReportId, sRepTitle, 0, 'S', saTransMsgArr[0],
								sLanguage, swiftOutwardSC);
						    }
						}
					    }// End Loop
					}
				    }
				}
			    }
			}

			if(bdGenerateMsg.equals(new BigDecimal(2)) && iReturnHol == 0 && iSqlColSize > 0)
			{
			    // Update SWIFT_DWSCHED.NEXT_DATE_AFTER_HOL
			    SWIFT_DWSCHEDVO swiftDwSched3VO = new SWIFT_DWSCHEDVO();
			    swiftDwSched3VO.setREP_ID(bdReportId);
			    swiftDwSched3VO.setMODULE(sModule);
			    swiftDwSched3VO.setSCHED_ID(bdSchedId);
			    swiftDwSched3VO.setNEXT_DATE_AFTER_HOL(dtDateTo);

			    try
			    {
				genericDAO.update(swiftDwSched3VO);
			    }
			    catch(DAOException e)
			    {
				sErrMsg = e.getMessage().substring(0, 900);
				swftCO.setErrorMsg(sErrMsg);

				/*
				 * CEO 31-01-2014 commented the below and used
				 * Long.valueOf(long) instead since it allows caching by JVM and
				 * code will be faster
				 */
				 /*return new Long(-1); */
				swftCO.setReturnVar(-1L);// olivia
				swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());
				return swftCO;
			    }
			}
			
			swftCO.setLogFileLocation(swiftOutwardSC.getLogFileLocation());//HGhazal - add in all cases - 19/02/2016

			// delete the Swift file if empty
			if(cPreviewSwiftMsg == 'N' && swftCO.getMsgFileName() != null)
			{
			    deleteEmptyFile(swftCO.getMsgFileName(), bdCompCode, bdReportId, sRepTitle, sLanguage, swiftOutwardSC);
			}

			return swftCO;
			}

	//efarah 07/04/2017 EWBI170270
	public String returnLanguage(String appName) throws BaseException {
		return swiftOutwardDAO.returnLanguage(appName);
	}
	
	//efarah 07/04/2017 EWBI170270
	public BigDecimal selectSwenOutwardFlag() throws BaseException {
		SWIFT_CONTROLVO swiftControlVO = swiftOutwardDAO.selectSwenOutwardFlag();
		return swiftControlVO.getSWEN_OUT_TRACE();
	}

	//**Added by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibBO - start**//
    public SWIFT_CONTROLVO returnSwiftCtrlRecValues(BigDecimal compCode) throws BaseException
    {
    	 PTH_CTRL1VO ctrlVO =  commonLibBO.returnPthCtrl1();
    	 if("1".equals(ctrlVO.getFILE_LOCATION_BY_COMP_YN()))
    	 {
    		 SWIFT_CONTROLVO swiftCtrlVO = swiftOutwardDAO.returnSwiftCtrlByComp(compCode);
    		return swiftCtrlVO; 
    	 }
    	 else
    	 {
    		 return commonLibBO.returnSwiftCtrlRecValues();
    	 }
    	 
    }
    //**Added by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibBO -end**//
    
    @Override
    public BigDecimal retSwtMsgCounterByTblName(String tableName) throws BaseException
    {
		BigDecimal id=swiftOutwardDAO.retSwtMsgCounterByTblName(tableName);
    	swiftOutwardDAO.updateSwtMsgCounterByTblName(tableName);
		return id;
    }
    
    @Override
    public BigDecimal retSwtMsgCounter() throws BaseException
    {
    	return retSwtMsgCounterByTblName("SWIFT_MESSAGE_COUNTER");
    }
    
    @Override
	public String generateUUID() throws BaseException {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}