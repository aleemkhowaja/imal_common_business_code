package com.path.bo.common.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.path.bo.admin.branches.BranchesBO;
import com.path.bo.common.CachedConstantsCommon;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.requests.csm.CtsRequestConstant;
import com.path.bo.common.signature.SignatureConstant;
import com.path.bo.core.account.AccountBO;
import com.path.bo.core.common.CoreCommonBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.currency.CurrencyBO;
import com.path.bo.core.mosblacklist.MosBlackListBO;
import com.path.bo.core.reason.ReasonBO;
import com.path.bo.core.teller.TellerBO;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.dao.common.CoreCommonDAO;
import com.path.dao.core.ciftype.CifTypeDAO;
import com.path.dbmaps.vo.ACC_NV_ADVICEVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CSM_CTRLVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSCONTROL_BY_COMPVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.dbmaps.vo.CTSTELLERACCTYPEDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.CTS_CONDITIONAL_AUTOMATIONVO;
import com.path.dbmaps.vo.CTS_MANUAL_JV_TMPVO;
import com.path.dbmaps.vo.CTS_REQUESTVO;
import com.path.dbmaps.vo.CTS_REQUEST_TYPEVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.dbmaps.vo.PROC_PRODUCT_PARAMVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_ADDREF_MASK_SPECIFICVO;
import com.path.dbmaps.vo.TFSBILLVO;
import com.path.dbmaps.vo.TFSLC1VO;
import com.path.dbmaps.vo.TFSLC2VO;
import com.path.dbmaps.vo.TFSLCREQUEST1VO;
import com.path.dbmaps.vo.TFSLCREQUEST2VO;
import com.path.dbmaps.vo.TFSLGVO;
import com.path.dbmaps.vo.TFSTRXVO;
import com.path.dbmaps.vo.YRTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.admin.genledger.GenLedgerCO;
import com.path.vo.common.DepositerSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.common.memo.MemoDtlCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.common.requests.csm.CtsRequestCO;
import com.path.vo.common.requests.csm.CtsRequestSC;
import com.path.vo.common.signature.SigCapSignatureCO;
import com.path.vo.common.signature.SignatureSC;
import com.path.vo.common.yrt.YRTSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.account.AccountsManagementCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ciftype.CifTypeSC;
import com.path.vo.core.common.CoreCommonCO;
import com.path.vo.core.common.CoreCommonSC;
import com.path.vo.core.conditionalautomation.ConditionalAutomationCO;
import com.path.vo.core.conditionalautomation.ConditionalAutomationSC;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomSC;
import com.path.vo.core.csmfom.ResultCO;
import com.path.vo.core.ctsreparg.CtsReportArgSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.gl.GLSC;
import com.path.vo.core.reason.ReasonSC;
import com.path.vo.core.specialconditions.SpecialConditionsCO;
import com.path.vo.core.teller.TellerSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;
import com.rits.cloning.Cloner;

public class CoreCommonBOImpl extends RetailBaseBO implements CoreCommonBO
{
    private static String trx_key = "TrxType";
    // NABIL FEGHALI - BB130085 - Global Payment File
    private static String trx_extended_key = "TrxTypeExtended";
    private CoreCommonDAO coreCommonDAO;
    private BranchesBO branchesBO;
    private CurrencyBO currencyBO;
    private TellerBO tellerBO;
    private MosBlackListBO mosBlackListBO;
    // NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    private AccountBO accountBO;
    private CifTypeDAO cifTypeDAO;
    private ReasonBO reasonBO; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    private CoreCommonCO coreCommonCO = new CoreCommonCO(); //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits

    /**
     * returning transaction type VO relative to specific type from cash if
     * available
     * 
     * @param CTSTRXTYPEVO trx type Object for which to return the Object
     * @return CTSTRXTYPEVO
     * @throws BaseException
     */
    public CTSTRXTYPEVO findTrxType(CTSTRXTYPEVO ctstrxtypeVO2) throws BaseException
    {
        CTSTRXTYPEVO ctstrxtypeVO = ctstrxtypeVO2;
        Assert.notNull(ctstrxtypeVO);
        Assert.notNull(ctstrxtypeVO.getCOMP_CODE());
        Assert.notNull(ctstrxtypeVO.getCODE());
        HashMap<String, HashMap> infoMap = CachedConstantsCommon.findInfo;
        HashMap<String, CTSTRXTYPEVO> trxTypeMap = infoMap.get(trx_key);
        boolean fetchDb = true;
        String trxTypeMapKey = ctstrxtypeVO.getCOMP_CODE() + "_" + ctstrxtypeVO.getCODE();
        if(trxTypeMap == null)
        {
            trxTypeMap = new HashMap<String, CTSTRXTYPEVO>();
            infoMap.put(trx_key, trxTypeMap);
        }
        else
        {
            CTSTRXTYPEVO ctstrxtypeVO1 = trxTypeMap.get(trxTypeMapKey);
            if(ctstrxtypeVO1 != null)
            {
                ctstrxtypeVO = ctstrxtypeVO1;
                fetchDb = false;
            }
        }

        if(fetchDb)
        {
            // ctstrxtypeVO = (CTSTRXTYPEVO) genericDAO.selectByPK(ctstrxtypeVO);
            ctstrxtypeVO = coreCommonDAO.returnTrxType(ctstrxtypeVO);
            if(null != ctstrxtypeVO)
            {
                /*
                 * checking on cr_dr_forex only
                 */
                if(TrxMgntConstant.DEPOSIT.equals(ctstrxtypeVO.getTYPE()))
                {
                    ctstrxtypeVO.setCR_DR_FOREX(TrxMgntConstant.FOREX_CREDITOR);
                }
                else if(TrxMgntConstant.WITHDRAWAL.equals(ctstrxtypeVO.getTYPE()))
                {
                    ctstrxtypeVO.setCR_DR_FOREX(TrxMgntConstant.FOREX_DEBTOR);
                }
                if(BigDecimal.ONE.equals(ctstrxtypeVO.getSO_ENDING_M()))
                {
                    ctstrxtypeVO.setDEFAULT_TRSCY("1");
                }
                trxTypeMap.put(trxTypeMapKey, ctstrxtypeVO);
            }
        }

        return ctstrxtypeVO;
    }

    /**
     * NABIL FEGHALI - BB130085 - Global Payment File
     * 
     * @param ctstrxtypeExtendedVO
     * @return
     * @throws BaseException
     */
    public CTSTRXTYPE_EXTENDEDVO findTrxTypeExtended(CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO2)
        throws BaseException
    {
        CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO = ctstrxtypeExtendedVO2;
        Assert.notNull(ctstrxtypeExtendedVO);
        Assert.notNull(ctstrxtypeExtendedVO.getCOMP_CODE());
        Assert.notNull(ctstrxtypeExtendedVO.getCODE());

        boolean fetchDb = true;
        HashMap<String, HashMap> infoMap = CachedConstantsCommon.findInfo;
        HashMap<String, CTSTRXTYPE_EXTENDEDVO> trxTypeExtendedMap = infoMap.get(trx_extended_key);
        String trxTypeExtendedMapKey = ctstrxtypeExtendedVO.getCOMP_CODE() + "_"
            + ctstrxtypeExtendedVO.getCODE();

        if(trxTypeExtendedMap == null)
        {
            trxTypeExtendedMap = new HashMap<String, CTSTRXTYPE_EXTENDEDVO>();
            infoMap.put(trx_extended_key, trxTypeExtendedMap);
        }
        else
        {
            CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO1 = trxTypeExtendedMap.get(trxTypeExtendedMapKey);
            if(ctstrxtypeExtendedVO1 != null)
            {
                ctstrxtypeExtendedVO = ctstrxtypeExtendedVO1;
                fetchDb = false;
            }
        }

        if(fetchDb)
        {
            ctstrxtypeExtendedVO = coreCommonDAO.returnTrxTypeExtended(ctstrxtypeExtendedVO);
            if(null != ctstrxtypeExtendedVO)
            {
                trxTypeExtendedMap.put(trxTypeExtendedMapKey, ctstrxtypeExtendedVO);
            }
        }

        return ctstrxtypeExtendedVO;
    }

    public int countTrxDRCRTYPE(TrxMgntSC trxMgntSC) throws BaseException
    {
        return coreCommonDAO.countTrxDRCRTYPE(trxMgntSC);
    }

    /**
     * istr_trxtype.db_acc
     * 
     * @param trxMgntSC
     * @return String
     * @throws BaseException
     */
    public String returnDBAccount(TrxMgntSC trxMgntSC) throws BaseException
    {
        StringBuffer db_acc = new StringBuffer();
        trxMgntSC.setDrCrType(TrxMgntConstant.ACCOUNT_SIGN_DEBIT);
        int trxDRTYPECount = countTrxDRCRTYPE(trxMgntSC);
        if(trxDRTYPECount > 0)
        {
            db_acc = new StringBuffer(TrxMgntConstant.ACCOUNT_SIGN_DEBIT);
        }

        trxMgntSC.setDrCrType(TrxMgntConstant.ACCOUNT_SIGN_CREDIT);
        trxDRTYPECount = countTrxDRCRTYPE(trxMgntSC);
        if(!"".equals(db_acc.toString()) && trxDRTYPECount > 0)
        {
            db_acc.append(TrxMgntConstant.ACCOUNT_SIGN_CREDIT);
        }
        else if(trxDRTYPECount > 0)
        {
            db_acc.append(TrxMgntConstant.ACCOUNT_SIGN_CREDIT);
        }
        return db_acc.toString();
    }

    public GEN_LEDGERVO returnValidGeneralLedger(GLSC criteria) throws BaseException
    {
        GEN_LEDGERVO genledgerVO = new GEN_LEDGERVO();
        genledgerVO.setCOMP_CODE(criteria.getCompCode());
        genledgerVO.setGL_CODE(criteria.getGlCode());

        genledgerVO = (GEN_LEDGERVO) genericDAO.selectByPK(genledgerVO);

        return genledgerVO;
    }

    public ArrayList<CTSREASONSVO> returnReasonDropDownData(ReasonSC ctsreasonsvo) throws BaseException
    {
        return coreCommonDAO.returnReasonDropDownData(ctsreasonsvo);
    }

    public CoreCommonDAO getCoreCommonDAO()
    {
        return coreCommonDAO;
    }

    public void setCoreCommonDAO(CoreCommonDAO coreCommonDAO)
    {
        this.coreCommonDAO = coreCommonDAO;
    }

    /**
     * this method checks if a user has closed his balance, if yes its throws an exception
     * in Pbd : N_transaction.uf_check_closed_bal
     */
    public void checkClosedBal(TrxMgntSC trxMgntSC) throws BaseException
    {
        if(coreCommonDAO.checkClosedBalance(trxMgntSC) >= 1)
        {
            throw new BOException(MessageCodes.USER_ALREADY_SETTLED_CASH_BAL);
        }
    }

    /**
     * guo_find_info.uf_find_cif_type
     * 
     * @param trxMgntSC
     * @return
     * @throws BaseException
     */
    public RIFCTTVO findCifType(BigDecimal compCode, BigDecimal TYPE_CODE) throws BaseException
    {
        RIFCTTVO rifCttVO = new RIFCTTVO();
        rifCttVO.setCOMP_CODE(compCode);
        rifCttVO.setTYPE_CODE(TYPE_CODE);
        rifCttVO = (RIFCTTVO) genericDAO.selectByPK(rifCttVO);

        if(rifCttVO == null)
        {
            throw new BOException(MessageCodes.INVALID_MISSING_ACCOUNT_TYPE);
        }

        return rifCttVO;
    }

    /**
     * in Pbd : dw_validate_col_properties
     */
    // public HashMap<String, PropertiesByTrxTypeCO> returnPropertiesByTrxType(PropertiesByTrxTypeSC
    // propByTrxTypeSC) throws BaseException
    // {
    // return (HashMap<String, PropertiesByTrxTypeCO>)
    // coreCommonDAO.returnPropertiesByTrxType(propByTrxTypeSC);
    // }

    /**
     * This Function checks If the chosen Gl is an Internal On B/S
     * This Function is the counterpart of f_get_glcode in PowerBuilder
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public GenLedgerCO checkAffectFlag(GLSC criteria) throws BaseException
    {
        GenLedgerCO genLedgerCO = new GenLedgerCO();

        GEN_LEDGERVO genledgerVO = coreCommonBO.returnValidGeneralLedger(criteria);
        genLedgerCO.setGenledgerVO(genledgerVO);

        if(null != genledgerVO)
        {
            if(null == genledgerVO.getBRIEF_DESC_ENG())
            {
                throw new BOException(MessageCodes.INVALID_MISSING_GENERAL_LEDGER); // 452
            }

            /*
             * We check if the GL is on balance sheet or not
             */
            if(!ConstantsCommon.XOR.equals(criteria.getBalanceSheet())
                && !genledgerVO.getBS_CONTRA().equals(criteria.getBalanceSheet()))
            {

                if(CoreCommonConstants.ON_BALANCE_SHEET.equals(genledgerVO.getBS_CONTRA()))
                {
                    throw new BOException(MessageCodes.NOT_VALID_BALANCE_SHEET_GL); // 453
                }
                else
                {
                    throw new BOException(MessageCodes.NOT_VALID_CONTRA_GL); // 1856
                }

            }

            if(!ConstantsCommon.XOR.equals(criteria.getGenLedgerType())
                && !genledgerVO.getGL_TYPE().equals(criteria.getGenLedgerType()))
            {
                if(ConstantsCommon.INTERNAL_GEN_LEDGER_TYPE.equals(criteria.getGenLedgerType()))
                {
                    throw new BOException(MessageCodes.NOT_VALID_INTERNAL_GL); // 1352
                }
                else if(ConstantsCommon.NON_INTERNAL_GEN_LEDGER_TYPE.equals(criteria.getGenLedgerType()))
                {
                    throw new BOException(MessageCodes.NOT_VALID_NON_INTERNAL_GL); // 1353
                }
            }
        }

        return genLedgerCO;

    }

    public List<BigDecimal> getTellerBranches(TellerSC tellerSC) throws BaseException
    {
        List<BigDecimal> branchList = new ArrayList<BigDecimal>();

        String showBranchCondition = tellerBO.returnShowBranchCondition(tellerSC);
        StringBuffer showBr = new StringBuffer();
        if(showBranchCondition != null)
        {
            showBr = new StringBuffer(showBranchCondition);
            
            if(showBranchCondition.equals("0"))
	    {
		showBr = null;
	    }
        }

        if(showBr == null || showBr.length() == 0)
        {
            showBr = new StringBuffer("L");
        }

        if("L".equalsIgnoreCase(showBr.toString()))
        {
            branchList.add(tellerSC.getBranchCode());
        }
        else if("A".equalsIgnoreCase(showBr.toString()))
        {
            BranchesSC criteria = new BranchesSC();
            criteria.setCompCode(tellerSC.getCompCode());
            branchList = branchesBO.getAllBranchId(criteria);
        }
        else if("S".equalsIgnoreCase(showBr.toString()))
        {
            branchList = tellerBO.getAllTellerBranches(tellerSC);
        }

        return branchList;
    }

    /**
     * returnBankCIF
     * 
     * @param FomSC
     * in Pbd : f_get_bankcif
     * @return
     */
    public FomCO returnBankCIF(FomSC criteria) throws BaseException
    {
        FomCO fomCO = coreCommonDAO.returnClientBankCIF(criteria);

        if(fomCO == null)
        {
            if (("true").equals(StringUtil.nullToEmpty(criteria.getNoMessageToDisplay())))/*DBU190684*/
            {
        	FomCO fomReturnedCO = new FomCO(); 
        	fomReturnedCO.setNoMessageToDisplay("true");
        	return fomReturnedCO;
            }
            throw new BOException(MessageCodes.INVALID_MISSING_BANK_CIF_CODE);
        }

        if(!"Y".equals(fomCO.getRifCttVO().getBANK()))
        {
            throw new BOException(MessageCodes.CIF_ENTERED_IS_NOT_A_BANK);
        }

        if(NCifMaintenanceConstant.CIF_SUSPENDED.equals(fomCO.getCifVO().getSTATUS()))
        {
            throw new BOException(MessageCodes.BANK_CIF_IS_SUSPENDED);
        }

        if(NCifMaintenanceConstant.CIF_DELETED.equals(fomCO.getCifVO().getSTATUS()))
        {
            throw new BOException(MessageCodes.BANK_CIF_IS_DELETED);
        }

        if(NCifMaintenanceConstant.CIF_INACTIVE.equals(fomCO.getCifVO().getSTATUS()))
        {//JAIZ190099 - Ability to do transaction through web service for inactive CIFs
            if(criteria.isProceedOnInactiveCIF())
            {
        	criteria.setThrowProceedOnInactiveCIFWarning(true);
            }
            else
            //JAIZ190099 - Ability to do transaction through web service for inactive CIFs
            {
            throw new BOException(MessageCodes.CIF_CODE_IS_INACTIVE);
            }
        }

        return fomCO;
    }

    public BigDecimal returnCIFNoOfBank(CifSC criteria) throws BaseException
    {
        return coreCommonDAO.returnCIFNoOfBank(criteria);
    }

    /**
     * returnClientCIF
     * 
     * @param FomSC
     * in Pbd : f_get_clientcif
     * @return
     */
    public FomCO returnClientCIF(FomSC criteria) throws BaseException
    {
        FomCO fomCO = coreCommonDAO.returnClientBankCIF(criteria);

        if(fomCO == null)
        {
            throw new BOException(MessageCodes.INVALID_MISSING_CLIENT_CIF_CODE);
        }

        if(!"Y".equals(fomCO.getRifCttVO().getCLIENT()))
        {
            throw new BOException(MessageCodes.CIF_ENTERED_IS_NOT_A_CLIENT);
        }

        if(NCifMaintenanceConstant.CIF_SUSPENDED.equals(fomCO.getCifVO().getSTATUS()))
        {
            throw new BOException(MessageCodes.CLIENT_CIF_IS_SUSPENDED);
        }

        if(NCifMaintenanceConstant.CIF_DELETED.equals(fomCO.getCifVO().getSTATUS()))
        {
            throw new BOException(MessageCodes.CLIENT_CIF_IS_DELETED);
        }

        if(NCifMaintenanceConstant.CIF_INACTIVE.equals(fomCO.getCifVO().getSTATUS()))
        {
            //JAIZ190099 - Ability to do transaction through web service for inactive CIFs
            if(criteria.isProceedOnInactiveCIF())
            {
        	criteria.setThrowProceedOnInactiveCIFWarning(true);
            }
            else
            //JAIZ190099 - Ability to do transaction through web service for inactive CIFs
            {
        	throw new BOException(MessageCodes.CLIENT_CIF_IS_INACTIVE);
            }
        }

        return fomCO;
    }

    /**
     * get the count of CIF Bank
     * 
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public Integer returnClientCIFCount(FomSC criteria) throws BaseException
    {
        Integer cpt;
        cpt = coreCommonDAO.returnClientBankCIFCount(criteria);
        return cpt;
    }

    /**
     * get the list of CIF Bank
     * 
     * @param criteria
     * @return List<FomCO>
     * @throws BaseException
     */
    public List<FomCO> returnClientCIFList(FomSC criteria) throws BaseException
    {
        List<FomCO> lst;
        lst = coreCommonDAO.returnClientBankCIFList(criteria);
        return lst;
    }

    /**
     * Getting required Data
     * 
     * @param trxMgntCO
     * @param criteria
     * @return
     * @throws BaseException
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> trxTypeMgntRequiredData(TrxMgntCO trxMgntCO,
        TrxMgntSC criteria) throws BaseException
    {
        /**
         * get the required Data ...
         */
        RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC();
        requiredFieldsSC.setTrxType(trxMgntCO.getCtstrsVO().getTRX_TYPE());
        // requiredFieldsSC.setElementName(propName);
        requiredFieldsSC.setCompCode(trxMgntCO.getLoginCompCode());
        requiredFieldsSC.setBranchCode(trxMgntCO.getLoginBraCode());
        requiredFieldsSC.setPreferredLanguage(trxMgntCO.getLoginPreferrredLanguage());
        requiredFieldsSC.setLoginUserId(criteria.getUserId());
        requiredFieldsSC.setAppName(trxMgntCO.getAppName());
        requiredFieldsSC.setCifNo(NumberUtil.emptyDecimalToZero(criteria.getCif()));
        if(NumberUtil.nullToZero(criteria.getTrsNo()).compareTo(BigDecimal.ZERO) == 1)
        {
            requiredFieldsSC.setTrsNo(criteria.getTrsNo());
        }
        if(null != criteria.getRequiredDataByCifNoOnly())
        {
            requiredFieldsSC.setRequiredDataByCifNoOnly(criteria.getRequiredDataByCifNoOnly());
        }
        requiredFieldsSC.setCbInd(TrxMgntConstant.CLIENT_CB_IND);
        requiredFieldsSC.setTrsType(TrxMgntConstant.TRS_TYPE_CSM);
        requiredFieldsSC.setCheckFomTrxDetails(criteria.getCheckFomTrxDetails());
        return commonLibBO.returnMapRequiredData(requiredFieldsSC);
    }

    

    /**
     * account details display management ....
     * 
     * @author marwanmaddah
     * @date Feb 20, 2013
     * @param trxMgntCO
     * @throws BaseException void
     * 
     */
    public void accountDtlDisplayMgnt(TrxMgntCO trxMgntCO) throws BaseException
    {
        CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
        ctsTrxTypeVO.setCOMP_CODE(trxMgntCO.getLoginCompCode());
        ctsTrxTypeVO.setCODE(trxMgntCO.getTrxType());
        ctsTrxTypeVO.setSTATUS(TrxMgntConstant.STATUS_APPROVE);
        ctsTrxTypeVO = findTrxType(ctsTrxTypeVO);
        trxMgntCO.setCtstrxtypeVO(ctsTrxTypeVO);

        if(TrxMgntConstant.CLEARING_CHEQUE.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO()
            .getCHQ_RELATED())))
        {
            if(TrxMgntConstant.TRANSFER.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getTYPE()))
                && NumberUtil.nullToZero(trxMgntCO.getCtstrxtypeVO().getTRSFR_TYPE()).compareTo(
                    BigDecimal.valueOf(3)) == 0
                && "1".equals(StringUtil
                    .nullToEmpty(trxMgntCO.getCtstrxtypeVO().getSHOW_INTERNATIONAL_CHQ_NO()))
                && TrxMgntConstant.MULTI_TRX.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO()
                    .getMULTI_TRX())))
            {
                trxMgntCO.setHid_CHQ_NUM("true");
            }
        }
        else if(TrxMgntConstant.HOUSE_CHEQUE.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO()
            .getCHQ_RELATED()))
            && (!TrxMgntConstant.TRANSFER.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getTYPE())) || !"1"
                .equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getUTILITY_PAYMENT()))))
        {
            if(!"Q".equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrsVO().getTRSFR_METHOD()))
                && TrxMgntConstant.TRANSFER.equals(StringUtil
                    .nullToEmpty(trxMgntCO.getCtstrxtypeVO().getTYPE()))
                && TrxMgntConstant.MULTI_TRX.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO()
                    .getMULTI_TRX())))
            {
                trxMgntCO.setHid_CHQ_NUM("true");
            }
        }
        else if(TrxMgntConstant.TRANSFER.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getTYPE()))
            && "1".equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getUTILITY_PAYMENT()))
            && !"Q".equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrsVO().getTRSFR_METHOD()))
            && TrxMgntConstant.MULTI_TRX.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO()
                .getMULTI_TRX())))
        {
            trxMgntCO.setHid_CHQ_NUM("true");
        }
        else
        {
            if(TrxMgntConstant.MULTI_TRX.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO()
                .getMULTI_TRX())))
            {
                trxMgntCO.setHid_CHQ_NUM("true");
            }
        }

        /** Default **/
        if("E".equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getSO_TYPE())))
        {
            if(TrxMgntConstant.MULTI_TRX.equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO()
                .getMULTI_TRX())))
            {
                if("C".equals(StringUtil.nullToEmpty(trxMgntCO.getCtstrxtypeVO().getCR_DR_FOREX())))
                {
                    trxMgntCO.setHid_SO_PERC("true");
                    trxMgntCO.setHid_SO_PERC_MIN("true");
                    trxMgntCO.setHid_SO_PERC_MAX("true");
                }
                else
                {
                    trxMgntCO.setHid_SO_PERC_MIN("true");
                    trxMgntCO.setHid_SO_PERC_MAX("true");
                }
            }
            else
            {
                trxMgntCO.setHid_SO_PERC("true");
                trxMgntCO.setHid_SO_PERC_MIN("true");
                trxMgntCO.setHid_SO_PERC_MAX("true");
            }
        }
        else
        {
            trxMgntCO.setHid_SO_PERC("true");
            trxMgntCO.setHid_SO_PERC_MIN("true");
            trxMgntCO.setHid_SO_PERC_MAX("true");
        }
    }

    /**
     * this functions is used to check the digit of the civilid(pb
     * :f_getcivilidcheckdigit)
     * 
     * @param idno
     * @param inwardOutWardclrChq
     * @return
     * @throws BaseException
     */
    public int returnCivilIdCheckDigit(String idno, String inwardOutWardclrChq) throws BaseException
    {

        int sum;
        int intNumber = 0;
        int modResult;
        String character;
        int returnValue = 1;

        if(ConstantsCommon.BMA_BAHREIN.toString().equals(inwardOutWardclrChq))
        {
            if((checkCivilIdBh(idno)) == -1)
            {
                returnValue = -1;
            }

        }
        //Hala Al Sheikh - AIB100209
        else if(ConstantsCommon.PMA_Palestine.toString().equals(inwardOutWardclrChq))
        {
            TrxMgntSC trxMgntSC = new TrxMgntSC();
            trxMgntSC.setIdNo(idno);
            trxMgntSC = coreCommonProcedureBO.getCheckIdVal(trxMgntSC);
            returnValue = trxMgntSC.getIdNoReturnVal();
            //id:991925 Details:System is not displaying the stopper message "Invalid Entry" even if a invalid Civil ID is used
            if( !(idno.substring(idno.length() - 1).equals(returnValue+"")))
            {
            returnValue=-1;
            }
            //id:991925 Details:System is not displaying the stopper message "Invalid Entry" even if a invalid Civil ID is used
        }
        //End Hala
        else
        {
            if(ConstantsCommon.CBK_KUWAIT.toString().equals(inwardOutWardclrChq))
            {
                sum = 0;

                if(idno.length() >= 1)
                {
                    character = idno.substring(0, 1);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 2;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }

                if(idno.length() >= 2)
                {
                    character = idno.substring(1, 2);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 1;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }
                if(idno.length() >= 3)
                {
                    character = idno.substring(2, 3);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 6;
                    sum = sum + intNumber;
                }
                if(idno.length() >= 4)
                {
                    character = idno.substring(3, 4);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 3;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }

                if(idno.length() >= 5)
                {
                    character = idno.substring(4, 5);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 7;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }

                if(idno.length() >= 6)
                {
                    character = idno.substring(5, 6);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 9;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }

                if(idno.length() >= 7)
                {
                    character = idno.substring(6, 7);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 10;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }
                if(idno.length() >= 8)
                {
                    character = idno.substring(7, 8);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 5;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }

                if(idno.length() >= 9)
                {
                    character = idno.substring(8, 9);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 8;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }

                if(idno.length() >= 10)
                {
                    character = idno.substring(9, 10);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 4;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }
                if(idno.length() >= 11)
                {
                    character = idno.substring(10, 11);
                    intNumber = NumberUtil.toInteger(character);
                    intNumber = intNumber * 2;
                    sum = sum + intNumber;
                }
                else
                {
                    intNumber = 0;
                }

                modResult = sum % 11;
                modResult = 11 - modResult;
                //
                if(idno.length() >= 12)
                {
                    character = idno.substring(11, 12);
                    intNumber = NumberUtil.toInteger(character);
                }
                else
                {
                    intNumber = 0;
                }
                if(intNumber != modResult)
                {
                    returnValue = -1;
                }

            }
        }

        return returnValue;
    }

    /**
     * this function checks the civild validity onlyIf the country == 3 then
     * //BMA :BAHRAIN
     * 
     * @param civilId
     * @return
     * @throws BOException
     */
    public int checkCivilIdBh(String civilId) throws BaseException
    {

        int i, a, last, rem, check, sum, len;
        String character;
        i = 1;
        a = 1;
        sum = 0;
        int lenCivil = civilId.length();

        //id:793794 Details:SUPT190019 - AUB - Upgrade Issues on FOM TAR:SUPT190019 
        //as per pb we must start from second character from left to the last character from left
        // and the first character from left will be checked with reminder
        for(len = lenCivil-1; len - 1 >= 0; len = len - 1)
        {

            character = civilId.substring(len-1, len);

            a++;
            sum = sum + Integer.parseInt(character) * a;
        }

        rem = (sum % 11);

        if((rem == 0 || rem == 1))
        {
            check = 0;
        }
        else
        {
            check = 11 - rem;
        }

        last = Integer.parseInt(civilId.substring(lenCivil-1, lenCivil));

        if(check != last)
        {
            return -1;
        }

        return 0;
    }

    /**
     * [MARWAN]: return CSM Control VO
     * 
     * @return
     * @throws BaseException
     */
    public CSM_CTRLVO returnCsmControls() throws BaseException
    {
        CSM_CTRLVO csmControlVO = new CSM_CTRLVO();
        csmControlVO.setLINE_NO(BigDecimal.ONE);
        return commonLibBO.returnCSMControlDetails(csmControlVO);
    }

    public void setBranchesBO(BranchesBO branchesBO)
    {
        this.branchesBO = branchesBO;
    }

    public void setTellerBO(TellerBO tellerBO)
    {
        this.tellerBO = tellerBO;
    }

    public CurrencyBO getCurrencyBO()
    {
        return currencyBO;
    }

    public void setCurrencyBO(CurrencyBO currencyBO)
    {
        this.currencyBO = currencyBO;
    }

    /**
     * [Jihad]: this function is used to concatenate the label key with its
     * place
     * 
     * @return
     * @throws
     */
    // 
    public String[] returnSectionName(String labelKey, String sectionName, String DefaultLablel)
    {

        return new String[] {StringUtil.nullEmptyToValue(labelKey, DefaultLablel), "/",
            StringUtil.nullEmptyToValue(sectionName, "")};
    }

    /**
     * return the list of transaction type
     * that the type of the transaction define in the criteria can be linked to
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public CTSTRXTYPEVO linkToTrxTypes(TrxMgntSC criteria) throws BaseException
    {
        return coreCommonDAO.linkToTrxTypes(criteria);
    }

    /**
     * 
     * @param tellerAccTypeDetVO
     * @return
     * @throws BaseException
     */
    public Integer checkAccessOnGlType(CTSTELLERACCTYPEDETVO tellerAccTypeDetVO) throws BaseException
    {
        return coreCommonDAO.checkAccessOnGlType(tellerAccTypeDetVO);
    }

    /**
     * check Id No
     * 
     * @param depositerSC
     * @param comCode required
     * @param PreferrredLanguage required
     * @param depositerId (or id No) required
     * @param IdType not required
     * @param cifNo not required
     * @param CheckIdTypesLength equal true if you need to check between Id No length and
     * (ID_TYPE.FROM_LEN, ID_TYPE.TO_LEN)
     * @param showSuspicious should set true if you need to call the function wf_show_suspicious
     * @param mosBlackListedStatus if you need add status condition on mos blacklisted
     * @return WarningMessages if exists
     * @throws BaseException
     */
    public DepositerSC checkIdNo(DepositerSC depositerSC) throws BaseException
    {
        String depositerId = depositerSC.getDepositerId();
        BigDecimal idType = BigDecimal.valueOf(-1);
        if(!NumberUtil.isEmptyDecimal(depositerSC.getIdType()))
        {
            idType = depositerSC.getIdType();
        }

        if(depositerId != null && !"".equals(depositerId))
        {
            CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
            cifControlVO.setCOMP_CODE(depositerSC.getCompCode());
            cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
            /*
             * check mos black listed
             */
            checkMosBlackList(depositerSC);
            /*
             * Check ID No. Length Limits
             */
            ID_TYPESVO idTypesVO = new ID_TYPESVO();
            idTypesVO.setCOMP_CODE(depositerSC.getCompCode());
            idTypesVO.setCODE(idType);
            idTypesVO = (ID_TYPESVO) genericDAO.selectByPK(idTypesVO);
            
            /*
             * Invalid ID Type
             */
            if(idTypesVO == null)
            {
                throw new BOException(MessageCodes.INVALID_ID_TYPE);
            }
            
            if("true".equals(depositerSC.getCheckIdTypesLength())
                && idTypesVO != null
                && ((idTypesVO.getFROM_LEN() != null && idTypesVO.getFROM_LEN().compareTo(BigDecimal.ZERO) != 0) || (idTypesVO
                    .getTO_LEN() != null && idTypesVO.getTO_LEN().compareTo(BigDecimal.ZERO) != 0)))
            {
                if((depositerId.trim()).length() < idTypesVO.getFROM_LEN().intValue()
                    || (depositerId.trim()).length() > idTypesVO.getTO_LEN().intValue())
                {
                    throw new BOException(MessageCodes.THE_LENGTH_OF_ID_NO, new String[] {
                        idTypesVO.getFROM_LEN().toString(), idTypesVO.getTO_LEN().toString()});
                }
            }
            else
            {
                /*
                 * civil id
                 */
                if(idTypesVO != null && idTypesVO.getTYPES() != null && "1".equals(idTypesVO.getTYPES())
                    && cifControlVO.getCID_LENGH() != null
                    && cifControlVO.getCID_LENGH().compareTo(BigDecimal.ZERO) != 0
    			&& ((depositerId.trim()).length() > cifControlVO.getCID_LENGH().intValue() ))
                {
                    throw new BOException(MessageCodes.ID_LENGHT_SHOULD_BE_EQUAL_TO_NUMBERS,
                        new String[] {cifControlVO.getCID_LENGH().toString()});
                }
            }
            /*
             * civil id
             */
            if(idTypesVO != null
		    && (ConstantsCommon.DEFAULT_DATA_TYPE.equals(idTypesVO.getDATA_TYPE()) || (ConstantsCommon.NUMERIC_DATA_TYPE
			    .equals(idTypesVO.getDATA_TYPE()) && "1".equals(idTypesVO.getTYPES()))))
	    {
		/*
		 * civil id
		 */
		if("1".equals(idTypesVO.getTYPES()))
		{
		    /*
		     * Check if numeric
		     */
		    if(!NumberUtil.isNumber(depositerId))
		    {
			throw new BOException(MessageCodes.PLEASE_ENTER_A_VALID_NUMBER);
		    }
		    /*
		     * check civil id if validate equal 1
		     */
		    String validateId = "0";
		    if(NumberUtil.isEmptyDecimal(depositerSC.getCifNo()))
		    {
			validateId = cifControlVO.getVALIDATE_ID();

		    }
		    else
		    {
			validateId = coreCommonDAO.returnValidateIdByCif(depositerSC);
		    }
		    depositerSC.setValidateId(validateId);
		    if("1".equals(validateId))
		    {
			CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
			ctsControlVO.setCOMP_CODE(depositerSC.getCompCode());
			ctsControlVO.setBRANCH_CODE(depositerSC.getBranchCode());
			ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);
			/*
			 * CHECK DIGIT ID
			 */
			int resultCheck = returnCivilIdCheckDigit(depositerId, ctsControlVO.getINWARD_OUTWARD_CLR_CHQ());
			if(resultCheck == -1)
			{
			    throw new BOException(MessageCodes.INVALID_ENTRY);
			}
		    }
		}
	    }
            else
            {
        	if((ConstantsCommon.ALPHA_DATA_TYPE.equals(idTypesVO.getDATA_TYPE()) && !StringUtil.isAlpha(
                        depositerId, true))
                        || (ConstantsCommon.NUMERIC_DATA_TYPE.equals(idTypesVO.getDATA_TYPE()) && !NumberUtil
                            .isNumber(depositerId))
                        || (ConstantsCommon.ALPHA_NUMERIC_DATA_TYPE.equals(idTypesVO.getDATA_TYPE()) && !StringUtil
                            .isAlphaAndNumeric(depositerId, true)))
                    {
                        throw new BOException(MessageCodes.INVALID_MISSING_ID_NO);
                    }
            }
        }
        return depositerSC;
    }

    private void checkMosBlackList(DepositerSC depositerSC) throws BaseException
    {
        BigDecimal idType = BigDecimal.valueOf(-1);
        MosBlackListSC mosBlackListSC = new MosBlackListSC();
        mosBlackListSC.setCompCode(depositerSC.getCompCode());
        mosBlackListSC.setIdNo(depositerSC.getDepositerId());
        if(!NumberUtil.isEmptyDecimal(depositerSC.getIdType()))
        {
            idType = depositerSC.getIdType();
        }
        mosBlackListSC.setlIdType(idType);
        mosBlackListSC.setStatus(depositerSC.getMosBlackListedStatus());
        List<BigDecimal> mosBlackListCodes = mosBlackListBO.returnBlackListByID(mosBlackListSC);
        if(mosBlackListCodes != null && !mosBlackListCodes.isEmpty())
        {
            String warningMessage = commonLibBO.returnTranslErrorMessage(MessageCodes.REQUESTER_IS_BLACKLISTED,
                depositerSC.getPreferredLanguage());
            depositerSC.setWarningMessages(warningMessage);
        }
        // if("true".equals(depositerSC.getShowSuspicious()))
        // {
        // //wf_show_suspicious()
        // }
    }

    /**
     * // This Function checks the CIF age against the min and max age defined
     * in // RIFCTT, and RIFATT
     */
    public ResultCO checkCifAge(Date dateBirthParam, CifTypeSC cifTypeSC) throws BaseException
    {
        Date dateBirth = dateBirthParam;
        ResultCO result = new ResultCO();
        // result.setMessage
        Date sysDate = cifTypeSC.getRunningDate();
        if(cifTypeSC.getRunningDate() == null)
        {
            sysDate = commonLibBO.returnSystemDateNoTime();
        }

        RIFCTTVO rifcttVO = new RIFCTTVO();
        RIFATTVO rifattVO = new RIFATTVO();
        if(cifTypeSC.getMinAgeByAccountType() != null && cifTypeSC.getMinAgeByAccountType())
        {
            rifattVO.setCOMP_CODE(cifTypeSC.getCompCode());
            rifattVO.setTYPE_CODE(cifTypeSC.getGlCode());
            rifattVO = commonLibBO.returnRIFATTInfo(rifattVO);
        }
        else
        {
            cifTypeSC.setVtIndicator(NCifMaintenanceConstant.CIF_IS_INDIVIDUAL);
            cifTypeSC.setClientIndicator(NCifMaintenanceConstant.CIF_IS_CLIENT);
            rifcttVO = cifTypeDAO.returnCifAgeDet(cifTypeSC);
        }

        if(rifcttVO != null && rifattVO != null)
        {
            int minAge = 0;
            int minAgeProceed = 0;
            if(cifTypeSC.getMinAgeByAccountType() != null && cifTypeSC.getMinAgeByAccountType())
            {
                minAge = NumberUtil.nullToZero(rifattVO.getMIN_AGE()).intValue();
                minAgeProceed = NumberUtil.toInt(NumberUtil.nullToZero(rifattVO.getMIN_AGE_PROCEED()));
            }
            else
            {
                minAge = NumberUtil.nullToZero(rifcttVO.getMIN_AGE()).intValue();
                minAgeProceed = NumberUtil.nullToZero(rifcttVO.getMIN_AGE_PROCEED()).intValue();
            }
            boolean checkMinAge = false;
            // if the critiria is both or minimum check the minimum age
            if(StringUtil.nullEmptyToValue(cifTypeSC.getCheckMinMaxAge(), "B").equals("B")
                || StringUtil.nullEmptyToValue(cifTypeSC.getCheckMinMaxAge(), "B").equals("MIN"))
            {
                checkMinAge = true;
            }

            boolean checkMaxAge = false;
            // if the criteria is both or minimum check the minimum age
            if(StringUtil.nullEmptyToValue(cifTypeSC.getCheckMinMaxAge(), "B").equals("B")
                || StringUtil.nullEmptyToValue(cifTypeSC.getCheckMinMaxAge(), "B").equals("MAX"))
            {
                checkMaxAge = true;
            }

            // In case of accountType the checking is done on min age only
            if(cifTypeSC.getMinAgeByAccountType() != null && cifTypeSC.getMinAgeByAccountType())
            {
                checkMaxAge = false;
            }

            // Min Age
            if(minAge != 0 && (checkMinAge))
            {

                if((dateBirth == null) && (minAgeProceed != 1))
                {
                    // Age of CIF is less than the minimum age.
                    throw new BOException(MessageCodes.AGE_LESS_MINIMUM_AGE);
                }
                dateBirth = DateUtil.nullToInitDate(dateBirth);
                // Calendar cal=DateUtil.getDateWithoutTime(sysDate);

                int year = DateUtil.getDayYearMonth(sysDate, DateUtil.YEAR).intValue()
                    - DateUtil.getDayYearMonth(dateBirth, DateUtil.YEAR).intValue();
                if((year < minAge)
                    || ((year == minAge) && ((DateUtil.getDayYearMonth(sysDate, DateUtil.MONTH).compareTo(
                        DateUtil.getDayYearMonth(dateBirth, DateUtil.MONTH)) < 0) || ((DateUtil
                        .getDayYearMonth(sysDate, DateUtil.MONTH).compareTo(
                            DateUtil.getDayYearMonth(dateBirth, DateUtil.MONTH)) == 0) && (DateUtil
                        .getDayYearMonth(sysDate, DateUtil.DAY).compareTo(
                            DateUtil.getDayYearMonth(dateBirth, DateUtil.DAY)) < 0)))))
                {
                    if(minAgeProceed == 1)
                    {
                        result.setIntegerResut(MessageCodes.AGE_LESS_MINIMUM_AGE);
                        result.setIntegerMsgType(ConstantsCommon.WARNING_INFO_MSG_TYPE);
                    }
                    else
                    {
                        if(StringUtil.nullToEmpty(cifTypeSC.getNoExceptionMsg()).equals(""))
                        {
                            throw new BOException(MessageCodes.AGE_LESS_MINIMUM_AGE);
                        }
                        else
                        {
                            result.setIntegerResut(MessageCodes.AGE_LESS_MINIMUM_AGE);
                            result.setIntegerMsgType(ConstantsCommon.ERROR_MSG_TYPE);
                        }
                    }
                }
            }

            int maxAge = NumberUtil.nullToZero(rifcttVO.getMAX_AGE()).intValue();
            String maxAgeProceed = StringUtil.nullToEmpty(rifcttVO.getMAX_AGE_PROCEED());
            if(maxAge != 0 && (checkMaxAge))
            {
                int year = DateUtil.getDayYearMonth(sysDate, "y").intValue()
                    - DateUtil.getDayYearMonth(dateBirth, "y").intValue();
                if((year > maxAge)
                    || ((year == maxAge) && ((DateUtil.getDayYearMonth(sysDate, "m").compareTo(
                        DateUtil.getDayYearMonth(dateBirth, "m")) > 0) || ((DateUtil.getDayYearMonth(sysDate,
                        "m").compareTo(DateUtil.getDayYearMonth(dateBirth, "m")) == 0) && (DateUtil
                        .getDayYearMonth(sysDate, "d").compareTo(DateUtil.getDayYearMonth(dateBirth, "d")) > 0)))))
                {

                    if("1".equals(maxAgeProceed))
                    {
                        result.setIntegerResut(MessageCodes.AGE_MORE_MAXIMUM_AGE);
                        result.setIntegerMsgType(ConstantsCommon.WARNING_INFO_MSG_TYPE);
                    }
                    else
                    {
                        // Age of CIF is less than the maximum age.
                        if(StringUtil.nullToEmpty(cifTypeSC.getNoExceptionMsg()).equals(""))
                        {
                            throw new BOException(MessageCodes.AGE_MORE_MAXIMUM_AGE);
                        }
                        else
                        {
                            result.setIntegerResut(MessageCodes.AGE_MORE_MAXIMUM_AGE);
                            // result.setIntegerMsgType(ConstantsCommon.ERROR_MSG_TYPE);
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * this function is used to check the accountr period if it's not defined or
     * closed
     * 
     * @PB : wf_check_acc_period
     * @param compCode
     * @param branchCode
     * @param runningDate
     * @throws BaseException
     */
    public YRTVO checkYrtPeriod(BigDecimal compCode, BigDecimal branchCode, Date runningDate)
        throws BaseException
    {
        YRTSC yrtSC = new YRTSC();
        Calendar cal = Calendar.getInstance();
        cal.setTime(commonLibBO.addSystemTimeToDate(runningDate));
        yrtSC.setCompCode(compCode);
        yrtSC.setBranchCode(branchCode);
        yrtSC.setMonth(new BigDecimal(cal.get(Calendar.MONTH)).add(BigDecimal.ONE));
        yrtSC.setYear(new BigDecimal(cal.get(Calendar.YEAR)));
        YRTVO yrtVO = commonLibBO.returnYrtDetails(yrtSC);

        // if no record is found we send a message : A/C period for transactio
        // date is not defined

        if(yrtVO == null)
        {
            throw new BOException(MessageCodes.ACC_PERIOD_NOT_DEFINED);
        }
        // if status ='C': A/C period for transaction date is closed
        {
            String status = yrtVO.getSTATUS();
            if(ConstantsCommon.YEAR_STATUS_CLOSED.equals(status))
            {
                throw new BOException(MessageCodes.ACC_PERIOD_CLOSED);
            }
        }

        return yrtVO;
    }

    public List<CIFCO> authorizedSigList(CifSC cifSC) throws BaseException
    {

        return coreCommonDAO.authorizedSigList(cifSC);

    }

    public void setMosBlackListBO(MosBlackListBO mosBlackListBO)
    {
        this.mosBlackListBO = mosBlackListBO;
    }

    public String soundexEg(String name1) throws BaseException
    {
        String caracter;
        String result = "";
        String name = name1.trim().toUpperCase().replace("MINOR", ""); // check if i
        // have to use
        // replaceInString
        // below used.
        caracter = StringUtil.substring(name, 4);

        if(caracter.compareTo("AL ") == 0 || caracter.compareTo("EL ") == 0 || caracter.compareTo("EL-") == 0
            || caracter.compareTo("AL-") == 0)
        {
            name = name.substring(4, name.length());
        }
        name = StringUtil.replaceInString(name, " AL-", "1");
        name = StringUtil.replaceInString(name, " EL-", "1");
        name = StringUtil.replaceInString(name, " AL ", "1");
        name = StringUtil.replaceInString(name, " EL ", "1");
        name = StringUtil.replaceInString(name, " MR ", "1");
        name = StringUtil.replaceInString(name, " MR. ", "1");
        name = StringUtil.replaceInString(name, " MRS ", "1");
        name = StringUtil.replaceInString(name, " MRS. ", "1");
        name = StringUtil.replaceInString(name, " SIR ", "1");
        name = StringUtil.replaceInString(name, " SIR. ", "1");
        name = StringUtil.replaceInString(name, " DE ", "1");

        name = StringUtil.replaceInString(name, "SH", "0");
        name = StringUtil.replaceInString(name, "CH", "0");
        name = StringUtil.replaceInString(name, "PH", "F");

        name = StringUtil.replaceInString(name, "GH", "G");
        name = StringUtil.replaceInString(name, "KH", "C");

        name = StringUtil.replaceInString(name, "K", "C");
        name = StringUtil.replaceInString(name, "Q", "C");
        name = StringUtil.replaceInString(name, "J", "G");
        name = StringUtil.replaceInString(name, "T", "D");
        name = StringUtil.replaceInString(name, "V", "F");

        // Remove the double consonance
        name = StringUtil.replaceInString(name, "BB", "B");
        name = StringUtil.replaceInString(name, "CC", "C");
        name = StringUtil.replaceInString(name, "DD", "D");
        name = StringUtil.replaceInString(name, "FF", "F");
        name = StringUtil.replaceInString(name, "GG", "G");
        name = StringUtil.replaceInString(name, "HH", "H");
        name = StringUtil.replaceInString(name, "JJ", "J");
        name = StringUtil.replaceInString(name, "KK", "K");
        name = StringUtil.replaceInString(name, "LL", "L");
        name = StringUtil.replaceInString(name, "MM", "M");
        name = StringUtil.replaceInString(name, "NN", "N");
        name = StringUtil.replaceInString(name, "PP", "P");
        name = StringUtil.replaceInString(name, "QQ", "Q");
        name = StringUtil.replaceInString(name, "RR", "R");
        name = StringUtil.replaceInString(name, "SS", "S");
        name = StringUtil.replaceInString(name, "TT", "T");
        name = StringUtil.replaceInString(name, "VV", "V");
        name = StringUtil.replaceInString(name, "XX", "X");
        name = StringUtil.replaceInString(name, "ZZ", "Z");

        for(int i = 1; i < name.length(); i++)
        {
            caracter = name.substring(i, i + 1);
            if(caracter.indexOf("BCDFGHJKLMNPQRSTVWXYZ0") > 0)
            {
                result = result.concat(caracter);
            }
        }
        return result;
    }

    @Override
    public String returnNationalityDescription(CifSC cifSC) throws BaseException
    {
        return coreCommonDAO.returnNationalityDescription(cifSC);
    }

    /**
     * returnCheckdigit
     * in pbd : f_getcheckdigit
     * 
     * @param cifSC
     * @return
     * @throws BaseException
     */
    public String returnCheckdigit(String cardNum) throws BaseException
    {
        if(null == cardNum || "".equals(cardNum))
        {
            return "0";
        }

        StringBuffer temp = new StringBuffer();
        char[] chars = cardNum.toCharArray();
        for(int i = 0; i < chars.length; i++)
        {
            if(Character.getNumericValue(chars[i]) % 2 == 0)
            {
                temp.append(chars[i]);
            }
            else
            {
                temp.append(Character.getNumericValue(chars[i]) * 2);
            }
        }

        int sum = 0;
        chars = temp.toString().toCharArray();
        for(int i = 0; i < chars.length; i++)
        {
            sum += Character.getNumericValue(chars[i]); // Integer.valueOf(chars[i]).intValue();
        }

        if(sum % 10 == 0)
        {
            return "0";
        }

        return String.valueOf(10 - (sum % 10));
    }

    /**
     * Adding business rules to the HashMap (check only mandatory fields on save, check all business
     * rules on dependency and on load)
     * 
     * @param coreCommonCO
     * @return HashMap
     * @throws BaseException
     */
    public SYS_PARAM_SCREEN_DISPLAYVO addBusinessEltScreenDisplay(CoreCommonCO coreCommonCO)
        throws BaseException
    {
        String elementId = coreCommonCO.getElementId();
        String elementName = coreCommonCO.getElementName();
        String actionType = coreCommonCO.getActionType();
        String value = coreCommonCO.getValue();
        String actionStr = coreCommonCO.getActionStr();

        /**
         * get the required Data from DET table(rifctt_det or ctstrxtype_det)...
         */
        RequiredFieldsSC criteria = new RequiredFieldsSC();
        criteria.setAppName(coreCommonCO.getAppName());
        criteria.setLangCode(coreCommonCO.getLanguage());
        criteria.setProgRef(coreCommonCO.getOpt());
        criteria.setCompCode(coreCommonCO.getLoginCompCode());

        if(ConstantsCommon.CIF_APP_NAME.equals(coreCommonCO.getScreenSrc()))
        {
            criteria.setCifType(coreCommonCO.getCifType());
        }
        if(ConstantsCommon.TRX_APP_NAME.equals(coreCommonCO.getScreenSrc()))
        {
            criteria.setTrxType(coreCommonCO.getTrxType());
        }

        HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> requiredMap = commonLibBO.returnMapRequiredData(criteria);
        SYS_PARAM_SCREEN_DISPLAYVO requiredObj;

        if(!"".equals(StringUtil.nullToEmpty(elementId)) && requiredMap.containsKey(elementId))
        {
            requiredObj = requiredMap.get(elementId);
        }
        else if(!"".equals(StringUtil.nullToEmpty(elementName)) && requiredMap.containsKey(elementName))
        {
            requiredObj = requiredMap.get(elementName);
        }
        else
        {
            requiredObj = new SYS_PARAM_SCREEN_DISPLAYVO();
            requiredObj.setELEMENT_ID(elementId);
            requiredObj.setELEMENT_NAME(elementName);
        }

        /**
         * get Displayed Data, which means the HM already filled within the same process,
         * i.e: first line in dependency of x field, we set displayResultMap.Mandatory ='1', in the
         * second line,
         * when calling this method to set the visibility to '1',
         * not to loose the mandatory value already set in the first line
         */
        boolean existRequiredData = true;
        HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> displayResultMap = coreCommonCO.getBuisnessElement();
        SYS_PARAM_SCREEN_DISPLAYVO requiredMapBusElt = new SYS_PARAM_SCREEN_DISPLAYVO();

        if(!"".equals(StringUtil.nullToEmpty(elementId)) && displayResultMap.containsKey(elementId))
        {
            requiredMapBusElt = displayResultMap.get(elementId);
        }
        else if(!"".equals(StringUtil.nullToEmpty(elementName)) && displayResultMap.containsKey(elementName))
        {
            requiredMapBusElt = displayResultMap.get(elementName);
        }
        else
        {
            if(!"".equals(StringUtil.nullToEmpty(elementId)) && requiredMap.containsKey(elementId))
            {
                requiredMapBusElt = requiredMap.get(elementId);
            }
            else if(!"".equals(StringUtil.nullToEmpty(elementName)) && requiredMap.containsKey(elementName))
            {
                requiredMapBusElt = requiredMap.get(elementName);
            }
            else
            {
                existRequiredData = false;
            }
        }

        if(NumberUtil.emptyDecimalToZero(requiredMapBusElt.getMAX_LENGTH()).compareTo(BigDecimal.ZERO) == 0)
        {
            requiredMapBusElt.setMAX_LENGTH(null);
        }

        if(StringUtil.nullToEmpty(requiredMapBusElt.getDecFormat()).equals(""))
        {
            requiredMapBusElt.setDecFormat(null);
        }

        if(NumberUtil.isEmptyDecimal(requiredMapBusElt.getLEAD_ZEROS()))
        {
            requiredMapBusElt.setLEAD_ZEROS(null);
        }

        if(NumberUtil.nullToZero(requiredMapBusElt.getZERO_NOT_ALLOWED()).intValue() == 0)
        {
            requiredMapBusElt.setZERO_NOT_ALLOWED(null);
        }

        if(NumberUtil.isEmptyDecimal(requiredMapBusElt.getIS_VISIBLE()))
        {
            requiredMapBusElt.setIS_VISIBLE(BigDecimal.ONE);
        }

        // in all cases (load/save/dependency), check mandatory fields
        if(ConstantsCommon.ACTION_TYPE_MANDATORY.equals(actionType)
            && (!existRequiredData || (existRequiredData && NumberUtil
                .nullToZero(requiredObj.getIS_MANDATORY()).compareTo(BigDecimal.ONE) != 0)))
        {
            requiredMapBusElt.setIS_MANDATORY(new BigDecimal(value));
        }

        // in case of Retrieve or Dependency, check the rest (read only, visible...)
        // in case of save, dismiss this part
        if(!"save".equalsIgnoreCase(StringUtil.nullToEmpty(actionStr))) // !isSave
        {
            if(ConstantsCommon.ACTION_TYPE_VISIBLE.equals(actionType))
            {
                if(!existRequiredData
                    || (existRequiredData && !StringUtil.nullEmptyToValue(requiredObj.getIS_VISIBLE(), "1")
                        .equals("0")))
                {
                    requiredMapBusElt.setIS_VISIBLE(new BigDecimal(value));
                }

            }
            else if(ConstantsCommon.ACTION_TYPE_READONLY.equals(actionType))
            {
                if(!existRequiredData
                    || (existRequiredData && NumberUtil.nullToZero(requiredObj.getIS_READONLY()).compareTo(
                        BigDecimal.ONE) != 0))
                {
                    requiredMapBusElt.setIS_READONLY(new BigDecimal(value));
                }

            }
            else if(ConstantsCommon.ACTION_TYPE_LABEL.equals(actionType))
            {
                if(!existRequiredData
                    || (existRequiredData && "".equals(StringUtil.nullToEmpty(requiredObj.getLABEL_KEY()))))
                {
                    requiredMapBusElt.setLABEL_KEY(value);
                }

            }

            else if(ConstantsCommon.ACTION_TYPE_VALUE.equals(actionType))
            {
                if(!existRequiredData
                    || (existRequiredData && "".equals(StringUtil.nullToEmpty(requiredObj.getValue()))))
                {
                    requiredMapBusElt.setValue(value);
                }

            }

            else if(ConstantsCommon.ACTION_TYPE_DECFORMAT.equals(actionType))
            {
                if(!existRequiredData
                    || (existRequiredData && "".equals(StringUtil.nullToEmpty(requiredObj.getDecFormat()))))
                {
                    requiredMapBusElt.setDecFormat(value);
                }

            }
            else if(ConstantsCommon.ACTION_TYPE_MAXLENGTH.equals(actionType))
            {
                if(!existRequiredData
                    || (existRequiredData && NumberUtil.isEmptyDecimal(requiredObj.getMAX_LENGTH())))
                {
                    requiredMapBusElt.setMAX_LENGTH(new BigDecimal(value));
                }

            }
            else if(ConstantsCommon.ACTION_TYPE_TXTFORMAT.equals(actionType)
                && (!existRequiredData || existRequiredData
                    && "".equals(StringUtil.nullToEmpty(requiredObj.getTxtFormat()))))
            {
                requiredMapBusElt.setTxtFormat(value.toString());
            }

            else if(ConstantsCommon.ACTION_TYPE_LEAD_ZEROS.equals(actionType)
                && (!existRequiredData || existRequiredData
                    && "".equals(StringUtil.nullToEmpty(requiredObj.getTxtFormat()))))
            {
                requiredMapBusElt.setLEAD_ZEROS(new BigDecimal(value));
            }

        }

        if(StringUtil.nullToEmpty(requiredMapBusElt.getLABEL_KEY()).equals("")
            || StringUtil.nullToEmpty(requiredMapBusElt.getLABEL_KEY()).equals("N"))
        {
            requiredMapBusElt.setLABEL_KEY(null);
        }
        return requiredMapBusElt;
    }

    /**
     * this function is used to return the transfer method
     * 
     * @param trxMgntCO
     * @return
     */
    public TrxMgntCO returnTransferMethod(TrxMgntCO trxMgntCO)
    {
        if((TrxMgntConstant.DEPOSIT.equals(trxMgntCO.getCtstrxtypeVO().getTYPE()) || TrxMgntConstant.WITHDRAWAL
            .equals(trxMgntCO.getCtstrxtypeVO().getTYPE()))
            && TrxMgntConstant.NOT_CHQ_RELATED.equals(trxMgntCO.getCtstrxtypeVO().getCHQ_RELATED()))
        {
            trxMgntCO.getCtstrsVO().setTRS_METHOD(TrxMgntConstant.CASH);
        }
        if(TrxMgntConstant.DEPOSIT.equals(trxMgntCO.getCtstrxtypeVO().getTYPE())
            && TrxMgntConstant.CLEARING_CHEQUE.equals(trxMgntCO.getCtstrxtypeVO().getCHQ_RELATED()))
        {
            trxMgntCO.getCtstrsVO().setTRS_METHOD(TrxMgntConstant.FOREIGN_CHEQUE);
        }
        if((TrxMgntConstant.DEPOSIT.equals(trxMgntCO.getCtstrxtypeVO().getTYPE()) || TrxMgntConstant.WITHDRAWAL
            .equals(trxMgntCO.getCtstrxtypeVO().getTYPE()))
            && TrxMgntConstant.HOUSE_CHEQUE.equals(trxMgntCO.getCtstrxtypeVO().getCHQ_RELATED()))
        {
            trxMgntCO.getCtstrsVO().setTRS_METHOD(TrxMgntConstant.LOCAL_CHEQUE);
        }
        if(TrxMgntConstant.WITHDRAWAL.equals(trxMgntCO.getCtstrxtypeVO().getTYPE())
            && TrxMgntConstant.CLEARING_CHEQUE.equals(trxMgntCO.getCtstrxtypeVO().getCHQ_RELATED()))
        {
            trxMgntCO.getCtstrsVO().setTRS_METHOD(TrxMgntConstant.LOCAL_CHEQUE);
        }
        if(TrxMgntConstant.TRANSFER.equals(trxMgntCO.getCtstrxtypeVO().getTYPE())
            && TrxMgntConstant.TRSFR_TYPE_INTRA_BANK.equals(trxMgntCO.getCtstrxtypeVO().getTRSFR_TYPE()))
        {
            trxMgntCO.getCtstrsVO().setTRS_METHOD(TrxMgntConstant.INTRA);
        }
        if(TrxMgntConstant.TRANSFER.equals(trxMgntCO.getCtstrxtypeVO().getTYPE())
            && TrxMgntConstant.TRSFR_TYPE_LOCAL.equals(trxMgntCO.getCtstrxtypeVO().getTRSFR_TYPE()))
        {
            trxMgntCO.getCtstrsVO().setTRS_METHOD(TrxMgntConstant.LOCAL_CHEQUE);
        }
        if(TrxMgntConstant.TRANSFER.equals(trxMgntCO.getCtstrxtypeVO().getTYPE())
            && TrxMgntConstant.TRSFR_TYPE_INTERNATIONAL.equals(trxMgntCO.getCtstrxtypeVO().getTRSFR_TYPE()))
        {
            trxMgntCO.getCtstrsVO().setTRS_METHOD(TrxMgntConstant.EXTERNAL);
        }

        return trxMgntCO;
    }

    public CTSTRXTYPEVO returnTrxType(CTSTRXTYPEVO ctstrxtypeVO) throws BaseException
    {
        return coreCommonDAO.returnTrxType(ctstrxtypeVO);
    }

    /**
     * this method creates #CTS_MANUAL_JV_TMP
     * 
     * @throws BaseException
     */
    public void createHashManualJv() throws BaseException
    {
        if(commonLibBO.returnIsSybase() == 1)
        {
            coreCommonDAO.createHashManualJv("");
        }
    }

    /**
     * this method creates #CTS_MANUAL_JV_TMP
     * 
     * @throws BaseException
     */
    public void dropHashManualJv() throws BaseException
    {
        if(commonLibBO.returnIsSybase() == 1)
        {
            coreCommonDAO.dropHashManualJv("");
        }
    }

    /**
     * insert into the hash table #CTS_MANUAL_JV_TMP
     */
    public void insertHashManualJv(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws BaseException
    {
        coreCommonDAO.insertHashManualJv(ctsManualJvTmpVO);
    }

    /**
     * delete all the data from the hash table #CTS_MANUAL_JV_TMP in case of sybase or
     * from temp CTS_MANUAL_JV_TMP table in case of oracle
     */
    public void deleteManualJvTmp(CTS_MANUAL_JV_TMPVO ctsManualJvTmpVO) throws BaseException
    {
        coreCommonDAO.deleteManualJvTmp(ctsManualJvTmpVO);
    }

    /**
     * return account type (pb:guo_find_info.uf_find_acc_type)
     * 
     * @param trxMgntSC
     * @return
     * @throws BaseException
     */
    public RIFATTVO returnAccoutntType(BigDecimal compCode, BigDecimal TYPE_CODE) throws BaseException
    {
        RIFATTVO rifAttVO = new RIFATTVO();
        rifAttVO.setCOMP_CODE(compCode);
        rifAttVO.setTYPE_CODE(TYPE_CODE);
        rifAttVO = (RIFATTVO) genericDAO.selectByPK(rifAttVO);

        if(rifAttVO == null)
        {
            throw new BOException(MessageCodes.INVALID_MISSING_ACCOUNT_TYPE);
        }

        return rifAttVO;
    }

    /*
     * @Deprecated
     * private void addSignSysParamProp(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> diplayResultMap,
     * String btnId, BigDecimal isReadOnly)
     * {
     * SYS_PARAM_SCREEN_DISPLAYVO displayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
     * displayVO.setIS_READONLY(isReadOnly);
     * displayVO.setELEMENT_ID(btnId);
     * diplayResultMap.put(btnId, displayVO);
     * }
     */

    /**
     * return main vault
     */
    public CTSTELLERVO returnMainVault(CTSTELLERSC ctsTellerSC) throws BaseException
    {
        CTSTELLERVO ctstellerVO = coreCommonDAO.returnMainVault(ctsTellerSC);
        if(null != ctstellerVO && null == ctstellerVO.getCODE())
        {
            throw new BOException(MessageCodes.INVALID_VAULT_TYPE);
        }
        return ctstellerVO;
    }

    /**
     * NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
     * 
     * @param signatureSC
     * @throws BaseException
     */
    public void checkSignatureExpiryDateMandatory(SignatureSC signatureSC) throws BaseException
    {
        if(signatureSC != null)
        {
            HashMap<String, Integer> resultmap = coreCommonDAO.checkSignatureExpiryDateMandatory(signatureSC);
            if(resultmap != null && !resultmap.isEmpty())
            {
                if(resultmap.containsKey(SignatureConstant.COUNT_SCAN))
                {
                    Integer countScan = resultmap.get(SignatureConstant.COUNT_SCAN);
                    if(countScan != null && countScan.compareTo(0) > 0)
                    {
                        throw new BOException(MessageCodes.EXP_DATE_REQUIRED_FOR_SIGN);
                    }
                }

                if(resultmap.containsKey(SignatureConstant.COUNT_SIGN_MODIF))
                {
                    Integer countSignModif = resultmap.get(SignatureConstant.COUNT_SIGN_MODIF);
                    if(countSignModif != null && countSignModif.compareTo(0) > 0)
                    {
                        throw new BOException(MessageCodes.EXP_DATE_REQUIRED_FOR_SIGN);
                    }
                }
            }
        }
    }

    /**
     * NABIL FEGHALI - BB120129 - YMC FORMS
     * Return null if validation is ok, otherwise 0 or error code
     * 
     * @param reportId
     * @param argumentId
     * @return
     * @throws BaseException
     */
    private Integer validateReportAndArgumentId(BigDecimal reportId, BigDecimal argumentId)
        throws BaseException
    {
        if(!NumberUtil.isEmptyDecimal(reportId) && reportId.compareTo(BigDecimal.ZERO) > 0
            && !NumberUtil.isEmptyDecimal(argumentId) && argumentId.compareTo(BigDecimal.ZERO) > 0)
        {
            // Validate the report id
            return commonLibBO.validateConfirmationReport(reportId);
        }
        else
        {
            return 0;
        }

    }

    /**
     * NABIL FEGHALI - BB120129 - YMC FORMS
     * Initiate the CtsReportArgSC from AccountsManagementCO
     * 
     * @param accountsManagementCO
     * @param argumentId
     * @return
     * @throws BaseException
     */
    private CtsReportArgSC returnCtsReportArgSC(AccountsManagementCO accountsManagementCO, BigDecimal argumentId)
        throws BaseException
    {
        CtsReportArgSC ctsReportArgSC = new CtsReportArgSC();
        ctsReportArgSC.setArgCode(argumentId);
        ctsReportArgSC.setUserId(accountsManagementCO.getLoginUserId());
        ctsReportArgSC.setRunningDate(accountsManagementCO.getRunningDate());
        ctsReportArgSC.setCompCode(accountsManagementCO.getLoginCompCode());
        ctsReportArgSC.setBranchCode(accountsManagementCO.getAmfVO().getBRANCH_CODE());
        ctsReportArgSC.setCurrency(accountsManagementCO.getAmfVO().getCURRENCY_CODE());
        ctsReportArgSC.setGenLedger(accountsManagementCO.getAmfVO().getGL_CODE());
        ctsReportArgSC.setCifNo(accountsManagementCO.getAmfVO().getCIF_SUB_NO());
        ctsReportArgSC.setSerialNo(accountsManagementCO.getAmfVO().getSL_NO());
        ctsReportArgSC.setTrxNo(BigDecimal.ZERO);
        ctsReportArgSC.setTrxTypeCode(BigDecimal.ZERO);

        return ctsReportArgSC;
    }

    /**
     * NABIL FEGHALI - BB120129 - YMC FORMS
     * Create the dynamic parameters as a String with ~#~ separator
     * 
     * @param accountsManagementCO
     * @param argumentId
     * @return
     * @throws BaseException
     */
    private String returnCtsReportArguments(AccountsManagementCO accountsManagementCO, BigDecimal argumentId)
        throws BaseException
    {
        CtsReportArgSC ctsReportArgSC = returnCtsReportArgSC(accountsManagementCO, argumentId);
        return commonLibBO.createDynamicReportParams(ctsReportArgSC, null);
    }

    /**
     * NABIL FEGHALI - BB120129 - YMC FORMS
     * This is a common function used to print account additional advices defined in CSM Admion -
     * system parameters - account control record
     * PB= f_advice_print
     * 
     * @param accountCO
     * @return
     * @throws BaseException
     */
    public List<ReportResponseCO> printAccAdditionalAdvices(AccountsManagementCO accountsManagementCO)
        throws BaseException
    {
        List<ReportResponseCO> additionalAdvicesList = new ArrayList<ReportResponseCO>();

        if(!NumberUtil.isEmptyDecimal(accountsManagementCO.getLoginCompCode())
            && !NumberUtil.isEmptyDecimal(accountsManagementCO.getAmfVO().getBRANCH_CODE())
            && !NumberUtil.isEmptyDecimal(accountsManagementCO.getAmfVO().getGL_CODE())
            && accountsManagementCO.getAmfVO().getGMI_FLAG() != null
            && !accountsManagementCO.getAmfVO().getGMI_FLAG().isEmpty())
        {

            String cifLanguage = "";

            if(!NumberUtil.isEmptyDecimal(accountsManagementCO.getAmfVO().getCIF_SUB_NO())
                && accountsManagementCO.getAmfVO().getCIF_SUB_NO().compareTo(BigDecimal.ZERO) > 0)
            {
                CifSC criteria = new CifSC();
                criteria.setComp_code(accountsManagementCO.getLoginCompCode());
                criteria.setCif_no(accountsManagementCO.getAmfVO().getCIF_SUB_NO());
                CIFCO cifCO = commonLibBO.returnCIFInfo(criteria);
                if(cifCO != null)
                {
                    cifLanguage = cifCO.getCifVO().getLANGUAGE();
                    accountsManagementCO.getCifVO().setCIF_TYPE(cifCO.getCifVO().getCIF_TYPE());
                }
            }

            List<ACC_NV_ADVICEVO> advicesList = coreCommonDAO.returnAccNvAdvices(accountsManagementCO);
            if(advicesList != null && !advicesList.isEmpty())
            {
                for(ACC_NV_ADVICEVO accAdvice : advicesList)
                {

                    ReportResponseCO reportResponseCO = new ReportResponseCO();
                    defaultPrinterName(reportResponseCO, accountsManagementCO.getCtsTellerVO(),
                        accountsManagementCO.getCtsControl(), "ACC");
                    reportResponseCO.setReportRef(null);
                    reportResponseCO.setSelectReportLanguage(ConstantsCommon.PREFERED_LANG_BOTH
                        .equals(cifLanguage));

                    BigDecimal engRepId = accAdvice.getENG_REP_ID();
                    BigDecimal arabRepId = accAdvice.getARAB_REP_ID();
                    BigDecimal engArgId = accAdvice.getENG_ARG_ID();
                    BigDecimal arabArgId = accAdvice.getARAB_ARG_ID();
                    String engMessage = commonLibBO.returnTranslErrorMessage(
                        MessageCodes.PRINT_ADVICE_CONFIRMATION, new String[] {StringUtil.nullToEmpty(accAdvice
                            .getENG_MESSAGE())}, accountsManagementCO.getLanguage());
                    String arabMessage = commonLibBO.returnTranslErrorMessage(
                        MessageCodes.PRINT_ADVICE_CONFIRMATION, new String[] {StringUtil.nullToEmpty(accAdvice
                            .getARAB_MESSAGE())}, accountsManagementCO.getLanguage());

                    if(ConstantsCommon.PREFERED_LANG_LATIN.equals(cifLanguage)
                        && !NumberUtil.isEmptyDecimal(engArgId) && engArgId.compareTo(BigDecimal.ZERO) != 0)
                    {
                        Integer validationError = validateReportAndArgumentId(engRepId, engArgId);
                        if(validationError == null)
                        {
                            reportResponseCO.setReportId(engRepId);
                            String reportParams = returnCtsReportArguments(accountsManagementCO, engArgId);
                            reportResponseCO.setReportParams(reportParams);
                            reportResponseCO.setReportLanguage(CommonMethods
                                .returnLanguageFromPreffered(cifLanguage));
                            reportResponseCO.setSelectReportLanguage(false);
                            reportResponseCO.setMessage(engMessage);

                            reportResponseCO.setNbrCopies( accAdvice.getENG_REP_ID_NCOPIES());
                        }
                    }
                    else if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(cifLanguage)
                        && !NumberUtil.isEmptyDecimal(arabArgId) && arabArgId.compareTo(BigDecimal.ZERO) != 0)
                    {
                        Integer validationError = validateReportAndArgumentId(arabRepId, arabArgId);
                        if(validationError == null)
                        {
                            reportResponseCO.setReportId(arabRepId);
                            String reportParams = returnCtsReportArguments(accountsManagementCO, arabArgId);
                            reportResponseCO.setReportParams(reportParams);
                            reportResponseCO.setReportLanguage(CommonMethods
                                .returnLanguageFromPreffered(cifLanguage));
                            reportResponseCO.setSelectReportLanguage(false);
                            reportResponseCO.setMessage(arabMessage);
                            reportResponseCO.setNbrCopies( accAdvice.getARAB_REP_ID_NCOPIES());
                        }
                    }
                    else if(ConstantsCommon.PREFERED_LANG_BOTH.equals(cifLanguage))
                    {
                        Integer arabValidationError = validateReportAndArgumentId(arabRepId, arabArgId);
                        Integer engValidationError = validateReportAndArgumentId(engRepId, engArgId);
                        if(arabValidationError == null && engValidationError == null)
                        {
                            reportResponseCO.setEngReportId(engRepId);
                            reportResponseCO.setArabReportId(arabRepId);
                            CtsReportArgSC engCtsReportArgSC = returnCtsReportArgSC(accountsManagementCO,
                                engArgId);
                            CtsReportArgSC arabCtsReportArgSC = returnCtsReportArgSC(accountsManagementCO,
                                arabArgId);
                            Map<BigDecimal, CtsReportArgSC> argumentMap = new HashMap<BigDecimal, CtsReportArgSC>();
                            argumentMap.put(engArgId, engCtsReportArgSC);
                            argumentMap.put(arabArgId, arabCtsReportArgSC);
                            argumentMap = commonLibBO.createMultiDynamicReportParams(argumentMap,
                                accountsManagementCO.getLoginCompCode(), null);
                            if(argumentMap == null)
                            {
                                reportResponseCO.setReportRef(null);
                                reportResponseCO.setReportId(null);
                                reportResponseCO.setEngReportId(null);
                                reportResponseCO.setArabReportId(null);
                            }
                            else
                            {
                                reportResponseCO.setEngReportParams(argumentMap.get(engArgId).getParameters());
                                reportResponseCO
                                    .setArabReportParams(argumentMap.get(arabArgId).getParameters());
                                reportResponseCO.setSelectReportLanguage(true);
                            }
                            reportResponseCO.setSelectLangBeforeConf(Boolean.TRUE);
                            reportResponseCO.setMessage(null);
                            reportResponseCO.setEngMessage(engMessage);
                            reportResponseCO.setArabMessage(arabMessage);
                        }

                    }
                    if(reportResponseCO.getReportId() != null || reportResponseCO.getEngReportId() != null
                        || reportResponseCO.getArabReportId() != null)
                    {
                        additionalAdvicesList.add(reportResponseCO);
                    }

                }
            }

        }

        return additionalAdvicesList;
    }

    /**
     * 
     * Fills necessary Currency Data, and returns Cross Rate
     * 
     * @author redacharabaty
     * 
     * @param TrxMgntSC
     * trxMgntSC.getFrCy() From Currency
     * trxMgntSC.getToCy() Transaction Currency (To Currency)
     * trxMgntSC.getRunningDate() System Running Date
     * trxMgntSC.getCompCode() Company Code
     * trxMgntSC.getBaseCurrencyCode() Base Currency
     * trxMgntSC.getCif() CIF number
     * trxMgntSC.getBranchCode() Branch Code
     * 
     * 
     * @return TrxMgntSC
     * trxMgntSC.getExchRate()
     * 
     * 
     * @throws BaseException
     */
    public TrxMgntSC returnCrossRate(TrxMgntSC trxMgntSC1) throws BaseException
    {
        TrxMgntSC trxMgntSC = trxMgntSC1;
        /*
         * Fetch From Currency Data
         */
        CURRENCIESVO currenciesVO = new CURRENCIESVO();
        currenciesVO.setCOMP_CODE(trxMgntSC.getCompCode());
        currenciesVO.setCURRENCY_CODE(trxMgntSC.getFrCy());
        currenciesVO = currencyBO.getCurrencyDetails(currenciesVO);

        if(currenciesVO == null)
        {
            currenciesVO = new CURRENCIESVO();
        }

        /*
         * Set From Currency Data
         */
        trxMgntSC.setAcFromCyUnits(currenciesVO.getUNIT());
        trxMgntSC.setAcFromCyMultiDiv(currenciesVO.getMULT_DIV_IND());

        /*
         * Fetch To Currency Data
         */
        currenciesVO = new CURRENCIESVO();
        currenciesVO.setCOMP_CODE(trxMgntSC.getCompCode());
        currenciesVO.setCURRENCY_CODE(trxMgntSC.getToCy());
        currenciesVO = currencyBO.getCurrencyDetails(currenciesVO);

        if(currenciesVO == null)
        {
            currenciesVO = new CURRENCIESVO();
        }

        /*
         * Set To Currency Data
         */
        trxMgntSC.setAcToCyUnits(currenciesVO.getUNIT());
        trxMgntSC.setAcToCyMultiDiv(currenciesVO.getMULT_DIV_IND());

        /*
         * Call Procedure
         */
        trxMgntSC = coreCommonProcedureBO.getCrossRate(trxMgntSC);

        return trxMgntSC;
    }

    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * This function is used to count and update the special conditions
     * 
     * @param fomCO
     * @param spCondsStatusList
     * @param resourceCode
     * @throws BaseException
     */
    public void countDeleteSpecialCond(ConditionalAutomationCO conditionalAutomationCO,
        List<String> spCondsStatusList, String resourceCode, List<BigDecimal> condAutoList)
        throws BaseException
    {
        SpecialConditionsCO specialConditionsCO = new SpecialConditionsCO();
        specialConditionsCO.getSpecialConditionsVO().setCOMP_CODE(conditionalAutomationCO.getLoginCompCode());
        specialConditionsCO.getSpecialConditionsVO().setCIF_NO(conditionalAutomationCO.getCifNO());

        if(StringUtil.isNotEmpty(resourceCode))
        {
            specialConditionsCO.getSpecialConditionsVO().setRECORD_SOURCE(resourceCode);
        }

        if(spCondsStatusList != null && !spCondsStatusList.isEmpty())
        {
            specialConditionsCO.setStatusList(spCondsStatusList);
        }

        if(condAutoList != null && !condAutoList.isEmpty())
        {
            specialConditionsCO.setCondAutoList(condAutoList);
        }

        BigDecimal countSpecialCond = coreCommonDAO.countSpecialCondition(specialConditionsCO);
        if(countSpecialCond == null)
        {
            throw new BOException(MessageCodes.ERROR_IN_RETRIEVING_FROM_CIF_SPECIAL_CONDITIONS);
        }

        if(countSpecialCond.compareTo(BigDecimal.ZERO) > 0)
        {
            specialConditionsCO.getSpecialConditionsVO().setSTATUS("D");
            specialConditionsCO.getSpecialConditionsVO().setDATE_DELETED(
                commonLibBO.addSystemTimeToDate(conditionalAutomationCO.getRunningDate()));
            specialConditionsCO.getSpecialConditionsVO().setDELETED_BY("SYSTEM");
            // specialConditionsCO.setStatusList(spCondsStatusList);
            coreCommonDAO.updateSpecialConditions(specialConditionsCO);
        }
    }

    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * 
     * @param conditionalAutomationCO
     * specialCondType = CTS_CONDITIONAL_AUTOMATION.SPECIAL_COND_TYPE
     * specialCondCode = CTS_CONDITIONAL_AUTOMATION.CODE
     * @throws BaseException
     */
    private void callForbidMatchedCIF(ConditionalAutomationCO conditionalAutomationCO, String specialCondType,
        BigDecimal specialCondCode, BigDecimal ctsControlSpCondReason) throws BaseException
    {
        Date expiryDate = commonLibBO.addSystemTimeToDate(DateUtil.createDate(2999, 12, 31));
        ConditionalAutomationCO conditionalAutomationForbidCO = new ConditionalAutomationCO();
        conditionalAutomationForbidCO.setLoginCompCode(conditionalAutomationCO.getLoginCompCode());
        conditionalAutomationForbidCO.setLoginBraCode(conditionalAutomationCO.getLoginBraCode());
        conditionalAutomationForbidCO.setCifNO(conditionalAutomationCO.getCifNO());
        conditionalAutomationForbidCO.setStartDate(conditionalAutomationCO.getRunningDate());
        conditionalAutomationForbidCO.setEndDate(expiryDate);
        conditionalAutomationForbidCO.setForbidTrx(specialCondType);
        conditionalAutomationForbidCO.setReasonCode(ctsControlSpCondReason);
        conditionalAutomationForbidCO.setAdministration(null);
        conditionalAutomationForbidCO.setRecordSource("C");
        conditionalAutomationForbidCO.setReference("");
        conditionalAutomationForbidCO.setCondAutCode(specialCondCode);
        conditionalAutomationForbidCO = coreCommonProcedureBO.forbidMatchedCIF(conditionalAutomationForbidCO);

        if(StringUtil.isNotEmpty(conditionalAutomationForbidCO.getErrorMessage()))
        {
            throw new BOException(conditionalAutomationForbidCO.getErrorMessage());
        }
    }

    /**
     * internal function used to create/delete memo
     * 
     * @param conditionalAutomationCO
     * @param checkArg
     * @param memoCode
     * @throws BaseException
     */
    private void createDeleteMemo(ConditionalAutomationCO conditionalAutomationCO, String checkArg,
        BigDecimal memoCode) throws BaseException
    {
        // Delete existing memo if cif not complete
        MemoDtlCO memoDtlCO = new MemoDtlCO();
        memoDtlCO.setLoginCompCode(conditionalAutomationCO.getLoginCompCode());
        memoDtlCO.setLoginBraCode(conditionalAutomationCO.getLoginBraCode());
        memoDtlCO.setRunningDate(commonLibBO.addSystemTimeToDate(conditionalAutomationCO.getRunningDate()));
        memoDtlCO.setUserName(conditionalAutomationCO.getLoginUserId());
        memoDtlCO.getCtsMemoDetVO().setCIF_NO(conditionalAutomationCO.getCifNO());
        memoDtlCO.setCheckArg(checkArg);
        memoDtlCO.getCtsMemoDetVO().setMEMO_CODE(memoCode);
        // memoBO.createDeleteMemo(memoDtlCO);
        memoDtlCO = coreCommonProcedureBO.createDeleteMemo(memoDtlCO);
        if(memoDtlCO != null && !NumberUtil.isEmptyDecimal(memoDtlCO.getErrorCode())
            && memoDtlCO.getErrorCode().compareTo(BigDecimal.ZERO) > 0)
        {
            throw new BOException(memoDtlCO.getErrorCode().intValue());
        }
    }

    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * This function is used to return the Conditional Automation VO list
     * 
     * @param conditionalAutomationCO
     * @param entityType
     * @param eventType
     * @param cifType
     * @return
     * @throws BaseException
     */
    public List<CTS_CONDITIONAL_AUTOMATIONVO> returnConditionalAutomationList(BigDecimal compCode,
        String entityType, BigDecimal eventType, BigDecimal cifType, BigDecimal deleteSpecialCond,
        BigDecimal linkedCondAutCode, BigDecimal cifTypesFlag) throws BaseException
    {
        ConditionalAutomationSC conditionalAutomationSC = new ConditionalAutomationSC();
        conditionalAutomationSC.setCompCode(compCode);
        conditionalAutomationSC.setEntityType(entityType);
        conditionalAutomationSC.setEventType(eventType);

        if(!NumberUtil.isEmptyDecimal(cifType))
        {
            conditionalAutomationSC.setCifType(cifType);
        }
        if(!NumberUtil.isEmptyDecimal(deleteSpecialCond))
        {
            conditionalAutomationSC.setDeleteSpecialCond(deleteSpecialCond);
        }
        if(!NumberUtil.isEmptyDecimal(linkedCondAutCode))
        {
            conditionalAutomationSC.setLinkedCondAutomationCode(linkedCondAutCode);
        }
        if(!NumberUtil.isEmptyDecimal(cifTypesFlag))
        {
            conditionalAutomationSC.setCifTypesFlag(cifTypesFlag);
        }
	
	/*
	 * #958092 - SUPT200040 - System showing 3272 is Already used in a Standing Order of the same Type issue_SUPT190047
	 */
	if(new BigDecimal(11).compareTo(eventType) == 0)
	{
		conditionalAutomationSC.setSpecialCondType("2");
	}
        return coreCommonDAO.selectConditionalAutomation(conditionalAutomationSC);
    }

    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * PB = f_check_conditional_automation
     * the function checks if the cif has a conditional automation
     * 
     * @param conditionalAutomationCO :
     * conditionalAutomationCO.getLoginCompCode();
     * conditionalAutomationCO.getLoginBraCode();
     * conditionalAutomationCO.getCifNO();
     * conditionalAutomationCO.isFromTrxScreen(); to check if is from transaction screen
     * conditionalAutomationCO.getRunningDate()
     * conditionalAutomationCO.getLoginUserId()
     * conditionalAutomationCO.getLanguage()
     * conditionalAutomationCO.getLoginPreferrredLanguage();
     * conditionalAutomationCO.actionFlag; 1 = called when creating or updating a cif. 2 = Called in
     * all places where the memo screen pops up
     * @throws BaseException
     */
    public ConditionalAutomationCO checkConditionalAutomation(ConditionalAutomationCO conditionalAutomationCO)
        throws BaseException
    {
        if(conditionalAutomationCO == null || conditionalAutomationCO.getActionFlag() == null)
        {
            return null;
        }

        if(NumberUtil.isEmptyDecimal(conditionalAutomationCO.getCifNO()))
        {
            throw new BOException(MessageCodes.CONDITIONAL_AUTOMATION_CIF_NULL);
        }

        // Fix issue #157482
        // Check If CIF_NO = 0 , then its an Internal Account
        if(conditionalAutomationCO.getCifNO().compareTo(BigDecimal.ZERO) == 0)
        {
            return conditionalAutomationCO;
        }

        // Get the reason that is set in csm admin control reccord screen : default reason for
        // automatic
        CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
        ctsControlVO.setCOMP_CODE(conditionalAutomationCO.getLoginCompCode());
        ctsControlVO.setBRANCH_CODE(conditionalAutomationCO.getLoginBraCode());
        ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);

        if(ctsControlVO == null)
        {
            return null;
        }

        // Selecting cif is complete flag, and get the cif type
        CifSC cifSC = new CifSC();
	// EWBI160091 (403157)- from FOM we may have negative F
	cifSC.setComp_code(NumberUtil.nullEmptyToValue(conditionalAutomationCO.getCompCodeCif(),
		conditionalAutomationCO.getLoginCompCode()));
        cifSC.setCif_no(conditionalAutomationCO.getCifNO());
        cifSC.setPreventException(true);
        CIFVO cifVO = commonLibBO.returnCIF(cifSC);
        if(cifVO == null)
        {
            throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
        }
        else
        {
            conditionalAutomationCO.setCifType(cifVO.getCIF_TYPE());
        }

        // Called when creating or updating a cif
        if(conditionalAutomationCO.getActionFlag().equals(1))
        {
            List<String> spCondsStatusList = Arrays.asList("P", "TD");

            countDeleteSpecialCond(conditionalAutomationCO, spCondsStatusList, "C", null);

            // Delete existing memo if cif not complete
            createDeleteMemo(conditionalAutomationCO, "CD", BigDecimal.ZERO);

            // when creating or updating the cif_type of a cif
            // check if a conditional automation is created on the selected cif_type
            List<CTS_CONDITIONAL_AUTOMATIONVO> ctsConditionalAutomationVOList = returnConditionalAutomationList(
                conditionalAutomationCO.getLoginCompCode(), "S", BigDecimal.ONE, conditionalAutomationCO
                    .getCifType(), null, null, null);

            if(ctsConditionalAutomationVOList == null || ctsConditionalAutomationVOList.size() > 1)
            {
                
                throw new BOException(MessageCodes.INVALID_MISSING_CONDITIONAL_AUTOMATION);
            }

            // When no automation condition is created for this cif type
            if(ctsConditionalAutomationVOList.isEmpty())
            {
                // check if an automation condition is created as follows: if CIF is not complete
                // than create a special condition
                // check if the current cif is not complete
                if("N".equals(cifVO.getCIF_COMPLETE()))
                {
                    ctsConditionalAutomationVOList = returnConditionalAutomationList(conditionalAutomationCO
                        .getLoginCompCode(), "S", BigDecimal.valueOf(3), null, null, null, null);

                    if(ctsConditionalAutomationVOList == null || ctsConditionalAutomationVOList.size() > 1)
                    {
                       
                        throw new BOException(MessageCodes.INVALID_MISSING_CONDITIONAL_AUTOMATION);
                    }

                    // if an conditional automation is created for cif is not complete
                    if(!ctsConditionalAutomationVOList.isEmpty())
                    {
                        // if a special condition is created then delete it
                        countDeleteSpecialCond(conditionalAutomationCO, spCondsStatusList, null, null);

                        // call p_ret_forbid_matched_cif
                        callForbidMatchedCIF(conditionalAutomationCO, ctsConditionalAutomationVOList.get(0)
                            .getSPECIAL_COND_TYPE(), ctsConditionalAutomationVOList.get(0).getCODE(),
                            ctsControlVO.getSPECIAL_COND_CODE());

                    }
                }
            }
            // when automation condition is created for this cif type
            else
            {
                // if a special condition is created then delete it
                countDeleteSpecialCond(conditionalAutomationCO, spCondsStatusList, null, null);

                // INSERT INTO CTSSPCOND
                // Get the reason that is set in csm admin control reccord screen : default reason
                // for automatic
                // call p_ret_forbid_matched_cif
                callForbidMatchedCIF(conditionalAutomationCO, ctsConditionalAutomationVOList.get(0)
                    .getSPECIAL_COND_TYPE(), ctsConditionalAutomationVOList.get(0).getCODE(), ctsControlVO
                    .getSPECIAL_COND_CODE());
            }

            // check when cif is not complete and create memo
            // check if the current cif is not complete
            if("N".equals(cifVO.getCIF_COMPLETE()))
            {
                ctsConditionalAutomationVOList = returnConditionalAutomationList(conditionalAutomationCO
                    .getLoginCompCode(), "E", BigDecimal.valueOf(3), null, null, null, null);

                if(ctsConditionalAutomationVOList == null || ctsConditionalAutomationVOList.size() > 1)
                {
                  
                    throw new BOException(MessageCodes.INVALID_MISSING_CONDITIONAL_AUTOMATION);
                }

                // if an conditional automation is created for cif is not complete
                if(!ctsConditionalAutomationVOList.isEmpty())
                {
                    // Create existing memo if cif not complete
                    createDeleteMemo(conditionalAutomationCO, "C", ctsConditionalAutomationVOList.get(0)
                        .getCODE());
                }
            }
        }
        // Called in all places where the memo screen pops up
        else if(conditionalAutomationCO.getActionFlag().equals(2))
        {
            StringBuffer messageBuffer = new StringBuffer();

            // Check case of minor CIF
            List<CTS_CONDITIONAL_AUTOMATIONVO> ctsConditionalAutomationVOList = returnConditionalAutomationList(
                conditionalAutomationCO.getLoginCompCode(), "M", BigDecimal.valueOf(2), null, null, null, null);

            // if an conditional automation is created for cif is not complete
            if(ctsConditionalAutomationVOList != null && !ctsConditionalAutomationVOList.isEmpty()
                && cifVO.getBIRTH_DATE() != null)
            {
                CifTypeSC cifTypeSC = new CifTypeSC();
                cifTypeSC.setCompCode(conditionalAutomationCO.getLoginCompCode());
                cifTypeSC.setCifTypeCode(conditionalAutomationCO.getCifType());
                cifTypeSC.setNoExceptionMsg("0");
                cifTypeSC.setCheckMinMaxAge(FomConstant.MIN);
                cifTypeSC.setRunningDate(conditionalAutomationCO.getRunningDate());
                ResultCO result = checkCifAge(cifVO.getBIRTH_DATE(), cifTypeSC);
                if(result.getIntegerResut() != null && result.getIntegerResut() > 0)
                {
                    messageBuffer.append("\n");
                    messageBuffer.append(commonLibBO.returnTranslErrorMessage(MessageCodes.CIF_IS_MINOR,
                        conditionalAutomationCO.getLanguage()));
                }
            }

            // Check case of CIF has dormant account
            ctsConditionalAutomationVOList = returnConditionalAutomationList(conditionalAutomationCO
                .getLoginCompCode(), "M", BigDecimal.valueOf(4), null, null, null, null);
            if(ctsConditionalAutomationVOList != null && !ctsConditionalAutomationVOList.isEmpty())
            {
                AccountSC accountSC = new AccountSC();
                accountSC.setCompCode(conditionalAutomationCO.getLoginCompCode());
                accountSC.setCifCode(conditionalAutomationCO.getCifNO());
                accountSC.setStatus("T");
                accountSC.setGmiExcludes("I");
                BigDecimal countDormantAcc = accountBO.countAMFByCIFSUBNO(accountSC);
                // TODO check GV_BYCODE = FALSE
                if(countDormantAcc != null && countDormantAcc.compareTo(BigDecimal.ZERO) > 0)
                {
                    messageBuffer.append("\n");
                    messageBuffer.append(commonLibBO.returnTranslErrorMessage(
                        MessageCodes.CIF_HAS_DORMANT_ACCOUNTS, conditionalAutomationCO.getLanguage()));
                }
            }

            // In case of transaction do not check for special condition as it is already done in
            // the interface
            if(conditionalAutomationCO.getShowSpecialConditionMessage() != null
                && conditionalAutomationCO.getShowSpecialConditionMessage())
            {
                // check case of CIF having special condition
                ctsConditionalAutomationVOList = returnConditionalAutomationList(conditionalAutomationCO
                    .getLoginCompCode(), "M", BigDecimal.valueOf(5), null, null, null, null);
                if(ctsConditionalAutomationVOList != null && !ctsConditionalAutomationVOList.isEmpty())
                {
                    AccountCO accountCO = new AccountCO();
                    accountCO.getAmfVO().setCOMP_CODE(conditionalAutomationCO.getLoginCompCode());
                    accountCO.getAmfVO().setBRANCH_CODE(conditionalAutomationCO.getLoginBraCode());
                    accountCO.getCifVO().setCIF_NO(conditionalAutomationCO.getCifNO());
                    accountCO.setCifAcc("C");
                    accountCO.setRunningDate(conditionalAutomationCO.getRunningDate());
                    accountCO = coreCommonProcedureBO.specialConditions(accountCO);
                    if(accountCO != null)
                    {
                        String reason = null;
                        if(ConstantsCommon.PREFERED_LANG_LATIN.equals(conditionalAutomationCO
                            .getLoginPreferrredLanguage()))
                        {
                            reason = StringUtil.nullToEmpty(accountCO.getReasonEng());
                        }
                        else
                        {
                            reason = StringUtil.nullToEmpty(accountCO.getReasonAr());
                        }
                        // FORBID CR
                        if("1".equals(accountCO.getFORBID_TRX()))
                        {
                            messageBuffer.append("\n");
                            messageBuffer.append(commonLibBO.returnTranslErrorMessage(
                                MessageCodes.CLIENT_FORBIDDEN_FROM_CREDITING_ACCOUNT,
                                new String[] {"", reason}, conditionalAutomationCO.getLanguage()));

                        }// FORBID DR
                        else if("2".equals(accountCO.getFORBID_TRX()))
                        {
                            messageBuffer.append("\n");
                            messageBuffer.append(commonLibBO.returnTranslErrorMessage(
                                MessageCodes.CLIENT_FORBIDDEN_FROM_DEBITING_ACCOUNT, new String[] {"", reason},
                                conditionalAutomationCO.getLanguage()));

                        }// FORBID Both
                        else if("3".equals(accountCO.getFORBID_TRX()))
                        {
                            messageBuffer.append("\n");
                            messageBuffer.append(commonLibBO.returnTranslErrorMessage(
                                MessageCodes.CLIENT_FORBID_FROM_CRED_DEB_ACCOUNT, new String[] {"", reason},
                                conditionalAutomationCO.getLanguage()));

                        }// RESTRICT CR
                        else if("4".equals(accountCO.getFORBID_TRX()))
                        {
                            messageBuffer.append("\n");
                            messageBuffer.append(commonLibBO.returnTranslErrorMessage(
                                MessageCodes.CLIENT_RESTRICTED_FROM_CREDITING_ACCOUNT,
                                new String[] {"", reason}, conditionalAutomationCO.getLanguage()));

                        }// RESTRICT DR
                        else if("5".equals(accountCO.getFORBID_TRX()))
                        {
                            messageBuffer.append("\n");
                            messageBuffer.append(commonLibBO.returnTranslErrorMessage(
                                MessageCodes.CLIENT_RESTRICTED_FROM_DEBITING_ACCOUNT,
                                new String[] {"", reason}, conditionalAutomationCO.getLanguage()));

                        }// RESTRICT Both
                        else if("6".equals(accountCO.getFORBID_TRX()))
                        {
                            messageBuffer.append("\n");
                            messageBuffer.append(commonLibBO.returnTranslErrorMessage(
                                MessageCodes.CLIENT_RESTRCT_FROM_CRED_DEB_ACC, new String[] {"", reason},
                                conditionalAutomationCO.getLanguage()));

                        }
                    }

                }

            }

            conditionalAutomationCO.setWarningMessages(messageBuffer.toString());

        }
        
        //added by reda for SUPT190047
        // Called when suspending a cif
        else if (conditionalAutomationCO.getActionFlag().equals(0))
        {
	    ReasonSC reasonSC = new ReasonSC();
	    reasonSC.setCompCode(conditionalAutomationCO.getLoginCompCode());
	    reasonSC.setCode(cifVO.getREASON_CODE());

	    CTSREASONSVO reasonVO = reasonBO.returnReasonByCode(reasonSC);

	    if(reasonVO != null)
	    {
		if("32".equals(reasonVO.getREASON_TYPE())) // if in admin the new reason type of Decease CIF was 32
		{
		    CifSC deceaseCifSC = new CifSC();
		    deceaseCifSC.setCompCode(conditionalAutomationCO.getLoginCompCode());
		    deceaseCifSC.setCif_no(conditionalAutomationCO.getCifNO());
		    deceaseCifSC.setIdTypeCode(conditionalAutomationCO.getId_type());
		    deceaseCifSC.setId_no(conditionalAutomationCO.getId_no());
		    List<CIFVO> lst = listCIFbyID(deceaseCifSC);

		    if(lst != null && !lst.isEmpty())
		    {
                                        
			ConditionalAutomationCO spCondConditionalAutomationCO = (new Cloner()).deepClone(conditionalAutomationCO);

			for(int i = 0; i < lst.size(); i++)
			{

			    List<CTS_CONDITIONAL_AUTOMATIONVO> ctsConditionalAutomationVOList = returnConditionalAutomationList(
				    spCondConditionalAutomationCO.getLoginCompCode(), "S", BigDecimal.valueOf(11), null, null, null, null); // 11 if in admin the
                                                                                                                                                                                                                                                                        // new event type
                                                                                                                                                                                                                                                                        // was 11

			    if(ctsConditionalAutomationVOList == null || ctsConditionalAutomationVOList.size() > 1)
			    {
				throw new BOException(MessageCodes.ERROR_WHILE_RETRIEVING_CONDITIONAL_AUTOMATION);
			    }

			    // if an conditional automation is created for cif is not complete
			    if(!ctsConditionalAutomationVOList.isEmpty())
			    {
				List<String> spCondsStatusList = Arrays.asList("P", "TD");

				spCondConditionalAutomationCO.setCifNO(lst.get(i).getCIF_NO());

				// if a special condition is created then delete it
				countDeleteSpecialCond(spCondConditionalAutomationCO, spCondsStatusList, null, null);

				// call p_ret_forbid_matched_cif
				callForbidMatchedCIF(spCondConditionalAutomationCO, ctsConditionalAutomationVOList.get(0).getSPECIAL_COND_TYPE(),
                                                                        ctsConditionalAutomationVOList.get(0).getCODE(), cifVO.getREASON_CODE());

			    }
			}
		    }
		}
	    }
        }        
        //
        return conditionalAutomationCO;
    }

    /*
     * Method returning the Exchange Rate after taking as parameters
     * the from currency and to currency
     * 
     * trsAcCy = to Currency
     * trsCy = from Currency
     */
    public TrxMgntSC returnNormalRate(TrxMgntSC trxMgntSC1) throws BaseException
    {
        TrxMgntSC trxMgntSC = trxMgntSC1;

        /*
         * Call Procedure
         */
        trxMgntSC = coreCommonProcedureBO.returnRateNormal(trxMgntSC);

        return trxMgntSC;
    }

    public void setAccountBO(AccountBO accountBO)
    {
        this.accountBO = accountBO;
    }

    /**
     * CHECK IF CIF IS BLACK LISTED
     */
    public int checkIfBlackListedCIF(CifSC cifSC) throws BaseException
    {
        return coreCommonDAO.checkIfBlackListedCIF(cifSC);
    }

    public CifTypeDAO getCifTypeDAO()
    {
        return cifTypeDAO;
    }

    public void setCifTypeDAO(CifTypeDAO cifTypeDAO)
    {
        this.cifTypeDAO = cifTypeDAO;
    }

    @Override
    public List<S_ADDREF_MASK_SPECIFICVO> returnCIFAddRefNumberMask(String accountType) throws BaseException
    {
        return coreCommonDAO.returnCIFAddRefNumberMask(accountType);
    }

    /**
     * PB uf_fill_other_varaibles in pathmain.pbl
     * 
     * @author nabilfeghali
     * @param reportResponseCO
     * @param ctsTellerVO
     * @param ctsControlVO
     * @param printType
     * @return
     * @throws BaseException
     */
    public ReportResponseCO defaultPrinterName(ReportResponseCO reportResponseCO, CTSTELLERVO ctsTellerVO,
        CTSCONTROLVO ctsControlVO, String printType) throws BaseException
    {
        if(reportResponseCO != null && ctsTellerVO != null && ctsControlVO != null)
        {
            String printerName = null;

            if("TRX".equals(printType))
            {
                printerName = ctsTellerVO.getTRS_ADVICE_PRINTER();
                if(printerName == null || printerName.isEmpty())
                {
                    printerName = ctsControlVO.getTRS_ADVICE_PRINTER();
                }
            }
            else if("CIF".equals(printType) || "ACC".equals(printType))
            {
                printerName = ctsTellerVO.getACC_CIF_FORMS_PRINTER();
                if(printerName == null || printerName.isEmpty())
                {
                    printerName = ctsControlVO.getACC_CIF_FORMS_PRINTER();
                }
            }

            if(StringUtil.isNotEmpty(printerName))
            {
                reportResponseCO.setPrinterName(printerName);
            }
        	//TP #372259 automatically invoking ctrl+p to print CSM advices --[Elias Aoun]  
        	reportResponseCO.setAutoPrint(true);
        }
        return reportResponseCO;
    }

    /**
     * used to apply template accounting entries in TFA application
     * 
     * @author: jihadlamaa
     * @date: Jun 3, 2014
     * @PB:
     * @param tfaCommonSC
     * @throws BaseException
     */
    public void applyTempAccEntries(CtsRequestSC criteria) throws BaseException
    {
        coreCommonProcedureBO.pkgTemplateTfa(criteria);
    }

    /**
     * USED TO PROCESS lc/lg request
     * 
     * @author: jihadlamaa
     * @date: Feb 12, 2015
     * @PB:
     * @param requestCO
     * @throws BaseException
     */

    public void processTFARequest(CtsRequestCO requestCO) throws BaseException

    {

        CTS_REQUEST_TYPEVO ctsRequestType = new CTS_REQUEST_TYPEVO();
        ctsRequestType.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
        ctsRequestType.setCODE(requestCO.getCtsRequestVO().getTYPE());
        ctsRequestType = (CTS_REQUEST_TYPEVO) genericDAO.selectByPK(ctsRequestType);

        if(ctsRequestType != null)
        {
            String autoRequest = ctsRequestType.getAUTOMATIC_PROCESS();

            BigDecimal amount = null;
            BigDecimal cyDoc = null;
            BigDecimal appChargebr = null;
            BigDecimal appChargeCy = null;
            BigDecimal appChargeGl = null;
            BigDecimal appChargeCif = null;
            BigDecimal appChargSl = null;
            BigDecimal customer = null;
            /*
             * EntityChargesCO criteria =new EntityChargesCO();
             * criteria.setEntityType("REQ");
             * criteria.setLoginCompCode(requestCO.getCtsRequestVO().getCOMP_CODE());
             * criteria.setLoginBraCode(requestCO.getLoginBraCode());
             * criteria.setEntityCode(requestCO.getCtsRequestVO().getREQ_NO());
             * criteria.setLoginPreferrredLanguage("EN");
             * 
             * List<CtsChargesEntityCO> entityChargesList =
             * entityChargesBO.retrieveCtsChargesEntityCOList(criteria);
             * BigDecimal amountCharge=BigDecimal.ZERO;
             * BigDecimal vatAmnt=null;
             * for(CtsChargesEntityCO ctsCharEntCO : entityChargesList)
             * {
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * vatAmnt=ctsCharEntCO.getVatCtsChargesEntityVO().getAMOUNT_ORIGINAL_FC()==null?BigDecimal
             * .ZERO
             * :ctsCharEntCO.getVatCtsChargesEntityVO().getAMOUNT_ORIGINAL_FC();
             * amountCharge =
             * amountCharge.add(ctsCharEntCO.getCtsChargesEntityVO().getAMOUNT()).add(
             * vatAmnt);
             * 
             * }
             */

            if("OU".equals(ctsRequestType.getTFA_TYPE()))
            {
                TFSLCREQUEST1VO obj1VO = new TFSLCREQUEST1VO();
                obj1VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                obj1VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                obj1VO.setLC_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                obj1VO.setLC_YEAR(BigDecimal.ZERO);
                obj1VO.setLC_TYPE("O");
                obj1VO = (TFSLCREQUEST1VO) genericDAO.selectByPK(obj1VO);

                TFSLCREQUEST2VO obj2VO = new TFSLCREQUEST2VO();
                obj2VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                obj2VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                obj2VO.setLC_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                obj2VO.setLC_YEAR(BigDecimal.ZERO);
                obj2VO.setLC_TYPE("O");
                obj2VO = (TFSLCREQUEST2VO) genericDAO.selectByPK(obj2VO);
                if(requestCO.isScreenProcess())
                {
                    obj1VO.setSTATUS("P");
                    //obj2VO.setSTATUS("P");
                }
                else
                {
                    obj1VO.setSTATUS("1".equals(autoRequest) ? "P" : "H");
                    //obj2VO.setSTATUS("1".equals(autoRequest) ? "P" : "H");
                }
                obj1VO.setISSUED_BY(requestCO.getLoginUserId());
                obj1VO.setDATE_ISSUED(requestCO.getRunningDate());
                genericDAO.update(obj1VO);
                genericDAO.update(obj2VO);

                TFSLC1VO lc1VO = new TFSLC1VO();
                lc1VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                lc1VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                lc1VO.setLC_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                lc1VO.setLC_YEAR(BigDecimal.ZERO);
                lc1VO.setLC_TYPE("O");

                TFSLC2VO lc2VO = new TFSLC2VO();
                lc2VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                lc2VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                lc2VO.setLC_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                lc2VO.setLC_YEAR(BigDecimal.ZERO);
                lc2VO.setLC_TYPE("O");

                if(requestCO.isScreenProcess())
                {
                    lc1VO.setSTATUS("P");
                 // lc2VO.setSTATUS("P");
                }
                else
                {
                    lc1VO.setSTATUS("1".equals(autoRequest) ? "P" : "H");
                 // lc2VO.setSTATUS("1".equals(autoRequest) ? "P" : "H");
                }

                genericDAO.update(lc1VO);
                genericDAO.update(lc2VO);

                amount = obj1VO.getABOUT_AMOUNT();
                cyDoc = obj1VO.getLC_CURRENCY();
                /*
                 * appChargebr = obj1VO.getCHARGES_ACC_BR();
                 * appChargeCy = obj1VO.getCHARGES_ACC_CY();
                 * appChargeGl = obj1VO.getCHARGES_ACC_GL();
                 * appChargeCif = obj1VO.getCHARGES_ACC_CIF();
                 * appChargSl = obj1VO.getCHARGES_ACC_SL();
                 */

            }
            else if("IN".equals(ctsRequestType.getTFA_TYPE()))
            {
                TFSLC1VO obj1VO = new TFSLC1VO();
                obj1VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                obj1VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                obj1VO.setLC_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                obj1VO.setLC_YEAR(BigDecimal.ZERO);
                obj1VO.setLC_TYPE("I");
                obj1VO = (TFSLC1VO) genericDAO.selectByPK(obj1VO);
                
                TFSLC2VO obj2VO = new TFSLC2VO();
                obj2VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                obj2VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                obj2VO.setLC_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                obj2VO.setLC_YEAR(BigDecimal.ZERO);
                obj2VO.setLC_TYPE("I");
                obj2VO = (TFSLC2VO) genericDAO.selectByPK(obj2VO);
                if(requestCO.isScreenProcess())
                {
                    obj1VO.setLC_STATUS("A");
                    // obj2VO.setSTATUS("P");
                }
                else
                {
                    obj1VO.setLC_STATUS("1".equals(autoRequest) ? "A" : "H");
                    //obj2VO.setSTATUS("1".equals(autoRequest) ? "P" : "H");
                }
//                obj1VO.setISSUED_BY(requestCO.getLoginUserId());
//                obj1VO.setDATE_ISSUED(requestCO.getRunningDate());
                genericDAO.update(obj1VO);
                genericDAO.update(obj2VO);
            }
            
          else if("BIN".equals(ctsRequestType.getTFA_TYPE()) || "BOU".equals(ctsRequestType.getTFA_TYPE()) )
                
                
            {
                
                
                TFSBILLVO obj1VO = new TFSBILLVO();
                obj1VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                obj1VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                obj1VO.setBILL_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                obj1VO.setBILL_TYPE("BIN".equals(ctsRequestType.getTFA_TYPE())?"N":"U");                                
                obj1VO = (TFSBILLVO) genericDAO.selectByPK(obj1VO);

                obj1VO.setSTATUS("A");
                
              

                obj1VO.setAPPROVED_BY(requestCO.getLoginUserId());
                obj1VO.setDATE_APPROVED(requestCO.getRunningDate());
                genericDAO.update(obj1VO);
                amount = obj1VO.getAMOUNT();
                cyDoc = obj1VO.getCURRENCY();  
                
               /* obj1VO.setAPPROVED_BY(requestCO.getLoginUserId());
                obj1VO.setDATE_APPROVED(requestCO.getRunningDate());*/
                genericDAO.update(obj1VO);
                
            }

            else
            {
                TFSLGVO obj1VO = new TFSLGVO();
                obj1VO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                obj1VO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
                obj1VO.setREQUISITION_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
                obj1VO = (TFSLGVO) genericDAO.selectByPK(obj1VO);

                if(requestCO.isScreenProcess())
                {
                    obj1VO.setSTATUS("P");
                }
                else
                {
                    obj1VO.setSTATUS("1".equals(autoRequest) ? "P" : "H");
                }

                obj1VO.setAPPROVED_BY(requestCO.getLoginUserId());
                obj1VO.setDATE_APPROVED(requestCO.getRunningDate());
                genericDAO.update(obj1VO);

                amount = obj1VO.getAMOUNT();
                cyDoc = obj1VO.getCURRENCY();
                /*
                 * appChargebr = obj1VO.getFUNDING_ACC_BR();
                 * appChargeCy = obj1VO.getFUNDING_ACC_CY();
                 * appChargeGl = obj1VO.getFUNDING_ACC_GL();
                 * appChargeCif = obj1VO.getFUNDING_ACC_CIF();
                 * appChargSl = obj1VO.getFUNDING_ACC_SL();
                 */

            }

            if(("1".equals(autoRequest) || requestCO.isScreenProcess())
        	    && (!"BIN".equals(ctsRequestType.getTFA_TYPE()) && !"BOU".equals(ctsRequestType.getTFA_TYPE())))
            {

                // call P_RET_REQUEST_CHARGES arguments will be added when the API will
                // be ready from CSM.
                // call P_RET_REQUEST_CHARGES arguments will be added when the API will
                // be ready from CSM.
                /*
                 * TrxMgntChargesSC trxMgntChargesSC = new TrxMgntChargesSC();
                 * trxMgntChargesSC.setCompCode(requestCO.getCtsRequestVO().getCOMP_CODE());
                 * trxMgntChargesSC.setBranchCode(requestCO.getLoginBraCode());
                 * trxMgntChargesSC.setEntityTypeCode(requestCO.getCtsRequestVO().getTYPE());
                 * trxMgntChargesSC.setRequestCy(cyDoc);
                 * trxMgntChargesSC.setDeductAcBr(appChargebr);
                 * trxMgntChargesSC.setDeductAcCy(appChargeCy);
                 * trxMgntChargesSC.setDeductAcGl(appChargeGl);
                 * trxMgntChargesSC.setDeductAcCif(appChargeCif);
                 * trxMgntChargesSC.setDeductAcSl(appChargSl);
                 * trxMgntChargesSC.setUserId(requestCO.getLoginUserId());
                 * trxMgntChargesSC.setEntityCode(requestCO.getCtsRequestVO().getREQ_NO());
                 * trxMgntChargesSC.setRequestDate(requestCO.getRunningDate());
                 * trxMgntChargesSC.setAppName("RET");
                 * 
                 * if(requestCO.isScreenProcess())
                 * {
                 * trxMgntChargesSC.setAutoApprove("1");
                 * }
                 * else
                 * {
                 * trxMgntChargesSC.setAutoApprove("1".equals(autoRequest) ? "1" : "0");
                 * }
                 * 
                 * if(!NumberUtil.isEmptyDecimal(appChargebr) &&
                 * !NumberUtil.isEmptyDecimal(appChargeCy)
                 * && !NumberUtil.isEmptyDecimal(appChargeGl) &&
                 * !NumberUtil.isEmptyDecimal(appChargeCif)
                 * && !NumberUtil.isEmptyDecimal(appChargSl))
                 * {
                 * 
                 * coreCommonProcedureBO.returnRequestCharges(trxMgntChargesSC);
                 * if(!"".equals(StringUtil.nullToEmpty(trxMgntChargesSC.getErrorMessage())))
                 * {
                 * throw new BOException(trxMgntChargesSC.getErrorMessage());
                 * }
                 * }
                 */

        	if(!"IN".equals(ctsRequestType.getTFA_TYPE()))
                {
		    CtsRequestSC criteria = new CtsRequestSC();
		    criteria.setCompCode(requestCO.getCtsRequestVO().getCOMP_CODE());
		    criteria.setBranchCode(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
		    criteria.setTrxType(new BigDecimal(1005));
		    criteria.setLcType("OU".equals(ctsRequestType.getTFA_TYPE()) ? "O" : "G");
		    criteria.setTrxNbr(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
		    if(requestCO.isScreenProcess())
		    {

			criteria.setLcType("OU".equals(ctsRequestType.getTFA_TYPE()) ? "O" : "G");
			criteria.setTrxNbr(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
			criteria.setStatus("P");
			criteria.setUserId(requestCO.getLoginUserId());
			criteria.setRunningDate(requestCO.getRunningDate());
			criteria.setAppName("TFA");
			criteria.setPreferredLanguage(requestCO.getLanguage());
			criteria.setReinstateDocType("0");
			criteria.setReinstateLinkedTrx("0");
			criteria.setCrud("P");
			coreCommonBO.applyTempAccEntries(criteria);

			if("E".equals(criteria.getErrorType()))
			{
			    throw new BOException(criteria.getErrorMessage());
			}
		    }

		    // set the status to 'P' since the status still as validated when created
		    // in the request screen hint(the template check if the tfstrx is approved ignore)
		    TFSTRXVO tfstsrxVO = new TFSTRXVO();
		    tfstsrxVO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
		    tfstsrxVO.setBRANCH(requestCO.getCtsRequestVO().getPROCESS_BRANCH());
		    tfstsrxVO.setTRX_NBR(requestCO.getCtsRequestVO().getAPPLICATION_CODE());
		    tfstsrxVO.setTRX_TYPE(new BigDecimal(1005));
		    tfstsrxVO.setLC_TYPE(criteria.getLcType());
		    tfstsrxVO.setSTATUS("P");
		    genericDAO.update(tfstsrxVO);
                }
                // Udate the process as proceeed

                if(!requestCO.isScreenProcess()) // IF NOT FROM CSM DO NO UPDATE IT
                {

                    CTS_REQUESTVO ctsRequestVO = new CTS_REQUESTVO();
                    ctsRequestVO.setCOMP_CODE(requestCO.getCtsRequestVO().getCOMP_CODE());
                    ctsRequestVO.setBRANCH(requestCO.getCtsRequestVO().getBRANCH());
                    ctsRequestVO.setREQ_NO(requestCO.getCtsRequestVO().getREQ_NO());
                    ctsRequestVO.setSTATUS(CtsRequestConstant.STATUS_PROCESSED);
                    ctsRequestVO.setDATE_PROCESSED(commonLibBO.addSystemTimeToDate(requestCO.getRunningDate()));
                    ctsRequestVO.setPROCESSED_BY(requestCO.getLoginUserId());
                    genericDAO.update(ctsRequestVO);
                }

            }
        }
        else
        {

            throw new BOException(MessageCodes.INVALID_MISSING, new String[] {"Request_Type_key"});
        }

    }

    /**
     * This function gets the count of Classified records for a certain
     * CIF. In general, any count greater than 0 means that the CIF
     * is classified.
     * 
     * @author Reda Charabaty
     * @param CifSC
     * compCode Company Code
     * cif_no CIF Number
     * 
     * 
     * @return CifSC
     * 
     * 
     * @throws BaseException
     */
    public int countClassifiedCIF(CifSC cifSC) throws BaseException
    {
        return coreCommonDAO.countClassifiedCIF(cifSC);
    }

    @Override
    public Map<String, PROC_PRODUCT_PARAMVO> retrieveProcProductParam(CoreCommonSC coreCommonSC)
        throws DAOException
    {
        return coreCommonDAO.retrieveProcProductParam(coreCommonSC);
    }

    public void refreshDual() throws BaseException
    {
	int result = coreCommonDAO.refreshDual();
    }
    
    public Boolean getPassConfirmMsgYN(Integer confirmMsg) throws BaseException
    {
	Boolean confirmYN=true;
	String confirmMsgYN =coreCommonDAO.getPassConfirmMsgYN(confirmMsg);
	if("0".equals(confirmMsgYN))
	{
	    confirmYN=false;
	}
	return confirmYN;
    }
    
    /**
     * @author raniaalbitar
     * 796564 SUMMIT - Merging FilerNon-filer in Account Limits
     * @param accountsManagementCO
     * @return
     * @throws BaseException
     */
   public CoreCommonCO dependencyByReasonCode(CoreCommonSC coreCommonSC) throws BaseException
   {
	if(!NumberUtil.isEmptyDecimal(coreCommonSC.getExemptedFromFilerReason()))//TODO
	{
	    if(coreCommonSC.getExemptedFromFilerReason().compareTo(BigDecimal.ZERO) > 0)
	    {
		ReasonSC reasonSC = new ReasonSC();
		reasonSC.setCode(coreCommonSC.getExemptedFromFilerReason());//TODO
		reasonSC.setCompCode(coreCommonSC.getCompanyCode());//TODO
		reasonSC.setReason_type(FomConstant.CIF_FILER_NON_FILER_REASON_TYPE);

		CTSREASONSVO ctsreasonsVO = reasonBO.returnReasonByCode(reasonSC);
		if(null == ctsreasonsVO)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_REASON_CODE);
		}
		else
		{
		    coreCommonCO.setExemptedFromFilerReason(ctsreasonsVO.getCODE());
		    
		    if(ConstantsCommon.LANGUAGE_ENGLISH.equals(coreCommonSC.getLanguage()))//TODO
		    {
			coreCommonCO.setReasonCodeDesc(ctsreasonsVO.getBRIEF_NAME_ENG());
		    }
		    else
		    {
			coreCommonCO.setReasonCodeDesc(ctsreasonsVO.getBRIEF_NAME_ARAB());
		    }
		}
	    }
	    else
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_REASON_CODE);
	    }

	}
	else
	{
	    coreCommonCO.setExemptedFromFilerReason(null);
	    coreCommonCO.setReasonCodeDesc(null);
	}

	return coreCommonCO;
   }
   
   /**
    * @author raniaalbitar
    * 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    * @param accountsManagementCO
    * @return
    * @throws BaseException
    */
   public CoreCommonCO checkExemptionExpiryDate(CoreCommonSC coreCommonSC) throws BaseException
   {
//	AMF_EXTENDEDVO amfExtendedVO = accountsManagementCO.getAmfExtendedVO();
	Date systemDate;
	systemDate = coreCommonSC.getRunningDate();//TODO
	/*if(amfExtendedVO != null)
	{*/
	    Date exemptionExiryDate = coreCommonSC.getExemptedFromFilerExpiryDte();
	    if(exemptionExiryDate != null)
	    {
		if(DateUtil.parseDate("01/01/1900", "dd/mm/yyyy").compareTo(exemptionExiryDate) > 0
			|| (exemptionExiryDate).compareTo(systemDate) < 0)
		{
		    throw new BOException(MessageCodes.INVALID_DATE);
		}
		
		
	    }
	    coreCommonCO.setExemptedFromFilerExpiryDte(exemptionExiryDate);
//	}
	
	return coreCommonCO;
   }
   
    public void setReasonBO(ReasonBO reasonBO)
    {
	this.reasonBO = reasonBO;
    }

    public CoreCommonCO getCoreCommonCO()
    {
        return coreCommonCO;
    }

    public void setCoreCommonCO(CoreCommonCO coreCommonCO)
    {
        this.coreCommonCO = coreCommonCO;
    }
    
    @Override
    public SigCapSignatureCO retSignatureScreen(SignatureSC signatureSC) throws BaseException
    {
	SigCapSignatureCO sigCapSignCO = new SigCapSignatureCO();
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	HashMap resMap = coreCommonDAO.retExtSigAndUrl();
	boolean sigCap = false;
	if(resMap != null)
	{
	    sigCap = resMap.get(SignatureConstant.SIGCAP_EXTERNAL_SIGNATURE_MGT_YN) != null
		    && ((Integer) resMap.get(SignatureConstant.SIGCAP_EXTERNAL_SIGNATURE_MGT_YN)).intValue() == 1;
	}
	if(sigCap)
	{
	    SYS_PARAM_SCREEN_DISPLAYVO accRejBtns = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO accReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO amtTxt = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO cancelBtn = new SYS_PARAM_SCREEN_DISPLAYVO();
	    amtTxt.setIS_READONLY(BigDecimal.ONE);
	    amtTxt.setIS_VISIBLE(BigDecimal.ZERO);
	    accReadOnly.setIS_READONLY(BigDecimal.ONE);

            sigCapSignCO.setSigScreen(SignatureConstant.SIGCAP_SIG_SCREEN);
            // for cardsManagement
            // && !signatureSC.getAppName().equals("PMS") added by abbas for
            // tp#459218
            if(SignatureConstant.CIF_SIGNATURE.equals(signatureSC.getSignatureTp())
                    && !SignatureConstant.PMS_APP.equals(signatureSC.getAppName()))
            {
                return null;
            }
            // added by abbas for tp#459218
            if(SignatureConstant.PMS_APP.equals(signatureSC.getAppName())
                    && signatureSC.getAccountReference().isEmpty())
            {
                return null;
            }
            // end abbas
            // only if there's a url in db fill the related property
            if(resMap.get(SignatureConstant.SIGCAP_EXTERNAL_SIGNATURE_URL) != null)
            {
//                sigCapSignCO.setSigCapUrl(resMap.get(SignatureConstant.SIGCAP_EXTERNAL_SIGNATURE_URL)
//                        + "?Command=LoadForIntegration&AccType=Account+Number&AccNo="
                // + signatureSC.getAccountReference() + "&Amount=" +
                // signatureSC.getAmount() + "&TransId=&");
                
                String sAmt = "";
                if(NumberUtil.isEmptyDecimal(signatureSC.getAmount()) || null == signatureSC.getAmount())
                {
                    sAmt = "";
                }
                else
                {
                    sAmt = signatureSC.getAmount().toString();
                }
                sigCapSignCO.setSigCapUrl(resMap.get(SignatureConstant.SIGCAP_EXTERNAL_SIGNATURE_URL)
                        + "?Command=LoadForIntegration&AccType=Account+Number&AccNo="
                        + signatureSC.getAccountReference() + "&Amount=" + sAmt + "&TransId=&");
                    
            }
            if((signatureSC.isReadOnly() && NumberUtil.isEmptyDecimal(signatureSC.getAmount()))
                    || !signatureSC.isShowAcceptCancelBtns()) // Abdo TP#488342
                                                              // 25/02/2017
            {
                accRejBtns.setIS_VISIBLE(BigDecimal.ZERO);
                cancelBtn.setIS_VISIBLE(BigDecimal.ZERO);
            }
            else
            {
                // && !signatureSC.getAppName().equals("PMS") added by abbas for
                // tp#459218
                if((SignatureConstant.SIGCAP_MODIFY.equals(signatureSC.getFlag())
                        || !NumberUtil.isEmptyDecimal(signatureSC.getAmount()))
                        && !SignatureConstant.PMS_APP.equals(signatureSC.getAppName()))
                {
                    amtTxt.setIS_VISIBLE(BigDecimal.ONE);
                    accRejBtns.setIS_VISIBLE(BigDecimal.ONE);
                    accRejBtns.setIS_READONLY(BigDecimal.ONE);
                }
                else
                {
                    accRejBtns.setIS_VISIBLE(BigDecimal.ZERO);
                    amtTxt.setIS_VISIBLE(BigDecimal.ZERO);
                    cancelBtn.setIS_VISIBLE(BigDecimal.ZERO);
                }
            }
            businessHm.put(SignatureConstant.ACC_NO, accReadOnly);
            businessHm.put(SignatureConstant.SIG_AMT, amtTxt);
            businessHm.put(SignatureConstant.AMT_SIG_CAP_LBL, amtTxt);
            businessHm.put(SignatureConstant.ACCEPT_SIG_CAP_BTN, accRejBtns);
            businessHm.put(SignatureConstant.REJECT_SIG_CAP_BTN, accRejBtns);
            businessHm.put(SignatureConstant.CANCEL_SIG_CAP_BTN, cancelBtn);
            sigCapSignCO.setBusinessHm(businessHm);
        }
        else
        {
            sigCapSignCO.setSigScreen(SignatureConstant.SIG_SIG_SCREEN);
        }
        return sigCapSignCO;
    }

    @Override
    public CTSCONTROL_BY_COMPVO returnCTSControlByComp(CTSCONTROL_BY_COMPVO criteria) throws BaseException
    {
        CTSCONTROL_BY_COMPVO ctscontrolByCompVO = new CTSCONTROL_BY_COMPVO();
        ctscontrolByCompVO.setCOMP_CODE(criteria.getCOMP_CODE());
        ctscontrolByCompVO = (CTSCONTROL_BY_COMPVO) genericDAO.selectByPK(ctscontrolByCompVO);

        return ctscontrolByCompVO;
    }
    
    //Maria BMO180276
    public void validationNidCard(FomSC criteria) throws BaseException
    {
            CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
                ctsControlVO.setCOMP_CODE(criteria.getCompCode());
                ctsControlVO.setBRANCH_CODE(criteria.getBranchCode());

                ctsControlVO = (CTSCONTROLVO) genericDAO.selectByPK(ctsControlVO);
                
                CTSTRXTYPE_EXTENDEDVO ctstrxtypeExtendedVO = new CTSTRXTYPE_EXTENDEDVO();
                if("1".equals(criteria.getFromSrc()))
                {                
                ctstrxtypeExtendedVO.setCOMP_CODE(criteria.getCompCode());
                ctstrxtypeExtendedVO.setCODE(criteria.getTransactionType());
                ctstrxtypeExtendedVO = coreCommonBO.findTrxTypeExtended(ctstrxtypeExtendedVO);
                }
                
            Integer count;
            count = coreCommonDAO.validationNidCard(criteria);
            
            /*FromSrc = 1 from transaction screen
            FromSrc = 2 from card screen
            FromSrc = 3 from chequebook screen
            */
            if ((("1".equals(ctsControlVO.getNOT_ALLOW_CREAT_PROD_ID_EXP_YN()) && !"1".equals(criteria.getFromSrc())) || ("1".equals(criteria.getFromSrc()) && "1".equals(ctstrxtypeExtendedVO.getNOT_ALLOW_CREAT_PROD_ID_EXP_YN())) )  
                            && "1".equals(criteria.getFromExpDateValid()) 
                               && count > 0) 
            {
                    if(criteria.getRunningDate().compareTo(criteria.getIdExpiryDate()) >= 0)
                    {
                            if ("1".equals(criteria.getFromSrc()))
                            {
                                        throw new BOException(MessageCodes.CANNOT_CREATE_TRX_NID_IS_EXPIRED); 
                            }
                            
                            if ("2".equals(criteria.getFromSrc()))
                            {
                                    throw new BOException(MessageCodes.CANNOT_CREATE_CARD_NID_IS_EXPIRED);
                            }
                            
                            if ("3".equals(criteria.getFromSrc()))
                            {
                                    throw new BOException(MessageCodes.CANNOT_CREATE_CHQ_NID_IS_EXPIRED);
                            }                            
                    }
            }
            else if("0".equals(criteria.getFromExpDateValid()) && count > 1)
            {
                    throw new BOException(MessageCodes.CANNOT_CREATE_NID_RELATED_MORE_THAN_ONE_CIF); 
            }
    }
    //added by reda for SUPT190047
    public List<CIFVO> listCIFbyID(CifSC criteria) throws BaseException
    {
                List<CIFVO> lst;
                lst = coreCommonDAO.listCIFbyID(criteria);
                return lst;
    }
    //

}
