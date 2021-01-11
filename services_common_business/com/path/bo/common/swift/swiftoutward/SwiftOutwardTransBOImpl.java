package com.path.bo.common.swift.swiftoutward;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import com.path.bo.common.ConstantsCommon;
import com.path.dao.common.swift.SwiftOutwardDAO;
import com.path.dbmaps.vo.SWIFT_DWSVO;
import com.path.dbmaps.vo.SWIFT_HISTORYVOWithBLOBs;
import com.path.dbmaps.vo.SWIFT_MSGMODVO;
import com.path.dbmaps.vo.SWIFT_MSG_REFVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.DBSequenceSC;
import com.path.vo.common.dynfiles.DynFilesColumnCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftoutward.SwiftCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardProcessCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;
import com.path.vo.swift.SwiftSignatureSC;

public class SwiftOutwardTransBOImpl extends BaseBO implements SwiftOutwardTransBO
{
    private SwiftOutwardNonTransBO swiftOutwardNonTransBO;
    private SwiftOutwardDAO swiftOutwardDAO;
  
    public void setSwiftOutwardDAO(SwiftOutwardDAO swiftOutwardDAO)
    {
	this.swiftOutwardDAO = swiftOutwardDAO;
    }

    public void setSwiftOutwardNonTransBO(SwiftOutwardNonTransBO swiftOutwardNonTransBO)
    {
	this.swiftOutwardNonTransBO = swiftOutwardNonTransBO;
    }
//Updated by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
    public BigDecimal updateSwiftTrxNo(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep,
	    String isSetSwiftTrxNoToNull, String sUpdateStmt, int sqlRowCount, int SqlColSize, String sLanguage,
	    SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	int iOpenBracket, iCloseBracket;
	String sUpdateSql, sColumn, sErrMsg;
	Object valueObj;
	String[] saTransMsgArr;
	BigDecimal ldSwiftTrxNo = BigDecimal.ZERO;//Added by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)

	if("Y".equals(isSetSwiftTrxNoToNull))
	{
	    sUpdateSql = sUpdateStmt.replace("?", "NULL");
	}
	else
	{
	  //Commented by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
		// sUpdateSql = sUpdateStmt.replace("?", "1"); // SWIFT_TRX_NO will
	    // have a fixed value
	    // "1" in java and no
	    // need to get a counter
	    // from PMSCOUNTER
		
		ldSwiftTrxNo= returnSwiftTrxNo();//Updated by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
		sUpdateSql = sUpdateStmt.replace("?", ldSwiftTrxNo.toString());//Updated by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
	}

	iOpenBracket = sUpdateSql.indexOf('[', 1);
	iCloseBracket = sUpdateSql.indexOf(']', iOpenBracket);

	while(iOpenBracket > 0)
	{
	    sColumn = sUpdateSql.substring(iOpenBracket + 1, iCloseBracket);
	    valueObj = swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, SqlColSize, sColumn);

	    sUpdateSql = sUpdateSql.replace('[' + sColumn + ']', valueObj.toString());

	    iOpenBracket = sUpdateSql.indexOf('[', 1);
	    iCloseBracket = sUpdateSql.indexOf(']', iOpenBracket);
	}

	swiftOutwardSC.setDynamicUpdateStmt(sUpdateSql);
	int iSQLnbRows = swiftOutwardDAO.executeUpdateStmt(swiftOutwardSC);

	if(iSQLnbRows == 0)
	{
	    saTransMsgArr = commonLibBO.returnTranslMessage(66679, sLanguage);
	    sErrMsg = saTransMsgArr[0]; // "The Dynamic Update Statement has Failed: No Rows Affected"
	    throw new BOException(sErrMsg);
	}
	return ldSwiftTrxNo;//Updated by LBedrane when copying KIB170005 605700 we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)
    }

    public void updateStmtNbr(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, String sUpdateStmt,
	    int sqlRowCount, int SqlColSize, String sLanguage, SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	int iOpenBracket, iCloseBracket;
	String sUpdateSql, sColumn, sErrMsg;
	Object valueObj;
	String[] saTransMsgArr;

	sUpdateSql = sUpdateStmt;

	iOpenBracket = sUpdateSql.indexOf('[', 1);
	iCloseBracket = sUpdateSql.indexOf(']', iOpenBracket);

	while(iOpenBracket > 0)
	{
	    sColumn = sUpdateSql.substring(iOpenBracket + 1, iCloseBracket);
	    valueObj = swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, SqlColSize, sColumn);

	    sUpdateSql = sUpdateSql.replace('[' + sColumn + ']', valueObj.toString());

	    iOpenBracket = sUpdateSql.indexOf('[', 1);
	    iCloseBracket = sUpdateSql.indexOf(']', iOpenBracket);
	}

	swiftOutwardSC.setDynamicUpdateStmt(sUpdateSql);
	int iSQLnbRows = swiftOutwardDAO.executeUpdateStmt(swiftOutwardSC);

	if(iSQLnbRows == 0)
	{
	    saTransMsgArr = commonLibBO.returnTranslMessage(66679, sLanguage);
	    sErrMsg = saTransMsgArr[0]; // "The Dynamic Update Statement has Failed: No Rows Affected"
	    throw new BOException(sErrMsg);
	}
    }

 
    public Integer createMessage(int iProcessInd, ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep,
	    int sqlRowCount, int sqlColSize, BigDecimal bdCompCode, String sSkipCond, String sErrorCond,
	    String theSwiftFile, char cPreviewSwiftMsg, char cGenMode, String sApplication, SwiftCO swftCO,
	    String sLanguage, BigDecimal bdRepId, String sRepTitle, SwiftOutwardSC swiftOutwardSC,
	    ArrayList<Map<String, Object>> aListMapSqlRep, BigDecimal swiftTrxNo) throws BaseException

    {
    	
    BigDecimal genFileYN = ReturnGenFileYnValue();//LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java
	Date dtHistoryDate;
	String sErrMsg = "", sMsgCode, sTransType, sModule, sRepSkipCond, sRepErrCond, sMsgBody, sNewFileName, sSwiftMsg = "",sFileName,sFileMode;
	Integer iNbrGeneration;
	BigDecimal bdTrsNo, bdBranchCode, bdAmfAddNbr, bdSeq, bdTrsNoAcc, bdPreviewWithErr, bdCountTrsNo, bdAckNackCtr, bdMsgOrder, bdMsgCountGrpNbr;

	String sSwiftFile = theSwiftFile;
	Object oRepSkipCond, oRepErrCond;
	StringBuffer sbsSwiftMsg, sbsSwiftMessage, sbsHeader;
	sbsSwiftMsg = new StringBuffer("");
	sbsSwiftMessage = new StringBuffer("");
	sbsHeader = new StringBuffer("");
	/*
	 * CEO 31-01-2014 commented the below and used Long.valueOf(long)
	 * instead since it allows caching by JVM and code will be faster
	 */
	/* Long lCountMsg = new Long(0); */
	
	String sFolderLocation, sFileExt, sSenderBic, sReceiverBic;

	bdPreviewWithErr = NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getPREVIEW_WITH_ERROR());
	dtHistoryDate = commonLibBO.returnSystemDateWithTime();

	SWIFT_MSGMODVO swiftMsgModVO = new SWIFT_MSGMODVO();
	SWIFT_MSGMODVO swftMsgModVO;

	sMsgCode = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"msg_code");
	bdMsgOrder = new BigDecimal(swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
		sqlColSize, "message_order").toString());// olivia
	iNbrGeneration = bdMsgOrder.intValue();
	sTransType = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"trans_type");
	sModule = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"module");
	bdTrsNo = new BigDecimal(swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"trs_no").toString());// olivia
	bdBranchCode = new BigDecimal(swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
		sqlColSize, "branch_code").toString());// olivia

	sMsgCode = StringUtil.nullToEmpty(sMsgCode);
	iNbrGeneration = NumberUtil.nullToZero(iNbrGeneration);
	sTransType = StringUtil.nullToEmpty(sTransType);
	sModule = StringUtil.nullToEmpty(sModule);
	bdTrsNo = NumberUtil.nullToZero(bdTrsNo);
	bdBranchCode = NumberUtil.nullToZero(bdBranchCode);

	
	SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
	swiftInwardCO.setCf_mt(sMsgCode);
	swiftInwardCO.setCompute_2(sTransType);
	swiftInwardCO.setCompute_3(sModule);
	int generateAchFlag = swiftOutwardDAO.returnGenerateAchFlagOut(swiftInwardCO);    
	
	// Get the Folder Location and File Extension from SWIFT_MSGMODVO
	swiftMsgModVO.setMSG_CODE(sMsgCode);
	swiftMsgModVO.setMODULE(sModule);
	swiftMsgModVO.setTRX_TYPE(sTransType);
	swftMsgModVO = (SWIFT_MSGMODVO) genericDAO.selectByPK(swiftMsgModVO);
	
	if (swftMsgModVO == null)//efarah 05/12/2016
	{
		sErrMsg = commonLibBO.returnTranslErrorMessage(66709, sLanguage);
		swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode,
			sErrMsg, sLanguage, swiftOutwardSC);
		swftCO.setErrorMsg(sErrMsg);
		return -1;
	}
	sFolderLocation = StringUtil.nullToEmpty(swftMsgModVO.getFOLDER_LOCATION());
	sFileExt = StringUtil.nullToEmpty(swftMsgModVO.getFILE_EXT());
	//

	// Below code to replace the uf_run_ext_prog in PowerBuilder since
	// VBScript file cannot be run on Linux Server
	if(!StringUtil.nullToEmpty(sFolderLocation).isEmpty() && !"".equals(sFolderLocation))
	{
	    sSwiftFile = FileUtil.getFileURLByName("repository") + sFolderLocation;
	}
	//

	swiftOutwardSC.setMsgCode(sMsgCode);
	swiftOutwardSC.setModule(sModule);
	swiftOutwardSC.setTransType(sTransType);
	/*if (swiftOutwardSC.getBranchCode() ==null)
	{
		swiftOutwardSC.setBranchCode(bdBranchCode);
	} BMOUPI180343*/
	swiftOutwardSC.setBranchCode(bdBranchCode);
	
	if((bdTrsNo.equals(BigDecimal.ZERO)) && ("ACC".equals(sModule)))
	{
	    bdAmfAddNbr = (BigDecimal) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
		    sqlColSize, "amf_add_number1");
	    bdSeq = (BigDecimal) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		    "seq");
	    bdTrsNo = bdAmfAddNbr.add(bdSeq);

	    bdTrsNoAcc = NumberUtil.nullToZero(swiftOutwardDAO.returnAccMaxTrsNo(swiftOutwardSC));
	    bdTrsNo = bdTrsNoAcc.add(BigDecimal.ONE);
	}

	// Do not display the skip message in Print Swift in case message has
	// repetitive tags. In this case the first sequence will be
	// displayed only. Other sequences will be skipped but won't be
	// displayed in Print Swift

	bdMsgCountGrpNbr = NumberUtil.nullToZero(swiftOutwardDAO.returnMsgCountByGrpNbr(swiftOutwardSC));
	if(!bdMsgCountGrpNbr.equals(BigDecimal.ZERO))
	{
	    swftCO.setSkipRepetitiveMsg(1);
	}

	// The below has been commented since the expression builder is
	// implemented in the next line
	// sRepSkipCond = (String)
	// swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep,
	// sqlRowCount, sqlColSize, "rep_skip_cond");

	// Read the Report Skip Condition from the report and evaluate it
	oRepSkipCond = commonLibBO.executeExpression(sSkipCond, sqlRowCount, aListMapSqlRep);
	sRepSkipCond = StringUtil.nullToEmpty(oRepSkipCond).toString();
	StringBuilder sbsErrPrvMsg = new StringBuilder("");
	if(StringUtil.nullToEmpty(sRepSkipCond).equals("Y"))
	{
	    // The Message <PARAM1> For Module <PARAM2> Transaction Type
	    // <PARAM3> was skipped
	    sErrMsg = commonLibBO.returnTranslErrorMessage(66680, new String[] { sMsgCode, sModule, sTransType },
		    sLanguage);
	    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 2, cGenMode, sErrMsg, sLanguage,
		    swiftOutwardSC);

	    if(bdPreviewWithErr.equals(BigDecimal.ONE) && cPreviewSwiftMsg == 'Y')
	    {
		sbsErrPrvMsg
			.append("****************************************************************************************************");
		sbsErrPrvMsg.append("\r\n");
		sbsErrPrvMsg.append(sErrMsg);
		sbsErrPrvMsg.append("\r\n");
		sbsErrPrvMsg
			.append("****************************************************************************************************");
		sbsErrPrvMsg.append("\r\n");

		if(!bdMsgCountGrpNbr.equals(BigDecimal.ZERO))
		{
		    // Do not display the skip error message in Print Swift in
		    // case the message contains group tags
		    sbsErrPrvMsg = new StringBuilder("");
		}
		swftCO.setSwiftMessage(sbsErrPrvMsg.toString());// Return
								// sErrPrvMsg to
		// generateByReport/generateByTrx
		// to be displayed in the
		// Preview Swift Window
		// Solving a bug in PowerBuilder to display error preview
		// message if skip = 'Y'
	    }
	    swftCO.setErrorMsg(sbsErrPrvMsg.toString());
	    return 0;
	}

	// The below has been commented since the expression builder is
	// implemented in the next line
	// sRepErrCond = (String)
	// swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep,
	// sqlRowCount, sqlColSize, "rep_error_cond");

	// Read the Report Error Condition from the report and evaluate it
	oRepErrCond = commonLibBO.executeExpression(sErrorCond, sqlRowCount, aListMapSqlRep);
	sRepErrCond = StringUtil.nullToEmpty(oRepErrCond).toString();
	sbsErrPrvMsg = new StringBuilder("");
	Boolean bErrorPreview = false, bErrorProcess = false;
	if(StringUtil.nullToEmpty(sRepErrCond).length() > 0)
	{
	    if(bdPreviewWithErr.equals(BigDecimal.ONE) && cPreviewSwiftMsg == 'Y')
	    {
		bErrorPreview = true;
		// Error Expression For the Message <PARAM1> in Report <PARAM2>
		// ID: <PARAM3> is satisfied
		sErrMsg = commonLibBO.returnTranslErrorMessage(66681, new String[] { sMsgCode, sRepTitle,
			bdRepId.toString() }, sLanguage);

		sbsErrPrvMsg
			.append("****************************************************************************************************");
		sbsErrPrvMsg.append("\r\n");
		sbsErrPrvMsg.append(sErrMsg);
		sbsErrPrvMsg.append("\r\n");
		sbsErrPrvMsg
			.append("****************************************************************************************************");
		sbsErrPrvMsg.append("\r\n");
		// sErrPrvMsg +=
		// "****************************************************************************************************"
		// + "\r\n"
		// + sErrMsg
		// + "\r\n"
		// +
		// "****************************************************************************************************"
		// + "\r\n";
	    }
	    else
	    {
		bErrorProcess = true;
	    }
	}

	// Start the counter by 1 since it is the message order in buildMessage
	// method
	boolean bErrorBody = false;
	Long lCountMsg = Long.valueOf(0);
	File swftFile = null;
	try {
		swftFile = new PathFileSecure(sSwiftFile);
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	for(int iMsgCounter = 1; iMsgCounter <= iNbrGeneration; iMsgCounter++)
	{
		sbsHeader = new StringBuffer("");//HGhazal - TP#295141 - Header is duplicated - 07/05/2015 - copied on 24/08/2015
	    if(!bErrorProcess)
	    {
		if(cPreviewSwiftMsg == 'N' )
		{
		    if(swftFile.length() > 0 && sbsErrPrvMsg.length() > 0) //TP 335635 NO $ SIGN FOR THE FIRST MESSAGE EFARAH 09/10/2015
		    {
			sbsErrPrvMsg.append("\r\n");
			sbsErrPrvMsg.append("$");
			sbsErrPrvMsg.append("\r\n");
		    }
		    else
		    {
			sbsErrPrvMsg = new StringBuilder("");
		    }
		}
		else
		{
		    sbsErrPrvMsg.append("");
		    // below part has been commented since the logic of
		    // separating messages by $ sign has been moved to after
		    // createMessage() call
		    /*
		     * if(swftFile.length() > 0) { sErrPrvMsg = sErrPrvMsg + ""
		     * + "\r\n"; } else { sErrPrvMsg = sErrPrvMsg + ""; }
		     */
		}

		swiftOutwardNonTransBO.updateColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize, "gen_index",
			iMsgCounter);
		
		String genIndex ="";
		
		try{
		    genIndex = swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
				sqlColSize, "gen_index").toString();
		}
		catch (NullPointerException e)//HGhazal - add try catch - 20/02/2017
		{
		  /*  sErrMsg = commonLibBO.returnTranslErrorMessage(902501, new String[] { sMsgCode,
			    "gen_index is missing"}, sLanguage);
		    bErrorBody = true;*/
			genIndex = "0"; // Lbedrane  10/01/2019
		    
		}
		if (!"0".equals(genIndex) && !"1".equals(genIndex))
		{
			String cfHeader = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
					sqlColSize, "cf_header");
			
			if(StringUtil.isNotEmpty(cfHeader))//HGhazal - null pointer exception - 21/02/2017
			{
        			cfHeader = cfHeader.replaceAll("700", "701");
        			cfHeader = cfHeader.replaceAll("720", "721");
        			cfHeader = cfHeader.replaceAll("710", "711");
			}
			sbsHeader.append(cfHeader);
			
		}
		else
		{
			sbsHeader.append((String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,sqlColSize, "cf_header"));
		}

		log.debug("HEADER:"+sbsHeader.toString());//HGhazal - add debug info
		
		// Check the header since it is not being set to null in
		// oracle/sybase query in case sender or receiver are null
		// length must be 29
		sSenderBic = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
			sqlColSize, "cf_sender");
		sSenderBic = StringUtil.nullToEmpty(sSenderBic);

		// length must be 21
		sReceiverBic = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
			sqlColSize, "cf_receiver");
		sReceiverBic = StringUtil.nullToEmpty(sReceiverBic);

		// CEO - 18/03/2014 Before expression builder
		// if(sSenderBic.equals("") || sReceiverBic.equals("") ||
		// sSenderBic.length() != 29 || sReceiverBic.length() != 21 )

		// CEO - 18/03/2014 After expression builder
		if("".equals(sSenderBic) || "".equals(sReceiverBic))
		{
		    sbsHeader.append("");
		}
		//

		if((StringUtil.nullToEmpty(sbsHeader.toString()).equals(""))
			&& (bdPreviewWithErr.equals(BigDecimal.ONE) && cPreviewSwiftMsg == 'Y'))
		{
		    // ERROR: Header Missing in <PARAM1> Module <PARAM2>
		    // Transaction Type <PARAM3> - Transaction No <PARAM4>
		    sErrMsg = commonLibBO.returnTranslErrorMessage(66682, new String[] { sMsgCode, sModule, sTransType,
			    bdTrsNo.toString() }, sLanguage);
		    sbsHeader.append("\r\n");
		    sbsHeader
			    .append("****************************************************************************************************");
		    sbsHeader.append("\r\n");
		    sbsHeader.append(sErrMsg);
		    sbsHeader.append("\r\n");
		    sbsHeader
			    .append("****************************************************************************************************");
		    sbsHeader.append("\r\n");
		}

		if (generateAchFlag == 1)
		{
		    sbsHeader.append("\n");
		}
		else
		{
		    sbsHeader.append("\r\n");
		}

		sMsgBody = buildMessage(iProcessInd, selectResultSqlRep, sqlRowCount, sqlColSize, bdCompCode, sMsgCode,
			sModule, sTransType, bdTrsNo, iMsgCounter, bdRepId, sRepTitle, cPreviewSwiftMsg,
			bdPreviewWithErr, cGenMode, sApplication, swftCO, sLanguage, swiftOutwardSC, aListMapSqlRep,swftMsgModVO);

		// Add the below checking instead of StringUtil.nullToEmpty
		// since the latest is trimming the last line in sMsgBody
		if(sMsgBody == "null" || sMsgBody == null)
		{
		    sMsgBody = "";
		}

		if("".equals(sMsgBody))
		{
		    // Message <PARAM1> Module <PARAM2> Transaction Type
		    // <PARAM3> Order <PARAM4> is empty
		    sErrMsg = commonLibBO.returnTranslErrorMessage(66683, new String[] { sMsgCode, sModule, sTransType,
			    String.valueOf(iMsgCounter) }, sLanguage);
		    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 2, cGenMode, sErrMsg,
			    sLanguage, swiftOutwardSC);
		    //EFarah - Do not throw error if order is empty - TP#328137 - 03/09/2015
		    //swftCO.setErrorMsg(sErrMsg);
		    //return -1; 
		    continue;	//HGhazal - Add continue to skip this order - TP#328137 - 03/09/2015 
		}

		// sMsgBody.equals("") //HGhazal - add condition on order
		if (("".equals(sMsgBody) || "-1".equals(sMsgBody)) && iMsgCounter == 1)
		{
		    // Message <PARAM1> Module <PARAM2> Transaction Type
		    // <PARAM3> was not created for Transaction No <PARAM4>
		    sErrMsg = commonLibBO.returnTranslErrorMessage(66686, new String[] { sMsgCode, sModule, sTransType,
			    bdTrsNo.toString() }, sLanguage);
		    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode, sErrMsg,
			    sLanguage, swiftOutwardSC);
		    bErrorBody = true;
		}
		else
		{
		    if(cPreviewSwiftMsg == 'N')
		    {
			swiftOutwardSC.setCompCode(bdCompCode);
			/*if (swiftOutwardSC.getBranchCode() ==null)
			{
				swiftOutwardSC.setBranchCode(bdBranchCode);
			} BMOUPI180343*/
			swiftOutwardSC.setBranchCode(bdBranchCode);
			swiftOutwardSC.setMsgCode(sMsgCode);
			swiftOutwardSC.setModule(sModule);
			swiftOutwardSC.setTransType(sTransType);
			swiftOutwardSC.setTrsNo(bdTrsNo);
			swiftOutwardSC.setMsgOrder(new BigDecimal(iMsgCounter));//efarah 15-03-2017 TP#492696


			bdCountTrsNo = NumberUtil.nullToZero(swiftOutwardDAO.returnCountHstTrsNo(swiftOutwardSC));

			if(bdCountTrsNo.equals(BigDecimal.ZERO))
			{
			    if(iNbrGeneration > 1)
			    {
				sNewFileName = swiftOutwardNonTransBO.returnFileName(sMsgCode, sModule, bdTrsNo,
					sSwiftFile, iMsgCounter, bdBranchCode, sFileExt, sLanguage,bdCompCode);// olivia //Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
												    // 31/07/2014
												    // jenkin
												    // issues
			    }
			    else
			    {
				sNewFileName = swiftOutwardNonTransBO.returnFileName(sMsgCode, sModule, bdTrsNo,
					sSwiftFile, 0, bdBranchCode, sFileExt, sLanguage,bdCompCode);// olivia //Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
											  // 31/07/2014
											  // jenkin
											  // issues
			    }
			    swftCO.setMsgFileName(sNewFileName);

			    File newSwftFile = null;
				try {
					newSwftFile = new PathFileSecure(sNewFileName);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			    if(newSwftFile.length() > 0 && sbsErrPrvMsg.length()>0)
			    {
				sbsErrPrvMsg.append("\r\n");
				sbsErrPrvMsg.append("$");
				sbsErrPrvMsg.append("\r\n");
			    }
			    else
			    {
				sbsErrPrvMsg.append("");
			    }

			    if(NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getFORMAT_MSG()).equals(
				    BigDecimal.ONE))
			    {
				byte[] bts1 = new BigInteger("0001", 8).toByteArray();
				byte[] bts2 = new BigInteger("0003", 8).toByteArray();
				byte[] bts3 = new BigInteger("040", 8).toByteArray();
				try
				{
				    sbsSwiftMsg.append(new String(bts1, FileUtil.DEFAULT_FILE_ENCODING));
				    sbsSwiftMsg.append(sbsHeader.toString());
				    sbsSwiftMsg.append(sMsgBody);
				    sbsSwiftMsg.append("-}");
				    sbsSwiftMsg.append(new String(bts2, FileUtil.DEFAULT_FILE_ENCODING));
				}
				catch(UnsupportedEncodingException e)
				{
				    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode, e
					    .getMessage().substring(0, 900), sLanguage, swiftOutwardSC);
				}
				// byte[] swiftMsgbyteArray =
				// sSwiftMsg.getBytes();
				// int iMsgSize = swiftMsgbyteArray.length %
				// 512;
				int iMsgSize = sbsSwiftMsg.length() % 512;
				int iSpace = 512 - iMsgSize;
				StringBuffer sbSwiftMsg = new StringBuffer();
				while(iSpace > 0)
				{
				    /*
				     * CEO 24/01/2014 commented the below line
				     * since it is not recommended to
				     * concatenate strings in a loop using
				     * String so the best practice is to use
				     * StringBuffer instead of String
				     */
				    // sSwiftMsg = sSwiftMsg + new String(bts3);
				    try
				    {
					// sbSwiftMsg.append(sbsSwiftMsg.toString()
					// + new String(bts3,
					// FileUtil.DEFAULT_FILE_ENCODING));olivia
					sbSwiftMsg.append(new String(bts3, FileUtil.DEFAULT_FILE_ENCODING));// olivia
				    }
				    catch(UnsupportedEncodingException e)
				    {
					swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0,
						cGenMode, e.getMessage().substring(0, 900), sLanguage, swiftOutwardSC);
				    }
				    iSpace = iSpace - 1;
				}
				sbsSwiftMsg.append(sbSwiftMsg.toString());
			    }
			    else
			    {
				sbsSwiftMsg.append(sbsErrPrvMsg.toString());
				sbsSwiftMsg.append(sbsHeader.toString());
				sbsSwiftMsg.append(sMsgBody);
				sbsSwiftMsg.append("-}");
			    }

			    // Get CF_ACK_NACK
			    bdAckNackCtr = (BigDecimal) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep,
				    sqlRowCount, sqlColSize, "cf_ack_nack");

			    SWIFT_HISTORYVOWithBLOBs swiftHstVOWithBLOBs = new SWIFT_HISTORYVOWithBLOBs();

			    swiftHstVOWithBLOBs.setCOMP_CODE(bdCompCode);
			    swiftHstVOWithBLOBs.setBRANCH_CODE(swiftOutwardSC.getBranchCode());
			    swiftHstVOWithBLOBs.setMSG_CODE(sMsgCode);
			    swiftHstVOWithBLOBs.setMODULE(sModule);
			    swiftHstVOWithBLOBs.setTRX_TYPE(sTransType);
			    swiftHstVOWithBLOBs.setTRS_NO(bdTrsNo);
			    swiftHstVOWithBLOBs.setMSG_ORDER(new BigDecimal(iMsgCounter));//efarah 15-03-2017 TP#492696
			    swiftHstVOWithBLOBs.setACK_NACK_CTR(bdAckNackCtr);
			    swiftHstVOWithBLOBs.setMSG_IN_OUT("O");
			    swiftHstVOWithBLOBs.setREFERENCE_TAG_DATA(swftCO.getTagRefVal());
			    swiftHstVOWithBLOBs.setHISTORY_DATE(dtHistoryDate);
			    if (genFileYN.equals(new BigDecimal(1))){
			    swiftHstVOWithBLOBs.setMID_STATUS(ConstantsCommon.PENDING_STATUS);//LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java  
			    }
			    swiftHstVOWithBLOBs.setSWIFT_TRX_NO(swiftTrxNo);//LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java 
			    swiftHstVOWithBLOBs.setSWIFT_MSG_BLOB(sbsSwiftMsg.toString());
			    genericDAO.insert(swiftHstVOWithBLOBs);
			    
			    // Write Swift message into file
			  if (genFileYN.equals(new BigDecimal(0))){//LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java
			    try
			    {
				FileOutputStream fos = new FileOutputStream(sNewFileName, true);
				fos.write(sbsSwiftMsg.toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
				fos.flush();
				fos.close();
				swftCO.setSwiftMessage(sbsSwiftMsg.toString());// itani
			    }
			    catch(Exception e)
			    {
				// Message <PARAM1> Module <PARAM2> Transaction
				// Type <PARAM3> Transaction No <PARAM4> Order
				// <PARAM5> was not written in File Successfully
				sErrMsg = commonLibBO.returnTranslErrorMessage(66684, new String[] { sMsgCode, sModule,
					sTransType, bdTrsNo.toString(), String.valueOf(iMsgCounter) }, sLanguage);
				if(e.getMessage() != null)
				{
				    sErrMsg = sErrMsg.concat("-").concat(e.getMessage());// olivia
											 // 31/07/2014
											 // jenkin
											 // issues
				}
				swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode,
					sErrMsg, sLanguage, swiftOutwardSC);
				swftCO.setErrorMsg(sErrMsg);
				return -1;
			    }

			    }//LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java  
			  
			    // Message <PARAM1> Module <PARAM2> Transaction Type
			    // <PARAM3> Transaction No <PARAM4> Order <PARAM5>
			    // generated Successfully
			    sErrMsg = commonLibBO.returnTranslErrorMessage(66685, new String[] { sMsgCode, sModule,
				    sTransType, bdTrsNo.toString(), String.valueOf(iMsgCounter) }, sLanguage);
				sFileMode = commonLibBO.returnSwiftCtrlRecValues().getFILE_MODE();
			    if(StringUtil.nullToEmpty(sFileMode).equals("2"))
			    {
					    if(iNbrGeneration > 1)
					    {
					    	if(!StringUtil.nullToEmpty(sFolderLocation).isEmpty() && !"".equals(sFolderLocation))
					    	{
					    		File folderLocationFileName = null;
								try {
									folderLocationFileName = new PathFileSecure(sNewFileName);
								} catch (Exception e2) {
									e2.printStackTrace();
								}
					    		sFileName = sFolderLocation+"/"+folderLocationFileName.getName();
					    		
					    	}
					    	else
					    	{	
							sFileName = swiftOutwardNonTransBO.returnFileNameMode2(sMsgCode, sModule, bdTrsNo,
								sSwiftFile, iMsgCounter, bdBranchCode, sFileExt, sLanguage);
					    	}
					    }
					    else
					    {
					    	if(!StringUtil.nullToEmpty(sFolderLocation).isEmpty() && !"".equals(sFolderLocation))
					    	{
					    		File folderLocationFileName = null;
								try {
									folderLocationFileName = new PathFileSecure(sNewFileName);
								} catch (Exception e2) {
									e2.printStackTrace();
								}
					    		sFileName = sFolderLocation+"/"+folderLocationFileName.getName();
					    		
					    	}
					    	else
					    	{	
						    	sFileName = swiftOutwardNonTransBO.returnFileNameMode2(sMsgCode, sModule, bdTrsNo,
									sSwiftFile, 0, bdBranchCode, sFileExt, sLanguage);
					    	}
					    }
					    //LBedrane when copying KIB170005 605700 - as per Mhojeij in case the genFileYN is not check the log will be generated without defining the location of the log <Start>
					   if (genFileYN.equals(new BigDecimal(0)))
					   {
						   		sErrMsg = sErrMsg + " " + sFileName;
					    }
					    else
					    {
					    	sErrMsg = sErrMsg + " ";
					    }
					   //LBedrane when copying KIB170005 605700 <End>
			    }
			    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 1, cGenMode, sErrMsg,
				    sLanguage, swiftOutwardSC);

			    if(StringUtil.nullToEmpty(sbsSwiftMsg.substring(0, 1)).equals("$"))
			    {
				sSwiftMsg = sbsSwiftMsg.substring(1, sbsSwiftMsg.length());
				sbsSwiftMsg = new StringBuffer("");
				sbsSwiftMsg.append(sSwiftMsg);
			    }
			    sbsSwiftMsg= new StringBuffer("");//HGhazal - TP#295141 - Msgs are duplicated - 07/05/2015 - copied on 24/08/2015
			    // lCountMsg = lCountMsg + 1 ;
			}
			else //HGhazal - Add error message if trx is already processed - 10/02/2015
			{
			    // Message <PARAM1> Module <PARAM2> Transaction Type
			    // <PARAM3> Transaction No <PARAM4> Order <PARAM5>
			    // is already processed
			    sErrMsg = commonLibBO.returnTranslErrorMessage(66772, new String[] { sMsgCode, sModule,
				    sTransType, bdTrsNo.toString(), String.valueOf(iMsgCounter) }, sLanguage);
			    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 1, cGenMode, sErrMsg,
				    sLanguage, swiftOutwardSC);
			    swftCO.setErrorMsg(sErrMsg);
			    return -1;
			}
		    }
		    else
		    // cPreviewSwiftMsg == 'Y'
		    {
			sbsSwiftMsg.append(sbsErrPrvMsg.toString());
			sbsSwiftMsg.append(sbsHeader.toString());
			sbsSwiftMsg.append(sMsgBody);
			sbsSwiftMsg.append("-}");

			sbsSwiftMessage.append(sbsSwiftMsg.toString());
			swftCO.setSwiftMessage(sbsSwiftMessage.toString());
			sbsSwiftMsg= new StringBuffer("");//HGhazal - TP#295141 - Msgs are duplicated - 07/05/2015 - copied on 24/08/2015
			if(!bErrorPreview)
			{
			    // Message <PARAM1> Module <PARAM2> Transaction Type
			    // <PARAM3> Transaction No <PARAM4> Order <PARAM5>
			    // previewed Successfully
			    sErrMsg = commonLibBO.returnTranslErrorMessage(66694, new String[] { sMsgCode, sModule,
				    sTransType, bdTrsNo.toString(), String.valueOf(iMsgCounter) }, sLanguage);
			    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 1, cGenMode, sErrMsg,
				    sLanguage, swiftOutwardSC);
			}
		    }
		}
	    }

	    lCountMsg = lCountMsg + 1;
	}

	swftCO.setCountMsg(lCountMsg);

	if(bErrorProcess || bErrorPreview)
	{
	    // Message <PARAM1> Module <PARAM2> Transaction Type <PARAM3> was
	    // not created for Transaction No <PARAM4>
	    sErrMsg = commonLibBO.returnTranslErrorMessage(66686, new String[] { sMsgCode, sModule, sTransType,
		    bdTrsNo.toString() }, sLanguage);
	    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode, sErrMsg, sLanguage,
		    swiftOutwardSC);
	    swftCO.setErrorMsg(sErrMsg);
	    return -1;
	}
	else if(bErrorBody)
	{
	    swftCO.setErrorMsg(sErrMsg);
	   return -1;
	}
	else
	{
	    swftCO.setErrorMsg(sErrMsg);
	    return 1;
	}
    }

    public String buildMessage(int iProcessInd, ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep,
	    int sqlRowCount, int sqlColSize, BigDecimal bdCompCode, String sMsgCode, String sModule, String sTransType,
	    BigDecimal bdTrsNo, int iMsgCounter, BigDecimal bdRepId, String sRepTitle, char cPreviewSwiftMsg,
	    BigDecimal bdPreviewWithErr, char cGenMode, String theApplication, SwiftCO swftCO, String sLanguage,
	    SwiftOutwardSC swiftOutwardSC, ArrayList<Map<String, Object>> aListMapSqlRep,SWIFT_MSGMODVO swftMsgModVO) throws BaseException
    {
	String sTagRef = "";
	int isSybase;

	ArrayList<SwiftOutwardProcessCO> swiftOutProcessCO;

	swiftOutwardSC.setMsgCode(sMsgCode);
	swiftOutwardSC.setModule(sModule);
	swiftOutwardSC.setTransType(sTransType);
	swiftOutwardSC.setMsgOrder(new BigDecimal(iMsgCounter));
	swiftOutProcessCO = swiftOutwardDAO.returnAllocationParameters(swiftOutwardSC);

	isSybase = commonLibBO.returnIsSybase();
	swftCO.setTagRefVal("");//Hojeij - 29/05/2018
	SWIFT_MSG_REFVO swiftMsgRefVO = new SWIFT_MSG_REFVO();
	SWIFT_MSG_REFVO swftMsgRefVO;
	swiftMsgRefVO.setCOMP_CODE(bdCompCode);
	swiftMsgRefVO.setMSG_CODE(sMsgCode);
	swiftMsgRefVO.setMODULE(sModule);
	swiftMsgRefVO.setIN_OUT("O");
	swftMsgRefVO = (SWIFT_MSG_REFVO) genericDAO.selectByPK(swiftMsgRefVO);
	if(swftMsgRefVO != null)
	{
	    sTagRef = StringUtil.nullToEmpty(swftMsgRefVO.getTAG());
	}
	String sErrMsg = "";
	if(swiftOutProcessCO.isEmpty())
	{
	    // No Message is parameterized For <PARAM1> Module <PARAM2>
	    // Transaction Type <PARAM3> Order <PARAM4>
	    sErrMsg = commonLibBO.returnTranslErrorMessage(66687, new String[] { sMsgCode, sModule, sTransType,
		    String.valueOf(iMsgCounter) }, sLanguage);
	    swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 2, cGenMode, sErrMsg, sLanguage,
		    swiftOutwardSC);
	    return "-1";
	}

	BigDecimal bdGrpNbr, bdNbrTrx;
	int iBeginGrp, iEndGrp;
	int iIdx = 0;//EFarah - repetitive tags issue
	StringBuilder sbsMessage = new StringBuilder("");
	HashMap<String,String> tagNameDescMap = new HashMap<String,String>();//LBedrane on 11/12/2018 -  #714395 - TAGs new changes in the amendment screen */
	for(int iCount = 0; iCount < swiftOutProcessCO.size(); iCount++)
	{
		tagNameDescMap.put(swiftOutProcessCO.get(iCount).getSwiftFormatVO().getTAG(), swiftOutProcessCO.get(iCount).getSwiftFormatVO().getDESCRIPTION());//LBedrane on 11/12/2018 -  #714395 - TAGs new changes in the amendment screen */
	    bdGrpNbr = swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getGROUP_NBR();
	    if(isSybase == 1)
	    {
		bdNbrTrx = new BigDecimal(swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
			sqlColSize, "nbr_trx").toString());
	    }
	    else
	    {
		bdNbrTrx = (BigDecimal) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
			sqlColSize, "nbr_trx");
	    }

	    iBeginGrp = NumberUtil.nullToZero(swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getBEGIN_GRP())
		    .intValue();
	    iEndGrp = NumberUtil.nullToZero(swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getEND_GRP()).intValue();

	    bdGrpNbr = NumberUtil.nullToZero(bdGrpNbr);
	    bdNbrTrx = NumberUtil.nullToZero(bdNbrTrx);

	    BigDecimal bdIncludeHdr;

	    bdIncludeHdr = swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getINCLUDE_HDR();

	    bdIncludeHdr = NumberUtil.nullToZero(bdIncludeHdr);
	    //int iIdx = 0;//EFarah - repetitive tags issue
	    if(iBeginGrp > 0 && iIdx == 0 && bdGrpNbr.intValue()==1)//EFarah - first group
	    {
		if(bdIncludeHdr.intValue() == 1)
		{
		    iIdx = 0;
		}
		else
		{
		    iIdx = 1;
		}
	    }

	    if(iIdx > 0 && bdNbrTrx.intValue() == 0)
	    {
		if(iEndGrp > 0)
		{
		    iIdx = 0;
		}
		continue;
	    }
	    BigDecimal bdLineNo;
	    String sStatus, sInformation, sInfoMsg = "";
	    sStatus = StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftFormatVO().getSTATUS());
	    bdLineNo = NumberUtil.nullToZero(swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getLINE_NO());
	    sInformation = StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getINFORMATION());

	    if("".equals(sInformation))
	    {
		// The Line End Information at line <PARAM1> in the allocation
		// For Message <PARAM2> Module <PARAM3> Transaction Type
		// <PARAM4> Order <PARAM5> is not defined -
		sErrMsg = commonLibBO.returnTranslErrorMessage(66688, new String[] { bdLineNo.toString(), sMsgCode,
			sModule, sTransType, String.valueOf(iMsgCounter) }, sLanguage);
		swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode, sErrMsg, sLanguage,
			swiftOutwardSC);

		if(bdPreviewWithErr.equals(BigDecimal.ONE) && cPreviewSwiftMsg == 'Y')
		{
		    // -----ERROR----- The Line End Information at line <PARAM1>
		    // in the allocation For \r\n Message <PARAM2> Module
		    // <PARAM3> Transaction Type \r\n <PARAM4> Order <PARAM5> is
		    // not defined -
		    sInfoMsg = commonLibBO.returnTranslErrorMessage(66689, new String[] { bdLineNo.toString(),
			    sMsgCode, sModule, sTransType, String.valueOf(iMsgCounter) }, sLanguage);
		}
		else
		{
		    return "-1";
		}
	    }

	    String sColumnName, sSkipCond, sTagCond, sValueCond;
	    if(swiftOutProcessCO.get(iCount).getSwiftMsgDetVOWithBLOBs() != null){
	    	 sColumnName = StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftMsgDetVOWithBLOBs()
	    			    .getCOLUMN_NAME());
	    		    // sTagColumnName =
	    		    // StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftMsgDetVOWithBLOBs().getTAG_COND());//commented
	    		    // by Olivia due to Jenkin issues "UnusedLocalVariable"
	    		    sSkipCond = StringUtil
	    			    .nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftMsgDetVOWithBLOBs().getSKIP_COND());
	    		    sTagCond = StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftMsgDetVOWithBLOBs().getTAG_COND());
	    		    sValueCond = StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftMsgDetVOWithBLOBs()
	    			    .getVALUE_COND());
	    		    String skipSpecialChars = swiftOutProcessCO.get(iCount).getSwiftMsgDetVOWithBLOBs().getSKIP_SPECIAL_CHARS_YN();

	    		    if("".equals(sColumnName))
	    		    {
	    			sColumnName = sValueCond;
	    		    }

	    		    // Value Condition Checking
	    		    String sValueTag = "";
	    		    Object oValueTagObj;
	    		    if(sValueCond.length() > 0)
	    		    {
	    			oValueTagObj = commonLibBO.executeExpression(sValueCond, sqlRowCount + iIdx, aListMapSqlRep);
	    			sValueTag = StringUtil.nullToEmpty(oValueTagObj).toString();
	    		    }

	    		    else
	    		    {
	    			oValueTagObj = swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount + iIdx,
	    				sqlColSize, sColumnName);
	    			sValueTag = StringUtil.nullToEmpty(oValueTagObj).toString();
	    		    }

	    		    // Remove the NON-SWIFT Characters from the message
	    		    sValueTag = swiftOutwardNonTransBO.removeSpecialChar(sValueTag,swftMsgModVO!=null?swftMsgModVO.getINCLUDE_ARABIC_YN():BigDecimal.ZERO,skipSpecialChars);

	    		    BigDecimal bdTrimLines;

	    		    bdTrimLines = NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getTRIM_LINES());
	    		    if(bdTrimLines.compareTo(BigDecimal.ONE) == 0)
	    		    {
	    			sValueTag = swiftOutwardNonTransBO.trimTag(sValueTag);
	    		    }

	    		    BigDecimal bdUpperCase;

	    		    bdUpperCase = NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getUPPER_CASE());
	    		    if(bdUpperCase.compareTo(BigDecimal.ONE) == 0)
	    		    {
	    			sValueTag = sValueTag.toUpperCase(Locale.ENGLISH);
	    		    }
	    		    String sTagName;
	    		    boolean bTagFound = false;
	    		    if(!bTagFound)
	    		    {
	    			sTagName = StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftFormatVO().getTAG());
	    			if(sTagName.equals(sTagRef))
	    			{
	    			    swftCO.setTagRefVal(sValueTag); // SET THE VALUE TO SAVE IT
	    			    // IN SWIFT_HISTORY
	    			    bTagFound = true;
	    			}
	    		    }

	    		    // Tag Condition Checking
	    		    StringBuilder sbsTag = new StringBuilder("");
	    		    Object oTagObj;
	    		    if(sTagCond.length() > 0)
	    		    {
	    			oTagObj = commonLibBO.executeExpression(sTagCond, sqlRowCount + iIdx, aListMapSqlRep);
	    			sbsTag.append(StringUtil.nullToEmpty(oTagObj).toString());
	    		    }
	    		    else
	    		    {
	    			sbsTag.append(StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftFormatVO().getTAG()));
	    		    }

	    		    if(("".equals(sbsTag.toString())) && ("".equals(sTagCond)))
	    		    {
	    			// Tag at Line <PARAM1> in Message <PARAM2> Module <PARAM3>
	    			// Transaction Type <PARAM4> Order <PARAM5> does not exist -
	    			sErrMsg = commonLibBO.returnTranslErrorMessage(66690, new String[] { String.valueOf(iCount), sMsgCode,
	    				sModule, sTransType, String.valueOf(iMsgCounter) }, sLanguage);
	    			swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode, sErrMsg, sLanguage,
	    				swiftOutwardSC);

	    			if(bdPreviewWithErr.equals(BigDecimal.ONE) && cPreviewSwiftMsg == 'Y')
	    			{
	    			    // -----ERROR----- Tag Not Defined in Swift Message -
	    			    sbsTag = new StringBuilder("");
	    			    sbsTag.append(commonLibBO.returnTranslErrorMessage(66691, new String[] { sMsgCode }, sLanguage));
	    			}
	    			else
	    			{
	    			    return "-1";
	    			}
	    		    }

	    		    String sSkipErrMsg = "", sKipTag = "";
	    		    int iFirstLineInGrp;
	    		    Object oSkipTagObj;
	    		    if("M".equals(sStatus) && ("".equals(sValueTag)))
	    		    {
	    			// Tag <PARAM1> at Line Number <PARAM2> in <PARAM3> Module
	    			// <PARAM4> Transaction Type <PARAM5> Order <PARAM6> is a
	    			// mandatory tag and its value is null -
	    			sErrMsg = commonLibBO
	    				.returnTranslErrorMessage(66692, new String[] { sbsTag.toString(), String.valueOf(iCount),
	    					sMsgCode, sModule, sTransType, String.valueOf(iMsgCounter) }, sLanguage);
	    			swiftOutwardNonTransBO.writeLogFile(bdCompCode, bdRepId, sRepTitle, 0, cGenMode, sErrMsg, sLanguage,
	    				swiftOutwardSC);

	    			if(bdPreviewWithErr.equals(BigDecimal.ONE) && cPreviewSwiftMsg == 'Y')
	    			{
	    			    // -----ERROR----- Tag <PARAM1> at Line Number <PARAM2> in
	    			    // <PARAM3> \r\n Module <PARAM4> Transaction Type <PARAM5>
	    			    // Order <PARAM6> \r\n is a mandatory tag and its value is
	    			    // null -
	    			    sValueTag = commonLibBO.returnTranslErrorMessage(66693, new String[] { sbsTag.toString(),
	    				    String.valueOf(iCount), sMsgCode, sModule, sTransType, String.valueOf(iMsgCounter) },
	    				    sLanguage);
	    			}
	    			else
	    			{
	    			    return "-1";
	    			}
	    		    }
	    		    // Check if the tag status is mandatory and the value is not null,
	    		    // but the user wants to skip the tag
	    		    else if(("M".equals(sStatus)) && (sValueTag.length() > 0))
	    		    {
	    			sSkipErrMsg = "";
	    			if(sSkipCond.length() > 0)
	    			{
	    			    oSkipTagObj = commonLibBO.executeExpression(sSkipCond, sqlRowCount + iIdx, aListMapSqlRep);
	    			    sKipTag = StringUtil.nullToEmpty(oSkipTagObj).toString().toUpperCase();
	    			    if("Y".equals(sKipTag))
	    			    {
	    				continue;
	    			    }
	    			}
	    		    }
	    		    else if("O".equals(sStatus))
	    		    {
	    			oSkipTagObj = commonLibBO.executeExpression(sSkipCond, sqlRowCount + iIdx, aListMapSqlRep);
	    			sKipTag = StringUtil.nullToEmpty(oSkipTagObj).toString().toUpperCase();
	    			if("Y".equals(sKipTag))
	    			{
	    			    if(iEndGrp > 0)
	    			    {
	    				if(iIdx < bdNbrTrx.intValue())
	    				{
	    				    iFirstLineInGrp = NumberUtil.nullToZero(
	    					    swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getFIRST_LINE_IN_GRP()).intValue();
	    				    iCount = iFirstLineInGrp - 1;
	    				    iIdx++;
	    				}
	    				else if(iIdx == bdNbrTrx.intValue())
	    				{
	    				    iIdx = 0;
	    				}
	    			    }
	    			    continue;
	    			}
	    		    }

	    		    sValueTag = swiftOutwardNonTransBO.changeFormat(sValueTag);

	    		    // BOK110200 - ABARS110008
	    		    if("@@#".equals(sValueTag))
	    		    {
	    			continue;
	    		    }

	    		    StringBuffer sbsTagDesc = new StringBuffer(); // olivia
	    		    BigDecimal bdPrintSwift;

	    		    bdPrintSwift = NumberUtil.nullToZero(commonLibBO.returnSwiftCtrlRecValues().getPRINT_SWIFT());
	    		    String sOldTag = "", sOldTagDesc = "", sTagDesc = "", sApplication = theApplication;
	    		    if(bdPrintSwift.equals(BigDecimal.ONE))
	    		    {
	    			sTagDesc = StringUtil.nullToEmpty(swiftOutProcessCO.get(iCount).getSwiftFormatVO().getDESCRIPTION());
	    			sApplication = StringUtil.nullToEmpty(sApplication).toUpperCase();
	    			sOldTagDesc = StringUtil.nullToEmpty(sOldTagDesc);
	    			if(sTagDesc.equals(sOldTagDesc) || sOldTag.equals(sbsTag.toString()) || iProcessInd == 1)
	    			{
	    			    sTagDesc = "";
	    			}
	    			else
	    			{
	    			    if("LF".equals(sInformation))
	    			    {
	    				if((!"".equals(sOldTagDesc))
	    					&& (sTagDesc.equals(sOldTagDesc.substring(0, sOldTagDesc.length() - 2))))
	    				{
	    				    sTagDesc = "";
	    				}
	    				else
	    				{
	    				    sbsTagDesc.append(sTagDesc);
	    				    if(! sValueTag.isEmpty()){
	    				    	sbsTagDesc.append("\r\n");// olivia
	    				    }
	    				    
	    				    sTagDesc = sbsTagDesc.toString();// olivia
	    				    // sTagDesc = sTagDesc + "\r\n";//olivia
	    				}
	    			    }
	    			    else
	    			    {
	    				if(!"".equals(sTagDesc))
	    				{
	    				    if((!"".equals(sOldTagDesc))
	    					    && (sTagDesc.equals(sOldTagDesc.substring(0, sOldTagDesc.length() - 2))))
	    				    {
	    					sTagDesc = "";
	    				    }
	    				    else
	    				    {
	    					sbsTagDesc.append(sTagDesc);
	    					if (! sValueTag.isEmpty()){
	    						sbsTagDesc.append("\r\n");// olivia
	    					}
	    					
	    					sTagDesc = sbsTagDesc.toString();// olivia
	    					// sTagDesc = sTagDesc + "\r\n";//olivia
	    				    }
	    				}
	    			    }
	    			}
	    			sbsMessage.append(sbsTag.toString());
	    			sbsMessage.append(sTagDesc);
	    			sbsMessage.append(sSkipErrMsg);
	    			sbsMessage.append(sValueTag);
	    		    }
	    		    else
	    		    {
	    			sbsMessage.append(sbsTag.toString());
	    			sbsMessage.append(sSkipErrMsg);
	    			sbsMessage.append(sValueTag);
	    		    }

	    		    sOldTag = sbsTag.toString();
	    		    sOldTagDesc = sTagDesc;

	    		    if("LF".equals(sInformation))
	    		    {
	    			sbsMessage.append("\r\n");
	    		    }
	    		    else if("C".equals(sInformation))
	    		    {
	    			sbsMessage.append("");
	    		    }
	    		    else
	    		    {
	    			sbsMessage.append(sInfoMsg);
	    		    }

	    		    // Identify the end of a tags group
	    		    if(iEndGrp > 0)
	    		    {
	    			if(iIdx < bdNbrTrx.intValue())
	    			{
	    			    iFirstLineInGrp = NumberUtil.nullToZero(
	    				    swiftOutProcessCO.get(iCount).getSwiftMsgDetVO().getFIRST_LINE_IN_GRP()).intValue();
	    			    iCount = iFirstLineInGrp - 1;
	    			    iIdx++;
	    			}
	    			else if(iIdx == bdNbrTrx.intValue())
	    			{
	    			    iIdx = 0;
	    			}
	    		    }
	    }
	    else{
	    	
	    }
	   
	}

	/*Added  by LBedrane on 11/12/2018 -  #714395 - TAGs new changes in the amendment screen */
	String sbsMessageContents = sbsMessage.toString();
	if(sbsMessageContents.indexOf("<ADD>") != -1 || sbsMessageContents.indexOf("<DELETE>") != -1
		|| sbsMessageContents.indexOf("<REPALL>") != -1)
	{
	    return replaceSpecialTagsByContents(sbsMessageContents,tagNameDescMap);
	}
	
	//return sbsMessage.toString(); /*Committed by LBedrane  on 11/12/2018  -  #714395 - TAGs new changes in the amendment screen*/
	return sbsMessageContents; /*Added  by LBedrane on 11/12/2018  -  #714395 - TAGs new changes in the amendment screen*/
    }
    
    
    /*Added  by LBedrane on 11/12/2018  -  #714395 - TAGs new changes in the amendment screen*/
    /**
     * Method to replace ADD,DELETE and REPALL tags by their specific contents
     * @param messageContents
     * @param tagNameDescMap
     * @return
     */
    private String replaceSpecialTagsByContents(String messageContents,HashMap<String,String> tagNameDescMap)
    {
	String sbsMessageStr = messageContents;
	StringBuffer tagsReplaced = new StringBuffer("");
	List<String> stringsADD = new ArrayList<String>();
	List<String> stringsREP = new ArrayList<String>();
	List<String> stringsDEL = new ArrayList<String>();
	// map tag, tag contents
	LinkedHashMap<String, String> allTagsMap = new LinkedHashMap<String, String>();
	int index1;
	int index2;
	String currentTag;
	String tagContents = "";
	while(sbsMessageStr.indexOf(":") != -1)
	{
	    index1 = sbsMessageStr.indexOf(":");
	    index2 = sbsMessageStr.indexOf(":", index1 + 1);
	    currentTag = sbsMessageStr.substring(index1, index2 + 1);
	    // control for the last tag in second substring parameter
	    tagContents = sbsMessageStr.substring(index2 + 1, sbsMessageStr.indexOf(":", index2 + 1) == -1
		    ? sbsMessageStr.length() : sbsMessageStr.indexOf(":", index2 + 1));
	    // regular tag
	    if(tagContents.indexOf("<ADD>") == -1 && tagContents.indexOf("<DELETE>") == -1
		    && tagContents.indexOf("<REPALL>") == -1)
	    {
		allTagsMap.put(currentTag, tagContents);
	    }
	    else
	    {
		if(tagContents.indexOf("<ADD>") != -1)
		{
		    stringsADD = Arrays.asList(tagContents.replaceAll("(\r\n|\n|\r)", " ").replaceAll("^.*?<ADD>", "")
			    .replaceAll("(\r\n|\n|\r)", " ").split("</ADD>.*?(<ADD>|$)"));
		}
		if(tagContents.indexOf("<REPALL>") != -1)
		{
		    stringsREP = Arrays
			    .asList(tagContents.replaceAll("(\r\n|\n|\r)", " ").replaceAll("^.*?<REPALL>", "")
				    .replaceAll("(\r\n|\n|\r)", " ").split("</REPALL>.*?(<REPALL>|$)"));
		}
		if(tagContents.indexOf("<DELETE>") != -1)
		{
		    stringsDEL = Arrays
			    .asList(tagContents.replaceAll("(\r\n|\n|\r)", " ").replaceAll("^.*?<DELETE>", "")
				    .replaceAll("(\r\n|\n|\r)", " ").split("</DELETE>.*?(<DELETE>|$)"));
		}
		for(int i = 0; i < stringsADD.size(); i++)
		{
		    tagsReplaced.append("/ADD/+" + stringsADD.get(i) + "\n");
		}
		for(int i = 0; i < stringsDEL.size(); i++)
		{
		    tagsReplaced.append("/DELETE/+" + stringsDEL.get(i) + "\n");
		}
		for(int i = 0; i < stringsREP.size(); i++)
		{
		    tagsReplaced.append("/REPALL/+" + stringsREP.get(i) + "\n");
		}
		//to distinguish tags containing the special characters
		allTagsMap.put(currentTag+"~#~", currentTag+tagNameDescMap.get(currentTag)+"\n"+tagsReplaced.toString());
	    }
	    tagsReplaced = new StringBuffer("");
	    if(sbsMessageStr.indexOf(":", index2 + 1) == -1)
	    {
		break;
	    }
	    else
	    {
		sbsMessageStr = sbsMessageStr.substring(sbsMessageStr.indexOf(tagContents) + tagContents.length(),
			sbsMessageStr.length());
	    }
	}
	for(Entry<String, String> entry : allTagsMap.entrySet())
	{
	    if(entry.getKey().indexOf("~#~") == -1)
	    {
		tagsReplaced.append(entry.getKey() + entry.getValue());
	    }
	    else
	    {
		tagsReplaced.append("\n"+entry.getValue()+"\n");
	    }
	}
	return tagsReplaced.toString();
    } 

    public void markAsGeneratedByTrx(ArrayList<ArrayList<DynFilesColumnCO>> selectResultSqlRep, int sqlRowCount,
	    int sqlColSize, BigDecimal bdCompCode, BigDecimal bdRepId, String sRepTitle, String sLanguage,
	    SwiftOutwardSC swiftOutwardSC) throws BaseException
    {
	String sUpdateStmt = null, sMsgCode, sModule, sTransType;
	int iNbrGeneration;
	BigDecimal bdBranchCode, bdAckNackCtr, bdTrsNo, bdMsgOrder;
	Date dtHistoryDate;

	SWIFT_DWSVO swiftDwsVO = new SWIFT_DWSVO();
	swiftDwsVO.setREP_ID(bdRepId);
	SWIFT_DWSVO swftDwsVO;
	swftDwsVO = (SWIFT_DWSVO) genericDAO.selectByPK(swiftDwsVO);

	if(swftDwsVO != null)
	{
	    sUpdateStmt = swftDwsVO.getUPDATE_STMT();
	}

	updateSwiftTrxNo(selectResultSqlRep, "N", sUpdateStmt, sqlRowCount, sqlColSize, sLanguage, swiftOutwardSC);

	// Get CF_ACK_NACK
	bdAckNackCtr = (BigDecimal) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
		sqlColSize, "cf_ack_nack");

	bdBranchCode = new BigDecimal(swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
		sqlColSize, "branch_code").toString());// olivia

	sMsgCode = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"msg_code");
	bdMsgOrder = new BigDecimal(swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount,
		sqlColSize, "message_order").toString());// olivia
	iNbrGeneration = bdMsgOrder.intValue();
	sTransType = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"trans_type");
	sModule = (String) swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"module");
	bdTrsNo = new BigDecimal(swiftOutwardNonTransBO.returnColumnValue(selectResultSqlRep, sqlRowCount, sqlColSize,
		"trs_no").toString());// olivia

	sMsgCode = StringUtil.nullToEmpty(sMsgCode);
	iNbrGeneration = NumberUtil.nullToZero(iNbrGeneration);
	sTransType = StringUtil.nullToEmpty(sTransType);
	sModule = StringUtil.nullToEmpty(sModule);
	bdTrsNo = NumberUtil.nullToZero(bdTrsNo);
	bdBranchCode = NumberUtil.nullToZero(bdBranchCode);

	dtHistoryDate = commonLibBO.returnSystemDateWithTime();

	SWIFT_HISTORYVOWithBLOBs swiftHstVOWithBLOBs = new SWIFT_HISTORYVOWithBLOBs();

	swiftHstVOWithBLOBs.setCOMP_CODE(bdCompCode);
	swiftHstVOWithBLOBs.setBRANCH_CODE(bdBranchCode);
	swiftHstVOWithBLOBs.setMSG_CODE(sMsgCode);
	swiftHstVOWithBLOBs.setMODULE(sModule);
	swiftHstVOWithBLOBs.setTRX_TYPE(sTransType);
	swiftHstVOWithBLOBs.setTRS_NO(bdTrsNo);
	swiftHstVOWithBLOBs.setMSG_ORDER(new BigDecimal(iNbrGeneration));
	swiftHstVOWithBLOBs.setACK_NACK_CTR(bdAckNackCtr);
	swiftHstVOWithBLOBs.setMSG_IN_OUT("O");
	swiftHstVOWithBLOBs.setHISTORY_DATE(dtHistoryDate);
	swiftHstVOWithBLOBs.setMARK_GENERATED(BigDecimal.ONE);

	genericDAO.insert(swiftHstVOWithBLOBs);

    }
    
    
  //LBedrane when copying KIB170005 605700  we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<Start>
    public BigDecimal returnSwiftTrxNo() throws BaseException
    {
    	//Get sequence/identity
    	BigDecimal ldSwiftTrxNo;
		DBSequenceSC dbSeqSC = new DBSequenceSC();
		dbSeqSC.setSequenceName("SWIFT_TRX_NO_SEQ");
		dbSeqSC.setTableName("SWIFT_TRXNO_IDENTITY");
		
		ldSwiftTrxNo = commonLibBO.returnTableSequence(dbSeqSC);
		
		return ldSwiftTrxNo;
    }
  //LBedrane when copying KIB170005 605700  we copied also ( HGHAZAL - read from sequence value - EWBI160216 - 07/09/2016 from R14.0.9)<End>
    
   //LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java  <Start>
    public BigDecimal ReturnGenFileYnValue() throws BaseException{
    	BigDecimal ldGenFileYn;
    	ldGenFileYn=swiftOutwardDAO.ReturnGenFileYnValue() ;
    	return ldGenFileYn;
    }
  //LBedrane  on 18/01/2018 copying KIB170005 US = 605700 from PB to Java  <END>
    
    public SwiftSignatureSC processSignatureMessage(SwiftSignatureSC swiftSignatureSC) throws BaseException
    {
	try{
		byte[] b = swiftSignatureSC.getContent().getBytes("UTF-8");
		KeyStore keyStore = loadKeyStore(swiftSignatureSC.getKeyStoreFileName(), swiftSignatureSC.getKeyStorePassword());
		PrivateKey privateKey = (PrivateKey) keyStore.getKey(swiftSignatureSC.getKeyAlias(), swiftSignatureSC.getKeyStorePassword().toCharArray());
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(privateKey);
		signature.update(b);
		byte[] signatureBytes = signature.sign();
		//String s = new String(Base64.encode(signatureBytes),"ANSI");
		String s = new String(SecurityUtils.encodeB64(signatureBytes));
		swiftSignatureSC.setSigned(s.replace("\n", "").replace("\r", ""));
		swiftSignatureSC.setOlErrorCode(0);
		swiftSignatureSC.setOsErrorDesc("");
		
		
		return swiftSignatureSC;
	}
	catch(Exception e){
	    swiftSignatureSC.setSigned("");
	    swiftSignatureSC.setOlErrorCode(-1);
	    swiftSignatureSC.setOsErrorDesc(e.toString());
	    return swiftSignatureSC;
	}
    }

    public KeyStore loadKeyStore (String keyStoreFileName, String keyStorePassword) throws Exception
    {
	KeyStore keystore = KeyStore.getInstance("JKS");
	FileInputStream inputStream = null;
	try
	{
	 inputStream = new FileInputStream(keyStoreFileName);
	}
	catch (Exception e) {
	    // TODO: handle exception
	    throw new BaseException(e);
	}
	finally
	{
	    inputStream.close();
	}
	keystore.load(inputStream, keyStorePassword.toCharArray());	
	inputStream.close();
	return keystore; 
    }

}
