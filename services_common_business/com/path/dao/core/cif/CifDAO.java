/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.cif;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
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
public interface CifDAO
{
    public int cifListCount(CifSC criteria) throws DAOException;

    public List cifList(CifSC criteria) throws DAOException;

    public CIFVO returnCifByNo(CifSC criteria) throws DAOException;

    public int checkCIFValidation(CifSC criteria) throws DAOException;

    public int cifLookupQueryListCount(CifSC criteria) throws DAOException;

    public List cifLookupQueryList(CifSC criteria) throws DAOException;

    public CIFVO cifLookupQueryObject(CifSC criteria) throws DAOException;

    public CIFCO returnCifInfo(CifSC criteria) throws DAOException;

    public CIFVO returnCIF(CifSC criteria) throws DAOException;

    public FomCO returnPassportInfoFromCIF(CifSC criteria) throws DAOException;

    public List cifNoAccList(CifSC criteria) throws DAOException;

    public int cifNoAccListCount(CifSC criteria) throws DAOException;

    public List cifBankList(CifSC criteria) throws DAOException;

    public int cifBankListCount(CifSC criteria) throws DAOException;

    public CIFVO returnCifNameByCifNo(CifSC criteria) throws DAOException;

    public String getGLType(CifSC cifSC) throws DAOException;

    public BigDecimal validateCifByAmfRet(CifSC cifSC) throws DAOException;

    public BigDecimal validateCifByAmfDyn() throws DAOException;

    public int cifJointListCount(CifSC criteria) throws DAOException;

    public List cifJointList(CifSC criteria) throws DAOException;

    public int cifAllAmfListCount(CifSC criteria) throws DAOException;

    public List cifAllAmfList(CifSC criteria) throws DAOException;

    public int checkAdditionalReference(CifSC criteria) throws DAOException;

    public BigDecimal returnCIFBankForeignCheques(MICRSC micrSC) throws DAOException;

    public String returnCIFName(MICRSC micrSC) throws DAOException;

    public CIFVO returnCIFNameAIB(MICRSC micrSC) throws DAOException;

    public BigDecimal returnMinCIFCompRef(MICRSC micrSC) throws DAOException;

    public int memoDtlsCifListCount(CifSC criteria) throws DAOException;

    public List<CIFVO> memoDtlsCifList(CifSC criteria) throws DAOException;

    public CIFVO getMemoDtlsCif(CifSC criteria) throws DAOException;

    public int returnCifFmsListCount(CifSC criteria) throws DAOException;

    public List<CIFCO> returnCifFmsList(CifSC criteria) throws DAOException;

    public CIFVO returnCifFmsByCifNo(CifSC criteria) throws DAOException;

    public CIFCO returnCIFDetailsforBlackList(CifSC criteria) throws DAOException;

    public int cardsManagementCifListCount(CifSC criteria) throws DAOException;

    public List<CIFVO> cardsManagementCifList(CifSC criteria) throws DAOException;

    public CIFVO returnCifDetailsForCardsManagementByCifNo(CifSC criteria) throws DAOException;

    // w_lookup_cif_amf_rifctt
    public int cifListCountbyBrCyGl(CifSC criteria) throws DAOException;

    public List cifListbyBrCyGl(CifSC criteria) throws DAOException;

    public int cifListCountCert(CifSC criteria) throws DAOException;

    public List cifListCert(CifSC criteria) throws DAOException;

    public CIFVO getCifDetailbyBrCyGl(CifSC criteria) throws DAOException;

    public void updateBlackListedCIF(CifSC criteria) throws DAOException;

    public String returnJointAccounts(CifSC criteria) throws DAOException;

    public int checkIDUniqueCount(CifSC criteria) throws DAOException;

    public CIFCO checkIDUniqueness(CifSC criteria) throws DAOException;

    public CIFCO cifClientDetailsInfo(CifSC criteria) throws DAOException;

    public List<CifTrxTypeLimitCO> cifBenefLkpList(CifSC criteria) throws DAOException;

    public Integer cifBenefLkpCount(CifSC criteria) throws DAOException;

    public BigDecimal checkTellerCifAccess(CifSC cifSc) throws DAOException;

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
    public CIFCO returnCIFDetails(CifSC cifSC) throws DAOException;

    public Integer returnCommonSwiftDataCount(CifSC cifSC) throws DAOException;

    public List<CIFCO> returnCommonSwiftData(CifSC cifSC) throws DAOException;

    public Integer returnReceiverBankListCount(CifSC cifSC) throws DAOException;

    public List<CIFCO> returnReceiverBankList(CifSC cifSC) throws DAOException;

    public Integer returnAllCIFListCount(CifSC cifSC) throws DAOException;

    public List<CIFCO> returnAllCIFList(CifSC cifSC) throws DAOException;

    public List<CIFVO> returnDeveloperCifFmsList(CifSC criteria) throws DAOException;

    public Integer returnDeveloperCifFmsListCount(CifSC cifSC) throws DAOException;

    /**
     * Method to retrieve CIF list count based on company code (along with
     * checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return int
     * @throws DAOException
     * @author HanaaElJazzar
     */
    int returnCifListCountByGlobalCif(CifSC cifSC) throws DAOException;

    /**
     * Method to retrieve CIF list the list of the CIF based on compCode (along
     * with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return List of cifVO Objects
     * @throws DAOException
     * @author HanaaElJazzar
     */
    List getCifListByGlobalCif(CifSC cifSC) throws DAOException;

    /**
     * Method to retrieve CIF record details based on cifNo value, compCode
     * (along with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return CIFVO
     * @throws DAOException
     * @author HanaaElJazzar
     */
    CIFVO returnCifDetailsByGlobalCif(CifSC cifSC) throws DAOException;

    List<CIFVO> returnCifIdNoListResult(CifSC criteria) throws DAOException;

    int returnCifIdNoListCount(CifSC criteria) throws DAOException;

    List<CIFCO> returnCifVehicleNoListResult(CifSC criteria) throws DAOException;

    int returnCifVehicleNoListCount(CifSC criteria) throws DAOException;

    public int returnJointCifFmsListCount(CifSC criteria) throws DAOException;

    public List<CIFCO> returnJointCifFmsList(CifSC criteria) throws DAOException;

    public CIFVO returnJointCifFmsByCifNo(CifSC criteria) throws DAOException;

    public int bankCifLkpCount(CifSC criteria) throws DAOException;

    public List<CifTrxTypeLimitCO> bankCifLkpList(CifSC criteria) throws DAOException;

    public BigDecimal returnCifForBasedOnMasked(CifSC cifSC) throws DAOException;

    /**
     * Returns a list of accounts for a selected CIF
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<AccountCO> returnSwitchCIFBranchAccList(CifSC criteria) throws DAOException;
    
    /**
     * Returns count of a list of accounts for a selected CIF
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int returnSwitchCIFBranchAccListCount(CifSC criteria) throws DAOException;
    
    /**
     * This method runs the procedure named P_TRANSFER_ACCOUNTS_DEMO
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public CifSC switchCIFBranch(CifSC cifSC) throws DAOException;
    
    public List<AccountCO> returnSwitchedCIFDataList(CifSC criteria) throws DAOException;
    
	public int returnSwitchedCIFDataListCount(CifSC criteria)throws DAOException;
			
	public int returnCifNoLookupCount(CifSC criteria) throws DAOException;
	
	public List<CIFCO> returnCifNoLookup(CifSC criteria) throws DAOException;
    
	public CIFCO returnCifNoLookupById(CifSC criteria) throws DAOException;
	
    public int cifSegmentTrialProcessListCount(CifSC criteria) throws DAOException;
    
    public List<CIFVO> cifSegmentTrialProcessList(CifSC criteria) throws DAOException;

}
