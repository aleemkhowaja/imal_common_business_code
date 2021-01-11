package com.path.vo.common.fms.limitscommon;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class FmsOneObligorDetCO extends BaseVO
{
    private BigDecimal compCode; // gv_company_code @AL_COMP_CODE
    private BigDecimal branchCode; // gv_branch_code @AL_BRANCH_CODE -
				   // @AL_FAC_BRANCH
    private String userId; // gv_userid @AS_USER_ID
    private BigDecimal counterParty; // ll_counter_party @AL_CIF
    private String trxType; // 'A' @AS_TRX_TYPE
    private String facilityType; // ls_facility_type @AS_FLAG
    private BigDecimal amountCV; // ldec_amount_cv @ADC_FAC_AMOUNT
    private BigDecimal currency; // ll_cy @AL_FAC_CY
    private BigDecimal dealRate; // ldec_limit @ADC_DEAL_RATE
    private BigDecimal currencyUnit; // ll_cy_unit @AL_FAC_UNIT
    private String multiDiv; // ls_multi_div @AS_FAC_MULT_DIV
    private String generalType; // ls_gen_fac_type @AS_GENERAL_TYPE
    private BigDecimal productClass; // ll_class @AL_CLASS
    private BigDecimal productClassType;// ll_class_type @AL_CLASS_TYPE
    private Date valueDate; // ldt_value_date @ADT_VALUE_DATE
    private Date effectiveFromDate; // @ADT_EFFECT_FROM_DATE
				    // @ADT_EFFECT_FROM_DATE
    private Date effectiveToDate; // @ADT_EFFECT_TO_DATE @ADT_EFFECT_TO_DATE
    private Date unutilizeExpiryDate; // @ADT_UNTILIZE_EXP_DATE
				      // @ADT_UNTILIZE_EXP_DATE
    private Date runningDate;
    private BigDecimal code; // ll_code @AL_FACILITY_NO
    private BigDecimal drawdownNo; // @AL_DRWDWN_NO
    private BigDecimal errorNo; // ll_error @AL_ERROR
    private String errorDesc; // ls_error_desc @AS_ERROR
    private String fromScreen; // APPL_FAC_SCREEN/REQ_FIN_SCREEN/FAC_SCREEN/DRAW_DN_SCREEN
    private BigDecimal amountValue; // ldec_amount
    private BigDecimal exchRate; // exch_rate
    private BigDecimal facilityValue; // facility_value
    private BigDecimal fromFacility; // from_facility
    private BigDecimal facilityBranch; // facility_branch
    private BigDecimal facilityTypeClass;// facility_type_class
    private BigDecimal valueCV; // value_cv
    private BigDecimal availableLimit; // ldec_available

    private BigDecimal amount; // adec_amount Param 1 of wf_validate_one_obligor
    private BigDecimal rowNo; // al_row Param 2 of wf_validate_one_obligor
    private String calledFrom; // as_called_from Param 3 of
			       // wf_validate_one_obligor
    
    
    private BigDecimal dealNo; // AL_DEAL_NO
    private BigDecimal dealAmount; // ADC_DEAL_AMOUNT
    private BigDecimal dealYeild; // ADC_DEAL_YIELD
    private String dealType; // AS_DEAL_TYPE
    private String cashFinanceFlag; // AS_DEAL_TYPE
    private Date maturityDate; // @ADT_MATURITY_DT
    private BigDecimal subLimitNo; // SUB LIMIT NUMBER
    private BigDecimal drawDownBranch; // facility_branch
    private String limitFlag; // NULL FOR CHECKING 1/INSERTSUBLIMIT/DRWDWN 2/UPDATE LIMIT  3/SETTLE LIMIT
    private String drawDownStatus; // 'U' UPDATE,APPROVE  'D' REVERSEM,DELETE
    private BigDecimal amountWithCompany; // AMOUNT WITH COMPANY
    private BigDecimal amountWithClient; // AMOUNT WITH CLIENT
    private BigDecimal unUtilzed; 
    private BigDecimal trsNo; 
    private String tfaDrawDown; //  IIS ('Y' - IIS using TFA DD ; N - Default value)
 

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public BigDecimal getRowNo()
    {
	return rowNo;
    }

    public void setRowNo(BigDecimal rowNo)
    {
	this.rowNo = rowNo;
    }

    public String getCalledFrom()
    {
	return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public String getFromScreen()
    {
	return fromScreen;
    }

    public void setFromScreen(String fromScreen)
    {
	this.fromScreen = fromScreen;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public BigDecimal getCounterParty()
    {
	return counterParty;
    }

    public void setCounterParty(BigDecimal counterParty)
    {
	this.counterParty = counterParty;
    }

    public String getTrxType()
    {
	return trxType;
    }

    public void setTrxType(String trxType)
    {
	this.trxType = trxType;
    }

    public String getFacilityType()
    {
	return facilityType;
    }

    public void setFacilityType(String facilityType)
    {
	this.facilityType = facilityType;
    }

    public BigDecimal getAmountCV()
    {
	return amountCV;
    }

    public void setAmountCV(BigDecimal amountCV)
    {
	this.amountCV = amountCV;
    }

    public BigDecimal getCurrency()
    {
	return currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	this.currency = currency;
    }

    public BigDecimal getDealRate()
    {
	return dealRate;
    }

    public void setDealRate(BigDecimal dealRate)
    {
	this.dealRate = dealRate;
    }

    public BigDecimal getCurrencyUnit()
    {
	return currencyUnit;
    }

    public void setCurrencyUnit(BigDecimal currencyUnit)
    {
	this.currencyUnit = currencyUnit;
    }

    public String getMultiDiv()
    {
	return multiDiv;
    }

    public void setMultiDiv(String multiDiv)
    {
	this.multiDiv = multiDiv;
    }

    public String getGeneralType()
    {
	return generalType;
    }

    public void setGeneralType(String generalType)
    {
	this.generalType = generalType;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public BigDecimal getProductClassType()
    {
	return productClassType;
    }

    public void setProductClassType(BigDecimal productClassType)
    {
	this.productClassType = productClassType;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public Date getEffectiveFromDate()
    {
	return effectiveFromDate;
    }

    public void setEffectiveFromDate(Date effectiveFromDate)
    {
	this.effectiveFromDate = effectiveFromDate;
    }

    public Date getEffectiveToDate()
    {
	return effectiveToDate;
    }

    public void setEffectiveToDate(Date effectiveToDate)
    {
	this.effectiveToDate = effectiveToDate;
    }

    public Date getUnutilizeExpiryDate()
    {
	return unutilizeExpiryDate;
    }

    public void setUnutilizeExpiryDate(Date unutilizeExpiryDate)
    {
	this.unutilizeExpiryDate = unutilizeExpiryDate;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public BigDecimal getDrawdownNo()
    {
	return drawdownNo;
    }

    public void setDrawdownNo(BigDecimal drawdownNo)
    {
	this.drawdownNo = drawdownNo;
    }

    public BigDecimal getErrorNo()
    {
	return errorNo;
    }

    public void setErrorNo(BigDecimal errorNo)
    {
	this.errorNo = errorNo;
    }

    public String getErrorDesc()
    {
	return errorDesc;
    }

    public void setErrorDesc(String errorDesc)
    {
	this.errorDesc = errorDesc;
    }

    public BigDecimal getAmountValue()
    {
	return amountValue;
    }

    public void setAmountValue(BigDecimal amountValue)
    {
	this.amountValue = amountValue;
    }

    public BigDecimal getExchRate()
    {
	return exchRate;
    }

    public void setExchRate(BigDecimal exchRate)
    {
	this.exchRate = exchRate;
    }

    public BigDecimal getFacilityValue()
    {
	return facilityValue;
    }

    public void setFacilityValue(BigDecimal facilityValue)
    {
	this.facilityValue = facilityValue;
    }

    public BigDecimal getFromFacility()
    {
	return fromFacility;
    }

    public void setFromFacility(BigDecimal fromFacility)
    {
	this.fromFacility = fromFacility;
    }

    public BigDecimal getFacilityBranch()
    {
	return facilityBranch;
    }

    public void setFacilityBranch(BigDecimal facilityBranch)
    {
	this.facilityBranch = facilityBranch;
    }

    public BigDecimal getFacilityTypeClass()
    {
	return facilityTypeClass;
    }

    public void setFacilityTypeClass(BigDecimal facilityTypeClass)
    {
	this.facilityTypeClass = facilityTypeClass;
    }

    public BigDecimal getValueCV()
    {
	return valueCV;
    }

    public void setValueCV(BigDecimal valueCV)
    {
	this.valueCV = valueCV;
    }

    public BigDecimal getAvailableLimit()
    {
	return availableLimit;
    }

    public void setAvailableLimit(BigDecimal availableLimit)
    {
	this.availableLimit = availableLimit;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public BigDecimal getDealNo()
    {
        return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
        this.dealNo = dealNo;
    }

    public BigDecimal getDealAmount()
    {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount)
    {
        this.dealAmount = dealAmount;
    }

    public BigDecimal getDealYeild()
    {
        return dealYeild;
    }

    public void setDealYeild(BigDecimal dealYeild)
    {
        this.dealYeild = dealYeild;
    }

    public String getDealType()
    {
        return dealType;
    }

    public void setDealType(String dealType)
    {
        this.dealType = dealType;
    }

    public String getCashFinanceFlag()
    {
        return cashFinanceFlag;
    }

    public void setCashFinanceFlag(String cashFinanceFlag)
    {
        this.cashFinanceFlag = cashFinanceFlag;
    }

    public Date getMaturityDate()
    {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
        this.maturityDate = maturityDate;
    }

    public BigDecimal getSubLimitNo()
    {
        return subLimitNo;
    }

    public void setSubLimitNo(BigDecimal subLimitNo)
    {
        this.subLimitNo = subLimitNo;
    }

    public BigDecimal getDrawDownBranch()
    {
        return drawDownBranch;
    }

    public void setDrawDownBranch(BigDecimal drawDownBranch)
    {
        this.drawDownBranch = drawDownBranch;
    }

    public String getLimitFlag()
    {
        return limitFlag;
    }

    public void setLimitFlag(String limitFlag)
    {
        this.limitFlag = limitFlag;
    }

    public String getDrawDownStatus()
    {
        return drawDownStatus;
    }

    public void setDrawDownStatus(String drawDownStatus)
    {
        this.drawDownStatus = drawDownStatus;
    }

    public BigDecimal getAmountWithCompany()
    {
        return amountWithCompany;
    }

    public void setAmountWithCompany(BigDecimal amountWithCompany)
    {
        this.amountWithCompany = amountWithCompany;
    }

    public BigDecimal getAmountWithClient()
    {
        return amountWithClient;
    }

    public void setAmountWithClient(BigDecimal amountWithClient)
    {
        this.amountWithClient = amountWithClient;
    }

    public BigDecimal getUnUtilzed()
    {
        return unUtilzed;
    }

    public void setUnUtilzed(BigDecimal unUtilzed)
    {
        this.unUtilzed = unUtilzed;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public String getTfaDrawDown()
    {
        return tfaDrawDown;
    }

    public void setTfaDrawDown(String tfaDrawDown)
    {
        this.tfaDrawDown = tfaDrawDown;
    }

}
