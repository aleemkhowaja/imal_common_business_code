package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class AccountsDefaultCO extends BaseVO {

	private BigDecimal ALLOWED_CURRENCY;//ALLOWED_CURRENCY from RIFATD
	private BigDecimal ALLOWED_CURRENCY_COUNT;//ALLOWED_CURRENCY_COUNT from RIFATD
	private BigDecimal maturityGl;//accountTypeNewOffInstr_${_pageRef}
	private BigDecimal maturityDays;//
	private BigDecimal COMP_CODE;//COMP_CODE from RIFATT
	private BigDecimal TYPE_CODE;//TYPE_CODE from RIFATT
	private BigDecimal SERIAL_NO;//
	private BigDecimal SEQ_NO;//
	private BigDecimal TERM_DAYS;//TERM_DAYS from RIFATT
	
	
	private BigDecimal CUR_AC_CY;//accCyOI  : Transfer_To_The_Following_Account_key from Accounts Instructions Tab 
	private BigDecimal CUR_AC_GL;//accGlOI	: Transfer_To_The_Following_Account_key from Accounts Instructions Tab 
	private BigDecimal CUR_AC_SL;//accSlOI	: Transfer_To_The_Following_Account_key from Accounts Instructions Tab 
	
	private BigDecimal FD_ACC_BR;//FD_ACC_BR from RIFATT
	private BigDecimal FD_ACC_CY;//FD_ACC_CY from RIFATT
	private BigDecimal FD_ACC_GL;//FD_ACC_GL from RIFATT
	private BigDecimal FD_ACC_CIF;//FD_ACC_CIF from RIFATT
	private BigDecimal FD_ACC_SL;//FD_ACC_SL from RIFATT
	
	private BigDecimal CR_PT_RATE;//CR_PT_RATE from AMF
	private BigDecimal trf_br;//accBrMI_${_pageRef} :Accounts Instructions Tab: Maturity Instructions: Transfer to the following A/C
	private BigDecimal trf_cy;//accCyMI_${_pageRef} :Accounts Instructions Tab: Maturity Instructions: Transfer to the following A/C
	private BigDecimal trf_gl;//accGlMI_${_pageRef} :Accounts Instructions Tab: Maturity Instructions: Transfer to the following A/C
	private BigDecimal trf_cif;//accCifMI_${_pageRef} :Accounts Instructions Tab: Maturity Instructions: Transfer to the following A/C
	private BigDecimal trf_sl;//accSlMI_${_pageRef} :Accounts Instructions Tab: Maturity Instructions: Transfer to the following A/C
	private BigDecimal facilityAmount;//facilityAmount_${_pageRef} : fl_amt
	private BigDecimal OFFEND_GL;// OFFEND_GL from RIFATT
	private BigDecimal NEW_GL;//new_gl from AMFVO : accountTypeNewOffInstr_${_pageRef}
	private BigDecimal OPEN_DEP_AMOUNT;//OPEN_DEP_AMOUNT from AMFVO : amount_${_pageRef}
	private BigDecimal CV_AVAIL_BAL;//CV_AVAIL_BAL from AMFVO TODO Need to fetch while choosing the cif in main screen and SET this in a HIDDEN
	private BigDecimal DR_PT_RATE;//DR_PT_RATE from AMF
	private BigDecimal FC_AVAIL_BAL;//CV_AVAIL_BAL from AMFVO TODO Need to fetch while choosing the cif in main screen and SET this in a HIDDEN
	private BigDecimal APPLICABLE_DAYS;//APPLICABLE_DAYS from RIFATTVO
	private BigDecimal AMOUNT;//AMOUNT from RIFATD
	private BigDecimal TRX_TYPE;//TRX_TYPE from RIFATDVO
	private BigDecimal HOLD_TRX_TYPE;//HOLD_TRX_TYPE 
	private BigDecimal HOLD_AMOUNT;//HOLD_AMOUNT 
	private BigDecimal RMSIA_FIRST_MAT_PERIOD;//RMSIA_FIRST_MAT_PERIOD from RIFATTVO
	private BigDecimal DET_IND;//DET_IND from RIFATDVO
	
	private BigDecimal LIBOR;//LIBOR from PFT_RATEVO
	private BigDecimal LIBOR_MIN;//LIBOR_MIN from PFT_RATEVO
	private BigDecimal LIBOR_MAX;//LIBOR_MAX from PFT_RATEVO
	private BigDecimal PT_RATE;//PT_RATE from PFT_RATEVO
	private BigDecimal CIF_TYPE;//CIF_TYPE from PFT_RATEVO
	private BigDecimal RATE;//RATE max from PFT_RATEVO
	
	private BigDecimal ADVANCE_PERC;//ADVANCE_PERC from PFT_ADVANCE_DET
	private BigDecimal DEDUCTION_PERIODICITY;//DEDUCTION_PERIODICITY from PFT_ADVANCE_DET
	private BigDecimal TAX_RATE_CAP_REV;//TAX_RATE_CAP_REV from AMF_EXTENDED
	private BigDecimal CIF_SUB_NO;//CIF_SUB_NO 
	private BigDecimal BRANCH_CODE;//BRANCH_CODE
	private BigDecimal RIFATD_COUNT;//RIFATD_COUNT
	private BigDecimal CURRENCY_AVAILABLE;//CURRENCY_AVAILABLE
	private BigDecimal AUTO_SWEEP_GL;
	
	private String BRIEF_DESC_GL;//BRIEF_DESC_ENGfrom GEN_LEDGER
	private String LONG_DESC_GL;//LONG_DESC_ENG from GEN_LEDGER
	private String BRIEF_DESC_GL_AR;// BRIEF_DESC_ARABfrom GEN_LEDGER
	private String LONG_DESC_GL_AR;//LONG_DESC_ARAB from GEN_LEDGER
	private String BRIEF_DESC_CY;//BRIEF_DESC_ENG/ BRIEF_DESC_ARABfrom CURRENCIES
	private String LONG_DESC_CY;//LONG_DESC_ENG/LONG_DESC_ARAB from CURRENCIES
	private String RMSIA_FLAG;//RMSIA_FLAG from RIFATT
	private String AC_SIGN;//AC_SIGN from GEN_LEDGER
	private String PT_IND;//PT_IND from GEN_LEDGER
	private String ALLOW_CHANGE_DIST_PER;//ALLOW_CHANGE_DIST_PER from RIFATT
	private String MATURED_CALCULATION;//MATURED_CALCULATION from RIFATT
	private String AFFECTION;//AFFECTION from RIFATT
	private String AFFECT_CHEQUE_BILL_LIST;//AFFECTION from RIFATT
	private String BS_CONTRA;//BS_CONTRA from GEN_LEDGER
	private String MAIL_ADVISE;//MAIL_ADVISE from AMFVO
	private String MAIL_STMT;//PRINT_ST from GEN_LEDGER
	private String STMT_PERIOD;//STMT_PERIOD from RIFATT
	private String AUTO_RENEW;//AUTO_RENEW from RIFATT
	private String renewAccount;//renewAccount_${_pageRef}
	private String ALLOW_OTHER_CIF;//ALLOW_OTHER_CIF from RIFATT
	private String PFT_POST_TO;//PFT_POST_TO --Accounts Instructions Tab -- postProfitTo_${_pageRef}
	private String curAccName;//accDescOI	: Transfer_To_The_Following_Account_key from Accounts Instructions Tab 
	private String trf_accName;//accDescMI_${_pageRef} :Accounts Instructions Tab: Maturity Instructions: Transfer to the following A/C
	private String curAccAddRef;//accAddRefMI_${_pageRef} :Accounts Instructions Tab: Maturity Instructions: Transfer to the following A/C
	private String vipAlert;//vipAlert in main section b/w main grid and tabs of account screen TODO need to place the control
	private String ADDITIONAL_REFERENCE;//reference_${_pageRef}: in main section b/w main grid and tabs of account screen
	private String newEditMode;//R for Editing and N for new Record
	private String facilityIndicator;//facilityIndicator_${_pageRef}: fl_ind
	private String DEFAULT_OFFEND_INST;//DEFAULT_OFFEND_INST from RIFATT
	private String STATUS;//STATUS from AMFVO : status_${_pageRef}
	private String DR_PT_INDEX;//DR_PT_INDEX from AMF
	private String CR_PT_INDEX;//CR_PT_INDEX from AMF
	private String PT_INDEX;//PT_INDEX from PFT_RATEVO
	private String DEDUCT_ZAKAT_FR;//DEDUCT_ZAKAT_FR from RIFATT
	private String ZAKAT_APPLIED;//ZAKAT_APPLIED from RIFATT
	private String RENEW_PROTECT;//RENEW_PROTECT from RIFATT
	private String MODIF_POINTS_DETAILS;//MODIF_POINTS_DETAILS from RIFATT
	private String ALTER_AFFECT_FLAG;//ALTER_AFFECT_FLAG from ALTER_AFFECT_FLAG
	private String DEFAULT_PT_PERIOD;//DEFAULT_PT_PERIOD from RIFATT
	private String TERM_IND;//TERM_IND from RIFATT
	private String RMSIA_FIRST_MAT;//RMSIA_FIRST_MAT from RIFATT
	private String ALLOW_CHANGE_CIF;
	
	private String ADVANCE_PROFIT;//ADVANCE_PROFIT from PFT_ADVANCE_DET
	private String DEDUCTION_METHOD;//DEDUCTION_METHOD from PFT_ADVANCE_DET
	private String EDIT_ADVPROFIT_IN_ACCLEVEL_YN;//EDIT_ADVPROFIT_IN_ACCLEVEL_YN from PFT_ADVANCE_DET
	private String APP_TAX_CAP_REV;//APP_TAX_CAP_REV from AMF_EXTENDED
	private String PROTECT_PT_PERIOD;//PROTECT_PT_PERIOD  from RIFATT
	private String MODIFY_PSR_CUSTOMER;//MODIFY_PSR_CUSTOMER  from RIFATT
	private String ALLOW_CHANGE_HOLD_AMOUNT;//ALLOW_CHANGE_HOLD_AMOUNT from RIFATD
	private String ALLOW_MODIFY_CIF_PROFIT_ACC;//ALLOW_MODIFY_CIF_PROFIT_ACC  from RIFATT
	private String GL_CATEGORY;
	private String CATEGORY;
	private String DR_CR_IDX;
	private String AUTO_SWEEP;
	
	private Boolean createNewAccountFlag;//new_ind
	private Boolean affectPassbookFlag;//affectPassbook_${_pageRef} from Accounts Instructions Tab
	private Boolean affectBillsFlag;//affectBills_${_pageRef} from Accounts Instructions Tab
	
	
	private Date lastPostDate;//last_post_date /ld_distribution_date
	private Date maturityDate;//
	private Date finalMaturityDate;//
	private Date CR_APPL_DATE;//CR_APPL_DATE from AMFVO
	private Date DR_APPL_DATE;//DR_APPL_DATE from AMF
	private BigDecimal minOpeningBalance;
	
	public BigDecimal getALLOWED_CURRENCY() {
		return ALLOWED_CURRENCY;
	}

	public void setALLOWED_CURRENCY(BigDecimal aLLOWEDCURRENCY) {
		ALLOWED_CURRENCY = aLLOWEDCURRENCY;
	}

	public BigDecimal getALLOWED_CURRENCY_COUNT() {
		return ALLOWED_CURRENCY_COUNT;
	}

	public void setALLOWED_CURRENCY_COUNT(BigDecimal aLLOWEDCURRENCYCOUNT) {
		ALLOWED_CURRENCY_COUNT = aLLOWEDCURRENCYCOUNT;
	}

	public String getRMSIA_FLAG() {
		return RMSIA_FLAG;
	}

	public void setRMSIA_FLAG(String rMSIAFLAG) {
		RMSIA_FLAG = rMSIAFLAG;
	}

	public String getBRIEF_DESC_GL() {
		return BRIEF_DESC_GL;
	}

	public void setBRIEF_DESC_GL(String bRIEFDESCGL) {
		BRIEF_DESC_GL = bRIEFDESCGL;
	}

	public String getAC_SIGN() {
		return AC_SIGN;
	}

	public void setAC_SIGN(String aCSIGN) {
		AC_SIGN = aCSIGN;
	}

	public String getPT_IND() {
		return PT_IND;
	}

	public void setPT_IND(String pTIND) {
		PT_IND = pTIND;
	}

	public String getALLOW_CHANGE_DIST_PER() {
		return ALLOW_CHANGE_DIST_PER;
	}

	public void setALLOW_CHANGE_DIST_PER(String aLLOWCHANGEDISTPER) {
		ALLOW_CHANGE_DIST_PER = aLLOWCHANGEDISTPER;
	}

	public String getMATURED_CALCULATION() {
		return MATURED_CALCULATION;
	}

	public void setMATURED_CALCULATION(String mATUREDCALCULATION) {
		MATURED_CALCULATION = mATUREDCALCULATION;
	}

	public Date getLastPostDate() {
		return lastPostDate;
	}

	public void setLastPostDate(Date lastPostDate) {
		this.lastPostDate = lastPostDate;
	}

	public String getAFFECTION() {
		return AFFECTION;
	}

	public void setAFFECTION(String aFFECTION) {
		AFFECTION = aFFECTION;
	}

	public String getBS_CONTRA() {
		return BS_CONTRA;
	}

	public void setBS_CONTRA(String bSCONTRA) {
		BS_CONTRA = bSCONTRA;
	}

	public String getMAIL_ADVISE() {
		return MAIL_ADVISE;
	}

	public void setMAIL_ADVISE(String mAILADVISE) {
		MAIL_ADVISE = mAILADVISE;
	}

	public String getMAIL_STMT() {
		return MAIL_STMT;
	}

	public void setMAIL_STMT(String mAILSTMT) {
		MAIL_STMT = mAILSTMT;
	}

	public Boolean getCreateNewAccountFlag() {
		return createNewAccountFlag;
	}

	public void setCreateNewAccountFlag(Boolean createNewAccountFlag) {
		this.createNewAccountFlag = createNewAccountFlag;
	}

	public BigDecimal getMaturityGl() {
		return maturityGl;
	}

	public void setMaturityGl(BigDecimal maturityGl) {
		this.maturityGl = maturityGl;
	}

	public BigDecimal getMaturityDays() {
		return maturityDays;
	}

	public void setMaturityDays(BigDecimal maturityDays) {
		this.maturityDays = maturityDays;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getFinalMaturityDate() {
		return finalMaturityDate;
	}

	public void setFinalMaturityDate(Date finalMaturityDate) {
		this.finalMaturityDate = finalMaturityDate;
	}

	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}

	public void setCOMP_CODE(BigDecimal cOMPCODE) {
		COMP_CODE = cOMPCODE;
	}

	public BigDecimal getTYPE_CODE() {
		return TYPE_CODE;
	}

	public void setTYPE_CODE(BigDecimal tYPECODE) {
		TYPE_CODE = tYPECODE;
	}

	public String getSTMT_PERIOD() {
		return STMT_PERIOD;
	}

	public void setSTMT_PERIOD(String sTMTPERIOD) {
		STMT_PERIOD = sTMTPERIOD;
	}

	public BigDecimal getSERIAL_NO() {
		return SERIAL_NO;
	}

	public void setSERIAL_NO(BigDecimal sERIALNO) {
		SERIAL_NO = sERIALNO;
	}

	public BigDecimal getSEQ_NO() {
		return SEQ_NO;
	}

	public void setSEQ_NO(BigDecimal sEQNO) {
		SEQ_NO = sEQNO;
	}

	public String getAUTO_RENEW() {
		return AUTO_RENEW;
	}

	public void setAUTO_RENEW(String aUTORENEW) {
		AUTO_RENEW = aUTORENEW;
	}

	public String getRenewAccount() {
		return renewAccount;
	}

	public void setRenewAccount(String renewAccount) {
		this.renewAccount = renewAccount;
	}

	public String getALLOW_OTHER_CIF() {
		return ALLOW_OTHER_CIF;
	}

	public void setALLOW_OTHER_CIF(String aLLOWOTHERCIF) {
		ALLOW_OTHER_CIF = aLLOWOTHERCIF;
	}

	public String getPFT_POST_TO() {
		return PFT_POST_TO;
	}

	public void setPFT_POST_TO(String pFTPOSTTO) {
		PFT_POST_TO = pFTPOSTTO;
	}

	public BigDecimal getCUR_AC_CY() {
		return CUR_AC_CY;
	}

	public void setCUR_AC_CY(BigDecimal cURACCY) {
		CUR_AC_CY = cURACCY;
	}

	public BigDecimal getCUR_AC_GL() {
		return CUR_AC_GL;
	}

	public void setCUR_AC_GL(BigDecimal cURACGL) {
		CUR_AC_GL = cURACGL;
	}

	public BigDecimal getCUR_AC_SL() {
		return CUR_AC_SL;
	}

	public void setCUR_AC_SL(BigDecimal cURACSL) {
		CUR_AC_SL = cURACSL;
	}

	public String getCurAccName() {
		return curAccName;
	}

	public void setCurAccName(String curAccName) {
		this.curAccName = curAccName;
	}

	public BigDecimal getFD_ACC_BR() {
		return FD_ACC_BR;
	}

	public void setFD_ACC_BR(BigDecimal fDACCBR) {
		FD_ACC_BR = fDACCBR;
	}

	public BigDecimal getFD_ACC_CY() {
		return FD_ACC_CY;
	}

	public void setFD_ACC_CY(BigDecimal fDACCCY) {
		FD_ACC_CY = fDACCCY;
	}

	public BigDecimal getFD_ACC_GL() {
		return FD_ACC_GL;
	}

	public void setFD_ACC_GL(BigDecimal fDACCGL) {
		FD_ACC_GL = fDACCGL;
	}

	public BigDecimal getFD_ACC_CIF() {
		return FD_ACC_CIF;
	}

	public void setFD_ACC_CIF(BigDecimal fDACCCIF) {
		FD_ACC_CIF = fDACCCIF;
	}

	public BigDecimal getFD_ACC_SL() {
		return FD_ACC_SL;
	}

	public void setFD_ACC_SL(BigDecimal fDACCSL) {
		FD_ACC_SL = fDACCSL;
	}

	public BigDecimal getTrf_br() {
		return trf_br;
	}

	public void setTrf_br(BigDecimal trfBr) {
		trf_br = trfBr;
	}

	public BigDecimal getTrf_cy() {
		return trf_cy;
	}

	public void setTrf_cy(BigDecimal trfCy) {
		trf_cy = trfCy;
	}

	public BigDecimal getTrf_gl() {
		return trf_gl;
	}

	public void setTrf_gl(BigDecimal trfGl) {
		trf_gl = trfGl;
	}

	public BigDecimal getTrf_cif() {
		return trf_cif;
	}

	public void setTrf_cif(BigDecimal trfCif) {
		trf_cif = trfCif;
	}

	public BigDecimal getTrf_sl() {
		return trf_sl;
	}

	public void setTrf_sl(BigDecimal trfSl) {
		trf_sl = trfSl;
	}

	public String getTrf_accName() {
		return trf_accName;
	}

	public void setTrf_accName(String trfAccName) {
		trf_accName = trfAccName;
	}

	public String getCurAccAddRef() {
		return curAccAddRef;
	}

	public void setCurAccAddRef(String curAccAddRef) {
		this.curAccAddRef = curAccAddRef;
	}

	public String getVipAlert() {
		return vipAlert;
	}

	public void setVipAlert(String vipAlert) {
		this.vipAlert = vipAlert;
	}

	public String getLONG_DESC_GL() {
		return LONG_DESC_GL;
	}

	public void setLONG_DESC_GL(String lONGDESCGL) {
		LONG_DESC_GL = lONGDESCGL;
	}

	public String getBRIEF_DESC_CY() {
		return BRIEF_DESC_CY;
	}

	public void setBRIEF_DESC_CY(String bRIEFDESCCY) {
		BRIEF_DESC_CY = bRIEFDESCCY;
	}

	public String getLONG_DESC_CY() {
		return LONG_DESC_CY;
	}

	public void setLONG_DESC_CY(String lONGDESCCY) {
		LONG_DESC_CY = lONGDESCCY;
	}

	public String getADDITIONAL_REFERENCE() {
		return ADDITIONAL_REFERENCE;
	}

	public void setADDITIONAL_REFERENCE(String aDDITIONALREFERENCE) {
		ADDITIONAL_REFERENCE = aDDITIONALREFERENCE;
	}

	public String getNewEditMode() {
		return newEditMode;
	}

	public void setNewEditMode(String newEditMode) {
		this.newEditMode = newEditMode;
	}

	public Boolean getAffectPassbookFlag() {
		return affectPassbookFlag;
	}

	public void setAffectPassbookFlag(Boolean affectPassbookFlag) {
		this.affectPassbookFlag = affectPassbookFlag;
	}

	
	
	public Boolean getAffectBillsFlag()
	{
	    return affectBillsFlag;
	}

	public void setAffectBillsFlag(Boolean affectBillsFlag)
	{
	    this.affectBillsFlag = affectBillsFlag;
	}
	
	public String getFacilityIndicator() {
		return facilityIndicator;
	}

	public void setFacilityIndicator(String facilityIndicator) {
		this.facilityIndicator = facilityIndicator;
	}

	public BigDecimal getFacilityAmount() {
		return facilityAmount;
	}

	public void setFacilityAmount(BigDecimal facilityAmount) {
		this.facilityAmount = facilityAmount;
	}

	public String getDEFAULT_OFFEND_INST() {
		return DEFAULT_OFFEND_INST;
	}

	public void setDEFAULT_OFFEND_INST(String dEFAULTOFFENDINST) {
		DEFAULT_OFFEND_INST = dEFAULTOFFENDINST;
	}

	public BigDecimal getOFFEND_GL() {
		return OFFEND_GL;
	}

	public void setOFFEND_GL(BigDecimal oFFENDGL) {
		OFFEND_GL = oFFENDGL;
	}

	public BigDecimal getNEW_GL() {
		return NEW_GL;
	}

	public void setNEW_GL(BigDecimal nEWGL) {
		NEW_GL = nEWGL;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public BigDecimal getOPEN_DEP_AMOUNT() {
		return OPEN_DEP_AMOUNT;
	}

	public void setOPEN_DEP_AMOUNT(BigDecimal oPENDEPAMOUNT) {
		OPEN_DEP_AMOUNT = oPENDEPAMOUNT;
	}

	public BigDecimal getCV_AVAIL_BAL() {
		return CV_AVAIL_BAL;
	}

	public void setCV_AVAIL_BAL(BigDecimal cVAVAILBAL) {
		CV_AVAIL_BAL = cVAVAILBAL;
	}

	public BigDecimal getFC_AVAIL_BAL() {
		return FC_AVAIL_BAL;
	}

	public void setFC_AVAIL_BAL(BigDecimal fCAVAILBAL) {
		FC_AVAIL_BAL = fCAVAILBAL;
	}

	public BigDecimal getCR_PT_RATE() {
		return CR_PT_RATE;
	}

	public void setCR_PT_RATE(BigDecimal cRPTRATE) {
		CR_PT_RATE = cRPTRATE;
	}

	public String getCR_PT_INDEX() {
		return CR_PT_INDEX;
	}

	public void setCR_PT_INDEX(String cRPTINDEX) {
		CR_PT_INDEX = cRPTINDEX;
	}

	public String getDR_PT_INDEX() {
		return DR_PT_INDEX;
	}

	public void setDR_PT_INDEX(String dRPTINDEX) {
		DR_PT_INDEX = dRPTINDEX;
	}

	public BigDecimal getDR_PT_RATE() {
		return DR_PT_RATE;
	}

	public void setDR_PT_RATE(BigDecimal dRPTRATE) {
		DR_PT_RATE = dRPTRATE;
	}

	public Date getCR_APPL_DATE() {
		return CR_APPL_DATE;
	}

	public void setCR_APPL_DATE(Date cRAPPLDATE) {
		CR_APPL_DATE = cRAPPLDATE;
	}

	public Date getDR_APPL_DATE() {
		return DR_APPL_DATE;
	}

	public void setDR_APPL_DATE(Date dRAPPLDATE) {
		DR_APPL_DATE = dRAPPLDATE;
	}

	public BigDecimal getLIBOR() {
		return LIBOR;
	}

	public void setLIBOR(BigDecimal lIBOR) {
		LIBOR = lIBOR;
	}

	public BigDecimal getLIBOR_MIN() {
		return LIBOR_MIN;
	}

	public void setLIBOR_MIN(BigDecimal lIBORMIN) {
		LIBOR_MIN = lIBORMIN;
	}

	public BigDecimal getLIBOR_MAX() {
		return LIBOR_MAX;
	}

	public void setLIBOR_MAX(BigDecimal lIBORMAX) {
		LIBOR_MAX = lIBORMAX;
	}

	public BigDecimal getPT_RATE() {
		return PT_RATE;
	}

	public void setPT_RATE(BigDecimal pTRATE) {
		PT_RATE = pTRATE;
	}

	public String getPT_INDEX() {
		return PT_INDEX;
	}

	public void setPT_INDEX(String pTINDEX) {
		PT_INDEX = pTINDEX;
	}

	public BigDecimal getCIF_TYPE() {
		return CIF_TYPE;
	}

	public void setCIF_TYPE(BigDecimal cIFTYPE) {
		CIF_TYPE = cIFTYPE;
	}

	public BigDecimal getRATE() {
		return RATE;
	}

	public void setRATE(BigDecimal rATE) {
		RATE = rATE;
	}

	public BigDecimal getAPPLICABLE_DAYS() {
		return APPLICABLE_DAYS;
	}

	public void setAPPLICABLE_DAYS(BigDecimal aPPLICABLEDAYS) {
		APPLICABLE_DAYS = aPPLICABLEDAYS;
	}

	public BigDecimal getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(BigDecimal aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public BigDecimal getTRX_TYPE() {
		return TRX_TYPE;
	}

	public void setTRX_TYPE(BigDecimal tRXTYPE) {
		TRX_TYPE = tRXTYPE;
	}

	public BigDecimal getHOLD_TRX_TYPE() {
		return HOLD_TRX_TYPE;
	}

	public void setHOLD_TRX_TYPE(BigDecimal hOLDTRXTYPE) {
		HOLD_TRX_TYPE = hOLDTRXTYPE;
	}

	public BigDecimal getHOLD_AMOUNT() {
		return HOLD_AMOUNT;
	}

	public void setHOLD_AMOUNT(BigDecimal hOLDAMOUNT) {
		HOLD_AMOUNT = hOLDAMOUNT;
	}

	public String getDEDUCT_ZAKAT_FR() {
		return DEDUCT_ZAKAT_FR;
	}

	public void setDEDUCT_ZAKAT_FR(String dEDUCTZAKATFR) {
		DEDUCT_ZAKAT_FR = dEDUCTZAKATFR;
	}

	public String getZAKAT_APPLIED() {
		return ZAKAT_APPLIED;
	}

	public void setZAKAT_APPLIED(String zAKATAPPLIED) {
		ZAKAT_APPLIED = zAKATAPPLIED;
	}

	public BigDecimal getADVANCE_PERC() {
		return ADVANCE_PERC;
	}

	public void setADVANCE_PERC(BigDecimal aDVANCEPERC) {
		ADVANCE_PERC = aDVANCEPERC;
	}

	public BigDecimal getDEDUCTION_PERIODICITY() {
		return DEDUCTION_PERIODICITY;
	}

	public void setDEDUCTION_PERIODICITY(BigDecimal dEDUCTIONPERIODICITY) {
		DEDUCTION_PERIODICITY = dEDUCTIONPERIODICITY;
	}

	public String getADVANCE_PROFIT() {
		return ADVANCE_PROFIT;
	}

	public void setADVANCE_PROFIT(String aDVANCEPROFIT) {
		ADVANCE_PROFIT = aDVANCEPROFIT;
	}

	public String getDEDUCTION_METHOD() {
		return DEDUCTION_METHOD;
	}

	public void setDEDUCTION_METHOD(String dEDUCTIONMETHOD) {
		DEDUCTION_METHOD = dEDUCTIONMETHOD;
	}

	public String getEDIT_ADVPROFIT_IN_ACCLEVEL_YN() {
		return EDIT_ADVPROFIT_IN_ACCLEVEL_YN;
	}

	public void setEDIT_ADVPROFIT_IN_ACCLEVEL_YN(String eDITADVPROFITINACCLEVELYN) {
		EDIT_ADVPROFIT_IN_ACCLEVEL_YN = eDITADVPROFITINACCLEVELYN;
	}

	public BigDecimal getTAX_RATE_CAP_REV() {
		return TAX_RATE_CAP_REV;
	}

	public void setTAX_RATE_CAP_REV(BigDecimal tAXRATECAPREV) {
		TAX_RATE_CAP_REV = tAXRATECAPREV;
	}

	public String getAPP_TAX_CAP_REV() {
		return APP_TAX_CAP_REV;
	}

	public void setAPP_TAX_CAP_REV(String aPPTAXCAPREV) {
		APP_TAX_CAP_REV = aPPTAXCAPREV;
	}

	public String getRENEW_PROTECT() {
		return RENEW_PROTECT;
	}

	public void setRENEW_PROTECT(String rENEWPROTECT) {
		RENEW_PROTECT = rENEWPROTECT;
	}

	public String getMODIF_POINTS_DETAILS() {
		return MODIF_POINTS_DETAILS;
	}

	public void setMODIF_POINTS_DETAILS(String mODIFPOINTSDETAILS) {
		MODIF_POINTS_DETAILS = mODIFPOINTSDETAILS;
	}

	public BigDecimal getCIF_SUB_NO() {
		return CIF_SUB_NO;
	}

	public void setCIF_SUB_NO(BigDecimal cIFSUBNO) {
		CIF_SUB_NO = cIFSUBNO;
	}

	public String getALTER_AFFECT_FLAG() {
		return ALTER_AFFECT_FLAG;
	}

	public void setALTER_AFFECT_FLAG(String aLTERAFFECTFLAG) {
		ALTER_AFFECT_FLAG = aLTERAFFECTFLAG;
	}

	public String getDEFAULT_PT_PERIOD() {
		return DEFAULT_PT_PERIOD;
	}

	public void setDEFAULT_PT_PERIOD(String dEFAULTPTPERIOD) {
		DEFAULT_PT_PERIOD = dEFAULTPTPERIOD;
	}

	public String getPROTECT_PT_PERIOD() {
		return PROTECT_PT_PERIOD;
	}

	public void setPROTECT_PT_PERIOD(String pROTECTPTPERIOD) {
		PROTECT_PT_PERIOD = pROTECTPTPERIOD;
	}

	public String getMODIFY_PSR_CUSTOMER() {
		return MODIFY_PSR_CUSTOMER;
	}

	public void setMODIFY_PSR_CUSTOMER(String mODIFYPSRCUSTOMER) {
		MODIFY_PSR_CUSTOMER = mODIFYPSRCUSTOMER;
	}

	public String getALLOW_CHANGE_HOLD_AMOUNT() {
		return ALLOW_CHANGE_HOLD_AMOUNT;
	}

	public void setALLOW_CHANGE_HOLD_AMOUNT(String aLLOWCHANGEHOLDAMOUNT) {
		ALLOW_CHANGE_HOLD_AMOUNT = aLLOWCHANGEHOLDAMOUNT;
	}

	public String getALLOW_MODIFY_CIF_PROFIT_ACC() {
		return ALLOW_MODIFY_CIF_PROFIT_ACC;
	}

	public void setALLOW_MODIFY_CIF_PROFIT_ACC(String aLLOWMODIFYCIFPROFITACC) {
		ALLOW_MODIFY_CIF_PROFIT_ACC = aLLOWMODIFYCIFPROFITACC;
	}

	public BigDecimal getBRANCH_CODE() {
		return BRANCH_CODE;
	}

	public void setBRANCH_CODE(BigDecimal bRANCHCODE) {
		BRANCH_CODE = bRANCHCODE;
	}

	public BigDecimal getTERM_DAYS() {
		return TERM_DAYS;
	}

	public void setTERM_DAYS(BigDecimal tERMDAYS) {
		TERM_DAYS = tERMDAYS;
	}

	public String getTERM_IND() {
		return TERM_IND;
	}

	public void setTERM_IND(String tERMIND) {
		TERM_IND = tERMIND;
	}

	public BigDecimal getRMSIA_FIRST_MAT_PERIOD() {
		return RMSIA_FIRST_MAT_PERIOD;
	}

	public void setRMSIA_FIRST_MAT_PERIOD(BigDecimal rMSIAFIRSTMATPERIOD) {
		RMSIA_FIRST_MAT_PERIOD = rMSIAFIRSTMATPERIOD;
	}

	public String getRMSIA_FIRST_MAT() {
		return RMSIA_FIRST_MAT;
	}

	public void setRMSIA_FIRST_MAT(String rMSIAFIRSTMAT) {
		RMSIA_FIRST_MAT = rMSIAFIRSTMAT;
	}

	public BigDecimal getRIFATD_COUNT() {
		return RIFATD_COUNT;
	}

	public void setRIFATD_COUNT(BigDecimal rIFATDCOUNT) {
		RIFATD_COUNT = rIFATDCOUNT;
	}

	public BigDecimal getCURRENCY_AVAILABLE() {
		return CURRENCY_AVAILABLE;
	}

	public void setCURRENCY_AVAILABLE(BigDecimal cURRENCYAVAILABLE) {
		CURRENCY_AVAILABLE = cURRENCYAVAILABLE;
	}

	public BigDecimal getDET_IND() {
		return DET_IND;
	}

	public void setDET_IND(BigDecimal dETIND) {
		DET_IND = dETIND;
	}

	public String getALLOW_CHANGE_CIF() {
		return ALLOW_CHANGE_CIF;
	}

	public void setALLOW_CHANGE_CIF(String aLLOWCHANGECIF) {
		ALLOW_CHANGE_CIF = aLLOWCHANGECIF;
	}

	public String getGL_CATEGORY() {
		return GL_CATEGORY;
	}

	public void setGL_CATEGORY(String gLCATEGORY) {
		GL_CATEGORY = gLCATEGORY;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getDR_CR_IDX() {
		return DR_CR_IDX;
	}

	public void setDR_CR_IDX(String dRCRIDX) {
		DR_CR_IDX = dRCRIDX;
	}

	public BigDecimal getAUTO_SWEEP_GL() {
		return AUTO_SWEEP_GL;
	}

	public void setAUTO_SWEEP_GL(BigDecimal aUTOSWEEPGL) {
		AUTO_SWEEP_GL = aUTOSWEEPGL;
	}

	public String getAUTO_SWEEP() {
		return AUTO_SWEEP;
	}

	public void setAUTO_SWEEP(String aUTOSWEEP) {
		AUTO_SWEEP = aUTOSWEEP;
	}

	public BigDecimal getMinOpeningBalance() {
		return minOpeningBalance;
	}

	public void setMinOpeningBalance(BigDecimal minOpeningBalance) {
		this.minOpeningBalance = minOpeningBalance;
	}

	public String getBRIEF_DESC_GL_AR()
	{
	    return BRIEF_DESC_GL_AR;
	}

	public void setBRIEF_DESC_GL_AR(String bRIEF_DESC_GL_AR)
	{
	    BRIEF_DESC_GL_AR = bRIEF_DESC_GL_AR;
	}

	public String getLONG_DESC_GL_AR()
	{
	    return LONG_DESC_GL_AR;
	}

	public void setLONG_DESC_GL_AR(String lONG_DESC_GL_AR)
	{
	    LONG_DESC_GL_AR = lONG_DESC_GL_AR;
	}

	public String getAFFECT_CHEQUE_BILL_LIST()
	{
	    return AFFECT_CHEQUE_BILL_LIST;
	}

	public void setAFFECT_CHEQUE_BILL_LIST(String aFFECT_CHEQUE_BILL_LIST)
	{
	    AFFECT_CHEQUE_BILL_LIST = aFFECT_CHEQUE_BILL_LIST;
	}


}
