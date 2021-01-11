/**
 * @Auther:MarwanMaddah
 * @Date:Mar 2, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.account.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dao.core.account.AccountDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMF_EXTENDEDVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.common.AccRestrictedSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public class AccountBOImpl extends RetailBaseBO implements AccountBO
{
    private AccountDAO accountDAO;

    /**
     * return the account list count... Pbd :w_lookup_amf_dyn
     * 
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int accountListCount(AccountSC criteria) throws BaseException
    {

	criteria.setDefaultValues();
	if(ConstantsCommon.YES.equals(StringUtil.nullEmptyToValue(criteria.getNostroByProductClass(),
		ConstantsCommon.NO)))
	{
	    /**
	     * @author Saheer.Naduthodi returns the account list count based on
	     *         product class Pbd:w_lookup_nostro_productclass
	     */
	    return accountDAO.accountListByProductClassCount(criteria);

	}
	return accountDAO.accountListCount(criteria);
    }

    /**
     * return a list contains all accounts based on the criteria... this
     * function call the dynamic query for Account Pbd :w_lookup_amf_dyn
     * 
     * @param criteria
     * @return list
     * @throws BaseException
     */
    public List accountList(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	if(ConstantsCommon.YES.equals(StringUtil.nullEmptyToValue(criteria.getNostroByProductClass(),
		ConstantsCommon.NO)))
	{

	    /**
	     * @author Saheer.Naduthodi returns the account list based on
	     *         product class Pbd:w_lookup_nostro_productclass
	     */
	    return accountDAO.accountByProductClassList(criteria);
	}
	return accountDAO.accountList(criteria);

    }

    
    @Override
    public AccountSC returnAccountList(AccountSC criteria) throws BaseException
    {
	//Habib Baalbaki accocunt restriction 372747
	AccountSC accountSC = new AccountSC();
	accountSC.setCurrAppName(criteria.getCurrAppName());
	accountSC.setPageRef(criteria.getPageRef());
	accountSC.setUserId(criteria.getUserId());
	accountSC.setCompCode(criteria.getCompCode());
	callFillAccRestricted(accountSC);
	
	int result = 0;
	if(criteria.isCheckNbRec())
	{
	    result = accountListCount(criteria);
	    criteria.setTrxMgntNbRecords(result);
	}
	if(criteria.isCheckNbRec() && result == 0)
	{
	    criteria.setSidx(null); 
	    criteria.setSord(null);
	}
	List<AMFVO> amfList = accountList(criteria);
	criteria.setAccountListRecords(amfList);
	return criteria;
    }
    
    
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public AMFVO checkAccountValidation(AccountSC criteria) throws BaseException
    {
	return accountDAO.checkAccountValidation(criteria);
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public AMFVO returnAccountByReference(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	AMFVO amfVO=null;
	//Habib Baalbaki accocunt restriction 372747
	callFillAccRestricted(criteria);
	
	List amfVOList = accountDAO.returnAccountByReference(criteria);
	/*Bug # 338150 -- [John Massaad] raising a BOException when we have duplicate Additional Reference 
	 for two different accounts raither than static message with DAOException*/
	if( (amfVOList == null || amfVOList.isEmpty()) && BigDecimal.ONE.compareTo(NumberUtil.nullToZero(criteria.getDisplayMsg())) == 0)
	{
	    throw new BOException(MessageCodes.ADDITIONAL_REFERENCE_IS_NOT_VALID);
	}
	//Duplicate Account Number Wrong data
	else if(amfVOList.size() > 1)
	{
	    //changed by bahaa for #BUG 520894
	    throw new BOException(MessageCodes.DUPLICATE_PARAM, new String[] { "Account_No_key" });
	}
	else if(amfVOList.size() == 1)
	{
	    // Bug # 338150 -- [John Massaad]
	    amfVO = (AMFVO) amfVOList.get(0);
	}
	if(!NumberUtil.isEmptyDecimal(criteria.getDisplayMsg()) && (BigDecimal.ONE.compareTo(criteria.getDisplayMsg())==0) )
	{
	    checkAccountInAMF(criteria);
	}
	return amfVO;
    }

    /**
     * returnAMFBySLNo
     */
    public AMFVO returnAMFBySLNo(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	//Habib Baalbaki accocunt restriction 372747
	callFillAccRestricted(criteria);
	
	AMFVO amfVO = accountDAO.returnAMFBySLNo(criteria);
	if(!NumberUtil.isEmptyDecimal(criteria.getDisplayMsg()) && (BigDecimal.ONE.compareTo(criteria.getDisplayMsg())==0) )
	{
	    if(amfVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_ACCOUNT);
	    }
	    checkAccountInAMF(criteria);
	}
	return amfVO;
    }

    /**
     * @return the accountDAO
     */
    public AccountDAO getAccountDAO()
    {
	return accountDAO;
    }

    /**
     * @param accountDAO the accountDAO to set
     */
    public void setAccountDAO(AccountDAO accountDAO)
    {
	this.accountDAO = accountDAO;
    }

    @Override
    public List cifRelatedAccountList(AccountSC criteria) throws BaseException
    {

//	AccRestrictedSC accRestrictedSC  = new AccRestrictedSC();
//	accRestrictedSC.setFrAcBr(new BigDecimal(0));
//	accRestrictedSC.setFrAcCif(criteria.getCifCode());
//	accRestrictedSC.setFrAcCy(new BigDecimal(0));
//	accRestrictedSC.setFrAcGl(new BigDecimal(0));
//	accRestrictedSC.setFrAcSl(new BigDecimal(0));
//	accRestrictedSC.setToAcBr(new BigDecimal(9999));
//	accRestrictedSC.setToAcCif(criteria.getCifCode());
//	accRestrictedSC.setToAcCy(new BigDecimal(999));
//	accRestrictedSC.setToAcGl(new BigDecimal(999999));
//	accRestrictedSC.setToAcSl(new BigDecimal(999));
//	accRestrictedSC.setAppName(criteria.getAppName());
//	accRestrictedSC.setUserId(criteria.getUserId());
//	accRestrictedSC.setCompCode(criteria.getCompCode());
//	accRestrictedSC.setBranchCode(criteria.getBranchCode());
//	accRestrictedSC.setProgRef(criteria.getScreenRef());
//	coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);

	
	return accountDAO.cifRelatedAccountList(criteria);
    }

    @Override
    public int cifRelatedAccountListCount(AccountSC criteria) throws BaseException
    {
	return accountDAO.cifRelatedAccountListCount(criteria);
    }

    public List accountNumberList(AccountSC criteria) throws BaseException
    {
	return accountDAO.accountNumberList(criteria);
    }
    
    @Override
    public AccountSC returnCifRelatedAccountList(AccountSC criteria) throws BaseException
    {
	//Habib Baalbaki accocunt restriction 372747
	callFillAccRestricted(criteria);
	
	int result = 0;
	if(criteria.isCheckNbRec())
	{
	    result = cifRelatedAccountListCount(criteria);
	    criteria.setTrxMgntNbRecords(result);
	}
	if(criteria.isCheckNbRec() && result == 0)
	{
	    criteria.setSidx(null); 
	    criteria.setSord(null);
	}
	List<AccountCO> amfList = cifRelatedAccountList(criteria);
	criteria.setCifAccList(amfList);
	return criteria;
    }

    public int accountNumberListCount(AccountSC criteria) throws BaseException
    {
	return accountDAO.accountNumberListCount(criteria);
    }

    public int deductFromAccountCount(AccountSC criteria) throws DAOException
    {
	return accountDAO.deductFromAccountCount(criteria);
    }

    public List<AccountCO> deductFromAccountList(AccountSC criteria) throws DAOException
    {
	return accountDAO.deductFromAccountList(criteria);
    }

    public int checkAccountNumber(AccountSC criteria) throws BaseException
    {
	return accountDAO.checkAccountNumber(criteria);
    }

    public AccountCO returnAMFDetails(AccountSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	//Habib Baalbaki accocunt restriction 372747
	callFillAccRestricted(criteria);
	return accountDAO.returnAMFDetails(criteria);
    }

    /**
     * Check if This content of criteria if has A predefined AMF Account Pbd
     * :f_check_acc_br and f_get_acc_br
     * 
     * @param AccountSC
     * @return list
     * @throws BaseException
     */
    public List<AMFVO> checkAccountInAMF(AccountSC criteria) throws BaseException
    {
	if("".equals(StringUtil.nullToEmpty(criteria.getBS_CONTRA())))
	{
	    criteria.setBS_CONTRA(ConstantsCommon.XOR); // Both Internal and Non
	    // Internal On B/S A/C
	}
	//Habib Baalbaki accocunt restriction 372747
	if("N".equals(criteria.getSkipAccountRestriction()))
	{
		callFillAccRestricted(criteria);
	}
	
	List<AMFVO> amfList = accountDAO.checkAccountInAMF(criteria);

	if(amfList == null || amfList.isEmpty())
	{
	    if(!NumberUtil.isEmptyDecimal(criteria.getBranchCode()))
	    {
		if(NumberUtil.isEmptyDecimal(criteria.getCurrencyCode()))
		{
		    throw new BOException(MessageCodes.NO_ACCOUNT_FOR_SELECTED_BRANCH);
		}
		else
		{
		    if(NumberUtil.isEmptyDecimal(criteria.getGlCode()))
		    {
			throw new BOException(MessageCodes.NO_ACCOUNT_FOR_SELECTED_CURRENCY);
		    }
		    else
		    {
			if(NumberUtil.isEmptyDecimal(criteria.getCifCode()))
			{
			    throw new BOException(MessageCodes.Invalid_CIFNo);
			}
			else
			{
			    if(NumberUtil.isEmptyDecimal(criteria.getSlNbr()))
			    {
				throw new BOException(MessageCodes.INVALID_ACCOUNT);
			    }
			    else
			    {
				StringBuffer account = new StringBuffer();
				account.append("/*" + "0000".substring(criteria.getCompCode().toString().length())
					+ criteria.getCompCode().toString() + '-'
					+ "0000".substring(criteria.getBranchCode().toString().length())
					+ criteria.getBranchCode().toString());
				if(criteria.getCurrencyCode() != null)
				{
				    account.append('-'
					    + "000".substring(criteria.getCurrencyCode().toString().length())
					    + criteria.getCurrencyCode().toString());
				}
				if(criteria.getGlCode() != null)
				{
				    account.append('-' + "000000".substring(criteria.getGlCode().toString().length())
					    + criteria.getGlCode().toString());
				}
				if(criteria.getCifCode() != null)
				{
				    account.append('-'
					    + "00000000".substring(criteria.getCifCode().toString().length())
					    + criteria.getCifCode().toString());
				}
				if(criteria.getSlNbr() != null)
				{
				    account.append('-' + "000".substring(criteria.getSlNbr().toString().length())
					    + criteria.getSlNbr().toString());
				}

				account.append("*/");
				throw new BOException(MessageCodes.ACCOUNT_NO_IS_INVALID_OR_MISSING,
					new String[] { account.toString() });

			    }
			}
		    }
		}
	    }

	}
	else
	{
	    // this flag is used to check if account exist IN AMF without
	    // buisness cheking on status if 0 or null or empty check on status
	    // if "1" dont check
	    if(amfList.size() == 1
		    && (criteria.getNotCheckOnStatus() == null || "".equals(criteria.getNotCheckOnStatus()) || "0"
			    .equals(criteria.getNotCheckOnStatus())))

	    {
		AMFVO amfVO = amfList.get(0);
		checkAccountStatus(criteria, amfVO);
	    }
	}
	return (amfList == null) ? new ArrayList<AMFVO>() : amfList;
    }

    /**
     * Check account status - part2 Pbd :f_check_acc_br and f_get_acc_br and
     * uf_get_inv_acc
     * 
     * @param AccountSC
     * @return list
     * @throws BaseException
     * @neededProperties 
     *                   criteria.getBranchCode,criteria.getCurrencyCode,criteria
     *                   .getGlCode,criteria.getCifCode,criteria.getSlNbr,
     *                   criteria
     *                   .getCompCode,criteria.getVIEW_SUSPEND_ACC,criteria
     *                   .getTYPE
     *                   ,criteria.getCR_DR_FOREX,criteria.getVIEW_DORMANT_ACC
     *#BUG TONY NOUH 212017 20/08/2014
     */
    public String checkAccountStatus(AccountSC criteria, AMFVO amfVO) throws BaseException
    {
	String newLine = AccountsConstant.NEW_LINE;
	// Added to check for closure account at the level of passbook maintenance
	String originOptRef = "";
	if(StringUtil.isNotEmpty(criteria.getScreenRef()))
	{
	    originOptRef = commonLibBO.returnOrginProgRef(ConstantsCommon.RET_APP_NAME, criteria.getScreenRef());
	}
	StringBuffer warningMessages = new StringBuffer();
	// Libin added null checking
	if(!NumberUtil.isEmptyDecimal(amfVO.getBRANCH_CODE()) && !NumberUtil.isEmptyDecimal(amfVO.getCURRENCY_CODE())
		&& !NumberUtil.isEmptyDecimal(amfVO.getGL_CODE()) && !NumberUtil.isEmptyDecimal(amfVO.getCIF_SUB_NO())
		&& !NumberUtil.isEmptyDecimal(amfVO.getSL_NO()))
	{
	    StringBuffer account = new StringBuffer();
	    account.append("/*" + "0000".substring(criteria.getCompCode().toString().length())
		    + criteria.getCompCode().toString() + '-'
		    + "0000".substring(amfVO.getBRANCH_CODE().toString().length())
		    + amfVO.getBRANCH_CODE().toString());
	    if(amfVO.getCURRENCY_CODE() != null)
	    {
		account.append('-' + "000".substring(amfVO.getCURRENCY_CODE().toString().length())
			+ amfVO.getCURRENCY_CODE().toString());
	    }
	    if( amfVO.getGL_CODE() != null)
	    {
		account.append('-' + "000000".substring(amfVO.getGL_CODE().toString().length())
			+ amfVO.getGL_CODE().toString());
	    }
	    if(amfVO.getCIF_SUB_NO() != null)
	    {
		account.append('-' + "00000000".substring(amfVO.getCIF_SUB_NO().toString().length())
			+ amfVO.getCIF_SUB_NO().toString());
	    }
	    if(amfVO.getSL_NO() != null)
	    {
		account.append('-' + "000".substring(amfVO.getSL_NO().toString().length())
			+ amfVO.getSL_NO().toString());
	    }

	    account.append("*/");

	    if(ConstantsCommon.OPENED_ACCOUNT.equals(amfVO.getSTATUS())) // "O".equals(amfVO.getSTATUS())
	    {
		throw new BOException(MessageCodes.ACCOUNT_NO_HAS_NOT_BEEN_AUTHORIZED, new String[] { account
			.toString() });
	    }
	    if(AccountsConstant.STATUS_DELETE.equals(amfVO.getSTATUS())) // "D".equals(amfVO.getSTATUS()
	    {
		if("BOD".equals(StringUtil.nullToEmpty(criteria.getCallingIndicator())))
	        {
	            String accStatusMsg = commonLibBO.returnTranslErrorMessage(
	                MessageCodes.ACCOUNT_NO_HAS_DELETED, new String[] { account
	                    .toString() }, criteria.getPreferredLanguage());
	            warningMessages.append(accStatusMsg).append(newLine);
	        }
	        else
	        {
	            throw new BOException(MessageCodes.ACCOUNT_NO_HAS_DELETED, new String[] { account.toString() });
	        }
	    }
	    if(AccountsConstant.STATUS_CLOSED.equals(amfVO.getSTATUS())) // "C".equals(amfVO.getSTATUS()
	    {
		if("BOD".equals(StringUtil.nullToEmpty(criteria.getCallingIndicator())))
	        {
	            String accStatusMsg = commonLibBO.returnTranslErrorMessage(
	                MessageCodes.ACCOUNT_NO_HAS_CLOSED, new String[] { account
	                    .toString() }, criteria.getPreferredLanguage());
	            warningMessages.append(accStatusMsg).append(newLine);
	        }
	        else
	        {
	            throw new BOException(MessageCodes.ACCOUNT_NO_HAS_CLOSED, new String[] { account.toString() });
	        }
	    }
	    if(AccountsConstant.STATUS_OFFENDING.equals(amfVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.ACCOUNT_NO_HAS_MARKED_AS_OFFENDING, new String[] { account
			.toString() });
	    }
	    //NABIL FEGHALI - Fix issue #214544 
	    //The checking on REFERENCE1 is not needed because the close with transfer is done in the procedure
	    //NABIL FEGHALI Fix Issue #230816
	    if( AccountsConstant.STATUS_CLOSURE_APPROVED.equals(amfVO.getSTATUS()) 
		    || (AccountsConstant.STATUS_APPLY_FOR_CLOSURE.equals(amfVO.getSTATUS())
			    && ( !StringUtil.isNotEmpty(criteria.getScreenRef()) || ConstantsCommon.RET_APP_NAME.equals(originOptRef))))
	    {
		if("BOD".equals(StringUtil.nullToEmpty(criteria.getCallingIndicator())))
	        {
	            String accStatusMsg = commonLibBO.returnTranslErrorMessage(
	                MessageCodes.ACCOUNT_NO_HAS_MARKED_FOR_CLOSING, new String[] { account
	                    .toString() }, criteria.getPreferredLanguage());
	            warningMessages.append(accStatusMsg).append(newLine);
	        }
	        else
	        {
	            throw new BOException(MessageCodes.ACCOUNT_NO_HAS_MARKED_FOR_CLOSING,
				new String[] { account.toString() });
	        }
	    }
	    
	    boolean fromAccBusiness = (TrxMgntConstant.DEPOSIT.equals(criteria.getTYPE()))
		    || (TrxMgntConstant.TRANSFER.equals(criteria.getTYPE())
			    && TrxMgntConstant.MAIN_ACC_CR.equals(criteria.getCR_DR_FOREX()) && TrxMgntConstant.ACCOUNT_SIGN_CREDIT
			    .equals(amfVO.getAC_SIGN()))
		    || (TrxMgntConstant.TRANSFER.equals(criteria.getTYPE())
			    && TrxMgntConstant.MAIN_ACC_DR.equals(criteria.getCR_DR_FOREX()) && TrxMgntConstant.ACCOUNT_SIGN_DEBIT
			    .equals(amfVO.getAC_SIGN()));
	    boolean toAccBusiness = (TrxMgntConstant.DEPOSIT.equals(criteria.getTYPE()) && !TrxMgntConstant.HOUSE_CHEQUE
		    .equals(criteria.getCHQ_RELATED()))
		    || (TrxMgntConstant.TRANSFER.equals(criteria.getTYPE())
			    && TrxMgntConstant.MAIN_ACC_CR.equals(criteria.getCR_DR_FOREX()) && TrxMgntConstant.ACCOUNT_SIGN_DEBIT
			    .equals(amfVO.getAC_SIGN()))
		    || (TrxMgntConstant.TRANSFER.equals(criteria.getTYPE())
			    && TrxMgntConstant.MAIN_ACC_DR.equals(criteria.getCR_DR_FOREX()) && TrxMgntConstant.ACCOUNT_SIGN_CREDIT
			    .equals(amfVO.getAC_SIGN()));

	    /**
	     * Proceed on Suspend Account If Deposit
	     */
	    if(AccountsConstant.STATUS_SUSPENDED.equals(amfVO.getSTATUS())
		    || AccountsConstant.STATUS_TO_SUSPEND.equals(amfVO.getSTATUS()))
	    {
		/**
		 * in case the function is called from products screen
		 * (safebox,..) then the flag is not affected, system must
		 * maintain same behavior
		 */
		if(null == criteria.getVIEW_SUSPEND_ACC())
		{
		    if(AccountsConstant.STATUS_TO_SUSPEND.equals(amfVO.getSTATUS()))
		    {
			throw new BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED, new String[] { account
				.toString() });
		    }
		    else
		    {
			throw new BOException(MessageCodes.AC_NO_HAS_BEEN_SUSPENDED,
				new String[] { account.toString() });
		    }
		}
		else if(TrxMgntConstant.PROCEED_ON_SUSPENDED_AC_IF_DEPOSIT.equals(criteria.getVIEW_SUSPEND_ACC()))
		{
		    if( ((criteria.getColName() == null || criteria.getColName().equals("") || "trs_ac_sl".equals(criteria.getColName())) && fromAccBusiness)
			    || ("to_trs_ac_sl".equals(criteria.getColName()) && toAccBusiness)   )
		    {
			if(AccountsConstant.STATUS_TO_SUSPEND.equals(amfVO.getSTATUS()))
			{
			    // throw new
			    // BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED_WARNING,
			    // new String[] { account }); //information message
			    String accStatusMsg = commonLibBO.returnTranslErrorMessage(
				    MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED_WARNING, new String[] { account
					    .toString() }, criteria.getPreferredLanguage());
			    warningMessages.append(accStatusMsg).append(newLine);
			}
			else
			{
			    // throw new
			    // BOException(MessageCodes.ACCOUNT_NO_HAS_SUSPENDED
			    // , new String[] { account }); //information
			    // message
			    String accStatusMsg = commonLibBO.returnTranslErrorMessage(
				    MessageCodes.ACCOUNT_NO_HAS_SUSPENDED, new String[] { account.toString() },
				    criteria.getPreferredLanguage());
			    warningMessages.append(accStatusMsg).append(newLine);
			}
		    }
		    else
		    {
			if(AccountsConstant.STATUS_TO_SUSPEND.equals(amfVO.getSTATUS()))
			{
			    throw new BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED, new String[] { account
				    .toString() });
			}
			else
			{
			    throw new BOException(MessageCodes.AC_NO_HAS_BEEN_SUSPENDED, new String[] { account
				    .toString() });
			}
		    }
		}
		else if(TrxMgntConstant.PROCEED_ON_SUSPENDED_AC_AND_VIEW_SIGNATURE.equals(criteria.getVIEW_SUSPEND_ACC())
			|| TrxMgntConstant.PROCEED_ON_SUSPENDED_AC_AND_DONT_VIEW_SIGNATURE.equals(criteria
				.getVIEW_SUSPEND_ACC()))
		{
		    if(AccountsConstant.STATUS_TO_SUSPEND.equals(amfVO.getSTATUS()))
		    {
//			throw new BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED_WARNING,
//				new String[] { account.toString() });
			
			String accStatusMsg = commonLibBO.returnTranslErrorMessage(
				MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED_WARNING,
				new String[] { account.toString() }, criteria.getPreferredLanguage());
			warningMessages.append(accStatusMsg).append(newLine);
		    }
		    else
		    {
//			throw new BOException(MessageCodes.ACCOUNT_NO_HAS_SUSPENDED,
//				new String[] { account.toString() });
			String accStatusMsg = commonLibBO.returnTranslErrorMessage(
				MessageCodes.ACCOUNT_NO_HAS_SUSPENDED,
				new String[] { account.toString() }, criteria.getPreferredLanguage());
			warningMessages.append(accStatusMsg).append(newLine);
		    }
		}
		else if(TrxMgntConstant.DONT_PROCEED_ON_SUSPENDED_AC.equals(criteria.getVIEW_SUSPEND_ACC()))
		{
		    if(AccountsConstant.STATUS_TO_SUSPEND.equals(amfVO.getSTATUS()))
		    {
			throw new BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED, new String[] { account
				.toString() });
		    }
		    else
		    {
			throw new BOException(MessageCodes.AC_NO_HAS_BEEN_SUSPENDED,
				new String[] { account.toString() });
		    }
		}
	    }
	    if(AccountsConstant.STATUS_REJECT.equals(amfVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.ACCOUNT_NO_HAS_REJECTED, new String[] { account.toString() });
	    }

	    /**
	     * Unclaimed Accounts adjust checking on dormant/unclaimed acc
	     */
	    if(AccountsConstant.STATUS_DORMANT.equals(amfVO.getSTATUS()))
	    {
		if(AccountsConstant.CHECK_UN_CLAIMED.equals(criteria.getCheckUnclaimFlag()))
		{
		    criteria.setAvoidCheckUnclaimed(0);
		    criteria.setProcessCode(BigDecimal.ZERO);
		    AccountSC criteriaResult = coreCommonProcedureBO.checkUnclaimed(criteria);
		    if(criteriaResult != null && StringUtil.isNotEmpty(criteriaResult.getYear()))
		    {
			throw new BOException(MessageCodes.ACCOUNT_NO_MARKED_UNCLAIMED_AT_YEAR, new String[] {
				account.toString(), criteriaResult.getYear() });
		    }
		}
		// If
		// f_check_unclaimed(GV_COMPANY_CODE,A_STR.L_BR,A_STR.L_CY,A_STR.L_GL
		// ,A_STR.L_CIF,A_STR.L_sl ) > 0 Then
		// ls_year =
		// f_check_unclaimed_year(GV_COMPANY_CODE,A_STR.L_BR,A_STR.L_CY,A_STR.L_GL
		// ,A_STR.L_CIF,A_STR.L_sl )
		// guo_messages.uf_set_add_param(ls_account,ls_year)
		// ls_is_unclaimed = '1'
		// end if
		
		//Hala - TP661014 JAIZ160072 - 30/08/2018
		AMF_EXTENDEDVO amfExtendedVO = new AMF_EXTENDEDVO();
		amfExtendedVO.setCOMP_CODE(criteria.getCompCode());
		amfExtendedVO.setBRANCH_CODE(amfVO.getBRANCH_CODE());
		amfExtendedVO.setCURRENCY_CODE(amfVO.getCURRENCY_CODE());
		amfExtendedVO.setGL_CODE(amfVO.getGL_CODE());
		amfExtendedVO.setCIF_SUB_NO(amfVO.getCIF_SUB_NO());
		amfExtendedVO.setSL_NO(amfVO.getSL_NO());
		amfExtendedVO = (AMF_EXTENDEDVO) genericDAO.selectByPK(amfExtendedVO);
		
		
		String is_unclaimed = "";
		String year = "";
		criteria.setVIEW_DORMANT_ACC(StringUtil.nullEmptyToValue(criteria.getVIEW_DORMANT_ACC(), "0"));
		if(  ( (TrxMgntConstant.PROCEED_ON_DORMANT_AC_IF_DEPOSIT.equals(criteria.getVIEW_DORMANT_ACC()))
			&& (((criteria.getColName() == null || criteria.getColName().equals("") || "trs_ac_sl".equals(criteria.getColName())) && fromAccBusiness)
			    || ("to_trs_ac_sl".equals(criteria.getColName()) && toAccBusiness) ) )
			|| TrxMgntConstant.PROCEED_ON_DORMANT_AC_AND_VIEW_SIGNATURE.equals(criteria
				.getVIEW_DORMANT_ACC())
			|| TrxMgntConstant.PROCEED_ON_DORMANT_AC_AND_DONT_VIEW_SIGNATURE.equals(criteria
				.getVIEW_DORMANT_ACC())
			|| TrxMgntConstant.PROCEED_ON_DORMANT_AC_AND_DONT_VIEW_CIF_SIGNATURE.equals(criteria
				.getVIEW_DORMANT_ACC())
			|| (TrxMgntConstant.DONT_PROCEED_ON_DORMANT_AC.equals(criteria.getVIEW_DORMANT_ACC()) && (amfExtendedVO == null 
				|| (!AccountsConstant.STATUS_DORMANT.equals(amfExtendedVO.getSUB_STATUS()) && !"".equals(StringUtil.nullEmptyToValue(amfExtendedVO.getSUB_STATUS(), "")))))) //Hala - TP661014 JAIZ160072 - 30/08/2018
		{
		    if("1".equals(is_unclaimed))
		    {
			// throw new
			// BOException(MessageCodes.ACC_NO_MARKED_UNCLAIMED_AT_YEAR_WARNING,
			// new String[] { account, year }); //information
			// message
			String accStatusMsg = commonLibBO.returnTranslErrorMessage(
				MessageCodes.ACC_NO_MARKED_UNCLAIMED_AT_YEAR_WARNING,
				new String[] { account.toString() }, criteria.getPreferredLanguage());
			warningMessages.append(accStatusMsg).append(newLine);

		    }
		    else
		    {
			// throw new
			// BOException(MessageCodes.ACCOUNT_NO_IS_DORMANT_WARNING,
			// new String[] { account }); //information message
			String accStatusMsg = commonLibBO.returnTranslErrorMessage(
				MessageCodes.ACCOUNT_NO_IS_DORMANT_WARNING, new String[] { account.toString() },
				criteria.getPreferredLanguage());
			warningMessages.append(accStatusMsg).append(newLine);
		    }
		}
		else
		{
		    if("1".equals(is_unclaimed))
		    {
			throw new BOException(MessageCodes.ACCOUNT_NO_MARKED_UNCLAIMED_AT_YEAR, new String[] {
				account.toString(), year });
		    }
		    else
		    {
			throw new BOException(MessageCodes.ACCOUNT_NO_IS_DORMANT, new String[] { account.toString() });

		    }

		}
	    }
	    if(AccountsConstant.STATUS_TO_REACTIVATE.equals(amfVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_REACTIVATED, new String[] { account.toString() });
	    }
	    // if("Q".equals(amfVO.getSTATUS()))
	    // {
	    // throw new BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_SUSPENDED,
	    // new String[] { account.toString() });
	    // }
	    if(AccountsConstant.STATUS_TO_REJECT.equals(amfVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.ACCOUNT_NO_IS_TO_BE_REJECTED, new String[] { account.toString() });
	    }
	    //passbook opt maintenance
	    if("S000MT".equals(originOptRef)

	    && ConstantsCommon.APPLY_FOR_CLOSURE_ACCOUNT.equals(amfVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.ACCOUNT_NO_IS_APPLIED_FOR_CLOSURE,
			new String[] { account.toString() });
	    }

	    // if(ConstantsCommon.APPLY_FOR_CLOSURE_ACCOUNT.equals(amfVO.getSTATUS()))
	    // {
	    // throw new
	    // BOException(MessageCodes.ACCOUNT_NO_IS_APPLIED_FOR_CLOSURE, new
	    // String[] { account.toString() });
	    // }
	}
	return warningMessages.toString();
    }

    @Override
    public List getAccountsList(AccountSC criteria) throws BaseException
    {
	return accountDAO.getAccountsList(criteria);
    }

    @Override
    public int getAccountsListCount(AccountSC criteria) throws BaseException
    {
	return accountDAO.getAccountsListCount(criteria);
    }

    @Override
    public AccountSC returnAllAccountList(AccountSC criteria) throws BaseException
    {
	//Habib Baalbaki accocunt restriction 372747
	callFillAccRestricted(criteria);
	
	int result = 0;
	if(criteria.isCheckNbRec())
	{
	    result = getAccountsListCount(criteria);
	    criteria.setTrxMgntNbRecords(result);
	}
	if(criteria.isCheckNbRec() && result == 0)
	{
	    criteria.setSidx(null); 
	    criteria.setSord(null);
	}
	List<AMFVO> amfList = getAccountsList(criteria);
	criteria.setAccountListRecords(amfList);
	return criteria;
    }
    
    @Override
    public AMFVO validateBySlNo(AccountSC criteria) throws BaseException
    {
	return accountDAO.validateBySlNo(criteria);
    }

    /**
     * where status = 'T' : it's like dw_account_status query
     */
    public List<AMFVO> returnAMFByCIFSUBNO(AccountSC criteria) throws BaseException
    {
	return accountDAO.returnAMFByCIFSUBNO(criteria);
    }

    /**
     * 
     */
    public AccountCO returnAMFByAddRef(AccountSC criteria) throws BaseException
    {
	return accountDAO.returnAMFByAddRef(criteria);
    }

    public AMFVO returnAMFByAddRefList(AccountSC criteria) throws BaseException
    {
	List<AMFVO> lst = accountDAO.returnAMFByAddRefList(criteria);
	if(lst == null || lst.isEmpty())
	{
	    throw new BOException(MessageCodes.ADDITIONAL_REFERENCE_IS_NOT_VALID);
	}
	else if(lst.size() > 1)
	{
	    //changed by bahaa for #BUG 520894
	    throw new BOException(MessageCodes.DUPLICATE_PARAM, new String[] { "Account_No_key" });
	}
	return lst.get(0);
    }

    public AccountCO returnAMFByAccountType(AccountSC criteria) throws BaseException
    {
	return accountDAO.returnAMFByAccountType(criteria);
    }

    public AccountCO returnTellerAccountByCy(AccountSC criteria) throws BaseException
    {
	return accountDAO.returnTellerAccountByCy(criteria);
    }

    @Override
    public List accountListByBrCyGlCif(AccountSC criteria) throws BaseException
    {
	return accountDAO.accountListByBrCyGlCif(criteria);
    }

    @Override
    public int accountListCountByBrCyGlCif(AccountSC criteria) throws BaseException
    {
	return accountDAO.accountListCountByBrCyGlCif(criteria);
    }
    
    @Override
    public AccountSC returnAccListByBrCyGlCifList(AccountSC criteria) throws BaseException
    {
	//Habib Baalbaki accocunt restriction 372747
	AccountSC accountSC = new AccountSC();
	accountSC.setCurrAppName(criteria.getCurrAppName());
	accountSC.setPageRef(criteria.getPageRef());
	accountSC.setUserId(criteria.getUserId());
	accountSC.setCompCode(criteria.getCompCode());
	callFillAccRestricted(accountSC);
	
	int result = 0;
	if(criteria.isCheckNbRec())
	{
	    result = accountListCountByBrCyGlCif(criteria);
	    criteria.setTrxMgntNbRecords(result);
	}
	if(criteria.isCheckNbRec() && result == 0)
	{
	    criteria.setSidx(null); 
	    criteria.setSord(null);
	}
	List<AccountCO> amfList = accountListByBrCyGlCif(criteria);
	criteria.setCifAccList(amfList);
	return criteria;
    }
    
    
    
    

    @Override
    public AccountCO returnGlDetailsByBrCyGlCifSlForValidation(AccountSC criteria) throws BaseException
    {
	return accountDAO.returnGlDetailsByBrCyGlCifSlForValidation(criteria);
    }

    @Override
    public AccountCO retrieveAMFFlagandStatus(AccountCO criteria) throws BaseException
    {
	return accountDAO.retrieveAMFFlagandStatus(criteria);
    }

    public AccountSC returnTrxTypeCriteria(AccountSC accountSC) throws BaseException
    {
	AccountSC criteria = accountSC;
	CTSTRXTYPEVO ctstrxtypeVO = new CTSTRXTYPEVO();
	ctstrxtypeVO.setCOMP_CODE(criteria.getCompCode());
	ctstrxtypeVO.setCODE(criteria.getTrxType());
	ctstrxtypeVO.setSTATUS(TrxMgntConstant.STATUS_APPROVE);
	ctstrxtypeVO = coreCommonBO.findTrxType(ctstrxtypeVO);

	if("trs_ac_sl".equals(criteria.getColumnId()))
	{
	    criteria = returnTrxFromAccCriteria(criteria, ctstrxtypeVO);
	}
	//Fix issue #241817 acc det sl will be treated as to acc sl
	if("to_trs_ac_sl".equals(criteria.getColumnId()) || "acc_det_sl".equals(criteria.getColumnId()))
	{
	    criteria = returnTrxToAccCriteria(criteria, ctstrxtypeVO);
	}
	if("ctrl_sl".equals(criteria.getColumnId()))
	{
	    criteria = returnTrxCtrlAccCriteria(criteria/* , ctstrxtypeVO */);
	}
	if("ch_ac_sl".equals(criteria.getColumnId()))
	{
	    criteria = returnTrxChargeAccCriteria(criteria, ctstrxtypeVO);
	}
	return criteria;
    }

    private AccountSC returnTrxFromAccCriteria(AccountSC criteria, CTSTRXTYPEVO ctstrxtypeVO) throws BaseException
    {
	criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);

	TrxMgntSC trxMgntSC = new TrxMgntSC();
	trxMgntSC.setCompCode(criteria.getCompCode());
	trxMgntSC.setTrxType(criteria.getTrxType());
	String db_acc = coreCommonBO.returnDBAccount(trxMgntSC);

	if("".equals(db_acc))
	{
	    if(null != ctstrxtypeVO
		    && TrxMgntConstant.WITHDRAWAL.equals(ctstrxtypeVO.getTYPE())
		    && (TrxMgntConstant.HOUSE_CHEQUE.equals(ctstrxtypeVO.getCHQ_RELATED()) || TrxMgntConstant.CLEARING_CHEQUE
			    .equals(ctstrxtypeVO.getCHQ_RELATED()))
		    && "1".equals(ctstrxtypeVO.getCC_MAINTAIN_SERIAL_NO())) //Abdo TP##427548 - 26/08/2016
	    {
		criteria.setBS_CONTRA("X");
		criteria.setGMI_FLAG("X");
		criteria.setAffectPassChq("3");
		criteria.setFlag("AMF");
		criteria.setTrxType(null); // w_lookup_amf_dyn
	    }
	    else
	    {
		if(null != ctstrxtypeVO && "0".equals(ctstrxtypeVO.getNOSTRO_MVT()))
		{
		    criteria.setBS_CONTRA("C");
		    criteria.setGMI_FLAG("N");
		    criteria.setTrxType(null); // w_lookup_amf_dyn
		}
		else
		{
		    criteria.setBS_CONTRA("X");
		    criteria.setGMI_FLAG("X");
		    criteria.setFlag("AMF");
		    criteria.setTrxType(null); // w_lookup_amf_dyn
		}
	    }

	}
	else
	{
	    trxMgntSC.setDrCrType(TrxMgntConstant.ACCOUNT_SIGN_DEBIT);
	    int trxDRTYPECount = coreCommonBO.countTrxDRCRTYPE(trxMgntSC);
	    if((TrxMgntConstant.WITHDRAWAL.equals(ctstrxtypeVO.getTYPE()) || (TrxMgntConstant.TRANSFER
		    .equals(ctstrxtypeVO.getTYPE()) && TrxMgntConstant.ACCOUNT_SIGN_DEBIT.equals(ctstrxtypeVO
		    .getCR_DR_FOREX())))
		    && (trxDRTYPECount != 0))
	    {
		criteria.setCR_DR_FOREX("D"); // w_lookup_amf_trxtype
	    }
	    else
	    {
		trxMgntSC.setDrCrType(TrxMgntConstant.ACCOUNT_SIGN_CREDIT);
		int trxCRTYPECount = coreCommonBO.countTrxDRCRTYPE(trxMgntSC);
		if((TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
			&& TrxMgntConstant.ACCOUNT_SIGN_CREDIT.equals(ctstrxtypeVO.getCR_DR_FOREX()) && trxCRTYPECount != 0)
			|| (TrxMgntConstant.DEPOSIT.equals(ctstrxtypeVO.getTYPE()) && trxCRTYPECount != 0))
		{
		    criteria.setCR_DR_FOREX("C"); // w_lookup_amf_trxtype
		}
		else
		{
		    if(TrxMgntConstant.WITHDRAWAL.equals(ctstrxtypeVO.getTYPE())
			    && (TrxMgntConstant.HOUSE_CHEQUE.equals(ctstrxtypeVO.getCHQ_RELATED()) || TrxMgntConstant.CLEARING_CHEQUE
				    .equals(ctstrxtypeVO.getCHQ_RELATED())))
		    {
			criteria.setBS_CONTRA("X");
			criteria.setGMI_FLAG("X");
			criteria.setAffectPassChq("3");
			criteria.setFlag("AMF");
			criteria.setTrxType(null); // w_lookup_amf_dyn
		    }
		    else
		    {
			if("0".equals(ctstrxtypeVO.getNOSTRO_MVT()))
			{
			    criteria.setBS_CONTRA("C");
			    criteria.setGMI_FLAG("N");
			    criteria.setFlag("AMF");
			    criteria.setTrxType(null); // w_lookup_amf_dyn
			}
			else
			{
			    criteria.setTrxType(null);
			    criteria.setBS_CONTRA("X");
			    criteria.setGMI_FLAG("X");
			    criteria.setFlag("AMF");
			    criteria.setTrxType(null); // w_lookup_amf_dyn
			}
		    }
		}
	    }
	}
	return criteria;
    }

    private AccountSC returnTrxToAccCriteria(AccountSC criteria, CTSTRXTYPEVO ctstrxtypeVO) throws BaseException
    {
	criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	criteria.setFlag("AMF");

	TrxMgntSC trxMgntSC = new TrxMgntSC();
	trxMgntSC.setCompCode(criteria.getCompCode());
	trxMgntSC.setTrxType(criteria.getTrxType());
	String db_acc = coreCommonBO.returnDBAccount(trxMgntSC);

	if("".equals(db_acc))
	{
	    if(TrxMgntConstant.DEPOSIT.equals(ctstrxtypeVO.getTYPE())
		    && TrxMgntConstant.HOUSE_CHEQUE.equals(ctstrxtypeVO.getCHQ_RELATED()))
	    {
		criteria.setBS_CONTRA("X");
		criteria.setGMI_FLAG("X");
		criteria.setAffectPassChq("3");
		criteria.setTrxType(null); // w_lookup_amf_dyn
	    }
	    else
	    {
		if("1".equals(ctstrxtypeVO.getNOSTRO_MVT()))
		{
		    criteria.setBS_CONTRA("X");
		    criteria.setGMI_FLAG("X");
		    criteria.setTrxType(null); // w_lookup_amf_dyn
		}
		else
		{
		    if(TrxMgntConstant.CLEARING_CHEQUE.equals(ctstrxtypeVO.getCHQ_RELATED()))
		    {
			if("C".equals(ctstrxtypeVO.getTYPE()))
			{
			    criteria.setBS_CONTRA("B"); // Bank
			}
			else
			{
			    if("D".equals(ctstrxtypeVO.getTYPE()))
			    {
				criteria.setBS_CONTRA("X");
			    }
			}
		    }
		    criteria.setTrxType(null); // w_lookup_amf_dyn
		}
	    }

	}
	else
	{
	    trxMgntSC.setDrCrType(TrxMgntConstant.ACCOUNT_SIGN_CREDIT);
	    int trxCRTYPECount = coreCommonBO.countTrxDRCRTYPE(trxMgntSC);
	    if((TrxMgntConstant.WITHDRAWAL.equals(ctstrxtypeVO.getTYPE()) || (TrxMgntConstant.TRANSFER
		    .equals(ctstrxtypeVO.getTYPE()) && TrxMgntConstant.ACCOUNT_SIGN_DEBIT.equals(ctstrxtypeVO
		    .getCR_DR_FOREX())))
		    && (trxCRTYPECount != 0))
	    {
		criteria.setCR_DR_FOREX("C"); // w_lookup_amf_trxtype
	    }
	    else
	    {
		trxMgntSC.setDrCrType(TrxMgntConstant.ACCOUNT_SIGN_DEBIT);
		int trxDRTYPECount = coreCommonBO.countTrxDRCRTYPE(trxMgntSC);
		if((TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
			&& TrxMgntConstant.ACCOUNT_SIGN_CREDIT.equals(ctstrxtypeVO.getCR_DR_FOREX()) && trxDRTYPECount != 0)
			|| (TrxMgntConstant.DEPOSIT.equals(ctstrxtypeVO.getTYPE()) && trxDRTYPECount != 0))
		{
		    criteria.setCR_DR_FOREX("D"); // w_lookup_amf_trxtype
		}
		else
		{
		    if(TrxMgntConstant.DEPOSIT.equals(ctstrxtypeVO.getTYPE())
			    && TrxMgntConstant.HOUSE_CHEQUE.equals(ctstrxtypeVO.getCHQ_RELATED()))
		    {
			criteria.setBS_CONTRA("X");
			criteria.setGMI_FLAG("X");
			criteria.setAffectPassChq("3");
			criteria.setTrxType(null); // w_lookup_amf_dyn
		    }
		    else
		    {
			if("1".equals(ctstrxtypeVO.getNOSTRO_MVT()))
			{
			    criteria.setBS_CONTRA("X");
			    criteria.setGMI_FLAG("X");
			    criteria.setTrxType(null); // w_lookup_amf_dyn
			}
			else
			{
			    if(TrxMgntConstant.CLEARING_CHEQUE.equals(ctstrxtypeVO.getCHQ_RELATED()))
			    {
				if("C".equals(ctstrxtypeVO.getTYPE()))
				{
				    criteria.setBS_CONTRA("B");
				}
				else
				{
				    if("D".equals(ctstrxtypeVO.getTYPE()))
				    {
					criteria.setBS_CONTRA("X");
				    }
				}
			    }
			    criteria.setTrxType(null); // w_lookup_amf_dyn
			}
		    }
		}
	    }
	}
	return criteria;
    }

    /**
     * n_transaction.uf_dw_main_rbuttondown : case "ctrl_sl"
     * 
     * @param criteria
     * @param ctstrxtypeVO
     * @return AccountSC
     * @throws BaseException
     */
    private AccountSC returnTrxCtrlAccCriteria(AccountSC criteria/*
								  * ,
								  * CTSTRXTYPEVO
								  * ctstrxtypeVO
								  */) throws BaseException
    {
	criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	criteria.setFlag("AMF");
	criteria.setTrxType(null); // w_lookup_amf_trxtype
	return criteria;
    }

    /**
     * n_transaction.uf_dw_main_rbuttondown : case "ch_ac_sl"
     * 
     * @param criteria
     * @param ctstrxtypeVO
     * @return AccountSC
     * @throws BaseException
     */
    private AccountSC returnTrxChargeAccCriteria(AccountSC criteria, CTSTRXTYPEVO ctstrxtypeVO) throws BaseException
    {
	criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	if("0".equals(ctstrxtypeVO.getNOSTRO_MVT()))
	{
	    criteria.setBS_CONTRA("C"); // Client
	    criteria.setGMI_FLAG("N"); // Non Internal
	}
	else
	{
	    criteria.setBS_CONTRA("X");
	    criteria.setGMI_FLAG("X");
	}
	criteria.setFlag("AMF");
	criteria.setTrxType(null); // w_lookup_amf_trxtype
	return criteria;
    }

    public List<AMFVO> getAccountList(AccountSC criteria) throws BaseException
    {
	//Habib Baalbaki accocunt restriction 372747
	callFillAccRestricted(criteria);
	
	return accountDAO.checkAccountInAMF(criteria);
    }

    public List<AMFVO> returnAccountsInAMFByCondition(AccountSC criteria) throws BaseException
    {
	List<AMFVO> amfList = accountDAO.checkAccountInAMF(criteria);
	return (amfList == null) ? new ArrayList<AMFVO>() : amfList;
    }

    public boolean verifyCifAllowedToDebitOrCredit(AccountSC criteria) throws BaseException
    {
	String verifyValue = accountDAO.verifyCifAllowedToDebitOrCredit(criteria);
	if("3".equals(verifyValue))
	{
	    throw new BOException(MessageCodes.CLIENT_NOT_ALLOWED_CREDIT_DEBIT);// TODO
	    // These
	    // messages
	    // should
	    // replace
	    // with
	    // new
	    // after
	    // executed
	    // in
	    // db
	}
	else if("1".equals(verifyValue))
	{
	    throw new BOException(MessageCodes.CLIENT_NOT_ALLOWED_CREDIT);// TODO
	    // These
	    // messages
	    // should
	    // replace
	    // with
	    // new
	    // after
	    // executed
	    // in
	    // db
	}
	return true;
    }

    @Override
    public int checkBranchExistsInAMF(AccountSC criteria) throws DAOException
    {
	return accountDAO.checkBranchExistsInAMF(criteria);
    }

    @Override
    public List returnAccountsDataFromW_cif_accounts1_List(AccountSC criteria) throws BaseException
    {
	return accountDAO.returnAccountsDataFromW_cif_accounts1_List(criteria);
    }

    @Override
    public int returnAccountsDataFromW_cif_accounts1_ListCount(AccountSC criteria) throws BaseException
    {

	if(commonLibBO.returnIsSybase() == 1)
	 {
	
	 coreCommonProcedureBO.dropAccHashTables();
	 coreCommonProcedureBO.createAccHashTables();
	
	  }
	AccRestrictedSC accRestrictedSC  = new AccRestrictedSC();
	accRestrictedSC.setFrAcBr(new BigDecimal(0));
	accRestrictedSC.setFrAcCif(criteria.getCif_no());
	accRestrictedSC.setFrAcCy(new BigDecimal(0));
	accRestrictedSC.setFrAcGl(new BigDecimal(0));
	accRestrictedSC.setFrAcSl(new BigDecimal(0));
	accRestrictedSC.setToAcBr(new BigDecimal(9999));
	accRestrictedSC.setToAcCif(criteria.getCif_no());
	accRestrictedSC.setToAcCy(new BigDecimal(999));
	accRestrictedSC.setToAcGl(new BigDecimal(999999));
	accRestrictedSC.setToAcSl(new BigDecimal(999));
	accRestrictedSC.setAppName(criteria.getAppName());
	accRestrictedSC.setUserId(criteria.getUserId());
	accRestrictedSC.setCompCode(criteria.getCompCode());
	accRestrictedSC.setBranchCode(criteria.getBranchCode());
	accRestrictedSC.setProgRef(criteria.getScreenRef());
	coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);
	
	return accountDAO.returnAccountsDataFromW_cif_accounts1_ListCount(criteria);
    }

    @Override
    public List accountsDataBDCList(AccountSC criteria) throws BaseException
    {
	return accountDAO.accountsDataBDCList(criteria);
    }

    @Override
    public int accountsDataBDCListCount(AccountSC criteria) throws BaseException
    {
	return accountDAO.accountsDataBDCListCount(criteria);
    }

    @Override
    public AMFVO returnAccountsDataBDC(AccountSC criteria) throws DAOException
    {
	return accountDAO.returnAccountsDataBDC(criteria);
    }

    /**
     * @author eliasaoun
     * @PB w_lookup_amf_report_company_branch
     */
    public int getAMFReportCompBranchLkpListCount(AccountSC criteria) throws BaseException
    {
	return accountDAO.getAMFReportCompBranchLkpListCount(criteria);
    }

    /**
     * @author eliasaoun
     * @PB w_lookup_amf_report_company_branch
     */
    public List<AccountCO> getAMFReportCompBranchLkpList(AccountSC criteria) throws BaseException
    {
	return accountDAO.getAMFReportCompBranchLkpList(criteria);
    }

    // NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public BigDecimal countAMFByCIFSUBNO(AccountSC criteria) throws BaseException
    {
	return accountDAO.countAMFByCIFSUBNO(criteria);
    }
    
    public int getCoveringAccountsListCount(AccountSC criteria) throws BaseException
    {
      return accountDAO.getCoveringAccountsListCount(criteria);
    }

    /**
     * @author Ramesh.Lekkala
     */
    @Override
    public List<AccountCO> getCoveringAccountsList(AccountSC criteria) throws BaseException
    {
      return accountDAO.getCoveringAccountsList(criteria);
    }

    @Override
    public AMFVO returnCardAccount(AccountSC criteria) throws BaseException
    {
	return accountDAO.returnCardAccount(criteria);
    }

    public int callFillAccRestricted(AccountSC criteria) throws BaseException
    {
    	return coreCommonProcedureBO.callFillAccRestricted(criteria);
    }
    
  //DASI170044 - Cheque Certification [mfalha]
    public List<AMFVO> getAccountListInAMF(AccountSC criteria) throws BaseException
    {
	return accountDAO.checkAccountInAMF(criteria);
    }
  //DASI170044 - Cheque Certification [mfalha]
}
