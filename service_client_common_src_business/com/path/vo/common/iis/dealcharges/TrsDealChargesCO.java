package com.path.vo.common.iis.dealcharges;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.TRSDEALCHARGESVO;
import com.path.dbmaps.vo.TRSPAYPLAN_CHARGESVO;

public class TrsDealChargesCO extends TRSDEALCHARGESVO implements Serializable
{
    private String lsBriefNameeng;
    private BigDecimal ldecFlatAmount;
    private BigDecimal ldecMinimumAmount;
    private BigDecimal ldecChargePercentage;
    private String lsPeriodicity;
    private String lsProfitOnCharge;
    private String lsPercentageOfProfit;
    private String lsAllowToEditChargePerYn;
    private String lsSpecificBranchCurrency;
    private BigDecimal ldecMaximumAmount;
    private BigDecimal ldrAccBranch;
    private BigDecimal ldrAccCurrency;
    private BigDecimal ldrAccGL;
    private BigDecimal ldrAccCifSubNo;
    private BigDecimal ldrAccSlNo;
    private String lsPayAtDealClosureYn;
    private String profitOnCharge;
    private String EventColumnName;
    private String EventColumn = "N";
    private BigDecimal chargeAmtToInclInPrinciple;
    private BigDecimal insuranceAmount;
    private BigDecimal dealChargesFormat;
    private String TRSCHARGES_BRIEF_NAME_ENG;
    private String TRSCHARGES_PERCENTAGE_OF_PROFIT_YN;
    private String VAT_BRIEF_NAME_ENG;
    private String TRSCHARGES_PERIODICITY;
    private String TRSCHARGES_ALLOW_TO_EDIT_CHARGE_PER_YN;
    private String TRSCHARGES_CREDIT_TO_SD_ACCOUNT_YN;
    private String TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN;
    private String dealChargesFormat_baseCy;
    private String dealChargesFormat_chargeCy;
    // TP#190558; Saheer.Naduthodi; 20/07/2014 [START]
    private BigDecimal drAccGL;
    private BigDecimal drAccCifSubNo;
    private BigDecimal drAccSL;
    private BigDecimal drAccBranch;
    private BigDecimal drAccCurrency;
    private String specificAccBrCy;
    private BigDecimal FLAT_AMOUNT;
    private String RVRS_CHARGE_CANCELLATION_YN;
    // TP#190558; Saheer.Naduthodi; 20/07/2014 [END]

    // TP# 222676; deepu.mohandas; 18/09/2014
    private String ALLOW_EDIT;
    // SBI170098 ; Saheer.Naduthodi; 07/12/2017  [Begin]
    private String templateCodeDesc;
    private BigDecimal TEMPLATE_CODE;
    // SBI170098 ; Saheer.Naduthodi; 07/12/2017  [End]
    private String allowToEditVatCode;// TP#234960;roshin ;28/10/2014
    private String  calcOnYerlyOutstndPrincYN;
    // AUBBH120107 - Installment Rescheduling/ Skip Process ; Modification ; Srikumar [START]
    private Date VALUE_DATE;    
    private String REVERSE_CHARGE_YN;
	// AUBBH120107 - Installment Rescheduling/ Skip Process ; Modification ; Srikumar [END]

    private BigDecimal drDecimals;
    private BigDecimal chargesDecimals;

    // TP AUBBH120107 Hari.K.S
    private TRSPAYPLAN_CHARGESVO trspayplanChargesVO;

    // 856598
    private BigDecimal accountBranch;
    private BigDecimal accountCurrency;
    private BigDecimal creditAccountGL;
    private BigDecimal creditAccountCIF;
    private BigDecimal creditAccountSL;

    // 930836 - BBLI190360
    private String PROFIT_ON_CHARGE;

    public BigDecimal getDealChargesFormat()
    {
	return dealChargesFormat;
    }

    public void setDealChargesFormat(BigDecimal dealChargesFormat)
    {
	this.dealChargesFormat = dealChargesFormat;
    }

    public String getProfitOnCharge()
    {
	return profitOnCharge;
    }

    public void setProfitOnCharge(String profitOnCharge)
    {
	this.profitOnCharge = profitOnCharge;
    }

    public BigDecimal getLdrAccBranch()
    {
	return ldrAccBranch;
    }

    public void setLdrAccBranch(BigDecimal ldrAccBranch)
    {
	this.ldrAccBranch = ldrAccBranch;
    }

    public BigDecimal getLdrAccCurrency()
    {
	return ldrAccCurrency;
    }

    public void setLdrAccCurrency(BigDecimal ldrAccCurrency)
    {
	this.ldrAccCurrency = ldrAccCurrency;
    }

    public BigDecimal getLdrAccGL()
    {
	return ldrAccGL;
    }

    public void setLdrAccGL(BigDecimal ldrAccGL)
    {
	this.ldrAccGL = ldrAccGL;
    }

    public BigDecimal getLdrAccCifSubNo()
    {
	return ldrAccCifSubNo;
    }

    public void setLdrAccCifSubNo(BigDecimal ldrAccCifSubNo)
    {
	this.ldrAccCifSubNo = ldrAccCifSubNo;
    }

    public BigDecimal getLdrAccSlNo()
    {
	return ldrAccSlNo;
    }

    public void setLdrAccSlNo(BigDecimal ldrAccSlNo)
    {
	this.ldrAccSlNo = ldrAccSlNo;
    }

    public String getLsPayAtDealClosureYn()
    {
	return lsPayAtDealClosureYn;
    }

    public void setLsPayAtDealClosureYn(String lsPayAtDealClosureYn)
    {
	this.lsPayAtDealClosureYn = lsPayAtDealClosureYn;
    }

    public BigDecimal getLdecMaximumAmount()
    {
	return ldecMaximumAmount;
    }

    public void setLdecMaximumAmount(BigDecimal ldecMaximumAmount)
    {
	this.ldecMaximumAmount = ldecMaximumAmount;
    }

    public String getLsSpecificBranchCurrency()
    {
	return lsSpecificBranchCurrency;
    }

    public void setLsSpecificBranchCurrency(String lsSpecificBranchCurrency)
    {
	this.lsSpecificBranchCurrency = lsSpecificBranchCurrency;
    }

    public String getLsBriefNameeng()
    {
	return lsBriefNameeng;
    }

    public void setLsBriefNameeng(String lsBriefNameeng)
    {
	this.lsBriefNameeng = lsBriefNameeng;
    }

    public BigDecimal getLdecFlatAmount()
    {
	return ldecFlatAmount;
    }

    public void setLdecFlatAmount(BigDecimal ldecFlatAmount)
    {
	this.ldecFlatAmount = ldecFlatAmount;
    }

    public BigDecimal getLdecMinimumAmount()
    {
	return ldecMinimumAmount;
    }

    public void setLdecMinimumAmount(BigDecimal ldecMinimumAmount)
    {
	this.ldecMinimumAmount = ldecMinimumAmount;
    }

    public BigDecimal getLdecChargePercentage()
    {
	return ldecChargePercentage;
    }

    public void setLdecChargePercentage(BigDecimal ldecChargePercentage)
    {
	this.ldecChargePercentage = ldecChargePercentage;
    }

    public String getLsPeriodicity()
    {
	return lsPeriodicity;
    }

    public void setLsPeriodicity(String lsPeriodicity)
    {
	this.lsPeriodicity = lsPeriodicity;
    }

    public String getLsProfitOnCharge()
    {
	return lsProfitOnCharge;
    }

    public void setLsProfitOnCharge(String lsProfitOnCharge)
    {
	this.lsProfitOnCharge = lsProfitOnCharge;
    }

    public String getLsPercentageOfProfit()
    {
	return lsPercentageOfProfit;
    }

    public void setLsPercentageOfProfit(String lsPercentageOfProfit)
    {
	this.lsPercentageOfProfit = lsPercentageOfProfit;
    }

    public String getEventColumnName()
    {
	return EventColumnName;
    }

    public void setEventColumnName(String eventColumnName)
    {
	EventColumnName = eventColumnName;
    }

    public String getEventColumn()
    {
	return EventColumn;
    }

    public void setEventColumn(String eventColumn)
    {
	EventColumn = eventColumn;
    }

    public BigDecimal getChargeAmtToInclInPrinciple()
    {
	return chargeAmtToInclInPrinciple;
    }

    public void setChargeAmtToInclInPrinciple(BigDecimal chargeAmtToInclInPrinciple)
    {
	this.chargeAmtToInclInPrinciple = chargeAmtToInclInPrinciple;
    }

    public BigDecimal getInsuranceAmount()
    {
	return insuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount)
    {
	this.insuranceAmount = insuranceAmount;
    }

    public String getTRSCHARGES_BRIEF_NAME_ENG()
    {
	return TRSCHARGES_BRIEF_NAME_ENG;
    }

    public void setTRSCHARGES_BRIEF_NAME_ENG(String tRSCHARGESBRIEFNAMEENG)
    {
	TRSCHARGES_BRIEF_NAME_ENG = tRSCHARGESBRIEFNAMEENG;
    }

    public String getTRSCHARGES_PERCENTAGE_OF_PROFIT_YN()
    {
	return TRSCHARGES_PERCENTAGE_OF_PROFIT_YN;
    }

    public void setTRSCHARGES_PERCENTAGE_OF_PROFIT_YN(String tRSCHARGESPERCENTAGEOFPROFITYN)
    {
	TRSCHARGES_PERCENTAGE_OF_PROFIT_YN = tRSCHARGESPERCENTAGEOFPROFITYN;
    }

    public String getVAT_BRIEF_NAME_ENG()
    {
	return VAT_BRIEF_NAME_ENG;
    }

    public void setVAT_BRIEF_NAME_ENG(String vATBRIEFNAMEENG)
    {
	VAT_BRIEF_NAME_ENG = vATBRIEFNAMEENG;
    }

    public String getTRSCHARGES_PERIODICITY()
    {
	return TRSCHARGES_PERIODICITY;
    }

    public void setTRSCHARGES_PERIODICITY(String tRSCHARGESPERIODICITY)
    {
	TRSCHARGES_PERIODICITY = tRSCHARGESPERIODICITY;
    }

    public String getTRSCHARGES_ALLOW_TO_EDIT_CHARGE_PER_YN()
    {
	return TRSCHARGES_ALLOW_TO_EDIT_CHARGE_PER_YN;
    }

    public void setTRSCHARGES_ALLOW_TO_EDIT_CHARGE_PER_YN(String tRSCHARGESALLOWTOEDITCHARGEPERYN)
    {
	TRSCHARGES_ALLOW_TO_EDIT_CHARGE_PER_YN = tRSCHARGESALLOWTOEDITCHARGEPERYN;
    }

    public String getTRSCHARGES_CREDIT_TO_SD_ACCOUNT_YN()
    {
	return TRSCHARGES_CREDIT_TO_SD_ACCOUNT_YN;
    }

    public void setTRSCHARGES_CREDIT_TO_SD_ACCOUNT_YN(String tRSCHARGESCREDITTOSDACCOUNTYN)
    {
	TRSCHARGES_CREDIT_TO_SD_ACCOUNT_YN = tRSCHARGESCREDITTOSDACCOUNTYN;
    }

    public String getTRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN()
    {
	return TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN;
    }

    public void setTRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN(String tRSCHARGESPAYNETINCENTPRINCSTLMTYN)
    {
	TRSCHARGES_PAY_NET_INCENT_PRINC_STLMT_YN = tRSCHARGESPAYNETINCENTPRINCSTLMTYN;
    }

    public String getDealChargesFormat_baseCy()
    {
	return dealChargesFormat_baseCy;
    }

    public void setDealChargesFormat_baseCy(String dealChargesFormatBaseCy)
    {
	dealChargesFormat_baseCy = dealChargesFormatBaseCy;
    }

    public String getDealChargesFormat_chargeCy()
    {
	return dealChargesFormat_chargeCy;
    }

    public void setDealChargesFormat_chargeCy(String dealChargesFormatChargeCy)
    {
	dealChargesFormat_chargeCy = dealChargesFormatChargeCy;
    }

    public BigDecimal getDrAccGL()
    {
	return drAccGL;
    }

    public void setDrAccGL(BigDecimal drAccGL)
    {
	this.drAccGL = drAccGL;
    }

    public BigDecimal getDrAccCifSubNo()
    {
	return drAccCifSubNo;
    }

    public void setDrAccCifSubNo(BigDecimal drAccCifSubNo)
    {
	this.drAccCifSubNo = drAccCifSubNo;
    }

    public BigDecimal getDrAccSL()
    {
	return drAccSL;
    }

    public void setDrAccSL(BigDecimal drAccSL)
    {
	this.drAccSL = drAccSL;
    }

    public BigDecimal getDrAccBranch()
    {
	return drAccBranch;
    }

    public void setDrAccBranch(BigDecimal drAccBranch)
    {
	this.drAccBranch = drAccBranch;
    }

    public BigDecimal getDrAccCurrency()
    {
	return drAccCurrency;
    }

    public void setDrAccCurrency(BigDecimal drAccCurrency)
    {
	this.drAccCurrency = drAccCurrency;
    }

    public String getSpecificAccBrCy()
    {
	return specificAccBrCy;
    }

    public void setSpecificAccBrCy(String specificAccBrCy)
    {
	this.specificAccBrCy = specificAccBrCy;
    }

    public BigDecimal getFLAT_AMOUNT()
    {
	return FLAT_AMOUNT;
    }

    public void setFLAT_AMOUNT(BigDecimal fLATAMOUNT)
    {
	FLAT_AMOUNT = fLATAMOUNT;
    }

    public String getALLOW_EDIT()
    {
	return ALLOW_EDIT;
    }

    public void setALLOW_EDIT(String aLLOWEDIT)
    {
	ALLOW_EDIT = aLLOWEDIT;
    }

    public String getAllowToEditVatCode()
    {
	return allowToEditVatCode;
    }

    public void setAllowToEditVatCode(String allowToEditVatCode)
    {
	this.allowToEditVatCode = allowToEditVatCode;
    }

    public String getRVRS_CHARGE_CANCELLATION_YN()
    {
	return RVRS_CHARGE_CANCELLATION_YN;
    }

    public void setRVRS_CHARGE_CANCELLATION_YN(String rVRSCHARGECANCELLATIONYN)
    {
	RVRS_CHARGE_CANCELLATION_YN = rVRSCHARGECANCELLATIONYN;
    }

    public String getLsAllowToEditChargePerYn()
    {
	return lsAllowToEditChargePerYn;
    }

    public void setLsAllowToEditChargePerYn(String lsAllowToEditChargePerYn)
    {
	this.lsAllowToEditChargePerYn = lsAllowToEditChargePerYn;
    }

    public String getTemplateCodeDesc()
    {
	return templateCodeDesc;
    }

    public void setTemplateCodeDesc(String templateCodeDesc)
    {
	this.templateCodeDesc = templateCodeDesc;
    }

    public BigDecimal getTEMPLATE_CODE()
    {
	return TEMPLATE_CODE;
    }

    public void setTEMPLATE_CODE(BigDecimal tEMPLATE_CODE)
    {
	TEMPLATE_CODE = tEMPLATE_CODE;
    }
  //AUBBH120107 - Installment Rescheduling/ Skip Process ; Modification ; Srikumar [START]
    /**
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.VALUE_DATE
     * @return the value of TRSPAYPLAN_CHARGES.VALUE_DATE
     */
    public Date getVALUE_DATE() {
        return VALUE_DATE;
    }

    /**
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.VALUE_DATE
     * @param VALUE_DATE the value for TRSPAYPLAN_CHARGES.VALUE_DATE
     */
    public void setVALUE_DATE(Date VALUE_DATE) {
        this.VALUE_DATE = VALUE_DATE;
    }

	public String getREVERSE_CHARGE_YN() {
		return REVERSE_CHARGE_YN;
	}

	public void setREVERSE_CHARGE_YN(String rEVERSE_CHARGE_YN) {
		REVERSE_CHARGE_YN = rEVERSE_CHARGE_YN;
	}    
//AUBBH120107 - Installment Rescheduling/ Skip Process ; Modification ; Srikumar [END]

    /**
     * @return the drDecimals
     */
    public BigDecimal getDrDecimals()
    {
	return drDecimals;
    }

    /**
     * @param drDecimals the drDecimals to set
     */
    public void setDrDecimals(BigDecimal drDecimals)
    {
	this.drDecimals = drDecimals;
    }

    /**
     * @return the chargesDecimals
     */
    public BigDecimal getChargesDecimals()
    {
	return chargesDecimals;
    }

    /**
     * @param chargesDecimals the chargesDecimals to set
     */
    public void setChargesDecimals(BigDecimal chargesDecimals)
    {
	this.chargesDecimals = chargesDecimals;
    }

    /**
     * @return the trspayplanChargesVO
     */
    public TRSPAYPLAN_CHARGESVO getTrspayplanChargesVO()
    {
	return trspayplanChargesVO;
    }

    /**
     * @param trspayplanChargesVO the trspayplanChargesVO to set
     */
    public void setTrspayplanChargesVO(TRSPAYPLAN_CHARGESVO trspayplanChargesVO)
    {
	this.trspayplanChargesVO = trspayplanChargesVO;
    }

    /**
     * @return the accountBranch
     */
    public BigDecimal getAccountBranch()
    {
	return accountBranch;
    }

    /**
     * @param accountBranch the accountBranch to set
     */
    public void setAccountBranch(BigDecimal accountBranch)
    {
	this.accountBranch = accountBranch;
    }

    /**
     * @return the accountCurrency
     */
    public BigDecimal getAccountCurrency()
    {
	return accountCurrency;
    }

    /**
     * @param accountCurrency the accountCurrency to set
     */
    public void setAccountCurrency(BigDecimal accountCurrency)
    {
	this.accountCurrency = accountCurrency;
    }

    /**
     * @return the creditAccountGL
     */
    public BigDecimal getCreditAccountGL()
    {
	return creditAccountGL;
    }

    /**
     * @param creditAccountGL the creditAccountGL to set
     */
    public void setCreditAccountGL(BigDecimal creditAccountGL)
    {
	this.creditAccountGL = creditAccountGL;
    }

    /**
     * @return the creditAccountCIF
     */
    public BigDecimal getCreditAccountCIF()
    {
	return creditAccountCIF;
    }

    /**
     * @param creditAccountCIF the creditAccountCIF to set
     */
    public void setCreditAccountCIF(BigDecimal creditAccountCIF)
    {
	this.creditAccountCIF = creditAccountCIF;
    }

    /**
     * @return the creditAccountSL
     */
    public BigDecimal getCreditAccountSL()
    {
	return creditAccountSL;
    }

    /**
     * @param creditAccountSL the creditAccountSL to set
     */
    public void setCreditAccountSL(BigDecimal creditAccountSL)
    {
	this.creditAccountSL = creditAccountSL;
    }

    /**
     * @return the pROFIT_ON_CHARGE
     */
    public String getPROFIT_ON_CHARGE()
    {
	return PROFIT_ON_CHARGE;
    }

    /**
     * @param pROFIT_ON_CHARGE the pROFIT_ON_CHARGE to set
     */
    public void setPROFIT_ON_CHARGE(String pROFIT_ON_CHARGE)
    {
	PROFIT_ON_CHARGE = pROFIT_ON_CHARGE;
    }

	public String getCalcOnYerlyOutstndPrincYN() {
		return calcOnYerlyOutstndPrincYN;
	}

	public void setCalcOnYerlyOutstndPrincYN(String calcOnYerlyOutstndPrincYN) {
		this.calcOnYerlyOutstndPrincYN = calcOnYerlyOutstndPrincYN;
	}


}