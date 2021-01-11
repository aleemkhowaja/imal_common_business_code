package com.path.bo.common.iis.islamiccalculator.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.util.Assert;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.iis.IISCommonConstants;
import com.path.bo.common.iis.IISReturnMessagesCO;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.bo.core.common.CoreCommonBO;
import com.path.dao.common.iis.islamiccalculator.IISCommonDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BLACKLIST_OVERRIDE_REASONVO;
import com.path.dbmaps.vo.BRANCH_HOLIDAYVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_OCCUPATIONVO;
import com.path.dbmaps.vo.COUNTRY_CALENDARVO;
import com.path.dbmaps.vo.COUNTRY_CALENDARVOKey;
import com.path.dbmaps.vo.COUNTRY_HOLIDAYVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.FMSAPPLIMITDETVO;
import com.path.dbmaps.vo.FMSAPPLVO;
import com.path.dbmaps.vo.FMSAPPLVOKey;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.IISCTRL_ADDITIONAL_PARAMVO;
import com.path.dbmaps.vo.IISCTRL_ADDITIONAL_PARAMVOKey;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.TRSCHARGESVOKey;
import com.path.dbmaps.vo.TRSCIFLIMITDETVO;
import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSCLASSVOKey;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVO;
import com.path.dbmaps.vo.TRSCLASS_EXTENDEDVOKey;
import com.path.dbmaps.vo.TRSDEALCHARGESVO;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRSDEAL2VO;
import com.path.dbmaps.vo.TRSDEALVOKey;
import com.path.dbmaps.vo.TRSDEAL_COUNTRY_HOLIDAYVO;
import com.path.dbmaps.vo.TRSDEAL_STLMT_APTNMTVOKey;
import com.path.dbmaps.vo.TRSDEAL_YIELD_AMENDEDVO;
import com.path.dbmaps.vo.TRSDETVO;
import com.path.dbmaps.vo.TRSPAYPLANDETVO;
import com.path.dbmaps.vo.TRSPAYPLANVO;
import com.path.dbmaps.vo.TRSROSTER_REGISTER_DETVO;
import com.path.dbmaps.vo.TRSROSTER_REGISTER_DETVOKey;
import com.path.dbmaps.vo.TRSVATVO;
import com.path.dbmaps.vo.TRSVAT_PERIODVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.iis.islamiccalculator.CifBlackListRestrictCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IISCustomerLimitCO;
import com.path.vo.common.iis.islamiccalculator.IISHolidayCheckCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorDBRatioSC;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorEventMgmtCO;
import com.path.vo.common.iis.islamiccalculator.LOSmessagesCO;
import com.path.vo.common.iis.islamiccalculator.TrsPlanBallonPaymentCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.iis.common.IISInvestmentDealCO;
import com.path.vo.iis.common.IISInvestmentDealSC;

import net.sf.json.JSONArray;

import net.sf.json.JSONObject;

/**
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code<br>
 * <br>
 * 
 * BO Class for IIS Common Functions.
 * 
 * @see com.path.bo.common.iis.islamiccalculator.impl.IISCommonBOImpl
 * @author Bejoy
 * 
 */
public class IISCommonBOImpl extends BaseBO implements IISCommonBO
{
    private static final long serialVersionUID = 1L;
    private IISCommonDAO iisCommonDAO;
    private CoreCommonBO coreCommonBO;
    public static final Integer SYSTEM_DATE_IS_LESS_THAN_THE_TRANSACTION_CREATION_VERIFICATION_DATE = 903184;
    public static final Integer SYSTEM_DATE_IS_LESS_THAN_THE_TRANSACTION_APPROVAL_DATE = 903709;

    @Override
    public String returnCurrencyPtMethod(CURRENCIESVOKey currenciesVOKey) throws BaseException
    {

	CURRENCIESVO currenciesVO = iisCommonDAO.getCurrencyDetails(currenciesVOKey);

	if(currenciesVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_DEAL_CURRENCY);
	}

	String PT_METHOD = currenciesVO.getPT_METHOD();
	BigDecimal IISCONTROL_SEQ_KEY_DEBIT_PT_METHOD = BigDecimal.valueOf(9);
	String DEBIT_PT_METHOD = returnIISCONTROLValyByKey(IISCONTROL_SEQ_KEY_DEBIT_PT_METHOD, "DEBIT_PT_METHOD");

	if(DEBIT_PT_METHOD != null && DEBIT_PT_METHOD.equals(ConstantsCommon.YES))
	{
	    PT_METHOD = currenciesVO.getORIGIN();
	}
	if(PT_METHOD == null || PT_METHOD.isEmpty())
	{
	    PT_METHOD = "1";
	}

	return PT_METHOD;
    }

    /**
     * Method for checking the CIF status whether it is suspended,closed etc...
     * or not
     * 
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    public IISCommonCO validateCifStatus(IISCommonCO iisCommonCO) throws BaseException
    {
	// Checking whether CIF is present in the object and fetching it if not
	// present in it.
	if(iisCommonCO.getIdNo() == null && iisCommonCO.getCifNo() == null)
	{
	    throw new BOException(MessageCodes.INVALID_ENTRY);
	}
	if(iisCommonCO.getIdNo() != null && iisCommonCO.getCifNo() == null)
	{
	    iisCommonCO.setCifNo(returnCif(iisCommonCO));
	}

	IISCommonCO cifStatusObj = iisCommonDAO.getCifStatus(iisCommonCO);// Getting
	if(cifStatusObj == null)
	{
	    throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
	}
	// the
	// status
	// of
	// CIF
	if(cifStatusObj.getClientStatus() == null)// Counter Party is deceased
	{
	    if(cifStatusObj.getStatus() == null || cifStatusObj.getStatus().equals("I"))
	    {
		throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_INACTIVE);
	    }
	    else if(cifStatusObj.getStatus().equals("C"))
	    {
		throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_CLOSED);
	    }
	    else if(cifStatusObj.getStatus().equals("S"))
	    {
		throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_SUSPENDED);
	    }
	    else if(cifStatusObj.getStatus().equals("D"))
	    {
		throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_DELETED);
	    }
	}
	else
	{
	    if(cifStatusObj.getClientStatus().intValue() == 1)
	    {
		throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_DECEASED);
	    }
	}
	cifStatusObj.setCifNo(iisCommonCO.getCifNo());
	cifStatusObj.setIdNo(iisCommonCO.getIdNo());
	cifStatusObj.setCompCode(iisCommonCO.getCompCode());
	cifStatusObj.setBranchCode(iisCommonCO.getBranchCode());
	return cifStatusObj;
    }

    /**
     * Method for getting CIF
     * 
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    public BigDecimal returnCif(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.getCif(iisCommonCO);
    }

    /**
     * Method for checking the CIF is blacklisted or not
     * 
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    public IISCommonCO isBlackListed(IISCommonCO iisCommonCO) throws BaseException
    {
	String blackListType = "0", blackListLongName = "", blackListCode = "0", blackListCodeSource = "0",
		blackListCodeLongDesc = "";
	IISCommonCO cifStatusObj = iisCommonDAO.getCifStatus(iisCommonCO);// Getting
	// the
	// status
	// of
	// CIF
	if(cifStatusObj != null && cifStatusObj.getBlackListed() != null
		&& cifStatusObj.getBlackListed().intValue() == 1)
	{
	    String blackListedContinueFlag = iisCommonDAO.isAllowBlackListed(iisCommonCO);
	    if(blackListedContinueFlag.equals(ConstantsCommon.NO))
	    {
		cifStatusObj = iisCommonDAO.getBlackListedDetails(iisCommonCO);

		if(cifStatusObj != null)
		{

		    if(cifStatusObj.getBlackListType() != null)
		    {
			blackListType = StringUtil.nullToEmpty(cifStatusObj.getBlackListType());
		    }
		    // if(cifStatusObj.getBlackListLongNameEng() != null)
		    // {
		    // blackListLongNameEng =
		    // StringUtil.nullToEmpty(cifStatusObj.getBlackListLongNameEng());
		    // }
		    // TP# 267361;deepu.mohandas 03/02/2015
		    if(cifStatusObj.getBlackListLongNameEng() != null
			    && ConstantsCommon.LANGUAGE_ENGLISH.equals(iisCommonCO.getLanguage()))
		    {
			blackListLongName = StringUtil.nullToEmpty(cifStatusObj.getBlackListLongNameEng());
		    }
		    else if(cifStatusObj.getBlackListLongNameArab() != null
			    && ConstantsCommon.LANGUAGE_ARABIC.equals(iisCommonCO.getLanguage()))
		    {
			blackListLongName = StringUtil.nullToEmpty(cifStatusObj.getBlackListLongNameArab());
		    }
		    if(cifStatusObj.getBlackListCode() != null)
		    {
			blackListCode = StringUtil.nullToEmpty(cifStatusObj.getBlackListCode());
		    }
		    if(cifStatusObj.getBlackListLongDescEng() != null)
		    {
			blackListCodeLongDesc = StringUtil.nullToEmpty(cifStatusObj.getBlackListLongDescEng());
		    }
		    if(cifStatusObj.getBlackListCodeSource() != null)
		    {
			blackListCodeSource = StringUtil.nullToEmpty(cifStatusObj.getBlackListCodeSource());
		    }
		}
		// TP#215577; Saheer.Naduthodi; 11/09/2014 [START]
		if(IISCommonConstants.MESSAGE_TYPEWARNING.equals(
			StringUtil.nullEmptyToValue(iisCommonCO.getValue(), IISCommonConstants.MESSAGE_TYPE_STOP)))
		{
		    // LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
		    if(IISCommonConstants.CALLED_FROM_LOS.equals(iisCommonCO.getCalledFrom()))
		    {
			iisCommonCO.setLosMessagesCO(new LOSmessagesCO());
			iisCommonCO.getLosMessagesCO().setCode(BigDecimal.valueOf(902322));
			iisCommonCO.getLosMessagesCO().setType("C");
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Counter Party is Black Listed \n Black List no ");
			errorMessage.append(blackListCode);
			errorMessage.append("\n Source");
			errorMessage.append(blackListCodeSource);
			errorMessage.append(",");
			errorMessage.append(blackListCode);
			errorMessage.append("\n Black List");
			errorMessage.append(blackListType);
			errorMessage.append(",");
			errorMessage.append(blackListLongName);
			iisCommonCO.getLosMessagesCO().setDescription(errorMessage.toString());
		    }
		    // LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
		    else
		    {
			if(!IISCommonConstants.CALLED_FROM_WS.equals(iisCommonCO.getCalledFrom()))
			{
			    throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_BLACK_LISTED_PARAM,
				    new String[] { blackListCode, blackListCodeSource + blackListCodeLongDesc,
					    blackListType + blackListLongName },
				    ConstantsCommon.CONFIRM_MSG_TYPE, "CHECK_BLACK_LISTED_CIF", false);
			}
		    }
		}
		if(!IISCommonConstants.CALLED_FROM_WS.equals(iisCommonCO.getCalledFrom()))
		{
		    throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_BLACK_LISTED_PARAM,
			    new String[] { blackListCode, blackListCodeSource + blackListCodeLongDesc,
				    blackListType + blackListLongName },
			    ConstantsCommon.CONFIRM_MSG_TYPE, "CHECK_BLACK_LISTED_CIF", false);
		}
	    }
	    // TP#215577; Saheer.Naduthodi; 11/09/2014 [END]
	    // 614937 Fawas.Kuruvakkottil 01/02/2018 -changed ctsmessages
	    throw new BOException(MessageCodes.COUNTER_PARTY_STATUS_BLACK_LISTED_PARAM_STP_MSG, new String[] {
		    blackListCode, blackListCodeSource + blackListCodeLongDesc, blackListType + blackListLongName });
	}
	return iisCommonCO;
    }

    /**
     * Method for setting the First Date
     * 
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    public IISCommonCO returnFirstdate(IISCommonCO iisCommonCO) throws BaseException
    {
	// get the month,day,year of value date(start date)
	// start
	Date valueDate = iisCommonCO.getCommencementDate();
	String gracePeriodicity = iisCommonCO.getGracePeriodicity();// first
	// payment
	// after
	BigDecimal gracePeriod = iisCommonCO.getGracePeriod();// first payment
	// after

	String paymentPeriodicty = iisCommonCO.getPaymPeriodicity();
	String paymentPeiodicityPos = iisCommonCO.getPaymPeriodPos();
	Boolean lastDayOfMonthb = false;

	Calendar cal = Calendar.getInstance();
	cal.setTime(valueDate);

	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int year = cal.get(Calendar.YEAR);
	Date lastDayOfMonth = getlastDayOfMonth(month, year);
	Date firstPayDate = valueDate;
	if(valueDate.compareTo(lastDayOfMonth) == 0)
	{
	    lastDayOfMonthb = true;
	}
	if(gracePeriodicity.equals(IISCommonConstants.DAY))// Day
	{
	    firstPayDate = DateUtil.relativeDate(valueDate, NumberUtil.toInt(gracePeriod));
	    iisCommonCO.setFirstPayDate(firstPayDate);
	}
	else if(gracePeriodicity.equals(IISCommonConstants.WEEK))// Week
	{
	    firstPayDate = DateUtil.relativeDate(valueDate, (NumberUtil.toInt(gracePeriod) * 7));
	    iisCommonCO.setFirstPayDate(firstPayDate);
	}
	else if(gracePeriodicity.equals(IISCommonConstants.MONTH))// Month
	{
	    for(int i = 1; i <= NumberUtil.toInt(gracePeriod); i++)
	    {
		month++;
		if(month > 11)
		{
		    month = 0;
		    year++;
		}

	    }
	    if(lastDayOfMonthb && paymentPeiodicityPos.equals(IISCommonConstants.DAY))
	    {
		switch (month)
		{
		    // case 1: case 3:case 5: case 7: case 8: case 10:case 12:
		    // //issues faced in Dateutil as month starts from 0.
		    case 0:
		    case 2:
		    case 4:
		    case 6:
		    case 7:
		    case 9:
		    case 11:
			if(day == 31)
			{
			    day = 31;
			}
			break;

		    case 3:
		    case 5:
		    case 8:
		    case 10:
			if(day == 31)
			{
			    month++;
			    day = 1;
			}
			break;

		    case 1:
			if((year % 4) == 0)// checking Leap year
			{
			    if(day == 31)
			    {
				month++;
				day = 2;
			    }
			    else if(day == 30)
			    {
				month++;
				day = 1;
			    }
			}
			else
			{
			    if(day == 31)
			    {
				month++;
				day = 3;
			    }
			    else if(day == 30)
			    {
				month++;
				day = 2;
			    }
			    else if(day == 29)
			    {
				month++;
				day = 1;
			    }
			}
			break;
		    default:
			break;
		}
		firstPayDate = DateUtil.createDate(year, month, day);
		iisCommonCO.setFirstPayDate(firstPayDate);
	    }
	    else
	    {
		firstPayDate = DateUtil.createDate(year, month, day);
		// Commented to get the corrected first payment date
		// firstPayDate = findMaturityDate(firstPayDate,
		// NumberUtil.toInt(gracePeriod));// f_relativedate
		iisCommonCO.setFirstPayDate(firstPayDate);
	    }
	}
	else if(gracePeriodicity.equals(IISCommonConstants.YEAR))// Year
	{
	    for(int i = 1; i <= NumberUtil.toInt(gracePeriod); i++)
	    {
		year++;
	    }
	    firstPayDate = DateUtil.createDate(year, month, day);
	    iisCommonCO.setFirstPayDate(firstPayDate);
	}
	else if(gracePeriodicity.equals(IISCommonConstants.QUARTER) || gracePeriodicity.equals(IISCommonConstants.SEMI)
		|| gracePeriodicity.equals(IISCommonConstants.ANUAL))
	{
	    Date valueDate1 = valueDate;
	    for(int i = 1; i <= NumberUtil.toInt(gracePeriod); i++)
	    {
		firstPayDate = returnNextDate(valueDate1, gracePeriodicity, false);
		valueDate1 = firstPayDate;
	    }
	    iisCommonCO.setFirstPayDate(firstPayDate);
	}
	else
	{
	    firstPayDate = valueDate;
	    iisCommonCO.setFirstPayDate(firstPayDate);
	}
	Date firstPayDateorg = firstPayDate;

	// end
	String planCalcFirstPay = iisCommonDAO.getCalcFirstPaymentDateYn(iisCommonCO);
	if(iisCommonCO.getCalledFrom() != null
		&& iisCommonCO.getCalledFrom().equals(IISCommonConstants.CALCULATOR_PAYMENT_CRITERIA))
	{
	    planCalcFirstPay = "Y";
	}

	if(planCalcFirstPay != null && (planCalcFirstPay.equals("Y") && (paymentPeriodicty.equals("M")
		|| paymentPeriodicty.equals("Q") || paymentPeriodicty.equals("S") || paymentPeriodicty.equals("A"))))
	{

	    firstPayDate = iisCommonCO.getCommencementDate();

	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(firstPayDate);

	    int month1 = cal1.get(Calendar.MONTH);
	    int day1 = cal1.get(Calendar.DAY_OF_MONTH);
	    int year1 = cal1.get(Calendar.YEAR);
	    Date dealValueDate = iisCommonCO.getValueDate();
	    if(paymentPeriodicty.equals(IISCommonConstants.MONTH))
	    {
		if(paymentPeiodicityPos.equals(IISCommonConstants.MONTH_START))// month
		// start
		{
		    // if(DateUtil.getDatePart("DD", dealValueDate) != 1)
		    // {
		    // month1++;
		    // if(month1 > 11)
		    // {
		    // month1 = 0;// Changed the value of month to 0 as
		    // // java calendar starts from 0
		    // year1++;
		    // }
		    // }
		    firstPayDate = DateUtil.createDate(year1, month1, 1);
		    if(firstPayDate.before(dealValueDate))
		    {
			firstPayDate = DateUtil.relativeMonth(firstPayDate, 1);
		    }
		}
		else if(paymentPeiodicityPos.equals(IISCommonConstants.MONTH_MIDDLE))// month
		// middle
		{
		    // if(NumberUtil.toInt(day1) > 15)
		    // if(DateUtil.getDatePart("DD", dealValueDate) > 15)
		    // {
		    // month1++;
		    // if(month1 > 11)
		    // {
		    // month1 = 0;// Changed the value of month to 0 as
		    // // java calendar starts from 0
		    // year1++;
		    // }
		    // }
		    firstPayDate = DateUtil.createDate(year1, month1, 15);
		    if(firstPayDate.before(dealValueDate))
		    {
			firstPayDate = DateUtil.relativeMonth(firstPayDate, 1);
		    }
		}
		else if(paymentPeiodicityPos.equals(IISCommonConstants.MONTH_END))// month
		// End
		{
		    firstPayDate = DateUtil.relativeDate(firstPayDate, 1);
		    Calendar cal2 = Calendar.getInstance();
		    cal2.setTime(firstPayDate);
		    int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		    if(day2 != 1)
		    {

			month1++;
			if(month1 > 11)
			{
			    month1 = 0;// Changed the value of month to 0 as
			    // java calendar starts from 0
			    year1++;
			}
			firstPayDate = DateUtil.createDate(year1, month1, 1);
			firstPayDate = DateUtil.relativeDate(firstPayDate, -1);
		    }
		}
		else if(paymentPeiodicityPos.equals(IISCommonConstants.MONTH_DAY) && day > day1)// month
		// End
		{

		    month1++;
		    if(month1 > 11)
		    {
			month1 = 0;// Changed the value of month to 0 as
			// java calendar starts from 0
			year1++;
		    }
		    while(true)
		    {
			if((day1 > 28 && day1 <= 31)
				&& !DateUtil.isValidDate(DateUtil.createDate(year1, month1, day1).toString()))
			{
			    day1--;
			}
			else
			{
			    firstPayDate = DateUtil.createDate(year1, month1, day1);
			    break;
			}
		    }
		    firstPayDate = DateUtil.createDate(year1, month1, day1);

		}
	    }
	    else if(paymentPeriodicty.equals(IISCommonConstants.QUARTER))
	    {
		firstPayDate = getDateQuarter(month1, year1);
		iisCommonCO.setFirstPayDate(firstPayDate);
	    }
	    else if(paymentPeriodicty.equals(IISCommonConstants.SEMI))
	    {
		firstPayDate = getDatehalfyear(month1, year1);
		iisCommonCO.setFirstPayDate(firstPayDate);
	    }
	    else if(paymentPeriodicty.equals(IISCommonConstants.ANUAL))
	    {
		firstPayDate = DateUtil.createDate(year1, 11, 31);
		iisCommonCO.setFirstPayDate(firstPayDate);
	    }
	    if(firstPayDate.after(iisCommonCO.getMaturityDate()))
	    {
		firstPayDate = firstPayDateorg;
		iisCommonCO.setFirstPayDate(firstPayDate);
	    }
	    else
	    {
		if(firstPayDate.compareTo(firstPayDateorg) != 0)
		{
		    if(firstPayDate.compareTo(valueDate) == 0)
		    {
			iisCommonCO.setGracePeriod(BigDecimal.ZERO);
			iisCommonCO.setGracePeriodOption(BigDecimal.ZERO);
			iisCommonCO.setGracePeriodicity("D");
		    }
		    else
		    {
			iisCommonCO.setGracePeriod(BigDecimal.valueOf(DateUtil.numberOfDays(valueDate, firstPayDate)));
			iisCommonCO.setGracePeriodOption(BigDecimal.ONE);
			iisCommonCO.setGracePeriodicity("D");
			iisCommonCO.setFirstPayDate(firstPayDate);
		    }
		}
	    }
	    iisCommonCO.setFirstPayDate(firstPayDate);
	}
	return iisCommonCO;
    }

    private Date getDateQuarter(int month1, int year)
    {
	Date quarterDate = DateUtil.createDate(year, month1, 1);
	if(month1 <= 2)
	{
	    quarterDate = DateUtil.createDate(year, 2, 31);
	}
	else if(month1 <= 5)
	{
	    quarterDate = DateUtil.createDate(year, 5, 30);
	}
	else if(month1 <= 8)
	{
	    quarterDate = DateUtil.createDate(year, 8, 30);
	}
	else if(month1 <= 11)
	{
	    quarterDate = DateUtil.createDate(year, 11, 31);
	}
	return quarterDate;
    }

    private Date getDatehalfyear(int month1, int year)
    {
	Date quarterDate = DateUtil.createDate(year, month1, 1);
	if(month1 <= 5)
	{
	    quarterDate = DateUtil.createDate(year, 5, 30);
	}

	else if(month1 <= 11)
	{
	    quarterDate = DateUtil.createDate(year, 11, 31);
	}
	return quarterDate;
    }

    private Date getlastDayOfMonth(int monthParam, int yearParam) throws BaseException
    {

	int month = monthParam, year = yearParam;
	month = month % 11;
	if(month == 0)
	{
	    year++;
	    month = 0;
	}

	Date lastDayofDate = DateUtil.createDate(year, month, 1);
	lastDayofDate = DateUtil.relativeDate(lastDayofDate, -1);
	return lastDayofDate;
    }

    // TODO:Need to remove after testing - setTestValues
    /*
     * private void setTestValues(IISCommonCO iisCommonCO) { Date valueDate =
     * DateUtil.createDate(2010, 1, 1); Date maturityDate =
     * DateUtil.createDate(2011, 1, 1);
     * iisCommonCO.setMaturityDate(maturityDate); String paymentPeriodicity =
     * "A"; Long paymentPeriodicityNo = 2L; String paymentPeriodicityMonthPos =
     * "S"; iisCommonCO.setPaymPeriodicity(paymentPeriodicity);
     * iisCommonCO.setPaymPeriodPos(paymentPeriodicityMonthPos);
     * iisCommonCO.setPaymPeriodNbr(BigDecimal.valueOf(paymentPeriodicityNo));
     * iisCommonCO.setFirstPayDate(valueDate); }
     */

    /**
     * Method to calculate the number of payments
     * 
     * @param IISCommonCO
     * @return IISCommonCO
     * @throws BaseException
     */
    public IISCommonCO returnNumberofPayments(IISCommonCO iisCommonCO) throws BaseException
    {
	BigDecimal paymPeriodNbr = iisCommonCO.getPaymPeriodNbr();
	if(paymPeriodNbr.intValue() <= 0)
	{
	    iisCommonCO.setNoOfPayments(BigDecimal.ZERO);
	    return iisCommonCO;
	}
	BigDecimal noOfPayments = BigDecimal.ZERO;
	long numberOfPayment = noOfPayments.longValue();
	Date firstPayDate = iisCommonCO.getFirstPayDate();
	Date maturityDate = iisCommonCO.getMaturityDate();
	String payPeriodicity = iisCommonCO.getPaymPeriodicity();
	String payPeriodPos = NumberUtil.nullToZero(iisCommonCO.getPaymPeriodPos());
	if(payPeriodicity.equals(IISCommonConstants.DAY))
	{
	    double noOfPaymentDayWise = (DateUtil.numberOfDays(firstPayDate, maturityDate)
		    / (double) (NumberUtil.toInt(paymPeriodNbr)));
	    noOfPaymentDayWise = NumberUtil.truncate(noOfPaymentDayWise, 0L);
	    noOfPayments = BigDecimal.valueOf(noOfPaymentDayWise + 1);
	}
	else if(payPeriodicity.equals(IISCommonConstants.WEEK))
	{
	    double noOfPaymentWeekWise = ((DateUtil.numberOfDays(firstPayDate, maturityDate) / (double) 7)
		    / (NumberUtil.toInt(paymPeriodNbr)));
	    noOfPaymentWeekWise = NumberUtil.truncate(noOfPaymentWeekWise, 0L);
	    noOfPayments = BigDecimal.valueOf(noOfPaymentWeekWise + 1);
	}
	else if((payPeriodicity.equals(IISCommonConstants.MONTH)) && ((paymPeriodNbr).intValue() > 0))
	{
	    double noOfPaymentsMonthWise = (DateUtil.getMonthsDifference(firstPayDate, maturityDate))
		    / NumberUtil.toInt(paymPeriodNbr);
	    if((noOfPaymentsMonthWise % 1) == 0)
	    {
		noOfPaymentsMonthWise = NumberUtil.truncate(noOfPaymentsMonthWise, 0L);
	    }
	    else
	    {
		noOfPaymentsMonthWise = NumberUtil.truncate(noOfPaymentsMonthWise, 0L);
		noOfPaymentsMonthWise = noOfPaymentsMonthWise + 1;
	    }
	    // TP#208633; Ramesh; Date 11/08/2014
	    //noOfPaymentsMonthWise = NumberUtil.round(noOfPaymentsMonthWise, 0L);
	    noOfPayments = BigDecimal.valueOf(noOfPaymentsMonthWise);
	    noOfPayments = calculateNumberOfPaymentsOnPayPeriodPOS(firstPayDate, maturityDate, payPeriodPos,
		    noOfPayments);
	    // TP#202682; Ramesh; Date 28/09/2014 [if you want +1 pass from
	    // where you are calling this method because +1 is not applicable to
	    // all]
	    // numberOfPayment = noOfPayments.longValue() + 1;
	    numberOfPayment = noOfPayments.longValue();
	    noOfPayments = BigDecimal.valueOf(numberOfPayment);
	}
	else if(payPeriodicity.equals(IISCommonConstants.QUARTER) || payPeriodicity.equals(IISCommonConstants.SEMI)
		|| payPeriodicity.equals(IISCommonConstants.ANUAL))
	{
	    int payPeriodNumber = paymPeriodNbr.intValue();
	    while(firstPayDate.before(maturityDate))
	    {
		for(int i = 0; i < payPeriodNumber; i++)
		{
		    firstPayDate = returnNextDate(firstPayDate, payPeriodicity, false);
		}
		if(firstPayDate.after(maturityDate))
		{
		    numberOfPayment++;
		    break;
		}
		numberOfPayment++;
	    }
	    noOfPayments = BigDecimal.valueOf(numberOfPayment + 1);
	}
	iisCommonCO.setNoOfPayments(noOfPayments);
	// System.out.println(noOfPayments);
	return iisCommonCO;
    }

    private BigDecimal calculateNumberOfPaymentsOnPayPeriodPOS(Date firstPayDate, Date maturityDate,
	    String payPeriodPos, BigDecimal noOfPaymentsParam) throws BaseException
    {
	BigDecimal noOfPayments = noOfPaymentsParam;
	long numberOfPayment;
	numberOfPayment = noOfPayments.longValue();

	if(payPeriodPos.equals(IISCommonConstants.MONTH_DAY))
	{
	    long firstPayDatePart = DateUtil.getDatePart("DD", firstPayDate);
	    long maturityDatePart = DateUtil.getDatePart("DD", maturityDate);
	    if(maturityDatePart > firstPayDatePart)
	    {
		numberOfPayment++;
	    }
	}
	else if(payPeriodPos.equals(IISCommonConstants.MONTH_START))
	{
	    long maturityDatePart = DateUtil.getDatePart("DD", maturityDate);
	    if(maturityDatePart > 1)
	    {
		numberOfPayment++;
	    }
	}
	else if(payPeriodPos.equals(IISCommonConstants.MONTH_MIDDLE))
	{
	    long maturityDatePart = DateUtil.getDatePart("DD", maturityDate);
	    if(maturityDatePart > 15)
	    {
		numberOfPayment++;
	    }
	}

	if(payPeriodPos.equals(IISCommonConstants.MONTH_END))
	{
	    long firstPayDateMonthPart = DateUtil.getDatePart("MM", firstPayDate);
	    long maturityDateMonthPart = DateUtil.getDatePart("DD", maturityDate);
	    if(maturityDateMonthPart == firstPayDateMonthPart)
	    {
		numberOfPayment++;
	    }
	}
	noOfPayments = BigDecimal.valueOf(numberOfPayment);
	return noOfPayments;
    }

    /**
     * Method for setting the Maturity Date
     * 
     * @param IISCommonCO
     * @return IISCommonCO
     * @throws BaseException
     */
    public IISCommonCO returnMaturitydate(IISCommonCO iisCommonCO) throws BaseException
    {
	BigDecimal noOfPayments;
	BigDecimal paymPeriodNbr;

	noOfPayments = iisCommonCO.getNoOfPayments();
	paymPeriodNbr = iisCommonCO.getPaymPeriodNbr();
	// if PaymPeriodNbr is null or PaymPeriodicity() is null then
	// no need of calculate maturity date, the existing maturity date is
	// enough i.e 31/12/2111
	if(paymPeriodNbr == null || iisCommonCO.getPaymPeriodicity() == null || iisCommonCO.getFirstPayDate() == null)
	{
	    return iisCommonCO;
	}
	if(noOfPayments == null)
	{
	    noOfPayments = BigDecimal.ONE;
	}

	// Date calcuteDate = iisCommonCO.getStartDate();
	Date calcuteDate = iisCommonCO.getFirstPayDate();// Changing the first
	// pay date as per
	// Bijoy for all
	// onchange events we
	// are passing first
	// pay date to get the
	// mMD.
	Calendar cal = Calendar.getInstance();
	cal.setTime(calcuteDate);
	// get the date.month and year of first pay date
	// int month = cal.get(Calendar.MONTH)+1;
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int year = cal.get(Calendar.YEAR);
	// getting daysaftermaxperiod
	// long daysaftermaxperiod =
	// iisCommonDAO.getDaysAfterMaximumPeriod(iisCommonCO);
	// to validate the parameters passes to the getmaturity date function

	validateParameter(iisCommonCO);

	if(iisCommonCO.getPaymPeriodicity().equals("D"))
	{
	    if(noOfPayments == null || NumberUtil.toDouble(noOfPayments) <= 0)
	    {
		noOfPayments = BigDecimal.ONE;
		if(iisCommonCO.getValue() != null && iisCommonCO.getValue().equals("VALUE"))
		{
		    iisCommonCO.setNoOfPayments(noOfPayments);
		}
	    }
	    double days = (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
		    - NumberUtil.toDouble(paymPeriodNbr);
	    iisCommonCO.setMaturityDate(DateUtil.relativeDate(calcuteDate, (int) days));
	}
	else if(iisCommonCO.getPaymPeriodicity().equals("W"))
	{
	    double days = (NumberUtil.toDouble(paymPeriodNbr) * 7 * NumberUtil.toDouble(noOfPayments))
		    - NumberUtil.toDouble(paymPeriodNbr) * 7;
	    iisCommonCO.setMaturityDate(DateUtil.relativeDate(calcuteDate, (int) days));
	}
	else if(iisCommonCO.getPaymPeriodicity().equals("M"))
	{
	    // TP#171552; Ramesh; Date 29/06/2014
	    double noOfpaymentsToAdd = (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
		    - NumberUtil.toDouble(paymPeriodNbr);
	    // To find out the year of maturity date
	    for(int i = 1; i <= noOfpaymentsToAdd; i++)
	    {
		month++;
		if(month > 11)
		{
		    month = 0;
		    year++;
		}
	    }
	    /*
	     * paym_period_pos has 4 values E - Month End S - MOnth Start M -
	     * MOnth Middle D -Set Date
	     */
	    if(iisCommonCO.getPaymPeriodPos() != null && iisCommonCO.getPaymPeriodPos().equals("E"))// Month
	    // End
	    {
		month++;
		if(month > 11)
		{
		    month = 0;
		    year++;
		}
		// since the below payment periodicity is at month end, we need
		// to create the maturity date as month end date
		iisCommonCO.setMaturityDate(DateUtil.relativeDate(DateUtil.createDate(year, month, 1), -1));
	    }
	    else if(iisCommonCO.getPaymPeriodPos() != null && iisCommonCO.getPaymPeriodPos().equals("M"))// Month
	    // Middle
	    {
		iisCommonCO.setMaturityDate(DateUtil.createDate(year, month, 15));
	    }
	    else if(iisCommonCO.getPaymPeriodPos() != null && iisCommonCO.getPaymPeriodPos().equals("S"))// month
	    // Start
	    {
		iisCommonCO.setMaturityDate(DateUtil.createDate(year, month, 1));
	    }
	    else if(iisCommonCO.getPaymPeriodPos() != null && iisCommonCO.getPaymPeriodPos().equals("D"))// Set
	    // Date
	    {
		switch (month)
		{
		    // case 1: case 3:case 5: case 7: case 8: case 10:case 12:
		    case 0:
		    case 2:
		    case 4:
		    case 6:
		    case 7:
		    case 9:
		    case 11:
			if(day == 31)
			{
			    day = 31;
			}
			break;

		    // case 4:case 6:case 9:case 11:
		    case 3:
		    case 5:
		    case 8:
		    case 10:
			if(day == 31)
			{
			    month++;
			    day = 1;
			}
			break;

		    // case 2:
		    case 1:
			if((year % 4) == 0)// checking Leap year
			{
			    if(day == 31)
			    {
				month++;
				day = 2;
			    }
			    else if(day == 30)
			    {
				month++;
				day = 1;
			    }
			}
			else
			{
			    if(day == 31)
			    {
				month++;
				day = 3;
			    }
			    else if(day == 30)
			    {
				month++;
				day = 2;
			    }
			    else if(day == 29)
			    {
				month++;
				day = 1;
			    }
			}
			break;
		    default:
			break;
		}
		iisCommonCO.setMaturityDate(DateUtil.createDate(year, month, day));
	    }
	    else
	    {
		double daysvalue = NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments);
		iisCommonCO.setMaturityDate(findMaturityDate(calcuteDate, (int) daysvalue));
	    }
	}
	else if(iisCommonCO.getPaymPeriodicity().equals("Y"))
	{
	    iisCommonCO.setMaturityDate(
		    DateUtil.dateAdd(DateUtil.YEAR, paymPeriodNbr.longValue() * noOfPayments.longValue(), calcuteDate));
	    // for(int i = 1; i <= NumberUtil.toDouble(paymPeriodNbr) *
	    // NumberUtil.toDouble(noOfPayments); i++)
	    // {
	    // year++;
	    // }
	    // if(DateUtil.numberOfDays(DateUtil.createDate(year, month, day),
	    // iisCommonCO.getRunningDate()) > 0)
	    // {
	    // iisCommonCO.setMaturityDate(DateUtil.createDate(year, month,
	    // day));
	    // }
	    // else
	    // {
	    // iisCommonCO.setMaturityDate(DateUtil.createDate(year, month, day
	    // - 1));
	    // }
	}
	else if(iisCommonCO.getPaymPeriodicity().equals("Q") || iisCommonCO.getPaymPeriodicity().equals("S")
		|| iisCommonCO.getPaymPeriodicity().equals("A"))
	{
	    boolean abFirst = false;
	    Date valueDateNew;
	    if(noOfPayments == null || NumberUtil.toDouble(noOfPayments) <= 0)
	    {
		noOfPayments = BigDecimal.ONE;
		// TP# 733111
		if(StringUtil.nullToEmpty(iisCommonCO.getValue()).equals("VALUE"))
		{
		    iisCommonCO.setNoOfPayments(noOfPayments);
		}
	    }
	    double days = (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
		    - NumberUtil.toDouble(paymPeriodNbr);
	    if(days == 0)
	    {
		iisCommonCO.setMaturityDate(iisCommonCO.getFirstPayDate());
	    }
	    if(iisCommonCO.getPaymPeriodicity().equals("Q"))
	    {
		if(calcuteDate.compareTo(DateUtil.createDate(year, 2, 31)) == 0
			// || calcuteDate.compareTo(DateUtil.createDate(year, 6,
			// 30))==0
			|| calcuteDate.compareTo(DateUtil.createDate(year, 5, 30)) == 0
			// || calcuteDate.compareTo(DateUtil.createDate(year, 9,
			// 30))==0
			|| calcuteDate.compareTo(DateUtil.createDate(year, 8, 30)) == 0
			// || calcuteDate.compareTo(DateUtil.createDate(year,
			// 12, 31))==0)
			|| calcuteDate.compareTo(DateUtil.createDate(year, 11, 31)) == 0)
		{
		    valueDateNew = DateUtil.relativeDate(calcuteDate, -1);
		    for(int i = 1; i < (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
			    - (NumberUtil.toDouble(paymPeriodNbr) - 2); i++)
		    {
			Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
			valueDateNew = maturityDate;
			iisCommonCO.setMaturityDate(maturityDate);
		    }
		}
		else
		{
		    valueDateNew = DateUtil.relativeDate(calcuteDate, -1);
			//Added By Rakesh ; TP733111 ; 15/11/2018 [start]
			if(StringUtil.nullToEmpty(iisCommonCO.getValue()).equals("START_DATE"))
			{
				Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
				valueDateNew = maturityDate;
				iisCommonCO.setMaturityDate(maturityDate);	
			}
			//Added By Rakesh ; TP733111 ; 15/11/2018 [end]
			else
			{
				for(int i = 1; i < (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
					- (NumberUtil.toDouble(paymPeriodNbr) - 1); i++)
				{
				Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
				valueDateNew = maturityDate;
				iisCommonCO.setMaturityDate(maturityDate);
				}
			}
		}
	    }
	    else if(iisCommonCO.getPaymPeriodicity().equals("S"))
	    {
		if(calcuteDate.compareTo(DateUtil.createDate(year, 5, 30)) == 0
			|| calcuteDate.compareTo(DateUtil.createDate(year, 11, 31)) == 0)
		{
		    valueDateNew = DateUtil.relativeDate(calcuteDate, -1);
		    for(int i = 1; i < (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
			    - (NumberUtil.toDouble(paymPeriodNbr) - 2); i++)
		    {
			Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
			valueDateNew = maturityDate;
			iisCommonCO.setMaturityDate(maturityDate);
		    }
		}
		else
		{
		    valueDateNew = DateUtil.relativeDate(calcuteDate, -1);
					  //Added By Rakesh ; TP733111 ; 15/11/2018 [start]
			if(StringUtil.nullToEmpty(iisCommonCO.getValue()).equals("START_DATE"))
			{
				Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
				valueDateNew = maturityDate;
				iisCommonCO.setMaturityDate(maturityDate);	
			}
			//Added By Rakesh ; TP733111 ; 15/11/2018 [end]
			else
			{
				for(int i = 1; i < (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
					- (NumberUtil.toDouble(paymPeriodNbr) - 1); i++)
				{
				Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
				valueDateNew = maturityDate;
				iisCommonCO.setMaturityDate(maturityDate);
				}
			}
		}
	    }
	    else if(iisCommonCO.getPaymPeriodicity().equals("A"))
	    {
		if(calcuteDate.compareTo(DateUtil.createDate(year, 11, 31)) == 0)
		{
		    valueDateNew = DateUtil.relativeDate(calcuteDate, -1);
		    for(int i = 1; i < (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
			    - (NumberUtil.toDouble(paymPeriodNbr) - 2); i++)
		    {
			Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
			valueDateNew = maturityDate;
			iisCommonCO.setMaturityDate(maturityDate);
		    }
		}
		else
		{
		    valueDateNew = DateUtil.relativeDate(calcuteDate, -1);
					  //Added By Rakesh ; TP733111 ; 15/11/2018 [start]
			if(StringUtil.nullToEmpty(iisCommonCO.getValue()).equals("START_DATE"))
			{
				Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
				valueDateNew = maturityDate;
				iisCommonCO.setMaturityDate(maturityDate);	
			}
			//Added By Rakesh ; TP733111 ; 15/11/2018 [end]
			else
			{
				for(int i = 1; i < (NumberUtil.toDouble(paymPeriodNbr) * NumberUtil.toDouble(noOfPayments))
					- (NumberUtil.toDouble(paymPeriodNbr) - 1); i++)
				{
				Date maturityDate = returnNextDate(valueDateNew, iisCommonCO.getPaymPeriodicity(), abFirst);
				valueDateNew = maturityDate;
				iisCommonCO.setMaturityDate(maturityDate);
				}
			}
		}
	    }
	}

	if(iisCommonCO.getNoOfPayments().intValue() == 1 && (!"BILLS".equals(iisCommonCO.getValue())))
	{
	    iisCommonCO.setMaturityDate(iisCommonCO.getFirstPayDate());
	}
	if(calcuteDate.compareTo(iisCommonCO.getMaturityDate()) == 0 && iisCommonCO.getIisPayplanCriteria() != null
		&& iisCommonCO.getIisPayplanCriteria().size() > 0)
	{

	    Date prevValudate = iisCommonCO.getStartDate();
	    Date maxValudate = prevValudate;// intializing
	    for(int i = 1; i < iisCommonCO.getIisPayplanCriteria().size(); i++)
	    {
		Date toDate = iisCommonCO.getIisPayplanCriteria().get(i).getTO_DATE();
		if(DateUtil.numberOfDays(toDate, prevValudate) > 0)
		{
		    maxValudate = toDate;
		}
		else
		{
		    maxValudate = prevValudate;
		}
		prevValudate = toDate;
	    }
	    iisCommonCO.setMaturityDate(maxValudate);

	}
	return iisCommonCO;
    }

    public Date returnNextDate(Date calcuteDateParam, String paymPeriodicity, boolean abFirst) throws BaseException
    {
	Date calcuteDate = calcuteDateParam;
	int month, year;
	Date nextDate;
	nextDate = calcuteDate;
	if(!abFirst)
	{
	    calcuteDate = DateUtil.relativeDate(calcuteDate, 1);// month to
	    // change as
	}

	Calendar cal = Calendar.getInstance();
	cal.setTime(calcuteDate);
	month = cal.get(Calendar.MONTH);// Rmoving +1 to get the correct month
	// in java
	year = cal.get(Calendar.YEAR);
	if(paymPeriodicity.equals(IISCommonConstants.QUARTER))
	{
	    if(month <= 2)
	    {
		nextDate = DateUtil.createDate(year, 2, 31);
	    }
	    else if(month <= 5)
	    {
		nextDate = DateUtil.createDate(year, 5, 30);
	    }
	    else if(month <= 8)
	    {
		nextDate = DateUtil.createDate(year, 8, 30);
	    }
	    else if(month <= 11)
	    {
		nextDate = DateUtil.createDate(year, 11, 31);
	    }
	}
	else if(paymPeriodicity.equals(IISCommonConstants.SEMI))
	{
	    if(month <= 5)
	    {
		nextDate = DateUtil.createDate(year, 5, 30);
	    }

	    else if(month <= 11)
	    {
		nextDate = DateUtil.createDate(year, 11, 31);
	    }
	}
	else if(paymPeriodicity.equals(IISCommonConstants.ANUAL) && month <= 11)
	{

	    nextDate = DateUtil.createDate(year, 11, 31);

	}
	return nextDate;
    }

    private Date findMaturityDate(Date calcuteDate, int intValueParam) throws BaseException
    {// f_relativedate
	int intValue = intValueParam;
	Calendar cal = Calendar.getInstance();
	cal.setTime(calcuteDate);
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int year = cal.get(Calendar.YEAR);
	switch (month)
	{
	    case 0:
	    case 2:
	    case 4:
	    case 6:
	    case 7:
	    case 9:
	    case 11:
		break;
	    case 3:
	    case 5:
	    case 8:
	    case 10:
		if(day == 30)
		{
		    day = 31;
		}
		break;
	    case 1:
		if((year % 4) == 0)// checking Leap year
		{
		    if(day == 28)
		    {
			day = 31;
		    }
		}
		else
		{
		    if(day == 29)
		    {
			day = 31;
		    }
		}
		break;
	    default:
		break;
	}

	if(intValue > 0)
	{
	    for(int i = 1; i < intValue; i++)
	    {
		month++;
		if(month > 11)
		{
		    year++;
		    month = 0;
		}
	    }
	}
	else if(intValue < 0)
	{
	    intValue = intValue * -1;
	    for(int i = 1; i < intValue; i++)
	    {
		month--;
		if(month < 0)
		{
		    year = year - 1;
		    month = 11;
		}
	    }
	}

	if(day == 31)
	{
	    switch (month)
	    {
		case 0:
		case 2:
		case 4:
		case 6:
		case 7:
		case 9:
		case 11:
		    break;
		case 3:
		case 5:
		case 8:
		case 10:
		    day = 30;
		    break;
		case 1:
		    if((year % 4) == 0)// checking Leap year
		    {
			day = 29;
		    }
		    else
		    {
			day = 28;
		    }
		    break;
		default:
		    break;
	    }
	}
	else if(month == 1 && day > 28)
	{

	    if((year % 4) == 0)// checking Leap year
	    {
		day = 29;
	    }
	    else
	    {
		day = 28;
	    }

	}

	return DateUtil.createDate(year, month, day);
    }

    private IISCommonCO validateParameter(IISCommonCO iisCommonCO)
    {
	if(NumberUtil.toDouble(iisCommonCO.getNoOfPayments()) < 0 || iisCommonCO.getNoOfPayments() == null)
	{
	    iisCommonCO.setNoOfPayments(BigDecimal.ZERO);
	}
	if(iisCommonCO.getPaymPeriodNbr() == null)
	{
	    iisCommonCO.setPaymPeriodNbr(BigDecimal.ZERO);
	}
	if(iisCommonCO.getPaymPeriodicity() == null)
	{
	    iisCommonCO.setPaymPeriodicity("D");
	}
	return iisCommonCO;
    }

    public IISCommonDAO getIisCommonDAO()
    {
	return iisCommonDAO;
    }

    public void setIisCommonDAO(IISCommonDAO iisCommonDAO)
    {
	this.iisCommonDAO = iisCommonDAO;
    }

    @Override
    public String returnHolidayActionDealDateYn(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.getHolidayActionDealDateYn(iisCommonCO);
    }

    @Override
    public IslamicCalculatorEventMgmtCO returnIISControlParams(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	return iisCommonDAO.getIISControlParams(islamicCalculatorEventMgmtCO);
    }

    @Override
    public IISCommonCO returnYieldFromRegister(IISCommonCO iisCommonCO) throws BaseException
    {
	BigDecimal orginalYield = BigDecimal.ZERO;
	// Added by Linchu to set the yield in all cases--88348
	iisCommonCO.setOrginalYield(orginalYield);
	if(iisCommonCO.getNoOfPayments() != null && iisCommonCO.getNoOfPayments().intValue() > 0)
	{
	    BigDecimal rosterRegister;

	    // Get the Register code for specific product
	    rosterRegister = iisCommonDAO.getRosterRegister(iisCommonCO);
	    if(rosterRegister == null)
	    {
		rosterRegister = BigDecimal.ZERO;
	    }
	    if(NumberUtil.toInt(rosterRegister) == 0)
	    {
		// Get the Register code for All product
		rosterRegister = iisCommonDAO.getRosterRegisterWithOutClass(iisCommonCO);
		if(rosterRegister == null)
		{
		    rosterRegister = BigDecimal.ZERO;
		}
	    }

	    if(NumberUtil.toInt(rosterRegister) == 0)
	    {
		return iisCommonCO;
	    }

	    // Get the Cif Type
	    BigDecimal cifType = iisCommonDAO.getCifType(iisCommonCO);

	    int noOfpayments = iisCommonCO.getNoOfPayments().intValue();
	    String paymPeriodicity = iisCommonCO.getPaymPeriodicity();
	    int periodicityNbr = calculatePeriodicity(paymPeriodicity, noOfpayments);
	    iisCommonCO.setRosterNoOfPayments(BigDecimal.valueOf(periodicityNbr));
	    iisCommonCO.setRosterRegisterCode(rosterRegister);

	    iisCommonCO.setEntityType("C");
	    iisCommonCO.setRosterEntityCode(iisCommonCO.getCifNo());
	    setYieldFromroster(iisCommonCO);
	    if(iisCommonCO.getRosterCodeModarib() == null && iisCommonCO.getRosterCodeyield() == null
		    && iisCommonCO.getRosterLineno() == null)
	    {
		iisCommonCO.setEntityType("T");
		iisCommonCO.setRosterEntityCode(cifType);
		setYieldFromroster(iisCommonCO);
		if(iisCommonCO.getRosterCodeModarib() == null && iisCommonCO.getRosterCodeyield() == null
			&& iisCommonCO.getRosterLineno() == null)
		{
		    iisCommonCO.setEntityType("A");
		    iisCommonCO.setRosterEntityCode(cifType);
		    setYieldFromroster(iisCommonCO);
		}
	    }

	    BigDecimal staffType = iisCommonDAO.getAccCifType(iisCommonCO);
	    if(NumberUtil.toInt(iisCommonCO.getRosterCodeyield()) > 0)
	    {
		BigDecimal staffYiled;
		String maintainSalaryAc = iisCommonDAO.getMaintainsalaryAc(iisCommonCO);
		if(NumberUtil.toInt(staffType) == NumberUtil.toInt(cifType))
		{
		    staffYiled = iisCommonDAO.getStaffYield(iisCommonCO);
		    orginalYield = staffYiled;
		}
		// else if(iisCommonCO.getSalaryWithBank().equals("N") ||
		// iisCommonCO.getSalaryWithBank().equals("Y")
		else if(ConstantsCommon.YES.equals(iisCommonCO.getSalaryWithBank())
			|| ConstantsCommon.YES.equals(maintainSalaryAc)
			|| IISCommonConstants.ON.equals(maintainSalaryAc))
		{
		    iisCommonCO.setSalaryWithBank(ConstantsCommon.YES);
		    orginalYield = iisCommonDAO.getYieldSalaryWithBank(iisCommonCO);
		}
		else
		{
		    iisCommonCO.setSalaryWithBank(ConstantsCommon.NO);
		    orginalYield = iisCommonDAO.getYieldSalaryWithBank(iisCommonCO);

		}
		iisCommonCO.setOrginalYield(orginalYield);
	    }

	    // if(iisCommonCO.getPartyType().equals("B"))
	    // {
	    // /*
	    // * BigDecimal orginalModaribYield;
	    // * if(NumberUtil.toInt(iisCommonCO.getRosterCodeModarib()) > 0)
	    // * { orginalModaribYield =
	    // * iisCommonDAO.getYieldModarib(iisCommonCO); }
	    // */
	    // }
	}
	iisCommonCO.setOrginalYield(orginalYield);
	return iisCommonCO;
    }

    private void setYieldFromroster(IISCommonCO iisCommonCO) throws BaseException
    {
	List<TRSROSTER_REGISTER_DETVO> trsrosterRegisterDetVO;// = new
	// ArrayList<TRSROSTER_REGISTER_DETVO>();
	TRSROSTER_REGISTER_DETVOKey trsrosterRegisterkey = new TRSROSTER_REGISTER_DETVOKey();
	trsrosterRegisterkey.setCOMP_CODE(iisCommonCO.getCompCode());
	trsrosterRegisterkey.setBRANCH_CODE(iisCommonCO.getBranchCode());
	trsrosterRegisterkey.setCODE(iisCommonCO.getRosterRegisterCode());
	trsrosterRegisterkey.setENTITY_TYPE(iisCommonCO.getEntityType());
	trsrosterRegisterkey.setLINE_NO(iisCommonCO.getRosterEntityCode());// in
	// mapper
	// line
	// no
	// is
	// mapped
	// to
	// ENTITY_CODE
	if(iisCommonCO.getEntityType().equals("A"))
	{
	    trsrosterRegisterDetVO = iisCommonDAO.getYeildRegisterAllCif(trsrosterRegisterkey);
	}
	else
	{
	    trsrosterRegisterDetVO = iisCommonDAO.getYeildRegisterCif(trsrosterRegisterkey);
	}
	for(int i = 0; i < trsrosterRegisterDetVO.size(); i++)
	{
	    BigDecimal PeriodicityNo = trsrosterRegisterDetVO.get(i).getPERIOD_NBR();
	    String yieldPeriodicityType = trsrosterRegisterDetVO.get(i).getPERIOD_TYPE();
	    int yieldPeriodicityNo = calculatePeriodicity(yieldPeriodicityType, PeriodicityNo.intValue());
	    /*
	     * if the currency type is specificS- Specific
	     */
	    if(trsrosterRegisterDetVO.get(i).getCURRENCY_TYPE().equals("S")
		    && NumberUtil.toInt(iisCommonCO.getCurrency()) != NumberUtil
			    .toInt(trsrosterRegisterDetVO.get(i).getCURRENCY_CODE()))
	    {

		continue;

	    }
	    Date fromDate = trsrosterRegisterDetVO.get(i).getFROM_DATE();
	    Date valueDate = iisCommonCO.getStartDate();
	    Date toDate = trsrosterRegisterDetVO.get(i).getTO_DATE();
	    // if adt_vdate >=
	    // ds_yield_register_cif.GetItemDatetime(ll_row,'from_date') and
	    // adt_vdate <=
	    // ds_yield_register_cif.GetItemDatetime(ll_row,'to_date') then
	    // if((valueDate != null && toDate != null && fromDate != null))
	    // &&
	    // (!(valueDate.after(fromDate) || fromDate.equals(valueDate)) &&
	    // (valueDate.before(toDate) || valueDate
	    // .equals(toDate))))
	    // if(!(valueDate.after(fromDate) || fromDate.equals(valueDate))
	    // && (valueDate.before(toDate) || valueDate.equals(toDate)))
	    // TP#246655; Ramesh; Date 21/12/2014[START]
	    if(((valueDate != null && toDate != null && fromDate != null))
		    && (valueDate.before(fromDate) || valueDate.after(toDate)))
	    {

		continue;
	    }
	    // TP#246655; Ramesh; Date 21/12/2014[END]
	    // System.out.println("First Date : " + fromDate);
	    // System.out.println("Second Date : " + valueDate);
	    // System.out.println("Is second date after first ? : " +
	    // valueDate.after(fromDate));

	    if(NumberUtil.nullToZero((trsrosterRegisterDetVO.get(i).getPAY_PLAN_TMPLT_ID())).intValue() >= 0
		    && NumberUtil.nullToZero(trsrosterRegisterDetVO.get(i).getPAY_PLAN_TMPLT_ID())
			    .intValue() != NumberUtil.toInteger(iisCommonCO.getTempCode()))
	    {

		continue;

	    }
	    if(NumberUtil.toDouble(trsrosterRegisterDetVO.get(i).getBALLOON_PERCENTAGE()) > 0)
	    {
		if(iisCommonCO.getBaloonPercentage() != null
			|| NumberUtil.toDouble(iisCommonCO.getBaloonPercentage()) == 0)
		{
		    continue;
		}
		if(NumberUtil.toDouble(iisCommonCO.getBaloonPercentage()) < NumberUtil
			.toDouble(trsrosterRegisterDetVO.get(i).getBALLOON_PERCENTAGE()))
		{
		    continue;
		}
	    }
	    if(NumberUtil.toInt(iisCommonCO.getRosterNoOfPayments()) >= yieldPeriodicityNo)
	    {
		iisCommonCO.setRosterCodeyield(trsrosterRegisterDetVO.get(i).getROSTER_CODE_YIELD());
		iisCommonCO.setRosterCodeModarib(trsrosterRegisterDetVO.get(i).getROSTER_CODE_MODARIB());
		iisCommonCO.setRosterLineno(trsrosterRegisterDetVO.get(i).getLINE_NO());
		break;
	    }
	}
    }

    private int calculatePeriodicity(String paymPeriodicity, int noOfpayments)
    {
	if(paymPeriodicity.equals(IISCommonConstants.DAY))
	{
	    return noOfpayments * 1;
	}
	else if(paymPeriodicity.equals(IISCommonConstants.WEEK))
	{
	    return noOfpayments * 7;
	}
	else if(paymPeriodicity.equals(IISCommonConstants.MONTH))
	{
	    return noOfpayments * 31;
	}
	else if(paymPeriodicity.equals(IISCommonConstants.YEAR))
	{
	    return noOfpayments * 365;
	}
	else
	{
	    return 0;
	}
    }

    @Override
    public IISCommonCO checkGracePeriod(IISCommonCO iisCommonCO) throws BaseException
    {
	TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	trsClassVOKey.setCOMP_CODE(iisCommonCO.getCompCode());
	trsClassVOKey.setCODE(iisCommonCO.getProductClass());
	TRSCLASSVO trsClassVO = iisCommonDAO.getGracePeriodClass(trsClassVOKey);
	// TP#205044;Roshin;22/07/2014 start
	BigDecimal classGracePeriod = null;
	String classGracePeriodicity = null;
	if(trsClassVO != null)
	{
	    classGracePeriod = trsClassVO.getGRACE_PERIOD_MAX_NBR();
	    classGracePeriodicity = trsClassVO.getGRACE_PERIOD_MAX_TYPE();
	}
	// TP#205044;Roshin;22/07/2014 end
	trsClassVOKey = null;
	trsClassVO = null;

	if(classGracePeriod == null)
	{
	    classGracePeriod = BigDecimal.ZERO;
	}
	if(classGracePeriodicity == null)
	{
	    classGracePeriodicity = "D";
	}
	if(NumberUtil.toInt(classGracePeriod) <= 0)
	{
	    return iisCommonCO;
	}
	int periodicityNo = 0;
	periodicityNo = calculatePeriodicity(classGracePeriodicity, classGracePeriod.intValue());
	classGracePeriod = BigDecimal.valueOf(periodicityNo);
	BigDecimal gracePeriod = iisCommonCO.getGracePeriod();
	String gracePeriodicity = iisCommonCO.getGracePeriodicity();
	if(gracePeriod == null)
	{
	    gracePeriod = BigDecimal.ZERO;
	}
	if(gracePeriodicity == null)
	{
	    gracePeriodicity = "D";
	}
	periodicityNo = calculatePeriodicity(gracePeriodicity, gracePeriod.intValue());
	gracePeriod = BigDecimal.valueOf(periodicityNo);
	if(NumberUtil.toInt(classGracePeriod) > 0
		&& (classGracePeriodicity != null && classGracePeriodicity.trim().length() > 0)
		&& NumberUtil.toInt(gracePeriod) > NumberUtil.toInt(classGracePeriod))
	{

	    throw new BOException(MessageCodes.GRACE_PER_EXCEEDS_LIM_DEF_PRODUCTCLASS);

	}
	return iisCommonCO;
    }

    /**
     * Method to calculate the Cif income
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     */
    public CIF_OCCUPATIONVO returnCifIncome(IISCommonCO iiSCommonCO) throws BaseException
    {
	return iisCommonDAO.getCifIncome(iiSCommonCO);
    }

    /*
     * private IISCommonCO getCifType(IISCommonCO iiSCommonCO) throws
     * BaseException { //iiSCommonCO = iisCommonDAO.getCifType(iiSCommonCO);
     * return iiSCommonCO; } private IISCommonCO getCifStaff(IISCommonCO
     * iiSCommonCO) throws BaseException { return
     * iisCommonDAO.isCifTypeStaff(iiSCommonCO); } //Method check
     * GetOutstandingDealAmount private BigDecimal
     * getOutstandingDealAmount(IISCommonCO iiSCommonCO) throws BaseException {
     * return iisCommonDAO.getOutstandingDealAmount(iiSCommonCO); } private
     * BigDecimal getOutstandingDealAmountForGuarantor(IISCommonCO iiSCommonCO)
     * throws BaseException { return
     * iisCommonDAO.getOutstandingDealAmountForGuarantor(iiSCommonCO); }
     */

    /**
     * Method calculate monthly installments
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    private ArrayList<IslamicCalculatorDBRatioSC> getMonthlyInstallmentsByCif(IISCommonCO iiSCommonCO)
	    throws BaseException
    {
	return (ArrayList<IslamicCalculatorDBRatioSC>) iisCommonDAO.getMonthlyInstallmentsByCif(iiSCommonCO);
    }

    public List<IslamicCalculatorDBRatioSC> calculateDBRatio(IISCommonCO iiSCommonCO) throws BaseException
    {
	List<IslamicCalculatorDBRatioSC> dbRatioVector = new ArrayList<IslamicCalculatorDBRatioSC>();

	IslamicCalculatorDBRatioSC islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	dbRatioVector.add(islamicCalculatorDBRatioSC);// Debt_Burden_Ratio_key

	IISCommonCO iisCommonForOccupation = new IISCommonCO();
	iisCommonForOccupation.setCompCode(iiSCommonCO.getCompCode());
	iisCommonForOccupation.setCifNo(iiSCommonCO.getCifNo());
	CIF_OCCUPATIONVO occupation = iisCommonDAO.getCifIncome(iisCommonForOccupation);

	double cifIncome = 0.0d, otherIncome = 0.0d, totalSalary = 0.0d, approvedSal = 0.0d;
	// if(occupation == null)
	// {
	// islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	// islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(0));//
	// // Customer_Monthly_Salary_key
	// dbRatioVector.add(islamicCalculatorDBRatioSC);
	// islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	// islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(0));//
	// // Other_Source_of_Income_key
	// dbRatioVector.add(islamicCalculatorDBRatioSC);
	// }
	// else if(occupation.getMONTHLY_BASIC_SALARY() == null ||
	// occupation.getOTHER_INCOME() == null)
	// {
	// islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	// islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(0));//
	// // Customer_Monthly_Salary_key
	// dbRatioVector.add(islamicCalculatorDBRatioSC);
	// islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	// islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(0));//
	// // Other_Source_of_Income_key
	// dbRatioVector.add(islamicCalculatorDBRatioSC);
	// }
	// else if((occupation != null) && (occupation.getMONTHLY_BASIC_SALARY()
	// != null))
	// {
	// cifIncome =
	// NumberUtil.toDouble(occupation.getMONTHLY_BASIC_SALARY());
	// }
	// else
	// {
	// cifIncome = 0;
	// }
	//
	// islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	//
	// islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(cifIncome));//
	// // Customer_Monthly_Salary_key
	// dbRatioVector.add(islamicCalculatorDBRatioSC);
	//
	// if((occupation != null) && (occupation.getOTHER_INCOME() != null))
	// {
	// otherIncome = NumberUtil.toDouble(occupation.getOTHER_INCOME());
	// }
	// else
	// {
	// otherIncome = 0;
	// }
	//
	// islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	// islamicCalculatorDBRatioSC.setDbrAmount(new
	// BigDecimal(otherIncome));// Other_Source_of_Income_key
	// dbRatioVector.add(islamicCalculatorDBRatioSC);

	if(occupation == null)
	{
	    islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	    islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.ZERO);// Customer_Monthly_Salary_key
	    dbRatioVector.add(islamicCalculatorDBRatioSC);
	    islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	    islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.ZERO);// Other_Source_of_Income_key
	    dbRatioVector.add(islamicCalculatorDBRatioSC);
	}
	else
	{
	    if(occupation.getMONTHLY_BASIC_SALARY() != null)
	    {
		cifIncome = NumberUtil.toDouble(occupation.getMONTHLY_BASIC_SALARY());
	    }
	    if(occupation.getOTHER_INCOME() != null)
	    {
		otherIncome = NumberUtil.toDouble(occupation.getOTHER_INCOME());
	    }

	    islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	    islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(cifIncome));// Customer_Monthly_Salary_key
	    dbRatioVector.add(islamicCalculatorDBRatioSC);

	    islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	    islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(otherIncome));// Other_Source_of_Income_key
	    dbRatioVector.add(islamicCalculatorDBRatioSC);
	}

	double cifApprovedSalary = 0d;
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = new IslamicCalculatorEventMgmtCO();
	islamicCalculatorEventMgmtCO.setCompCode(iiSCommonCO.getCompCode());
	islamicCalculatorEventMgmtCO.setBranchCode(iiSCommonCO.getBranchCode());
	islamicCalculatorEventMgmtCO = returnIISControlParams(islamicCalculatorEventMgmtCO);
	if(islamicCalculatorEventMgmtCO.getCalcDbrCalculationReqdYn().equals("Y"))
	{
	    cifApprovedSalary = iiSCommonCO.getCifApprovedSalary() == null ? 0D
		    : NumberUtil.toDouble(iiSCommonCO.getCifApprovedSalary());
	}
	else
	{
	    cifApprovedSalary = cifIncome;
	}

	if(NumberUtil.toDouble(cifApprovedSalary) <= 0)
	{
	    approvedSal = 0d;
	}
	approvedSal = NumberUtil.toDouble(cifApprovedSalary);
	totalSalary = approvedSal + otherIncome;
	islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(totalSalary));// Total_Salary_key
	dbRatioVector.add(islamicCalculatorDBRatioSC);

	islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	// IslamicCalculatorDBRatioSC.setDbramount(dbramount);//Direct_Customer_Exposure_key
	dbRatioVector.add(islamicCalculatorDBRatioSC);

	double ownInstallments = NumberUtil.toDouble(iisCommonDAO.getOutstandingDealAmount(iiSCommonCO));
	islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(-ownInstallments));// Own_Installments_key
	dbRatioVector.add(islamicCalculatorDBRatioSC);

	double totalInstallments = 0.0d;
	ArrayList<IslamicCalculatorDBRatioSC> monthlyinstallmentsList = getMonthlyInstallmentsByCif(iiSCommonCO);
	for(IslamicCalculatorDBRatioSC monthlyinstallment : monthlyinstallmentsList)
	{
	    double installmentAmount = NumberUtil.toDouble(monthlyinstallment.getDbrAmount());
	    totalInstallments = totalInstallments + (installmentAmount);
	    islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	    islamicCalculatorDBRatioSC.setDbrDetails(monthlyinstallment.getDbrDetails());
	    islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(-installmentAmount));
	    dbRatioVector.add(islamicCalculatorDBRatioSC);
	}
	monthlyinstallmentsList = null;

	double guarantorCommitments = NumberUtil
		.toDouble(iisCommonDAO.getOutstandingDealAmountForGuarantor(iiSCommonCO));
	islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf((-guarantorCommitments)));// Guarantors_Commitments_key
	dbRatioVector.add(islamicCalculatorDBRatioSC);

	islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(totalSalary - totalInstallments));// Net
	// Salary
	dbRatioVector.add(islamicCalculatorDBRatioSC);

	islamicCalculatorDBRatioSC = new IslamicCalculatorDBRatioSC();
	double grandTotal = totalSalary + (-totalInstallments) + (-guarantorCommitments) + (-ownInstallments);
	double dbrPercent = 1;
	if(iiSCommonCO.getProductClass() != null)
	{
	    dbrPercent = NumberUtil.toDouble(iisCommonDAO.getMaxDealInstPerOfSal(iiSCommonCO)) / 100;
	}

	double dbrPercentAmount = dbrPercent * totalSalary;
	islamicCalculatorDBRatioSC.setDbrAmount(BigDecimal.valueOf(grandTotal - dbrPercentAmount));// DB
	// Ration
	// Computation
	dbRatioVector.add(islamicCalculatorDBRatioSC);

	return dbRatioVector;
    }

    @Override
    /**
     * @author mvalappil- To return the given date is holiday(Y/N) and the next
     *         working day based on the action code
     * @param compCode
     * @param branchCode
     * @param date
     * @param currencyCode
     * @param actionCode - 0 - No action 1 - Last Working Day Before The
     *            Holidays 2 - First Working Day After The Holidays 3 - Last
     *            Working Day Before The Holidays But Value Dated On The Actual
     *            Due Day 4 - First Working Day After The Holidays But Value
     *            Dated On The Actual Due Day 5 - Modified Following Business
     *            Day (if the new date is not the same month need to rollback )
     * @param dateType - V - Value Date M - Maturity Date P - Plan Date D -
     *            Delivery Date s - Sales Date PV - Placement Value Date PM -
     *            Placement Maturity Date BV - Borrowing Value Date BM -
     *            Borrowing Maturity Date
     * @param maturityDateBeforeHolidayMonthEnd application only for dateType M
     *            and D
     * @param TrsdealCountryHolidayList
     * 
     * 
     *            list of countries
     * @return Map nextDate = next working day and holidayInd = given date is a
     *         holiday of not (Y/N)
     */
    public IISHolidayCheckCO checkCurrencyAndCountryHoliday(IISHolidayCheckCO iisHolidayCheckCO) throws BaseException
    {
	Date nextDay = iisHolidayCheckCO.getDate();

	String holidayInd = "N";
	iisHolidayCheckCO.setNewDate(nextDay);
	iisHolidayCheckCO.setHolidayYn(holidayInd);
	if(nextDay == null)
	{
	    return iisHolidayCheckCO;
	}

	if(iisHolidayCheckCO.getActionCode() == null)
	{
	    iisHolidayCheckCO.setActionCode(BigDecimal.ZERO);
	}
	if(NumberUtil.toDouble(iisHolidayCheckCO.getActionCode()) == 0)
	{
	    // return returncheckCurrencyHoliday(nextDay, holidayInd);
	    return iisHolidayCheckCO;
	}

	if(iisHolidayCheckCO.getApplyYearHoliday() == null)
	{
	    PTH_CTRLVO pthCTRLVO = commonLibBO.returnPthCtrl();
	    iisHolidayCheckCO.setApplyYearHoliday(pthCTRLVO.getAPPLY_YR_HOL());
	}

	if(iisHolidayCheckCO.getApplyYearHoliday().equals("Y") || iisHolidayCheckCO.getApplyYearHoliday().equals("1"))
	{
	    iisHolidayCheckCO.setApplyYearHoliday("Y");
	}
	else
	{
	    iisHolidayCheckCO.setApplyYearHoliday("N");
	}

	if(iisHolidayCheckCO.getMaturityDateBeforeHolidayMonthEnd() == null)
	{
	    iisHolidayCheckCO.setMaturityDateBeforeHolidayMonthEnd("N");
	}

	// 738706
	COUNTRY_CALENDARVO countryCalendarVO = null;
	COUNTRY_CALENDARVOKey countryCalendarVOKey = null;

	if(!NumberUtil.isEmptyDecimal(iisHolidayCheckCO.getCurrencyCode()))
	{
		countryCalendarVOKey = new COUNTRY_CALENDARVOKey();
	    countryCalendarVOKey.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
	    countryCalendarVOKey.setCOUNTRY_CODE(iisHolidayCheckCO.getCurrencyCode().negate());
	    countryCalendarVO = iisCommonDAO.getCountryCalendar(countryCalendarVOKey);
	}
	countryCalendarVOKey = new COUNTRY_CALENDARVOKey();
	if(countryCalendarVO == null)
	{
	    // return returncheckCurrencyHoliday(nextDay, holidayInd);
	    // iisHolidayCheckCO.setNewDate(nextDay);
	    // iisHolidayCheckCO.setHolidayYn(holidayInd);
	    // return iisHolidayCheckCO;
	    countryCalendarVO = new COUNTRY_CALENDARVO();
	}
	if(iisHolidayCheckCO.getTrsdealCountryHolidayList() == null)
	{
	    iisHolidayCheckCO.setTrsdealCountryHolidayList(new ArrayList<TRSDEAL_COUNTRY_HOLIDAYVO>());
	}

	if(countryCalendarVO.getHOL1() == null)
	{
	    countryCalendarVO.setHOL1("");
	}
	if(countryCalendarVO.getHOL2() == null)
	{
	    countryCalendarVO.setHOL2("");
	}
	if(countryCalendarVO.getHOL3() == null)
	{
	    countryCalendarVO.setHOL3("");
	}
	if(countryCalendarVO.getHOL4() == null)
	{
	    countryCalendarVO.setHOL4("");
	}

	countryCalendarVO.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
	countryCalendarVOKey.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
	Long countryCode = iisCommonDAO.getCountryCode(countryCalendarVOKey);
	countryCalendarVOKey = null;

	boolean loopInd = true;
	boolean holiday = false;
	boolean monthEndInd = false;
	do
	{
	    holiday = false;
	    String dayName = DateUtil.getDayShortName(nextDay);
	    if(countryCalendarVO.getHOL1().equals(dayName) || countryCalendarVO.getHOL2().equals(dayName)
		    || countryCalendarVO.getHOL3().equals(dayName) || countryCalendarVO.getHOL4().equals(dayName))
	    {
		holiday = true;
	    }
	    if(!holiday)
	    {
		// Check the day is in branch holiday
		BRANCH_HOLIDAYVO branchHolidayVO = new BRANCH_HOLIDAYVO();
		branchHolidayVO.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
		branchHolidayVO.setBRANCH_CODE(iisHolidayCheckCO.getBranchCode());
		branchHolidayVO.setMM_HOL(BigDecimal.valueOf(DateUtil.getDatePart("MM", nextDay)));
		branchHolidayVO.setDD_HOL(BigDecimal.valueOf(DateUtil.getDatePart("DD", nextDay)));
		if(iisHolidayCheckCO.getApplyYearHoliday().equals("Y")
			|| iisHolidayCheckCO.getApplyYearHoliday().equals("1"))
		{
		    branchHolidayVO.setYYYY_HOL(BigDecimal.valueOf(DateUtil.getDatePart("YYYY", nextDay)));
		}
		else
		{
		    branchHolidayVO.setYYYY_HOL(BigDecimal.valueOf(0L));
		}
		branchHolidayVO = iisCommonDAO.getBranchHoliday(branchHolidayVO);
		if(branchHolidayVO != null)
		{
		    holiday = true;
		}
	    }

	    if(!holiday)
	    {
		// Check the day is in Country holiday
		COUNTRY_HOLIDAYVO countryHolidayVO = new COUNTRY_HOLIDAYVO();
		countryHolidayVO.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
		countryHolidayVO.setCOUNTRY_CODE(BigDecimal.valueOf(countryCode));
		countryHolidayVO.setMM_HOL(BigDecimal.valueOf(DateUtil.getDatePart("MM", nextDay)));
		countryHolidayVO.setDD_HOL(BigDecimal.valueOf(DateUtil.getDatePart("DD", nextDay)));
		if(iisHolidayCheckCO.getApplyYearHoliday().equals("Y"))
		{
		    countryHolidayVO.setYYYY_HOL(BigDecimal.valueOf(DateUtil.getDatePart("YYYY", nextDay)));
		}
		else
		{
		    countryHolidayVO.setYYYY_HOL(BigDecimal.valueOf(0L));
		}
		countryHolidayVO = iisCommonDAO.getCountryHoliday(countryHolidayVO);
		if(countryHolidayVO != null)
		{
		    holiday = true;
		}
	    }

	    if(!holiday)
	    {
		// Check the day is in Country holiday
		COUNTRY_HOLIDAYVO countryHolidayVO = new COUNTRY_HOLIDAYVO();
		countryHolidayVO.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
		countryHolidayVO.setCOUNTRY_CODE(BigDecimal.valueOf(countryCode * -1));//
		countryHolidayVO.setMM_HOL(BigDecimal.valueOf(DateUtil.getDatePart("MM", nextDay)));
		countryHolidayVO.setDD_HOL(BigDecimal.valueOf(DateUtil.getDatePart("DD", nextDay)));
		if(iisHolidayCheckCO.getApplyYearHoliday().equals("Y"))
		{
		    countryHolidayVO.setYYYY_HOL(BigDecimal.valueOf(DateUtil.getDatePart("YYYY", nextDay)));
		}
		else
		{
		    countryHolidayVO.setYYYY_HOL(BigDecimal.valueOf(0L));
		}
		countryHolidayVO = iisCommonDAO.getCountryHoliday(countryHolidayVO);
		if(countryHolidayVO != null)
		{
		    holiday = true;
		}
	    }
	    if(!holiday)
	    {
		// Checking the trsdeal country holiday
		for(TRSDEAL_COUNTRY_HOLIDAYVO trsDealCountryHolidayVO : iisHolidayCheckCO
			.getTrsdealCountryHolidayList())
		{
		    COUNTRY_HOLIDAYVO countryHolidayVO = new COUNTRY_HOLIDAYVO();
		    countryHolidayVO.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
		    countryHolidayVO.setCOUNTRY_CODE(trsDealCountryHolidayVO.getCOUNTRY_CODE());
		    countryHolidayVO.setMM_HOL(BigDecimal.valueOf(DateUtil.getDatePart("MM", nextDay)));
		    countryHolidayVO.setDD_HOL(BigDecimal.valueOf(DateUtil.getDatePart("DD", nextDay)));
		    if(iisHolidayCheckCO.getApplyYearHoliday().equals("Y"))
		    {
			countryHolidayVO.setYYYY_HOL(BigDecimal.valueOf(DateUtil.getDatePart("YYYY", nextDay)));
		    }
		    else
		    {
			countryHolidayVO.setYYYY_HOL(BigDecimal.valueOf(0L));
		    }
		    countryHolidayVO = iisCommonDAO.getCountryHoliday(countryHolidayVO);
		    if(countryHolidayVO != null)
		    {
			holiday = true;
			break;
		    }
		}
	    }

	    if(holiday)
	    {
		// if the day is a holiday
		holidayInd = "Y";
		// Modifed by Manoj on 15/02/2018 for ICT Holiday modification
		// added type 5

		if(NumberUtil.toDouble(iisHolidayCheckCO.getActionCode()) == 1D
			|| NumberUtil.toDouble(iisHolidayCheckCO.getActionCode()) == 3D)
		{
		    nextDay = DateUtil.dateAdd(DateUtil.DAY, -1L, nextDay);
		}
		else if(NumberUtil.toDouble(iisHolidayCheckCO.getActionCode()) == 2D
			|| NumberUtil.toDouble(iisHolidayCheckCO.getActionCode()) == 4D
			|| NumberUtil.toDouble(iisHolidayCheckCO.getActionCode()) == 5D)// 5
											// is
		{
		    if(NumberUtil.toDouble(iisHolidayCheckCO.getActionCode()) == 5D
			    && nextDay.equals(DateUtil.getMonthLastDay(nextDay)))
		    {
			monthEndInd = true;
		    }

		    if(((iisHolidayCheckCO.getMaturityDateBeforeHolidayMonthEnd().equals("Y"))
			    && nextDay.equals(DateUtil.getMonthLastDay(nextDay))
			    && (iisHolidayCheckCO.getDateType().equals("M")
				    || iisHolidayCheckCO.getDateType().equals("D")))
			    || monthEndInd)
		    {
			nextDay = DateUtil.dateAdd(DateUtil.DAY, -1L, nextDay);
			monthEndInd = true;
		    }
		    else
		    {
			nextDay = DateUtil.dateAdd(DateUtil.DAY, 1L, nextDay);
		    }
		}
		else
		{
		    nextDay = DateUtil.dateAdd(DateUtil.DAY, 1L, nextDay);
		}
	    }
	    else
	    {
		// if the day is not holiday
		loopInd = false; // To stop the loop
		break;
	    }

	}while(loopInd);

	// return returncheckCurrencyHoliday(nextDay, holidayInd);
	iisHolidayCheckCO.setNewDate(nextDay);
	iisHolidayCheckCO.setHolidayYn(holidayInd);
	return iisHolidayCheckCO;
    }

    public IISHolidayCheckCO checkValueDateIsHoliday(IISHolidayCheckCO iisHolidayCheckCOParam) throws BaseException
    {
	IISHolidayCheckCO iisHolidayCheckCO = iisHolidayCheckCOParam;
	Date nextDay = iisHolidayCheckCO.getDate();
	TRSCLASSVOKey trsClassKey = new TRSCLASSVOKey();
	TRSCLASSVO trsClassVO;// = new TRSCLASSVO();
	iisHolidayCheckCO.setNewDate(nextDay);
	iisHolidayCheckCO.setHolidayYn("N");
	if(iisHolidayCheckCO.getHolidayActionDealValueDate() == null)
	{
	    iisHolidayCheckCO.setHolidayActionDealValueDate("N");
	}
	if(iisHolidayCheckCO.getDateType() == null)
	{
	    iisHolidayCheckCO.setDateType("M");
	}
	String checkHolidayAction = "N";
	if(iisHolidayCheckCO.getHolidayActionDealValueDate().equals("N") && iisHolidayCheckCO.getDateType().equals("V"))
	{
	    checkHolidayAction = "N";
	}
	else
	{
	    checkHolidayAction = "Y";
	}

	if(iisHolidayCheckCO.getCompCode() == null)
	{
	    iisHolidayCheckCO.setCompCode(BigDecimal.ZERO);
	}

	if(iisHolidayCheckCO.getProductClassCode() == null)
	{
	    iisHolidayCheckCO.setProductClassCode(BigDecimal.ZERO);
	}

	trsClassKey.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
	trsClassKey.setCODE(iisHolidayCheckCO.getProductClassCode());
	trsClassVO = iisCommonDAO.getHolidayActions(trsClassKey);

	if(checkHolidayAction.equals(ConstantsCommon.YES))
	{
	    if(iisHolidayCheckCO.getActionCode() == null || iisHolidayCheckCO.getHolidayMessageAction() == null)
	    {
		if(trsClassVO == null)
		{
		    return iisHolidayCheckCO;
		}
		else
		{
		    iisHolidayCheckCO.setActionCode(trsClassVO.getHOLIDAY_ACTION());
		    iisHolidayCheckCO.setHolidayMessageAction(trsClassVO.getHOLIDAY_ACTION_WARNING_IND());
		}
	    }
	    iisHolidayCheckCO = checkCurrencyAndCountryHoliday(iisHolidayCheckCO);
	}
	checkAllowBackDealValueDate(iisHolidayCheckCO);
	return iisHolidayCheckCO;
    }

    public IISHolidayCheckCO checkAllowBackDealValueDate(IISHolidayCheckCO iisHolidayCheckCO) throws BaseException
    {
	TRSCLASSVOKey trsClassKey = new TRSCLASSVOKey();
	TRSCLASSVO trsClassVO;// = new TRSCLASSVO();

	if(iisHolidayCheckCO.getCompCode() == null)
	{
	    iisHolidayCheckCO.setCompCode(BigDecimal.ZERO);
	}

	if(iisHolidayCheckCO.getProductClassCode() == null)
	{
	    iisHolidayCheckCO.setProductClassCode(BigDecimal.ZERO);
	}

	trsClassKey.setCOMP_CODE(iisHolidayCheckCO.getCompCode());
	trsClassKey.setCODE(iisHolidayCheckCO.getProductClassCode());

	trsClassVO = iisCommonDAO.getHolidayActions(trsClassKey);

	if(iisHolidayCheckCO.getDateType().equals("V") && trsClassVO != null
		&& trsClassVO.getDEAL_ALLOW_BACK_VDATE_TRANS_YN().equals("N")
		&& iisHolidayCheckCO.getSystemDate() != null && iisHolidayCheckCO.getDealValueDate() != null
		&& iisHolidayCheckCO.getDealValueDate().before(iisHolidayCheckCO.getSystemDate()))
	{
	    throw new BOException(MessageCodes.DEAL_VALUE_DATE_CANNOT_LESS_SYSDATE);
	}
	return iisHolidayCheckCO;
    }

    @Override
    public Double returnVatPercentage1(IISCommonCO iiSCommonCO) throws BaseException
    {
	if(iiSCommonCO.getVatCode() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	}
	if(iiSCommonCO.getStartDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_VALUE_DATE);
	}

	Double vatpercentage = 0d;
	vatpercentage = iisCommonDAO.getVatPercentage(iiSCommonCO);
	if(vatpercentage == null)
	{
	    vatpercentage = iisCommonDAO.getVatPercentageWithNoDate(iiSCommonCO);
	}
	if(vatpercentage == null)
	{
	    throw new BOException(MessageCodes.NULL_VAT_PERCENTAGE);
	}
	return vatpercentage;
    }

    @Override
    public BigDecimal returnHolidayAction(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.getHolidayAction(iisCommonCO);
    }

    @Override
    public TRSCLASSVO returnHolidayActions(TRSCLASSVOKey trsclasskey) throws BaseException
    {
	return iisCommonDAO.getHolidayActions(trsclasskey);
    }

    @Override
    public IISCommonCO returnExchangeRate(IISCommonCO iisCommonCO) throws BaseException
    {
	BigDecimal exchangeRateCurrency = NumberUtil.emptyDecimalToZero(iisCommonCO.getExchangeRateCurrency());

	BigDecimal baseCurrency = NumberUtil.emptyDecimalToZero(iisCommonCO.getBaseCurrencyCode());

	if(exchangeRateCurrency.compareTo(BigDecimal.ZERO) == 0 || baseCurrency.compareTo(BigDecimal.ZERO) == 0)
	{
	    throw new BOException(MessageCodes.INVALID_CURRENCY_CODE);
	}

	if(iisCommonCO.getExchangeDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_DATE);
	}

	if(exchangeRateCurrency.compareTo(baseCurrency) == 0)
	{
	    iisCommonCO.setExchageRate(BigDecimal.ONE);
	    return iisCommonCO;
	}

	Date maximumDateRate = iisCommonDAO.getMaximumDateRate(iisCommonCO);

	if(maximumDateRate == null)
	{
	    throw new BOException(MessageCodes.EXCHANGE_RATE_CANNONT_BE_LESS_OR_EQUAL_TO_ZERO);
	}
	else
	{
	    iisCommonCO.setMaximumDateRate(maximumDateRate);
	}

	BigDecimal exchageRate = iisCommonDAO.getExchangeRateWrtDate(iisCommonCO);

	if(exchageRate == null)
	{
	    throw new BOException(MessageCodes.EXCHANGE_RATE_CANNONT_BE_LESS_OR_EQUAL_TO_ZERO);
	}

	iisCommonCO.setExchageRate(exchageRate);

	return iisCommonCO;
    }

    @Override
    public IISCommonCO returnCrossRate(IISCommonCO iisCommonCO) throws BaseException
    {

	TrxMgntSC trxMgntSC = new TrxMgntSC();
	trxMgntSC.setCompCode(iisCommonCO.getCompCode());
	trxMgntSC.setBranchCode(iisCommonCO.getBranchCode());
	trxMgntSC.setFrCy(iisCommonCO.getTrCurrency());
	trxMgntSC.setToCy(iisCommonCO.getPfCurrency());
	trxMgntSC.setBaseCurrencyCode(iisCommonCO.getBaseCurrencyCode());
	trxMgntSC.setRunningDate(iisCommonCO.getCrossDate());
	trxMgntSC.setCif(iisCommonCO.getCifNo());

	trxMgntSC = coreCommonBO.returnCrossRate(trxMgntSC);

	// Added by Mathew to handle when Exchange rate not defined for currency
	if(trxMgntSC == null || NumberUtil.nullToZero(trxMgntSC.getExchRate()).compareTo(BigDecimal.ZERO) <= 0)
	{
	    trxMgntSC.setExchRate(BigDecimal.ONE);
	    // throw new BOException(MessageCodes.INVALID_EXCHANGE_RATE);
	}
	// if(trxMgntSC == null)
	// {
	// iisCommonCO.setCrossRate(BigDecimal.ONE);
	// }
	else
	{
	    iisCommonCO.setCrossRate(trxMgntSC.getExchRate());
	}

	return iisCommonCO;
    }

    public IISCommonCO returnDaysAfterMaximumPeriod(IISCommonCO iisCommonCO) throws BaseException
    {
	if(iisCommonDAO.getDaysAfterMaximumPeriod(iisCommonCO) != null)
	{
	    iisCommonCO
		    .setDaysAfterMaximumPeriod(BigDecimal.valueOf(iisCommonDAO.getDaysAfterMaximumPeriod(iisCommonCO)));
	}
	return iisCommonCO;
    }

    /*
     * private static final double doubleValue(Object o) { return
     * NumberUtil.toDouble(o);
     * 
     * }
     */

    public CURRENCIESVO returnCurrencyDetails(CURRENCIESVOKey currenciesVOKey) throws BaseException
    {
	return iisCommonDAO.getCurrencyDetails(currenciesVOKey);
    }

    @Override
    public TRSVAT_PERIODVO returnVatPercentage1(TRSVAT_PERIODVO trsvatPERIODVO) throws BaseException
    {
	IISCommonCO iisCommonCO = new IISCommonCO();
	iisCommonCO.setCompCode(trsvatPERIODVO.getCOMP_CODE());
	iisCommonCO.setVatCode(trsvatPERIODVO.getVAT_CODE());
	iisCommonCO.setStartDate(trsvatPERIODVO.getFROM_DATE());

	if(iisCommonCO.getVatCode() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	}
	if(iisCommonCO.getStartDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_VALUE_DATE);
	}

	Double vatpercentage = 0d;
	vatpercentage = iisCommonDAO.getVatPercentage(iisCommonCO);
	if(vatpercentage == null)
	{
	    trsvatPERIODVO.setFROM_DATE(null);
	    vatpercentage = iisCommonDAO.getVatPercentageWithNoDate(iisCommonCO);
	}
	if(vatpercentage == null)
	{
	    throw new BOException(MessageCodes.NULL_VAT_PERCENTAGE);
	}

	trsvatPERIODVO.setPERCENTAGE(BigDecimal.valueOf(vatpercentage));

	return trsvatPERIODVO;
    }

    @Override
    public BigDecimal returnAmountWithCurrencyDecimalForMaxMin(BigDecimal amountParam, int decimalPoint, String MinMax)
	    throws BaseException
    {
	BigDecimal amount = amountParam;
	String minDec = "0";
	String maxDec = "9";

	// String minDecVal = "0.0";
	// String maxDecVal = "0.9";
	StringBuffer bufMinDec = new StringBuffer("0.0");
	StringBuffer bufMaxDec = new StringBuffer("0.9");

	for(int i = 1; i < decimalPoint; i++)
	{
	    // minDecVal = minDecVal + minDec;
	    // maxDecVal = maxDecVal + maxDec;
	    bufMinDec.append(minDec);
	    bufMaxDec.append(maxDec);
	}
	String minDecVal = bufMinDec.toString();
	String maxDecVal = bufMaxDec.toString();
	if(MinMax.equals(IISCommonConstants.MAX))
	{
	    amount = amount.add(BigDecimal.valueOf(NumberUtil.toDouble(maxDecVal)));
	}
	else
	{
	    amount = amount.add(BigDecimal.valueOf(NumberUtil.toDouble(minDecVal)));
	}

	return NumberUtil.roundToBigDecimal(amount, decimalPoint);

    }

    @Override
    public String returnRifStaff(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.getRifStaff(iisCommonCO);
    }

    public BigDecimal returnCifType(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.getCifType(iisCommonCO);
    }

    @Override
    public IISCommonCO returnUsrAccess(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.getUsrAccess(iisCommonCO);
    }

    @Override
    public IISCTRLVO returnIISCTRL(IISCTRLVOKey iisctrlvoKey) throws BaseException
    {
	IISCTRLVO iisControlVO = new IISCTRLVO();
	iisControlVO.setCOMP_CODE(iisctrlvoKey.getCOMP_CODE());
	iisControlVO.setBRANCH_CODE(iisctrlvoKey.getBRANCH_CODE());
	return commonLibBO.returnIISControlDetails(iisControlVO);
    }

    @Override
    public USRVO returnUsrDetailsIIS(USRVO usrvo) throws BaseException
    {
	return iisCommonDAO.getUsrDetailsIIS(usrvo);
    }

    @Override
    public boolean returnIsIisApplication(String appName) throws BaseException
    {
	if(appName.equals(ConstantsCommon.ITRS_APP_NAME) || appName.equals(ConstantsCommon.IIS_APP_NAME)
		|| appName.equals(ConstantsCommon.ICOR_APP_NAME) || appName.equals(ConstantsCommon.IRET_APP_NAME)
		|| appName.equals(ConstantsCommon.LEND_APP_NAME) || appName.equals(ConstantsCommon.LCOR_APP_NAME)

		|| appName.equals(ConstantsCommon.LRET_APP_NAME) || appName.equals(ConstantsCommon.PROV_APP_NAME)

		|| appName.equals(ConstantsCommon.IVRL_APP_NAME) || appName.equals(ConstantsCommon.IMIG_APP_NAME)
		|| appName.equals(ConstantsCommon.IPRC_APP_NAME) || appName.equals(ConstantsCommon.IRVL_APP_NAME))
	{
	    return true;
	}
	return false;
    }

    @Override
    public Double getMonthsAndDayDifferance(Date dateFrom, Date dateTo) throws BaseException
    {
	Calendar calFrom = Calendar.getInstance();
	Calendar calTo = Calendar.getInstance();
	calFrom.setTime(dateFrom);
	calTo.setTime(dateTo);

	int year1 = calFrom.get(Calendar.YEAR);
	int year2 = calTo.get(Calendar.YEAR);
	int month1 = calFrom.get(Calendar.MONTH) + 1;
	int month2 = calTo.get(Calendar.MONTH) + 1;

	boolean fromLastMonth = false;
	boolean toLastMonth = false;
	int calculationMethod = 1;
	Date newFromDate = dateFrom;
	long days = 1L;
	long monthDiff = 0L;

	Date fromLastDay = DateUtil.getMonthLastDay(dateFrom);
	if(fromLastDay.equals(dateFrom))
	{
	    fromLastMonth = true;
	}
	Date toLastDay = DateUtil.getMonthLastDay(dateTo);
	if(toLastDay.equals(dateTo))
	{
	    toLastMonth = true;
	}
	if(toLastMonth && fromLastMonth)
	{
	    calculationMethod = 1;
	}
	else if(fromLastMonth)
	{
	    calculationMethod = 1;
	}
	monthDiff = ((year2 * 12) + month2) - ((year1 * 12) + month1);
	newFromDate = DateUtil.dateAdd(DateUtil.MONTH, monthDiff, dateFrom);
	switch (calculationMethod)
	{
	    case 1:
		if(toLastMonth && fromLastMonth)
		{
		    newFromDate = DateUtil.getMonthLastDay(newFromDate);
		}
		days = DateUtil.numberOfDays(newFromDate, dateTo);
		if(days < 0L)
		{
		    if((!toLastMonth) && fromLastMonth)
		    {

			monthDiff = monthDiff - 1;
			newFromDate = DateUtil.createDate(year2, month2 - 1, 01);
			newFromDate = DateUtil.dateAdd("DD", -1L, newFromDate);
			days = DateUtil.numberOfDays(newFromDate, dateTo);

		    }
		    else
		    {
			monthDiff = monthDiff - 1;
			newFromDate = DateUtil.dateAdd(DateUtil.MONTH, monthDiff, dateFrom);
			days = DateUtil.numberOfDays(newFromDate, dateTo);
		    }
		}
		break;
	    case 2:
		newFromDate = DateUtil.getMonthLastDay(newFromDate);
		newFromDate = DateUtil.getMonthLastDay(newFromDate);
		monthDiff--;
		days = DateUtil.getDatePart("DD", dateTo);
		break;
	    default:
		break;
	}

	double monthDay = monthDiff + days / 100D;
	// long Month = (long) monthDay;
	// double day = NumberUtil.round((monthDay - Month) * 100D, 0L);

	return monthDay;
    }

    public CoreCommonBO getCoreCommonBO()
    {
	return coreCommonBO;
    }

    public void setCoreCommonBO(CoreCommonBO coreCommonBO)
    {
	this.coreCommonBO = coreCommonBO;
    }

    @Override
    public String returnIISCTRL_ADDITIONAL_PARAM(BigDecimal compCode, BigDecimal branchCode, BigDecimal code)
	    throws BaseException
    {
	IISCTRL_ADDITIONAL_PARAMVOKey iisctrlAddParamVOKey = new IISCTRL_ADDITIONAL_PARAMVOKey();
	IISCTRL_ADDITIONAL_PARAMVO iisctrlAddParamVO;

	iisctrlAddParamVOKey.setCOMP_CODE(compCode);
	iisctrlAddParamVOKey.setBRANCH_CODE(branchCode);
	iisctrlAddParamVOKey.setCODE(code);

	iisctrlAddParamVO = (IISCTRL_ADDITIONAL_PARAMVO) genericDAO.selectByPK(iisctrlAddParamVOKey);

	if(iisctrlAddParamVO == null)
	{
	    return "";
	    // throw new BOException(900007, new String[] {
	    // "Error_Reading_Control_Record_Additional_Parameters_Key" },
	    // false);
	}

	String dataValue = "";
	dataValue = iisctrlAddParamVO.getDATA_VALUE();

	return dataValue;
    }

    @Override
    public String returnIISCONTROLValyByKey(BigDecimal seqKey, String flagName) throws BaseException
    {
	return iisCommonDAO.returnIISCONTROLValyByKey(seqKey, flagName);
    }

    /***
     * Method for calculating the annual yield rate
     */
    @Override
    public IslamicCalculatorEventMgmtCO calculateTotalAnnualYield(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProfitCalcMethod() == null)
	{
	    return islamicCalculatorEventMgmtCO;
	}
	// IF(profit_calculation_method = 'S' , yield , ( ( profit_amt ) /
	// deal_amount ) * 100 * 365 / daysafter( value_date , maturity_date ))
	if(islamicCalculatorEventMgmtCO.getProfitCalcMethod() == null
		|| IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
			.equals(islamicCalculatorEventMgmtCO.getProfitCalcMethod()))
	{
	    Date startDate = islamicCalculatorEventMgmtCO.getStartDate();
	    Date maturityDate = islamicCalculatorEventMgmtCO.getMaturityDate();

	    if(startDate == null)
	    {
		throw new BOException(MessageCodes.INVALID_VALUE_DATE);
	    }

	    if(maturityDate == null)
	    {
		throw new BOException(MessageCodes.INVALID_MATURITY_DATE);
	    }

	    double daysafter = DateUtil.numberOfDays(startDate, maturityDate, "dd/MM/yyyy");
	    // Need to get from the result of the payplan.
	    double profitAmt = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getProfit());
	    double financingAmt = NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount());
	    double totalYield = 0;
	    if(profitAmt > 0 && financingAmt > 0 && daysafter > 0)
	    {
		totalYield = (profitAmt / financingAmt) * 100 * 365 / daysafter;
	    }
	    islamicCalculatorEventMgmtCO.setTotalYield(BigDecimal.valueOf(totalYield));
	}
	else if(IISCommonConstants.PROFIT_CALCULATION_METHOD_STRAIGHT_LINE
		.equals(islamicCalculatorEventMgmtCO.getProfitCalcMethod()))
	{
	    islamicCalculatorEventMgmtCO.setTotalYield(islamicCalculatorEventMgmtCO.getYield());
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [Begin]
	if(!IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
		.equals(islamicCalculatorEventMgmtCO.getProfitCalcMethod())
		&& ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn()))
	{
	    throw new BOException(
		    MessageCodes.FLEXI_PAYMENTS_APPLICABLE_ONLY_IF_CALCULATION_METHOD_IS_DIMINISHING_RETURNS);
	}
	// BB160136; Saheer.Naduthodi; 20/04/2017 [End]
	return islamicCalculatorEventMgmtCO;
    }

    // f_get_outstanding_principal
    /**
     * @author Ramesh.Lekkala
     */
    // TP#253460; Ramesh; Date 29/12/2014
    @Override
    public BigDecimal returnOutStandingPrincipal(BigDecimal dealNo, BigDecimal compCode, BigDecimal branchCode)
	    throws BaseException
    {
	if(dealNo == null)
	{
	    return BigDecimal.valueOf(-1);
	}
	TRSDEALVOKey trsdealvoKey = new TRSDEALVOKey();

	BigDecimal llCount = NumberUtil.nullToZero(iisCommonDAO.returnTrsDealCount(trsdealvoKey));
	if(llCount.compareTo(BigDecimal.ONE) != 0)
	{
	    return BigDecimal.valueOf(-2);
	}
	TRSDEALVO trsdealvo = (TRSDEALVO) genericDAO.selectByPK(trsdealvoKey);
	TRSCLASSVOKey trsclassvoKey = new TRSCLASSVOKey();
	trsclassvoKey.setCOMP_CODE(compCode);
	trsclassvoKey.setCODE(trsdealvo.getCLASS());
	BigDecimal trsClassCount = NumberUtil.nullToZero(iisCommonDAO.returnTrsClassCount(trsclassvoKey));
	if(trsClassCount.compareTo(BigDecimal.ONE) != 0)
	{
	    return BigDecimal.valueOf(-3);
	}

	BigDecimal settlementDivision = iisCommonDAO.returnSettlementDivision(trsclassvoKey);

	TRSDEAL_STLMT_APTNMTVOKey trsdealSTLMTAPTNMTVOKey = new TRSDEAL_STLMT_APTNMTVOKey();
	trsdealSTLMTAPTNMTVOKey.setCOMP_CODE(compCode);
	trsdealSTLMTAPTNMTVOKey.setBRANCH_CODE(branchCode);
	trsdealSTLMTAPTNMTVOKey.setSERIAL_NO(dealNo);
	BigDecimal dealStlmntAptNmt = NumberUtil
		.nullToZero(iisCommonDAO.returnCountTrsSelmntAptNmt(trsdealSTLMTAPTNMTVOKey));
	if(dealStlmntAptNmt.compareTo(BigDecimal.ZERO) > 0)
	{
	    settlementDivision = BigDecimal.valueOf(3);
	}
	CURRENCIESVOKey currenciesvoKey = new CURRENCIESVOKey();
	currenciesvoKey.setCOMP_CODE(compCode);
	currenciesvoKey.setCURRENCY_CODE(trsdealvo.getDEAL_CY());
	BigDecimal currenciesCount = iisCommonDAO.returnCurrenciesCount(currenciesvoKey);
	if(currenciesCount.compareTo(BigDecimal.ONE) != 0)
	{
	    return BigDecimal.valueOf(-4);
	}
	CURRENCIESVO currenciesvo = returnCurrencyDetails(currenciesvoKey);
	BigDecimal llUnit = currenciesvo.getDECIMAL_POINTS();
	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setCOMP_CODE(compCode);
	iisctrlvoKey.setBRANCH_CODE(branchCode);
	String limitBasedOn = StringUtil.nullEmptyToValue(iisCommonDAO.returnIISCtrlLimitBasedOn(iisctrlvoKey), "P");
	TRSPAYPLANVO trspayplanvo = new TRSPAYPLANVO();
	TRSPAYPLANDETVO trspayplandetvo = iisCommonDAO.returnSumOfCapitalAmtAndCptlAmtBeforeXirr(trspayplanvo);
	BigDecimal ldecCompleteOutstandingPrincipal = NumberUtil
		.nullToZero(trspayplandetvo.getCAPITAL_AMT_BEFORE_XIRR());
	BigDecimal ldecCompleteOutstandingPrincipalxirr = NumberUtil.nullToZero(trspayplandetvo.getCAPITAL_AMT());
	trspayplandetvo = iisCommonDAO.returnTrsPayplanDetSumofValues(trspayplanvo);

	BigDecimal ldecPrincipal = NumberUtil.nullToZero(trspayplandetvo.getCAPITAL_AMT_BEFORE_XIRR());
	BigDecimal ldecProfit = NumberUtil.nullToZero(trspayplandetvo.getPROFIT_AMT_BEFORE_XIRR());
	BigDecimal ldecSettlement = NumberUtil.nullToZero(trspayplandetvo.getSETTLEMENT_AMOUNT());
	BigDecimal ldecPrincipalXIRR = NumberUtil.nullToZero(trspayplandetvo.getCAPITAL_AMT());
	BigDecimal ldecProfitXIRR = NumberUtil.nullToZero(trspayplandetvo.getPROFIT_AMT());
	BigDecimal ldecPartialSettledPrincipal = NumberUtil.nullToZero(trspayplandetvo.getSETTLED_CAPITAL_AMT());
	// BigDecimal ldecPartialSettledProfit =
	// NumberUtil.nullToZero(trspayplandetvo.getSETTLED_PROFIT_AMT());
	BigDecimal ldecWaivedProfit = NumberUtil.nullToZero(trspayplandetvo.getWAIVED_PROFIT_AMT());
	if(ldecWaivedProfit.compareTo(BigDecimal.ZERO) > 0)
	{
	    settlementDivision = BigDecimal.valueOf(3);
	}

	if(!limitBasedOn.equals(IISCommonConstants.LIMIT_REINSTATE_BASED_ON_PRINCIPAL))
	{
	    ldecCompleteOutstandingPrincipal = ldecCompleteOutstandingPrincipalxirr;
	    ldecPrincipal = ldecPrincipalXIRR;
	    ldecProfit = ldecProfitXIRR;
	}
	BigDecimal ldec_Partial_Outstanding_Principal = BigDecimal.ZERO;
	switch (settlementDivision.intValue())
	{
	    case 0:

		if((ldecPrincipal.add(ldecProfit)).compareTo(BigDecimal.ZERO) > 0)
		{
		    ldec_Partial_Outstanding_Principal = ((ldecPrincipal)
			    .subtract((ldecSettlement.multiply(ldecPrincipal)).divide((ldecPrincipal.add(ldecProfit)),
				    llUnit.intValue(), BigDecimal.ROUND_HALF_UP)));

		}
		else
		{
		    ldec_Partial_Outstanding_Principal = BigDecimal.ZERO;
		}

		break;

	    case 1:

		if(ldecSettlement.compareTo(ldecProfit) > 0)
		{
		    ldec_Partial_Outstanding_Principal = ldecPrincipal.subtract(ldecSettlement.subtract(ldecProfit));
		}
		else
		{
		    ldec_Partial_Outstanding_Principal = ldecPrincipal;
		}

		break;
	    case 2:

		if(ldecSettlement.compareTo(ldecPrincipal) > 0)
		{
		    ldec_Partial_Outstanding_Principal = BigDecimal.ZERO;
		}
		else
		{
		    ldec_Partial_Outstanding_Principal = ldecPrincipal.subtract(ldecSettlement);
		}
		break;

	    default:

		if((ldecPrincipal.subtract(ldecPartialSettledPrincipal)).compareTo(BigDecimal.ZERO) > 0)
		{
		    ldec_Partial_Outstanding_Principal = ldecPrincipal.subtract(ldecPartialSettledPrincipal);
		}
		else
		{
		    ldec_Partial_Outstanding_Principal = BigDecimal.ZERO;
		}

		break;
	}
	BigDecimal ldec_Total_Outstanding_Principal = ldecCompleteOutstandingPrincipal
		.add(ldec_Partial_Outstanding_Principal);
	ldec_Total_Outstanding_Principal = BigDecimal
		.valueOf(NumberUtil.round(ldec_Total_Outstanding_Principal.doubleValue(), llUnit.intValue()));
	return ldec_Total_Outstanding_Principal;
    }

    /**
     * @author saheer.naduthodi
     * @modification BB130089
     * @date 14/05/2015
     */
    @Override
    public IISCustomerLimitCO validateGeneralCustomerLimit(IISCustomerLimitCO iisCustomerLimitCO) throws BaseException

    {
	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setCOMP_CODE(NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getCompCode()));
	iisctrlvoKey.setBRANCH_CODE(NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getBranchCode()));
	IISCTRLVO iisctrlvo = returnIISCTRL(iisctrlvoKey);
	iisctrlvoKey = null;
	if(iisctrlvo == null)
	{
	    throw new BOException(MessageCodes.CANNOT_RETRIEVE_CONTROL_RECORD);
	}

	BigDecimal generalCustomerLimit = NumberUtil.nullToZero(iisctrlvo.getCUSTOMER_LIMIT_AMOUNT());
	String messageType = StringUtil.nullEmptyToValue(iisctrlvo.getCUSTOMER_LIMIT_MESSAGE_TYPE(),
		ConstantsCommon.NO);
	if(ConstantsCommon.NO.equals(messageType))
	{
	    return iisCustomerLimitCO;
	}
	if(generalCustomerLimit.compareTo(BigDecimal.ZERO) == 0)
	{
	    throw new BOException("General Customer Limit is defined as zero");
	}
	BigDecimal dealAmount = NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getDealAmount());
	BigDecimal dealCY = NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getDealCY());

	BigDecimal baseCurrency = NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getBaseCurrencyCode());

	if(dealCY.compareTo(baseCurrency) != 0)
	{
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getCompCode()));
	    iisCommonCO.setExchangeRateCurrency(NumberUtil.emptyDecimalToZero(dealCY));
	    iisCommonCO.setBaseCurrencyCode(NumberUtil.emptyDecimalToZero(baseCurrency));
	    iisCommonCO.setRunningDate(DateUtil.nullToInitDate(iisCustomerLimitCO.getRunningDate()));
	    iisCommonCO.setExchangeDate(DateUtil.nullToInitDate(iisCustomerLimitCO.getRunningDate()));
	    iisCommonCO = returnExchangeRate(iisCommonCO);
	    if(iisCommonCO == null)
	    {
		iisCommonCO = new IISCommonCO();
	    }
	    BigDecimal exchangeRate = NumberUtil.nullToZero(iisCommonCO.getExchageRate());
	    iisCommonCO = null;
	    CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	    currenciesVOKey.setCOMP_CODE(NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getCompCode()));
	    currenciesVOKey.setCURRENCY_CODE(NumberUtil.emptyDecimalToZero(dealCY));
	    CURRENCIESVO currenciesvo = returnCurrencyDetails(currenciesVOKey);
	    currenciesVOKey = null;
	    if(currenciesvo == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	    }
	    if(ConstantsCommon.MULTIPLY.equals(StringUtil.nullToEmpty(currenciesvo.getMULT_DIV_IND())))
	    {
		dealAmount = dealAmount.multiply(exchangeRate).divide(currenciesvo.getUNIT());
	    }
	    else
	    {
		dealAmount = dealAmount.divide(exchangeRate).divide(currenciesvo.getUNIT());

	    }

	}
	BigDecimal outstandingTotalAmount;
	if(iisCustomerLimitCO.getRemainingAmount() == null)
	{
	    outstandingTotalAmount = NumberUtil.nullToZero(iisCommonDAO.returnOutstandingAmount(iisCustomerLimitCO));
	}
	else
	{
	    outstandingTotalAmount = NumberUtil.emptyDecimalToZero(iisCustomerLimitCO.getRemainingAmount());
	}
	if(generalCustomerLimit.compareTo(outstandingTotalAmount.add(NumberUtil.emptyDecimalToZero(dealAmount))) == -1)
	{

	    StringBuffer errorMessage = new StringBuffer();
	    errorMessage.append("Deal amount exceeds General Customer Limit. \nAvailable Limit is < ");
	    errorMessage.append(StringUtil.nullToEmpty(iisCustomerLimitCO.getBaseCurrencyDesc()));
	    errorMessage.append(" ");
	    int decimalPoint = NumberUtil.isEmptyDecimal(iisCustomerLimitCO.getBaseCurrencyDecimal()) ? 3
		    : iisCustomerLimitCO.getBaseCurrencyDecimal().intValue();
	    errorMessage.append(
		    NumberUtil.roundToBigDecimal(generalCustomerLimit.subtract(outstandingTotalAmount), decimalPoint));
	    errorMessage.append(" > only.");
	    if(IISCommonConstants.MESSAGE_TYPE_STOP.equals(messageType))
	    {

		throw new BOException(MessageCodes.iis_invalid_code, new String[] { errorMessage.toString() }, false);
	    }
	    else
	    {
		// LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
		if(IISCommonConstants.CALLED_FROM_LOS.equals(iisCustomerLimitCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_WS.equals(iisCustomerLimitCO.getCalledFrom()))
		{
		    iisCustomerLimitCO.setLosMessagesCO(new LOSmessagesCO());
		    iisCustomerLimitCO.getLosMessagesCO().setCode(BigDecimal.valueOf(MessageCodes.iis_invalid_code));
		    iisCustomerLimitCO.getLosMessagesCO().setType("C");
		    iisCustomerLimitCO.getLosMessagesCO().setDescription(errorMessage.toString());
		}
		// LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
		else
		{
		    throw new BOException(MessageCodes.iis_invalid_code, new String[] { errorMessage.toString() },
			    ConstantsCommon.CONFIRM_MSG_TYPE, "DEAL_AMOUNT_EXCEED_GENERAL_CUSTOMER_LIMIT", true);
		}
	    }
	}
	return iisCustomerLimitCO;

    }

    public void checkClassLimitTenure(IISCommonCO iisCommonCO) throws BaseException
    {
	if(ConstantsCommon.YES.equals(iisCommonCO.getAllowMultipleClassLimit())
		&& NumberUtil.emptyDecimalToZero(iisCommonCO.getLimitCode()).compareTo(BigDecimal.ZERO) == 0)
	{
	    return;
	}
	TRSCIFLIMITDETVO trsCifLimitdetvo = iisCommonDAO.returnClassLimitTenure(iisCommonCO);// Getting
	if(trsCifLimitdetvo != null)
	{
	    BigDecimal dealPeriodicityNbr = iisCommonCO.getPaymPeriodNbr();

	    BigDecimal periodicityNbr = NumberUtil.nullToZero(trsCifLimitdetvo.getPERIODICITY_NBR());

	    BigDecimal periodicityNbrMin = NumberUtil.nullToZero(trsCifLimitdetvo.getPERIODICITY_NBR_MIN());

	    if("W".equals(iisCommonCO.getPaymPeriodicity()))
	    {
		dealPeriodicityNbr = dealPeriodicityNbr.multiply(BigDecimal.valueOf(7));
	    }
	    if("M".equals(iisCommonCO.getPaymPeriodicity()))
	    {
		dealPeriodicityNbr = dealPeriodicityNbr.multiply(BigDecimal.valueOf(31));
	    }
	    if("Y".equals(iisCommonCO.getPaymPeriodicity()))
	    {
		dealPeriodicityNbr = dealPeriodicityNbr.multiply(BigDecimal.valueOf(365));
	    }

	    if("W".equals(trsCifLimitdetvo.getPERIODICITY_TYPE()))
	    {
		periodicityNbr = periodicityNbr.multiply(BigDecimal.valueOf(7));
	    }
	    if("M".equals(trsCifLimitdetvo.getPERIODICITY_TYPE()))
	    {
		periodicityNbr = periodicityNbr.multiply(BigDecimal.valueOf(31));
	    }
	    if("Y".equals(trsCifLimitdetvo.getPERIODICITY_TYPE()))
	    {
		periodicityNbr = periodicityNbr.multiply(BigDecimal.valueOf(365));
	    }

	    if("W".equals(trsCifLimitdetvo.getPERIODICITY_TYPE_MIN()))
	    {
		periodicityNbrMin = periodicityNbrMin.multiply(BigDecimal.valueOf(7));
	    }
	    if("M".equals(trsCifLimitdetvo.getPERIODICITY_TYPE_MIN()))
	    {
		periodicityNbrMin = periodicityNbrMin.multiply(BigDecimal.valueOf(31));
	    }
	    if("Y".equals(trsCifLimitdetvo.getPERIODICITY_TYPE_MIN()))
	    {
		periodicityNbrMin = periodicityNbrMin.multiply(BigDecimal.valueOf(365));
	    }

	    if(periodicityNbr.compareTo(BigDecimal.ZERO) == 1 && periodicityNbr.compareTo(dealPeriodicityNbr) == -1)
	    {
		if(IISCommonConstants.MESSAGE_TYPE_STOP.equals(trsCifLimitdetvo.getCHECK_DEAL_TENURE_TYPE()))
		{
		    throw new BOException(MessageCodes.TOTAL_PERIODS_EXCEEDS_COUNTER_PARTY_TENURE_PERIOD);

		}
		if(IISCommonConstants.MESSAGE_TYPEWARNING.equals(trsCifLimitdetvo.getCHECK_DEAL_TENURE_TYPE()))
		{
		    throw new BOException(MessageCodes.TOTAL_PERIODS_EXCEEDS_COUNTER_PARTY_TENURE_PERIOD_WARNING,
			    ConstantsCommon.CONFIRM_MSG_TYPE, "TOTAL_PERIODS_EXCEEDS_COUNTER_PARTY_TENURE_PERIOD",
			    true);
		}
	    }
	    if(periodicityNbrMin.compareTo(BigDecimal.ZERO) == 1
		    && periodicityNbrMin.compareTo(dealPeriodicityNbr) == 1)
	    {

		if(IISCommonConstants.MESSAGE_TYPE_STOP.equals(trsCifLimitdetvo.getCHECK_DEAL_TENURE_TYPE()))
		{
		    throw new BOException(MessageCodes.TOTAL_PERIOD_IS_LESS_THAN_COUNTER_PARTY_MIN_TENURE);

		}
		if(IISCommonConstants.MESSAGE_TYPEWARNING.equals(trsCifLimitdetvo.getCHECK_DEAL_TENURE_TYPE()))
		{
		    throw new BOException(MessageCodes.TOTAL_PERIOD_IS_LESS_THAN_COUNTER_PARTY_MIN_TENURE,
			    ConstantsCommon.CONFIRM_MSG_TYPE, "TOTAL_PERIODS_EXCEEDS_COUNTER_PARTY_TENURE_PERIOD",
			    true);
		}
	    }

	}
    }

    @Override
    public AMFVO returnAccountByAccount(AMFVO amfVo) throws BaseException
    {
	return iisCommonDAO.returnAccountByAccount(amfVo);
    }

    @Override
    public AMFVO returnAccountByAdditionalRef(AMFVO amfVo) throws BaseException
    {
	return iisCommonDAO.returnAccountByAdditionalRef(amfVo);
    }

    @Override
    /**
     * of_set_yield
     */
    public IslamicCalculatorEventMgmtCO applyBillsCalculatorYield(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	String issueAtType = "R";
	String isCouponPaymentType;
	BigDecimal annuallyPeriodicity = BigDecimal.ZERO;
	String pt_method = null;
	BigDecimal ldec_daysperyear = null;
	Double llDSC;
	Double llDCC;
	BigDecimal ldec_yield;
	Long llTenor;

	issueAtType = islamicCalculatorEventMgmtCO.getTrsdealNIDCVO().getISSUE_AT_TYPE();
	issueAtType = StringUtil.nullEmptyToValue(issueAtType, "R");

	if("Y".equals(issueAtType))
	{
	    isCouponPaymentType = islamicCalculatorEventMgmtCO.getTrsdealNIDCVO().getCOUPON_PAYMENT_TYPE();

	    if("M".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(12);

	    }
	    else if("Q".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(4);
	    }
	    else if("S".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(2);
	    }
	    else if("Y".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(1);
	    }

	    /*
	     * String noOfCoupon =
	     * getNoOfcoupon(islamicCalculatorEventMgmtCO.getValueDate(),
	     * islamicCalculatorEventMgmtCO.getMaturityDate());
	     */
	    BigDecimal noOfCoupon = getNoOfcoupon(islamicCalculatorEventMgmtCO);
	    Date previousCouponDate = getpreviouscoupondate(islamicCalculatorEventMgmtCO);
	    Date nextCouponDate = getnextCouponDate(islamicCalculatorEventMgmtCO);

	    llDSC = NumberUtil
		    .toDoubleObj(DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getValueDate(), nextCouponDate));
	    llDCC = NumberUtil.toDoubleObj(DateUtil.numberOfDays(previousCouponDate, nextCouponDate));

	    // ldec_yield =
	    // (((BigDecimal.valueOf(100).divide(islamicCalculatorEventMgmtCO.getPrice(),
	    // 12,
	    // BigDecimal.ROUND_HALF_UP)).pow((BigDecimal.ONE.divide(noOfCoupon,
	    // 12, BigDecimal.ROUND_HALF_UP)
	    // .subtract(BigDecimal.ONE).add(BigDecimal.valueOf(llDSC).divide(BigDecimal.valueOf(llDCC))))
	    // .intValue())).subtract(BigDecimal.ONE)).multiply(BigDecimal.valueOf(100).multiply(
	    // annuallyPeriodicity));

	    ldec_yield = (((BigDecimal.valueOf(100).divide(islamicCalculatorEventMgmtCO.getPrice(), 12,
		    BigDecimal.ROUND_HALF_UP)).pow(
			    (BigDecimal.ONE.divide(noOfCoupon, 12, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.ONE)
				    .add(BigDecimal.valueOf(llDSC).divide(BigDecimal.valueOf(llDCC)))).intValue()))
					    .subtract(BigDecimal.ONE))
						    .multiply(BigDecimal.valueOf(100).multiply(annuallyPeriodicity));
	    double yield = (Math.pow((100D / islamicCalculatorEventMgmtCO.getPrice().doubleValue()),
		    (1D / (noOfCoupon.doubleValue() - 1 + (llDSC / llDCC)))) - 1)
		    * (100D * annuallyPeriodicity.doubleValue());
	    ldec_yield = BigDecimal.valueOf(yield);

	}

	else
	{

	    ldec_daysperyear = returnDaysPerYear(islamicCalculatorEventMgmtCO.getCompCode(),
		    islamicCalculatorEventMgmtCO.getAccrualBasis(), islamicCalculatorEventMgmtCO.getCurrencyCode(),
		    islamicCalculatorEventMgmtCO.getValueDate(), islamicCalculatorEventMgmtCO.getMaturityDate());

	    llTenor = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getValueDate(),
		    islamicCalculatorEventMgmtCO.getMaturityDate());

	    if(islamicCalculatorEventMgmtCO.getPrice().compareTo(BigDecimal.ZERO) == 0
		    || BigDecimal.valueOf(llTenor).compareTo(BigDecimal.ZERO) == 0)
	    {
		ldec_yield = BigDecimal.ZERO;
	    }
	    else
	    {
		ldec_yield = (BigDecimal.valueOf(100).subtract(islamicCalculatorEventMgmtCO.getPrice()))
			.multiply(ldec_daysperyear).multiply(BigDecimal.valueOf(100))
			.divide(islamicCalculatorEventMgmtCO.getPrice().multiply(BigDecimal.valueOf(llTenor)), 6,
				BigDecimal.ROUND_HALF_UP);

	    }
	    islamicCalculatorEventMgmtCO.setYield(ldec_yield);
	}
	return islamicCalculatorEventMgmtCO;

    }

    public BigDecimal returnDaysPerYear(BigDecimal compCode, BigDecimal accrualBasis, BigDecimal currencyCode,
	    Date valueDate, Date MAturityDate) throws BaseException
    {
	String pt_method;
	BigDecimal ldec_daysperyear = BigDecimal.ZERO;
	if(accrualBasis.compareTo(BigDecimal.ONE) == 0)
	{

	    CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	    currenciesVOKey.setCOMP_CODE(compCode);
	    currenciesVOKey.setCURRENCY_CODE(currencyCode);

	    pt_method = returnCurrencyPtMethod(currenciesVOKey);
	    if("1".equals(pt_method))
	    {
		ldec_daysperyear = BigDecimal.valueOf(365);

	    }
	    else
	    {
		ldec_daysperyear = BigDecimal.valueOf(360);
	    }
	}
	if(accrualBasis.compareTo(BigDecimal.valueOf(2)) == 0)
	{

	    ldec_daysperyear = BigDecimal.valueOf(360);

	}

	if(accrualBasis.compareTo(BigDecimal.valueOf(6)) == 0)
	{
	    ldec_daysperyear = BigDecimal.valueOf(360);
	}

	if(accrualBasis.compareTo(BigDecimal.valueOf(3)) == 0)
	{
	    ldec_daysperyear = BigDecimal.valueOf(365);

	}

	if(accrualBasis.compareTo(BigDecimal.valueOf(4)) == 0)
	{
	    ldec_daysperyear = BigDecimal.valueOf(365);

	}

	if(accrualBasis.compareTo(BigDecimal.valueOf(5)) == 0)
	{
	    ldec_daysperyear = BigDecimal.valueOf(getAverageYearDaysInDealPeriod(valueDate, MAturityDate));
	}
	return ldec_daysperyear;
    }

    /**
     * of_getnoofcoupon
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    public BigDecimal getNoOfcoupon(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	Date date;
	Date dateTemp;
	BigDecimal Day;
	Date ldtDate;
	BigDecimal no_of_coupon = BigDecimal.ZERO;
	int rowSize = islamicCalculatorEventMgmtCO.getTrsdealNIDCCoupPaymtVOList().size();

	for(int i = 1; i <= 2; i++)
	{
	    for(int j = 0; j < rowSize; j++)
	    {
		date = islamicCalculatorEventMgmtCO.getTrsdealNIDCCoupPaymtVOList().get(j).getCOUPON_PAYMENT_DATE();
		Date valueDate = islamicCalculatorEventMgmtCO.getValueDate();
		if(i == 1)

		{
		    dateTemp = valueDate;
		}
		else
		{
		    dateTemp = islamicCalculatorEventMgmtCO.getMaturityDate();
		}
		// ls_Date = String(Year(Date(ldt_date_temp)),"0000") + '/' +
		// String(Month(Date(ldt_Date)),"00") + '/' +
		// String(Day(Date(ldt_Date)),"00")

		int month = DateUtil.getDayYearMonth(date, "M");
		int day = DateUtil.getDayYearMonth(date, "D");
		int year = DateUtil.getDayYearMonth(dateTemp, "Y");
		if(month == 1)
		{
		    if(day > 28)
		    {

			if(year % 4 > 0D)
			{
			    day = 28;
			}
		    }
		}
		ldtDate = DateUtil.createDate(year, month, day);
		Day = BigDecimal.ONE;
		if(i == 1)
		{
		    if(ldtDate.compareTo(valueDate) > 0)
		    {
			if(DateUtil.getDatePart("YYYY", islamicCalculatorEventMgmtCO.getMaturityDate())
				.equals(DateUtil.getDatePart("YYYY", valueDate)))
			{
			    if(ldtDate.compareTo(islamicCalculatorEventMgmtCO.getMaturityDate()) <= 0)
			    {
				no_of_coupon = no_of_coupon.add(BigDecimal.ONE);
			    }
			}
			else
			{
			    no_of_coupon = no_of_coupon.add(BigDecimal.ONE);
			}

		    }
		}
		else
		{
		    if(ldtDate.compareTo(islamicCalculatorEventMgmtCO.getMaturityDate()) <= 0)
		    {
			no_of_coupon = no_of_coupon.add(BigDecimal.ONE);
		    }
		}

		if(i == 1)
		{
		    if(DateUtil.getDatePart("YYYY", islamicCalculatorEventMgmtCO.getMaturityDate())
			    .equals(DateUtil.getDatePart("YYYY", valueDate)))
		    {
			i = 2;
		    }
		    else
		    {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(valueDate);
			int valueDateYear = calendar.get(Calendar.YEAR);
			Date maturityDate = islamicCalculatorEventMgmtCO.getMaturityDate();
			calendar.setTime(maturityDate);
			int maturityDateYear = calendar.get(Calendar.YEAR);
			no_of_coupon = no_of_coupon
				.add(new BigDecimal(rowSize * (maturityDateYear - valueDateYear - 1)));

		    }
		}

	    }
	}
	return no_of_coupon;
    }

    /**
     * of_getpreviouscoupondate
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    public Date getpreviouscoupondate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	Date date;
	int loYear;

	Date ldtDate;
	Date ldtPreviousCouponDate = null;

	int rowSize = islamicCalculatorEventMgmtCO.getTrsdealNIDCCoupPaymtVOList().size();

	for(int i = 1; i <= 2; i++)
	{
	    for(int Counter = 0; Counter < rowSize; Counter++)
	    {
		date = islamicCalculatorEventMgmtCO.getTrsdealNIDCCoupPaymtVOList().get(Counter)
			.getCOUPON_PAYMENT_DATE();
		if(i == 1)

		{
		    loYear = 1;
		}
		else
		{
		    loYear = 0;
		}

		Date dateTemp = islamicCalculatorEventMgmtCO.getValueDate();

		int month = DateUtil.getDayYearMonth(date, "M");
		int day = DateUtil.getDayYearMonth(date, "D");
		int year = DateUtil.getDayYearMonth(dateTemp, "Y") - loYear;
		if(month == 1)
		{
		    if(day > 28)
		    {

			if(year % 4 > 0D)
			{
			    day = 28;
			}
		    }
		}
		ldtDate = DateUtil.createDate(year, month, day);

		if(i == 1 && Counter == 0)

		{
		    ldtPreviousCouponDate = ldtDate;

		}
		if(ldtPreviousCouponDate != null && (ldtDate.compareTo(ldtPreviousCouponDate) > 0
			&& ldtDate.compareTo(islamicCalculatorEventMgmtCO.getValueDate()) <= 0))
		{
		    ldtPreviousCouponDate = ldtDate;
		}
	    }

	}
	return ldtPreviousCouponDate;
    }

    /**
     * of_getnextcoupondate
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return
     * @throws BaseException
     */
    public Date getnextCouponDate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	Date date;
	Date ldtDate;
	int loYear;
	int rowSize = islamicCalculatorEventMgmtCO.getTrsdealNIDCCoupPaymtVOList().size();

	Date ldtNextCouponDate = null;
	for(int i = 1; i <= 2; i++)
	{
	    for(int Counter = 0; Counter < rowSize; Counter++)
	    {
		date = islamicCalculatorEventMgmtCO.getTrsdealNIDCCoupPaymtVOList().get(Counter)
			.getCOUPON_PAYMENT_DATE();
		if(i == 1)

		{
		    loYear = 1;
		}
		else
		{
		    loYear = 0;
		}

		Date dateTemp = islamicCalculatorEventMgmtCO.getValueDate();

		int month = DateUtil.getDayYearMonth(date, "M");
		int day = DateUtil.getDayYearMonth(date, "D");
		int year = DateUtil.getDayYearMonth(dateTemp, "Y") + loYear;
		if(month == 1)
		{
		    if(day > 28)
		    {

			if(year % 4 > 0D)
			{
			    day = 28;
			}
		    }
		}
		ldtDate = DateUtil.createDate(year, month, day);

		if(i == 1 && Counter == 0)

		{
		    ldtNextCouponDate = ldtDate;

		}
		if(ldtNextCouponDate != null && (ldtDate.compareTo(ldtNextCouponDate) < 0
			&& ldtDate.compareTo(islamicCalculatorEventMgmtCO.getValueDate()) > 0))

		{
		    ldtNextCouponDate = ldtDate;
		}

	    }
	}
	return ldtNextCouponDate;
    }

    @Override
    public Double getAverageYearDaysInDealPeriod(Date valueDate, Date matrutiyDate) throws BaseException
    {
	int fromYear = DateUtil.getDatePart("YYYY", valueDate).intValue();
	int toYear = DateUtil.getDatePart("YYYY", matrutiyDate).intValue();

	Date fromYearBingin = DateUtil.createDate(fromYear, 1, 1);
	Date fromYearEnd = DateUtil.createDate(fromYear, 12, 31);
	Date toYearBigin = DateUtil.createDate(toYear, 1, 1);
	Date toYearEnd = DateUtil.createDate(toYear, 12, 31);

	long dealDaysInFirstYear = DateUtil.numberOfDays(valueDate, fromYearEnd) + 1L;
	long actualDaysInLastYear = DateUtil.numberOfDays(toYearBigin, toYearEnd) + 1L;
	long dealPeriodLastYear = DateUtil.numberOfDays(toYearBigin, matrutiyDate);
	long actualDaysInFirstYear = DateUtil.numberOfDays(fromYearBingin, fromYearEnd) + 1L;
	toYearBigin = null;
	toYearEnd = null;

	double totalMonths = (((((double) dealDaysInFirstYear * actualDaysInLastYear)
		+ (dealPeriodLastYear * actualDaysInFirstYear)) / (actualDaysInLastYear * actualDaysInFirstYear))
		+ toYear - fromYear - 1);
	long totalDays = DateUtil.numberOfDays(valueDate, matrutiyDate);
	double avgDays = totalDays / totalMonths;

	return avgDays;
    }

    /**
     * of_set_price
     */
    @Override
    public IslamicCalculatorEventMgmtCO applyPriceSetCalculator(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	String issueAtType = "R";
	String isCouponPaymentType;
	BigDecimal annuallyPeriodicity = BigDecimal.ZERO;
	double llDSC;
	double llDCC;
	BigDecimal ldec_price = BigDecimal.ZERO;
	String pt_method = null;
	BigDecimal ldec_daysperyear = null;
	Long llTenor;

	issueAtType = islamicCalculatorEventMgmtCO.getTrsdealNIDCVO().getISSUE_AT_TYPE();

	if(issueAtType == null || issueAtType.equals(""))
	{
	    issueAtType = "R";
	}
	// issueAtType = StringUtil.nullEmptyToValue(issueAtType, "R");
	if("Y".equals(issueAtType))
	{
	    isCouponPaymentType = islamicCalculatorEventMgmtCO.getTrsdealNIDCVO().getCOUPON_PAYMENT_TYPE();

	    if("M".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(12);

	    }
	    else if("Q".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(4);
	    }
	    else if("S".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(2);
	    }
	    else if("Y".equals(isCouponPaymentType))
	    {
		annuallyPeriodicity = BigDecimal.valueOf(1);
	    }

	    BigDecimal noOfCoupon = getNoOfcoupon(islamicCalculatorEventMgmtCO);
	    Date previousCouponDate = getpreviouscoupondate(islamicCalculatorEventMgmtCO);
	    Date nextCouponDate = getnextCouponDate(islamicCalculatorEventMgmtCO);
	    llDSC = NumberUtil
		    .toDoubleObj(DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getValueDate(), nextCouponDate));
	    llDCC = NumberUtil.toDoubleObj(DateUtil.numberOfDays(previousCouponDate, nextCouponDate));

	    // ldec_price = ((BigDecimal.valueOf(100).divide(
	    // (BigDecimal.ONE.add(islamicCalculatorEventMgmtCO.getYield().divide(
	    // (BigDecimal.valueOf(100).multiply(annuallyPeriodicity)), 12,
	    // BigDecimal.ROUND_HALF_UP))),
	    // 12,
	    // BigDecimal.ROUND_HALF_UP).pow(((noOfCoupon).subtract(BigDecimal.ONE).add(BigDecimal.valueOf(
	    // llDSC).divide(BigDecimal.valueOf(llDCC), 12,
	    // BigDecimal.ROUND_HALF_UP))).intValue())));

	    double yield = islamicCalculatorEventMgmtCO.getYield().doubleValue();

	    double price = 1 + ((yield / (100D * annuallyPeriodicity.doubleValue())));
	    price = 100D / (Math.pow(price, (noOfCoupon.doubleValue() - 1 + (llDSC / llDCC))));
	    ldec_price = NumberUtil.roundToBigDecimal(price, 4L);
	}
	else
	{

	    if(islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(12)) == 1)
	    {

		CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
		currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());

		pt_method = returnCurrencyPtMethod(currenciesVOKey);
		if("1".equals(pt_method))
		{
		    ldec_daysperyear = BigDecimal.valueOf(365);

		}
		else
		{
		    ldec_daysperyear = BigDecimal.valueOf(360);
		}
	    }
	    if(islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(2)) == 0)
	    {

		ldec_daysperyear = BigDecimal.valueOf(360);

	    }

	    if(islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(6)) == 0)
	    {
		ldec_daysperyear = BigDecimal.valueOf(360);
	    }

	    if(islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(3)) == 0)
	    {
		ldec_daysperyear = BigDecimal.valueOf(365);

	    }

	    if(islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(4)) == 0)
	    {
		ldec_daysperyear = BigDecimal.valueOf(365);

	    }

	    if(islamicCalculatorEventMgmtCO.getAccrualBasis().compareTo(BigDecimal.valueOf(5)) == 0)
	    {
		ldec_daysperyear = BigDecimal.valueOf(getAverageYearDaysInDealPeriod(
			islamicCalculatorEventMgmtCO.getValueDate(), islamicCalculatorEventMgmtCO.getMaturityDate()));
	    }

	    llTenor = DateUtil.numberOfDays(islamicCalculatorEventMgmtCO.getValueDate(),
		    islamicCalculatorEventMgmtCO.getMaturityDate());

	    // if(islamicCalculatorEventMgmtCO.getPrice().equals(BigDecimal.ZERO)
	    // || BigDecimal.valueOf(llTenor).equals(BigDecimal.ZERO))
	    if(NumberUtil.nullToZero(ldec_daysperyear).compareTo(BigDecimal.ZERO) == 0)
	    {
		ldec_price = BigDecimal.ZERO;
	    }
	    else
	    {

		// BigDecimal tenorYeildre=
		// BigDecimal.valueOf(llTenor).multiply(islamicCalculatorEventMgmtCO.getYield());
		BigDecimal tenorYeildre = BigDecimal.valueOf(llTenor)
			.multiply(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getYield()));
		BigDecimal idecyr = ldec_daysperyear.multiply(BigDecimal.valueOf(100));
		BigDecimal divisionte = tenorYeildre.divide(idecyr, 12, BigDecimal.ROUND_HALF_UP);
		BigDecimal addone = BigDecimal.ONE.add(divisionte);
		BigDecimal sedivision = BigDecimal.valueOf(100).divide(addone, 4, BigDecimal.ROUND_HALF_UP);
		ldec_price = sedivision;

	    }
	    islamicCalculatorEventMgmtCO.setPrice(ldec_price);
	}
	return islamicCalculatorEventMgmtCO;
    }

    @Override
    public IISReturnMessagesCO addExceptionToList(IISReturnMessagesCO iiReturnMessagesCO, BaseException e)
	    throws BaseException

    {

	if(IISCommonConstants.CALLED_FROM_WS.equals(iiReturnMessagesCO.getCalledFrom()))
	{
	    // Will identify the default action from CTSMessage and will proceed
	    // accordingly TODO
	}

	String messageIdentifier = e.getMsgIdent();

	if(StringUtil.isEmptyString(messageIdentifier))
	{
	    throw e;
	}

	if(isExceptionInList(iiReturnMessagesCO, messageIdentifier))
	{
	    return iiReturnMessagesCO;
	}

	// Registering to the exception list
	iiReturnMessagesCO.getMessageIdentifierList().add(messageIdentifier);
	iiReturnMessagesCO.getExceptionList().add(e);

	return iiReturnMessagesCO;

    }

    public boolean isExceptionInList(IISReturnMessagesCO iiReturnMessagesCO, String msgIdent) throws BaseException

    {

	ArrayList<String> messageIdentifierList = iiReturnMessagesCO.getMessageIdentifierList();
	if(messageIdentifierList.isEmpty())
	{
	    String jsonexceptionList = iiReturnMessagesCO.getJsonexceptionList();
	    if(StringUtil.isNotEmpty(jsonexceptionList))
	    {
		JSONArray exceptionArray = JSONArray.fromObject(jsonexceptionList);
		Object[] exceptionObjArr = exceptionArray.toArray();
		boolean isAvailable = false;
		for(Object exceptionObj : exceptionObjArr)
		{
		    String MsgIdent = (String) exceptionObj;
		    messageIdentifierList.add(MsgIdent);
		    if(MsgIdent.equals(msgIdent))
		    {
			isAvailable = true;
		    }
		}
		return isAvailable;
	    }
	    return false;
	}

	for(String messageIdentifierFromList : messageIdentifierList)
	{

	    if(messageIdentifierFromList.equals(msgIdent))
	    {
		return true;
	    }
	}
	return false;

    }

    /**
     * @author Arun.Variyath #TAR BB130030 11/08/2015
     * @param iisCommonCO
     * @return
     * @throws BaseException
     */
    @Override
    public String returnCalcMatDteFlagValue(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.returnCalcMatDteFlagValue(iisCommonCO);
    }

    /**
     * // f_check_limit_yield_roster // TP# 222800 BM140006 - Limit for Yield
     * Roster in IIS Sreejith
     */
    public List<String> checkLimitYieldRoster(BigDecimal compCode, BigDecimal branchCode, String partyType,
	    BigDecimal cif, String salaryWithBank, BigDecimal classCode, BigDecimal cy, BigDecimal amount, Date vDate,
	    BigDecimal numberOfPayments, String periodicityType, BigDecimal templateCode, BigDecimal balloonAmtPcnt,
	    BigDecimal yieldNew, Boolean columnMargin) throws BaseException
    {
	List<String> informationMessageList = new ArrayList<String>();
	IISCommonCO iisCommonParamCO = new IISCommonCO();
	iisCommonParamCO.setCompCode(compCode);
	iisCommonParamCO.setBranchCode(branchCode);
	iisCommonParamCO.setProductType("S");
	iisCommonParamCO.setClassCode(classCode);
	iisCommonParamCO.setAcPartyType(partyType);
	BigDecimal register = NumberUtil
		.emptyDecimalToZero(iisCommonDAO.returnCodeFromTRSROSTER_REGISTER(iisCommonParamCO));
	if(register.compareTo(BigDecimal.ZERO) == 0)
	{
	    iisCommonParamCO.setClassCode(null);
	    iisCommonParamCO.setProductType("A");
	    register = NumberUtil.emptyDecimalToZero(iisCommonDAO.returnCodeFromTRSROSTER_REGISTER(iisCommonParamCO));
	}
	if(register.compareTo(BigDecimal.ZERO) == 0)
	{
	    return informationMessageList;
	}
	BigDecimal periodicityNo = NumberUtil.emptyDecimalToZero(numberOfPayments);

	if("W".equals(periodicityType))
	{
	    periodicityNo = periodicityNo.multiply(BigDecimal.valueOf(7));
	}
	if("M".equals(periodicityType))
	{
	    periodicityNo = periodicityNo.multiply(BigDecimal.valueOf(31));
	}
	if("Y".equals(periodicityType))
	{
	    periodicityNo = periodicityNo.multiply(BigDecimal.valueOf(365));
	}
	if("Q".equals(periodicityType))
	{
	    periodicityNo = periodicityNo.multiply(BigDecimal.valueOf(92));
	}
	if("S".equals(periodicityType))
	{
	    periodicityNo = periodicityNo.multiply(BigDecimal.valueOf(183));
	}
	if("A".equals(periodicityType))
	{
	    periodicityNo = periodicityNo.multiply(BigDecimal.valueOf(365));
	}
	TRSROSTER_REGISTER_DETVO trsrosterREGISTERDETVO = new TRSROSTER_REGISTER_DETVO();
	trsrosterREGISTERDETVO.setCOMP_CODE(compCode);
	trsrosterREGISTERDETVO.setBRANCH_CODE(branchCode);
	trsrosterREGISTERDETVO.setCODE(register);
	trsrosterREGISTERDETVO.setENTITY_TYPE("C");
	trsrosterREGISTERDETVO.setENTITY_CODE(cif);
	List<TRSROSTER_REGISTER_DETVO> trsrosterREGISTERDETVOList = iisCommonDAO
		.returnTRSROSTER_REGISTER_DETData(trsrosterREGISTERDETVO);
	BigDecimal yieldPeriodicityNbr = BigDecimal.ZERO, lineNbr = BigDecimal.ZERO, rosterCodeYield = BigDecimal.ZERO;
	for(TRSROSTER_REGISTER_DETVO registerDETVO : trsrosterREGISTERDETVOList)
	{
	    yieldPeriodicityNbr = NumberUtil.emptyDecimalToZero(registerDETVO.getPERIOD_NBR());
	    if("W".equals(registerDETVO.getPERIOD_TYPE()))
	    {
		yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(7));
	    }
	    if("M".equals(registerDETVO.getPERIOD_TYPE()))
	    {
		yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(31));
	    }
	    if("Y".equals(registerDETVO.getPERIOD_TYPE()))
	    {
		yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(365));
	    }
	    if("Q".equals(registerDETVO.getPERIOD_TYPE()))
	    {
		yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(92));
	    }
	    if("S".equals(registerDETVO.getPERIOD_TYPE()))
	    {
		yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(183));
	    }
	    if("A".equals(registerDETVO.getPERIOD_TYPE()))
	    {
		yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(365));
	    }
	    if("S".equals(registerDETVO.getCURRENCY_TYPE()) && cy.compareTo(registerDETVO.getCURRENCY_CODE()) != 0)
	    {
		continue;
	    }
	    if(registerDETVO.getFROM_DATE() != null && registerDETVO.getTO_DATE() != null
		    && vDate.compareTo(registerDETVO.getFROM_DATE()) <= 0
		    && vDate.compareTo(registerDETVO.getTO_DATE()) >= 0)
	    {
		continue;
	    }
	    if(NumberUtil.emptyDecimalToZero(registerDETVO.getPAY_PLAN_TMPLT_ID()).compareTo(BigDecimal.ZERO) >= 0
		    && NumberUtil.emptyDecimalToZero(registerDETVO.getPAY_PLAN_TMPLT_ID()).compareTo(templateCode) != 0)
	    {
		continue;
	    }
	    if(NumberUtil.emptyDecimalToZero(registerDETVO.getBALLOON_PERCENTAGE()).compareTo(BigDecimal.ZERO) > 0)
	    {
		if(NumberUtil.emptyDecimalToZero(balloonAmtPcnt).compareTo(BigDecimal.ZERO) == 0)
		{
		    continue;
		}
		if(NumberUtil.emptyDecimalToZero(balloonAmtPcnt)
			.compareTo(NumberUtil.emptyDecimalToZero(registerDETVO.getBALLOON_PERCENTAGE())) < 0)
		{
		    continue;
		}
	    }
	    if(periodicityNo.compareTo(yieldPeriodicityNbr) >= 0)
	    {
		lineNbr = registerDETVO.getLINE_NO();
		rosterCodeYield = registerDETVO.getROSTER_CODE_YIELD();
		break;
	    }
	}
	if(NumberUtil.emptyDecimalToZero(lineNbr).compareTo(BigDecimal.ZERO) == 0
		&& NumberUtil.emptyDecimalToZero(rosterCodeYield).compareTo(BigDecimal.ZERO) == 0)
	{
	    trsrosterREGISTERDETVO.setCODE(register);
	    trsrosterREGISTERDETVO.setENTITY_TYPE("T");
	    trsrosterREGISTERDETVO.setENTITY_CODE(BigDecimal.ZERO);
	    trsrosterREGISTERDETVOList = iisCommonDAO.returnTRSROSTER_REGISTER_DETData(trsrosterREGISTERDETVO);
	    for(TRSROSTER_REGISTER_DETVO registerDETVO : trsrosterREGISTERDETVOList)
	    {
		yieldPeriodicityNbr = NumberUtil.emptyDecimalToZero(registerDETVO.getPERIOD_NBR());
		if("W".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(7));
		}
		if("M".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(31));
		}
		if("Y".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(365));
		}
		if("Q".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(92));
		}
		if("S".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(183));
		}
		if("A".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(365));
		}
		if("S".equals(registerDETVO.getCURRENCY_TYPE())
			&& cy.compareTo(NumberUtil.emptyDecimalToZero(registerDETVO.getCURRENCY_CODE())) != 0)
		{
		    continue;
		}
		if(registerDETVO.getFROM_DATE() != null && registerDETVO.getTO_DATE() != null
			&& vDate.compareTo(registerDETVO.getFROM_DATE()) >= 0
			&& vDate.compareTo(registerDETVO.getTO_DATE()) <= 0)
		{
		    continue;
		}
		if(NumberUtil.emptyDecimalToZero(registerDETVO.getPAY_PLAN_TMPLT_ID()).compareTo(BigDecimal.ZERO) >= 0
			&& NumberUtil.emptyDecimalToZero(registerDETVO.getPAY_PLAN_TMPLT_ID())
				.compareTo(templateCode) != 0)
		{
		    continue;
		}
		if(NumberUtil.emptyDecimalToZero(registerDETVO.getBALLOON_PERCENTAGE()).compareTo(BigDecimal.ZERO) > 0)
		{
		    if(NumberUtil.emptyDecimalToZero(balloonAmtPcnt).compareTo(BigDecimal.ZERO) == 0)
		    {
			continue;
		    }
		    if(NumberUtil.emptyDecimalToZero(balloonAmtPcnt)
			    .compareTo(NumberUtil.emptyDecimalToZero(registerDETVO.getBALLOON_PERCENTAGE())) < 0)
		    {
			continue;
		    }
		}
		if(periodicityNo.compareTo(yieldPeriodicityNbr) >= 0)
		{
		    lineNbr = NumberUtil.emptyDecimalToZero(registerDETVO.getLINE_NO());
		    rosterCodeYield = NumberUtil.emptyDecimalToZero(registerDETVO.getROSTER_CODE_YIELD());
		    break;
		}
	    }
	}
	if(NumberUtil.emptyDecimalToZero(lineNbr).compareTo(BigDecimal.ZERO) == 0
		&& NumberUtil.emptyDecimalToZero(rosterCodeYield).compareTo(BigDecimal.ZERO) == 0)
	{
	    trsrosterREGISTERDETVO.setCODE(register);
	    trsrosterREGISTERDETVO.setENTITY_TYPE("A");
	    trsrosterREGISTERDETVO.setENTITY_CODE(null);
	    trsrosterREGISTERDETVOList = iisCommonDAO.returnTRSROSTER_REGISTER_DETData(trsrosterREGISTERDETVO);
	    for(TRSROSTER_REGISTER_DETVO registerDETVO : trsrosterREGISTERDETVOList)
	    {
		yieldPeriodicityNbr = NumberUtil.emptyDecimalToZero(registerDETVO.getPERIOD_NBR());
		if("W".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(7));
		}
		if("M".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(31));
		}
		if("Y".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(365));
		}
		if("Q".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(92));
		}
		if("S".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(183));
		}
		if("A".equals(registerDETVO.getPERIOD_TYPE()))
		{
		    yieldPeriodicityNbr = yieldPeriodicityNbr.multiply(BigDecimal.valueOf(365));
		}
		if("S".equals(registerDETVO.getCURRENCY_TYPE()) && cy.compareTo(registerDETVO.getCURRENCY_CODE()) != 0)
		{
		    continue;
		}
		if(registerDETVO.getFROM_DATE() != null && registerDETVO.getTO_DATE() != null
			&& vDate.compareTo(registerDETVO.getFROM_DATE()) <= 0
			&& vDate.compareTo(registerDETVO.getTO_DATE()) >= 0)
		{
		    continue;
		}
		if(NumberUtil.emptyDecimalToZero(registerDETVO.getPAY_PLAN_TMPLT_ID()).compareTo(BigDecimal.ZERO) >= 0
			&& NumberUtil.emptyDecimalToZero(registerDETVO.getPAY_PLAN_TMPLT_ID())
				.compareTo(templateCode) != 0)
		{
		    continue;
		}
		if(NumberUtil.emptyDecimalToZero(registerDETVO.getBALLOON_PERCENTAGE()).compareTo(BigDecimal.ZERO) > 0)
		{
		    if(NumberUtil.emptyDecimalToZero(balloonAmtPcnt).compareTo(BigDecimal.ZERO) == 0)
		    {
			continue;
		    }
		    if(NumberUtil.emptyDecimalToZero(balloonAmtPcnt)
			    .compareTo(NumberUtil.emptyDecimalToZero(registerDETVO.getBALLOON_PERCENTAGE())) < 0)
		    {
			continue;
		    }
		}
		if(periodicityNo.compareTo(yieldPeriodicityNbr) >= 0)
		{
		    lineNbr = NumberUtil.emptyDecimalToZero(registerDETVO.getLINE_NO());
		    rosterCodeYield = NumberUtil.emptyDecimalToZero(registerDETVO.getROSTER_CODE_YIELD());
		    break;
		}
	    }
	}
	BigDecimal yield = BigDecimal.ZERO, yieldMin = BigDecimal.ZERO, yieldMax = BigDecimal.ZERO;
	iisCommonParamCO.setCifNo(NumberUtil.emptyDecimalToZero(cif));
	iisCommonParamCO.setRosterCodeYield(NumberUtil.emptyDecimalToZero(rosterCodeYield));
	iisCommonParamCO.setAmount(NumberUtil.emptyDecimalToZero(amount));
	if(NumberUtil.emptyDecimalToZero(rosterCodeYield).compareTo(BigDecimal.ZERO) > 0)
	{
	    CIFVO cifvo = iisCommonDAO.returnCifTypeAndMaintSalaryAcc(iisCommonParamCO);
	    BigDecimal stafType = NumberUtil
		    .emptyDecimalToZero(iisCommonDAO.returnCifTypeFromACC_NV_CONTROL(iisCommonParamCO));
	    BigDecimal cifType = BigDecimal.ZERO;
	    String maintainSalaryAc = "";
	    if(cifvo != null)
	    {
		cifType = NumberUtil.emptyDecimalToZero(cifvo.getCIF_TYPE());
		maintainSalaryAc = StringUtil.nullToEmpty(cifvo.getMAINTAIN_SALARY_ACC());
	    }
	    IISCommonCO commonParamCO = iisCommonDAO.returnYieldFromTRSROSTERDET(iisCommonParamCO);
	    if(commonParamCO != null)
	    {
		if(cifType.compareTo(stafType) == 0)
		{
		    yield = NumberUtil.emptyDecimalToZero(commonParamCO.getSTAFF_YIELD());
		    yieldMin = NumberUtil.emptyDecimalToZero(commonParamCO.getSTAFF_YIELD_MIN());
		    yieldMax = NumberUtil.emptyDecimalToZero(commonParamCO.getSTAFF_YIELD_MAX());
		}
		else if("N".equals(salaryWithBank))
		{
		    yield = NumberUtil.emptyDecimalToZero(commonParamCO.getYIELD());
		    yieldMin = NumberUtil.emptyDecimalToZero(commonParamCO.getNON_DOMICILE_YIELD_MIN());
		    yieldMax = NumberUtil.emptyDecimalToZero(commonParamCO.getNON_DOMICILE_YIELD_MAX());
		}
		else if("Y".equals(salaryWithBank))
		{
		    yield = NumberUtil.emptyDecimalToZero(commonParamCO.getDOMICILE_YIELD());
		    yieldMin = NumberUtil.emptyDecimalToZero(commonParamCO.getDOMICILE_YIELD_MIN());
		    yieldMax = NumberUtil.emptyDecimalToZero(commonParamCO.getDOMICILE_YIELD_MAX());
		}
		else if("1".equals(maintainSalaryAc) || "Y".equals(maintainSalaryAc))
		{
		    yield = NumberUtil.emptyDecimalToZero(commonParamCO.getDOMICILE_YIELD());
		    yieldMin = NumberUtil.emptyDecimalToZero(commonParamCO.getDOMICILE_YIELD_MIN());
		    yieldMax = NumberUtil.emptyDecimalToZero(commonParamCO.getDOMICILE_YIELD_MAX());
		}
		else
		{
		    yield = NumberUtil.emptyDecimalToZero(commonParamCO.getYIELD());
		    yieldMin = NumberUtil.emptyDecimalToZero(commonParamCO.getNON_DOMICILE_YIELD_MIN());
		    yieldMax = NumberUtil.emptyDecimalToZero(commonParamCO.getNON_DOMICILE_YIELD_MAX());
		}
	    }
	}

	if(NumberUtil.emptyDecimalToZero(yield).compareTo(BigDecimal.ZERO) > 0)
	{
	    String yieldType = "", allowEditYieldOutsideRange = "", allowEditDefaultedYield = "";
	    IISCommonCO commonParamCO1 = iisCommonDAO.returnAllowEditOutSideRangeAndDefaultedYield(iisCommonParamCO);
	    if(commonParamCO1 != null)
	    {
		allowEditYieldOutsideRange = StringUtil.nullToEmpty(commonParamCO1.getALLOW_EDIT_YIELD_OUTSIDE_RANGE());
		allowEditDefaultedYield = StringUtil.nullToEmpty(commonParamCO1.getALLOW_EDIT_DEFAULTED_YIELD());
	    }
	    if(columnMargin)
	    {
		yieldType = "Margin";
	    }
	    else
	    {
		yieldType = "Yield";
	    }

	    if(yieldMin.compareTo(BigDecimal.ZERO) > 0 && yieldMax.compareTo(BigDecimal.ZERO) > 0
		    && (yieldNew.compareTo(yieldMin) < 0 || yieldMax.compareTo(yieldNew) < 0))
	    {
		if("W".equals(allowEditYieldOutsideRange))
		{
		    informationMessageList
			    .add(yieldType + " should be within the range " + yieldMin + " - " + yieldMax);
		}
		if("S".equals(allowEditYieldOutsideRange))
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { yieldType + " should be within the range" + yieldMin + " - " + yieldMax });
		}
	    }
	    if(yieldNew.compareTo(yield) != 0)
	    {
		if("W".equals(allowEditDefaultedYield))
		{
		    informationMessageList.add("You are amending the defaulted " + yieldType);
		}
		if("S".equals(allowEditDefaultedYield))
		{
		    throw new BOException(MessageCodes.iis_invalid_code,
			    new String[] { "Defaulted " + yieldType + " cannot be edited" });
		}
	    }
	}
	return informationMessageList;
    }

    /**
     * // wf_insert_deal_yield // TP# 222800 BM140006 - Limit for Yield Roster
     * in IIS Sreejith
     */
    public TRSDEAL_YIELD_AMENDEDVO insertDealYield(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo,
	    BigDecimal multipleYieldLineNo, BigDecimal yield, String defaultYN) throws BaseException
    {
	IISCommonCO iisCommonParamCO = new IISCommonCO();
	iisCommonParamCO.setCompCode(compCode);
	iisCommonParamCO.setBranchCode(branchCode);
	iisCommonParamCO.setDealNo(dealNo);
	TRSDEAL_YIELD_AMENDEDVO trsdealYIELDAMENDEDVO = new TRSDEAL_YIELD_AMENDEDVO();
	BigDecimal lineNo = NumberUtil
		.emptyDecimalToZero(iisCommonDAO.returnRecCountFromTRSDEAL_YIELD_AMENDED(iisCommonParamCO))
		.add(BigDecimal.ONE);
	trsdealYIELDAMENDEDVO.setLINE_NO(NumberUtil.emptyDecimalToZero(lineNo));
	trsdealYIELDAMENDEDVO.setMULTIPLE_YIELD_LINE_NO(multipleYieldLineNo);
	trsdealYIELDAMENDEDVO.setYIELD(yield);
	trsdealYIELDAMENDEDVO.setDEFAULT_YN(defaultYN);
	trsdealYIELDAMENDEDVO.setCOMP_CODE(compCode);
	trsdealYIELDAMENDEDVO.setBRANCH_CODE(branchCode);
	trsdealYIELDAMENDEDVO.setDEAL_NO(dealNo);
	return trsdealYIELDAMENDEDVO;
    }

    @Override
    public TRSVAT_PERIODVO returnVatPercentageForBrachAndCy(IISCommonCO iiSCommonCO) throws BaseException
    {

	TRSVAT_PERIODVO trsvatPERIODVO = new TRSVAT_PERIODVO();
	trsvatPERIODVO.setVAT_CODE(iiSCommonCO.getVatCode());
	trsvatPERIODVO.setCOMP_CODE(iiSCommonCO.getCompCode());
	trsvatPERIODVO.setVAT_BRANCH(iiSCommonCO.getBranchCode());
	trsvatPERIODVO.setVAT_CY(iiSCommonCO.getCurrency());
	trsvatPERIODVO.setFROM_DATE(iiSCommonCO.getStartDate());

	if(trsvatPERIODVO.getVAT_CODE() == null)
	{
	    TRSVAT_PERIODVO trsvat_PERIODVOReturn = new TRSVAT_PERIODVO();
	    trsvat_PERIODVOReturn.setVAT_CHARGE_PERCENT(BigDecimal.ZERO);
	    trsvat_PERIODVOReturn.setPERCENTAGE(BigDecimal.ZERO);
	    return trsvat_PERIODVOReturn;
	}
	if(trsvatPERIODVO.getFROM_DATE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_VALUE_DATE);
	}

	if(trsvatPERIODVO.getCOMP_CODE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
	}

	if(trsvatPERIODVO.getVAT_BRANCH() == null)
	{
	    trsvatPERIODVO.setVAT_BRANCH(BigDecimal.ZERO);
	}

	if(trsvatPERIODVO.getVAT_CY() == null)
	{
	    trsvatPERIODVO.setVAT_CY(BigDecimal.ZERO);
	}
	TRSVATVO trsvatvo = new TRSVATVO();
	if(NumberUtil.nullToZero(iiSCommonCO.getDealNo()).compareTo(BigDecimal.valueOf(-1)) == 0)
	{
	    trsvatvo.setVAT_RATE_BASED_ON("T");
	}
	else
	{
	    trsvatvo.setCOMP_CODE(trsvatPERIODVO.getCOMP_CODE());
	    trsvatvo.setVAT_CODE(trsvatPERIODVO.getVAT_CODE());
	    trsvatvo = (TRSVATVO) genericDAO.selectByPK(trsvatvo);
	    if(trsvatvo == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	    }
	}

	BigDecimal vatCount = iisCommonDAO.getVatCountWithBranchAndCy(trsvatPERIODVO);
	TRSVAT_PERIODVO trsvat_PERIODVOReturn = new TRSVAT_PERIODVO();
	if(vatCount.compareTo(BigDecimal.ZERO) == 0)
	{
	    TRSVAT_PERIODVO trsvat_PERIODVOSelect = new TRSVAT_PERIODVO();
	    trsvat_PERIODVOSelect.setCOMP_CODE(trsvatPERIODVO.getCOMP_CODE());
	    trsvat_PERIODVOSelect.setVAT_CODE(trsvatPERIODVO.getVAT_CODE());
	    trsvat_PERIODVOSelect.setFROM_DATE(trsvatPERIODVO.getFROM_DATE());
	    trsvat_PERIODVOSelect.setVAT_BRANCH(BigDecimal.ZERO);
	    trsvat_PERIODVOSelect.setVAT_CY(BigDecimal.ZERO);

	    trsvat_PERIODVOReturn = iisCommonDAO.returnVatRateByBranchAndCy(trsvat_PERIODVOSelect);
	}
	else
	{
	    if(!StringUtil.nullEmptyToValue(trsvatvo.getVAT_RATE_BASED_ON(), "T").equals("T"))
	    {
		if(iiSCommonCO.getDealNo() == null)
		{
		    throw new BOException("Cannot_calulate_vat_invalid_deal_number_to_get_maturity_branch");
		}
		TRSDETVO trsdetvo = new TRSDETVO();
		trsdetvo.setCOMP_CODE(iiSCommonCO.getCompCode());
		trsdetvo.setBRANCH_CODE(iiSCommonCO.getBranchCode());
		trsdetvo.setSERIAL_NO(iiSCommonCO.getDealNo());

		BigDecimal matBranchCode = NumberUtil.nullToZero(iisCommonDAO.returnMaturityAccBr(trsdetvo));
		if(matBranchCode == null || matBranchCode.compareTo(BigDecimal.ZERO) != 1)
		{
		    throw new BOException("Maturity_account_branch_is_not_define");
		}
		trsvatPERIODVO.setVAT_BRANCH(matBranchCode);
	    }

	    if(trsvatPERIODVO.getVAT_CY() == null || trsvatPERIODVO.getVAT_CY().compareTo(BigDecimal.ZERO) == 0)
	    {
		TRSDEALVO trsdealvo = new TRSDEALVO();
		trsdealvo.setCOMP_CODE(iiSCommonCO.getCompCode());
		trsdealvo.setBRANCH_CODE(iiSCommonCO.getBranchCode());
		trsdealvo.setSERIAL_NO(iiSCommonCO.getDealNo());
		trsvatPERIODVO.setVAT_CY(iisCommonDAO.returnDealCurrencyCode(trsdealvo));
	    }
	    TRSVAT_PERIODVO trsvat_PERIODVOSelect = new TRSVAT_PERIODVO();
	    trsvat_PERIODVOSelect.setCOMP_CODE(trsvatPERIODVO.getCOMP_CODE());
	    trsvat_PERIODVOSelect.setVAT_CODE(trsvatPERIODVO.getVAT_CODE());
	    trsvat_PERIODVOSelect.setFROM_DATE(trsvatPERIODVO.getFROM_DATE());
	    trsvat_PERIODVOSelect.setVAT_BRANCH(trsvatPERIODVO.getVAT_BRANCH());
	    trsvat_PERIODVOSelect.setVAT_CY(trsvatPERIODVO.getVAT_CY());
	    trsvat_PERIODVOReturn = iisCommonDAO.returnVatRateByBranchAndCy(trsvat_PERIODVOSelect);
	    if(trsvat_PERIODVOReturn == null)
	    {
		trsvat_PERIODVOSelect.setVAT_BRANCH(trsvatPERIODVO.getVAT_BRANCH());
		trsvat_PERIODVOSelect.setVAT_CY(BigDecimal.ZERO);
		trsvat_PERIODVOReturn = iisCommonDAO.returnVatRateByBranchAndCy(trsvat_PERIODVOSelect);
	    }

	    if(trsvat_PERIODVOReturn == null)
	    {
		trsvat_PERIODVOSelect.setVAT_BRANCH(BigDecimal.ZERO);
		trsvat_PERIODVOSelect.setVAT_CY(trsvatPERIODVO.getVAT_CY());
		trsvat_PERIODVOReturn = iisCommonDAO.returnVatRateByBranchAndCy(trsvat_PERIODVOSelect);
	    }
	    if(trsvat_PERIODVOReturn == null)
	    {
		trsvat_PERIODVOSelect.setVAT_BRANCH(BigDecimal.ZERO);
		trsvat_PERIODVOSelect.setVAT_CY(trsvatPERIODVO.getVAT_CY());
		trsvat_PERIODVOReturn = iisCommonDAO.returnVatRateByBranchAndCy(trsvat_PERIODVOSelect);
	    }

	    if(trsvat_PERIODVOReturn == null)
	    {
		trsvat_PERIODVOSelect.setVAT_BRANCH(BigDecimal.ZERO);
		trsvat_PERIODVOSelect.setVAT_CY(BigDecimal.ZERO);
		trsvat_PERIODVOReturn = iisCommonDAO.returnVatRateByBranchAndCy(trsvat_PERIODVOSelect);
	    }

	}

	if(trsvat_PERIODVOReturn == null)
	{
	    throw new BOException(MessageCodes.NULL_VAT_PERCENTAGE);
	}

	return trsvat_PERIODVOReturn;
    }

    @Override
    public void returnWarningMessageForVatBrachCode(IISCommonCO iiSCommonCO) throws BaseException
    {

	TRSVAT_PERIODVO trsvatPERIODVO = new TRSVAT_PERIODVO();
	trsvatPERIODVO.setVAT_CODE(iiSCommonCO.getVatCode());
	trsvatPERIODVO.setCOMP_CODE(iiSCommonCO.getCompCode());
	trsvatPERIODVO.setVAT_BRANCH(iiSCommonCO.getBranchCode());
	trsvatPERIODVO.setVAT_CY(iiSCommonCO.getCurrency());
	trsvatPERIODVO.setFROM_DATE(iiSCommonCO.getStartDate());

	if(trsvatPERIODVO.getVAT_CODE() == null)
	{
	    return;
	}
	if(trsvatPERIODVO.getFROM_DATE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_VALUE_DATE);
	}

	if(trsvatPERIODVO.getCOMP_CODE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
	}

	if(trsvatPERIODVO.getVAT_BRANCH() == null)
	{
	    trsvatPERIODVO.setVAT_BRANCH(BigDecimal.ZERO);
	}

	if(trsvatPERIODVO.getVAT_CY() == null)
	{
	    trsvatPERIODVO.setVAT_CY(BigDecimal.ZERO);
	}
	TRSVATVO trsvatvo = new TRSVATVO();
	trsvatvo.setCOMP_CODE(trsvatPERIODVO.getCOMP_CODE());
	trsvatvo.setVAT_CODE(trsvatPERIODVO.getVAT_CODE());
	trsvatvo = (TRSVATVO) genericDAO.selectByPK(trsvatvo);
	if(trsvatvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	}
	BigDecimal matBranchCode = BigDecimal.ZERO;
	if(!StringUtil.nullEmptyToValue(trsvatvo.getVAT_RATE_BASED_ON(), "T").equals("T"))
	{
	    if(iiSCommonCO.getDealNo() == null)
	    {
		throw new BOException("Cannot_calulate_vat_invalid_deal_number_to_get_maturity_branch");
	    }
	    if(iiSCommonCO.getDealNo().compareTo(BigDecimal.valueOf(-1)) == 0)
	    {
		matBranchCode = iiSCommonCO.getBranchCode();
	    }
	    else
	    {

		TRSDETVO trsdetvo = new TRSDETVO();
		trsdetvo.setCOMP_CODE(iiSCommonCO.getCompCode());
		trsdetvo.setBRANCH_CODE(iiSCommonCO.getBranchCode());
		trsdetvo.setSERIAL_NO(iiSCommonCO.getDealNo());

		matBranchCode = iisCommonDAO.returnMaturityAccBr(trsdetvo);
	    }
	    if(matBranchCode == null || matBranchCode.compareTo(BigDecimal.ZERO) == 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code_warning,
			new String[] { "Maturity_Account_Branch_is_not_defined_to_get_VAT_rate_key" }, true,
			ConstantsCommon.CONFIRM_MSG_TYPE, "VAT_MATURITY_BRANCH_CHECKING");
		// throw new
		// BOException("Maturity_Account_Branch_is_not_defined_to_get_VAT_rate_key",ConstantsCommon.CONFIRM_MSG_TYPE,
		// "");
	    }
	}
    }

    /**
     * Moved from Calculator Classes for LOS Integration on 13/12/2017 [Begin]
     */
    /**
     * @author Arun.Variyath -uf_check_instamt_with_cifsal_perc
     * @param islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO checkInstamtWithCifSalPerc(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCoParam) throws BaseException
    {

	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCoParam;
	// LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
	if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
		|| IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
		|| IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
	{
	    islamicCalculatorEventMgmtCO.setCalledFrom(IISCommonConstants.CALLED_FROM_LOS);
	}
	else
	{
	    islamicCalculatorEventMgmtCO.setCalledFrom(IISCommonConstants.BLANKSTRING);
	}
	// LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
	if(!isValidateSalaryMultiple(islamicCalculatorEventMgmtCO))
	{
	    return islamicCalculatorEventMgmtCO;
	}
	TRSCLASSVO trsclassvo = new TRSCLASSVO();

	trsclassvo.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	trsclassvo.setCODE(islamicCalculatorEventMgmtCO.getProductClass());

	trsclassvo = commonLibBO.returnTrsClassVO(trsclassvo);
	if(trsclassvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}
	String messageType = StringUtil.nullToEmpty(trsclassvo.getMAX_INST_PERC_OF_SAL_MSG_TYPE());
	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType())
		|| NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getCifNo())
		|| islamicCalculatorEventMgmtCO.getCifNo().doubleValue() <= 0)
	{
	    return islamicCalculatorEventMgmtCO;
	}
	BigDecimal maxInstPercSalary = NumberUtil
		.nullToZero(iisCommonDAO.returnMaxInstPercSalary(islamicCalculatorEventMgmtCO));
	if(maxInstPercSalary.compareTo(BigDecimal.ZERO) == 0)
	{
	    // LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
	    if(IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
	    {
		islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
		islamicCalculatorEventMgmtCO.getLosMessagesCO().setCode(BigDecimal.valueOf(900007));
		islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("I");
		islamicCalculatorEventMgmtCO.getLosMessagesCO().setDescription(
			"Salary Percentage is Not Specified In Product Class. Salary Validation not Done");
		islamicCalculatorEventMgmtCO.setLosMessagesCOList(new ArrayList<LOSmessagesCO>());
		islamicCalculatorEventMgmtCO.getLosMessagesCOList()
			.add(islamicCalculatorEventMgmtCO.getLosMessagesCO());
		islamicCalculatorEventMgmtCO.setLosMessagesCO(null);
	    }
	    // LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
	    islamicCalculatorEventMgmtCO.setConfirmMessageDetailId(
		    "Salary_Percentage_is_Not_Specified_In_Product_Class_Salary_Validation_not_Done_key");
	    return islamicCalculatorEventMgmtCO;
	}
	BigDecimal cifMonthSalary = NumberUtil
		.nullToZero(iisCommonDAO.getMonthlyBasicSalary(islamicCalculatorEventMgmtCO));
	if(cifMonthSalary.compareTo(BigDecimal.ZERO) == 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "CIF_Salary_Not_Specified_Salary_Validation_not_Done_key" });
	}
	BigDecimal maxInstAmount = cifMonthSalary.multiply(maxInstPercSalary).divide(BigDecimal.valueOf(100));
	// TP#228424;Arun.R.Variyath;07/10/2014 [Start]
	int totRowCount = islamicCalculatorEventMgmtCO.getTrsPayPlandetVOList().size() - 1;
	TRSPAYPLANDETVO trspayplandetVO;
	BigDecimal exchgRate = BigDecimal.ZERO;
	BigDecimal dealCy = islamicCalculatorEventMgmtCO.getCurrencyCode();
	int currRowCount = 0;
	while(totRowCount >= currRowCount)
	{
	    trspayplandetVO = islamicCalculatorEventMgmtCO.getTrsPayPlandetVOList().get(currRowCount);
	    if(trspayplandetVO != null && NumberUtil.emptyDecimalToZero(trspayplandetVO.getBALLOON_PAYMENT())
		    .compareTo(BigDecimal.ONE) != 0)
	    {
		Date valueDate = trspayplandetVO.getVALUE_DATE();
		int dateMonth = DateUtil.getDayYearMonth(valueDate, IISCommonConstants.MONTH) + 1;
		int dateYear = DateUtil.getDayYearMonth(valueDate, IISCommonConstants.YEAR);
		int dateYearNext = dateYear;
		int dateMonthNext = dateMonth;
		BigDecimal installmentAmount = BigDecimal.ZERO;
		while(dateMonthNext == dateMonth && dateYearNext == dateYear && totRowCount >= currRowCount)
		{

		    installmentAmount = installmentAmount.add(trspayplandetVO.getAMOUNT());
		    currRowCount++;

		    if(totRowCount >= currRowCount)
		    {
			trspayplandetVO = islamicCalculatorEventMgmtCO.getTrsPayPlandetVOList().get(currRowCount);
			valueDate = trspayplandetVO.getVALUE_DATE();
			dateMonthNext = DateUtil.getDayYearMonth(valueDate, IISCommonConstants.MONTH) + 1;
			dateYearNext = DateUtil.getDayYearMonth(valueDate, IISCommonConstants.YEAR);
		    }

		}

		if(dealCy.compareTo(islamicCalculatorEventMgmtCO.getBaseCurrencyCode()) != 0)
		{
		    IISCommonCO iisCommonCO = new IISCommonCO();
		    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
		    iisCommonCO.setExchangeRateCurrency(dealCy);
		    iisCommonCO.setBaseCurrencyCode(islamicCalculatorEventMgmtCO.getBaseCurrencyCode());
		    iisCommonCO.setRunningDate(islamicCalculatorEventMgmtCO.getRunningDate());
		    iisCommonCO.setExchangeDate(islamicCalculatorEventMgmtCO.getRunningDate());
		    iisCommonCO = returnExchangeRate(iisCommonCO);
		    BigDecimal Idec_exchg_rate = NumberUtil.nullToZero(iisCommonCO.getExchageRate());
		    CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
		    currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		    currenciesVOKey.setCURRENCY_CODE(dealCy);
		    CURRENCIESVO currenciesVO = (CURRENCIESVO) genericDAO.selectByPK(currenciesVOKey);
		    String mutiDivInd;
		    BigDecimal unit;
		    if(currenciesVO != null)
		    {
			unit = currenciesVO.getUNIT();
			mutiDivInd = currenciesVO.getMULT_DIV_IND();
			if(IISCommonConstants.DEAL_MULTDIV_MULTIPLY.equals(mutiDivInd))
			{
			    installmentAmount = installmentAmount.multiply(Idec_exchg_rate).divide(unit);
			}
			else
			{
			    installmentAmount = installmentAmount.divide(exchgRate).divide(unit);
			}
		    }
		}
		islamicCalculatorEventMgmtCO.setDateYear(dateYear);
		islamicCalculatorEventMgmtCO.setDateMonth(dateMonth);
		// TP#641609; Saheer.Naduthodi; 19/03/2018 [Begin]
		BigDecimal totExstInstAmt = BigDecimal.ZERO;
		if(islamicCalculatorEventMgmtCO.getTotalExstInstAmt() == null)
		{

		    totExstInstAmt = NumberUtil
			    .nullToZero(iisCommonDAO.returnSumOfInstallmentAmount(islamicCalculatorEventMgmtCO));
		}
		else
		{
		    totExstInstAmt = islamicCalculatorEventMgmtCO.getTotalExstInstAmt();

		}
		// TP#641609; Saheer.Naduthodi; 19/03/2018 [End]
		if((StringUtil.isEmptyString(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom())
			|| "MAX_INST_PERC_OF_SAL_WARNING"
				.equals(islamicCalculatorEventMgmtCO.getGlobalConfirmationFrom()))

			&& (maxInstAmount.compareTo(installmentAmount.add(totExstInstAmt)) < 0))
		{

		    if("W".equals(messageType))
		    {
			// LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
			if(IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
			{
			    islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
			    islamicCalculatorEventMgmtCO.getLosMessagesCO()
				    .setCode(BigDecimal.valueOf(MessageCodes.iis_invalid_code));
			    islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("C");
			    islamicCalculatorEventMgmtCO.getLosMessagesCO()
				    .setDescription("Installment amount exceeds the maximum salary percentage");
			}
			// LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
			else
			{
			    throw new BOException(
				    MessageCodes.INSTALLMENT_AMOUNT_CANNOT_EXCEED_SPECIFIED_PERCENTAGE_OF_CIF_SALARY,
				    new String[] { ", ", "Do_you_want_to_Continue_key" }, true,
				    ConstantsCommon.CONFIRM_MSG_TYPE, "MAX_INST_PERC_OF_SAL_WARNING");

			}
		    }
		    else
		    {
			throw new BOException(
				MessageCodes.INSTALLMENT_AMOUNT_CANNOT_EXCEED_SPECIFIED_PERCENTAGE_OF_CIF_SALARY_STOP);
		    }
		    islamicCalculatorEventMgmtCO.setGlobalConfirmationFrom(null);
		}

		/*
		 * if(maxInstAmount.compareTo(installmentAmount.add(
		 * totExstInstAmt)) < 0) { throw new
		 * BOException(MessageCodes.iis_invalid_code, new String[] {
		 * "Installment_Amount_Cannot_Exceed_Specified_Percentage_Of_CIF_Salary_key"
		 * }); }
		 */
	    }
	    else
	    {
		currRowCount++;
	    }
	}
	// TP#228424;Arun.R.Variyath;07/10/2014 [End]
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for showWarningForCifSalaryMultiple the methods to calculate the
     * payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO showWarningForCifSalaryMultiple(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {

	if(isValidateSalaryMultiple(islamicCalculatorEventMgmtCO))
	{

	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonDAO.returnProductClassDetails(trsClassVOKey);
	    trsClassVOKey = null;
	    if(trsClassVO == null)
	    {
		return islamicCalculatorEventMgmtCO;
	    }
	    BigDecimal totalFinanceAmtMaxMultSal = trsClassVO.getTOT_FINANCE_AMT_MAX_MULT_SAL();
	    if(totalFinanceAmtMaxMultSal == null || (totalFinanceAmtMaxMultSal.compareTo(BigDecimal.ZERO)) == 0)

	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("902352");
		if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
		{
		    islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setCode(BigDecimal.valueOf(902352));
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("I");
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setDescription(
			    "Salary Multiple is Not Specified In Product Class.Salary Validation not Done");
		}
		// throw new
		// BOException(MessageCodes.SALARY_MULTIPLE_IS_NOT_SPECIFIED_IN_PRODUCT_CLASS);
		// "Information,Salary Multiple is Not Specified In Product
		// Class.Salary Validation not Done");
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * TP #662919;Saheer.Naduthodi;26/04/2018
     */
    private boolean isValidateSalaryMultiple(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
    {
	if(NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getProductClass()))
	    return false;
	if(NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getCompCode()))
	    return false;
	if(NumberUtil.isEmptyDecimal(islamicCalculatorEventMgmtCO.getCifNo()))
	    return false;

	// Need to validate if product class, company code and CIF is exist
	if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
	    return true;
	if(IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
	    return true;
	if(IISCommonConstants.ISLAMIC_FINANCIL_CALCULATOR_I.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    return true;
	if(IISCommonConstants.ISLAMIC_FINANCIL_CALCULATOR_II.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	    return true;
	return false;
    }

    /**
     * Method for validating if financing amount is less than minimum financing
     * amt
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateMinFinanacingAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO trsClassVO) throws BaseException
    {
	if(trsClassVO == null)
	{
	    return islamicCalculatorEventMgmtCO;
	}
	String minValue = "", maxValue = "";
	if(trsClassVO.getMIN_FINANCING_AMT() != null && trsClassVO.getMAX_FINANCING_AMT() != null)
	{
	    minValue = StringUtil.nullToEmpty(trsClassVO.getMIN_FINANCING_AMT());
	    maxValue = StringUtil.nullToEmpty(trsClassVO.getMAX_FINANCING_AMT());
	}

	if(trsClassVO.getMIN_FINANCING_AMT() != null && trsClassVO.getCHECK_MIN_FINANCING_AMT() != null
		&& islamicCalculatorEventMgmtCO.getFinancingAmount() != null
		&& islamicCalculatorEventMgmtCO.getFinancingAmount().compareTo(trsClassVO.getMIN_FINANCING_AMT()) == -1
		&& (!trsClassVO.getCHECK_MIN_FINANCING_AMT().equals(ConstantsCommon.NO)))
	{

	    if(trsClassVO.getCHECK_MIN_FINANCING_AMT().equals("S"))
	    {
		throw new BOException(MessageCodes.FINANCE_AMT_BTW, new String[] { minValue, maxValue });
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("1664");
		if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
		{
		    islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setCode(BigDecimal.valueOf(1664));
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("C");
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setDescription("Financing Amount should be between "
			    + minValue.toString() + " and " + maxValue.toString());
		}
		// throw new BOException("Cannot Proceed, Financing Amount
		// should be between TRSCLASS.MIN_FINANCING_AMT and
		// TRSCLASS.MAX_FINANCING_AMT");
	    }

	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for further validations after the user clicks yes to calculate the
     * payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO validateMaxFinancingAmountForDealCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() != null && islamicCalculatorEventMgmtCO.getCompCode() != null)
	{
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonDAO.returnProductClassDetails(trsClassVOKey);
	    trsClassVOKey = null;
	    if(trsClassVO == null)
	    {
		return islamicCalculatorEventMgmtCO;
	    }
	    islamicCalculatorEventMgmtCO = validateMaxFinancingAmount(islamicCalculatorEventMgmtCO, trsClassVO);
	    // Fix to show the message if the limit is between the min and max
	    // amounts.
	    islamicCalculatorEventMgmtCO = validateFinancingLimitMaxMinAmount(islamicCalculatorEventMgmtCO, trsClassVO);
	    // islamicCalculatorEventMgmtCO =
	    // validateFinancingLimitMinAmount(islamicCalculatorEventMgmtCO,trsClassVO);

	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;

    }

    /**
     * Method for validating financing amount should not exceed maximum
     * financing amount the methods to calculate the payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    private IslamicCalculatorEventMgmtCO validateMaxFinancingAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO trsClassVOParam) throws BaseException
    {
	TRSCLASSVO trsClassVO = trsClassVOParam;
	if(trsClassVO == null)
	{
	    return islamicCalculatorEventMgmtCO;
	}
	String minValue = "", maxValue = "";
	if(trsClassVO.getMIN_FINANCING_AMT() != null && trsClassVO.getMAX_FINANCING_AMT() != null)
	{
	    minValue = StringUtil.nullToEmpty(trsClassVO.getMIN_FINANCING_AMT());
	    maxValue = StringUtil.nullToEmpty(trsClassVO.getMAX_FINANCING_AMT());
	}

	if(trsClassVO.getMAX_FINANCING_AMT() != null && trsClassVO.getCHECK_MAX_FINANCING_AMT() != null
		&& islamicCalculatorEventMgmtCO.getFinancingAmount() != null
		&& (islamicCalculatorEventMgmtCO.getFinancingAmount().compareTo(trsClassVO.getMAX_FINANCING_AMT()) == 1)
		&& (!trsClassVO.getCHECK_MAX_FINANCING_AMT().equals(ConstantsCommon.NO)))
	{

	    if("S".equals(trsClassVO.getCHECK_MAX_FINANCING_AMT()))
	    {
		throw new BOException(MessageCodes.FINANCE_AMT_BTW, new String[] { minValue, maxValue });
		// Cannot Proceed,Financing Amount should be between
		// TRSCLASS . MIN_FINANCING_AMT and TRSCLASS .
		// MAX_FINANCING_AMT");
	    }
	    else
	    {
		islamicCalculatorEventMgmtCO.setConfirmationMessageId("1664");
		if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
		{
		    islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setCode(BigDecimal.valueOf(1664));
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("C");
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setDescription("Financing Amount should be between "
			    + minValue.toString() + " and " + maxValue.toString());
		}
		// throw new BOException("Cannot Proceed, Financing Amount
		// should be between TRSCLASS.MIN_FINANCING_AMT and
		// TRSCLASS.MAX_FINANCING_AMT");
	    }

	}
	trsClassVO = null;
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validating financing amount should not exceed limit max
     * financing amount the methods to calculate the payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    private IslamicCalculatorEventMgmtCO validateFinancingLimitMaxMinAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO, TRSCLASSVO trsClassVOParam) throws BaseException
    {
	TRSCLASSVO trsClassVO = trsClassVOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() != null && islamicCalculatorEventMgmtCO.getCompCode() != null)
	{
	    if(trsClassVO == null)
	    {
		return islamicCalculatorEventMgmtCO;
	    }
	    BigDecimal maxValue = BigDecimal.ZERO, minValue = BigDecimal.ZERO;
	    if(trsClassVO.getLIMIT_MAX() != null && trsClassVO.getLIMIT_MIN() != null)
	    {
		minValue = trsClassVO.getLIMIT_MIN();
		maxValue = trsClassVO.getLIMIT_MAX();
	    }
	    if(minValue == null)
	    {
		minValue = BigDecimal.ZERO;
	    }

	    CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
	    currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
	    CURRENCIESVO currenciesVO;

	    if(islamicCalculatorEventMgmtCO.getCurrencyCode() == null)
	    {
		currenciesVO = null;
	    }
	    else
	    {
		currenciesVO = returnCurrencyDetails(currenciesVOKey);
	    }

	    BigDecimal currencyDecimalPoints = currenciesVO == null ? BigDecimal.ZERO
		    : currenciesVO.getDECIMAL_POINTS();

	    int currDecimalPoints = NumberUtil.toInt(currencyDecimalPoints);

	    if(maxValue == null || maxValue.compareTo(BigDecimal.ZERO) == 0)
	    {
		maxValue = BigDecimal.valueOf(999999999999d);
		maxValue = returnAmountWithCurrencyDecimalForMaxMin(maxValue, currDecimalPoints, "MAX");
	    }

	    minValue = NumberUtil.roundToBigDecimal(minValue, currDecimalPoints);

	    maxValue = NumberUtil.roundToBigDecimal(maxValue, currDecimalPoints);

	    if(islamicCalculatorEventMgmtCO.getFinancingAmount().doubleValue() > maxValue.doubleValue()
		    || islamicCalculatorEventMgmtCO.getFinancingAmount().doubleValue() < minValue.doubleValue())
	    {
		throw new BOException(MessageCodes.FINANCE_AMT_BTW,
			new String[] { minValue.toString(), maxValue.toString() });

	    }

	    trsClassVO = null;

	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validating the deal period if deal period is exceeding the max
     * period
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    public IslamicCalculatorEventMgmtCO validateDealPeriod(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO,
	    TRSCLASSVO trsClassVO) throws BaseException
    {
	if(trsClassVO != null)
	{
	    if(trsClassVO.getREPAYMENTS_MAX() == null)
	    {
		trsClassVO.setREPAYMENTS_MAX(BigDecimal.ZERO);
	    }
	    // TP#227303;Arun.R.Variyath;29/09/2014 [Start]
	    BigDecimal maxPayments = trsClassVO.getREPAYMENTS_MAX();
	    BigDecimal noOfPayments = islamicCalculatorEventMgmtCO.getNoOfPayments();
	    // 627304
	    if(maxPayments.compareTo(BigDecimal.ZERO) == 1 && noOfPayments.compareTo(maxPayments) > 0)
	    {
		throw new BOException(MessageCodes.iis_invalid_code,
			new String[] { "No_of_payments_exceeds_maximum_number_key" });
	    }
	    BigDecimal periodicityNbr = NumberUtil.nullToZero(trsClassVO.getPERIODICITY_NBR());
	    Date startDate = islamicCalculatorEventMgmtCO.getStartDate();
	    Date maturityDate = islamicCalculatorEventMgmtCO.getMaturityDate();
	    String periodictyType = StringUtil.nullEmptyToValue(trsClassVO.getPERIODICITY_TYPE(), "D");
	    if("Y".equals(periodictyType))
	    {
		periodicityNbr = periodicityNbr.multiply(BigDecimal.valueOf(12));
	    }
	    else if("W".equals(StringUtil.nullToEmpty(trsClassVO.getPERIODICITY_TYPE())))
	    {
		periodicityNbr = periodicityNbr.multiply(BigDecimal.valueOf(7));
	    }
	    Date toDate = null;
	    if("Y".equals(periodictyType) || "M".equals(periodictyType))
	    {
		toDate = DateUtil.relativeMonth(startDate, periodicityNbr.intValue());
	    }
	    else if("D".equals(periodictyType) || "W".equals(periodictyType))
	    {
		toDate = DateUtil.relativeDate(startDate, periodicityNbr.intValue());
	    }
	    IISCommonCO iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(islamicCalculatorEventMgmtCO.getCompCode());
	    iisCommonCO.setBranchCode(islamicCalculatorEventMgmtCO.getBranchCode());

	    iisCommonCO = returnDaysAfterMaximumPeriod(iisCommonCO);

	    BigDecimal daysAfterMaxPeriod = NumberUtil.nullToZero(iisCommonCO.getDaysAfterMaximumPeriod());

	    iisCommonCO = null;
	    Date relativeDateAfterAddingDays = DateUtil.relativeDate(toDate, daysAfterMaxPeriod.intValue());
	    if(!"M0168".equals(StringUtil.nullToEmpty(islamicCalculatorEventMgmtCO.getPageRef()))
		    && periodicityNbr.doubleValue() > 0 && maturityDate.after(relativeDateAfterAddingDays))
	    {

		String checkDealPeriodIndic = StringUtil.nullEmptyToValue(trsClassVO.getCHK_DEAL_PERIOD_IND(), "N");
		if(checkDealPeriodIndic.equals(IISCommonConstants.MESSAGE_TYPEWARNING))
		{
		    if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING
			    .equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			    || IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			    || IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
		    {
			islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
			islamicCalculatorEventMgmtCO.getLosMessagesCO()
				.setCode(BigDecimal.valueOf(MessageCodes.iis_invalid_code));
			islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("C");
			islamicCalculatorEventMgmtCO.getLosMessagesCO()
				.setDescription("Deal Period Exceeds Maximum Period");
		    }
		    // TO DO Handle confirmation fron JS
		    // else
		    // {
		    // throw new BOException(IISMessageCodes.IIS_WARNING_CODE,
		    // new String[] {
		    // "Total Periods Exceeds Maximum Deal Period" },
		    // ConstantsCommon.CONFIRM_MSG_TYPE,
		    // "FOREX_TENURE_LIMIT_LESS_THAN_CONFIRMATION", false);
		    // }
		}
		else if(checkDealPeriodIndic.equals(IISCommonConstants.MESSAGE_TYPE_STOP))
		{
		    throw new BOException(MessageCodes.PROC_DEAL_PERIOD_EXCEEDS_MAX_PERIOD);
		}
	    }

	    if(islamicCalculatorEventMgmtCO.getDealPeriodCompounding().equals(ConstantsCommon.NO)
		    && islamicCalculatorEventMgmtCO.getFirstPaymentDate() == null)
	    {
		throw new BOException(MessageCodes.INVALID_FIRST_PAYMENT_DATE);

	    }
	    // TP#227303;Arun.R.Variyath;29/09/2014 [End]
	}
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO checkCifExistingDeals(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setBRANCH_CODE(islamicCalculatorEventMgmtCO.getBranchCode());
	iisctrlvoKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	IISCTRLVO iisctrlVO = returnIISCTRL(iisctrlvoKey);
	// getCifExistingDealCount(islamicCalculatorEventMgmtCO);
	// TP# 190913;deepu.mohandas 15/05/2015
	IslamicCalculatorEventMgmtCO resultCO = iisCommonDAO.returnCifExistingDealCount(islamicCalculatorEventMgmtCO);
	if(resultCO != null)
	{

	    StringBuffer message = new StringBuffer();
	    message.append("Deal Exists.\n");
	    if(resultCO.getACTIVE_DEAL_COUNT().compareTo(BigDecimal.ZERO) == 1)
	    {
		message.append("Active Deals : ");
		message.append(resultCO.getACTIVE_DEAL_COUNT());
		message.append("\n");
	    }
	    if(resultCO.getAPPROVE_DEAL_COUNT().compareTo(BigDecimal.ZERO) == 1)
	    {
		message.append("Approved Deals : ");
		message.append(resultCO.getAPPROVE_DEAL_COUNT());
		message.append("\n");
	    }
	    if(resultCO.getDELETE_DEAL_COUNT().compareTo(BigDecimal.ZERO) == 1)
	    {

		message.append("Deleted Deals : ");
		message.append(resultCO.getDELETE_DEAL_COUNT());
		message.append("\n");
	    }
	    if(resultCO.getREVERSE_DEAL_COUNT().compareTo(BigDecimal.ZERO) == 1)
	    {
		message.append("Reversed Deals : ");
		message.append(resultCO.getREVERSE_DEAL_COUNT());
		message.append("\n");
	    }

	    if(ConstantsCommon.YES.equals(iisctrlVO.getCHECK_CIF_EXISTING_DEALS_YN()))
	    {
		if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))
		{
		    islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
		    islamicCalculatorEventMgmtCO.getLosMessagesCO()
			    .setCode(BigDecimal.valueOf(MessageCodes.DEAL_EXISTS));
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("C");

		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setDescription(message.toString());
		}
		else
		{
		    message.append("Do you want to View the Details?");
		    throw new BOException(MessageCodes.iis_invalid_code_warning,
			    new String[] { "Warning_key", message.toString() }, ConstantsCommon.CONFIRM_MSG_TYPE,
			    IISCommonConstants.CHECK_CIF_EXISTING_DEALS, false);
		}

	    }
	    if("S".equals(iisctrlVO.getCHECK_CIF_EXISTING_DEALS_YN()))
	    {

		if(resultCO.getACTIVE_DEAL_COUNT().compareTo(BigDecimal.ZERO) == 1)
		{
		    throw new BOException(MessageCodes.iis_invalid_code, new String[] { message.toString() }, false);
		}
		else if(IISCommonConstants.CALLED_FROM_INTERNET_BANKING
			.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_LOS.equals(islamicCalculatorEventMgmtCO.getCalledFrom())
			|| IISCommonConstants.CALLED_FROM_WS.equals(islamicCalculatorEventMgmtCO.getCalledFrom()))

		{
		    islamicCalculatorEventMgmtCO.setLosMessagesCO(new LOSmessagesCO());
		    islamicCalculatorEventMgmtCO.getLosMessagesCO()
			    .setCode(BigDecimal.valueOf(MessageCodes.DEAL_EXISTS));
		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setType("C");

		    islamicCalculatorEventMgmtCO.getLosMessagesCO().setDescription(message.toString());
		}
		else
		{
		    message.append("Do you want to View the Details?");
		    throw new BOException(MessageCodes.iis_invalid_code_warning,
			    new String[] { "Warning_key", message.toString() }, ConstantsCommon.CONFIRM_MSG_TYPE,
			    IISCommonConstants.CHECK_CIF_EXISTING_DEALS, resultCO.getACTIVE_DEAL_COUNT());

		}

	    }

	}
	return islamicCalculatorEventMgmtCO;

    }

    /**
     * Method for validating the CifSalaryMultiple the methods to calculate the
     * payment schedule
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */

    public IslamicCalculatorEventMgmtCO validateForCifSalaryMultiple(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() != null && islamicCalculatorEventMgmtCO.getCompCode() != null
		&& islamicCalculatorEventMgmtCO.getCifNo() != null)
	{
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonDAO.returnProductClassDetails(trsClassVOKey);
	    trsClassVOKey = null;
	    if(trsClassVO == null)
	    {
		return islamicCalculatorEventMgmtCO;
	    }
	    islamicCalculatorEventMgmtCO = validateCifSalary(islamicCalculatorEventMgmtCO, trsClassVO);
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validating Cif salary if the cif salary is less than deal
     * amount.
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    private IslamicCalculatorEventMgmtCO validateCifSalary(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO,
	    TRSCLASSVO trsClassVO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getCifNo() != null
		&& NumberUtil.toInt(islamicCalculatorEventMgmtCO.getCifNo()) > 0)
	{
	    if(trsClassVO == null)
	    {
		return islamicCalculatorEventMgmtCO;
	    }
	    BigDecimal totalFinanceAmtMaxMultSal = trsClassVO.getTOT_FINANCE_AMT_MAX_MULT_SAL();
	    // if(totalFinanceAmtMaxMultSal== null ||
	    // doubleValue(totalFinanceAmtMaxMultSal)== 0)
	    // {
	    // throw new
	    // BOException(MessageCodes.SALARY_MULTIPLE_IS_NOT_SPECIFIED_IN_PRODUCT_CLASS);
	    // //"Information,Salary Multiple is Not Specified In Product
	    // Class.Salary Validation not Done");Added
	    // this validation in separate method as it is a warning.
	    // }

	    double maximumSalaryTimes = NumberUtil.toDouble(totalFinanceAmtMaxMultSal);
	    if(maximumSalaryTimes == 0)
	    {
		return islamicCalculatorEventMgmtCO;
	    }
	    double monthlyBasicSalary = NumberUtil
		    .toDouble(iisCommonDAO.getMonthlyBasicSalary(islamicCalculatorEventMgmtCO));
	    if(monthlyBasicSalary == 0)
	    {
		throw new BOException(MessageCodes.CIF_SALARY_NOT_SPECIFIED);
	    }
	    double maximumFinanceAmount = monthlyBasicSalary * maximumSalaryTimes;
	    if((islamicCalculatorEventMgmtCO.getCurrencyCode())
		    .compareTo(islamicCalculatorEventMgmtCO.getBaseCurrencyCode()) != 0)
	    {
		CommonLibSC commonLibSC = new CommonLibSC();
		commonLibSC.setCompanyCode(islamicCalculatorEventMgmtCO.getCompCode());
		commonLibSC.setAccCurrency(islamicCalculatorEventMgmtCO.getCurrencyCode());
		commonLibSC.setSelectedDate(islamicCalculatorEventMgmtCO.getRunningDate());
		BigDecimal exchangeRate = iisCommonDAO.returnExchangeRate(commonLibSC);
		commonLibSC = null;

		CURRENCIESVOKey currenciesVOKey = new CURRENCIESVOKey();
		currenciesVOKey.setCURRENCY_CODE(islamicCalculatorEventMgmtCO.getCurrencyCode());
		currenciesVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
		CURRENCIESVO currenciesvo = iisCommonDAO.getCurrencyDetails(currenciesVOKey);
		currenciesVOKey = null;
		if(currenciesvo != null)
		{
		    islamicCalculatorEventMgmtCO.setFinancingAmount(CommonMethods.multiplyDivideAmount(
			    currenciesvo.getMULT_DIV_IND(), islamicCalculatorEventMgmtCO.getFinancingAmount(),
			    exchangeRate, currenciesvo.getUNIT(), currenciesvo.getDECIMAL_POINTS()));
		}

		currenciesvo = null;

	    }
	    double outstandingAmount = NumberUtil
		    .toDouble(iisCommonDAO.returnOutstandingAmountOfExistingDeals(islamicCalculatorEventMgmtCO));
	    if(maximumFinanceAmount < outstandingAmount
		    + NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getFinancingAmount()))
	    {
		throw new BOException(MessageCodes.DEAL_AMOUNT_GRT_THAN_CIF_SALARY);
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    // BB160136
    @Override
    public IslamicCalculatorEventMgmtCO validateFlexiPayment(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	if(ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getFlexiPaymentYn()))
	{
	    if(!IISCommonConstants.PROFIT_CALCULATION_METHOD_DIMINISHING_RETURNS
		    .equals(islamicCalculatorEventMgmtCO.getProfitCalcMethod()))
	    {
		throw new BOException(
			MessageCodes.FLEXI_PAYMENTS_APPLICABLE_ONLY_IF_CALCULATION_METHOD_IS_DIMINISHING_RETURNS);
	    }
	    if(!IISCommonConstants.MONTH.equals(islamicCalculatorEventMgmtCO.getPaymPeriodicity()))
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_ALLOWED_FOR_MONTHLY_INSTALLMENT);
	    }
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfPayments())
		    .compareTo(BigDecimal.ONE) < 1)
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_ALLOWED_FOR_NUMBER_OF_PAYMENTS_GREATER_THAN_1);
	    }
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getRepaymentCriteriaRowCount())
		    .compareTo(BigDecimal.ZERO) == 1)
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_REPAYMENT_PLAN_CRITERIA);
	    }
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments())
		    .compareTo(BigDecimal.ZERO) == 1)
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_BALLOON_PAYMENT);
	    }
	    if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getTempCode())
		    .compareTo(BigDecimal.ZERO) == 1)
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_REPAYMENT_PLAN_TEMPLATE);
	    }
	    if(IISCommonConstants.TRUE.equals(islamicCalculatorEventMgmtCO.getDealPeriodCompounding())
		    || ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getDealPeriodCompounding()))
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_DEAL_PERIOD_COMPOUNDING);
	    }
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonDAO.returnProductClassDetails(trsClassVOKey);
	    trsClassVOKey = null;
	    if(trsClassVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	    }
	    if(ConstantsCommon.YES.equals(trsClassVO.getGRACE_PRD_CMPND_PFT_DEAL_YN()))
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_GRACE_PERIOD_COMPOUNDING);
	    }
	    if(ConstantsCommon.YES.equals(trsClassVO.getPRINCIPAL_LAST()))
	    {
		throw new BOException(MessageCodes.FLEXI_PAYMENTS_IS_NOT_APPLICABLE_WITH_REDUCING_BALANCE_METHOD);
	    }

	}
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO validateFieldsForDealCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() != null && islamicCalculatorEventMgmtCO.getCompCode() != null)
	{
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonDAO.returnProductClassDetails(trsClassVOKey);
	    islamicCalculatorEventMgmtCO = validateVatCode(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = validateYieldRate(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = validateDealAmount(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = validateMinFinanacingAmount(islamicCalculatorEventMgmtCO, trsClassVO);
	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    private IslamicCalculatorEventMgmtCO validateVatCode(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getVatIcludedInInstallement() != null
		&& islamicCalculatorEventMgmtCO.getVatIcludedInInstallement().equals("true"))
	{
	    if(islamicCalculatorEventMgmtCO.getVatCode() == null
		    || NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getVatCode()) <= 0)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	    }
	    if(islamicCalculatorEventMgmtCO.getVatPercentage() == null
		    || NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getVatCode()) <= 0)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	    }
	}
	return islamicCalculatorEventMgmtCO;
    }

    private IslamicCalculatorEventMgmtCO validateYieldRate(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	if(IISCommonConstants.ISLAMIC_BILLS_CALCULATOR.equals(islamicCalculatorEventMgmtCO.getCalculatorType()))
	{
	    return islamicCalculatorEventMgmtCO;
	}
	if(islamicCalculatorEventMgmtCO.getYield() != null && islamicCalculatorEventMgmtCO.getProfitCalcMethod() != null
		&& islamicCalculatorEventMgmtCO.getTotalFlatRate() != null
		&& islamicCalculatorEventMgmtCO.getYield().compareTo(BigDecimal.ZERO) == 1
		&& "S".equals(islamicCalculatorEventMgmtCO.getProfitCalcMethod())
		&& islamicCalculatorEventMgmtCO.getTotalFlatRate().compareTo(BigDecimal.ZERO) == 1 && NumberUtil
			.nullToZero(islamicCalculatorEventMgmtCO.getContractPrice()).compareTo(BigDecimal.ZERO) != 1)
	{
	    throw new BOException(MessageCodes.SPECIFY_EITHER_YIELD_OR_TOTAL_FLAT_RATE);

	}
	return islamicCalculatorEventMgmtCO;
    }

    private IslamicCalculatorEventMgmtCO validateDealAmount(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getFinancingAmount() != null
		&& (islamicCalculatorEventMgmtCO.getFinancingAmount().compareTo(BigDecimal.ZERO) == -1
			|| islamicCalculatorEventMgmtCO.getFinancingAmount()
				.compareTo(BigDecimal.valueOf(999999999999.999)) == 1))
	{
	    throw new BOException(MessageCodes.FINANCE_AMT_BTW, new String[] { "0", "999999999999.999" });
	}
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO validateNoOfPaymentsForDealCharges(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCOParam) throws BaseException
    {
	IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO = islamicCalculatorEventMgmtCOParam;
	if(islamicCalculatorEventMgmtCO.getProductClass() != null && islamicCalculatorEventMgmtCO.getCompCode() != null)
	{
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonDAO.returnProductClassDetails(trsClassVOKey);
	    islamicCalculatorEventMgmtCO = validateNoOfPayments(islamicCalculatorEventMgmtCO, trsClassVO);
	    islamicCalculatorEventMgmtCO = validateOnChangePayEvery(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = validateDealPeriod(islamicCalculatorEventMgmtCO, trsClassVO);
	    islamicCalculatorEventMgmtCO = validateBalloonAmount(islamicCalculatorEventMgmtCO);
	    islamicCalculatorEventMgmtCO = validateYield(islamicCalculatorEventMgmtCO);
	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    private IslamicCalculatorEventMgmtCO validateNoOfPayments(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO,
	    TRSCLASSVO trsClassVOParam) throws BaseException
    {

	if(islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO() == null
		|| islamicCalculatorEventMgmtCO.getTrsPayplanCriteriaVO().isEmpty())
	{
	    if(islamicCalculatorEventMgmtCO.getNoOfPayments() == null
		    || NumberUtil.toInt(islamicCalculatorEventMgmtCO.getNoOfPayments()) == 0)
	    {
		throw new BOException(MessageCodes.INVALID_NUMBER_OF_PAYMENTS);
	    }
	}
	else if(islamicCalculatorEventMgmtCO.getNoOfPayments() == null)
	{
	    islamicCalculatorEventMgmtCO.setNoOfPayments(BigDecimal.ZERO);
	}

	TRSCLASSVO trsClassVO = trsClassVOParam;
	if(trsClassVO != null && trsClassVO.getREPAYMENTS_MAX() != null
		&& NumberUtil.toInt(islamicCalculatorEventMgmtCO.getNoOfPayments()) > NumberUtil
			.toInt(trsClassVO.getREPAYMENTS_MAX()))
	{

	    throw new BOException(MessageCodes.CANNOT_PROC_NO_OF_PAYMENTS_EXCEEDS_LIMIT);

	}

	if(islamicCalculatorEventMgmtCO.getMaturityDate() == null)
	{

	    throw new BOException(MessageCodes.iis_invalid_code, new String[] { "Maturity_date_required_key" });
	}

	if(islamicCalculatorEventMgmtCO.getStartDate().after(islamicCalculatorEventMgmtCO.getMaturityDate()))
	{
	    throw new BOException(MessageCodes.MAT_DTE_CANT_BEFORE_OR_EQUALTO_START_DTE);
	}
	trsClassVO = null;
	return islamicCalculatorEventMgmtCO;
    }

    public IslamicCalculatorEventMgmtCO validateOnChangePayEvery(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(islamicCalculatorEventMgmtCO.getProductClass() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_PRODUCT_CLASS);
	}

	if(islamicCalculatorEventMgmtCO.getPaymPeriodNbr() != null)
	{
	    if(NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getPaymPeriodNbr()) <= 0)
	    {
		throw new BOException(MessageCodes.INVALID_NUMBER_OF_PAYMENTS);
	    }
	    if(NumberUtil.toDouble(islamicCalculatorEventMgmtCO.getPaymPeriodNbr()) > 999)
	    {
		throw new BOException(MessageCodes.PROC_DEAL_PERIOD_EXCEEDS_MAX_PERIOD);
	    }
	}
	if(islamicCalculatorEventMgmtCO.getProductClass() != null
		&& (islamicCalculatorEventMgmtCO.getProductClass()).compareTo(BigDecimal.ZERO) == 1
		&& islamicCalculatorEventMgmtCO.getCompCode() != null)
	{
	    TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
	    trsClassVOKey.setCOMP_CODE(islamicCalculatorEventMgmtCO.getCompCode());
	    trsClassVOKey.setCODE(islamicCalculatorEventMgmtCO.getProductClass());
	    TRSCLASSVO trsClassVO = iisCommonDAO.returnProductClassDetails(trsClassVOKey);
	    if(trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN() != null
		    && trsClassVO.getMSG_ON_EDIT_DEFAULT_DATE_YN().equals(ConstantsCommon.YES)
		    && (!islamicCalculatorEventMgmtCO.getCheckDefaultMaturityDate()))
	    {

		islamicCalculatorEventMgmtCO.setConfirmationMessageId("902080");
		islamicCalculatorEventMgmtCO.setCheckDefaultMaturityDate(true);

	    }
	    trsClassVO = null;
	}
	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Method for validating the balloon payments to check the no of balloon
     * payments and balloon amount greater then 0
     * 
     * @param islamicCalculatorEventMgmtCO
     * @return islamicCalculatorEventMgmtCO
     * @throws BaseException
     */
    private IslamicCalculatorEventMgmtCO validateBalloonAmount(
	    IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO) throws BaseException
    {
	if(NumberUtil.toInt(islamicCalculatorEventMgmtCO.getNoOfBaloonPayments()) > 0
		&& (islamicCalculatorEventMgmtCO.getBaloonAmount() == null
			|| (islamicCalculatorEventMgmtCO.getBaloonAmount()).compareTo(BigDecimal.ZERO) < 1))
	{
	    throw new BOException(MessageCodes.CANNOT_PROC_BALLON_AMT_NOT_SPECIFIED);
	}
	List<TrsPlanBallonPaymentCO> listBallonPaymentCOs = islamicCalculatorEventMgmtCO.getBalloonDetailsList();
	if(listBallonPaymentCOs == null || listBallonPaymentCOs.isEmpty())
	{
	    return islamicCalculatorEventMgmtCO;
	}
	double sumOfBalloonAmount = 0d;
	for(TrsPlanBallonPaymentCO eachBallonPaymentCO : listBallonPaymentCOs)
	{
	    if(eachBallonPaymentCO.getBalloonDate() == null)
	    {
		throw new BOException(MessageCodes.INVALID_BALLOON_DETAILS);
	    }
	    if(eachBallonPaymentCO.getBalloonAmount() == null
		    || (eachBallonPaymentCO.getBalloonAmount()).compareTo(BigDecimal.ZERO) < 1)
	    {
		throw new BOException(MessageCodes.INVALID_BALLOON_DETAILS);
	    }

	    sumOfBalloonAmount = sumOfBalloonAmount + (eachBallonPaymentCO.getBalloonAmount()).floatValue();
	}
	if(sumOfBalloonAmount > (islamicCalculatorEventMgmtCO.getBaloonAmount()).floatValue())
	{
	    throw new BOException(MessageCodes.AMOUNT_EXCEEDS_TOTAL_BALLOON_AMT);
	}
	return islamicCalculatorEventMgmtCO;
    }

    private IslamicCalculatorEventMgmtCO validateYield(IslamicCalculatorEventMgmtCO islamicCalculatorEventMgmtCO)
	    throws BaseException
    {

	if(NumberUtil.emptyDecimalToZero(islamicCalculatorEventMgmtCO.getYield()).compareTo(BigDecimal.ZERO) == 0
		&& ConstantsCommon.YES.equals(islamicCalculatorEventMgmtCO.getYieldRequired()))
	{
	    throw new BOException(MessageCodes.CANNOT_PROC_ANNUAL_RATE_NOT_SPECIFIED);
	}

	return islamicCalculatorEventMgmtCO;
    }

    /**
     * Moved from Calculator Classes for LOS Integration on 13/12/2017 [End]
     */

    @Override
    public int returnCivilIdCount(IISCommonCO iisCommonCO) throws BaseException
    {
	return iisCommonDAO.returnCivilIdCount(iisCommonCO);
    }

    @Override
    public void checkLimitRelatedCY(IISCommonCO iisCommonCO) throws BaseException
    {
	if(NumberUtil.isEmptyDecimal(iisCommonCO.getLimitCode()))
	{
	    return;
	}
	try
	{
	    Assert.notNull(iisCommonCO.getCompCode(), "Invalid/ Missing Company Code");
	    Assert.notNull(iisCommonCO.getBranchCode(), "Invalid/ Missing Branch Code");
	    Assert.notNull(iisCommonCO.getCifNo(), "Invalid/ Missing Cif No");
	    Assert.notNull(iisCommonCO.getLimitCode(), "Invalid/ Missing Limit Serial No");
	    Assert.notNull(iisCommonCO.getCurrency(), "Invalid/ Missing Currency");
	}
	catch(Exception e)
	{
	    throw new BOException(e.getMessage());
	}
	if(NumberUtil.isEmptyDecimal(iisCommonCO.getLimitCY()))
	{
	    TRSCIFLIMITDETVO trsciflimitdetvo = new TRSCIFLIMITDETVO();
	    trsciflimitdetvo.setCOMP_CODE(iisCommonCO.getCompCode());
	    trsciflimitdetvo.setBRANCH_CODE(iisCommonCO.getBranchCode());
	    trsciflimitdetvo.setSERIAL_NO(iisCommonCO.getLimitCode());
	    BigDecimal limitCY = iisCommonDAO.returnLimitCY(trsciflimitdetvo);
	    trsciflimitdetvo = null;
	    if(NumberUtil.isEmptyDecimal(limitCY))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_LIMIT_SERIAL_NO);
	    }
	    iisCommonCO.setLimitCY(limitCY);
	}
	if(iisCommonCO.getCurrency().compareTo(iisCommonCO.getLimitCY()) == 0)
	{
	    return;
	}
	int count = iisCommonDAO.returnRelatedCYCount(iisCommonCO);
	if(count < 1)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Specified Currency is Not Defined in Limit" }, false);
	}

    }

	    /**
     * To retrieve the list of deals which marked for utilizing in asset dash
     * board where those not utilized yet
     * 
     * @param investmentDealSC compCode : logged in company Code branchCode :
     *            logged in branch Code baseCurrencyCode : Base currency code
     *            for the company, using for getting cross rate if utilization
     *            currency is other than the deal currency, runningDate using
     *            for getting cross rate if utilization currency is other than
     *            the deal currency tangibleAsset : Y OR N if its Y then will
     *            return the deals of the product of Ijarah, Istisna and Wakala
     *            Investment, else "N" will return the deals other than Ijarah,
     *            Istisna and Wakala Investment products fromDate :period from
     *            toDate : period to
     * 
     * @return List of IISInvestmentDealCO
     * @throws BaseException
     */
    @Override
    public List<IISInvestmentDealCO> returnInvestDealList(IISInvestmentDealSC investmentDealSC) throws BaseException
    {

	if(investmentDealSC == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_INFORMATION);
	}
	if(NumberUtil.isEmptyDecimal(investmentDealSC.getCompCode()))
	{
	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
	}
	if(NumberUtil.isEmptyDecimal(investmentDealSC.getBranchCode()))
	{
	    throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
	}
	if(NumberUtil.isEmptyDecimal(investmentDealSC.getBaseCurrencyCode()))
	{
	    // Invalid Base Currency
	    throw new BOException(900444);
	}
	if(investmentDealSC.getRunningDate() == null)
	{
	    throw new BOException(MessageCodes.INVALID_RUNNING_DATE);
	}

	List<IISInvestmentDealCO> investDealList = iisCommonDAO.returnInvestDealList(investmentDealSC);
	if(investDealList == null || investDealList.isEmpty())
	{
	    return investDealList;
	}
	BigDecimal utilizationCurrency = investmentDealSC.getUtilizationCurrency();
	if(NumberUtil.isEmptyDecimal(utilizationCurrency))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
	}
	CURRENCIESVO currenciesvo = new CURRENCIESVO();
	currenciesvo.setCOMP_CODE(investmentDealSC.getCompCode());
	currenciesvo.setCURRENCY_CODE(utilizationCurrency);
	currenciesvo = commonLibBO.returnCurrency(currenciesvo);

	for(IISInvestmentDealCO investmentDealCO : investDealList)
	{
	    BigDecimal principalAmount = NumberUtil.nullToZero(investmentDealCO.getPrincipalAmount());
	    BigDecimal income = NumberUtil.nullToZero(investmentDealCO.getIncome());
	    BigDecimal dealCurrency = investmentDealCO.getDealCurrency();
	    if(utilizationCurrency.compareTo(dealCurrency) != 0)
	    {
		IISCommonCO iisCommonCO = new IISCommonCO();
		iisCommonCO.setCompCode(investmentDealSC.getCompCode());
		iisCommonCO.setBranchCode(investmentDealSC.getBranchCode());
		iisCommonCO.setTrCurrency(dealCurrency);
		iisCommonCO.setPfCurrency(utilizationCurrency);
		iisCommonCO.setBaseCurrencyCode(investmentDealSC.getBaseCurrencyCode());
		iisCommonCO.setCrossDate(investmentDealSC.getRunningDate());
		iisCommonCO.setCifNo(investmentDealCO.getCifNo());
		iisCommonCO = returnCrossRate(iisCommonCO);
		BigDecimal exchRate = iisCommonCO.getCrossRate();
		if(exchRate == null || exchRate.compareTo(BigDecimal.ZERO) <= 0)
		{
		    exchRate = BigDecimal.ONE;
		}
		BigDecimal amortization = NumberUtil.nullToZero(investmentDealCO.getAmortization());
		amortization = NumberUtil.roundToBigDecimal(amortization.multiply(exchRate),
			currenciesvo.getDECIMAL_POINTS().intValue());
		investmentDealCO.setAmortization(amortization);

		principalAmount = NumberUtil.roundToBigDecimal(principalAmount.multiply(exchRate),
			currenciesvo.getDECIMAL_POINTS().intValue());
		investmentDealCO.setPrincipalAmount(principalAmount);

		income = NumberUtil.roundToBigDecimal(income.multiply(exchRate),
			currenciesvo.getDECIMAL_POINTS().intValue());
		investmentDealCO.setIncome(income);
	    }
	    investmentDealCO.setNetAssetValue(principalAmount.add(income));
	}
	return investDealList;
    }

    /**
     * 
     * @param investmentDealSC compCode : logged in company Code branchCode :
     *            logged in branch Code dealNumber : deal number to update
     *            utilizaionStatus : "Y" or "N"
     * 
     * @return
     * @throws BaseException
     */
    @Override
    public int updateDealUtilizationFromAsset(IISInvestmentDealSC investmentDealSC) throws BaseException
    {
		if(investmentDealSC == null)
		{
			throw new BOException(MessageCodes.INVALID_MISSING_INFORMATION);
		}
		if(NumberUtil.isEmptyDecimal(investmentDealSC.getCompCode()))
		{
			throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
		}
		if(NumberUtil.isEmptyDecimal(investmentDealSC.getBranchCode()))
		{
			throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
		}
		if(NumberUtil.isEmptyDecimal(investmentDealSC.getDealNumber()))
		{
			throw new BOException(MessageCodes.INVALID_DEAL_NUMBER);
		}
		if(StringUtil.isEmptyString(investmentDealSC.getUtilizaionStatus()))
		{
			throw new BOException(MessageCodes.INVALID_MISSING_INFORMATION);
		}

		TRSDEAL2VO trsDeal2VO = new TRSDEAL2VO();
		trsDeal2VO.setCOMP_CODE(investmentDealSC.getCompCode());
		trsDeal2VO.setBRANCH_CODE(investmentDealSC.getBranchCode());
		trsDeal2VO.setSERIAL_NO(investmentDealSC.getDealNumber());
		trsDeal2VO.setUTILIZED_FROM_ASSET_DASH_BOARD(investmentDealSC.getUtilizaionStatus());
		return genericDAO.update(trsDeal2VO);
    }
    @Override
    public BigDecimal returnEarlySettlementReimbursmentAmount(IISCommonCO iisCommonCO) throws BaseException
    {
	BigDecimal nextInstalmmentAmount = NumberUtil
		.nullToZero(iisCommonDAO.returnNextLineInstallmentAmount(iisCommonCO));

	Date lastFullySettledDate = null;
	boolean lastlineSettled = false;
	Date settlementDate = iisCommonCO.getSettlementDate();
	TRSDEALVOKey trsdealvoKey = new TRSDEALVOKey();
	trsdealvoKey.setCOMP_CODE(iisCommonCO.getCompCode());
	trsdealvoKey.setBRANCH_CODE(iisCommonCO.getBranchCode());
	trsdealvoKey.setSERIAL_NO(iisCommonCO.getDealNo());

	TRSDEALVO trsdealvo = (TRSDEALVO) genericDAO.selectByPK(trsdealvoKey);
	if(trsdealvo == null)
	{
	    throw new BOException(MessageCodes.INVALID_DEAL_NO);
	}

	Date dealMaturityDate = trsdealvo.getMATURITY_DATE();
	BigDecimal remainingProfit = BigDecimal.ZERO;

	if(nextInstalmmentAmount.compareTo(BigDecimal.ZERO) != 0)
	{
	    lastFullySettledDate = DateUtil.nullToInitDate(iisCommonDAO.returnFullySettledInstallmentDate(iisCommonCO));

	    if(ConstantsCommon.YES.equals(iisCommonCO.getProfitUpfront())
		    && lastFullySettledDate.compareTo(dealMaturityDate) == 0)
	    {
		lastFullySettledDate = iisCommonDAO.returnPartialSettlementLastFullySettledInstallmentDate(iisCommonCO);

		if(lastFullySettledDate == null || lastFullySettledDate.compareTo(settlementDate) == -1)
		{
		    lastFullySettledDate = settlementDate;
		}
		lastlineSettled = true;
	    }

	    if(lastFullySettledDate.compareTo(settlementDate) == 1)
	    {
		settlementDate = lastFullySettledDate;
		iisCommonCO.setSettlementDate(settlementDate);
	    }
	}

	BigDecimal partialSettledLineNbr = NumberUtil
		.emptyDecimalToZero(iisCommonDAO.returnPartialSettledPlanLineNbr(iisCommonCO));

	BigDecimal returnPlanLastLineNbr = NumberUtil
		.emptyDecimalToZero(iisCommonDAO.returnPlanLastLineNbr(iisCommonCO));

	if(lastlineSettled || returnPlanLastLineNbr.compareTo(partialSettledLineNbr) == 0)
	{
	    partialSettledLineNbr = BigDecimal.ONE;
	}

	BigDecimal remainingProfifromPartiallyPlan = BigDecimal.ZERO;

	// Get Remaining Profit from TRSDEALDET
	remainingProfit = NumberUtil.emptyDecimalToZero(iisCommonDAO.returnRemainingProfitFromTrsdealdet(iisCommonCO));

	if(partialSettledLineNbr.compareTo(BigDecimal.ZERO) == 1)
	{
	    // Get Remaining Profit from TRSPAYPLANDET
	    iisCommonCO.setLineNo(partialSettledLineNbr);
	    remainingProfifromPartiallyPlan = NumberUtil
		    .emptyDecimalToZero(iisCommonDAO.returnRemainingProfitForPartialSettlted(iisCommonCO));

	    if(remainingProfifromPartiallyPlan.compareTo(remainingProfit) == -1)
	    {
		remainingProfit = remainingProfifromPartiallyPlan;
	    }
	}

	BigDecimal deffRemainingRevenue = BigDecimal.ZERO;

	BigDecimal totalProfit = remainingProfit.add(deffRemainingRevenue);

	// BigDecimal outstandingProfit = BigDecimal.ZERO;
	//
	// if(totalProfit.compareTo(outstandingProfit) == 1)
	// {
	// totalProfit = outstandingProfit;
	// }

	BigDecimal prftAmtPushdwnFrmAbvInst = BigDecimal.ZERO;

	BigDecimal reimbursementAmount = (totalProfit.subtract(prftAmtPushdwnFrmAbvInst));

	return reimbursementAmount;
    }
	
	
	
	public void validateActionDateWithPrevActionDate(Date trxDate, Date prevTrxDate, String trxMode,
			String VALD_ACT_WRT_PREV_ACT_DTE_YN) throws BaseException
	{
		trxDate = DateUtil.removeTimeFromDate(trxDate);
		prevTrxDate = DateUtil.removeTimeFromDate(prevTrxDate);
		if(VALD_ACT_WRT_PREV_ACT_DTE_YN == null || ConstantsCommon.NO.equals(VALD_ACT_WRT_PREV_ACT_DTE_YN))
		{
		    return;
		}
		if(DateUtil.nullToInitDate(prevTrxDate).equals(DateUtil.nullToInitDate(null))
			|| DateUtil.nullToInitDate(trxDate).equals(DateUtil.nullToInitDate(null)))
		{
		    return;
		}
		if(trxDate.after(prevTrxDate) || trxDate.equals(prevTrxDate))
		{
		    return;
		}
		if(IISCommonConstants.TRX_MODE_DELETE.equals(trxMode) || IISCommonConstants.TRX_MODE_VERIFY.equals(trxMode)
			|| IISCommonConstants.TRX_MODE_REJECT.equals(trxMode)
			|| IISCommonConstants.TRX_MODE_APPROVE.equals(trxMode))
		{
		    throw new BOException(SYSTEM_DATE_IS_LESS_THAN_THE_TRANSACTION_CREATION_VERIFICATION_DATE);
		
		}
		if(IISCommonConstants.TRX_MODE_REVERSE.equals(trxMode)
			|| IISCommonConstants.TRX_MODE_UPDATE_AFTER_APPROVE.equals(trxMode))
		{
		    throw new BOException(SYSTEM_DATE_IS_LESS_THAN_THE_TRANSACTION_APPROVAL_DATE);
		
		}
	}
	
	public void checkTotalYieldWithTieRate(BigDecimal compCode, BigDecimal branchCode, BigDecimal productClass,
		    BigDecimal totalYield, BigDecimal minYieldPrm, Date valueDate, Object returnObject) throws BaseException
	    {

		TRSCLASSVOKey trsClassVOKey = new TRSCLASSVOKey();
		trsClassVOKey.setCOMP_CODE(compCode);
		trsClassVOKey.setCODE(productClass);
		TRSCLASSVO trsClassVO = iisCommonDAO.getGracePeriodClass(trsClassVOKey);
		if(trsClassVO != null && "Y".equals(StringUtil.nullToEmpty(trsClassVO.getAPPLY_TEG_YN())))
		{
		    IISCommonCO iisCommonCO = new IISCommonCO();
		    iisCommonCO.setCompCode(compCode);
		    iisCommonCO.setBranchCode(branchCode);
		    iisCommonCO.setProductClass(productClass);
		    iisCommonCO.setValueDate(valueDate);
		    BigDecimal tieRate = iisCommonDAO.returnApplicableTieRate(iisCommonCO);
		    if(tieRate == null)
		    {
			throw new BOException(MessageCodes.iis_invalid_code, new String[] { "tie_Rate_not_defined_key" });
		    }

		    if(tieRate.compareTo(totalYield) == -1)
		    {
			throw new BOException(MessageCodes.iis_invalid_code,
				new String[] { "total_yield_is_grater_than_applicable_tie_continue", ", TIE%:-",
					tieRate.toString() },
				ConstantsCommon.CONFIRM_MSG_TYPE, "CHECK_BLACK_LISTED_CIF", returnObject);
		    }
		    BigDecimal minYield = minYieldPrm;
		    if(NumberUtil.nullToZero(minYield).compareTo(BigDecimal.ZERO) != 1)
		    {
			minYield = NumberUtil.emptyDecimalToZero(iisCommonDAO.returnApplicableTieRateMinYield(iisCommonCO));
		    }
		    if(totalYield.compareTo(minYield) == -1)
		    {
			String sminYield = "(" + NumberUtil.format(minYield, "##.000") + "%)";
			throw new BOException(MessageCodes.iis_invalid_code,
				new String[] { "yield_cannot_be_less_than_minimum_yield_key", sminYield }, true);
		    }
		}
		else
		{
		    return;
		}
	    }

	@Override
	public IISCommonCO returnFirstPaymentDateByCutoffDay(IISCommonCO commonCO)throws BaseException {
		TRSCLASS_EXTENDEDVO trsClassExtendedvo = returnTRSCLASSExtendedDetail(commonCO.getCompCode(), commonCO.getProductClass());
		if(trsClassExtendedvo != null && NumberUtil.nullToZero(trsClassExtendedvo.getFIRST_PAYMENT_DAY()).compareTo(BigDecimal.ZERO) == 1 ){
			int dayOfValueDate = DateUtil.getDatePart("DD", commonCO.getValueDate()).intValue();
			int firstPaymentDays = trsClassExtendedvo.getFIRST_PAYMENT_DAY().intValue() ;
			int firstPaymentmonth;
			int firstPaymenyear = DateUtil.getDatePart("YY", commonCO.getValueDate()).intValue();
			
			if (dayOfValueDate > NumberUtil.nullToZero(trsClassExtendedvo.getCUTOFF_DAY_FOR_FIRST_PAYMT_DT()).longValue())
			{
				firstPaymentmonth = DateUtil.getDatePart("MM", commonCO.getValueDate()).intValue() + 1;
			}else{
				firstPaymentmonth = DateUtil.getDatePart("MM", commonCO.getValueDate()).intValue();
			}
			if(firstPaymentmonth > 12){
				firstPaymentmonth = 1;
				firstPaymenyear = firstPaymenyear + 1;
			}
			firstPaymentmonth = firstPaymentmonth - 1;
			Date firstPaymentDate = DateUtil.createDate(firstPaymenyear, firstPaymentmonth, 1);
			firstPaymentDate = DateUtil.getMonthLastDay(firstPaymentDate);
			if(firstPaymentDays > DateUtil.getDatePart("DD", firstPaymentDate).intValue()){
				firstPaymentDays = DateUtil.getDatePart("DD", firstPaymentDate).intValue();
			}
			firstPaymentDate = DateUtil.createDate(firstPaymenyear, firstPaymentmonth, firstPaymentDays);
			commonCO.setFirstPayDate(firstPaymentDate);
			commonCO.setGracePeriodicity("D");
			commonCO.setGracePeriod(BigDecimal.valueOf(DateUtil.numberOfDays(commonCO.getValueDate(), firstPaymentDate)));
		}
		return commonCO;
	} 

	private TRSCLASS_EXTENDEDVO returnTRSCLASSExtendedDetail(BigDecimal compCode, BigDecimal productClass) throws BaseException {
		TRSCLASS_EXTENDEDVOKey trsclassExtendedVOKey = new TRSCLASS_EXTENDEDVOKey();
		trsclassExtendedVOKey.setCOMP_CODE(compCode);
		trsclassExtendedVOKey.setCODE(productClass);

		return iisCommonDAO.returnTRSCLASSExtendedDetail(trsclassExtendedVOKey);
	}

	@Override
	public CifBlackListRestrictCO updateCifBlackListReson(CifBlackListRestrictCO cifBlackListRestrictCO)
			throws BaseException {
		/**
    	 * Added By Manoj On 01/02/2017 For - BMO160011
    	 */
		if("N".equals(cifBlackListRestrictCO.getModifiedYN()))
		{
			return cifBlackListRestrictCO;
		}
		Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getCOMP_CODE());
		Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getPARENT_REF());
		//Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getAPP_NAME());
		Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getENTITY_CODE());
		
		cifBlackListRestrictCO.getBlackListOverrideReasonVO().setAPP_NAME("IIS");
		
		if(NumberUtil.nullToZero(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getREASON_CODE()).compareTo(BigDecimal.ZERO) != 1){
			throw new BOException(MessageCodes.iis_invalid_code,
				    new String[] { "missing_invalid_reason_code_key" }, false);
		}
		//cifBlackListRestrictCO.getBlackListOverrideReasonVO().setDATE_UPDATED(cifBlackListRestrictCO.getRunningDate());
		//cifBlackListRestrictCO.getBlackListOverrideReasonVO().setUSER_ID(cifBlackListRestrictCO.getUserId());
		CifBlackListRestrictCO tempCifBlackListRestrictCO =  retrieveCifBlackListReson(cifBlackListRestrictCO);
		cifBlackListRestrictCO.getBlackListOverrideReasonVO().setDATE_UPDATED(commonLibBO.returnSystemDateWithTime());
		if(tempCifBlackListRestrictCO == null){
			//BigDecimal maxLineNbr= iisCommonDAO.returnBlackListOverrideReasonMaxLineNbr(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
			BigDecimal maxLineNbr= BigDecimal.ONE;
			maxLineNbr = NumberUtil.nullToZero(maxLineNbr).add(BigDecimal.ONE);
			cifBlackListRestrictCO.getBlackListOverrideReasonVO().setLINE_NO(maxLineNbr);
			genericDAO.insert(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
		}else{
			cifBlackListRestrictCO.getBlackListOverrideReasonVO().setLINE_NO(tempCifBlackListRestrictCO.getBlackListOverrideReasonVO().getLINE_NO());
			//genericDAO.update(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
			iisCommonDAO.updatecifBlackListRestrict(cifBlackListRestrictCO.getBlackListOverrideReasonVO()); 
		}
		
//		if("Y".equals(cifBlackListRestrictCO.getNewRecordYN() )){
//			BigDecimal maxLineNbr= iisCommonDAO.returnBlackListOverrideReasonMaxLineNbr(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
//			cifBlackListRestrictCO.getBlackListOverrideReasonVO().setLINE_NO(maxLineNbr);
//			genericDAO.insert(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
//		}else{
//			cifBlackListRestrictCO.getBlackListOverrideReasonVO().setDATE_UPDATED(cifBlackListRestrictCO.getRunningDate());
//			cifBlackListRestrictCO.getBlackListOverrideReasonVO().setUSER_ID(cifBlackListRestrictCO.getUserId());
//			int update = genericDAO.update(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
//			if (update <= 0){
//				BigDecimal maxLineNbr= iisCommonDAO.returnBlackListOverrideReasonMaxLineNbr(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
//				cifBlackListRestrictCO.getBlackListOverrideReasonVO().setLINE_NO(maxLineNbr);
//				genericDAO.insert(cifBlackListRestrictCO.getBlackListOverrideReasonVO());
//			}
//			
//		}
		
		
		return cifBlackListRestrictCO;
	}

	@Override
	public CifBlackListRestrictCO retrieveCifBlackListReson(CifBlackListRestrictCO cifBlackListRestrictCO)
			throws BaseException {
		/**
    	 * Added By Manoj On 01/02/2017 For - BMO160011
    	 */
		Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getCOMP_CODE());
		Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getPARENT_REF());
		Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getAPP_NAME());
		Assert.notNull(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getENTITY_CODE());
		
		return iisCommonDAO.returnBlackListOverrideReasonDet(cifBlackListRestrictCO);
	}

	@Override
	public IISCommonCO validateCifBlacklistedRestrictionBypass(IISCommonCO iisCommonCO) throws BaseException {
		/**
    	 * Added By Manoj On 01/02/2017 For - BMO160011
    	 */
		final String MSG_CONFIRM = "C";
		final String MSG_INFORM = "I";
		
		IISCommonCO cifStatusObj = iisCommonDAO.getCifStatus(iisCommonCO);// Getting
		
		if(cifStatusObj == null ){
			throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
		}
		
		if( NumberUtil.nullToZero(cifStatusObj.getBlackListed()).intValue() != 1)
		{
			return iisCommonCO;
		}
		
		Assert.notNull(iisCommonCO.getCompCode(), "Invalid Company code, validateCifBlacklistedRestrictionBypass");
		Assert.notNull(iisCommonCO.getBranchCode(), "Invalid Branch Code, validateCifBlacklistedRestrictionBypass");
		Assert.notNull(iisCommonCO.getProgRef(), "Invalid prog ref, validateCifBlacklistedRestrictionBypass");
		Assert.notNull(iisCommonCO.getAppName(), "Invalid app name, validateCifBlacklistedRestrictionBypass");
		//Assert.notNull(iisCommonCO.getTrxNbr(), "Invalid trx nbr, validateCifBlacklistedRestrictionBypass");
		Assert.notNull(iisCommonCO.getCifNo(), "Invalid cif no, validateCifBlacklistedRestrictionBypass");
		Assert.notNull(iisCommonCO.getRunningDate(), "Invalid running date, validateCifBlacklistedRestrictionBypass");
		Assert.notNull(iisCommonCO.getUserId(), "Invalid User ID, validateCifBlacklistedRestrictionBypass");
		
		iisCommonCO.setRestrictionFactor("IT");
		iisCommonCO = iisCommonDAO.execP_RET_CHECK_BLACKLIST_RESTRICT(iisCommonCO);
		if(iisCommonCO != null)
		{
			if(NumberUtil.nullToZero(iisCommonCO.getErrorCode()).compareTo(BigDecimal.ZERO) == -1) {
				throw new BOException(MessageCodes.iis_invalid_code,
					    new String[] { "Error While executing P_RET_CHECK_BLACKLIST_RESTRICT" }, false);
			}
			
			if(NumberUtil.nullToZero(iisCommonCO.getReturnCode()).compareTo(BigDecimal.ZERO) == 0)
			{
				return iisCommonCO;
			}
			String messageType = MSG_CONFIRM;
			if(NumberUtil.nullToZero(iisCommonCO.getTrxNbr()).compareTo(BigDecimal.ZERO) == 1)
			{
				CifBlackListRestrictCO cifBlackListRestrictCO = new CifBlackListRestrictCO();
				cifBlackListRestrictCO.setBlackListOverrideReasonVO(new BLACKLIST_OVERRIDE_REASONVO());
				
				cifBlackListRestrictCO.getBlackListOverrideReasonVO().setCOMP_CODE(iisCommonCO.getCompCode());
				cifBlackListRestrictCO.getBlackListOverrideReasonVO().setBRANCH_CODE(iisCommonCO.getBranchCode());
				cifBlackListRestrictCO.getBlackListOverrideReasonVO().setAPP_NAME(iisCommonCO.getAppName());
				cifBlackListRestrictCO.getBlackListOverrideReasonVO().setPARENT_REF(iisCommonCO.getProgRef());
				cifBlackListRestrictCO.getBlackListOverrideReasonVO().setENTITY_CODE(iisCommonCO.getTrxNbr().toString());
				
				cifBlackListRestrictCO = iisCommonDAO.returnBlackListOverrideReasonDet(cifBlackListRestrictCO);
				if (cifBlackListRestrictCO != null && NumberUtil.nullToZero(iisCommonCO.getPaymPeriodNbr()).compareTo(BigDecimal.ZERO) ==1)
				{
					Date newDate = null;
					
					if(iisCommonCO.getPaymPeriodicity() == null){
						throw new BOException(MessageCodes.iis_invalid_code,
							    new String[] { "invalid Threshold Periodicity" }, false);
					}
					
					if(iisCommonCO.getPaymPeriodicity().equals("D")){
						newDate = DateUtil.relativeDate(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getCREATED_DATE(), iisCommonCO.getPaymPeriodNbr().intValue());
					}else{
						if (iisCommonCO.getPaymPeriodicity().equals("M"))
						{
							newDate = DateUtil.relativeMonth(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getCREATED_DATE(), iisCommonCO.getPaymPeriodNbr().intValue());
						}else{
							if(iisCommonCO.getPaymPeriodicity().equals("Y"))
							{
								newDate = DateUtil.relativeMonth(cifBlackListRestrictCO.getBlackListOverrideReasonVO().getCREATED_DATE(), (iisCommonCO.getPaymPeriodNbr().intValue()*12));
							}else{
								throw new BOException(MessageCodes.iis_invalid_code,
									    new String[] { "invalid Threshold Periodicity" }, false);
							}
						}
					}
					if(newDate != null)
					{
						if(iisCommonCO.getRunningDate().after(newDate)){
							messageType = MSG_CONFIRM;
							 
						}else{
							messageType = MSG_INFORM;
							
						}
					}
				}else{
					messageType = MSG_CONFIRM;
				}
			}
			if(messageType.equals(MSG_CONFIRM)){
				if(NumberUtil.nullToZero(iisCommonCO.getReturnCode()).compareTo(BigDecimal.ONE) == 0){
					throw new BOException(MessageCodes.iis_invalid_code,
						    new String[] { iisCommonCO.getErrorMessage() }, false);
				}else{
					throw new BOException(MessageCodes.iis_invalid_code,
						    new String[] { iisCommonCO.getErrorMessage() }, true, ConstantsCommon.CONFIRM_MSG_TYPE,
						    IISCommonConstants.CIF_BLACK_LIST_RESTRICTION_BYPASS_CONFIRMATION);
				}
				
			}else{
				iisCommonCO.setBlackListLongNameEng(iisCommonCO.getErrorMessage2());
			}
		}
		
//		 throw new BOException(IISMessageCodes.CIF_BLACK_LIST_RESTRICTION_BYPASS_CONFIRMATION,
//				    new String[] { "Restriction brief description",iisCommonCO.getCifNo().toString(),"Source Code" }, ConstantsCommon.CONFIRM_MSG_TYPE,
//				    IISCommonConstants.CIF_BLACK_LIST_RESTRICTION_BYPASS_CONFIRMATION);
		 
//		iisCommonCO.setBlackListLongNameEng("Black cc listed");
		return iisCommonCO;
	}	
	
	@Override
	public String returnVatDeductionMethodOnCharge(BigDecimal compCode, BigDecimal charge_CODE) throws BaseException 
	{
		TRSCHARGESVOKey trschargesvoKey = new TRSCHARGESVOKey();
		trschargesvoKey.setCOMP_CODE(compCode);
		trschargesvoKey.setCODE(charge_CODE);
		return iisCommonDAO.returnVatDeductionMethodOnCharge(trschargesvoKey);
	}

	@Override
	public IISCommonCO returnCommonVatDetails(IISCommonCO iisCommonCO) throws BaseException 
	{
		return iisCommonDAO.returnCommonVatDetails(iisCommonCO);
	}

	@Override
	public String returnvatPercInd(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo) throws BaseException 
	{
		IISCommonCO iisCommonCO = new  IISCommonCO();
		iisCommonCO.setCompCode(compCode);
		iisCommonCO.setBranchCode(branchCode);
		iisCommonCO.setDealNo(dealNo);
		return iisCommonDAO.returnvatPercInd(iisCommonCO);
	}

	@Override
	public BigDecimal returnVatCodeChargesIncludeInst(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo)
			throws BaseException 
	{
		IISCommonCO iisCommonCO = new  IISCommonCO();
		iisCommonCO.setCompCode(compCode);
		iisCommonCO.setBranchCode(branchCode);
		iisCommonCO.setDealNo(dealNo);
		return iisCommonDAO.returnVatCodeChargesIncludeInst(iisCommonCO);
	}

	@Override
	public BigDecimal returnVatCountOtherCharge(BigDecimal compCode, BigDecimal branchCode, BigDecimal dealNo, BigDecimal vatCode)
			throws BaseException 
	{
		IISCommonCO iisCommonCO = new  IISCommonCO();
		iisCommonCO.setCompCode(compCode);
		iisCommonCO.setBranchCode(branchCode);
		iisCommonCO.setDealNo(dealNo);

		return iisCommonDAO.returnVatCountOtherCharge(iisCommonCO);
	}	
	
	public TRSDEALCHARGESVO calculateChargeOnYearlyoutstandingCapital(BigDecimal compCode, BigDecimal branchCode,
		    BigDecimal dealNo, Date startDate, BigDecimal chargeCode, BigDecimal chargePercentage, String callType,
		    BigDecimal baseCurrency, BigDecimal chargeCurrency, Date runningDate, BigDecimal planNo, BigDecimal planSeq)
		    throws BaseException
	{
		TRSDEALCHARGESVO trsdealchargesvo = new TRSDEALCHARGESVO();
		IISCommonCO iisCommonParamCO = new IISCommonCO();
		iisCommonParamCO.setCompCode(compCode);
		iisCommonParamCO.setBranchCode(branchCode);
		iisCommonParamCO.setDealNo(dealNo);
		if(NumberUtil.isEmptyDecimal(planNo) && NumberUtil.isEmptyDecimal(planSeq))
		{
			TRSPAYPLANVO trspayplanvo = iisCommonDAO.returnTrsPayPlanDetails(iisCommonParamCO);
			if(trspayplanvo != null)
			{

				iisCommonParamCO.setPlanNbr(trspayplanvo.getPLAN_NBR());
				iisCommonParamCO.setPlanSeq(trspayplanvo.getPLAN_SEQ());
			}
		}
		else
		{
			iisCommonParamCO.setPlanNbr(planNo);
			iisCommonParamCO.setPlanSeq(planSeq);
		}
		List<TRSPAYPLANDETVO> trspayplandetVOList = new ArrayList<TRSPAYPLANDETVO>();

		if("F".equals(callType))// TP 1039534 CDMI200002 ; Jinson;
			// 18/07/2020
		{
			trspayplandetVOList = iisCommonDAO.returnFmsPayPlanDetDetails(iisCommonParamCO);

		}
		else
		{
			trspayplandetVOList = iisCommonDAO.returnTrsPayPlanDetDetails(iisCommonParamCO);
		}
		if(trspayplandetVOList == null || trspayplandetVOList.isEmpty())
		{
			return trsdealchargesvo;
		}
		String CALC_ON_YERLY_OUTSTND_PRINC_YN = ConstantsCommon.NO;
		String insuranceYn = ConstantsCommon.NO;

		TRSCHARGESVOKey trschargesVoKey = new TRSCHARGESVOKey();
		trschargesVoKey.setCOMP_CODE(compCode);
		trschargesVoKey.setCODE(chargeCode);
		TRSCHARGESVO trschargesvo = (TRSCHARGESVO) genericDAO.selectByPK(trschargesVoKey);
		if(trschargesvo != null)
		{
			CALC_ON_YERLY_OUTSTND_PRINC_YN = trschargesvo.getCALC_ON_YERLY_OUTSTND_PRINC_YN();
			insuranceYn = trschargesvo.getINSURANCE();
		}
		TRSDEALVO trsdealvo = new TRSDEALVO();
		FMSAPPLVO fmsApplVO = new FMSAPPLVO();
		if("F".equals(callType))// TP 1039534 CDMI200002 ; Jinson;
			// 18/07/2020
		{
			FMSAPPLVOKey fmsApplVOkey = new FMSAPPLVOKey();
			fmsApplVOkey.setCOMP_CODE(compCode);
			fmsApplVOkey.setBRANCH(branchCode);
			fmsApplVOkey.setCODE(planNo);
			fmsApplVO = (FMSAPPLVO) genericDAO.selectByPK(fmsApplVOkey);
		}
		BigDecimal dealAmount = BigDecimal.ZERO;
		Date dealValueDate = null;

		if(NumberUtil.nullToZero(dealNo).compareTo(BigDecimal.ZERO) > 0)
		{

			trsdealvo.setCOMP_CODE(compCode);
			trsdealvo.setBRANCH_CODE(branchCode);
			trsdealvo.setSERIAL_NO(dealNo);
			trsdealvo = (TRSDEALVO) genericDAO.selectByPK(trsdealvo);
			if(trsdealvo == null)
			{
				throw new BOException(MessageCodes.INVALID_DEAL_NO);
			}
		}
		CURRENCIESVO currenciesvo = new CURRENCIESVO();
		currenciesvo.setCOMP_CODE(compCode);
		if("F".equals(callType))// TP 1039534 CDMI200002 ; Jinson;
			// 18/07/2020
		{
			currenciesvo.setCURRENCY_CODE(fmsApplVO.getCURRENCY());
		}
		else
		{
			currenciesvo.setCURRENCY_CODE(trsdealvo.getDEAL_CY());
		}
		currenciesvo = (CURRENCIESVO) genericDAO.selectByPK(currenciesvo);
		if(currenciesvo == null)
		{
			throw new BOException(MessageCodes.INVALID_MISSING_DEAL_CURRENCY);
		}
		Integer currencyDecPoint = NumberUtil.emptyDecimalToZero(currenciesvo.getDECIMAL_POINTS()).intValue();
		if("R".equals(callType))// Repayment plan
		{
			dealAmount = trsdealvo.getDEAL_AMOUNT();
			dealValueDate = trsdealvo.getVALUE_DATE();
			startDate = trsdealvo.getVALUE_DATE();
		}
		else if("F".equals(callType)) // TP 1039534 CDMI200002 ; Jinson;
			// 18/07/2020 Start[]
		{

			FMSAPPLIMITDETVO fmsAppLimitDetVO = new FMSAPPLIMITDETVO();
			fmsAppLimitDetVO.setCODE(planNo);
			fmsAppLimitDetVO.setCOMP_CODE(compCode);
			fmsAppLimitDetVO.setBRANCH(branchCode);
			fmsAppLimitDetVO.setLINE_NBR(planSeq);
			fmsAppLimitDetVO.setAPP_TYPE("F");
			fmsAppLimitDetVO = (FMSAPPLIMITDETVO) genericDAO.selectByPK(fmsAppLimitDetVO);
			if(fmsAppLimitDetVO != null)
			{
				dealAmount = fmsAppLimitDetVO.getFACILITY_VALUE();
				dealValueDate = fmsAppLimitDetVO.getVALUE_DATE();
				startDate = fmsAppLimitDetVO.getVALUE_DATE();
			}

		}// TP 1039534 CDMI200002 ; Jinson;
		// 18/07/2020 End[]
		else
		{
			if(NumberUtil.emptyDecimalToZero(chargePercentage).compareTo(BigDecimal.ZERO) == 0)
			{
				throw new BaseException("Charge percentage cannot be null");
			}
		}

		if("Y".equals(CALC_ON_YERLY_OUTSTND_PRINC_YN))
		{
			BigDecimal outstandingCapital = dealAmount;
			Date outstandingStartDate = startDate;
			Date outstandingEndDate = DateUtil.relativeMonth(outstandingStartDate, 12);
			Date fromDate = dealValueDate;
			Date toDate;
			BigDecimal cumCapitalAmount = BigDecimal.ZERO;
			BigDecimal totalChargeAmount = BigDecimal.ZERO;
			boolean yearChange = false;

			BigDecimal noOfDays = BigDecimal.ZERO;
			if(chargePercentage.compareTo(BigDecimal.ZERO) == 1)
			{
				for(TRSPAYPLANDETVO trspayplandetCO : trspayplandetVOList)
				{
					long totalNoOfDaysInYear = DateUtil.numberOfDays(outstandingStartDate, outstandingEndDate);
					toDate = trspayplandetCO.getVALUE_DATE();
					BigDecimal chargeAmount = BigDecimal.ZERO;
					cumCapitalAmount = cumCapitalAmount.add(NumberUtil.nullToZero(trspayplandetCO.getCAPITAL_AMT())
							.subtract(NumberUtil.nullToZero(trspayplandetCO.getCHARGE_AMOUNT())
									.add(NumberUtil.nullToZero(trspayplandetCO.getINSURANCE_AMOUNT()))));
					yearChange = false;

					if(!trspayplandetCO.getVALUE_DATE().before(outstandingStartDate)
							&& !trspayplandetCO.getVALUE_DATE().after(outstandingEndDate))
					{
						noOfDays = BigDecimal.valueOf(DateUtil.numberOfDays(fromDate, toDate));
						if(noOfDays.compareTo(BigDecimal.ZERO) == -1)
						{
							noOfDays = BigDecimal.ZERO;
						}

						chargeAmount = outstandingCapital.multiply(chargePercentage).divide(BigDecimal.valueOf(100), 12,
								BigDecimal.ROUND_HALF_UP);
						chargeAmount = chargeAmount
								.divide(BigDecimal.valueOf(totalNoOfDaysInYear), 12, BigDecimal.ROUND_HALF_UP)
								.multiply(noOfDays);
					}
					else if(trspayplandetCO.getVALUE_DATE().after(outstandingEndDate)
							&& fromDate.before(outstandingEndDate))
					{
						noOfDays = BigDecimal.valueOf(DateUtil.numberOfDays(fromDate, outstandingEndDate));
						if(noOfDays.compareTo(BigDecimal.ZERO) == -1)
						{
							noOfDays = BigDecimal.ZERO;
						}
						chargeAmount = outstandingCapital.multiply(chargePercentage).divide(BigDecimal.valueOf(100), 12,
								BigDecimal.ROUND_HALF_UP);
						chargeAmount = chargeAmount
								.divide(BigDecimal.valueOf(totalNoOfDaysInYear), 12, BigDecimal.ROUND_HALF_UP)
								.multiply(noOfDays);

						noOfDays = BigDecimal.valueOf(DateUtil.numberOfDays(outstandingEndDate, toDate));
						if(noOfDays.compareTo(BigDecimal.ZERO) == -1)
						{
							noOfDays = BigDecimal.ZERO;
						}

						outstandingCapital = outstandingCapital.subtract(cumCapitalAmount);

						BigDecimal chargeAmount1 = outstandingCapital.multiply(chargePercentage)
								.divide(BigDecimal.valueOf(100), 12, BigDecimal.ROUND_HALF_UP);
						chargeAmount1 = chargeAmount1
								.divide(BigDecimal.valueOf(totalNoOfDaysInYear), 12, BigDecimal.ROUND_HALF_UP)
								.multiply(noOfDays);
						chargeAmount = chargeAmount.add(chargeAmount1);
						cumCapitalAmount = BigDecimal.ZERO;
						yearChange = true;
					}
					chargeAmount = NumberUtil.roundToBigDecimal(chargeAmount, currencyDecPoint);

					if(!trspayplandetCO.getVALUE_DATE().before(outstandingEndDate))
					{
						outstandingCapital = outstandingCapital.subtract(cumCapitalAmount);
						cumCapitalAmount = BigDecimal.ZERO;
						yearChange = true;
					}

					if(yearChange)
					{
						outstandingStartDate = outstandingEndDate;
						outstandingEndDate = DateUtil.relativeMonth(outstandingStartDate, 12);
					}
					System.out.println(chargeAmount);
					totalChargeAmount = totalChargeAmount.add(chargeAmount);
					fromDate = toDate;
				}
				// totalChargeAmount
				// calulate totalChargeAmountCV -- base cy
				// calulate totalChargeAmountFC -- charge cy
				IISCommonCO iisCommonCO = new IISCommonCO();
				iisCommonCO.setCompCode(compCode);
				iisCommonCO.setBaseCurrencyCode(baseCurrency);
				iisCommonCO.setBranchCode(branchCode);
				if("F".equals(callType)) // TP 1039534 CDMI200002 ; Jinson;
					// 18/07/2020
				{
					iisCommonCO.setCifNo(fmsApplVO.getCIF());
				}
				else
				{
					iisCommonCO.setCifNo(trsdealvo.getCIF_NO());
				}
				iisCommonCO.setTrCurrency(chargeCurrency);// Transaction
				// currency
				iisCommonCO.setPfCurrency(baseCurrency);// Base
				// currency
				iisCommonCO.setCrossDate(runningDate);
				iisCommonCO = returnCrossRate(iisCommonCO);

				trsdealchargesvo.setCHARGES_AMOUNT(totalChargeAmount);
				trsdealchargesvo.setCHARGES_AMT_CV(totalChargeAmount.multiply(iisCommonCO.getCrossRate()));
				trsdealchargesvo.setCHARGES_AMT_FC(totalChargeAmount.multiply(iisCommonCO.getCrossRate()));
				trsdealchargesvo.setEXCH_RATE(iisCommonCO.getCrossRate());
			}
		}
		return trsdealchargesvo;
	}

}