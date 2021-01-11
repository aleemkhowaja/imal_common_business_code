package com.path.vo.core.cardsmanagement;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSCARDS_ACCVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.vo.core.common.RetailBaseVO;

public class CardsAccountCO extends RetailBaseVO
{
    private CTSCARDS_ACCVO accountVO = new CTSCARDS_ACCVO();
    private CURRENCIESVO currenciesVO = new CURRENCIESVO();
    private String ACC_NAME;
    private String OLD_ACC_REASON;
    private BigDecimal ALLOW_TO_ADD_ACC;
    private BigDecimal ALLOW_TO_CHANGE_CIF;
    private BigDecimal ALLOW_TO_CHANGE_CY;
    private String ALLOW_ONLY_BASECY;
    private BigDecimal APPLICATION_ID;
    private String CHECK_WD_AMOUNT;
    private String CHECK_POS_AMOUNT;
    private String CHECK_WD_DETAILS;
    private String CHECK_POS_DETAILS;
    private String CHECK_TEMP_PERMANENT;
    private String CHECK_TEMP_PERMANENT_POS;
    private String NEW_ROW;
    private String ACC_STATUS;
    private String SUPP_PRIM;
    private String prim_sec;
    private String protectACC_CY = "false";
    private String protectACC_CIF = "false";
    private String hideLIMIT_BASED_ON = "false";
    private String hideLIMIT_CHECK_PERIOD = "false";
    private String hidePOS_BASED_ON = "false";
    private String hidePOS_PERIODICITY = "false";
    private String hideLIMIT_AMOUNT = "false";
    private String hidePOS_LIMIT = "false";
    private String protectPK_SEC_FLAG = "false";

    private String protectLIMIT_BASED_ON = "false";
    private String protectLIMIT_CHECK_PERIOD = "false";
    private String protectPOS_BASED_ON = "false";
    private String protectPOS_PERIODICITY = "false";

    private BigDecimal cifCode;
    private BigDecimal amtFormat;
    private String dependencyCallSource;
    private String IBAN_ACC_NO;
    
    
    private BigDecimal ldecAmount;//BMOI140007
    private BigDecimal card_Type;//BMOI140007

    public CTSCARDS_ACCVO getAccountVO()
    {
	return accountVO;
    }

    public void setAccountVO(CTSCARDS_ACCVO accountVO)
    {
	this.accountVO = accountVO;
    }

    public CURRENCIESVO getCurrenciesVO()
    {
	return currenciesVO;
    }

    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
	this.currenciesVO = currenciesVO;
    }

    public String getACC_NAME()
    {
	return ACC_NAME;
    }

    public void setACC_NAME(String aCCNAME)
    {
	ACC_NAME = aCCNAME;
    }

    public String getOLD_ACC_REASON()
    {
	return OLD_ACC_REASON;
    }

    public void setOLD_ACC_REASON(String oLDACCREASON)
    {
	OLD_ACC_REASON = oLDACCREASON;
    }

    public BigDecimal getALLOW_TO_ADD_ACC()
    {
	return ALLOW_TO_ADD_ACC;
    }

    public void setALLOW_TO_ADD_ACC(BigDecimal aLLOWTOADDACC)
    {
	ALLOW_TO_ADD_ACC = aLLOWTOADDACC;
    }

    public BigDecimal getALLOW_TO_CHANGE_CIF()
    {
	return ALLOW_TO_CHANGE_CIF;
    }

    public void setALLOW_TO_CHANGE_CIF(BigDecimal aLLOWTOCHANGECIF)
    {
	ALLOW_TO_CHANGE_CIF = aLLOWTOCHANGECIF;
    }

    public BigDecimal getALLOW_TO_CHANGE_CY()
    {
	return ALLOW_TO_CHANGE_CY;
    }

    public void setALLOW_TO_CHANGE_CY(BigDecimal aLLOWTOCHANGECY)
    {
	ALLOW_TO_CHANGE_CY = aLLOWTOCHANGECY;
    }

    public String getCHECK_WD_AMOUNT()
    {
	return CHECK_WD_AMOUNT;
    }

    public void setCHECK_WD_AMOUNT(String cHECKWDAMOUNT)
    {
	CHECK_WD_AMOUNT = cHECKWDAMOUNT;
    }

    public String getCHECK_POS_AMOUNT()
    {
	return CHECK_POS_AMOUNT;
    }

    public void setCHECK_POS_AMOUNT(String cHECKPOSAMOUNT)
    {
	CHECK_POS_AMOUNT = cHECKPOSAMOUNT;
    }

    public String getCHECK_WD_DETAILS()
    {
	return CHECK_WD_DETAILS;
    }

    public void setCHECK_WD_DETAILS(String cHECKWDDETAILS)
    {
	CHECK_WD_DETAILS = cHECKWDDETAILS;
    }

    public String getCHECK_POS_DETAILS()
    {
	return CHECK_POS_DETAILS;
    }

    public void setCHECK_POS_DETAILS(String cHECKPOSDETAILS)
    {
	CHECK_POS_DETAILS = cHECKPOSDETAILS;
    }

    public String getCHECK_TEMP_PERMANENT()
    {
	return CHECK_TEMP_PERMANENT;
    }

    public void setCHECK_TEMP_PERMANENT(String cHECKTEMPPERMANENT)
    {
	CHECK_TEMP_PERMANENT = cHECKTEMPPERMANENT;
    }

    public String getCHECK_TEMP_PERMANENT_POS()
    {
	return CHECK_TEMP_PERMANENT_POS;
    }

    public void setCHECK_TEMP_PERMANENT_POS(String cHECKTEMPPERMANENTPOS)
    {
	CHECK_TEMP_PERMANENT_POS = cHECKTEMPPERMANENTPOS;
    }

    public String getNEW_ROW()
    {
	return NEW_ROW;
    }

    public void setNEW_ROW(String nEWROW)
    {
	NEW_ROW = nEWROW;
    }

    public String getACC_STATUS()
    {
	return ACC_STATUS;
    }

    public void setACC_STATUS(String aCCSTATUS)
    {
	ACC_STATUS = aCCSTATUS;
    }

    public String getSUPP_PRIM()
    {
	return SUPP_PRIM;
    }

    public void setSUPP_PRIM(String sUPPPRIM)
    {
	SUPP_PRIM = sUPPPRIM;
    }

    public String getPrim_sec()
    {
	return prim_sec;
    }

    public void setPrim_sec(String primSec)
    {
	prim_sec = primSec;
    }

    public BigDecimal getAPPLICATION_ID()
    {
	return APPLICATION_ID;
    }

    public void setAPPLICATION_ID(BigDecimal aPPLICATIONID)
    {
	APPLICATION_ID = aPPLICATIONID;
    }

    public String getALLOW_ONLY_BASECY()
    {
	return ALLOW_ONLY_BASECY;
    }

    public void setALLOW_ONLY_BASECY(String aLLOWONLYBASECY)
    {
	ALLOW_ONLY_BASECY = aLLOWONLYBASECY;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public BigDecimal getAmtFormat()
    {
	return amtFormat;
    }

    public void setAmtFormat(BigDecimal amtFormat)
    {
	this.amtFormat = amtFormat;
    }

    public String getDependencyCallSource()
    {
	return dependencyCallSource;
    }

    public void setDependencyCallSource(String dependencyCallSource)
    {
	this.dependencyCallSource = dependencyCallSource;
    }

    public String getProtectACC_CY()
    {
	return protectACC_CY;
    }

    public void setProtectACC_CY(String protectACCCY)
    {
	protectACC_CY = protectACCCY;
    }

    public String getHideLIMIT_BASED_ON()
    {
	return hideLIMIT_BASED_ON;
    }

    public void setHideLIMIT_BASED_ON(String hideLIMITBASEDON)
    {
	hideLIMIT_BASED_ON = hideLIMITBASEDON;
    }

    public String getHideLIMIT_CHECK_PERIOD()
    {
	return hideLIMIT_CHECK_PERIOD;
    }

    public void setHideLIMIT_CHECK_PERIOD(String hideLIMITCHECKPERIOD)
    {
	hideLIMIT_CHECK_PERIOD = hideLIMITCHECKPERIOD;
    }

    public String getHidePOS_BASED_ON()
    {
	return hidePOS_BASED_ON;
    }

    public void setHidePOS_BASED_ON(String hidePOSBASEDON)
    {
	hidePOS_BASED_ON = hidePOSBASEDON;
    }

    public String getHidePOS_PERIODICITY()
    {
	return hidePOS_PERIODICITY;
    }

    public void setHidePOS_PERIODICITY(String hidePOSPERIODICITY)
    {
	hidePOS_PERIODICITY = hidePOSPERIODICITY;
    }

    public String getHideLIMIT_AMOUNT()
    {
	return hideLIMIT_AMOUNT;
    }

    public void setHideLIMIT_AMOUNT(String hideLIMITAMOUNT)
    {
	hideLIMIT_AMOUNT = hideLIMITAMOUNT;
    }

    public String getHidePOS_LIMIT()
    {
	return hidePOS_LIMIT;
    }

    public void setHidePOS_LIMIT(String hidePOSLIMIT)
    {
	hidePOS_LIMIT = hidePOSLIMIT;
    }

    public String getProtectPK_SEC_FLAG()
    {
	return protectPK_SEC_FLAG;
    }

    public void setProtectPK_SEC_FLAG(String protectPKSECFLAG)
    {
	protectPK_SEC_FLAG = protectPKSECFLAG;
    }

    public String getProtectLIMIT_BASED_ON()
    {
	return protectLIMIT_BASED_ON;
    }

    public void setProtectLIMIT_BASED_ON(String protectLIMITBASEDON)
    {
	protectLIMIT_BASED_ON = protectLIMITBASEDON;
    }

    public String getProtectLIMIT_CHECK_PERIOD()
    {
	return protectLIMIT_CHECK_PERIOD;
    }

    public void setProtectLIMIT_CHECK_PERIOD(String protectLIMITCHECKPERIOD)
    {
	protectLIMIT_CHECK_PERIOD = protectLIMITCHECKPERIOD;
    }

    public String getProtectPOS_BASED_ON()
    {
	return protectPOS_BASED_ON;
    }

    public void setProtectPOS_BASED_ON(String protectPOSBASEDON)
    {
	protectPOS_BASED_ON = protectPOSBASEDON;
    }

    public String getProtectPOS_PERIODICITY()
    {
	return protectPOS_PERIODICITY;
    }

    public void setProtectPOS_PERIODICITY(String protectPOSPERIODICITY)
    {
	protectPOS_PERIODICITY = protectPOSPERIODICITY;
    }

    public String getProtectACC_CIF()
    {
	return protectACC_CIF;
    }

    public void setProtectACC_CIF(String protectACCCIF)
    {
	protectACC_CIF = protectACCCIF;
    }

    public BigDecimal getLdecAmount()
    {
        return ldecAmount;
    }

    public void setLdecAmount(BigDecimal ldecAmount)
    {
        this.ldecAmount = ldecAmount;
    }

    public BigDecimal getCard_Type()
    {
        return card_Type;
    }

    public void setCard_Type(BigDecimal card_Type)
    {
        this.card_Type = card_Type;
    }

    
    public String getIBAN_ACC_NO()
    {
        return IBAN_ACC_NO;
    }

    public void setIBAN_ACC_NO(String iBAN_ACC_NO)
    {
        IBAN_ACC_NO = iBAN_ACC_NO;
    }

}
