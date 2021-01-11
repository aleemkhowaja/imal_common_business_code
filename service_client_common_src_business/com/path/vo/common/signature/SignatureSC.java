package com.path.vo.common.signature;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.path.lib.common.util.DateUtil;
import com.path.struts2.lib.common.GridParamsSC;

public class SignatureSC extends GridParamsSC implements Cloneable
{
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cifNo;
    private BigDecimal slNo;
    private BigDecimal glNo;
    private String appName;
    private String validateFlag;
    private Date validationDate = DateUtil.nullToInitDate(null);//Libin initialized the variable as issue reported by tool - Uninitialized read of validationDate
    private String validationDateStr;
    private String returnFlag;
    private String signatureTp;
    private String cifAcc;
    private boolean autoApprove;
    private BigDecimal objSeq;
    private BigDecimal tempObjSeq;
    private BigDecimal lastNumber;
    private BigDecimal tempLastNumber;
    private Date systemDate;
    private BigDecimal amount = BigDecimal.ZERO;
    private String groupID;
    private String status;
    private String genNote;
    private BigDecimal width;
    private BigDecimal height;
    private String format;
    private String description;
    private Date expiryDate;
    private BigDecimal unlimited;
    private byte[] image;
    private String signMode;
    private String filterSign = "0";
    private String applyFilter;
    private BigDecimal showSignDoc;
    private BigDecimal showSignPho;
    private boolean isCIFObject;
    private BigDecimal currentCurrency;
    private BigDecimal objCode;
    private String insUpdDelApprRejSel;
    private boolean isTemp;
    private String objType;
    private int defaultPhoto;
    private int trxType;
    private String enforceSign;
    private BigDecimal signNoteMand;
    private BigDecimal signViewMand;
    private BigDecimal showSignAnn;
    private String details;
    private String edit;
    private String changeAmount;
    private boolean readOnly; // flag to distinguish whether its view/maintenance
    private BigDecimal lovType;
    private String langCode;
    private ArrayList<String> privilegesToCheck;
    private String docType;
    private String parentPageStatus;
    private String parentIvCrud;
    private String jointAccNo;
    private String isUnclamied;
    private String program;
    private String flag;
    private boolean showAcceptCancelBtns;
    private String groupIds;
    private String viewSelectedSignMessage;
    private String screenName;// to identify the screen from were the page is called(added because this page is common across application)
	
    // NABIL FEGHALI - IIAB120556 - Signature Privilege Expiry
    private String expiryDateRequired;
	
    private Boolean copySignTabVisible;
    private boolean hideAcceptCancelInAlert;
    private String profType;
    private BigDecimal cifType;
    
    private String isAsaanAcc;
    private String gridRowId;

    private boolean noWarningMsg;
    private BigDecimal countryID;

    //EWBI160037 -- [John Massaad]
    private BigDecimal trsNo;
    private String trsType;
    private String cbInd;
    private String trsStatus;
    private String signCIFDesc;
    private String accountReference;
    
    // #650085 DASI180166
    private String excludedStatuses ;
    
   //EWBI160037 -- [John Massaad]

    public String getAccountReference()
    {
        return accountReference;
    }

    public void setAccountReference(String accountReference)
    {
        this.accountReference = accountReference;
    }

    public SignatureSC(){
	 //set default date to 1900
	validationDate  = DateUtil.nullToInitDate(validationDate);
    }
 
    public String getIsUnclamied()
    {
	return isUnclamied;
    }

    public void setIsUnclamied(String isUnclamied)
    {
	this.isUnclamied = isUnclamied;
    }

    public String getParentPageStatus()
    {
	return parentPageStatus;
    }

    public void setParentPageStatus(String parentPageStatus)
    {
	this.parentPageStatus = parentPageStatus;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getSlNo()
    {
	return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getValidateFlag()
    {
	return validateFlag;
    }

    public void setValidateFlag(String validateFlag)
    {
	this.validateFlag = validateFlag;
    }

    public Date getValidationDate()
    {
	return validationDate;
    }

    public void setValidationDate(Date validationDate)
    {
	this.validationDate = validationDate;
    }

    public String getReturnFlag()
    {
	return returnFlag;
    }

    public void setReturnFlag(String returnFlag)
    {
	this.returnFlag = returnFlag;
    }

    public String getCifAcc()
    {
	return cifAcc;
    }

    public void setCifAcc(String cifAcc)
    {
	this.cifAcc = cifAcc;
    }

    public boolean isAutoApprove()
    {
	return autoApprove;
    }

    public void setAutoApprove(boolean autoApprove)
    {
	this.autoApprove = autoApprove;
    }

    public BigDecimal getObjSeq()
    {
	return objSeq;
    }

    public void setObjSeq(BigDecimal objSeq)
    {
	this.objSeq = objSeq;
    }

    public BigDecimal getTempObjSeq()
    {
	return tempObjSeq;
    }

    public void setTempObjSeq(BigDecimal tempObjSeq)
    {
	this.tempObjSeq = tempObjSeq;
    }

    public BigDecimal getLastNumber()
    {
	return lastNumber;
    }

    public void setLastNumber(BigDecimal lastNumber)
    {
	this.lastNumber = lastNumber;
    }

    public BigDecimal getTempLastNumber()
    {
	return tempLastNumber;
    }

    public void setTempLastNumber(BigDecimal tempLastNumber)
    {
	this.tempLastNumber = tempLastNumber;
    }

    public Date getSystemDate()
    {
	return systemDate;
    }

    public void setSystemDate(Date systemDate)
    {
	this.systemDate = systemDate;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public String getGroupID()
    {
	return groupID;
    }

    public void setGroupID(String groupID)
    {
	this.groupID = groupID;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getGenNote()
    {
	return genNote;
    }

    public void setGenNote(String genNote)
    {
	this.genNote = genNote;
    }

    public BigDecimal getWidth()
    {
	return width;
    }

    public void setWidth(BigDecimal width)
    {
	this.width = width;
    }

    public BigDecimal getHeight()
    {
	return height;
    }

    public void setHeight(BigDecimal height)
    {
	this.height = height;
    }

    public String getFormat()
    {
	return format;
    }

    public void setFormat(String format)
    {
	this.format = format;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public Date getExpiryDate()
    {
	return expiryDate;
    }

    public void setExpiryDate(Date expiryDate)
    {
	this.expiryDate = expiryDate;
    }

    public BigDecimal getUnlimited()
    {
	return unlimited;
    }

    public void setUnlimited(BigDecimal unlimited)
    {
	this.unlimited = unlimited;
    }

    public byte[] getImage()
    {
	return image;
    }

    public void setImage(byte[] image)
    {
	this.image = image;
    }

    public String getSignMode()
    {
	return signMode;
    }

    public void setSignMode(String signMode)
    {
	this.signMode = signMode;
    }

    public String getFilterSign()
    {
	return filterSign;
    }

    public void setFilterSign(String filterSign)
    {
	this.filterSign = filterSign;
    }

    public String getApplyFilter()
    {
	return applyFilter;
    }

    public void setApplyFilter(String applyFilter)
    {
	this.applyFilter = applyFilter;
    }

    public BigDecimal getShowSignDoc()
    {
	return showSignDoc;
    }

    public void setShowSignDoc(BigDecimal showSignDoc)
    {
	this.showSignDoc = showSignDoc;
    }

    public BigDecimal getShowSignPho()
    {
	return showSignPho;
    }

    public void setShowSignPho(BigDecimal showSignPho)
    {
	this.showSignPho = showSignPho;
    }

    public boolean isCIFObject()
    {
	return isCIFObject;
    }

    public void setCIFObject(boolean isCIFObject)
    {
	this.isCIFObject = isCIFObject;
    }

    public BigDecimal getCurrentCurrency()
    {
	return currentCurrency;
    }

    public void setCurrentCurrency(BigDecimal currentCurrency)
    {
	this.currentCurrency = currentCurrency;
    }

    public BigDecimal getObjCode()
    {
	return objCode;
    }

    public void setObjCode(BigDecimal objCode)
    {
	this.objCode = objCode;
    }

    public String getInsUpdDelApprRejSel()
    {
	return insUpdDelApprRejSel;
    }

    public void setInsUpdDelApprRejSel(String insUpdDelApprRejSel)
    {
	this.insUpdDelApprRejSel = insUpdDelApprRejSel;
    }

    public boolean isTemp()
    {
	return isTemp;
    }

    public void setTemp(boolean isTemp)
    {
	this.isTemp = isTemp;
    }

    public String getObjType()
    {
	return objType;
    }

    public void setObjType(String objType)
    {
	this.objType = objType;
    }

    public int getDefaultPhoto()
    {
	return defaultPhoto;
    }

    public void setDefaultPhoto(int defaultPhoto)
    {
	this.defaultPhoto = defaultPhoto;
    }

    public String getEnforceSign()
    {
	return enforceSign;
    }

    public void setEnforceSign(String enforceSign)
    {
	this.enforceSign = enforceSign;
    }

    public BigDecimal getSignNoteMand()
    {
	return signNoteMand;
    }

    public void setSignNoteMand(BigDecimal signNoteMand)
    {
	this.signNoteMand = signNoteMand;
    }

    public BigDecimal getShowSignAnn()
    {
	return showSignAnn;
    }

    public void setShowSignAnn(BigDecimal showSignAnn)
    {
	this.showSignAnn = showSignAnn;
    }

    public String getDetails()
    {
	return details;
    }

    public void setDetails(String details)
    {
	this.details = details;
    }

    public String getEdit()
    {
	return edit;
    }

    public void setEdit(String edit)
    {
	this.edit = edit;
    }

    public String getChangeAmount()
    {
	return changeAmount;
    }

    public void setChangeAmount(String changeAmount)
    {
	this.changeAmount = changeAmount;
    }

    public ArrayList<String> getPrivilegesToCheck()
    {
	return privilegesToCheck;
    }

    public void setPrivilegesToCheck(ArrayList<String> privilegesToCheck)
    {
	this.privilegesToCheck = privilegesToCheck;
    }

    public BigDecimal getGlNo()
    {
	return glNo;
    }

    public void setGlNo(BigDecimal glNo)
    {
	this.glNo = glNo;
    }

    public String getSignatureTp()
    {
	return signatureTp;
    }

    public void setSignatureTp(String signatureTp)
    {
	this.signatureTp = signatureTp;
    }

    public void setReadOnly(boolean readOnly)
    {
	this.readOnly = readOnly;
    }

    public boolean isReadOnly()
    {
	return readOnly;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setDocType(String docType)
    {
	this.docType = docType;
    }

    public String getDocType()
    {
	return docType;
    }

    public void setJointAccNo(String jointAccNo)
    {
	this.jointAccNo = jointAccNo;
    }

    public String getJointAccNo()
    {
	return jointAccNo;
    }

    public void setProgram(String program)
    {
	this.program = program;
    }

    public String getProgram()
    {
	return program;
    }

    public void setTrxType(int trxType)
    {
	this.trxType = trxType;
    }

    public int getTrxType()
    {
	return trxType;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public String getFlag()
    {
	return flag;
    }

    public String getParentIvCrud()
    {
	return parentIvCrud;
    }

    public void setParentIvCrud(String parentIvCrud)
    {
	this.parentIvCrud = parentIvCrud;
    }

    @Override
    public Object clone()
    {
	try
	{
	    return super.clone();
	}
	catch(CloneNotSupportedException e)
	{
	    InternalError err = new InternalError();
	    err.initCause(e);
	    throw err;
	}
    }

    public boolean isShowAcceptCancelBtns()
    {
	return showAcceptCancelBtns;
    }

    public void setShowAcceptCancelBtns(boolean showAcceptCancelBtns)
    {
	this.showAcceptCancelBtns = showAcceptCancelBtns;
    }

    public String getGroupIds()
    {
	return groupIds;
    }

    public void setGroupIds(String groupIds)
    {
	this.groupIds = groupIds;
    }

    public BigDecimal getSignViewMand()
    {
	return signViewMand;
    }

    public void setSignViewMand(BigDecimal signViewMand)
    {
	this.signViewMand = signViewMand;
    }

    public String getViewSelectedSignMessage()
    {
	return viewSelectedSignMessage;
    }

    public void setViewSelectedSignMessage(String viewSelectedSignMessage)
    {
	this.viewSelectedSignMessage = viewSelectedSignMessage;
    }

    public String getExpiryDateRequired()
    {
	return expiryDateRequired;
    }

    public void setExpiryDateRequired(String expiryDateRequired)
    {
	this.expiryDateRequired = expiryDateRequired;
    }

    public Boolean getCopySignTabVisible()
    {
	return copySignTabVisible;
    }

    public void setCopySignTabVisible(Boolean copySignTabVisible)
    {
	this.copySignTabVisible = copySignTabVisible;
    }

    public String getScreenName()
    {
	return screenName;
    }

    public void setScreenName(String screenName)
    {
	this.screenName = screenName;
    }

    public boolean isHideAcceptCancelInAlert()
    {
        return hideAcceptCancelInAlert;
    }

    public void setHideAcceptCancelInAlert(boolean hideAcceptCancelInAlert)
    {
        this.hideAcceptCancelInAlert = hideAcceptCancelInAlert;
    }

    public String getProfType()
    {
        return profType;
    }

    public void setProfType(String profType)
    {
        this.profType = profType;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public String getIsAsaanAcc()
    {
        return isAsaanAcc;
    }

    public void setIsAsaanAcc(String isAsaanAcc)
    {
        this.isAsaanAcc = isAsaanAcc;
    }
    
    public String getGridRowId()
    {
        return gridRowId;
    }

    public void setGridRowId(String gridRowId)
    {
        this.gridRowId = gridRowId;
    }

    public boolean isNoWarningMsg()
    {
        return noWarningMsg;
    }

    public void setNoWarningMsg(boolean noWarningMsg)
    {
        this.noWarningMsg = noWarningMsg;
    }

    public BigDecimal getCountryID()
    {
        return countryID;
    }

    public void setCountryID(BigDecimal countryID)
    {
        this.countryID = countryID;
    }
    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public String getTrsType()
    {
        return trsType;
    }

    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    public String getCbInd()
    {
        return cbInd;
    }

    public void setCbInd(String cbInd)
    {
        this.cbInd = cbInd;
    }

    public String getTrsStatus()
    {
        return trsStatus;
    }

    public void setTrsStatus(String trsStatus)
    {
        this.trsStatus = trsStatus;
    }

    public String getSignCIFDesc()
    {
        return signCIFDesc;
    }

    public void setSignCIFDesc(String signCIFDesc)
    {
        this.signCIFDesc = signCIFDesc;
    }

    public String getValidationDateStr()
    {
        return validationDateStr;
    }

    public void setValidationDateStr(String validationDateStr)
    {
        this.validationDateStr = validationDateStr;
    }

    public final String getExcludedStatuses()
    {
        return excludedStatuses;
    }

    public final void setExcludedStatuses(String excludedStatuses)
    {
        this.excludedStatuses = excludedStatuses;
    }


}