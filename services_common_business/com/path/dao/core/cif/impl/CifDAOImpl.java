/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.cif.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.path.dao.core.cif.CifDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ciftrxtypelimit.CifTrxTypeLimitCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.trxmgnt.MICRSC;

/**
 * @author MarwanMaddah
 * 
 */
public class CifDAOImpl extends BaseDAO implements CifDAO
{
    /**
     * sql map to get the count of the CIF list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int cifListCount(CifSC criteria) throws DAOException
    {
	// Falha AMANA180481 - Retrieving joint CIFs- iMAL R14*** on release 14.1.1
	if (!NumberUtil.isEmptyDecimal(criteria.getFromDash()))
	{
	   if (criteria.getFromDash().compareTo(BigDecimal.ONE)==0 )
	   {
	      addCifWhereQueryFilter(criteria);
 	   }
	}
	 // Falha AMANA180481 - Retrieving joint CIFs- iMAL R14*** on release 14.1.1

	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.cifListCount", criteria)).intValue();
	return nb;
    }

    /**
     * sql map to get the CIF list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List cifList(CifSC criteria) throws DAOException
    {
	// Falha AMANA180481 - Retrieving joint CIFs- iMAL R14*** on release 14.1.1

	if (!NumberUtil.isEmptyDecimal(criteria.getFromDash()))
	{
	   if (criteria.getFromDash().compareTo(BigDecimal.ONE)==0 )
	   {
	      addCifWhereQueryFilter(criteria);
 	   }
	}
	 // Falha AMANA180481 - Retrieving joint CIFs- iMAL R14*** on release 14.1.1

	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	    return getSqlMap()
		    .queryForList("cifMapper.cifList", criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    public List selectListCifForFilterIdNo(CifSC criteria) throws DAOException
    {
	return (ArrayList) getSqlMap().queryForList("cifMapper.selectListCifForFilterIdNo",
		criteria);
    }
    
    /**
     * sql map to get CIFVO based on the cif_no.
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public CIFVO returnCifByNo(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.returnCifByNo", criteria);
    }

    /**
     * Sql Map to get the count of accounts that have the entered CIF_id
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int checkCIFValidation(CifSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("cifMapper.checkCifValidation", criteria)).intValue();
    }

    /**
     * sql map to get the CIF list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List cifLookupQueryList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifLookupQueryList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifLookupQueryListMap");
	    return getSqlMap().queryForList("cifMapper.cifLookupQueryList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    /**
     * sql map to get the count of the CIF list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int cifLookupQueryListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifLookupQueryListMap");
	return ((Integer) getSqlMap().queryForObject("cifMapper.cifLookupQueryListCount", criteria)).intValue();
    }

    public CIFVO cifLookupQueryObject(CifSC criteria) throws DAOException
    {
	return ((CIFVO) getSqlMap().queryForObject("cifMapper.getcifLookupQueryObject", criteria));
    }

    public CIFCO returnCifInfo(CifSC criteria) throws DAOException
    {
	return ((CIFCO) getSqlMap().queryForObject("cifMapper.returnCifInfo", criteria));
    }

    public CIFVO returnCIF(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.returnCIF", criteria);
    }

    public FomCO returnPassportInfoFromCIF(CifSC criteria) throws DAOException
    {
	return (FomCO) getSqlMap().queryForObject("cifMapper.passportInfoFromCIF", criteria);
    }

    public List cifNoAccList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifNoAccList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	    return getSqlMap().queryForList("cifMapper.cifNoAccList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public int cifNoAccListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.cifNoAccListCount", criteria)).intValue();
	return nb;
    }

    public CIFCO cifClientDetailsInfo(CifSC criteria) throws DAOException
    {
	return (CIFCO) getSqlMap().queryForObject("cifMapper.cifClientDetailsInfo", criteria);
    }

    /**
     * sql map to get the CIF Bank list based on a defined criteria
     * 
     */
    public List cifBankList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifBankList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifBankLookupQueryListMap");
	    return getSqlMap().queryForList("cifMapper.cifBankList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    /**
     * sql map to get the count of the CIF bank list based on a defined criteria
     * 
     */
    public int cifBankListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifBankLookupQueryListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.cifBankListCount", criteria)).intValue();
	return nb;
    }

    public CIFVO returnCifNameByCifNo(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.returnCifNameByCifNo", criteria);
    }

    public List cifJointList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.jointAccCIFList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	    return getSqlMap().queryForList("cifMapper.jointAccCIFList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public int cifJointListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.jointAccCIFListCount", criteria)).intValue();
	return nb;
    }

    public String getGLType(CifSC cifSC) throws DAOException
    {
	return getSqlMap().queryForObject("cifMapper.selectGlType", cifSC).toString();
    }

    public BigDecimal validateCifByAmfDyn() throws DAOException
    {
	// return getSqlMap().queryForObject("cifMapper.selectCifByAmfDyn",
	// cifSC);
	return null;
    }

    public BigDecimal validateCifByAmfRet(CifSC cifSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("cifMapper.selectCifByAmfRet", cifSC);
    }

    public int checkAdditionalReference(CifSC criteria) throws DAOException
    {
	int nb = 0;
	Object obj = getSqlMap().queryForObject("cifMapper.checkAdditionalReference", criteria);
	if(obj != null)
	{
	    nb = ((Integer) obj).intValue();
	}

	return nb;
    }

    public BigDecimal returnCIFBankForeignCheques(MICRSC micrSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("cifMapper.returnCIFBankForeignCheques", micrSC);
    }

    public String returnCIFName(MICRSC micrSC) throws DAOException
    {
	return (String) getSqlMap().queryForObject("cifMapper.returnCIFName", micrSC);
    }

    public CIFVO returnCIFNameAIB(MICRSC micrSC) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.returnCIFNameAIB", micrSC);
    }

    public BigDecimal returnMinCIFCompRef(MICRSC micrSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("cifMapper.returnMinCIFCompRef", micrSC);
    }

    public List cifAllAmfList(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "AMF.BaseResultMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifAllAmfList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("cifMapper.cifAllAmfList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public int cifAllAmfListCount(CifSC criteria) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.cifAllAmfListCount", criteria)).intValue();
	return nb;
    }

    public int memoDtlsCifListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	return ((Integer) getSqlMap().queryForObject("cifMapper.memoDtlsCifListCount", criteria)).intValue();
    }

    public List<CIFVO> memoDtlsCifList(CifSC criteria) throws DAOException
    {

	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.memoDtlsCifList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	    return getSqlMap().queryForList("cifMapper.memoDtlsCifList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}

    }

    public CIFVO getMemoDtlsCif(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.getMemoDtlsCif", criteria);
    }

    public int returnCifFmsListCount(CifSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("cifMapper.cifFmsListCount", criteria)).intValue();
    }

    @SuppressWarnings("unchecked")
    public List<CIFCO> returnCifFmsList(CifSC criteria) throws DAOException
    {

	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifFmsList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifInfoMap");
	    return getSqlMap().queryForList("cifMapper.cifFmsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}

    }

    public CIFVO returnCifFmsByCifNo(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.returnDependencyCifFms", criteria);
    }

    @Override
    public CIFCO returnCIFDetailsforBlackList(CifSC criteria) throws DAOException
    {
	// DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	return ((CIFCO) getSqlMap().queryForObject("cifMapper.returnCIFDetailsforBlackList", criteria));
    }

    @Override
    public int cifListCountbyBrCyGl(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.cifLookupQueryListCountFor_w_lookup_cif_amf_rifctt",
		criteria)).intValue();
	return nb;
    }

    @Override
    public List cifListbyBrCyGl(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifLookupQueryListFor_w_lookup_cif_amf_rifctt", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	    return getSqlMap().queryForList("cifMapper.cifLookupQueryListFor_w_lookup_cif_amf_rifctt", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    public int cifListCountCert(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMapCert");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.cifListCountCert", criteria)).intValue();
	return nb;
    }

    @Override
    public List cifListCert(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifListCert", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMapCert");
	    return getSqlMap().queryForList("cifMapper.cifListCert", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public CIFVO getCifDetailbyBrCyGl(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.getcifLookupCifDetailFor_w_lookup_cif_amf_rifctt",
		criteria);
    }

    public void updateBlackListedCIF(CifSC criteria) throws DAOException
    {
	getSqlMap().update("cifMapper.updateBlackListedCIF", criteria);
    }

    public String returnJointAccounts(CifSC criteria) throws DAOException
    {
	return (String) getSqlMap().queryForObject("cifMapper.returnJointAccounts", criteria);
    }

    public int checkIDUniqueCount(CifSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("cifMapper.checkIDUniqueCount", criteria)).intValue();
    }

    @Override
    public CIFCO checkIDUniqueness(CifSC criteria) throws DAOException
    {
	return ((CIFCO) getSqlMap().queryForObject("cifMapper.checkIDUniqueness", criteria));
    }

    @Override
    public List<CIFVO> cardsManagementCifList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cardsManagementList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	    return getSqlMap().queryForList("cifMapper.cardsManagementList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int cardsManagementCifListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifMapper.cardsManagementListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public CIFVO returnCifDetailsForCardsManagementByCifNo(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.returnCifDetailsForCardsManagementByCifNo", criteria);
    }

    @Override
    public Integer cifBenefLkpCount(CifSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("cifMapper.cifBenefLkpCount", criteria));
    }

    @Override
    public List<CifTrxTypeLimitCO> cifBenefLkpList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.cifBenefLkpList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifBenefLkp_map");
	    return getSqlMap().queryForList("cifMapper.cifBenefLkpList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public BigDecimal checkTellerCifAccess(CifSC cifSc) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("cifMapper.checkTellerCifAccess", cifSc);
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
    public CIFCO returnCIFDetails(CifSC cifSC) throws DAOException
    {
	return (CIFCO) getSqlMap().queryForObject("cifMapper.returnCIFDetails", cifSC);
    }

    /**
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public Integer returnCommonSwiftDataCount(CifSC cifSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("cifMapper.selectCommonSwiftDataCount", cifSC);
    }

    /**
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public List<CIFCO> returnCommonSwiftData(CifSC cifSC) throws DAOException
    {
	if(cifSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.selectCommonSwiftData", cifSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(cifSC, getSqlMap(), "cifMapper.swiftCIFListMap");
	    return getSqlMap().queryForList("cifMapper.selectCommonSwiftData", cifSC, cifSC.getRecToskip(),
		    cifSC.getNbRec());
	}
    }

    /**
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public Integer returnReceiverBankListCount(CifSC cifSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("cifMapper.receiverBankListCount", cifSC);
    }

    /**
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public List<CIFCO> returnReceiverBankList(CifSC cifSC) throws DAOException
    {
	if(cifSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.receiverBankList", cifSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(cifSC, getSqlMap(), "cifMapper.swiftCIFListMap");
	    return getSqlMap()
		    .queryForList("cifMapper.receiverBankList", cifSC, cifSC.getRecToskip(), cifSC.getNbRec());
	}
    }

    /**
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public Integer returnAllCIFListCount(CifSC cifSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("cifMapper.allCIFListCount", cifSC);
    }

    /**
     * 
     * @author: elieachkar
     * @date: Oct 23, 2013
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public List<CIFCO> returnAllCIFList(CifSC cifSC) throws DAOException
    {
	if(cifSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.allCIFList", cifSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(cifSC, getSqlMap(), "cifMapper.swiftCIFListMap");
	    return getSqlMap().queryForList("cifMapper.allCIFList", cifSC, cifSC.getRecToskip(), cifSC.getNbRec());
	}
    }

    @Override
    public List<CIFVO> returnDeveloperCifFmsList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.developerCifFmsList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifInfoMap");
	    return getSqlMap().queryForList("cifMapper.developerCifFmsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public Integer returnDeveloperCifFmsListCount(CifSC cifSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("cifMapper.returnDeveloperCifFmsListCount", cifSC);
    }

    /**
     * Method to retrieve CIF list count based on company code (along with
     * checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return int
     * @throws DAOException
     * @author HanaaElJazzar
     */
    @Override
    public int returnCifListCountByGlobalCif(CifSC cifSC) throws DAOException
    {
	DAOHelper.fixGridMaps(cifSC, getSqlMap(), "cifMapper.cifListMapByGlobalCif");
	return ((Integer) getSqlMap().queryForObject("cifMapper.getCifCountByGlobalCif", cifSC)).intValue();
    }

    /**
     * Method to retrieve CIF list the list of the CIF based on compCode (along
     * with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return List of cifVO Objects
     * @throws DAOException
     * @author HanaaElJazzar
     */
    @Override
    public List getCifListByGlobalCif(CifSC cifSC) throws DAOException
    {
	DAOHelper.fixGridMaps(cifSC, getSqlMap(), "cifMapper.cifListMapByGlobalCif");
	if(cifSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.getCifListByGlobalCif", cifSC);
	}
	else
	{
	    return getSqlMap().queryForList("cifMapper.getCifListByGlobalCif", cifSC, cifSC.getRecToskip(),
		    cifSC.getNbRec());
	}
    }

    /**
     * Method to retrieve CIF record details based on cifNo value, compCode
     * (along with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return CIFVO
     * @throws DAOException
     * @author HanaaElJazzar
     */
    @Override
    public CIFVO returnCifDetailsByGlobalCif(CifSC cifSC) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.cifDetailsByGlobalCif", cifSC);
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
    public List<CIFVO> returnCifIdNoListResult(CifSC cifSC) throws DAOException
    {
	DAOHelper.fixGridMaps(cifSC, getSqlMap(), "cifMapper.returnCifIdNoListResultMap");
	if(cifSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.returnCifIdNoListResult", cifSC);
	}
	else
	{
	    return getSqlMap().queryForList("cifMapper.returnCifIdNoListResult", cifSC, cifSC.getRecToskip(),
		    cifSC.getNbRec());
	}
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
    public int returnCifIdNoListCount(CifSC cifSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("cifMapper.returnCifIdNoListCount", cifSC)).intValue();
    }

    /**
     * Method to retrieve CIF list result based on company code and vehicle
     * number and status.
     * 
     * @param cifSC
     * @return List<CIFCO>
     * @throws BaseException
     * @author tonynouh
     */
    public List<CIFCO> returnCifVehicleNoListResult(CifSC cifSC) throws DAOException
    {
	DAOHelper.fixGridMaps(cifSC, getSqlMap(), "cifMapper.returnCifVehicleNoListResultMap");
	if(cifSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.returnCifVehicleNoListResult", cifSC);
	}
	else
	{
	    return getSqlMap().queryForList("cifMapper.returnCifVehicleNoListResult", cifSC, cifSC.getRecToskip(),
		    cifSC.getNbRec());
	}
    }

    /**
     * Method to retrieve CIF list count based on company code and vehicle
     * number and status.
     * 
     * @param cifSC
     * @return int
     * @throws BaseException
     * @author tonynouh
     */
    public int returnCifVehicleNoListCount(CifSC cifSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("cifMapper.returnCifVehicleNoListCount", cifSC)).intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CIFCO> returnJointCifFmsList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.jointCifFmsList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifInfoMap");
	    return getSqlMap().queryForList("cifMapper.jointCifFmsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}

    }

    @Override
    public int returnJointCifFmsListCount(CifSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("cifMapper.jointCifFmsListCount", criteria)).intValue();
    }

    @Override
    public CIFVO returnJointCifFmsByCifNo(CifSC criteria) throws DAOException
    {
	return (CIFVO) getSqlMap().queryForObject("cifMapper.returnDependencyJointCifFms", criteria);
    }

    @Override
    public int bankCifLkpCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	return ((Integer) getSqlMap().queryForObject("cifMapper.bankCifLkpCount", criteria)).intValue();
    }

    @Override
    public List<CifTrxTypeLimitCO> bankCifLkpList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.bankCifLkpList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
	    return getSqlMap().queryForList("cifMapper.bankCifLkpList", criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public BigDecimal returnCifForBasedOnMasked(CifSC cifSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("cifMapper.returnCifForBasedOnMasked", cifSC);
    }

    // Falha AMANA180481 - Retrieving joint CIFs- iMAL R14*** on release 14.1.1
    private void addCifWhereQueryFilter(CifSC criteria) throws DAOException
    {
	String cifWhereQuery = "";
	HashMap fieldMap = (HashMap) criteria.getSrchMapFldsOnly();
	if(fieldMap != null && !fieldMap.isEmpty())
	{
	    Iterator it = fieldMap.entrySet().iterator();
	    while(it.hasNext())
	    {
		Entry entry = (Entry) it.next();
		String columnName = entry.getKey() != null ? (String) entry.getKey() : "";
		String value = entry.getValue() != null ? (String) entry.getValue() : "";

		if(columnName.contains("ID_NO"))
		{
		    // boolean isValidNumber = NumberUtil.isNumber(value);
		    // if(isValidNumber)
		    // {
//		    List<CIFCO> listCifForFilterIdNo = new ArrayList<CIFCO>();
		    criteria.setId_no(value);
//		    listCifForFilterIdNo = selectListCifForFilterIdNo(criteria);
//		    StringBuffer resultCIFList = new StringBuffer();
//		    if(!listCifForFilterIdNo.isEmpty())
//		    {
//			String separetor = "";
//			for(int i = 0; i < listCifForFilterIdNo.size(); i++)
//			{
//			    CIFCO cifCO = listCifForFilterIdNo.get(i);
//			    if(i > 0)
//			    {
//				separetor = ",";
//			    }
//			    resultCIFList.append(separetor).append(cifCO.getCifVO().getCIF_NO());
//			}
//			cifWhereQuery += " AND CIF_NO IN ( " + resultCIFList + ")";
//		    }
		    
		    cifWhereQuery = "true";
		    if(criteria.getColSearchQuery() != null)
		    {
			String idNoFilter = criteria.getColSearchQuery().replace("ID_NO", "'%" + value + "%'");
			criteria.setColSearchQuery(idNoFilter);
		    }
		}

		// }

	    }
	}
	criteria.setCifWhereQuery(cifWhereQuery);

    }
    // Falha AMANA180481 - Retrieving joint CIFs- iMAL R14*** on release 14.1.1

    
    public List<AccountCO> returnSwitchCIFBranchAccList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.returnSwitchCIFBranchAccList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "AMF.BaseResultMap");
	    return getSqlMap().queryForList("cifMapper.returnSwitchCIFBranchAccList", criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    public int returnSwitchCIFBranchAccListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "AMF.BaseResultMap");
	return ((Integer) getSqlMap().queryForObject("cifMapper.returnSwitchCIFBranchAccListCount", criteria)).intValue();
    }

    public CifSC switchCIFBranch(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("cifMapper.switchCIFBRProc", cifSC);

	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));

	return cifSC;
    }
    
    
    public List<AccountCO> returnSwitchedCIFDataList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifMapper.returnSwitchedCIFDataList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "switchedCIFMap");
	    return getSqlMap().queryForList("cifMapper.returnSwitchedCIFDataList", criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    public int returnSwitchedCIFDataListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "switchedCIFMap");
	return ((Integer) getSqlMap().queryForObject("cifMapper.returnSwitchedCIFDataListCount", criteria)).intValue();
    }
	
	@Override
        public int returnCifNoLookupCount(CifSC criteria) throws DAOException
        {
    	DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.resCifTypeCategPriority");
    
    	int nb = 0;
    	nb = ((Integer) getSqlMap().queryForObject("cifMapper.returnCifNoLookupCount", criteria)).intValue();
    	return nb;
    
        }
	
	
        @Override
        public List<CIFCO> returnCifNoLookup(CifSC criteria) throws DAOException
        {
    
    	if(criteria.getNbRec() == -1)
    	{
    	    return getSqlMap().queryForList("cifMapper.resCifTypeCategPriority", criteria);
    	}
    	else
    	{
    	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.resCifTypeCategPriority");
    	    return getSqlMap().queryForList("cifMapper.returnCifNoLookup", criteria, criteria.getRecToskip(),
    		    criteria.getNbRec());
    	}
    
        }

	@Override
	public CIFCO returnCifNoLookupById(CifSC criteria) throws DAOException
	{
	    return (CIFCO) getSqlMap().queryForObject("cifMapper.returnCifNoLookupById", criteria);
	}
	
	 public int cifSegmentTrialProcessListCount(CifSC criteria) throws DAOException
	    {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("cifMapper.cifSegmentTrialProcessListCount", criteria)).intValue();
		return nb;
	    }
	    
	    public List cifSegmentTrialProcessList(CifSC criteria) throws DAOException
	    {
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("cifMapper.cifSegmentTrialProcessList", criteria);
		}
		else
		{
		    DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifMapper.cifListMap");
		    return getSqlMap()
			    .queryForList("cifMapper.cifSegmentTrialProcessList", criteria, criteria.getRecToskip(), criteria.getNbRec());
		}
	    }

}
