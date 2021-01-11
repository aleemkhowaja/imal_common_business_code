package com.path.bo.common.impl;

import java.math.BigDecimal;

import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.vo.core.transferentity.TransferEntitySC;
import com.path.dao.common.CoreCommonProcedureDAO;
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
import com.path.vo.core.trxmgnt.AccountPositionCO;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntChargesSC;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.path.vo.core.trxmgnt.TrxMgntSoDetSC;
import com.path.vo.core.trxmgnt.WithholdingSC;
import com.path.vo.core.trxmgnt.batch.TrxMgntBatchSC;
import com.path.vo.core.trxmgnt.fxdeal.TrxMgntFxDealSC;
import com.path.vo.core.trxmgnt.settlement.TrxMgntSettlementSC;
import com.path.vo.core.segmentation.CustSegmentationSC;

public class CoreCommonProcedureBOImpl extends RetailBaseBO implements CoreCommonProcedureBO
{
    private CoreCommonProcedureDAO coreCommonProcedureDAO; 

    // private HashTableBO hashTableBO;

    public void setCoreCommonProcedureDAO(CoreCommonProcedureDAO coreCommonProcedureDAO)
    {
	this.coreCommonProcedureDAO = coreCommonProcedureDAO;
    }

    public ChequeBookSC chqbookBatchApprovePrcs(ChequeBookSC chequeBookSC) throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    chequeBookSC.setIsOracle(0);
	}
	else
	{ 
	    chequeBookSC.setIsOracle(1);
	}
	return coreCommonProcedureDAO.chqbookBatchApprovePrcs(chequeBookSC);
    }

    /**
     * approveChequebookNewTrans.
     */
    public ChequeBookSC approveChequebook_NewTrans(ChequeBookSC chequeBookSC) throws BaseException
    {
	String sybOra;
	if(commonLibBO.returnIsSybase() == 1)
	{
	    sybOra = "S";
	}
	else
	{
	    sybOra = "O";
	}
	
	chequeBookSC.applyTraceProps(chequeBookSC.getTraceAppName(), chequeBookSC.getTraceUserId(), chequeBookSC.getTraceProgRef(), chequeBookSC.getHttpSessionIdForLink()); //Rania - SQL session tracing R14.1 - 27/03/2018
	ChequeBookSC newChequeBookSC = coreCommonProcedureDAO.approveChequebook(chequeBookSC, sybOra);

	return newChequeBookSC;
    }

    /**
     * approveChequebookNewTrans.
     */
    public ChequeBookSC approveChequebook(ChequeBookSC chequeBookSC) throws BaseException
    {
	String sybOra;
	if(commonLibBO.returnIsSybase() == 1)
	{
	    sybOra = "S";
	}
	else
	{
	    sybOra = "O";
	}
	
	chequeBookSC.applyTraceProps(chequeBookSC.getTraceAppName(), chequeBookSC.getTraceUserId(), chequeBookSC.getTraceProgRef(), chequeBookSC.getHttpSessionIdForLink()); //Rania - SQL session tracing R14.1 - 27/03/2018
	ChequeBookSC newChequeBookSC = coreCommonProcedureDAO.approveChequebook(chequeBookSC, sybOra);

	return newChequeBookSC;
    }

    public AlertsSC getToDoDet(AlertsSC alertsSC) throws BaseException
    {

	return coreCommonProcedureDAO.getToDoDet(alertsSC);
    }

    public AccountPositionCO viewAccPosition(AccountPositionCO accountPositionCO) throws BaseException
    {
	return coreCommonProcedureDAO.viewAccPosition(accountPositionCO);
    }

    /**
     * f_get_avlbal_br()
     */
    public BigDecimal returnAvlBalBR(AccountPositionCO accountPositionCO) throws BaseException
    {
	return coreCommonProcedureDAO.returnAvlBalBR(accountPositionCO);
    }

    /*
     * public void setHashTableBO(HashTableBO hashTableBO) { this.hashTableBO =
     * hashTableBO; }
     */
    /**
     * Create/approve transactions.
     */
    public TrxMgntSC processCtstrs(TrxMgntSC trxMgntSC) throws BaseException
    {
	String sybOra;

	if(commonLibBO.returnIsSybase() == 1)
	{
	    sybOra = "S";
	}
	else
	{
	    sybOra = "O";
	}
	return coreCommonProcedureDAO.processCtstrs(trxMgntSC, sybOra);
    }

    /**
     * @author guittaabougharrach
     * @param trxMgntSC
     * @return TrxMgntSC
     * @throws BaseException calls p_n_trx_insertdof
     */
    public TrxMgntSC insertDof(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.insertDof(trxMgntSC);
    }

    /**
     * @author Chady.A
     * @param cardsManagementSC
     * @return CardsManagementSC
     * @throws BaseException
     */
    public CardsManagementSC callAlertCtsCard(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.callAlertCtsCard(cardsManagementSC);
    }
    
    public CardsManagementSC selectCardsMgntTmp(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.selectCardsMgntTmp(cardsManagementSC);
    }

    /**
     * @author guittaabougharrach
     * @param trxMgntSC
     * @return TrxMgntSC
     * @throws BaseException calls p_n_trx_reversedof
     */
    public TrxMgntSC reverseDof(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.reverseDof(trxMgntSC);
    }

    /**
     * @author guittaabougharrach
     * @param trxMgntSC
     * @return TrxMgntSC
     * @throws BaseException calls P_RET_ENTRIES
     */
    public TrxMgntSC retailEntries(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.retailEntries(trxMgntSC);
    }

    /**
     * check data for transactions.
     */
    public TrxMgntSC checkTransData(TrxMgntSC trxMgntSC) throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    trxMgntSC.setIsOracle(0);
	}
	else
	{
	    trxMgntSC.setIsOracle(1);
	}
	return coreCommonProcedureDAO.checkTransData(trxMgntSC);
    }

    /**
     * this function is used to update all cif names in all applications
     **/
    public void updateCifNames(NCifMaintenanceSC nCifMaintenanceSC) throws BaseException
    {
	coreCommonProcedureDAO.updateCifNames(nCifMaintenanceSC);
    }

    /**
     * This method calls procedure p_ret_reverse_ctstrs that reverses and void
     * transaction
     */
    public TrxMgntSC reverseCtstrs(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.reverseCtstrs(trxMgntSC);
    }

    /**
     * This method calls the special conditions checking procedure if by account
     * or by CIF
     */
    public AccountCO specialConditions(AccountCO accountCO) throws BaseException
    {
	return coreCommonProcedureDAO.specialConditions(accountCO);
    }

    /**
     * This method calls procedure P_RET_GET_COVERING_BAL that return Covering
     * Balance (also replaces powerbuilder function f_get_covering_bal)
     */
    public AccountPositionCO returnCoveringBalance(AccountPositionCO accountPositionCO) throws BaseException
    {
	return coreCommonProcedureDAO.returnCoveringBalance(accountPositionCO);
    }

    /**
     * This method calls procedure p_ret_validate_iban that validates iban
     * accounts
     */
    public TrxMgntSC validateIBAN(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.validateIBAN(trxMgntSC);
    }
    
    public TransferCashSC callAlertSmsSubscription(TransferCashSC transferCashSC) throws BaseException
    {
	return coreCommonProcedureDAO.callAlertSmsSubscription(transferCashSC);
    }
    
    /**
     * in PB n_transaction.uf_get_rate This method calls procedure
     * P_RET_GET_RATE
     */
    public TrxMgntSC returnRate(TrxMgntSC trxMgntSC) throws BaseException
    {
	String sybOra;
	if(commonLibBO.returnIsSybase() == 1)
	{
	    sybOra = "S";
	}
	else
	{
	    sybOra = "O";
	}
	return coreCommonProcedureDAO.returnRate(trxMgntSC, sybOra);
    }

    /**
     * this method creates #stand_order
     * 
     * @throws BaseException
     */
    public void createHashStandOrder() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createHashStandOrder("");
	}
    }
    

    /**
     * this method creates #stand_order
     * 
     * @throws BaseException
     */
    public void dropHashStandOrder() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropHashStandOrder("");
	}
    }
   
    /**
     * this method creates #CTS_CHARGES_UNIFIED
     * 
     * @throws BaseException
     */
     public void createHashCtsChargesUnified() throws BaseException
     {
         if(commonLibBO.returnIsSybase() == 1)
         {
             coreCommonProcedureDAO.createHashCtsChargesUnified("");
         }
     }
     /**
     * this method creates #CTS_CHARGES_UNIFIED
     * 
     * @throws BaseException
     */
     public void dropHashCtsChargesUnified() throws BaseException
     {
         if(commonLibBO.returnIsSybase() == 1)
         {
             coreCommonProcedureDAO.dropHashCtsChargesUnified("");
         }
     }

    /**
     * this method creates #DOF_POSTING_TMP
     * 
     * @throws BaseException
     */
    public void createHashDof() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createHashDof("");
	}
    }
    public void dropHashDof() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropHashDof("");
	}
    }

    /**
     * this method creates transaction hash tables
     * 
     * @throws BaseException
     */
    public void createTrxHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createTrxHashTables("");
	}
    }

    /**
     * this method drops FOM hash tables
     * @author nabilfeghali
     * @throws BaseException
     */
    public void dropFOMHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropFOMHashTables("");
	}
    }

    /**
     * this method creates FOM hash tables
     * @author nabilfeghali
     * @throws BaseException
     */
    public void createFOMHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createFOMHashTables("");
	}
    }

    /**
     * this method drops transaction hash tables
     * 
     * @throws BaseException
     */
    public void dropTrxHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropTrxHashTables("");
	}
    }

    /**
     * THIS FUNCTION RETURNS THE "M_RATE" From table EXCH_RAT for a specific
     * date, IF not found return 0. in PB f_get_exchrate in getExChRate we set
     * aSb = 'M', alBranchCode = 0 and alCif = 0
     * 
     * @param transferCashSC
     * @return TransferCashSC
     * @throws BaseException
     */
    public TransferCashSC getExChRate(TransferCashSC transferCashSC) throws BaseException
    {
	String sybOra;
	if(commonLibBO.returnIsSybase() == 1)
	{
	    sybOra = "S";
	}
	else
	{
	    sybOra = "O";
	}
	return coreCommonProcedureDAO.getExChRate(transferCashSC, sybOra);
    }

    /**
     * This function returns the error code and error type if exists in pb
     * uf_check_teller_limits
     * 
     * @param transferCashSC
     * @return TransferCashSC
     * @throws BaseException
     */
    public TransferCashSC checkUserLimits(TransferCashSC transferCashSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkUserLimits(transferCashSC);
    }

    /**
     * This method calculates the first payment date and the ending date for SO
     * 
     * @param trxMgntSoDetSC
     * @return trxMgntSoDetSC
     * @throws BaseException
     */
    public TrxMgntSoDetSC calculateSoDates(TrxMgntSoDetSC trxMgntSoDetSC) throws BaseException
    {
	
	return coreCommonProcedureDAO.calculateSoDates(trxMgntSoDetSC);
    }

    
    //Hasan ghrayeb-BPM modification
    /**
     * This method call the P_RET_CHARGES_GAINLOSS_DENOM TO ADD THE NEW GAIN/LOSS RECORD CHARGE TO CTS_CHARGES_UNIFIED	
     */
   
    public TrxMgntSC InsertNewGainlossRecord(TrxMgntSC trxMgntSC) throws BaseException
    {
	
	return coreCommonProcedureDAO.InsertNewGainlossRecord(trxMgntSC);
    }

    /**
     * This function returns the error code, error type, error Msg and
     * overdrawn_void if exists in pb uf_check_amount_restriction
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC checkAmntRestriction(TrxMgntSC criteria) throws BaseException
    {
	return coreCommonProcedureDAO.checkAmntRestriction(criteria);
    }

    /**
     * This function returns the VAT details relating to the charge in pb
     * f_get_vat_amount
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC getTVADetails(TrxMgntSC trxMgntSC) throws BaseException
    {
	/*
	 * So as not to get Arithmetic Overflow Exception
	 */
	trxMgntSC.setExchRate(trxMgntSC.getExchRate().setScale(6, BigDecimal.ROUND_HALF_UP));
	trxMgntSC.setTotalCVcharge(trxMgntSC.getTotalCVcharge().setScale(10, BigDecimal.ROUND_HALF_UP));
	trxMgntSC.setTotalFCcharge(trxMgntSC.getTotalFCcharge().setScale(10, BigDecimal.ROUND_HALF_UP));

	return coreCommonProcedureDAO.getTVADetails(trxMgntSC);
    }

    /**
     * This function returns the Exchange Rate Flag to know which rate to use in
     * pb n_retail_rate.uf_set_exchrate_type
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC getExchrateFlag(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getExchrateFlag(trxMgntSC);
    }

    /**
     * This function returns the Cross Rate exchange rate calls
     * P_RET_GET_CROSS_RATE_COVER
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC getCrossRateCover(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getCrossRateCover(trxMgntSC);
    }

    /**
     * This function returns the CVAMOUNT calls P_RET_CALC_CVAMOUNT
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC getCvAmount(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getCvAmount(trxMgntSC);
    }

    /**
     * This function returns the Charges details calls P_RET_GET_CHARGES_DETAILS
     * 
     * @param TrxMgntChargesSC
     * @return TrxMgntChargesSC
     * @throws BaseException
     */
    public TrxMgntChargesSC getChargesDetails(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.getChargesDetails(trxMgntChargesSC);
    }

    public TrxMgntChargesSC returnProductCharges(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnProductCharges(trxMgntChargesSC);
    }

    /**
     * This function returns the Cross Rate in pb P_RET_CHECK_USER_MINMAX_BAL
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC checkUserMinMaxBal(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkUserMinMaxBal(trxMgntSC);
    }

  //#795165 Branches cash limit monitoring [MFALHA]
    public TrxMgntSC checkBranchCashLimit(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkBranchCashLimit(trxMgntSC);
    }
  //#795165 Branches cash limit monitoring [MFALHA]

    public TrxMgntSC checkHouseChequeData(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkHouseChequeData(trxMgntSC);
    }

    public void populateCif(PopulateCifSC populateCifSC) throws BaseException
    {
	coreCommonProcedureDAO.populateCif(populateCifSC);
    }

    /**
     * This function returns the CV balance and FC balance P_GET_BF_BALANCE
     * 
     * @param StatementOfAccountsCO
     * @return StatementOfAccountsCO
     * @throws BaseException
     */
    public AccountCommonCO getBFBalance(AccountCommonCO accountCommonCO) throws BaseException
    {
	return coreCommonProcedureDAO.getBFBalance(accountCommonCO);
    }

    public TrxMgntSC returnClosingTime(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnClosingTime(trxMgntSC);
    }

    /**
     * in PB common uf_get_rate This method calls procedure
     * P_RET_GET_RATE_NORMAL
     */
    public TrxMgntSC returnRateNormal(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnRateNormal(trxMgntSC);
    }

    /**
     * in PB common wf_get_amount_in_base_cy in currency exchange This method
     * calls procedure P_RET_GET_AMT_TELLER_EXCH
     */
    public TrxMgntSC returnAmountByRateForTellerExch(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnAmountByRateForTellerExch(trxMgntSC);
    }

    public CtstrsUploadSC callProcFillTmpCtstrsUpload(CtstrsUploadSC ctstrsUploadSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcFillTmpCtstrsUpload(ctstrsUploadSC);
    }

    public CtstrsUploadSC callProcBatchLaunchProcess(CtstrsUploadSC ctstrsUploadSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcBatchLaunchProcess(ctstrsUploadSC);
    }

    public CtstrsUploadSC callProcBatchDeleteRecords(CtstrsUploadSC ctstrsUploadSC) throws BaseException
    {

	return coreCommonProcedureDAO.callProcBatchDeleteRecords(ctstrsUploadSC);
    }

    public TrxMgntSC returnRetVDate(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnRetVDate(trxMgntSC);
    }

    public TrxMgntSC moveFromTrsAlertToTrs(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.moveFromTrsAlertToTrs(trxMgntSC);
    }

    /**
     * Based originally on n_transaction.uf_validate_remittance and
     * n_transaction.uf_validate_tc_remittance Calls procedure
     * P_RET_VALIDATE_REMITTANCE
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC validateRemittance(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.validateRemittance(trxMgntSC);
    }

    /**
     * Based originally on n_transaction.uf_update_remitt_inventory Calls
     * procedure P_RET_UPDATE_REMITT_INVENTORY
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC updateRemittance(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.updateRemittance(trxMgntSC);
    }

    /**
     * this method calls procedure P_RET_UPDATE_CHEQUE_STATUS and replaces
     * n_transaction.uf_insert_cheque_status
     * 
     * @author guittaabougharrach
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC updateChequeStatus(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.updateChequeStatus(trxMgntSC);
    }

    /**
     * this procedure is used to get the additiona reference of account using
     * the P_API_GET_ADD_REF procedure
     * 
     * @param accountCommonCO
     * @return
     * @throws BaseException
     */
    public AccountCO returnAccountAdditionalReference(AccountCO accountCO) throws BaseException
    {
	return coreCommonProcedureDAO.returnAccountAdditionalReference(accountCO);
    }
    
    public AccountCO createAccount(AccountCO accountCO) throws BaseException
    {
	return coreCommonProcedureDAO.createAccount(accountCO);
    }

    public BlackListSC fillCifSoundex(BlackListSC blackListSC) throws BaseException
    {
	return coreCommonProcedureDAO.fillCifSoundex(blackListSC);
    }

    public CardsManagementSC checkDataCards(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkDataCards(cardsManagementSC);
    }

    public CardsManagementSC addCardsHistory(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.addCardsHistory(cardsManagementSC);
    }

    public CardsManagementSC returnCardNo(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnCardNo(cardsManagementSC);
    }

    public TrxMgntSC soChangestatusCharge(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.soChangestatusCharge(trxMgntSC);
    }

    public BlackListSC updateFillCifBlacklistMos(BlackListSC blackListSC) throws BaseException
    {
	return coreCommonProcedureDAO.updateFillCifBlacklistMos(blackListSC);
    }

    /**
     * in pbd : guo_back_end_proc.p_cards
     */
    public CardsManagementSC returnCardsRefWithExpDate(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnCardsRefWithExpDate(cardsManagementSC);
    }

    /**
     * this method creates #SDX
     * 
     * @throws BaseException
     */
    public void createHashSoundex() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createHashSoundex("");
	}
    }

    /**
     * this method drops #SDX
     * 
     * @throws BaseException
     */
    public void dropHashSoundex() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropHashSoundex("");
	}
    }

    public void closeAccount(AccountSC accountSC) throws BaseException
    {
	coreCommonProcedureDAO.closeAccount(accountSC);
    }

    public void authorizeCloseAccount(AccountSC accountSC) throws BaseException
    {
	coreCommonProcedureDAO.authorizeCloseAccount(accountSC);
    }

    public AccountSC checkUnclaimed(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkUnclaimed(accountSC);
    }

    public AccountSC callProcCheckCollguarantor(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcCheckCollguarantor(accountSC);
    }

    /**
     * f_release_ret_hof p_ret_release_hof
     * 
     * @author nabilfeghali
     * @param trxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC releaseHof(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.releaseHof(trxMgntSC);
    }

    /**
     * in pb : n_transaction.uf_release_trans p_ret_release_hof_with_charges
     * 
     * @author guittaabougharrach
     * @param trxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC releaseHofWithCharges(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.releaseHofWithCharges(trxMgntSC);
    }

    /**
     * PB = P_RET_ALERT_CTSTRS
     * 
     * @author nabilfeghali
     * @param trxMgntCO
     * @throws BaseException
     */
    public TrxMgntSC callAlertCtsTrs(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callAlertCtsTrs(trxMgntSC);
    }

    /**
     * @author nabilfeghali
     * @param cifSC
     * @return
     * @throws BaseException
     */
    public CifSC callAlertCif(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.callAlertCif(cifSC);
    }

    /**
     * @author nabilfeghali
     * @param AccountSC
     * @return
     * @throws BaseException
     */
    public AccountSC callAlertAmf(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.callAlertAmf(accountSC);
    }

    public MosBlackListSC fillSoundex(MosBlackListSC mosBlackListSC) throws BaseException
    {
	return coreCommonProcedureDAO.fillSoundex(mosBlackListSC);
    }

    /**
     * this function is used to create HOF transaction
     * 
     * @param trxMgntSC
     * @return
     * @throws BaseException
     */
    public TrxMgntSC createHoldOfFunds(TrxMgntSC trxMgntSC) throws BaseException

    {
	return coreCommonProcedureDAO.createHoldOfFunds(trxMgntSC);
    }

    public TrxMgntSC authorizeClearingVoiding(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.authorizeClearingVoiding(trxMgntSC);
    }

    /**
     * f_addjv_ret
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC addJvRet(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.addJvRet(trxMgntSC);
    }

    /**
     * Calls the Procedure P_RET_CHECK_SPECIAL_CONDITION. Performs Checking on
     * From and To Account for Special Conditions
     * 
     * @author redacharabaty
     * @param trxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC checkSpecialConditions(TrxMgntSC trxMgntSC) throws BaseException
    {
	//Hala Al Sheikh - SBI170027 
	dropTrxHashTables();
	createTrxHashTables();
	return coreCommonProcedureDAO.checkSpecialConditions(trxMgntSC);
    }

    /**
     * Call of P_CHECK_BLACKLIST
     * 
     * @author nabilfeghali
     * @param blackListSC
     * @return
     * @throws BaseException
     */
    public BlackListSC checkBlackList(BlackListSC blackListSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkBlackList(blackListSC);
    }

    public TrxMgntSC callProcRecalcForRelatedGl(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcRecalcForRelatedGl(trxMgntSC);
    }

    public TrxMgntSC callProcPcsPftForRelatedGl(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcPcsPftForRelatedGl(trxMgntSC);
    }

    public TrxMgntSC callProcPcsProfitDetail(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcPcsProfitDetail(trxMgntSC);
    }

    public TrxMgntSC callProcRetGetPenaltyDetail(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcRetGetPenaltyDetail(trxMgntSC);
    }

    @Override
    public PassBookCO updatePassbookDOFHST(PassBookCO passBookCO) throws BaseException
    {
	return coreCommonProcedureDAO.updatePassbookDOFHST(passBookCO);
    }

    @Override
    public PassBookCO printPassbookDetails(PassBookCO passBookCO) throws BaseException
    {
	return coreCommonProcedureDAO.printPassbookDetails(passBookCO);
    }

    public TrxMgntSC callProcGetPcsCharges(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcGetPcsCharges(trxMgntSC);
    }

    public TrxMgntSC callProcGetPcsTaxes(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcGetPcsTaxes(trxMgntSC);

    }

    @Override
    public TrxMgntBatchSC updateAutoBatch(TrxMgntBatchSC trxMgntBatchSC) throws BaseException
    {
	return coreCommonProcedureDAO.updateAutoBatch(trxMgntBatchSC);
    }

    public TrxMgntSC callProcVisaLaunchProcess(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcVisaLaunchProcess(trxMgntSC);
    }

    /**
     * Calls the Procedure P_RET_CHECK_REMITTANCE_STOCK. Performs Checking on
     * Remittance Stock if it is low. equivalent to
     * n_transaction.uf_check_remittance_stock()
     * 
     * @author redacharabaty
     * @param trxMgntSC
     * @return TrxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC checkRemittanceStock(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkRemittanceStock(trxMgntSC);
    }

    @Override
    public void createAuthorizeClearingTmpTables() throws BaseException
    {
	coreCommonProcedureDAO.createAuthorizeClearingTmpTables();
    }

    public AccountCommonCO getBalanceAcc(AccountCommonCO accountCommonCO) throws BaseException
    {
	dropAccHashTables();
	createAccHashTables();
	return coreCommonProcedureDAO.getBalanceAcc(accountCommonCO);
    }
    
    public AccountCommonCO getAccBalance(AccountCommonCO accountCommonCO) throws BaseException
    {
	return coreCommonProcedureDAO.getAccBalance(accountCommonCO);
    }
    
    
    public TrxMgntSC getAccExchrate(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getAccExchrate(trxMgntSC);
    }

    public final SpecialConditionsSC pRetAlertSPCONDS(SpecialConditionsSC spcondsSC) throws BaseException
    {
	return coreCommonProcedureDAO.pRetAlertSPCONDS(spcondsSC);
    }

    /**
     * Calls the Procedure P_RET_GET_CROSS_RATE. Calculates and returns the
     * Cross Rate. Should be called when we have FC/FC
     * 
     * Replaces f_get_cross_rate_sb
     * 
     * @author redacharabaty
     * 
     * 
     * @param trxMgntSC -compCode Company Code -toCy Transaction Currency (To
     *            Currency) -baseCurrencyCode Base Currency -frCy From Currency
     *            -trsType Transaction Type (D/W/T/H) -trxType Transaction Type
     *            Code -crDrForex CrDrForex -runningDate System Running Date
     *            -branchCode Branch Code -cif CIF number -cash If transfer
     *            method ='C' or default_dr_acc_teller = '1' then as_cash should
     *            be = '1' -staff In case of Staff Rate then '1' -acFromCyUnits
     *            From Currency Units: If we already have the value from
     *            previous queries in order to save query on Currencies table,
     *            else a query will be executed -acFromCyMultiDiv From Currency
     *            MultDiv Indicator: if we already have the value from previous
     *            queries in order to save query on Currencies table, else a
     *            query will be executed -acToCyMultiDiv To Currency MultDiv
     *            Indicator: if we already have the value from previous queries
     *            in order to save query on Currencies table, else a query will
     *            be executed -acToCyUnits To Currency Units: if we already have
     *            the value from previous queries in order to save query on
     *            Currencies table, else a query will be executed -screenSrc To
     *            be filled by 'EX' in case called from currency exchange screen
     * 
     * 
     * 
     * @return trxMgntSC -exchRate Cross Rate -multiDivInd MultDiv Indicator
     *         -errorCode -errorMessage
     * 
     * 
     * @throws BaseException
     */
    public TrxMgntSC getCrossRate(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getCrossRate(trxMgntSC);
    }

    public TrxMgntSettlementSC checkIisInvestmentDeal(TrxMgntSettlementSC trxMgntSettlementSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkIisInvestmentDeal(trxMgntSettlementSC);
    }

    public void createTempTableForInvestmentDeal() throws BaseException
    {
	coreCommonProcedureDAO.createTempTableForInvestmentDeal();
    }

    public TrxMgntSettlementSC returnMinAmountRecv(TrxMgntSettlementSC trxMgntSettlementSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnMinAmountRecv(trxMgntSettlementSC);
    }

    /**
     * @author EliasAoun ; BSI120039 ; 23-01-2014
     * @description this modif has been postponed
     */
    public AccountSC storeInAmfAlert(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.storeInAmfAlert(accountSC);
    }

    // NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public ConditionalAutomationCO forbidMatchedCIF(ConditionalAutomationCO conditionalAutomationCO)
	    throws BaseException
    {
	return coreCommonProcedureDAO.forbidMatchedCIF(conditionalAutomationCO);
    }

    /**
     * Calls the Procedure P_RET_GET_CHARGES_UNIFIED. Calculates the charges by
     * calling the common procedure. Stores the charges in the table
     * CTS_CHARGES_UNIFIED. returns the totals of CV and FC charge amounts and
     * totals of CV and FC charge dues amounts
     * 
     * @author redacharabaty
     * 
     * 
     * @param entityChargesSC
     * 
     *            Input Arguments -compCode Logged-In Company -branchCode
     *            Logged-In Branch -userID Logged-In User ID Prior to calling
     *            this function, a record must be inserted into
     *            CTS_CHARGES_UNIFIED LINE_NO 0, with the following filled:
     * 
     *            -COMP_CODE Logged-In Company -BRANCH_CODE Logged-In Branch
     *            -BRANCH_SO SO Transaction Branch (In case of Standing Order)
     *            -TRS_NO_SO SO Transaction Number (In case of Standing Order)
     *            -PRODUCT_NAME Product Name. Values are: - CHQ CHEQUEBOOK - SAF
     *            SAFEBOX - REA REASON - TRX TRX_TYPE - CAR
     *            CARDS - PAS PASSBOOK - LOS LOST_FOUND - CER CERTIFICATE - SO
     *            STANDING_ORDER -TELLER_CODE Login Teller Code
     *            -ENTITY_TYPE_CODE Trx: Transaction Type Code Entities: Entity
     *            Type Code -DEDUCT Trx: CASH_DEDUCT_IND Entities:
     *            CHARGES_DEDUCT (If exists) (flag that designates how charges
     *            are deducted) -CRUD CRUD of screen -CHQ_ISSUE_TYPE CHQ Only:
     *            NORMAL_URGENT, N --> Normal / U --> Urgent -LEAVES CHQ Only:
     *            LEAVES -TYPE CHQ Only: TYPES -LINE_NO 0 as the procedure will
     *            read the arguments from line 0. -TRS_NO Transaction Number if
     *            it exists (not upon dependencies) Note for all the below
     *            columns, the ones related to Transactions should be filled
     *            only in case TRS_NO is not filled. In case of entities, they
     *            should be filled when possible. -CREDIT_ACC_BR Branch Trx:
     *            From Account Entities: Main Account -CREDIT_ACC_CY Currency
     *            Trx: From Account Entities: Main Account -CREDIT_ACC_GL GL
     *            Trx: From Account Entities: Main Account -CREDIT_ACC_CIF CIF
     *            Trx: From Account Entities: Main Account -CREDIT_ACC_SL SL
     *            Trx: From Account Entities: Main Account -DEBIT_ACC_BR Branch
     *            Trx Only: To Account -DEBIT_ACC_CY Currency Trx Only: To
     *            Account -DEBIT_ACC_GL GL Trx Only: To Account -DEBIT_ACC_CIF
     *            CIF Trx Only: To Account -DEBIT_ACC_SL SL Trx Only: To Account
     *            -CHARGE_ACC_BR Branch Trx: Charge Account Entities: Charge
     *            Account (If exists) -CHARGE_ACC_CY Currency Trx: Charge
     *            Account Entities: Charge Account (If exists) -CHARGE_ACC_GL GL
     *            Trx: Charge Account Entities: Charge Account (If exists)
     *            -CHARGE_ACC_CIF CIF Trx: Charge Account Entities: Charge
     *            Account (If exists) -CHARGE_ACC_SL SL Trx: Charge Account
     *            Entities: Charge Account (If exists) -AMOUNT_FC_NEW Trx Only:
     *            AMOUNT -TRS_CY Trx Only: TRS_CY -TRS_DATE Trx Only: TRS_DATE
     *            -AMOUNT Trx Only: CV_AMOUNT -EXCH_RATE Trx Only: EXCHANGE_RATE
     *            -TRSFR_METHOD Trx Only: TRSFR_METHOD -ACTION_TYPE Action Type
     *            of Transaction - P Approval Charges - N Cancelation Charges -
     *            RC Cancelation Reason Charges - RV Void Reason Charges - RR
     *            Reverse Reason Charges - E Standing Order Setup Charges - A
     *            Standing Order Amend Charges - R Standing Order Reinstate
     *            Charges - S Standing Order Suspend Charges - C Standing Order
     *            Close Charges -CTRL_CY Currency Trx: Teller Account -CTRL_GL
     *            GL Trx: Teller Account -CTRL_CIF CIF Trx: Teller Account
     *            -CTRL_SL SL Trx: Teller Account
     * 
     * 
     * 
     * @return entityChargesSC The Procedure will fill the table
     *         CTS_CHARGES_UNIFIED. After the procedure returns, charges can be
     *         read from the table; with the exception of LINE_NO 0. The
     *         procedure will return the totals: -totalCvAmount Total Charge
     *         Amount in CV -totalFcAmount Total Charge Amount in FC
     *         -totalCvDues Total Charge Dues Amount in CV -totalFcDues Total
     *         Charge Dues Amount in CV
     * @throws BaseException
     */
    public EntityChargesSC calculateCharges(EntityChargesSC entityChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.calculateCharges(entityChargesSC);
    }

    /**
     * NABIL FEGHALI - PATH120107 - FATCA PHASE I
     * 
     * @param memoDtlCO
     * @return
     * @throws BaseException
     */
    public MemoDtlCO createDeleteMemo(MemoDtlCO memoDtlCO) throws BaseException
    {
	return coreCommonProcedureDAO.createDeleteMemo(memoDtlCO);
    }

    /**
     * TONY NOUH reverse batch
     * 
     * @param ctstrsUploadSC
     * @return CtstrsUploadSC
     * @throws BaseException
     */
    public CtstrsUploadSC reverseBatch(CtstrsUploadSC ctstrsUploadSC) throws BaseException
    {
	return coreCommonProcedureDAO.reverseBatch(ctstrsUploadSC);
    }

    /**
     * @author EliasAoun
     * @PB f_check_pending_dues
     * @Modfi #82717 IIAB080110 - DUES in Account
     * @param #compCode, #branchCode, #baseCurrencyCode, #userId, #runningDate,
     *        #brCode, #currencyCode, #glCode, #cifCode, #slNbr ;-#screenRef :
     *        'S' for Suspend , 'RE' for Reactivate , X for Checking
     */
    public AccountSC checkPendingDues(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkPendingDues(accountSC);
    }

    /**
     * @author EliasAoun
     * @PB f_dues_amount_acc
     * @Modif #82717 IIAB080110 - DUES in FOM dueStatus can be from 1 till 4 1
     *        => in ('P','PC') 2 => in ('A','W') 3 => in ('A','W','P','PC') 4 =>
     *        in ('S') action : 'C' => for CIF ;'A' => for Account
     */
    public DuesManagementSC returnDuesAmountAcc(DuesManagementSC duesManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnDuesAmountAcc(duesManagementSC);
    }

    @Override
    public DuesManagementSC invokeDuesAlertProcedure(DuesManagementSC duesSc) throws BaseException
    {
	return coreCommonProcedureDAO.executeDuesAlertProcedure(duesSc);
    }

    @Override
    public DuesManagementSC invokeReverseTrxForDuesProcedure(DuesManagementSC duesSc) throws BaseException
    {
	return coreCommonProcedureDAO.executeReverseTrxForDues(duesSc);
    }

    @Override
    public DuesManagementSC invokeCheckDuesAccountProcedure(DuesManagementSC duesSc) throws BaseException
    {
	return coreCommonProcedureDAO.executeCheckDuesAccountProcedure(duesSc);
    }

    @Override
    public void createCTS_DUES_TEMP() throws BaseException
    {
	if(1 == commonLibBO.returnIsSybase())
	{
	    coreCommonProcedureDAO.createCTS_DUES_TEMP();
	}
    }
    
    @Override
    public void createHUNTING_TMP() throws BaseException
    {
	if(1 == commonLibBO.returnIsSybase())
	{
	    coreCommonProcedureDAO.createHUNTING_TMP();
	}
    }

    @Override
    public void createHOF_TMP() throws BaseException
    {
	if(1 == commonLibBO.returnIsSybase())
	{
	     coreCommonProcedureDAO.createHOF_TMP();
	}
    }

    /**
     * This method calls procedure P_RET_CHECK_AMOUNT  to validate 
     * if account exceed available balance
     */
    public TrxMgntSC returnCheckAmountAccBalance(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnCheckAmountAccBalance(trxMgntSC);
    }
    
	
	
    public void dropAccHashTables() throws BaseException
        {
	  if(commonLibBO.returnIsSybase() == 1)
	     {
	       coreCommonProcedureDAO.dropAccHashTables("");
	     }
	}

	    public void createAccHashTables() throws BaseException
	    {
		if(commonLibBO.returnIsSybase() == 1)
		{
		    coreCommonProcedureDAO.createAccHashTables("");
		}
	    }
    /**
     * JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659 log charges as dues when insufficient balance
     */
    public TrxMgntSC insertCtsDues(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.insertCtsDues(trxMgntSC);
    }


    public CtstrsUploadSC launchBatchSaveAs(CtstrsUploadSC ctstrsUploadSC) throws BaseException
    {
	return coreCommonProcedureDAO.launchBatchSaveAs(ctstrsUploadSC);
    }
       
      
    
    public void dropBatchProcessHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	     {
	       coreCommonProcedureDAO.dropBatchProcessHashTables("");
	     }
	
    }
    public void createBatchProcessHashTables() throws BaseException
    {
	
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createBatchProcessHashTables("");
	}
    }
    
    public void dropBatchValidHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	     {
	       coreCommonProcedureDAO.dropBatchValidHashTables("");
	     }
	
    }
    public void createBatchValidHashTables() throws BaseException
    {
	
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createBatchValidHashTables("");
	}
    }
    
    
    /**
     * This method calls procedure P_RET_CHECK_ALLOWED_GLS  to validate 
     * if the specified GL is allowed to be Credited/Debited/ or Both
     * 
     * @param trxMgntSC
     * 		compCode		Company Code
     * 		trxType			Transaction Type
     * 		trsAcGl			GL Code to be checked
     * 		sign			Sign to check for (C/D/B)
     * @return trxMgntSC
     * @throws BaseException
     */
    public TrxMgntSC returnCheckAllowedGls(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnCheckAllowedGls(trxMgntSC);
    }
    
    
    /**
     * This method calls procedure P_RET_GET_BIC_CODE to calculate
     * a new BIC Code and validate a given BIC Code
     * 
     * @param trxMgntSC
     * 		compCode		Company Code
     * 		branchCode		Branch Code	
     * 		bankCif			CIF Number to get BIC Code for
     * 		bankBicCode		Given BIC Code to validate if same as the new one to be generated (Optional)
     * 
     * 
     * @return trxMgntSC
     * 		bicCode			Generated BIC Code
     * 
     * @throws BaseException
     */
    public TrxMgntSC returnBicCode(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnBicCode(trxMgntSC);
    }
    
    /**
     * This method calls procedure P_RET_VALIDATE_PROVIDER_REF to validate
     * the provider ref
     * @param trxMgntSC
     * @return
     * @throws BaseException
     */
    public TrxMgntSC validateProviderRef(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.validateProviderRef(trxMgntSC);
    }
    
    
    /**
     * This method calls procedure P_RET_REQUEST_CHARGES to calculate and possibly generate JVs
     * for Request Charges. It returns the total.
     * 
     * @param trxMgntChargesSC
     * 		compCode		Company Code
     * 		branchCode		Branch Code
     * 		entityTypeCode		Request Type Code
     * 		requestCy		Request Currency
     * 		deductAcBr		Deduct Account Branch
     * 		deductAcCy		Deduct Account Currency
     * 		deductAcGl		Deduct Account GL
     * 		deductAcCif		Deduct Account CIF
     * 		deductAcSl		Deduct Account SL
     * 		userId			User ID
     * 		entityCode		Request Number
     * 		autoApprove		Auto-Approve ('1'/'0')
     * 		requestDate		Request Date
     * 		appName			Application Name (not required)
     * 		amount			Amount (not required)
     * 
     * @return trxMgntChargesSC
     * 		totalAmount		Total Charge Amount
     * 		error			Error Code
     * 		errorMessage		Error Message
     *
     * 
     * @throws BaseException
     */
    public TrxMgntChargesSC returnRequestCharges(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnRequestCharges(trxMgntChargesSC);
    }
    
    public TrxMgntSC returnAmountByRate(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnAmountByRate(trxMgntSC);
    }

    /**
     * @author eliasaoun
     * @desc generate the next counter based on IBISCOUNTER.TRX_TYPE
     * @param COMP_CODE, BRANCH_CODE, TRX_TYPE
     * @return LAST_NO
     */
    public IBISCOUNTERVO generateIbisCounter(IBISCOUNTERVO criteria) throws BaseException
    {
	return coreCommonProcedureDAO.generateIbisCounter(criteria);
    }
    
    /**
     * @author eliasaoun
     * @desc generate the next counter based on IBISCOUNTER.TRX_TYPE
     * @param as_source BlackListManagementConstant.AS_SOURCE_UN || AS_SOURCE_OFAC
	    	compCode login company code
     */
    public BlackListIntSourceSC callSoundexProcess(BlackListIntSourceSC criteria) throws BaseException
    {
	return coreCommonProcedureDAO.callSoundexProcess(criteria);
    }

    public void createCardsHashTables() throws BaseException
    {
	coreCommonProcedureDAO.createCardsHashTables();
    }
    
    public void dropCardsHashTables() throws BaseException
    {
	coreCommonProcedureDAO.dropCardsHashTables();
    }
    /**
     * used to apply accounting entries
     * 
     * @author: jihadlamaa
     * @date: Jun 3, 2014
     * @PB:
     * @param tfaCommonSC
     * @return
     * @throws BaseException
     */
    public CtsRequestSC pkgTemplateTfa(CtsRequestSC criteria) throws BaseException
    {

        CtsRequestSC tfaCommonSC1 = coreCommonProcedureDAO.pkgTemplateTfa(criteria);

        return tfaCommonSC1;

    }
    //Abdo BURJ150069 12/08/2016
    public void checkAccCreation(AccountSC accountSC) throws BaseException
    {
    	coreCommonProcedureDAO.checkAccCreation(accountSC);	
    }
    
    /**
     * This method calls procedure P_RET_GET_PENALTY_DETAIL_GEN to calculate
     * the profit and penalties for a General Account upon Breaking of Deposit.
     * 
     * @param trxMgntSC
     * 		compCode		Company Code
     * 		branchCode		Branch Code
     *          trsAcBr			Break of Deposit Account Branch
     *          trsAcCy			Break of Deposit Account Currency
     *          trsAcGl			Break of Deposit Account GL
     *          trsAcCif		Break of Deposit Account CIF
     *          trsAcSl			Break of Deposit Account SL
     *          systemDate		Running Date
     *          type			Break of Deposit GL: '0' --> Default Penalty GL / '1' --> Use Related GL (trxMgntCO.getCtstrsBREAKDEPVO().getBD_TYPE()) (Optional
     *          PENALTY_GL		in case type set to '1' then Related GL (trxMgntCO.getCtstrsBREAKDEPVO().getRELATED_GL()) (Optional)
     * 
     * @return trxMgntSC
     * 		adecBal			Break of Deposit Account Available Balance (Principal Amount)
     * 		adecProfit		Sum of Points
     * 		adecPenalty		Penalty Amount
     * 		adecNetProfit		Sum of Points with Tax,Penalty,Commission and Charges deducted
     * 		asOverPenalty		Allow Modify Penalty (RIFATT.MODIF_PEN)
     * 		PRFT_CY			Post Profit To Currency	
     * 		PRFT_GL			Post Profit To GL
     * 		PRFT_CIF		Post Profit To CIF
     * 		PRFT_SL			Post Profit To SL
     * 		PENALTY_GL		Penalty Account GL (RIFATT.PEN_GL)/Related GL (Depending on as_bd_type)
     * 		PENALTY_CIF		Penalty Account CIF (RIFATT.PEN_CIF)
     * 		PENALTY_SL		Penalty Account SL (RIFATT.PEN_SL)
     * 		ACCR_GL			Accrual Account GL
     * 		ACCR_CIF		Accrual Account CIF
     * 		ACCR_SL			Accrual Account SL
     * 		TAX_FC			Tax Amount in Break of Dep Account Currency
     * 		commissionFC		Commission Amount in Break of Dep Account Currency
     * 		chargeFC		Charge Amount in Break of Dep Account Currency
     * 		error			Error Code
     * 		errorMessage		Error Message
     *
     * 
     * @throws BaseException
     */
    public TrxMgntSC callProcRetGetPenaltyDetailGen(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcRetGetPenaltyDetailGen(trxMgntSC);
    }

    public CardsManagementCO returnCardEnquiry(CardsManagementCO cardsManagementCO) throws BaseException
    {
	return coreCommonProcedureDAO.returnCardEnquiry(cardsManagementCO);
    }

    public void createHashEccArguments() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createHashEccArguments("");
	}
    }

    public void dropHashEccArguments() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropHashEccArguments("");
	}
    }

    @Override
    public AccountSC callRetAccReactivation(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.callRetAccReactivation(accountSC);
    }

    public TrxMgntSC returnTranslateMICR(TrxMgntSC trxMgntSC) throws DAOException
    {
	return coreCommonProcedureDAO.returnTranslateMICR(trxMgntSC);
    }
    
    public TrxMgntSC verifyMICRKey(TrxMgntSC trxMgntSC) throws DAOException
    {
	return coreCommonProcedureDAO.verifyMICRKey(trxMgntSC);
    }
    
    /**
     * this method should be in new transaction so the data added to table SYNC_LOCKUNLOCK_ACC in the procedure P_RET_LOCK_UNLOCK_SAFE_ACC
     * will be committed and not affect the first session.and when calling safeAccLockBO.lockUnlockAccounts_NewTrans this method can see these data 
     * because they are committed.
     * note that coreCommonProcedureBO should be in the applicationContext.xml 
     */
    public TrxMgntSC lockUnlockSafeAccounts_NewTrans(TrxMgntSC trxMgntSC) throws BaseException
    {
	dropTrxHashTables();
	createTrxHashTables();
	return coreCommonProcedureDAO.lockUnlockSafeAccounts(trxMgntSC);
    }
    
    /*Same procedure call as lockUnlock but without new session opening */
    public TrxMgntSC fillCreditedAccounts(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.lockUnlockSafeAccounts(trxMgntSC);
    }
    /*Roland Freige - BB140182 - Salary was posted but the online salary block failed + split of counters*/
    public TrxMgntSC callIISProcedureCalculation(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callIISProcedureCalculation(trxMgntSC);
    }
    
    public TrxMgntSC checkIISsalaryBlock(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkIISsalaryBlock(trxMgntSC);
    }
    
    //TONY NOUH User Story#315732  AMANA130105 Overdraft Products
    public TrxMgntSC checkOverDraft(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkOverDraft(trxMgntSC);
    }
    
    /**
     * This method calls procedure P_RET_PROCESS_WITHHOLDING to run the Withholding Process
     * which can either pass charges or create a HOF transaction on withholding accounts.
     * 
     * @param withholdingSC
     * 		compCode		Company Code
     * 		branchCode		Branch Code
     * 		userId			User ID
     * 		taxRegulationID		Tax Regulation ID
     * 		processID		Process ID
     * 		action			Action to be Done ('F' for Final Run / 'T' for Trial Run)
     * 
     * @return withholdingSC
     * 		errorCode		Error Code
     * 		errorMessage		Error Message
     *
     * 
     * @throws BaseException
     */
    public WithholdingSC processWithholding(WithholdingSC withholdingSC) throws BaseException
    {
	return coreCommonProcedureDAO.processWithholding(withholdingSC);
    }
    
    /**
     * This method calls procedure P_RET_CHECK_USER_LIMITS_REQ, which will check
     * and return the user's request type limits.
     * 
     * @param CtsRequestSC compCode Company Code branchCode Branch Code userId
     *            User ID cifNo CIF No requestType Request Type Code
     * 
     * @return CtsRequestSC balanceLimitRequest Limit crud Check All Request
     *         flag (Check limit for all Requests )(assets Sale or Purchase
     *         only) code Request Type Code trsType Check Overall Limit flag
     *         (assets Sale or Purchase only) errorCode Error Code errorType
     *         Error Type (W/E) errorMessage Error Message
     * 
     * 
     * @throws BaseException
     */
    public CtsRequestSC checkUserLimtReq(CtsRequestSC criteria) throws BaseException
    {
	return coreCommonProcedureDAO.checkUserLimtReq(criteria);
    }
    
    public void createCtsTrsTempFiltered() throws BaseException
    {
	coreCommonProcedureDAO.createCtsTrsTempFiltered();
    }
    
    public void createCtsTemp() throws BaseException
    {
	coreCommonProcedureDAO.createCtsTemp();
    }
    
    
    public TrxMgntSC callProcRetProcessAutoAllocation(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcRetProcessAutoAllocation(trxMgntSC);
    }

    /**
     * Hasan EWBI160091 20/05/2016
     */
	@Override
    public CifSC callCifUpdate(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.callCifUpdate(cifSC);
    }  

    //raed BIPL120018
    public TrxMgntSC callFractionsProfit(TrxMgntSC trxMgntSC) throws BaseException
    {
    	return coreCommonProcedureDAO.callFractionsProfit(trxMgntSC);
    }

    @Override
    public AccountSC returnAmfBalanceFCNew(AccountSC accountSC) throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    accountSC.setIsOracle(0);
	}
	else
	{
	    accountSC.setIsOracle(1);
	}
	return coreCommonProcedureDAO.returnAmfBalanceFCNew(accountSC);
    }
	 
    @Override
    public AccountChargesSC processAccountCharges(AccountChargesSC accountChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.processAccountCharges(accountChargesSC);
    }
    
    public CustSegmentationSC runTrialSegmentationProcess(CustSegmentationSC custSegmentationSC) throws BaseException
    {
	return coreCommonProcedureDAO.runTrialSegmentationProcess(custSegmentationSC);
    }
    
    // added by nancy - 31/01/2018
    @Override
    public AccountSC checkOnClosingAccount (AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkOnClosingAccount(accountSC);
    }
    // end nancy
    
    // Added by nancy - 30/01/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public DuesManagementSC returnActiveWithAmountAcc(DuesManagementSC duesManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnActiveWithAmountAcc(duesManagementSC);
    }
    
    public DuesManagementSC returnPostdatedChequeBalances(DuesManagementSC duesManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnPostdatedChequeBalances(duesManagementSC);
    }
    // end nancy 
	
    /**
     * This method calls procedure P_CHECK_ONE_OBLIGOR_LIMIT to check the Card/CIF limits
     * BBRE150001 - TP#328725
     * 
     * 	Mapper available only on 14.0.7
     * @param trxMgntSC
     * 
     * 		compCode		Company Code
     * 		branchCode		Branch Code
     * 		cif			CIF Number
     * 		action			'C' - For Checking Limit
     * 		trsDate			Transaction Date
     * 		trsType			Transaction Type , 'ID' - Investment Deal , 'FX' - Forex Deal , etc
     * 		trsNo			Transaction Number
     * 		trsCy			Transaction Currency
     * 		trxAmount		Transaction Amount
     * 		oldTrxAmount		Old Transaction Amount (If an active transaction is modifying then assign old value)
     * 		productClass		(For IIS Transactions need to pass Product Class Else Pass it as 0)
     * 		currAppName		Application Name
     * 		userId			User ID
     * 
     * @return trxMgntSC
     * 		remainingLimit		Remaining Limit
     * 		errorCode		Error Code
     * 		errorMessage		Error Message
     *
     * 
     * @throws BaseException
     */
    public TrxMgntSC checkOneObligorLimit(TrxMgntSC trxMgntSC) throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    dropTrxHashTables();
	    createTrxHashTables();
	    return coreCommonProcedureDAO.checkOneObligorLimit(trxMgntSC);
	}
	else
	{
	    return trxMgntSC;
	}
    }

    
    
    /**
     * RAED SAAD
     * 
     * Title
     * 
     * USER STORY #562508 ABARSI160021 - Release of HOF and Transfer to FATCA account - CSM 14.1
     * 
     * (non-Javadoc)
     * 
     */
    @Override
    public void createProcessWithholdingTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createProcessWithholdingTables("");
	}
	
    }


    /**
     * RAED SAAD
     * 
     * Title
     * 
     * USER STORY #562508 ABARSI160021 - Release of HOF and Transfer to FATCA account - CSM 14.1
     * 
     * (non-Javadoc)
     * 
     */
    @Override
    public void dropProcessWithholdingTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropProcessWithholdingTables("");
	}
	
    }
    
    /**
     * RAED SAAD
     * 
     * Title
     * 
     * USER STORY #562508 ABARSI160021 - Release of HOF and Transfer to FATCA account - CSM 14.1
     * 
     * (non-Javadoc)
     * 
     */
    @Override
    public TrxMgntSC releaseHofByCif(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.releaseHofByCif(trxMgntSC);
    }

    @Override
    public TrxMgntSC checkClosingPeriod(TrxMgntSC trxMgntSC) throws BaseException
    {
	String sybOra;

	if(commonLibBO.returnIsSybase() == 1)
	{
	    sybOra = "S";
	}
	else
	{
	    sybOra = "O";
	}
	return coreCommonProcedureDAO.checkClosingPeriod(trxMgntSC, sybOra);
    }
    
    public AccRestrictedSC fillAccRestricted(AccRestrictedSC accRestrictedSC) throws BaseException
    {
	return coreCommonProcedureDAO.fillAccRestricted(accRestrictedSC);
    }
    
    /**
     * @author tonyelkhoury : CEFTS- Phase II- Direct Debit - AMANA170089
     * This method calls procedure P_RET_CHECK_EFT_DEBIT_TRX
     * @param compCode - systemDate - benefBank - trsAcBr - trsAcCy - trsAcGl - trsAcCif - trsAcSl - trxType - reference - trxAmount
     */
    public TrxMgntSC checkEftDebitTransaction(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkEftDebitTransaction(trxMgntSC);
    }
    
        @Override
    public CifSC checkEtlIdentProcess_NewTrans(CifSC criteria) throws BaseException
    {
    	if(commonLibBO.returnIsSybase() == 1)
	    {
			coreCommonProcedureBO.createCtsTemp();
	    }
    	return coreCommonProcedureDAO.checkEtlIdentProcess(criteria);
    }
    
    
    public TrxMgntSC retGetTrsNo(TrxMgntSC trxMgntSC) throws BaseException
    {
    	return coreCommonProcedureDAO.retGetTrsNo(trxMgntSC);
    }
    
    
    public TrxMgntSC clearTrsNo(TrxMgntSC trxMgntSC) throws BaseException
    {
    	return coreCommonProcedureDAO.clearTrsNo(trxMgntSC);
    }



    /**
     * Mapper available only on 14.0.7
     */
    public void dropOneObligorTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropOneObligorTables("");
	}
    }
	    
    /**
     * Mapper available only on 14.0.7
     */
    public void createOneObligorTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createOneObligorTables("");
	}
    }
	

    public TrxMgntSC iisOneObligorLimitReport(TrxMgntSC trxMgntSC) throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    return coreCommonProcedureDAO.iisOneObligorLimitReport(trxMgntSC);
	}
	else
	{
	    return trxMgntSC;
	}
    }
    
    /** Rania Al-Bitar
     * Date: 19/01/2018
     * @param trxMgntSC
     * @return
     * @throws DAOException
     */
    // BB140096 --[John Massaad]
    public TrxMgntSC defaultIntermBankBicCode(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.defaultIntermBankBicCode(trxMgntSC);
    }
    
    // EWBI160037 -- [John Massaad]
    public CifSC copyAuthorizeSignatures(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.copyAuthorizeSignatures(cifSC);
    }

    /**
     * BB140096 --[John Massaad]
     */
    public void createNonFinancialInfoTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createNonFinancialInfoTables("");
	}

    }

    /**
     * BB140096 --[John Massaad]
     */
    public void dropNonFinancialInfoTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropNonFinancialInfoTables("");
	}
    }
    
    public TrxMgntSC callProcVisaImport(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcVisaImport(trxMgntSC);
    }
   
    public TrxMgntSC callProcVisaMatch(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callProcVisaMatch(trxMgntSC);
    }
    
    @Override
    public BlackListSC checkBlackListRestriction(BlackListSC blackListSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkBlackListRestriction(blackListSC);
    }
    
    public TrxMgntSC callPCSRecoverProfit(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callPCSRecoverProfit(trxMgntSC);
    }
    
    public TrxMgntSC callPCSUpdateBODTrx(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callPCSUpdateBODTrx(trxMgntSC);
    }
    
    public AccountSC createAMF(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.createAMF(accountSC);
    }
    
    public TrxMgntSC returnCheckAllowedCIFs(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnCheckAllowedCIFs(trxMgntSC);
    }
    
    public TrxMgntSC callRetReverseProfit(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callRetReverseProfit(trxMgntSC);
    }
    
    //Abdo US 382751 - BB KYC with Dynamic Screen  
    public void dropSironHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropSironHashTables("");
	}
    }
    
    /**
     * this method creates transaction hash tables
     * 
     * @throws BaseException
     */
    public void createSironHashTables() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createSironHashTables("1");
	}
    }
    
    /**
     *  BURJ150099 -TRANSFER ACCOUNT BY BRANCH/GL-Hussein elhajj
     */
    public void createHashAuditDetails() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.createHashAuditDetails("");
	}
    }
    
    public void dropHashAuditDetails() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    coreCommonProcedureDAO.dropHashAuditDetails("");
	}
    }
    
    public DynFilesSC callProcExecDynFilesStatement(DynFilesSC dynFilesSC) throws BaseException
    
    {
	return coreCommonProcedureDAO.callProcExecDynFilesStatement(dynFilesSC);
    }
   
    
   public CifSC callMappingSiron(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.callMappingSiron(cifSC);
    }
   
   public CifSC callScoreSiron(CifSC cifSC) throws  BaseException {
	
  	return coreCommonProcedureDAO.callScoreSiron(cifSC);
      }
    //End Abdo
 
   public TrxMgntFxDealSC updateFxDeals(TrxMgntFxDealSC trxMgntFxDealSC)  throws BaseException
   {
	
	return coreCommonProcedureDAO.updateFxDeals(trxMgntFxDealSC);
   }

   //id:924759 Details:JAVA error upon selecting account - Transaction  falha
    @Override
    public int callFillAccRestricted(AccountSC criteria) throws BaseException
    {
	// Habib Baalbaki accocunt restriction 372747
	try
	{
	    if(commonLibBO.returnIsSybase() == 1)
	    {
		coreCommonProcedureDAO.createACC_RESTRICTION_TEMP(criteria);
	    }
	}
	catch(BaseException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return coreCommonProcedureDAO.callFillAccRestricted(criteria);
    }

    // id:924759 Details:JAVA error upon selecting account - Transaction
    public void createACC_RESTRICTION_TEMP(AccountSC criteria) throws BaseException
    {
	try
	{
	    if(commonLibBO.returnIsSybase() == 1)
	    {
		coreCommonProcedureDAO.createACC_RESTRICTION_TEMP(criteria);
	    }
	}
	catch(BaseException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    // added by nancy -- 17/07/2018-- 382769-- account limits
    public void accLimitValidationChecking(AccountSC accountSC) throws BaseException
    {
	coreCommonProcedureDAO.accLimitValidationChecking(accountSC);
    }
    // end nancy

    // Hussein Elhajj-AUBBH170058
    public AccountSC recalculatePointsAccruals(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.recalculatePointsAccruals(accountSC);
    }

    // MajdHaidar 1/11/2018
    @Override
    public AccountSC callCheckAccountData(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.callCheckAccountData(accountSC);
    }
    
    @Override
    public ChequeBookSC callCheckChequeBookData(ChequeBookSC chequeBookSC) throws BaseException
    {
	return coreCommonProcedureDAO.callCheckChequeBookData(chequeBookSC);
    }

    /**
     * @author RaniaAlBitar DB150021 Maisarah Credit Card
     */

    public TrxMgntSC callFmsFillShadowAccount(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callFmsFillShadowAccount(trxMgntSC);
    }

    /**
     * @author RaniaAlBitar DB170108 - Advance profit payment
     */

    public AccountsManagementCO callPcsGetAdvanceAmount(AccountsManagementCO accountsManagementCO) throws BaseException
    {
	return coreCommonProcedureDAO.callPcsGetAdvanceAmount(accountsManagementCO);
    }


	       
    public CifSC callCheckFomData(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.callCheckFomData(cifSC);
    }
	       
	       
    /**
     * @author RaniaAlBitar DB140075 - Customer wants to close the General
     *         Account - R14.1.1
     */
    public TrxMgntSC getOverdrawLimit(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getOverdrawLimit(trxMgntSC);
    }

    public TrxMgntSC getInvstBal(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getInvstBal(trxMgntSC);
    }

    /**
     * @author RaniaAlBitar AIBBI180340 - SBI170029 - Excess Over Limit
     * @param accountsManagementCO
     * @return
     * @throws BaseException
     */

    public AccountsManagementCO callFmsGetOverDraftLimit(AccountsManagementCO accountsManagementCO) throws BaseException
    {
	return coreCommonProcedureDAO.callFmsGetOverDraftLimit(accountsManagementCO);
    }

    /**
     * @author raniaalbitar 718813 - Dynamic Customer Scoring on latest
     */
    public CustSegmentationSC runTrialScoringProcess(CustSegmentationSC custSegmentationSC) throws BaseException
    {
	return coreCommonProcedureDAO.runTrialScoringProcess(custSegmentationSC);
    }
	       
    /**
     * @author raniaalbitar Customers Segmentation
     * @param segmentGroupingSC
     * @return
     * @throws BaseException
     */
    public SegmentGroupingSC runAlertSegmentGrouping(SegmentGroupingSC segmentGroupingSC) throws BaseException
    {
	return coreCommonProcedureDAO.runAlertSegmentGrouping(segmentGroupingSC);
    }

	   	
    @Override
    public CustSegmentationSC runAlertSegmentation(CustSegmentationSC custSegmentationSC) throws BaseException
    {
	return coreCommonProcedureDAO.runAlertSegmentation(custSegmentationSC);
    }
    
    @Override
    public SpecialConditionsSC callCheckSpCondData(SpecialConditionsSC criteria) throws BaseException
    {
	return coreCommonProcedureDAO.callCheckSpCondData(criteria);
    }

	       
    public TrxMgntSC insertCTSTRSDET(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.insertCTSTRSDET(trxMgntSC);
    }
	       
    @Override
    public TrxMgntSC callFillBillReport(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callFillBillReport(trxMgntSC);
    }

    @Override
    public TrxMgntSC commonPosting(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.commonPosting(trxMgntSC);
    }

    public TrxMgntSC processInvPoints(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.processInvPoints(trxMgntSC);
    }

    // Hala Al Sheikh - ABSAI180070
    public CifSC callChecksumDigit(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.callChecksumDigit(cifSC);
    }

    /**
     * @author RaniaAlBitar ABSAI180073
     */
    public FomCO executeScoringProcess(FomCO fomCO) throws BaseException
    {
	fomCO = coreCommonProcedureDAO.executeScoringProcess(fomCO);

	return fomCO;
    }

    // Hala Al Sheikh - ABEI180106
    public CardsManagementSC callFMSGenerateDrwDwn(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.callFMSGenerateDrwDwn(cardsManagementSC);
    }

    /**
     * @author HusseinElHajj
     * ABAR130131 - NANTISSEMENT DES BONS DE CAISSES
     */
    public TrxMgntSC checkCollateralizedCD(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkCollateralizedCD(trxMgntSC);
    }

    @Override
    public FomSC createPkgSms(FomSC fomSC) throws BaseException
    {
	return coreCommonProcedureDAO.createPkgSms(fomSC);
    }

    public AccountCO wrapSpecialCondition(AccountCO accountCO) throws BaseException
    {
	return coreCommonProcedureDAO.wrapSpecialCondition(accountCO);
    }

    public TrxMgntCO pcsWrapAnniversaryAccDep(TrxMgntCO trxMgntCO) throws BaseException
    {
	return coreCommonProcedureDAO.pcsWrapAnniversaryAccDep(trxMgntCO);
    }
    
    //Hala Al Sheikh - SBI170059 SBI170060 
    public AccountsManagementCO callFmsWrapGetMosharakaDetails(AccountsManagementCO accountsManagementCO) throws BaseException
    {
	return coreCommonProcedureDAO.callFmsWrapGetMosharakaDetails(accountsManagementCO);	    
    }
    //Hala Al Sheikh - SBI190010
    public TrxMgntSC returnCheckAllowedCYs(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.returnCheckAllowedCYs(trxMgntSC);
    }

    // Hala Al Sheikh - AMANA160055
    public TrxMgntSC callAtmInsertCeftsTrf(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callAtmInsertCeftsTrf(trxMgntSC);
    }

    // modified by nancy - 28/09/2017-568160-AMANA170089-CEFTS- Phase II- Direct Debit
    @Override
    public TrxMgntSC balanceSettlement(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.balanceSettlement(trxMgntSC);
    }
    
    @Override
    public CifSC callCheckValidateFomData(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.callCheckValidateFomData(cifSC);
    }
    
    /**
     * @author eliasaoun
     * @modif : 809432 - PBSS170049
     * this method creates #ALRT_FILL_DETAILS_TMP
     */
    public Integer createAlertFillDetailsTemp() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    return coreCommonProcedureDAO.createAlertFillDetailsTemp("");
	}
	return 0;
    }
    

    /**
     * @author eliasaoun
     * @modif : 809432 - PBSS170049
     * this method creates #ALRT_FILL_DETAILS_TMP
     */
    public Integer dropAlertFillDetailsTemp() throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    return coreCommonProcedureDAO.dropAlertFillDetailsTemp("");
	}
	return 0;
    }
    

    public TrxMgntSC callCheckRecRemittanceData(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callCheckRecRemittanceData(trxMgntSC);
    }
    // end nancy 
    public AccountsManagementCO retRestrictAccCifCreate(AccountsManagementCO accountsManagementCO) throws BaseException
    {
	return coreCommonProcedureDAO.retRestrictAccCifCreate(accountsManagementCO);
    }   
    
    public AccountCO retApiCreateAccount(AccountCO accountCO) throws BaseException
    {
	return coreCommonProcedureDAO.retApiCreateAccount(accountCO);
    }
    
    public AccountCO wrapCoreGetVatDetails(AccountCO accountCO) throws BaseException
    {
	return coreCommonProcedureDAO.wrapCoreGetVatDetails(accountCO);
    }  
    //Hala Al Sheikh - BMO180327
    public CardsManagementCO returnFMSWrapGetCardFacDet(CardsManagementCO cardsManagementCO) throws BaseException
    {
    	return coreCommonProcedureDAO.returnFMSWrapGetCardFacDet(cardsManagementCO);
    }
    
	@Override
	public TransferEntitySC callP_FMS_WRAP_REPLACE_RLN_MGR(TransferEntitySC transferEntitySC) throws BaseException
	{
		return coreCommonProcedureDAO.callP_FMS_WRAP_REPLACE_RLN_MGR(transferEntitySC);
	} 

    @Override
    public TrxMgntSC getTransactionAccount(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.getTransactionAccount(trxMgntSC);
    }
    public TrxMgntSC getCheckIdVal(TrxMgntSC trxMgntSC) throws BaseException //Hala Al Sheikh - AIB100209
    {
	return coreCommonProcedureDAO.getCheckIdVal(trxMgntSC);
    }

    @Override
    public CifSC fillTablesITR(CifSC cifSC) throws BaseException
    {
	return coreCommonProcedureDAO.fillTablesITR(cifSC);
    }

    @Override
    public CardsManagementCO returnCardEnquiryExt(CardsManagementCO cardsManagementCO) throws BaseException
    {
	if(commonLibBO.returnIsSybase() == 1)
	{
	    cardsManagementCO.setIsOracle(0);
	}
	else
	{ 
	    cardsManagementCO.setIsOracle(1);
	}
	return coreCommonProcedureDAO.returnCardEnquiryExt(cardsManagementCO);
    }

    @Override
    public AccountSC callGetAmfBalanceFC(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.callGetAmfBalanceFC(accountSC);
    }

    @Override
    public TrxMgntSC callInsertCtstrs(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callInsertCtstrs(trxMgntSC);
    }

    @Override
    public TrxMgntSC callAccEntry(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callAccEntry(trxMgntSC);
    }

    @Override
    public TrxMgntSC callConvertTrsAmount(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.callConvertTrsAmount(trxMgntSC);
    }
    
    public TrxMgntSC callCtsCtrTimeout(TrxMgntSC trxMgntSC) throws DAOException
    {
	return coreCommonProcedureDAO.callCtsCtrTimeout(trxMgntSC);
    }
    
    @Override
    public TrxMgntSC retInsertStatus(TrxMgntSC trxMgntSC) throws DAOException
    {
	return coreCommonProcedureDAO.retInsertStatus(trxMgntSC);
    }

    @Override
    /**
     * This procedure was created as a wrapper to call the Unified charges calculation Procedure P_RET_GET_CHARGES_UNIFIED and return the 
    				desired output based on previous procedures that IB were calling.
     */
    public TrxMgntChargesSC retIbChargeUnified(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.retIbChargeUnified(trxMgntChargesSC);
    }

    @Override
    /**
     * call P_RET_PROCESS_HOF_WITH_CHARGE for STerling webservie
     */
    public TrxMgntChargesSC retProcessHofWithCharge(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.retProcessHofWithCharge(trxMgntChargesSC);
    }
    
    @Override
    public TrxMgntSC createStandingOrder(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.createStandingOrder(trxMgntSC);
    }
    
    public TransferCashSC checkVaultRemittance(TransferCashSC transferCashSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkVaultRemittance(transferCashSC);
    }
    
    @Override
    public TrxMgntSC checkDataLostFound(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkDataLostFound(trxMgntSC);
    }

    @Override
    public TrxMgntSC checkDataTransferAccount(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkDataTransferAccount(trxMgntSC);
    }

    @Override
    public DuesManagementSC checkDataDuesMgnt(DuesManagementSC duesManagementSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkDataDuesMgnt(duesManagementSC);
    }
    
    public void commitTrans() throws BaseException
    {
	coreCommonProcedureDAO.commitTrans();
    }

    @Override
    public TrxMgntSC collectRemittance(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.collectRemittance(trxMgntSC);
    }

    @Override
    public TrxMgntSC createRemittance(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.createRemittance(trxMgntSC);
    }

    @Override
    public TrxMgntSC createChequeDeposit(TrxMgntSC trxMgntSC) throws BaseException
    {
	return coreCommonProcedureDAO.createChequeDeposit(trxMgntSC);
    }
    
    public TrxMgntChargesSC checkHOFSpecialConditions(TrxMgntChargesSC trxMgntChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.checkHOFSpecialConditions(trxMgntChargesSC);
    }
    
    /**
     * @author HusseinElhajj
     * Segmentation
     */
    public AccountChargesSC saveSegmetationCharges(AccountChargesSC accountChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.saveSegmentationCharges(accountChargesSC);
    }
	
    /**
     * @author HusseinElhajj
     * Segmentation
     */
	
    public AccountChargesSC retrieveSegCharges(AccountChargesSC accountChargesSC) throws BaseException
    {
	return coreCommonProcedureDAO.retrieveSegCharges(accountChargesSC);
    }
    
    public CustSegmentationSC executeSegmentationProcess(CustSegmentationSC custSegmentationSC) throws BaseException
    {
	return coreCommonProcedureDAO.executeSegmentationProcess(custSegmentationSC);
    }
    
    public FOMRealBeneficiariesCO updateRealBenefRecords(FOMRealBeneficiariesCO fomRealBeneficiariesCO) throws BaseException
    {
	return coreCommonProcedureDAO.updateRealBenefRecords(fomRealBeneficiariesCO);
    }
    
    public void callIncidentReportAlertProcedure(IncidentReportSC incidentReportSC) throws BaseException
    {
	coreCommonProcedureDAO.callIncidentReportAlertProcedure(incidentReportSC);
    }

    @Override
    public TrxMgntSC processSuspenseAccount(TrxMgntSC trxMgntSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return null;
    }
    
    //Hala Al Sheikh - NBINT130004
    public AccountSC callCheckCertificateData(AccountSC accountSC) throws BaseException
    {
	return coreCommonProcedureDAO.callCheckCertificateData(accountSC);
    }

    // added by nancy - 06/02/2018-613993-DASI180012 - Procedure on Certificate
    public TrxMgntSC checkCertificateCreation(TrxMgntSC trxMgntSC)throws BaseException
    {
	return coreCommonProcedureDAO.checkCertificateCreation(trxMgntSC);
    }
    // end nancy

}
