/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.cif.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.common.CoreCommonBO;
import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dao.core.cif.CifDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.FMSCTRLVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.admin.companies.CompaniesCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ciftrxtypelimit.CifTrxTypeLimitCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.trxmgnt.MICRSC;

/**
 * @author MarwanMaddah
 * 
 */
public class CifBOImpl extends BaseBO implements CifBO
{
    private CifDAO cifDAO;
    private CoreCommonBO coreCommonBO;
    private CoreCommonProcedureBO coreCommonProcedureBO;
    private CoreCommonServiceBO coreCommonServiceBO;


    public int bankCifLkpCount(CifSC criteria) throws BaseException
    {
	return cifDAO.bankCifLkpCount(criteria);
    }

    public List<CifTrxTypeLimitCO> bankCifLkpList(CifSC criteria) throws BaseException
    {
	return cifDAO.bankCifLkpList(criteria);
    }
    
    /**
     * return the CIF list count...
     * 
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int cifListCount(CifSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	return cifDAO.cifListCount(criteria);
    }

    /**
     * return a list contains all CIF ids based on the criteria...
     * 
     * @param criteria
     * @return list
     * @throws BaseException
     */
    public List cifList(CifSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	return cifDAO.cifList(criteria);
    }

    /**
     * return the cif object related to cif_no.
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public CIFVO returnCifByNo(CifSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	CIFVO cifVO = cifDAO.returnCifByNo(criteria);

	if("1".equals(criteria.getRetExpIfExsits()))
	{
	    if(cifVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
	    }
	    else if(ConstantsCommon.CIF_SUSPENDED.equals(cifVO.getSTATUS()))
	    {
		/*
		 * reda SUPT190047 - #866114 Unable to Delete the Special
		 * Condition
		 */
		if(!"1".equals(criteria.getAllow_suspended_cif()))
		{
		    throw new BOException(MessageCodes.CLIENT_CIF_IS_SUSPENDED);
		}
	    }
	    else if(ConstantsCommon.CIF_DELETED.equals(cifVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.CLIENT_CIF_IS_DELETED);
	    }
	    else if(ConstantsCommon.CIF_INACTIVE.equals(cifVO.getSTATUS()))
	    {
		throw new BOException(MessageCodes.CLIENT_CIF_IS_INACTIVE);
	    }
	}
	
	//Hala Al Sheikh - BIPL180103
	if (!StringUtil.isEmptyString(criteria.getBlkListScreenCheck()))
	{
	    FomCO fomCO = new FomCO();
	    fomCO.setLoginCompCode(criteria.getComp_code());
	    fomCO.setCifVO(cifVO);
	    fomCO.setLoginPreferrredLanguage(criteria.getPreferredLanguage());
	    fomCO.setBlackListInCifName(criteria.getBlkListScreenCheck());
	    fomCO.setBlackListAction(NCifMaintenanceConstant.FOM_BLKLIST_FROM_DEPENDENCY);
	    coreCommonServiceBO.checkFomBtnCifBlackList(fomCO);
	    if(!StringUtil.isEmptyString(fomCO.getBlkListWarnMessage()))
	    {
		cifVO.setDESCRIPTION(null);
        	cifVO.setDESCRIPTION(commonLibBO.returnTranslErrorMessage(MessageCodes.CIF_IS_BLACKLISTED,criteria.getPreferredLanguage()));
	    }
	}
	//end Hala Al Sheikh - BIPL180103
	
	return cifVO;
    }

    /**
     * return true if the CIF_id is valid and exists in database.
     */
    public Boolean checkCIFValidation(CifSC criteria) throws BaseException
    {
	Boolean result = false;
	int theValue = cifDAO.checkCIFValidation(criteria);
	if(theValue > 0)
	{
	    result = true;
	}
	return result;
    }

    /**
     * @return the cifDAO
     */
    public CifDAO getCifDAO()
    {
	return cifDAO;
    }

    /**
     * @param cifDAO the cifDAO to set
     */
    public void setCifDAO(CifDAO cifDAO)
    {
	this.cifDAO = cifDAO;
    }

    /**
     * return the data for showing the CIF Lookup query popup
     * 
     * @param Search criteria
     * @return List
     * @throws BaseException
     */
    public List cifLookupQueryList(CifSC criteria) throws BaseException
    {
	cifLkpParamPreparation(criteria);
	return cifDAO.cifLookupQueryList(criteria);
    }

    /**
     * return the data count for showing the CIF Lookup query Popup
     * 
     * @param Search criteria
     * @return List
     * @throws BaseException
     */
    public int cifLookupQueryListCount(CifSC criteria) throws BaseException
    {
	cifLkpParamPreparation(criteria);
	return cifDAO.cifLookupQueryListCount(criteria);
    }

    /**
     * This function returns the CIFCO where all the information needed for the
     * CIF found in CIF1 And CIF are found this is the same function found in
     * returnCIFinfo
     * 
     * @param criteria CifSC
     * @return
     * @throws BaseException
     */
    public CIFCO returnCIFinfo(CifSC criteria) throws BaseException
    {
	return cifDAO.returnCifInfo(criteria);
    }

    private void cifLkpParamPreparation(CifSC criteria) throws BaseException
    {
	BigDecimal forbidAccount = new BigDecimal(TrxMgntConstant.FORBID_ACCOUNT);
	BigDecimal forbidCash = new BigDecimal(TrxMgntConstant.FORBID_CASH);

	/**
	 * @author marwanmaddah: In case transaction type not null ...
	 */
	if(!NumberUtil.isEmptyDecimal(criteria.getTrxType())
		&& "true".equals(StringUtil.nullToEmpty(criteria.getBanksLkp())))
	{
	    CTSTRXTYPEVO ctstrxtypeVO = new CTSTRXTYPEVO();
	    ctstrxtypeVO.setCOMP_CODE(criteria.getComp_code());
	    ctstrxtypeVO.setCODE(criteria.getTrxType());
	    ctstrxtypeVO.setSTATUS(TrxMgntConstant.STATUS_APPROVE);
	    ctstrxtypeVO = coreCommonBO.findTrxType(ctstrxtypeVO);

	    /**
	     * @author marwanmaddah: Corr Bank LookUp management
	     */
	    if("true".equals(StringUtil.nullToEmpty(criteria.getCorrBankLkp())))
	    {
		if("0".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getSHOW_ALL_BANK_CIF())))
		{
		    if(TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
			    && (forbidAccount.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE())) || forbidCash
				    .equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))))
		    {
			criteria.setLookupCorrBank("true");
		    }
		    else
		    {
			criteria.setLookupBankCif("true");
		    }
		}
		else
		{
		    criteria.setLookupBankCif("true");
		}
	    }
	    /**
	     * @author marwanmaddah: Bank Cif Lookup in transaction screen ...
	     */
	    if("true".equals(StringUtil.nullToEmpty(criteria.getBankCifLkp())))
	    {
		if(TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
			&& "1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getUTILITY_PAYMENT())))
		{
		    criteria.setLookupCorrBank("true");
		}
		else
		{
		    criteria.setClearingHouse(ctstrxtypeVO.getCLEARING_HOUSE());
		    criteria.setLookupBankCifAib("true");
		}
	    }

	    /**
	     * @author marwanmaddah: benef Bank lookup in transaction screen ...
	     */
	    if("true".equals(StringUtil.nullToEmpty(criteria.getBenefBankLkp())))
	    {
		if((TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE()) && (forbidAccount.equals(NumberUtil
			.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE())) || forbidCash.equals(NumberUtil
			.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))))
			|| "1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF())))
		{
		    if("1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF())))
		    {
			if(!TrxMgntConstant.SEND_SWIFT.equals(StringUtil.nullToEmpty(ctstrxtypeVO.getSEND_SWIFT())))
			{
			    criteria.setLookupBankCif("true");
			}
		    }
		    else
		    {
			criteria.setTrxType(null);
			criteria.setCurrencyCode(null);
		    }
		    if(!"1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF()))
			    || ("1".equals(StringUtil.nullToEmpty(ctstrxtypeVO.getFILTER_BENEF())) && TrxMgntConstant.SEND_SWIFT
				    .equals(StringUtil.nullToEmpty(ctstrxtypeVO.getSEND_SWIFT()))))
		    {
			criteria.setLookupCorrBank("true");
		    }
		}
		else
		{
		    criteria.setLookupBankCif("true");
		}
	    }

	    /**
	     * @author marwanmaddah: intermediary bank lookup in non financial
	     *         information section in transaction screen ...
	     */
	    if("true".equals(StringUtil.nullToEmpty(criteria.getIntermBankLkp())))
	    {
		if(TrxMgntConstant.TRANSFER.equals(ctstrxtypeVO.getTYPE())
			&& (forbidAccount.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE())) || forbidCash
				.equals(NumberUtil.emptyDecimalToZero(ctstrxtypeVO.getTRSFR_TYPE()))))
		{
		    criteria.setTrxType(null);
		    criteria.setCurrencyCode(null);
		    criteria.setLookupCorrBank("true");
		}
		else
		{
		    criteria.setLookupBankCif("true");
		}
	    }
	}
    }

    // private void retrieveRecordDependencyByIvCRUD(LostFoundManagementCO
    // lostFoundManagementCO)
    // {
    // LostFoundScreenUtility screenUtility = new
    // LostFoundScreenUtility(getAdditionalScreenParams());
    //
    // screenUtility.addScreenDisplay_IS_READONLY(true,
    // LOSTFOUND_ELEMENTS.DATE_REPORTED, new BigDecimal(0));
    //
    // screenUtility.addScreenDisplay_IS_READONLY(true,
    // LOSTFOUND_ELEMENTS.ACC_BR, new BigDecimal(1));
    // screenUtility.addScreenDisplay_IS_READONLY(true,
    // LOSTFOUND_ELEMENTS.ACC_CY, new BigDecimal(1));
    // screenUtility.addScreenDisplay_IS_READONLY(true,
    // LOSTFOUND_ELEMENTS.ACC_GL, new BigDecimal(1));
    // screenUtility.addScreenDisplay_IS_READONLY(true,
    // LOSTFOUND_ELEMENTS.ACC_CIF, new BigDecimal(1));
    // screenUtility.addScreenDisplay_IS_READONLY(true,
    // LOSTFOUND_ELEMENTS.ACC_SL, new BigDecimal(1));
    // screenUtility.addScreenDisplay_IS_READONLY(true,
    // LOSTFOUND_ELEMENTS.ACC_ADD_REF, new BigDecimal(1));
    //
    // }

    public CIFVO returnCIF(CifSC criteria) throws BaseException
    {
	return cifDAO.returnCIF(criteria);
    }

    /**
     * return the cif1 object with Passport Info related to cif_no.
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public FomCO returnPassportInfoFromCIF(CifSC criteria) throws BaseException
    {
	return cifDAO.returnPassportInfoFromCIF(criteria);
    }
    
    /**
     * return the cif1 object with Passport Info related to cif_no.
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public FomCO returnPassportInfoFromCIF(FomCO fomCO) throws BaseException
    {
	// Hasan Bug#566067 - BMOUPI170480 20/09/2017
	CifSC criteria = new CifSC();
	criteria.setCompCode(fomCO.getLoginCompCode());
	criteria.setCompCodeCif(NumberUtil.nullEmptyToValue(fomCO.getCompCodeCif(), fomCO.getLoginCompCode()));
	criteria.setCif_no(fomCO.getCifVO().getCIF_NO());

	CTSTELLERVO ctsTellerVO = fomCO.getCtsTellerVO();

	fomCO = cifDAO.returnPassportInfoFromCIF(criteria);
	if(fomCO == null)
	{
	    fomCO = new FomCO();
	}
	fomCO.setAccesByTeller(
		coreCommonServiceBO.checkAccesTellerModified(ctsTellerVO, NCifMaintenanceConstant.PASSPORT_INFO));
	return fomCO;
    }

    /**
     * return the lookup related to dw_lookup_cif_no_acc
     */
    public List cifNoAccList(CifSC criteria) throws BaseException
    {
	return cifDAO.cifNoAccList(criteria);
    }

    /**
     * return the row count for lookup related to dw_lookup_cif_no_acc
     */
    public int cifNoAccListCount(CifSC criteria) throws BaseException
    {
	return cifDAO.cifNoAccListCount(criteria);
    }

    public CIFCO cifClientDetailsInfo(CifSC criteria) throws BaseException
    {
	return cifDAO.cifClientDetailsInfo(criteria);
    }

    @Override
    public List cifBankList(CifSC criteria) throws BaseException
    {
	return cifDAO.cifBankList(criteria);
    }

    @Override
    public int cifBankListCount(CifSC criteria) throws BaseException
    {
	return cifDAO.cifBankListCount(criteria);
    }

    @Override
    public CIFVO returnCifNameByCifNo(CifSC criteria) throws BaseException
    {	
	CIFVO cifVO = cifDAO.returnCifNameByCifNo(criteria);
	//Hala Al Sheikh - BIPL180103
	if (!StringUtil.isEmptyString(criteria.getBlkListScreenCheck()))
	{
	    FomCO fomCO = new FomCO();
	    fomCO.setLoginCompCode(criteria.getComp_code());
	    fomCO.setCifVO(cifVO);
	    fomCO.setLoginPreferrredLanguage(criteria.getPreferredLanguage());
	    fomCO.setBlackListInCifName(criteria.getBlkListScreenCheck());
	    fomCO.setBlackListAction(NCifMaintenanceConstant.FOM_BLKLIST_FROM_DEPENDENCY);
	    coreCommonServiceBO.checkFomBtnCifBlackList(fomCO);
	    if(!StringUtil.isEmptyString(fomCO.getBlkListWarnMessage()))
	    {
		cifVO.setDESCRIPTION(null);
		cifVO.setDESCRIPTION(commonLibBO.returnTranslErrorMessage(MessageCodes.CIF_IS_BLACKLISTED,criteria.getPreferredLanguage()));
	    }
	}
	//
	return cifVO; 
    }

    @Override
    public List cifJointList(CifSC criteria) throws BaseException
    {
	return cifDAO.cifJointList(criteria);
    }

    @Override
    public int cifJointListCount(CifSC criteria) throws BaseException
    {
	return cifDAO.cifJointListCount(criteria);
    }

    @Override
    public String getGLType(CifSC cifSC) throws BaseException
    {
	return cifDAO.getGLType(cifSC);
    }

    @Override
    public BigDecimal validateCifByAmfDyn() throws BaseException
    {
	return cifDAO.validateCifByAmfDyn();
    }

    @Override
    public BigDecimal validateCifByAmfRet(CifSC cifSC) throws BaseException
    {
	return cifDAO.validateCifByAmfRet(cifSC);
    }

    @Override
    public int checkAdditionalReference(CifSC cifSC) throws BaseException
    {
	return cifDAO.checkAdditionalReference(cifSC);
    }

    public BigDecimal returnCIFBankForeignCheques(MICRSC micrSC) throws BaseException
    {
	return cifDAO.returnCIFBankForeignCheques(micrSC);
    }

    public String returnCIFName(MICRSC micrSC) throws BaseException
    {
	return cifDAO.returnCIFName(micrSC);
    }

    public CIFVO returnCIFNameAIB(MICRSC micrSC) throws BaseException
    {
	return cifDAO.returnCIFNameAIB(micrSC);
    }

    public BigDecimal returnMinCIFCompRef(MICRSC micrSC) throws BaseException
    {
	return cifDAO.returnMinCIFCompRef(micrSC);
    }

    public List cifAllAmfList(CifSC criteria) throws BaseException
    {
	return cifDAO.cifAllAmfList(criteria);
    }

    public int cifAllAmfListCount(CifSC criteria) throws BaseException
    {
	return cifDAO.cifAllAmfListCount(criteria);
    }

    public int returnCifFmsListCount(CifSC criteria) throws BaseException
    {
	FMSCTRLVO fmsCtrlVO = new FMSCTRLVO();
	fmsCtrlVO.setCOMP_CODE(criteria.getCompCode());
	fmsCtrlVO.setBRANCH_CODE(criteria.getBranchCode());
	fmsCtrlVO = (FMSCTRLVO) genericDAO.selectByPK(fmsCtrlVO);

	if(fmsCtrlVO != null && StringUtil.isNotEmpty(fmsCtrlVO.getSHOW_JOINT_CIF_IN_LOOKUP())
		&& fmsCtrlVO.getSHOW_JOINT_CIF_IN_LOOKUP().equals("Y"))
	{
	    return cifDAO.returnJointCifFmsListCount(criteria);
	}
	else
	{
	    return cifDAO.returnCifFmsListCount(criteria);
	}

    }

    public List<CIFCO> returnCifFmsList(CifSC criteria) throws BaseException
    {
	FMSCTRLVO fmsCtrlVO = new FMSCTRLVO();
	fmsCtrlVO.setCOMP_CODE(criteria.getCompCode());
	fmsCtrlVO.setBRANCH_CODE(criteria.getBranchCode());
	fmsCtrlVO = (FMSCTRLVO) genericDAO.selectByPK(fmsCtrlVO);

	if(fmsCtrlVO != null && StringUtil.isNotEmpty(fmsCtrlVO.getSHOW_JOINT_CIF_IN_LOOKUP())
		&& fmsCtrlVO.getSHOW_JOINT_CIF_IN_LOOKUP().equals("Y"))
	{
	    return cifDAO.returnJointCifFmsList(criteria);
	}
	else
	{
	    return cifDAO.returnCifFmsList(criteria);
	}

    }

    public CIFVO returnCifFmsByCifNo(CifSC criteria) throws BaseException
    {
	FMSCTRLVO fmsCtrlVO = new FMSCTRLVO();
	fmsCtrlVO.setCOMP_CODE(criteria.getCompCode());
	fmsCtrlVO.setBRANCH_CODE(criteria.getBranchCode());
	fmsCtrlVO = (FMSCTRLVO) genericDAO.selectByPK(fmsCtrlVO);
	CIFVO cifVO;

	if(fmsCtrlVO != null && StringUtil.isNotEmpty(fmsCtrlVO.getSHOW_JOINT_CIF_IN_LOOKUP())
		&& fmsCtrlVO.getSHOW_JOINT_CIF_IN_LOOKUP().equals("Y"))
	{
	    cifVO = cifDAO.returnJointCifFmsByCifNo(criteria);
	}
	else
	{
	    cifVO = cifDAO.returnCifFmsByCifNo(criteria);
	}

	if(cifVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
	}
	// 561518 BMOUPI170449 ,Vysakh,06/09/2017,BEGIN /
	 if(cifVO != null && !ConstantsCommon.CIF_ACTIVE.equals(cifVO.getSTATUS()))
	 {
	     if(ConstantsCommon.CIF_SUSPENDED.equals(cifVO.getSTATUS()))
	     {
	  throw new BOException(MessageCodes.CLIENT_CIF_IS_SUSPENDED);
	     }
	     else if(ConstantsCommon.CIF_DELETED.equals(cifVO.getSTATUS()))
	     {
	  throw new BOException(MessageCodes.CLIENT_CIF_IS_DELETED);
	     }
	     else if(ConstantsCommon.CIF_INACTIVE.equals(cifVO.getSTATUS()))
	     {
	  throw new BOException(MessageCodes.CLIENT_CIF_IS_INACTIVE);
	     }
	     else
	     {
	  throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
	     }
	 }
	// 561518,Vysakh,06/09/2017,END / 

	return cifVO;
    }

    public int memoDtlsCifListCount(CifSC criteria) throws BaseException
    {
	S_APPVO sAppVO = new S_APPVO();
	sAppVO.setAPP_NAME(criteria.getAppName());
	criteria.setGI_VERSION(commonLibBO.returnApplicationDetails(sAppVO).getVER());
	return cifDAO.memoDtlsCifListCount(criteria);
    }

    public List<CIFVO> memoDtlsCifList(CifSC criteria) throws BaseException
    {
	S_APPVO sAppVO = new S_APPVO();
	sAppVO.setAPP_NAME(criteria.getAppName());
	criteria.setGI_VERSION(commonLibBO.returnApplicationDetails(sAppVO).getVER());
	return cifDAO.memoDtlsCifList(criteria);
    }

    public CIFVO getMemoDtlsCif(CifSC criteria) throws BaseException
    {
	S_APPVO sAppVO = new S_APPVO();
	sAppVO.setAPP_NAME(criteria.getAppName());
	criteria.setGI_VERSION(commonLibBO.returnApplicationDetails(sAppVO).getVER());
	// added by nancy -- 31/05/2018--Bug 679865
	CifSC cifSC = new CifSC();
	cifSC.setCompCode(criteria.getCompCode());
	cifSC.setCif_no(criteria.getCif_no());
	cifSC.setAllStatus(true);
	cifSC.setRetExpIfExsits("1");
	returnCifByNo(cifSC);
	// end nancy 
	CIFVO cifVO = cifDAO.getMemoDtlsCif(criteria);
	if(cifVO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
	}
	return cifVO;

    }

    @Override
    public Integer cifBenefLkpCount(CifSC criteria) throws BaseException
    {
	return cifDAO.cifBenefLkpCount(criteria);
    }

    @Override
    public List<CifTrxTypeLimitCO> cifBenefLkpList(CifSC criteria) throws BaseException
    {
	return cifDAO.cifBenefLkpList(criteria);
    }

    @Override
    public CIFCO returnCIFDetailsforBlackListt(CifSC criteria) throws BaseException
    {
	return cifDAO.returnCIFDetailsforBlackList(criteria);
    }

    @Override
    public int cifListCountbyBrCyGl(CifSC criteria) throws BaseException
    {
	return cifDAO.cifListCountbyBrCyGl(criteria);
    }

    @Override
    public List cifListbyBrCyGl(CifSC criteria) throws BaseException
    {
	return cifDAO.cifListbyBrCyGl(criteria);
    }

    @Override
    public CIFVO getCifDetailbyBrCyGl(CifSC criteria) throws BaseException
    {
	return cifDAO.getCifDetailbyBrCyGl(criteria);
    }

    @Override
    public CIFVO cifLookupQueryObject(CifSC criteria) throws BaseException
    {
	return cifDAO.cifLookupQueryObject(criteria);
    }

    public void updateBlackListedCIF(CifSC criteria) throws BaseException
    {
	cifDAO.updateBlackListedCIF(criteria);
    }

    public String returnJointAccounts(CifSC criteria) throws BaseException
    {
	return cifDAO.returnJointAccounts(criteria);
    }

    @Override
    public List<CIFVO> cardsManagementCifList(CifSC criteria) throws BaseException
    {
	return cifDAO.cardsManagementCifList(criteria);
    }

    @Override
    public int cardsManagementCifListCount(CifSC criteria) throws BaseException
    {
	return cifDAO.cardsManagementCifListCount(criteria);
    }

    @Override
    public CIFVO returnCifDetailsForCardsManagementByCifNo(CifSC criteria) throws BaseException
    {
	CIFVO cifVO = cifDAO.returnCifDetailsForCardsManagementByCifNo(criteria);
	if(null == cifVO && BigDecimal.ONE.compareTo(NumberUtil.nullToZero(criteria.getDisplayMsg())) == 0)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CIFCODE);
	}
	return cifVO;
    }

    /**
     * @return the coreCommonBO
     */
    public CoreCommonBO getCoreCommonBO()
    {
	return coreCommonBO;
    }

    /**
     * @param coreCommonBO the coreCommonBO to set
     */
    public void setCoreCommonBO(CoreCommonBO coreCommonBO)
    {
	this.coreCommonBO = coreCommonBO;
    }

    /**
     * in PBD:f_check_teller_cif_access
     * 
     * @param cifSc
     */
    public BigDecimal checkTellerCifAccess(CifSC cifSc) throws BaseException
    {
	//DASI170068
	CIFVO cifVo = new CIFVO();
	cifVo.setCOMP_CODE(cifSc.getCompCode());
	cifVo.setCIF_NO(cifSc.getCifCode());
	cifVo = (CIFVO) genericDAO.selectByPK(cifVo);
	if(cifVo != null)
	{
	    RIFCTTVO rifCttVO = new RIFCTTVO();
	    rifCttVO.setCOMP_CODE(cifSc.getCompCode());
	    rifCttVO.setTYPE_CODE(cifVo.getCIF_TYPE());
	    rifCttVO = (RIFCTTVO) genericDAO.selectByPK(rifCttVO);
	    if(rifCttVO != null)
	    {
		cifSc.setEcoSecProfMatrix(rifCttVO.getECO_SEC_PROFESSION_MATRIX());
	    }
	}
	return cifDAO.checkTellerCifAccess(cifSc);
    }

    /**
     * Returning all CIF details with bic code, rifctt details...
     * 
     * @author: elieachkar
     * @date: Oct 18, 2013
     * @PB:
     * @param cifSC
     * @return
     * @throws BaseException
     */
    public CIFCO returnCIFDetails(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCIFDetails(cifSC);
    }

    public Integer returnCommonSwiftDataCount(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCommonSwiftDataCount(cifSC);
    }

    public List<CIFCO> returnCommonSwiftData(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCommonSwiftData(cifSC);
    }

    public Integer returnReceiverBankListCount(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnReceiverBankListCount(cifSC);
    }

    public List<CIFCO> returnReceiverBankList(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnReceiverBankList(cifSC);
    }

    public Integer returnAllCIFListCount(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnAllCIFListCount(cifSC);
    }

    public List<CIFCO> returnAllCIFList(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnAllCIFList(cifSC);
    }

    public List cifListCert(CifSC criteria) throws BaseException
    {
	return cifDAO.cifListCert(criteria);
    }

    public int cifListCountCert(CifSC criteria) throws BaseException
    {
	return cifDAO.cifListCountCert(criteria);

    }

    public Integer returnDeveloperCifFmsListCount(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnDeveloperCifFmsListCount(cifSC);
    }

    @Override
    public List<CIFVO> returnDeveloperCifFmsList(CifSC criteria) throws BaseException
    {
	return cifDAO.returnDeveloperCifFmsList(criteria);
    }

    /**
     * Method to retrieve CIF list the list of the CIF based on compCode (along
     * with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return List of cifVO Objects
     * @throws BaseException
     * @author HanaaElJazzar
     */
    @Override
    public List getCifListByGlobalCif(CifSC cifSC) throws BaseException
    {
	return cifDAO.getCifListByGlobalCif(cifSC);
    }

    /**
     * Method to retrieve CIF record details based on cifNo value, compCode
     * (along with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return CIFVO
     * @throws BaseException
     * @author HanaaElJazzar
     */
    @Override
    public CIFVO returnCifDetailsByGlobalCif(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCifDetailsByGlobalCif(cifSC);
    }

    /**
     * Method to retrieve CIF list count based on company code (along with
     * checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return int
     * @throws BaseException
     * @author HanaaElJazzar
     */
    @Override
    public int returnCifListCountByGlobalCif(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCifListCountByGlobalCif(cifSC);
    }

    /**
     * Method to retrieve CIF list result based on company code and id no and
     * status.
     * 
     * @param cifSC
     * @return List<CIFVO>
     * @throws BaseException
     * @author tonynouh
     */
    public List<CIFVO> returnCifIdNoListResult(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCifIdNoListResult(cifSC);
    }

    /**
     * Method to retrieve CIF list count based on company code and id no and
     * status.
     * 
     * @param cifSC
     * @return int
     * @throws BaseException
     * @author tonynouh
     */
    public int returnCifIdNoListCount(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCifIdNoListCount(cifSC);
    }

    /**
     * Method to retrieve CIF list result based on company code and Vehicle
     * number and status.
     * 
     * @param cifSC
     * @return List<CIFCO>
     * @throws BaseException
     * @author tonynouh
     */
    public List<CIFCO> returnCifVehicleNoListResult(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCifVehicleNoListResult(cifSC);
    }

    /**
     * Method to retrieve CIF list count based on company code and id Vehicle
     * number status.
     * 
     * @param cifSC
     * @return int
     * @throws BaseException
     * @author tonynouh
     */
    public int returnCifVehicleNoListCount(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCifVehicleNoListCount(cifSC);
    }

    
    /**
     * @author eliasaoun
     * @Desc prepare needed data to be checked before opening the lookup
     *       relevant to CORR_BANK
     */
    public CTSTRXTYPEVO returnCorrBankLookupData(CifSC criteria) throws BaseException
    {
	CTSTRXTYPEVO ctstrxtypeVO = new CTSTRXTYPEVO();
	ctstrxtypeVO.setCOMP_CODE(criteria.getCompCode());
	ctstrxtypeVO.setCODE(criteria.getTrxType());
	return coreCommonBO.findTrxType(ctstrxtypeVO);
    }
    
    @Override
    public CompaniesCO getDefaultBenefCriteria(CifSC criteria) throws BaseException
    {
	CompaniesCO companiesCO = new CompaniesCO();
	COMPANIESVO compVO = new COMPANIESVO();
	compVO.setCOMP_CODE(criteria.getComp_code());
	compVO = commonLibBO.returnCompany(compVO);
	if(compVO != null)
	{
	    compVO.setCOMP_COUNTRY(NumberUtil.nullToZero(compVO.getCOMP_COUNTRY()));
	    companiesCO.setCompaniesVO(compVO);
	}
	return companiesCO;
    }

    @Override
    public BigDecimal returnCifForBasedOnMasked(CifSC cifSC) throws BaseException
    {
	return cifDAO.returnCifForBasedOnMasked(cifSC);
    }
    
    
    public int callFillAccRestricted(AccountSC criteria) throws BaseException
    {
    	return coreCommonProcedureBO.callFillAccRestricted(criteria);
    }
    
    public void setCoreCommonProcedureBO(CoreCommonProcedureBO coreCommonProcedureBO) {
	this.coreCommonProcedureBO = coreCommonProcedureBO;
    }
    
    public int cifListCountRestricted(CifSC criteria) throws BaseException
    {
	criteria.setDefaultValues();
	criteria.setApplyRestriction("1");
	return cifDAO.cifListCount(criteria);
    }
    
    public List cifListRestricted(CifSC criteria) throws BaseException
    {
	
	AccountSC accountSC = new AccountSC();
	accountSC.setCurrAppName(criteria.getCurrAppName());
	accountSC.setPageRef(criteria.getPageRef());
	accountSC.setUserId(criteria.getUserId());
	accountSC.setCompCode(criteria.getCompCode());
	callFillAccRestricted(accountSC);
	criteria.setDefaultValues();
	criteria.setApplyRestriction("1");
	int result = 0;
	if(criteria.isCheckNbRec())
	{
	    result = cifListCountRestricted(criteria);
	    criteria.setTrxMgntNbRecords(result);
	}
	if(criteria.isCheckNbRec() && result == 0)
	{
	    criteria.setSidx(null); 
	    criteria.setSord(null);
	}
	
	
	return cifDAO.cifList(criteria);
	
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }

    public List<AccountCO> returnSwitchCIFBranchAccList(CifSC criteria) throws BaseException
    {
	return cifDAO.returnSwitchCIFBranchAccList(criteria);
    }
    
    public int returnSwitchCIFBranchAccListCount(CifSC criteria) throws BaseException
    {
	return cifDAO.returnSwitchCIFBranchAccListCount(criteria);
    }
    
    public void switchCIFBranch(CifSC criteria) throws BaseException
    {
	CifSC newCifSC = cifDAO.switchCIFBranch(criteria);
	if(newCifSC.getErrorCode() != null && newCifSC.getErrorCode().intValue() < 0
		&& newCifSC.getErrorMessage() != null)
	{
	    BOException bo;
		
	    bo = new BOException(newCifSC.getErrorMessage());

	    bo.setMsgTitleKey("Cannot_Proceed");
	    throw bo;
	}
    }
    
    public List<AccountCO> returnSwitchedCIFDataList(CifSC criteria) throws BaseException
    {
	return cifDAO.returnSwitchedCIFDataList(criteria);
    }
    
    public int returnSwitchedCIFDataListCount(CifSC criteria) throws BaseException
    {
	return cifDAO.returnSwitchedCIFDataListCount(criteria);
    }

    /**
     * TP#412662 -- [Joyce kanazeh]
     */
    @Override
    public int returnCifNoLookupCount(CifSC criteria) throws BaseException
    {
	return cifDAO.returnCifNoLookupCount(criteria);
    }

    /**
     *TP#412662 -- [Joyce kanazeh]
     */
    @Override
    public List<CIFCO> returnCifNoLookup(CifSC criteria) throws BaseException
    {
	return cifDAO.returnCifNoLookup(criteria);
    }

    /**
     * TP#412662 -- [Joyce kanazeh]
     */
    public CIFCO returnCifNoLookupById(CifSC criteria) throws BaseException
    {
	return cifDAO.returnCifNoLookupById(criteria);
    }
	
}
