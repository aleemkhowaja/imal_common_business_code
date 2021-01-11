package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.struts2.lib.common.GridParamsSC;

public class FomSC extends GridParamsSC
{
    private String status;
    private String userName;
    private String appName;
    private BigDecimal cifNo;
    private BigDecimal tellerCode;
    private BigDecimal tellerRole;
    private BigDecimal priorityCode;
    private String limitType;
    private String roleCode;
    private String langCode;
    private BigDecimal lovType;
    private String cifDefaultAddress;
    private String gc_branch;
    private String statusSuspended;
    private String CLIENT;
    private String ADD_STRING2;
    private String entity;
    private BigDecimal event;
    private List listBranches;
    private String ivCrud;
    private BigDecimal cifType;
    private String lang;
    private BigDecimal division;
    private BigDecimal department;
    private String confirmMsg;
    private String oldMobile;
    private String walletFlag;
  
    
   // #82962  IIAB110527 fboukarroum
    private String statusDeleted;
    private BigDecimal idType;
    private BigDecimal idType2;
    private String idNo;
    private String idNo2;
    private String bank;
    private String fromValidationOfIdType2="0";
    
    private BigDecimal nationality;
    private BigDecimal country;
    private BigDecimal country1;
    private BigDecimal country2;
    private BigDecimal country3;
    private BigDecimal country4;
    private String fatcaCompliant;
    private String bicCode;
    //abir
    //private BigDecimal lineNo;
    //private BigDecimal memberCifNo;
    private BigDecimal memberLineNo;
    private String gridData;
    private String moreDetailsgridData;
    private String defaultCIfIds;
    private BigDecimal memberCifNo;
    private BigDecimal compCodeCif;
    private String proceedOnModifiedCif;
    private String progRef;
    private BigDecimal sironGrade;
    private BigDecimal line;
    private String checkRole;
    
    private BigDecimal compCountryCode;
    private BigDecimal nationCode;
    private BigDecimal receiveIncomeCountryCode;
    private BigDecimal countryYmcEight;
    private BigDecimal cifAddressCountryEight;
    private BigDecimal longStayCntryCodeEight;
    private BigDecimal attorneyOutsideCntryCode;
    private BigDecimal otherPassportCountry;
    private BigDecimal permResidCountryCode;
    private BigDecimal taxPayerCountryCode;
    private BigDecimal compPhoneCountry;
    private String postalCodeType;
    private BigDecimal sharePerc;
    private BigDecimal updateCode;
    private String financialType;
    private int countCifsJoint;
    private BigDecimal countryTaxPayerId;
    private BigDecimal errorCode;
    private String errorMessage;
    private String allowCifCreationMaskYN;
    private CTSTELLERVO ctsTellerVO;
    
  //Habib Baalbaki accocunt restriction 372747
    private String pageRef;
    private String errType;
    private String errMsg;
    private BigDecimal rtrnVal;
    private BigDecimal errCode;
    private boolean checkNbRec;
    private int cifNbRecords;
    private List<CIFVO> cifListRecords = new ArrayList<>();
    private String elementID;
    
    private String lastRun;//Rania - Customers Segmentation
    
    private String noMessageToDisplay; /*DBU190684*/
    
    private String cifWhereQuery;
    
    private boolean proceedOnInactiveCIF;
    private boolean throwProceedOnInactiveCIFWarning;
    
    //Rania - ABSAI180073
    private BigDecimal scoreRiskValue;
    private BigDecimal scoreCode;
    private String fromScoreValueDep;
    private String fromScoreBtn;
    private BigDecimal screenId;
    private String screenDesc;
    //added by maria for BMO180276
    private String fromSrc;   
    private String cardReaderCivilID;
    private String fromExpDateValid;
    private Date  idExpiryDate;
    private BigDecimal transactionType;
    //Rania - BMO180181
    private BigDecimal joinIdType;
    private String joinIdNo;
    private String enableUniquenessByCifTypeOnly;
    //
    
    private BigDecimal accBR;
    private BigDecimal accCY;
    private BigDecimal accGL;
    private BigDecimal accSL;
    private String email;
    private String mobile;
    private BigDecimal eventCode;
    private String accAddRef;
    private BigDecimal packageCode;
    private String subscriberType;
    private BigDecimal chequeType;
    
    private String gridMode;
    private String selectedCustomerRef;
    private boolean openExistingRecord;
    
    private BigDecimal fomKycScreenId;
    
    //Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
    private String parentChildInd;
    //
    private BigDecimal maxSp;
    
    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public void setLimitType(String limitType)
    {
	this.limitType = limitType;
    }

    public String getLimitType()
    {
	return limitType;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getUserName()
    {
	return userName;
    }

    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getTellerRole()
    {
	return tellerRole;
    }

    public void setTellerRole(BigDecimal tellerRole)
    {
	this.tellerRole = tellerRole;
    }

    public String getRoleCode()
    {
	return roleCode;
    }

    public void setRoleCode(String roleCode)
    {
	this.roleCode = roleCode;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public String getCifDefaultAddress()
    {
	return cifDefaultAddress;
    }

    public void setCifDefaultAddress(String cifDefaultAddress)
    {
	this.cifDefaultAddress = cifDefaultAddress;
    }

    public String getGc_branch()
    {
	return gc_branch;
    }

    public void setGc_branch(String gcBranch)
    {
	gc_branch = gcBranch;
    }

    public List getListBranches()
    {
	return listBranches;
    }

    public void setListBranches(List listBranches)
    {
	this.listBranches = listBranches;
    }

    public BigDecimal getTellerCode()
    {
	return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
	this.tellerCode = tellerCode;
    }

    public String getCLIENT()
    {
	return CLIENT;
    }

    public void setCLIENT(String cLIENT)
    {
	CLIENT = cLIENT;
    }

    public String getADD_STRING2()
    {
	return ADD_STRING2;
    }

    public void setADD_STRING2(String aDDSTRING2)
    {
	ADD_STRING2 = aDDSTRING2;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public String getLang()
    {
	return lang;
    }

    public void setLang(String lang)
    {
	this.lang = lang;
    }

    public BigDecimal getDivision()
    {
	return division;
    }

    public void setDivision(BigDecimal division)
    {
	this.division = division;
    }

    public BigDecimal getDepartment()
    {
	return department;
    }

    public void setDepartment(BigDecimal department)
    {
	this.department = department;
    }

    public String getEntity()
    {
	return entity;
    }

    public void setEntity(String entity)
    {
	this.entity = entity;
    }

    public BigDecimal getEvent()
    {
        return event;
    }

    public void setEvent(BigDecimal event)
    {
        this.event = event;
    }
    
    public String getStatusDeleted()
    {
        return statusDeleted;
    }

    public void setStatusDeleted(String statusDeleted)
    {
        this.statusDeleted = statusDeleted;
    }
    
    public BigDecimal getIdType()
    {
        return idType;
    }

    public void setIdType(BigDecimal idType)
    {
        this.idType = idType;
    }

    public BigDecimal getIdType2()
    {
        return idType2;
    }

    public void setIdType2(BigDecimal idType2)
    {
        this.idType2 = idType2;
    }

    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getIdNo2()
    {
        return idNo2;
    }

    public void setIdNo2(String idNo2)
    {
        this.idNo2 = idNo2;
    }

    public String getBank()
    {
        return bank;
    }

    public void setBank(String bank)
    {
        this.bank = bank;
    }

    public String getFromValidationOfIdType2()
    {
        return fromValidationOfIdType2;
    }

    public void setFromValidationOfIdType2(String fromValidationOfIdType2)
    {
        this.fromValidationOfIdType2 = fromValidationOfIdType2;
    }

    public BigDecimal getPriorityCode()
    {
        return priorityCode;
    }

    public void setPriorityCode(BigDecimal priorityCode)
    {
        this.priorityCode = priorityCode;
    }

    public BigDecimal getNationality()
    {
        return nationality;
    }

    public void setNationality(BigDecimal nationality)
    {
        this.nationality = nationality;
    }

    public BigDecimal getCountry1()
    {
        return country1;
    }

    public void setCountry1(BigDecimal country1)
    {
        this.country1 = country1;
    }

    public BigDecimal getCountry2()
    {
        return country2;
    }

    public void setCountry2(BigDecimal country2)
    {
        this.country2 = country2;
    }

    public BigDecimal getCountry3()
    {
        return country3;
    }

    public void setCountry3(BigDecimal country3)
    {
        this.country3 = country3;
    }

    public BigDecimal getCountry4()
    {
        return country4;
    }

    public void setCountry4(BigDecimal country4)
    {
        this.country4 = country4;
    }

    public String getFatcaCompliant()
    {
        return fatcaCompliant;
    }

    public void setFatcaCompliant(String fatcaCompliant)
    {
        this.fatcaCompliant = fatcaCompliant;
    }

    public BigDecimal getCountry()
    {
        return country;
    }

    public void setCountry(BigDecimal country)
    {
        this.country = country;
    }

    public String getConfirmMsg()
    {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
        this.confirmMsg = confirmMsg;
    }

    /**
     * @return the statusSuspended
     */
    public String getStatusSuspended()
    {
        return statusSuspended;
    }

    /**
     * @param statusSuspended the statusSuspended to set
     */
    public void setStatusSuspended(String statusSuspended)
    {
        this.statusSuspended = statusSuspended;
    }

    public String getBicCode()
    {
        return bicCode;
    }

    public void setBicCode(String bicCode)
    {
        this.bicCode = bicCode;
    }

    public BigDecimal getMemberLineNo()
    {
        return memberLineNo;
    }

    public void setMemberLineNo(BigDecimal memberLineNo)
    {
        this.memberLineNo = memberLineNo;
    }

    public String getMoreDetailsgridData()
    {
        return moreDetailsgridData;
    }

    public void setMoreDetailsgridData(String moreDetailsgridData)
    {
        this.moreDetailsgridData = moreDetailsgridData;
    }

    public String getGridData()
    {
        return gridData;
    }

    public void setGridData(String gridData)
    {
        this.gridData = gridData;
    }

    public String getDefaultCIfIds()
    {
        return defaultCIfIds;
    }

    public void setDefaultCIfIds(String defaultCIfIds)
    {
        this.defaultCIfIds = defaultCIfIds;
    }

    public BigDecimal getMemberCifNo()
    {
        return memberCifNo;
    }

    public void setMemberCifNo(BigDecimal memberCifNo)
    {
        this.memberCifNo = memberCifNo;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public BigDecimal getSironGrade()
    {
        return sironGrade;
    }

    public void setSironGrade(BigDecimal sironGrade)
    {
        this.sironGrade = sironGrade;
    }

    public String getCheckRole()
    {
        return checkRole;
    }

    public void setCheckRole(String checkRole)
    {
        this.checkRole = checkRole;
    }

    public BigDecimal getCompCountryCode()
    {
        return compCountryCode;
    }

    public void setCompCountryCode(BigDecimal compCountryCode)
    {
        this.compCountryCode = compCountryCode;
    }

    public BigDecimal getNationCode()
    {
        return nationCode;
    }

    public void setNationCode(BigDecimal nationCode)
    {
        this.nationCode = nationCode;
    }

    public BigDecimal getReceiveIncomeCountryCode()
    {
        return receiveIncomeCountryCode;
    }

    public void setReceiveIncomeCountryCode(BigDecimal receiveIncomeCountryCode)
    {
        this.receiveIncomeCountryCode = receiveIncomeCountryCode;
    }

    public BigDecimal getCountryYmcEight()
    {
        return countryYmcEight;
    }

    public void setCountryYmcEight(BigDecimal countryYmcEight)
    {
        this.countryYmcEight = countryYmcEight;
    }

    public BigDecimal getCifAddressCountryEight()
    {
        return cifAddressCountryEight;
    }

    public void setCifAddressCountryEight(BigDecimal cifAddressCountryEight)
    {
        this.cifAddressCountryEight = cifAddressCountryEight;
    }

    public BigDecimal getLongStayCntryCodeEight()
    {
        return longStayCntryCodeEight;
    }

    public void setLongStayCntryCodeEight(BigDecimal longStayCntryCodeEight)
    {
        this.longStayCntryCodeEight = longStayCntryCodeEight;
    }

    public BigDecimal getAttorneyOutsideCntryCode()
    {
        return attorneyOutsideCntryCode;
    }

    public void setAttorneyOutsideCntryCode(BigDecimal attorneyOutsideCntryCode)
    {
        this.attorneyOutsideCntryCode = attorneyOutsideCntryCode;
    }

    public BigDecimal getOtherPassportCountry()
    {
        return otherPassportCountry;
    }

    public void setOtherPassportCountry(BigDecimal otherPassportCountry)
    {
        this.otherPassportCountry = otherPassportCountry;
    }

    public BigDecimal getPermResidCountryCode()
    {
        return permResidCountryCode;
    }

    public void setPermResidCountryCode(BigDecimal permResidCountryCode)
    {
        this.permResidCountryCode = permResidCountryCode;
    }

    public BigDecimal getTaxPayerCountryCode()
    {
        return taxPayerCountryCode;
    }

    public void setTaxPayerCountryCode(BigDecimal taxPayerCountryCode)
    {
        this.taxPayerCountryCode = taxPayerCountryCode;
    }

    public BigDecimal getCompPhoneCountry()
    {
        return compPhoneCountry;
    }

    public void setCompPhoneCountry(BigDecimal compPhoneCountry)
    {
        this.compPhoneCountry = compPhoneCountry;
    }

    public String getPostalCodeType()
    {
        return postalCodeType;
    }

    public void setPostalCodeType(String postalCodeType)
    {
        this.postalCodeType = postalCodeType;
    }

    public BigDecimal getSharePerc()
    {
        return sharePerc;
    }

    public void setSharePerc(BigDecimal sharePerc)
    {
        this.sharePerc = sharePerc;
    }

    public BigDecimal getUdpdateCode()
    {
        return updateCode;
    }

    public void setUdpdateCode(BigDecimal udpdateCode)
    {
        this.updateCode = udpdateCode;
    }

    public String getFinancialType()
    {
        return financialType;
    }

    public void setFinancialType(String financialType)
    {
        this.financialType = financialType;
    }

    public BigDecimal getLine()
    {
        return line;
    }

    public void setLine(BigDecimal line)
    {
        this.line = line;
    }

    public int getCountCifsJoint()
    {
        return countCifsJoint;
    }

    public void setCountCifsJoint(int countCifsJoint)
    {
        this.countCifsJoint = countCifsJoint;
    }

    public BigDecimal getCountryTaxPayerId()
    {
        return countryTaxPayerId;
    }

    public void setCountryTaxPayerId(BigDecimal countryTaxPayerId)
    {
        this.countryTaxPayerId = countryTaxPayerId;
    }

    public BigDecimal getUpdateCode()
    {
        return updateCode;
    }

    public void setUpdateCode(BigDecimal updateCode)
    {
        this.updateCode = updateCode;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public String getErrType()
    {
        return errType;
    }

    public void setErrType(String errType)
    {
        this.errType = errType;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }

    public BigDecimal getRtrnVal()
    {
        return rtrnVal;
    }

    public void setRtrnVal(BigDecimal rtrnVal)
    {
        this.rtrnVal = rtrnVal;
    }

    public BigDecimal getErrCode()
    {
        return errCode;
    }

    public void setErrCode(BigDecimal errCode)
    {
        this.errCode = errCode;
    }

    public boolean isCheckNbRec()
    {
        return checkNbRec;
    }

    public void setCheckNbRec(boolean checkNbRec)
    {
        this.checkNbRec = checkNbRec;
    }

    public List<CIFVO> getCifListRecords()
    {
        return cifListRecords;
    }

    public void setCifListRecords(List<CIFVO> cifListRecords)
    {
        this.cifListRecords = cifListRecords;
    }

    public int getCifNbRecords()
    {
        return cifNbRecords;
    }

    public void setCifNbRecords(int cifNbRecords)
    {
        this.cifNbRecords = cifNbRecords;
    }

    public String getOldMobile()
    {
        return oldMobile;
    }

    public void setOldMobile(String oldMobile)
    {
        this.oldMobile = oldMobile;
    }

    public String getWalletFlag()
    {
        return walletFlag;
    }

    public void setWalletFlag(String walletFlag)
    {
        this.walletFlag = walletFlag;
    }
    
    public BigDecimal getAccBR()
    {
        return accBR;
    }

    public void setAccBR(BigDecimal accBR)
    {
        this.accBR = accBR;
    }

    public BigDecimal getAccCY()
    {
        return accCY;
    }

    public void setAccCY(BigDecimal accCY)
    {
        this.accCY = accCY;
    }

    public BigDecimal getAccGL()
    {
        return accGL;
    }

    public void setAccGL(BigDecimal accGL)
    {
        this.accGL = accGL;
    }

    public BigDecimal getAccSL()
    {
        return accSL;
    }

    public void setAccSL(BigDecimal accSL)
    {
        this.accSL = accSL;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public BigDecimal getEventCode()
    {
        return eventCode;
    }

    public void setEventCode(BigDecimal eventCode)
    {
        this.eventCode = eventCode;
    }

    public String getAccAddRef()
    {
        return accAddRef;
    }

    public void setAccAddRef(String accAddRef)
    {
        this.accAddRef = accAddRef;
    }

    public BigDecimal getPackageCode()
    {
        return packageCode;
    }

    public void setPackageCode(BigDecimal packageCode)
    {
        this.packageCode = packageCode;
    }

    public String getSubscriberType()
    {
	return subscriberType;
    }

    public void setSubscriberType(String subscriberType)
    {
	this.subscriberType = subscriberType;
    }

    public BigDecimal getChequeType()
    {
	return chequeType;
    }

    public void setChequeType(BigDecimal chequeType)
    {
	this.chequeType = chequeType;
    }

    public String getLastRun()
    {
        return lastRun;
    }

    public void setLastRun(String lastRun)
    {
        this.lastRun = lastRun;
    }

    public String getNoMessageToDisplay()
    {
        return noMessageToDisplay;
    }

    public void setNoMessageToDisplay(String noMessageToDisplay)
    {
        this.noMessageToDisplay = noMessageToDisplay;
    }

    public String getCifWhereQuery()
    {
        return cifWhereQuery;
    }

    public void setCifWhereQuery(String cifWhereQuery)
    {
        this.cifWhereQuery = cifWhereQuery;
    }

    public boolean isProceedOnInactiveCIF()
    {
        return proceedOnInactiveCIF;
    }

    public void setProceedOnInactiveCIF(boolean proceedOnInactiveCIF)
    {
        this.proceedOnInactiveCIF = proceedOnInactiveCIF;
    }

    public boolean isThrowProceedOnInactiveCIFWarning()
    {
        return throwProceedOnInactiveCIFWarning;
    }

    public void setThrowProceedOnInactiveCIFWarning(boolean throwProceedOnInactiveCIFWarning)
    {
        this.throwProceedOnInactiveCIFWarning = throwProceedOnInactiveCIFWarning;
    }

    public BigDecimal getScoreRiskValue()
    {
        return scoreRiskValue;
    }

    public void setScoreRiskValue(BigDecimal scoreRiskValue)
    {
        this.scoreRiskValue = scoreRiskValue;
    }

    public BigDecimal getScoreCode()
    {
        return scoreCode;
    }

    public void setScoreCode(BigDecimal scoreCode)
    {
        this.scoreCode = scoreCode;
    }

    public String getFromScoreValueDep()
    {
        return fromScoreValueDep;
    }

    public void setFromScoreValueDep(String fromScoreValueDep)
    {
        this.fromScoreValueDep = fromScoreValueDep;
    }

    public String getFromScoreBtn()
    {
        return fromScoreBtn;
    }

    public void setFromScoreBtn(String fromScoreBtn)
    {
        this.fromScoreBtn = fromScoreBtn;
    }

    public String getElementID()
    {
        return elementID;
    }

    public void setElementID(String elementID)
    {
        this.elementID = elementID;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

    public String getProceedOnModifiedCif()
    {
        return proceedOnModifiedCif;
    }

    public void setProceedOnModifiedCif(String proceedOnModifiedCif)
    {
        this.proceedOnModifiedCif = proceedOnModifiedCif;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }
    

    public void setErrorMessage(String errorMessage)
    {
	this.errorMessage = errorMessage;
    }

    public String getErrorMessage()
    {
	return errorMessage;
    }

	public CTSTELLERVO getCtsTellerVO()
	{
	    return ctsTellerVO;
	}

	public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
	{
	    this.ctsTellerVO = ctsTellerVO;
	}

	public String getAllowCifCreationMaskYN()
	{
	    return allowCifCreationMaskYN;
	}

	public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
	{
	    this.allowCifCreationMaskYN = allowCifCreationMaskYN;
	}

	public String getGridMode()
	{
	    return gridMode;
	}

	public void setGridMode(String gridMode)
	{
	    this.gridMode = gridMode;
	}

	public String getSelectedCustomerRef()
	{
	    return selectedCustomerRef;
	}

	public void setSelectedCustomerRef(String selectedCustomerRef)
	{
	    this.selectedCustomerRef = selectedCustomerRef;
	}

	public boolean isOpenExistingRecord()
	{
	    return openExistingRecord;
	}

	public void setOpenExistingRecord(boolean openExistingRecord)
	{
	    this.openExistingRecord = openExistingRecord;
	}

	public BigDecimal getFomKycScreenId()
	{
	    return fomKycScreenId;
	}

	public void setFomKycScreenId(BigDecimal fomKycScreenId)
	{
	    this.fomKycScreenId = fomKycScreenId;
	}

	public String getParentChildInd()
	{
	    return parentChildInd;
	}

	public void setParentChildInd(String parentChildInd)
	{
	    this.parentChildInd = parentChildInd;
	}

	public BigDecimal getScreenId()
	{
	    return screenId;
	}

	public void setScreenId(BigDecimal screenId)
	{
	    this.screenId = screenId;
	}

	public String getScreenDesc()
	{
	    return screenDesc;
	}

	public void setScreenDesc(String screenDesc)
	{
	    this.screenDesc = screenDesc;
	}

	public String getFromSrc() {
		return fromSrc;
	}

	public void setFromSrc(String fromSrc) {
		this.fromSrc = fromSrc;
	}

	public String getCardReaderCivilID() {
		return cardReaderCivilID;
	}

	public void setCardReaderCivilID(String cardReaderCivilID) {
		this.cardReaderCivilID = cardReaderCivilID;
	}

	public String getFromExpDateValid() {
		return fromExpDateValid;
	}

	public void setFromExpDateValid(String fromExpDateValid) {
		this.fromExpDateValid = fromExpDateValid;
	}

	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	public BigDecimal getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(BigDecimal transactionType) {
		this.transactionType = transactionType;
	}

	
	public BigDecimal getJoinIdType()
	{
		return joinIdType;
	}

	
	public void setJoinIdType(BigDecimal joinIdType)
	{
		this.joinIdType = joinIdType;
	}

	
	public String getJoinIdNo()
	{
		return joinIdNo;
	}

	
	public void setJoinIdNo(String joinIdNo)
	{
		this.joinIdNo = joinIdNo;
	}

	
	public String getEnableUniquenessByCifTypeOnly()
	{
		return enableUniquenessByCifTypeOnly;
	}

	
	public void setEnableUniquenessByCifTypeOnly(String enableUniquenessByCifTypeOnly)
	{
		this.enableUniquenessByCifTypeOnly = enableUniquenessByCifTypeOnly;
	}

	public BigDecimal getMaxSp()
	{
	    return maxSp;
	}

	public void setMaxSp(BigDecimal maxSp)
	{
	    this.maxSp = maxSp;
	}
	
	
}