package com.path.dao.common.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.vo.core.transferentity.TransferEntitySC;
import com.path.bo.common.ConstantsCommon;
import com.path.vo.core.chargesrefund.ChargesRefundSC;
import com.path.dao.common.CoreCommonProcedureDAO;
import com.path.dbmaps.vo.IBISCOUNTERVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
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



public class CoreCommonProcedureDAOImpl extends BaseDAO implements CoreCommonProcedureDAO
{
    /**
     * Create Transaction Hash tables
     */
    public void createTrxHashTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createTrxHashTables", sybOra);

    }

    /**
     * Drop Transaction Hash tables
     */
    public void dropTrxHashTables(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropTrxHashTables", sybOra);
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

    public void createBatchProcessHashTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all BAtch before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createBatchProcessHashTables", sybOra);
	
    }
    
    public void dropBatchProcessHashTables(String sybOra) throws DAOException
    {
	try
	{
	    /*
	     * Commit all BAtch before so that creation of hash table passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropBatchProcessHashTables", sybOra);
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
    
    public void createBatchValidHashTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all BAtch before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createBatchValidHashTables", sybOra);
	
    }
    
    public void dropBatchValidHashTables(String sybOra) throws DAOException
    {
	try
	{
	    /*
	     * Commit all BAtch before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropBatchValidHashTables", sybOra);
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
     * Create FOM Hash tables
     * @author nabilfeghali
     */
    public void createFOMHashTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all FOM before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createFOMHashTables", sybOra);

    }

    /**
     * Drop FOM Hash tables
     * @author nabilfeghali
     */
    public void dropFOMHashTables(String sybOra)
    {
	try
	{
	    /*
	     * Commit all FOM before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropFOMHashTables", sybOra);
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
     * Create Hash table #stand_order
     */
    public void createHashStandOrder(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	
	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createSTAND_ORDER", sybOra);
	
    }
    
    /**
     * Create Hash table #CTS_CHARGES_UNIFIED
     */
    public void createHashCtsChargesUnified(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	
	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createCTS_CHARGES_UNIFIED", sybOra);
	
    }
    
    /**
     * Create Hash table #ECC_ARGUMENTS
     */
    public void createHashEccArguments(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	
	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createECC_ARGUMENTS", sybOra);
	
    }
    
    /**
     * Drop Hash table #stand_order
     */
    public void dropHashStandOrder(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropSTAND_ORDER", sybOra);
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
     * Drop Hash table #CTS_CHARGES_UNIFIED
     */
    public void dropHashCtsChargesUnified(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropCTS_CHARGES_UNIFIED", sybOra);
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
     * Drop Hash table #ECC_ARGUMENTS
     */
    public void dropHashEccArguments(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropECC_ARGUMENTS", sybOra);
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
     * This function calls the procedure P_RET_APPROVE_CHQBOOK where the
     * chequebook related is approved
     * 
     * @param chequeBookCO
     * @return
     * @throws DAOException
     */
    public ChequeBookSC approveChequebook(ChequeBookSC chequeBookSC, String sybOra) throws DAOException
    {
//	if("S".equals(sybOra))
//	{
//	    /*
//	     * Commit all trans before so that creation of hash table passes
//	     */
//	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
//
//	    try
//	    {
//		getSqlMap().update("coreCommonProcedureMapper.dropSTAND_ORDER", chequeBookSC);
//	    }
//	    catch (Throwable e) 
//	    {
//		log.info("[approveChequebook] DROP STAND_ORDER : table does not exist ");
//	    }
//	    /*
//	     * Create Hash table
//	     */
//	    getSqlMap().update("coreCommonProcedureMapper.createSTAND_ORDER", chequeBookSC);
//	}

	/*
	 * Call Procedure
	 */
	insertTempSessionDetails(chequeBookSC.getUserLang());
	
	getSqlMap().update("coreCommonProcedureMapper.approveChequebook", chequeBookSC);


//	if("S".equals(sybOra))
//	{
//	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
//	    /*
//	     * Drop Hash Table
//	     */
//	    try
//	    {
//		getSqlMap().update("coreCommonProcedureMapper.dropSTAND_ORDER", chequeBookSC);
//	    }
//	    catch (Throwable e) 
//	    {
//		log.info("[approveChequebook] DROP STAND_ORDER : table does not exist ");
//	    }
//	    
//	}
	chequeBookSC.setErrorMessage(StringUtil.replaceProcedureMessage(chequeBookSC.getErrorMessage()));

	return chequeBookSC;
    }
    
    public ChequeBookSC chqbookBatchApprovePrcs(ChequeBookSC chequeBookSC) throws DAOException
    {	
	insertTempSessionDetails(chequeBookSC.getLang(), chequeBookSC.getRunningDate(), chequeBookSC.getUserName(), chequeBookSC.getAppName());
	getSqlMap().update("coreCommonProcedureMapper.chqbookBatchApprovePrcs", chequeBookSC);
	chequeBookSC.setErrorMessage(StringUtil.replaceProcedureMessage(chequeBookSC.getErrorMessage()));
	return chequeBookSC;
    }

    /**
     * This method calls procedure P_RET_CHECK_TRANS_DATA to check data before
     * submitting transactions
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC checkTransData(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    // NABIL FEGHALI - ABARI120067
//	    insertTempSessionDetails(trxMgntSC.getLangCode(),trxMgntSC.getUserId());
	    // NABIL FEGHALI - END - ABARI120067
	    insertTempSessionDetails(trxMgntSC.getLangCode(), trxMgntSC.getRunningDate(), trxMgntSC.getUserId(), trxMgntSC
			.getAppName());
	   
	    getSqlMap().update("coreCommonProcedureMapper.checkTransData", trxMgntSC);

	    // return the Message by Eliminating Procedures Names
	    // between <# and #>
	    if(trxMgntSC.getErrorMessage() != null)
	    {
		trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    }
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_CHECK_TRANS_DATA " + e.getMessage(),e);
	}
    }
    
    /**
     * checkDataCards
     * @param cardsManagementSC
     * @return cardsManagementSC
     * @throws DAOException
     */
    public CardsManagementSC checkDataCards(CardsManagementSC cardsManagementSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.callProcCardsCheckData", cardsManagementSC);
	    cardsManagementSC.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementSC.getErrorMessage()));
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_CHECK_DATA_CTSCARDS " + e.getMessage(),e);
	}
	return cardsManagementSC;
    }

    /**
     * This method calls procedure P_TODO_GET_USER_JOB_COUNTER to insert data
     * before
     * 
     * 
     * @param alertsSC
     * @return alertsSC
     * @throws DAOException
     */

    public AlertsSC getToDoDet(AlertsSC alertsSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.getToDoDet", alertsSC);
	    return alertsSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_TODO_GET_USER_JOB_COUNTER " + e.getMessage(),e);
	}
    }

    /**
     * This method calls procedure P_RET_PROCESS_CTSTRS to create and approve
     * transactions
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC processCtstrs(TrxMgntSC trxMgntSC, String sybOra) throws DAOException
    {
	try
	{
//	    insertTempSessionDetails(trxMgntSC.getLangCode(), trxMgntSC.getSystemDate());
	    //Jihane Bug #210919
	    insertTempSessionDetails(trxMgntSC.getLangCode(), trxMgntSC.getSystemDate(), trxMgntSC.getUserId(), trxMgntSC.getAppName());
	    
	    getSqlMap().update("coreCommonProcedureMapper.processCtstrs", trxMgntSC);

	    //return the Message by Eliminating Procedures Names between <# and #>
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_PROCESS_CTSTRS " + e.getMessage(),e);
	}
    }
    /**
     * This method calls procedure P_N_TRX_INSERTDOF to insert DOF entries
     * @author guittaabougharrach
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC insertDof(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    insertTempSessionDetails(trxMgntSC.getLangCode());
	    getSqlMap().update("coreCommonProcedureMapper.insertDof", trxMgntSC);
	    //return the Message by Eliminating Procedures Names between <# and #>
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_N_TRX_INSERTDOF " + e.getMessage(),e);
	}
    }
    /**
     * This method calls procedure P_RET_GAINLOSS_DENOM to insert GAIN/LOSS CHARGE TO CTSCHARGES_UNIFIED
     * @author Hasan ghrayeb
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException 
     */
    public TrxMgntSC InsertNewGainlossRecord(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.InsertNewGainlossRecord", trxMgntSC);
	    //return the Message by Eliminating Procedures Names between <# and #>
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	 catch(Exception e)
	{
	     throw new DAOException("Error in P_RET_CHARGES_GAINLOSS_DENOM " + e.getMessage(),e);
	}
	 
    }
    
    
    
    /**
     * This method calls procedure P_N_TRX_REVERSEDOF to insert DOF entries
     * @author guittaabougharrach
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException 
     */
    public TrxMgntSC reverseDof(TrxMgntSC trxMgntSC) throws DAOException
    {
	
	try
	{
	    insertTempSessionDetails(trxMgntSC.getLangCode());
	    getSqlMap().update("coreCommonProcedureMapper.reverseDof", trxMgntSC);
	    //return the Message by Eliminating Procedures Names between <# and #>
	    //#499326, trim unneeded empty space returned from procedure
	    trxMgntSC.setErrorMessage( StringUtil.replaceProcedureMessage(StringUtil.nullToEmpty(trxMgntSC.getErrorMessage())));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_N_TRX_REVERSEDOF " + e.getMessage(),e);
	}
    }

    /**
     * This method calls procedure P_RET_ENTRIES to insert entries in CTSTRSDET
     * @author guittaabougharrach
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC retailEntries(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    insertTempSessionDetails(trxMgntSC.getLangCode());
	    getSqlMap().update("coreCommonProcedureMapper.retailEntries", trxMgntSC);
	    //return the Message by Eliminating Procedures Names between <# and #>
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_ENTRIES " + e.getMessage(),e);
	}
    }

    /**
     * This method calls procedure P_RET_REVERSE_CTSTRS to reverse,cancel or
     * void transactions for different transaction types
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC reverseCtstrs(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.reverseCtstrs", trxMgntSC);
	    //return the Message by Eliminating Procedures Names between <# and #>
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_REVERSE_CTSTRS " + e.getMessage(),e);
	}
    }

    public TrxMgntSC callProcVisaLaunchProcess(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    insertTempSessionDetails(trxMgntSC.getLangCode());
	    getSqlMap().update("coreCommonProcedureMapper.callProcVisaLaunchProcess", trxMgntSC);
	    //return the Message by Eliminating Procedures Names between <# and #>
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_PROCESS_VISA " + e.getMessage(),e);
	}
    }
    
    
    public void updateCifNames(NCifMaintenanceSC nCifMaintenanceSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.updateCifNames", nCifMaintenanceSC);

	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_UPDATECIFNAMES " + e.getMessage(),e);
	}

    }

    public AccountPositionCO viewAccPosition(AccountPositionCO accountPositionCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.viewAccPosition", accountPositionCO);
	accountPositionCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountPositionCO.getErrorMsg()));
	return accountPositionCO;
    }

    public BigDecimal returnAvlBalBR(AccountPositionCO accountPositionCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnAvlBalBR", accountPositionCO);
	return accountPositionCO.getAvailBalance();
    }

    /**
     * This function calls the procedure P_SPECIAL_CONDITIONS_DET where the checking on special conditions is done
     * @param accountCO
     * 		amfVO.COMP_CODE			COMPANY CODE
     * 		amfVO.BRANCH_CODE		BRANCH CODE OF THE ACCOUNT
     * 		amfVO.CURRENCY_CODE		CURRENCY CODE OF THE ACCOUNT
     * 		amfVO.GL_CODE			GL CODE OF THE ACCOUNT
     * 		amfVO.CIF_SUB_NO		CIF OF THE ACCOUNT
     * 		amfVO.SL_NO			SL NO OF THE ACCOUNT
     * 		cifVO.CIF_NO			CIF NUMBER
     * 		cifacc				CONDITION TYPE: 'A' IF ACCOUNT OR 'C' IF CIF
     * 	@return	accountCO
     * 		FORBID_TRX			FORBID_TRX FIELD, SHOWS WHAT TO FORBID OR RESTRICT 
     * 		FORBID_PRODUCT			FORBID_PRODUCT FIELD, SHOWS IF FORBIDDING A PRODUCT SUCH AS CHEQUEBOOK 
     * 		reasonEng			OUTPUT - Reason Desc English
     * 		reasonAr			OUTPUT - Reason Desc Arabic
     * 		errorCode			OUTPUT - Error Code
     * 		errorMsg			OUTPUT - Error Text
     * @throws DAOException 
     */
    public AccountCO specialConditions(AccountCO accountCO) throws DAOException
    {
	insertTempSessionDetails(null, accountCO.getRunningDate());
	getSqlMap().update("coreCommonProcedureMapper.specialConditions", accountCO);
	accountCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountCO.getErrorMsg()));
	return accountCO;
    }

    public AccountPositionCO returnCoveringBalance(AccountPositionCO accountPositionCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnCoveringBalance", accountPositionCO);
	accountPositionCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountPositionCO.getErrorMsg()));
	return accountPositionCO;
    }

    /**
     *this method calls P_RET_VALIDATE_IBAN in order to validate IBAN Acc
     * 
     * @param trxMgntSC
     * @return TrxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC validateIBAN(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.validateIBAN", trxMgntSC);
	    //return the Message by Eliminating Procedures Names between <# and #>
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_VALIDATE_IBAN " + e.getMessage(),e);
	}
    }

    /**
     * in pb n_transaction.uf_get_rate returnRate.
     */
    public TrxMgntSC returnRate(TrxMgntSC trxMgntSC, String sybOra) throws DAOException
    {
	if("S".equals(sybOra))
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnRateForSyb", trxMgntSC);
	}
	else
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnRateForOracle", trxMgntSC);
	}
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * THIS FUNCTION RETURNS THE "M_RATE" From table EXCH_RAT for a specific
     * date, IF not found return 0
     * 
     * @param transferCashSC
     * @return TransferCashSC
     * @throws DAOException
     */
    public TransferCashSC getExChRate(TransferCashSC transferCashSC, String sybOra) throws DAOException
    {
	if("S".equals(sybOra))
	{
	    getSqlMap().update("coreCommonProcedureMapper.getExChRate", transferCashSC);
	}
	else
	{
	    getSqlMap().update("coreCommonProcedureMapper.getExChRateNew", transferCashSC);
	}
	transferCashSC.setErrorMessage(StringUtil.replaceProcedureMessage(transferCashSC.getErrorMessage()));

	return transferCashSC;
    }

    /**
     * This function returns the error code and error type if exists in pb
     * uf_check_teller_limits
     * 
     * @param transferCashSC
     * @return TransferCashSC
     * @throws DAOException
     */
    public TransferCashSC checkUserLimits(TransferCashSC transferCashSC) throws DAOException
    {
	insertTempSessionDetails(transferCashSC.getLanguage());
	getSqlMap().update("coreCommonProcedureMapper.checkUserLimits", transferCashSC);
	transferCashSC.setErrorMessage(StringUtil.replaceProcedureMessage(transferCashSC.getErrorMessage()));
	return transferCashSC;
    }


    /**
     * This method calculates the first payment date and the ending date for SO
     * 
     * @param trxMgntSoDetSC
     * @return TrxMgntSoDetSC
     * @throws DAOException
     */
    public TrxMgntSoDetSC calculateSoDates(TrxMgntSoDetSC trxMgntSoDetSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.calculateSoDates", trxMgntSoDetSC);
	    return trxMgntSoDetSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_CALCULATE_SO_DATES " + e.getMessage(),e);
	}
    }

    /**
     * checkAmntRestriction.
     * 
     * @param criteria
     * @return TrxMgntSC.
     * @throws DAOException
     */
    public TrxMgntSC checkAmntRestriction(TrxMgntSC criteria) throws DAOException
    {
      if(NumberUtil.isEmptyDecimal(criteria.getOverDrawnAmountFr()))
      {
          criteria.setOverDrawnAmountFr(BigDecimal.ZERO.setScale(6));
      }
      else
      {
          criteria.setOverDrawnAmountFr(criteria.getOverDrawnAmountFr().setScale(6));
      }
      if(NumberUtil.isEmptyDecimal(criteria.getOverDrawnAmountTo()))
      {
	  criteria.setOverDrawnAmountTo(BigDecimal.ZERO.setScale(6));
      }
      else
      {
	  criteria.setOverDrawnAmountTo(criteria.getOverDrawnAmountTo().setScale(6));
      }
 
      if(NumberUtil.isEmptyDecimal(criteria.getAccAmount()))
      {
          criteria.setAccAmount(BigDecimal.ZERO.setScale(3));
      }
      else
      {
          criteria.setAccAmount(criteria.getAccAmount().setScale(3));
      }
      if(NumberUtil.isEmptyDecimal(criteria.getTrxAmount()))
      {
          criteria.setTrxAmount(BigDecimal.ZERO.setScale(3));
      }
      else
      {
          criteria.setTrxAmount(criteria.getTrxAmount().setScale(3));
      }
      
	/*
	 * jihane TP83062 BB110236
	 * Call insertTempSessionDetails method to insert language, user id,
	 * application name.. into TEMP_SESSION_DETAILS
	 */
	insertTempSessionDetails(criteria.getLangCode(), criteria.getRunningDate(), criteria.getUserId(), criteria
		.getAppName());
	
	String versionCode = StringUtil.nullToEmpty(criteria.getVersionCode());
	getSqlMap().update("coreCommonProcedureMapper" + versionCode + ".checkAmntRestriction" + versionCode, criteria);
	// return the Message by Eliminating Procedures Names between <# and #>
      criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
      return criteria;
    }

    /**
     * This function returns the VAT details relating to the charge in pb
     * f_get_vat_amount
     * 
     * @param transferCashSC
     * @return TransferCashSC
     * @throws DAOException
     */
    public TrxMgntSC getTVADetails(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getTVADetails", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * This function returns the Exchange Rate Flag to know which rate to use in
     * pb n_retail_rate.uf_set_exchrate_type
     * 
     * @param transferCashSC
     * @return TransferCashSC
     * @throws DAOException
     */
    public TrxMgntSC getExchrateFlag(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getExchrateFlag", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * This function returns the Cross Rate in pb P_RET_GET_CROSS_RATE_COVER
     * 
     * @param transferCashSC
     * @return TransferCashSC
     * @throws DAOException
     */
    public TrxMgntSC getCrossRateCover(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getCrossRateCover", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    public TrxMgntSC getCvAmount(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getCvAmount", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * This function returns the Charges Details in pb P_RET_GET_CHARGES_DETAILS
     * 
     * @param trxMgntChargesSC
     * @return trxMgntChargesSC
     * @throws DAOException
     */
    public TrxMgntChargesSC getChargesDetails(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getChargesDetails", trxMgntChargesSC);
	
	/*
	 * Clean Return Values
	 */
	if(trxMgntChargesSC != null)
	{
	    trxMgntChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntChargesSC.getErrorMessage()));
	    /*
	     * Remove Trailing Zeroes in error Code
	     */
	    if(trxMgntChargesSC.getError() != null)
	    {
		trxMgntChargesSC.setError(new BigDecimal(trxMgntChargesSC.getError().stripTrailingZeros().doubleValue()));
	    }
	}
	
	return trxMgntChargesSC;
    }

    public TrxMgntChargesSC returnProductCharges(TrxMgntChargesSC criteria) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnProductCharges", criteria);
	criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
	return criteria;
    }

    /**
     * This function returns the Cross Rate in pb P_RET_CHECK_USER_MINMAX_BAL
     * 
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC checkUserMinMaxBal(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkUserMinMaxBal", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
  //#795165 Branches cash limit monitoring [MFALHA]
    public TrxMgntSC checkBranchCashLimit(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkBranchCashLimit", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
  //#795165 Branches cash limit monitoring [MFALHA]


    public TrxMgntSC checkHouseChequeData(TrxMgntSC trxMgntSC) throws DAOException
    {
	//NABIL FEGHALI - ABARI120067
	insertTempSessionDetails(trxMgntSC.getLangCode());
	//NABIL FEGHALI - END - ABARI120067
	getSqlMap().update("coreCommonProcedureMapper.checkHouseChequeData", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * ths procedure is used to populat cif to others companies.
     */
    public void populateCif(PopulateCifSC populateCifSC) throws DAOException
    {
	try
	{
	    //In uo_back_end_procedure.populate_cif the sqlca.Autocommit = True 
	    //before calling the populate procedure and then set to false after
	    getSqlMap().setAutoCommit(true);
	    getSqlMap().update("coreCommonProcedureMapper.populateCif", populateCifSC);
	    getSqlMap().setAutoCommit(false);
	    
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_updateCifNames"+e.getMessage(),e);
	}

    }

    /**
     * This function returns the CV balance and FC balance P_GET_BF_BALANCE
     * 
     * @param StatementOfAccountsCO
     * @return StatementOfAccountsCO
     * @throws DAOException
     */
    public AccountCommonCO getBFBalance(AccountCommonCO accountCommonCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getBFBalance", accountCommonCO);
	return accountCommonCO;
    }

    public TrxMgntSC returnClosingTime(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnClosingTime", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * in uf_get_rate the common one P_RET_GET_RATE_NORMAL
     */
    public TrxMgntSC returnRateNormal(TrxMgntSC trxMgntSC) throws DAOException
    {
	 //Bug # 338150 -- [John Massaad] -- insertTempSessionDetailsin order to translate messages return by this procedure
        insertTempSessionDetails(trxMgntSC.getLangCode(), trxMgntSC.getSystemDate(), trxMgntSC.getUserId(),
            trxMgntSC.getAppName());
        //Bug # 338150
	getSqlMap().update("coreCommonProcedureMapper.returnRateNormal", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * in PB common wf_get_amount_in_base_cy in currency exchange This method
     * calls procedure P_RET_GET_AMT_TELLER_EXCH
     */
    public TrxMgntSC returnAmountByRateForTellerExch(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnAmountByRateForTellerExch", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * THIS METHOD CALLS P_FILL_CTSTRS_UPLOAD_TMP 
     * @PARAM USERID , COMPCODE , BRANCHCODE ,BATCHNO ,FILETYPE ,ISMULTITRSFRSGLROW
     */     
    public CtstrsUploadSC callProcFillTmpCtstrsUpload(CtstrsUploadSC ctstrsUploadSC) throws DAOException
    { 
      //insertTempSessionDetails("AR"); 
	insertTempSessionDetails(ctstrsUploadSC.getLanguage(), ctstrsUploadSC.getRunningDate(), ctstrsUploadSC
		.getUserId(), ctstrsUploadSC.getCurrAppName());
	getSqlMap().update("coreCommonProcedureMapper.fillTmpCtstrsUpload", ctstrsUploadSC);
	ctstrsUploadSC.setErrorMessage(StringUtil.replaceProcedureMessage(ctstrsUploadSC.getErrorMessage()));
	return ctstrsUploadSC;
    }

    /**
     * THIS METHOD CALLS P_BATCH_LAUNCH_PROCESS
     * 
     * @PARAM USERID , COMPCODE , BRANCHCODE ,BATCHNO ,FILETYPE
     *        ,ISMULTITRSFRSGLROW
     */
    public CtstrsUploadSC callProcBatchLaunchProcess(CtstrsUploadSC ctstrsUploadSC) throws DAOException
    {

	// insertTempSessionDetails(ctstrsUploadSC.getLanguage());
	insertTempSessionDetails(ctstrsUploadSC.getLanguage(), ctstrsUploadSC.getRunningDate(),
		ctstrsUploadSC.getUserId(), ctstrsUploadSC.getCurrAppName());
	getSqlMap().update("coreCommonProcedureMapper.CallProcBatchLaunchProcess", ctstrsUploadSC);
	ctstrsUploadSC.setErrorMessage(StringUtil.replaceProcedureMessage(ctstrsUploadSC.getErrorMessage()));
	return ctstrsUploadSC;
    }

    public CtstrsUploadSC callProcBatchDeleteRecords(CtstrsUploadSC ctstrsUploadSC) throws DAOException
    {
	// insertTempSessionDetails(ctstrsUploadSC.getLanguage());
	insertTempSessionDetails(ctstrsUploadSC.getLanguage(), ctstrsUploadSC.getRunningDate(),
		ctstrsUploadSC.getUserId(), ctstrsUploadSC.getCurrAppName());
	getSqlMap().update("coreCommonProcedureMapper.CallProcBatchDeleteRecords", ctstrsUploadSC);
	ctstrsUploadSC.setErrorMessage(StringUtil.replaceProcedureMessage(ctstrsUploadSC.getErrorMessage()));
	return ctstrsUploadSC;

    }

    public TrxMgntSC returnRetVDate(TrxMgntSC trxMgntSC) throws DAOException
    {
	String versionCode = StringUtil.nullToEmpty(trxMgntSC.getVersionCode());
	getSqlMap().update("coreCommonProcedureMapper"+versionCode+".returnRetVDate"+versionCode, trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    public TrxMgntSC validateRemittance(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.validateRemittance", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    public TrxMgntSC moveFromTrsAlertToTrs(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.moveFromTrsAlertToTrs", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC updateRemittance(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.updateRemittance", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    /**
     * this method calls procedure P_RET_UPDATE_CHEQUE_STATUS and replaces n_transaction.uf_insert_cheque_status
     * @author guittaabougharrach
     * @param TrxMgntSC
     * @return TrxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC updateChequeStatus(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.updateChequeStatus", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * this procedure is used to get the additiona reference of account using the
     * P_API_GET_ADD_REF procedure
     * @param accountCommonCO
     * @return
     * @throws DAOException
     */
    public AccountCO returnAccountAdditionalReference(AccountCO accountCO) throws DAOException
    {
    	getSqlMap().update("coreCommonProcedureMapper.returnAccountAdditionalReference", accountCO);
    	accountCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountCO.getErrorMsg()));
	return accountCO;
    }
    
    public AccountCO createAccount(AccountCO accountCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.createAccount", accountCO);
	accountCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountCO.getErrorMsg()));
	return accountCO;
    }
    
    public BlackListSC fillCifSoundex(BlackListSC blackListSC) throws  DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.fillCifSoundex", blackListSC);
	blackListSC.setErrorMessage(StringUtil.replaceProcedureMessage(blackListSC.getErrorMessage()));
	return blackListSC;
    }
    
    public TrxMgntSC soChangestatusCharge(TrxMgntSC trxMgntSC) throws  DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.soChangestatusCharge", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    /**
     * Create Hash table #stand_order
     */
    public void createHashSoundex(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createSoundex", sybOra);

    }

    
    public void dropHashSoundex(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropSoundex", sybOra);
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

    
    public BlackListSC updateFillCifBlacklistMos(BlackListSC blackListSC) throws  DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.updateFillCifBlacklistMos", blackListSC);
	blackListSC.setErrorMessage(StringUtil.replaceProcedureMessage(blackListSC.getErrorMessage()));
	return blackListSC;
    }

    public CardsManagementSC returnCardsRefWithExpDate(CardsManagementSC cardsManagementSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnCardsRefWithExpDate", cardsManagementSC);
	cardsManagementSC.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementSC.getErrorMessage()));
	return cardsManagementSC;
    }

    public CardsManagementSC selectCardsMgntTmp(CardsManagementSC cardsManagementSC) throws DAOException
    {
	try {

	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	} catch (Exception e) 
	{
	    e.printStackTrace();
	}
	getSqlMap().update("coreCommonProcedureMapper.selectCardsMgntTmp", cardsManagementSC);
	cardsManagementSC.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementSC.getErrorMessage()));
	return cardsManagementSC;
    }

    public CardsManagementSC addCardsHistory(CardsManagementSC cardsManagementSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.addCardsHistory", cardsManagementSC);
	cardsManagementSC.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementSC.getErrorMessage()));
	return cardsManagementSC;
    } 
    
    public CardsManagementSC returnCardNo(CardsManagementSC cardsManagementSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnCardNo", cardsManagementSC);
	cardsManagementSC.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementSC.getErrorMessage()));
	return cardsManagementSC;
    } 
    
    public void closeAccount(AccountSC accountSC) throws DAOException
    {
	insertTempSessionDetails(accountSC.getLangCode());
	getSqlMap().update("coreCommonProcedureMapper.closeAccount", accountSC);
	accountSC.setWarningMessages(StringUtil.replaceProcedureMessage(accountSC.getWarningMessages()));
    }
    
    public void authorizeCloseAccount(AccountSC accountSC) throws DAOException
    {
	insertTempSessionDetails(accountSC.getLangCode());
	getSqlMap().update("coreCommonProcedureMapper.authorizeCloseAccount", accountSC);
	accountSC.setWarningMessages(StringUtil.replaceProcedureMessage(accountSC.getWarningMessages()));
    }
    
    public AccountSC checkUnclaimed(AccountSC accountSC) throws DAOException
    {
    	getSqlMap().update("coreCommonProcedureMapper.checkUnclaimed", accountSC);
    	accountSC.setWarningMessages(StringUtil.replaceProcedureMessage(accountSC.getWarningMessages()));
    	return accountSC;
    }


        
    public AccountSC callProcCheckCollguarantor(AccountSC accountSC) throws DAOException
    {
    	getSqlMap().update("coreCommonProcedureMapper.CallProcCheckCollguarantor", accountSC);
	accountSC.setWarningMessages(StringUtil.replaceProcedureMessage(accountSC.getWarningMessages()));
    	return accountSC;
    }
    
    /**
     * @author Chady.A
     * PB = p_ret_alert_card
     */
    public CardsManagementSC callAlertCtsCard(CardsManagementSC cardsManagementSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callAlertCtsCard", cardsManagementSC);
	cardsManagementSC.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementSC.getErrorMessage()));
	return cardsManagementSC;
    }
    
    public TransferCashSC callAlertSmsSubscription(TransferCashSC transferCashSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callAlertSmsSubscription", transferCashSC);
	transferCashSC.setErrorMessage(StringUtil.replaceProcedureMessage(transferCashSC.getErrorMessage()));
	return transferCashSC;
    }    
    /**
     * @author nabilfeghali
     * PB = P_RET_ALERT_CTSTRS
     */
    public TrxMgntSC callAlertCtsTrs(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().delete("coreCommonProcedureMapper.callAlertCtsTrs", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * f_release_ret_hof
     * p_ret_release_hof
     * @author nabilfeghali
     */
    public TrxMgntSC releaseHof(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.releaseHof", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    /**
     * in pb : n_transaction.uf_release_trans
     * p_ret_release_hof_with_charges
     * @author guittaabougharrach
     */
    public TrxMgntSC releaseHofWithCharges(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());
	getSqlMap().update("coreCommonProcedureMapper.releaseHofWithCharges", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * This function will call guo_back_end_proc.p_ret_alert_cif
     * 
     * @author nabilfeghali
     * @param cifSC
     * @return
     * @throws DAOException
     */
    public CifSC callAlertCif(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callAlertCif", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
    
    /**
     * This function will call guo_back_end_proc.p_ret_alert_amf
     * 
     * @author nabilfeghali
     * @param accountSC
     * @return
     * @throws DAOException
     */
    public AccountSC callAlertAmf(AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callAlertAmf", accountSC);
	accountSC.setWarningMessages(StringUtil.replaceProcedureMessage(accountSC.getWarningMessages()));
	return accountSC;
    }
    
    public MosBlackListSC fillSoundex(MosBlackListSC mosBlackListSC) throws  DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.fillSoundex", mosBlackListSC);
	mosBlackListSC.setErrorMessage(StringUtil.replaceProcedureMessage(mosBlackListSC.getErrorMessage()));
	return mosBlackListSC;
    }
    
    /**
     * this function added by jihadlamaa in order to create HOF transaction
     * @param trxMgntSC
     * @return
     * @throws DAOException
     */
    public TrxMgntSC createHoldOfFunds(TrxMgntSC trxMgntSC) throws  DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.createHoldOfFunds", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC authorizeClearingVoiding(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());
	getSqlMap().update("coreCommonProcedureMapper.authorizeClearingVoiding", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC addJvRet(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.addJvRet", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC checkSpecialConditions(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode(), trxMgntSC.getSystemDate());
	getSqlMap().update("coreCommonProcedureMapper.checkSpecialConditions", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * This function will call P_CHECK_BLACKLIST
     * @author nabilfeghali
     * @param blackListSC
     * @return
     * @throws DAOException
     */
    public BlackListSC checkBlackList(BlackListSC blackListSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkBlackList", blackListSC);
	blackListSC.setErrorMessage(StringUtil.replaceProcedureMessage(blackListSC.getErrorMessage()));
	return blackListSC;
    }
    
   
    
    public TrxMgntSC callProcRecalcForRelatedGl(TrxMgntSC trxMgntSC) throws  DAOException
    {      	       	  
	getSqlMap().update("coreCommonProcedureMapper.CallProcRecalcForRelatedGl", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC callProcPcsPftForRelatedGl(TrxMgntSC trxMgntSC) throws  DAOException
    {      	       	  
	getSqlMap().update("coreCommonProcedureMapper.CallProcPcsPftForRelatedGl", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC callProcPcsProfitDetail(TrxMgntSC trxMgntSC) throws  DAOException
    {      	       	  
	getSqlMap().update("coreCommonProcedureMapper.CallProcPcsProfitDetail", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    
    public TrxMgntSC callProcRetGetPenaltyDetail(TrxMgntSC trxMgntSC) throws  DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());
	
        if(NumberUtil.isEmptyDecimal(trxMgntSC.getADEC_RATE()))
        {
            trxMgntSC.setADEC_RATE(BigDecimal.ZERO.setScale(6));
        }
        else
        {
            trxMgntSC.setADEC_RATE(trxMgntSC.getADEC_RATE().setScale(6));
        } 
        
	getSqlMap().update("coreCommonProcedureMapper.CallProcRetGetPenaltyDetail", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC; 
    }
    
    
    public TrxMgntSC callProcGetPcsCharges(TrxMgntSC trxMgntSC) throws  DAOException
    {      	       	  
	getSqlMap().update("coreCommonProcedureMapper.CallProcGetPcsCharges", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC; 
    }
    
    public TrxMgntSC callProcGetPcsTaxes(TrxMgntSC trxMgntSC) throws  DAOException
    {      	       	  
	getSqlMap().update("coreCommonProcedureMapper.CallProcGetPcsTaxes", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC; 
    }
    
    
    

    /**
     * @author hibaoweidat
     * PB = f_update_passbook_det
     */
    public PassBookCO updatePassbookDOFHST(PassBookCO passBookCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.updatePassbookDOFHST", passBookCO);
	passBookCO.setErrMsg(StringUtil.replaceProcedureMessage(passBookCO.getErrMsg()));
	return passBookCO;
    }

    /**
     * @author hibaoweidat
     * PB = uf_print_pass_temp_det
     */
    public PassBookCO printPassbookDetails(PassBookCO passBookCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.printPassbookDetails", passBookCO);
	passBookCO.setErrMsg(StringUtil.replaceProcedureMessage(passBookCO.getErrMsg()));
	return passBookCO;
    }


    @Override
    public TrxMgntBatchSC updateAutoBatch( TrxMgntBatchSC trxMgntBatchSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.updateAutoBatch", trxMgntBatchSC);
	trxMgntBatchSC.setErrorMsg(StringUtil.replaceProcedureMessage(trxMgntBatchSC.getErrorMsg()));
	return trxMgntBatchSC;
    }
    
    public TrxMgntSC checkRemittanceStock(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkRemittanceStock", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    @Override
    public void createAuthorizeClearingTmpTables() throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.dropAuthorizeClearingTmpTables", "");
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
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	getSqlMap().update("coreCommonProcedureMapper.createAuthorizeClearingTmpTables", "");
    }
    
    
    public AccountCommonCO getBalanceAcc(AccountCommonCO accountCommonCO) throws DAOException
    { 
	insertTempSessionDetails(accountCommonCO.getLanguage());
	getSqlMap().update("coreCommonProcedureMapper.getBalanceAcc", accountCommonCO);
	return accountCommonCO;
    }
    
    public AccountCommonCO getAccBalance(AccountCommonCO accountCommonCO) throws DAOException
    { 
	insertTempSessionDetails(accountCommonCO.getLanguage());
	getSqlMap().update("coreCommonProcedureMapper.getAccBalance", accountCommonCO);
	return accountCommonCO;
    }
    
    public TrxMgntSC getAccExchrate(TrxMgntSC trxMgntSC) throws DAOException
    { 
	getSqlMap().update("coreCommonProcedureMapper.getAccExchrate", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    
    public final SpecialConditionsSC pRetAlertSPCONDS(SpecialConditionsSC spcondsSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.pRetAlertSPCONDS", spcondsSC);
	return spcondsSC;
    }
    
    /**
     * This function calculates and returns the cross rate in case of FC/FC. 
     * It calls  P_RET_GET_CROSS_RATE
     * @author redacharabaty
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC getCrossRate(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getCrossRate", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSettlementSC checkIisInvestmentDeal(TrxMgntSettlementSC trxMgntSettlementSC) throws DAOException
    {
	if(trxMgntSettlementSC.getIsSybase() == 1)
	{
	    getSqlMap().update("coreCommonProcedureMapper.checkIisInvestmentDeal", trxMgntSettlementSC);
	}
	else
	{
	    getSqlMap().queryForList("coreCommonProcedureMapper.checkIisInvestmentDeal", trxMgntSettlementSC);
	}
	trxMgntSettlementSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSettlementSC.getErrorMessage()));
	return trxMgntSettlementSC;
    }
    
    public void createTempTableForInvestmentDeal() throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.dropTempTableForInvestmentDeal", "");
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
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	getSqlMap().update("coreCommonProcedureMapper.createTempTableForInvestmentDeal", "");
    }
    
    public TrxMgntSettlementSC returnMinAmountRecv(TrxMgntSettlementSC trxMgntSettlementSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnMinAmountRecv", trxMgntSettlementSC);
	trxMgntSettlementSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSettlementSC.getErrorMessage()));
	return trxMgntSettlementSC;
    }

    /**
     * @author EliasAoun ; BSI120039 ; 23-01-2014
     * @description this modif has been postponed to #R14.2
     */
    public AccountSC storeInAmfAlert(AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.storeInAmfAlert", accountSC);
//	accountSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountSC.getErrorMessage()));
	return accountSC;
    }
    
    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * @param conditionalAutomationCO
     * @return
     * @throws DAOException
     */
    public ConditionalAutomationCO forbidMatchedCIF(ConditionalAutomationCO conditionalAutomationCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.forbidMatchedCIF", conditionalAutomationCO);
	return conditionalAutomationCO;
    }
    
    /**
     * This function calculates and returns the total of the Charges P_RET_GET_CHARGES_UNIFIED
     * @author redacharabaty
     * 
     * @param entityChargesSC
     * @return entityChargesSC
     * @throws DAOException
     */
    public EntityChargesSC calculateCharges(EntityChargesSC entityChargesSC) throws DAOException
    {
	insertTempSessionDetails(entityChargesSC.getLanguage(),null,entityChargesSC.getUserId());
	getSqlMap().update("coreCommonProcedureMapper.calculateCharges", entityChargesSC);
	entityChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(entityChargesSC.getErrorMessage()));
	return entityChargesSC;
    }
    
    /**
     * NABIL FEGHALI - PATH120107 - FATCA PHASE I
     * @param memoDtlCO
     * @return
     * @throws DAOException
     */
    public MemoDtlCO createDeleteMemo(MemoDtlCO memoDtlCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.createDeleteMemo", memoDtlCO);
	return memoDtlCO;
    }
    
    public CtstrsUploadSC reverseBatch(CtstrsUploadSC ctstrsUploadSC) throws DAOException
    {
	insertTempSessionDetails(ctstrsUploadSC.getLanguage(), ctstrsUploadSC.getSystemDate());
	getSqlMap().update("coreCommonProcedureMapper.reverseBatch", ctstrsUploadSC);
	return ctstrsUploadSC; 
    }

    
    @Override
    public AccountSC checkPendingDues(AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkPendingDues", accountSC);
	return accountSC;
    }
    
    @Override
    public DuesManagementSC returnDuesAmountAcc(DuesManagementSC duesManagementSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnDuesAmountAcc", duesManagementSC);
	return duesManagementSC;
    }
    
    

    @Override
    public DuesManagementSC executeDuesAlertProcedure(DuesManagementSC duesSc) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callDuesAlertProcedure", duesSc);
	return duesSc;
    }

    @Override
    public DuesManagementSC executeReverseTrxForDues(DuesManagementSC duesSc) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callReverseTrxForDuesProcedure", duesSc);
	return duesSc;
    }

    @Override
    public DuesManagementSC executeCheckDuesAccountProcedure(DuesManagementSC duesSc) throws DAOException
    {
	insertTempSessionDetails(duesSc.getLangCode());
	getSqlMap().update("coreCommonProcedureMapper.callCheckDuesAccountProcedure", duesSc);
	duesSc.setErrorMessage(StringUtil.replaceProcedureMessage(duesSc.getErrorMessage()));
	return duesSc;
    }

    @Override
    public void createCTS_DUES_TEMP() throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.dropCTS_DUES_TEMP", "");
	}
	catch(Exception e)
	{
	    log.error(e.getMessage());
	}
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.createCTS_DUES_TEMP", "");
	}
	catch(Exception e)
	{
	    log.error(e.getMessage());
	}
    }

    @Override
    public void createHUNTING_TMP() throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.dropHUNTING_TMP", "");
	}
	catch(Exception e)
	{
	    log.error(e.getMessage());
	}
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.createHUNTING_TMP", "");
	}
	catch(Exception e)
	{
	    log.error(e.getMessage());
	}
    }

    @Override
    public void createHOF_TMP() throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.dropHOF_TMP", "");
	}
	catch(Exception e)
	{
	    log.error(e.getMessage());
	}
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.createHOF_TMP", "");
	}
	catch(Exception e)
	{
	    log.error(e.getMessage());
	}
    }

    /**
     * This method calls procedure P_RET_CHECK_AMOUNT  to validate 
     * if account exceed available balance
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC returnCheckAmountAccBalance(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    /*
	     * Call insertTempSessionDetails method to insert language, user id, application name.. into TEMP_SESSION_DETAILS 
	     */
	    insertTempSessionDetails(trxMgntSC.getLangCode(), trxMgntSC.getRunningDate(), trxMgntSC.getUserId(),
		    trxMgntSC.getAppName());
	    getSqlMap().update("coreCommonProcedureMapper.returnCheckAmountAccBalance", trxMgntSC);
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_CHECK_AMOUNT " + e.getMessage(),e);
	}
    }
    public void createAccHashTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createAccHashTables", sybOra);

    }

    /**
     * Drop Account Hash tables
     */
    public void dropAccHashTables(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropAccHashTables", sybOra);
	}
	catch(Exception e)
	{
	    log.info("No hash Table to Drop");
	  

	}

    }
    
    /**
     *  //JIHANE TP82894 - IIAB080110 ; TP82682 ABARI110659 log charges as dues when insufficient balance
     */
    public TrxMgntSC insertCtsDues(TrxMgntSC trxMgntSC) throws DAOException
    {

	getSqlMap().update("coreCommonProcedureMapper.insertCtsDues", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public CtstrsUploadSC launchBatchSaveAs(CtstrsUploadSC ctstrsUploadSC) throws DAOException
    {

	insertTempSessionDetails(ctstrsUploadSC.getLanguage());
	getSqlMap().update("coreCommonProcedureMapper.launchBatchSaveAs", ctstrsUploadSC);
	ctstrsUploadSC.setErrorMessage(StringUtil.replaceProcedureMessage(ctstrsUploadSC.getErrorMessage()));
	return ctstrsUploadSC;
    }
    

    /**
     * This method calls procedure P_RET_CHECK_ALLOWED_GLS  to validate 
     * if the specified GL is allowed to be Credited/Debited/ or Both
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC returnCheckAllowedGls(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnCheckAllowedGls", trxMgntSC);
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_CHECK_ALLOWED_GLS " + e.getMessage(),e);
	}
    }
    
    /**
     * This method calls procedure P_RET_GET_BIC_CODE to calculate
     * a new BIC Code and validate a given BIC Code
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC returnBicCode(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnBicCode", trxMgntSC);
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_GET_BIC_CODE " + e.getMessage(),e);
	}
    }
    
    /**
     * This method calls procedure P_RET_VALIDATE_PROVIDER_REF to validate
     * the provider ref
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC validateProviderRef(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.validateProviderRef", trxMgntSC);
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_VALIDATE_PROVIDER_REF " + e.getMessage(),e);
	}
    }
    
    /**
     * This method calls procedure P_RET_REQUEST_CHARGES to calculate and possibly generate JVs
     * for Request Charges. It returns the total.
     * 
     * @param trxMgntChargesSC
     * @return trxMgntChargesSC
     * @throws DAOException
     */
    public TrxMgntChargesSC returnRequestCharges(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnRequestCharges", trxMgntChargesSC);
	    trxMgntChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntChargesSC.getErrorMessage()));
	    return trxMgntChargesSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_REQUEST_CHARGES " + e.getMessage(),e);
	}
    }
    
    /**
     * This method calls procedure P_RET_GET_AMOUNT_RATE to calculate the amount by Rate
     * 
     * @param trxMgntSC
     * @return trxMgntSC
     * @throws DAOException
     */
    public TrxMgntSC returnAmountByRate(TrxMgntSC trxMgntSC) throws DAOException
    {
	if(NumberUtil.isEmptyDecimal(trxMgntSC.getTrxAmount()))
        {
	    trxMgntSC.setTrxAmount(BigDecimal.ZERO.setScale(3));
        }
        else
        {
            trxMgntSC.setTrxAmount(trxMgntSC.getTrxAmount().setScale(3));
        }
	if(NumberUtil.isEmptyDecimal(trxMgntSC.getAccAmount()))
	{
	    trxMgntSC.setAccAmount(BigDecimal.ZERO.setScale(3));
	}
	else
	{
	    trxMgntSC.setAccAmount(trxMgntSC.getAccAmount().setScale(3));
	}
	if(NumberUtil.isEmptyDecimal(trxMgntSC.getCvAmount()))
	{
	    trxMgntSC.setCvAmount(BigDecimal.ZERO.setScale(3));
	}
	else
	{
	    trxMgntSC.setCvAmount(trxMgntSC.getCvAmount().setScale(3));
	}

	getSqlMap().update("coreCommonProcedureMapper.returnAmountByRate", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * This method calls procedure P_N_TRX_GET_OPNO to generate next counter
     * 
     * @param IBISCOUNTERVO
     * @return IBISCOUNTERVO
     * @throws DAOException
     */
    public IBISCOUNTERVO generateIbisCounter(IBISCOUNTERVO criteria) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.generateIbisCounter", criteria);
	return criteria;
    }

    
    public void createCardsHashTables() throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	getSqlMap().update("coreCommonProcedureMapper.ctsTempAllCardsCreation", "");
    }

    public void dropCardsHashTables() throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", "");
	    getSqlMap().update("coreCommonProcedureMapper.ctsTempAlldropCards", "");
	}
	catch(Exception e)
	{
	    log.info("No hash Table to Drop");
	}
	
    }

    public BlackListIntSourceSC callSoundexProcess(BlackListIntSourceSC criteria) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callSoundexProcess", criteria);
	return criteria;
    }
    
    public TrxMgntSC callProcRetGetPenaltyDetailGen(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());
	getSqlMap().update("coreCommonProcedureMapper.callProcRetGetPenaltyDetailGen", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC; 
    }
    
    public TrxMgntSC returnTranslateMICR(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnTranslateMICR", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC; 
    }
    
    public TrxMgntSC verifyMICRKey(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.verifyMICRKey", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC; 
    }

    public CardsManagementCO returnCardEnquiry(CardsManagementCO cardsManagementCO) throws DAOException
    {
	cardsManagementCO.applyMaskParams(new String[]{"cardsMgtVO.cardNo"} );
	getSqlMap().update("coreCommonProcedureMapper.returnCardEnquiry", cardsManagementCO);
	cardsManagementCO.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementCO.getErrorMessage()));
	return cardsManagementCO;
    }
    
    /**
     * used to aplly accounting entries in tfa application
     * 
     * @author: jihadlamaa
     * @date: Jun 3, 2014
     * @PB:
     * @param tfaCommonSC
     * @return
     * @throws DAOException
     */
    public CtsRequestSC pkgTemplateTfa(CtsRequestSC criteria) throws DAOException
    {
        try
        {
            insertTempSessionDetails(criteria.getPreferredLanguage());
            getSqlMap().update("coreCommonProcedureMapper.pkgTemplateTfa", criteria);
            // return the Message by Eliminating Procedures Names
            // between <# and #>
            criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
        }
        catch(Exception e)
        {
            log.error("Error in pkgTemplateTfa" + e.getMessage());
            throw new DAOException(getProcedureErrorMsg(criteria, e).getErrorMessage());
        }
        return criteria;

    }
    
    /**
     * get Procedure Error Msg
     * 
     * @author: eliebounassif
     * @date: Oct 5, 2015
     * @PB:
     * @param sc
     * @param e
     * @return
     */
    private CtsRequestSC getProcedureErrorMsg(CtsRequestSC sc, Exception e)
    {
	String msg = e.getMessage();
	String prefix, suffix = "&"; // for sybase and oracle the character '&'
	// follows ther user error
	int fromIndex, endIndex;

	if(sc.getIsOracle() == 1)
	{
	    // for oracle the part that precede the user error contains the
	    // below string
	    prefix = "ORA-20000: #";
	}
	else
	{
	    // for sybase it contains the below string
	    prefix = ": # ";
	}
	fromIndex = msg.indexOf(prefix);
	if(fromIndex >= 0)
	{
	    endIndex = msg.indexOf(suffix, fromIndex);
	    // extracting the user error with the prefix
	    msg = msg.substring(fromIndex, endIndex);
	    // replacing the prefix with empty string
	    sc.setErrorMessage(msg.replace(prefix, ""));
	}
	else
	{
	    sc.setErrorMessage(msg);
	}

	return sc;
    }
    /**
     * this method creates #DOF_POSTING_TMP
     * 
     * @throws DAOException
     */
    public void createHashDof(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createHashDof", sybOra);

    }

    public void dropHashDof(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropHashDof", sybOra);
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

    @Override
    public AccountSC callRetAccReactivation(AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callRetAccReactivation", accountSC);
	return accountSC;
    }
    
    public TrxMgntSC lockUnlockSafeAccounts(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());

	getSqlMap().update("coreCommonProcedureMapper.lockUnlockSafeAccounts", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC callIISProcedureCalculation(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());

	getSqlMap().update("coreCommonProcedureMapper.callIISProcedureCalculation", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    public TrxMgntSC checkIISsalaryBlock(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());

	getSqlMap().update("coreCommonProcedureMapper.checkIISsalaryBlock", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    //TONY NOUH User Story#315732  AMANA130105 Overdraft Products
    public TrxMgntSC checkOverDraft(TrxMgntSC trxMgntSC) throws DAOException
    {
	insertTempSessionDetails(trxMgntSC.getLangCode());
	
	getSqlMap().update("coreCommonProcedureMapper.checkOverDraft", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    // added by nancy-27/09/2017-568160-AMANA170089-CEFTS- Phase II- Direct Debit
    @Override
    public TrxMgntSC balanceSettlement(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.balanceSettlement", trxMgntSC);
        return trxMgntSC;
    }
    // end nancy
    
    
    public WithholdingSC processWithholding(WithholdingSC withholdingSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.processWithholding", withholdingSC);
	withholdingSC.setErrorMessage(StringUtil.replaceProcedureMessage(withholdingSC.getErrorMessage()));
	return withholdingSC;
    }
    public CtsRequestSC checkUserLimtReq(CtsRequestSC criteria) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.checkUserLimtReq", criteria);

        return criteria;

    }
    
    public void createCtsTrsTempFiltered() throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.commitTrans", null);
        getSqlMap().update("coreCommonProcedureMapper.dropCtsTrsTempFiltered", null);
        getSqlMap().update("coreCommonProcedureMapper.createCtsTrsTempFiltered", null);
    }
    
    public void createCtsTemp() throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.commitTrans", null);
        getSqlMap().update("coreCommonProcedureMapper.dropCtsTemp", null);
        getSqlMap().update("coreCommonProcedureMapper.createCtsTemp", null);
    }

    public TrxMgntSC callProcRetProcessAutoAllocation(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callProcRetProcessAutoAllocation", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * Hasan EWBI160091 20/05/2016
     */
    @Override
    public CifSC callCifUpdate(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCifUpdate", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
    
    //raed BIPL120018
    public TrxMgntSC callFractionsProfit(TrxMgntSC trxMgntSC) throws DAOException
    {
    	  getSqlMap().update("coreCommonProcedureMapper.getPCSFactionsProfit", trxMgntSC);
    	  trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
    	  return trxMgntSC;
    }
    
    @Override
    public TrxMgntSC callAtmInsertCeftsTrf(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callAtmInsertCeftsTrf", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));	
	return trxMgntSC;
    }
    
    //Abdo BURJ150069 12/08/2016
    public void checkAccCreation(AccountSC accountSC) throws DAOException
    {
    	  getSqlMap().update("coreCommonProcedureMapper.checkAccCreation", accountSC);
    	  accountSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountSC.getErrorMessage()));//Hasan Bug#435331 05/04/2017
    }
    
    @Override
    public CifSC fillTablesITR(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.fillTablesITR", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
    
    public CardsManagementCO returnCardEnquiryExt(CardsManagementCO cardsManagementCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnCardEnquiryExt", cardsManagementCO);
	cardsManagementCO.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementCO.getErrorMessage()));
	return cardsManagementCO;
    }
    
    @Override
    public AccountSC callGetAmfBalanceFC(AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callGetAmfBalanceFC", accountSC);
	accountSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountSC
		.getErrorMessage()));
	return accountSC;
    }
    
    @Override
    public TrxMgntSC callInsertCtstrs(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callInsertCtstrs", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC
		.getErrorMessage()));
	return trxMgntSC;
    }
    
    @Override
    public TrxMgntSC callAccEntry(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callAccEntry", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    @Override
    public TrxMgntSC callConvertTrsAmount(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callConvertTrsAmount", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    @Override
    public TrxMgntSC callCtsCtrTimeout(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCtsCtrTimeout", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    @Override
    public TrxMgntSC retInsertStatus(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.retInsertStatus", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    @Override
    public TrxMgntChargesSC retIbChargeUnified(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.retIbChargeUnified", trxMgntChargesSC);
	trxMgntChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntChargesSC.getErrorMessage()));
	return trxMgntChargesSC;
    }

    @Override
    public TrxMgntChargesSC retProcessHofWithCharge(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.retProcessHofWithCharge", trxMgntChargesSC);
	// trxMgntChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntChargesSC
	// .getErrorMessage()));
	return trxMgntChargesSC;
    }

    @Override
    public AccountSC returnAmfBalanceFCNew(AccountSC accountSC) throws DAOException
    {
	if(accountSC.getIsOracle() == 1)
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnAmfBalanceFCNew", accountSC);
	}
	else
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnAmfBalanceFC", accountSC);
	}
	return accountSC;
    }
    

    @Override
    public AccountChargesSC processAccountCharges(AccountChargesSC accountChargesSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callRetProcessAccountCharges", accountChargesSC);
	accountChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountChargesSC.getErrorMessage()));
	return accountChargesSC;
    }



    /**
     * RAED SAAD
     * 
     * Title
     * 
     * USER STORY #562508 ABARSI160021 - Release of HOF and Transfer to FATCA
     * account - CSM 14.1
     * 
     * (non-Javadoc)
     * 
     */
    @Override
    public TrxMgntSC releaseHofByCif(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.releaseHofByCif", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    /**
     * RAED SAAD
     * 
     * Title
     * 
     * USER STORY #562508 ABARSI160021 - Release of HOF and Transfer to FATCA
     * account - CSM 14.1
     * 
     * (non-Javadoc)
     * 
     */
    @Override
    public void createProcessWithholdingTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.dropProcessWithholdingTables", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createProcessWithholdingTables", sybOra);

    }

    /**
     * RAED SAAD
     * 
     * Title
     * 
     * USER STORY #562508 ABARSI160021 - Release of HOF and Transfer to FATCA
     * account - CSM 14.1
     * 
     * (non-Javadoc)
     * 
     */
    @Override
    public void dropProcessWithholdingTables(String sybOra) throws DAOException
    {

	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropProcessWithholdingTables", sybOra);
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
    
    @Override
    public TrxMgntSC checkClosingPeriod(TrxMgntSC trxMgntSC, String sybOra) throws DAOException
    {
	try
        {
	    insertTempSessionDetails(trxMgntSC.getLangCode(), trxMgntSC.getSystemDate(), trxMgntSC.getUserId(),
	                trxMgntSC.getAppName());
            getSqlMap().update("coreCommonProcedureMapper.checkClosingPeriod", trxMgntSC);
            trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC
                .getErrorMessage()));
        }
        catch(Exception e)
        {
            throw new DAOException("Error in P_RET_CHECK_CLOSED_PERIOD " + e.getMessage(), e);
        }
        return trxMgntSC;
    }
    
    @Override
    public AccRestrictedSC fillAccRestricted(AccRestrictedSC accRestrictedSC) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.fillAccRestricted", accRestrictedSC);
        return accRestrictedSC;
	    
    }

    
    @Override
    public CifSC checkEtlIdentProcess(CifSC criteria) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkEtlIdentProcess", criteria);
	return criteria;
	
    }
    
    public TrxMgntSC checkEftDebitTransaction(TrxMgntSC trxMgntSC) throws DAOException
    {

	getSqlMap().update("coreCommonProcedureMapper.checkEftDebitTransaction", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;

    }
     
    

    public TrxMgntSC retGetTrsNo(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.retGetTrsNo", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    
    public TrxMgntSC clearTrsNo(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.clearTrsNo", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TrxMgntSC checkOneObligorLimit(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkOneObligorLimit", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public void dropOneObligorTables(String sybOra) throws DAOException
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropOneObligorTables", sybOra);
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
    
    
    public void createOneObligorTables(String sybOra) throws DAOException
    {
	/*
         * Commit all transaction before so that creation of hash table passes
         */
        getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

        /*
         * Create Hash table
         */
        getSqlMap().update("coreCommonProcedureMapper.createOneObligorTables", sybOra);
	
    }
    
    
    public TrxMgntSC iisOneObligorLimitReport(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.iisOneObligorLimitReport", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /** Rania Al-Bitar
     *  Date: 19/01/2018
     */
    
    /**
     * BB140096 --[John Massaad]
     */
    public void createNonFinancialInfoTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createNonFinancialInfoTables", sybOra);

    }

    /**
     * BB140096 --[John Massaad]
     */
    public void dropNonFinancialInfoTables(String sybOra) throws DAOException
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropNonFinancialInfoTables", sybOra);
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
    
    /** Rania Al-Bitar
     * Date: 19/01/2017
     * BB140096
     * @param trxMgntSC
     * @return
     * @throws DAOException
     */
    public TrxMgntSC defaultIntermBankBicCode(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.defaultIntermBankBicCode", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * EWBI160037 -- [John Massaad]
     */
    public CifSC copyAuthorizeSignatures(CifSC cifSC) throws DAOException
    {
	 getSqlMap().update("coreCommonProcedureMapper.copyAuthorizeSignatures", cifSC);
	 cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
    
    //Abdo US 382751 - BB KYC with Dynamic Screen   
    public CifSC callMappingSiron(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callMappingSiron", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }

    public void createSironHashTables(String sybOra) throws DAOException
    {
	/*
	 * Commit all BAtch before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createSironHashTables", sybOra);

    }
    
    public void dropSironHashTables(String sybOra)
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropSironHashTables", sybOra);
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
    
    public CifSC callScoreSiron(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callScoreSiron", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
    //End Abdo 

    public TrxMgntSC callProcVisaImport(TrxMgntSC criteria)  throws DAOException
    {
        try
        {
            getSqlMap().update("coreCommonProcedureMapper.callProcVisaImport", criteria);
            // return the Message by Eliminating Procedures Names between <# and #>
            criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
            return criteria;
        }
        catch(Exception e)
        {
            throw new DAOException("Error in P_RET_IMPORT_VISA " + e.getMessage(), e);
        }
    }
    
   
    public TrxMgntSC callProcVisaMatch(TrxMgntSC criteria)  throws DAOException
    {
        try
        {
            getSqlMap().update("coreCommonProcedureMapper.callProcVisaMatch", criteria);
            // return the Message by Eliminating Procedures Names between <# and #>
            criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
            return criteria;
        }
        catch(Exception e)
        {
            throw new DAOException("Error in P_RET_IMPORT_VISA " + e.getMessage(), e);
        }
    }
    
    public TrxMgntSC callPCSRecoverProfit(TrxMgntSC trxMgntSC) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.callPCSRecoverProfit", trxMgntSC);
        trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
        return trxMgntSC;
    }
    
    public TrxMgntSC returnCheckAllowedCIFs(TrxMgntSC trxMgntSC) throws DAOException
    {
        try
        {
            getSqlMap().update("coreCommonProcedureMapper.returnCheckAllowedCIFs", trxMgntSC);
            trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
            return trxMgntSC;
        }
        catch(Exception e)
        {
            throw new DAOException("Error in P_RET_CHECK_ALLOWED_CIFS " + e.getMessage(), e);
        }
    }
    
    public TrxMgntSC callRetReverseProfit(TrxMgntSC trxMgntSC) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.callRetReverseProfit", trxMgntSC);
        trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
        return trxMgntSC;
    }
    
    public AccountSC createAMF(AccountSC accountSC) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.createAMF", accountSC);
        return accountSC;
    }
    
    
    public TrxMgntSC callPCSUpdateBODTrx(TrxMgntSC trxMgntSC) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.callPCSUpdateBODTrx", trxMgntSC);
        trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
        return trxMgntSC;
    }
    
    @Override
    public BlackListSC checkBlackListRestriction(BlackListSC blackListSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkBlackListRestriction", blackListSC);
	blackListSC.setErrorMessage(StringUtil.replaceProcedureMessage(blackListSC.getErrorMessage()));
	return blackListSC;
    }
    
    public void createHashAuditDetails(String sybOra) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);

	/*
	 * Create Hash table
	 */
	getSqlMap().update("coreCommonProcedureMapper.createHashAuditDetails", sybOra);

    }
    
    public void dropHashAuditDetails(String sybOra) throws DAOException
    {
	try
	{
	    /*
	     * Commit all transaction before so that creation of hash table
	     * passes
	     */
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    getSqlMap().update("coreCommonProcedureMapper.dropHashAuditDetails", sybOra);
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
     * THIS METHOD CALLS P_EXECUTE_DYN_FILES_STATEMENTS 
     * @PARAM USER_NAME,
		FILE_CODE,
		PROCEED,
		AL_THREAD_ID
     */     
     public DynFilesSC callProcExecDynFilesStatement(DynFilesSC dynFilesSC)throws DAOException
     { 

	getSqlMap().update("coreCommonProcedureMapper.callProcExecDynFilesStatement", dynFilesSC);
	dynFilesSC.setErrorMessage(StringUtil.replaceProcedureMessage(dynFilesSC.getErrorMessage()));
	return dynFilesSC;

     }
    

    /** Hussein Elhajj
     * Date: 25/04/2018
     * method for calling  P_IIS_UPDATE_FX_LINKED_UTIL
     * @param trxMgntFxDealSC
     * @return
     * @throws DAOException
     */
    @Override
    public TrxMgntFxDealSC updateFxDeals(TrxMgntFxDealSC trxMgntFxDealSC) throws DAOException
    {
	 try
	        {
	            getSqlMap().update("coreCommonProcedureMapper.updateFxDeal", trxMgntFxDealSC);
	            // return the Message by Eliminating Procedures Names between <# and #>
	            trxMgntFxDealSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntFxDealSC.getErrorMessage()));
	            return trxMgntFxDealSC;
	        }
	        catch(Exception e)
	        {
	            throw new DAOException("Error in P_IIS_UPDATE_FX_LINKED_UTIL " + e.getMessage(), e);
	        }
	    }

    @Override
    public int callFillAccRestricted(AccountSC criteria) throws DAOException
    {
	// Habib Baalbaki accocunt restriction 372747
	return getSqlMap().update("coreCommonProcedureMapper.callP_SADS_WRAP_PPL_ACC_REST", criteria);
    }

    @Override
    public void createACC_RESTRICTION_TEMP(AccountSC criteria) throws DAOException
    {
	/*
	 * Commit all transaction before so that creation of hash table passes
	 */
	if(ConstantsCommon.CURR_DBMS_SQLSERVER != 1)
	{
	    getSqlMap().update("coreCommonProcedureMapper.commitTrans", null);
	}
	getSqlMap().update("coreCommonProcedureMapper.dropACC_RESTRICTION_TEMP", null);
	getSqlMap().update("coreCommonProcedureMapper.createACC_RESTRICTION_TEMP", criteria);

    }

    // added by nancy -- 17/07/2018-- 382769-- account limits
    public void accLimitValidationChecking(AccountSC criteria) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.accLimitValidationChecking", criteria);
	criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
    }
    // end nancy

    @Override
    public AccountSC recalculatePointsAccruals(AccountSC accountSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.recalculatePointsAccruals", accountSC);
	    // return the Message by Eliminating Procedures Names between <# and #>
	    accountSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountSC.getErrorMessage()));
	    return accountSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_CORE_ADJUST_FMA_PT_ACCRUALS" + e.getMessage(), e);
	}
    }
    
    
    // MajdHaidar 01/11/2018
    @Override
    public AccountSC callCheckAccountData(AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCheckAccountData", accountSC);
	accountSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountSC.getErrorMessage()));
	return accountSC;
    }
    
    @Override
    public TrxMgntChargesSC checkHOFSpecialConditions(TrxMgntChargesSC trxMgntChargesSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkHOFSpecialConditions", trxMgntChargesSC);
	trxMgntChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntChargesSC
		.getErrorMessage()));
	return trxMgntChargesSC;
    }
    
    
    /**
     * @author RaniaAlBitar DB150021 Maisarah Credit Card
     */

    public TrxMgntSC callFmsFillShadowAccount(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callFmsFillShadowAccount", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * @author RaniaAlBitar DB170108 - Advance profit payment
     */

    public AccountsManagementCO callPcsGetAdvanceAmount(AccountsManagementCO accountsManagementCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callPcsGetAdvanceAmount", accountsManagementCO);
	accountsManagementCO.setErrorText(StringUtil.replaceProcedureMessage(accountsManagementCO.getErrorText()));
	return accountsManagementCO;
    }

    public CifSC callCheckFomData(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCheckFomData", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
    
    /**
     * @author RaniaAlBitar DB140075 - Customer wants to close the General
     *         Account - R14.1.1
     * @param accountsManagementCO
     * @return
     * @throws DAOException
     */
    public TrxMgntSC getOverdrawLimit(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getOverdrawLimit", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    public TrxMgntSC getInvstBal(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.getInvstBal", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    /**
     * @author RaniaAlBitar AIBBI180340 - SBI170029 - Excess Over Limit
     * @param accountsManagementCO
     * @return
     * @throws DAOException
     */
    public AccountsManagementCO callFmsGetOverDraftLimit(AccountsManagementCO accountsManagementCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callFmsGetOverDraftLimit", accountsManagementCO);
	accountsManagementCO.setErrorText(StringUtil.replaceProcedureMessage(accountsManagementCO.getErrorText()));
	return accountsManagementCO;
    }


    /**
     * @author raniaalbitar
     * @param custSegmentationSC
     * @return
     * @throws DAOException 718813 - Dynamic Customer Scoring on latest
     */
    public CustSegmentationSC runTrialScoringProcess(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.runTrialScoringProcess", custSegmentationSC);

	if(custSegmentationSC.getErrorMessage() != null)
	{
	    custSegmentationSC
		    .setErrorMessage(StringUtil.replaceProcedureMessage(custSegmentationSC.getErrorMessage()));
	}
	return custSegmentationSC;
    }

    /**
     * @author raniaalbitar Customers Segmentation
     */

    public SegmentGroupingSC runAlertSegmentGrouping(SegmentGroupingSC segmentGroupingSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.runAlertSegmentGrouping", segmentGroupingSC);

	if(segmentGroupingSC.getErrorMessage() != null)
	{
	    segmentGroupingSC.setErrorMessage(StringUtil.replaceProcedureMessage(segmentGroupingSC.getErrorMessage()));
	}
	return segmentGroupingSC;
    }


    public CustSegmentationSC runAlertSegmentation(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.runAlertSegmentation", custSegmentationSC);
	// return the Message by Eliminating Procedures Names between <# and #> 
	if(custSegmentationSC.getErrorMessage() != null)
	{
	    custSegmentationSC.setErrorMessage(StringUtil.replaceProcedureMessage(custSegmentationSC.getErrorMessage()));
	}
	return custSegmentationSC;
    }
    
    @Override
    public TrxMgntSC createStandingOrder(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.createStandingOrder", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    public TransferCashSC checkVaultRemittance(TransferCashSC transferCashSC) throws DAOException
    {
        insertTempSessionDetails(transferCashSC.getLanguage());
        getSqlMap().update("coreCommonProcedureMapper.checkVaultRemittance", transferCashSC);
        transferCashSC.setErrorMessage(StringUtil.replaceProcedureMessage(transferCashSC.getErrorMessage()));
        return transferCashSC;
    }
    
    @Override
    public SpecialConditionsSC callCheckSpCondData(SpecialConditionsSC criteria) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCheckSpCondData", criteria);
	criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
	return criteria;
    }
    
    @Override
    public TrxMgntSC checkDataLostFound(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCheckDataLostFound", trxMgntSC);
	trxMgntSC
		.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
        return trxMgntSC;
    }
    
    @Override
    public TrxMgntSC checkDataTransferAccount(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkDataTransferAccount", trxMgntSC);
	trxMgntSC
		.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
        return trxMgntSC;
    }
    
    @Override
    public DuesManagementSC checkDataDuesMgnt(DuesManagementSC duesManagementSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkDataDuesMgnt", duesManagementSC);
	duesManagementSC
		.setErrorMessage(StringUtil.replaceProcedureMessage(duesManagementSC.getErrorMessage()));
        return duesManagementSC;
    }
    
    public void commitTrans() throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.commitTrans", null);

    }
    
    @Override
    public TrxMgntSC collectRemittance(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.collectRemittance", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    @Override
    public TrxMgntSC createRemittance(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.createRemittance", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    @Override
    public TrxMgntSC createChequeDeposit(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.createChequeDeposit", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
//	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }
    
    @Override
    public CifSC callCheckValidateFomData(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCheckValidateFomData", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
    
    public CustSegmentationSC runTrialSegmentationProcess(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.runTrialSegmentationProcess", custSegmentationSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	if(custSegmentationSC.getErrorMessage() != null)
	{
	    custSegmentationSC.setErrorMessage(StringUtil.replaceProcedureMessage(custSegmentationSC.getErrorMessage()));
	}
	return custSegmentationSC;
    }
    
    // added by nancy 31/01/2018
    @Override
    public AccountSC checkOnClosingAccount (AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkOnClosingAccount", accountSC);
	accountSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountSC.getErrorMessage()));
	return accountSC;
    }
    // end nancy 
    
    // Added by nancy - 30/01/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    @Override
    public DuesManagementSC returnActiveWithAmountAcc(DuesManagementSC duesManagementSC) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.returnActiveWithAmountAcc", duesManagementSC);
        return duesManagementSC;
    }
    
    @Override
    public DuesManagementSC returnPostdatedChequeBalances(DuesManagementSC duesManagementSC) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.returnPostdatedChequeBalances", duesManagementSC);
        return duesManagementSC;
    }
    // end nancy 
	    

    public AccountsManagementCO retRestrictAccCifCreate(AccountsManagementCO accountsManagementCO) throws DAOException
    {
	insertTempSessionDetails(accountsManagementCO.getLanguage());
	getSqlMap().update("coreCommonProcedureMapper.retRestrictAccCifCreate", accountsManagementCO);
	accountsManagementCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountsManagementCO.getErrorMsg()));
	accountsManagementCO.setErrorType(StringUtil.replaceProcedureMessage(accountsManagementCO.getErrorType()));
	return accountsManagementCO;
    }
	 public TrxMgntSC insertCTSTRSDET(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.insertCTSTRSDET", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    @Override
    public TrxMgntSC callFillBillReport(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callFillBillReport", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    @Override
    public TrxMgntSC commonPosting(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.commonPosting", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    public TrxMgntSC processInvPoints(TrxMgntSC criteria) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.processInvPoints", criteria);
	    // return the Message by Eliminating Procedures Names between <# and #>
	    criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria.getErrorMessage()));
	    return criteria;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_PROCESS_OD_POINTS " + e.getMessage(), e);
	}
    }
 
    // Hala Al Sheikh - ABSAI180070
    public CifSC callChecksumDigit(CifSC cifSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callChecksumDigit", cifSC);
	cifSC.setErrorMessage(StringUtil.replaceProcedureMessage(cifSC.getErrorMessage()));
	return cifSC;
    }
  

    /**
     * @author HusseinElhajj ABAR130131 - NANTISSEMENT DE BONS DE CAISSES
     * @param TrxMgntSC
     * @return
     * @throws DAOException
     */
    public TrxMgntSC checkCollateralizedCD(TrxMgntSC trxMgntSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkCollateralizedCD", trxMgntSC);
	trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	return trxMgntSC;
    }

    @Override
    public FomSC createPkgSms(FomSC fomSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.createPkgSms", fomSC);
	fomSC.setErrorMessage(StringUtil.replaceProcedureMessage(fomSC.getErrorMessage()));
	return fomSC;
    }
    
    @Override
    public ChequeBookSC callCheckChequeBookData(ChequeBookSC chequeBookSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCheckChequeBookData", chequeBookSC);
	chequeBookSC.setErrorMessage(StringUtil.replaceProcedureMessage(chequeBookSC.getErrorMessage()));
	return chequeBookSC;
    }
	    
    /**
     * @author RaniaAlBitar
     * ABSAI180073
     */

    public FomCO executeScoringProcess(FomCO fomCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.executeScoringProcess", fomCO);

	if(fomCO.getErrorDesc() != null)
	{
	    fomCO.setErrorDesc(StringUtil.replaceProcedureMessage(fomCO.getErrorDesc()));
	}
	return fomCO;
    }
    //Hala Al Sheikh - ABEI180106
    public CardsManagementSC callFMSGenerateDrwDwn(CardsManagementSC cardsManagementSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.callFMSGenerateDrwDwn", cardsManagementSC);
	    cardsManagementSC.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementSC.getErrorMessage()));
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_FMS_WRAP_GENERATE_DRWDWN " + e.getMessage(),e);
	}
	return cardsManagementSC;
    }

    public AccountCO wrapSpecialCondition(AccountCO accountCO) throws DAOException
    {
	insertTempSessionDetails(null, accountCO.getRunningDate());
	getSqlMap().update("coreCommonProcedureMapper.wrapSpecialCondition", accountCO);
	accountCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountCO.getErrorMsg()));
	return accountCO;
    }
    
    public TrxMgntCO pcsWrapAnniversaryAccDep(TrxMgntCO trxMgntCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.pcsWrapAnniversaryAccDep", trxMgntCO);
	trxMgntCO.setErrorMsg(StringUtil.replaceProcedureMessage(trxMgntCO.getErrorMsg()));
	return trxMgntCO;
    }

    //Hala Al Sheikh - SBI170059 SBI170060 
    public AccountsManagementCO callFmsWrapGetMosharakaDetails(AccountsManagementCO accountsManagementCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callFmsWrapGetMosharakaDetails", accountsManagementCO);
	accountsManagementCO.setErrorText(StringUtil.replaceProcedureMessage(accountsManagementCO.getErrorText()));
	return accountsManagementCO;
    }
    public AccountCO retApiCreateAccount(AccountCO accountCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.retApiCreateAccount", accountCO);
	accountCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountCO.getErrorMsg()));
	accountCO.setErrorType(StringUtil.replaceProcedureMessage(accountCO.getErrorType()));
	return accountCO;
    }

    public AccountCO wrapCoreGetVatDetails(AccountCO accountCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.wrapCoreGetVatDetails", accountCO);
	accountCO.setErrorMsg(StringUtil.replaceProcedureMessage(accountCO.getErrorMsg()));
	accountCO.setErrorType(StringUtil.replaceProcedureMessage(accountCO.getErrorType()));
	return accountCO;
    }

    // Hala Al Sheikh - BMO180327
    public CardsManagementCO returnFMSWrapGetCardFacDet(CardsManagementCO cardsManagementCO) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.returnFMSWrapGetCardFacDet", cardsManagementCO);
	cardsManagementCO.setErrorMessage(StringUtil.replaceProcedureMessage(cardsManagementCO.getErrorMessage()));
	return cardsManagementCO;
    }

    public TransferEntitySC callP_FMS_WRAP_REPLACE_RLN_MGR(TransferEntitySC transferEntitySC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callP_FMS_WRAP_REPLACE_RLN_MGR", transferEntitySC);
	transferEntitySC.setErrorMessage(StringUtil.replaceProcedureMessage(transferEntitySC.getErrorMessage()));
	return transferEntitySC;
    }	

    // Hala Al Sheikh - SBI190010
    public TrxMgntSC returnCheckAllowedCYs(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.returnCheckAllowedCYs", trxMgntSC);
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_CHECK_ALLOWED_FILER_CY " + e.getMessage(),e);
	}
    }
    
    
    /**
     * Create Hash table #ALRT_FILL_DETAILS_TMP
     */
    public Integer createAlertFillDetailsTemp(String sybOra) throws DAOException
    {
	// Commit all transaction before so that creation of hash table passes
	int instSq = getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	
	// Create Hash table
	return instSq + getSqlMap().update("coreCommonProcedureMapper.createAlertFillDetailsTemp", sybOra);
    }

    
    /**
     * Drop ALRT_FILL_DETAILS_TMP Hash tables
     */
    public Integer dropAlertFillDetailsTemp(String sybOra)
    {
	try
	{
	    /*
	     * Commit all ALRT_FILL_DETAILS_TMP before so that creation of hash table passes
	     */
	    int instSq = getSqlMap().update("coreCommonProcedureMapper.commitTrans", sybOra);
	    return instSq + getSqlMap().update("coreCommonProcedureMapper.dropAlertFillDetailsTemp", sybOra);
	}
	catch(Exception e)
	{
	    /*
	     * the try catch block is added here since in Sybase we can't check
	     * on the existence of the Hash table before creating it, but we
	     * want to continue normally even if the drop was not successful
	     */
	    log.info("No hash Table to Drop dropAlertFillDetailsTemp");
	}
	return -1;
    }
    
    public TrxMgntSC callCheckRecRemittanceData(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.callCheckRecRemittanceData", trxMgntSC);
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_CHECK_REC_REMIT_DATA " + e.getMessage(),e);
	}
    }

    @Override
    public TrxMgntSC getTransactionAccount(TrxMgntSC trxMgntSC) throws DAOException
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.getTransactionAccount", trxMgntSC);
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_ATM_GET_TRX_ACCOUNT_EXT " + e.getMessage(),e);
	}
    }
    public TrxMgntSC getCheckIdVal(TrxMgntSC trxMgntSC) throws DAOException //Hala Al Sheikh - AIB100209
    {
	try
	{
	    getSqlMap().update("coreCommonProcedureMapper.getCheckIdVal", trxMgntSC);
	    return trxMgntSC;
	}
	catch(Exception e)
	{
	    throw new DAOException("Error in P_RET_GET_CHECKID " + e.getMessage(),e);
	}
    }
    
    
    /**
     * @author HusseinElhajj
     * Segmentation Convention
     */
    public AccountChargesSC retrieveSegCharges(AccountChargesSC accountChargesSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callRetRetriveSegCharges", accountChargesSC);
	accountChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountChargesSC.getErrorMessage()));
	return accountChargesSC;
    }
	
	
	/**
     * @author HusseinElhajj
     * Segmentation Convention
     */
    public AccountChargesSC saveSegmentationCharges (AccountChargesSC accountChargesSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callSaveSegmentationCharges", accountChargesSC);
	accountChargesSC.setErrorMessage(StringUtil.replaceProcedureMessage(accountChargesSC.getErrorMessage()));
	return accountChargesSC;
    }
    
    /**
     * @author RaniaAlBitar
     * Customers Segmentation Enhancement
     */
    public CustSegmentationSC executeSegmentationProcess(CustSegmentationSC custSegmentationSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.executeSegmentationProcess", custSegmentationSC);

	if(custSegmentationSC.getErrorMessage() != null)
	{
	    custSegmentationSC.setErrorMessage(StringUtil.replaceProcedureMessage(custSegmentationSC.getErrorMessage()));
	}
	return custSegmentationSC;
    }

    //Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
    public FOMRealBeneficiariesCO updateRealBenefRecords(FOMRealBeneficiariesCO fomRealBeneficiariesCO) throws DAOException
    {
        getSqlMap().update("coreCommonProcedureMapper.updateRealBenefRecords", fomRealBeneficiariesCO);
        fomRealBeneficiariesCO.setOsErrorDesc(StringUtil.replaceProcedureMessage(fomRealBeneficiariesCO.getOsErrorDesc()));
        return fomRealBeneficiariesCO;
    }
    
    public void callIncidentReportAlertProcedure(IncidentReportSC incidentReportSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callIncidentReportAlertProcedure", incidentReportSC);
	incidentReportSC.setErrorMessage(StringUtil.replaceProcedureMessage(incidentReportSC.getErrorMessage()));
    }
    
    //Hala Al Sheikh - NBINT130004
    public AccountSC callCheckCertificateData(AccountSC accountSC) throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.callCheckCertificateData", accountSC);
	accountSC.setErrMsg(StringUtil.replaceProcedureMessage(accountSC.getErrMsg()));
	return accountSC;
    }

    
    // added by nancy - 06/02/2018-613993-DASI180012 - Procedure on Certificate
    public TrxMgntSC checkCertificateCreation(TrxMgntSC trxMgntSC)throws DAOException
    {
	getSqlMap().update("coreCommonProcedureMapper.checkCertificateCreation", trxMgntSC);
	// return the Message by Eliminating Procedures Names between <# and #>
	if(trxMgntSC.getErrorMessage() != null)
	{
	    trxMgntSC.setErrorMessage(StringUtil.replaceProcedureMessage(trxMgntSC.getErrorMessage()));
	}
	return trxMgntSC;
    }
    // end nancy
    
    public List returnIisChargeDetails(ChargesRefundSC chargesRefundSC) throws DAOException
    {
	return getSqlMap().queryForList("coreCommonProcedureMapper.returnIisChargeDetails", chargesRefundSC,
		chargesRefundSC.getRecToskip(), chargesRefundSC.getNbRec());
    }

}
