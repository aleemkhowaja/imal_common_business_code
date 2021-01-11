package com.path.bo.common.swift.swiftinward;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.KeyStore;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.swift.swiftoutward.SwiftOutwardNonTransBO;
import com.path.bo.common.swift.swiftreconciliation.SwiftReconBO;
import com.path.dbmaps.vo.DF_FILE_PRC_INP_PARMVO;
import com.path.dbmaps.vo.EAS_SERVICESVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dao.common.swift.SwiftInwardDAO;
import com.path.dbmaps.vo.SWIFT_HISTORYVOWithBLOBs;
import com.path.dbmaps.vo.SWIFT_LOG_INVO;
import com.path.dbmaps.vo.SWIFT_MANUAL_PROCESSVOKey;
import com.path.dbmaps.vo.SWIFT_MSGDET_INVO;
import com.path.dbmaps.vo.SWIFT_MSGHDR_INVO;
import com.path.dbmaps.vo.SWIFT_MSG_REFVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathBufferedReaderSecure;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.StringUtil;
import com.path.lib.remote.RmiServiceCaller;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.vo.common.DBSequenceSC;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardIndexCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardProcessCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardSC;
import com.path.vo.swift.SwiftSignatureSC;
import com.path.vo.common.swift.swiftoutward.SwiftCO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.hssf.record.chart.BeginRecord;
import com.path.dbmaps.vo.SWFT_SCHED_MANAGERVO;
import com.path.dbmaps.vo.SWFT_SCHED_MANAGER_INVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import org.springframework.security.crypto.codec.Base64;

public class SwiftInwardBOImpl extends BaseBO implements SwiftInwardBO
{
    private static final String PRINTED = "N";
    private static final String STATUS = "U";
    private static final String SWFT = "SWFT";
    private SwiftInwardDAO swiftInwardDAO;
    private SwiftOutwardNonTransBO swiftOutwardNonTransBO;//Added by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibbo
    private SwiftCO swiftCO;
    private SwiftReconBO swiftReconBO;
    private static Object lock = new Object();//efarah 07/04/2017 EWBI170270

    public void setSwiftReconBO(SwiftReconBO swiftReconBO)
    {
	this.swiftReconBO = swiftReconBO;
    }

    public SwiftCO getSwiftCO()
    {
	return swiftCO;
    }

    public void setSwiftCO(SwiftCO swiftCO)
    {
	this.swiftCO = swiftCO;
    }

    public void setSwiftInwardDAO(SwiftInwardDAO swiftInwardDAO)
    {
	this.swiftInwardDAO = swiftInwardDAO;
    }

    /*
     * used to write inside the swift inward log file Use FileWriter class with
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
    public Integer writeLogFile(BigDecimal bdCompCode, int iIndicator, String theSErrorMsg, String sLanguage,
	    SwiftInwardCO swiftInwardCO) throws BaseException
    {
	try
	{
	    StringBuffer sbsSwiftLogFile = new StringBuffer();
	    String sRepoSwift;
	    String[] saTransMsgArr;

	    sRepoSwift = FileUtil.getFileURLByName("repository");
	    sbsSwiftLogFile.append(swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getLOG_IN_PATH_JAVA());//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter

	    if(swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getLOG_IN_PATH_JAVA() == null)//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66757, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	    if(sRepoSwift.endsWith("/"))
	    {
		sbsSwiftLogFile.insert(0, sRepoSwift);
	    }
	    else
	    {
		sbsSwiftLogFile.insert(0, "/");
		sbsSwiftLogFile.insert(0, sRepoSwift);
	    }

	    swiftInwardCO.setLogFileLocation(sbsSwiftLogFile.toString());
	    Date dtLogDateTime;
	    dtLogDateTime = commonLibBO.returnSystemDateWithTime();

	    String sLogDateTime;
	    sLogDateTime = DateUtil.format(dtLogDateTime, "dd/MM/yyyy HH:mm:ss");
	    String sSeverity;
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
		default:
		    sSeverity = "";
		    break;
	    }
	    String sLogMsg, sErrorMsg = theSErrorMsg;
	    FileOutputStream fw = new FileOutputStream(sbsSwiftLogFile.toString(), true);
	    sLogMsg = bdCompCode.toString() + "\t" + sSeverity + "\t" + sLogDateTime + "\t" + sErrorMsg + "\r\n";
	    fw.write(sLogMsg.getBytes("UTF-8"));
	    fw.flush();
	    fw.close();
	    
	    if(!StringUtil.isNotEmpty(sErrorMsg))
	    {
		return 1;
	    }
	    // insert the logging into DB with DAOException handling
	    try
	    {
		// Create new instance of SWIFT_LOGVO
		SWIFT_LOG_INVO swiftLogInVO = new SWIFT_LOG_INVO();

		// set the values to be inserted into DB
		swiftLogInVO.setCOMP_CODE(bdCompCode);
		swiftLogInVO.setSEVERITY(sSeverity);
		swiftLogInVO.setLOG_DATE(dtLogDateTime);
		swiftLogInVO.setMSG(sErrorMsg);

		// Insert into DB
		genericDAO.insert(swiftLogInVO);
	    }
	    catch(DAOException e)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(2, sLanguage);
		sSeverity = saTransMsgArr[1];
		sErrorMsg = e.getMessage().substring(0, e.getMessage().length());
		fw = new FileOutputStream(sbsSwiftLogFile.toString(), true);
		sLogMsg = bdCompCode.toString() + "\t" + sSeverity + "\t" + sLogDateTime + "\t" + sErrorMsg + "\r\n";
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

    public ArrayList<SwiftInwardCO> readTextFile(String sFileLocation, String sLanguage, BigDecimal bdCompCode,
	    String ackNackSource) throws BaseException
    {

	String sSwiftInwardPath = null;
	File inwardFileMaker;
	boolean bRetun = false;
	String[] saTransMsgArr;

	if("0".equals(ackNackSource))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
	}
	else if("1".equals(ackNackSource))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_ACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
	}
	else if("2".equals(ackNackSource))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_NACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
	}

	sSwiftInwardPath = FileUtil.getFileURLByName("repository").concat(File.separator).concat(sSwiftInwardPath);
	try {
		inwardFileMaker = new PathFileSecure(sSwiftInwardPath);
	} catch (Exception e2) {
		throw new BOException(e2);
	}
	
	if(!inwardFileMaker.exists())
	{
	    bRetun = inwardFileMaker.mkdir();
	    if(!bRetun)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66760, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}

	ArrayList<SwiftInwardCO> swiftInwardCOList = new ArrayList<SwiftInwardCO>();
	SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
//	FileReader msgFile = null;
	PathBufferedReaderSecure reader = null;
	String msgLine = "", cfTag = null;
	Long rowNumber = 0L;
	Long grpNumber = 0L;
	Long nbRowPerGrp = 0L;
	Long nbCompute4 = 0L;
	Long firstLine = 0L;
	int firstOccurence =-1;
	boolean firstTime =false;
	boolean achFlag = false;
	String lsDate = "";
	String lsSignature ="";
	String lsSign = "";
	
	try
	{
	    sSwiftInwardPath = sSwiftInwardPath.concat("/");
//	    msgFile = new FileReader(sSwiftInwardPath.concat(sFileLocation));
	    FileInputStream fis = new FileInputStream(sSwiftInwardPath.concat(sFileLocation));
	    reader = new PathBufferedReaderSecure(new InputStreamReader(fis,FileUtil.DEFAULT_FILE_ENCODING),200000000);
//	    reader = new BufferedReader(msgFile);

	    while((msgLine = reader.readLine()) != null)
	    {
		swiftInwardCO = new SwiftInwardCO();
		if (msgLine.trim().indexOf("<") ==0 && msgLine.indexOf("[CDATA[") < 0)
		{
		    if(msgLine.indexOf("<date>")>=0)
		    {
			lsDate = msgLine.substring(msgLine.indexOf("<date>") + 6, msgLine.indexOf("</date>"));
		    }
		    if(msgLine.indexOf("<signature>")>=0)
		    {
			lsSignature = msgLine.substring(msgLine.indexOf("<signature>") + 11, msgLine.indexOf("</signature>"));
		    }
		    achFlag = true;
		    continue;
		}
		else
		{
		    if(msgLine.indexOf("[CDATA[") > 0)
		    {
			msgLine = msgLine.substring(msgLine.indexOf("[CDATA[") + 7);
		    }
		}
		rowNumber++;
		nbRowPerGrp++;
		swiftInwardCO.setMessage_line(msgLine);
		swiftInwardCO.setCompute_1(rowNumber);// line_nbr
		if (StringUtil.nullToEmpty(lsSign).isEmpty())
		{
		    lsSign = lsSign +  msgLine;
		}
		else
		{
		    lsSign = lsSign +"\r\n" +  msgLine;
		}
		if("$".equals(msgLine))// olivia 31/07/2014 jenkin issues
		{
		    swiftInwardCO.setCf_tag("N");
		    lsSign = null;
		}
		else
		{
			if(msgLine.indexOf("{1:F01") < 0 && (rowNumber==1 && StringUtil.nullToEmpty(swiftInwardCO.getCf_tag()).equals("")))
			{
				writeLogFile(bdCompCode, 0, "The header line should contain: {1:F01 " , sLanguage, swiftInwardCO);
				throw new BOException("The header line should contain: {1:F01 ");
			}
		    if(msgLine.indexOf("{1:F01") >= 0)
		    {
			swiftInwardCO.setCf_tag("H");
		    }
		    else
		    {
			if(StringUtils.left(msgLine, 2).equals("-}"))
			{
			    swiftInwardCO.setCf_tag("T");
			    
			    if (achFlag)
			    {
        			    lsSign = lsSign.substring(0, lsSign.indexOf("-}") + 2);

        			    SWIFT_CONTROLVO swiftControlVO = swiftInwardDAO.returnKeyStore();
        			    lsSign = lsSign + StringUtil.nullToEmpty(swiftControlVO.getSECRET_MESSAGE()) + lsDate;
        			    
        			    lsSign = lsSign + swiftControlVO.getSECRET_MESSAGE() + lsDate;
        			    
        			    SwiftSignatureSC swiftSignatureSC = new SwiftSignatureSC();
        			    swiftSignatureSC.setKeyAlias(swiftControlVO.getKEYSTORE_IN_ALIAS());
        			    swiftSignatureSC.setKeyStoreFileName(FileUtil.getFileURLByName("repository").concat(File.separator).concat(swiftControlVO.getKEYSTORE_IN_PATH()) );
        			    swiftSignatureSC.setKeyStorePassword(SecurityUtils.decryptAES("DIGITALSIGNATURE", swiftControlVO.getKEYSTORE_IN_PASS()));
        			    swiftSignatureSC.setContent(lsSign);
        			    
        			    swiftSignatureSC.setDigitalSignature(lsSignature);
        			    
        			    if (swiftSignatureSC.getOlErrorCode() != 0)
        			    {
        				saTransMsgArr = commonLibBO.returnTranslMessage(66797, sLanguage);
        				writeLogFile(bdCompCode, 0, saTransMsgArr[0] + swiftSignatureSC.getOsErrorDesc(), sLanguage, swiftInwardCO);
        				throw new BOException(saTransMsgArr[0] + swiftSignatureSC.getOsErrorDesc());
        			    }
			    }
			    

			}
			else
			{
			    if("".equals(msgLine))
			    {
				continue;
			    }
			    else if(!"".equals(msgLine) && msgLine.substring(0, 1).equals(":"))
			    {
				swiftInwardCO.setCf_tag(msgLine.substring(0, msgLine.indexOf(":", 2) + 1));
			    }
			    else
			    {
				swiftInwardCO.setCf_tag("");// Tag
			    }
			}
		    }
		}
		if("H".equals(swiftInwardCO.getCf_tag()))
		{
		    firstLine = rowNumber;
		    grpNumber++;
		    nbRowPerGrp = 0L;
		}
		swiftInwardCO.setCf_msg_grp(grpNumber);// Msg_nbr
		swiftInwardCO.setCf_msg_line_count(nbRowPerGrp);// NbrLines/Msg
		if("H".equals(swiftInwardCO.getCf_tag()))
		{
		    swiftInwardCO.setCf_mt("MT "
			    + msgLine.substring(msgLine.indexOf("{2", 2) + 4, msgLine.indexOf("{2", 2) + 7));// Msg
		    // Code
		    swiftInwardCO.setCf_mt("MT " + msgLine.substring(msgLine.indexOf("{2", 2) + 4, msgLine.indexOf("{2", 2) + 7));// Msg Code
		    int generateAchFlag = swiftInwardDAO.returnGenerateAchFlag(swiftInwardCO);
		    if(achFlag && generateAchFlag==0)
		    {
			writeLogFile(bdCompCode, 0, "the file has digital signature functionality but the message is not flagged for digital signature" , sLanguage, swiftInwardCO);
			throw new BOException("the file has digital signature functionality but the message is not flagged for digital signature");
		    }
		    if(!achFlag && generateAchFlag==1)
		    {
			writeLogFile(bdCompCode, 0, "the message is flagged for digital signature functionality but the file doesn't contain it." , sLanguage, swiftInwardCO);
			throw new BOException("the message is flagged for digital signature functionality but the file doesn't contain it.");
		    }
		    
		}
		else
		{
		    swiftInwardCO.setCf_mt("");
		}
		if("H".equals(swiftInwardCO.getCf_tag()))// olivia 31/07/2014
		// jenkin issues
		{
		    swiftInwardCO.setCompute_3(msgLine.substring(msgLine.indexOf("{1:F01") + 3, msgLine.length()));// Message
		    // Line
		}
		else
		{
		    if("T".equals(swiftInwardCO.getCf_tag()))// olivia
		    // 31/07/2014
		    // jenkin issues
		    {
			swiftInwardCO.setCompute_3(StringUtils.left(msgLine, 3));
		    }
		    else
		    {
			if("".equals(swiftInwardCO.getCf_tag()))// olivia
			// 31/07/2014
			// jenkin issues
			{
			    swiftInwardCO.setCompute_3(msgLine);
			}
			else
			{
			    swiftInwardCO.setCompute_3(msgLine.substring(msgLine.indexOf(swiftInwardCO.getCf_tag(), 1)
				    + swiftInwardCO.getCf_tag().length() + 1, msgLine.length()));
			}
		    }
		}

		swiftInwardCO.setCf_line_value("");
		swiftInwardCO.setCf_nbr_msgs(grpNumber);
		// swiftInwardCO.setCfFirstLine(new Long(1));//mhmd
		swiftInwardCO.setCf_first_line(firstLine);
		// setting last line for each line in the message
		if("T".equals(swiftInwardCO.getCf_tag()))// olivia 31/07/2014
		// jenkin issues
		{
		    int sizeOfswiftInward = swiftInwardCOList.size();
		    for(int i = firstLine.intValue() - 1; i < Math.min(sizeOfswiftInward, rowNumber - 1); i++)
		    {
			swiftInwardCO.setCf_last_line(rowNumber);
			swiftInwardCOList.get(i).setCf_last_line(rowNumber);
			}
		}
		else
		{
			if(msgLine.indexOf("-}") >= 0 & "H".equals(swiftInwardCO.getCf_tag()))//efarah 06-03-2017 If files contains more than 1 message and there is no enter between 2 messages like BBS
			{
			    int sizeOfswiftInward = swiftInwardCOList.size();
			    if (firstTime==false)
			    {
				    for(int i = firstLine.intValue(); i == Math.min(sizeOfswiftInward+1, rowNumber); i++)
				    {
				    	firstTime=true;
						swiftInwardCOList.get(firstLine.intValue()-(sizeOfswiftInward-firstOccurence)).setCf_last_line(rowNumber-1);
						firstOccurence=firstLine.intValue()-1;
				    }
			    }
			    else
			    {
			    	for(int i = firstLine.intValue(); i == Math.min(sizeOfswiftInward+1, rowNumber); i++)
				    {
						swiftInwardCOList.get(firstOccurence).setCf_last_line(rowNumber-1);
						firstOccurence=firstLine.intValue()-1;
				    }
			    }
			}
		}
		swiftInwardCO.setCf_value("");
		swiftInwardCO.setCompute_5(grpNumber);
		swiftInwardCO.setCf_nbr_repetition(0L);
		swiftInwardCO.setCf_header_det("");

		if("$".equals(msgLine))// olivia 31/07/2014 jenkin issues
		{
		    nbCompute4++;
		}
		else
		{
		    if(msgLine.indexOf("{1:F01") >= 0)
		    {
		    	nbCompute4 = 1L;
				if(msgLine.indexOf("$") >= 0){
					nbCompute4 = 2L; //#619070 Mohamad Hojeij - 12/05/2018
				}
		    }
		    else
		    {
			if(StringUtils.left(msgLine, 2).equals("-}"))
			{
				nbCompute4 = 2L;
			}
			else
			{
			    if(!"".equals(msgLine) && msgLine.substring(1, 1).equals(":"))
			    {
				nbCompute4++;
			    }
			}
		    }
		}

		swiftInwardCO.setCompute_4(nbCompute4);
		if(!StringUtil.nullToEmpty(swiftInwardCO.getCf_tag()).equals(""))
		{
		    cfTag = swiftInwardCO.getCf_tag();
		}
		swiftInwardCO.setCfd_tag(cfTag);
		if(swiftInwardCO.getCf_line_value().length() > 5)
		{
		    swiftInwardCO.setCompute_2(swiftInwardCO.getCf_line_value().substring(1, 6));
		}
		else
		{
		    swiftInwardCO.setCompute_2(swiftInwardCO.getCf_line_value());
		}

		swiftInwardCOList.add(swiftInwardCO);

	    }
//	    msgFile.close();
	    reader.close();

	}
	catch(Exception e)
	{
	    swiftInwardCO.setReturnVar(-1L);

	    if(e.getMessage() != null && "-1".equals(e.getMessage()))
	    {
		writeLogFile(bdCompCode, 0, e.toString(), sLanguage, swiftInwardCO);
		throw new BOException(e.toString(), e);// olivia
		// 31/07/2014jenkin
		// issues
	    }
	    else
	    {
		writeLogFile(bdCompCode, 0, e.getMessage(), sLanguage, swiftInwardCO);
		throw new BOException(e.getMessage(), e);// olivia 31/07/2014
		// jenkin issues

	    }
	}
	finally
	{
	    try
	    {
//		msgFile.close();
		reader.close();
	    }
	    catch(IOException e1)
	    {
		throw new BOException(e1.getMessage(), e1);// olivia 31/07/2014
		// jenkin issues
	    }
	}
	// swiftInwardCOList.clear();
	// swiftInwardCOList.add(swiftInwardCO);
	// return swiftInwardCOList;

	return swiftInwardCOList;
    }
    
    //LBedrane - BMO180040 - TP#692469 - 26/07/2018 <Start>  
    public ArrayList<SwiftInwardCO> readMqFile(String Smessage, String sLanguage, BigDecimal bdCompCode) throws BaseException
        {
    	String sSwiftInwardPath = "";
    	File inwardFileMaker;
    	boolean bRetun = false;
    	String[] saTransMsgArr;
    	
    	sSwiftInwardPath = FileUtil.getFileURLByName("repository").concat(File.separator).concat(sSwiftInwardPath);
    	try {
			inwardFileMaker = new PathFileSecure(sSwiftInwardPath);
		} catch (Exception e1) {
			throw new BOException(e1);
		}
    	
    	if(!inwardFileMaker.exists())
    	{
    	    bRetun = inwardFileMaker.mkdir();
    	    if(!bRetun)
    	    {
    		saTransMsgArr = commonLibBO.returnTranslMessage(66760, sLanguage);
    		throw new BOException(saTransMsgArr[0]);
    	    }
    	}

    	ArrayList<SwiftInwardCO> swiftInwardCOList = new ArrayList<SwiftInwardCO>();
    	SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
//    	FileReader msgFile = null;
    	PathBufferedReaderSecure reader = null;
    	String msgLine, cfTag = null;
    	Long rowNumber = 0L;
    	Long grpNumber = 0L;
    	Long nbRowPerGrp = 0L;
    	Long nbCompute4 = 0L;
    	Long firstLine = 0L;
    	int firstOccurence =-1;
    	boolean firstTime =false;
    	
try {
	Scanner scanner = new Scanner(Smessage);
	
	while (scanner.hasNextLine() ) {
		msgLine = scanner.nextLine();
		swiftInwardCO = new SwiftInwardCO();
		rowNumber++;
		nbRowPerGrp++;
		swiftInwardCO.setMessage_line(msgLine);
		swiftInwardCO.setCompute_1(rowNumber);// line_nbr
		if("$".equals(msgLine))// olivia 31/07/2014 jenkin issues
		{
		    swiftInwardCO.setCf_tag("N");
		}
		else
		{
			if(msgLine.indexOf("{1:F01") < 0 && (rowNumber==1 && StringUtil.nullToEmpty(swiftInwardCO.getCf_tag()).equals("")))
			{
				writeLogFile(bdCompCode, 0, "The header line should contain: {1:F01 " , sLanguage, swiftInwardCO);
				throw new BOException("The header line should contain: {1:F01 ");
			}
		    if(msgLine.indexOf("{1:F01") >= 0)
		    {
			swiftInwardCO.setCf_tag("H");
		    }
		    else
		    {
			if(StringUtils.left(msgLine, 2).equals("-}"))
			{
			    swiftInwardCO.setCf_tag("T");
			}
			else
			{
			    if("".equals(msgLine))
			    {
				continue;
			    }
			    else if(!"".equals(msgLine) && msgLine.substring(0, 1).equals(":"))
			    {
				swiftInwardCO.setCf_tag(msgLine.substring(0, msgLine.indexOf(":", 2) + 1));
			    }
			    else
			    {
				swiftInwardCO.setCf_tag("");// Tag
			    }
			}
		    }
		}
		if("H".equals(swiftInwardCO.getCf_tag()))
		{
		    firstLine = rowNumber;
		    grpNumber++;
		    nbRowPerGrp = 0L;
		}
		swiftInwardCO.setCf_msg_grp(grpNumber);// Msg_nbr
		swiftInwardCO.setCf_msg_line_count(nbRowPerGrp);// NbrLines/Msg
		if("H".equals(swiftInwardCO.getCf_tag()))
		{
		    swiftInwardCO.setCf_mt("MT "
			    + msgLine.substring(msgLine.indexOf("{2", 2) + 4, msgLine.indexOf("{2", 2) + 7));// Msg
		    // Code
		}
		else
		{
		    swiftInwardCO.setCf_mt("");
		}
		if("H".equals(swiftInwardCO.getCf_tag()))// olivia 31/07/2014
		// jenkin issues
		{
		    swiftInwardCO.setCompute_3(msgLine.substring(msgLine.indexOf("{1:F01") + 3, msgLine.length()));// Message
		    // Line
		}
		else
		{
		    if("T".equals(swiftInwardCO.getCf_tag()))// olivia
		    // 31/07/2014
		    // jenkin issues
		    {
			swiftInwardCO.setCompute_3(StringUtils.left(msgLine, 3));
		    }
		    else
		    {
			if("".equals(swiftInwardCO.getCf_tag()))// olivia
			// 31/07/2014
			// jenkin issues
			{
			    swiftInwardCO.setCompute_3(msgLine);
			}
			else
			{
			    swiftInwardCO.setCompute_3(msgLine.substring(msgLine.indexOf(swiftInwardCO.getCf_tag(), 1)
				    + swiftInwardCO.getCf_tag().length() + 1, msgLine.length()));
			}
		    }
		}

		swiftInwardCO.setCf_line_value("");
		swiftInwardCO.setCf_nbr_msgs(grpNumber);
		// swiftInwardCO.setCfFirstLine(new Long(1));//mhmd
		swiftInwardCO.setCf_first_line(firstLine);
		// setting last line for each line in the message
		if("T".equals(swiftInwardCO.getCf_tag()))// olivia 31/07/2014
		// jenkin issues
		{
		    int sizeOfswiftInward = swiftInwardCOList.size();
		    for(int i = firstLine.intValue() - 1; i < Math.min(sizeOfswiftInward, rowNumber - 1); i++)
		    {
			swiftInwardCO.setCf_last_line(rowNumber);
			swiftInwardCOList.get(i).setCf_last_line(rowNumber);
			}
		}
		else
		{
			if(msgLine.indexOf("-}") >= 0 & "H".equals(swiftInwardCO.getCf_tag()))//efarah 06-03-2017 If files contains more than 1 message and there is no enter between 2 messages like BBS
			{
			    int sizeOfswiftInward = swiftInwardCOList.size();
			    if (firstTime==false)
			    {
				    for(int i = firstLine.intValue(); i == Math.min(sizeOfswiftInward+1, rowNumber); i++)
				    {
				    	firstTime=true;
						swiftInwardCOList.get(firstLine.intValue()-(sizeOfswiftInward-firstOccurence)).setCf_last_line(rowNumber-1);
						firstOccurence=firstLine.intValue()-1;
				    }
			    }
			    else
			    {
			    	for(int i = firstLine.intValue(); i == Math.min(sizeOfswiftInward+1, rowNumber); i++)
				    {
						swiftInwardCOList.get(firstOccurence).setCf_last_line(rowNumber-1);
						firstOccurence=firstLine.intValue()-1;
				    }
			    }
			}
		}
		swiftInwardCO.setCf_value("");
		swiftInwardCO.setCompute_5(grpNumber);
		swiftInwardCO.setCf_nbr_repetition(0L);
		swiftInwardCO.setCf_header_det("");

		if("$".equals(msgLine))// olivia 31/07/2014 jenkin issues
		{
		    nbCompute4++;
		}
		else
		{
		    if(msgLine.indexOf("{1:F01") >= 0)
		    {
		    	nbCompute4 = 1L;
				if(msgLine.indexOf("$") >= 0){
					nbCompute4 = 2L; //#619070 Mohamad Hojeij - 12/05/2018
				}
		    }
		    else
		    {
			if(StringUtils.left(msgLine, 2).equals("-}"))
			{
				nbCompute4 = 2L;
			}
			else
			{
			    if(!"".equals(msgLine) && msgLine.substring(1, 1).equals(":"))
			    {
				nbCompute4++;
			    }
			}
		    }
		}

		swiftInwardCO.setCompute_4(nbCompute4);
		if(!StringUtil.nullToEmpty(swiftInwardCO.getCf_tag()).equals(""))
		{
		    cfTag = swiftInwardCO.getCf_tag();
		}
		swiftInwardCO.setCfd_tag(cfTag);
		if(swiftInwardCO.getCf_line_value().length() > 5)
		{
		    swiftInwardCO.setCompute_2(swiftInwardCO.getCf_line_value().substring(1, 6));
		}
		else
		{
		    swiftInwardCO.setCompute_2(swiftInwardCO.getCf_line_value());
		}

		swiftInwardCOList.add(swiftInwardCO);

	    
		
		
	}//end while
	
}//try

catch(Exception e)
{
    swiftInwardCO.setReturnVar(-1L);

    if(e.getMessage() != null && "-1".equals(e.getMessage()))
    {
	writeLogFile(bdCompCode, 0, e.toString(), sLanguage, swiftInwardCO);
	throw new BOException(e.toString(), e);// olivia
	// 31/07/2014jenkin
	// issues
    }
    else
    {
	writeLogFile(bdCompCode, 0, e.getMessage(), sLanguage, swiftInwardCO);
	throw new BOException(e.getMessage(), e);// olivia 31/07/2014
	// jenkin issues

    }
}
    	
    	return swiftInwardCOList;
        }
  //LBedrane - BMO180040 - TP#692469 - 26/07/2018 <End>  
    

    public ArrayList<SwiftInwardCO> saveAndReadTextFile(String SwiftMsgBlob, String sLanguage, BigDecimal bdCompCode)
	    throws BaseException
    {
	String[] saTransMsgArr;
	
	String sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	if(sSwiftInwardPath == null)
	{
	    saTransMsgArr = commonLibBO.returnTranslMessage(66752, sLanguage);
	    throw new BOException(saTransMsgArr[0]);
	}
	sSwiftInwardPath = FileUtil.getFileURLByName("repository").concat(File.separator).concat(sSwiftInwardPath);
	File inwardFileMaker;
	boolean bRetun = false;
	try {
		inwardFileMaker = new PathFileSecure(sSwiftInwardPath);
	} catch (Exception e1) {
		throw new BOException(e1);
	}
	if(!inwardFileMaker.exists())
	{
	    bRetun = inwardFileMaker.mkdir();
	    if(!bRetun)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66760, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}

	String sFileName = "RMH".concat(DateUtil.format(commonLibBO.returnSystemDateWithTime(), "ddMMyyyy hhmmss"))
		.concat(".txt");
	sFileName = sFileName.replaceAll(" ", "");
	File inwardLocation;
	try {
		inwardLocation = new PathFileSecure(sSwiftInwardPath);
	} catch (Exception e1) {
		throw new BOException(e1);
	}
	if(!inwardLocation.exists())
	{// olivia 31/07/2014 jenkin issues
	    bRetun = inwardLocation.mkdir();
	    if(!bRetun)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66760, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}

	String sFileNameLoc;
	ArrayList<SwiftInwardCO> swiftInwardCOList;// olivia 31/07/2014 jenkin issues
	
	try
	{
	    sFileNameLoc = sSwiftInwardPath + File.separator + sFileName;
	    FileOutputStream fos = new FileOutputStream(sFileNameLoc, true);

	    fos.write(SwiftMsgBlob.toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    fos.flush();
	    fos.close();

	    swiftInwardCOList = readTextFile(sFileName, sLanguage, bdCompCode, "0");
	    inwardLocation = new PathFileSecure(sFileNameLoc);
	    Files.delete(inwardLocation.toPath());
	}
	catch(Exception e)
	{
	    throw new BOException(e.getMessage(), e);// olivia 31/07/2014
	    // jenkin issues
	}

	return swiftInwardCOList;
    }

    private int processAllInward(String sSwiftMsgIn, String sMsgCode, BigDecimal bdCompCode, BigDecimal bdBranchCode,
	    String sModule, String sTrxType, BigDecimal bdTrsNo, String sPrinted, String sProcessMessageStatus,
	    String sTagRefValue, String sProcessed, String sLanguage) throws BaseException
    {
	if("U".equals(sProcessed))
	{
	    SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
	    SWIFT_HISTORYVOWithBLOBs swiftHstVOWithBLOBs = new SWIFT_HISTORYVOWithBLOBs();
	    swiftHstVOWithBLOBs.setCOMP_CODE(bdCompCode);
	    swiftHstVOWithBLOBs.setBRANCH_CODE(bdBranchCode);
	    swiftHstVOWithBLOBs.setMSG_CODE(sMsgCode);
	    swiftHstVOWithBLOBs.setMODULE(sModule);
	    swiftHstVOWithBLOBs.setTRX_TYPE(sTrxType);
	    swiftHstVOWithBLOBs.setTRS_NO(bdTrsNo);
	    swiftHstVOWithBLOBs.setMSG_ORDER(BigDecimal.ONE);
	    swiftHstVOWithBLOBs.setMSG_IN_OUT("I");
	    swiftHstVOWithBLOBs.setHISTORY_DATE(commonLibBO.returnSystemDateWithTime());
	    swiftHstVOWithBLOBs.setPRINTED(sPrinted);
	    swiftHstVOWithBLOBs.setMSG_STATUS(sProcessMessageStatus);
	    swiftHstVOWithBLOBs.setREFERENCE_TAG_DATA(sTagRefValue);
	    swiftHstVOWithBLOBs.setSWIFT_MSG_BLOB(sSwiftMsgIn.toString());

	    try
	    {
	    	genericDAO.insert(swiftHstVOWithBLOBs);
	    }
	    catch(DAOException e)
	    {
	    	writeLogFile(bdCompCode, 1, e.getMessage(), sLanguage, swiftInwardCO);
	    	return -1;
	    }
	}
	return 1;
    }

    private int processAllInward(String sSwiftMsgIn, String sMsgCode, BigDecimal bdCompCode, BigDecimal bdBranchCode,
    	    String sModule, String sTrxType, BigDecimal bdTrsNo, String sPrinted, String sProcessMessageStatus,
    	    String sTagRefValue, String sProcessed, String sLanguage, BigDecimal ldSwiftTrxNo ) throws BaseException
        {
    	if("U".equals(sProcessed))
    	{
    	    SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
    	    SWIFT_HISTORYVOWithBLOBs swiftHstVOWithBLOBs = new SWIFT_HISTORYVOWithBLOBs();
    	    swiftHstVOWithBLOBs.setCOMP_CODE(bdCompCode);
    	    swiftHstVOWithBLOBs.setBRANCH_CODE(bdBranchCode);
    	    swiftHstVOWithBLOBs.setMSG_CODE(sMsgCode);
    	    swiftHstVOWithBLOBs.setMODULE(sModule);
    	    swiftHstVOWithBLOBs.setTRX_TYPE(sTrxType);
    	    swiftHstVOWithBLOBs.setTRS_NO(bdTrsNo);
    	    swiftHstVOWithBLOBs.setMSG_ORDER(BigDecimal.ONE);
    	    swiftHstVOWithBLOBs.setMSG_IN_OUT("I");
    	    swiftHstVOWithBLOBs.setHISTORY_DATE(commonLibBO.returnSystemDateWithTime());
    	    swiftHstVOWithBLOBs.setPRINTED(sPrinted);
    	    swiftHstVOWithBLOBs.setMSG_STATUS(sProcessMessageStatus);
    	    swiftHstVOWithBLOBs.setREFERENCE_TAG_DATA(sTagRefValue);
    	    //TODO add set swift trx no
    	    swiftHstVOWithBLOBs.setSWIFT_TRX_NO(ldSwiftTrxNo); //HGhazal - EWBI160216 - 07/09/2016
    	    swiftHstVOWithBLOBs.setSWIFT_MSG_BLOB(sSwiftMsgIn.toString());

    	    try
    	    {
    	    	genericDAO.insert(swiftHstVOWithBLOBs);
    	    }
    	    catch(DAOException e)
    	    {
    	    	writeLogFile(bdCompCode, 1, e.getMessage(), sLanguage, swiftInwardCO);
    	    	return -1;
    	    }
    	}
    	return 1;
	}
    
    public SwiftCO parseMessage(ArrayList<SwiftInwardCO> swiftInwardCOList, String sMsgCode, Long lCtrMsg,
	    BigDecimal bdCompCode, BigDecimal bdBranchCode, String sUserId, Date dSysDate, BigDecimal bdAckMode,
	    String sSwiftMsgIn, String sMode, String sProcessed, Long lTrsNo, String sModule, String sMsgStatus,
	    String sLanguage, ArrayList<Map<String, Object>> aListMapSqlRep) throws BaseException
    {
	StringBuilder sbsSwiftLogFile = new StringBuilder();
	sbsSwiftLogFile.append(swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getLOG_IN_PATH_JAVA());//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	String[] saTransMsgArr;
	
	if(swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getLOG_IN_PATH_JAVA() == null)//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	{
	    saTransMsgArr = commonLibBO.returnTranslMessage(66757, sLanguage);
	    throw new BOException(saTransMsgArr[0]);
	}
	
	String sRepoSwift = FileUtil.getFileURLByName("repository");
	if(sRepoSwift.endsWith("/"))
	{
	    sbsSwiftLogFile.insert(0, sRepoSwift);
	}
	else
	{
	    sbsSwiftLogFile.insert(0, "/");
	    sbsSwiftLogFile.insert(0, sRepoSwift);
	}
	String sSwiftLog;
	sSwiftLog = sbsSwiftLogFile.toString();
	SWIFT_MANUAL_PROCESSVOKey swiftManualProcess = new SWIFT_MANUAL_PROCESSVOKey();
	swiftManualProcess.setCOMP_CODE(bdCompCode);
	swiftManualProcess.setMSG_CODE(sMsgCode);
	BigDecimal nbCount;
	nbCount = swiftInwardDAO.returnCountManualMsg(swiftManualProcess);

	SwiftInwardCO swftInwardCO = new SwiftInwardCO();
	SwiftCO swiftCO = new SwiftCO();
	String sErrMsg = "";
	if("S".equals(sMode) && NumberUtil.nullToZero(nbCount).compareTo(BigDecimal.ZERO) == 1)// olivia
	// 31/07/2014
	// jenkin
	// issues
	{
	    sErrMsg = commonLibBO.returnTranslErrorMessage(66741, new String[] { sMsgCode }, sLanguage);
	    swiftCO.setErrorMsg(sErrMsg);
	    writeLogFile(bdCompCode, 1, sErrMsg, sLanguage, swftInwardCO);
	    processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT, SWFT, swiftInwardDAO
		    .returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed, sLanguage);
	    swiftCO.setReturnVar(-1L);
	    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
	    return swiftCO;
	}

	SWIFT_MSGHDR_INVO swiftMsghdrIn = new SWIFT_MSGHDR_INVO();
	swiftMsghdrIn.setACK(bdAckMode);
	swiftMsghdrIn.setMSG_CODE(sMsgCode);
	BigDecimal nbMaxSeq;
	nbMaxSeq = swiftInwardDAO.returnMaxSeq(swiftMsghdrIn);
	
	if(nbMaxSeq == null)
	{
	    sErrMsg = commonLibBO.returnTranslErrorMessage(66750, new String[] { sMsgCode }, sLanguage);
	    swiftCO.setErrorMsg(sErrMsg);
	    writeLogFile(bdCompCode, 1, sErrMsg, sLanguage, swftInwardCO);
	    swiftCO.setReturnVar(-1L);
	    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
	    return swiftCO;
	}
	int iRetValue;
	String sReportTitle;
	if(NumberUtil.nullToZero(nbMaxSeq).compareTo(BigDecimal.ZERO) == 0
		&& (commonLibBO.returnSwiftCtrlRecValues().getPROCESS_ALL_INWARD().equals(0) || NumberUtil.nullToZero(
			bdAckMode).compareTo(BigDecimal.ONE) == 0))
	{
	    iRetValue = processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT, SWFT, swiftInwardDAO
		    .returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed, sLanguage);
	    if(iRetValue == -1)
	    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66742, sLanguage);
			sReportTitle = saTransMsgArr[1];
			swiftCO.setErrorMsg(sReportTitle);
			writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			swiftCO.setReturnVar(-1L);
			swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			return swiftCO;
	    }
	}

	if(NumberUtil.nullToZero(nbMaxSeq).compareTo(BigDecimal.ZERO) == 0
		&& (commonLibBO.returnSwiftCtrlRecValues().getPROCESS_ALL_INWARD().equals(1) || NumberUtil.nullToZero(
			bdAckMode).compareTo(BigDecimal.ZERO) == 0))
	{
	    sErrMsg = commonLibBO.returnTranslErrorMessage(66750, new String[] { sMsgCode }, sLanguage);
	    swiftCO.setErrorMsg(sErrMsg);
	    writeLogFile(bdCompCode, 1, sErrMsg, sLanguage, swftInwardCO);
	    swiftCO.setReturnVar(-1L);
	    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
	    return swiftCO;
	}

	if(NumberUtil.nullToZero(nbMaxSeq).compareTo(BigDecimal.ZERO) == 1)
	{
	    if(bdAckMode.compareTo(BigDecimal.ZERO) == 0)
	    {
	    	swiftMsghdrIn.setACK(BigDecimal.ZERO);
	    }
	    else if(bdAckMode.compareTo(BigDecimal.ZERO) == 1)
	    {
	    	swiftMsghdrIn.setACK(BigDecimal.ONE);
	    }
	}
	String sProcName, sTagRef = null;
	int counter;
	
	for(counter = 1; counter <= NumberUtil.nullToZero(nbMaxSeq).intValueExact(); counter++) // pb
	// line
	// 113
	{
	    SWIFT_MSGHDR_INVO swiftMsghdrInward = new SWIFT_MSGHDR_INVO();
	    swiftMsghdrInward.setMSG_CODE(sMsgCode);
	    swiftMsghdrInward.setSEQ(new BigDecimal(counter));
	    if(bdAckMode.compareTo(BigDecimal.ZERO) > 0)
	    {
	    	swiftMsghdrInward.setACK(BigDecimal.ONE);
	    }
	    else
	    {
	    	swiftMsghdrInward.setACK(BigDecimal.ZERO);
	    }
	    try
	    {
	    	// sProcName = swiftInwardDAO.returnProcName(swiftMsghdrInward);
	    	sProcName = ((SWIFT_MSGHDR_INVO) genericDAO.selectByPK(swiftMsghdrInward)).getPROC_NAME();
	    }
	    catch(Exception e) //Chady.A BUG #323574
	    {
			sErrMsg = commonLibBO.returnTranslErrorMessage(66743, new String[] { sMsgCode,
				Integer.toString(counter) }, sLanguage);
			swiftCO.setErrorMsg(sErrMsg);
			writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			swiftCO.setReturnVar(-1L);
			return swiftCO;
	    }

	    swiftMsghdrIn.setSEQ(new BigDecimal(counter));
	    SwiftInwardSC swiftInwardSC = new SwiftInwardSC();
	    ArrayList<SwiftInwardProcessCO> swiftMsgAllocDet;
	    int swiftMsgAllocDetCount = 0;
	    
	    try
	    {
			swiftInwardSC.setMSG_CODE(swiftMsghdrIn.getMSG_CODE());
			swiftInwardSC.setACK(swiftMsghdrIn.getACK());
			swiftInwardSC.setSEQ(swiftMsghdrIn.getSEQ());
			swiftMsgAllocDet = swiftInwardDAO.returnSwiftMsghdrIn(swiftInwardSC);// dw_msg_alloc_det
			swiftMsgAllocDetCount = swiftInwardDAO.returnSwiftMsghdrInCount(swiftInwardSC);
	    }
	    catch(DAOException e)
	    {
			sErrMsg = commonLibBO.returnTranslErrorMessage(66744, new String[] { sMsgCode,
				Integer.toString(counter) }, sLanguage);
			swiftCO.setErrorMsg(sErrMsg);
			writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			swiftCO.setReturnVar(-1L);
			swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			return swiftCO;
	    }
	    
	    SWIFT_MSG_REFVO swiftMsgRef = new SWIFT_MSG_REFVO();
	    if(bdAckMode.compareTo(BigDecimal.ZERO) == 0)
	    {
			swiftMsgRef.setCOMP_CODE(bdCompCode);
			swiftMsgRef.setMSG_CODE(sMsgCode);
		
			try
			{
			    sTagRef = swiftInwardDAO.returnTag(swiftMsgRef);
			}
			catch(DAOException e)
			{
			    sTagRef = "";
			}
	    }
	    // pb line 193
	    Object oRepSkipCond;
	    oRepSkipCond = commonLibBO.executeExpression(swiftMsgAllocDet.get(counter).getSwiftMsghdrInVO()
		    .getREPTAG_COND(), counter, aListMapSqlRep);
	    String sRepSkipCond;
	    sRepSkipCond = StringUtil.nullToEmpty(oRepSkipCond).toString();
	    
	    if(StringUtil.nullToEmpty(sRepSkipCond).equals(""))
	    {
			sErrMsg = commonLibBO.returnTranslErrorMessage(66745, new String[] { sMsgCode,
				Integer.toString(counter) }, sLanguage);
			writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT, SWFT, swiftInwardDAO
				.returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed, sLanguage);
			swiftCO.setReturnVar(-1L);
			swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			return swiftCO;
	    }

	    Long llNbrOccur =  Long.valueOf(sRepSkipCond);

	    if(llNbrOccur.compareTo(0L) == 0)
	    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66751, sLanguage);
			sReportTitle = saTransMsgArr[1];
			swiftCO.setErrorMsg(sReportTitle);
			writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			iRetValue = processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT, SWFT,
				swiftInwardDAO.returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed, sLanguage);
			if(iRetValue == -1)
			{
			    saTransMsgArr = commonLibBO.returnTranslMessage(66742, sLanguage);
			    sReportTitle = saTransMsgArr[1];
			    swiftCO.setErrorMsg(sReportTitle);
			    writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			    swiftCO.setReturnVar(-1L);
			    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			    return swiftCO;
			}
	    }
	    String sTagDw = null;
	    List<SwiftInwardIndexCO> fieldList = new ArrayList<SwiftInwardIndexCO>();
	    SwiftInwardIndexCO swiftInwardIndexCO = new SwiftInwardIndexCO();
	    int iCtr;
	    BigDecimal bdTagLine = BigDecimal.ZERO, bdRowCount, bdPreviousTagindex, bdCurrentTagindex = BigDecimal.ZERO, bdPreviousIndex = BigDecimal.ZERO, bdCurrentIndex = BigDecimal.ZERO;
	    String sPreviousTag;
	    
	    for(iCtr = 0; iCtr < swiftInwardCOList.size(); iCtr++)// pb line 229
	    // uf_fill_dwidx
	    {
		//bdTagLine = BigDecimal.ZERO;
		//bdCurrentTagindex = BigDecimal.ZERO;
		//bdPreviousIndex = BigDecimal.ZERO;
		//bdCurrentIndex = BigDecimal.ONE;
		swiftInwardIndexCO = new SwiftInwardIndexCO();
		

		sPreviousTag = sTagDw;
		sTagDw = swiftInwardCOList.get(iCtr).getCf_tag();

		if("".equals(StringUtil.nullToEmpty(sTagDw)))// olivia
		// 31/07/2014
		// jenkin issues
		{
		    sTagDw = sPreviousTag;
		    bdTagLine = bdTagLine.add(BigDecimal.ONE);// olivia
		    // 31/07/2014
		    // jenkin issues
		}
		else
		{
		    bdTagLine = BigDecimal.ZERO;
		}

		bdPreviousTagindex = bdCurrentTagindex;
		SWIFT_MSGDET_INVO swiftMsgdetInVO = new SWIFT_MSGDET_INVO();
		swiftMsgdetInVO.setMSG_CODE(sMsgCode);
		swiftMsgdetInVO.setSEQ(new BigDecimal(counter));
		swiftMsgdetInVO.setTAG(sTagDw);
		swiftMsgdetInVO.setTAG_LINE(bdTagLine);

		bdRowCount = swiftInwardDAO.returnMaxSeq(swiftMsghdrInward);
		swiftMsgdetInVO = swiftInwardDAO.returnMsgdetIn(swiftMsgdetInVO);

		if(swiftMsgdetInVO == null)
		{
		    swiftInwardIndexCO.setLineNbr(new BigDecimal(iCtr));
		    swiftInwardIndexCO.setTag(sTagDw);
		    swiftInwardIndexCO.setTagLine(bdTagLine);
		    swiftInwardIndexCO.setIndex(BigDecimal.ZERO);
		    fieldList.add(swiftInwardIndexCO);
		    continue;
		}
		else
		{
		    bdCurrentTagindex = swiftMsgdetInVO.getALLOC_LINE_NBR();//olivia 30/12/2014
		    
		    if(NumberUtil.nullToZero(bdRowCount).compareTo(BigDecimal.ZERO) == 0)// olivia
		    // 31/07/2014
		    // jenkin
		    // issues
		    {
			swiftInwardIndexCO.setLineNbr(new BigDecimal(iCtr));
			swiftInwardIndexCO.setTag(sTagDw);
			swiftInwardIndexCO.setTagLine(bdTagLine);
			swiftInwardIndexCO.setIndex(BigDecimal.ZERO);
		    }
		    else
		    {
			swiftInwardIndexCO.setLineNbr(new BigDecimal(iCtr));
			swiftInwardIndexCO.setTag(sTagDw);
			swiftInwardIndexCO.setTagLine(bdTagLine);
			if(swiftMsgdetInVO.getGROUP_NBR() == null
				|| swiftMsgdetInVO.getGROUP_NBR().compareTo(BigDecimal.ZERO) == 0)
			{
			    swiftInwardIndexCO.setIndex(BigDecimal.ZERO);
			    bdPreviousIndex = BigDecimal.ZERO;
			}
			else
			{
			    if("Y".equals(StringUtil.nullToEmpty(swiftMsgdetInVO.getHDR_DET())))// olivia
			    // 31/07/2014
			    // jenkin
			    // issues
			    {
				swiftInwardIndexCO.setIndex(bdPreviousTagindex);
				if(bdPreviousIndex.compareTo(BigDecimal.ZERO) == 0)
				{
				    bdCurrentIndex = BigDecimal.ZERO;
				}
			    }
			    else
			    {
				if(bdCurrentTagindex.compareTo(bdPreviousTagindex) == 1)
				{
				    swiftInwardIndexCO.setIndex(bdCurrentIndex);
				}
				else
				{
				    bdCurrentIndex = bdCurrentIndex.add(BigDecimal.ONE);
				    swiftInwardIndexCO.setIndex(bdCurrentIndex);
				}
				bdPreviousIndex = bdCurrentIndex;
			    }
			}
		    }
		}
		fieldList.add(swiftInwardIndexCO);
	    }
	    BigDecimal bdArgVar;
	    DF_FILE_PRC_INP_PARMVO dfFilePrcInpParm;
	    List<DF_FILE_PRC_INP_PARMVO> paramList = new ArrayList<DF_FILE_PRC_INP_PARMVO>();
	    int iIdx;
	    String sDefaultValue, sTagRefValue = null;
	    
	    for(iIdx = 1; iIdx <= llNbrOccur; iIdx++) // pb line 240
	    {
	    	//HGhazal - get swift trx no - EWBI160216 - 07/09/2016
	    	BigDecimal ldSwiftTrxNo = returnSwiftTrxNo();
	    	String lsSwiftTrxNo = ldSwiftTrxNo.toString();
		for(iCtr = 0; iCtr < swiftMsgAllocDetCount; iCtr++)
		{
		    dfFilePrcInpParm = new DF_FILE_PRC_INP_PARMVO();
		    bdArgVar = swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getARG_VAR();
		    
		    if("".equals(StringUtil.nullToEmpty(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getARG_VAR())))// olivia
		    // 31/07/2014
		    // jenkin
		    // issues
		    {
		    	bdArgVar = BigDecimal.ZERO;
		    }
		    sDefaultValue = StringUtil.nullToEmpty(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO()
			    .getDEFAULT_VALUE());
		    if("G"
			    .equals(StringUtil.nullToEmpty(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO()
				    .getARG_TYPE())))// olivia
		    // 31/07/2014
		    // jenkin
		    // issues
		    {
			sDefaultValue = StringUtil.nullToEmpty(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO()
				.getDEFAULT_VALUE());
			sDefaultValue = returnGlobalValue(sDefaultValue, bdCompCode, bdBranchCode, sUserId, dSysDate,
				iIdx, llNbrOccur, commonLibBO.returnSystemDateNoTime(), bdAckMode,lsSwiftTrxNo);

			if("-1".equals(sDefaultValue))
			{
			    writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			}
		    }
		    String sTag = null;
		    sTag = swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG();
		    // PB Code line 270:If (IsNull(ls_default_value) Or
		    // Trim(ls_default_value) = '') and Not IsNull(ls_Tag) Then
		    if("".equals(sDefaultValue)
			    && !"".equals(StringUtil.nullToEmpty(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO()
				    .getTAG())))
		    {
			if(NumberUtil.nullToZero(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG_LINE())
				.compareTo(BigDecimal.ZERO) == 0)
			{
			    swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().setTAG_LINE(BigDecimal.ZERO);
			}

			if(NumberUtil.nullToZero(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getGROUP_NBR())
				.compareTo(BigDecimal.ZERO) == 0)
			{
			    swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().setGROUP_NBR(BigDecimal.ZERO);
			}
			int iOccur, iRow = 0;
			String sSuffix = null;
			if(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getGROUP_NBR().compareTo(BigDecimal.ZERO) == 0)
			{
			    // mhmd set instead of 1
			    int foundTag = 0, iLine;
			    for(iOccur = 0; iOccur < swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getOCCURENCE()
				    .intValue(); iOccur++)
			    {
				for(iLine = swiftInwardCOList.get(lCtrMsg.intValue()-1).getCf_first_line().intValue(); iLine < swiftInwardCOList
					.get(lCtrMsg.intValue()-1).getCf_last_line().intValue(); iLine++)//efarah 06-03-2017 If files contains more than 1 message and there is no enter between 2 messages like BBS
				{
				    if(swiftInwardCOList.get(iLine - 1).getCf_tag().equals(
					    swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG()))
				    {
					iRow = iLine;
					foundTag = 1;
					break;
				    }
				    else
				    {
					if(swiftInwardCOList.get(iLine - 1).getCf_tag().equals("H") && iCtr == 0)
					{
					    oRepSkipCond = null;//EFARAH
					}
				    }
				}
			    }
			    // added mhmd to check if the tag existed or not
			    if(foundTag == 0)
			    {
				iRow = 0;
			    }
			}
			else
			{
			    for(iOccur = 1; iOccur <= fieldList.size(); iOccur++)
			    {
				if(fieldList.get(iOccur-1).getTag().equals(
					swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG())
					&& fieldList.get(iOccur-1).getTagLine().equals(
						swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG_LINE())
					&& fieldList.get(iOccur-1).getIndex().equals(BigDecimal.ZERO))
				{
				    iRow = iOccur;
				    bdArgVar = BigDecimal.ZERO;
				    break;
				}
			    }

			    if(iRow > 0)
			    {
				sSuffix = "H";
			    }
			    else
			    {
				for(iOccur = 1; iOccur <= fieldList.size(); iOccur++)
				{
				    if(fieldList.get(iOccur-1).getTag().equals(
					    swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG())
					    && fieldList.get(iOccur-1).getTagLine().equals(
						    swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG_LINE())
					    && fieldList.get(iOccur-1).getIndex().equals(new BigDecimal(iIdx)))
				    {
					iRow = iOccur;
					sSuffix = "D";
					bdArgVar = BigDecimal.ONE;
					break;
				    }
				}
			    }
			}
			if(iRow < 0)
			{
			    sErrMsg = commonLibBO.returnTranslErrorMessage(66746, new String[] {
				    fieldList.get(iOccur-1).getTag(), sMsgCode, Integer.toString(counter),
				    Integer.toString(iCtr) }, sLanguage);
			    swiftCO.setErrorMsg(sErrMsg);
			    writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			    processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT, SWFT,
				    swiftInwardDAO.returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed, sLanguage);
			    swiftCO.setReturnVar(-1L);
			    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			    return swiftCO;
			}

			if(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getSTATUS().equals("M") && iRow == 0)
			{
			    sErrMsg = commonLibBO.returnTranslErrorMessage(66769, new String[] {
				    swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG() }, sLanguage);//EFARAH
			    swiftCO.setErrorMsg(sErrMsg);
			    writeLogFile(bdCompCode, 1, sErrMsg, sLanguage, swftInwardCO);
			    processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT, SWFT,
				    swiftInwardDAO.returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed, sLanguage);
			    //if(iRetValue == -1)
			    //{
				//saTransMsgArr = commonLibBO.returnTranslMessage(66751, sLanguage);
				//sReportTitle = saTransMsgArr[1];
				//swiftCO.setErrorMsg(sReportTitle);
				//writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			    swiftCO.setReturnVar(-1L);
			    return swiftCO;				    
			    //}
			}
			else
			{
			    if(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getSTATUS().equals("O") && iRow == 0)
			    {
				dfFilePrcInpParm.setINP_PARM_VALUE("");
				dfFilePrcInpParm.setINP_PARM_TYPE("string");
				paramList.add(dfFilePrcInpParm);
				continue;
			    }
			}
			int iRowNbr;
			if(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getGROUP_NBR().compareTo(BigDecimal.ZERO) == 0)
			{
			    iRowNbr = iRow + swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG_LINE().intValue();
			}
			else
			{
			    iRowNbr = iRow;
			}
			// line 349
			if(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getVALUE_EXP() != null
				&& swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getVALUE_EXP().length() > 0)
			{
			    oRepSkipCond = swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getVALUE_EXP();
			    // mhmd
			    // oRepSkipCond = commonLibBO.executeExpression(
			    // swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getVALUE_EXP()
			    // ,
			    // counter - 1, aListMapSqlRep);
			    sRepSkipCond = StringUtil.nullToEmpty(oRepSkipCond).toString();
			    if(StringUtil.nullToEmpty(sRepSkipCond).equals(""))
			    {
				sErrMsg = commonLibBO.returnTranslErrorMessage(66746, new String[] {
					fieldList.get(iOccur).getTag(), sMsgCode, Integer.toString(counter),
					Integer.toString(iCtr) }, sLanguage);
				swiftCO.setErrorMsg(sErrMsg);
				writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
				iRetValue = processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT,
					SWFT, swiftInwardDAO.returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed,
					sLanguage);
				if(iRetValue == -1)
				{
				    saTransMsgArr = commonLibBO.returnTranslMessage(66751, sLanguage);
				    sReportTitle = saTransMsgArr[1];
				    swiftCO.setErrorMsg(sReportTitle);
				    writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
				    swiftCO.setReturnVar(-1L);
				    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
				    return swiftCO;
				}
			    }
			}
			// pb line 371
			if(iRowNbr > swiftInwardCOList.size())//efarah 29-01-2016 ABARSU160018 
			{
			    dfFilePrcInpParm.setINP_PARM_VALUE("");
			    paramList.add(dfFilePrcInpParm);
			    continue;//efarah 29-01-2016 ABARSU160018 
			}

			// mhmd adjusting condition to
			String sCfTag = null;
			if(!swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG_LINE().equals(BigDecimal.ZERO))
			{
			    sCfTag = swiftInwardCOList.get(iRowNbr - 1).getCfd_tag().toString();
			}
			// pb line 381 mhmd adjusting condition
			if(iRow == 0
				|| (swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getTAG_LINE().compareTo(
					BigDecimal.ZERO) != 0 && !swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO()
					.getTAG().equals(sCfTag)))
			{
			    dfFilePrcInpParm.setINP_PARM_VALUE("");
			    dfFilePrcInpParm.setINP_PARM_TYPE("string");
			}
			else
			{
			    if(oRepSkipCond != null && !"".equals(oRepSkipCond.toString()))
			    {
				oRepSkipCond = commonLibBO.executeExpression(oRepSkipCond.toString(), iRowNbr - 1,
					aListMapSqlRep);
			    }
			    // mhmd
			    // oRepSkipCond =
			    // commonLibBO.executeExpression("~\""
			    // + swiftInwardCOList.get(counter).getCfValue() +
			    // "~\"," + iRowNbr + ")",
			    // counter, aListMapSqlRep);
			    sRepSkipCond = StringUtil.nullToEmpty(oRepSkipCond).toString();
			    // pb line 388 mhmd
			    if("".equals(StringUtil.nullToEmpty(sRepSkipCond)))
			    {
				// mhmd adjust while loop pb line 399
				String sNextTag = null;
				do
				{
				    if(bdArgVar.compareTo(BigDecimal.ONE) == 0)
				    {
					//sTag = swiftInwardCOList.get(iRowNbr - 1).getCfd_tag().toString();
					//iRowNbr=iRowNbr+1;
					bdArgVar = BigDecimal.ZERO;
				    }

				    // mhmd
				    String sMessageLine;
				    sMessageLine = swiftInwardCOList.get(iRowNbr - 1).getMessage_line();
				    // if(sMessageLine.length() > sTag.length()
				    // &&
				    // sMessageLine.substring(1,sTag.length())==
				    // sTag)
				    // {
				    // sLineValue =
				    // sMessageLine.substring(sMessageLine.indexOf(sTag)
				    // + sTag.length(), sMessageLine.length());
				    // }
				    // else
				    // {
				    // sLineValue = sMessageLine;
				    // }

				    if(sTag != null && sMessageLine.length() >= sTag.length()
					    && sTag.equals(sMessageLine.substring(0, sTag.length()))) // olivia
				    // 31/07/2014
				    // jenkin issues
				    {
					swiftInwardCOList.get(iRowNbr - 1).setCf_line_value(
						swiftInwardCOList.get(iRowNbr - 1).getMessage_line().substring(
							swiftInwardCOList.get(iRowNbr - 1).getMessage_line().indexOf(
								sTag, 0)
								+ sTag.length(),
							swiftInwardCOList.get(iRowNbr - 1).getMessage_line().length()));
				    }
				    else
				    {
					swiftInwardCOList.get(iRowNbr - 1).setCf_line_value(
						swiftInwardCOList.get(iRowNbr - 1).getMessage_line());
				    }
				    // replace the Single quote (') and
				    // double quote (") by ~~~' or ~~~"
				    // mhmd
				    // swiftInwardCOList.get(counter).setCfLineValue(
				    // swiftInwardCOList.get(counter).getCfLineValue().replace("'",
				    // "~~~~~'"));
				    // swiftInwardCOList.get(counter).setCfLineValue(
				    // swiftInwardCOList.get(counter).getCfLineValue()
				    // .replace("\"", "~~~~~\""));

				    // mhmd
				    // oRepSkipCond =
				    // commonLibBO.executeExpression(
				    // swiftInwardCOList.get(counter).getCfLineValue()
				    // , iRowNbr,
				    // aListMapSqlRep);
				    sRepSkipCond = StringUtil.nullToEmpty(
					    swiftInwardCOList.get(iRowNbr - 1).getCf_line_value()).toString();
				    if(StringUtil.nullToEmpty(sRepSkipCond).equals(""))
				    {
					sErrMsg = commonLibBO.returnTranslErrorMessage(66746, new String[] {
						fieldList.get(iOccur).getTag(), sMsgCode, Integer.toString(counter),
						Integer.toString(iCtr) }, sLanguage);
					swiftCO.setErrorMsg(sErrMsg);
					writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
					iRetValue = processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode,
						SWFT, SWFT, swiftInwardDAO.returnAccMaxTrsNo(), PRINTED, STATUS, null,
						sProcessed, sLanguage);
					if(iRetValue == -1)
					{
					    saTransMsgArr = commonLibBO.returnTranslMessage(66751, sLanguage);
					    sReportTitle = saTransMsgArr[1];
					    swiftCO.setErrorMsg(sReportTitle);
					    writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
					    swiftCO.setReturnVar(-1L);
					    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
					    return swiftCO;
					}
				    }
				    // mhmd
				    if(NumberUtil.nullToZero(
					    swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getGROUP_NBR()).compareTo(
					    BigDecimal.ZERO) == 0
					    && swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO().getGROUP_NBR().equals(
						    BigDecimal.ZERO))
				    {
					if(bdArgVar.compareTo(BigDecimal.ZERO) == 0)
					{
					    if(dfFilePrcInpParm.getINP_PARM_VALUE() == null)// olivia
					    // 31/07/2014
					    // jenkin
					    // issues
					    // switch
					    // if
					    // not
					    // else
					    {
						dfFilePrcInpParm.setINP_PARM_VALUE(swiftInwardCOList.get(iRowNbr - 1)
							.getCf_line_value());
					    }
					    else
					    {
						dfFilePrcInpParm.setINP_PARM_VALUE(dfFilePrcInpParm.getINP_PARM_VALUE()
							+ swiftInwardCOList.get(iRowNbr - 1).getCf_line_value());
					    }

					}
					else
					{
					    if(dfFilePrcInpParm.getINP_PARM_VALUE() == null)// olivia
					    // 31/07/2014
					    // jenkin
					    // issues
					    // switch
					    // if
					    // not
					    // else
					    {
						dfFilePrcInpParm.setINP_PARM_VALUE(" "
							+ swiftInwardCOList.get(iRowNbr - 1).getCf_line_value());
					    }
					    else
					    {
						dfFilePrcInpParm.setINP_PARM_VALUE(dfFilePrcInpParm.getINP_PARM_VALUE()
							+ " " + swiftInwardCOList.get(iRowNbr - 1).getCf_line_value());
					    }

					}
				    }
				    else
				    {
					if(dfFilePrcInpParm.getINP_PARM_VALUE() == null)// olivia
					// 31/07/2014
					// jenkin
					// issues
					// switch
					// if
					// not
					// else
					{
					    // dfFilePrcInpParm.setINP_PARM_VALUE(sMessageLine
					    // + sSuffix);
					    dfFilePrcInpParm.setINP_PARM_VALUE(swiftInwardCOList.get(iRowNbr - 1)
						    .getCf_line_value()
						    + sSuffix);
					}
					else
					{
					    // dfFilePrcInpParm.setINP_PARM_VALUE(dfFilePrcInpParm.getINP_PARM_VALUE()
					    // + sMessageLine + sSuffix);
					    dfFilePrcInpParm.setINP_PARM_VALUE(dfFilePrcInpParm.getINP_PARM_VALUE()
						    + swiftInwardCOList.get(iRowNbr - 1).getCf_line_value() + sSuffix);
					}
				    }

				    dfFilePrcInpParm.setINP_PARM_TYPE("string");

				    if(iRowNbr <= swiftInwardCOList.size())
				    {
					sNextTag = swiftInwardCOList.get(iRowNbr).getCfd_tag();
				    }
				    iRowNbr += 1;
				}while(bdArgVar.compareTo(BigDecimal.ONE) == 0 && sTag.equals(sNextTag)
					&& iRowNbr <= swiftInwardCOList.size());
			    }
			    else
			    // olivia 31/07/2014 jenkin issues switch if not
			    // else
			    {
				if("".equals(StringUtil.nullToEmpty(swiftMsgAllocDet.get(iCtr).getSwiftMsgdetInVO()
					.getGROUP_NBR())))// olivia 31/07/2014
				// jenkin issues
				{
				    dfFilePrcInpParm.setINP_PARM_VALUE(sRepSkipCond);
				}
				else
				{
				    dfFilePrcInpParm.setINP_PARM_VALUE(sRepSkipCond + StringUtil.nullToEmpty(sSuffix));
				}
				dfFilePrcInpParm.setINP_PARM_TYPE("string");
				// set this to skip execute expression above for
				// oRepSkipCond
				oRepSkipCond = null;
			    }
			}
		    }

		    else
		    {
			dfFilePrcInpParm.setINP_PARM_VALUE(sDefaultValue);
			dfFilePrcInpParm.setINP_PARM_TYPE("string");
		    }

		    // check tag reference to add it in swift_history

		    if(!StringUtil.nullToEmpty(sTag).isEmpty() && !StringUtil.nullToEmpty(sTagRef).isEmpty()
			    && StringUtil.nullToEmpty(sTag).equals(StringUtil.nullToEmpty(sTagRef)))// olivia
		    // 31/07/2014
		    // jenkin
		    // issues
		    {
			// if(sTag.equals(sTagRef))//olivia 31/07/2014 jenkin
			// issues
			// {
			StringUtil.nullToEmpty(sTagRefValue);
			sTagRefValue = sTagRefValue.concat(dfFilePrcInpParm.getINP_PARM_VALUE());// olivia
			// 31/07/2014
			// jenkin
			// issues
			// }
		    }
		    paramList.add(dfFilePrcInpParm);
		}
		// pb line 474 mhmd
		SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
		swiftInwardCO.setCf_nbr_msgs(swiftInwardCOList.get(0).getCf_nbr_msgs());
		swiftInwardCO.setCf_mt(swiftInwardCOList.get(0).getCf_mt());
		swiftInwardCO = swiftInwardDAO.executeDynProcedure(paramList, sProcName, swiftInwardCO);

		String[] apiOutPutParams = swiftInwardCO.getOutputParams();
		// commented waiting for csm to implement userstory 604030 BigDecimal branchCode = new BigDecimal(apiOutPutParams[4]);
		// switch (new
		// BigDecimal(apiOutPutParams[0]).intValue())//olivia 31/07/2014
		// jenkin issues
		// {
		// insert inward message into swift history
		// inserting the message status as processed
		if("0".equals(apiOutPutParams[0]))// olivia 31/07/2014 jenkin
		// issues
		{
		    sErrMsg = commonLibBO.returnTranslErrorMessage(66748, new String[] { apiOutPutParams[2] },
			    sLanguage);
		    swiftCO.setErrorMsg(sErrMsg);
		    writeLogFile(bdCompCode, 1, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
		    processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, apiOutPutParams[1],
			    apiOutPutParams[3], new BigDecimal(apiOutPutParams[2]), null, "P", sTagRefValue,
			    sProcessed, sLanguage);

		    swiftCO.setLogFileLocation(sSwiftLog);
		    SWIFT_HISTORYVOWithBLOBs swiftHstVOWithBLOBs = new SWIFT_HISTORYVOWithBLOBs();
		    // if the caller of this window is swift history
		    // for an unprocessed message
		    if(StringUtil.nullToEmpty(sMsgStatus).equals("U"))
		    {
			swiftHstVOWithBLOBs.setSWIFT_MSG_BLOB(sSwiftMsgIn.toString());
			swiftHstVOWithBLOBs.setCOMP_CODE(bdCompCode);
			//old code restored waiting csm implement 604030
			swiftHstVOWithBLOBs.setBRANCH_CODE(bdBranchCode);
			swiftHstVOWithBLOBs.setMODULE(apiOutPutParams[1]);
			swiftHstVOWithBLOBs.setMSG_CODE(swiftInwardCO.getCf_mt());
			swiftHstVOWithBLOBs.setMSG_ORDER(new BigDecimal(swiftInwardCO.getCf_nbr_msgs()));
			swiftHstVOWithBLOBs.setACK(BigDecimal.ZERO);
			swiftHstVOWithBLOBs.setHISTORY_DATE(commonLibBO.returnSystemDateNoTime());
			swiftHstVOWithBLOBs.setTRS_NO(new BigDecimal(apiOutPutParams[2]));
			swiftHstVOWithBLOBs.setTRX_TYPE(apiOutPutParams[3]);
			swiftHstVOWithBLOBs.setMSG_STATUS("R");
			swiftHstVOWithBLOBs.setMODULE(apiOutPutParams[1]);

			try
			{
			    genericDAO.update(swiftHstVOWithBLOBs);
			}
			catch(DAOException e)
			{
			    saTransMsgArr = commonLibBO.returnTranslMessage(66751, sLanguage);
			    sReportTitle = saTransMsgArr[1];
			    swiftCO.setErrorMsg(sReportTitle);
			    writeLogFile(bdCompCode, 1, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
			    swiftCO.setReturnVar(-1L);
			    swiftCO.setLogFileLocation(swftInwardCO.getLogFileLocation());
			    return swiftCO;
			}
		    }

		    // break;//olivia 31/07/2014 jenkin issues
		}
		// inserting the message into swift history even if
		// procedure failed
		// default://olivia 31/07/2014 jenkin issues
		else
		// olivia 31/07/2014 jenkin issues
		{
			//EFarah - Add case to handle ack/nack - 20/07/2015
			if(NumberUtil.isNumberPositive(new BigDecimal(apiOutPutParams[0])))// olivia 31/07/2014 jenkin
				// issues
		      {
		          sErrMsg = commonLibBO.returnTranslErrorMessage(66748, new String[] { apiOutPutParams[1] },
		           sLanguage);
		          swiftCO.setErrorMsg(sErrMsg);
		          writeLogFile(bdCompCode, 1, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
		          /*processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT,
	        	  SWFT, swiftInwardDAO
		          .returnAccMaxTrsNo(), null, "P", sTagRefValue,
			    sProcessed, sLanguage); in case only the beneficiary is inserted in tmp and the transaction not created do not insert in history*/

			    swiftCO.setLogFileLocation(sSwiftLog);
		      }
		     else
		     {
		         sErrMsg = commonLibBO.returnTranslErrorMessage(66749, new String[] { apiOutPutParams[0],
		          apiOutPutParams[1] }, sLanguage);
		         swiftCO.setErrorMsg(sErrMsg);
		         writeLogFile(bdCompCode, 0, swiftCO.getErrorMsg(), sLanguage, swftInwardCO);
		         processAllInward(sSwiftMsgIn, sMsgCode, bdCompCode, bdBranchCode, SWFT, SWFT, swiftInwardDAO
		          .returnAccMaxTrsNo(), PRINTED, STATUS, null, sProcessed, sLanguage);
		         swiftCO.setLogFileLocation(sSwiftLog);
		         swiftCO.setReturnVar(-1L);
		         return swiftCO;
		     }
		}
		// }
		paramList = new ArrayList<DF_FILE_PRC_INP_PARMVO>();

	    }

	}

	return swiftCO;
    }

    private String returnGlobalValue(String sDefaultValueIn, BigDecimal bdCompCode, BigDecimal bdBranchCode,
	    String sUserId, Date dSysDate, Integer iIdx, Long llNbrOccur, Date dToday, BigDecimal bdAckMode, String lsSwiftTrxNo)
	    throws DAOException
    {
	String sDefaultValue = sDefaultValueIn;

	if(sDefaultValue.compareTo("gv_company_code") == 0 || "c_c".equals(sDefaultValue))
	{
	    sDefaultValue = bdCompCode.toString();
	}
	else if(sDefaultValue.compareTo("gv_branch_code") == 0 || "b_c".equals(sDefaultValue))
	{
	    sDefaultValue = bdBranchCode.toString();
	}
	else if(sDefaultValue.compareTo("gv_userid") == 0 || "u_i".equals(sDefaultValue))
	{
	    sDefaultValue = sUserId;
	}
	else if(sDefaultValue.compareTo("gv_system_date") == 0 || "r_d".equals(sDefaultValue))
	{
	    sDefaultValue = DateUtil.format(dSysDate, "dd/MM/yyyy");
	}
	else if(sDefaultValue.compareTo("gv_count") == 0)
	{
	    sDefaultValue = new BigDecimal(iIdx).toString();
	}
	else if(sDefaultValue.compareTo("gv_nbr_occur") == 0)
	{
	    sDefaultValue = llNbrOccur.toString();
	}
	else if(sDefaultValue.compareTo("gv_today") == 0)
	{
	    sDefaultValue = DateUtil.format(dToday, "dd/MM/yyyy");
	}
	else if(sDefaultValue.compareTo("gv_ack") == 0)
	{
	    sDefaultValue = bdAckMode.toString();
	}
	else if(sDefaultValue.compareTo("gv_hdr_det") == 0)
	{
	    sDefaultValue = BigDecimal.ZERO.toString() ;
	}
	//HGhazal - add SWIFT TRX NO - EWBI160216 - 07/09/2016
	else if(sDefaultValue.compareTo("swift_trx_no") == 0)
	{
		sDefaultValue = lsSwiftTrxNo;
	}
	else
	{
	    sDefaultValue = "-1";
	}

	return sDefaultValue;
    }

    public ArrayList<Map<String, String>> loadInwardFiles(String ackNackFilesFlag, String sLanguage ,BigDecimal bdCompCode) //Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
	    throws BaseException
    {

	String sSwiftInwardPath = null;
	String[] saTransMsgArr;
	
	if("0".equals(ackNackFilesFlag))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_PATH_JAVA(); //Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
	    if(sSwiftInwardPath == null || sSwiftInwardPath.isEmpty())
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66752, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}
	else if("1".equals(ackNackFilesFlag))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_ACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
	    if(sSwiftInwardPath == null || sSwiftInwardPath.isEmpty())
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66758, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}
	else if("2".equals(ackNackFilesFlag))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_NACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter 
	    if(sSwiftInwardPath == null || sSwiftInwardPath.isEmpty())
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66759, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}

	sSwiftInwardPath = FileUtil.getFileURLByName("repository").concat(File.separator).concat(sSwiftInwardPath);
	File inwardFileMaker;
	boolean bRetun = false;
	try {
		inwardFileMaker = new PathFileSecure(sSwiftInwardPath);
	} catch (Exception e1) {
		throw new BOException(e1);
	}
	log.error(sSwiftInwardPath);
	if(!inwardFileMaker.exists())
	{
	    bRetun = inwardFileMaker.mkdir();
	    if(!bRetun)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66760, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}

	File inwardFolder;
	try {
		inwardFolder = new PathFileSecure(sSwiftInwardPath);
	} catch (Exception e) {
		throw new BOException(e);
	}
	File[] fileList = FileUtil.returnFilesOnly(inwardFolder);

	Map<String, String> mp;// olivia 31/07/2014 jenkin issues
	mp = new HashMap<String, String>();
	ArrayList<Map<String, String>> swiftInwardMessages = new ArrayList<Map<String, String>>();
	for(final File fileEntry : fileList)
	{
	    mp.put("fileKey1", fileEntry.getName());
	    swiftInwardMessages.add(mp);
	    mp = new HashMap<String, String>();
	}

	return swiftInwardMessages;

    }

    public void moveFile(String fileName, String ackNackFlag, String sLanguage, BigDecimal bdCompCode) throws BaseException
    {
	String sSwiftInwardPath = null, archivePath, renamePath;
	String[] saTransMsgArr;
	File inwardFileMaker, archiveFileMaker;
	boolean bRetun = false;
	/* MHojeij 25/07/2018 - copy NBK180005 692818 - start*/
	String doNotArch;
	doNotArch = swiftInwardDAO.getDoNotArchFlag();
	if(! StringUtil.nullToEmpty(doNotArch).equals("") && doNotArch.equals("Y")){
		return;
	}
	/* MHojeij 25/07/2018 - copy NBK180005 692818 - end*/
	if("0".equals(StringUtil.nullToEmpty(ackNackFlag)))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	}
	else if("1".equals(ackNackFlag))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_ACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	}
	else if("2".equals(ackNackFlag))
	{
	    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_NACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
	}
	archivePath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getARCHIVE_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter

	sSwiftInwardPath = FileUtil.getFileURLByName("repository").concat(File.separator).concat(sSwiftInwardPath);

	archivePath = FileUtil.getFileURLByName("repository").concat(File.separator).concat(archivePath);

	try {
		archiveFileMaker = new PathFileSecure(archivePath);
	} catch (Exception e2) {
		throw new BOException(e2);
	}
	try {
		inwardFileMaker = new PathFileSecure(sSwiftInwardPath);
	} catch (Exception e2) {
		throw new BOException(e2);
	}
	if(!inwardFileMaker.exists())
	{
	    bRetun = inwardFileMaker.mkdir();
	    if(!bRetun)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66760, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}

	if(!archiveFileMaker.exists())
	{
	    bRetun = archiveFileMaker.mkdir();
	    if(!bRetun)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66762, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}

	renamePath = archivePath;

	sSwiftInwardPath = sSwiftInwardPath.concat(File.separator).concat(fileName);
	// archivePath = archivePath + "/";
	File destDirectory;
	try {
		destDirectory = new PathFileSecure(archivePath.toString());
	} catch (Exception e1) {
		throw new BOException(e1);
	}

	if(!destDirectory.exists())
	{
	    bRetun = destDirectory.mkdir();
	    if(!bRetun)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66762, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}
	archivePath = archivePath.concat(File.separator).concat(fileName);

	try {
		destDirectory = new PathFileSecure(archivePath);
	} catch (Exception e1) {
		throw new BOException(e1);
	}

	File deletedFile;
	try {
		deletedFile = new PathFileSecure(sSwiftInwardPath);
	} catch (Exception e1) {
		throw new BOException(e1);
	}

	try
	{
	    Files.move(deletedFile.toPath(), destDirectory.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    String timeStamp = DateUtil.format(commonLibBO.returnSystemDateWithTime(), "yyyyMMdd_HHmmss");
	    renamePath = renamePath.concat(File.separator).concat(fileName.substring(0, fileName.indexOf('.'))).concat(
		    timeStamp).concat(".txt");
	    Boolean bVal;
		try {
			bVal = destDirectory.renameTo(new PathFileSecure(renamePath));
		} catch (Exception e) {
			throw new BOException(e);
		}
	    if (!bVal)
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66771, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }
	}
	catch(IOException e)
	{
	    throw new BOException(e.getMessage(), e);// olivia 31/07/2014 jenkin
	    // issues
	}
    }

    public int returnInwardSwiftLogGridCount(SwiftInwardSC swiftInwardSC) throws BaseException
    {
	return swiftInwardDAO.returnInwardSwiftLogGridCount(swiftInwardSC);
    }

    public ArrayList<SWIFT_LOG_INVO> returnInwardSwiftLogGrid(SwiftInwardSC swiftInwardSC) throws BaseException
    {
	ArrayList<SWIFT_LOG_INVO> swiftLogINVO;
	swiftLogINVO = swiftInwardDAO.returnInwardSwiftLogGrid(swiftInwardSC);
	return swiftLogINVO;
    }

    public int swenEngineProcessIn(String sLanguage, BigDecimal bdCompCode, BigDecimal bdBranchCode, String sUserId,
	    BigDecimal bdBaseCurrency, Date dSystemDate) throws BaseException
    {
	// check if ack flag in the control record is 1 or 0
	int iAck = 1;
	if(BigDecimal.ONE.equals(commonLibBO.returnSwiftCtrlRecValues().getACK()))
	{
	    iAck = 3;
	}

	/*BMOUPI180305 Mohamad Hojeij 27/05/2018 chck if there is any thread active to stop its self*/
	for(int folderCount = 0; folderCount < iAck; folderCount++)
	{
	    String sSwiftInwardPath = null;
	    String[] saTransMsgArr;

	    switch (folderCount)
	    {
		case 0:
		    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
		    if(sSwiftInwardPath == null || sSwiftInwardPath.isEmpty())
		    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66752, sLanguage);
			throw new BOException(saTransMsgArr[0]);
		    }
		    break;
		case 1:
		    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_ACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
		    if(sSwiftInwardPath == null || sSwiftInwardPath.isEmpty())
		    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66758, sLanguage);
			throw new BOException(saTransMsgArr[0]);
		    }
		    break;
		case 2:
		    sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(bdCompCode).getINWARD_NACK_PATH_JAVA();//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
		    if(sSwiftInwardPath == null || sSwiftInwardPath.isEmpty())
		    {
			saTransMsgArr = commonLibBO.returnTranslMessage(66759, sLanguage);
			throw new BOException(saTransMsgArr[0]);
		    }
		    break;
		default:
		    break;
	    }
	    // Concat the file directory with repository directory
	    String sRepoSwift = FileUtil.getFileURLByName("repository");
	    sSwiftInwardPath = sRepoSwift.concat(sSwiftInwardPath);

	    // parse message logic must be applied on how much each folder
	    // contain MSGs
	    File inwardFolder;
		try {
			inwardFolder = new PathFileSecure(sSwiftInwardPath);
		} catch (Exception e2) {
			throw new BOException(e2);
		}
	    ArrayList<SwiftInwardCO> swiftInwardCOList;
	    
	    for(File file : inwardFolder.listFiles())
	    {
		if(file.isDirectory()
			|| !"txt"
				.equals(file.getName().substring(file.getName().length() - 3, file.getName().length())))
		{
		    continue;
		}

		String sFileName = file.getName();
		BigDecimal bdFolderCount = new BigDecimal(folderCount), bdAckMode = BigDecimal.ZERO;
		
		String sFileName2 = sFileName.replaceFirst(Pattern.quote("." +
		          "txt") + "$", Matcher.quoteReplacement("." + "prc"));
		
		try {
			if(! file.renameTo(new PathFileSecure(sSwiftInwardPath + sFileName2))){
				continue;
			}
		} catch (Exception e1) {
			throw new BOException(e1);
		}

		swiftInwardCOList = readTextFile(sFileName2, sLanguage, bdCompCode, bdFolderCount.toString());
		String sMsgCode = null;
		if(swiftInwardCOList != null && !swiftInwardCOList.isEmpty())
		{
		    sMsgCode = swiftInwardCOList.get(0).getCf_mt();
		}
		// Check if Inward Recon
		if("MT 950".equals(sMsgCode) || "MT 940".equals(sMsgCode) && folderCount == 0)
		{
		    String sFileContent = "";
		    try
		    {
			sFileContent = FileUtil.readFile(sSwiftInwardPath.concat(File.separator).concat(sFileName));
		    }
		    catch(Exception e)
		    {
			throw new BOException(e);
		    }
		    try
		    {
			swiftReconBO.selectFile(sFileContent, sLanguage, bdCompCode, bdBaseCurrency, sUserId,
				dSystemDate, 1);
			moveFile(sFileName2, bdFolderCount.toString(), sLanguage,bdCompCode);//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
			continue;
		    }
		    catch(BOException e)
		    {
			moveFile(sFileName2, bdFolderCount.toString(), sLanguage,bdCompCode);//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
			throw new BOException(e);
		    }
		}
		// get the hashmap of the message
		ArrayList<Map<String, Object>> aListMapSqlRep = convertObjectListToMapList(swiftInwardCOList);
		Long MsgGrp = 1L;
		int lastLine = 1;
		BigDecimal StartingLine = BigDecimal.ONE;
		ArrayList<SwiftInwardCO> swiftInwardCOList2 = new ArrayList<SwiftInwardCO>();
		Boolean firstMsg = false;
		
		ArrayList<ArrayList<SwiftInwardCO>> swiftInwardCOList1 = new ArrayList<ArrayList<SwiftInwardCO>>();;
		
		for(int i = 0;i< swiftInwardCOList.size(); i++)
		{
			if(swiftInwardCOList.get(i).getCf_tag().equals("H"))
			{
				if(firstMsg==true)
				{				
					swiftInwardCOList1.add(swiftInwardCOList2);
					swiftInwardCOList2 = new ArrayList<SwiftInwardCO>();
				}
				swiftInwardCOList2.add(swiftInwardCOList.get(i));
			}
			else
			{
				firstMsg=true;
				if(!swiftInwardCOList.get(i).getCf_tag().equals("N"))
				{
					swiftInwardCOList2.add(swiftInwardCOList.get(i));
				}
			}
		}
		swiftInwardCOList1.add(swiftInwardCOList2);
		
		for(int i = 0; i < swiftInwardCOList1.size(); i++)
		{
		    // GETTING START LINE FOR EACH MESSAGE
		    for(SwiftInwardCO swiftInwardCoElement : swiftInwardCOList1.get(i))
		    {
		    if(swiftInwardCoElement.getCf_tag().equals("H"))//efarah 06-03-2017
			{
		    	if(i==0)
		    	{
		    		MsgGrp = 1L;
		    		lastLine =swiftInwardCOList1.get(i).size();
		    		swiftInwardCOList.get(i).setCf_first_line(1L);
		    		swiftInwardCOList.get(i).setCf_last_line(new Long(lastLine));
		    	}
		    	else
		    	{
		    		MsgGrp = new Long(lastLine);
		    		if (swiftInwardCoElement.getCompute_4() == 2) MsgGrp = MsgGrp + 1; //#619070 Mohamad Hojeij - 12/05/2018
		    		swiftInwardCOList.get(i).setCf_first_line(new Long(lastLine) +1);
		    		swiftInwardCOList.get(i).setCf_last_line(new Long(lastLine) + new Long(swiftInwardCOList1.get(i).size()));
		    		lastLine =swiftInwardCOList1.get(i).size();
		    	}
			    StartingLine = new BigDecimal(swiftInwardCoElement.getCompute_1());
			    sMsgCode = swiftInwardCoElement.getCf_mt();
			    break;
			}
		    }

		    // BUILDING THE MESSAGE TO BE SAVED IN SWIFT HISTORY
		    StringBuilder sbInwardMsg = new StringBuilder();
		    String sTag, sMessageLine;
		    for(int k = StartingLine.intValue() - 1; k < swiftInwardCOList.size(); k++)
		    {
			sTag = swiftInwardCOList.get(k).getCf_tag();
			sMessageLine = swiftInwardCOList.get(k).getMessage_line();

			if(sMessageLine == null)
			{
			    sMessageLine = "";
			}
			sbInwardMsg.append(sMessageLine);
			sbInwardMsg.append("\r\n");

			if("T".equals(sTag))
			{
			    break;

			}

		    }

		    try
		    {
			swiftCO = parseMessage(swiftInwardCOList, sMsgCode, MsgGrp, bdCompCode, bdBranchCode, sUserId,
				commonLibBO.returnSystemDateWithTime(), bdAckMode, sbInwardMsg.toString(), "S", "U",
				0L, null, null, sLanguage, aListMapSqlRep);

			moveFile(sFileName2, bdFolderCount.toString(), sLanguage,bdCompCode);//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
		    }
		    catch(BOException e)
		    {
			moveFile(sFileName2, bdFolderCount.toString(), sLanguage,bdCompCode);//Updated by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - adding company code parameter
			throw new BOException(e);
		    }

		}
	    }
	}
	return 1;
    }

    private ArrayList<Map<String, Object>> convertObjectListToMapList(ArrayList<SwiftInwardCO> swiftInwardCOList)
	    throws BaseException
    {
	ArrayList<Map<String, Object>> inwardMapList = new ArrayList<Map<String, Object>>();
	Map<String, Object> hm;
	for(SwiftInwardCO swiftInwardCO : swiftInwardCOList)
	{
	    hm = new HashMap<String, Object>();
	    hm.put("compute_1", swiftInwardCO.getCompute_1());
	    hm.put("cf_msg_grp", StringUtil.nullToEmpty(swiftInwardCO.getCf_msg_grp()));
	    hm.put("cf_msg_line_count", StringUtil.nullToEmpty(swiftInwardCO.getCf_msg_line_count()));
	    hm.put("cf_mt", swiftInwardCO.getCf_mt());
	    hm.put("cf_tag", swiftInwardCO.getCf_tag());
	    hm.put("compute_3", swiftInwardCO.getCompute_3());
	    hm.put("cf_first_line", StringUtil.nullToEmpty(swiftInwardCO.getCf_first_line()));
	    hm.put("cf_header_det", swiftInwardCO.getCf_header_det());
	    hm.put("cf_last_line", StringUtil.nullToEmpty(swiftInwardCO.getCf_last_line()));
	    hm.put("cf_line_value", swiftInwardCO.getCf_line_value());
	    hm.put("cf_nbr_msgs", swiftInwardCO.getCf_nbr_msgs());
	    hm.put("cf_nbr_repetition", StringUtil.nullToEmpty(swiftInwardCO.getCf_nbr_repetition()));
	    hm.put("cf_value", swiftInwardCO.getCf_value());
	    hm.put("cfd_tag", swiftInwardCO.getCfd_tag());
	    hm.put("compute_2", swiftInwardCO.getCompute_2());
	    hm.put("compute_3", swiftInwardCO.getCompute_3());
	    hm.put("compute_4", swiftInwardCO.getCompute_4());
	    hm.put("compute_5", swiftInwardCO.getCompute_5());
	    hm.put("message_line", swiftInwardCO.getMessage_line());
	    inwardMapList.add(hm);
	}
	return inwardMapList;
    }

    public void updateEngineServiceStatusIn(BigDecimal bdCompCode, String serviceName, int serviceStatus,
	    String sLanguage, SwiftInwardSC swiftInwardSC) throws BaseException
    {
	String[] saTransMsgArr;
	String logMsg;

	if(serviceStatus == 1)
	{
	    swiftInwardSC.setServiceStatus("ON");
	    saTransMsgArr = commonLibBO.returnTranslMessage(66674, sLanguage);
	    logMsg = saTransMsgArr[0]; // Swift Engine Started
	}
	else
	{
	    swiftInwardSC.setServiceStatus("OFF");
	    saTransMsgArr = commonLibBO.returnTranslMessage(66675, sLanguage);
	    logMsg = saTransMsgArr[0]; // Swift Engine Stopped
	}

	swiftInwardSC.setServiceName(serviceName);

	swiftInwardDAO.updateEngineServiceStatusIn(swiftInwardSC);
	SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
	writeLogFile(bdCompCode, 1, logMsg, sLanguage, swiftInwardCO);

    }

    public void resetLog() throws BaseException
    {
	swiftInwardDAO.deleteSwiftLogInward();
    }
    
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
    
  //efarah 07/04/2017 EWBI170270
    public void stopThread() throws BaseException {

    	if(ConstantsCommon.timerInExec != null)
	    {
		synchronized(ConstantsCommon.timerInExec)
		{
			SWFT_SCHED_MANAGER_INVO managVo = new SWFT_SCHED_MANAGER_INVO();
			managVo.setTHREAD_ID(0);
			genericDAO.delete(managVo);
			ConstantsCommon.timerInExec.cancel();
			ConstantsCommon.timerInExec = null;
		}
	    }
	}
    
    //efarah 07/04/2017 EWBI170270
    public void runThread(Long iRefreshRate, String language,
    		BigDecimal companyCode, BigDecimal branchCode, String userName,
    		SwiftInwardCO swiftInwardCO, BigDecimal bdBaseCurrency,Date dSysDate) throws BaseException {

    	if(ConstantsCommon.timerInExec == null)
    	{
    	    synchronized(lock)
    	    {
    	    	ConstantsCommon.timerInExec = new Timer();
    	    }
    	}
    	else
    	{
    	    synchronized(ConstantsCommon.timerInExec)
    	    {
    	    	ConstantsCommon.timerInExec.cancel();
    	    	ConstantsCommon.timerInExec = new Timer();
    	    }
    	}
    	long threadId = System.currentTimeMillis();/*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
    	ConstantsCommon.timerInExec.scheduleAtFixedRate(
    			new SwenINTaskRunner(language, companyCode, branchCode, userName,
    					swiftInwardCO, bdBaseCurrency,dSysDate,threadId), iRefreshRate, iRefreshRate);/*Mohamad Hojeij 27/05/2018 BMOUPI180305 add the thread id*/
    }

    //efarah 07/04/2017 EWBI170270
    public class SwenINTaskRunner extends TimerTask
    {
    String language;
    BigDecimal companyCode;
    BigDecimal branchCode;
    String userName;
    SwiftInwardCO swiftInwardCO;
    BigDecimal bdBaseCurrency;
    Date dSysDate;
    long threadId;
    /*commented by Mohamad Hojeij 27/05/2018 BMOUPI180305*/
   /* public SwenINTaskRunner(String language, BigDecimal companyCode,BigDecimal branchCode, String userName, SwiftInwardCO swiftInwardCO, BigDecimal bdBaseCurrency,Date dSysDate)
    { 
    	
        this.language = language;
        this.companyCode = companyCode;
        this.branchCode = branchCode;
        this.userName = userName;
        this.swiftInwardCO = swiftInwardCO;
        this.bdBaseCurrency = bdBaseCurrency;
        this.dSysDate = dSysDate;
    }*/
    
    public SwenINTaskRunner(String language, BigDecimal companyCode,BigDecimal branchCode, String userName, SwiftInwardCO swiftInwardCO, BigDecimal bdBaseCurrency,Date dSysDate,long threadId)
    {
    	
        this.language = language;
        this.companyCode = companyCode;
        this.branchCode = branchCode;
        this.userName = userName;
        this.swiftInwardCO = swiftInwardCO;
        this.bdBaseCurrency = bdBaseCurrency;
        this.dSysDate = dSysDate;
        this.threadId = threadId;/*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
    }

    public void run()
    {
    	try {
    		/*Mohamad Hojeij 27/05/2018 BMOUPI180305*/
    		SWFT_SCHED_MANAGER_INVO managVo = new SWFT_SCHED_MANAGER_INVO();
    		int iEngineStatus = returnServiceStatus("SWIFT_IN", language);
    		
    		if(iEngineStatus == 0){
    			this.cancel();
    			
				managVo = new SWFT_SCHED_MANAGER_INVO();
    			managVo.setTHREAD_ID(threadId);
    			genericDAO.delete(managVo);
    			return;
    		}
			managVo.setTHREAD_ID(threadId);
    		BigDecimal activeThreadsCount = swiftInwardDAO.returnCountActiveThreads(managVo);
    		BigDecimal isActive = swiftInwardDAO.returnIsActiveThreads(managVo);
    		
    		if(activeThreadsCount.equals(BigDecimal.ONE) && isActive.equals(BigDecimal.ZERO) ){
    			this.cancel();
    			return;
    		}
    		
    		
    		if(activeThreadsCount.equals(BigDecimal.ZERO) && isActive.equals(BigDecimal.ZERO)){
    			
        		
    			Date thread_date = commonLibBO.returnSystemDateWithTime();
    			managVo = new SWFT_SCHED_MANAGER_INVO();
    			managVo.setTHREAD_ID(threadId);
    			managVo.setTHREAD_DATE(thread_date);
    			managVo.setTHREAD_STATUS("A");
    			genericDAO.insert(managVo);
    		}
    		
    		if((activeThreadsCount.compareTo(BigDecimal.ONE)== 1 || activeThreadsCount.equals(BigDecimal.ONE)) && isActive.equals(BigDecimal.ONE)){
    			long threadwithMindate = swiftInwardDAO.returnThreadWithMinDate(managVo);
    			if(threadwithMindate != threadId){
    				this.cancel();
    				managVo = new SWFT_SCHED_MANAGER_INVO();
        			managVo.setTHREAD_ID(threadId);
        			genericDAO.delete(managVo);
        			return;
    			}
    		}
    		
    		
    		/*managVo = new SWFT_SCHED_MANAGER_INVO();
			managVo.setTHREAD_ID(threadId);
			activeThreadsCount = swiftInwardDAO.returnIsActiveThreads(managVo);
    		if(activeThreadsCount.equals(BigDecimal.ZERO)){
    			Date thread_date = commonLibBO.returnSystemDateWithTime();
    			managVo = new SWFT_SCHED_MANAGER_INVO();
    			managVo.setTHREAD_ID(threadId);
    			managVo.setTHREAD_DATE(thread_date);
    			managVo.setTHREAD_STATUS("A");
    			genericDAO.insert(managVo);
    		}
    		else if(activeThreadsCount.equals(BigDecimal.ONE)){
    			managVo = new SWFT_SCHED_MANAGER_INVO();
    			managVo.setTHREAD_ID(threadId);
    			activeThreadsCount = swiftInwardDAO.returnIsActiveThreads(managVo);
    			
    		}
    		
    		if(activeThreadsCount.compareTo(BigDecimal.ONE) == 1){ //activeThreadsCount > 1 --> kill all the threads and leave the one with the old date
    			
    			
    			
    		}*/
    		
    		CommonLibBO commonLibBO = (CommonLibBO) ApplicationContextProvider.getApplicationContext().getBean("commonLibBO");
    		
    		if(commonLibBO.clusterOperationControl ("SwenProcessIn", false))
    	 {
    		SwiftInwardBO swiftInwardBO = (SwiftInwardBO) ApplicationContextProvider.getApplicationContext().getBean("swiftInwardBO");
    		
    		try
    		{	    
    		    swenEngineProcessIn(language,companyCode,branchCode,userName, bdBaseCurrency,dSysDate);
    		}
    		catch(Exception e)
    		{
    	//	    // Cancel the Timer in order not to stop the task execution
    	//	    this.cancel();
    	
    		    SwiftInwardCO swiftInwardCO = new SwiftInwardCO();
    		    try
    		    {
    			writeLogFile(companyCode, 0, e.getMessage(), language, swiftInwardCO);
    		    }
    		    catch(Exception e1)
    		    {
    			e1.printStackTrace();
    		    }	   
    		}
    	 }
    } catch (BeansException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    } catch (BaseException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
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
    }
    
    //efarah 07/04/2017 EWBI170270
    public Integer updateRefreshRate(BigDecimal bdRefRate,String serviceName) throws BaseException
    {
	if(NumberUtil.isNumberNegative(bdRefRate) || bdRefRate.compareTo(new BigDecimal(999999999)) == 1)
	{
	    return -1;
	}
	EAS_SERVICESVO easServicesVO = new EAS_SERVICESVO();
	easServicesVO.setREFRESH_RATE(bdRefRate);
	easServicesVO.setSERVICE_NAME(serviceName);

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
  //Added by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibBO -Start
  	public SwiftOutwardNonTransBO getSwiftOutwardNonTransBO() {
  		return swiftOutwardNonTransBO;
  	}

  	public void setSwiftOutwardNonTransBO(SwiftOutwardNonTransBO swiftOutwardNonTransBO) {
  		this.swiftOutwardNonTransBO = swiftOutwardNonTransBO;
  	}
  	//Added by LBedrane on 23/02/2018 for #405559 AUBBH160008 - SWIFT Multiple Companies issue - in order to not update commonlibBO - End
  	
    public boolean checkIfFileDeletedFromRepository(String fileName,BigDecimal compCode) throws BaseException
    {

    	String sSwiftInwardPath = swiftOutwardNonTransBO.returnSwiftCtrlRecValues(compCode).getINWARD_PATH_JAVA();
    	String fileUrl = FileUtil.getFileURLByName("repository").concat(File.separator).concat(sSwiftInwardPath).concat(File.separator).concat(fileName);
    	File file;
		try {
			file = new PathFileSecure(fileUrl);
		} catch (Exception e) {
			throw new BOException(e);		
			}
    	if(file.exists())
    	{
    		return false;
    	}
    	return true;
    }
    //LBedrane - BMO180040 - TP#690676 - 12/07/2018
  	public Integer returnValueOfEnableQueueYn() throws BaseException {
  		
  		return swiftInwardDAO.returnValueOfEnableQueueYn();
  	}
  	
  //LBedrane - BMO180040 - TP#690676 - 12/07/2018 <Start>
  	//used to fill the MQ grid at the level of the inwardprocess screen
	public HashMap<String, Object> fillInwardQueueGrid() throws BaseException {
		
		HashMap<String, Object> mqRespscHash = new HashMap<>();
		try{
		
		String swiftUrl = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties","swift.serviceURL") ;
		SWIFT_CONTROLVO swiftControlVo = new SWIFT_CONTROLVO();
		swiftControlVo = swiftInwardDAO.readMQSettings();
		//MQConnectorBO mqConnectorBO = (MQConnectorBO) RmiServiceCaller.returnRmiInterface(swiftUrl, MQConnectorBO.class,"mqConnectorBOService");
		HashMap<String, Object> swiftControlVoHash = new HashMap<>();
		swiftControlVoHash = PathPropertyUtil.convertToMap(swiftControlVo);
		//mqRespscHash =    mqConnectorBO.getMQMessages(swiftControlVoHash);
		}  
		catch(Exception e){
			  return null;
		}
		
		return mqRespscHash;
	}
	 //LBedrane - BMO180040 - TP#690676 - 12/07/2018 <ENd>

    public KeyStore loadKeyStore (String keyStoreFileName, String keyStorePassword) throws Exception
    {
	KeyStore keystore = KeyStore.getInstance("JKS");
	FileInputStream inputStream = new FileInputStream(keyStoreFileName); 
	keystore.load(inputStream, keyStorePassword.toCharArray());	
	inputStream.close();
	return keystore; 
    }
    
    public SwiftSignatureSC verifySignatureMessage(SwiftSignatureSC swiftSignatureSC) throws Exception {
	// TODO Auto-generated method stub
	try{
	    KeyStore keyStore = loadKeyStore(swiftSignatureSC.getKeyStoreFileName(),swiftSignatureSC.getKeyStorePassword());
	    Signature signature = Signature.getInstance("SHA256withRSA");
	    signature.initVerify(keyStore.getCertificate(swiftSignatureSC.getKeyAlias()).getPublicKey());
	    signature.update(swiftSignatureSC.getContent().getBytes());
	    boolean s = signature.verify(Base64.decode(swiftSignatureSC.getDigitalSignature().getBytes()));
	    if(s) 
		swiftSignatureSC.setSigned("true");
	    else 
		swiftSignatureSC.setSigned("false");
	    swiftSignatureSC.setOlErrorCode(0);
	    swiftSignatureSC.setOsErrorDesc("");
	    return swiftSignatureSC;
	    
	}
	catch(Exception e){
	    swiftSignatureSC.setSigned("false");
	    swiftSignatureSC.setOlErrorCode(-1);
	    swiftSignatureSC.setOsErrorDesc(e.toString());
	    return swiftSignatureSC;
	}
    }
}
