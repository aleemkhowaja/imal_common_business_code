package com.path.vo.common.signature;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.path.dbmaps.vo.CIFOBJECTVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import java.util.ArrayList;
import com.path.dbmaps.vo.S_OBJECTVO;
import com.path.dbmaps.vo.S_SCANVO;
import com.path.dbmaps.vo.S_SIGN_ANNVO;
import com.path.dbmaps.vo.S_SIGN_MODIFVO;
import com.path.lib.vo.BaseVO;

public class SignatureCO extends BaseVO
{
    private CURRENCIESVO currenciesVO;
    private CIFOBJECTVO cifObjectVO=new CIFOBJECTVO();
    private S_SCANVO scanVO = new S_SCANVO();
    private S_OBJECTVO signObjectVO;
    private S_SIGN_ANNVO signatureAnnotationVO;
    private CIFVO cifVO = new CIFVO();
    
    private S_SIGN_MODIFVO signModifVO = new S_SIGN_MODIFVO();    
    private String cifStatus;
    private Date updateDate ;
    private String opt;
    private String originOpt;
    //EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;
    // EWBI160037 --[John Massaad]
    private String checked;
    private BigDecimal loginBraCode;
    private String authCifDesc;
    private String preferredLanguage;
    private BigDecimal compCode;
    private String checkedSignaturesGridUpdates;
    private ArrayList<SignatureCO> checkedSignaturesList = new ArrayList<SignatureCO>();
    private BigDecimal lineNo;
    //Bug 316141 -- [John Massaad] 
    private String imageName;
    private String latestupdateDate;
    //private S_SIGN_ANN_TEMP    TODO add the mapper class
    
    private String origin; //flag to distinguish between  S_SIGN_MODIF=1 or CIFObject=2 
  
    private String viewMode = "A";  //flag to check whether the screen is in edit/view/change amount mode
    
    private Boolean unlimitedFlag ;
    private String defaultUnlimitedFlag;   
    private byte[] oleObject;    
    
    private Date runningDate;
    
    private String userId;
    private boolean autoApprove;
    private String editType;	//Edit type flag for identifying full edit /change amount only the SIGNATURE_CHANGE_AMOUNT/SIGNATURE_EDIT_ALL

    private String signFileType;
    
    private String currencyDesc;
    private String signatureTp;
    

    //Return Flag Parameters
    private Boolean signatureSchemaModified;
    private Boolean signatureSchemaApproved;
    private Boolean signatureSchemaRejected;
    private String signatureActionsPerformed;
    private Boolean signatureAdded;
    private Map<String, String> signatureActionsPerformedMap = new HashMap<String, String>(); 
    private String screenName;// to identify the screen from were the page is called(added because this page is common across application)

    
    private BigDecimal originObjectCode;
	private BigDecimal originObjectSeq;
	
	private boolean fetchImg;
	
	private boolean readOnly;
	
	private String statusDesc;
	private String toBeStatusDesc;
	
	private  String instructionsDesc;
	
	private  String idTypeDesc;
	
	private String level;
	private String parent;
	private String isLeaf;
	
	private String accNoAndDesc;
	
	private String index;
	
	private boolean defaultPhoto;
	
	private String onlyStatus;
	
	//flag used to check whether the sign has been viewed or not
	private boolean signViewed;
	
	private BigDecimal currDecPoints;
 
	private String ADDITIONAL_REFERENCE;// used for signature service
	private String IBAN_ACC_NO;	// used for signature service	
	
    // EWBI160037 --[John Massaad]
    private Date validationDate;

    // #573892-EWB170023-Modification CIF: Manque l audit de l utilisateur
    // modificateur
    private String setSignAuditTrxNbr;

    private String fromCopySignature;
    private boolean idDefaulted;
    
	public BigDecimal getCurrDecPoints() {
		return currDecPoints;
	}

	public void setCurrDecPoints(BigDecimal currDecPoints) {
		this.currDecPoints = currDecPoints;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getToBeStatusDesc() {
		return toBeStatusDesc;
	}

	public void setToBeStatusDesc(String toBeStatusDesc) {
		this.toBeStatusDesc = toBeStatusDesc;
	}
    
    public BigDecimal getOriginObjectCode() {
		return originObjectCode;
	}

	public void setOriginObjectCode(BigDecimal originObjectCode) {
		this.originObjectCode = originObjectCode;
	}

	public BigDecimal getOriginObjectSeq() {
		return originObjectSeq;
	}

	public void setOriginObjectSeq(BigDecimal originObjectSeq) {
		this.originObjectSeq = originObjectSeq;
	}

    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //byte[] image;
    //Integer showAnn;
   // Integer viewedAnn;
   // Integer checked;
    //Integer viewed;
   
   // String used = "Y";
    
    public boolean isCIFObject() {
		return "2".equals(origin);
	}
	 
	public CURRENCIESVO getCurrenciesVO()
    {
        return currenciesVO;
    }
    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
        this.currenciesVO = currenciesVO;
    }
    public CIFOBJECTVO getCifObjectVO()
    {
        return cifObjectVO;
    }
    public void setCifObjectVO(CIFOBJECTVO cifObjectVO)
    {
        this.cifObjectVO = cifObjectVO;
    }
    public S_SIGN_MODIFVO getSignModifVO()
    {
        return signModifVO;
    }
    public void setSignModifVO(S_SIGN_MODIFVO signModifVO)
    {
        this.signModifVO = signModifVO;
    }
    public String getOrigin()
    {
        return origin;
    }
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
/*    public byte[] getImage()
    {
        return image;
    }
    public void setImage(byte[] image)
    {
	this.image = image;
    }*/
   
	public String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
	/*public Integer getShowAnn() {
		return showAnn;
	}
	public void setShowAnn(Integer showAnn) {
		this.showAnn = showAnn;
	}
	public Integer getViewedAnn() {
		return viewedAnn;
	}
	public void setViewedAnn(Integer viewedAnn) {
		this.viewedAnn = viewedAnn;
	}
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	public Integer getViewed() {
		return viewed;
	}
	public void setViewed(Integer viewed) {
		this.viewed = viewed;
	}*/
	/*public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}*/
	public void setViewMode(String viewMode) {
		this.viewMode = viewMode;
	}
	public String getViewMode() {
		return viewMode;
	}
	public S_SCANVO getScanVO() {
		return scanVO;
	}
	public void setScanVO(S_SCANVO scanVO) {
		this.scanVO = scanVO;
	}
	public Boolean getUnlimitedFlag() {
		return unlimitedFlag;
	}
	public void setUnlimitedFlag(Boolean unlimitedFlag) {
		this.unlimitedFlag = unlimitedFlag;
	}
	public String getDefaultUnlimitedFlag() {
		return defaultUnlimitedFlag;
	}
	public void setDefaultUnlimitedFlag(String defaultUnlimitedFlag) {
		this.defaultUnlimitedFlag = defaultUnlimitedFlag;
	}	 
	public byte[] getOleObject() {
		return oleObject;
	}
	public void setOleObject(byte[] oleObject) {
		this.oleObject = oleObject;
	}
	public Date getRunningDate() {
		return runningDate;
	}
	public void setRunningDate(Date runningDate) {
		this.runningDate = runningDate;
	}
	public S_SIGN_ANNVO getSignatureAnnotationVO() {
		return signatureAnnotationVO;
	}
	public void setSignatureAnnotationVO(S_SIGN_ANNVO signatureAnnotationVO) {
		this.signatureAnnotationVO = signatureAnnotationVO;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isAutoApprove() {
		return autoApprove;
	}
	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public S_OBJECTVO getSignObjectVO() {
		return signObjectVO;
	}
	public void setSignObjectVO(S_OBJECTVO signObjectVO) {
		this.signObjectVO = signObjectVO;
	}
	public void setSignFileType(String signFileType) {
		this.signFileType = signFileType;
	}
	public String getSignFileType() {
		return signFileType;
	}

	public void setSignatureTp(String signatureTp) {
		this.signatureTp = signatureTp;
	}

	public String getSignatureTp() {
		return signatureTp;
	}

	public void setFetchImg(boolean fetchImg) {
		this.fetchImg = fetchImg;
	}

	public boolean isFetchImg() {
		return fetchImg;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public void setAccNoAndDesc(String accNoAndDesc) {
		this.accNoAndDesc = accNoAndDesc;
	}

	public String getAccNoAndDesc() {
		return accNoAndDesc;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIndex() {
		return index;
	}

	public void setDefaultPhoto(boolean defaultPhoto) {
		this.defaultPhoto = defaultPhoto;
	}

	public boolean isDefaultPhoto() {
		return defaultPhoto;
	}

	public String getOnlyStatus() {
		return onlyStatus;
	}

	public void setOnlyStatus(String onlyStatus) {
		this.onlyStatus = onlyStatus;
	}

	public Boolean getSignatureSchemaModified()
	{
	    return signatureSchemaModified;
	}

	public void setSignatureSchemaModified(Boolean signatureSchemaModified)
	{
	    this.signatureSchemaModified = signatureSchemaModified;
	}

	public Boolean getSignatureSchemaApproved()
	{
	    return signatureSchemaApproved;
	}

	public void setSignatureSchemaApproved(Boolean signatureSchemaApproved)
	{
	    this.signatureSchemaApproved = signatureSchemaApproved;
	}

	public Boolean getSignatureSchemaRejected()
	{
	    return signatureSchemaRejected;
	}

	public void setSignatureSchemaRejected(Boolean signatureSchemaRejected)
	{
	    this.signatureSchemaRejected = signatureSchemaRejected;
	}

	public String getSignatureActionsPerformed()
	{
	    return signatureActionsPerformed;
	}

	public void setSignatureActionsPerformed(String signatureActionsPerformed)
	{
	    this.signatureActionsPerformed = signatureActionsPerformed;
	}

	public Boolean getSignatureAdded()
	{
	    return signatureAdded;
	}

	public void setSignatureAdded(Boolean signatureAdded)
	{
	    this.signatureAdded = signatureAdded;
	}

	public Map<String, String> getSignatureActionsPerformedMap()
	{
	    return signatureActionsPerformedMap;
	}

	public void setSignatureActionsPerformedMap(Map<String, String> signatureActionsPerformedMap)
	{
	    this.signatureActionsPerformedMap = signatureActionsPerformedMap;
	}

	public boolean isSignViewed() {
		return signViewed;
	}

	public void setSignViewed(boolean signViewed) {
		this.signViewed = signViewed;
	}

	public String getScreenName()
	{
	    return screenName;
	}

	public void setScreenName(String screenName)
	{
	    this.screenName = screenName;
	}

	public String getCifStatus()
	{
	    return cifStatus;
	}

	public void setCifStatus(String cifStatus)
	{
	    this.cifStatus = cifStatus;
	}

	public Date getUpdateDate()
	{
	    return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
	    this.updateDate = updateDate;
	}

	/**
	 * @return the opt
	 */
	public String getOpt()
	{
	    return opt;
	}

	/**
	 * @param opt the opt to set
	 */
	public void setOpt(String opt)
	{
	    this.opt = opt;
	}

	/**
	 * @return the originOpt
	 */
	public String getOriginOpt()
	{
	    return originOpt;
	}

	/**
	 * @param originOpt the originOpt to set
	 */
	public void setOriginOpt(String originOpt)
	{
	    this.originOpt = originOpt;
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
	 * @return the latestupdateDate
	 */
	public String getLatestupdateDate()
	{
	    return latestupdateDate;
	}

	/**
	 * @param latestupdateDate the latestupdateDate to set
	 */
	public void setLatestupdateDate(String latestupdateDate)
	{
	    this.latestupdateDate = latestupdateDate;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName()
	{
	    return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName)
	{
	    this.imageName = imageName;
	}

	public String getInstructionsDesc()
	{
	    return instructionsDesc;
	}

	public void setInstructionsDesc(String instructionsDesc)
	{
	    this.instructionsDesc = instructionsDesc;
	}
	
	public String getIdTypeDesc()
	{
	    return idTypeDesc;
	}

	public void setIdTypeDesc(String idTypeDesc)
	{
	    this.idTypeDesc = idTypeDesc;
	}	

	public String getADDITIONAL_REFERENCE()
	{
	    return ADDITIONAL_REFERENCE;
	}

	public void setADDITIONAL_REFERENCE(String aDDITIONAL_REFERENCE)
	{
	    ADDITIONAL_REFERENCE = aDDITIONAL_REFERENCE;
	}

	public String getIBAN_ACC_NO()
	{
	    return IBAN_ACC_NO;
	}

	public void setIBAN_ACC_NO(String iBAN_ACC_NO)
	{
	    IBAN_ACC_NO = iBAN_ACC_NO;
	}

	public Date getValidationDate()
	{
	    return validationDate;
	}

	public void setValidationDate(Date validationDate)
	{
	    this.validationDate = validationDate;
	}

	public String getSetSignAuditTrxNbr()
	{
	    return setSignAuditTrxNbr;
	}

	public void setSetSignAuditTrxNbr(String setSignAuditTrxNbr)
	{
	    this.setSignAuditTrxNbr = setSignAuditTrxNbr;
	}

	public String getFromCopySignature()
	{
	    return fromCopySignature;
	}

	public void setFromCopySignature(String fromCopySignature)
	{
	    this.fromCopySignature = fromCopySignature;
	}

	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}

	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}

	public String getChecked()
	{
	    return checked;
	}

	public void setChecked(String checked)
	{
	    this.checked = checked;
	}

	public BigDecimal getLoginBraCode()
	{
	    return loginBraCode;
	}

	public void setLoginBraCode(BigDecimal loginBraCode)
	{
	    this.loginBraCode = loginBraCode;
	}

	public String getAuthCifDesc()
	{
	    return authCifDesc;
	}

	public void setAuthCifDesc(String authCifDesc)
	{
	    this.authCifDesc = authCifDesc;
	}

	public String getPreferredLanguage()
	{
	    return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage)
	{
	    this.preferredLanguage = preferredLanguage;
	}

	public BigDecimal getCompCode()
	{
	    return compCode;
	}

	public void setCompCode(BigDecimal compCode)
	{
	    this.compCode = compCode;
	}

	public String getCheckedSignaturesGridUpdates()
	{
	    return checkedSignaturesGridUpdates;
	}

	public void setCheckedSignaturesGridUpdates(String checkedSignaturesGridUpdates)
	{
	    this.checkedSignaturesGridUpdates = checkedSignaturesGridUpdates;
	}

	public ArrayList<SignatureCO> getCheckedSignaturesList()
	{
	    return checkedSignaturesList;
	}

	public void setCheckedSignaturesList(ArrayList<SignatureCO> checkedSignaturesList)
	{
	    this.checkedSignaturesList = checkedSignaturesList;
	}

	public BigDecimal getLineNo()
	{
	    return lineNo;
	}

	public void setLineNo(BigDecimal lineNo)
	{
	    this.lineNo = lineNo;
	}

	public boolean isIdDefaulted()
	{
	    return idDefaulted;
	}

	public void setIdDefaulted(boolean idDefaulted)
	{
	    this.idDefaulted = idDefaulted;
	}

/*	public String getAccNo() {
		return NumberUtil.addLeadingZeros(cifObjectVO.getCOMP_CODE(), 4).concat("-")
		.concat(NumberUtil.addLeadingZeros(cifObjectVO.getBRANCH_CODE(), 4)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_CY(), 3)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_GL(), 6)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_CIF(), 8)).concat("-")
	.concat(NumberUtil.addLeadingZeros(cifObjectVO.getACC_SL(), 3));
		 
	}*/

	

} 