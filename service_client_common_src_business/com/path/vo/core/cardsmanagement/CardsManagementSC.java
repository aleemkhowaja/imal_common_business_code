/**
 * @Auther:WissamAbouJaoude
 * @Date:March 16, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.cardsmanagement;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

public class CardsManagementSC extends GridParamsSC
{
    private Date sysDate;
    private String iv_crud;
    private BigDecimal applicationId;
    private BigDecimal applicationRef;
    private BigDecimal cat_code;
    private String status_iden;
    private String status;
    private String bs_contra; // s_category
    private String passChq;
    private String statusLst;
    private String language;
    private String primSupp;
    private BigDecimal cif;
    private String cifType;
    private BigDecimal lineNum;
    private String cifStatus;
    private String cifReason;
    private String isStatusCif;
    private String maskedCardNo;
    private BigDecimal acc_br;
    private BigDecimal acc_cy;
    private BigDecimal acc_gl;
    private BigDecimal acc_cif;
    private BigDecimal acc_sl;
    private String addRef;
    private String accStatus;
    private String accReason;
    private String actionType;
    private String reference;
    private String expiDate;
    private BigDecimal cardType;
    private String cardStatus;
    private String cardReason;
    private BigDecimal autoGenNumFr;
    private Date from_date;
    private Date to_date;
    private Date createdDate;
    private Date effDate;
    private Date newEffDate;
    private Date newExpiDate;
    private Date newPreDate;
    private Date PreparationDate;
    private BigDecimal creditType;
    private String action;
    private String docCard;
    private String flag;
    private BigDecimal dest_branch;
    private String batchEvent;
    private Date batch_no;
    private String batch_no1;
    private String exportUpdates;
    private String oldPeriod;
    private BigDecimal chargesSchemaCode;
    private String statusAction1;
    private String statusAction2;
    private String statusType;
    private String statusReason;
    private String maxOrMin;
    private String card_no;
    private String cardsNum;
    private String orig_card_no;
    private BigDecimal designCode;
    private BigDecimal errorCode;
    private BigDecimal selectedCard;
    private String errorMessage;
    private String preferredLanguage;
    private String reasonUsedFor;
    private String type;
    private String progRef;
    private String originProgRef;
    private String sameType;
    private BigDecimal lovTypeStatus;
    private BigDecimal lovTypeCifStatus;
    private BigDecimal lovTypePrimSupp;
    private Date batchNo;
    private Boolean isMultiHO;
    private BigDecimal hoBranch;

    //BB140052 -- [Hasan Youssef]
    private BigDecimal code;
    private BigDecimal cifTypeCode;
    //End [Hasan Youssef]
    // Charges
    private BigDecimal trsNo;
    private BigDecimal avaPaymentCode;
    private BigDecimal avaBenefLineNo;
    private BigDecimal avaBenefFileCode;
    
    private BigDecimal facilityNo; //Raed Saad BMOI150250
    private BigDecimal facilityBranch; //Raed Saad BMOI150250
    private BigDecimal facilitySubLimit; //Raed Saad BMOI150250
    private BigDecimal facilitySubLimitLineNo; //Raed Saad BMOI150250
    private BigDecimal fmsCreditCardFacilityLineNo;//Raed Saad BMOI150250
    private BigDecimal cardsBranch; //Raed Saad BMOI150250
    
    private String idNo; //BMOI130009 
    private String cSN;
    private String pinStatus;
    private String pin_status_desc;
    private String periodId;	
    private String allowCifCreationMaskYN;
    private BigDecimal lovTypePinType;
	
    private BigDecimal loginBranchCode;
    
    private Date defaultSearchDate;
    private String screenSrc;
    private String isFromAlert;
    //added by abbas for Bug#683186
    private String fromStatusReasonLookUp;
    //end abbas
    private String pageRef;
    private String accRestriction="1";
    private String multiBrTrx;
	//added by maria for BMO180276
    private Date idExpiryDate;    
    
    private String useForCifProductsFlag;
    private String creditCardPaymentTrx;
    
    //795158 BB-S10 Activating other branch cards[falha]
    private BigDecimal fromBranch;
    private BigDecimal toBranch;
    private BigDecimal fromApplicationId;
    private BigDecimal toApplicationId;
    private String fromCardNo;
    private String toCardNo;
    //795158 BB-S10 Activating other branch cards[falha]
    
    //Hala Al Sheikh ABEI180106
    private BigDecimal collateralCode;
    private BigDecimal facilityCode;
    private BigDecimal amount;
    private String multiDivCy;
    private BigDecimal currencyCode;
    private BigDecimal currencyRate;
    private BigDecimal currencyUnit;
    private String errorType;
    private BigDecimal drwdwnCode;
    

    public BigDecimal getCardsBranch()
    {
        return cardsBranch;
    }

    public void setCardsBranch(BigDecimal cardsBranch)
    {
        this.cardsBranch = cardsBranch;
    }

    public Date getSysDate()
    {
	return sysDate;
    }

    public void setSysDate(Date sysDate)
    {
	this.sysDate = sysDate;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public BigDecimal getCat_code()
    {
	return cat_code;
    }

    public void setCat_code(BigDecimal catCode)
    {
	cat_code = catCode;
    }

    public String getStatus_iden()
    {
	return status_iden;
    }

    public void setStatus_iden(String statusIden)
    {
	status_iden = statusIden;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getCif()
    {
	return cif;
    }

    public void setCif(BigDecimal cif)
    {
	this.cif = cif;
    }

    public String getIsStatusCif()
    {
	return isStatusCif;
    }

    public void setIsStatusCif(String isStatusCif)
    {
	this.isStatusCif = isStatusCif;
    }

    public BigDecimal getAcc_br()
    {
	return acc_br;
    }

    public void setAcc_br(BigDecimal accBr)
    {
	acc_br = accBr;
    }

    public BigDecimal getAcc_cy()
    {
	return acc_cy;
    }

    public void setAcc_cy(BigDecimal accCy)
    {
	acc_cy = accCy;
    }

    public BigDecimal getAcc_gl()
    {
	return acc_gl;
    }

    public void setAcc_gl(BigDecimal accGl)
    {
	acc_gl = accGl;
    }

    public BigDecimal getAcc_cif()
    {
	return acc_cif;
    }

    public void setAcc_cif(BigDecimal accCif)
    {
	acc_cif = accCif;
    }

    public BigDecimal getAcc_sl()
    {
	return acc_sl;
    }

    public void setAcc_sl(BigDecimal accSl)
    {
	acc_sl = accSl;
    }

    public BigDecimal getCardType()
    {
	return cardType;
    }

    public void setCardType(BigDecimal cardType)
    {
	this.cardType = cardType;
    }

    public Date getFrom_date()
    {
	return from_date;
    }

    public void setFrom_date(Date fromDate)
    {
	from_date = fromDate;
    }

    public Date getTo_date()
    {
	return to_date;
    }

    public void setTo_date(Date toDate)
    {
	to_date = toDate;
    }

    public BigDecimal getCreditType()
    {
	return creditType;
    }

    public void setCreditType(BigDecimal creditType)
    {
	this.creditType = creditType;
    }

    public String getAction()
    {
	return action;
    }

    public void setAction(String action)
    {
	this.action = action;
    }

    public BigDecimal getDest_branch()
    {
	return dest_branch;
    }

    public void setDest_branch(BigDecimal destBranch)
    {
	dest_branch = destBranch;
    }

    public String getBatch_no1()
    {
	return batch_no1;
    }

    public void setBatch_no1(String batchNo1)
    {
	batch_no1 = batchNo1;
    }

    public String getBatchEvent()
    {
	return batchEvent;
    }

    public void setBatchEvent(String batchEvent)
    {
	this.batchEvent = batchEvent;
    }

    public Date getBatch_no()
    {
	return batch_no;
    }

    public void setBatch_no(Date batchNo)
    {
	batch_no = batchNo;
    }

    public String getExportUpdates()
    {
	return exportUpdates;
    }

    public void setExportUpdates(String exportUpdates)
    {
	this.exportUpdates = exportUpdates;
    }

    public String getOldPeriod()
    {
	return oldPeriod;
    }

    public void setOldPeriod(String oldPeriod)
    {
	this.oldPeriod = oldPeriod;
    }

    public BigDecimal getChargesSchemaCode()
    {
	return chargesSchemaCode;
    }

    public void setChargesSchemaCode(BigDecimal chargesSchemaCode)
    {
	this.chargesSchemaCode = chargesSchemaCode;
    }

    public String getStatusAction1()
    {
	return statusAction1;
    }

    public void setStatusAction1(String statusAction1)
    {
	this.statusAction1 = statusAction1;
    }

    public String getStatusAction2()
    {
	return statusAction2;
    }

    public void setStatusAction2(String statusAction2)
    {
	this.statusAction2 = statusAction2;
    }

    public String getStatusReason()
    {
	return statusReason;
    }

    public void setStatusReason(String statusReason)
    {
	this.statusReason = statusReason;
    }

    public String getCard_no()
    {
	return card_no;
    }

    public void setCard_no(String cardNo)
    {
	card_no = cardNo;
    }

    public BigDecimal getDesignCode()
    {
	return designCode;
    }

    public void setDesignCode(BigDecimal designCode)
    {
	this.designCode = designCode;
    }

    public BigDecimal getAutoGenNumFr()
    {
	return autoGenNumFr;
    }

    public void setAutoGenNumFr(BigDecimal autoGenNumFr)
    {
	this.autoGenNumFr = autoGenNumFr;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getDocCard()
    {
	return docCard;
    }

    public void setDocCard(String docCard)
    {
	this.docCard = docCard;
    }

    public String getPrimSupp()
    {
	return primSupp;
    }

    public void setPrimSupp(String primSupp)
    {
	this.primSupp = primSupp;
    }

    public String getStatusLst()
    {
	return statusLst;
    }

    public void setStatusLst(String statusLst)
    {
	this.statusLst = statusLst;
    }

    public BigDecimal getApplicationId()
    {
	return applicationId;
    }

    public void setApplicationId(BigDecimal applicationId)
    {
	this.applicationId = applicationId;
    }

    public BigDecimal getApplicationRef()
    {
	return applicationRef;
    }

    public void setApplicationRef(BigDecimal applicationRef)
    {
	this.applicationRef = applicationRef;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
	this.errorMessage = errorMessage;
    }

    public String getMaxOrMin()
    {
	return maxOrMin;
    }

    public void setMaxOrMin(String maxOrMin)
    {
	this.maxOrMin = maxOrMin;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public String getReasonUsedFor()
    {
	return reasonUsedFor;
    }

    public void setReasonUsedFor(String reasonUsedFor)
    {
	this.reasonUsedFor = reasonUsedFor;
    }

    public String getStatusType()
    {
	return statusType;
    }

    public void setStatusType(String statusType)
    {
	this.statusType = statusType;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public String getCifReason()
    {
	return cifReason;
    }

    public void setCifReason(String cifReason)
    {
	this.cifReason = cifReason;
    }

    public String getAccStatus()
    {
	return accStatus;
    }

    public void setAccStatus(String accStatus)
    {
	this.accStatus = accStatus;
    }

    public String getAccReason()
    {
	return accReason;
    }

    public void setAccReason(String accReason)
    {
	this.accReason = accReason;
    }

    public String getActionType()
    {
	return actionType;
    }

    public void setActionType(String actionType)
    {
	this.actionType = actionType;
    }

    public String getReference()
    {
	return reference;
    }

    public void setReference(String reference)
    {
	this.reference = reference;
    }

    public String getExpiDate()
    {
	return expiDate;
    }

    public void setExpiDate(String expiDate)
    {
	this.expiDate = expiDate;
    }

    public String getCardStatus()
    {
	return cardStatus;
    }

    public void setCardStatus(String cardStatus)
    {
	this.cardStatus = cardStatus;
    }

    public String getCardReason()
    {
	return cardReason;
    }

    public void setCardReason(String cardReason)
    {
	this.cardReason = cardReason;
    }

    public Date getCreatedDate()
    {
	return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
	this.createdDate = createdDate;
    }

    public Date getEffDate()
    {
	return effDate;
    }

    public void setEffDate(Date effDate)
    {
	this.effDate = effDate;
    }

    public Date getNewEffDate()
    {
	return newEffDate;
    }

    public void setNewEffDate(Date newEffDate)
    {
	this.newEffDate = newEffDate;
    }

    public Date getNewExpiDate()
    {
	return newExpiDate;
    }

    public void setNewExpiDate(Date newExpiDate)
    {
	this.newExpiDate = newExpiDate;
    }

    public Date getNewPreDate()
    {
	return newPreDate;
    }

    public void setNewPreDate(Date newPreDate)
    {
	this.newPreDate = newPreDate;
    }

    public Date getPreparationDate()
    {
	return PreparationDate;
    }

    public void setPreparationDate(Date preparationDate)
    {
	PreparationDate = preparationDate;
    }

    public String getAddRef()
    {
	return addRef;
    }

    public void setAddRef(String addRef)
    {
	this.addRef = addRef;
    }

    public String getSameType()
    {
	return sameType;
    }

    public void setSameType(String sameType)
    {
	this.sameType = sameType;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public BigDecimal getSelectedCard()
    {
	return selectedCard;
    }

    public void setSelectedCard(BigDecimal selectedCard)
    {
	this.selectedCard = selectedCard;
    }

    public BigDecimal getLovTypeStatus()
    {
	return lovTypeStatus;
    }

    public void setLovTypeStatus(BigDecimal lovTypeStatus)
    {
	this.lovTypeStatus = lovTypeStatus;
    }

    public BigDecimal getLovTypeCifStatus()
    {
	return lovTypeCifStatus;
    }

    public void setLovTypeCifStatus(BigDecimal lovTypeCifStatus)
    {
	this.lovTypeCifStatus = lovTypeCifStatus;
    }

    public BigDecimal getLovTypePrimSupp()
    {
	return lovTypePrimSupp;
    }

    public void setLovTypePrimSupp(BigDecimal lovTypePrimSupp)
    {
	this.lovTypePrimSupp = lovTypePrimSupp;
    }

    public String getFlag()
    {
	return flag;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public BigDecimal getLineNum()
    {
	return lineNum;
    }

    public void setLineNum(BigDecimal lineNum)
    {
	this.lineNum = lineNum;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public Date getBatchNo()
    {
	return batchNo;
    }

    public void setBatchNo(Date batchNo)
    {
	this.batchNo = batchNo;
    }

    public String getOrig_card_no()
    {
	return orig_card_no;
    }

    public void setOrig_card_no(String origCardNo)
    {
	orig_card_no = origCardNo;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public String getCardsNum()
    {
	return cardsNum;
    }

    public void setCardsNum(String cardsNum)
    {
	this.cardsNum = cardsNum;
    }

    public String getMaskedCardNo()
    {
        return maskedCardNo;
    }

    public void setMaskedCardNo(String maskedCardNo)
    {
        this.maskedCardNo = maskedCardNo;
    }

    public String getPassChq()
    {
        return passChq;
    }

    public void setPassChq(String passChq)
    {
        this.passChq = passChq;
    }

    public String getBs_contra()
    {
        return bs_contra;
    }

    public void setBs_contra(String bsContra)
    {
        bs_contra = bsContra;
    }

    public String getCifType()
    {
        return cifType;
    }

    public void setCifType(String cifType)
    {
        this.cifType = cifType;
    }

    /**
     * @return the originProgRef
     */
    public String getOriginProgRef()
    {
        return originProgRef;
    }

    /**
     * @param originProgRef the originProgRef to set
     */
    public void setOriginProgRef(String originProgRef)
    {
        this.originProgRef = originProgRef;
    }

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public BigDecimal getCode() {
		return code;
	}

	public void setCifTypeCode(BigDecimal cifTypeCode) {
		this.cifTypeCode = cifTypeCode;
	}

	public BigDecimal getCifTypeCode() {
		return cifTypeCode;
	}

	public BigDecimal getAvaPaymentCode()
	{
	    return avaPaymentCode;
	}

	public void setAvaPaymentCode(BigDecimal avaPaymentCode)
	{
	    this.avaPaymentCode = avaPaymentCode;
	}

	public BigDecimal getAvaBenefLineNo()
	{
	    return avaBenefLineNo;
	}

	public void setAvaBenefLineNo(BigDecimal avaBenefLineNo)
	{
	    this.avaBenefLineNo = avaBenefLineNo;
	}

	public BigDecimal getAvaBenefFileCode()
	{
	    return avaBenefFileCode;
	}

	public void setAvaBenefFileCode(BigDecimal avaBenefFileCode)
	{
	    this.avaBenefFileCode = avaBenefFileCode;
	}

	public BigDecimal getFacilityNo()
	{
	    return facilityNo;
	}

	public void setFacilityNo(BigDecimal facilityNo)
	{
	    this.facilityNo = facilityNo;
	}

	public BigDecimal getFacilityBranch()
	{
	    return facilityBranch;
	}

	public void setFacilityBranch(BigDecimal facilityBranch)
	{
	    this.facilityBranch = facilityBranch;
	}

	public BigDecimal getFacilitySubLimit()
	{
	    return facilitySubLimit;
	}

	public void setFacilitySubLimit(BigDecimal facilitySubLimit)
	{
	    this.facilitySubLimit = facilitySubLimit;
	}

	public BigDecimal getFacilitySubLimitLineNo()
	{
	    return facilitySubLimitLineNo;
	}

	public void setFacilitySubLimitLineNo(BigDecimal facilitySubLimitLineNo)
	{
	    this.facilitySubLimitLineNo = facilitySubLimitLineNo;
	}
	
	public String getIdNo()
	{
	    return idNo;
	}

	public void setIdNo(String idNo)
	{
	    this.idNo = idNo;
	}

	public String getcSN()
	{
	    return cSN;
	}

	public void setcSN(String cSN)
	{
	    this.cSN = cSN;
	}

	public BigDecimal getFmsCreditCardFacilityLineNo()
	{
	    return fmsCreditCardFacilityLineNo;
	}

	public void setFmsCreditCardFacilityLineNo(BigDecimal fmsCreditCardFacilityLineNo)
	{
	    this.fmsCreditCardFacilityLineNo = fmsCreditCardFacilityLineNo;
	}

	public String getPin_status_desc()
	{
	    return pin_status_desc;
	}

	public void setPin_status_desc(String pin_status_desc)
	{
	    this.pin_status_desc = pin_status_desc;
	}

	public String getPeriodId()
	{
	    return periodId;
	}

	public void setPeriodId(String periodId)
	{
	    this.periodId = periodId;
	}

	public String getPinStatus()
	{
	    return pinStatus;
	}

	public void setPinStatus(String pinStatus)
	{
	    this.pinStatus = pinStatus;
	}

	public String getAllowCifCreationMaskYN()
	{
	    return allowCifCreationMaskYN;
	}

	public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
	{
	    this.allowCifCreationMaskYN = allowCifCreationMaskYN;
	}

	    public BigDecimal getLovTypePinType()
	    {
	        return lovTypePinType;
	    }

	    public void setLovTypePinType(BigDecimal lovTypePinType)
	    {
	        this.lovTypePinType = lovTypePinType;
	    }
    public BigDecimal getLoginBranchCode()
    {
	return loginBranchCode;
    }

    public void setLoginBranchCode(BigDecimal loginBranchCode)
    {
	this.loginBranchCode = loginBranchCode;
    }

    public String getIsFromAlert()
    {
	return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
	this.isFromAlert = isFromAlert;
    }

    public Boolean getIsMultiHO()
    {
	return isMultiHO;
    }

    public void setIsMultiHO(Boolean isMultiHO)
    {
	this.isMultiHO = isMultiHO;
    }

    public BigDecimal getHoBranch()
    {
	return hoBranch;
    }

    public void setHoBranch(BigDecimal hoBranch)
    {
	this.hoBranch = hoBranch;
    }

    public Date getDefaultSearchDate()
    {
	return defaultSearchDate;
    }

    public void setDefaultSearchDate(Date defaultSearchDate)
    {
	this.defaultSearchDate = defaultSearchDate;
    }

    public String getScreenSrc()
    {
	return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
	this.screenSrc = screenSrc;
    }

    public String getFromStatusReasonLookUp()
    {
	return fromStatusReasonLookUp;
    }

    public void setFromStatusReasonLookUp(String fromStatusReasonLookUp)
    {
	this.fromStatusReasonLookUp = fromStatusReasonLookUp;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public String getAccRestriction()
    {
	return accRestriction;
    }

    public void setAccRestriction(String accRestriction)
    {
	this.accRestriction = accRestriction;
    }

    public String getMultiBrTrx()
    {
	return multiBrTrx;
    }

    public void setMultiBrTrx(String multiBrTrx)
    {
	this.multiBrTrx = multiBrTrx;
    }

    public String getCreditCardPaymentTrx()
    {
	return creditCardPaymentTrx;
    }

    public void setCreditCardPaymentTrx(String creditCardPaymentTrx)
    {
	this.creditCardPaymentTrx = creditCardPaymentTrx;
    }

    public BigDecimal getFromBranch()
    {
	return fromBranch;
    }

    public void setFromBranch(BigDecimal fromBranch)
    {
	this.fromBranch = fromBranch;
    }

    public BigDecimal getToBranch()
    {
	return toBranch;
    }

    public void setToBranch(BigDecimal toBranch)
    {
	this.toBranch = toBranch;
    }

    public BigDecimal getFromApplicationId()
    {
	return fromApplicationId;
    }

    public void setFromApplicationId(BigDecimal fromApplicationId)
    {
	this.fromApplicationId = fromApplicationId;
    }

    public BigDecimal getToApplicationId()
    {
	return toApplicationId;
    }

    public void setToApplicationId(BigDecimal toApplicationId)
    {
	this.toApplicationId = toApplicationId;
    }

    public String getFromCardNo()
    {
	return fromCardNo;
    }

    public void setFromCardNo(String fromCardNo)
    {
	this.fromCardNo = fromCardNo;
    }

    public String getToCardNo()
    {
	return toCardNo;
    }

    public void setToCardNo(String toCardNo)
    {
	this.toCardNo = toCardNo;
    }


    public BigDecimal getCollateralCode()
    {
	return collateralCode;
    }

    public void setCollateralCode(BigDecimal collateralCode)
    {
	this.collateralCode = collateralCode;
    }

    public BigDecimal getFacilityCode()
    {
	return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
	this.facilityCode = facilityCode;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }


    public String getMultiDivCy()
    {
	return multiDivCy;
    }

    public void setMultiDivCy(String multiDivCy)
    {
	this.multiDivCy = multiDivCy;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyRate()
    {
	return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate)
    {
	this.currencyRate = currencyRate;
    }

    public BigDecimal getCurrencyUnit()
    {
	return currencyUnit;
    }

    public void setCurrencyUnit(BigDecimal currencyUnit)
    {
	this.currencyUnit = currencyUnit;
    }

    public String getErrorType()
    {
	return errorType;
    }

    public void setErrorType(String errorType)
    {
	this.errorType = errorType;
    }

    public BigDecimal getDrwdwnCode()
    {
	return drwdwnCode;
    }

    public void setDrwdwnCode(BigDecimal drwdwnCode)
    {
	this.drwdwnCode = drwdwnCode;
    }

	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	
	public String getUseForCifProductsFlag()
	{
		return useForCifProductsFlag;
	}

	
	public void setUseForCifProductsFlag(String useForCifProductsFlag)
	{
		this.useForCifProductsFlag = useForCifProductsFlag;
	}
	
	


}