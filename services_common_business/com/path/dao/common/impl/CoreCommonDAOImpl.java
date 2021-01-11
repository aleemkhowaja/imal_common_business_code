package com.path.dao.common.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dao.common.CoreCommonDAO;
import com.path.dbmaps.vo.ACC_NV_ADVICEVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.dbmaps.vo.CTSTELLERACCTYPEDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTS_CONDITIONAL_AUTOMATIONVO;
import com.path.dbmaps.vo.CTS_MANUAL_JV_TMPVO;
import com.path.dbmaps.vo.PROC_PRODUCT_PARAMVO;
import com.path.dbmaps.vo.S_ADDREF_MASK_SPECIFICVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.common.DepositerSC;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.core.account.AccountsManagementCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.common.CoreCommonSC;
import com.path.vo.core.conditionalautomation.ConditionalAutomationSC;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.reason.ReasonSC;
import com.path.vo.core.specialconditions.SpecialConditionsCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

public class CoreCommonDAOImpl extends BaseDAO implements CoreCommonDAO
{
    /**
     * This method returns the No of unclosed balances for the teller
     * creating/updating transactions.
     */
    public int checkClosedBalance(TrxMgntSC trxMgntSC) throws DAOException
    {
	int closedBalCount = ((Integer) getSqlMap().queryForObject("coreCommonMapper.select_closedBalCount", trxMgntSC))
		.intValue();
	return closedBalCount;
    }

    public ArrayList<CTSREASONSVO> returnReasonDropDownData(ReasonSC ctsreasonsvo) throws DAOException
    {
	return (ArrayList<CTSREASONSVO>) getSqlMap().queryForList("coreCommonMapper.returnReasonDropDownData", ctsreasonsvo);
    }

    // public Map<String, PropertiesByTrxTypeCO>
    // returnPropertiesByTrxType(PropertiesByTrxTypeSC propertiesByTrxTypeSC)
    // throws DAOException
    // {
    // return
    // getSqlMap().queryForMap("commonLibMapper.returnpropertiesByTrxType",
    // propertiesByTrxTypeSC, "ctstrxtypeSTDVO.ELEMENT_NAME");
    // }

    public CTSTRXTYPEVO returnTrxType(CTSTRXTYPEVO ctstrxtypeVO) throws DAOException
    {
	return (CTSTRXTYPEVO) getSqlMap().queryForObject("coreCommonMapper.returnTrxType", ctstrxtypeVO);
    }
    /**
     *	NABIL FEGHALI - BB130085 - Global Payment File 
     */
    public CTSTRXTYPE_EXTENDEDVO returnTrxTypeExtended(CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO) throws DAOException
    {
	return (CTSTRXTYPE_EXTENDEDVO) getSqlMap().queryForObject("coreCommonMapper.returnTrxTypeExtended", ctstrxtypeExtendedVO);
    }

    public FomCO returnClientBankCIF(FomSC criteria) throws DAOException
    {
	return (FomCO) getSqlMap().queryForObject("coreCommonMapper.returnClientBankCIF", criteria);
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public CTSTRXTYPEVO linkToTrxTypes(TrxMgntSC criteria) throws DAOException
    {
	return (CTSTRXTYPEVO) getSqlMap().queryForObject("coreCommonMapper.linkToTrxTypes", criteria);
    }

    /**
     * 
     * @param tellerAccTypeDetVO
     * @return
     * @throws DAOException
     */
    public Integer checkAccessOnGlType(CTSTELLERACCTYPEDETVO tellerAccTypeDetVO) throws DAOException
    {
	Integer cpt = 0;
	cpt =  (Integer) getSqlMap().queryForObject("coreCommonMapper.checkAccessOnGlType", tellerAccTypeDetVO);
	return cpt;
	
    }

    public String returnValidateIdByCif(DepositerSC depositerSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("coreCommonMapper.returnValidateIdByCif", depositerSC);
    }

    @Override
    public String returnNationalityDescription(CifSC cifSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("coreCommonMapper.returnNationalityDescription", cifSC);
    }

    public int countTrxDRCRTYPE(TrxMgntSC trxMgntSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("coreCommonMapper.countTrxDRCRTYPE", trxMgntSC)).intValue();
    }

    @Override
    public int returnClientBankCIFCount(FomSC criteria) throws DAOException
    {
	int cpt = 0;
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "coreCommonMapper.clientBankCIFMap");
	cpt = (Integer) getSqlMap().queryForObject("coreCommonMapper.returnClientBankCIFCount", criteria);
	return cpt;
    }

    @Override
    public List<FomCO> returnClientBankCIFList(FomSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "coreCommonMapper.clientBankCIFMap");

	criteria.setNbRec(5);
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("coreCommonMapper.returnClientBankCIFList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("coreCommonMapper.returnClientBankCIFList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
	
    }

    /**
     * Create Hash table #CTS_MANUAL_JV_TMP
     */
    public void createHashManualJv(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonMapper.createHashManualJv", sybOra);

    }

    /**
     * Drop Hash table #CTS_MANUAL_JV_TMP
     */
    public void dropHashManualJv(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonMapper.dropHashManualJv", sybOra);
	}
	catch(Exception e)
	{
	    log.info("No hash Table to Drop");
	    /*
	     * the try catch block is added here since in Sybase we can't check
	     * on the existence of the Hash table before creating it, but we
	     * want to continue normally even if the drop was not successful
	     */
	}
    }
    
    /**
     * insert into the hash table #CTS_MANUAL_JV_TMP
     */
    public void insertHashManualJv(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws DAOException
    {
	getSqlMap().insert("coreCommonMapper.insertHashManualJv", ctsManualJvTmpVO);
    }
    
    /**
     * delete all the data from the hash table #CTS_MANUAL_JV_TMP in case of sybase or 
     * from temp CTS_MANUAL_JV_TMP table in case of oracle
     */
    public void deleteManualJvTmp(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws DAOException
    {
	getSqlMap().delete("coreCommonMapper.deleteManualJvTmp", ctsManualJvTmpVO);
    }

	/**
	 * return main vault
	 */
    public CTSTELLERVO returnMainVault(CTSTELLERSC ctsTellerSC) throws DAOException
    {
	return (CTSTELLERVO) getSqlMap().queryForObject("coreCommonMapper.getMainVault", ctsTellerSC);
    }
    
    /**
     * NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry   
     * @param SignatureSC signatureSC
     * @throws DAOException
     */
    public HashMap<String, Integer> checkSignatureExpiryDateMandatory(SignatureSC signatureSC) throws DAOException
    {
	return (HashMap<String, Integer>)getSqlMap().queryForObject("coreCommonMapper.checkSignatureExpiryDateMandatory", signatureSC);
    }
    
    /**
     * NABIL FEGHALI - BB120129 - YMC FORMS
     * @param accountsManagementCO
     * @return
     * @throws DAOException
     */
    public List<ACC_NV_ADVICEVO> returnAccNvAdvices(AccountsManagementCO accountsManagementCO) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonMapper.returnAccNvAdvices", accountsManagementCO);
    }
    
    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * @param specialConditionsCO
     * @return
     * @throws DAOException
     */
    public BigDecimal countSpecialCondition(SpecialConditionsCO specialConditionsCO) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("coreCommonMapper.countSpecialConditions", specialConditionsCO);
    }
    
    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * @param specialConditionsCO
     * @throws DAOException
     */
    public void updateSpecialConditions(SpecialConditionsCO specialConditionsCO) throws DAOException
    {
	getSqlMap().update("coreCommonMapper.updateSpecialConditions", specialConditionsCO);
    }
    
    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * @param ctsConditionalAutomationVO
     * @return
     * @throws DAOException
     */
    public List<CTS_CONDITIONAL_AUTOMATIONVO> selectConditionalAutomation(ConditionalAutomationSC conditionalAutomationSC) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonMapper.selectConditionalAutomation", conditionalAutomationSC);
    }

    /**
     * check if CIF is black listed
     */
    public int checkIfBlackListedCIF(CifSC cifSC) throws DAOException
    {
	Integer result = (Integer) getSqlMap().queryForObject("coreCommonMapper.checkIfBlackListedCIF", cifSC);
	return (result == null) ? 0 : result.intValue();
    }
    
    public List <CIFCO> authorizedSigList(CifSC cifSC) throws DAOException 
    {
  	
     	
  	DAOHelper.fixGridMaps(cifSC, getSqlMap(), "coreCommonMapper.authorizedSigList_ResMap");
  	if(cifSC.getNbRec() == -1)
  	{
  	    return  getSqlMap().queryForList("coreCommonMapper.authorizedSigList", cifSC);
  	}
  	else
  	{
  	    return  getSqlMap().queryForList("coreCommonMapper.authorizedSigList", cifSC,
  		    cifSC.getRecToskip(), cifSC.getNbRec());
  	} 
    }

    @Override
    public List<S_ADDREF_MASK_SPECIFICVO> returnCIFAddRefNumberMask(String accountType) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonMapper.returnCIFAddRefNumberMask", accountType);
    }
    
    
    public int countClassifiedCIF(CifSC cifSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("coreCommonMapper.countClassifiedCIF", cifSC)).intValue();
    }

    @Override
    public Map<String, PROC_PRODUCT_PARAMVO> retrieveProcProductParam(CoreCommonSC coreCommonSC) throws DAOException
    {
	return getSqlMap().queryForMap("coreCommonMapper.retrieveProcProductParam", coreCommonSC, "PRODUCT_CODE");
    }

    public BigDecimal returnCIFNoOfBank(CifSC criteria) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("coreCommonMapper.returnCIFNoOfBank", criteria);
    }

    public int refreshDual() throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("coreCommonMapper.refreshDual", null)).intValue();
    }
    
    public String getPassConfirmMsgYN(Integer msgCode) throws DAOException
    {
	return ((String) getSqlMap().queryForObject("coreCommonMapper.getPassConfirmMsgYN", msgCode));
    }
    
    @Override
    public HashMap retExtSigAndUrl() throws DAOException
    {
	return (HashMap) getSqlMap().queryForObject("coreCommonMapper.retExtSigAndUrl",null);
    }
  //added by reda for SUPT190047
    public List<CIFVO> listCIFbyID(CifSC criteria) throws DAOException
    {
	    return getSqlMap().queryForList("coreCommonMapper.listCIFbyID", criteria);
	}
    //
    /**
     * @author mariachamieh BMO180276
     * 
     */
    public int validationNidCard(FomSC criteria) throws DAOException
    {
	Integer result = (Integer) getSqlMap().queryForObject("coreCommonMapper.validationNidCard", criteria);
	return (result == null) ? 0 : result.intValue();
    }
        
    
}
