package com.path.vo.core.entitycharges;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.vo.core.common.RetailBaseVO;

public class EntityChargesCO extends RetailBaseVO
{
    private List<CtsChargesEntityCO> ctsChargesEntityCOs = new ArrayList<CtsChargesEntityCO>(); // The Entity Charges Data
    private PTH_CTRLVO pthCTRL;
    private BigDecimal schema; 				// il_charge_schema (This is the charges schema to be used for retrieving charges)
    private String entityType; 				// Denotes the entity from which the charge is coming from such as CHQ for Chequebook or CAR for Cards
    private String deductCharges;			// Column that exists on some entity screens to choose if to deduct charges from Charge Account or Entity Account
    private BigDecimal cardType;			// In cards entity, this is the card type
    private BigDecimal entityCode;			// Entity Code
    private String baseForeign; 			// Set as "B" or "F" to know if CV or FC amount
    private BigDecimal baseCurrDecPoint;		// Decimal Points of Base Currency
    private BigDecimal chargeCurrDecPoint;		// Decimal Points of Account Currency
    private BigDecimal totalAmount;			// Total Sum of Amounts
    private BigDecimal totalAmountFc;			// FC Total Sum of Amounts
    private BigDecimal schemaDestroy;			// If there exists a separate Charge Schema for Destroy
    private BigDecimal schemaCancel;			// If there exists a separate Charge Schema for Cancel
    private BigDecimal originalCode; 			// In Case of multiple Chequebooks, this points to the original one
    private String typeInd;				// Type Indicator: CHEQUEBOOK (AD,AC,P) / SAFEBOX (R,I,S,N) / PASSBOOK (I,P)
    private String entityCommand;			// Denotes the Entity Command such as 'CHQ' for normal behavior, 'SBR' for Safebox Reverse
    private BigDecimal totalAllAmount;			// Total All used when multiple records are selected such as in Chequebook
    private BigDecimal totalAllAmountFc;		// Total All FC used when multiple records are selected such as in Chequebook
    private BigDecimal row;				// Current Row Number
    private BigDecimal exchRate;			// Exchange Rate
    private String briefDescEngBase;			// Brief Description of Base Currency
    private String briefDescEng;			// Brief Description of Account Currency
    private Boolean isEmptied = false;			// This is set to True when the charges are changed from entity screen and require recalculation. Upon calling of various charges function, they will check on this flag to see if to continue in calculation or not.
    private BigDecimal numOfEntities;			// In the case of chequebook or Lost & Found, this should be filled as num_of_chqbooks in chequebook and filled as (to_doc - doc_number + 1) in Lost & Found
    private String chargeType;				// In the case of Safebox, we have 4 types of charges, we use this to know which one we are retrieving. Value will be either R / I / S / N for Rental / Insurance / Stamp / Renewal
    private Boolean suppressMessage = false;		// Used to determine if error message is outputted or not
    private String blockActiveWithdrawal;		// Used for checking in Available Balance to store Block Active Withdrawal
    private BigDecimal trsNo;				// Trx Number of Trx created from Charges
    private BigDecimal cvAmount;			// Amount in Base Currency
    private BigDecimal fcAmount;			// Amount in Foreign Currency
    private BigDecimal chargeCode;			// Charge Code while iterating among different charges
    private boolean repeat; 				// ib_repeat this is used in transaction to get total charges in some cases where we don't want to read from the datawindow
    private Integer proceed; 				// Used for confirmation message 2881 
    private Integer returnInt; 				// used to check if charges calculations passed correctly or not
    private BigDecimal chargeAccBranch;			// Charge Account Branch
    private BigDecimal chargeAccCurrency;		// Charge Account Currency
    private BigDecimal accBranch;			// Account Branch
    private BigDecimal accCurrency;			// Account Currency
    private BigDecimal trsAccounDetBranch;		// In case of multiple accounts, this is filled with the current account branch, equivalent of il_trsacc_br
    private String warningMessage; 			// To Store Warning Messages
    private BigDecimal entityTypeCode;			// Entity Type Code
    private String actionType;				// Charge Action Type to be calculated
    private BigDecimal leaves;				// Leave code for Chequebooks
    private BigDecimal type;				// Chequebook type
    private BigDecimal tradeSerialNbr;			// pmstradeVO.TRADE_SERIAL_NBR
    private String chqIssueType;			// Chequebook Issuance Type (Normal/Urgent)
    private String statusIdentifer;			// Card Status Reason => Equivalent to Cards Reason Code
    private BigDecimal errorCode;
    private String errorMsg; 
    
    private String gridJsonStr;
    private String isWaived;
    private String printingLocation;			// added by nancy -- 13/04/2018--FIBSI170009-Integration with chequebook printer and provider
    
    /*
     * jihane TP82894 - IIAB080110 ; TP82682 ABARI11065 added to store sum of dues amount 
     */
    private BigDecimal duesTotalAmount;			// Total Sum of Charges Dues Amounts
    private BigDecimal DuesTotalAmountFc;		 // FC Total Sum of charges Dues Amounts
    private String logDuesCreateTrx;
	
    /*
     * For Calculating Available Balance
     */
    private BigDecimal chargeAccGL;
    private BigDecimal chargeAccCIF;
    private BigDecimal chargeAccSL;
    private BigDecimal accGL;
    private BigDecimal accCIF;
    private BigDecimal accSL;
    private BigDecimal availBalance;
    private BigDecimal trxType;				// Used for Checking on Amount Exceeds available Balance
    private String confirmStop;				// Set to "C" for Confirmation Message, or "S" for Stopping Message
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    
    private boolean alreadyLocked;			//TONY NOUH US 154817 if the same account is already locked in the same process we should not relock it
    private Boolean autoCreated = false;		//Used to know if product is automatically created (from FOM)
    
    private Boolean commit = false;			// This is set to True to avoid the commit in checkAmountRestriction
    
    private BigDecimal deductBr;
    
    private BigDecimal maxLosDocAmt; 			//Abdo DCR 509649 25/04/2017
    private String appMultiCharges;
    
    
    
    private BigDecimal maxCerticateAmt; //used for DASI170045 - Commission on Cheque Deposit 
    private String multiplyByBills; //used for DASI170045 - Commission on Cheque Deposit
    private BigDecimal certificateCode;
        
    public BigDecimal getSchema()
    {
	return schema;
    }

    public void setSchema(BigDecimal schema)
    {
	this.schema = schema;
    }

    public PTH_CTRLVO getPthCTRL()
    {
	return pthCTRL;
    }

    public void setPthCTRL(PTH_CTRLVO pthCTRL)
    {
	this.pthCTRL = pthCTRL;
    }

    public String getEntityType()
    {
	return entityType;
    }

    public void setEntityType(String entityType)
    {
	this.entityType = entityType;
    }

    public String getDeductCharges()
    {
	return deductCharges;
    }

    public void setDeductCharges(String deductCharges)
    {
	this.deductCharges = deductCharges;
    }

    public BigDecimal getCardType()
    {
	return cardType;
    }

    public void setCardType(BigDecimal cardType)
    {
	this.cardType = cardType;
    }

    public BigDecimal getEntityCode()
    {
	return entityCode;
    }

    public void setEntityCode(BigDecimal entityCode)
    {
	this.entityCode = entityCode;
    }

    public String getBaseForeign()
    {
	return baseForeign;
    }

    public void setBaseForeign(String baseForeign)
    {
	this.baseForeign = baseForeign;
    }

    public BigDecimal getCvAmount()
    {
	return cvAmount;
    }

    public void setCvAmount(BigDecimal cvAmount)
    {
	this.cvAmount = cvAmount;
    }

    public BigDecimal getFcAmount()
    {
	return fcAmount;
    }

    public void setFcAmount(BigDecimal fcAmount)
    {
	this.fcAmount = fcAmount;
    }

    public BigDecimal getChargeCode()
    {
	return chargeCode;
    }

    public void setChargeCode(BigDecimal chargeCode)
    {
	this.chargeCode = chargeCode;
    }

    public boolean isRepeat()
    {
	return repeat;
    }

    public void setRepeat(boolean repeat)
    {
	this.repeat = repeat;
    }

    public Integer getProceed()
    {
	return proceed;
    }

    public void setProceed(Integer proceed)
    {
	this.proceed = proceed;
    }

    public Integer getReturnInt()
    {
	return returnInt;
    }

    public void setReturnInt(Integer returnInt)
    {
	this.returnInt = returnInt;
    }

    public BigDecimal getAccBranch()
    {
	return accBranch;
    }

    public void setAccBranch(BigDecimal accBranch)
    {
	this.accBranch = accBranch;
    }

    public BigDecimal getAccCurrency()
    {
	return accCurrency;
    }

    public void setAccCurrency(BigDecimal accCurrency)
    {
	this.accCurrency = accCurrency;
    }

    public BigDecimal getChargeAccBranch()
    {
	return chargeAccBranch;
    }

    public void setChargeAccBranch(BigDecimal chargeAccBranch)
    {
	this.chargeAccBranch = chargeAccBranch;
    }

    public BigDecimal getChargeAccCurrency()
    {
	return chargeAccCurrency;
    }

    public void setChargeAccCurrency(BigDecimal chargeAccCurrency)
    {
	this.chargeAccCurrency = chargeAccCurrency;
    }

    public List<CtsChargesEntityCO> getCtsChargesEntityCOs()
    {
	return ctsChargesEntityCOs;
    }

    public void setCtsChargesEntityCOs(List<CtsChargesEntityCO> ctsChargesEntityCOs)
    {
	this.ctsChargesEntityCOs = ctsChargesEntityCOs;
    }

    @Override
    public BigDecimal getBaseCurrDecPoint()
    {
	return baseCurrDecPoint;
    }

    @Override
    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
	this.baseCurrDecPoint = baseCurrDecPoint;
    }

    public BigDecimal getTotalAmount()
    {
	return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount)
    {
	this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmountFc()
    {
	return totalAmountFc;
    }

    public void setTotalAmountFc(BigDecimal totalAmountFc)
    {
	this.totalAmountFc = totalAmountFc;
    }

    public BigDecimal getSchemaDestroy()
    {
	return schemaDestroy;
    }

    public void setSchemaDestroy(BigDecimal schemaDestroy)
    {
	this.schemaDestroy = schemaDestroy;
    }

    public BigDecimal getSchemaCancel()
    {
	return schemaCancel;
    }

    public void setSchemaCancel(BigDecimal schemaCancel)
    {
	this.schemaCancel = schemaCancel;
    }

    public BigDecimal getOriginalCode()
    {
	return originalCode;
    }

    public void setOriginalCode(BigDecimal originalCode)
    {
	this.originalCode = originalCode;
    }

    public String getTypeInd()
    {
	return typeInd;
    }

    public void setTypeInd(String typeInd)
    {
	this.typeInd = typeInd;
    }

    public BigDecimal getTotalAllAmount()
    {
	return totalAllAmount;
    }

    public void setTotalAllAmount(BigDecimal totalAllAmount)
    {
	this.totalAllAmount = totalAllAmount;
    }

    public BigDecimal getTotalAllAmountFc()
    {
	return totalAllAmountFc;
    }

    public void setTotalAllAmountFc(BigDecimal totalAllAmountFc)
    {
	this.totalAllAmountFc = totalAllAmountFc;
    }

    public BigDecimal getRow()
    {
	return row;
    }

    public void setRow(BigDecimal row)
    {
	this.row = row;
    }

    public BigDecimal getExchRate()
    {
	return exchRate;
    }

    public void setExchRate(BigDecimal exchRate)
    {
	this.exchRate = exchRate;
    }

    public BigDecimal getChargeCurrDecPoint()
    {
	return chargeCurrDecPoint;
    }

    public void setChargeCurrDecPoint(BigDecimal chargeCurrDecPoint)
    {
	this.chargeCurrDecPoint = chargeCurrDecPoint;
    }

    public String getBriefDescEng()
    {
        return briefDescEng;
    }

    public void setBriefDescEng(String briefDescEng)
    {
        this.briefDescEng = briefDescEng;
    }

    public String getBriefDescEngBase()
    {
        return briefDescEngBase;
    }

    public void setBriefDescEngBase(String briefDescEngBase)
    {
        this.briefDescEngBase = briefDescEngBase;
    }

    public Boolean getIsEmptied()
    {
        return isEmptied;
    }

    public void setIsEmptied(Boolean isEmptied)
    {
        this.isEmptied = isEmptied;
    }

    public BigDecimal getNumOfEntities()
    {
        return numOfEntities;
    }

    public void setNumOfEntities(BigDecimal numOfEntities)
    {
        this.numOfEntities = numOfEntities;
    }

    public String getChargeType()
    {
        return chargeType;
    }

    public void setChargeType(String chargeType)
    {
        this.chargeType = chargeType;
    }

    public String getEntityCommand()
    {
        return entityCommand;
    }

    public void setEntityCommand(String entityCommand)
    {
        this.entityCommand = entityCommand; 
    }

    public BigDecimal getTrsAccounDetBranch()
    {
        return trsAccounDetBranch;
    }

    public void setTrsAccounDetBranch(BigDecimal trsAccounDetBranch)
    {
        this.trsAccounDetBranch = trsAccounDetBranch;
    }

    public String getGridJsonStr()
    {
	return gridJsonStr;
    }

	public void setGridJsonStr(String gridJsonStr) {
		this.gridJsonStr = gridJsonStr;
	}

	public BigDecimal getChargeAccGL()
	{
	    return chargeAccGL;
	}

	public void setChargeAccGL(BigDecimal chargeAccGL)
	{
	    this.chargeAccGL = chargeAccGL;
	}

	public BigDecimal getChargeAccCIF()
	{
	    return chargeAccCIF;
	}

	public void setChargeAccCIF(BigDecimal chargeAccCIF)
	{
	    this.chargeAccCIF = chargeAccCIF;
	}

	public BigDecimal getChargeAccSL()
	{
	    return chargeAccSL;
	}

	public void setChargeAccSL(BigDecimal chargeAccSL)
	{
	    this.chargeAccSL = chargeAccSL;
	}

	public BigDecimal getAccGL()
	{
	    return accGL;
	}

	public void setAccGL(BigDecimal accGL)
	{
	    this.accGL = accGL;
	}

	public BigDecimal getAccCIF()
	{
	    return accCIF;
	}

	public void setAccCIF(BigDecimal accCIF)
	{
	    this.accCIF = accCIF;
	}

	public BigDecimal getAccSL()
	{
	    return accSL;
	}

	public void setAccSL(BigDecimal accSL)
	{
	    this.accSL = accSL;
	}

	public BigDecimal getTrxType()
	{
	    return trxType;
	}

	public void setTrxType(BigDecimal trxType)
	{
	    this.trxType = trxType;
	}

	public BigDecimal getAvailBalance()
	{
	    return availBalance;
	}

	public void setAvailBalance(BigDecimal availBalance)
	{
	    this.availBalance = availBalance;
	}

	public String getConfirmStop()
	{
	    return confirmStop;
	}

	public void setConfirmStop(String confirmStop)
	{
	    this.confirmStop = confirmStop;
	}

	public Boolean getSuppressMessage()
	{
	    return suppressMessage;
	}

	public void setSuppressMessage(Boolean suppressMessage)
	{
	    this.suppressMessage = suppressMessage;
	}

	public String getBlockActiveWithdrawal()
	{
	    return blockActiveWithdrawal;
	}

	public void setBlockActiveWithdrawal(String blockActiveWithdrawal)
	{
	    this.blockActiveWithdrawal = blockActiveWithdrawal;
	}

	public String getIsWaived()
	{
	    return isWaived;
	}

	public void setIsWaived(String isWaived)
	{
	    this.isWaived = isWaived;
	}

	public BigDecimal getTrsNo()
	{
	    return trsNo;
	}

	public void setTrsNo(BigDecimal trsNo)
	{
	    this.trsNo = trsNo;
	}

	public String getWarningMessage()
	{
	    return warningMessage;
	}

	public void setWarningMessage(String warningMessage)
	{
	    this.warningMessage = warningMessage;
	}

	public BigDecimal getEntityTypeCode()
	{
	    return entityTypeCode;
	}

	public void setEntityTypeCode(BigDecimal entityTypeCode)
	{
	    this.entityTypeCode = entityTypeCode;
	}

	public String getActionType()
	{
	    return actionType;
	}

	public void setActionType(String actionType)
	{
	    this.actionType = actionType;
	}

	/**
	 * @return the leaves
	 */
	public BigDecimal getLeaves()
	{
	    return leaves;
	}

	/**
	 * @param leaves the leaves to set
	 */
	public void setLeaves(BigDecimal leaves)
	{
	    this.leaves = leaves;
	}

	/**
	 * @return the type
	 */
	public BigDecimal getType()
	{
	    return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(BigDecimal type)
	{
	    this.type = type;
	}

	/**
	 * @return the chqIssueType
	 */
	public String getChqIssueType()
	{
	    return chqIssueType;
	}

	/**
	 * @param chqIssueType the chqIssueType to set
	 */
	public void setChqIssueType(String chqIssueType)
	{
	    this.chqIssueType = chqIssueType;
	}
	
	public BigDecimal getDuesTotalAmount()
	{
	    return duesTotalAmount;
	}

	public void setDuesTotalAmount(BigDecimal duesTotalAmount)
	{
	    this.duesTotalAmount = duesTotalAmount;
	}

	public BigDecimal getDuesTotalAmountFc()
	{
	    return DuesTotalAmountFc;
	}

	public void setDuesTotalAmountFc(BigDecimal duesTotalAmountFc)
	{
	    DuesTotalAmountFc = duesTotalAmountFc;
	}

	public String getLogDuesCreateTrx()
	{
	    return logDuesCreateTrx;
	}

	public void setLogDuesCreateTrx(String logDuesCreateTrx)
	{
	    this.logDuesCreateTrx = logDuesCreateTrx;
	}

	/**
	 * @return the statusIdentifer
	 */
	public String getStatusIdentifer()
	{
	    return statusIdentifer;
	}

	/**
	 * @param statusIdentifer the statusIdentifer to set
	 */
	public void setStatusIdentifer(String statusIdentifer)
	{ 
	    this.statusIdentifer = statusIdentifer;
	}

	public CTSTELLERVO getCtsTellerVO()
	{
	    return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
	{
	    this.ctsTellerVO = ctsTellerVO;
	}

	/**
	 * @return the tradeSerialNbr
	 */
	public BigDecimal getTradeSerialNbr()
	{
	    return tradeSerialNbr;
	}

	/**
	 * @param tradeSerialNbr the tradeSerialNbr to set
	 */
	public void setTradeSerialNbr(BigDecimal tradeSerialNbr)
	{
	    this.tradeSerialNbr = tradeSerialNbr;
	}

	/**
	 * @return the errorCode
	 */
	public BigDecimal getErrorCode()
	{
	    return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(BigDecimal errorCode)
	{
	    this.errorCode = errorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg()
	{
	    return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg)
	{
	    this.errorMsg = errorMsg;
	}

	public boolean isAlreadyLocked()
	{
	    return alreadyLocked;
	}

	public void setAlreadyLocked(boolean alreadyLocked)
	{
	    this.alreadyLocked = alreadyLocked;
	}

	public Boolean getAutoCreated()
	{
	    return autoCreated;
	}

	public void setAutoCreated(Boolean autoCreated)
	{
	    this.autoCreated = autoCreated;
	}

	public Boolean getCommit()
	{
	    return commit;
	}

	public void setCommit(Boolean commit)
	{
	    this.commit = commit;
	}

	public BigDecimal getDeductBr()
	{
	    return deductBr;
	}

	public void setDeductBr(BigDecimal deductBr)
	{
	    this.deductBr = deductBr;
	}

	public final BigDecimal getMaxCerticateAmt()
	{
	    return maxCerticateAmt;
	}

	public final void setMaxCerticateAmt(BigDecimal maxCerticateAmt)
	{
	    this.maxCerticateAmt = maxCerticateAmt;
	}

	public final String getMultiplyByBills()
	{
	    return multiplyByBills;
	}

	public final void setMultiplyByBills(String multiplyByBills)
	{
	    this.multiplyByBills = multiplyByBills;
	}

	public  BigDecimal getCertificateCode()
	{
	    return certificateCode;
	}

	public  void setCertificateCode(BigDecimal certificateCode)
	{
	    this.certificateCode = certificateCode;
	}

	public String getPrintingLocation()
	{
	    return printingLocation;
	}

	public void setPrintingLocation(String printingLocation)
	{
	    this.printingLocation = printingLocation;
	}

	public BigDecimal getMaxLosDocAmt()
	{
	    return maxLosDocAmt;
	}

	public void setMaxLosDocAmt(BigDecimal maxLosDocAmt)
	{
	    this.maxLosDocAmt = maxLosDocAmt;
	}
	
	
	/**
	 * @return the appMultiCharges
	 */
	public String getAppMultiCharges()
	{
	    return appMultiCharges;
	}

	/**
	 * @param appMultiCharges the appMultiCharges to set
	 */
	public void setAppMultiCharges(String appMultiCharges)
	{
	    this.appMultiCharges = appMultiCharges;
	}
	

}
