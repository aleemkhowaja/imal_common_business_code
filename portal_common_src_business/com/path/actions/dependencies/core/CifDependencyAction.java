/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.memo.MemoConstants;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.core.cif.CifSC;

/**
 * @author MarwanMaddah
 * 
 */
public class CifDependencyAction extends RetailBaseAction
{
    private CIFVO cifVO;
    private CifBO cifBO;
    private CifSC criteria = new CifSC();
    private MemoSC memoSC = new MemoSC();
    private AMFVO account = new AMFVO();
    private String snameEngReadOnly;
    private BigDecimal CIF_NO;

    private String dependencyFlag;
    private String callingScreen;

    /**
     * Manage the dependency by CIF Id and fill the CIF Description, and in case
     * of any exception an action error will appear
     * 
     * @return
     */
    public String dependencyByCif()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    criteria.setCompCode(compCode);
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setIsFromDependency("1");	    
	    //Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
		criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
		criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN()); 
	    }
	    //END - Raed Saad - [BB160150]

	    if(cifVO == null || NumberUtil.isEmptyDecimal(cifVO.getCIF_NO()))
	    {
		cifVO = new CIFVO();
		//snameEngReadOnly = "readonly";//BUG #870489 ABEI190483 - Employer name not editable when we dont have CIF
	    }
	    else
	    {
		snameEngReadOnly = "readonly";  //relocate TP239210
		criteria.setCif_no(cifVO.getCIF_NO());
		if(callingScreen != null && "FOM_FundTransfer".equalsIgnoreCase(callingScreen))
		{
		    criteria.setComp_code(compCode);
		    criteria.setBranchCode(sessionCO.getBranchCode());
		    criteria.setRaFlag(sessionCO.getShowBranchesChar());
		    criteria.setRaStatus("A");
		    criteria.setRaResident("B");
		    cifVO = cifBO.cifLookupQueryObject(criteria);
		}
		else if(callingScreen != null && "FOM_EMPLOYER_CIF".equalsIgnoreCase(callingScreen))
		{
		    criteria.setComp_code(compCode);
		    criteria.setBranchCode(sessionCO.getBranchCode());
		    criteria.setRaFlag(sessionCO.getShowBranchesChar());
		    criteria.setRaStatus("A");
		    criteria.setRaResident("B");
		    cifVO = cifBO.cifLookupQueryObject(criteria);
		}
		//NABIL FEGHALI BB140155 KYC new changes
		else if(callingScreen != null && "FOM_KYC".equalsIgnoreCase(callingScreen))
		{
		    criteria.setComp_code(compCode);
		    criteria.setBanksLkp("true");
		    criteria.setBankCifLkp("true");
		    criteria.setLookupBankCif("true");
		    criteria.setBankType(null);
		    criteria.setResident("true");
		    cifVO = cifBO.cifLookupQueryObject(criteria);
		}
		else if(callingScreen != null && "AVA_FILE".equalsIgnoreCase(callingScreen))
		{
		    criteria.setComp_code(compCode);
		    criteria.setBranchCode(sessionCO.getBranchCode());
		    criteria.setRaFlag(sessionCO.getShowBranchesChar());
		    criteria.setRaStatus("A");
		    criteria.setRaResident("B");
		    // EWBI160074 -- [John Massaad]
		    if(!StringUtil.isNotEmpty(criteria.getCifType()))
		    {
			criteria.setCifType("T");// Corporate
		    }
		    criteria.setFromScreen("AVA_FILE");
		    cifVO = cifBO.cifLookupQueryObject(criteria);
		    if(cifVO == null)
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
		    }
		}
		else
		{
		    //Hala Al Sheikh - BIPL180103
		    if(callingScreen != null && "FOM_OTHER_FIN_ENGAGE_BLKLLIST".equalsIgnoreCase(callingScreen))
		    {
			 criteria.setComp_code(compCode);
			 criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
			 criteria.setBlkListScreenCheck(callingScreen);
		    }
		    //End Hala
		    
		    criteria.setIsFromDependency("1");
		    cifVO = cifBO.returnCifByNo(criteria);
		    
		    //Hala Al Sheikh - BIPL180103
		    if(callingScreen != null && "FOM_OTHER_FIN_ENGAGE_BLKLLIST".equalsIgnoreCase(callingScreen) && !StringUtil.isEmptyString(cifVO.getDESCRIPTION()))
		    {
			set_warning(cifVO.getDESCRIPTION());
		    }
		    //End Hala
		}
		if(cifVO == null)
		{
		    cifVO = new CIFVO();
		}
		else
		{
		    /**
		     * going to the common function in RetailBaseAction and
		     * check if there is any Memo.
		     */
		    if(criteria.isShowMemo())
		    {
			MemoSC memoSC = new MemoSC();
			memoSC.setCompCode(compCode);
			memoSC.setForAccOrCif(MemoConstants.CIF);
			memoSC.setCifNo(cifVO.getCIF_NO());
			checkForMemo(memoSC);
		    }
		}
	    }

	}
	catch(BOException e)
	{
	    cifVO = new CIFVO();
	    handleException(e, null, null);  
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCif method of CifDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Check CIF Id validation on cif id change management in account tag lib
     * 
     * @return
     */
    public String dependencyByCifId()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setBranchCode(NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE()));
	    criteria.setCurrencyCode(NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE()));
	    criteria.setGlCode(NumberUtil.emptyDecimalToNull(account.getGL_CODE()) );
	    criteria.setCif_no(NumberUtil.emptyDecimalToNull(account.getCIF_SUB_NO()));

	    if(dependencyFlag != null && "AmfRetAmfDyn".equals(dependencyFlag))
	    {
		dependencyForCifByAmfRetAmfDyn();
	    }
	    else
	    {
		if(!cifBO.checkCIFValidation(criteria))
		{
		    account.setCIF_SUB_NO(null);
		}
		account.setSL_NO(null);
		account.setBRIEF_NAME_ENG(null);
		account.setADDITIONAL_REFERENCE(null);
	    }
	    /**
	     * going to the common function in RetailBaseAction and check if
	     * there is any Memo.
	     */
	    // NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
	    // Check if the memo optRef is passed from parameters
	    String memoOptRef = memoSC.getOptRef();
	    // NABIL FEGHALI - FIX ISSUE #210861
	    boolean memoShowSpecialCond = memoSC.getShowSpecialConditionMessage();
	    MemoSC memoSC = new MemoSC();
	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setForAccOrCif(MemoConstants.CIF);
	    memoSC.setCifNo(criteria.getCif_no());
	    memoSC.setTrxType(criteria.getTrxType());
	    if(StringUtil.isNotEmpty(memoOptRef))
	    {
		memoSC.setOptRef(memoOptRef);
	    }
	    if(!memoShowSpecialCond)
	    {
		memoSC.setShowSpecialConditionMessage(false);
	    }
	    checkForMemo(memoSC);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // Dependency to get CIF Name
    public String dependencyByCifNo()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCif_no(CIF_NO);
	    criteria.setLang(sessionCO.getLanguage());
	    //Hala Al Sheikh - BIPL180103
	    if(callingScreen != null && "FOM_OCCUPATION_BLKLLIST".equalsIgnoreCase(callingScreen))
	    {
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		criteria.setComp_code(sessionCO.getCompanyCode());
		criteria.setBlkListScreenCheck(callingScreen);
	    }
	    //End Hala
	    cifVO = cifBO.returnCifNameByCifNo(criteria);
	    
	    if(cifVO !=null &&callingScreen != null && "FOM_OCCUPATION_BLKLLIST".equalsIgnoreCase(callingScreen) && !StringUtil.isEmptyString(cifVO.getDESCRIPTION()))
	    {
		set_warning(cifVO.getDESCRIPTION());
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCifTypeCode method of CifTypeDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    // Dependency to get CIF Name
    public String dependencyForCardsManagementCif()
    {

	try
	{
	    if(NumberUtil.isEmptyDecimal(CIF_NO))
	    {
		cifVO = new CIFVO();
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		criteria.setComp_code(sessionCO.getCompanyCode());
		criteria.setCif_no(CIF_NO);
		criteria.setLang(sessionCO.getLanguage());
		//Raed Saad - [BB160150]
		if(null == sessionCO.getCtsTellerVO())
		{
		    criteria.setAllowCifCreationMaskYN("1");
		}
		else
		{
		    criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
		}
		// END - Raed Saad - [BB160150]
		criteria.setStatus(NCifMaintenanceConstant.CIF_ACTIVE);
		criteria.setClient(NCifMaintenanceConstant.CIF_IS_BANK);
		cifVO = cifBO.returnCifDetailsForCardsManagementByCifNo(criteria);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyForCardsManagementCif method of CifTypeDependencyAction");
	    cifVO =  new CIFVO();
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /****
     * Method for checking the dependency of CIF for account component. Window
     * Name : w_lookup_amf_ret , w_lookup_amf_dyn Used in : General Accounts
     * ---> PT Details Tab
     * 
     * @return
     */
    private String dependencyForCifByAmfRetAmfDyn()
    {
	try
	{
	    String glType = cifBO.getGLType(criteria);
	    BigDecimal glCode = null;
	    criteria.setBS_CONTRA("B");
	    criteria.setGMI_FLAG("X");
	    criteria.setAffectPassChq("-1");
	    criteria.setCifType("X");
	    if(glType != null && glType.equals("I"))
	    {
		glCode = cifBO.validateCifByAmfRet(criteria);
	    }
	    else
	    {
		glCode = cifBO.validateCifByAmfDyn();
	    }
	    if(glCode == null)
	    {
		account.setCIF_SUB_NO(null);
		account.setSL_NO(null);
		account.setBRIEF_NAME_ENG(null);
		account.setADDITIONAL_REFERENCE(null);
	    }
	    else
	    {
		account.setGL_CODE(glCode);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyForCifByAmfRetAmfDyn method of CifTypeDependencyAction");
	    e.printStackTrace();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Memo dtls cif dependency CifSC.flag = null by default, for any exception
     * should be specified
     * 
     * @return
     */
    public String dependencyByMemoDtlsCif()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    // criteria.setGI_VERSION(new BigDecimal(1));
	    // Raed Saad - [BB160150]
	    if(null == sessionCO.getCtsTellerVO())
	    {
		criteria.setAllowCifCreationMaskYN("1");
	    }
	    else{
		criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN()); 
	    }
	    //END - Raed Saad - [BB160150]

	    if(criteria.getCif_no() == null)
	    {

		cifVO = new CIFVO();
	    }
	    else
	    {
		cifVO = cifBO.getMemoDtlsCif(criteria);
		/*
		 * if(cifVO==null) { cifVO = new CIFVO(); } else {
		 */
		/**
		 * going to the common function in RetailBaseAction and check if
		 * there is any Memo.
		 */
		
		/*
		 * MemoSC memoSC = new MemoSC();
		 * memoSC.setCompCode(sessionCO.getCompanyCode());
		 * memoSC.setForAccOrCif(MemoConstants.CIF);
		 * memoSC.setCifNo(cifVO.getCIF_NO()); checkForMemo(memoSC);
		 */
		// }
	    }

	}
	catch(Exception e)
	{

	    log.error(e, "Error in dependencyByMemoDtlsCif method of CifDependencyAction");
	    handleException(e, null, null);

	}
	return SUCCESS;
    }

    public String dependencyByCifFms()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setLang(sessionCO.getLanguage());

	    if(NumberUtil.isEmptyDecimal(criteria.getCifTypeCode()))
	    {
		criteria.setCifTypeCode(BigDecimal.ZERO);
	    }

	    if(NumberUtil.isEmptyDecimal(criteria.getCif_no())
		    || NumberUtil.isEmptyDecimal(criteria.getCifTypeCode()))
	    {
		cifVO = new CIFVO();
	    }
	    else
	    {
		cifVO = cifBO.returnCifFmsByCifNo(criteria);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCifFms method of CifDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#235336;Arun.R.Variyath;02/01/2015 [Start]
    // To show the message if code is invalid
    public String dependencyByCifIdWithExceptionMessage()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setComp_code(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setBranchCode(NumberUtil.emptyDecimalToNull(account.getBRANCH_CODE()));
	    criteria.setCurrencyCode(NumberUtil.emptyDecimalToNull(account.getCURRENCY_CODE()));
	    criteria.setGlCode(NumberUtil.emptyDecimalToNull(account.getGL_CODE()));
	    criteria.setCif_no(NumberUtil.emptyDecimalToNull(account.getCIF_SUB_NO()));
	    if(!cifBO.checkCIFValidation(criteria))
	    {
		throw new BOException(MessageCodes.Invalid_CIFNo);
	    }
	    account.setSL_NO(null);
	    account.setBRIEF_NAME_ENG(null);
	    account.setADDITIONAL_REFERENCE(null);
	}
	catch(Exception e)
	{
	    account.setCIF_SUB_NO(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#235336;Arun.R.Variyath;02/01/2015 [End]

    /**
     * @param cifBO the cifBO to set
     */
    public void setCifBO(CifBO cifBO)
    {
	this.cifBO = cifBO;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public CifSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CifSC criteria)
    {
	this.criteria = criteria;
    }

    public AMFVO getAccount()
    {
	return account;
    }

    public void setAccount(AMFVO account)
    {
	this.account = account;
    }

    public String getSnameEngReadOnly()
    {
	return snameEngReadOnly;
    }

    public void setSnameEngReadOnly(String snameEngReadOnly)
    {
	this.snameEngReadOnly = snameEngReadOnly;
    }

    public BigDecimal getCIF_NO()
    {
	return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIFNO)
    {
	CIF_NO = cIFNO;
    }

    public MemoSC getMemoSC()
    {
	return memoSC;
    }

    public void setMemoSC(MemoSC memoSC)
    {
	this.memoSC = memoSC;
    }

    public String getDependencyFlag()
    {
	return dependencyFlag;
    }

    public void setDependencyFlag(String dependencyFlag)
    {
	this.dependencyFlag = dependencyFlag;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

}
