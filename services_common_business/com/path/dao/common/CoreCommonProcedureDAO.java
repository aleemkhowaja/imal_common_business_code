package com.path.dao.common;

import java.math.BigDecimal;
import java.util.List;

import com.path.vo.core.chargesrefund.ChargesRefundSC;
import com.path.dbmaps.vo.IBISCOUNTERVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.AccountCommonCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.common.entitycharges.EntityChargesSC;
import com.path.vo.common.memo.MemoDtlCO;
import com.path.vo.common.requests.csm.CtsRequestSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.account.AccountsManagementCO;
import com.path.vo.core.accountcharges.AccountChargesSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;
import com.path.vo.core.blacklistmanagement.BlackListSC;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.chequebook.ChequeBookSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.common.AccRestrictedSC;
import com.path.vo.core.common.CtstrsUploadSC;
import com.path.vo.core.common.NCifMaintenanceSC;
import com.path.vo.core.conditionalautomation.ConditionalAutomationCO;
import com.path.vo.core.csmfom.FOMRealBeneficiariesCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomSC;
import com.path.vo.core.csmfom.PopulateCifSC;
import com.path.vo.core.dues.DuesManagementSC;
import com.path.vo.core.grouping.SegmentGroupingSC;
import com.path.vo.core.incident.IncidentReportSC;
import com.path.vo.core.passbook.PassBookCO;
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.specialconditions.SpecialConditionsSC;
import com.path.vo.core.transfercash.TransferCashSC;
import com.path.vo.core.transferentity.TransferEntitySC;
import com.path.vo.core.trxmgnt.AccountPositionCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxmgnt.TrxMgntSoDetSC;
import com.path.vo.core.trxmgnt.WithholdingSC;
import com.path.vo.core.trxmgnt.batch.TrxMgntBatchSC;
import com.path.vo.core.trxmgnt.fxdeal.TrxMgntFxDealSC;
import com.path.vo.core.trxmgnt.settlement.TrxMgntSettlementSC;

public interface CoreCommonProcedureDAO
{
    public ChequeBookSC approveChequebook(ChequeBookSC chequeBookSC, String sybOra) throws DAOException;

    public ChequeBookSC chqbookBatchApprovePrcs(ChequeBookSC chequeBookSC) throws DAOException;

    public AlertsSC getToDoDet(AlertsSC alertsSC) throws DAOException;

    public TrxMgntSC processCtstrs(TrxMgntSC trxMgntSC, String sybOra) throws DAOException;

    public TrxMgntSC reverseCtstrs(TrxMgntSC trxMgntSC) throws DAOException;

    public void updateCifNames(NCifMaintenanceSC nCifMaintenanceSC) throws DAOException;

    public AccountPositionCO viewAccPosition(AccountPositionCO accountPositionCO) throws DAOException;

    public BigDecimal returnAvlBalBR(AccountPositionCO accountPositionCO) throws DAOException;

    public AccountCO specialConditions(AccountCO accountCO) throws DAOException;

    public AccountPositionCO returnCoveringBalance(AccountPositionCO accountPositionCO) throws DAOException;

    public TrxMgntSC validateIBAN(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC returnRate(TrxMgntSC trxMgntSC, String sybOra) throws DAOException;

    public void createHashStandOrder(String sybOra) throws DAOException;

    public void dropHashStandOrder(String sybOra);

    public void createTrxHashTables(String sybOra) throws DAOException;

    public void dropTrxHashTables(String sybOra);
    
    public void createHashCtsChargesUnified(String sybOra) throws DAOException;

    public void dropHashCtsChargesUnified(String sybOra);

    public TransferCashSC getExChRate(TransferCashSC transferCashSC, String sybOra) throws DAOException;

    public TransferCashSC checkUserLimits(TransferCashSC transferCashSC) throws DAOException;

    public TrxMgntSoDetSC calculateSoDates(TrxMgntSoDetSC trxMgntSoDetSC) throws DAOException;

    public TrxMgntSC checkAmntRestriction(TrxMgntSC criteria) throws DAOException;

    public TrxMgntSC checkTransData(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC getTVADetails(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC getExchrateFlag(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC getCrossRateCover(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC getCvAmount(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntChargesSC getChargesDetails(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    
    public TrxMgntChargesSC returnProductCharges(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    
    public TrxMgntSC checkUserMinMaxBal(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC checkHouseChequeData(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC callProcVisaLaunchProcess(TrxMgntSC trxMgntSC) throws DAOException;
    
    public void populateCif(PopulateCifSC populateCifSC) throws DAOException;

    public AccountCommonCO getBFBalance(AccountCommonCO accountCommonCO) throws DAOException;

    public TrxMgntSC returnClosingTime(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC returnRateNormal(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC returnAmountByRateForTellerExch(TrxMgntSC trxMgntSC) throws DAOException;

    public CtstrsUploadSC callProcFillTmpCtstrsUpload(CtstrsUploadSC ctstrsUploadSC) throws DAOException;

    public CtstrsUploadSC callProcBatchLaunchProcess(CtstrsUploadSC ctstrsUploadSC) throws DAOException;
    
    public CtstrsUploadSC callProcBatchDeleteRecords(CtstrsUploadSC ctstrsUploadSC)  throws DAOException;

    public TrxMgntSC returnRetVDate(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC moveFromTrsAlertToTrs(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC validateRemittance(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC updateRemittance(TrxMgntSC trxMgntSC) throws DAOException;

    public AccountCO returnAccountAdditionalReference(AccountCO accountCO) throws DAOException;
    
    public AccountCO createAccount(AccountCO accountCO) throws DAOException;

    public BlackListSC fillCifSoundex(BlackListSC blackListSC) throws DAOException;

    public TrxMgntSC soChangestatusCharge(TrxMgntSC trxMgntSC) throws DAOException;

    public CardsManagementSC checkDataCards(CardsManagementSC cardsManagementSC) throws DAOException;

    public void createHashSoundex(String sybOra) throws DAOException;

    public void dropHashSoundex(String sybOra) throws DAOException;
        
    public BlackListSC updateFillCifBlacklistMos(BlackListSC blackListSC) throws DAOException;

    public CardsManagementSC returnCardsRefWithExpDate(CardsManagementSC cardsManagementSC) throws DAOException;

    public CardsManagementSC addCardsHistory(CardsManagementSC cardsManagementSC) throws DAOException;
    
    public CardsManagementSC returnCardNo(CardsManagementSC cardsManagementSC) throws DAOException;

    public TrxMgntSC updateChequeStatus(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC insertDof(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC reverseDof(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC retailEntries(TrxMgntSC trxMgntSC) throws DAOException;

    public void closeAccount(AccountSC accountSC) throws DAOException;

    public void authorizeCloseAccount(AccountSC accountSC) throws DAOException;

    public AccountSC checkUnclaimed(AccountSC accountSC) throws DAOException;

    public AccountSC callProcCheckCollguarantor(AccountSC accountSC) throws DAOException;

    public TrxMgntSC callAlertCtsTrs(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC releaseHof(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC releaseHofWithCharges(TrxMgntSC trxMgntSC) throws DAOException;

    public CardsManagementSC callAlertCtsCard(CardsManagementSC cardsManagementSC) throws DAOException;

    public CifSC callAlertCif(CifSC cifSC) throws DAOException;

    public AccountSC callAlertAmf(AccountSC accountSC) throws DAOException;

    public MosBlackListSC fillSoundex(MosBlackListSC mosBlackListSC) throws DAOException;

    public TrxMgntSC createHoldOfFunds(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC authorizeClearingVoiding(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC addJvRet(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC checkSpecialConditions(TrxMgntSC trxMgntSC) throws DAOException;

    public BlackListSC checkBlackList(BlackListSC blackListSC) throws DAOException;

    public TrxMgntSC callProcRecalcForRelatedGl(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC callProcPcsPftForRelatedGl(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC callProcPcsProfitDetail(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC callProcRetGetPenaltyDetail(TrxMgntSC trxMgntSC) throws DAOException;

    public PassBookCO updatePassbookDOFHST(PassBookCO passBookCO) throws DAOException;

    public PassBookCO printPassbookDetails(PassBookCO passBookCO) throws DAOException;

    public TrxMgntSC callProcGetPcsCharges(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC callProcGetPcsTaxes(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntBatchSC updateAutoBatch(TrxMgntBatchSC trxMgntBatchSC) throws DAOException;

    public TrxMgntSC checkRemittanceStock(TrxMgntSC trxMgntSC) throws DAOException;

    public void createAuthorizeClearingTmpTables()throws DAOException;
    
    public AccountCommonCO getBalanceAcc(AccountCommonCO accountCommonCO) throws DAOException;
    
    public AccountCommonCO getAccBalance(AccountCommonCO accountCommonCO) throws DAOException;
    
    public TrxMgntSC getAccExchrate(TrxMgntSC trxMgntSC) throws DAOException;
    
    public SpecialConditionsSC pRetAlertSPCONDS(SpecialConditionsSC spcondsSC) throws DAOException;
    
    public TrxMgntSC getCrossRate(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSettlementSC checkIisInvestmentDeal(TrxMgntSettlementSC trxMgntSettlementSC) throws DAOException;
    
    public void createTempTableForInvestmentDeal() throws DAOException;
    
    public TrxMgntSettlementSC returnMinAmountRecv(TrxMgntSettlementSC trxMgntSettlementSC) throws DAOException;

    public AccountSC storeInAmfAlert(AccountSC accountSC) throws DAOException;
    
    public ConditionalAutomationCO forbidMatchedCIF(ConditionalAutomationCO conditionalAutomationCO) throws DAOException;
    
    public EntityChargesSC calculateCharges(EntityChargesSC entityChargesSC) throws DAOException;
    
    public MemoDtlCO createDeleteMemo(MemoDtlCO memoDtlCO) throws DAOException;
    
    public CtstrsUploadSC reverseBatch(CtstrsUploadSC ctstrsUploadSC) throws DAOException;

    public AccountSC checkPendingDues(AccountSC accountSC) throws DAOException;
    
    public DuesManagementSC returnDuesAmountAcc(DuesManagementSC duesManagementSC) throws DAOException;

    public DuesManagementSC executeDuesAlertProcedure(DuesManagementSC duesSc) throws DAOException;

    public DuesManagementSC executeReverseTrxForDues(DuesManagementSC duesSc)throws DAOException;

    public DuesManagementSC executeCheckDuesAccountProcedure(DuesManagementSC duesSc)throws DAOException;

    public void createCTS_DUES_TEMP() throws DAOException;
    
    public void createHUNTING_TMP() throws DAOException;

    public void createHOF_TMP() throws DAOException;

    public TrxMgntSC returnCheckAmountAccBalance(TrxMgntSC trxMgntSC) throws DAOException;
    
    public void createAccHashTables(String sybOra) throws DAOException;

    public void dropAccHashTables(String sybOra);
    
    public void createFOMHashTables(String sybOra) throws DAOException;
    
    public void dropFOMHashTables(String sybOra);
    
    public TrxMgntSC insertCtsDues(TrxMgntSC trxMgntSC) throws DAOException;
    
    public CtstrsUploadSC launchBatchSaveAs(CtstrsUploadSC ctstrsUploadSC) throws DAOException;
    
    public void createBatchProcessHashTables(String sybOra) throws DAOException;
    
    public void dropBatchProcessHashTables(String sybOra) throws DAOException;
    
    public void createBatchValidHashTables(String sybOra) throws DAOException;
    
    public void dropBatchValidHashTables(String sybOra) throws DAOException;
    
    public TrxMgntSC returnCheckAllowedGls(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC returnBicCode(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC validateProviderRef(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntChargesSC returnRequestCharges(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;
    
    public TrxMgntSC returnAmountByRate(TrxMgntSC trxMgntSC) throws DAOException;

    public CardsManagementSC selectCardsMgntTmp(CardsManagementSC cardsManagementSC) throws DAOException;

    public IBISCOUNTERVO generateIbisCounter(IBISCOUNTERVO criteria) throws DAOException;

    public void createCardsHashTables() throws DAOException;

    public void dropCardsHashTables() throws DAOException;

    public BlackListIntSourceSC callSoundexProcess(BlackListIntSourceSC criteria)throws DAOException;
    
    public TrxMgntSC callProcRetGetPenaltyDetailGen(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC returnTranslateMICR(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC verifyMICRKey(TrxMgntSC trxMgntSC) throws DAOException;

    public CtsRequestSC pkgTemplateTfa(CtsRequestSC criteria) throws DAOException;
    
    public void createHashDof(String sybOra) throws DAOException;

    public void dropHashDof(String sybOra);

    public CardsManagementCO returnCardEnquiry(CardsManagementCO cardsManagementCO) throws DAOException;
    
    public void createHashEccArguments(String sybOra) throws DAOException;
    
    public void dropHashEccArguments(String sybOra);

    public AccountSC callRetAccReactivation(AccountSC accountSC) throws DAOException;
    
    public TrxMgntSC lockUnlockSafeAccounts(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC callIISProcedureCalculation(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC checkIISsalaryBlock(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC checkOverDraft(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC balanceSettlement(TrxMgntSC trxMgntSC) throws DAOException;
    
    public CifSC callCheckValidateFomData(CifSC cifSC) throws DAOException;
    
    public WithholdingSC processWithholding(WithholdingSC withholdingSC) throws DAOException;
    
    public CtsRequestSC checkUserLimtReq(CtsRequestSC criteria) throws DAOException;
    
    public void createCtsTrsTempFiltered() throws DAOException;
    
    public void createCtsTemp() throws DAOException;
    
    public CifSC fillTablesITR(CifSC cifSC) throws DAOException;
    
    public TrxMgntSC callProcRetProcessAutoAllocation(TrxMgntSC trxMgntSC) throws DAOException;
    
    public CifSC callCifUpdate(CifSC cifSC) throws DAOException;
    
    public TrxMgntSC callFractionsProfit(TrxMgntSC trxMgntSC) throws DAOException;
    
    public void checkAccCreation(AccountSC accountSC) throws DAOException;

    public CardsManagementCO returnCardEnquiryExt(CardsManagementCO cardsManagementCO) throws DAOException;
    
    public AccountSC callGetAmfBalanceFC(AccountSC accountSC) throws DAOException;
    
    public TrxMgntSC callAtmInsertCeftsTrf(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC callInsertCtstrs(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC callAccEntry(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC callConvertTrsAmount(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC callCtsCtrTimeout(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC retInsertStatus(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntChargesSC retIbChargeUnified(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;

    public TrxMgntChargesSC retProcessHofWithCharge(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;

    public TrxMgntSC createStandingOrder(TrxMgntSC trxMgntSC) throws DAOException;
    
    public SpecialConditionsSC callCheckSpCondData(SpecialConditionsSC criteria) throws DAOException;
    
    public TransferCashSC checkVaultRemittance(TransferCashSC transferCashSC) throws DAOException;
    
    public TrxMgntSC checkDataLostFound(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC checkDataTransferAccount(TrxMgntSC trxMgntSC) throws DAOException;

    public DuesManagementSC checkDataDuesMgnt(DuesManagementSC duesManagementSC) throws DAOException;
    
    public void commitTrans() throws DAOException;

    public TrxMgntSC createRemittance(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC collectRemittance(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC createChequeDeposit(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntChargesSC checkHOFSpecialConditions(TrxMgntChargesSC trxMgntChargesSC) throws DAOException;

    public AccountSC returnAmfBalanceFCNew(AccountSC accountSC) throws DAOException;

    public AccountChargesSC processAccountCharges(AccountChargesSC accountChargesSC) throws DAOException;  

    public CustSegmentationSC runTrialSegmentationProcess(CustSegmentationSC custSegmentationSC) throws DAOException;

    public AccountSC checkOnClosingAccount (AccountSC accountSC) throws DAOException;
    
    public DuesManagementSC returnActiveWithAmountAcc(DuesManagementSC duesManagementSC) throws DAOException;
    
    public DuesManagementSC returnPostdatedChequeBalances(DuesManagementSC duesManagementSC) throws DAOException; 
    
    public TrxMgntSC releaseHofByCif(TrxMgntSC trxMgntSC) throws DAOException;

    public void createProcessWithholdingTables(String sybOra) throws DAOException;

    public void dropProcessWithholdingTables(String sybOra) throws DAOException;
    
    public TrxMgntSC checkClosingPeriod(TrxMgntSC trxMgntSC, String sybOra) throws DAOException;
   
    public AccRestrictedSC fillAccRestricted(AccRestrictedSC accRestrictedSC) throws DAOException;
    
    public TrxMgntSC checkEftDebitTransaction(TrxMgntSC trxMgntSC) throws DAOException;

    public CifSC checkEtlIdentProcess(CifSC criteria) throws DAOException;
    
    public TransferCashSC callAlertSmsSubscription(TransferCashSC transferCashSC) throws DAOException;
    
    public TrxMgntSC retGetTrsNo(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC clearTrsNo(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC checkOneObligorLimit(TrxMgntSC trxMgntSC) throws DAOException;

    public void dropOneObligorTables(String sybOra) throws DAOException;
    
    public void createOneObligorTables(String sybOra) throws DAOException;
    
    public TrxMgntSC iisOneObligorLimitReport(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC defaultIntermBankBicCode(TrxMgntSC trxMgntSC) throws DAOException;
    
    public CifSC copyAuthorizeSignatures(CifSC cifSC)throws DAOException;
    
    public void createNonFinancialInfoTables(String sybOra) throws DAOException;
    
    public void dropNonFinancialInfoTables(String sybOra) throws DAOException;
    
    public CifSC callMappingSiron(CifSC cifSC) throws DAOException;
    
    public void createSironHashTables(String sybOra) throws DAOException;
    
    public void dropSironHashTables(String sybOra) throws DAOException;
    
    public TrxMgntSC callPCSRecoverProfit(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC callPCSUpdateBODTrx(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC returnCheckAllowedCIFs(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC callRetReverseProfit(TrxMgntSC trxMgntSC) throws DAOException;
    
    public AccountSC createAMF(AccountSC accountSC) throws DAOException;
    
    public CifSC callScoreSiron(CifSC cifSC) throws  DAOException ;

    public TrxMgntSC callProcVisaImport(TrxMgntSC criteria) throws DAOException;
    
    public TrxMgntSC callProcVisaMatch(TrxMgntSC criteria) throws DAOException;
    
    public BlackListSC checkBlackListRestriction(BlackListSC blackListSC) throws DAOException;
    
    public void createHashAuditDetails(String sybOra) throws DAOException;
    
    public void dropHashAuditDetails(String sybOra) throws DAOException;

    public DynFilesSC callProcExecDynFilesStatement(DynFilesSC dynFilesSC)throws DAOException;
    
    public TrxMgntFxDealSC updateFxDeals(TrxMgntFxDealSC trxMgntFxDealSC)throws DAOException;

    public void createACC_RESTRICTION_TEMP(AccountSC criteria) throws DAOException;

    public int callFillAccRestricted(AccountSC criteria) throws DAOException;

    public void accLimitValidationChecking(AccountSC criteria) throws DAOException;

    public AccountSC recalculatePointsAccruals(AccountSC accountSC) throws DAOException;

    public AccountSC callCheckAccountData(AccountSC accountSC) throws DAOException;

    public TrxMgntSC callFmsFillShadowAccount(TrxMgntSC trxMgntSC) throws DAOException;

    public AccountsManagementCO callPcsGetAdvanceAmount(AccountsManagementCO accountsManagementCO) throws DAOException;

    public TrxMgntSC getOverdrawLimit(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC checkCollateralizedCD(TrxMgntSC trxMgntSC) throws DAOException;

    public FomSC createPkgSms(FomSC fomSC) throws DAOException;
    
    public AccountsManagementCO callFmsGetOverDraftLimit(AccountsManagementCO accountsManagementCO) throws DAOException;
    
    public TrxMgntSC getInvstBal(TrxMgntSC trxMgntSC) throws DAOException;
    
    public CifSC callCheckFomData(CifSC cifSC) throws DAOException;
    
    public TrxMgntSC checkBranchCashLimit(TrxMgntSC trxMgntSC) throws DAOException;
    
    public CustSegmentationSC runAlertSegmentation(CustSegmentationSC custSegmentationSC) throws DAOException;

    public CustSegmentationSC runTrialScoringProcess(CustSegmentationSC custSegmentationSC) throws DAOException;

    public SegmentGroupingSC runAlertSegmentGrouping(SegmentGroupingSC segmentGroupingSC) throws DAOException;

    public TrxMgntSC insertCTSTRSDET(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC callFillBillReport(TrxMgntSC trxMgntSC) throws DAOException;
    
    public ChequeBookSC callCheckChequeBookData(ChequeBookSC chequeBookSC) throws DAOException;
    
    public TrxMgntSC commonPosting(TrxMgntSC trxMgntSC) throws DAOException;

    public TrxMgntSC processInvPoints(TrxMgntSC criteria) throws DAOException;
    
    public CifSC callChecksumDigit(CifSC cifSC) throws DAOException; //Hala Al Sheikh - ABSAI180070

    public FomCO executeScoringProcess(FomCO fomCO) throws DAOException;

    public CardsManagementSC callFMSGenerateDrwDwn(CardsManagementSC cardsManagementSC) throws DAOException;//Hala Al Sheikh - ABEI180106
    
    public AccountCO wrapSpecialCondition(AccountCO accountCO) throws DAOException;
    
    public TrxMgntCO pcsWrapAnniversaryAccDep(TrxMgntCO trxMgntCO) throws DAOException;
    
    public AccountsManagementCO callFmsWrapGetMosharakaDetails(AccountsManagementCO accountsManagementCO) throws DAOException;//Hala Al Sheikh - SBI170059 SBI170060 

    public TrxMgntSC returnCheckAllowedCYs(TrxMgntSC trxMgntSC) throws DAOException;//Hala Al Sheikh - SBI190010
    
    public Integer dropAlertFillDetailsTemp(String sybOra) throws DAOException;

    public Integer createAlertFillDetailsTemp(String sybOra) throws DAOException;

    public TrxMgntSC callCheckRecRemittanceData(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC getTransactionAccount(TrxMgntSC trxMgntSC) throws DAOException;
    
    public TrxMgntSC getCheckIdVal(TrxMgntSC trxMgntSC) throws DAOException; 

    public TrxMgntSC InsertNewGainlossRecord(TrxMgntSC trxMgntSC) throws BaseException;
    
    public AccountChargesSC retrieveSegCharges(AccountChargesSC accountChargesSC) throws DAOException;
    
    public AccountChargesSC saveSegmentationCharges(AccountChargesSC accountChargesSC) throws DAOException;
    
    public CustSegmentationSC executeSegmentationProcess(CustSegmentationSC custSegmentationSC) throws DAOException;
    
    public FOMRealBeneficiariesCO updateRealBenefRecords(FOMRealBeneficiariesCO fomRealBeneficiariesCO) throws DAOException;
    
    public AccountsManagementCO retRestrictAccCifCreate(AccountsManagementCO accountsManagementCO) throws DAOException;
    
    public AccountCO retApiCreateAccount(AccountCO accountCO) throws DAOException;
    
    public AccountCO wrapCoreGetVatDetails(AccountCO accountCO) throws DAOException;

    public CardsManagementCO returnFMSWrapGetCardFacDet(CardsManagementCO cardsManagementCO) throws DAOException;
    
    public TransferEntitySC callP_FMS_WRAP_REPLACE_RLN_MGR(TransferEntitySC transferEntitySC) throws DAOException;
    
    public void callIncidentReportAlertProcedure(IncidentReportSC incidentReportSC) throws DAOException;

    public AccountSC callCheckCertificateData(AccountSC accountSC) throws DAOException;//Hala Al Sheikh - NBINT130004

    public TrxMgntSC checkCertificateCreation(TrxMgntSC trxMgntSC)throws DAOException;
    
    public List returnIisChargeDetails(ChargesRefundSC chargesRefundSC) throws DAOException;

}
