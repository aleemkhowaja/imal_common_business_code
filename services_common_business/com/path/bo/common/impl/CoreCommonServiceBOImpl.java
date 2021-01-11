package com.path.bo.common.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.Assert;

import com.path.bo.admin.countries.CountriesBO;
import com.path.bo.admin.countriesregion.CountriesRegionBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.address.AddressCommonBO;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.safe.SafeAccLockBO;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.cifuseracces.CifUserAccessBO;
import com.path.bo.core.cities.CitiesBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.currency.CurrencyBO;
import com.path.bo.core.mosblacklist.MosBlackListBO;
import com.path.bo.core.postalcode.PostalCodeBO;
import com.path.bo.core.sectors.SectorsBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.core.bo.blacklistmanagement.BlackListBO;
import com.path.core.bo.blacklistmanagement.BlackListConstant;
import com.path.dao.common.CoreCommonServiceDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFCOUNTERVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CIF_RESERVEDVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAMVO;
import com.path.dbmaps.vo.CIF_TYPE_PARAM_DETVOKey;
import com.path.dbmaps.vo.CITIESVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.COUNTRIES_REGIONVO;
import com.path.dbmaps.vo.COUNTRIES_TEL_FORMATVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.dbmaps.vo.CTSTRS_CONF_MSGVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTS_BLCKLIST_NAME_MATCHVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.ID_CHECK_DIGITVO;
import com.path.dbmaps.vo.ID_CHECK_DIGIT_ALLOWEDVO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.dbmaps.vo.REMITTANCEVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.RIFPCTVO;
import com.path.dbmaps.vo.SECTORSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_ADDREF_MASK_SPECIFICVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.countries.CountriesCO;
import com.path.vo.admin.countries.CountriesSC;
import com.path.vo.admin.countriesregion.CountriesRegionSC;
import com.path.vo.common.AmountCO;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.blacklistmanagement.CifBlckLstVO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.common.safe.SyncAccLockUnlockCO;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.blacklistmanagement.BlackListCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ciftype.CifTypeSC;
import com.path.vo.core.cifuseraccess.CifUserAccessSC;
import com.path.vo.core.cities.CitiesSC;
import com.path.vo.core.common.NCifMaintenanceSC;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomSC;
import com.path.vo.core.csmfom.ResultCO;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.idtype.IdTypeSC;
import com.path.vo.core.postalcode.PostalCodeSC;
import com.path.vo.core.sectors.SectorsSC;
import com.path.vo.core.trxmgnt.AccountPositionCO;
import com.path.vo.core.trxmgnt.CtstrsConfMsgSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public class CoreCommonServiceBOImpl extends RetailBaseBO implements CoreCommonServiceBO
{
    private CoreCommonServiceDAO coreCommonServiceDAO;
    private SafeAccLockBO safeAccLockBO;
    private CifUserAccessBO cifUserAccessBO;
    private PostalCodeBO postalCodeBO;
    private CountriesBO countriesBO;
    private CountriesRegionBO countriesRegionBO;
    private CitiesBO citiesBO;
    private SectorsBO sectorsBO;
    private AlertsBO alertsBO;
    private CifBO cifBO;
    private MosBlackListBO mosBlackListBO;
    private BlackListBO blackListBO;
    private CurrencyBO currencyBO;
    private AccountBO accountBO;
    
    //EWBI160173  -- [falha]
    private AddressCommonBO addressBO;

    public COUNTRIES_TEL_FORMATVO returnCountriesTelFormat(COUNTRIES_TEL_FORMATVO cntryTelFrmatVO) throws BaseException
    {
	return coreCommonServiceDAO.returnCountriesTelFormat(cntryTelFrmatVO);
    }

    public CifBO getCifBO() {
		return cifBO;
	}

	public void setCifBO(CifBO cifBO) {
		this.cifBO = cifBO;
	}

    /**
     * @Desc append the extension of the country in telephon number, regarding
     *       if there exists some un-alphabetics characters
     *       (parenthesis,dash,...)
     * e.g : originalFormat = +(###)-###-##### ; extension = 9621
     * 		return : +(962)-1##-#####
     * @param originalFormat as is in DB
     * @param extension the extension that should be appended
     */
	public String replaceCountryExtension(String originalFormat, String extension) {
		Pattern p = Pattern.compile(ConstantsCommon.PHONE_REGEX, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(originalFormat);

		// if no extension is defined we should return the originalFormat (trivial condition)
		if ("".equals(extension)) {
			return originalFormat;
		} else if (m.find()) {
			// if we find a special characters we should exclude them
			int position = m.start();

			String tempExtension = "", tempFormat = "";
			String recursiveExtension = "", recusrsiveFormat = "";

			if (position < extension.length()) {
				tempExtension = extension.substring(0, position);
				recursiveExtension = extension.substring(position);
				recusrsiveFormat = originalFormat.substring(position);
			} else {
				// if the extension fit in the format, no more need to substring it
				recusrsiveFormat = originalFormat.substring(extension.length());
				tempExtension = extension;
			}

			// if the regEx was at the top of the string
			if (position == 0) {
				tempFormat = originalFormat.substring(0, 1);
				recusrsiveFormat = originalFormat.substring(1);
			}

			return tempExtension + tempFormat + replaceCountryExtension(recusrsiveFormat, recursiveExtension);
		} else {
			return "";
		}
	}

    /**
     * f_set_teller_mask chady - TAR BB120337
     * 
     * @param cardNum
     * @return
     */
    public String returnMaskedCardNo(CardsManagementCO cardsManagementCO) throws BaseException
    {
	if(!StringUtil.isNotEmpty(cardsManagementCO.getCardsMgtVO().getCARD_NO()))
	{
	    return null;
	}
	return commonLibBO.returnMaskedCardNo(cardsManagementCO);
    }

    /**
     * US 154817 SAFE account locking
     * 
     * @param in trxMgntCO
     * @param lockId return the lock id in case of lock (this number is used in
     *            inlock process)
     * @throws BaseException
     * @author tonynouh
     */
    public TrxMgntSC lockSafeAccounts(TrxMgntCO trxMgntCO) throws BaseException
    {
	BigDecimal safeApp = commonLibBO.returnPthCtrl().getSAFE_APP();
	if(NumberUtil.nullToZero(safeApp).compareTo(BigDecimal.ZERO) == 0)
	{
	    return new TrxMgntSC();
	}

	StringBuffer warningMessages = new StringBuffer(StringUtil.nullToEmpty(trxMgntCO.getWarningMsg()));
	// Initialize the CtstrxtypeVO if its not yet initialized
	if(trxMgntCO.getCtstrxtypeVO() == null || trxMgntCO.getCtstrxtypeVO().getCODE() == null
		|| NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrxtypeVO().getCODE()))
	{
	    returnCommonVariables(trxMgntCO);
	}
	TrxMgntSC trxMgntSC = new TrxMgntSC();
	PathPropertyUtil.copyProperties(trxMgntCO, trxMgntSC, "loginCompCode compCode", "loginBraCode branchCode",
		"ctstrsVO.TRS_NO trsNo", "loginTellerCode tellerCode", "crud ivCrud", "ctstrsVO.TRS_AC_BR trsAcBr",
		"ctstrsVO.TRS_AC_CY trsAcCy", "ctstrsVO.TRS_AC_GL trsAcGl", "ctstrsVO.TRS_AC_CIF trsAcCif",
		"ctstrsVO.TRS_AC_SL trsAcSl", "ctstrsVO.TO_TRS_AC_BR toTrsAcBr", "ctstrsVO.TO_TRS_AC_CY toTrsAcCy",
		"ctstrsVO.TO_TRS_AC_GL toTrsAcGl", "ctstrsVO.TO_TRS_AC_CIF toTrsAcCif",
		"ctstrsVO.TO_TRS_AC_SL toTrsAcSl", "overDrawnVoid overDrawnVoid", "ctstrxtypeVO.TYPE type",
		"ctstrxtypeVO.CR_DR_FOREX crDrForex", "ctstrxtypeVO.MULTI_TRX multiTrx",
		"ctstrxtypeVO.CHQ_RELATED chqRelated", "ctstrxtypeVO.CHECK_DATA_SYS2 checkDataSys2",
		"ctstrxtypeVO.OVERRIDE_USR_LEVEL overrideUsrLevel", "ctsTellerVO.PRIVILEGE_LEVEL userLevel");

	NumberUtil.resetEmptyValues(trxMgntSC);

	trxMgntSC.setLockUnlockAccountsFlag(TrxMgntConstant.LOCK_ACCOUNTS);
	trxMgntSC.setFromJava("true");
	// trxMgntSC.setFromAccGmiFlag("");
	// trxMgntSC.setFromAccSign("");
	// trxMgntSC.setToAccGmiFlag("");
	// trxMgntSC.setToAccSign("");

	trxMgntSC.setSafeApp(safeApp);

	// from java the calling of the below procedure is needed only to
	// insert into SYNC_LOCKUNLOCK_ACC and return the lockId and
	// accForLockExists (true in case there is accounts to be locked)
	coreCommonProcedureBO.lockUnlockSafeAccounts_NewTrans(trxMgntSC);
	if(TrxMgntConstant.ERROR.equals(trxMgntSC.getErrType())
		|| NumberUtil.nullToZero(trxMgntSC.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(trxMgntSC.getErrorMessage());
	}
	if(TrxMgntConstant.WARNING.equals(trxMgntSC.getErrType())
		|| NumberUtil.nullToZero(trxMgntSC.getErrorCode()).compareTo(BigDecimal.ZERO) > 0)
	{
	    warningMessages.append(trxMgntSC.getErrorMessage() + ConstantsCommon.NEW_LINE);
	}

	if("true".equals(trxMgntSC.getAccForLockExists()))
	{
	    String account = trxMgntSC.getTotalAccount();
	    SyncAccLockUnlockCO syncAccLockUnlockCO = new SyncAccLockUnlockCO();
	    syncAccLockUnlockCO.setLoggedCompany(trxMgntCO.getLoginCompCode());
	    syncAccLockUnlockCO.setLoggedBranch(trxMgntCO.getLoginBraCode());
	    syncAccLockUnlockCO.setLoggedUser(trxMgntCO.getLoginUserId());
	    syncAccLockUnlockCO.setModule(ConstantsCommon.RET_APP_NAME);
	    syncAccLockUnlockCO.setTimeout(null);
	    syncAccLockUnlockCO.setLockId(trxMgntSC.getLockId());

	    safeAccLockBO.lockUnlockAccounts_NewTrans(syncAccLockUnlockCO, "LR");

	    if(trxMgntCO.getLanguage() == null)
	    {
		trxMgntCO.setLanguage(ConstantsCommon.LANGUAGE_ENGLISH);
	    }
	    BigDecimal errorCode = syncAccLockUnlockCO.getErrorCode();
	    if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-1)) == 0)
	    {
		// Record Was Not blocked Successfully
		throw new BOException(MessageCodes.RECORD_WAS_NOT_BLOCKED_SUCCESSFULLY);
	    }
	    else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-4)) == 0)
	    {
		// 1 - locking successfull 4-Local Br is Disconnected, but
		// acc is local
		String errorMessage = commonLibBO.returnTranslErrorMessage(
			MessageCodes.LOCAL_BRANCH_DISC_ACC_IS_LOCAL_PARAM1, new String[] { account }, trxMgntCO
				.getLanguage());
		warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
	    }
	    BigDecimal userLevel = trxMgntSC.getUserLevel();
	    BigDecimal overrideUserLevel = trxMgntSC.getOverrideUsrLevel();
	    if(NumberUtil.isEmptyDecimal(trxMgntCO.getCtsTellerVO().getCODE()))
	    {
		CTSTELLERVO ctstellerVO = new CTSTELLERVO();
		ctstellerVO.setCOMP_CODE(trxMgntSC.getCompCode());
		ctstellerVO.setBRANCH_CODE(trxMgntSC.getBranchCode());
		ctstellerVO.setCODE(trxMgntSC.getTellerCode());
		ctstellerVO = (CTSTELLERVO) genericDAO.selectByPK(ctstellerVO);
		if(ctstellerVO != null)
		{
		    userLevel = ctstellerVO.getPRIVILEGE_LEVEL();
		}
	    }
	    if("1".equals(trxMgntSC.getCheckDataSys2())
		    && (overrideUserLevel == null || overrideUserLevel.compareTo(userLevel) > 0))
	    {
		// rollback
		if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-3)) == 0)
		{
		    // Already Locked
		    throw new BOException(MessageCodes.ACCOUNT_IS_ALREADY_LOCKED_PARAM1, new String[] { account });
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-2)) == 0)
		{
		    // Account Origin Br Disconnected
		    throw new BOException(MessageCodes.ACCOUNT_BRANCH_IS_DISCONNECTED_PARAM1, new String[] { account });
		}
		// else if(errorCode != null &&
		// errorCode.equals(BigDecimal.valueOf(3)))
		// {
		// // Origin Br Missing
		// throw new
		// BOException(MessageCodes.MISSING_INVALID_ACCOUNT_BRANCH_PARAM1,
		// new String[] { account });
		// }
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-5)) == 0)
		{
		    // Local Br is Disconnected, but acc is external
		    // the account might be locked just prior to the request
		    // timeout and should be unlocked
		    safeAccLockBO.lockUnlockAccounts_NewTrans(syncAccLockUnlockCO, "UR");
		    if(syncAccLockUnlockCO.getErrorCode() != null
			    && syncAccLockUnlockCO.getErrorCode().compareTo(BigDecimal.valueOf(0)) != 0)
		    {
			// Record Was Not Unblocked Successfully
			throw new BOException(MessageCodes.RECORD_WAS_NOT_UNBLOCKED_SUCCESFUL);
		    }
		    throw new BOException(MessageCodes.LOCAL_BRANCH_DISCONNECTED_ACCOUNT_EXTERNAL_PARAM1,
			    new String[] { account });
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-6)) == 0)
		{
		    // Original branch intentionally shutdown
		    throw new BOException(MessageCodes.ORIGINAL_BRANCH_INTERNATIONALLY_SHUTDOWN);
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-7)) == 0)
		{
		    // Original branch has pending Queue
		    throw new BOException(MessageCodes.ORIGINAL_BRANCH_HAS_PENDING_QUEUE);
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-8)) == 0)
		{
		    // Pending Queue for Account-Path110079 23-04-2012 //
		    // added by fares 25-04-2012
		    throw new BOException(MessageCodes.PENDING_QUEUE_FOR_ACCOUNT_PARAM1, new String[] { account });
		}
	    }
	    else
	    // the user level is allowed to proceed eventhough the locking
	    // was not successfull
	    {
		if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-3)) == 0)
		{
		    // Already Locked
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.ACCOUNT_IS_ALREADY_LOCKED_PARAM1, new String[] { account }, trxMgntCO
				    .getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-2)) == 0)
		{
		    // Account Origin Br Disconnected
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.ACCOUNT_BRANCH_IS_DISCONNECTED_PARAM1, new String[] { account }, trxMgntCO
				    .getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
		// else if(errorCode != null &&
		// errorCode.equals(BigDecimal.valueOf(3)))
		// {
		// // Origin Br Missing
		// String errorMessage = commonLibBO.returnTranslErrorMessage(
		// MessageCodes.MISSING_INVALID_ACCOUNT_BRANCH_PARAM1, new
		// String[] { account }, trxMgntCO
		// .getLanguage());
		// warningMessages.append(errorMessage +
		// ConstantsCommon.NEW_LINE);
		// }
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-5)) == 0)
		{
		    // Local Br is Disconnected, but acc is external
		    // the account might be locked just prior to the request
		    // timeout and should be unlocked
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.LOCAL_BRANCH_DISCONNECTED_ACCOUNT_EXTERNAL_PARAM1, new String[] { account },
			    trxMgntCO.getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-6)) == 0)
		{
		    // Original branch intentionally shutdown
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.ORIGINAL_BRANCH_INTERNATIONALLY_SHUTDOWN, trxMgntCO.getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-7)) == 0)
		{
		    // Original branch has pending Queue
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.ORIGINAL_BRANCH_HAS_PENDING_QUEUE, trxMgntCO.getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
		else if(errorCode != null && errorCode.compareTo(BigDecimal.valueOf(-8)) == 0)
		{
		    // Pending Queue for Account-Path110079 23-04-2012 //
		    // added by fares 25-04-2012
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.PENDING_QUEUE_FOR_ACCOUNT_PARAM1, new String[] { account }, trxMgntCO
				    .getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
	    }
	}

	trxMgntCO.setWarningMsg(warningMessages.toString());
	return trxMgntSC;
    }

    private void pepareDataFromWebServices(TrxMgntCO trxMgntCO) throws BaseException
    {
	// Teller
	CTSTELLERVO tellerVO = commonLibBO.returnCtsTellerDetails(trxMgntCO.getLoginCompCode(),
		trxMgntCO.getLoginBraCode(), trxMgntCO.getLoginUserId());
	if(tellerVO != null)
	{
	    trxMgntCO.setLoginTellerCode(tellerVO.getCODE());
	}

	// Accounts
	if(BigDecimal.ONE.equals(trxMgntCO.getUseAccount()))
	{
	    if(trxMgntCO.getAccountVO() != null
		    && (trxMgntCO.getAccountVO().getADDITIONAL_REFERENCE() != null
			    && StringUtil.isNotEmpty(trxMgntCO.getAccountVO().getADDITIONAL_REFERENCE()))
		    || (trxMgntCO.getAccountVO().getIBAN_ACC_NO() != null
			    && StringUtil.isNotEmpty(trxMgntCO.getAccountVO().getIBAN_ACC_NO())))
	    {
		AccountSC criteria = new AccountSC();
		criteria.setCompCode(trxMgntCO.getLoginCompCode());
		criteria.setPreferredLanguage("EN");
		if(trxMgntCO.getAccountVO().getADDITIONAL_REFERENCE() != null)
		{
		    criteria.setAddRef(trxMgntCO.getAccountVO().getADDITIONAL_REFERENCE());
		}
		else if(trxMgntCO.getAccountVO().getIBAN_ACC_NO() != null)
		{
		    criteria.setIbanNo(trxMgntCO.getAccountVO().getIBAN_ACC_NO());
		}
		List<AMFVO> accountList = new ArrayList<AMFVO>();
		accountList = accountBO.returnAccountsInAMFByCondition(criteria);
		if(!accountList.isEmpty() && accountList != null && accountList.size() == 1)
		{
		    trxMgntCO.getCtstrsVO().setTRS_AC_BR(accountList.get(0).getBRANCH_CODE());
		    trxMgntCO.getCtstrsVO().setTRS_AC_CIF(accountList.get(0).getCIF_SUB_NO());
		    trxMgntCO.getCtstrsVO().setTRS_AC_CY(accountList.get(0).getCURRENCY_CODE());
		    trxMgntCO.getCtstrsVO().setTRS_AC_GL(accountList.get(0).getGL_CODE());
		    trxMgntCO.getCtstrsVO().setTRS_AC_SL(accountList.get(0).getSL_NO());
		}
	    }
	}
	else if(BigDecimal.ZERO.equals(trxMgntCO.getUseAccount())
		&& StringUtil.isNotEmpty(trxMgntCO.getCurrencyVO().getISO_CODE()))
	{
	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setCompCode(trxMgntCO.getLoginCompCode());
	    trxMgntSC.setBranchCode(trxMgntCO.getLoginBraCode());
	    trxMgntSC.setTrxType(trxMgntCO.getCtstrsVO().getTRX_TYPE());
	    trxMgntSC.setDrCrType("D");
	    CURRENCIESVO currencyVO = new CURRENCIESVO();
	    List<CURRENCIESVO> currenciesList = new ArrayList<CURRENCIESVO>();
	    currencyVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    currencyVO.setISO_CODE(trxMgntCO.getCurrencyVO().getISO_CODE());
	    currenciesList = currencyBO.returnCurrencyByIsoCode(currencyVO);
	    if(!currenciesList.isEmpty() && currenciesList != null && currenciesList.get(0) != null)
	    {
		trxMgntSC.setTrsCy(currenciesList.get(0).getCURRENCY_CODE());
	    }
	    trxMgntSC = coreCommonProcedureBO.getTransactionAccount(trxMgntSC);
	    if(trxMgntSC != null)
	    {
		trxMgntCO.getCtstrsVO().setTRS_AC_BR(trxMgntSC.getTrsAcBr());
		trxMgntCO.getCtstrsVO().setTRS_AC_CIF(trxMgntSC.getTrsAcCif());
		trxMgntCO.getCtstrsVO().setTRS_AC_CY(trxMgntSC.getTrsAcCy());
		trxMgntCO.getCtstrsVO().setTRS_AC_GL(trxMgntSC.getTrsAcGl());
		trxMgntCO.getCtstrsVO().setTRS_AC_SL(trxMgntSC.getTrsAcSl());
	    }
	}

	if(BigDecimal.ONE.equals(trxMgntCO.getUseToAccount()))
	{
	    if(trxMgntCO.getIstr_to_acc() != null
		    && (trxMgntCO.getIstr_to_acc().getADDITIONAL_REFERENCE() != null
			    && StringUtil.isNotEmpty(trxMgntCO.getIstr_to_acc().getADDITIONAL_REFERENCE()))
		    || (trxMgntCO.getIstr_to_acc().getIBAN_ACC_NO() != null
			    && StringUtil.isNotEmpty(trxMgntCO.getIstr_to_acc().getIBAN_ACC_NO())))
	    {
		AccountSC criteria = new AccountSC();
		criteria.setCompCode(trxMgntCO.getLoginCompCode());
		criteria.setPreferredLanguage("EN");
		if(trxMgntCO.getIstr_to_acc().getADDITIONAL_REFERENCE() != null)
		{
		    criteria.setAddRef(trxMgntCO.getIstr_to_acc().getADDITIONAL_REFERENCE());
		}
		else if(trxMgntCO.getIstr_to_acc().getIBAN_ACC_NO() != null)
		{
		    criteria.setIbanNo(trxMgntCO.getIstr_to_acc().getIBAN_ACC_NO());
		}
		List<AMFVO> accountList = new ArrayList<AMFVO>();
		accountList = accountBO.returnAccountsInAMFByCondition(criteria);
		if(!accountList.isEmpty() && accountList != null && accountList.size() == 1)
		{
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(accountList.get(0).getBRANCH_CODE());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(accountList.get(0).getCIF_SUB_NO());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(accountList.get(0).getCURRENCY_CODE());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(accountList.get(0).getGL_CODE());
		    trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(accountList.get(0).getSL_NO());
		}
	    }
	}
	else if(BigDecimal.ZERO.equals(trxMgntCO.getUseToAccount()) && trxMgntCO.getCurrencyVO().getISO_CODE() != null)
	{
	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setCompCode(trxMgntCO.getLoginCompCode());
	    trxMgntSC.setBranchCode(trxMgntCO.getLoginBraCode());
	    trxMgntSC.setDrCrType("D");
	    CURRENCIESVO currencyVO = new CURRENCIESVO();
	    List<CURRENCIESVO> currenciesList = new ArrayList<CURRENCIESVO>();
	    currencyVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    currencyVO.setISO_CODE(trxMgntCO.getCurrencyVO().getISO_CODE());
	    currenciesList = currencyBO.returnCurrencyByIsoCode(currencyVO);
	    if(!currenciesList.isEmpty() || currenciesList != null)
	    {
		trxMgntSC.setTrsCy(currenciesList.get(0).getCURRENCY_CODE());
	    }
	    trxMgntSC = coreCommonProcedureBO.getTransactionAccount(trxMgntSC);
	    if(trxMgntSC != null)
	    {
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_BR(trxMgntSC.getTrsAcBr());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_CIF(trxMgntSC.getTrsAcCif());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_CY(trxMgntSC.getTrsAcCy());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_GL(trxMgntSC.getTrsAcGl());
		trxMgntCO.getCtstrsVO().setTO_TRS_AC_SL(trxMgntSC.getTrsAcSl());
	    }
	}
    }
    /**
     * US 154817 SAFE account locking unlock should be called at the end of each
     * process because we should commit/rollback before unlock
     * 
     * @param lockId
     * @param accForLockExists
     * @param fromExeption true/false
     * @param retailBaseVO
     * @return warningMessages String
     * @throws BaseException
     * @author tonynouh
     */
    public String unlockSafeAccounts(BigDecimal lockId, String accForLockExists, boolean fromExeption,
	    RetailBaseVO retailBaseVO) throws BaseException
    {
	BigDecimal safeApp = commonLibBO.returnPthCtrl().getSAFE_APP();
	if(NumberUtil.nullToZero(safeApp).compareTo(BigDecimal.ZERO) == 0)
	{
	    return "";
	}
	StringBuffer warningMessages = new StringBuffer();
	if("true".equals(accForLockExists) && lockId != null)
	{
	    if(fromExeption)
	    {
		genericDAO.rollBackTransaction();
	    }
	    else
	    {
		genericDAO.commitTransaction();
	    }
	    SyncAccLockUnlockCO syncAccLockUnlockCO = new SyncAccLockUnlockCO();
	    syncAccLockUnlockCO.setLoggedCompany(retailBaseVO.getLoginCompCode());
	    syncAccLockUnlockCO.setLoggedBranch(retailBaseVO.getLoginBraCode());
	    syncAccLockUnlockCO.setLoggedUser(retailBaseVO.getLoginUserId());
	    syncAccLockUnlockCO.setModule(ConstantsCommon.RET_APP_NAME);
	    syncAccLockUnlockCO.setTimeout(null);
	    syncAccLockUnlockCO.setLockId(lockId);
	    safeAccLockBO.lockUnlockAccounts_NewTrans(syncAccLockUnlockCO, "UR");

	    BigDecimal errorCode = syncAccLockUnlockCO.getErrorCode();
	    if(retailBaseVO.getLanguage() == null)
	    {
		retailBaseVO.setLanguage(ConstantsCommon.LANGUAGE_ENGLISH);
	    }
	    if(errorCode != null && errorCode.compareTo(BigDecimal.ZERO) != 0)
	    {
		if(TrxMgntConstant.CRUD_APPROVE.equals(retailBaseVO.getCrud()))
		{
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.ACC_UNLOCKING_FAILED_TRX_WAS_SUCCESSFULLY_PARAM1,
			    new String[] { "Approved_key" }, retailBaseVO.getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
		else if(TrxMgntConstant.CRUD_REVERSE.equals(retailBaseVO.getCrud()))
		{
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.ACC_UNLOCKING_FAILED_TRX_WAS_SUCCESSFULLY_PARAM1,
			    new String[] { "Reversed_key" }, retailBaseVO.getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
		else
		{
		    String errorMessage = commonLibBO.returnTranslErrorMessage(
			    MessageCodes.ACC_UNLOCKING_FAILED_TRX_WAS_SUCCESSFULLY_PARAM1,
			    new String[] { "processed_key" }, retailBaseVO.getLanguage());
		    warningMessages.append(errorMessage + ConstantsCommon.NEW_LINE);
		}
	    }
	}
	return warningMessages.toString();
    }

    /**
     * This method will be used to retrieve data once for each action following
     * the business needs. The retrieved variables should be set in the CO to be
     * used from all the methods called from one action. in pb uf_find_trxtype
     * 
     * @param trxMgntCO
     * @return trxMgntCO
     * @throws BaseException
     * @neededProperties trxMgntCO.getLoginCompCode()
     *                   trxMgntCO.getCtstrsVO().getTRX_TYPE()
     * 
     */
    public TrxMgntCO returnCommonVariables(TrxMgntCO trxMgntCO) throws BaseException
    {
	CTSTRXTYPEVO ctstrxtypeVO1 = new CTSTRXTYPEVO();
	ctstrxtypeVO1.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	ctstrxtypeVO1.setCODE(trxMgntCO.getCtstrsVO().getTRX_TYPE());
	if(!trxMgntCO.isFromRetrieve())
	{
	    ctstrxtypeVO1.setSTATUS(TrxMgntConstant.STATUS_APPROVE);
	}
	ctstrxtypeVO1 = coreCommonBO.findTrxType(ctstrxtypeVO1);

	if(ctstrxtypeVO1 == null)
	{
	    throw new BOException(MessageCodes.TRX_TYPE_PARAM1_NOT_APP_OR_SUSPENDED_PLS_CONTACT_ADMIN,
		    new String[] { trxMgntCO.getCtstrsVO().getTRX_TYPE().toString() });
	}

	if((TrxMgntConstant.MULTI_CHQ_ENTRY_SCREEN.equals(StringUtil.nullToEmpty(trxMgntCO.getScreenSrc())
		.toUpperCase()) || TrxMgntConstant.MULTI_CHQ_ENTRY_SCREEN_UO.equals(StringUtil.nullToEmpty(
		trxMgntCO.getScreenSrc()).toUpperCase()))
		&& "1".equals(ctstrxtypeVO1.getCC_MAINTAIN_BATCH()))
	{
	    ctstrxtypeVO1.setAUTOMATIC_BATCH("1");
	}

	if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(trxMgntCO.getLoginPreferrredLanguage()))
	{
	    ctstrxtypeVO1.setOTHER_INFO_LABEL1(ctstrxtypeVO1.getOTHER_INFO_LABEL1_ARAB());
	    ctstrxtypeVO1.setOTHER_INFO_LABEL2(ctstrxtypeVO1.getOTHER_INFO_LABEL2_ARAB());
	    ctstrxtypeVO1.setOTHER_INFO_LABEL3(ctstrxtypeVO1.getOTHER_INFO_LABEL3_ARAB());
	}
	trxMgntCO.setCtstrxtypeVO(ctstrxtypeVO1);
	CTSTRXTYPEVO ctstrxtypeVO = trxMgntCO.getCtstrxtypeVO();
	if(ctstrxtypeVO != null && NumberUtil.nullToZero(ctstrxtypeVO.getREMITT_TYPE()).compareTo(BigDecimal.ZERO) > 0)
	{
	    // Rania - 504699 - SBI170064 - Prize Bond Management
	    // id:968867 Details:Null Pointer Exception upon trying to approve
	    // transaction
	    if(trxMgntCO.getCtstrsExtendedVO() != null
		    && !NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsExtendedVO().getREMITTANCE_TYPE_CODE()))
	    {
		ctstrxtypeVO.setREMITT_TYPE(trxMgntCO.getCtstrsExtendedVO().getREMITTANCE_TYPE_CODE());
	    }
	    //
	    // trxMgntDAO.returnRemittanceDet(trxMgntCO);// remittanceVO will be
	    // filled in trxMgntCO
	    REMITTANCEVO remittanceVO = new REMITTANCEVO();
	    remittanceVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    remittanceVO.setCODE(ctstrxtypeVO.getREMITT_TYPE());
	    remittanceVO = (REMITTANCEVO) genericDAO.selectByPK(remittanceVO);
	    if(StringUtil.nullToEmpty(remittanceVO.getBY_COMP_OR_BRANCH()).isEmpty())
	    {
		remittanceVO.setBY_COMP_OR_BRANCH(TrxMgntConstant.REMITT_BY_COMP);
	    }
	    if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(trxMgntCO.getLoginPreferrredLanguage()))
	    {
		remittanceVO.setBRIEF_NAME_ENG(remittanceVO.getBRIEF_NAME_ARAB());
	    }
	    trxMgntCO.setRemittanceVO(remittanceVO);
	    trxMgntCO.setPrizeBondTypeList(remittanceVO.getPRIZE_BOND_TYPE_LIST()); //Rania - 504699 - SBI170064 - Prize Bond Management
	    trxMgntCO.setDenomination(remittanceVO.getDENOMINATION()); //Rania - 504699 - SBI170064 - Prize Bond Management
	}

	// NABIL FEGHALI - BB130085 - Global Payment File
	// Return ctsTrxTypeExtended
	if(ctstrxtypeVO != null)
	{
	    CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO1 = new CTSTRXTYPE_EXTENDEDVO();
	    ctstrxtypeExtendedVO1.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    ctstrxtypeExtendedVO1.setCODE(trxMgntCO.getCtstrsVO().getTRX_TYPE());
	    ctstrxtypeExtendedVO1 = coreCommonBO.findTrxTypeExtended(ctstrxtypeExtendedVO1);
	    if(ctstrxtypeExtendedVO1 == null)
	    {
		ctstrxtypeExtendedVO1 = new CTSTRXTYPE_EXTENDEDVO();
	    }
	    trxMgntCO.setCtstrxtypeExtendedVO(ctstrxtypeExtendedVO1);
	}

	return trxMgntCO;
    }

    public int returnCntCtsRegBillType(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonServiceDAO.returnCntCtsRegBillType(trxMgntSC);
    }

    public CIFVO updateMainCifData(CIFVO cifVO, Date dateUpdated) throws BaseException
    {
	FomCO fomCO = new FomCO();
	fomCO.setCifVO(cifVO);
	fomCO.setDateUpdated(dateUpdated);
	if(FomConstant.STATUS_ACTIVE.equals(fomCO.getCifVO().getSTATUS()))
	{
	    fomCO.getCifVO().setSTATUS(FomConstant.STATUS_INACTIVE);
	}

	callAlertCif(cifVO.getCOMP_CODE(), cifVO.getCIF_NO(), FomConstant.CIF_ALERT_STATUS_S, null);
	int row = coreCommonServiceDAO.updateMainCifData(fomCO);
	if(row < 1)
	{
	    throw new BOException(MessageCodes.RECORD_CHANGED);
	}
	
	return cifVO;
    }

    /**
     * Call the P_RET_ALERT_CIF procedure PB= guo_back_end_proc.p_ret_alert_cif
     * flag variable to define the row which table Will be save in Alert, it
     * will be null when Status is not FomConstant.CIF_ALERT_STATUS_SS
     * 
     * @author nabilfeghali modified by : Chady.A
     */
    public CifSC callAlertCif(BigDecimal compCode, BigDecimal cifNo, String status, String flag) throws BaseException
    {
	Assert.notNull(compCode);
	Assert.notNull(cifNo);
	CifSC cifSC = new CifSC();
	cifSC.setCompCode(compCode);
	cifSC.setCif_no(cifNo);
	cifSC.setCifAlertStatus(status);
	cifSC.setFlag(flag);
	CifSC returnedcifSC = coreCommonProcedureBO.callAlertCif(cifSC);
	if(returnedcifSC != null && returnedcifSC.getErrorCode() != null
		&& NumberUtil.nullToZero(returnedcifSC.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(returnedcifSC.getErrorMessage());
	}
	return cifSC;
    }

    public void fillSoundex(MosBlackListSC mosBlackListSC) throws BaseException
    {
	coreCommonProcedureBO.fillSoundex(mosBlackListSC);
    }

    public boolean checkIfDataCanModified(CTSTELLERVO ctsTellerVO, String cifstatus, String crudLevel,
	    Integer AccessDescriptionNumber) throws BaseException
    {
	boolean returnValue = true;
	// boolean cifIsFreshDraft=checkCifIsFreshDraft

	
	//BUG #520085 'cifIsFreshDraft' was removed based on bug#289102, the system should check on user access when cif status in not draft
	// BUG #289102 the system is allowing the user to modify the real
	// beneficiary knowing that the flag is not checked
	boolean cifIsFreshDraft = (StringUtil.nullToEmpty(cifstatus).equals(StringUtil.nullToEmpty(NCifMaintenanceConstant.CIF_DRAFT)));

	String crud = crudLevel;
	String comp, cifNo, approvedBy = null;
	String[] arr = crudLevel == null ? null : crudLevel.split("-");
	boolean checkOnApprovedBy = false;
	if(arr != null && arr.length == 3 && arr[0] != null && arr[1] != null && arr[2] != null)
	{
	    checkOnApprovedBy = true;
	    crud = arr[0];
	    comp = arr[1];
	    cifNo = arr[2];
	    CIFVO cifVo = new CIFVO();
	    cifVo.setCOMP_CODE(new BigDecimal(comp));
	    cifVo.setCIF_NO(new BigDecimal(cifNo));
	    cifVo = (CIFVO) genericDAO.selectByPK(cifVo);
	    if(cifVo != null)
	    {
		approvedBy = cifVo.getAPPROVED_BY();
	    }
	}
	boolean checkAccessTeller = checkAccesTellerModified(ctsTellerVO, AccessDescriptionNumber);
	if(checkOnApprovedBy && NCifMaintenanceConstant.CIF_INACTIVE.equals(cifstatus)
		&& !StringUtil.isNotEmpty(approvedBy) && "R".equals(crud))
	{
	    returnValue = true;
	}
	else if((NCifMaintenanceConstant.CIF_SUSPENDED.equals(cifstatus)
		|| NCifMaintenanceConstant.CIF_DELETED.equals(cifstatus) || "P".equals(crud) || "Q".equals(crud)
		|| "S".equals(crud) || !(checkAccessTeller)) && !(cifIsFreshDraft))
	{
	    returnValue = false;
	}


	return returnValue;
    }

    /**
     * this is a common function for all popups to check if we have acces to
     * insert or delete in popups
     * 
     * @param ctsTellerVO
     * @param allowModifyCif= this falg has two values N:no accesS Y: with
     *            access
     * @param AccessDescriptionNumber=in this we have to fill the number of
     *            acces description
     * @return
     * @throws BaseException
     */
    public boolean checkAccesTellerModified(CTSTELLERVO ctsTellerVO, Integer AccessDescriptionNumber)
	    throws BaseException
    {
	return checkAccesTellerModified(ctsTellerVO, AccessDescriptionNumber, null);
    }

    public boolean checkAccesTellerModified(CTSTELLERVO ctsTellerVO, Integer AccessDescriptionNumber,
	    HashMap<BigDecimal, CTSTELLER_AXSVO> cifUserAccessMap1) throws BaseException
    {
	HashMap<BigDecimal, CTSTELLER_AXSVO> cifUserAccessMap = cifUserAccessMap1;
	boolean returnValue = true;
	if(cifUserAccessMap == null && null != ctsTellerVO)
	{
	    FomCO fomCO = new FomCO();
	    fomCO.setCtsTellerVO(ctsTellerVO);
	    fomCO.getCifVO().setCOMP_CODE(ctsTellerVO.getCOMP_CODE());
	    fomCO.getCifVO().setBRANCH_CODE(ctsTellerVO.getBRANCH_CODE());
	    fomCO = fillCifUserAccessMap(fomCO);
	    cifUserAccessMap = fomCO.getCifUserAccessMap();
	}
	// Hasan Bug#566067 - BMOUPI170480 18/09/2017
	String checkAccessAllowed = "Y";
	if(cifUserAccessMap != null && null != cifUserAccessMap.get(new BigDecimal(AccessDescriptionNumber)))
	{
	    checkAccessAllowed = cifUserAccessMap.get(new BigDecimal(AccessDescriptionNumber)).getACCESS_ALLOWED();
	}
	// Teller has no right to modify any cif information
	if("N".equals(checkAccessAllowed) || "N".equals(ctsTellerVO.getALLOW_TO_MODIFY_CIF()))
	{
	    returnValue = false;
	}
	//}
	return returnValue;
    }

    public FomCO fillCifUserAccessMap(FomCO fomCO) throws BaseException
    {
	if(null != fomCO.getCtsTellerVO())
	{
	    CTSTELLERVO ctsTellerVO = fomCO.getCtsTellerVO();
	    CifUserAccessSC cifUserAccessSC = new CifUserAccessSC();
	    cifUserAccessSC.setCtsTellerVO(ctsTellerVO);
	    cifUserAccessSC.getCtsTellerAxsVO().setCOMP_CODE(ctsTellerVO.getCOMP_CODE());
	    cifUserAccessSC.getCtsTellerAxsVO().setBRANCH_CODE(ctsTellerVO.getBRANCH_CODE());
	    cifUserAccessSC.getCtsTellerAxsVO().setTELLER_CODE(ctsTellerVO.getCODE());
	    cifUserAccessSC.getCtsTellerAxsVO().setACCESS_TYPE(ConstantsCommon.CIF_APP_NAME);
	    HashMap<BigDecimal, CTSTELLER_AXSVO> cifUserAccessMap = (HashMap<BigDecimal, CTSTELLER_AXSVO>) returnCifTellersAcces(
		    cifUserAccessSC);
	    fomCO.setCifUserAccessMap(cifUserAccessMap);
	}
	return fomCO;
    }

    /**
     * this function get the cif teller acces in PB:wf_get_teller_access
     */
    public Map returnCifTellersAcces(CifUserAccessSC cifUserAccessSC) throws BaseException
    {
	String allowToModifyCif = StringUtil.nullEmptyToValue(
		cifUserAccessSC.getCtsTellerVO().getALLOW_TO_MODIFY_CIF(), "N");
	cifUserAccessSC.setAllowToModifyCif(allowToModifyCif);
	return cifUserAccessBO.selectCifUserAccessList(cifUserAccessSC);
    }

    public Boolean checkCifIsDraft(FomCO fomCO) throws BaseException
    {
	Boolean returnValue = false;

	BigDecimal cifNo = NumberUtil.nullToZero(fomCO.getCifVO().getCIF_NO());
	String status = StringUtil.nullEmptyToValue(fomCO.getCifVO().getSTATUS(), "0");

	if("0".equals(status) && cifNo.intValue() > 0) // if draft return 1
	{
	    returnValue = true;
	}

	return returnValue;
    }

    /**
     * this is general function check the validity of civil code it checks the
     * validty of ID_NO based it's type example : if we want valid the "ID_NO"
     * then we need to set the CivilCodeField to "ID_TYPE" if we want valid the
     * "ID_NO2" then we need to set the CivilCodeField to "ID_TYPE2" if we want
     * valid the "JOIN_ID_NO" then we need to set the CivilCodeField to
     * "JOIN_ID_TYPE"
     * 
     * @param fomCO
     * @throws BaseException
     */

    public void validateIdNo(FomCO fomCO) throws BaseException
    {
	String valueOfIdNo = "";
	String civilCodeField = fomCO.getCivilCodeField();
	BigDecimal idTypeCodeValue = NumberUtil.nullToZero(fomCO.getIdTypeValue());

	// if the civilcode eqUal to 1 then is civil code
	ID_TYPESVO idtypesVO = new ID_TYPESVO();
	idtypesVO.setCOMP_CODE(fomCO.getLoginCompCode());
	idtypesVO.setCODE(idTypeCodeValue);

	Boolean isCivilId = checkCivilId(idtypesVO, fomCO.getIdTypessVO().get(civilCodeField));
	// String validateCID=fomCO.getCifControlVO().getVALIDATE_ID();
	String validateCID = "0";
	if(fomCO.getRifCttVO() != null)
	{
	    validateCID = StringUtil.nullEmptyToValue(fomCO.getRifCttVO().getVALIDATE_CID(), "0");
	}

	valueOfIdNo = fomCO.getCivilCodeValue();

	/*
	 * IF ls_data_type='0' or (ls_data_type='2' and ll_id_type = 1) THEN IF
	 * ll_id_type = 1 Then //civil id //1.1 Check if numeric
	 */
	idtypesVO = (fomCO.getIdTypessVO().get(civilCodeField) == null) ? new ID_TYPESVO() : fomCO.getIdTypessVO().get(
		civilCodeField);
	if(!StringUtil.isNotEmpty(idtypesVO.getDATA_TYPE()) || "0".equals(idtypesVO.getDATA_TYPE())
		|| ("2".equals(idtypesVO.getDATA_TYPE()) && isCivilId))
	{
	    if(isCivilId)
	    {
		// 0-checking if the id is numeric ( datatype = 2 )
		checkDataType(valueOfIdNo, NCifMaintenanceConstant.ALPHA_NUMERIC_DATA_TYPE); // Hala
											     // Al
											     // Sheikh
											     // -
											     // AMANA130215
		// A-checking if the client is individual
		/*
		 * In case of FOMMoresignatory and fomOwnerShip we do not need
		 * to check the digits coz the CIF is not bank (no cif type)
		 */
		if(NCifMaintenanceConstant.CIF_IS_INDIVIDUAL.equals(fomCO.getVtInd())
			&& NCifMaintenanceConstant.VALIDATE_CID_TRUE.equals(validateCID)
			&& !("1").equals(StringUtil.nullToEmpty(fomCO.getFromFomSignatory()))
			&& !("1").equals(StringUtil.nullToEmpty(fomCO.getFromFomOwnerShip())))
		{

		    // B-checking if the Application is CSM
		    if(ConstantsCommon.RET_APP_NAME.equals(fomCO.getAppName()))
		    {

			if(FomConstant.CALLING_MOD_UPDATE.equals(fomCO.getScallingMod()))
			{
			    if(!fomCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ().equals(
				    ConstantsCommon.CB_JORDAN.toString())
				    && FomConstant.CALLING_MOD_UPDATE.equals(fomCO.getScallingMod())
				    && "1".equals(fomCO.getCifControlVO().getVALIDATE_ID())
				    && verifyCivilId(fomCO, "0") == -1)
			    {
				// NABIL FEGHALI - FIX ISSUE #78727 invalid
				// entry message on save
				// throw new
				// BOException(MessageCodes.INVALID_ENTRY, new
				// String[] { "ID_No_key",fomCO.getSectionName()
				// }, true);
				throw new BOException(MessageCodes.INVALID_ENTRY);
			    }
			}
			else
			{
			    if(coreCommonBO.returnCivilIdCheckDigit(valueOfIdNo, fomCO.getCtsControl()
				    .getINWARD_OUTWARD_CLR_CHQ()) == -1)
			    {
				throw new BOException(MessageCodes.INVALID_ENTRY /*
                                        					  * ,
                                        					  * new
                                        					  * String
                                        					  * [
                                        					  * ]
                                        					  * {
                                        					  * "NOT_MATCHED_WITH_ID_DIGIT_KEY"
                                        					  * }
                                        					  * ,
                                        					  * true
                                        					  */);

			    }
			    else
			    {
				if((((ConstantsCommon.CBK_KUWAIT.toString()).equals(fomCO.getCtsControl()
					.getINWARD_OUTWARD_CLR_CHQ())) || ((ConstantsCommon.BMA_BAHREIN.toString())
					.equals(fomCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ())))
					&& coreCommonBO.returnCivilIdCheckDigit(valueOfIdNo, "1") == -1)
				{
				    throw new BOException(MessageCodes.INVALID_ENTRY/*
										     * ,new
										     * String
										     * [
										     * ]
										     * {
										     * "NOT_MATCHED_WITH_ID_DIGIT_KEY"
										     * }
										     */);
				}
			    }
			}
		    }
		    else
		    // if the application is not CSM
		    {
			if(coreCommonBO.returnCivilIdCheckDigit(valueOfIdNo, "1") == -1)
			{
			    throw new BOException(MessageCodes.INVALID_ENTRY);
			}
		    } // B- end checking if the Application is CSM
		}// end of A-checking if the client is individual
	    } // end iscivilId
	}
	else
	{
	    checkDataType(valueOfIdNo, idtypesVO.getDATA_TYPE());
	} // end if id_type = 0 or 2
	// BBI100324 - RK - 22082011
	
	/*Checking on the idType in the IDs button, within the same CIF , No duplication is allowed*/
	  
	if(("1").equals(StringUtil.nullToEmpty(fomCO.getFromIdsButton()))
		&& !"true".equals(fomCO.getFromSignature()))
   {	  
    CIFVO cifVo = new CIFVO();
    CifSC criteria = new CifSC();
    criteria.setComp_code(fomCO.getLoginCompCode());
    criteria.setCif_no(fomCO.getCifVO().getCIF_NO());
    criteria.setAllStatus(true);
    fomCO.setScallingMod(FomConstant.CALLING_MOD_UPDATE);
    cifVo = cifBO.returnCIF(criteria);
    if(null!=cifVo)
    {
	//Hasan Bug#666032 DASI180213 02/05/2018
	BigDecimal cifVoIdType = NumberUtil.nullEmptyToValue(fomCO.getCifVO().getID_TYPE(), BigDecimal.ZERO);
       fomCO.setCifVO(cifVo);
       
       if(!BigDecimal.ZERO.equals(cifVoIdType))
       {
	   fomCO.getCifVO().setID_TYPE(cifVoIdType);
       }

       if(!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getID_TYPE()) && fomCO.getCifVO().getID_TYPE().intValue() > 0
		&& idTypeCodeValue.intValue() > 0 && fomCO.getCifVO().getID_TYPE().intValue() == idTypeCodeValue.intValue())
	{
	    throw new BOException(MessageCodes.ID_Type_Already_in_Use, new String[] { ": " + idTypeCodeValue.toString() }, true);
	}
   }
  }	  
	

	// private boolean applyBalckListOnIds=false;

	if((fomCO.getIdTypessVO().get(civilCodeField) != null) && (fomCO.isApplyUniquenessOnIds()))
	{
	    String validateCifId = fomCO.getCifControlVO().getVALIDATE_CIF_ID();
	    String uniqueness = StringUtil.nullEmptyToValue(fomCO.getIdTypessVO().get(civilCodeField).getUNIQUENESS(),
		    "0");
	    // Validate the uniqueness in case the validate CIF Uniquness upon
	    // "Input and Update" and in case "Update" do not validate it on
	    // dependency
	    if(!"1".equals(fomCO.getJointAccounts()) && !"1".equals(fomCO.getFromFomSignatory()))//BUG#802876 Copied from TP 475791 EWBI170089
	    {
	    if((NCifMaintenanceConstant.VALIDATE_CIF_ID_INPUT_UPDATE.equals(validateCifId)
		    || (NCifMaintenanceConstant.VALIDATE_CIF_ID_UPDATE.equals(validateCifId) && !("1")
			    .equals(StringUtil.nullToEmpty(fomCO.getFromDependency())))
		    || ("1").equals(StringUtil.nullToEmpty(fomCO.getFromFomSignatory())) || ("1").equals(StringUtil
		    .nullToEmpty(fomCO.getFromIdsButton())))
		    && (("2".equals(uniqueness)) || ("1".equals(uniqueness))))
		{
		    fomCO.getCifVO().setID_NO(valueOfIdNo.toUpperCase());//Abdo TP#583824-BTII170145-06/11/2017
		    fomCO.getCifVO().setID_TYPE(idTypeCodeValue);
		// TONY NOUH Bug#324672
		// fomCO.getCifVO().setID_NO2(valueOfIdNo);
		// fomCO.getCifVO().setID_TYPE2(idTypeCodeValue);
		//
		    // RANIA BMO180181
		    ID_TYPESVO idTypesVO = new ID_TYPESVO();
		    idTypesVO.setCOMP_CODE(fomCO.getLoginCompCode());
		    idTypesVO.setCODE(idTypeCodeValue);
		    idTypesVO = (ID_TYPESVO) genericDAO.selectByPK(idTypesVO);
		    fomCO.getIdTypesVO().setENABLE_UNIQUE_BY_CIF_TYPE_YN(idTypesVO.getENABLE_UNIQUE_BY_CIF_TYPE_YN());
		    //
				
		// Bug 336925 -- [John Massaad] -- adding the two parameters
		// (valueOfIdNo, idTypeCodeValue)
		    Integer maxCIF = validateIdUniqueness(fomCO, valueOfIdNo, idTypeCodeValue);
		// Bug 336925 -- [John Massaad] -- adding the two parameters
		// (valueOfIdNo, idTypeCodeValue)
		    fomCO.setFromValidationOfIdType2("0");

		    if(null != maxCIF)
		    {

		    // fboukarroum IIAB110527 - Document Number Repetition in
		    // CIF
		    // NCifMaintenanceConstant.VALIDATE_CIF_ID_INPUT_UPDATE.equals(validateCifId)
		    // && (isCivilId == idType=1 )
		    if(NCifMaintenanceConstant.UNIQUNESS_ENABLED.equals(uniqueness))
		    {
			// get the OVERRIDE_ID_TYPE for the legal status
			if(NumberUtil.isEmptyDecimal(fomCO.getRifCttVO().getLEGAL_STATUS())
				&& NumberUtil.isEmptyDecimal(fomCO.getCifVO().getLEGAL_STATUS()))
			{
			    throw new BOException(MessageCodes.DUPLICATE_ENTRY_CIVIL_ID, new String[] { " ",
				    valueOfIdNo, "ALREADY_USED_WITH_CIF", " ", maxCIF.toString() });
			}
			else
			{
			    LEGAL_STATUSVO legalStatusVO = new LEGAL_STATUSVO();
			    legalStatusVO.setCOMP_CODE(fomCO.getCifVO().getCOMP_CODE());
			    if(NumberUtil.isEmptyDecimal(fomCO.getCifVO().getLEGAL_STATUS()))
			    {
				legalStatusVO.setSTATUS_CODE(fomCO.getRifCttVO().getLEGAL_STATUS());
			    }
			    else
			    {
				legalStatusVO.setSTATUS_CODE(fomCO.getCifVO().getLEGAL_STATUS());
			    }
			    legalStatusVO = (LEGAL_STATUSVO) genericDAO.selectByPK(legalStatusVO);
			    String overrideIdType;
			    if(null == legalStatusVO)
			    {
				overrideIdType = "0";
			    }
			    else
			    {
				overrideIdType = StringUtil.nullEmptyToValue(legalStatusVO.getOVERRIDE_ID_TYPE(), "0");
			    }
			    if("1".equals(overrideIdType) && !Boolean.TRUE.equals(fomCO.getCifIdNumDupFlag()))
			    {
				String[] str = new String[] { fomCO.getCifVO().getID_NO(), returnSimilarIds(fomCO) };
				throw new BOException(MessageCodes.ID_NUMBER_IS_ALREADY_USED_FOR_CIF, str,
					ConstantsCommon.CONFIRM_MSG_TYPE, FomConstant.ID_NUM_DUPLICATION);
			    }
			    else if("0".equals(overrideIdType))
			    {
				throw new BOException(MessageCodes.ID_NUMBER_IS_ALREADY_USED_FOR_CIF, new String[] {
					fomCO.getCifVO().getID_NO(), maxCIF.toString() });
				// throw new
				// BOException(MessageCodes.DUPLICATE_CIVIL_ID,
				// new String[] { fomCO.getCifVO().getID_NO()
				// });
			    }
			} // end if we have legal_status set for CIF

		    } // end if uniqueness=2
		    // fboukarroum IIAB110527 - Document Number Repetition in
		    // CIF END
		    // uniqueness=1
		    String[] msgList = new String[] { valueOfIdNo, " ", "ALREADY_USED_WITH_CIF", " ", maxCIF.toString() };
		    if((uniqueness.equals(NCifMaintenanceConstant.UNIQUNESS_ALLOW_PROCEED)))
		    {
			if(fomCO.getSectionName().equals("Main"))
			{
			    addWarningMessagesList(fomCO, new BigDecimal(MessageCodes.DUPLICATE_CIVIL_ID), msgList,
				    "YESNO");
			}
			else
			{
			    fomCO.getWarningListCode().add(MessageCodes.DUPLICATE_ENTRY_CIVIL_ID);
			}

			HashMap<Integer, String[]> paramMsg = new HashMap<Integer, String[]>();
			paramMsg.put(MessageCodes.DUPLICATE_ENTRY_CIVIL_ID, msgList);
			fomCO.setCtsMsgParam(paramMsg);
			// throw new
			// BOException(MessageCodes.DUPLICATE_CIVIL_ID, new
			// String[] { " ", valueOfIdNo, "ALREADY_USED_WITH_CIF",
			// " ", countCif.toString(),"/",fomCO.getSectionName()
			// }, true);
		    } // end if uniqueness=1
		    // }
		} // end if((countCif >= 1))

	    }
	    }
	    if(NCifMaintenanceConstant.VALIDATE_CID_TRUE.equals(validateCID) && (isCivilId))
	    {
		Date ldDate = new Date();
		fomCO.getCifVO().setID_TYPE(idTypeCodeValue);
		fomCO.getCifVO().setID_NO(valueOfIdNo);
		fomCO.getCifVO().setCOMP_CODE(fomCO.getLoginCompCode());
		returnIDBirthDate(fomCO);
		ldDate = fomCO.getFinalDate();//Hala - TP679780
		if(ldDate == null)
		{
		    ldDate = DateUtil.parseDate("01/01/1900", "dd/mm/yyyy");
		}
		
		// AUBBHU200031 - Issues on FOM Screen falha
		if(ldDate != null
			&& !ldDate.equals(DateUtil.parseDate("01/01/1900", "dd/mm/yyyy")))
		{
		    // cifVO.setBIRTH_DATE(ldDate);
		    checkBirthDate(fomCO);

		    // nCifMaintenanceBO.addActionsToElement(FomElementsConstant.BIRTH_DATE_ID,
		    // "READ_ONLY", BigDecimal.ONE,
		    // elementHashmap);
		}
	    }

	    // if the criteria ApplyUniquenessOnIds is true check if this idno
	    // related to
	    // cif black listed or suspicious
	    // if (fomCO.isApplyBalckListOnIds())
	    // {

	    /*
	     * MosBlackListSC mosBlackListSC = new MosBlackListSC();
	     * mosBlackListSC.setCompCode(compCode);
	     * mosBlackListSC.setlIdType(idTypeCodeValue);
	     * mosBlackListSC.setsType(fomCO.getVtInd());
	     * mosBlackListSC.setsColname("id_no");
	     * mosBlackListSC.setIdNo(valueOfIdNo);
	     * mosBlackListSC.setCifNO(cifNo);
	     * if(fomCO.getCifControlRecordFlag() != null)
	     * mosBlackListSC.setCifControlRecordFlag
	     * (fomCO.getCifControlRecordFlag());
	     * if(fomCO.getCifSuspiciousFlag()!= null)
	     * mosBlackListSC.setCifSuspiciousFlag
	     * (fomCO.getCifSuspiciousFlag()); MosBlackListCO mosBlackListCO =
	     * new MosBlackListCO(); mosBlackListCO = mosBlackListBO.ch
	     * .checkSucpiciousIdBlcklist(mosBlackListSC);
	     */

	    // }

	}

	//Added by Maria Chamieh for SBI170183
	//check if id no belongs to a mandate for an asaan account 
	Integer existIdNo = coreCommonServiceDAO.checkIfExistIdNo(fomCO);
	if(existIdNo > 0) {
	    throw new BOException(MessageCodes.ID_NUMBER_BELONGS_FOR_ASAAN_ACCOUNT);
	}
	//End Maria
    }

    // This function returns 1 if the id type is civil id (pb:uf_check_civil_id)
    public Boolean checkCivilId(ID_TYPESVO idTypesSC, ID_TYPESVO idTypesVO1) throws BaseException
    {
	ID_TYPESVO idTypesVO = idTypesVO1;
	boolean returnValue = false;

	if(idTypesVO == null && !(NumberUtil.isEmptyDecimal(idTypesSC.getCODE())))
	{
	    idTypesSC.setCOMP_CODE(idTypesSC.getCOMP_CODE());
	    idTypesSC.setCODE(idTypesSC.getCODE());
	    idTypesVO = (ID_TYPESVO) genericDAO.selectByPK(idTypesSC);
	}

	String code = "0";
	if(idTypesVO == null)
	{
	    code = "0";// default value of code
	}
	else
	{
	    code = StringUtil.nullEmptyToValue((idTypesVO).getTYPES(), "0");
	}

	if((Integer.parseInt(code)) == (NCifMaintenanceConstant.CIVIL_ID))
	{
	    returnValue = true;

	}
	return returnValue;
    }

    /**
     * this function is used to check if the passed id_no is valid with the
     * data_type of its id_type pb:f_check_data_type fboukarroum 82940 -
     * AMANA110094 - Alpha - Numeric characters in FOM - MORE CONTACT - ID field
     * return Integer of similar CIF_NO seperated by comma
     * 
     * @param fomCO
     * @throws BaseException
     */
    public void checkDataType(String idNo, String dataType) throws BaseException
    {
	if(NCifMaintenanceConstant.ALPHA_DATA_TYPE.equals(dataType)
		&& !StringUtil.isAlpha(idNo, true)
		|| ((NCifMaintenanceConstant.NUMERIC_DATA_TYPE.equals(dataType) || NCifMaintenanceConstant.DEFAULT_DATA_TYPE
			.equals(dataType)) && !NumberUtil.isNumber(idNo))
		|| NCifMaintenanceConstant.ALPHA_NUMERIC_DATA_TYPE.equals(dataType)
			&& !((StringUtil.isAlphaAndNumeric(idNo, true) || NumberUtil.isNumber(idNo)
				|| StringUtil.isAlpha(idNo, true))) // Hala Al
								    // Sheikh -
								    // AMANA130215
	)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_ID_NO);
	}

    }

    /**
     * uf_verify_civil_id PATHTAR060422 for AUB Bank This Function Check the
     * civil ID entered with the parameters defined in Admin It Checks the
     * century the birth year ( in case of a non joint account) and the country
     * code
     */
    public int verifyCivilId(FomCO fomCO, String checkOnjoin) throws BaseException
    {
	// Hala Al Sheikh - ABSAI180070
	ID_CHECK_DIGITVO idCheckDigitVO = new ID_CHECK_DIGITVO();
	idCheckDigitVO.setCOMP_CODE(fomCO.getCifVO().getCOMP_CODE());
	idCheckDigitVO.setID_TYPE(fomCO.getCifVO().getID_TYPE());
	String civilId = StringUtil.nullToEmpty(fomCO.getCivilCodeValue());
	List<ID_CHECK_DIGITVO> idCheckDigitVOs = coreCommonServiceDAO.returnCheckIdDigitsData(idCheckDigitVO);

	for(int i = 0; i < idCheckDigitVOs.size(); i++)
	{

	    if(!"1".equals(StringUtil.nullToEmpty(fomCO.getCifVO().getID_TYPE())))
	    {
		return 1;
	    }
	    
	    // Hasan Bug#403932 19/05/2016 add condition if idCheckDigitVO != null
	    if(idCheckDigitVOs.get(i) != null)
	    {
		// id:889810 Details:System is generating a stoppin message Invalis Entity Type while the same is defined
		if(StringUtil.nullToEmpty(idCheckDigitVOs.get(i).getFIELD1()).equals("N"))
		{
		    continue;
		}
	    
		String field1 = StringUtil.nullToEmpty(idCheckDigitVOs.get(i).getFIELD1());
		String field2 = StringUtil.nullToEmpty(idCheckDigitVOs.get(i).getFIELD2());
		String field3 = StringUtil.nullToEmpty(idCheckDigitVOs.get(i).getFIELD3());
		String field4 = StringUtil.nullToEmpty(idCheckDigitVOs.get(i).getFIELD4());

		BigDecimal frPos1 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getFR_POS1());
		BigDecimal frPos2 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getFR_POS2());
		BigDecimal frPos3 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getFR_POS3());
		BigDecimal frPos4 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getFR_POS4());

		BigDecimal toPos1 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getTO_POS1());
		BigDecimal toPos2 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getTO_POS2());
		BigDecimal toPos3 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getTO_POS3());
		BigDecimal toPos4 = NumberUtil.nullToZero(idCheckDigitVOs.get(i).getTO_POS4());
	
		String subStr1 = "", subStr2 = "", subStr3 = "", subStr4 = "";
		if(frPos1.intValue() > 0 && toPos1.intValue() > 0)
		{
	
		    subStr1 = civilId.substring(frPos1.intValue(), (frPos1.intValue() - toPos1.intValue() + 1));
		}
	
		if(frPos2.intValue() > 0 && toPos2.intValue() > 0 && civilId.length() > (frPos2.intValue() - 1))
		{
		    subStr2 = civilId.substring(frPos2.intValue(), (frPos2.intValue() - toPos2.intValue() + 1));
		}
	
		if(frPos3.intValue() > 0 && toPos3.intValue() > 0 && civilId.length() > (frPos3.intValue() - 1))
		{
		    subStr3 = civilId.substring(frPos3.intValue(), (frPos3.intValue() - toPos3.intValue() + 1));
		}
	
		if(frPos4.intValue() > 0 && toPos4.intValue() > 0 && civilId.length() > (frPos4.intValue() - 1))
		{
		    subStr4 = civilId.substring(frPos4.intValue(), (frPos4.intValue() - toPos4.intValue() + 1));
		}
		


		String century = null;
		if("C".equals(field1)) // Century
		{
		    century = subStr1;
		}
		else if("C".equals(field2))
		{
		    century = subStr2;
		}
		else if("C".equals(field3))
		{
		    century = subStr3;
		}
		else if("C".equals(field4))
		{
		    century = subStr4;
		}

		if(!"1".equals(century) && !"2".equals(century) && !"3".equals(century))
		{
		    return -1;
		}
		String year = "";
		if("0".equals(checkOnjoin)) // check the validity in case the id is join
		{
		    String birthdayYear = DateUtil.getDayYearMonth(fomCO.getCifVO().getBIRTH_DATE(), "Y").toString();
		    String lastTwoDigitsBirthdayYear = birthdayYear.substring(2, 4);

		    if("Y".equals(field1)) // Year
		    {
			century = subStr1;
		    }
		    else if("Y".equals(field2))
		    {
			century = subStr2;
		    }
		    else if("Y".equals(field3))
		    {
			century = subStr3;
		    }
		    else if("Y".equals(field4))
		    {
			century = subStr4;
		    }
		    if(!lastTwoDigitsBirthdayYear.equals(year))
		    {
			return -1;
		    }
		}
		if("G".equals(field1)) // Gender
		{
		    List<ID_CHECK_DIGIT_ALLOWEDVO> idCheckDigitAllowedVOs = coreCommonServiceDAO.returnCheckIdDigitsAllowedData(idCheckDigitVOs.get(i));
		    for(int j = 0; j < idCheckDigitAllowedVOs.size(); j++)
		    {
			BigDecimal genderVal = new BigDecimal(subStr1);
			if((idCheckDigitAllowedVOs.get(j).getFR_POS()).compareTo(genderVal) <= 0
				&& (idCheckDigitAllowedVOs.get(j).getTO_POS()).compareTo(genderVal) >= 0)
			{
			    fomCO.getCifVO().setSEXE(idCheckDigitAllowedVOs.get(j).getFIELD());
			}
		    }
		}
		if("Z".equals(field1)) // Citizenship
		{
		    List<ID_CHECK_DIGIT_ALLOWEDVO> idCheckDigitAllowedVOs = coreCommonServiceDAO.returnCheckIdDigitsAllowedData(idCheckDigitVOs.get(i));
		    Boolean exists = false;
		    for(int j = 0; j < idCheckDigitAllowedVOs.size(); j++)
		    {
			BigDecimal citizenVal = new BigDecimal(subStr1);
			if(citizenVal.equals(new BigDecimal(idCheckDigitAllowedVOs.get(j).getFIELD())))
			{
			    exists = true;
			    continue;
			}
		    }
		    if(!exists)
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_ID_NO);
		    }
		}
		if("T".equals(field1)) // Checksum Digit
		{
		    CifSC cifSC = new CifSC();
		    // cifSC.setChecksumDigit(fomCO.getCifVO().getID_NO());
		    cifSC.setChecksumDigit(fomCO.getCifVO().getID_NO().substring(0, frPos1.intValue() -1)); //ABSAI190561: it should be sent without the check sum variable
		    cifSC = coreCommonProcedureBO.callChecksumDigit(cifSC);
		    BigDecimal checkSum = cifSC.getCode(); //new BigDecimal(cifSC.getChecksumDigit()); //ABSAI190561
		    // ABSAI190561: when the check digit is of size 1 and the returned checksum is >= 10
		    if(checkSum != null && checkSum.compareTo(BigDecimal.TEN) >= 0
			    && ((toPos1.intValue() - frPos1.intValue()) == 0))
		    {
			checkSum = BigDecimal.ZERO;
		    }
		    //
		    if(cifSC == null || (!(checkSum).equals(new BigDecimal(subStr1))))
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_ID_NO);
		    }
		}
	    }
	}
	//End ABSAI180070
	// QCB - Quatar
	if("0".equals(checkOnjoin)
		&& "4".equals(StringUtil.nullToEmpty(fomCO.getCtsControl().getINWARD_OUTWARD_CLR_CHQ())) // CENTRAL
		// BANK
		&& NumberUtil.nullToZero(fomCO.getCifVO().getNATION_CODE()).compareTo(new BigDecimal(
			(StringUtil.nullToEmpty(fomCO.getCivilCodeValue()).toString().substring(3, 4)))) == 0)
	{
	    return -1;
	}

	return 1;
    }

    /**
     * this function is used to validate the uniqueness of id_no
     * pb:f_validate_id_uniqueness fboukarroum IIAB110527 - Document Number
     * Repetition in CIF return maxCIF if there exists a similar CIF_NO (same
     * ID_TYPE and ID_NO)
     * 
     * @param fomCO
     * @throws BaseException
     */
    public Integer validateIdUniqueness(FomCO fomCO, String idNo2, BigDecimal idType2) throws BaseException
    {
	NCifMaintenanceSC nCifMaintenanceSC = new NCifMaintenanceSC();

	PathPropertyUtil.copyProperties(fomCO, nCifMaintenanceSC, "loginCompCode compCode", "cifVO.CIF_NO cifNo",
		"cifVO.ID_NO idNo", "cifVO.ID_NO2 idNo2", "cifVO.ID_TYPE idType", "cifVO.ID_TYPE2 idType2", "compCodeCif compCodeCif", "cifVO.JOIN_ID_TYPE joinIdType", "cifVO.JOIN_ID_NO joinIdNo"); //Rania - BMO180181

	NumberUtil.resetEmptyValues(nCifMaintenanceSC);
	// Bug 336925 -- [John Massaad] -- adding the two parameters
	// (valueOfIdNo, idTypeCodeValue)
	nCifMaintenanceSC.setIdNo2(idNo2.toUpperCase());//Abdo TP#583824-BTII170145-06/11/2017
	nCifMaintenanceSC.setIdType2(idType2);
	// Bug 336925 -- [John Massaad] -- adding the two parameters
	// (valueOfIdNo, idTypeCodeValue)
	nCifMaintenanceSC.setStatusDeleted(NCifMaintenanceConstant.CIF_DELETED);
	nCifMaintenanceSC.setFromValidationOfIdType2(fomCO.getFromValidationOfIdType2());
	nCifMaintenanceSC.setEnableUniquenessByCifTypeOnly(fomCO.getIdTypesVO().getENABLE_UNIQUE_BY_CIF_TYPE_YN()); //Rania - BMO180181
	nCifMaintenanceSC.setCifType(fomCO.getCifVO().getCIF_TYPE()); //Rania - BMO180181
	
	Integer maxCif = coreCommonServiceDAO.validateIdUniqueness(nCifMaintenanceSC);
	if(null != maxCif) // not unique
	{
	    String uniqueness = StringUtil.nullEmptyToValue(fomCO.getIdTypessVO().get(fomCO.getCivilCodeField())
		    .getUNIQUENESS(), "0");
	    if("1".equals(uniqueness))
	    {
		addWarningMessagesList(fomCO, new BigDecimal(MessageCodes.ID_NUMBER_IS_ALREADY_USED_FOR_CIF),
			new String[] { fomCO.getCifVO().getID_NO().toString(), maxCif.toString() }, null);
	    }
	}
	return maxCif;
    }

    /**
     * this function is used to get the similar CIF_NO's with same ID_TYPE and
     * ID_NO pb:f_check_cif_similar_id fboukarroum IIAB110527 - Document Number
     * Repetition in CIF return string of similar CIF_NO seperated by comma
     * 
     * @param fomCO
     * @throws BaseException
     */
    public String returnSimilarIds(FomCO fomCO) throws BaseException
    {
	StringBuffer sb = new StringBuffer();
	FomSC fomSC = new FomSC();
	PathPropertyUtil.copyProperties(fomCO, fomSC, "loginCompCode compCode", "cifVO.CIF_NO cifNo",
		"cifVO.ID_NO idNo", "cifVO.ID_NO2 idNo2", "cifVO.ID_TYPE idType", "cifVO.ID_TYPE2 idType2", "cifVO.JOIN_ID_TYPE joinIdType", "cifVO.JOIN_ID_NO joinIdNo"); //Rania - BMO180181
	fomSC.setStatusDeleted(FomConstant.STATUS_DELETED);
	fomSC.setEnableUniquenessByCifTypeOnly(fomCO.getIdTypesVO().getENABLE_UNIQUE_BY_CIF_TYPE_YN());//Rania - BMO180181
	List<FomCO> similarCifs = coreCommonServiceDAO.similarIdsPopupList(fomSC);
	for(FomCO fomCO1 : similarCifs)
	{
	    sb.append(fomCO1.getCifVO().getCIF_NO().toString()).append(",");
	}
	return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).toString();
    }

    public void returnIDBirthDate(FomCO fomCO) throws BaseException
    {
	String year = null, month = null, day = null, century, yearPrefix = null;
	String subStr1 = "", subStr2 = "", subStr3 = "", subStr4 = "";
	Date finalDate = null;
	BigDecimal idType = fomCO.getCifVO().getID_TYPE();
	BigDecimal compCode = NumberUtil.nullToZero(fomCO.getCifVO().getCOMP_CODE());
	String idNO = StringUtil.nullToEmpty(fomCO.getCifVO().getID_NO());
	
	ID_CHECK_DIGITVO idCheckDigitVO = new ID_CHECK_DIGITVO();

	if(idType != null)
	{
	    idCheckDigitVO.setCOMP_CODE(compCode);
	    idCheckDigitVO.setID_TYPE(idType);
	//    idCheckDigitVO.setLINE_NO(BigDecimal.ONE); //Hala Al Sheikh - TP990832 
	    idCheckDigitVO = (ID_CHECK_DIGITVO) genericDAO.selectByPK(idCheckDigitVO);
	}
	if(null != idCheckDigitVO)
	{
	    String field1 = StringUtil.nullToEmpty(idCheckDigitVO.getFIELD1());
	    String field2 = StringUtil.nullToEmpty(idCheckDigitVO.getFIELD2());
	    String field3 = StringUtil.nullToEmpty(idCheckDigitVO.getFIELD3());
	    String field4 = StringUtil.nullToEmpty(idCheckDigitVO.getFIELD4());

	    if("N".equals(field1) && "N".equals(field2) && "N".equals(field3) && "N".equals(field4))
	    {
		idCheckDigitVO.setCOMP_CODE(compCode);
		idType = NumberUtil.nullToZero(idType);
		idCheckDigitVO.setID_TYPE(idType);
//		idCheckDigitVO.setLINE_NO(BigDecimal.ONE); //Hala Al Sheikh - TP990832 
		idCheckDigitVO = (ID_CHECK_DIGITVO) genericDAO.selectByPK(idCheckDigitVO);
		if(fomCO.getCifVO().getBIRTH_DATE() != null)
		{
		    fomCO.setFinalDate(fomCO.getCifVO().getBIRTH_DATE());		    
		}
	    }

	    BigDecimal frPos1 = NumberUtil.nullToZero(idCheckDigitVO.getFR_POS1());
	    BigDecimal frPos2 = NumberUtil.nullToZero(idCheckDigitVO.getFR_POS2());
	    BigDecimal frPos3 = NumberUtil.nullToZero(idCheckDigitVO.getFR_POS3());
	    BigDecimal frPos4 = NumberUtil.nullToZero(idCheckDigitVO.getFR_POS4());

	    BigDecimal toPos1 = NumberUtil.nullToZero(idCheckDigitVO.getTO_POS1());
	    BigDecimal toPos2 = NumberUtil.nullToZero(idCheckDigitVO.getTO_POS2());
	    BigDecimal toPos3 = NumberUtil.nullToZero(idCheckDigitVO.getTO_POS3());
	    BigDecimal toPos4 = NumberUtil.nullToZero(idCheckDigitVO.getTO_POS4());

	    if(!"N".equals(field1) && !"N".equals(field2) && !"N".equals(field3) && !"N".equals(field4) && (NumberUtil.nullToZero(frPos1).intValue() == 0 || NumberUtil.nullToZero(frPos2).intValue() == 0  || NumberUtil.nullToZero(frPos3).intValue() == 0  
		    || NumberUtil.nullToZero(frPos4).intValue() == 0 || NumberUtil.nullToZero(toPos1).intValue() == 0  || NumberUtil.nullToZero(toPos2).intValue() == 0 
		    || NumberUtil.nullToZero(toPos3).intValue() == 0  || NumberUtil.nullToZero(toPos4).intValue() == 0 ))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "id_digits_key" });
	    }
	    //Hala - BUG 684961
	    if(frPos1.intValue() > 0 && toPos1.intValue() > 0)
	    {
		subStr1 = idNO.substring(frPos1.intValue() - 1, toPos1.intValue() );
	    }

	    if(frPos2.intValue() > 0 && toPos2.intValue() > 0 && idNO.length() > (frPos2.intValue() - 1))
	    {
		subStr2 = idNO.substring(frPos2.intValue() - 1, toPos2.intValue() );
	    }

	    if(frPos3.intValue() > 0 && toPos3.intValue() > 0 && idNO.length() > (frPos3.intValue() - 1))
	    {
		subStr3 = idNO.substring(frPos3.intValue() - 1, toPos3.intValue() );
	    }

	    if(frPos4.intValue() > 0 && toPos4.intValue() > 0 && idNO.length() > (frPos4.intValue() - 1))
	    {
		subStr4 = idNO.substring(frPos4.intValue() - 1, toPos4.intValue() );
	    }

	    if("Y".equals(field1))
	    {
		year = subStr1;
	    }
	    else if("M".equals(field1))
	    {
		month = subStr1;
	    }
	    else if("D".equals(field1))
	    {
		day = subStr1;
	    }
	    else if("C".equals(field1))
	    {
		century = subStr1;
		if("3".equalsIgnoreCase(century))
		{
		    yearPrefix = "20";
		}
		else
		{
		    yearPrefix = "19";
		}
	    }

	    if("Y".equals(field2))
	    {
		year = subStr2;
	    }
	    else if("M".equals(field2))
	    {
		month = subStr2;
	    }
	    else if("D".equals(field2))
	    {
		day = subStr2;
	    }
	    else if("C".equals(field2))
	    {
		century = subStr2;
		if("3".equalsIgnoreCase(century))
		{
		    yearPrefix = "20";
		}
		else
		{
		    yearPrefix = "19";
		}
	    }

	    if("Y".equals(field3))
	    {
		year = subStr3;
	    }
	    else if("M".equals(field3))
	    {
		month = subStr3;
	    }
	    else if("D".equals(field3))
	    {
		day = subStr3;
	    }
	    else if("C".equals(field3))
	    {
		century = subStr3;
		if("3".equalsIgnoreCase(century))
		{
		    yearPrefix = "20";
		}
		else
		{
		    yearPrefix = "19";
		}
	    }

	    if("Y".equals(field4))
	    {
		year = subStr4;
	    }
	    else if("M".equals(field4))
	    {
		month = subStr4;
	    }
	    else if("D".equals(field4))
	    {
		day = subStr4;
	    }
	    else if("C".equals(field4))
	    {
		century = subStr4;
		if("3".equalsIgnoreCase(century))
		{
		    yearPrefix = "20";
		}
		else
		{
		    yearPrefix = "19";
		}
	    }

	    if(!StringUtil.isNotEmpty(yearPrefix))
	    {
		yearPrefix = "19";
	    }
	    year = StringUtil.nullToEmpty(year);
	    if(year.length() == 2)
	    {
		year = (new StringBuffer(yearPrefix)).append(year).toString();
	    }
	    if(year.length() > 1)
	    {
		//Hala - TP679780
		if(StringUtil.isNotEmpty(month) && StringUtil.isNotEmpty(day) && StringUtil.isNotEmpty(year))
		{
		    String date = (new String(month)) + "/" + (new String(day)) + "/" + (new String(year));
    		    if(!DateUtil.isValidDate(date))
    		    {
    			throw new BOException(MessageCodes.INVALID_MISSING_DATE);
    		    }
		    fomCO.setFinalDate(DateUtil.createDate(Integer.parseInt(year), Integer.parseInt(month) -1, Integer.parseInt(day)));
		}
	    }
	}
    }
    
    /**
     * this function is used to get the mesg code and add it list of exceptions
     * 
     * @param fomCO
     * @param msgCode
     * @param infoType
     */
    public void addWarningMessagesList(FomCO fomCO, BigDecimal msgCode, String infoType)
    {
	if((!fomCO.getCifGlobalConfirmFlag()) && (!fomCO.getCifReservedConfirmFlag())
		&& NumberUtil.nullToZero(msgCode).intValue() > 0)
	{
	    BaseException baseEx = null;
	    baseEx = new BaseException(msgCode.intValue());

	    if((!fomCO.getCifGlobalConfirmFlag()) && (!fomCO.getCifReservedConfirmFlag()))
	    {
		fomCO.getWarningMessagesList().add(baseEx);
	    }
	}
    }

    /**
     * this function is used to get the mesg code and the param dynamic add it
     * list of exceptions
     * 
     * @param fomCO
     * @param msgCode
     * @param infoType
     */
    public void addWarningMessagesList(FomCO fomCO, BigDecimal msgCode, String[] msgParam, String infoType)
    {
	if((!fomCO.getCifGlobalConfirmFlag()) && (!fomCO.getCifReservedConfirmFlag())
		&& NumberUtil.nullToZero(msgCode).intValue() > 0)
	{
	    BaseException baseEx = null;
	    baseEx = new BaseException(msgCode.intValue(), msgParam);

	    if((!fomCO.getCifGlobalConfirmFlag()) && (!fomCO.getCifReservedConfirmFlag()))
	    {
		fomCO.getWarningMessagesList().add(baseEx);

	    }
	}
    }

    public FomCO checkBirthDate(FomCO fomCO) throws BaseException
    {
	//Hala - TP679780
	String civilCodeField = fomCO.getCivilCodeField();
	BigDecimal idTypeCodeValue = NumberUtil.nullToZero(fomCO.getIdTypeValue());
	ID_TYPESVO idtypesVO = new ID_TYPESVO();
	idtypesVO.setCOMP_CODE(fomCO.getLoginCompCode());
	idtypesVO.setCODE(idTypeCodeValue);

	Boolean isCivilId = checkCivilId(idtypesVO, fomCO.getIdTypessVO().get(civilCodeField));
	String validateCID = "0";
	if(fomCO.getRifCttVO() == null || NumberUtil.isEmptyDecimal(fomCO.getRifCttVO().getTYPE_CODE()))
	{
	    RIFCTTVO rifCttVO = new RIFCTTVO();
	    rifCttVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    rifCttVO.setTYPE_CODE(fomCO.getCifVO().getCIF_TYPE());
	    fomCO.setRifCttVO((RIFCTTVO) genericDAO.selectByPK(rifCttVO));
	}
	
	validateCID = StringUtil.nullEmptyToValue(fomCO.getRifCttVO().getVALIDATE_CID(), "0");

	fomCO.setFnIdentifier("verifyBirthDate");
	fomCO.setLoginCompCode(fomCO.getLoginCompCode());
	fomCO.setIdType(fomCO.getCifVO().getID_TYPE());
	if(NCifMaintenanceConstant.VALIDATE_CID_TRUE.equals(validateCID) && (isCivilId))
	{
	    checkIdDigits(fomCO);
	    fomCO.getCifVO().setBIRTH_DATE(fomCO.getFinalDate());
	}
	//
	CIFVO cifVO = fomCO.getCifVO();
	if(cifVO != null)
	{
	    Date birthDate = cifVO.getBIRTH_DATE();
	    if(birthDate != null)
	    {
		if(DateUtil.parseDate("01/01/1880", "dd/mm/yyyy").compareTo(birthDate) > 0
			|| fomCO.getRunningDate().compareTo(birthDate) <= 0)
		{
		    throw new BOException(MessageCodes.INVALID_DATE);
		}
		Date idDeliveryDate = cifVO.getID_DELIVERY_DATE();
		if(idDeliveryDate != null
			&& idDeliveryDate.compareTo(DateUtil.parseDate("01/01/1900", "dd/mm/yyyy")) > 0
			&& idDeliveryDate.compareTo(birthDate) < 0)
		{
		    String msgParm = returnLableOfBirthdate(fomCO);
		    throw new BOException(MessageCodes.SHOULD_BE_LESS_THAN_OR_EQUAL_TO, new String[] { msgParm,
			    "ID_Delivery_Date_key" });
		}

		if(cifVO.getCIF_TYPE() != null)
		{
		    StringBuffer warningMessagesBuf = new StringBuffer();
		    String warningMessages = "";
		    CifTypeSC cifTypeSC = new CifTypeSC();
		    cifTypeSC.setCompCode(fomCO.getLoginCompCode());
		    cifTypeSC.setCifTypeCode(cifVO.getCIF_TYPE());
		    cifTypeSC.setNoExceptionMsg("1");
		    cifTypeSC.setRunningDate(fomCO.getRunningDate());
		    ResultCO result = coreCommonBO.checkCifAge(birthDate, cifTypeSC);

		    if(result.getIntegerResut() != null && result.getIntegerResut() > 0
			    && !ConstantsCommon.WARNING_INFO_MSG_TYPE.equals(result.getIntegerMsgType()))
		    {
			// in case of error we should not sent the message type
			// (according to method handleException in BaseAction
			// class)
			Integer messageType = result.getIntegerMsgType();
			if(Integer.valueOf(ConstantsCommon.ERROR_MSG_TYPE).equals(messageType))
			{
			    messageType = null;
			}
			throw new BOException(result.getIntegerResut(), messageType);
		    }
		    else if(result.getIntegerResut() != null && result.getIntegerResut() > 0)
		    {
		    	//Bug #338150 -- [John Massaad] sending fomCO.getLanguage() rather than the preffered language
			 //added new String[]{""} by bahaa for #BUG 680315
				warningMessagesBuf.append("\n" + commonLibBO.returnTranslErrorMessage(result.getIntegerResut(),new String[]{""},fomCO.getLanguage()));
			warningMessages = warningMessagesBuf.toString();
			fomCO.setWarngMessages(warningMessages);

		    }
		    // fomCO.getCifVO().setBIRTH_DATE(fomCO.getFinalDate());
		    // Hala Al Sheikh - AMANA130215
		    if("1".equals(fomCO.getRifCttVO().getDISABLE_MARITAL_STATUS_YN())
			    && MessageCodes.AGE_LESS_MINIMUM_AGE == result.getIntegerResut())
		    {
			addActionToFOMElement(FomElementsConstant.MARITAL_STATUS_ID,
				ConstantsCommon.ACTION_TYPE_READONLY, BigDecimal.ONE, fomCO);
			addActionToFOMElement(FomElementsConstant.MARITAL_STATUS_ID, ConstantsCommon.ACTION_TYPE_VALUE,
				"S", fomCO);
		    }
		}
	    }
	}
	return fomCO;
    }

    /**
     * this function return either birhdate or Establishment Date based on two
     * input paramters 1-if the cif type is bank or not 2-if the cif type is
     * client or instutation
     * 
     * @param fomCO
     * @return
     * @throws BaseException
     */
    public String returnLableOfBirthdate(FomCO fomCO) throws BaseException
    {
	String returnLabel = "Date_of_Birth_key";
	if(fomCO.getRifCttVO() != null)
	{
	    String bank = StringUtil.nullEmptyToValue(fomCO.getRifCttVO().getBANK(), "N");
	    String type = StringUtil.nullToEmpty(fomCO.getCifVO().getTYPE());

	    if(type.equals(NCifMaintenanceConstant.CIF_IS_INDIVIDUAL)
		    && bank.equals(NCifMaintenanceConstant.CIF_NOT_BANK))
	    {
		returnLabel = "Date_of_Birth_key";
	    }
	    else if(type.equals(NCifMaintenanceConstant.CIF_IS_INDIVIDUAL)
		    && bank.equals(NCifMaintenanceConstant.CIF_IS_BANK))
	    {
		returnLabel = "Establishment_Date_key";
	    }
	    else if(type.equals(NCifMaintenanceConstant.CIF_IS_INSTITUTION)
		    && bank.equals(NCifMaintenanceConstant.CIF_IS_BANK))
	    {
		returnLabel = "Establishment_Date_key";
	    }
	    else if(type.equals(NCifMaintenanceConstant.CIF_IS_INSTITUTION)
		    && bank.equals(NCifMaintenanceConstant.CIF_NOT_BANK))
	    {
		returnLabel = "Establishment_Date_key";
	    }
	}
	return returnLabel;
    }

    /**
     * TP 324728 -- [John Massaad] Enhance the checking on the US Passport This
     * method is used to check if the selected IdType is passport("3") so ti
     * shows the related countryOfIssuance if not it hides it It is called on
     * dependency event of idType and on load, new, double click event of the
     * gird. Note that this method is also called when the idType value is
     * defaulted form another dependency such case is the case of the dependency
     * of cifNo inside some popups like MoreSignatory,RealBeneficiary,Ownership
     * Details, JointAccdetails
     */
    public FomCO checkPassportIDType(FomCO fomCO) throws BaseException
    {
	BigDecimal idType = NumberUtil.emptyDecimalToNull(fomCO.getIdType());

	BigDecimal idType2 = NumberUtil.emptyDecimalToNull(fomCO.getIdType2());

	String countryOfIssuanceIDName = fomCO.getCountryOfIssuanceIDName();
	String countryOfIssuanceDescIDName = fomCO.getCountryOfIssuanceDescIDName();

	ID_TYPESVO idTypesVO = new ID_TYPESVO();
	ID_TYPESVO idTypesVO1 = new ID_TYPESVO();

	if(idType != null)
	{
	    idTypesVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    idTypesVO.setCODE(idType);
	    idTypesVO = (ID_TYPESVO) genericDAO.selectByPK(idTypesVO);
	}

	if(idType2 != null)
	{
	    idTypesVO1.setCOMP_CODE(fomCO.getLoginCompCode());
	    idTypesVO1.setCODE(idType2);
	    idTypesVO1 = (ID_TYPESVO) genericDAO.selectByPK(idTypesVO1);
	}

	// //in case it is calling from gridId ( country of issuance must be
	// readonly not hidden in case of the idType is not passport)
	// if("true".equals(fomCO.getFromGrid())) //NB: here need to set
	// manually the syspramScreenDisplay afterdepenedency by getting the
	// HashMap..
	// //see CommmonFunc.js->
	// applyAdditionalDynamicDisplay(data["additionalScreenParams"]); //line
	// 289
	// {
	// // visibility and madatory management of country Of Issuance
	// if((idTypesVO != null && "3".equals(idTypesVO.getTYPES()))
	// || (idTypesVO1 != null && "3".equals(idTypesVO1.getTYPES())))
	// {
	// //
	// nCifMaintenanceBO.addActionToFOMElement(countryOfIssuanceIDName,
	// ConstantsCommon.ACTION_TYPE_READONLY,
	// BigDecimal.ZERO, fomCO);
	// nCifMaintenanceBO.addActionToFOMElement(countryOfIssuanceIDName,
	// ConstantsCommon.ACTION_TYPE_MANDATORY,
	// BigDecimal.ONE, fomCO);
	// }
	// else
	// {
	// nCifMaintenanceBO.addActionToFOMElement(countryOfIssuanceIDName,
	// ConstantsCommon.ACTION_TYPE_READONLY,
	// BigDecimal.ONE, fomCO);
	// nCifMaintenanceBO.addActionToFOMElement(countryOfIssuanceIDName,
	// ConstantsCommon.ACTION_TYPE_VALUE,
	// null, fomCO);
	// nCifMaintenanceBO.addActionToFOMElement(countryOfIssuanceDescIDName,
	// ConstantsCommon.ACTION_TYPE_VALUE,
	// null, fomCO);
	// nCifMaintenanceBO.addActionToFOMElement(countryOfIssuanceIDName,
	// ConstantsCommon.ACTION_TYPE_MANDATORY,
	// BigDecimal.ZERO, fomCO);
	//
	// }
	//
	// }
	// else
	// {
	// visibility and madatory management of country Of Issuance
	if((idTypesVO != null && "3".equals(idTypesVO.getTYPES()))
		|| (idTypesVO1 != null && "3".equals(idTypesVO1.getTYPES())))
	{
	    //
	    addActionToFOMElement(countryOfIssuanceIDName, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ONE, fomCO);
	    addActionToFOMElement(countryOfIssuanceIDName, ConstantsCommon.ACTION_TYPE_MANDATORY, BigDecimal.ONE, fomCO);
	}
	else
	{
	    addActionToFOMElement(countryOfIssuanceIDName, ConstantsCommon.ACTION_TYPE_VISIBLE, BigDecimal.ZERO, fomCO);
	    addActionToFOMElement(countryOfIssuanceIDName, ConstantsCommon.ACTION_TYPE_VALUE, null, fomCO);
	    addActionToFOMElement(countryOfIssuanceDescIDName, ConstantsCommon.ACTION_TYPE_VALUE, null, fomCO);
	    addActionToFOMElement(countryOfIssuanceIDName, ConstantsCommon.ACTION_TYPE_MANDATORY, BigDecimal.ZERO,
		    fomCO);

	}
	// }
	fomCO.setIdType(null);
	fomCO.setIdType2(null);
	fomCO.setCountryOfIssuanceIDName(null);
	fomCO.setCountryOfIssuanceDescIDName(null);
	return fomCO;
    }

    /**
     * Adding business rules to the HashMap to CIF Screen
     * 
     * @param elementId
     * @param elementName
     * @param actionType
     * @param value
     * @param fomCO
     * @throws BaseException
     */
    public FomCO addActionToFOMElement(String elementId, String elementName, String actionType, Object value1,
	    FomCO fomCO) throws BaseException
    {
	Object value = value1;
	RequiredFieldsSC criteria = new RequiredFieldsSC();
	criteria.setAppName(fomCO.getAppName());
	criteria.setLangCode(fomCO.getLanguage());
	criteria.setProgRef((null == fomCO.getOpt()) ? FomConstant.MAINTENANCE_OPT : fomCO.getOpt());
	criteria.setCompCode(fomCO.getLoginCompCode());
	
//	criteria.setEntityType(ConstantsCommon.ENTITY_CIF_TYPE_LOV);
	
	Map<String,Object> hm = new HashMap<String,Object>();
	
	hm.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, fomCO.getCifVO().getCIF_TYPE());
	hm.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV,fomCO.getAddressCommonCO().getCOUNTRY());
	//added by bilal for BMO190095
	hm.put(ConstantsCommon.ENTITY_RANKING_LOV, fomCO.getCifVO().getPRIORITY_CODE());	
    hm.put(ConstantsCommon.ENTITY_CIF_NO_LOV,fomCO.getAddressCommonCO().getCIF_NO());
	criteria.setEntityTypeInfosMap(hm);
	
 	if(!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_TYPE()))
 	{
 	   criteria.setCifType(fomCO.getCifVO().getCIF_TYPE());
 	}
 	if(!NumberUtil.isEmptyDecimal(fomCO.getAddressCommonCO().getCOUNTRY()))
 	{
 	   criteria.setCountryId(fomCO.getAddressCommonCO().getCOUNTRY());
 	    
 	}
	
	
	criteria.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_CIF_TYPE_DISPLAY, fomCO.getCifVO().getCIF_TYPE());
	criteria.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, fomCO.getCifVO().getCIF_TYPE());
	if(fomCO.getCifVO().getTYPE()==null)
	{
	    criteria.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_VT_TYPE_DISPLAY, "V");
	    //requiredFieldsSC.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_VT_TYPE_LOV, fomCO.getCifVO().getTYPE());
	}
	else
	{
	    criteria.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_VT_TYPE_DISPLAY, fomCO.getCifVO().getTYPE());
	    //requiredFieldsSC.getEntityTypeInfosMap().put(ConstantsCommon.ENTITY_VT_TYPE_LOV, fomCO.getCifVO().getTYPE());
	}
	if(!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_TYPE()))
	{
	    criteria.setCifType(fomCO.getCifVO().getCIF_TYPE());
	}
	if(!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_NO()))
	{
	    criteria.setCifNo(fomCO.getCifVO().getCIF_NO());
	}
	
	applyDynScreenDisplay(elementId, elementName, actionType, null == value ? null : value.toString(), fomCO
		.getBuisnessElement(), criteria);
	return fomCO;
    }

    public FomCO addActionToFOMElement(String element, String actionType, Object value1, FomCO fomCO)
	    throws BaseException
    {
	Object value = value1;
	String elementId = null, elementName = null;
	if(null == element || element.indexOf(".") == -1)
	{
	    elementId = element;
	    elementName = FomElementsConstant.cifTypeAllFieldList().get(element);
	}
	else
	{
	    elementName = element;
	}
	if(null == value)
	{
	    value = "";
	}
	addActionToFOMElement(elementId, elementName, actionType, value.toString(), fomCO);
	return fomCO;
    }

    /**
     * Adding business rules to the HashMap to CIF Screen
     * 
     * @param List elementId
     * @param elementName
     * @param actionType
     * @param value
     * @throws BaseException
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> addActionToFOMElement(List<String> elementsList,
	    String actionType, Object value1, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo)
	    throws BaseException
    {
	Object value = value1;
	return applyDynScreenDisplay(elementsList.toArray(new String[elementsList.size()]), actionType, value
		.toString(), businessMapToApplyTo, null);
    }

    /**
     * Adding business rules to the HashMap to CIF Screen
     * 
     * @param elementId
     * @param elementName
     * @param actionType
     * @param value
     * @throws BaseException
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> addActionToFOMElement(String elementId, String elementName,
	    String actionType, Object value1, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo)
	    throws BaseException
    {
	Object value = value1;
	return applyDynScreenDisplay(elementId, elementName, actionType, value.toString(), businessMapToApplyTo, null);
    }

    public FomCO fillCifControlDetails(FomCO fomCO) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(fomCO.getLoginCompCode());
	fomCO.setCifControlVO(commonLibBO.returnCifControlDetails(cifControlVO));
	return fomCO;
    }

    /**
     * this function check the legh of id no based on idtypes table legnh or CIF
     * control(in case the id is related to civil id and no definition in id
     * types(.
     * 
     * @param fomCO
     * @throws BaseException
     */
    public void validateLegnhIdNo(FomCO fomCO) throws BaseException
    {

	BigDecimal fromLen;
	BigDecimal toLen;
	String idNO = StringUtil.nullToEmpty(fomCO.getCivilCodeValue());

	// String idNO4 =StringUtil.nullToEmpty(fomCO.getCifVO().getID_NO());
	ID_TYPESVO idTypesVO = fomCO.getIdTypesVO();
	fromLen = NumberUtil.nullToZero(fomCO.getIdTypesVO().getFROM_LEN());
	toLen = NumberUtil.nullToZero(fomCO.getIdTypesVO().getTO_LEN());

	boolean civilID = checkCivilId(idTypesVO, null);

	if((NumberUtil.isNumberPositive(fromLen)) || (NumberUtil.isNumberPositive(toLen)))
	{
	    if(idNO.trim().length() < NumberUtil.toInt(fromLen) || idNO.trim().length() >

	    NumberUtil.toInt(toLen))
	    {
		throw new BOException(MessageCodes.LENGTH_OF_ID_NO_SHOULD_BE_BETWEEN_PARAM1_AND_PARAM2, new String[] {
			fromLen.toString(), toLen.toString() });
	    }
	}
	else if(civilID && !checkCIDLength(fomCO))
	{
	    throw new BOException(MessageCodes.ID_LENGHT_SHOULD_BE_EQUAL_TO_NUMBERS, new String[] { fomCO
		    .getCifControlVO().getCID_LENGH().toString() });
	}
	// ///////////////////////////////////////////////////////////////////////////////////////
    }

    // CIFCONTROL.CID_LENGH if equal then return true
    public Boolean checkCIDLength(FomCO fomCO) throws BaseException
    {

	// CHECK WITH Jihad in case of dynamic messages what is the prcedure to
	// handle them
	// message code 2052
	// [rk] this method check the idNo string length compared to
	// CIFCONTROL.CID_LENGH if equal then return true
	// [rk] if the method returned false then raise BoException with
	// (2052,new String[]{idNo}, lang) as argument
	CIFCONTROLVO cifControlVO = fomCO.getCifControlVO();
	if(cifControlVO == null)
	{
	    cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	}

	String idNO = StringUtil.nullToEmpty(fomCO.getCivilCodeValue());

	BigDecimal cidLength;
	cidLength = NumberUtil.nullToZero(cifControlVO.getCID_LENGH());

	if((idNO.length() != NumberUtil.toInt(cidLength)) && NumberUtil.toInt(cidLength) > 0)
	{

	    return false;
	}
	else
	{
	    return true;
	}
    }

    /**
     * This function sets the charges policy based on currency of from account
     * and transaction currency replaces n_transaction.uf_get_charges_cy_policy
     * 
     * @return String
     * @param trxMgntCO
     * @throws BaseException
     */
    public String getChargesCyPolicy(TrxMgntCO trxMgntCO) throws BaseException
    {
	String policy;

	if(NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_AC_CY())
		|| trxMgntCO.getBaseCurrencyCode().equals(trxMgntCO.getCtstrsVO().getTRS_AC_CY()))
	{
	    if(trxMgntCO.getCtstrsVO().getTRS_CY() != null && trxMgntCO.getBaseCurrencyCode() != null
		    && trxMgntCO.getBaseCurrencyCode().compareTo(trxMgntCO.getCtstrsVO().getTRS_CY()) == 0)
	    {
		/*
		 * Base/Base
		 */
		policy = "BB";
	    }
	    else
	    {
		/*
		 * Base/Foreign
		 */
		policy = "BF";
	    }
	}
	else
	{
	    if(NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_CY())
		    || trxMgntCO.getCtstrsVO().getTRS_CY().equals(trxMgntCO.getBaseCurrencyCode()))
	    {
		/*
		 * Foreign/Base
		 */
		policy = "FB";
	    }
	    else
	    {
		if(trxMgntCO.getCtstrsVO().getTRS_CY().equals(trxMgntCO.getCtstrsVO().getTRS_AC_CY()))
		{
		    /*
		     * Foreign/Foreign Same
		     */
		    policy = "FFS";
		}
		else
		{
		    /*
		     * Foreign/Foreign Different
		     */
		    policy = "FFD";
		}
	    }
	}
	return policy;
    }

    public AddressCommonCO checkAddressCountry(AddressCommonCO addressCommonCO) throws BaseException
    {
	// EWBI160173 -- [falha]
	RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC();
	requiredFieldsSC.setCifType(addressCommonCO.getCifVO().getCIF_TYPE());
	
	//EWBI160173 -- [John Massaad]
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	
	
	requiredFieldsSC.setCountryId(addressCommonCO.getCOUNTRY());
	requiredFieldsSC.setCompCode(addressCommonCO.getCOMP_CODE());
	requiredFieldsSC.setBranchCode(addressCommonCO.getBRANCH_CODE());
	requiredFieldsSC.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	requiredFieldsSC.setLoginUserId(addressCommonCO.getLoginUserId());
	requiredFieldsSC.setAppName(addressCommonCO.getAppName());
	requiredFieldsSC.setProgRef(FomConstant.PARENT_OPT);

	Map<String, Object> entityTypeInfosMap = new HashMap<String, Object>();
	entityTypeInfosMap.put(ConstantsCommon.ENTITY_COUNTRY_ID_LOV, addressCommonCO.getCOUNTRY());
	entityTypeInfosMap.put(ConstantsCommon.ENTITY_CIF_TYPE_LOV, addressCommonCO.getCifVO().getCIF_TYPE());
	entityTypeInfosMap.put(ConstantsCommon.ENTITY_RANKING_LOV, addressCommonCO.getCifVO().getPRIORITY_CODE());//by bilal for BMO190095
entityTypeInfosMap.put(ConstantsCommon.ENTITY_CIF_NO_LOV, addressCommonCO.getCifVO().getCIF_NO());
	
requiredFieldsSC.setEntityTypeInfosMap(entityTypeInfosMap);
	if(NumberUtil.nullToZero(addressCommonCO.getCifVO().getCIF_NO()).compareTo(BigDecimal.ZERO) == 1)
	{
	    requiredFieldsSC.setCifNo(addressCommonCO.getCifVO().getCIF_NO());
	}
	
	if("true".equals(addressCommonCO.getFromDependency()))//DASI180068
	{
	    String[] neededEntities = new String[]{"countryId"};
	    requiredFieldsSC.setNeededEntities(neededEntities);
	}

	//calling the MapRequiredData method in order to retrieve all the controls form the db
	elementHashmap =  commonLibBO.returnMapRequiredData(requiredFieldsSC);

	// get CTSCONTROLS Details
	CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	ctsControlVO.setCOMP_CODE(addressCommonCO.getCOMP_CODE());
	ctsControlVO.setBRANCH_CODE(addressCommonCO.getBRANCH_CODE());
	addressCommonCO.setCtsControl(commonLibBO.returnCtsControlDetails(ctsControlVO));

	// get CIFCONTROLVO Details
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(addressCommonCO.getCOMP_CODE());
	addressCommonCO.setCifControlVO(commonLibBO.returnCifControlDetails(cifControlVO));

	// calling initialiseAddressVisibility in order to check and apply
	// controls from CSM ADMIN
	addressCommonCO.setBuisnessElement(elementHashmap);
	addressCommonCO.setCifVO(addressCommonCO.getCifVO());
	addressCommonCO.setCifControlVO(addressCommonCO.getCifControlVO());
	addressCommonCO.setCtsControl(addressCommonCO.getCtsControl());

	elementHashmap = addressBO.initialiseAddressVisibility(addressCommonCO);
	// EWBI160173 -- [falha]
	
	elementHashmap.get("addressCO_ADDRESS_DESC");
	
	elementHashmap.get("addressCO_CONTACT_NAME");
	
	if(!"1".equals(addressCommonCO.getAddrScreenMode())) //Rania - BMO180181
	{
		addActionToFOMElement(Arrays.asList(FomElementsConstant.REGION_ID, FomElementsConstant.POBOX_AREA_ID,
				FomElementsConstant.CITY_CODE_ID, FomElementsConstant.SECTOR_CODE_ID,
				FomElementsConstant.POSTAL_CODE_ID, FomElementsConstant.REGION_DESC_ID,
				FomElementsConstant.POBOX_AREA_DESC_ID, FomElementsConstant.CITY_DESC_ID,
				FomElementsConstant.SECTOR_DESC_ID, FomElementsConstant.POSTAL_CODE_DESC_ID,
				FomElementsConstant.MOBILE_ID, FomElementsConstant.TEL_ID, FomElementsConstant.WORK_TEL_ID,
				FomElementsConstant.OTHER_TEL_ID, FomElementsConstant.FAX_ID,

				FomElementsConstant.REFERENCES_TEL_ID + "_" + addressCommonCO.getOpt(),
				FomElementsConstant.REFERENCES_TELEX_ID + "_" + addressCommonCO.getOpt(),
				FomElementsConstant.REFERENCES_FAX_ID + "_" + addressCommonCO.getOpt()),
				ConstantsCommon.ACTION_TYPE_VALUE, "", elementHashmap);
	}
	

	BigDecimal regionCode = NumberUtil.nullToZero(addressCommonCO.getREGION());
	BigDecimal countryCode = NumberUtil.nullToZero(addressCommonCO.getCOUNTRY());

	String phoneFormat = "";
	if(NumberUtil.isNumberPositive(countryCode))
	{
	    PostalCodeSC criteria = new PostalCodeSC();
	    criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	    criteria.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	    criteria.setCountry_code(countryCode);
	    criteria.setRegion_code(regionCode);
	    criteria.setPostal_code(NumberUtil.nullToZero(addressCommonCO.getPOSTAL_CODE()).toString());

	    POSTAL_CODEVO postalCodeVO = postalCodeBO.returnPostalCodeById(criteria);

	    if(postalCodeVO == null)
	    {
		addActionToFOMElement(FomElementsConstant.POSTAL_CODE_ID, null, ConstantsCommon.ACTION_TYPE_READONLY,
			BigDecimal.ZERO, elementHashmap);
	    }
	    else
	    {
		addActionToFOMElement(FomElementsConstant.POSTAL_CODE_ID, null, ConstantsCommon.ACTION_TYPE_READONLY,
			BigDecimal.ONE, elementHashmap);
	    }

	    CountriesSC countriesSC = new CountriesSC();
	    countriesSC.setCompCode(addressCommonCO.getCOMP_CODE());
	    countriesSC.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	    countriesSC.setLanguage(addressCommonCO.getPreferredLanguage());
	    countriesSC.setCountryCode(countryCode);

	    CountriesCO countriesCO = countriesBO.returnCountryById(countriesSC);
	    addressCommonCO.setWarningMsg(countriesCO.getWarningMsg());
	    COUNTRIESVO countriesVO = countriesCO.getCountriesVO();

	    if(countriesVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Country_key" });
	    }
	    else
	    {
		countriesVO.setCOMP_CODE(addressCommonCO.getCOMP_CODE());
		// if(NumberUtil.nullToZero(countriesVO.getBLACK_LISTED()).intValue()
		// > 0)
		// {
		// throw new BOException(MessageCodes.COUNTRY_BLACKLISTED);
		// }

		if(null == countriesVO.getTELEPHONE_FORMAT())
		{
		    phoneFormat = "";
		}
		else
		{
		    HashMap<String, String> hm = returnPhoneByCountry(countriesCO);

		    // get the format and apply it on the dependent fields
		    phoneFormat = StringUtil.nullToEmpty(hm.get("format"));
		}
		// added by nour for tp#925559
		if (countriesSC.getPreferredLanguage().equals(FomElementsConstant.ARABIC )&& countriesVO.getLONG_DESC_ARAB()==null)
		{
			countriesVO.setLONG_DESC_ARAB("");
		}
		else if (countriesSC.getPreferredLanguage().equals(FomElementsConstant.ENGLISH) && countriesVO.getLONG_DESC_ENG()==null)
		{
			countriesVO.setLONG_DESC_ENG("");
		}
		// end nour
		addActionToFOMElement(FomElementsConstant.ADD_COUNTRY_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE,
			countriesVO.getLONG_DESC_ENG(), elementHashmap);
	    }

	    // [rk] the following function is to be ignored waiting to be able
	    // to format screen string controls
	    // uf_set_format(LL_CODE)
	}
	else
	{
	    addActionToFOMElement(Arrays.asList(FomElementsConstant.REGION_ID, FomElementsConstant.POSTAL_CODE_ID,
		    FomElementsConstant.REGION_DESC_ID, FomElementsConstant.POSTAL_CODE_DESC_ID),
		    ConstantsCommon.ACTION_TYPE_VALUE, "", elementHashmap);
	}
	String[] inputDependent = new String[] { FomElementsConstant.MOBILE_ID,
		FomElementsConstant.TEL_ID + "_" + addressCommonCO.getOpt(), FomElementsConstant.WORK_TEL_ID,
		FomElementsConstant.OTHER_TEL_ID, FomElementsConstant.FAX_ID,
		FomElementsConstant.REFERENCES_TEL_ID + "_" + addressCommonCO.getOpt(),
		FomElementsConstant.REFERENCES_TELEX_ID + "_" + addressCommonCO.getOpt(),
		FomElementsConstant.REFERENCES_FAX_ID + "_" + addressCommonCO.getOpt() };
	applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_TXTFORMAT, phoneFormat, elementHashmap, null);
	if(StringUtil.isNotEmpty(phoneFormat))
	{
	    applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH, String.valueOf(phoneFormat
		    .length() + 1), elementHashmap, null);
	}
	//Commented by Rania - If the phoneFormat is null, we don't want to override the max length defined by the customization
	//DASI180298 - Ctrl F2 Parameter
	/*else
	{
		applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH,
			NCifMaintenanceConstant.ADDRESS_DETAILS_MAX_LENGTH, elementHashmap, null);
	}*/

	addressCommonCO.getBuisnessElement().putAll(elementHashmap);
	return addressCommonCO;
    }

    /**
     * @author eliasaoun
     * @Modif IIAB130209 In this method i select from the db in order to apply
     *        format on each field in fieldsArr
     * @Param countriesVO.TELEPHONE_FORMAT,
     *        countriesVO.TELEPHONE_CODE,countriesVO
     *        .COUNTRY_CODE,countriesVO.COMP_CODE,countriesCO.regionCode
     */
	public HashMap<String, String> returnPhoneByCountry(CountriesCO countriesCO)
			throws BaseException {
		COUNTRIESVO countriesVO = countriesCO.getCountriesVO();
		HashMap<String, String> hm = new HashMap<String, String>();
		if (StringUtil.isNotEmpty(countriesVO.getTELEPHONE_FORMAT())) {
			COUNTRIES_TEL_FORMATVO cntryTelFrmatVO = new COUNTRIES_TEL_FORMATVO();
			// in case the format = 00000000, it is a number but not a LINE_NO (as LINE_NO should be > 0)
			if (NumberUtil.isNumber(countriesVO.getTELEPHONE_FORMAT()) && NumberUtil.parseInt(countriesVO.getTELEPHONE_FORMAT()) > 0) {
				cntryTelFrmatVO.setLINE_NO(new BigDecimal(countriesVO.getTELEPHONE_FORMAT()));
			} else {
				cntryTelFrmatVO.setFORMAT_VALUE(countriesVO.getTELEPHONE_FORMAT());
			}
			cntryTelFrmatVO = returnCountriesTelFormat(cntryTelFrmatVO);
			countriesCO.setCountriesTelFormat(cntryTelFrmatVO);

			// get the telephone code of the region
			COUNTRIES_REGIONVO countriesRegionVO = new COUNTRIES_REGIONVO();
			countriesRegionVO.setCOMP_CODE(countriesVO.getCOMP_CODE());
			countriesRegionVO.setCOUNTRY_CODE(countriesVO.getCOUNTRY_CODE());
			countriesRegionVO.setREGION_CODE(NumberUtil.nullEmptyToValue( countriesCO.getRegionCode(), BigDecimal.ZERO));

			countriesRegionVO = (COUNTRIES_REGIONVO) genericDAO.selectByPK(countriesRegionVO);
			countriesCO.setCountriesRegionVO(countriesRegionVO);

			// hold the format that should be applied
			String formatValue = "";

			// the code of the region, e.g Beirut(region) : 01
			String regionCode = "";
			if (countriesRegionVO != null) {
				regionCode = StringUtil.nullToEmpty(countriesRegionVO.getTELEPHONE_CODE());
			}

			COUNTRIES_TEL_FORMATVO countriesTelFormat = countriesCO.getCountriesTelFormat();
			if (null == countriesTelFormat) {
				// wich mean no format is applied
				hm.put("format", "");
				return hm;
			} else {
				formatValue = StringUtil.replaceInString(countriesTelFormat.getFORMAT_VALUE(), ConstantsCommon.PHONE_REPLACE_WHAT,
						ConstantsCommon.PHONE_REPLACE_WITH);
			}

			// if a code is defined for the country/region we should regenerate
			// the format

			// the code of the country e.g LEBANON(country) : 961
			BigDecimal countryCode = countriesVO.getTELEPHONE_CODE();
			if (!NumberUtil.isEmptyDecimal(countryCode)) {
				// the country code should not traspass this length
				int telCodeLen = NumberUtil.nullToZero( countriesTelFormat.getTEL_CODE_LEN()).intValue();
				/**
				 * bug #303918 : if the format string start with "+" this means
				 * it will replace two zeros e.g : format: +1-231-32121... is
				 * the same as 001-231-32121...
				 */
				Pattern p = Pattern.compile(Pattern.quote(ConstantsCommon.PHONE_PLUS), Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(formatValue);
				if (m.find() && telCodeLen > 2) {
					telCodeLen = telCodeLen - 2;
				}

				// add 0 to the left to satisfy the length
				String stringPhoneCode = NumberUtil.addLeadingZeros(
						countryCode, telCodeLen);

				// could be ["(" || "+" || "(+" ]
				String phoneExtension = "";

				// to check whether first character is number or not
				boolean isFirstNumber = ConstantsCommon.PHONE_REPLACE_WITH.equals(formatValue.substring(0, 1));
				// if first character of the format is not "0"
				if (!isFirstNumber) {
					phoneExtension = formatValue.substring(0, 1);
					formatValue = formatValue.substring(1, formatValue.length());

					boolean isSecondNumber = ConstantsCommon.PHONE_REPLACE_WITH.equals(formatValue.substring(0, 1));
					// if second character of the format is not a number like
					// "(+000)-(000)-0000000"
					if (!isSecondNumber) {
						phoneExtension = phoneExtension.concat(formatValue.substring(0, 1));
						formatValue = formatValue.substring(1, formatValue.length());
					}

				}
				// after we set the country code(base on telCodeLen), here we
				// append the regionCode to it (in case it exists)
				stringPhoneCode = stringPhoneCode.concat(regionCode);

				String formatValueLast = replaceCountryExtension(formatValue, stringPhoneCode);
				// TP#372630 if the format does not have any special characters(other than + in begining) then it
				// seems like 000000000, so we simply append the phone code in case it is not empty
				if (!StringUtil.isNotEmpty(formatValueLast) && StringUtil.isNotEmpty(stringPhoneCode)) {
					formatValue = stringPhoneCode.concat(formatValue.substring(stringPhoneCode.length()));
				} else {
					formatValue = formatValueLast;
				}
				formatValue = phoneExtension.concat(formatValue);
			}
			hm.put("format", formatValue);
		}
		return hm;
	}
	

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressPoBoxArea(AddressCommonCO addressCommonCO)
	    throws BaseException
    {
	BigDecimal regionCode, countryCode;
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

	regionCode = NumberUtil.nullToZero(addressCommonCO.getPOBOX_AREA());
	countryCode = NumberUtil.nullToZero(addressCommonCO.getCOUNTRY());

	PostalCodeSC criteria = new PostalCodeSC();
	criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	criteria.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	criteria.setCountry_code(countryCode);
	criteria.setRegion_code(regionCode);
	criteria.setPostal_code(NumberUtil.nullToZero(addressCommonCO.getPOSTAL_CODE()).toString());

	POSTAL_CODEVO postalCodeVO = postalCodeBO.returnPostalCodeById(criteria);

	if(postalCodeVO == null)
	{
	    // nCifMaintenanceBO.addActionToElement(FomElementsConstant.POSTAL_CODE_ID,"READ_ONLY",
	    // BigDecimal.ZERO, elementHashmap);
	    addActionToFOMElement(FomElementsConstant.POSTAL_CODE_ID, null, ConstantsCommon.ACTION_TYPE_READONLY,
		    BigDecimal.ZERO, elementHashmap);
	}
	else
	{
	    // nCifMaintenanceBO.addActionToElement(FomElementsConstant.POSTAL_CODE_ID,"READ_ONLY",
	    // BigDecimal.ONE, elementHashmap);
	    addActionToFOMElement(FomElementsConstant.POSTAL_CODE_ID, null, ConstantsCommon.ACTION_TYPE_READONLY,
		    BigDecimal.ONE, elementHashmap);
	}

	CountriesRegionSC countriesRegionSC = new CountriesRegionSC();
	countriesRegionSC.setCompCode(addressCommonCO.getCOMP_CODE());
	countriesRegionSC.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	countriesRegionSC.setCountry_code(countryCode);
	countriesRegionSC.setRegionCode(regionCode);

	COUNTRIES_REGIONVO countriesRegionVO = countriesRegionBO.returnCountriesRegionById(countriesRegionSC);

	if(countriesRegionVO == null)
	{
	    // nCifMaintenanceBO.addActionToElement(FomElementsConstant.POBOX_AREA_ID,"VALUE",
	    // "", elementHashmap);
	    // nCifMaintenanceBO.addActionToElement(FomElementsConstant.POBOX_AREA_DESC_ID,"VALUE",
	    // "", elementHashmap);
	    addActionToFOMElement(FomElementsConstant.POBOX_AREA_ID, null, ConstantsCommon.ACTION_TYPE_VALUE, "",
		    elementHashmap);
	    addActionToFOMElement(FomElementsConstant.POBOX_AREA_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE, "",
		    elementHashmap);
	    //From webservice
	    if(StringUtil.isNotEmpty(addressCommonCO.getIntegAction()))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "P.O.Box Area" });
	    }
	}
	else
	{
	    // nCifMaintenanceBO.addActionToElement(FomElementsConstant.POBOX_AREA_ID,"VALUE",
	    // countriesRegionVO.getREGION_CODE(), elementHashmap);
	    // nCifMaintenanceBO.addActionToElement(FomElementsConstant.POBOX_AREA_DESC_ID,"VALUE",
	    // countriesRegionVO.getBRIEF_DESC_ENG(), elementHashmap);
	    addActionToFOMElement(FomElementsConstant.POBOX_AREA_ID, null, ConstantsCommon.ACTION_TYPE_VALUE,
		    countriesRegionVO.getREGION_CODE(), elementHashmap);
	    addActionToFOMElement(FomElementsConstant.POBOX_AREA_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE,
		    countriesRegionVO.getBRIEF_DESC_ENG(), elementHashmap);
	}

	return elementHashmap;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressRegion(AddressCommonCO addressCommonCO)
	    throws BaseException
    {
	BigDecimal regionCode, countryCode;
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

	addActionToFOMElement(Arrays.asList(FomElementsConstant.CITY_CODE_ID, FomElementsConstant.SECTOR_CODE_ID,
		FomElementsConstant.POSTAL_CODE_ID, FomElementsConstant.CITY_DESC_ID,
		FomElementsConstant.POSTAL_CODE_DESC_ID, FomElementsConstant.SECTOR_DESC_ID),
		ConstantsCommon.ACTION_TYPE_VALUE, "", elementHashmap);

	regionCode = NumberUtil.nullToZero(addressCommonCO.getREGION());
	countryCode = NumberUtil.nullToZero(addressCommonCO.getCOUNTRY());

	PostalCodeSC criteria = new PostalCodeSC();
	criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	criteria.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	criteria.setCountry_code(countryCode);
	criteria.setRegion_code(regionCode);
	criteria.setPostal_code(NumberUtil.nullToZero(addressCommonCO.getPOSTAL_CODE()).toString());

	POSTAL_CODEVO postalCodeVO = postalCodeBO.returnPostalCodeById(criteria);

	if(postalCodeVO == null)
	{
	    addActionToFOMElement(FomElementsConstant.POSTAL_CODE_ID, null, ConstantsCommon.ACTION_TYPE_READONLY,
		    BigDecimal.ZERO, elementHashmap);
	}
	else
	{
	    addActionToFOMElement(FomElementsConstant.POSTAL_CODE_ID, null, ConstantsCommon.ACTION_TYPE_READONLY,
		    BigDecimal.ONE, elementHashmap);
	}

	CountriesRegionSC countriesRegionSC = new CountriesRegionSC();
	countriesRegionSC.setCompCode(addressCommonCO.getCOMP_CODE());
	countriesRegionSC.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	countriesRegionSC.setCountry_code(countryCode);
	countriesRegionSC.setRegionCode(regionCode);

	COUNTRIES_REGIONVO countriesRegionVO = countriesRegionBO.returnCountriesRegionById(countriesRegionSC);

	CountriesSC countriesSC = new CountriesSC();
	countriesSC.setCompCode(addressCommonCO.getCOMP_CODE());
	countriesSC.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	countriesSC.setLanguage(addressCommonCO.getPreferredLanguage());
	countriesSC.setCountryCode(countryCode);

	CountriesCO countriesCO = countriesBO.returnCountryById(countriesSC);
	countriesCO.getCountriesVO().setCOMP_CODE(addressCommonCO.getCOMP_CODE());
	countriesCO.setRegionCode(regionCode);

	String[] inputDependent = new String[] { FomElementsConstant.MOBILE_ID, FomElementsConstant.TEL_ID,
		FomElementsConstant.WORK_TEL_ID, FomElementsConstant.OTHER_TEL_ID, FomElementsConstant.FAX_ID,

		FomElementsConstant.REFERENCES_TEL_ID + "_" + addressCommonCO.getOpt(),
		FomElementsConstant.REFERENCES_TELEX_ID + "_" + addressCommonCO.getOpt(),
		FomElementsConstant.REFERENCES_FAX_ID + "_" + addressCommonCO.getOpt() };
	HashMap<String, String> hm = coreCommonServiceBO.returnPhoneByCountry(countriesCO);
	String phoneFormat = StringUtil.nullToEmpty(hm.get("format"));

	// get the format and apply it on the dependent fields
	applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_TXTFORMAT, phoneFormat, elementHashmap, null);
	if(StringUtil.isNotEmpty(phoneFormat))
	{
	    applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH, String.valueOf(phoneFormat
		    .length() + 1), elementHashmap, null);
	}
	//Commented by Rania - If the phoneFormat is null, we don't want to override the max length defined by the customization
	//DASI180298 - Ctrl F2 Parameter
	/*else
	{
	    applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH,
		    NCifMaintenanceConstant.ADDRESS_DETAILS_MAX_LENGTH, elementHashmap, null);
	}*/

	if(countriesRegionVO == null)
	{
	    addActionToFOMElement(FomElementsConstant.REGION_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE, "",
		    elementHashmap);
	    addActionToFOMElement(FomElementsConstant.REGION_ID, null, ConstantsCommon.ACTION_TYPE_VALUE, "",
		    elementHashmap);
	    //From webservice
	    if(StringUtil.isNotEmpty(addressCommonCO.getIntegAction()))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Area_key" });
	    }
	}
	else
	{
	    addActionToFOMElement(FomElementsConstant.REGION_ID, null, ConstantsCommon.ACTION_TYPE_VALUE, regionCode,
		    elementHashmap);
	    addActionToFOMElement(FomElementsConstant.REGION_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE,
		    StringUtil.nullToEmpty(countriesRegionVO.getBRIEF_DESC_ENG()), elementHashmap);
	}
	return elementHashmap;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressCityCode(AddressCommonCO addressCommonCO)
	    throws BaseException
    {
	BigDecimal cityCode, regionCode, countryCode;
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

	// nCifMaintenanceBO.addActionToElement(FomElementsConstant.SECTOR_CODE_ID,"VALUE",
	// "", elementHashmap);
	// nCifMaintenanceBO.addActionToElement(FomElementsConstant.SECTOR_DESC_ID,"VALUE",
	// "", elementHashmap);
	addActionToFOMElement(FomElementsConstant.SECTOR_CODE_ID, null, ConstantsCommon.ACTION_TYPE_VALUE, "",
		elementHashmap);
	addActionToFOMElement(FomElementsConstant.SECTOR_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE, "",
		elementHashmap);

	cityCode = addressCommonCO.getCITY_CODE();

	if(NumberUtil.isNumberPositive(cityCode))
	{
	    regionCode = NumberUtil.nullToZero(addressCommonCO.getREGION());
	    countryCode = NumberUtil.nullToZero(addressCommonCO.getCOUNTRY());

	    CitiesSC criteria = new CitiesSC();

	    criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	    criteria.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	    criteria.setCountry_code(countryCode);
	    criteria.setRegion_code(regionCode);
	    criteria.setCity_code(cityCode);

	    CITIESVO citiesVO = citiesBO.returnCityById(criteria);
	    if(citiesVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "City_Code_key", "" }, true);
	    }
	    else
	    {
		// nCifMaintenanceBO.addActionToElement(FomElementsConstant.CITY_DESC_ID,"VALUE",
		// citiesVO.getBRIEF_DESC_ENG(), elementHashmap);
		addActionToFOMElement(FomElementsConstant.CITY_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE,
			citiesVO.getBRIEF_DESC_ENG(), elementHashmap);
	    }
	}
	// else
	// {
	// //throw new
	// BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
	// }
	return elementHashmap;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> checkAddressSectorCode(AddressCommonCO addressCommonCO)
	    throws BaseException
    {
	BigDecimal sectorCode, cityCode, regionCode, countryCode;
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

	sectorCode = addressCommonCO.getSECTOR_CODE();

	if(NumberUtil.isNumberPositive(sectorCode))
	{
	    regionCode = NumberUtil.nullToZero(addressCommonCO.getREGION());
	    countryCode = NumberUtil.nullToZero(addressCommonCO.getCOUNTRY());
	    cityCode = NumberUtil.nullToZero(addressCommonCO.getCITY_CODE());

	    SectorsSC criteria = new SectorsSC();
	    criteria.setCompCode(addressCommonCO.getCOMP_CODE());
	    criteria.setCountry_code(countryCode);
	    criteria.setRegion_code(regionCode);
	    criteria.setCity_code(cityCode);
	    criteria.setSector_code(sectorCode);
	    criteria.setPreferredLanguage(addressCommonCO.getPreferredLanguage());

	    SECTORSVO sectorsVO = sectorsBO.returnSectorById(criteria);

	    if(sectorsVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "Address_sector_key", "" }, true);
	    }
	    else
	    {
		// nCifMaintenanceBO.addActionToElement(FomElementsConstant.SECTOR_DESC_ID,"VALUE",
		// sectorsVO.getBRIEF_DESC_ENG(), elementHashmap);
		addActionToFOMElement(FomElementsConstant.SECTOR_DESC_ID, null, ConstantsCommon.ACTION_TYPE_VALUE,
			sectorsVO.getBRIEF_DESC_ENG(), elementHashmap);
	    }
	}
	else
	{
	    throw new BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
	}
	return elementHashmap;
    }

    /**
     * this method returns the latest cif id in the counter (PB: uf_get_cifno)
     * Minimum Params : 1. fomCO.getCifVO().getCIF_NO() 2. fomCO.getAppName() 3.
     * fomCO.getLoginCompCode() 4. fomCO.getLoginBraCode() 5.
     * fomCO.getCifVO().getCIF_TYPE()
     * 
     */
    public BigDecimal returnCifNumber(FomCO fomCO) throws BaseException
    {
	BigDecimal lastNumber = BigDecimal.ZERO;
	if(!StringUtil.isNotEmpty(fomCO.getCompaniesVO().getAUTO_GENERATE_CODE()))
	{
	    COMPANIESVO companiesVO = new COMPANIESVO();
	    companiesVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    fomCO.setCompaniesVO(commonLibBO.returnLoggedCompanyDetails(companiesVO));
	}
	String autoGenerateCode = fomCO.getCompaniesVO().getAUTO_GENERATE_CODE();
	String cifReservedNo = "";

	/** If Not AUTO Increment THROW A MESSAGE **/
	if(("0".equals(autoGenerateCode)))
	{
	    if(NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_NO()))
	    {
		return new BigDecimal(-1);
	    }
	    return fomCO.getCifVO().getCIF_NO();
	}
	/** end If NOT AUTO Increment **/
	else
	{
	    // 1- check if application is retail
	    // 2- CHECK IF TELLER IS ALLOWED TO SELECT FROM CIF RESERVED LIST
	    // **/
			if (ConstantsCommon.RET_APP_NAME.equals(fomCO.getAppName())
					&& "1".equals(StringUtil.nullEmptyToValue(fomCO.getCtsTellerVO().getCIF_RESERVED_NO(), "0"))) {
				RIFPCTVO rifPct = new RIFPCTVO();
				rifPct.setCOMP_CODE(fomCO.getLoginCompCode());
				rifPct.setPRIORITY_CODE(NumberUtil.nullToZero(fomCO.getCifVO().getPRIORITY_CODE()));
				rifPct = (RIFPCTVO) genericDAO.selectByPK(rifPct);

				if (rifPct != null) {
					cifReservedNo = StringUtil.nullToEmpty(rifPct.getCIF_RESERVED_NO());
				}
				if (!"".equals(cifReservedNo)
						&& "1".equals(StringUtil.nullEmptyToValue(cifReservedNo, "0"))
						&& !fomCO.getCifReservedConfirmFlag()) {
					throw new BOException(MessageCodes.CIF_RESERVED_LIST,ConstantsCommon.CONFIRM_MSG_TYPE,FomConstant.RESERVED_CIF_CONFIRMATION);
				}
				else
				{
				    cifReservedNo = "0";
				}
			}


			// #372261 generate CIF_NO based on branch_code defined in COMPANIES
			// (SADS)
			BigDecimal branchDigits = NumberUtil.nullToZero(fomCO.getCompaniesVO().getBRANCH_DIGITS());
			String addBranchCode = StringUtil.nullEmptyToValue(fomCO.getCompaniesVO().getADD_BRANCH_CODE(), "0");
			BigDecimal branchCode = fomCO.getLoginBraCode();

			// adding the branch code to the new cif code
			if ("0".equals(addBranchCode)) {
				branchDigits = BigDecimal.ZERO;
			}
			// check if the branch code is to be added to the cif no or no
			if (BigDecimal.ZERO.compareTo(branchDigits) == 0) {
				branchCode = BigDecimal.ZERO;
			} else {
				branchCode = fomCO.getCifVO().getBRANCH_CODE();
				if (NumberUtil.isEmptyDecimal(branchCode) || BigDecimal.ZERO.compareTo(branchCode) == 0) {
					branchCode = fomCO.getLoginBraCode();
				}
				String maxBranchCode = NumberUtil.fill("9", branchDigits);
				if (branchCode.compareTo(new BigDecimal(maxBranchCode)) > 0) {
					throw new BOException(MessageCodes.BRANCH_CODE_EXCEEDS);
				}
			}


			
			
			if ("1".equals(autoGenerateCode)) {
				// set the values of CIFVO Created first time
				CIFCOUNTERVO cifCounterVO = new CIFCOUNTERVO();
				cifCounterVO.setCOMP_CODE(fomCO.getLoginCompCode());
				cifCounterVO.setBRANCH_CODE(branchCode);
				// if the branch code is not added to the cif code, it's value is 0 in the cifcounter table 
				lastNumber = returnCifCounter(cifCounterVO);

				// checking if the cif is reserved and then get the minimum cif
				// not Reserved
				CIF_RESERVEDVO cifReservedSc = new CIF_RESERVEDVO();
				cifReservedSc.setCOMP_CODE(fomCO.getLoginCompCode());
				cifReservedSc.setCIF_NO(lastNumber);
				lastNumber = new BigDecimal(returnCifNotReserved(cifReservedSc));

				/** IIAB100318 [John Massaad] */
				fomCO.getCifVO().setCIF_NO(lastNumber);
				returnCIFNumbBasedOnMask(fomCO);
			}
	    else
	    {
		CIF_TYPE_PARAM_DETVOKey cifTypeParamDetvoSC = new CIF_TYPE_PARAM_DETVOKey();
		cifTypeParamDetvoSC.setCOMP_CODE(fomCO.getLoginCompCode());
		cifTypeParamDetvoSC.setCIF_TYPE(fomCO.getCifVO().getCIF_TYPE());

		coreCommonServiceDAO.updateDummyCIF_TYPE_PARAM(cifTypeParamDetvoSC);
		CIF_TYPE_PARAMVO cifTypeparamVO = returnLastNumberCifType(cifTypeParamDetvoSC);
		BigDecimal fromRange = BigDecimal.ZERO;
		BigDecimal toRange = BigDecimal.ZERO;
		BigDecimal code = BigDecimal.ZERO;
		if(cifTypeparamVO != null)
		{
		    lastNumber = NumberUtil.nullToZero(cifTypeparamVO.getLAST_NUMBER());
		    fromRange = NumberUtil.nullToZero(cifTypeparamVO.getFROM_RANGE());
		    toRange = NumberUtil.nullToZero(cifTypeparamVO.getTO_RANGE());
		    code = NumberUtil.nullToZero(cifTypeparamVO.getCODE());
		}

		if(0 == BigDecimal.ZERO.compareTo(fromRange) || 0 == BigDecimal.ZERO.compareTo(toRange)
			|| cifTypeparamVO == null)
		{
		    throw new BOException(MessageCodes.RANGES_ARE_NOT_DEFINED);
		}

		if(lastNumber==null){
		   
		    lastNumber = BigDecimal.ZERO;
		}
		
		lastNumber = (BigDecimal.ZERO.compareTo(lastNumber) == 0) ? fromRange : lastNumber.add(BigDecimal.ONE);

		while(lastNumber.compareTo(toRange) <= 0 && !"1".equals(StringUtil.nullEmptyToValue(cifReservedNo, "0")))
		{
		    CIF_RESERVEDVO cifReservedVO = new CIF_RESERVEDVO();
		    cifReservedVO.setCOMP_CODE(fomCO.getLoginCompCode());
		    cifReservedVO.setCIF_NO(lastNumber);
		    cifReservedVO = (CIF_RESERVEDVO) genericDAO.selectByPK(cifReservedVO);
		    if(cifReservedVO != null)
		    {
			cifReservedNo = "0";
			lastNumber = lastNumber.add(BigDecimal.ONE);
			continue;
		    }
		    else
		    {
			cifReservedNo = "1";
		    }
		    
		    CIFVO cifVO = new CIFVO();
		    cifVO.setCOMP_CODE(fomCO.getLoginCompCode());
		    cifVO.setCIF_NO(lastNumber);
		    cifVO = (CIFVO) genericDAO.selectByPK(cifVO);
		    if(cifVO == null)
		    {
			break;
		    }
		    lastNumber = lastNumber.add(BigDecimal.ONE);
		}

		if(lastNumber.compareTo(toRange) > 0)
		{
		    throw new BOException(MessageCodes.MAXIMUM_RANGE_EXCEEDED);
		}

		CIF_RESERVEDVO cifReservedVO = new CIF_RESERVEDVO();
		cifReservedVO.setCOMP_CODE(fomCO.getLoginCompCode());
		cifReservedVO.setCIF_NO(lastNumber);

		lastNumber = new BigDecimal(returnCifNotReserved(cifReservedVO));
		
		if(lastNumber.compareTo(toRange) > 0)
		{
		    throw new BOException(MessageCodes.MAXIMUM_RANGE_EXCEEDED);
		}

		CIF_TYPE_PARAMVO cifTypeParamVO = new CIF_TYPE_PARAMVO();
		cifTypeParamVO.setCOMP_CODE(fomCO.getLoginCompCode());
		cifTypeParamVO.setCODE(code);
		cifTypeParamVO.setLAST_NUMBER(lastNumber);

		genericDAO.update(cifTypeParamVO);

		/** IIAB100318 [John Massaad] */
		fomCO.getCifVO().setCIF_NO(lastNumber);
		returnCIFNumbBasedOnMask(fomCO);
		if(BigDecimal.ZERO.compareTo(fomCO.getCifVO().getCIF_NO()) == 0)
	    {
           throw new BOException(MessageCodes.TROUBLE_WITH_INDEX_KEY);
        }
	    }
	}
	
	
	
	return fomCO.getCifVO().getCIF_NO();
    }

    /**
     * this method returns the latest cif id in the counter (PB: uf_get_cifno)
     */
    private BigDecimal returnCifCounter(CIFCOUNTERVO cifCounterVO) throws BaseException
    {
	BigDecimal serialCifCounter;

	// Get CIF Counter details to check if filled
	CIFCOUNTERVO cifCounter = (CIFCOUNTERVO) genericDAO.selectByPK(cifCounterVO);

	// if not found we insert a new record with these informations
	if(cifCounter == null)
	{
	    CIFCOUNTERVO cifCounterNew = new CIFCOUNTERVO();
	    cifCounterNew.setCOMP_CODE(cifCounterVO.getCOMP_CODE());
	    cifCounterNew.setBRANCH_CODE(cifCounterVO.getBRANCH_CODE());
	    cifCounterNew.setLAST_NUMBER(BigDecimal.ZERO);
	    genericDAO.insert(cifCounterNew);
	    cifCounter = cifCounterNew;
	}

	/*
	 * we do a dummy update to lock the cifCounter record
	 */
	coreCommonServiceDAO.updateDummyCTSCOUNTER(cifCounter);

	/*
	 * we select the LAST_NUMBER from the CIFCOUNTER after inserting the
	 * value
	 */
	cifCounter = (CIFCOUNTERVO) genericDAO.selectByPK(cifCounterVO);
	serialCifCounter = NumberUtil.nullToZero(cifCounter.getLAST_NUMBER()).add(BigDecimal.ONE);

	CIFVO cifVO = new CIFVO();
	cifVO.setCOMP_CODE(cifCounterVO.getCOMP_CODE());
	cifVO.setCIF_NO(serialCifCounter);
	cifVO = (CIFVO) genericDAO.selectByPK(cifVO);
	if(cifVO != null)
	{
	    NCifMaintenanceSC nCifMaintenanceSC = new NCifMaintenanceSC();
	    nCifMaintenanceSC.setCompCode(cifCounterVO.getCOMP_CODE());
	    serialCifCounter = coreCommonServiceDAO.returnMaxCIFNumber(nCifMaintenanceSC).add(BigDecimal.ONE);
	}

	cifCounter.setLAST_NUMBER(serialCifCounter);

	/*
	 * Update the new LAST_NUMBER calculated
	 */
	genericDAO.update(cifCounter);

	/*
	 * Return the Big Decimal value calculated
	 */
	return serialCifCounter;

    }

    /**
     * this function checks if the CIF returned by any counter exists in table
     * CIF_RESEVED and then get the minimum CIF not exist in this list
     * 
     * example : if the counter is 4 and we have in CIF_RESERVED 2,4,5,8 then we
     * get the 6 since 4 and 5 are reserved .
     * 
     * 
     * this function replaced the this code:
     * 
     * //EXCLUSDE THE CIF RESERVED LIST ls_not_in_reserved = '0' DO WHILE
     * ls_not_in_reserved = '0' //CHECK IF NO IS IN RESERVED CIF LIST SELECT
     * COUNT(1) INTO :ll_count FROM CIF_RESERVED WHERE CIF_RESERVED.COMP_CODE =
     * :gv_company_code AND CIF_RESERVED.CIF_NO = :ll_last_number; If
     * sqlca.sqlcode <> 0 then ll_count = 0 If ll_count = 0 Then
     * ls_not_in_reserved = '1' Else ll_last_number = ll_last_number + 1 End If
     * LOOP //
     * 
     * @param cifReservedParam
     * @return
     * @throws BaseException
     */
    public int returnCifNotReserved(CIF_RESERVEDVO cifReservedParam) throws BaseException
    {
	CIF_RESERVEDVO cifReserved = (CIF_RESERVEDVO) genericDAO.selectByPK(cifReservedParam);
	// if the cif number is reserved we have to exclude it
	if(cifReserved == null)
	{
	    return (cifReservedParam.getCIF_NO().intValue());
	}

	else
	{
	    return coreCommonServiceDAO.returnCifNotReserved(cifReservedParam);
	}
    }

    /**
     * IIAB100318 [John Massaad] We are generating a new CIF_NO by calling
     * returnCIFNumbBasedOnMask (equivalent to f_get_cif_number_mask) and
     * Equivalent power builder method: f_get_cif_number_mask This method
     * returns the CIF NO according to the criteras specified in SADS->
     * ControlRecords -> CIF Number Mask
     * 
     */
    public FomCO returnCIFNumbBasedOnMask(FomCO fomCO) throws BaseException
    {
	BigDecimal maxCIFNo = fomCO.getCifVO().getCIF_NO();

	// we are calling this method because we are calling returnCIFNumberMask
	// from another BO
	List<S_ADDREF_MASK_SPECIFICVO> maskSpecificList = coreCommonBO.returnCIFAddRefNumberMask("C");
	int maskSpecificListSize = 0;
	if(null != maskSpecificList)
	{
	    maskSpecificListSize = maskSpecificList.size();
	}
	StringBuffer strBranch = new StringBuffer();
	BigDecimal branchDigits = new BigDecimal(4);
	for(int i = 0; i < maskSpecificListSize; i++)
	{
	    String mask = maskSpecificList.get(i).getCOLUMN_MASK();
	    String strBranchNb = NumberUtil.addLeadingZeros(fomCO.getCifVO().getBRANCH_CODE(), mask.length());

	    if((NCifMaintenanceConstant.COLUMN_NAME_BRANCH).equals(maskSpecificList.get(i).getCOLUMN_NAME()))
	    {
		if("1".equals(fomCO.getCompaniesVO().getAUTO_GENERATE_CODE()))
		{
		    String addBranchCode = fomCO.getCompaniesVO().getADD_BRANCH_CODE();
		    branchDigits = NumberUtil.nullEmptyToValue(fomCO.getCompaniesVO().getBRANCH_DIGITS(),
			    new BigDecimal(4));

		    if("0".equals(addBranchCode))
		    {
			branchDigits = new BigDecimal(4);
		    }
		    if(fomCO.getCifVO().getBRANCH_CODE().intValue() > Integer.parseInt(NumberUtil.fill("9",
			    branchDigits)))
		    {
			throw new BOException("BRANCH_CODE_EXCEEDS");
		    }

		    if(StringUtil.isNotEmpty(mask) && mask.length() > branchDigits.intValue())
		    {
			int startIndex = mask.length() - branchDigits.intValue();
			mask = mask.substring(startIndex, mask.length());
			StringBuffer sb = new StringBuffer(mask);
			while(startIndex > 0)
			{
			    sb.insert(0, "X");
			    startIndex--;
			}
			mask = sb.toString();
		    }
		}

		int position = mask.indexOf("#");
		while(position != -1)
		{
		    char braChar = strBranchNb.charAt(position);
		    strBranch.append(braChar);
		    position = mask.indexOf("#", position + 1);
		}
		strBranch = new StringBuffer(NumberUtil.addLeadingZeros(new BigDecimal(strBranch.toString()),
			branchDigits.intValue()));

	    }
	    else if((NCifMaintenanceConstant.COLUMN_NAME_SEQUENCE).equals(maskSpecificList.get(i).getCOLUMN_NAME()))
	    {
		//Hasan Bug#504328 30/03/2017
		BigDecimal firstCif = new BigDecimal(strBranch + String.join("", Collections.nCopies(8 - strBranch.length(), "0")));
		BigDecimal lastCif = new BigDecimal(strBranch + String.join("", Collections.nCopies(8 - strBranch.length(), "9")));
		CifSC cifSC = new CifSC();
		cifSC.setCompCode(fomCO.getLoginCompCode());
		cifSC.setCode(firstCif);
		cifSC.setCif_no(lastCif);
		
		BigDecimal cifNo = cifBO.returnCifForBasedOnMasked(cifSC);
				
		if(NumberUtil.isEmptyDecimal(cifNo))
		{
		    maxCIFNo = new BigDecimal(0);
		}
		else
		{
		    cifNo = cifNo.add(new BigDecimal(1));
		    if(lastCif.add(new BigDecimal(1)).equals(cifNo))
		    {
			maxCIFNo = new BigDecimal(0);
		    }
		    else
		    {
			maxCIFNo = cifNo;
		    }
		}
		
//		strBranch.append(NumberUtil.addLeadingZeros(fomCO.getCifVO().getCIF_NO(), 8 - strBranch.length()));
//		maxCIFNo = new BigDecimal(strBranch.toString());
	    }
	}
	fomCO.getCifVO().setCIF_NO(maxCIFNo);
	return fomCO;
    }

    /**
     * this function is used to get the cif number based on the cif type range
     * defined in"CIF Type Ranges" screen defined in CSMADMIN
     * 
     * @param cifTypeParamDetvokey
     * @return
     * @throws DAOException
     */
    public CIF_TYPE_PARAMVO returnLastNumberCifType(CIF_TYPE_PARAM_DETVOKey cifTypeParamDetvokey) throws BaseException
    {
	return coreCommonServiceDAO.returnLastNumberCifType(cifTypeParamDetvokey);

    }

    public ArrayList<CIFVO> returncifByIrisRecog(CifSC cifSC) throws BaseException
    {
	return coreCommonServiceDAO.returncifByIrisRecog(cifSC);
    }
    
    // Abdo CDMI170296 26/09/2017
    public CTSTELLERVO returnloginTeller(CTSTELLERSC ctsTellerSC) throws BaseException
    {
	CTSTELLERVO ctstellerVO = new CTSTELLERVO();
	ctstellerVO.setCOMP_CODE(ctsTellerSC.getCompCode());
	ctstellerVO.setBRANCH_CODE(ctsTellerSC.getBranchCode());
	ctstellerVO.setCODE(ctsTellerSC.getTellerCode());
	ctstellerVO = (CTSTELLERVO) genericDAO.selectByPK(ctstellerVO);
	return ctstellerVO;

    }

    /**
     * This function should call the checkMoneyLaundering function. Its used
     * only in transaction screen PB= uf_check_moneylaundring
     * 
     * @author nabilfeghali
     * @param trxMgntCO.getBaseCyDecimalPoints() trxMgntCO.getBaseCurrencyCode()
     * 
     */
    public TrxMgntCO trxCheckMoneyLaundering(TrxMgntCO trxMgntCO, boolean sendAlert) throws BaseException
    {
	AMFVO accountVO = new AMFVO();
	accountVO.setBRANCH_CODE(trxMgntCO.getCtstrsVO().getTRS_AC_BR());
	accountVO.setCURRENCY_CODE(trxMgntCO.getCtstrsVO().getTRS_AC_CY());
	accountVO.setGL_CODE(trxMgntCO.getCtstrsVO().getTRS_AC_GL());
	accountVO.setCIF_SUB_NO(trxMgntCO.getCtstrsVO().getTRS_AC_CIF());
	accountVO.setSL_NO(trxMgntCO.getCtstrsVO().getTRS_AC_SL());

	if(NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_AC_BR())
		|| NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_AC_CY())
		|| NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_AC_GL())
		|| NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_AC_CIF())
		|| NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_AC_SL()))
	{
	    // return -1;
	    trxMgntCO.setReturnNumber(new BigDecimal(-1));
	    return trxMgntCO;
	}
	else
	{
	    // Set The Amount Of The Transaction amount.
	    BigDecimal trsAmount = null;
	    
	    /*COMMENTED BY SABINE FOR ZB190001 - AML Currency Field
	     *  if(!NumberUtil.isEmptyDecimal(trxMgntCO.getCtstrsVO().getTRS_CY())
		    && !NumberUtil.isEmptyDecimal(trxMgntCO.getBaseCurrencyCode())
		    && !NumberUtil.isEmptyDecimal(trxMgntCO.getBaseCyDecimalPoints())
		    && trxMgntCO.getCtstrsVO().getTRS_CY().compareTo(trxMgntCO.getBaseCurrencyCode()) == 0)
	    {
		cvAmount = NumberUtil.roundToBigDecimal(trxMgntCO.getCtstrsVO().getAMOUNT(), trxMgntCO
			.getBaseCyDecimalPoints().intValue());
	    }
	    else
	    {
		AmountCO amountCO = new AmountCO();
		amountCO.setBaseCurrency(trxMgntCO.getBaseCurrencyCode());
		amountCO.setFcAmount(trxMgntCO.getCtstrsVO().getAMOUNT());
		amountCO.setCurrencyAccount(trxMgntCO.getCtstrsVO().getTRS_CY());
		amountCO.setCompCode(trxMgntCO.getLoginCompCode());
		amountCO.setRunningDate(trxMgntCO.getRunningDateRET());
		amountCO = commonLibBO.selectComputedCvAmount(amountCO);
		if(amountCO != null)
		{
		    cvAmount = amountCO.getCvAmount();
		}
	    }
	    */
	    /*
	     * Initialize the currency VO
	     */
	    TrxMgntSC trxSC = new TrxMgntSC();
	    CURRENCIESVO currencyVO = new CURRENCIESVO();
	    currencyVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    currencyVO.setCURRENCY_CODE(trxMgntCO.getCtstrsVO().getTRS_CY());
	    currencyVO = (CURRENCIESVO) genericDAO.selectByPK(currencyVO);
	    if(currencyVO != null)
	    {
		trxSC.setDecimalPoints(currencyVO.getDECIMAL_POINTS());
	    }
	    
	    trsAmount = trxMgntCO.getCtstrsVO().getAMOUNT();
	    trsAmount = NumberUtil.roundToBigDecimal(trsAmount, trxSC.getDecimalPoints()
		    .intValue()); 
	    //accPositionCO.setBaseCurrencyCode(trxMgntSC.getBaseCurrencyCode());
	    return checkMoneyLaundering(trxMgntCO, accountVO, trsAmount, true, sendAlert);
	}

    }

    /**
     * @author nabilfeghali PB = wf_check_moneylaundring in currencyExchange and
     *         uf_check_moneylaundring in transaction
     * @param 1) trxMgntCO.getCtsControlVO().getAFFECT_MONEY_LAUNDRING() , make
     *        sure that's filled 2)
     *        trxMgntCO.getCtstrxtypeVO().getMONEY_LAUNDRING() , make sure
     *        that's filled 2) amfVO : in case of transactio n : from account,
     *        in case of currency exchange : condition on cr_dr_forex 3)
     *        cvAmount : should be passed as parameter and calculated externaly.
     *        in currency exchange we should use wf_get_amount_in_base_cy 4)
     *        isTrxOpt to indicate if the method is called from transaction
     *        screen 5) trxMgntCO.getLoginCompCode() 6)
     *        trxMgntCO.getLoginBraCode() 7) trxType =
     *        trxMgntCO.getCtstrxtypeVO().getCODE() 8)
     *        trxMgntCO.getRunningDate() 9) trxMgntCO.getCtstrsVO().getTRS_CY().
     *        In case of currency exchange we should pass the
     *        currencyExchangeCO.getBaseCurrencyCode() 10)
     *        trxMgntCO.getCtstrxtypeVO().getML_WARNING_FLAG() - needed in case
     *        of transaction only 11) trxMgntCO.getLanguage() 12)
     *        trxMgntCO.getCtstrxtypeVO().getML_ALERT_FLAG() - needed in case of
     *        transaction only 13) trxMgntCO.getOriginBraCode() 14)
     *        trxMgntCO.getCtstrxtypeVO().getMULTI_BRANCH() - needed in case of
     *        transaction only 15) accountVO.getGMI_FLAG() - needed in case of
     *        transaction only
     * @return int : -1 for error. 0 : allow to proceed
     * @throws BaseException
     */
    public TrxMgntCO checkMoneyLaundering(TrxMgntCO trxMgntCO, AMFVO accountVO, BigDecimal cashAmount,
	    boolean isTrxOpt, boolean sendAlert) throws BaseException
    {

	// BigDecimal cashBr = null, cashCy = null, cashGl = null, cashCif =
	// null, cashSl = null, cashAmount = null;
	if(trxMgntCO.getCtsControlVO() != null && "1".equals(trxMgntCO.getCtsControlVO().getAFFECT_MONEY_LAUNDRING()))
	{
	    /*
	     * Check If The Process Exceeding Limit Will Be Applied For This
	     * Type Of Transaction.
	     */
	    if("0".equals(trxMgntCO.getCtstrxtypeVO().getMONEY_LAUNDRING()))
	    {
		// return 0;
		trxMgntCO.setReturnNumber(BigDecimal.ZERO);
		return trxMgntCO;
	    }

	    AMFVO amfVO = new AMFVO();
	    amfVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    amfVO.setBRANCH_CODE(accountVO.getBRANCH_CODE());
	    amfVO.setCURRENCY_CODE(accountVO.getCURRENCY_CODE());
	    amfVO.setGL_CODE(accountVO.getGL_CODE());
	    amfVO.setCIF_SUB_NO(accountVO.getCIF_SUB_NO());
	    amfVO.setSL_NO(accountVO.getSL_NO());
	    amfVO = (AMFVO) genericDAO.selectByPK(amfVO);
	    if(amfVO == null)
	    {
		throw new BOException(MessageCodes.ERROR_RETRIEVE_ACCOUNT_INFO);
	    }

	    if(isTrxOpt /* && amfVO != null */&& "I".equals(amfVO.getGMI_FLAG()))
	    {
		// return 0;
		trxMgntCO.setReturnNumber(BigDecimal.ZERO);
		return trxMgntCO;
	    }

	    /*
	     * Check The Opened Date For the Trx A/C No.
	     */

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH);
	    String formatedDate = sdf.format(amfVO.getDATE_OPND());
	    if(amfVO.getDATE_OPND() == null || "01/01/1900".equals(formatedDate))
	    {
		throw new BOException(MessageCodes.OPENED_DATE_DOES_NOT_EXIST_FOR_TRX_AC);
	    }
	    Date idOpenedDate = null;
	    if(amfVO.getDATE_OPND() != null && !"01/01/1900".equals(formatedDate))
	    {
		idOpenedDate = DateUtil.getFormatedDate(formatedDate);
	    }
	    BigDecimal trxType = NumberUtil.emptyDecimalToNull(trxMgntCO.getCtstrxtypeVO().getCODE());
	    String lcTrendsType = "";
	    TrxMgntSC trxMgntSC = new TrxMgntSC();
	    trxMgntSC.setCompCode(trxMgntCO.getLoginCompCode());
	    trxMgntSC.setBranchCode(trxMgntCO.getLoginBraCode());
	    trxMgntSC.setTrxType(trxType);
	    trxMgntSC.setCif(amfVO.getCIF_SUB_NO());
	    if (trxMgntCO.getCtstrsVO() != null)
	    {
		trxMgntSC.setTrsCy(trxMgntCO.getCtstrsVO().getTRS_CY());
		trxMgntSC.setBaseCurrencyCode(trxMgntCO.getBaseCurrencyCode());
	    }
	    
	    trxMgntSC.setDrCrType(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX());
	    /*
	     * Check The Cif Trx Trends.
	     */
	    ArrayList<TrxMgntCO> cifTrxTrendsDetVO = returnCifTrxTrendsDet(trxMgntSC);
	    if(cifTrxTrendsDetVO == null || cifTrxTrendsDetVO.isEmpty())
	    {
		/*
		 * Check The One Obligor Trx Trends .
		 */
		ArrayList<TrxMgntCO> rifObtTrendsDetVO = returnRifObtTrendsDet(trxMgntSC);
		if(rifObtTrendsDetVO == null || rifObtTrendsDetVO.isEmpty())
		{
		    /*
		     * Check The Trx Type Trends.
		     */
		    ArrayList<TrxMgntCO> ctsTrxTypeMlVO = returnCtsTrxTypeMl(trxMgntSC);
		    if(ctsTrxTypeMlVO == null || ctsTrxTypeMlVO.isEmpty())
		    {
			ArrayList<TrxMgntCO> ctsControlMlVO = returnCtsControlMl(trxMgntSC);
			if(ctsControlMlVO == null || ctsControlMlVO.isEmpty())
			{
			    // return 0;
			    trxMgntCO.setReturnNumber(BigDecimal.ZERO);
			    return trxMgntCO;
			}
			else
			{
			    /*
			     * Money Laundring Will Be Processed As How It Was
			     * Defined In Control Record For This Type Of Trx.
			     */
			    lcTrendsType = "R";
			}
		    }
		    else
		    {
			/*
			 * Money Laundring Will Be Processed By One Obligor For
			 * This Type Of Trx.
			 */
			lcTrendsType = "T";
		    }
		}
		else
		{
		    /*
		     * Money Laundring Will Be Processed By One Obligor For This
		     * Type Of Trx.
		     */
		    lcTrendsType = "O";
		}
	    }
	    else
	    {
		/*
		 * Money Laundring Will Be Processed By CIF For This Type Of
		 * Trx.
		 */
		lcTrendsType = "C";
	    }
	    /*
	     * Initialize the currency VO
	     */
	    CURRENCIESVO currencyVO = new CURRENCIESVO();
	    currencyVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
	    currencyVO.setCURRENCY_CODE(trxMgntCO.getCtstrsVO().getTRS_CY());
	    currencyVO = (CURRENCIESVO) genericDAO.selectByPK(currencyVO);
	    /*
	     * Exceeding Amount Process.
	     */
	    trxMgntSC.setTrends(lcTrendsType);
	    trxMgntSC.setAmount(cashAmount);
	    trxMgntSC.setOpenDate(idOpenedDate);
	    trxMgntSC.setRunningDate(trxMgntCO.getRunningDateRET());
	    if(currencyVO != null)
	    {
		trxMgntSC.setDecimalPoints(currencyVO.getDECIMAL_POINTS());
	    }
	    int moneyLaundringExceeedAmtResult = checkMoneyLaunderingExceedingAmount(trxMgntSC);
	    trxMgntCO.setMlPeriodicityType(trxMgntSC.getPeriodicityType());
	    /*
	     * Amount Is Exceeded
	     */
	    if(moneyLaundringExceeedAmtResult == -1)
	    {
		/*
		 * Transaction part , cheking for alerts
		 */
		if(isTrxOpt && sendAlert)
		{
		    trxMgntCO.getCtstrsVO().setFACILITY_COLLATERAL_REF(new BigDecimal(-1));

		    // To a specific level of user
		    if("1".equals(trxMgntCO.getCtstrxtypeVO().getML_ALERT_FLAG()))
		    {
			AlertsSC alertsSC = new AlertsSC();
			alertsSC.setCompCode(trxMgntCO.getLoginCompCode());
			alertsSC.setBranchCode(trxMgntCO.getOriginBraCode());
			alertsSC.setLevel(new BigDecimal(StringUtil.nullEmptyToValue(trxMgntCO.getCtstrxtypeVO()
				.getML_ALERT_USER(), "0")));
			alertsSC.setMultiBranch(trxMgntCO.getCtstrxtypeVO().getMULTI_BRANCH());
			List<String> usersList = alertsBO.returnAllTellersByLevel(alertsSC);
			if(usersList != null && !usersList.isEmpty())
			{
			    for(String user : usersList)
			    {
				if(user != null)
				{
				    sendMoneyLaundringAlertUser(trxMgntCO, user, "M", trxMgntSC.getPeriodicityType());
				}
			    }
			}

		    }
		    // To a specific User
		    else if("2".equals(trxMgntCO.getCtstrxtypeVO().getML_ALERT_FLAG()))
		    {
			if(trxMgntCO.getCtstrxtypeVO().getML_ALERT_USER() != null
				&& StringUtil.isNotEmpty(trxMgntCO.getCtstrxtypeVO().getML_ALERT_USER()))
			{
			    sendMoneyLaundringAlertUser(trxMgntCO, trxMgntCO.getCtstrxtypeVO().getML_ALERT_USER(), "M",
				    trxMgntSC.getPeriodicityType());
			}
		    }
		    // To a specific user group
		    else if("3".equals(trxMgntCO.getCtstrxtypeVO().getML_ALERT_FLAG()))
		    {
			AlertsSC alertsSC = new AlertsSC();
			alertsSC.setCompCode(trxMgntCO.getLoginCompCode());
			alertsSC.setBranchCode(trxMgntCO.getOriginBraCode());
			alertsSC.setGroup(trxMgntCO.getCtstrxtypeVO().getML_ALERT_USER());
			alertsSC.setMultiBranch(trxMgntCO.getCtstrxtypeVO().getMULTI_BRANCH());
			alertsSC.setAppName(ConstantsCommon.APP_NAME);
			List<String> usersList = alertsBO.returnAllTellersByGroup(alertsSC);
			if(usersList != null && !usersList.isEmpty())
			{
			    for(String user : usersList)
			    {
				if(user != null)
				{
				    sendMoneyLaundringAlertUser(trxMgntCO, user, "M", trxMgntSC.getPeriodicityType());
				}
			    }
			}

		    }

		}

		/*
		 * Check The Warning Flag Warning Value
		 */
		if("0".equals(trxMgntCO.getCtstrxtypeVO().getML_WARNING_FLAG()))
		{
		    /*
		     * Do Not Give Warning and allow to proceed
		     */
		    // return 0;
		    trxMgntCO.setReturnNumber(BigDecimal.ZERO);
		    return trxMgntCO;
		}
		else
		{
		    if("1".equals(trxMgntCO.getCtstrxtypeVO().getML_WARNING_FLAG()))
		    {
			/*
			 * Give Warning
			 */
			StringBuffer warningMessages = new StringBuffer(StringUtil.nullToEmpty(trxMgntCO
				.getWarningMsg()));
			String newWarningMessage = commonLibBO.returnTranslErrorMessage(
				MessageCodes.MONEY_LAUNDERING_AMOUNT_AMOUNT_EXCEED, trxMgntCO.getLanguage());
			if(warningMessages.indexOf(newWarningMessage) == -1)
			{
			    warningMessages.append("\n" + newWarningMessage);
			}
			trxMgntCO.setWarningMsg(warningMessages.toString());
			/*
			 * SET TO 1 in order in automatic approve do not show
			 * message twice
			 */
			trxMgntCO.setIsMlMessage("1");
			/*
			 * Allow To Proceed
			 */
			// return 0;
			trxMgntCO.setReturnNumber(BigDecimal.ZERO);
			return trxMgntCO;
		    }
		    else
		    {
			/*
			 * Don't Allow To Proceed
			 */
			throw new BOException(MessageCodes.MONEY_LAUNDERING_AMOUNT_AMOUNT_EXCEED);
		    }
		}
	    }
	    else if(moneyLaundringExceeedAmtResult == -2)
	    {
		// return -1;
		trxMgntCO.setReturnNumber(new BigDecimal(-1));
		return trxMgntCO;
	    }
	    else
	    {
		if(isTrxOpt)
		{
		    trxMgntCO.getCtstrsVO().setFACILITY_COLLATERAL_REF(null);
		}
		// return 0;
		trxMgntCO.setReturnNumber(BigDecimal.ZERO);
		return trxMgntCO;
	    }
	}
	else
	{
	    // return 0;
	    trxMgntCO.setReturnNumber(BigDecimal.ZERO);
	    return trxMgntCO;
	}

    }

    /**
     * wf_check_moneylaundring_exceeding_amount
     * 
     * @param trxMgntSC compCode, branchCode, trends, trxType, cif, cvAmount,
     *            openDate, runningDate, decimalPoints
     * @return int
     * @throws BaseException
     * @author TonyNouh
     */
    public int checkMoneyLaunderingExceedingAmount(TrxMgntSC trxMgntSC) throws BaseException
    {
	boolean lbExceed = false;
	Date ldFirstPeriod, ldLastPeriod;
	ArrayList<TrxMgntCO> trxMgntLstCO = new ArrayList<TrxMgntCO>();
	if("C".equals(trxMgntSC.getTrends()))
	{
	    /*
	     * Cif Trx Trends.
	     */
	    trxMgntLstCO = returnCifTrxTrendsDet(trxMgntSC);
	}
	else if("O".equals(trxMgntSC.getTrends()))
	{
	    /*
	     * One Obligor Trends
	     */
	    trxMgntLstCO = returnRifObtTrendsDet(trxMgntSC);
	}
	else if("T".equals(trxMgntSC.getTrends()))
	{
	    /*
	     * Transaction Type trends
	     */
	    trxMgntLstCO = returnCtsTrxTypeMl(trxMgntSC);
	}
	else if("R".equals(trxMgntSC.getTrends()))
	{
	    /*
	     * Control Trends
	     */
	    trxMgntLstCO = returnCtsControlMl(trxMgntSC);
	}
	Long nbOfDays = DateUtil.numberOfDays(trxMgntSC.getOpenDate(), trxMgntSC.getRunningDate());
	if(trxMgntLstCO != null && !trxMgntLstCO.isEmpty())
	{
	    for(int i = 0; i < trxMgntLstCO.size(); i++)
	    {
		trxMgntSC.setPeriodicityType(trxMgntLstCO.get(i).getPeriodType());
		/*
		 * Set The Total Amount To 0
		 */
		BigDecimal totalTransAmount = BigDecimal.ZERO;
		/*
		 * Just Compare The Amount To The Single Amount Of The Cif Or
		 * One Obligor Trends .
		 */
		if((NumberUtil.emptyDecimalToZero(trxMgntSC.getAmount()).compareTo(
			NumberUtil.emptyDecimalToZero(trxMgntLstCO.get(i).getSingleAmount())) > 0)
			&& (("C".equals(trxMgntSC.getTrends())) || ("O".equals(trxMgntSC.getTrends()))))
		{
		    /*
		     * The Amount Is Exceeded
		     */
		    lbExceed = true;
		    break;
		}

		if(!TrxMgntConstant.TRX_ML_PERIODICITY_CURRENT.equals(trxMgntLstCO.get(i).getPeriodType()))
		{
		    /*
		     * Daily Or Weekly
		     */
		    if("D".equals(trxMgntLstCO.get(i).getPeriodType())
			    || "W".equals(trxMgntLstCO.get(i).getPeriodType()))
		    {
			BigDecimal period = NumberUtil.emptyDecimalToZero(trxMgntLstCO.get(i).getPeriod());
			if("W".equals(trxMgntLstCO.get(i).getPeriodType()))
			{
			    /*
			     * Each week = 7 Days
			     */
			    period = period.multiply(new BigDecimal(7));
			}

			/*
			 * Count The No Of The Repeated Period If repeatedPeriod
			 * = 0 => We are In The First Repeated Period.
			 */
			BigDecimal repeatedPeriod = (new BigDecimal(nbOfDays)).divide(period, RoundingMode.HALF_UP);
			/*
			 * Get The Total Period Repeted If We are In The First
			 * Repeted Period =>repeatedPeriod = 0 => totalPeriod =
			 * 0
			 */
			BigDecimal totalPeriod = repeatedPeriod.multiply(period);
			/*
			 * IF totalPeriod = 0 => ldFirstPeriod = openDate
			 */
			ldFirstPeriod = DateUtil.relativeDate(trxMgntSC.getOpenDate(), totalPeriod.intValue());
			/*
			 * IF totalPeriod = 0 => ldLastPeriod = openDate +
			 * period - 1
			 */
			ldLastPeriod = DateUtil.relativeDate(trxMgntSC.getOpenDate(), (totalPeriod.intValue()
				+ period.intValue() - 1));
		    }
		    /*
		     * Monthly
		     */
		    else
		    {
			BigDecimal period = NumberUtil.emptyDecimalToZero(trxMgntLstCO.get(i).getPeriod());
			/*
			 * Count The Months Between The Trs & Open Date
			 */
			Double nbOfMonths = DateUtil.getMonthsDifference(trxMgntSC.getOpenDate(), trxMgntSC
				.getRunningDate());
			/*
			 * Get The Number Of the Repeated Period If
			 * repeatedPeriod = 0 => We are In The First Repeted
			 * Period.
			 */
			BigDecimal repeatedPeriod = (new BigDecimal(nbOfMonths.toString())).divide((NumberUtil
				.emptyDecimalToZero(trxMgntLstCO.get(i).getPeriod())));
			/*
			 * Get The Total Period Repeted If We are In The First
			 * Repeted Period => repeatedPeriod = 0 => totalPeriod =
			 * 0
			 */
			BigDecimal totalPeriod = repeatedPeriod.multiply(period);
			if(totalPeriod.compareTo(BigDecimal.ZERO) == 0)
			{
			    ldFirstPeriod = trxMgntSC.getOpenDate();
			}
			else
			{
			    ldFirstPeriod = DateUtil.relativeMonth(trxMgntSC.getOpenDate(), totalPeriod.intValue());
			}
			ldLastPeriod = DateUtil.relativeMonth(trxMgntSC.getOpenDate(), (totalPeriod.intValue() + period
				.intValue()));
		    }

		    trxMgntSC.setFirstPeriod(ldFirstPeriod);
		    trxMgntSC.setLastPeriod(ldLastPeriod);
		    totalTransAmount = coreCommonServiceDAO.returnTotalAmountBetweenFirstAndLastPeriod(trxMgntSC);
		    /*
		     * Set The Decimal Point Of The Base Currency
		     */
		    totalTransAmount = NumberUtil.roundToBigDecimal(totalTransAmount, trxMgntSC.getDecimalPoints()
			    .intValue());
		    
		     
			AmountCO amountCO = new AmountCO();
			amountCO.setBaseCurrency(trxMgntSC.getBaseCurrencyCode());
			amountCO.setCvAmount(totalTransAmount);
			amountCO.setCurrencyAccount(trxMgntSC.getTrsCy());
			amountCO.setCompCode(trxMgntSC.getCompCode());
			amountCO.setRunningDate(trxMgntSC.getRunningDate());
			amountCO = commonLibBO.selectComputedFCAmount(amountCO);
			if(amountCO != null)
			{
			    totalTransAmount = amountCO.getFcAmount();
			} 

		}

		/*
		 * Add The Amount Of The Current Trs To The Total Amount
		 */
		totalTransAmount = totalTransAmount.add(NumberUtil.emptyDecimalToZero(trxMgntSC.getAmount()));
		if(totalTransAmount.compareTo(NumberUtil.emptyDecimalToZero(trxMgntLstCO.get(i).getTotalAmount())) > 0)
		{
		    /*
		     * The Amount Is Exceeded
		     */
		    lbExceed = true;
		    break;
		}
	    }
	    /*
	     * The Amount Is Exceeded
	     */
	    if(lbExceed)
	    {
		return -1;
	    }
	}
	/*
	 * The Amount Is Not Exceeded
	 */
	return 0;
    }

    /**
     * This function will insert an alert in S_TODO_DET table. PB =
     * n_transaction.uf_send_money_laundring_alert_user
     * 
     * @author nabilfeghali
     * @param trxMgntCO trxMgntCO.getLoginUserId() trxMgntCO.getOriginCompCode()
     *            trxMgntCO.getOriginBraCode() trxMgntCO.getAppName()
     *            trxMgntCO.getRunningDate()
     * 
     *            type = 'M' --> Money Laundring type = 'Y' --> Transaction
     *            Approved
     * 
     * @throws BaseException
     */
    private void sendMoneyLaundringAlertUser(TrxMgntCO trxMgntCO, String userId, String type, String periodicityType)
	    throws BaseException
    {
	StringBuffer isExcepEng;

	if(trxMgntCO.getCtstrsVO().getEXCEP_APP() == null)
	{
	    isExcepEng = new StringBuffer("");
	}
	else
	{
	    isExcepEng = new StringBuffer(trxMgntCO.getCtstrsVO().getEXCEP_APP());
	}

	if(isExcepEng != null && isExcepEng.indexOf(AlertsConstants.TRX_ADD_CODE_ML) != -1)
	{
	    isExcepEng.append(AlertsConstants.TRX_ADD_CODE_ML + ",");
	    trxMgntCO.getCtstrsVO().setEXCEP_APP(isExcepEng.toString());
	}

	S_TODO_DETVO sToDoDetVO = new S_TODO_DETVO();

	AlertsSC alertsSC = new AlertsSC();
	alertsSC.setTellerId(trxMgntCO.getLoginUserId());
	alertsSC.setUserId(userId);
	alertsSC.setUserAction(AlertsConstants.USER_ACTION_G);
	alertsSC.setJobAction(AlertsConstants.JOB_ACTION_G);
	alertsSC = alertsBO.callToDoDet(alertsSC);

	sToDoDetVO.setTODO_CODE(alertsSC.getTodoCode());
	sToDoDetVO.setTODO_LINE(alertsSC.getTodoLine());
	sToDoDetVO.setJOB_ID(alertsSC.getJobId());
	sToDoDetVO.setCOMP_CODE(trxMgntCO.getOriginCompCode());
	sToDoDetVO.setBRANCH_CODE(trxMgntCO.getOriginBraCode());
	sToDoDetVO.setDISTRIBUTION_TYPE(AlertsConstants.DISTRIBUTION_TYPE_B);
	sToDoDetVO.setDISTRIBUTION_TO(AlertsConstants.DISTRIBUTION_TO_U);
	sToDoDetVO.setBRIEF_NAME_ENG("");
	sToDoDetVO.setBRIEF_NAME_ARAB("");
	// NABIL FEGHALI - SRS IIAB120051
	if(TrxMgntConstant.TRX_ML_PERIODICITY_CURRENT.equals(periodicityType))
	{
	    sToDoDetVO.setBRIEF_NAME_ENG(TrxMgntConstant.TRX_ML_PERIODICITY_CURRENT);
	}

	sToDoDetVO.setTODO_TYPE(AlertsConstants.TODO_TYPE_P);
	sToDoDetVO.setTODO_APPLICATION(trxMgntCO.getAppName());
	sToDoDetVO.setTODO_PROG_REF(AlertsConstants.TRX_MONEY_LAUNDRING_PROGREF);
	sToDoDetVO.setUSER_ID(userId);
	sToDoDetVO.setTODO_PRIORITY(AlertsConstants.TODO_PRIORITY_A);
	sToDoDetVO.setTODO_STATUS(AlertsConstants.STATUS_ACTIVE);
	sToDoDetVO.setALLOW_TO_SEND(BigDecimal.ZERO);
	sToDoDetVO.setDATE_RECEIVED(trxMgntCO.getRunningDate());
	sToDoDetVO.setRECEIVED_FROM(trxMgntCO.getLoginUserId());
	sToDoDetVO.setTODO_CHECKED(AlertsConstants.TODO_CHECKED_U);
	sToDoDetVO.setTODO_PARAM(NumberUtil.emptyDecimalToZero(trxMgntCO.getCtstrsVO().getTRS_NO()).toString());
	sToDoDetVO.setTODO_EXECUTION(AlertsConstants.TODO_EXECUTION_N);
	sToDoDetVO.setTRX_NUMBER("");
	sToDoDetVO.setTODO_ALERT(type);
	sToDoDetVO.setTODO_REASON(isExcepEng.toString());

	alertsBO.saveAlert(sToDoDetVO);
    }

    public ArrayList<TrxMgntCO> returnCifTrxTrendsDet(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonServiceDAO.returnCifTrxTrendsDet(trxMgntSC);
    }

    public ArrayList<TrxMgntCO> returnRifObtTrendsDet(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonServiceDAO.returnRifObtTrendsDet(trxMgntSC);
    }

    public ArrayList<TrxMgntCO> returnCtsTrxTypeMl(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonServiceDAO.returnCtsTrxTypeMl(trxMgntSC);
    }

    public ArrayList<TrxMgntCO> returnCtsControlMl(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonServiceDAO.returnCtsControlMl(trxMgntSC);
    }
    
    /**
     * @author elieachkar
     * @Modified By Chady : replace Param From CO to SC
     * @param trxMgntCO
     * @return
     * @throws BaseException
     * n_transaction.f_get_avlbal_br()
     * This Function Gets the Available and Active Balance in the Account
     * needed properties:
     * trxMgntCO.getLoginCompCode()
     * trxMgntCO.getBaseCurrencyCode()
     */
    public BigDecimal returnAvailBalBr(TrxMgntSC trxMgntSC) throws BaseException
    {
	AccountPositionCO accPositionCO = new AccountPositionCO();
	
	accPositionCO.setLoginCompCode(trxMgntSC.getCompCode());
	accPositionCO.setBaseCurrencyCode(trxMgntSC.getBaseCurrencyCode());
	accPositionCO.setAmfVO(new AMFVO());
	accPositionCO.getAmfVO().setCUR_AC_BR(trxMgntSC.getTrsAcBr());
	accPositionCO.getAmfVO().setCUR_AC_CY(trxMgntSC.getTrsAcCy());
	accPositionCO.getAmfVO().setCUR_AC_GL(trxMgntSC.getTrsAcGl());
	accPositionCO.getAmfVO().setCUR_AC_CIF(trxMgntSC.getTrsAcCif());
	accPositionCO.getAmfVO().setCUR_AC_SL(trxMgntSC.getTrsAcSl());
	accPositionCO.setCtsTrxTypeVO(new CTSTRXTYPEVO());
	accPositionCO.getCtsTrxTypeVO().setBLOCK_ACTIVE_WITH(trxMgntSC.getBlockActiveWith());
	
	return coreCommonProcedureBO.returnAvlBalBR(accPositionCO);
    }
    
    /**
     * Performs Checking on Special Conditions for AMF, calls procedure to check
     * and then returns Warning/ Error messages.
     * 
     * 
     * @author redacharabaty
     * @param AccountCO AccountCO.creditDebit Should be Filled "C" when Checking
     *            Credit Restrictions/ "D" when checking Debit Restrictions /
     *            "B" for Both AccountCO.amfVO.COMP_CODE COMPANY CODE
     *            AccountCO.amfVO.BRANCH_CODE BRANCH CODE OF THE ACCOUNT
     *            AccountCO.amfVO.CURRENCY_CODE CURRENCY CODE OF THE ACCOUNT
     *            AccountCO.amfVO.GL_CODE GL CODE OF THE ACCOUNT
     *            AccountCO.amfVO.CIF_SUB_NO CIF OF THE ACCOUNT
     *            AccountCO.amfVO.SL_NO SL NO OF THE ACCOUNT
     * 
     * 
     * @return String
     * @throws BaseException
     */
    public AccountCO checkAMFSpecialConditions(AccountCO accountCO1) throws BaseException
    {
	AccountCO accountCO = accountCO1;
	/*
	 * Check on Account Restrictions
	 */
	accountCO.setCifAcc(CoreCommonConstants.ACCOUNT);

	/*
	 * Call Standing Order Procedure
	 */
	accountCO = specialConditions(accountCO);
	
	if(accountCO == null)
	{
	    return null;
	}
	//Hala Al Sheikh - Special Condition Wrapper
	if(!"RET".equals(accountCO.getAppName()) && !"".equals(StringUtil.nullToEmpty(accountCO.getAppName()))
		&& accountCO.getIsSybase() == 1 )
	{
	    accountCO.setMultiTrx("0");
	    accountCO = coreCommonProcedureBO.wrapSpecialCondition(accountCO);
	}
	
	//Bassam Eid - BUG# 512170
	if(ConstantsCommon.ONE.equals(accountCO.getMakeForbidAsRestrict())
		&& ConstantsCommon.YES.equals(ConstantsCommon.APPLY_BURG_SPECIAL_COND_BEHAVIOR))
	{
	    if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_BOTH))
	    {	
		accountCO.setFORBID_TRX(CoreCommonConstants.FORBID_TRX_RESTRICT_BOTH);
	    }
	    else if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_DEBIT))
	    {	
		accountCO.setFORBID_TRX(CoreCommonConstants.FORBID_TRX_RESTRICT_DEBIT);
	    }
	    else if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_CREDIT))
	    {
		accountCO.setFORBID_TRX(CoreCommonConstants.FORBID_TRX_RESTRICT_CREDIT);
	    }
	}
	///////////////////////////

	String accountString = null;

	/*
	 * In Case of No Debit Restrictions on Account, check for CIF Debit
	 * Restrictions
	 */
	if(accountCO.getFORBID_TRX() == null
		|| accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_NOT_APPLICABLE)
		|| ((accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_CREDIT) || accountCO
			.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_RESTRICT_CREDIT)) && accountCO
			.getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_DEBIT))
		|| ((accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_DEBIT) || accountCO
			.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_RESTRICT_DEBIT)) && accountCO
			.getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_CREDIT)))
	{
	    /*
	     * Check on CIF Restrictions
	     */
	    accountCO.setCifAcc(CoreCommonConstants.CIF);
	    accountCO.getCifVO().setCIF_NO(accountCO.getAmfVO().getCIF_SUB_NO());
	    /*
	     * Call Standing Order Procedure
	     */
	    accountCO = specialConditions(accountCO);

	    if(accountCO == null
		    || accountCO.getFORBID_TRX() == null
		    || accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_NOT_APPLICABLE)
		    || ((accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_CREDIT) || accountCO
			    .getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_RESTRICT_CREDIT)) && accountCO
			    .getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_DEBIT))
		    || ((accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_DEBIT) || accountCO
			    .getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_RESTRICT_DEBIT)) && accountCO
			    .getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_CREDIT)))
	    {
		accountCO.setWarningMessage("");
		return accountCO;
	    }
	}
//	else
//	{
//
//
//	    // accountString = accountCO.getAmfVO().getBRANCH_CODE().toString()
//	    // + "-";
//	    // accountString +=
//	    // accountCO.getAmfVO().getCURRENCY_CODE().toString() + "-";
//	    // accountString += accountCO.getAmfVO().getGL_CODE().toString() +
//	    // "-";
//	    // accountString += accountCO.getAmfVO().getCIF_SUB_NO().toString()
//	    // + "-";
//	    // accountString += accountCO.getAmfVO().getSL_NO().toString();
//	}
	
	/*
	 * Build String to be used as argument in message
	 */

	StringBuilder strBldr = new StringBuilder();
	strBldr.append(accountCO.getAmfVO().getBRANCH_CODE().toString());
	strBldr.append("-");
	strBldr.append(accountCO.getAmfVO().getCURRENCY_CODE().toString());
	strBldr.append("-");
	strBldr.append(accountCO.getAmfVO().getGL_CODE().toString());
	strBldr.append("-");
	strBldr.append(accountCO.getAmfVO().getCIF_SUB_NO().toString());
	strBldr.append("-");
	strBldr.append(accountCO.getAmfVO().getSL_NO().toString());
	strBldr.trimToSize();
	accountString = strBldr.toString();

	/*
	 * Set Reason
	 */
	String reason;
	if(ConstantsCommon.PREFERED_LANG_LATIN.equals(accountCO.getLoginPreferrredLanguage()))
	{
	    reason = accountCO.getReasonEng();
	}
	else
	{
	    reason = accountCO.getReasonAr();
	}

	/*
	 * Forbid/Restrict Both
	 */
	if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_BOTH)) // Forbid
	// Both
	{
	    throw new BOException(MessageCodes.CLIENT_FORBID_FROM_CRED_DEB_ACCOUNT, new String[] { accountString,
		    reason });
	}
	else if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_RESTRICT_BOTH))// Restrict
	// Both
	{
	    accountCO.setWarningMessage(commonLibBO.returnTranslErrorMessage(MessageCodes.CLIENT_RESTRCT_FROM_CRED_DEB_ACC_PARAM, new String[] {
		    accountString, reason }, accountCO.getLoginPreferrredLanguage()) );
	    return accountCO;
	}

	/*
	 * Forbid/Restrict Debit
	 */
	//TP#283420 accountString was equal null 
	if((accountCO.getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_DEBIT)
		|| accountCO.getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_BOTH)) && accountString != null)  // Checking
	// on
	// Debit
	// Restrictions
	{
	    if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_DEBIT)) // Forbid
	    // Debit
	    {
		throw new BOException(MessageCodes.CLIENT_FORBIDDEN_FROM_DEBITING_ACCOUNT, new String[] {
			accountString, reason });
	    }
	    else if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_RESTRICT_DEBIT)) // Restrict
	    // Debit
	    {
		accountCO.setWarningMessage(commonLibBO.returnTranslErrorMessage(MessageCodes.CLIENT_RESTRICTED_FROM_DEBITING_ACCOUNT,
			new String[] { accountString, reason }, accountCO.getLanguage()));
		return accountCO;
	    }
	}

	/*
	 * Forbid/Restrict Credit
	 */
	if((accountCO.getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_CREDIT)
		|| accountCO.getCreditDebit().equals(ConstantsCommon.ACCOUNT_SIGN_BOTH)) && accountString != null)// Checking
	// on
	// Credit
	// Restrictions
	{
	    if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_FORBID_CREDIT)) // Forbid
	    // Credit
	    {
		throw new BOException(MessageCodes.CLIENT_FORBIDDEN_FROM_CREDITING_ACCOUNT, new String[] {
			accountString, reason });
	    }
	    else if(accountCO.getFORBID_TRX().equals(CoreCommonConstants.FORBID_TRX_RESTRICT_CREDIT)) // Restrict
	    // Credit
	    {
		accountCO.setWarningMessage(commonLibBO.returnTranslErrorMessage(MessageCodes.CLIENT_RESTRICTED_FROM_CREDITING_ACCOUNT,
			new String[] { accountString, reason }, accountCO.getLanguage()) );
		return accountCO;
	    }
	}
	return accountCO;
    }
    
    public AccountCO specialConditions(AccountCO accountCO1) throws BaseException
    {
	AccountCO accountCO = accountCO1;
	/*
	 * Checking on Account and CIF restrictions
	 */accountCO = coreCommonProcedureBO.specialConditions(accountCO);

	return accountCO;
    }
    
    
    /**
     * BB140191
     * 
     * @author Sarah Elhusseini   copied by antonella andraos
     * This function check the 3 conditions which are :
     *  1- if the card reader is enable for this id type
     *  2- if the MICR on civil ID is enable which makes the third condition enable
     *  3- if the flag "Default customer info from ID card" id enabled to default customer
     *  information from card which is the purpose of the modif
     * @param fomCO
     */
    public String checkCardReaderEnability(IdTypeSC idTypeSC) throws BaseException
    {
	if(!NumberUtil.isEmptyDecimal(idTypeSC.getTrxType()))
	{
	    TrxMgntCO trxMgntCO = new TrxMgntCO();
	    trxMgntCO.setLoginCompCode(idTypeSC.getCompCode());
	    trxMgntCO.getCtstrsVO().setTRX_TYPE(idTypeSC.getTrxType());
	    trxMgntCO = returnCommonVariables(trxMgntCO);

	    if("1".equals(trxMgntCO.getCtstrxtypeVO().getENABLE_MCR()) &&
	       "1".equals(trxMgntCO.getCtstrxtypeVO().getCUSTOMER_INFO_ID_CARD_YN()) &&
	       "1".equals(StringUtil.nullToEmpty(idTypeSC.getEnableMagneticCardReader())))
	    {
		return "1";
	    }
	}
	return "0";
    }
    
    /**
     * @author eliasaoun - hasanyoussef
     * @param CompCode / Cif_no
     * @modif EWBI160091 (403157)- Modification of CIF
     * this method is created to check whether we should handle a CIF with negative COMP_CODE based on flag in CIFCONTROL.PROCEED_ON_MODIFIED_CIF_YN,
     * by calling the procedure P_RET_PROCESS_TEMP_CIF
     */
    public CifSC callCifUpdate(CifSC cifSC) throws BaseException
    {
	Assert.notNull(cifSC.getCompCode());
	Assert.notNull(cifSC.getCif_no());

	if(checkNegativeComp(cifSC, true) == 1)
	{
	    CifSC returnedcifSC = coreCommonProcedureBO.callCifUpdate(cifSC);
	    if(returnedcifSC != null && returnedcifSC.getErrorCode() != null
		    && NumberUtil.nullToZero(returnedcifSC.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
	    {
		//throw new BOException(returnedcifSC.getErrorMessage());
	    }
	    cifSC.setCompCodeCif(cifSC.getCompCode().abs().negate());
	}
	return cifSC;
    }


    /**
     * @author eliasaoun
     * @modif EWBI160091 (403157)- Modification of CIF
     * @param criteria
     * @param afterApproveOrLoad to identify if the CIF has negatif record, or it has been approved
     */
    private CIFVO checkNegativeCompCif(CifSC criteria, boolean afterApproveOrLoad) throws BaseException
    {
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(criteria.getCompCode().abs());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	if(cifControlVO != null)
	{
	    if("1".equals(cifControlVO.getPROCEED_ON_MODIFIED_CIF_YN()))
	    {
		if(StringUtil.isNotEmpty(criteria.getSectionKey()))
		{
		    String originalProgRef = commonLibBO.returnOrginProgRef(criteria.getCurrAppName(), criteria.getSectionKey());
		    String[] optDetails = commonLibBO.returnOptDetailsList(criteria.getCurrAppName(), originalProgRef);
		    if(optDetails != null && optDetails[3] != null
			    && !ConstantsCommon.PROGREF_ROOT.equals(optDetails[3]))
		    {
			if(!ConstantsCommon.FOM_OPT.equals(optDetails[3]))
			{
			    return null;
			}
		    }
		}
		
		CIFVO cifVO = new CIFVO();
		cifVO.setCIF_NO(criteria.getCif_no());
		if(afterApproveOrLoad)
		{
		    cifVO.setCOMP_CODE(criteria.getCompCode().abs());
		}
		else
		{
		    cifVO.setCOMP_CODE(criteria.getCompCode().negate());
		}
		cifVO = (CIFVO) genericDAO.selectByPK(cifVO);
		if(afterApproveOrLoad)
		{
		    if(cifVO != null)
		    {
			// check if the CIF is approved or not, because once it is approved, we should modify a negative one
			if(cifVO.getAPPROVED_BY() != null)
			{
			    return cifVO;
			}
		    }
		}
		else
		{
		    return cifVO;
		}
	    }
	}
	return null;
    }   
    
    /**
     * 
     * @param criteria
     * @param afterApproveOrLoad : flag to check on existence of negative or positive CIF
     * @return 0 we should work on positive CIF, 1 work on negative CIF
     * @throws BaseException
     */
    private int checkNegativeComp(CifSC criteria, boolean afterApproveOrLoad) throws BaseException
    {
	if(checkNegativeCompCif(criteria, afterApproveOrLoad) == null)
	{
	    return 0;
	}
	else
	{
	    return 1;
	}
    }

    public int checkNegativeComp(CifSC criteria) throws BaseException
    {
	return checkNegativeComp( criteria, false);
    }
    
    public int checkNegativeCompApproved(CifSC criteria) throws BaseException
    {
	return checkNegativeComp( criteria, true);
    }
    
    /**
     * @param the Object used for audit
     * @return the target object with COMP_CODE positive > 0
     **/
    public Object returnCifAbs(Object objectBean) throws BaseException
    {
	Object destObj = null;
	try
	{
	    destObj = objectBean.getClass().newInstance();
	    PathPropertyUtil.copyProperties(objectBean, destObj);
	    PropertyUtils.setProperty(destObj, "COMP_CODE", ((BigDecimal) PropertyUtils.getProperty(destObj, "COMP_CODE")).abs());
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return destObj == null ? objectBean : destObj;
    }
    
    // added by nancy -- 06/07/2018-- 382769-account limits
    public int returncountConfMsg (CtstrsConfMsgSC ctstrsConfMsgSC) throws BaseException
    {
	return coreCommonServiceDAO.returncountConfMsg(ctstrsConfMsgSC);
    }
    
    public List<CTSTRS_CONF_MSGVO> returnConfMsg(CtstrsConfMsgSC ctstrsConfMsgSC) throws BaseException
    {
	List<CTSTRS_CONF_MSGVO> ctrstrsConfMsgList = coreCommonServiceDAO.returnConfMsg(ctstrsConfMsgSC);
	return ctrstrsConfMsgList;
    }
    
    public int checkIfLimitationActionExists(CtstrsConfMsgSC ctstrsConfMsgSC) throws BaseException
    {
	return coreCommonServiceDAO.checkIfLimitationActionExists(ctstrsConfMsgSC);
    }
    
    public int returnTierNo(AccountSC accountSC) throws BaseException
    {
	return coreCommonServiceDAO.returnTierNo(accountSC);
    }
    
    @Override
    public FomCO checkIdDigits(FomCO fomCO) throws BaseException
    {
	// TODO Auto-generated method stub
	// added just for compilation error since we are using this method in CoreCommonServiceBOImpl of R14.0.16
	return null;
    }
    
    //DASI180298 - Ctrl F2 Parameter
    public void setPhoneLength(AddressCommonCO addressCommonCO, FomCO fomCO) throws BaseException
    {
	CountriesSC countriesSC = new CountriesSC();
	countriesSC.setCompCode(addressCommonCO.getCOMP_CODE());
	countriesSC.setPreferredLanguage(addressCommonCO.getPreferredLanguage());
	countriesSC.setLanguage(addressCommonCO.getPreferredLanguage());
	countriesSC.setCountryCode(fomCO.getCifVO().getCOUNTRY());

	CountriesCO countriesCO = countriesBO.returnCountryById(countriesSC);
	countriesCO.getCountriesVO().setCOMP_CODE(addressCommonCO.getCOMP_CODE());
	countriesCO.setRegionCode(fomCO.getCifVO().getREGION_CODE());

	HashMap<String, String> hm = coreCommonServiceBO.returnPhoneByCountry(countriesCO);
	String phoneFormat = StringUtil.nullToEmpty(hm.get("format"));

	String[] inputDependent = new String[] { FomElementsConstant.MOBILE_ID,
		FomElementsConstant.TEL_ID + "_" + addressCommonCO.getOpt(), FomElementsConstant.WORK_TEL_ID,
		FomElementsConstant.OTHER_TEL_ID, FomElementsConstant.FAX_ID,
		FomElementsConstant.REFERENCES_TEL_ID + "_" + addressCommonCO.getOpt(),
		FomElementsConstant.REFERENCES_TELEX_ID + "_" + addressCommonCO.getOpt(),
		FomElementsConstant.REFERENCES_FAX_ID + "_" + addressCommonCO.getOpt() };

	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

	applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_TXTFORMAT, phoneFormat, elementHashmap, null);
	
	
	
	if(StringUtil.isNotEmpty(phoneFormat))
	{
	    applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH,
		    String.valueOf(phoneFormat.length() + 1), elementHashmap, null);
	}
	else
	{
	    if(fomCO.getBuisnessElement() != null && null != fomCO.getBuisnessElement().get("addressCO_TEL"))
	    {
		applyDynScreenDisplay(inputDependent, ConstantsCommon.ACTION_TYPE_MAXLENGTH,
			String.valueOf(fomCO.getBuisnessElement().get("addressCO_TEL").getMAX_LENGTH()), elementHashmap, null);
	    }
	}
	    
    }
    
    /**
     * @author RaniaAlBitar
     * ABSAI180073
     * @param cifSC
     * @throws BaseException
     */
    public CifSC calculateScoringForCifNo(CifSC cifSC) throws BaseException
    {
	FomCO fomCO = new FomCO();
	FomCO fomCOTemp = new FomCO();
	CIF_EXTENDEDVO cifExtendedVO = new CIF_EXTENDEDVO();
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	
	cifControlVO.setCOMP_CODE(cifSC.getCompCode()); //TODO to pass it as param
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);


	if("1".equals(cifControlVO.getENABLE_SCORING_YN()))
	{
	    fomCO.setLoginCompCode(cifSC.getCompCode());
	    fomCO.setLoginBraCode(cifSC.getBranchCode()); //TODO to pass it as param
	    fomCO.setCifVO(new CIFVO());
	    fomCO.setLoginUserId(cifSC.getUserId());//TODO to pass it as param
	    fomCO.setRunType("M");
	    fomCO.setRunningDate(cifSC.getRunningDate());
	    fomCO.setCifExtendedVO(new CIF_EXTENDEDVO());
	    
	    // Main Account

	    if(NumberUtil.emptyDecimalToNull(cifSC.getCif_no()) != null)//TODO to pass it as param
	    {
		fomCO.getCifVO().setCIF_NO(cifSC.getCif_no());
		fomCOTemp = coreCommonProcedureBO.executeScoringProcess(fomCO);

		if(fomCOTemp != null && NumberUtil.emptyDecimalToNull(fomCOTemp.getErrorCode()) != null 
			&& fomCOTemp.getErrorCode().compareTo(BigDecimal.ZERO) < 0)
		{
		    cifSC.setErrorMessage(fomCOTemp.getErrorDesc());
		}
		
		fomCO.getCifExtendedVO().setSCORE_RISK_VALUE(fomCOTemp.getScoreRiskValue());
		cifExtendedVO = new CIF_EXTENDEDVO();
		cifExtendedVO.setCOMP_CODE(cifSC.getCompCode());
		cifExtendedVO.setBRANCH_CODE(cifSC.getBranchCode());
		cifExtendedVO.setCIF_NO(cifSC.getCif_no());
		
		cifExtendedVO = (CIF_EXTENDEDVO)genericDAO.selectByPK(cifExtendedVO);
		
		if("1".equals(cifControlVO.getRETAIN_HIGHEST_SCORE_YN()) 
			&& cifExtendedVO != null && NumberUtil.emptyDecimalToZero(cifExtendedVO.getSCORE_RISK_VALUE()).compareTo(NumberUtil.emptyDecimalToZero(fomCOTemp.getScoreRiskValue())) > 0)
		{
		    fomCO.getCifExtendedVO().setSCORE_RISK_VALUE(cifExtendedVO.getSCORE_RISK_VALUE());
		}
		
		if(cifExtendedVO != null)
		{
		    genericDAO.update(cifExtendedVO);
		}

	    }
	}
	
	return cifSC;
    }

    // end nancy 
  
  //Hala Al Sheikh - BIPL180103
    public void checkFomBtnCifBlackList(FomCO fomCO) throws BaseException
    {
	boolean checkBlacklist = false;
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(fomCO.getLoginCompCode());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);

	if((NCifMaintenanceConstant.FOM_OWNERSHIP_BLKLLIST.equals(StringUtil.nullToEmpty(fomCO.getBlackListInCifName()))
		&& "1".equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_OWNERSHIP_YN())))
		|| (NCifMaintenanceConstant.FOM_OCCUPATION_BLKLLIST
			.equals(StringUtil.nullToEmpty(fomCO.getBlackListInCifName()))
			&& "1".equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_OCCUPATION_YN())))
		|| (NCifMaintenanceConstant.FOM_OTHER_FIN_ENGAGE_BLKLLIST
			.equals(StringUtil.nullToEmpty(fomCO.getBlackListInCifName()))
			&& "1".equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_OTHER_FINANCE_YN())))
		|| (NCifMaintenanceConstant.FOM_MORE_SIG_BLKLLIST
			.equals(StringUtil.nullToEmpty(fomCO.getBlackListInCifName()))
			&& "1".equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_MORE_SIGN_YN())))
		|| (NCifMaintenanceConstant.FOM_REAL_BENEF_BLKLLIST
			.equals(StringUtil.nullToEmpty(fomCO.getBlackListInCifName()))
			&& "1".equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_REAL_BENEF_YN())))
		|| (NCifMaintenanceConstant.FOM_JOINT_DETAILS_BLKLLIST
			.equals(StringUtil.nullToEmpty(fomCO.getBlackListInCifName()))
			&& "1".equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_JOINT_DETAILS_YN())))
		|| (NCifMaintenanceConstant.FOM_PROXY_BLKLLIST
			.equals(StringUtil.nullToEmpty(fomCO.getBlackListInCifName()))
			&& "1".equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_PROXIES_YN()))))

	{
	    if(!NumberUtil.isEmptyDecimal(NumberUtil.emptyDecimalToNull(fomCO.getCifVO().getCIF_NO()))
		    && NCifMaintenanceConstant.FOM_BLKLIST_FROM_DEPENDENCY.equals(fomCO.getBlackListAction()))
	    {
		CifSC criteria = new CifSC();
		criteria.setCompCode(fomCO.getLoginCompCode());
		criteria.setCif_no(fomCO.getCifVO().getCIF_NO());

		CIFVO cifVO1 = new CIFVO();
		cifVO1.setCOMP_CODE(fomCO.getLoginCompCode());
		cifVO1.setCIF_NO(fomCO.getCifVO().getCIF_NO());
		cifVO1 = (CIFVO) genericDAO.selectByPK(cifVO1);

		if("1".equals(StringUtil.nullToEmpty(cifVO1.getBLACK_LISTED())))
		{
		    checkBlacklist = true;
		}
	    }
	    else if(NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_NO())
		    && NCifMaintenanceConstant.FOM_BLKLIST_FROM_SAVE.equals(fomCO.getBlackListAction()))
	    {

		boolean checkNameMatch = false;
		MosBlackListCO mosBlackListCO = new MosBlackListCO();
		CIFVO cifDataVo = fomCO.getCifVO();
		mosBlackListCO.setCompCode(cifDataVo.getCOMP_CODE());
		mosBlackListCO.setCifVO(cifDataVo);
		mosBlackListCO.setAppName(ConstantsCommon.RET_APP_NAME);

		MosBlackListSC mosBlackListSC = new MosBlackListSC();
		mosBlackListSC.setCompCode(cifDataVo.getCOMP_CODE());
		mosBlackListSC.setCifNO(cifDataVo.getCIF_NO());
		ArrayList<CifBlckLstVO> cifBlckLstList = mosBlackListBO.returncifBlackList(mosBlackListSC);
		mosBlackListCO.setCifBlckLstVO(cifBlckLstList);

		if((!NumberUtil.isEmptyDecimal(fomCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC()))
			&& ((fomCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC()).compareTo(BigDecimal.ZERO) > 0))
		{
		    checkNameMatch = returnBlackListPercentMatching(fomCO);
		}

		if((checkNameMatch && (!NumberUtil.isEmptyDecimal(fomCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC()))
			&& ((fomCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC()).compareTo(BigDecimal.ZERO) > 0))
			|| (NumberUtil.isEmptyDecimal(fomCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC())))
		{
		    checkBlacklist = mosBlackListBO.checkCifBlcklist(mosBlackListCO);
		    fomCO.setCriteriaPerc(mosBlackListCO.getCriteriaPerc());
		}

	    }
	}
	if(checkBlacklist)
	{
	    if(NCifMaintenanceConstant.DONT_PROCEED_ON_BLACKLISTED_CIF.equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_PROCEED_LIST())))
	    {
		throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
	    }
	    else if(NCifMaintenanceConstant.WARN_PROCEED_ON_BLACKLISTED_CIF.equals(StringUtil.nullToEmpty(cifControlVO.getBLCKL_PROCEED_LIST())))
	    {
		fomCO.setBlkListWarnMessage(commonLibBO.returnTranslErrorMessage(MessageCodes.CIF_IS_BLACKLISTED,fomCO.getLoginPreferrredLanguage()));
		fomCO.getWarningListCode().add(MessageCodes.CIF_IS_BLACKLISTED);
	    }
	}
    }    
    

    //moving this from fomBO
    public boolean returnBlackListPercentMatching(FomCO fomCO)throws BaseException
    {

//	String newName = "";
//
//	char[] userTextt = userText.toCharArray();
//	for(char tmp : userTextt)
//	{
//
//	    newName = newName + " " + tmp;
//	}
//

//	String newBlackName = "";
//
//	char[] userTexttt = blackText.toCharArray();
//	for(char tmp1 : userTexttt)
//	{
//
//	    newBlackName = newBlackName + " " + tmp1;
//	}
//
//	int Ress = (newName.length()) - (computeDistance(newName, newBlackName));
//	int Tott = (Ress * 100) / (newName.length());	 


	MosBlackListCO mosBlackListCO = new MosBlackListCO();
	CIFVO cifDataVo = fomCO.getCifVO();
	mosBlackListCO.setCompCode(cifDataVo.getCOMP_CODE());
	mosBlackListCO.setCifVO(cifDataVo);
	mosBlackListCO.setAppName(ConstantsCommon.RET_APP_NAME);

	CIFVO cifVO = mosBlackListCO.getCifVO();
	mosBlackListCO.setFrom(cifVO.getCOMP_CODE());

	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(mosBlackListCO.getFrom());
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);

	String sAndOR = cifControlVO.getAND_OR();
	BigDecimal nameMatchingPercent = cifControlVO.getBLCKL_NAME_MATCH_PERC();
	BigDecimal citeriaMatchPercent = cifControlVO.getBLCKL_CRITERIA_MATCH_PERC();
	BigDecimal blackListAction = fomCO.getRifCttVO().getBLACKLIST_ACTION_LIST();
	String sBlkLName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_LNAME());
	String sBlkBName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_BNAME());
	String sBlkLastName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_LAST_NAME());
	String sBlkThrdName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_THRD_NAME());
	String sBlkSecName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_SEC_NAME());
	String sBlkFName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_FST_NAME());
	String sBlkMLName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_MOTHER_LNAME());
	String sBlkMFName = StringUtil.nullToEmpty(cifControlVO.getBLCKL_MOTHER_FNAME());
	int blckListCounter = 0;
	int criteriaCount = 0;
	int blckListPercentSum = 0;
	int messageCount = 0;
	boolean blckListRes = false,  matchedNameOR = false;

	BlackListSC blackListSC = new BlackListSC();
	blackListSC.setLovType(BlackListConstant.BLACK_LIST_STATUS_LOV_TYPE);
	blackListSC.setSectionKey(fomCO.getOriginOpt());
	blackListSC.setCurrAppName(fomCO.getAppName());
	blackListSC.setCompCode(cifDataVo.getCOMP_CODE());
	blackListSC.setCif(null);
	blackListSC.setIvCrud(BlackListConstant.CRUD_MAINTENANCE);
	blackListSC.setNbRec(-1);
	blackListSC.setLangCode(fomCO.getLanguage());

	if(!NumberUtil.isEmptyDecimal(nameMatchingPercent) && !(nameMatchingPercent.equals(BigDecimal.ZERO)))
	{   
	    int briefNCount = 0,longNCount = 0,firstNCount = 0,secNCount = 0,motherFNCount = 0,motherLNCount = 0,thirdNCount = 0,lastNCount = 0,counterNameMatch=1;

	    ArrayList<BlackListCO> blckLstNameList = (ArrayList<BlackListCO>) blackListBO.blackListMgmtList(blackListSC);

	    for(BlackListCO temp : blckLstNameList)
	    {
		criteriaCount = 0;
		blckListCounter = 0;
		blckListPercentSum = 0;

		/* BRIEF NAME name matching percentage */
		if(sBlkBName.equals(ConstantsCommon.BLACKLISTENABLED)
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getSHORT_NAME_ENG()) && StringUtil.isNotEmpty(temp.getBlackListVO().getBRIEF_NAME_ENG()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackBriefNameEN = temp.getBlackListVO().getBRIEF_NAME_ENG();
		    String briefNameEN = fomCO.getCifVO().getSHORT_NAME_ENG();

		    int Res = (blackBriefNameEN.length()) - (computeDistance(blackBriefNameEN, briefNameEN));
		    int Tot = (Res * 100) / (blackBriefNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{
				if(briefNCount==0){
	                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Brief Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(briefNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    briefNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
			    blckListRes = true;
			    return blckListRes;
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
				
//				int mosBlackListCode = fomDAO.returnMosBlackListCode(fomCO);
//				fomCO.setMosBlackListCode(mosBlackListCode);
//				int mosBlackListRecord = fomDAO.returnMosBlackListRecord(fomCO);
//				if (mosBlackListRecord<1) {
//				    
//					MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
//					mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
//					mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
//					mosBlackListVO.setCODE(new BigDecimal(mosBlackListCode));
//					mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
//					mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
//					mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
//					mosBlackListVO.setSTATUS("P");
//					genericDAO.insert(mosBlackListVO);
//				
//				}
				
				if (messageCount<1){
			/*	String warningMsg = commonLibBO.returnTranslErrorMessage(MessageCodes.CIF_IS_BLACKLISTED, fomCO
					.getLanguage());
				warningMsg = warningMsg.replace("<PARAM1>", "");
								
				fomCO.getWarningList().add(warningMsg);*/
				    addWarningMessagesListOnValidate(fomCO, new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");
  
				}
				
				messageCount = 1;
				

			    }

			    /*
			     * if Black List Action = Proceed on Compliance
			     * Decision
			     */
			    else
			    {
				if(briefNCount==0){
	                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Brief Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(briefNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    briefNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
				fomCO.setNameMatchedOR("true");

			    }

			}

		    }

		}

		/* LONG NAME name matching percentage */
		if((sBlkLName.equals(ConstantsCommon.BLACKLISTENABLED))
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getLONG_NAME_ENG())
			&& StringUtil.isNotEmpty(temp.getBlackListVO().getLONG_NAME_ENG()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackLongNameEN = temp.getBlackListVO().getLONG_NAME_ENG();
		    String longNameEN = fomCO.getCifVO().getLONG_NAME_ENG();

		    int Res = (blackLongNameEN.length()) - (computeDistance(blackLongNameEN, longNameEN));
		    int Tot = (Res * 100) / (blackLongNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{

				if(longNCount==0){
	                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Long Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(longNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    longNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
			    blckListRes = true;
			    return blckListRes;
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
				// int mosBlackListCode =
				// fomDAO.returnMosBlackListCode(fomCO);
				// fomCO.setMosBlackListCode(mosBlackListCode);
				// int mosBlackListRecord =
				// fomDAO.returnMosBlackListRecord(fomCO);
				// if (mosBlackListRecord<1) {
				//
				// MOSBLACKLISTVO mosBlackListVO = new
				// MOSBLACKLISTVO();
				// mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
				// mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
				// mosBlackListVO.setCODE(new
				// BigDecimal(mosBlackListCode));
				// mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
				// mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
				// mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
				// mosBlackListVO.setSTATUS("P");
				// genericDAO.insert(mosBlackListVO);
				//
				// }

				if(messageCount < 1)
				{
				    addWarningMessagesListOnValidate(fomCO,
					    new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");

				messageCount = 1;
				}
				
				
			    }

			    /*
			     * if Black List Action = Proceed on Compliance
			     * Decision
			     */
			    else
			    {
				
				if(longNCount==0){
	                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Long Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(longNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    longNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
				
				fomCO.setNameMatchedOR("true");
				

			    }

			}
		    }

		}

		/* LAST NAME name matching percentage */
		if(sBlkLastName.equals(ConstantsCommon.BLACKLISTENABLED)
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getLAST_NAME_ENG()) && StringUtil.isNotEmpty(temp.getBlackListVO().getCIF_LAST_NAME_ENG()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackLastNameEN = temp.getBlackListVO().getCIF_LAST_NAME_ENG();
		    String lastNameEN = fomCO.getCifVO().getLAST_NAME_ENG();

		    int Res = (blackLastNameEN.length()) - (computeDistance(blackLastNameEN, lastNameEN));
		    int Tot = (Res * 100) / (blackLastNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{

				if(lastNCount==0){
	                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Last Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(lastNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    lastNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
			    blckListRes = true;
			    return blckListRes;
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
//				int mosBlackListCode = fomDAO.returnMosBlackListCode(fomCO);
//				fomCO.setMosBlackListCode(mosBlackListCode);
//				int mosBlackListRecord = fomDAO.returnMosBlackListRecord(fomCO);
//				if (mosBlackListRecord<1) {
//				    
//					MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
//					mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
//					mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
//					mosBlackListVO.setCODE(new BigDecimal(mosBlackListCode));
//					mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
//					mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
//					mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
//					mosBlackListVO.setSTATUS("P");
//					genericDAO.insert(mosBlackListVO);
//				
//				}
				
				if (messageCount<1){
				    addWarningMessagesListOnValidate(fomCO, new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");

				messageCount = 1;
				}
			    }

			    /*
			     * if Black List Action = Proceed on Compliance
			     * Decision
			     */
			    else
			    {
				if(lastNCount==0){
	                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Last Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(lastNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    lastNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
				
				fomCO.setNameMatchedOR("true");
				

			    }

			}
		    }

		}

		/* THIRD NAME name matching percentage */
		if(sBlkThrdName.equals(ConstantsCommon.BLACKLISTENABLED)
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getTHIRD_NAME_ENG())&& StringUtil.isNotEmpty(temp.getBlackListVO().getCIF_THIRD_NAME_ENG()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackThirdNameEN = temp.getBlackListVO().getCIF_THIRD_NAME_ENG();
		    String thirdNameEN = fomCO.getCifVO().getTHIRD_NAME_ENG();

		    int Res = (blackThirdNameEN.length()) - (computeDistance(blackThirdNameEN, thirdNameEN));
		    int Tot = (Res * 100) / (blackThirdNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{

			    if(thirdNCount==0){
                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Third Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(thirdNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    thirdNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
			    
			    blckListRes = true;
			    return blckListRes;
			    
			    
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
//				int mosBlackListCode = fomDAO.returnMosBlackListCode(fomCO);
//				fomCO.setMosBlackListCode(mosBlackListCode);
//				int mosBlackListRecord = fomDAO.returnMosBlackListRecord(fomCO);
//				if (mosBlackListRecord<1) {
//				    
//					MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
//					mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
//					mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
//					mosBlackListVO.setCODE(new BigDecimal(mosBlackListCode));
//					mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
//					mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
//					mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
//					mosBlackListVO.setSTATUS("P");
//					genericDAO.insert(mosBlackListVO);
//				
//				}
				
				if (messageCount<1){
				    addWarningMessagesListOnValidate(fomCO, new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");

				messageCount = 1;
				}
			    }

			    /*
			     * if Black List Action = Proceed on Compliance
			     * Decision
			     */
			    else
			    {

				if(thirdNCount == 0)
				{

				    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
				    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
				    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
				    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
				    ctsBlckListNameMatchVO
					    .setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
				    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Third Name");
				    ctsBlckListNameMatchVO.setCRITERIA_VALUE(thirdNameEN);
				    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
				    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
				    thirdNCount = 1;
				    counterNameMatch++;

				}

				fomCO.setNameMatchedOR("true");

			    }

			}
		    }

		}

		/* SECOND NAME name matching percentage */
		if(sBlkSecName.equals(ConstantsCommon.BLACKLISTENABLED)
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getSEC_NAME_ENG()) && StringUtil.isNotEmpty(temp.getBlackListVO().getCIF_SEC_NAME_ENG()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackSecondNameEN = temp.getBlackListVO().getCIF_SEC_NAME_ENG();
		    String secondNameEN = fomCO.getCifVO().getSEC_NAME_ENG();

		    int Res = (blackSecondNameEN.length()) - (computeDistance(blackSecondNameEN, secondNameEN));
		    int Tot = (Res * 100) / (blackSecondNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{

			    
			    if(secNCount==0){
                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Second Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(secondNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    secNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
			    
			    blckListRes = true;
			    return blckListRes;
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
//				int mosBlackListCode = fomDAO.returnMosBlackListCode(fomCO);
//				fomCO.setMosBlackListCode(mosBlackListCode);
//				int mosBlackListRecord = fomDAO.returnMosBlackListRecord(fomCO);
//				if (mosBlackListRecord<1) {
//				    
//					MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
//					mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
//					mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
//					mosBlackListVO.setCODE(new BigDecimal(mosBlackListCode));
//					mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
//					mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
//					mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
//					mosBlackListVO.setSTATUS("P");
//					genericDAO.insert(mosBlackListVO);
//				
//				}
				
				if (messageCount<1){
				    addWarningMessagesListOnValidate(fomCO, new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");

				messageCount = 1;
				}
			    }

			    /*
			     * if Black List Action = Proceed on Compliance
			     * Decision
			     */
			    else
			    {

				if(secNCount == 0)
				{

				    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
				    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
				    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
				    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
				    ctsBlckListNameMatchVO
					    .setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
				    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Second Name");
				    ctsBlckListNameMatchVO.setCRITERIA_VALUE(secondNameEN);
				    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
				    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
				    secNCount = 1;
				    counterNameMatch++;

				}

				fomCO.setNameMatchedOR("true");

			    }

			}

		    }

		}

		/* FIRST NAME name matching percentage */
		if(sBlkFName.equals(ConstantsCommon.BLACKLISTENABLED)
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getLONG_NAME_ENG()) && StringUtil.isNotEmpty(temp.getBlackListVO().getLONG_NAME_ENG()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackFirstNameEN = temp.getBlackListVO().getLONG_NAME_ENG();
		    String firstNameEN = fomCO.getCifVO().getLONG_NAME_ENG();

		    int Res = (blackFirstNameEN.length()) - (computeDistance(blackFirstNameEN, firstNameEN));
		    int Tot = (Res * 100) / (blackFirstNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{
			    
			    if(firstNCount==0){
                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("First Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(firstNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    firstNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }
			    
			    blckListRes = true;
			    return blckListRes;
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
//				int mosBlackListCode = fomDAO.returnMosBlackListCode(fomCO);
//				fomCO.setMosBlackListCode(mosBlackListCode);
//				int mosBlackListRecord = fomDAO.returnMosBlackListRecord(fomCO);
//				if (mosBlackListRecord<1) {
//				    
//					MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
//					mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
//					mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
//					mosBlackListVO.setCODE(new BigDecimal(mosBlackListCode));
//					mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
//					mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
//					mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
//					mosBlackListVO.setSTATUS("P");
//					genericDAO.insert(mosBlackListVO);
//				
//				}
				
				if (messageCount<1){
				    addWarningMessagesListOnValidate(fomCO, new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");

				messageCount = 1;
				}
			    }

			    /*
			     * if Black List Action = Proceed on Compliance
			     * Decision
			     */
			    else
			    {

				if(firstNCount == 0)
				{

				    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
				    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
				    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
				    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
				    ctsBlckListNameMatchVO
					    .setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
				    ctsBlckListNameMatchVO.setCRITERIA_TYPE("First Name");
				    ctsBlckListNameMatchVO.setCRITERIA_VALUE(firstNameEN);
				    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
				    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
				    firstNCount = 1;
				    counterNameMatch++;

				}

				fomCO.setNameMatchedOR("true");

			    }

			}

		    }

		}

		/* MOTHER FIRST NAME name matching percentage */
		if(sBlkMLName.equals(ConstantsCommon.BLACKLISTENABLED)
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getMOTHER_FIRST_NAME())
			&& StringUtil.isNotEmpty(temp.getBlackListVO().getCIF_MOTHER_FNAME()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackMotherFrstNameEN = temp.getBlackListVO().getCIF_MOTHER_FNAME();
		    String motherFrstNameEN = fomCO.getCifVO().getMOTHER_FIRST_NAME();

		    int Res = (blackMotherFrstNameEN.length())
			    - (computeDistance(blackMotherFrstNameEN, motherFrstNameEN));
		    int Tot = (Res * 100) / (blackMotherFrstNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{
			    if(motherFNCount==0){
                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Mother First Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(motherFrstNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    motherFNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }

			    blckListRes = true;
			    return blckListRes;
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
//				int mosBlackListCode = fomDAO.returnMosBlackListCode(fomCO);
//				fomCO.setMosBlackListCode(mosBlackListCode);
//				int mosBlackListRecord = fomDAO.returnMosBlackListRecord(fomCO);
//				if (mosBlackListRecord<1) {
//				    
//					MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
//					mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
//					mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
//					mosBlackListVO.setCODE(new BigDecimal(mosBlackListCode));
//					mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
//					mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
//					mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
//					mosBlackListVO.setSTATUS("P");
//					genericDAO.insert(mosBlackListVO);
//				
//				}
				
				if (messageCount<1){
				    addWarningMessagesListOnValidate(fomCO, new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");

				messageCount = 1;
				}
			    }

			    /*
			     * if Black List Action = Proceed on Compliance
			     * Decision
			     */
			    else
			    {

				if(motherFNCount == 0)
				{

				    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
				    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
				    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
				    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
				    ctsBlckListNameMatchVO
					    .setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
				    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Mother First Name");
				    ctsBlckListNameMatchVO.setCRITERIA_VALUE(motherFrstNameEN);
				    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
				    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
				    motherFNCount = 1;
				    counterNameMatch++;

				}

				fomCO.setNameMatchedOR("true");

			    }

			}
		    }

		}

		/* MOTHER LAST NAME name matching percentage */
		if(sBlkMFName.equals(ConstantsCommon.BLACKLISTENABLED)
			&& StringUtil.isNotEmpty(fomCO.getCifVO().getMOTHER_LAST_NAME())
			&& StringUtil.isNotEmpty(temp.getBlackListVO().getCIF_MOTHER_LNAME()))
		{
		    criteriaCount = criteriaCount + 1;
		    String blackMotherLstNameEN = temp.getBlackListVO().getCIF_MOTHER_LNAME();
		    String motherLstNameEN = fomCO.getCifVO().getMOTHER_LAST_NAME();

		    int Res = (blackMotherLstNameEN.length())
			    - (computeDistance(blackMotherLstNameEN, motherLstNameEN));
		    int Tot = (Res * 100) / (blackMotherLstNameEN.length());

		    if(Tot >= nameMatchingPercent.intValue())
		    {

			if(sAndOR.equals("A"))
			{
			    if(motherLNCount==0){
                        	
	    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
	    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
	    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
	    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
	    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
	       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Mother Last Name");
	    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(motherLstNameEN);
	    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
	    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
	    			    motherLNCount =1;
	    			    counterNameMatch++;
	                        	
	                        	
	                            }

			    blckListRes = true;
			    return blckListRes;
			}

			else
			{

			    if(blackListAction.equals(new BigDecimal(0)))
			    {

				throw new BOException(MessageCodes.CIF_IS_BLACKLISTED);
			    }
			    /* if Black List Action = Allow to proceed */
			    else if(blackListAction.equals(new BigDecimal(1)))
			    {
				// int mosBlackListCode =
				// fomDAO.returnMosBlackListCode(fomCO);
				// fomCO.setMosBlackListCode(mosBlackListCode);
				// int mosBlackListRecord =
				// fomDAO.returnMosBlackListRecord(fomCO);
				// if (mosBlackListRecord<1) {
				//
				// MOSBLACKLISTVO mosBlackListVO = new
				// MOSBLACKLISTVO();
				// mosBlackListVO.setCOMP_CODE(fomCO.getLoginCompCode());
				// mosBlackListVO.setBRANCH(fomCO.getLoginBraCode());
				// mosBlackListVO.setCODE(new
				// BigDecimal(mosBlackListCode));
				// mosBlackListVO.setCIF(fomCO.getCifVO().getCIF_NO());
				// mosBlackListVO.setBRIEF_NAME_ENG(fomCO.getCifVO().getSHORT_NAME_ENG());
				// mosBlackListVO.setLONG_NAME_ENG(fomCO.getCifVO().getLONG_NAME_ENG());
				// mosBlackListVO.setSTATUS("P");
				// genericDAO.insert(mosBlackListVO);
				//
				// }

				if(messageCount < 1)
				{
				    addWarningMessagesListOnValidate(fomCO,
					    new BigDecimal(MessageCodes.CIF_BLACKLISTED_AS_CONTROL_RECORD), "YESNO");

				    messageCount = 1;
				}
			    }
			    
			    else {
				
				    if(motherLNCount==0){
	                        	
		    			    CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();
		    			    ctsBlckListNameMatchVO.setCOMP_CODE(fomCO.getLoginCompCode());
		    			    ctsBlckListNameMatchVO.setBRANCH_CODE(fomCO.getLoginBraCode());
		    			    ctsBlckListNameMatchVO.setLINE_NO(new BigDecimal(counterNameMatch));
		    			    ctsBlckListNameMatchVO.setBLCKLIST_LOG_LINE_NO(new BigDecimal(fomCO.getCountBlckListLog()));
		       			    ctsBlckListNameMatchVO.setCRITERIA_TYPE("Mother Last Name");
		    			    ctsBlckListNameMatchVO.setCRITERIA_VALUE(motherLstNameEN);
		    			    ctsBlckListNameMatchVO.setPERCENTAGE_VALUE(new BigDecimal(Tot));
		    			    fomCO.getCtsBlckListNameMatchVO().add(ctsBlckListNameMatchVO);
		    			    motherLNCount =1;
		    			    counterNameMatch++;
		                        	
		                        	
		                            }
				    
				    fomCO.setNameMatchedOR("true");
				    
				    
				
			    }


			}
		    }

		}

	    }

	}
	return blckListRes;

    }  
    public void addWarningMessagesListOnValidate(FomCO fomCO, BigDecimal msgCode, String infoType) throws BaseException
    {	 
	if(!fomCO.getCifGlobalConfirmFlag() && NumberUtil.nullToZero(msgCode).intValue() > 0)
	{			
	    BaseException baseEx = null;
	    baseEx = new BaseException(msgCode.intValue());
	    fomCO.getWarningMessagesList().add(baseEx);
	}
    }
    private int computeDistance(String blackBriefNameEN, String briefNameEN)
    {
	blackBriefNameEN = blackBriefNameEN.toLowerCase();
	briefNameEN = briefNameEN.toLowerCase();
	if ((briefNameEN.length()) > (blackBriefNameEN.length()) )
	{
	    briefNameEN = briefNameEN.substring(0, blackBriefNameEN.length());
	}

	int[] costs = new int[briefNameEN.length() + 1];
	for(int i = 0; i <= blackBriefNameEN.length(); i++)
	{
	    int lastValue = i;
	    for(int j = 0; j <= briefNameEN.length(); j++)
	    {
		if(i == 0)
		    costs[j] = j;
		else
		{
		    if(j > 0)
		    {
			int newValue = costs[j - 1];
			if(blackBriefNameEN.charAt(i - 1) != briefNameEN.charAt(j - 1))
			    newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
			costs[j - 1] = lastValue;
			lastValue = newValue;
		    }
		}
	    }
	    if(i > 0)
		costs[briefNameEN.length()] = lastValue;
	}
	return costs[briefNameEN.length()];
    }
    //End Hala Al Sheikh - BIPL180103
    
    
    public int returnSTodoDetByAlert(AlertsSC alertsSC) throws BaseException
    {
	return coreCommonServiceDAO.returnSTodoDetByAlert(alertsSC);
    }
    
    public CoreCommonServiceDAO getCoreCommonServiceDAO()
    {
	return coreCommonServiceDAO;
    }

    public void setCoreCommonServiceDAO(CoreCommonServiceDAO coreCommonServiceDAO)
    {
	this.coreCommonServiceDAO = coreCommonServiceDAO;
    }

    public SafeAccLockBO getSafeAccLockBO()
    {
	return safeAccLockBO;
    }

    public void setSafeAccLockBO(SafeAccLockBO safeAccLockBO)
    {
	this.safeAccLockBO = safeAccLockBO;
    }

    public CifUserAccessBO getCifUserAccessBO()
    {
	return cifUserAccessBO;
    }

    public void setCifUserAccessBO(CifUserAccessBO cifUserAccessBO)
    {
	this.cifUserAccessBO = cifUserAccessBO;
    }

    public PostalCodeBO getPostalCodeBO()
    {
	return postalCodeBO;
    }

    public void setPostalCodeBO(PostalCodeBO postalCodeBO)
    {
	this.postalCodeBO = postalCodeBO;
    }

    public CountriesBO getCountriesBO()
    {
	return countriesBO;
    }

    public void setCountriesBO(CountriesBO countriesBO)
    {
	this.countriesBO = countriesBO;
    }

    public CountriesRegionBO getCountriesRegionBO()
    {
	return countriesRegionBO;
    }

    public void setCountriesRegionBO(CountriesRegionBO countriesRegionBO)
    {
	this.countriesRegionBO = countriesRegionBO;
    }

    public CitiesBO getCitiesBO()
    {
	return citiesBO;
    }

    public void setCitiesBO(CitiesBO citiesBO)
    {
	this.citiesBO = citiesBO;
    }

    public SectorsBO getSectorsBO()
    {
	return sectorsBO;
    }

    public void setSectorsBO(SectorsBO sectorsBO)
    {
	this.sectorsBO = sectorsBO;
    }

    public AlertsBO getAlertsBO()
    {
        return alertsBO;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
        this.alertsBO = alertsBO;
    }

    public AddressCommonBO getAddressBO()
    {
        return addressBO;
    }

    public void setAddressBO(AddressCommonBO addressBO)
    {
	this.addressBO = addressBO;
    }

 
    public MosBlackListBO getMosBlackListBO()
    {
	return mosBlackListBO;
    }

    public void setMosBlackListBO(MosBlackListBO mosBlackListBO)
    {
	this.mosBlackListBO = mosBlackListBO;
    }

    public BlackListBO getBlackListBO()
    {
	return blackListBO;
    }

    public void setBlackListBO(BlackListBO blackListBO)
    {
	this.blackListBO = blackListBO;
    }

    public CurrencyBO getCurrencyBO()
    {
	return currencyBO;
    }

    public void setCurrencyBO(CurrencyBO currencyBO)
    {
	this.currencyBO = currencyBO;
    }

    public AccountBO getAccountBO()
    {
	return accountBO;
    }

    public void setAccountBO(AccountBO accountBO)
    {
	this.accountBO = accountBO;
    }
}
