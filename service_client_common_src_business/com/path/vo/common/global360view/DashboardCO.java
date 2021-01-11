/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 * 
 * @author: marwanmaddah
 * 
 * DashboardCO.java used to
 */
public class DashboardCO extends RetailBaseVO
{
    private String obligorDesc;
    private String creditRating;
    private String cifBranchDesc;
    private String loginBrType;
    private String currencyMsg;
    private BigDecimal baseCurrencyCode;
    private String baseCurrencyName;

    private BigDecimal safeBoxNbr = BigDecimal.ZERO;
    private BigDecimal cardsNbr = BigDecimal.ZERO;
    private BigDecimal chequeBooksNbr = BigDecimal.ZERO;
    private BigDecimal passBooksNbr = BigDecimal.ZERO;
    private BigDecimal lostDocsNbr = BigDecimal.ZERO;
    private BigDecimal bankersChqNbr = BigDecimal.ZERO;
    private BigDecimal voidedChqsNbr = BigDecimal.ZERO;
    private BigDecimal chequesForCollNbr = BigDecimal.ZERO;
    private BigDecimal postDatedChqWdrawalNbr = BigDecimal.ZERO;
    private BigDecimal postDatedChqDpNbr = BigDecimal.ZERO;
    private BigDecimal specialConditionsNbr = BigDecimal.ZERO;
    private BigDecimal standingOrdersNbr = BigDecimal.ZERO;
    private BigDecimal remittancesNbr = BigDecimal.ZERO;
    private BigDecimal memosNbr = BigDecimal.ZERO;
    private BigDecimal authSignatoriesNbr = BigDecimal.ZERO;
    private BigDecimal linksNbr = BigDecimal.ZERO;
    private BigDecimal smsSubscriptionNbr = BigDecimal.ZERO;

    private BigDecimal dueCode;
    private BigDecimal amfAssetNbr;
    private BigDecimal amfLiabNbr;
    private BigDecimal curBalAssetAmt;
    private BigDecimal curBalLiabAmt;
    private BigDecimal availBalAssetAmt;
    private BigDecimal availBalLiabAmt;
    private BigDecimal blockedBalAssetAmt;
    private BigDecimal blockedBalLiabAmt;
    private BigDecimal overdrawAssetAmt;
    private BigDecimal overdrawLiabAmt;
    private BigDecimal duesAssetAmt;
    private BigDecimal duesLiabAmt;
    private BigDecimal approvedLinesAmt = BigDecimal.ZERO;
    private BigDecimal applicationsAmt;
    private BigDecimal facilitiesAmt;
    private BigDecimal drawdownsAmt;
    private BigDecimal collateralsAmt = BigDecimal.ZERO;
    private BigDecimal guaranteesAmt = BigDecimal.ZERO;
    private BigDecimal lcAmt = BigDecimal.ZERO;
    private BigDecimal lgAmt = BigDecimal.ZERO;
    private BigDecimal billsAmt = BigDecimal.ZERO;
    private BigDecimal acceptanceAmt = BigDecimal.ZERO;
    private BigDecimal totalAssetAmt;
    private BigDecimal totalLiabAmt;
    private BigDecimal totalIliabAmt;
    private BigDecimal totalLimitAmt;
    private BigDecimal settledAssetAmt;
    private BigDecimal settledLiabAmt;
    private BigDecimal settledIliabAmt;
    private BigDecimal settledLimitAmt;
    private BigDecimal outstandAssetAmt;
    private BigDecimal outstandLiabAmt;
    private BigDecimal outstandIliabAmt;
    private BigDecimal outstandLimitAmt;
    private BigDecimal profitAssetAmt;
    private BigDecimal profitLiabAmt;
    private BigDecimal profitIliabAmt;
    private BigDecimal profitLimitAmt;
    private BigDecimal overdueAssetAmt;
    private BigDecimal overdueLiabAmt;
    private BigDecimal overdueIliabAmt;
    private BigDecimal overdueLimitAmt;
    private BigDecimal guaranteesAssetAmt;
    private BigDecimal guaranteesLiabAmt;
    private BigDecimal guaranteesIliabAmt;
    private BigDecimal guaranteesLimitAmt;
    private BigDecimal collateralAssetAmt;
    private BigDecimal collateralLiabAmt;
    private BigDecimal collateralIliabAmt;
    private BigDecimal collateralLimitAmt;
    private BigDecimal promNoteAssetAmt;
    private BigDecimal promNoteLiabAmt;
    private BigDecimal promNoteIliabAmt;
    private BigDecimal promNoteLimitAmt;
    private BigDecimal invCashAmt = BigDecimal.ZERO;
    private BigDecimal invHoldingAmt = BigDecimal.ZERO;
    private BigDecimal invSukukAmt = BigDecimal.ZERO;
    private BigDecimal treasForexAmt = BigDecimal.ZERO;
    private BigDecimal treasMarketAmt = BigDecimal.ZERO;
    private BigDecimal treasDerivAmt = BigDecimal.ZERO;

    private String cif_classification;
    private String cif_BlackList;
    private String cif_status;
    private BigDecimal loginTypeByBr;
    private CIFVO cifVO = new CIFVO();
    
    //PATH130194
    private String userRestrictionOnCIFDetls;
    /**
     * access right
     */
    private String totalAssLiabOpt = "false";
    private String finAppAprLineOpt = "false";
    private String customerGardingOpt = "false";
    private String financingDealsOpt = "false";
    private String investmentsOpt = "false";
    private String productsOpt = "false";
    private String otherOpt = "false";
    private String treasuryOpt = "false";
    private String chequesOpt = "false";

    // Elie Achkar TFA new variables
    private BigDecimal impLcSum = BigDecimal.ZERO;
    private BigDecimal impLcOuts = BigDecimal.ZERO;
    private BigDecimal impLcAccept = BigDecimal.ZERO;
    private BigDecimal impLcSettled = BigDecimal.ZERO;
    private BigDecimal expLcSum = BigDecimal.ZERO;
    private BigDecimal expLcOuts = BigDecimal.ZERO;
    private BigDecimal expLcAccept = BigDecimal.ZERO;
    private BigDecimal expLcSettled = BigDecimal.ZERO;
    private BigDecimal lgOuts = BigDecimal.ZERO;
    private BigDecimal lgSettled = BigDecimal.ZERO;
    private BigDecimal expBillsSum = BigDecimal.ZERO;
    private BigDecimal expBillsOuts = BigDecimal.ZERO;
    private BigDecimal expBillsAccept = BigDecimal.ZERO;
    private BigDecimal expBillsSettled = BigDecimal.ZERO;
    private BigDecimal impBillsSum = BigDecimal.ZERO;
    private BigDecimal impBillsOuts = BigDecimal.ZERO;
    private BigDecimal impBillsAccept = BigDecimal.ZERO;
    private BigDecimal impBillsSettled = BigDecimal.ZERO;
    private String tradeFinanceList;
    private String nickName;
    private String ebankingChannel;

    /**
    * 
    */

    /**
     * Total Assets and liabilities Account
     */
    private String assetsAndLiabList;

    /**
     * Financing Applications And Approved Lines \ Trade Finance Operation
     */
    private String finAppAndAppList;
    /**
     * Financing Deals
     * 
     */
    private String financeDealsList;
    /**
     * Investments & Treasury
     */
    private String investAndTreasuryList;
    
    
    private String priorityDesc;

    private String ATTORNEY_OUTSIDE_COUNTRY_YN;
    
    
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    //Rania - ABSAI180073
    private String scoreRiskDescription;
    private BigDecimal scoreRiskValue;
    //
    
    // DBU191081 Muhammed Anas Start
    private BigDecimal childCif;
    // DBU191081 Muhammed Anas End
    
    private List<String> childcifList = new ArrayList<String>();
    
    /**
     * @return the obligorDesc
     */
    public String getObligorDesc()
    {
        return obligorDesc;
    }

    /**
     * @param obligorDesc the obligorDesc to set
     */
    public void setObligorDesc(String obligorDesc)
    {
        this.obligorDesc = obligorDesc;
    }

    /**
     * @return the creditRating
     */
    public String getCreditRating()
    {
        return creditRating;
    }

    /**
     * @param creditRating the creditRating to set
     */
    public void setCreditRating(String creditRating)
    {
        this.creditRating = creditRating;
    }

    /**
     * @return the cifVO
     */
    public CIFVO getCifVO()
    {
        return cifVO;
    }

    /**
     * @param cifVO the cifVO to set
     */
    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    /**
     * @return the loginBrType
     */
    public String getLoginBrType()
    {
        return loginBrType;
    }

    /**
     * @param loginBrType the loginBrType to set
     */
    public void setLoginBrType(String loginBrType)
    {
        this.loginBrType = loginBrType;
    }

    /**
     * @return the currencyMsg
     */
    public String getCurrencyMsg()
    {
        return currencyMsg;
    }

    /**
     * @param currencyMsg the currencyMsg to set
     */
    public void setCurrencyMsg(String currencyMsg)
    {
        this.currencyMsg = currencyMsg;
    }

    /**
     * @return the safeBoxNbr
     */
    public BigDecimal getSafeBoxNbr()
    {
        return safeBoxNbr;
    }

    /**
     * @param safeBoxNbr the safeBoxNbr to set
     */
    public void setSafeBoxNbr(BigDecimal safeBoxNbr)
    {
        this.safeBoxNbr = safeBoxNbr;
    }

    /**
     * @return the cardsNbr
     */
    public BigDecimal getCardsNbr()
    {
        return cardsNbr;
    }

    /**
     * @param cardsNbr the cardsNbr to set
     */
    public void setCardsNbr(BigDecimal cardsNbr)
    {
        this.cardsNbr = cardsNbr;
    }

    /**
     * @return the chequeBooksNbr
     */
    public BigDecimal getChequeBooksNbr()
    {
        return chequeBooksNbr;
    }

    /**
     * @param chequeBooksNbr the chequeBooksNbr to set
     */
    public void setChequeBooksNbr(BigDecimal chequeBooksNbr)
    {
        this.chequeBooksNbr = chequeBooksNbr;
    }

    /**
     * @return the passBooksNbr
     */
    public BigDecimal getPassBooksNbr()
    {
        return passBooksNbr;
    }

    /**
     * @param passBooksNbr the passBooksNbr to set
     */
    public void setPassBooksNbr(BigDecimal passBooksNbr)
    {
        this.passBooksNbr = passBooksNbr;
    }

    /**
     * @return the lostDocsNbr
     */
    public BigDecimal getLostDocsNbr()
    {
        return lostDocsNbr;
    }

    /**
     * @param lostDocsNbr the lostDocsNbr to set
     */
    public void setLostDocsNbr(BigDecimal lostDocsNbr)
    {
        this.lostDocsNbr = lostDocsNbr;
    }

    /**
     * @return the bankersChqNbr
     */
    public BigDecimal getBankersChqNbr()
    {
        return bankersChqNbr;
    }

    /**
     * @param bankersChqNbr the bankersChqNbr to set
     */
    public void setBankersChqNbr(BigDecimal bankersChqNbr)
    {
        this.bankersChqNbr = bankersChqNbr;
    }

    /**
     * @return the voidedChqsNbr
     */
    public BigDecimal getVoidedChqsNbr()
    {
        return voidedChqsNbr;
    }

    /**
     * @param voidedChqsNbr the voidedChqsNbr to set
     */
    public void setVoidedChqsNbr(BigDecimal voidedChqsNbr)
    {
        this.voidedChqsNbr = voidedChqsNbr;
    }

    /**
     * @return the chequesForCollNbr
     */
    public BigDecimal getChequesForCollNbr()
    {
        return chequesForCollNbr;
    }

    /**
     * @param chequesForCollNbr the chequesForCollNbr to set
     */
    public void setChequesForCollNbr(BigDecimal chequesForCollNbr)
    {
        this.chequesForCollNbr = chequesForCollNbr;
    }

    /**
     * @return the postDatedChqWdrawalNbr
     */
    public BigDecimal getPostDatedChqWdrawalNbr()
    {
        return postDatedChqWdrawalNbr;
    }

    /**
     * @param postDatedChqWdrawalNbr the postDatedChqWdrawalNbr to set
     */
    public void setPostDatedChqWdrawalNbr(BigDecimal postDatedChqWdrawalNbr)
    {
        this.postDatedChqWdrawalNbr = postDatedChqWdrawalNbr;
    }

    /**
     * @return the postDatedChqDpNbr
     */
    public BigDecimal getPostDatedChqDpNbr()
    {
        return postDatedChqDpNbr;
    }

    /**
     * @param postDatedChqDpNbr the postDatedChqDpNbr to set
     */
    public void setPostDatedChqDpNbr(BigDecimal postDatedChqDpNbr)
    {
        this.postDatedChqDpNbr = postDatedChqDpNbr;
    }

    /**
     * @return the specialConditionsNbr
     */
    public BigDecimal getSpecialConditionsNbr()
    {
        return specialConditionsNbr;
    }

    /**
     * @param specialConditionsNbr the specialConditionsNbr to set
     */
    public void setSpecialConditionsNbr(BigDecimal specialConditionsNbr)
    {
        this.specialConditionsNbr = specialConditionsNbr;
    }

    /**
     * @return the standingOrdersNbr
     */
    public BigDecimal getStandingOrdersNbr()
    {
        return standingOrdersNbr;
    }

    /**
     * @param standingOrdersNbr the standingOrdersNbr to set
     */
    public void setStandingOrdersNbr(BigDecimal standingOrdersNbr)
    {
        this.standingOrdersNbr = standingOrdersNbr;
    }

    /**
     * @return the remittancesNbr
     */
    public BigDecimal getRemittancesNbr()
    {
        return remittancesNbr;
    }

    /**
     * @param remittancesNbr the remittancesNbr to set
     */
    public void setRemittancesNbr(BigDecimal remittancesNbr)
    {
        this.remittancesNbr = remittancesNbr;
    }

    /**
     * @return the memosNbr
     */
    public BigDecimal getMemosNbr()
    {
        return memosNbr;
    }

    /**
     * @param memosNbr the memosNbr to set
     */
    public void setMemosNbr(BigDecimal memosNbr)
    {
        this.memosNbr = memosNbr;
    }

    /**
     * @return the authSignatoriesNbr
     */
    public BigDecimal getAuthSignatoriesNbr()
    {
        return authSignatoriesNbr;
    }

    /**
     * @param authSignatoriesNbr the authSignatoriesNbr to set
     */
    public void setAuthSignatoriesNbr(BigDecimal authSignatoriesNbr)
    {
        this.authSignatoriesNbr = authSignatoriesNbr;
    }

    /**
     * @return the linksNbr
     */
    public BigDecimal getLinksNbr()
    {
        return linksNbr;
    }

    /**
     * @param linksNbr the linksNbr to set
     */
    public void setLinksNbr(BigDecimal linksNbr)
    {
        this.linksNbr = linksNbr;
    }

    /**
     * @return the cif_BlackList
     */
    public String getCif_BlackList()
    {
        return cif_BlackList;
    }

    /**
     * @param cifBlackList the cif_BlackList to set
     */
    public void setCif_BlackList(String cifBlackList)
    {
        cif_BlackList = cifBlackList;
    }

    /**
     * @return the cif_classification
     */
    public String getCif_classification()
    {
        return cif_classification;
    }

    /**
     * @param cifClassification the cif_classification to set
     */
    public void setCif_classification(String cifClassification)
    {
        cif_classification = cifClassification;
    }

    /**
     * @return the loginTypeByBr
     */
    public BigDecimal getLoginTypeByBr()
    {
        return loginTypeByBr;
    }

    /**
     * @param loginTypeByBr the loginTypeByBr to set
     */
    public void setLoginTypeByBr(BigDecimal loginTypeByBr)
    {
        this.loginTypeByBr = loginTypeByBr;
    }

    /**
     * @return the cif_status
     */
    public String getCif_status()
    {
        return cif_status;
    }

    /**
     * @param cifStatus the cif_status to set
     */
    public void setCif_status(String cifStatus)
    {
        cif_status = cifStatus;
    }

    /**
     * @return the cifBranchDesc
     */
    public String getCifBranchDesc()
    {
        return cifBranchDesc;
    }

    /**
     * @param cifBranchDesc the cifBranchDesc to set
     */
    public void setCifBranchDesc(String cifBranchDesc)
    {
        this.cifBranchDesc = cifBranchDesc;
    }

    /**
     * @return the baseCurrencyCode
     */
    public BigDecimal getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    /**
     * @param baseCurrencyCode the baseCurrencyCode to set
     */
    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    /**
     * @return the baseCurrencyName
     */
    public String getBaseCurrencyName()
    {
        return baseCurrencyName;
    }

    /**
     * @param baseCurrencyName the baseCurrencyName to set
     */
    public void setBaseCurrencyName(String baseCurrencyName)
    {
        this.baseCurrencyName = baseCurrencyName;
    }

    /**
     * @return the amfAssetNbr
     */
    public BigDecimal getAmfAssetNbr()
    {
        return amfAssetNbr;
    }

    /**
     * @param amfAssetNbr the amfAssetNbr to set
     */
    public void setAmfAssetNbr(BigDecimal amfAssetNbr)
    {
        this.amfAssetNbr = amfAssetNbr;
    }

    /**
     * @return the amfLiabNbr
     */
    public BigDecimal getAmfLiabNbr()
    {
        return amfLiabNbr;
    }

    /**
     * @param amfLiabNbr the amfLiabNbr to set
     */
    public void setAmfLiabNbr(BigDecimal amfLiabNbr)
    {
        this.amfLiabNbr = amfLiabNbr;
    }

    /**
     * @return the curBalAssetAmt
     */
    public BigDecimal getCurBalAssetAmt()
    {
        return curBalAssetAmt;
    }

    /**
     * @param curBalAssetAmt the curBalAssetAmt to set
     */
    public void setCurBalAssetAmt(BigDecimal curBalAssetAmt)
    {
        this.curBalAssetAmt = curBalAssetAmt;
    }

    /**
     * @return the curBalLiabAmt
     */
    public BigDecimal getCurBalLiabAmt()
    {
        return curBalLiabAmt;
    }

    /**
     * @param curBalLiabAmt the curBalLiabAmt to set
     */
    public void setCurBalLiabAmt(BigDecimal curBalLiabAmt)
    {
        this.curBalLiabAmt = curBalLiabAmt;
    }

    /**
     * @return the availBalAssetAmt
     */
    public BigDecimal getAvailBalAssetAmt()
    {
        return availBalAssetAmt;
    }

    /**
     * @param availBalAssetAmt the availBalAssetAmt to set
     */
    public void setAvailBalAssetAmt(BigDecimal availBalAssetAmt)
    {
        this.availBalAssetAmt = availBalAssetAmt;
    }

    /**
     * @return the availBalLiabAmt
     */
    public BigDecimal getAvailBalLiabAmt()
    {
        return availBalLiabAmt;
    }

    /**
     * @param availBalLiabAmt the availBalLiabAmt to set
     */
    public void setAvailBalLiabAmt(BigDecimal availBalLiabAmt)
    {
        this.availBalLiabAmt = availBalLiabAmt;
    }

    /**
     * @return the blockedBalAssetAmt
     */
    public BigDecimal getBlockedBalAssetAmt()
    {
        return blockedBalAssetAmt;
    }

    /**
     * @param blockedBalAssetAmt the blockedBalAssetAmt to set
     */
    public void setBlockedBalAssetAmt(BigDecimal blockedBalAssetAmt)
    {
        this.blockedBalAssetAmt = blockedBalAssetAmt;
    }

    /**
     * @return the blockedBalLiabAmt
     */
    public BigDecimal getBlockedBalLiabAmt()
    {
        return blockedBalLiabAmt;
    }

    /**
     * @param blockedBalLiabAmt the blockedBalLiabAmt to set
     */
    public void setBlockedBalLiabAmt(BigDecimal blockedBalLiabAmt)
    {
        this.blockedBalLiabAmt = blockedBalLiabAmt;
    }

    /**
     * @return the overdrawAssetAmt
     */
    public BigDecimal getOverdrawAssetAmt()
    {
        return overdrawAssetAmt;
    }

    /**
     * @param overdrawAssetAmt the overdrawAssetAmt to set
     */
    public void setOverdrawAssetAmt(BigDecimal overdrawAssetAmt)
    {
        this.overdrawAssetAmt = overdrawAssetAmt;
    }

    /**
     * @return the overdrawLiabAmt
     */
    public BigDecimal getOverdrawLiabAmt()
    {
        return overdrawLiabAmt;
    }

    /**
     * @param overdrawLiabAmt the overdrawLiabAmt to set
     */
    public void setOverdrawLiabAmt(BigDecimal overdrawLiabAmt)
    {
        this.overdrawLiabAmt = overdrawLiabAmt;
    }

    /**
     * @return the duesAssetAmt
     */
    public BigDecimal getDuesAssetAmt()
    {
        return duesAssetAmt;
    }

    /**
     * @param duesAssetAmt the duesAssetAmt to set
     */
    public void setDuesAssetAmt(BigDecimal duesAssetAmt)
    {
        this.duesAssetAmt = duesAssetAmt;
    }

    /**
     * @return the duesLiabAmt
     */
    public BigDecimal getDuesLiabAmt()
    {
        return duesLiabAmt;
    }

    /**
     * @param duesLiabAmt the duesLiabAmt to set
     */
    public void setDuesLiabAmt(BigDecimal duesLiabAmt)
    {
        this.duesLiabAmt = duesLiabAmt;
    }

    /**
     * @return the approvedLinesAmt
     */
    public BigDecimal getApprovedLinesAmt()
    {
        return approvedLinesAmt;
    }

    /**
     * @param approvedLinesAmt the approvedLinesAmt to set
     */
    public void setApprovedLinesAmt(BigDecimal approvedLinesAmt)
    {
        this.approvedLinesAmt = approvedLinesAmt;
    }

    /**
     * @return the applicationsAmt
     */
    public BigDecimal getApplicationsAmt()
    {
        return applicationsAmt;
    }

    /**
     * @param applicationsAmt the applicationsAmt to set
     */
    public void setApplicationsAmt(BigDecimal applicationsAmt)
    {
        this.applicationsAmt = applicationsAmt;
    }

    /**
     * @return the facilitiesAmt
     */
    public BigDecimal getFacilitiesAmt()
    {
        return facilitiesAmt;
    }

    /**
     * @param facilitiesAmt the facilitiesAmt to set
     */
    public void setFacilitiesAmt(BigDecimal facilitiesAmt)
    {
        this.facilitiesAmt = facilitiesAmt;
    }

    /**
     * @return the drawdownsAmt
     */
    public BigDecimal getDrawdownsAmt()
    {
        return drawdownsAmt;
    }

    /**
     * @param drawdownsAmt the drawdownsAmt to set
     */
    public void setDrawdownsAmt(BigDecimal drawdownsAmt)
    {
        this.drawdownsAmt = drawdownsAmt;
    }

    /**
     * @return the collateralsAmt
     */
    public BigDecimal getCollateralsAmt()
    {
        return collateralsAmt;
    }

    /**
     * @param collateralsAmt the collateralsAmt to set
     */
    public void setCollateralsAmt(BigDecimal collateralsAmt)
    {
        this.collateralsAmt = collateralsAmt;
    }

    /**
     * @return the guaranteesAmt
     */
    public BigDecimal getGuaranteesAmt()
    {
        return guaranteesAmt;
    }

    /**
     * @param guaranteesAmt the guaranteesAmt to set
     */
    public void setGuaranteesAmt(BigDecimal guaranteesAmt)
    {
        this.guaranteesAmt = guaranteesAmt;
    }

    /**
     * @return the lcAmt
     */
    public BigDecimal getLcAmt()
    {
        return lcAmt;
    }

    /**
     * @param lcAmt the lcAmt to set
     */
    public void setLcAmt(BigDecimal lcAmt)
    {
        this.lcAmt = lcAmt;
    }

    /**
     * @return the lgAmt
     */
    public BigDecimal getLgAmt()
    {
        return lgAmt;
    }

    /**
     * @param lgAmt the lgAmt to set
     */
    public void setLgAmt(BigDecimal lgAmt)
    {
        this.lgAmt = lgAmt;
    }

    /**
     * @return the billsAmt
     */
    public BigDecimal getBillsAmt()
    {
        return billsAmt;
    }

    /**
     * @param billsAmt the billsAmt to set
     */
    public void setBillsAmt(BigDecimal billsAmt)
    {
        this.billsAmt = billsAmt;
    }

    /**
     * @return the acceptanceAmt
     */
    public BigDecimal getAcceptanceAmt()
    {
        return acceptanceAmt;
    }

    /**
     * @param acceptanceAmt the acceptanceAmt to set
     */
    public void setAcceptanceAmt(BigDecimal acceptanceAmt)
    {
        this.acceptanceAmt = acceptanceAmt;
    }

    /**
     * @return the totalAssetAmt
     */
    public BigDecimal getTotalAssetAmt()
    {
        return totalAssetAmt;
    }

    /**
     * @param totalAssetAmt the totalAssetAmt to set
     */
    public void setTotalAssetAmt(BigDecimal totalAssetAmt)
    {
        this.totalAssetAmt = totalAssetAmt;
    }

    /**
     * @return the totalLiabAmt
     */
    public BigDecimal getTotalLiabAmt()
    {
        return totalLiabAmt;
    }

    /**
     * @param totalLiabAmt the totalLiabAmt to set
     */
    public void setTotalLiabAmt(BigDecimal totalLiabAmt)
    {
        this.totalLiabAmt = totalLiabAmt;
    }

    /**
     * @return the totalIliabAmt
     */
    public BigDecimal getTotalIliabAmt()
    {
        return totalIliabAmt;
    }

    /**
     * @param totalIliabAmt the totalIliabAmt to set
     */
    public void setTotalIliabAmt(BigDecimal totalIliabAmt)
    {
        this.totalIliabAmt = totalIliabAmt;
    }

    /**
     * @return the totalLimitAmt
     */
    public BigDecimal getTotalLimitAmt()
    {
        return totalLimitAmt;
    }

    /**
     * @param totalLimitAmt the totalLimitAmt to set
     */
    public void setTotalLimitAmt(BigDecimal totalLimitAmt)
    {
        this.totalLimitAmt = totalLimitAmt;
    }

    /**
     * @return the settledAssetAmt
     */
    public BigDecimal getSettledAssetAmt()
    {
        return settledAssetAmt;
    }

    /**
     * @param settledAssetAmt the settledAssetAmt to set
     */
    public void setSettledAssetAmt(BigDecimal settledAssetAmt)
    {
        this.settledAssetAmt = settledAssetAmt;
    }

    /**
     * @return the settledLiabAmt
     */
    public BigDecimal getSettledLiabAmt()
    {
        return settledLiabAmt;
    }

    /**
     * @param settledLiabAmt the settledLiabAmt to set
     */
    public void setSettledLiabAmt(BigDecimal settledLiabAmt)
    {
        this.settledLiabAmt = settledLiabAmt;
    }

    /**
     * @return the settledIliabAmt
     */
    public BigDecimal getSettledIliabAmt()
    {
        return settledIliabAmt;
    }

    /**
     * @param settledIliabAmt the settledIliabAmt to set
     */
    public void setSettledIliabAmt(BigDecimal settledIliabAmt)
    {
        this.settledIliabAmt = settledIliabAmt;
    }

    /**
     * @return the settledLimitAmt
     */
    public BigDecimal getSettledLimitAmt()
    {
        return settledLimitAmt;
    }

    /**
     * @param settledLimitAmt the settledLimitAmt to set
     */
    public void setSettledLimitAmt(BigDecimal settledLimitAmt)
    {
        this.settledLimitAmt = settledLimitAmt;
    }

    /**
     * @return the outstandAssetAmt
     */
    public BigDecimal getOutstandAssetAmt()
    {
        return outstandAssetAmt;
    }

    /**
     * @param outstandAssetAmt the outstandAssetAmt to set
     */
    public void setOutstandAssetAmt(BigDecimal outstandAssetAmt)
    {
        this.outstandAssetAmt = outstandAssetAmt;
    }

    /**
     * @return the outstandLiabAmt
     */
    public BigDecimal getOutstandLiabAmt()
    {
        return outstandLiabAmt;
    }

    /**
     * @param outstandLiabAmt the outstandLiabAmt to set
     */
    public void setOutstandLiabAmt(BigDecimal outstandLiabAmt)
    {
        this.outstandLiabAmt = outstandLiabAmt;
    }

    /**
     * @return the outstandIliabAmt
     */
    public BigDecimal getOutstandIliabAmt()
    {
        return outstandIliabAmt;
    }

    /**
     * @param outstandIliabAmt the outstandIliabAmt to set
     */
    public void setOutstandIliabAmt(BigDecimal outstandIliabAmt)
    {
        this.outstandIliabAmt = outstandIliabAmt;
    }

    /**
     * @return the outstandLimitAmt
     */
    public BigDecimal getOutstandLimitAmt()
    {
        return outstandLimitAmt;
    }

    /**
     * @param outstandLimitAmt the outstandLimitAmt to set
     */
    public void setOutstandLimitAmt(BigDecimal outstandLimitAmt)
    {
        this.outstandLimitAmt = outstandLimitAmt;
    }

    /**
     * @return the profitAssetAmt
     */
    public BigDecimal getProfitAssetAmt()
    {
        return profitAssetAmt;
    }

    /**
     * @param profitAssetAmt the profitAssetAmt to set
     */
    public void setProfitAssetAmt(BigDecimal profitAssetAmt)
    {
        this.profitAssetAmt = profitAssetAmt;
    }

    /**
     * @return the profitLiabAmt
     */
    public BigDecimal getProfitLiabAmt()
    {
        return profitLiabAmt;
    }

    /**
     * @param profitLiabAmt the profitLiabAmt to set
     */
    public void setProfitLiabAmt(BigDecimal profitLiabAmt)
    {
        this.profitLiabAmt = profitLiabAmt;
    }

    /**
     * @return the profitIliabAmt
     */
    public BigDecimal getProfitIliabAmt()
    {
        return profitIliabAmt;
    }

    /**
     * @param profitIliabAmt the profitIliabAmt to set
     */
    public void setProfitIliabAmt(BigDecimal profitIliabAmt)
    {
        this.profitIliabAmt = profitIliabAmt;
    }

    /**
     * @return the profitLimitAmt
     */
    public BigDecimal getProfitLimitAmt()
    {
        return profitLimitAmt;
    }

    /**
     * @param profitLimitAmt the profitLimitAmt to set
     */
    public void setProfitLimitAmt(BigDecimal profitLimitAmt)
    {
        this.profitLimitAmt = profitLimitAmt;
    }

    /**
     * @return the overdueAssetAmt
     */
    public BigDecimal getOverdueAssetAmt()
    {
        return overdueAssetAmt;
    }

    /**
     * @param overdueAssetAmt the overdueAssetAmt to set
     */
    public void setOverdueAssetAmt(BigDecimal overdueAssetAmt)
    {
        this.overdueAssetAmt = overdueAssetAmt;
    }

    /**
     * @return the overdueLiabAmt
     */
    public BigDecimal getOverdueLiabAmt()
    {
        return overdueLiabAmt;
    }

    /**
     * @param overdueLiabAmt the overdueLiabAmt to set
     */
    public void setOverdueLiabAmt(BigDecimal overdueLiabAmt)
    {
        this.overdueLiabAmt = overdueLiabAmt;
    }

    /**
     * @return the overdueIliabAmt
     */
    public BigDecimal getOverdueIliabAmt()
    {
        return overdueIliabAmt;
    }

    /**
     * @param overdueIliabAmt the overdueIliabAmt to set
     */
    public void setOverdueIliabAmt(BigDecimal overdueIliabAmt)
    {
        this.overdueIliabAmt = overdueIliabAmt;
    }

    /**
     * @return the overdueLimitAmt
     */
    public BigDecimal getOverdueLimitAmt()
    {
        return overdueLimitAmt;
    }

    /**
     * @param overdueLimitAmt the overdueLimitAmt to set
     */
    public void setOverdueLimitAmt(BigDecimal overdueLimitAmt)
    {
        this.overdueLimitAmt = overdueLimitAmt;
    }

    /**
     * @return the guaranteesAssetAmt
     */
    public BigDecimal getGuaranteesAssetAmt()
    {
        return guaranteesAssetAmt;
    }

    /**
     * @param guaranteesAssetAmt the guaranteesAssetAmt to set
     */
    public void setGuaranteesAssetAmt(BigDecimal guaranteesAssetAmt)
    {
        this.guaranteesAssetAmt = guaranteesAssetAmt;
    }

    /**
     * @return the guaranteesLiabAmt
     */
    public BigDecimal getGuaranteesLiabAmt()
    {
        return guaranteesLiabAmt;
    }

    /**
     * @param guaranteesLiabAmt the guaranteesLiabAmt to set
     */
    public void setGuaranteesLiabAmt(BigDecimal guaranteesLiabAmt)
    {
        this.guaranteesLiabAmt = guaranteesLiabAmt;
    }

    /**
     * @return the guaranteesIliabAmt
     */
    public BigDecimal getGuaranteesIliabAmt()
    {
        return guaranteesIliabAmt;
    }

    /**
     * @param guaranteesIliabAmt the guaranteesIliabAmt to set
     */
    public void setGuaranteesIliabAmt(BigDecimal guaranteesIliabAmt)
    {
        this.guaranteesIliabAmt = guaranteesIliabAmt;
    }

    /**
     * @return the guaranteesLimitAmt
     */
    public BigDecimal getGuaranteesLimitAmt()
    {
        return guaranteesLimitAmt;
    }

    /**
     * @param guaranteesLimitAmt the guaranteesLimitAmt to set
     */
    public void setGuaranteesLimitAmt(BigDecimal guaranteesLimitAmt)
    {
        this.guaranteesLimitAmt = guaranteesLimitAmt;
    }

    /**
     * @return the collateralAssetAmt
     */
    public BigDecimal getCollateralAssetAmt()
    {
        return collateralAssetAmt;
    }

    /**
     * @param collateralAssetAmt the collateralAssetAmt to set
     */
    public void setCollateralAssetAmt(BigDecimal collateralAssetAmt)
    {
        this.collateralAssetAmt = collateralAssetAmt;
    }

    /**
     * @return the collateralLiabAmt
     */
    public BigDecimal getCollateralLiabAmt()
    {
        return collateralLiabAmt;
    }

    /**
     * @param collateralLiabAmt the collateralLiabAmt to set
     */
    public void setCollateralLiabAmt(BigDecimal collateralLiabAmt)
    {
        this.collateralLiabAmt = collateralLiabAmt;
    }

    /**
     * @return the collateralIliabAmt
     */
    public BigDecimal getCollateralIliabAmt()
    {
        return collateralIliabAmt;
    }

    /**
     * @param collateralIliabAmt the collateralIliabAmt to set
     */
    public void setCollateralIliabAmt(BigDecimal collateralIliabAmt)
    {
        this.collateralIliabAmt = collateralIliabAmt;
    }

    /**
     * @return the collateralLimitAmt
     */
    public BigDecimal getCollateralLimitAmt()
    {
        return collateralLimitAmt;
    }

    /**
     * @param collateralLimitAmt the collateralLimitAmt to set
     */
    public void setCollateralLimitAmt(BigDecimal collateralLimitAmt)
    {
        this.collateralLimitAmt = collateralLimitAmt;
    }

    /**
     * @return the promNoteAssetAmt
     */
    public BigDecimal getPromNoteAssetAmt()
    {
        return promNoteAssetAmt;
    }

    /**
     * @param promNoteAssetAmt the promNoteAssetAmt to set
     */
    public void setPromNoteAssetAmt(BigDecimal promNoteAssetAmt)
    {
        this.promNoteAssetAmt = promNoteAssetAmt;
    }

    /**
     * @return the promNoteLiabAmt
     */
    public BigDecimal getPromNoteLiabAmt()
    {
        return promNoteLiabAmt;
    }

    /**
     * @param promNoteLiabAmt the promNoteLiabAmt to set
     */
    public void setPromNoteLiabAmt(BigDecimal promNoteLiabAmt)
    {
        this.promNoteLiabAmt = promNoteLiabAmt;
    }

    /**
     * @return the promNoteIliabAmt
     */
    public BigDecimal getPromNoteIliabAmt()
    {
        return promNoteIliabAmt;
    }

    /**
     * @param promNoteIliabAmt the promNoteIliabAmt to set
     */
    public void setPromNoteIliabAmt(BigDecimal promNoteIliabAmt)
    {
        this.promNoteIliabAmt = promNoteIliabAmt;
    }

    /**
     * @return the promNoteLimitAmt
     */
    public BigDecimal getPromNoteLimitAmt()
    {
        return promNoteLimitAmt;
    }

    /**
     * @param promNoteLimitAmt the promNoteLimitAmt to set
     */
    public void setPromNoteLimitAmt(BigDecimal promNoteLimitAmt)
    {
        this.promNoteLimitAmt = promNoteLimitAmt;
    }

    /**
     * @return the invCashAmt
     */
    public BigDecimal getInvCashAmt()
    {
        return invCashAmt;
    }

    /**
     * @param invCashAmt the invCashAmt to set
     */
    public void setInvCashAmt(BigDecimal invCashAmt)
    {
        this.invCashAmt = invCashAmt;
    }

    /**
     * @return the invHoldingAmt
     */
    public BigDecimal getInvHoldingAmt()
    {
        return invHoldingAmt;
    }

    /**
     * @param invHoldingAmt the invHoldingAmt to set
     */
    public void setInvHoldingAmt(BigDecimal invHoldingAmt)
    {
        this.invHoldingAmt = invHoldingAmt;
    }

    /**
     * @return the treasForexAmt
     */
    public BigDecimal getTreasForexAmt()
    {
        return treasForexAmt;
    }

    /**
     * @param treasForexAmt the treasForexAmt to set
     */
    public void setTreasForexAmt(BigDecimal treasForexAmt)
    {
        this.treasForexAmt = treasForexAmt;
    }

    /**
     * @return the treasMarketAmt
     */
    public BigDecimal getTreasMarketAmt()
    {
        return treasMarketAmt;
    }

    /**
     * @param treasMarketAmt the treasMarketAmt to set
     */
    public void setTreasMarketAmt(BigDecimal treasMarketAmt)
    {
        this.treasMarketAmt = treasMarketAmt;
    }

    /**
     * @return the treasDerivAmt
     */
    public BigDecimal getTreasDerivAmt()
    {
        return treasDerivAmt;
    }

    /**
     * @param treasDerivAmt the treasDerivAmt to set
     */
    public void setTreasDerivAmt(BigDecimal treasDerivAmt)
    {
        this.treasDerivAmt = treasDerivAmt;
    }

    /**
     * @return the assetsAndLiabList
     */
    public String getAssetsAndLiabList()
    {
        return assetsAndLiabList;
    }

    /**
     * @param assetsAndLiabList the assetsAndLiabList to set
     */
    public void setAssetsAndLiabList(String assetsAndLiabList)
    {
        this.assetsAndLiabList = assetsAndLiabList;
    }

    /**
     * @return the finAppAndAppList
     */
    public String getFinAppAndAppList()
    {
        return finAppAndAppList;
    }

    /**
     * @param finAppAndAppList the finAppAndAppList to set
     */
    public void setFinAppAndAppList(String finAppAndAppList)
    {
        this.finAppAndAppList = finAppAndAppList;
    }

    /**
     * @return the financeDealsList
     */
    public String getFinanceDealsList()
    {
        return financeDealsList;
    }

    /**
     * @param financeDealsList the financeDealsList to set
     */
    public void setFinanceDealsList(String financeDealsList)
    {
        this.financeDealsList = financeDealsList;
    }

    /**
     * @return the investAndTreasuryList
     */
    public String getInvestAndTreasuryList()
    {
        return investAndTreasuryList;
    }

    /**
     * @param investAndTreasuryList the investAndTreasuryList to set
     */
    public void setInvestAndTreasuryList(String investAndTreasuryList)
    {
        this.investAndTreasuryList = investAndTreasuryList;
    }

    /**
     * @return the totalAssLiabOpt
     */
    public String getTotalAssLiabOpt()
    {
        return totalAssLiabOpt;
    }

    /**
     * @param totalAssLiabOpt the totalAssLiabOpt to set
     */
    public void setTotalAssLiabOpt(String totalAssLiabOpt)
    {
        this.totalAssLiabOpt = totalAssLiabOpt;
    }

    /**
     * @return the finAppAprLineOpt
     */
    public String getFinAppAprLineOpt()
    {
        return finAppAprLineOpt;
    }

    /**
     * @param finAppAprLineOpt the finAppAprLineOpt to set
     */
    public void setFinAppAprLineOpt(String finAppAprLineOpt)
    {
        this.finAppAprLineOpt = finAppAprLineOpt;
    }

    /**
     * @return the customerGardingOpt
     */
    public String getCustomerGardingOpt()
    {
        return customerGardingOpt;
    }

    /**
     * @param customerGardingOpt the customerGardingOpt to set
     */
    public void setCustomerGardingOpt(String customerGardingOpt)
    {
        this.customerGardingOpt = customerGardingOpt;
    }

    /**
     * @return the financingDealsOpt
     */
    public String getFinancingDealsOpt()
    {
        return financingDealsOpt;
    }

    /**
     * @param financingDealsOpt the financingDealsOpt to set
     */
    public void setFinancingDealsOpt(String financingDealsOpt)
    {
        this.financingDealsOpt = financingDealsOpt;
    }

    /**
     * @return the investmentsOpt
     */
    public String getInvestmentsOpt()
    {
        return investmentsOpt;
    }

    /**
     * @param investmentsOpt the investmentsOpt to set
     */
    public void setInvestmentsOpt(String investmentsOpt)
    {
        this.investmentsOpt = investmentsOpt;
    }

    /**
     * @return the productsOpt
     */
    public String getProductsOpt()
    {
        return productsOpt;
    }

    /**
     * @param productsOpt the productsOpt to set
     */
    public void setProductsOpt(String productsOpt)
    {
        this.productsOpt = productsOpt;
    }

    /**
     * @return the otherOpt
     */
    public String getOtherOpt()
    {
        return otherOpt;
    }

    /**
     * @param otherOpt the otherOpt to set
     */
    public void setOtherOpt(String otherOpt)
    {
        this.otherOpt = otherOpt;
    }

    /**
     * @return the treasuryOpt
     */
    public String getTreasuryOpt()
    {
        return treasuryOpt;
    }

    /**
     * @param treasuryOpt the treasuryOpt to set
     */
    public void setTreasuryOpt(String treasuryOpt)
    {
        this.treasuryOpt = treasuryOpt;
    }

    /**
     * @return the chequesOpt
     */
    public String getChequesOpt()
    {
        return chequesOpt;
    }

    /**
     * @param chequesOpt the chequesOpt to set
     */
    public void setChequesOpt(String chequesOpt)
    {
        this.chequesOpt = chequesOpt;
    }

    /**
     * @return the invSukukAmt
     */
    public BigDecimal getInvSukukAmt()
    {
        return invSukukAmt;
    }

    /**
     * @param invSukukAmt the invSukukAmt to set
     */
    public void setInvSukukAmt(BigDecimal invSukukAmt)
    {
        this.invSukukAmt = invSukukAmt;
    }

    public BigDecimal getDueCode()
    {
        return dueCode;
    }

    public void setDueCode(BigDecimal dueCode)
    {
        this.dueCode = dueCode;
    }

    /**
     * @return the impLcSum
     */
    public BigDecimal getImpLcSum()
    {
        return impLcSum;
    }

    /**
     * @param impLcSum the impLcSum to set
     */
    public void setImpLcSum(BigDecimal impLcSum)
    {
        this.impLcSum = impLcSum;
    }

    /**
     * @return the impLcOuts
     */
    public BigDecimal getImpLcOuts()
    {
        return impLcOuts;
    }

    /**
     * @param impLcOuts the impLcOuts to set
     */
    public void setImpLcOuts(BigDecimal impLcOuts)
    {
        this.impLcOuts = impLcOuts;
    }

    /**
     * @return the impLcAccept
     */
    public BigDecimal getImpLcAccept()
    {
        return impLcAccept;
    }

    /**
     * @param impLcAccept the impLcAccept to set
     */
    public void setImpLcAccept(BigDecimal impLcAccept)
    {
        this.impLcAccept = impLcAccept;
    }

    /**
     * @return the impLcSettled
     */
    public BigDecimal getImpLcSettled()
    {
        return impLcSettled;
    }

    /**
     * @param impLcSettled the impLcSettled to set
     */
    public void setImpLcSettled(BigDecimal impLcSettled)
    {
        this.impLcSettled = impLcSettled;
    }

    /**
     * @return the expLcSum
     */
    public BigDecimal getExpLcSum()
    {
        return expLcSum;
    }

    /**
     * @param expLcSum the expLcSum to set
     */
    public void setExpLcSum(BigDecimal expLcSum)
    {
        this.expLcSum = expLcSum;
    }

    /**
     * @return the expLcOuts
     */
    public BigDecimal getExpLcOuts()
    {
        return expLcOuts;
    }

    /**
     * @param expLcOuts the expLcOuts to set
     */
    public void setExpLcOuts(BigDecimal expLcOuts)
    {
        this.expLcOuts = expLcOuts;
    }

    /**
     * @return the expLcAccept
     */
    public BigDecimal getExpLcAccept()
    {
        return expLcAccept;
    }

    /**
     * @param expLcAccept the expLcAccept to set
     */
    public void setExpLcAccept(BigDecimal expLcAccept)
    {
        this.expLcAccept = expLcAccept;
    }

    /**
     * @return the expLcSettled
     */
    public BigDecimal getExpLcSettled()
    {
        return expLcSettled;
    }

    /**
     * @param expLcSettled the expLcSettled to set
     */
    public void setExpLcSettled(BigDecimal expLcSettled)
    {
        this.expLcSettled = expLcSettled;
    }

    /**
     * @return the lgOuts
     */
    public BigDecimal getLgOuts()
    {
        return lgOuts;
    }

    /**
     * @param lgOuts the lgOuts to set
     */
    public void setLgOuts(BigDecimal lgOuts)
    {
        this.lgOuts = lgOuts;
    }

    /**
     * @return the lgSettled
     */
    public BigDecimal getLgSettled()
    {
        return lgSettled;
    }

    /**
     * @param lgSettled the lgSettled to set
     */
    public void setLgSettled(BigDecimal lgSettled)
    {
        this.lgSettled = lgSettled;
    }

    /**
     * @return the expBillsSum
     */
    public BigDecimal getExpBillsSum()
    {
        return expBillsSum;
    }

    /**
     * @param expBillsSum the expBillsSum to set
     */
    public void setExpBillsSum(BigDecimal expBillsSum)
    {
        this.expBillsSum = expBillsSum;
    }

    /**
     * @return the expBillsOuts
     */
    public BigDecimal getExpBillsOuts()
    {
        return expBillsOuts;
    }

    /**
     * @param expBillsOuts the expBillsOuts to set
     */
    public void setExpBillsOuts(BigDecimal expBillsOuts)
    {
        this.expBillsOuts = expBillsOuts;
    }

    /**
     * @return the expBillsAccept
     */
    public BigDecimal getExpBillsAccept()
    {
        return expBillsAccept;
    }

    /**
     * @param expBillsAccept the expBillsAccept to set
     */
    public void setExpBillsAccept(BigDecimal expBillsAccept)
    {
        this.expBillsAccept = expBillsAccept;
    }

    /**
     * @return the expBillsSettled
     */
    public BigDecimal getExpBillsSettled()
    {
        return expBillsSettled;
    }

    /**
     * @param expBillsSettled the expBillsSettled to set
     */
    public void setExpBillsSettled(BigDecimal expBillsSettled)
    {
        this.expBillsSettled = expBillsSettled;
    }

    /**
     * @return the impBillsSum
     */
    public BigDecimal getImpBillsSum()
    {
        return impBillsSum;
    }

    /**
     * @param impBillsSum the impBillsSum to set
     */
    public void setImpBillsSum(BigDecimal impBillsSum)
    {
        this.impBillsSum = impBillsSum;
    }

    /**
     * @return the impBillsOuts
     */
    public BigDecimal getImpBillsOuts()
    {
        return impBillsOuts;
    }

    /**
     * @param impBillsOuts the impBillsOuts to set
     */
    public void setImpBillsOuts(BigDecimal impBillsOuts)
    {
        this.impBillsOuts = impBillsOuts;
    }

    /**
     * @return the impBillsAccept
     */
    public BigDecimal getImpBillsAccept()
    {
        return impBillsAccept;
    }

    /**
     * @param impBillsAccept the impBillsAccept to set
     */
    public void setImpBillsAccept(BigDecimal impBillsAccept)
    {
        this.impBillsAccept = impBillsAccept;
    }

    /**
     * @return the impBillsSettled
     */
    public BigDecimal getImpBillsSettled()
    {
        return impBillsSettled;
    }

    /**
     * @param impBillsSettled the impBillsSettled to set
     */
    public void setImpBillsSettled(BigDecimal impBillsSettled)
    {
        this.impBillsSettled = impBillsSettled;
    }

    /**
     * @return the tradeFinanceList
     */
    public String getTradeFinanceList()
    {
        return tradeFinanceList;
    }

    /**
     * @param tradeFinanceList the tradeFinanceList to set
     */
    public void setTradeFinanceList(String tradeFinanceList)
    {
        this.tradeFinanceList = tradeFinanceList;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getEbankingChannel()
    {
        return ebankingChannel;
    }

    public void setEbankingChannel(String ebankingChannel)
    {
        this.ebankingChannel = ebankingChannel;
    }
    
    public String getUserRestrictionOnCIFDetls()
    {
        return userRestrictionOnCIFDetls;
    }

    public void setUserRestrictionOnCIFDetls(String userRestrictionOnCIFDetls)
    {
        this.userRestrictionOnCIFDetls = userRestrictionOnCIFDetls;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    public String getPriorityDesc()
    {
        return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc)
    {
        this.priorityDesc = priorityDesc;
    }

    

    public BigDecimal getSmsSubscriptionNbr()
    {
        return smsSubscriptionNbr;
    }

    public void setSmsSubscriptionNbr(BigDecimal smsSubscriptionNbr)
    {
        this.smsSubscriptionNbr = smsSubscriptionNbr;
    }

    public String getATTORNEY_OUTSIDE_COUNTRY_YN()
    {
        return ATTORNEY_OUTSIDE_COUNTRY_YN;
    }

    public void setATTORNEY_OUTSIDE_COUNTRY_YN(String aTTORNEY_OUTSIDE_COUNTRY_YN)
    {
        ATTORNEY_OUTSIDE_COUNTRY_YN = aTTORNEY_OUTSIDE_COUNTRY_YN;
    }

    public String getScoreRiskDescription()
    {
        return scoreRiskDescription;
    }

    public void setScoreRiskDescription(String scoreRiskDescription)
    {
        this.scoreRiskDescription = scoreRiskDescription;
    }

    public BigDecimal getScoreRiskValue()
    {
        return scoreRiskValue;
    }

    public void setScoreRiskValue(BigDecimal scoreRiskValue)
    {
        this.scoreRiskValue = scoreRiskValue;
    }
    
    
    public List<String> getChildcifList()
    {
	return childcifList;
    }

    public void setChildcifList(List<String> childcifList)
    {
	this.childcifList = childcifList;
    }
   
    public BigDecimal getChildCif() {
	return childCif;
    }

    public void setChildCif(BigDecimal childCif) {
	this.childCif = childCif;
    }
}
