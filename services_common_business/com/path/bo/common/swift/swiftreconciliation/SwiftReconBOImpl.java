package com.path.bo.common.swift.swiftreconciliation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.bo.common.CachedConstantsCommon;
import com.path.dao.common.swift.SwiftReconDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.SWIFT_HST_RECONCILEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconBankStmtCO;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconcileCO;
import com.path.vo.common.swift.swiftreconciliation.SwiftReconcileSC;

public class SwiftReconBOImpl extends BaseBO implements SwiftReconBO
{
    private SwiftReconDAO swiftReconDAO;

    public void setSwiftReconDAO(SwiftReconDAO swiftReconDAO)
    {
	this.swiftReconDAO = swiftReconDAO;
    }

    public ArrayList<SwiftReconcileCO> selectFile(String sInputFile, String sLanguage, BigDecimal bdCompCode,
	    BigDecimal bdBaseCy, String sUserId, Date dtSysDate, int iEngFlag) throws BaseException
    {
	ArrayList<SwiftReconcileCO> swiftReconcileCOList = new ArrayList<SwiftReconcileCO>();
	String sTransDate, sAmount;
	boolean bEntryDate = false;
	List<String> sSubTag6List, sSubTag7List, sSubTag8List, subTag9List, sTag61List, sTag65List, sTag86List, sTagsList;

	sSubTag6List = new ArrayList<String>();
	sSubTag7List = new ArrayList<String>();
	sSubTag8List = new ArrayList<String>();
	subTag9List = new ArrayList<String>();
	sTag61List = new ArrayList<String>();
	sTag65List = new ArrayList<String>();
	sTag86List = new ArrayList<String>();
	sTagsList = new ArrayList<String>();
	// bNewMsg = true;
	// swiftReconcileCOList to be filled with all the field in dw_reconcile
	// coming from the file parsing

	List<String> fileMsgs = new ArrayList<String>();
	int $Pos = 0;
	String sMsg;
	for(int iSplitCounter = 0; iSplitCounter < sInputFile.length(); iSplitCounter++)
	{
	    $Pos = sInputFile.indexOf('$', iSplitCounter);
	    if($Pos > 0)
	    {
		sMsg = sInputFile.substring(iSplitCounter, $Pos);
		if("\r\n".equals(sMsg.substring(0, 2)))
		{
		    sMsg = sInputFile.substring(iSplitCounter + 2, $Pos);
		}
		fileMsgs.add(sMsg);
		iSplitCounter = $Pos;
	    }
	    else
	    {
		sMsg = sInputFile.substring(iSplitCounter, sInputFile.length());
		if("\r\n".equals(sMsg.substring(0, 2)))
		{
		    sMsg = sInputFile.substring(iSplitCounter + 2, sInputFile.length());
		}
		fileMsgs.add(sMsg);
		break;
	    }
	}
	int iLength = 0, iBound, iRows = 0;
	BigDecimal bdCount61 = BigDecimal.ZERO, bdCount86 = BigDecimal.ZERO, bdCount65 = BigDecimal.ZERO;
	String[] saTransMsgArr;
	String sMessage, sTag;
	boolean bFound61 = false;
	// boolean bDelete = false;
	for(int iCallCounter = 0; iCallCounter < fileMsgs.size(); iCallCounter++)
	{
	    bdCount61 = BigDecimal.ZERO;
	    bdCount65 = BigDecimal.ZERO;
	    bdCount86 = BigDecimal.ZERO;

	    sMessage = fileMsgs.get(iCallCounter);
	    iLength = sMessage.length();
	    if(sMessage != null && !"{".equals(sMessage.substring(0, 1)))
	    {
		saTransMsgArr = commonLibBO.returnTranslMessage(66764, sLanguage);
		throw new BOException(saTransMsgArr[0]);
	    }

	    // bDelete = false;
	    int iCount = 0;
	    for(int i = 0; i < iLength - 3; i++)
	    {
		if(iLength > 5 && (i + 5) < sMessage.length())
		{
		    sTag = sMessage.substring(i, i + 5);

		    if(":".equals(sTag.substring(0, 1)) && ":".equals(sTag.substring(4, 5))
			    && !"\r\n".equals(sTag.substring(1, 3)) && !"\r\n".equals(sTag.substring(2, 4)))
		    {
			iCount++;
			sTagsList.add(sTag);
		    }
		    else if(":".equals(sTag.substring(0, 1)) && ":".equals(sTag.substring(3, 4))
			    && !"\r\n".equals(sTag.substring(1, 3)) && !"\r\n".equals(sTag.substring(2, 4)))
		    {
			iCount++;
			sTag = sTag.substring(0, 4);
			sTagsList.add(sTag);

			if(":61:".equals(sTag))
			{
			    bdCount61 = bdCount61.add(BigDecimal.ONE);
			}
			else if(":86:".equals(sTag))
			{
			    bdCount86 = bdCount86.add(BigDecimal.ONE);
			}
			else if(":65:".equals(sTag))
			{
			    bdCount65 = bdCount65.add(BigDecimal.ONE);
			}

		    }
		}
	    }

	    iBound = sTagsList.size();
	    if(":86:".equals(sTagsList.get(--iBound)))
	    {
		bdCount86 = new BigDecimal(bdCount86.intValue() - 1);
	    }

	    if(bdCount61.signum() > 0)
	    {
		iRows = bdCount61.intValue();
		bFound61 = true;
	    }
	    else if(bdCount86.signum() > 0)
	    {
		iRows = bdCount86.intValue();
		// bFound86 = true;
	    }
	    else if(bdCount65.signum() > 0)
	    {
		iRows = bdCount65.intValue();
		// bFound65 = true;
	    }

	    BigDecimal bdTag28 = BigDecimal.ZERO, bdCy = null, bdAccCompCode = null, bdAccBranchCode = null, bdDecPoints = BigDecimal.ZERO, bdDecimalPoints = null;

	    int startTagLen, iTag1PrevPos = 0, iTag2PrevPos = 0, iCounter, iLine, iTag1Pos = 0, iTag2Pos = 0, iTildPos, iTildPos2, iCommaPos, iAccSerPos;

	    String sExtract, sExtractMain, sTild, sTag20 = null, sTag21 = null, sTag25 = null, sTag60 = null, sTag62 = null, sTag64 = null, sSubTag9, sSubTag6, sSubTag7, sSubTag8;
	    AMFVO amfVO = new AMFVO();
	    iLine = 0;
	    CURRENCIESVO cyVO = new CURRENCIESVO();

	    for(iCounter = 0; iCounter < sTagsList.size(); iCounter++)
	    {
		if(sTagsList.get(iCounter) == null)
		{
		    continue;
		}
		iTag1Pos = sMessage.indexOf(sTagsList.get(iCounter).toString(), iTag1PrevPos + 1);
		if((iCounter + 1) != sTagsList.size())
		{
		    iTag2Pos = sMessage.indexOf(sTagsList.get(iCounter + 1).toString(), iTag2PrevPos + 1);
		}
		iTag1PrevPos = iTag1Pos;
		iTag2PrevPos = iTag2Pos;
		if(iTag1Pos == iTag2Pos && (iCounter + 1) != sTagsList.size())
		{
		    iTag2Pos = sMessage.indexOf(sTagsList.get(iCounter + 1).toString(), iTag1Pos
			    + sTagsList.get(iCounter).toString().length());
		    iTag1PrevPos = iTag2Pos;
		}
		startTagLen = sTagsList.get(iCounter).toString().length();

		if(iTag1Pos > 0 && iTag2Pos > 0)
		{
		    if((iCounter + 1) == sTagsList.size())
		    {
			sExtract = sMessage.substring(iTag1Pos + startTagLen, iLength);
		    }
		    else
		    {
			sExtract = sMessage.substring(iTag1Pos + startTagLen, iTag2Pos);
		    }

		    sExtractMain = sExtract;
		    sTild = "\r\n";
		    iTildPos = sExtract.indexOf(sTild);
		    sExtract = sExtract.substring(0, iTildPos);
		    sExtract = sExtract.trim();

		    if(":20:".equals(sTagsList.get(iCounter).toString()))
		    {
			sExtract = sExtract.trim();
			sTag20 = sExtract;
		    }
		    else if(":21:".equals(sTagsList.get(iCounter).toString()))
		    {
			sExtract = sExtract.trim();
			sTag21 = sExtract;
		    }
		    else if(":28C:".equals(sTagsList.get(iCounter).toString()))
		    {

			// bdValue = new BigDecimal(sExtract);
			bdTag28 = BigDecimal.ZERO;
		    }
		    else if(":61:".equals(sTagsList.get(iCounter).toString()))
		    {

			iTildPos2 = sExtractMain.indexOf(sTild, iTildPos + 1);
			// sub9
			if(iTildPos2 > 2)
			{
			    sSubTag9 = sExtractMain.substring(iTildPos + 2, iTildPos2);
			}
			else
			{
			    sSubTag9 = "";
			}
			subTag9List.add(sSubTag9);
			// sub6
			iCommaPos = sExtractMain.indexOf(',', 0);
			sSubTag6 = sExtractMain.substring(iCommaPos + bdDecPoints.intValue() + 1, iCommaPos
				+ bdDecPoints.intValue() + 5);

			sSubTag6List.add(sSubTag6);

			// sub7
			iAccSerPos = sExtractMain.indexOf('/', 1);
			if(iAccSerPos == -1)
			{
			    if(iTildPos2 > 0)
			    {
				iAccSerPos = iTildPos2;
			    }
			    else
			    {
				iAccSerPos = iTildPos;
			    }
			}
			sSubTag7 = sExtractMain.substring(iCommaPos + bdDecPoints.intValue() + 4 + 1, iAccSerPos);

			sSubTag7List.add(sSubTag7);

			// sub8
			iAccSerPos = sExtractMain.indexOf('/', 1);
			if(iAccSerPos > 0)
			{
			    sSubTag8 = sExtractMain.substring(iAccSerPos, iTildPos);
			}
			else
			{
			    sSubTag8 = "";
			}
			sSubTag8List.add(sSubTag8);
			//			
			sTag61List.add(sExtract);

		    }
		    else if(":86:".equals(sTagsList.get(iCounter).toString()))
		    {
			sTag86List.add(sExtract);
		    }
		    else if(":25:".equals(sTagsList.get(iCounter).toString()))
		    {
			sExtract = sExtract.trim();
			sTag25 = sExtract;

			SwiftReconcileSC swiftReconcileSC = new SwiftReconcileSC();
			swiftReconcileSC.setAccNo(sExtract);
			swiftReconcileSC.setCompCode(bdCompCode);

			amfVO = swiftReconDAO.selectAccountNoDet(swiftReconcileSC);

			if(amfVO == null)
			{
			    saTransMsgArr = commonLibBO.returnTranslMessage(66765, sLanguage);
			    throw new BOException(saTransMsgArr[0]);
			}

			bdCy = amfVO.getCURRENCY_CODE();
			bdAccCompCode = amfVO.getCOMP_CODE();
			bdAccBranchCode = amfVO.getBRANCH_CODE();

			cyVO.setCOMP_CODE(bdCompCode);
			cyVO.setCURRENCY_CODE(bdCy);
			cyVO = (CURRENCIESVO) genericDAO.selectByPK(cyVO);

			if(cyVO == null)
			{
			    saTransMsgArr = commonLibBO.returnTranslMessage(66766, sLanguage);
			    throw new BOException(saTransMsgArr[0]);
			}
			bdDecimalPoints = cyVO.getDECIMAL_POINTS();

		    }
		    else if(":60F:".equals(sTagsList.get(iCounter).toString())
			    || ":60M:".equals(sTagsList.get(iCounter).toString()))
		    {
			sTag60 = sExtract;
			cyVO.setCOMP_CODE(bdCompCode);
			bdDecPoints = swiftReconDAO.selectCurrencyDecimalPoints(cyVO, sExtract);

		    }
		    else if(":62F:".equals(sTagsList.get(iCounter).toString()))
		    {
			sTag62 = sExtract;
		    }
		    else if(":62M:".equals(sTagsList.get(iCounter).toString()))
		    {
			sTag62 = sExtract;
		    }
		    else if(":64:".equals(sTagsList.get(iCounter).toString()))
		    {
			sTag64 = sExtract;
		    }
		    else if(":65:".equals(sTagsList.get(iCounter).toString()))
		    {

			sTag65List.add(sExtract);

		    }

		}

	    }
	    String sErrMsg;
	    if(sTag25 == null)
	    {
		sErrMsg = commonLibBO.returnTranslErrorMessage(66769, new String[] { "25" }, sLanguage);
		throw new BOException(sErrMsg);
	    }
	    if(sTag60 == null)
	    {
		sErrMsg = commonLibBO.returnTranslErrorMessage(66769, new String[] { "60" }, sLanguage);
		throw new BOException(sErrMsg);
	    }
	    if(sTag62 == null)
	    {
		sErrMsg = commonLibBO.returnTranslErrorMessage(66769, new String[] { "62" }, sLanguage);
		throw new BOException(sErrMsg);
	    }
	    //HGhazal - add checking on tag 64 - SUPT160154 - 06/06/2016
	    if(sTag64 == null)
	    {
		sErrMsg = commonLibBO.returnTranslErrorMessage(66769, new String[] { "64" }, sLanguage);
		throw new BOException(sErrMsg);
	    }
	    
	    // pb 294 omit plus one since i'm using list instead of datawindow
	    // filling opening balance (row 1)
	    SwiftReconcileCO swiftReconCO = new SwiftReconcileCO();
	    // swiftReconcileCOList = new ArrayList<SwiftReconcileCO>();
	    int iRow, il_max = 0, iPos;
	    iRow = swiftReconcileCOList.size();
	    String sMark, sAccount, sCy, sDate;
	    BigDecimal bdAmount = null;
	    Date dDate;
	    for(iLine = iRow; iLine < iRows + iRow + 1; iLine++)
	    {
		if(iLine < iRows + iRow + 1)
		{
		    SWIFT_HST_RECONCILEVO swiftHstReconcileVO = new SWIFT_HST_RECONCILEVO();
		    swiftReconCO = new SwiftReconcileCO();
		    swiftHstReconcileVO.setTRX_NBR(new BigDecimal(il_max));
		    swiftHstReconcileVO.setTRANSACTION_REF_NO(sTag20);
		    swiftHstReconcileVO.setRELATED_REF(sTag21);
		    swiftHstReconcileVO.setSTATEMENT_NUMBER(bdTag28);
		    swiftHstReconcileVO.setACC_NO(sTag25);
		    swiftHstReconcileVO.setCOMP_CODE(bdAccCompCode);
		    swiftHstReconcileVO.setBRANCH_CODE(bdAccBranchCode);
		    swiftHstReconcileVO.setCURRENCY_CODE(bdCy);
		    swiftReconCO.setDecPoint(bdDecimalPoints);
		    sMark = sTag60.substring(0, 1);
		    sDate = sTag60.substring(1, 7);
		    sDate = sDate.substring(sDate.length() - 2, sDate.length()) + '/' + sDate.substring(2, 4) + '/'
			    + sDate.substring(0, 2);
		    dDate = DateUtil.getFormatedDate(sDate);
		    sCy = sTag60.substring(7, 10);
		    sAmount = sTag60.substring(10);

		    iPos = sAmount.indexOf(',', 1);
		    if(iPos < 0)
		    {
			bdAmount = new BigDecimal(sAmount);
		    }
		    else
		    {
			sAmount = sAmount.replace(',', '.');
			bdAmount = new BigDecimal(sAmount);
		    }
		    if("D".equals(sMark))
		    {
			bdAmount = new BigDecimal(-1 * bdAmount.doubleValue());
		    }

		    if(iLine == iRow)
		    {
			if(bdCy.equals(bdBaseCy))
			{
			    swiftHstReconcileVO.setCV_AMOUNT(bdAmount);
			}
			else
			{
			    swiftHstReconcileVO.setFC_AMOUNT(bdAmount);
			}
		    }
		    swiftHstReconcileVO.setVALUE_DATE(dDate);

		    swiftHstReconcileVO.setTRANS_DATE(dDate);
		    swiftHstReconcileVO.setOB_MARK(sMark);
		    swiftHstReconcileVO.setOB_DATE(dDate);
		    swiftHstReconcileVO.setOB_CY(sCy);
		    swiftHstReconcileVO.setOB_AMOUNT(bdAmount);

		    sMark = sTag62.substring(0, 1);
		    sDate = sTag62.substring(1, 5);
		    sDate = sDate.substring(sDate.length() - 2, sDate.length()) + '/' + sDate.substring(2, 4) + '/'
			    + sDate.substring(0, 2);
		    dDate = DateUtil.getFormatedDate(sDate);
		    sCy = sTag62.substring(7, 10);

		    sAmount = sTag62.substring(10).replace(',', '.');
		    bdAmount = new BigDecimal(sAmount);
		    swiftHstReconcileVO.setCB_MARK(sMark);
		    swiftHstReconcileVO.setCB_DATE(dDate);
		    swiftHstReconcileVO.setCB_CY(sCy);
		    swiftHstReconcileVO.setCB_AMOUNT(bdAmount);

		    sMark = sTag64.substring(0, 1);
		    sDate = sTag64.substring(1, 5);
		    sDate = sDate.substring(sDate.length() - 2, sDate.length()) + '/' + sDate.substring(2, 4) + '/'
			    + sDate.substring(0, 2);
		    dDate = DateUtil.getFormatedDate(sDate);
		    sCy = sTag64.substring(7, 10);

		    sAmount = sTag64.substring(10).replace(',', '.');
		    bdAmount = new BigDecimal(sAmount);
		    swiftHstReconcileVO.setCB_MARK(sMark);
		    swiftHstReconcileVO.setCB_DATE(dDate);
		    swiftHstReconcileVO.setCB_CY(sCy);
		    swiftHstReconcileVO.setCB_AMOUNT(bdAmount);

		    // get account expression
		    sAccount = NumberUtil.addLeadingZeros(bdAccBranchCode, 4) + "-"
			    + NumberUtil.addLeadingZeros(bdCy, 3) + "-";

		    StringBuffer sbAcc = new StringBuffer();
		    sbAcc.append(NumberUtil.format(bdCompCode, "0000"));
		    sbAcc.append("-");
		    sbAcc.append(NumberUtil.format(bdAccBranchCode, "0000"));
		    sbAcc.append("-");
		    sbAcc.append(NumberUtil.format(bdCy, "000"));
		    sbAcc.append("-");
		    sbAcc.append(NumberUtil.format(amfVO.getGL_CODE(), "000000"));
		    sbAcc.append("-");
		    sbAcc.append(NumberUtil.format(amfVO.getCIF_SUB_NO(), "00000000"));
		    sbAcc.append("-");
		    sbAcc.append(NumberUtil.format(amfVO.getSL_NO(), "000"));

		    sAccount = sbAcc.toString();

		    swiftReconCO.setAccount(sAccount);
		    swiftReconCO.setSwiftHstReconcileVO(swiftHstReconcileVO);
		    swiftReconcileCOList.add(swiftReconCO);
		}

	    }

	    int iCell = 0;
	    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setINFORMATION_TO_ACC_OWNER("Opening Bal.");
	    swiftReconcileCOList.get(iRow).setOpBalInd(BigDecimal.ONE);
	    // End filling opening balance (row 1)
	    Date dTrDate;
	    for(iLine = iRow + 1; iLine < iRows + iRow + 1; iLine++)
	    {
		swiftReconcileCOList.get(iLine).setOpBalInd(BigDecimal.ZERO);
		if(iCell < sTag65List.size() && !sTag65List.isEmpty())
		{
		    sMark = sTag65List.get(iCell).toString().substring(0, 1);
		    sDate = sTag65List.get(iCell).toString().substring(1, 7);
		    sDate = sDate.substring(sDate.length() - 2, sDate.length()) + '/' + sDate.substring(2, 4) + '/'
			    + sDate.substring(0, 2);
		    dDate = DateUtil.getFormatedDate(sDate);
		    sCy = sTag65List.get(iCell).toString().substring(7, 10);
		    sAmount = sTag65List.get(iCell).toString().substring(10).replace(',', '.');
		    bdAmount = new BigDecimal(sAmount);

		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setFA_MARK(sMark);
		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setFA_DATE(dDate);
		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setFA_CY(sCy);
		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setFA_AMOUNT(bdAmount);
		}

		if(!sTag61List.isEmpty() && iCell < sTag61List.size() && sTag61List.get(iCell) != null)
		{
		    swiftReconcileCOList.get(iLine).setSubtag6(sSubTag6List.get(iCell).toString());
		    swiftReconcileCOList.get(iLine).setSubtag7(sSubTag7List.get(iCell).toString());
		    swiftReconcileCOList.get(iLine).setSubtag8(sSubTag8List.get(iCell).toString());
		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setSUBTAG9(
			    subTag9List.get(iCell).toString());
		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setSTATMENT_LINE(
			    sTag61List.get(iCell).toString());
		    sDate = sTag61List.get(iCell).toString().substring(0, 6);
		    sDate = sDate.substring(sDate.length() - 2, sDate.length()) + '/' + sDate.substring(2, 4) + '/'
			    + sDate.substring(0, 2);
		    dDate = DateUtil.getFormatedDate(sDate);
		    sTransDate = sTag61List.get(iCell).toString().substring(6, 10);
		    sTransDate = sTransDate.substring(2, 4) + '/' + sTransDate.substring(0, 2) + '/'
			    + sDate.substring(sDate.length() - 2, sDate.length());
		    dTrDate = DateUtil.getFormatedDate(sTransDate);
		    if(dTrDate == null)
		    {
			dTrDate = dDate;
		    }
		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setTRANS_DATE(dTrDate);
		    swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setVALUE_DATE(dDate);

		    if(iCell < sTag86List.size())
		    {
			swiftReconcileCOList.get(iLine).getSwiftHstReconcileVO().setINFORMATION_TO_ACC_OWNER(
				sTag86List.get(iCell).toString());
		    }

		}
		iCell++;
	    }

	    // logic after calling decompose_each_message function
	    String sValueDate, sStmt, sStmtLine = null;
	    Date dValueDate;
	    int iMarkLen, iStart;
	    for(iCounter = 0; iCounter < swiftReconcileCOList.size(); iCounter++)
	    {
		sStmt = swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().getSTATMENT_LINE();

		if(sStmt == null || "".equals(sStmt))
		{
		    continue;
		}
		else
		{
		    sStmtLine = swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().getSTATMENT_LINE();
		    sValueDate = sStmtLine.substring(0, 6);
		    sValueDate = sValueDate.substring(sValueDate.length() - 2, sValueDate.length()) + '/'
			    + sValueDate.substring(2, 4) + '/' + sValueDate.substring(0, 2);
		    dValueDate = DateUtil.getFormatedDate(sValueDate);
		    swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().setVALUE_DATE(dValueDate);

		}

		sMark = sStmtLine.substring(10, 12);
		if("RC".equals(sMark))
		{
		    bEntryDate = true;
		    sMark = "RD";
		}
		else if("RD".equals(sMark))
		{
		    bEntryDate = true;
		    sMark = "RC";
		}
		else
		{
		    sMark = sStmtLine.substring(10, 11);
		    if("C".equals(sMark))
		    {
			bEntryDate = true;
			sMark = "D";
		    }
		    else if("D".equals(sMark))
		    {
			bEntryDate = true;
			sMark = "C";
		    }
		    else
		    {
			sMark = sStmtLine.substring(6, 8);
			if("RC".equals(sMark))
			{
			    bEntryDate = false;
			    sMark = "RD";
			}
			else if("RD".equals(sMark))
			{
			    bEntryDate = false;
			    sMark = "RC";
			}
			else
			{
			    sMark = sStmtLine.substring(6, 7);
			    if("C".equals(sMark))
			    {
				bEntryDate = false;
				sMark = "D";
			    }
			    else if("D".equals(sMark))
			    {
				bEntryDate = false;
				sMark = "C";
			    }
			}
		    }
		}

		sMark = sMark.trim();
		iMarkLen = sMark.length();

		if(bEntryDate)
		{
		    iStart = 10 + iMarkLen;
		}
		else
		{
		    iStart = 6 + iMarkLen;
		}

		sCy = sStmtLine.substring(iStart, iStart + 1);

		for(iCount = iStart; iCount < sStmtLine.length(); iCount++)
		{
		    sCy = sStmtLine.substring(iCount, iCount + 1);
		    if(!NumberUtil.isNumber(sCy) && !",".equals(sCy))
		    {
			break;
		    }
		}

		bdCy = swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().getCURRENCY_CODE();
		sAmount = sStmtLine.substring(iStart, iCount);
		sAmount = sAmount.replace(',', '.');

		if("RC".equals(sMark) || "C".equals(sMark))
		{
		    bdAmount = new BigDecimal(sAmount);
		    bdAmount = bdAmount.multiply(new BigDecimal(-1));
		}
		else if("RD".equals(sMark) || "D".equals(sMark))
		{
		    bdAmount = new BigDecimal(sAmount);
		}

		sStmt = swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().getSTATMENT_LINE();
		if(!"".equals(sStmt) && sStmt != null)
		{
		    if(bdCy.equals(bdBaseCy))
		    {
			swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().setFC_AMOUNT(BigDecimal.ZERO);
			swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().setCV_AMOUNT(bdAmount);
		    }
		    else
		    {
			swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().setFC_AMOUNT(bdAmount);
			swiftReconcileCOList.get(iCounter).getSwiftHstReconcileVO().setCV_AMOUNT(BigDecimal.ZERO);
		    }
		}

	    }
	    // Computed Fields Part
	}
	ArrayList<Map<String, Object>> expMapList = convertSwiftReconcileCOListToMap(swiftReconcileCOList);

	Date minTradeDate, minValueDate, maxTradeDate, maxValueDate;
	String compute3;

	for(int j = 0; j < swiftReconcileCOList.size(); j++)
	{

	    minTradeDate = (Date) commonLibBO.executeExpression("min(trans_date for acc_no)", j, expMapList);
	    maxTradeDate = (Date) commonLibBO.executeExpression("max(trans_date for acc_no)", j, expMapList);
	    minValueDate = (Date) commonLibBO.executeExpression("min(value_date for acc_no)", j, expMapList);
	    maxValueDate = (Date) commonLibBO.executeExpression("max(value_date for acc_no)", j, expMapList);

	    swiftReconcileCOList.get(j).setMinTradeDate(minTradeDate);
	    swiftReconcileCOList.get(j).setMaxTradeDate(maxTradeDate);
	    swiftReconcileCOList.get(j).setMinValueDate(minValueDate);
	    swiftReconcileCOList.get(j).setMaxValueDate(maxValueDate);
	    compute3 = "";
	    if(j > 0 && j != swiftReconcileCOList.size() && bFound61)
	    {
		compute3 = (String) commonLibBO
			.executeExpression(
				"subtag6 + if(subtag7 <>'','-','')  +  subtag7 + if(subtag8 <>'','-','')  +  subtag8 + if(subtag9 <>'','-','') +  subtag9",
				j, expMapList);
		swiftReconcileCOList.get(j).setCompute3(compute3);
	    }
	}

	// check case of SWEN
	if(iEngFlag == 1)
	{
	    String sVtFlag = commonLibBO.returnSwiftCtrlRecValues().getRECON_BY_TDATE().equals(BigDecimal.ONE) ? "T"
		    : "V";
	    String fullMatchCond = commonLibBO.returnSwiftCtrlRecValues().getFULL_MATCH_EXPRESSION();

	    String[] partialMatchCondList = new String[3];
	    partialMatchCondList[0] = commonLibBO.returnSwiftCtrlRecValues().getFIRST_PARTIAL_MATCH();
	    partialMatchCondList[1] = commonLibBO.returnSwiftCtrlRecValues().getSECOND_PARTIAL_MATCH();
	    partialMatchCondList[2] = commonLibBO.returnSwiftCtrlRecValues().getTHIRD_PARTIAL_MATCH();

	    String[] reasonList = new String[5];
	    reasonList[0] = commonLibBO.returnSwiftCtrlRecValues().getFIRST_PARTIAL_REASON();
	    reasonList[1] = commonLibBO.returnSwiftCtrlRecValues().getSECOND_PARTIAL_REASON();
	    reasonList[2] = commonLibBO.returnSwiftCtrlRecValues().getTHIRD_PARTIAL_REASON();
	    reasonList[3] = commonLibBO.returnSwiftCtrlRecValues().getNOT_IN_CORE_REASON();
	    reasonList[4] = commonLibBO.returnSwiftCtrlRecValues().getNOT_IN_FILE_REASON();

	    ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOList = selectBankStmtReconcile(bdCompCode, sVtFlag,
		    swiftReconcileCOList, sLanguage);
	    reconcile(swiftReconcileCOList, swiftReconBankStmtCOList, fullMatchCond, partialMatchCondList, reasonList,
		    sUserId, dtSysDate, "SWEN", "INW001");
	}

	return swiftReconcileCOList;
    }

    public ArrayList<SwiftReconBankStmtCO> selectBankStmtReconcile(BigDecimal bdCompCode, String sVtFlag,
	    ArrayList<SwiftReconcileCO> swiftReconcileCOList, String sLanguage) throws BaseException
    {
	String sErrMsg;
	String[] saTransMsgArr;
	AMFVO amfVO = new AMFVO();
	SwiftReconcileSC swiftReconcileSC = new SwiftReconcileSC();
	ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOAllList = new ArrayList<SwiftReconBankStmtCO>();

	swiftReconcileSC.setCompCode(bdCompCode);

	for(int iAccCount = 0; iAccCount < swiftReconcileCOList.size(); iAccCount++)
	{
	    if(swiftReconcileCOList.get(iAccCount).getOpBalInd().compareTo(BigDecimal.ONE) == 0) // opBalInd=1
	    {
		swiftReconcileSC.setAccNo(swiftReconcileCOList.get(iAccCount).getSwiftHstReconcileVO().getACC_NO());

		if("T".equals(sVtFlag))
		{
		    swiftReconcileSC.setMinDate(swiftReconcileCOList.get(iAccCount).getMinTradeDate());
		    swiftReconcileSC.setMaxDate(swiftReconcileCOList.get(iAccCount).getMaxTradeDate());
		}
		else
		{
		    swiftReconcileSC.setMinDate(swiftReconcileCOList.get(iAccCount).getMinValueDate());
		    swiftReconcileSC.setMaxDate(swiftReconcileCOList.get(iAccCount).getMaxValueDate());
		}
		swiftReconcileSC.setVtFlag(sVtFlag);
		
		amfVO = swiftReconDAO.selectAccountNoDet(swiftReconcileSC);

		if(amfVO == null)
		{
		    saTransMsgArr = commonLibBO.returnTranslMessage(66765, sLanguage);
		    throw new BOException(saTransMsgArr[0]);
		}
		
		swiftReconcileSC.setBrCode(amfVO.getBRANCH_CODE());//efarah ABARS160042
		swiftReconcileSC.setCyCode(amfVO.getCURRENCY_CODE());
		swiftReconcileSC.setGlCode(amfVO.getGL_CODE());
		swiftReconcileSC.setCifNo(amfVO.getCIF_SUB_NO());
		swiftReconcileSC.setSlNo(amfVO.getSL_NO());
		
		ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOList = swiftReconDAO
			.selectBankStmtReconcile(swiftReconcileSC);
		if(swiftReconBankStmtCOList == null)
		{
		    sErrMsg = commonLibBO.returnTranslErrorMessage(66767, new String[] { swiftReconcileSC.getAccNo() },
			    sLanguage);
		    throw new BOException(sErrMsg);

		}
		if(swiftReconBankStmtCOList.isEmpty())
		{
		    sErrMsg = commonLibBO.returnTranslErrorMessage(66767, new String[] { swiftReconcileSC.getAccNo() },
			    sLanguage);
		    throw new BOException(sErrMsg);

		}

		// if(swiftReconBankStmtCOList != null)
		// {
		swiftReconBankStmtCOAllList.addAll(swiftReconBankStmtCOList);
		// }
		// }

		// creating first row for Opening balance
		SwiftReconcileSC swiftReconcileBalSC = new SwiftReconcileSC();
		SwiftReconBankStmtCO bankStmtCO = new SwiftReconBankStmtCO();
		ArrayList<SwiftReconBankStmtCO> swiftbalanceCOList;

		swiftReconcileBalSC.setCompCode(bdCompCode);
		swiftReconcileBalSC.setBrCode(swiftReconBankStmtCOList.get(0).getHstVO().getBRANCH_CODE());
		swiftReconcileBalSC.setCyCode(swiftReconBankStmtCOList.get(0).getHstVO().getCURRENCY_CODE());
		swiftReconcileBalSC.setGlCode(swiftReconBankStmtCOList.get(0).getHstVO().getGL_CODE());
		swiftReconcileBalSC.setCifNo(swiftReconBankStmtCOList.get(0).getHstVO().getCIF_SUB_NO());
		swiftReconcileBalSC.setSlNo(swiftReconBankStmtCOList.get(0).getHstVO().getSL_NO());

		bankStmtCO.getHstVO().setCOMP_CODE(bdCompCode);
		bankStmtCO.getHstVO().setBRANCH_CODE(swiftReconBankStmtCOList.get(0).getHstVO().getBRANCH_CODE());
		bankStmtCO.getHstVO().setCURRENCY_CODE(swiftReconBankStmtCOList.get(0).getHstVO().getCURRENCY_CODE());
		bankStmtCO.getHstVO().setGL_CODE(swiftReconBankStmtCOList.get(0).getHstVO().getGL_CODE());
		bankStmtCO.getHstVO().setCIF_SUB_NO(swiftReconBankStmtCOList.get(0).getHstVO().getCIF_SUB_NO());
		bankStmtCO.getHstVO().setSL_NO(swiftReconBankStmtCOList.get(0).getHstVO().getSL_NO());

		bankStmtCO.setAccNo(swiftReconcileCOList.get(iAccCount).getSwiftHstReconcileVO().getACC_NO());

		if("T".equals(sVtFlag))
		{
		    bankStmtCO.getHstVO().setTRANS_DATE(swiftReconcileCOList.get(iAccCount).getMinTradeDate());
		    bankStmtCO.getHstVO().setVALUE_DATE(swiftReconcileCOList.get(iAccCount).getMinTradeDate());
		    swiftReconcileBalSC.setMinDate(swiftReconcileCOList.get(iAccCount).getMinTradeDate());
		    swiftbalanceCOList = selectOpeningBalT(swiftReconcileBalSC);
		    bankStmtCO.getHstVO().setCV_AMOUNT(swiftbalanceCOList.get(0).getHstVO().getCV_AMOUNT());
		    bankStmtCO.getHstVO().setFC_AMOUNT(swiftbalanceCOList.get(0).getHstVO().getFC_AMOUNT());
		}
		else
		{
		    bankStmtCO.getHstVO().setTRANS_DATE(swiftReconcileCOList.get(iAccCount).getMinValueDate());
		    bankStmtCO.getHstVO().setVALUE_DATE(swiftReconcileCOList.get(iAccCount).getMinValueDate());
		    swiftReconcileBalSC.setMinDate(swiftReconcileCOList.get(iAccCount).getMinValueDate());
		    swiftbalanceCOList = selectOpeningBalV(swiftReconcileBalSC);
		    bankStmtCO.getHstVO().setCV_AMOUNT(swiftbalanceCOList.get(0).getHstVO().getCV_AMOUNT());
		    bankStmtCO.getHstVO().setFC_AMOUNT(swiftbalanceCOList.get(0).getHstVO().getFC_AMOUNT());
		}

		// lds_reconcile.SetItem(ll_row,'decimal_points',lstr_recon[ll_ctr2].decimal_points)
		bankStmtCO.setReconInd(BigDecimal.ZERO);
		bankStmtCO.setOpBalInd(BigDecimal.ONE);

		swiftbalanceCOList = new ArrayList<SwiftReconBankStmtCO>();
		swiftbalanceCOList.add(bankStmtCO);
		swiftReconBankStmtCOAllList.addAll(
			swiftReconBankStmtCOAllList.size() - swiftReconBankStmtCOList.size(), swiftbalanceCOList);

		// end creating first row for Opening balance
	    }
	}
	// computing the acc_no
	for(int i = 0; i < swiftReconBankStmtCOAllList.size(); i++)
	{
	    StringBuffer sbAcc = new StringBuffer();
	    sbAcc.append(NumberUtil.format(bdCompCode, "0000"));
	    sbAcc.append("-");
	    sbAcc.append(NumberUtil.format(swiftReconBankStmtCOAllList.get(i).getHstVO().getBRANCH_CODE(), "0000"));
	    sbAcc.append("-");
	    sbAcc.append(NumberUtil.format(swiftReconBankStmtCOAllList.get(i).getHstVO().getCURRENCY_CODE(), "000"));
	    sbAcc.append("-");
	    sbAcc.append(NumberUtil.format(swiftReconBankStmtCOAllList.get(i).getHstVO().getGL_CODE(), "000000"));
	    sbAcc.append("-");
	    sbAcc.append(NumberUtil.format(swiftReconBankStmtCOAllList.get(i).getHstVO().getCIF_SUB_NO(), "00000000"));
	    sbAcc.append("-");
	    sbAcc.append(NumberUtil.format(swiftReconBankStmtCOAllList.get(i).getHstVO().getSL_NO(), "000"));

	    swiftReconBankStmtCOAllList.get(i).setAccNo(sbAcc.toString());
	}

	return swiftReconBankStmtCOAllList;
    }

    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalT(SwiftReconcileSC swiftReconcileSC) throws BaseException
    {
	return swiftReconDAO.selectOpeningBalT(swiftReconcileSC);

    }

    public ArrayList<SwiftReconBankStmtCO> selectOpeningBalV(SwiftReconcileSC swiftReconcileSC) throws BaseException
    {
	return swiftReconDAO.selectOpeningBalV(swiftReconcileSC);

    }

    public ArrayList<SwiftReconcileCO> reconcile(ArrayList<SwiftReconcileCO> swiftReconcileCOListIn,
	    ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOListIn, String fullMatchCond,
	    String[] partialMatchCondList, String[] reasonList, String sUserId, Date dtRunDate, String sAppName,
	    String sPageRef) throws BaseException
    {
	String sReconInd, fullMatchCondRow0 = fullMatchCond, fullMatchCondRows = fullMatchCond, lsVar = "",fullMatchCondRowsorg=fullMatchCond;
	String[] partialMatchCondListRow0 = { "a", "b", "c" }, partialMatchCondListRows = { "a", "b", "c" };
	ArrayList<SwiftReconcileCO> swiftReconcileCOFinalList = new ArrayList<SwiftReconcileCO>();
	Object oReconInd;
	boolean bMatch = false;
	ArrayList<SwiftReconcileCO> swiftReconcileCOList = swiftReconcileCOListIn;
	ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOList = swiftReconBankStmtCOListIn;

	for(int j = 0; j < partialMatchCondList.length; j++)
	{
	    partialMatchCondListRow0[j] = partialMatchCondList[j];
	    partialMatchCondListRows[j] = partialMatchCondList[j];
	}

	Boolean bOpBal = false;
	ArrayList<ArrayList<SwiftReconBankStmtCO>> swiftReconBankStmtCOAllSubList = new ArrayList<ArrayList<SwiftReconBankStmtCO>>();
	ArrayList<ArrayList<SwiftReconcileCO>> swiftReconcileCOAllSubList = new ArrayList<ArrayList<SwiftReconcileCO>>();
	ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOSubList = new ArrayList<SwiftReconBankStmtCO>();
	ArrayList<SwiftReconcileCO> swiftReconcileCOSubList = new ArrayList<SwiftReconcileCO>();

	// divide swiftReconcileCOList into sub lists group by acc_no and put
	// them in swiftReconcileCOAllSubList
	for(int iListCount1 = 0; iListCount1 < swiftReconcileCOList.size(); iListCount1++)
	{
	    if(swiftReconcileCOList.get(iListCount1).getOpBalInd().compareTo(BigDecimal.ONE) == 0)
	    {
		bOpBal = false;
		if(!swiftReconcileCOSubList.isEmpty())
		{
		    swiftReconcileCOAllSubList.add(swiftReconcileCOSubList);
		}
		swiftReconcileCOSubList = new ArrayList<SwiftReconcileCO>();
		bOpBal = true;

	    }
	    if(bOpBal)
	    {
		swiftReconcileCOSubList.add(swiftReconcileCOList.get(iListCount1));
	    }
	}
	swiftReconcileCOAllSubList.add(swiftReconcileCOSubList);

	// divide swiftReconBankStmtCOList into sub lists group by acc_no and
	// put them in swiftReconBankStmtCOAllSubList
	for(int iListCount2 = 0; iListCount2 < swiftReconBankStmtCOList.size(); iListCount2++)
	{
	    if(swiftReconBankStmtCOList.get(iListCount2).getOpBalInd().compareTo(BigDecimal.ONE) == 0)
	    {
		bOpBal = false;
		if(!swiftReconBankStmtCOSubList.isEmpty())
		{
		    swiftReconBankStmtCOAllSubList.add(swiftReconBankStmtCOSubList);
		}
		swiftReconBankStmtCOSubList = new ArrayList<SwiftReconBankStmtCO>();
		bOpBal = true;

	    }
	    if(bOpBal)
	    {
		swiftReconBankStmtCOSubList.add(swiftReconBankStmtCOList.get(iListCount2));
	    }
	}
	swiftReconBankStmtCOAllSubList.add(swiftReconBankStmtCOSubList);

	for(int isubListCount1 = 0; isubListCount1 < swiftReconcileCOAllSubList.size(); isubListCount1++)
	{
	    for(int isubListCount2 = 0; isubListCount2 < swiftReconBankStmtCOAllSubList.size(); isubListCount2++)
	    {

		swiftReconcileCOList = swiftReconcileCOAllSubList.get(isubListCount1);
		swiftReconBankStmtCOList = swiftReconBankStmtCOAllSubList.get(isubListCount2);

		if(swiftReconcileCOList.get(0).getAccount().equals(swiftReconBankStmtCOList.get(0).getAccNo()))
		{

		    ArrayList<Map<String, Object>> swiftReconBankStmtCOMap = convertswiftReconBankStmtCOListToMap(swiftReconBankStmtCOList);

		    // check if opening balance is matching: row0 in dw1 matches
		    // with
		    // row0
		    // in dw2

		    // adjust the matching expressions: replace the CV_AMOUNT_F
		    // by
		    // swiftHstReconcileVO.CV_AMOUNT...
		    fullMatchCondRow0 = fullMatchCondRow0.replace("CV_AMOUNT_F", 
		    		BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getCV_AMOUNT(), "0")).doubleValue()).toString());
		    fullMatchCondRow0 = fullMatchCondRow0.replace("FC_AMOUNT_F", 
		    		BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getFC_AMOUNT(), "0")).doubleValue()).toString());
		    fullMatchCondRow0 = fullMatchCondRow0.replace("TRANS_DATE_F", "Date('".concat(
			    DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList.get(0)
				    .getSwiftHstReconcileVO().getTRANS_DATE()), "dd/MM/yyyy")).concat("')"));
		    fullMatchCondRow0 = fullMatchCondRow0.replace("VALUE_DATE_F", "Date('".concat(
			    DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList.get(0)
				    .getSwiftHstReconcileVO().getVALUE_DATE()), "dd/MM/yyyy")).concat("')"));
		    if(swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getSUBTAG9() == null)
		    {
			lsVar = "''";
		    }
		    else
		    {
			lsVar = "'".concat(swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getSUBTAG9()).concat(
				"'");
		    }
		    fullMatchCondRow0 = fullMatchCondRow0.replace("DESCRIPTION_F", lsVar);
		    lsVar = "";

		    oReconInd = commonLibBO.executeExpression(fullMatchCondRow0, 0, swiftReconBankStmtCOMap);
		    sReconInd = StringUtil.nullToEmpty(oReconInd).toString();
		    if("true".equals(sReconInd))
		    { // FULL MATCH
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setCURRENCY_CODE(
				swiftReconBankStmtCOList.get(0).getHstVO().getCURRENCY_CODE());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setGL_CODE(
				swiftReconBankStmtCOList.get(0).getHstVO().getGL_CODE());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setCIF_SUB_NO(
				swiftReconBankStmtCOList.get(0).getHstVO().getCIF_SUB_NO());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setSL_NO(
				swiftReconBankStmtCOList.get(0).getHstVO().getSL_NO());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setJV_REF(
				swiftReconBankStmtCOList.get(0).getHstVO().getJV_REF());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setDESCRIPTION(
				swiftReconBankStmtCOList.get(0).getHstVO().getDESCRIPTION());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setCHQ_SRL(
				swiftReconBankStmtCOList.get(0).getHstVO().getCHQ_SRL());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setEXCH_RATE(
				swiftReconBankStmtCOList.get(0).getHstVO().getEXCH_RATE());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setOP_STATUS(
				swiftReconBankStmtCOList.get(0).getHstVO().getOP_STATUS());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setBC_FLAG(
				swiftReconBankStmtCOList.get(0).getHstVO().getBC_FLAG());
			swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setRECONCILE_IND("A");
			swiftReconcileCOList.get(0).setReconInd(BigDecimal.ONE);
			swiftReconBankStmtCOList.get(0).setReconInd(BigDecimal.ONE);
			bMatch = true;
		    }
		    else
		    { // PARTIAL MATCH
			for(int i = 0; i < partialMatchCondListRow0.length; i++)
			{
			    // adjust the matching expressions: replace the
			    // CV_AMOUNT_F
			    // by
			    // swiftHstReconcileVO.CV_AMOUNT...
			    if(!"".equals(StringUtil.nullToEmpty(partialMatchCondListRow0[i])))
			    {
				partialMatchCondListRow0[i] = partialMatchCondListRow0[i].replace("CV_AMOUNT_F",//TURN_OFF_WARNINGS
						BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getCV_AMOUNT(), "0")).doubleValue()).toString());
				partialMatchCondListRow0[i] = partialMatchCondListRow0[i].replace("FC_AMOUNT_F",//TURN_OFF_WARNINGS
						BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getFC_AMOUNT(), "0")).doubleValue()).toString());
				partialMatchCondListRow0[i] = partialMatchCondListRow0[i].replace("TRANS_DATE_F",//TURN_OFF_WARNINGS
					"Date('".concat(
						DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList.get(0)
							.getSwiftHstReconcileVO().getTRANS_DATE()), "dd/MM/yyyy"))
						.concat("')"));
				partialMatchCondListRow0[i] = partialMatchCondListRow0[i].replace("VALUE_DATE_F",//TURN_OFF_WARNINGS
					"Date('".concat(
						DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList.get(0)
							.getSwiftHstReconcileVO().getVALUE_DATE()), "dd/MM/yyyy"))
						.concat("')"));
				if(swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getSUBTAG9() == null)
				{
				    lsVar = "''";
				}
				else
				{
				    lsVar = "'".concat(
					    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getSUBTAG9()).concat(
					    "'");
				}
				partialMatchCondListRow0[i] = partialMatchCondListRow0[i].replace("DESCRIPTION_F",//TURN_OFF_WARNINGS
					lsVar);
				lsVar = "";

				// executing the expressions
				oReconInd = commonLibBO.executeExpression(partialMatchCondListRow0[i], 0,
					swiftReconBankStmtCOMap);
				sReconInd = StringUtil.nullToEmpty(oReconInd).toString();

				if("true".equals(sReconInd))
				{
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setREASON(reasonList[i]);
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setRECONCILE_IND("N");
				    swiftReconcileCOList.get(0).setReconInd(BigDecimal.ONE);
				    swiftReconBankStmtCOList.get(0).setReconInd(BigDecimal.ONE);
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setCURRENCY_CODE(
					    swiftReconBankStmtCOList.get(0).getHstVO().getCURRENCY_CODE());
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setGL_CODE(
					    swiftReconBankStmtCOList.get(0).getHstVO().getGL_CODE());
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setCIF_SUB_NO(
					    swiftReconBankStmtCOList.get(0).getHstVO().getCIF_SUB_NO());
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setSL_NO(
					    swiftReconBankStmtCOList.get(0).getHstVO().getSL_NO());
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setOP_STATUS("A");
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setBC_FLAG("B");
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setADD_DATE1(
					    swiftReconBankStmtCOList.get(0).getHstVO().getTRANS_DATE());
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setADD_DATE2(
					    swiftReconBankStmtCOList.get(0).getHstVO().getVALUE_DATE());

				    bMatch = true;
				    break;
				}
			    }
			}
			if(!bMatch)// not found
			{
			    // not in iMAL
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setREASON(
				    reasonList[reasonList.length - 2]);

			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setRECONCILE_IND("N");
			    swiftReconcileCOList.get(0).setReconInd(BigDecimal.ONE);
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setADD_STRING2("2");
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setOP_STATUS("A");
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setBC_FLAG("B");
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setCURRENCY_CODE(
				    swiftReconBankStmtCOList.get(0).getHstVO().getCURRENCY_CODE());
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setGL_CODE(
				    swiftReconBankStmtCOList.get(0).getHstVO().getGL_CODE());
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setCIF_SUB_NO(
				    swiftReconBankStmtCOList.get(0).getHstVO().getCIF_SUB_NO());
			    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().setSL_NO(
				    swiftReconBankStmtCOList.get(0).getHstVO().getSL_NO());
			}
		    }
		    // end check if opening balance is matching: row1 in dw1
		    // matches
		    // with
		    // row1 in dw2

		    // loop on each row in dw1 and find it on dw2 starting from
		    // row
		    // 1 to
		    // exclude opening balance row

		    for(int iRow = 1; iRow < swiftReconcileCOList.size(); iRow++)
		    {
			// adjust the matching expressions: replace the
			// CV_AMOUNT_F
			// by
			// swiftHstReconcileVO.CV_AMOUNT...
		    bMatch = false;
		    fullMatchCondRows = fullMatchCondRowsorg;
			fullMatchCondRows = fullMatchCondRows.replace("CV_AMOUNT_F",
				BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().getCV_AMOUNT(), "0")).doubleValue()).toString());
			fullMatchCondRows = fullMatchCondRows.replace("FC_AMOUNT_F",
				BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().getFC_AMOUNT(), "0")).doubleValue()).toString());
			fullMatchCondRows = fullMatchCondRows.replace("TRANS_DATE_F", "Date('".concat(
				DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList.get(iRow)
					.getSwiftHstReconcileVO().getTRANS_DATE()), "dd/MM/yyyy")).concat("')"));
			fullMatchCondRows = fullMatchCondRows.replace("VALUE_DATE_F", "Date('".concat(
				DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList.get(iRow)
					.getSwiftHstReconcileVO().getVALUE_DATE()), "dd/MM/yyyy")).concat("')"));
			if(swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().getSUBTAG9() == null)
			{
			    lsVar = "''";
			}
			else
			{
			    lsVar = "'".concat(swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().getSUBTAG9())
				    .concat("'");
			}
			fullMatchCondRows = fullMatchCondRows.replace("DESCRIPTION_F", lsVar);
			lsVar = "";

			for(int iCount = 1; iCount < swiftReconBankStmtCOList.size(); iCount++)
			{
				if (swiftReconBankStmtCOList.get(iCount).getReconInd().equals(BigDecimal.ONE))
				{
					continue;
				}
			    // executing expressions
				CachedConstantsCommon.expressionCodesMap = null;
				
			    oReconInd = commonLibBO.executeExpression(fullMatchCondRows, iCount,
				    swiftReconBankStmtCOMap);
			    sReconInd = StringUtil.nullToEmpty(oReconInd).toString();

			    if("true".equals(sReconInd))
			    { // FULL MATCH
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setCURRENCY_CODE(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getCURRENCY_CODE());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setGL_CODE(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getGL_CODE());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setCIF_SUB_NO(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getCIF_SUB_NO());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setSL_NO(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getSL_NO());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setJV_REF(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getJV_REF());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setDESCRIPTION(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getDESCRIPTION());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setCHQ_SRL(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getCHQ_SRL());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setEXCH_RATE(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getEXCH_RATE());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setOP_STATUS(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getOP_STATUS());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setBC_FLAG(
					swiftReconBankStmtCOList.get(iCount).getHstVO().getBC_FLAG());
				swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setRECONCILE_IND("A");
				swiftReconcileCOList.get(iRow).setReconInd(BigDecimal.ONE);
				swiftReconBankStmtCOList.get(iCount).setReconInd(BigDecimal.ONE);//eeeeeeeee
				bMatch = true;
				break;
			    }
			    else
			    { // PARTIAL MATCH
				for(int i = 0; i < partialMatchCondListRows.length; i++)
				{
				    // adjust the matching expressions: replace
				    // the
				    // CV_AMOUNT_F by
				    // swiftHstReconcileVO.CV_AMOUNT...
				    if(!"".equals(StringUtil.nullToEmpty(partialMatchCondListRows[i])))
				    {

					partialMatchCondListRows[i] = partialMatchCondListRows[i].replace("CV_AMOUNT_F",//TURN_OFF_WARNINGS
						BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().getCV_AMOUNT(), "0")).doubleValue()).toString());
					partialMatchCondListRows[i] = partialMatchCondListRows[i].replace("FC_AMOUNT_F",//TURN_OFF_WARNINGS
						BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().getFC_AMOUNT(), "0")).doubleValue()).toString());
					partialMatchCondListRows[i] = partialMatchCondListRows[i].replace(//TURN_OFF_WARNINGS
						"TRANS_DATE_F", "Date('".concat(
							DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList
								.get(iRow).getSwiftHstReconcileVO().getTRANS_DATE()),
								"dd/MM/yyyy")).concat("')"));
					partialMatchCondListRows[i] = partialMatchCondListRows[i].replace(
						"VALUE_DATE_F", "Date('".concat(
							DateUtil.format(DateUtil.nullToInitDate(swiftReconcileCOList
								.get(iRow).getSwiftHstReconcileVO().getVALUE_DATE()),
								"dd/MM/yyyy")).concat("')"));
					if(swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().getSUBTAG9() == null)
					{
					    lsVar = "''";
					}
					else
					{
					    lsVar = "'".concat(
						    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO()
							    .getSUBTAG9()).concat("'");
					}
					partialMatchCondListRows[i] = partialMatchCondListRows[i].replace(
						"DESCRIPTION_F", lsVar);
					lsVar = "";
					// executing expressions
					oReconInd = commonLibBO.executeExpression(partialMatchCondListRows[i], iCount,
						swiftReconBankStmtCOMap);
					sReconInd = StringUtil.nullToEmpty(oReconInd).toString();

					if("true".equals(sReconInd))
					{
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setREASON(
						    reasonList[i]);
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setRECONCILE_IND(
						    "N");
					    swiftReconcileCOList.get(iRow).setReconInd(BigDecimal.ONE);
					    swiftReconBankStmtCOList.get(iCount).setReconInd(BigDecimal.ONE);
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setCURRENCY_CODE(
						    swiftReconBankStmtCOList.get(iCount).getHstVO().getCURRENCY_CODE());
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setGL_CODE(
						    swiftReconBankStmtCOList.get(iCount).getHstVO().getGL_CODE());
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setCIF_SUB_NO(
						    swiftReconBankStmtCOList.get(iCount).getHstVO().getCIF_SUB_NO());
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setSL_NO(
						    swiftReconBankStmtCOList.get(iCount).getHstVO().getSL_NO());
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setOP_STATUS("A");
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setBC_FLAG("B");
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setADD_DATE1(
						    swiftReconBankStmtCOList.get(iCount).getHstVO().getTRANS_DATE());
					    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setADD_DATE2(
						    swiftReconBankStmtCOList.get(iCount).getHstVO().getVALUE_DATE());

					    bMatch = true;
					    break; // exit remaining matching
					    // conditions
					}
				    }
				}
			    }
			    if(bMatch)
			    {
				// exit the loop of grid2
				break;
			    }
			}
			if(!bMatch)// not found
			{
			    // not in iMAL
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setREASON(
				    reasonList[reasonList.length - 2]);
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setRECONCILE_IND("N");
			    swiftReconcileCOList.get(iRow).setReconInd(BigDecimal.ONE);
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setADD_STRING2("2");
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setOP_STATUS("A");
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setBC_FLAG("B");
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setCURRENCY_CODE(
				    swiftReconBankStmtCOList.get(0).getHstVO().getCURRENCY_CODE());
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setGL_CODE(
				    swiftReconBankStmtCOList.get(0).getHstVO().getGL_CODE());
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setCIF_SUB_NO(
				    swiftReconBankStmtCOList.get(0).getHstVO().getCIF_SUB_NO());
			    swiftReconcileCOList.get(iRow).getSwiftHstReconcileVO().setSL_NO(
				    swiftReconBankStmtCOList.get(0).getHstVO().getSL_NO());
			}

		    }

		    // move unmatched rows in dw2 to dw1
		    int swiftReconcileCOListSize = swiftReconcileCOList.size();

		    for(int i = 0; i < swiftReconBankStmtCOList.size(); i++)
		    {
			if(NumberUtil.nullToZero(swiftReconBankStmtCOList.get(i).getReconInd()).compareTo(
				BigDecimal.ZERO) == 0
				&& NumberUtil.nullToZero(swiftReconBankStmtCOList.get(i).getOpBalInd()).compareTo(
					BigDecimal.ONE) != 0)
			{
			    SwiftReconcileCO swiftReconcileCO = new SwiftReconcileCO();
			    swiftReconcileCO.getSwiftHstReconcileVO().setOP_STATUS(
				    swiftReconBankStmtCOList.get(i).getHstVO().getOP_STATUS());
			    swiftReconcileCO.getSwiftHstReconcileVO().setBC_FLAG(
				    swiftReconBankStmtCOList.get(i).getHstVO().getBC_FLAG());
			    swiftReconcileCO.getSwiftHstReconcileVO().setCOMP_CODE(
				    swiftReconBankStmtCOList.get(i).getHstVO().getCOMP_CODE());
			    swiftReconcileCO.getSwiftHstReconcileVO().setBRANCH_CODE(
				    swiftReconBankStmtCOList.get(i).getHstVO().getBRANCH_CODE());
			    swiftReconcileCO.getSwiftHstReconcileVO().setCURRENCY_CODE(
				    swiftReconBankStmtCOList.get(i).getHstVO().getCURRENCY_CODE());
			    swiftReconcileCO.getSwiftHstReconcileVO().setGL_CODE(
				    swiftReconBankStmtCOList.get(i).getHstVO().getGL_CODE());
			    swiftReconcileCO.getSwiftHstReconcileVO().setCIF_SUB_NO(
				    swiftReconBankStmtCOList.get(i).getHstVO().getCIF_SUB_NO());
			    swiftReconcileCO.getSwiftHstReconcileVO().setSL_NO(
				    swiftReconBankStmtCOList.get(i).getHstVO().getSL_NO());
			    swiftReconcileCO.getSwiftHstReconcileVO().setOP_NO(
				    swiftReconBankStmtCOList.get(i).getHstVO().getOP_NO().add(BigDecimal.ONE));
			    swiftReconcileCO.getSwiftHstReconcileVO().setLINE_NO(
				    swiftReconBankStmtCOList.get(i).getHstVO().getLINE_NO().add(BigDecimal.ONE));
			    swiftReconcileCO.setAccount(swiftReconBankStmtCOList.get(i).getAccNo());
			    swiftReconcileCO.getSwiftHstReconcileVO().setACC_NO(
				    swiftReconcileCOList.get(0).getSwiftHstReconcileVO().getACC_NO());
			    swiftReconcileCO.getSwiftHstReconcileVO().setJV_REF(
				    swiftReconBankStmtCOList.get(i).getHstVO().getJV_REF());
			    swiftReconcileCO.getSwiftHstReconcileVO().setCHQ_SRL(
				    swiftReconBankStmtCOList.get(i).getHstVO().getCHQ_SRL());
			    swiftReconcileCO.getSwiftHstReconcileVO().setTRANS_DATE(
				    swiftReconBankStmtCOList.get(i).getHstVO().getTRANS_DATE());
			    swiftReconcileCO.getSwiftHstReconcileVO().setVALUE_DATE(
				    swiftReconBankStmtCOList.get(i).getHstVO().getVALUE_DATE());
			    swiftReconcileCO.getSwiftHstReconcileVO().setFC_AMOUNT(
				    swiftReconBankStmtCOList.get(i).getHstVO().getFC_AMOUNT());
			    swiftReconcileCO.getSwiftHstReconcileVO().setCV_AMOUNT(
				    swiftReconBankStmtCOList.get(i).getHstVO().getCV_AMOUNT());
			    swiftReconcileCO.getSwiftHstReconcileVO().setEXCH_RATE(
				    swiftReconBankStmtCOList.get(i).getHstVO().getEXCH_RATE());
			    swiftReconcileCO.getSwiftHstReconcileVO().setTRANSACTION_REF_NO(
				    swiftReconcileCOList.get(swiftReconcileCOListSize - 1).getSwiftHstReconcileVO()
					    .getTRANSACTION_REF_NO());
			    swiftReconcileCO.getSwiftHstReconcileVO().setRELATED_REF(
				    swiftReconcileCOList.get(swiftReconcileCOListSize - 1).getSwiftHstReconcileVO()
					    .getRELATED_REF());
			    swiftReconcileCO.getSwiftHstReconcileVO().setADD_STRING2("1");
			    swiftReconcileCO.getSwiftHstReconcileVO().setRECONCILE_IND("N");
			    swiftReconcileCO.setOpBalInd(swiftReconBankStmtCOList.get(i).getOpBalInd());
			    // not in file reason
			    swiftReconcileCO.getSwiftHstReconcileVO().setREASON(reasonList[reasonList.length - 1]);

			    swiftReconcileCOList.add(swiftReconcileCO);
			}
		    }

		    // uf_save_recon
		    BigDecimal bdOpNo = BigDecimal.ZERO, bdLineNo = BigDecimal.ZERO;
		    String sNextAcc = "";

		    BigDecimal bdTrxNo = commonLibBO.returnIBISCOUNTER(BigDecimal.ZERO, BigDecimal.ZERO, "REC",
			    sUserId, sAppName, sPageRef);

		    for(int i = 0; i < swiftReconcileCOList.size(); i++)
		    {
			String sPrevAcc = swiftReconcileCOList.get(i).getSwiftHstReconcileVO().getACC_NO();
			if(i != swiftReconcileCOList.size() - 1)
			{
			    sNextAcc = swiftReconcileCOList.get(i + 1).getSwiftHstReconcileVO().getACC_NO();
			}

			bdOpNo = bdOpNo.add(BigDecimal.ONE);
			bdLineNo = bdLineNo.add(BigDecimal.ONE);
			swiftReconcileCOList.get(i).getSwiftHstReconcileVO().setOP_NO(bdOpNo);
			swiftReconcileCOList.get(i).getSwiftHstReconcileVO().setLINE_NO(bdLineNo);
			swiftReconcileCOList.get(i).getSwiftHstReconcileVO().setTRX_NBR(bdTrxNo);

			if(!sPrevAcc.equals(sNextAcc))
			{
			    bdTrxNo = commonLibBO.returnIBISCOUNTER(BigDecimal.ZERO, BigDecimal.ZERO, "REC", sUserId,
				    sAppName, sPageRef);
			    bdOpNo = BigDecimal.ZERO;
			    bdLineNo = BigDecimal.ZERO;
			}
			swiftReconcileCOList.get(i).getSwiftHstReconcileVO().setRECONCILED_DT(dtRunDate);
			swiftReconcileCOList.get(i).getSwiftHstReconcileVO().setRECONCILED_BY(sUserId);
			swiftReconcileCOList.get(i).getSwiftHstReconcileVO().setDATE_MODIFIED(dtRunDate);
			swiftReconcileCOList.get(i).getSwiftHstReconcileVO().setCREATED_BY(sUserId);

		    }
		    swiftReconcileCOFinalList.addAll(swiftReconcileCOList);
		}
	    }
	}
	return swiftReconcileCOFinalList;
    }

    private ArrayList<Map<String, Object>> convertSwiftReconcileCOListToMap(ArrayList<SwiftReconcileCO> swiftReconCOList)
	    throws BaseException
    {
	ArrayList<Map<String, Object>> reconMapList = new ArrayList<Map<String, Object>>();
	Map<String, Object> hm;
	for(SwiftReconcileCO swiftReconCO : swiftReconCOList)
	{
	    hm = new HashMap<String, Object>();
	    hm.put("value_date", swiftReconCO.getSwiftHstReconcileVO().getVALUE_DATE());
	    hm.put("trans_date", swiftReconCO.getSwiftHstReconcileVO().getTRANS_DATE());
	    hm.put("acc_no", swiftReconCO.getSwiftHstReconcileVO().getACC_NO());
	    hm.put("subtag6", swiftReconCO.getSubtag6());
	    hm.put("subtag7", swiftReconCO.getSubtag7());
	    hm.put("subtag8", swiftReconCO.getSubtag8());
	    hm.put("subtag9", swiftReconCO.getSwiftHstReconcileVO().getSUBTAG9());
	    reconMapList.add(hm);
	}
	return reconMapList;
    }

    private ArrayList<Map<String, Object>> convertswiftReconBankStmtCOListToMap(
	    ArrayList<SwiftReconBankStmtCO> swiftReconBankStmtCOList) throws BaseException
    {
	ArrayList<Map<String, Object>> swiftReconBankStmtCOMap = new ArrayList<Map<String, Object>>();
	Map<String, Object> hm;
	for(int i = 0; i < swiftReconBankStmtCOList.size(); i++)
	{
	    hm = new HashMap<String, Object>();
	    hm.put("hstVO", swiftReconBankStmtCOList.get(i).getHstVO());
	    hm.put("srlNo", swiftReconBankStmtCOList.get(i).getSrlNo());
	    hm.put("reconSet", swiftReconBankStmtCOList.get(i).getReconSet());
	    hm.put("dateOrder", swiftReconBankStmtCOList.get(i).getDateOrder());
	    hm.put("bfFc", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getBfFc(), "0")).doubleValue()));
	    hm.put("bfCv", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getBfCv(), "0")).doubleValue()));
	    hm.put("opBal", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getOpBal(), "0")).doubleValue()));
	    hm.put("reconInd", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getReconInd(), "0")).doubleValue()));
	    hm.put("opBalInd", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getOpBalInd(), "0")).doubleValue()));
	    hm.put("accNo", swiftReconBankStmtCOList.get(i).getAccNo());
	    hm.put("decPoint", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getDecPoint(), "0")).doubleValue()));
	    hm.put("trxRef", swiftReconBankStmtCOList.get(i).getTrxRef());
	    hm.put("CV_AMOUNT_I", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getHstVO().getCV_AMOUNT(), "0")).doubleValue()));
	    hm.put("FC_AMOUNT_I", BigDecimal.valueOf(new BigDecimal(StringUtil.nullEmptyToValue(swiftReconBankStmtCOList.get(i).getHstVO().getFC_AMOUNT(), "0")).doubleValue()));
	    hm.put("TRANS_DATE_I", swiftReconBankStmtCOList.get(i).getHstVO().getTRANS_DATE());
	    hm.put("VALUE_DATE_I", swiftReconBankStmtCOList.get(i).getHstVO().getVALUE_DATE());
	    hm.put("DESCRIPTION_I", swiftReconBankStmtCOList.get(i).getHstVO().getDESCRIPTION());

	    swiftReconBankStmtCOMap.add(hm);
	}
	return swiftReconBankStmtCOMap;
    }

    public int saveRecon(ArrayList<SwiftReconcileCO> swiftReconcileCOList) throws BaseException
    {
	for(int i = 0; i < swiftReconcileCOList.size(); i++)
	{
	    genericDAO.insert(swiftReconcileCOList.get(i).getSwiftHstReconcileVO());
	}
	return 1;
    }

    public SwiftReconcileCO returnConditions() throws BaseException
    {
	SwiftReconcileCO matchConditionList = new SwiftReconcileCO();
	String[] partialMatchList = new String[3];
	String[] partialReasonList = new String[5];

	if(commonLibBO.returnSwiftCtrlRecValues().getFULL_MATCH_EXPRESSION() != null)
	{
	    matchConditionList.setFullMatchExp(commonLibBO.returnSwiftCtrlRecValues().getFULL_MATCH_EXPRESSION());
	}
	if(commonLibBO.returnSwiftCtrlRecValues().getFIRST_PARTIAL_MATCH() != null)
	{
	    partialMatchList[0] = commonLibBO.returnSwiftCtrlRecValues().getFIRST_PARTIAL_MATCH();
	}
	if(commonLibBO.returnSwiftCtrlRecValues().getSECOND_PARTIAL_MATCH() != null)
	{
	    partialMatchList[1] = commonLibBO.returnSwiftCtrlRecValues().getSECOND_PARTIAL_MATCH();
	}
	if(commonLibBO.returnSwiftCtrlRecValues().getTHIRD_PARTIAL_MATCH() != null)
	{
	    partialMatchList[2] = commonLibBO.returnSwiftCtrlRecValues().getTHIRD_PARTIAL_MATCH();
	}

	//

	if(commonLibBO.returnSwiftCtrlRecValues().getFIRST_PARTIAL_REASON() != null)
	{
	    partialReasonList[0] = commonLibBO.returnSwiftCtrlRecValues().getFIRST_PARTIAL_REASON();
	}
	if(commonLibBO.returnSwiftCtrlRecValues().getSECOND_PARTIAL_REASON() != null)
	{
	    partialReasonList[1] = commonLibBO.returnSwiftCtrlRecValues().getSECOND_PARTIAL_REASON();
	}
	if(commonLibBO.returnSwiftCtrlRecValues().getTHIRD_PARTIAL_REASON() != null)
	{
	    partialReasonList[2] = commonLibBO.returnSwiftCtrlRecValues().getTHIRD_PARTIAL_REASON();
	}
	if(commonLibBO.returnSwiftCtrlRecValues().getNOT_IN_CORE_REASON() != null)
	{
	    partialReasonList[3] = commonLibBO.returnSwiftCtrlRecValues().getNOT_IN_CORE_REASON();
	}
	if(commonLibBO.returnSwiftCtrlRecValues().getNOT_IN_FILE_REASON() != null)
	{
	    partialReasonList[4] = commonLibBO.returnSwiftCtrlRecValues().getNOT_IN_FILE_REASON();
	}
	matchConditionList.setPartialMatchCondList(partialMatchList);
	matchConditionList.setPartialReasonList(partialReasonList);
	return matchConditionList;
    }
}
