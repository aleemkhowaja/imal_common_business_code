/**
 * @Auther:MarwanMaddah
 * @Date:Mar 12, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.memo.MemoConstants;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;

/**
 * @author MarwanMaddah
 * 
 */
public class AccountDependencyAction extends RetailBaseAction
{
    private AccountBO accountBO;
    AccountSC criteria = new AccountSC();
    private AMFVO account = new AMFVO();
    private AccountCO accountCO = new AccountCO();
    private String sl_flag;
    private final MemoSC memoSC = new MemoSC();

    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * Check the account validation on SL change in account tag-lib, default
     * dependency management
     * 
     * @return
     */
    public String dependencyBySLId()
    {
	try
	{
	    AccountSC criteria = new AccountSC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    BigDecimal cifCode = NumberUtil.emptyDecimalToNull(account.getCIF_SUB_NO());
	    BigDecimal brCode = NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE());
	    BigDecimal currCode = NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE());
	    BigDecimal glCode = NumberUtil.emptyDecimalToNull(account.getGL_CODE());
	    BigDecimal slNbr = NumberUtil.emptyDecimalToNull(account.getSL_NO());
	    String addRef = account.getADDITIONAL_REFERENCE();

	    criteria.setBranchCode(brCode);
	    criteria.setCurrencyCode(currCode);
	    criteria.setGlCode(glCode);
	    criteria.setCifCode(cifCode);
	    criteria.setSlNbr(slNbr);
	    criteria.setAddRef(addRef);
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setLangCode(sessionCO.getLanguage());//Hala Al Sheikh - SBI170027
	    criteria.setLovType(ConstantsCommon.STATUS_LOV);//Hala Al Sheikh - SBI170027
	    AMFVO accResult = accountBO.checkAccountValidation(criteria);
	    if(accResult == null)
	    {
		account = new AMFVO();

		account.setCIF_SUB_NO(cifCode);
		account.setBRANCH_CODE(brCode);
		account.setCURRENCY_CODE(currCode);
		account.setGL_CODE(glCode);

	    }
	    else
	    {
		account.setBRIEF_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		account.setADDITIONAL_REFERENCE(accResult.getADDITIONAL_REFERENCE());
		account.setCifDesc(accResult.getCifDesc());
		account.setAccountType(accResult.getAccountType());
		account.setCurrrencyDesc(accResult.getCurrrencyDesc());
		//Hala Al Sheikh - SBI170027
		account.setLONG_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		account.setSTATUS(accResult.getStatusDesc());
	    }

	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setForAccOrCif("A");
	    memoSC.setCifNo(cifCode);
	    memoSC.setAccBR(brCode);
	    memoSC.setAccCY(currCode);
	    memoSC.setAccGL(glCode);
	    memoSC.setAccCIF(cifCode);
	    memoSC.setAccSL(slNbr);
	    memoSC.setLovType(MemoConstants.LOV_TYPE);
	    memoSC.setLangCode(sessionCO.getLanguage());
	    checkForMemo(memoSC);
	}
	catch(BOException ex)
	{
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyBySLId method of AccountDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Dependency by Additional reference if there is an account related to the
     * entered reference will fill all account inputs else will reset the
     * additional reference.
     * 
     * @return
     */
    public String dependencyByACRef()
    {
	try
	{
	    BigDecimal displyMessage = NumberUtil.emptyDecimalToNull(criteria.getDisplayMsg());
	    AccountSC criteria = new AccountSC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    BigDecimal cifCode = NumberUtil.emptyDecimalToNull(account.getCIF_SUB_NO());
	    BigDecimal brCode = NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE());
	    BigDecimal currCode = NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE());
	    BigDecimal glCode = NumberUtil.emptyDecimalToNull(account.getGL_CODE());
	    BigDecimal slNbr = NumberUtil.emptyDecimalToNull(account.getSL_NO());
	    criteria.setDisplayMsg(displyMessage);

	    String addRef = account.getADDITIONAL_REFERENCE();
	    if(!StringUtil.nullToEmpty(addRef).isEmpty())
	    {
		criteria.setAddRef(addRef);
	    }
	    criteria.setBranchCode(brCode);
	    criteria.setCurrencyCode(currCode);
	    criteria.setGlCode(glCode);
	    criteria.setCifCode(cifCode);
	    criteria.setSlNbr(slNbr);
	    criteria.setUserId(sessionCO.getUserName());
	    if((addRef == null || "".equals(addRef))
		    && (brCode == null || currCode == null || glCode == null || cifCode == null || slNbr == null))
	    {
		account = new AMFVO();
	    }
	    else
	    {
		criteria.setLovType(ConstantsCommon.STATUS_LOV);
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		AMFVO accResult = accountBO.returnAccountByReference(criteria);

		if(accResult == null)
		{
		    account = new AMFVO();
		}
		else
		{
		    account.setBRIEF_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		    account.setADDITIONAL_REFERENCE(accResult.getADDITIONAL_REFERENCE());
		    account.setBRANCH_CODE(accResult.getBRANCH_CODE());
		    account.setCURRENCY_CODE(accResult.getCURRENCY_CODE());
		    account.setGL_CODE(accResult.getGL_CODE());
		    account.setCIF_SUB_NO(accResult.getCIF_SUB_NO());
		    account.setSL_NO(accResult.getSL_NO());
		    //Hala Al Sheikh - SBI170027
		    account.setLONG_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		    account.setSTATUS(accResult.getStatusDesc());
		}

		memoSC.setCompCode(sessionCO.getCompanyCode());
		memoSC.setForAccOrCif("A");
		memoSC.setCifNo(cifCode);
		memoSC.setAccBR(brCode);
		memoSC.setAccCY(currCode);
		memoSC.setAccGL(glCode);
		memoSC.setAccCIF(cifCode);
		memoSC.setAccSL(slNbr);
		memoSC.setLovType(MemoConstants.LOV_TYPE);
		memoSC.setLangCode(sessionCO.getLanguage());
		checkForMemo(memoSC);
	    }
	}
	catch(BOException ex)
	{
	    handleException(ex, null, null);
	    account = new AMFVO();
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByACRef method of AccountDependencyAction.java");
	    handleException(e, null, null);
	    account = new AMFVO();
	}
	return SUCCESS;
    }

    /**
     * 
     * @return
     */
    public String returnAMFBySLNo()
    {
	try
	{
	    AccountSC criteria = new AccountSC();

	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());

	    criteria.setBranchCode(account.getBRANCH_CODE());
	    criteria.setCurrencyCode(account.getCURRENCY_CODE());
	    criteria.setGlCode(account.getGL_CODE());
	    criteria.setCifCode(account.getCIF_SUB_NO());
	    criteria.setSlNbr(account.getSL_NO());

	    criteria.setLovType(ConstantsCommon.STATUS_LOV);
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    account = accountBO.returnAMFBySLNo(criteria);
	    if(account == null)
	    {
		account = new AMFVO();
	    }
	}
	catch(BOException ex)
	{
	    handleException(ex, null, null);
	    account = new AMFVO();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    account = new AMFVO();
	}
	return SUCCESS;
    }

    public AccountSC fillCommonCriteria(AccountSC criteria) throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setUserId(sessionCO.getUserName());
	criteria.setLangCode(sessionCO.getLanguage());
	
	String originOptRef = "",parentProgRef="";
	if(StringUtil.isNotEmpty(get_pageRef()))
	{
	    originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	}
	
	  /*Added to get the parent of the parent of the dynamic opts created in dynamic screen section == > to get the (GU0024)*/
	    String [] parentOptRef = returnCommonLibBO().returnOptDetailsList(
		    sessionCO.getCurrentAppName(), originOptRef);
	    if (parentOptRef[3]!= null)
	      {
		  parentProgRef= parentOptRef[3];
		  OPTVO optVO = new OPTVO();
	          optVO.setAPP_NAME(sessionCO.getCurrentAppName());
		  optVO.setPROG_REF(parentProgRef);
	          optVO = returnCommonLibBO().returnOptDetails(optVO);
		   if (null != optVO)
		   {
	            if (null != optVO.getPARENT_REF() )
		      {
	                parentProgRef= optVO.getPARENT_REF();
		      }
		   }
	      }

	// Links Management
	if("LM01MT".equals(originOptRef)
		&& ("to_acc".equals(criteria.getColumnId()) || "from_acc".equals(criteria.getColumnId())))
	{
	    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	    criteria.setGMI_FLAG("N"); // only General and Fixed Account
	}

	// chequeBook Maintenance
	if("Q000MT".equals(originOptRef))
	{
	    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	    criteria.setBS_CONTRA("X");
	    criteria.setFlag("AMF");

	    if(!"LNK_ACC_SL".equals(criteria.getColumnId()))
	    {
		if(criteria.getAllowInternAcc() == null || "".equals(criteria.getAllowInternAcc()))
		{
		    criteria.setAllowInternAcc("0");
		}

		if("0".equals(criteria.getAllowInternAcc())
			&& ConstantsCommon.INTERNAL_GL_TYPE.equals(criteria.getGL_TYPE()))
		{
		    criteria.setAffectPassChq("3");
		    criteria.setGMI_FLAG("X"); // no Restriction on GMI
		}
		else
		{
		    criteria.setAffectPassChq("2");
		    criteria.setGMI_FLAG("N"); // General or Fixed
		}
	    }
	}

	// chequeBook Query
	if("Q000QR".equals(originOptRef))
	{
	    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	    criteria.setBS_CONTRA("X");
	    criteria.setFlag("AMF");
	    criteria.setAffectPassChq("2");
	    criteria.setGMI_FLAG("X");
	    criteria.setFromScreen("CHEQUEBOOK_QUERY");
	    //bbs Cheque books linked to inactive accounts  - ALL ACCOUNTS STATUS
	    criteria.setAMFStatus("'A','C','D','F','I','M','O','P','Q','R','S','T','X','Y'");
	    
	    //Hasan Bug#627576 FIBSI180104 07/03/2018
	    CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	    ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);

	    if("1".equals(ctsControlVO.getFORBID_OTHER_BR_CHQ()))
	    {
		criteria.setBranchCode(sessionCO.getBranchCode());
	    }

	    if(!"1".equals(StringUtil.nullToEmpty(ctsControlVO.getACCEPT_INTRN_CHQ())))
	    {
		criteria.setAffectPassChq("2");
		criteria.setGMI_FLAG("N"); // only General and Fixed
	    }
	}
	 //dynamic Integration
	    if("GU0024".equals(parentProgRef))
	    {
		criteria.setBS_CONTRA("X");
		criteria.setGMI_FLAG("X");
		criteria.setFlag("AMF");
		criteria.setBankCifInd("X");
		criteria.setCifCode(BigDecimal.ZERO);
		criteria.setAMFStatus("'A','I','T'");  /*To not take into consideration the P status*/
		//criteria.setAddRef();
		 
	    }

	// CLOSED DORMANT ACCOUNTS
	if("A002CDAMT".equals(originOptRef))
	{
	    criteria.setBS_CONTRA("X");
	    criteria.setCIFStatus("'I','A'");
	    criteria.setGMI_FLAG("G");
	}

	// FOM Trx Type Limit Screen
	if(FomConstant.MAINTENANCE_OPT.equalsIgnoreCase(originOptRef))
	{
	    criteria.setACC_BC(ConstantsCommon.ON_BALANCE_SHEET);
	    criteria.setBS_CONTRA("B");
	    criteria.setFlag("AMF");
	    criteria.setGMI_FLAG("N");
	}

	return criteria;
    }

    /**
     * Dependency by Account Additional reference
     * 
     * @return String
     */
    public String dependencyByAddRef()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria = fillCommonCriteria(criteria);

	    if((criteria.getAddRef() == null || "".equals(criteria.getAddRef()))
		    && (NumberUtil.isEmptyDecimal(criteria.getBranchCode())
			    || NumberUtil.isEmptyDecimal(criteria.getCurrencyCode())
			    || NumberUtil.isEmptyDecimal(criteria.getGlCode())
			    || NumberUtil.isEmptyDecimal(criteria.getCifCode()) || NumberUtil.isEmptyDecimal(criteria
			    .getSlNbr())))
	    {
		account = new AMFVO();
	    }
	    else
	    {
		criteria.setLovType(ConstantsCommon.STATUS_LOV);
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		if(StringUtil.nullToEmpty(criteria.getFromScreen()).equals("dynamicIntegration"))
		{
		    criteria.setAMFStatus("'A','I','T'"); 
		    criteria.setBS_CONTRA("X");
		    criteria.setGMI_FLAG("X");
	            criteria.setFlag("AMF");
		    criteria.setBankCifInd("X");
		    criteria.setCifCode(BigDecimal.ZERO);
		}
		AMFVO accResult = accountBO.returnAccountByReference(criteria);

		if(accResult == null)
		{
		    account = new AMFVO();
		}
		else
		{
		    account.setBRIEF_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		    account.setADDITIONAL_REFERENCE(accResult.getADDITIONAL_REFERENCE());
		    account.setBRANCH_CODE(accResult.getBRANCH_CODE());
		    account.setCURRENCY_CODE(accResult.getCURRENCY_CODE());
		    account.setGL_CODE(accResult.getGL_CODE());
		    account.setCIF_SUB_NO(accResult.getCIF_SUB_NO());
		    account.setSL_NO(accResult.getSL_NO());
		    account.setCurrrencyDesc(accResult.getCurrrencyDesc());
		    account.setCifDesc(accResult.getCifDesc());
		    account.setAccountType(accResult.getAccountType());
		    account.setGMI_FLAG(accResult.getGMI_FLAG());
		}

		memoSC.setCompCode(criteria.getCompCode());
		memoSC.setForAccOrCif("A");
		memoSC.setCifNo(account.getCIF_SUB_NO());
		memoSC.setAccBR(account.getBRANCH_CODE());
		memoSC.setAccCY(account.getCURRENCY_CODE());
		memoSC.setAccGL(account.getGL_CODE());
		memoSC.setAccCIF(account.getCIF_SUB_NO());
		memoSC.setAccSL(account.getSL_NO());
		memoSC.setLovType(MemoConstants.LOV_TYPE);
		memoSC.setLangCode(criteria.getLangCode());
		checkForMemo(memoSC);
	    }
	}
	catch(BOException ex)
	{
	    account.setADDITIONAL_REFERENCE(null);
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByAddRef method of AccountDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * this method return All AMF Column calling by its Serial Number
     * 
     * @return
     */
    public String returnAMFBySrlNbr()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria = fillCommonCriteria(criteria);
	    
	    //habib accocunt restriction 372747
	    String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
		    sessionCO.getCurrentAppName(), get_pageRef()), get_pageRef());
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPageRef(originalProgRef);
	    
	    if((criteria.getAddRef() != null && !"".equals(criteria.getAddRef()))
		    || (!NumberUtil.isEmptyDecimal(criteria.getBranchCode())
			    && !NumberUtil.isEmptyDecimal(criteria.getCurrencyCode())
			    && !NumberUtil.isEmptyDecimal(criteria.getGlCode())
			    && !NumberUtil.isEmptyDecimal(criteria.getCifCode()) && !NumberUtil.isEmptyDecimal(criteria
			    .getSlNbr())))
	    {
		criteria.setLovType(ConstantsCommon.STATUS_LOV);
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		account = accountBO.returnAMFBySLNo(criteria);
	    }
	    if(account == null)
	    {
		account = new AMFVO();
	    }
	    /**
	     * @author sarahelhusseini added to check memo on cif when
	     *         retrieving account from SL lookup
	     */
	    if(!NumberUtil.isEmptyDecimal(account.getCIF_SUB_NO()))//Hasan Bug#472154 10/07/2017
	    {
		MemoSC memoSC = new MemoSC();
		memoSC.setCompCode(criteria.getCompCode());
		memoSC.setForAccOrCif(MemoConstants.CIF);
		memoSC.setCifNo(criteria.getCifCode());
		checkForMemo(memoSC);
	    }

	    if(NumberUtil.isEmptyDecimal(account.getSL_NO()))
	    {
		account.setADDITIONAL_REFERENCE(null);
	    }
	    else
	    {
		memoSC.setCompCode(criteria.getCompCode());
		memoSC.setForAccOrCif(MemoConstants.ACCOUNTS);
		memoSC.setLovType(MemoConstants.LOV_TYPE);
		memoSC.setCifNo(account.getCIF_SUB_NO());
		memoSC.setAccBR(account.getBRANCH_CODE());
		memoSC.setAccCY(account.getCURRENCY_CODE());
		memoSC.setAccCIF(account.getCIF_SUB_NO());
		memoSC.setAccGL(account.getGL_CODE());
		memoSC.setAccSL(account.getSL_NO());
		memoSC.setLangCode(criteria.getLangCode());
		checkForMemo(memoSC);
	    }
	}
	catch(BOException ex)
	{
	    handleException(ex, null, null);
	    account = new AMFVO();
	}
	catch(Exception e)
	{
	    log.error(e, "Error in returnAMFBySrlNbr method of AccountDependencyAction.java");
	    handleException(e, null, null);
	    account = new AMFVO();
	}
	return SUCCESS;
    }

    /**
     * the purpose of This method is to return the Cy Name, Gl Desc, CIF Name
     * and A/c Name of Account
     * 
     * @return String
     */
    public String returnAMFDetails()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.STATUS_LOV);
	    criteria.setLangCode(sessionCO.getLanguage());
	    accountCO = accountBO.returnAMFDetails(criteria);
	    if(accountCO == null)
	    {
		accountCO = new AccountCO();
	    }
	}
	catch(BOException ex)
	{
	    handleException(ex, null, null);
	    accountCO = new AccountCO();
	}
	catch(Exception e)
	{
	    log.error(e, "Error in returnAMFDetails method of AccountDependencyAction.java");
	    handleException(e, null, null);
	    accountCO = new AccountCO();
	}
	return SUCCESS;
    }

    // TP#235336;Arun.R.Variyath;02/01/2015 [START]
    // To show the message if code is invalid
    public String dependencyBySLIdWithMessage()
    {
	try
	{
	    AccountSC criteria = new AccountSC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    BigDecimal cifCode = NumberUtil.emptyDecimalToNull(account.getCIF_SUB_NO());
	    BigDecimal brCode = NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE());
	    BigDecimal currCode = NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE());
	    BigDecimal glCode = NumberUtil.emptyDecimalToNull(account.getGL_CODE());
	    BigDecimal slNbr = NumberUtil.emptyDecimalToNull(account.getSL_NO());
	    String addRef = account.getADDITIONAL_REFERENCE();

	    criteria.setBranchCode(brCode);
	    criteria.setCurrencyCode(currCode);
	    criteria.setGlCode(glCode);
	    criteria.setCifCode(cifCode);
	    criteria.setSlNbr(slNbr);
	    criteria.setAddRef(addRef);
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    account.setCIF_SUB_NO(cifCode);
	    account.setBRANCH_CODE(brCode);
	    account.setCURRENCY_CODE(currCode);
	    account.setGL_CODE(glCode);
	    AMFVO accResult = accountBO.checkAccountValidation(criteria);
	    if(accResult == null)
	    {
		account = new AMFVO();
		account.setCIF_SUB_NO(cifCode);
		account.setBRANCH_CODE(brCode);
		account.setCURRENCY_CODE(currCode);
		account.setGL_CODE(glCode);
		throw new BOException(MessageCodes.INVALID_MISSING_ACCOUNT_SL);

	    }
	    else
	    {
		account.setBRIEF_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		account.setADDITIONAL_REFERENCE(accResult.getADDITIONAL_REFERENCE());
		account.setCifDesc(accResult.getCifDesc());
		account.setAccountType(accResult.getAccountType());
		account.setCurrrencyDesc(accResult.getCurrrencyDesc());
	    }

	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setForAccOrCif("A");
	    memoSC.setCifNo(cifCode);
	    memoSC.setAccBR(brCode);
	    memoSC.setAccCY(currCode);
	    memoSC.setAccGL(glCode);
	    memoSC.setAccCIF(cifCode);
	    memoSC.setAccSL(slNbr);
	    memoSC.setLovType(MemoConstants.LOV_TYPE);
	    memoSC.setLangCode(sessionCO.getLanguage());
	    checkForMemo(memoSC);
	}
	catch(BOException ex)
	{
	    handleException(ex, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyBySLId method of AccountDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#235336;Arun.R.Variyath;02/01/2015 [END]

    /**
     * @return the account
     */
    public AMFVO getAccount()
    {
	return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(AMFVO account)
    {
	this.account = account;
    }

    /**
     * @param accountBO the accountBO to set
     */
    public void setAccountBO(AccountBO accountBO)
    {
	this.accountBO = accountBO;
    }

    /**
     * @return the sl_flag
     */
    public String getSl_flag()
    {
	return sl_flag;
    }

    /**
     * @param slFlag the sl_flag to set
     */
    public void setSl_flag(String slFlag)
    {
	sl_flag = slFlag;
    }

    public AccountSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(AccountSC criteria)
    {
	this.criteria = criteria;
    }

    public AccountCO getAccountCO()
    {
	return accountCO;
    }

    public void setAccountCO(AccountCO accountCO)
    {
	this.accountCO = accountCO;
    }

    /****
     * Method for the dependency of SL_No in an account component (The where
     * clause is different from the previous method) (Window :
     * w_lookup_amf_ret_nonint, Used in : General Account Screen)
     * 
     * @return
     */
    public String dependencyBySerialNumber()
    {
	try
	{
	    AccountSC criteria = new AccountSC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    BigDecimal cifCode = NumberUtil.emptyDecimalToNull(account.getCIF_SUB_NO());
	    BigDecimal brCode = NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE());
	    BigDecimal currCode = NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE());
	    BigDecimal glCode = NumberUtil.emptyDecimalToNull(account.getGL_CODE());
	    BigDecimal slNbr = NumberUtil.emptyDecimalToNull(account.getSL_NO());
	    criteria.setBranchCode(brCode);
	    criteria.setCurrencyCode(currCode);
	    criteria.setGlCode(glCode);
	    criteria.setCifCode(cifCode);
	    criteria.setSlNbr(slNbr);
	    criteria.setBS_CONTRA("B");
	    criteria.setGMI_FLAG("X");
	    criteria.setAffectPassChq("-1");
	    criteria.setCifType("X");
	    criteria.setAFFECT_CARD("0");
	    criteria.setUserId(sessionCO.getUserName());

	    AMFVO accResult = accountBO.validateBySlNo(criteria);
	    if(accResult == null)
	    {
		account.setBRANCH_CODE(null);
		account.setCURRENCY_CODE(null);
		account.setGL_CODE(null);
		account.setCIF_SUB_NO(null);
		account.setSL_NO(null);
		account.setBRIEF_NAME_ENG(null);
	    }
	    else
	    {
		account.setBRIEF_NAME_ENG(accResult.getBRIEF_NAME_ENG());
		account.setADDITIONAL_REFERENCE(accResult.getADDITIONAL_REFERENCE());
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyBySerialNumber method of AccountDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /****
     * Method for the dependency (Window : w_lookup_bdc )
     * 
     * @return
     */
    public String dependencyByAccountsDataBDC()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(criteria.getCurrencyCode())
		    && !NumberUtil.isEmptyDecimal(criteria.getBranchCode())
		    && !NumberUtil.isEmptyDecimal(criteria.getGlCode())
		    && !NumberUtil.isEmptyDecimal(criteria.getCifCode())
		    && !NumberUtil.isEmptyDecimal(criteria.getSlNbr()))
	    {
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		account = accountBO.returnAccountsDataBDC(criteria);
		if(account == null)
		{
		    account = new AMFVO();
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByAccountsDataBDC method of AccountDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

}
