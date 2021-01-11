package com.path.vo.common.cifproduct;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIF_ACC_DETVO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.CTSCHEQUEGLCYVOKey;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

 public class CifProductsCO extends  RetailBaseVO
 {
    private CIF_ACC_DETVO cifProductsVO = new CIF_ACC_DETVO();
    private String chequeTypeDesc;
    private String billsTypeDesc;
    private String cardTypeDesc;
    private String affectCard;
    private String affectPassbook;
    private String affectChequeBook;
    private String affectBills;
    private String AFFECT_CHEQUE_BILL_LIST;
    private String passBookDesc;
    // ADDED BY JIHAD
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private BigDecimal branchCode;

    // For check Box on screen
    private Boolean issueChkBkFlag;
    private Boolean issueCardFlag;
    private Boolean issuePsBkFlag;
    private Boolean issueBillsFlag;

    private String saveType;
    private String cifStatus;
    private String iv_crud;
    private String appName;
    private String preferredLanguage;
    private Date cif_UpdateDate;

    private int rifatdCount;
    private int refatdCyCount;
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private BigDecimal cifType;
    private RIFATTVO rifAttVO = new RIFATTVO();
    private CTSCARDSVO ctsCardsVO = new CTSCARDSVO();
    private CTSCHEQUEGLCYVOKey ctsChequeGlCyVo = new CTSCHEQUEGLCYVOKey();
    private CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
    private BigDecimal cifTypeCode;

    private Boolean accesByTeller = true;
    private String fromScreen;
    // EWBI160091 (403157)- Modification of CIF
    private BigDecimal compCodeCif;
	
    // used for webservice
    private String deleteCifProduct;
	

    private String statusReasonDesc;

    public CIFCONTROLVO getCifControlVO()
    {
	return cifControlVO;
    }

    public void setCifControlVO(CIFCONTROLVO cifControlVO)
    {
	this.cifControlVO = cifControlVO;
    }

    public RIFATTVO getRifAttVO()
    {
	return rifAttVO;
    }

    public void setRifAttVO(RIFATTVO rifAttVO)
    {
	this.rifAttVO = rifAttVO;
    }

    public CTSCARDSVO getCtsCardsVO()
    {
	return ctsCardsVO;
    }

    public void setCtsCardsVO(CTSCARDSVO ctsCardsVO)
    {
	this.ctsCardsVO = ctsCardsVO;
    }

    public CTSCHEQUEGLCYVOKey getCtsChequeGlCyVo()
    {
	return ctsChequeGlCyVo;
    }

    public void setCtsChequeGlCyVo(CTSCHEQUEGLCYVOKey ctsChequeGlCyVo)
    {
	this.ctsChequeGlCyVo = ctsChequeGlCyVo;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
	return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
	this.buisnessElement = buisnessElement;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public int getRifatdCount()
    {
	return rifatdCount;
    }

    public void setRifatdCount(int rifatdCount)
    {
	this.rifatdCount = rifatdCount;
    }

    public int getRefatdCyCount()
    {
	return refatdCyCount;
    }

    public void setRefatdCyCount(int refatdCyCount)
    {
	this.refatdCyCount = refatdCyCount;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public CIF_ACC_DETVO getCifProductsVO()
    {
	return cifProductsVO;
    }

    public void setCifProductsVO(CIF_ACC_DETVO cifProductsVO)
    {
	this.cifProductsVO = cifProductsVO;
    }

    public String getChequeTypeDesc()
    {
	return chequeTypeDesc;
    }

    public void setChequeTypeDesc(String chequeTypeDesc)
    {
	this.chequeTypeDesc = chequeTypeDesc;
    }

    public String getCardTypeDesc()
    {
	return cardTypeDesc;
    }

    public void setCardTypeDesc(String cardTypeDesc)
    {
	this.cardTypeDesc = cardTypeDesc;
    }

    public String getPassBookDesc()
    {
	return passBookDesc;
    }

    public void setPassBookDesc(String passBookDesc)
    {
	this.passBookDesc = passBookDesc;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public Boolean getIssueChkBkFlag()
    {
	return issueChkBkFlag;
    }

    public void setIssueChkBkFlag(Boolean issueChkBkFlag)
    {
	this.issueChkBkFlag = issueChkBkFlag;
    }

    public Boolean getIssueCardFlag()
    {
	return issueCardFlag;
    }

    public void setIssueCardFlag(Boolean issueCardFlag)
    {
	this.issueCardFlag = issueCardFlag;
    }

    public Boolean getIssuePsBkFlag()
    {
	return issuePsBkFlag;
    }

    public void setIssuePsBkFlag(Boolean issuePsBkFlag)
    {
	this.issuePsBkFlag = issuePsBkFlag;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public String getFromScreen()
    {
	return fromScreen;
    }

    public void setFromScreen(String fromScreen)
    {
	this.fromScreen = fromScreen;
    }

    public String getAffectCard()
    {
	return affectCard;
    }

    public void setAffectCard(String affectCard)
    {
	this.affectCard = affectCard;
    }

    public String getAffectPassbook()
    {
	return affectPassbook;
    }

    public void setAffectPassbook(String affectPassbook)
    {
	this.affectPassbook = affectPassbook;
    }

    public String getAffectChequeBook()
    {
	return affectChequeBook;
    }

    public void setAffectChequeBook(String affectChequeBook)
    {
	this.affectChequeBook = affectChequeBook;
    }

    public String getDeleteCifProduct()
    {
	return deleteCifProduct;
    }

    public void setDeleteCifProduct(String deleteCifProduct)
    {
	this.deleteCifProduct = deleteCifProduct;
    }
    
    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public String getAffectBills()
    {
	return affectBills;
    }

    public void setAffectBills(String affectBills)
    {
	this.affectBills = affectBills;
    }

    public String getBillsTypeDesc()
    {
	return billsTypeDesc;
    }

    public void setBillsTypeDesc(String billsTypeDesc)
    {
	this.billsTypeDesc = billsTypeDesc;
    }

    public String getAFFECT_CHEQUE_BILL_LIST()
    {
	return AFFECT_CHEQUE_BILL_LIST;
    }

    public void setAFFECT_CHEQUE_BILL_LIST(String AFFECT_CHEQUE_BILL_LIST)
    {
	this.AFFECT_CHEQUE_BILL_LIST = AFFECT_CHEQUE_BILL_LIST;
    }

    public Boolean getIssueBillsFlag()
    {
	return issueBillsFlag;
    }

    public void setIssueBillsFlag(Boolean issueBillsFlag)
    {
	this.issueBillsFlag = issueBillsFlag;
    }

    public String getStatusReasonDesc()
    {
	return statusReasonDesc;
    }

    public void setStatusReasonDesc(String statusReasonDesc)
    {
	this.statusReasonDesc = statusReasonDesc;
    }

}
