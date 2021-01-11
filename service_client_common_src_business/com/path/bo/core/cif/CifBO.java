/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.cif;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CIF1VO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.admin.companies.CompaniesCO;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ciftrxtypelimit.CifTrxTypeLimitCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.trxmgnt.MICRSC;

/**
 * @author MarwanMaddah
 * 
 */
public interface CifBO
{
    public int cifListCount(CifSC criteria) throws BaseException;

    public List cifList(CifSC criteria) throws BaseException;

    public CIFVO returnCifByNo(CifSC criteria) throws BaseException;

    public Boolean checkCIFValidation(CifSC criteria) throws BaseException;

    public int cifLookupQueryListCount(CifSC criteria) throws BaseException;

    public List cifLookupQueryList(CifSC criteria) throws BaseException;

    public CIFVO cifLookupQueryObject(CifSC criteria) throws BaseException;

    public CIFCO returnCIFinfo(CifSC criteria) throws BaseException;

    public FomCO returnPassportInfoFromCIF(CifSC criteria) throws BaseException;

    public List cifNoAccList(CifSC criteria) throws BaseException;

    public int cifNoAccListCount(CifSC criteria) throws BaseException;

    public List cifBankList(CifSC criteria) throws BaseException;

    public int cifBankListCount(CifSC criteria) throws BaseException;

    public CIFVO returnCifNameByCifNo(CifSC criteria) throws BaseException;

    public String getGLType(CifSC cifSC) throws BaseException;

    public BigDecimal validateCifByAmfRet(CifSC cifSC) throws BaseException;

    public BigDecimal validateCifByAmfDyn() throws BaseException;

    public int cifJointListCount(CifSC criteria) throws BaseException;

    public List cifJointList(CifSC criteria) throws BaseException;

    public CIFVO returnCIF(CifSC criteria) throws BaseException;

    public int checkAdditionalReference(CifSC cifSC) throws BaseException;

    public List cifAllAmfList(CifSC criteria) throws BaseException;

    public int cifAllAmfListCount(CifSC criteria) throws BaseException;

    public BigDecimal returnCIFBankForeignCheques(MICRSC micrSC) throws BaseException;

    public String returnCIFName(MICRSC micrSC) throws BaseException;

    public CIFVO returnCIFNameAIB(MICRSC micrSC) throws BaseException;

    public BigDecimal returnMinCIFCompRef(MICRSC micrSC) throws BaseException;

    public int returnCifFmsListCount(CifSC criteria) throws BaseException;

    public List<CIFCO> returnCifFmsList(CifSC criteria) throws BaseException;

    public CIFVO returnCifFmsByCifNo(CifSC criteria) throws BaseException;

    public int memoDtlsCifListCount(CifSC criteria) throws BaseException;

    public List<CIFVO> memoDtlsCifList(CifSC criteria) throws BaseException;

    public CIFVO getMemoDtlsCif(CifSC criteria) throws BaseException;

    public CIFCO returnCIFDetailsforBlackListt(CifSC criteria) throws BaseException;

    public int cardsManagementCifListCount(CifSC criteria) throws BaseException;

    public List<CIFVO> cardsManagementCifList(CifSC criteria) throws BaseException;

    public CIFVO returnCifDetailsForCardsManagementByCifNo(CifSC criteria) throws BaseException;

    // w_lookup_cif_amf_rifctt
    public int cifListCountbyBrCyGl(CifSC criteria) throws BaseException;

    public List cifListbyBrCyGl(CifSC criteria) throws BaseException;

    public int cifListCountCert(CifSC criteria) throws BaseException;

    public List cifListCert(CifSC criteria) throws BaseException;

    public CIFVO getCifDetailbyBrCyGl(CifSC criteria) throws BaseException;

    public void updateBlackListedCIF(CifSC criteria) throws BaseException;

    public String returnJointAccounts(CifSC criteria) throws BaseException;

    public CIFCO cifClientDetailsInfo(CifSC criteria) throws BaseException;

    public Integer cifBenefLkpCount(CifSC criteria) throws BaseException;

    public List<CifTrxTypeLimitCO> cifBenefLkpList(CifSC criteria) throws BaseException;

    public BigDecimal checkTellerCifAccess(CifSC cifSc) throws BaseException;

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
    public CIFCO returnCIFDetails(CifSC cifSC) throws BaseException;

    public Integer returnCommonSwiftDataCount(CifSC cifSC) throws BaseException;

    public List<CIFCO> returnCommonSwiftData(CifSC cifSC) throws BaseException;

    public Integer returnReceiverBankListCount(CifSC cifSC) throws BaseException;

    public List<CIFCO> returnReceiverBankList(CifSC cifSC) throws BaseException;

    public Integer returnAllCIFListCount(CifSC cifSC) throws BaseException;

    public List<CIFCO> returnAllCIFList(CifSC cifSC) throws BaseException;

    public Integer returnDeveloperCifFmsListCount(CifSC cifSC) throws BaseException;

    public List<CIFVO> returnDeveloperCifFmsList(CifSC criteria) throws BaseException;

    /**
     * Method to retrieve CIF list the list of the CIF based on compCode (along
     * with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return List of cifVO Objects
     * @throws BaseException
     * @author HanaaElJazzar
     */
    List getCifListByGlobalCif(CifSC cifSC) throws BaseException;

    /**
     * Method to retrieve CIF record details based on cifNo value, compCode
     * (along with checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return CIFVO
     * @throws BaseException
     * @author HanaaElJazzar
     */
    CIFVO returnCifDetailsByGlobalCif(CifSC cifSC) throws BaseException;

    /**
     * Method to retrieve CIF list count based on company code (along with
     * checking its value in PTH_CTRL) and status.
     * 
     * @param cifSC
     * @return int
     * @throws BaseException
     * @author HanaaElJazzar
     */
    int returnCifListCountByGlobalCif(CifSC cifSC) throws BaseException;
    
    public List<CIFVO> returnCifIdNoListResult(CifSC criteria) throws BaseException;
    
    public int returnCifIdNoListCount(CifSC criteria) throws BaseException;
    
    public List<CIFCO> returnCifVehicleNoListResult(CifSC criteria) throws BaseException;
    
    public int returnCifVehicleNoListCount(CifSC criteria) throws BaseException;

    public CTSTRXTYPEVO returnCorrBankLookupData(CifSC criteria) throws BaseException;

    public int bankCifLkpCount(CifSC criteria) throws BaseException;

    public List<CifTrxTypeLimitCO> bankCifLkpList(CifSC criteria) throws BaseException;

    public CompaniesCO getDefaultBenefCriteria(CifSC criteria) throws BaseException;

    public BigDecimal returnCifForBasedOnMasked(CifSC cifSC) throws BaseException;
    
    public int cifListCountRestricted(CifSC criteria) throws BaseException;

    public List cifListRestricted(CifSC criteria) throws BaseException;

    /**
     * Returns a list of accounts for a selected CIF
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<AccountCO> returnSwitchCIFBranchAccList(CifSC criteria) throws BaseException;
    
    /**
     * Returns count of a list of accounts for a selected CIF
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnSwitchCIFBranchAccListCount(CifSC criteria) throws BaseException;
    
    /**
     * 
     * @param criteria
     * @throws BaseException
     */
    public void switchCIFBranch(CifSC criteria) throws BaseException;
    
    public List<AccountCO> returnSwitchedCIFDataList(CifSC criteria) throws BaseException;

    public int returnSwitchedCIFDataListCount(CifSC criteria) throws BaseException;
    
    /**
    *TP # 412662 - Customer RelationShip Management
    */
    public int returnCifNoLookupCount(CifSC criteria) throws BaseException;
    /**
     TP # 412662 - Customer RelationShip Management
    **/
    public  List<CIFCO> returnCifNoLookup(CifSC cifSC) throws BaseException;
    /**
    *TP # 412662 - Customer RelationShip Management
    */
    public  CIFCO returnCifNoLookupById(CifSC cifSC) throws BaseException;
    public FomCO returnPassportInfoFromCIF(FomCO criteria) throws BaseException;

}
