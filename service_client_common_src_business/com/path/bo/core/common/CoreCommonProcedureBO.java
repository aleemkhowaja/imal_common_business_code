package com.path.bo.core.common;

import java.math.BigDecimal;
import com.path.dbmaps.vo.IBISCOUNTERVO;
import com.path.lib.common.exception.BaseException;
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
import com.path.vo.core.segmentation.CustSegmentationSC;
import com.path.vo.core.dues.DuesManagementSC;
import com.path.vo.core.grouping.SegmentGroupingSC;
import com.path.vo.core.incident.IncidentReportSC;
import com.path.vo.core.passbook.PassBookCO;
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

public interface CoreCommonProcedureBO
{
    public ChequeBookSC approveChequebook_NewTrans(ChequeBookSC chequeBookSC) throws BaseException;
    public ChequeBookSC chqbookBatchApprovePrcs(ChequeBookSC chequeBookSC) throws  BaseException;
    public ChequeBookSC approveChequebook(ChequeBookSC chequeBookSC) throws BaseException;
    public AlertsSC getToDoDet(AlertsSC alertsSC) throws BaseException;
    public TrxMgntSC processCtstrs(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC reverseCtstrs(TrxMgntSC trxMgntSC) throws BaseException;
    public void updateCifNames(NCifMaintenanceSC nCifMaintenanceSC) throws BaseException;
    public AccountPositionCO viewAccPosition(AccountPositionCO accountPositionCO) throws BaseException;
    public BigDecimal returnAvlBalBR(AccountPositionCO accountPositionCO) throws BaseException;
    public AccountPositionCO returnCoveringBalance(AccountPositionCO accountPositionCO) throws BaseException;
    public AccountCO specialConditions(AccountCO accountCO) throws BaseException;
    public TrxMgntSC validateIBAN(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC returnRate(TrxMgntSC trxMgntSC) throws BaseException;
    public void createHashStandOrder() throws BaseException;
    public void dropHashStandOrder() throws BaseException;
    public void createTrxHashTables() throws BaseException;
    public void dropTrxHashTables()throws BaseException;
    public TransferCashSC getExChRate(TransferCashSC transferCashSC) throws BaseException;
    public TransferCashSC checkUserLimits(TransferCashSC transferCashSC) throws BaseException;
    public TrxMgntSoDetSC calculateSoDates(TrxMgntSoDetSC trxMgntSoDetSC) throws BaseException;
    public TrxMgntSC checkAmntRestriction(TrxMgntSC criteria) throws BaseException;
    public TrxMgntSC checkTransData(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC getTVADetails(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC getExchrateFlag(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC getCrossRateCover(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC getCvAmount(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntChargesSC getChargesDetails(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntChargesSC returnProductCharges(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntSC checkUserMinMaxBal(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkHouseChequeData(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callProcVisaLaunchProcess(TrxMgntSC trxMgntSC)throws BaseException ;
    public void populateCif(PopulateCifSC populateCifSC) throws BaseException;
    public AccountCommonCO getBFBalance(AccountCommonCO accountCommonCO) throws BaseException;
    public TrxMgntSC returnClosingTime(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC returnRateNormal(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC returnAmountByRateForTellerExch(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC returnRetVDate(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC validateRemittance(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC moveFromTrsAlertToTrs(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC updateRemittance(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC updateChequeStatus(TrxMgntSC trxMgntSC) throws BaseException;
    public CtstrsUploadSC callProcFillTmpCtstrsUpload(CtstrsUploadSC ctstrsUploadSC)  throws BaseException ;
    public CtstrsUploadSC callProcBatchLaunchProcess(CtstrsUploadSC ctstrsUploadSC)  throws BaseException ;
    public CtstrsUploadSC callProcBatchDeleteRecords(CtstrsUploadSC ctstrsUploadSC)  throws BaseException ;
    public AccountCO returnAccountAdditionalReference(AccountCO accountCO) throws BaseException;
    public AccountCO createAccount(AccountCO accountCO) throws BaseException;
    public BlackListSC fillCifSoundex(BlackListSC blackListSC) throws  BaseException;
    public CardsManagementSC checkDataCards(CardsManagementSC cardsManagementSC) throws BaseException;
    public TrxMgntSC soChangestatusCharge(TrxMgntSC trxMgntSC) throws  BaseException;
    public void createHashSoundex() throws BaseException;
    public void dropHashSoundex() throws BaseException;
    public BlackListSC updateFillCifBlacklistMos(BlackListSC blackListSC) throws  BaseException;
    public CardsManagementSC returnCardsRefWithExpDate(CardsManagementSC cardsManagementSC) throws  BaseException;
    public CardsManagementSC addCardsHistory(CardsManagementSC cardsManagementSC) throws  BaseException;
    public CardsManagementSC returnCardNo(CardsManagementSC cardsManagementSC) throws  BaseException;
    public CardsManagementCO returnCardEnquiry(CardsManagementCO cardsManagementCO) throws  BaseException;
    public TrxMgntSC insertDof(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC reverseDof(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC retailEntries(TrxMgntSC trxMgntSC) throws BaseException;
    public void closeAccount(AccountSC accountSC) throws BaseException;
    public void authorizeCloseAccount(AccountSC accountSC) throws BaseException;
    public AccountSC checkUnclaimed(AccountSC accountSC) throws BaseException;
    public AccountSC callProcCheckCollguarantor(AccountSC accountSC)  throws BaseException ;
    public TrxMgntSC releaseHof(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callAlertCtsTrs(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC releaseHofWithCharges(TrxMgntSC trxMgntSC) throws BaseException;
    public CardsManagementSC callAlertCtsCard(CardsManagementSC cardsManagementSC) throws BaseException;
    public CifSC callAlertCif(CifSC cifSC) throws  BaseException;
    public AccountSC callAlertAmf(AccountSC accountSC) throws  BaseException;
    public MosBlackListSC fillSoundex(MosBlackListSC mosBlackListSC) throws  BaseException;
    public TrxMgntSC createHoldOfFunds(TrxMgntSC trxMgntSC) throws  BaseException ; 
    public TrxMgntSC authorizeClearingVoiding(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC addJvRet(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkSpecialConditions(TrxMgntSC trxMgntSC) throws BaseException;
    public BlackListSC checkBlackList(BlackListSC blackListSC) throws BaseException;
    public TrxMgntSC callProcRecalcForRelatedGl(TrxMgntSC trxMgntSC) throws  BaseException;
    public TrxMgntSC callProcPcsPftForRelatedGl(TrxMgntSC trxMgntSC) throws  BaseException;
    public TrxMgntSC callProcPcsProfitDetail(TrxMgntSC trxMgntSC) throws  BaseException;
    public TrxMgntSC callProcRetGetPenaltyDetail(TrxMgntSC trxMgntSC) throws BaseException;
    public PassBookCO updatePassbookDOFHST(PassBookCO passBookCO) throws BaseException;
    public PassBookCO printPassbookDetails(PassBookCO passBookCO) throws BaseException;
    public TrxMgntSC callProcGetPcsCharges(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callProcGetPcsTaxes(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntBatchSC updateAutoBatch(TrxMgntBatchSC trxMgntBatchSC) throws BaseException;
    public TrxMgntSC checkRemittanceStock(TrxMgntSC trxMgntSC) throws BaseException;
    public void createAuthorizeClearingTmpTables() throws BaseException;
    public AccountCommonCO getBalanceAcc(AccountCommonCO accountCommonCO) throws BaseException;
    public AccountCommonCO getAccBalance(AccountCommonCO accountCommonCO) throws BaseException;
    public TrxMgntSC getAccExchrate(TrxMgntSC trxMgntSC) throws BaseException;
    public SpecialConditionsSC pRetAlertSPCONDS(SpecialConditionsSC spcondsSC) throws BaseException;
    public TrxMgntSC getCrossRate(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSettlementSC checkIisInvestmentDeal(TrxMgntSettlementSC trxMgntSettlementSC) throws BaseException;
    public void createTempTableForInvestmentDeal() throws BaseException;
    public TrxMgntSettlementSC returnMinAmountRecv(TrxMgntSettlementSC trxMgntSettlementSC) throws BaseException;
    public AccountSC storeInAmfAlert(AccountSC accountSC) throws BaseException;
    public ConditionalAutomationCO forbidMatchedCIF(ConditionalAutomationCO conditionalAutomationCO) throws BaseException;
    public EntityChargesSC calculateCharges(EntityChargesSC entityChargesSC) throws BaseException;
    public MemoDtlCO createDeleteMemo(MemoDtlCO memoDtlCO) throws BaseException;
    public CtstrsUploadSC reverseBatch(CtstrsUploadSC ctstrsUploadSC)throws BaseException;
    public AccountSC checkPendingDues(AccountSC accountSC) throws BaseException;
    public DuesManagementSC returnDuesAmountAcc(DuesManagementSC duesManagementSC) throws BaseException;
    public DuesManagementSC invokeDuesAlertProcedure(DuesManagementSC duesSc)throws BaseException;
    public DuesManagementSC invokeReverseTrxForDuesProcedure(DuesManagementSC duesSc)throws BaseException;
    public DuesManagementSC invokeCheckDuesAccountProcedure(DuesManagementSC duesSc)throws BaseException;
    public void createCTS_DUES_TEMP() throws BaseException;
    public void createHUNTING_TMP() throws BaseException;
    public void createHOF_TMP() throws BaseException;
    public TrxMgntSC returnCheckAmountAccBalance(TrxMgntSC trxMgntSC) throws BaseException;
    public void dropAccHashTables() throws BaseException;
    public void createAccHashTables() throws BaseException;
    public CtstrsUploadSC launchBatchSaveAs(CtstrsUploadSC ctstrsUploadSC)  throws BaseException ;
    public void dropFOMHashTables() throws BaseException;
    public void createFOMHashTables() throws BaseException;
    public TrxMgntSC insertCtsDues(TrxMgntSC trxMgntSC) throws BaseException;
    public void dropBatchProcessHashTables() throws BaseException;
    public void createBatchProcessHashTables() throws BaseException;
    public void dropBatchValidHashTables() throws BaseException;
    public void createBatchValidHashTables() throws BaseException;
    public TrxMgntSC returnCheckAllowedGls(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC returnTranslateMICR(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC verifyMICRKey(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC returnBicCode(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC validateProviderRef(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntChargesSC returnRequestCharges(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntSC returnAmountByRate(TrxMgntSC trxMgntSC) throws BaseException;
    public CardsManagementSC selectCardsMgntTmp(CardsManagementSC cardsManagementSC) throws BaseException;   
    public IBISCOUNTERVO generateIbisCounter(IBISCOUNTERVO criteria )  throws BaseException;
    public void createCardsHashTables() throws BaseException;
    public void dropCardsHashTables() throws BaseException;
    public BlackListIntSourceSC callSoundexProcess(BlackListIntSourceSC criteria) throws BaseException;
    public TrxMgntSC callProcRetGetPenaltyDetailGen(TrxMgntSC trxMgntSC) throws BaseException;
    public CtsRequestSC pkgTemplateTfa(CtsRequestSC criteria) throws BaseException;
    public void createHashDof() throws BaseException;
    public void dropHashDof() throws BaseException;
    public void createHashEccArguments() throws BaseException;
    public void dropHashEccArguments() throws BaseException;
    public AccountSC callRetAccReactivation(AccountSC accountSC) throws BaseException;
    public TrxMgntSC lockUnlockSafeAccounts_NewTrans(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC fillCreditedAccounts(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callIISProcedureCalculation(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkIISsalaryBlock(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkOverDraft(TrxMgntSC trxMgntSC) throws BaseException;    
    public WithholdingSC processWithholding(WithholdingSC withholdingSC) throws BaseException;
    public CtsRequestSC checkUserLimtReq(CtsRequestSC criteria) throws BaseException;
    public void createCtsTrsTempFiltered() throws BaseException;
    public void createCtsTemp() throws BaseException;
    public TrxMgntSC callProcRetProcessAutoAllocation(TrxMgntSC trxMgntSC) throws BaseException;
    public void checkAccCreation(AccountSC accountSC) throws BaseException;
    public TrxMgntSC callFractionsProfit(TrxMgntSC trxMgntSC) throws BaseException;
    public CardsManagementCO returnCardEnquiryExt(CardsManagementCO cardsManagementCOCopy)throws BaseException;
    public AccountSC returnAmfBalanceFCNew(AccountSC accountSC) throws BaseException;
    public AccountChargesSC  processAccountCharges(AccountChargesSC accountChargesSC) throws BaseException;
    public TrxMgntSC releaseHofByCif(TrxMgntSC trxMgntSC) throws BaseException;
    public void dropProcessWithholdingTables() throws BaseException;
    public void createProcessWithholdingTables() throws BaseException;
    public void createHashCtsChargesUnified() throws BaseException;
    public void dropHashCtsChargesUnified() throws BaseException;
    public AccRestrictedSC fillAccRestricted(AccRestrictedSC criteria) throws BaseException;
    public CifSC checkEtlIdentProcess_NewTrans(CifSC criteria) throws BaseException;
    public TransferCashSC callAlertSmsSubscription(TransferCashSC transferCashSC) throws BaseException;
    public TrxMgntSC retGetTrsNo(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC clearTrsNo(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkOneObligorLimit(TrxMgntSC trxMgntSC) throws BaseException;
    public void dropOneObligorTables() throws BaseException;
    public void createOneObligorTables() throws BaseException;
    public TrxMgntSC iisOneObligorLimitReport(TrxMgntSC trxMgntSC) throws BaseException;
    public void dropNonFinancialInfoTables() throws BaseException;
    public void createNonFinancialInfoTables() throws BaseException;
    public TrxMgntSC defaultIntermBankBicCode(TrxMgntSC trxMgntSC) throws BaseException;
    public CifSC callMappingSiron(CifSC cifSC) throws  BaseException;
    public void dropSironHashTables() throws BaseException;
    public void createSironHashTables() throws BaseException;
    public CifSC callScoreSiron(CifSC cifSC) throws  BaseException;
    public TrxMgntSC callProcVisaImport(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callProcVisaMatch(TrxMgntSC trxMgntSC) throws BaseException;
    public void createHashAuditDetails() throws BaseException;
    public void dropHashAuditDetails() throws BaseException;
    public DynFilesSC callProcExecDynFilesStatement(DynFilesSC dynFilesSC) throws BaseException;
    public TrxMgntFxDealSC updateFxDeals(TrxMgntFxDealSC trxMgntFxDealSC)  throws BaseException;
    public int callFillAccRestricted(AccountSC criteria) throws BaseException;
    public void accLimitValidationChecking(AccountSC accountSC) throws BaseException;   
    public AccountSC recalculatePointsAccruals(AccountSC accountSC) throws BaseException;
    public AccountSC callCheckAccountData(AccountSC accountSC) throws BaseException;//MajdHaidar 01/11/2018
    public TrxMgntSC callFmsFillShadowAccount(TrxMgntSC trxMgntSC) throws BaseException;
    public CifSC callCheckFomData(CifSC cifSC) throws BaseException;
    public AccountsManagementCO callPcsGetAdvanceAmount(AccountsManagementCO accountsManagementCO) throws BaseException;
    public TrxMgntSC getOverdrawLimit(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkCollateralizedCD(TrxMgntSC trxMgntSC)throws BaseException;
    public FomSC createPkgSms(FomSC fomSC) throws BaseException;
    public AccountsManagementCO callFmsGetOverDraftLimit(AccountsManagementCO accountsManagementCO) throws BaseException;
    public TrxMgntSC getInvstBal(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkBranchCashLimit(TrxMgntSC trxMgntSC) throws BaseException;
    public CustSegmentationSC runTrialSegmentationProcess(CustSegmentationSC custSegmentationSC) throws BaseException;
    public CustSegmentationSC runAlertSegmentation(CustSegmentationSC custSegmentationSC) throws BaseException;
    public CustSegmentationSC runTrialScoringProcess(CustSegmentationSC custSegmentationSC) throws BaseException;
    public SegmentGroupingSC runAlertSegmentGrouping(SegmentGroupingSC segmentGroupingSC) throws BaseException;
    public TrxMgntSC callFillBillReport(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC insertCTSTRSDET(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC commonPosting(TrxMgntSC trxMgntSC) throws BaseException;
    public CifSC callChecksumDigit(CifSC cifSC) throws BaseException;//Hala Al Sheikh - ABSAI180070
    public TrxMgntSC processInvPoints(TrxMgntSC trxMgntSC) throws BaseException;
    public FomCO executeScoringProcess(FomCO fomCO) throws BaseException;
    public CardsManagementSC callFMSGenerateDrwDwn(CardsManagementSC cardsManagementSC) throws BaseException;//Hala Al Sheikh - ABEI180106
    public AccountCO wrapSpecialCondition(AccountCO accountCO) throws BaseException;
    public TrxMgntCO pcsWrapAnniversaryAccDep(TrxMgntCO trxMgntCO) throws BaseException;
    public AccountsManagementCO callFmsWrapGetMosharakaDetails(AccountsManagementCO accountsManagementCO) throws BaseException;//Hala Al Sheikh - SBI170059 SBI170060 
    public void createACC_RESTRICTION_TEMP (AccountSC criteria) throws BaseException;
    public TrxMgntSC returnCheckAllowedCYs(TrxMgntSC trxMgntSC) throws BaseException;//Hala Al Sheikh - SBI190010
    public TrxMgntSC callAtmInsertCeftsTrf(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC balanceSettlement(TrxMgntSC trxMgntSC) throws BaseException;
    public Integer createAlertFillDetailsTemp() throws BaseException;
    public Integer dropAlertFillDetailsTemp() throws BaseException;
    public TrxMgntSC callCheckRecRemittanceData(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC getTransactionAccount(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC getCheckIdVal(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC InsertNewGainlossRecord(TrxMgntSC trxMgntSC) throws BaseException;
    public AccountChargesSC retrieveSegCharges(AccountChargesSC accountChargesSC) throws BaseException;
    public AccountChargesSC saveSegmetationCharges(AccountChargesSC accountChargesSC) throws BaseException;
    public CustSegmentationSC executeSegmentationProcess(CustSegmentationSC custSegmentationSC) throws BaseException;
    public CifSC fillTablesITR(CifSC cifSC) throws BaseException;
    public AccountSC callGetAmfBalanceFC(AccountSC accountSC) throws BaseException;
    public TrxMgntSC callInsertCtstrs(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callAccEntry(TrxMgntSC trxMgntSC)throws BaseException;
    public TrxMgntSC callConvertTrsAmount(TrxMgntSC trxMgntSC)throws BaseException;
    public TrxMgntSC callCtsCtrTimeout(TrxMgntSC trxMgntSC)throws BaseException;
    public TrxMgntSC retInsertStatus(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntChargesSC retIbChargeUnified(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntChargesSC retProcessHofWithCharge(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public TrxMgntSC createStandingOrder(TrxMgntSC trxMgntSC) throws BaseException;
    public void commitTrans() throws BaseException;
    public TrxMgntSC collectRemittance(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC createRemittance(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC createChequeDeposit(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntChargesSC checkHOFSpecialConditions(TrxMgntChargesSC trxMgntChargesSC) throws BaseException;
    public CifSC copyAuthorizeSignatures(CifSC cifSC) throws BaseException;
    public CifSC callCifUpdate(CifSC cifSC) throws  BaseException;
    public ChequeBookSC callCheckChequeBookData(ChequeBookSC chequeBookSC) throws BaseException;
    public BlackListSC checkBlackListRestriction(BlackListSC blackListSC) throws BaseException;
    public TrxMgntSC callPCSRecoverProfit(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callPCSUpdateBODTrx(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC returnCheckAllowedCIFs(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC callRetReverseProfit(TrxMgntSC trxMgntSC) throws BaseException;
    public AccountSC createAMF(AccountSC accountSC) throws BaseException;
    public TrxMgntSC checkClosingPeriod(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkEftDebitTransaction(TrxMgntSC trxMgntSC) throws BaseException;
    public CifSC callCheckValidateFomData(CifSC cifSC) throws BaseException;
    public AccountSC checkOnClosingAccount (AccountSC accountSC) throws BaseException;
    public DuesManagementSC returnActiveWithAmountAcc(DuesManagementSC duesManagementSC) throws BaseException;
    public DuesManagementSC returnPostdatedChequeBalances(DuesManagementSC duesManagementSC) throws BaseException;
    public AccountsManagementCO retRestrictAccCifCreate(AccountsManagementCO accountsManagementCO) throws BaseException;
    public AccountCO retApiCreateAccount(AccountCO accountCO) throws BaseException;
    public AccountCO wrapCoreGetVatDetails(AccountCO accountCO) throws BaseException;       
    public CardsManagementCO returnFMSWrapGetCardFacDet(CardsManagementCO cardsManagementCO) throws BaseException;//Hala Al Sheikh - BMO180327
    public TransferEntitySC callP_FMS_WRAP_REPLACE_RLN_MGR(TransferEntitySC transferEntitySC) throws BaseException;
    public SpecialConditionsSC callCheckSpCondData(SpecialConditionsSC criteria) throws BaseException;
    public TransferCashSC checkVaultRemittance(TransferCashSC transferCashSC) throws BaseException;
    public TrxMgntSC checkDataLostFound(TrxMgntSC trxMgntSC) throws BaseException;
    public TrxMgntSC checkDataTransferAccount(TrxMgntSC trxMgntSC) throws BaseException;
    public DuesManagementSC checkDataDuesMgnt(DuesManagementSC duesManagementSC) throws BaseException;
    public FOMRealBeneficiariesCO updateRealBenefRecords(FOMRealBeneficiariesCO fomRealBeneficiariesCO) throws BaseException;
    public void callIncidentReportAlertProcedure(IncidentReportSC incidentReportSC) throws BaseException;
    public TrxMgntSC processSuspenseAccount(TrxMgntSC trxMgntSC) throws BaseException;
    public AccountSC callCheckCertificateData(AccountSC accountSC) throws BaseException;//Hala Al Sheikh - NBINT130004
    public TrxMgntSC checkCertificateCreation(TrxMgntSC trxMgntSC)throws BaseException;
}