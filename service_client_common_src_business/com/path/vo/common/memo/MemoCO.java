package com.path.vo.common.memo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSMEMO_DETVO;

public class MemoCO implements Serializable {

	private BigDecimal TRX_NO;
	private BigDecimal MEMO_CODE;
	private String ENG_COMENT;
	private BigDecimal LAST_REVIEW_NO;
	private BigDecimal BRANCH_CODE;
	private String BRIEF_DESC_ENG;
	private String COMMON_DESC_ENG;
	private String LONG_DESC_ENG;
	private String COMMON_DESC_ARAB;
	private String LONG_DESC_ARAB;
	private String ARAB_COMENT;
	private String TYPE;
	private String APP_SPECIFIC;
	private String APP_NAME;
	private String CIF_SPECIFIC;
	private BigDecimal ACC_BR;
	private BigDecimal ACC_CY;
	private BigDecimal ACC_GL;
	private BigDecimal ACC_CIF;
	private BigDecimal ACC_SL;
	private BigDecimal CIF_NO;
	private String STATUS;
	private Date FROM_DATE;
	private Date DATE_TO;
	private String checkArg;
	private BigDecimal condAutomationCode;
	private String CIF_ACCNO; // to display either CIF or Account
	private String forCifOrAcc; // to display either CIF or Account Type
	//Bassam Eid - BUG# 681162
	private BigDecimal eventType;
	//////////////////////////
	
	private CTSMEMO_DETVO ctsmemoDETVO;

	private String CIF_ROLE;

	// add view var
	
	
	//For webservices (OMNI)
	private BigDecimal AMOUNT;
	private BigDecimal TRX_REF;
	private String TRX_TYPE;
	private String TRX_DESC;
	private BigDecimal CURRENCIES_DECIMAL_POINTS;
	private String CURRENCIES_BRIEF_DESC_ENG;
	private String CURRENCIES_FLAG_CTR;

	private BigDecimal COMMON_REF;
	
	//Rania - DB180100 - Customers Segmentation Enhancement
	private String SEGMENT_SPECIFIC_YN;
	//

	public BigDecimal getTRX_NO() {
		return TRX_NO;
	}

	public void setTRX_NO(BigDecimal tRXNO) {
		TRX_NO = tRXNO;
	}

	public BigDecimal getMEMO_CODE() {
		return MEMO_CODE;
	}

	public void setMEMO_CODE(BigDecimal mEMOCODE) {
		MEMO_CODE = mEMOCODE;
	}

	public String getENG_COMENT() {
		return ENG_COMENT;
	}

	public void setENG_COMENT(String eNGCOMENT) {
		ENG_COMENT = eNGCOMENT;
	}

	public BigDecimal getLAST_REVIEW_NO() {
		return LAST_REVIEW_NO;
	}

	public void setLAST_REVIEW_NO(BigDecimal lASTREVIEWNO) {
		LAST_REVIEW_NO = lASTREVIEWNO;
	}

	public BigDecimal getBRANCH_CODE() {
		return BRANCH_CODE;
	}

	public void setBRANCH_CODE(BigDecimal bRANCHCODE) {
		BRANCH_CODE = bRANCHCODE;
	}

	public String getBRIEF_DESC_ENG() {
		return BRIEF_DESC_ENG;
	}

	public void setBRIEF_DESC_ENG(String bRIEFDESCENG) {
		BRIEF_DESC_ENG = bRIEFDESCENG;
	}

	public String getCOMMON_DESC_ENG() {
		return COMMON_DESC_ENG;
	}

	public void setCOMMON_DESC_ENG(String cOMMONDESCENG) {
		COMMON_DESC_ENG = cOMMONDESCENG;
	}

	public String getLONG_DESC_ENG() {
		return LONG_DESC_ENG;
	}

	public void setLONG_DESC_ENG(String lONGDESCENG) {
		LONG_DESC_ENG = lONGDESCENG;
	}

	public String getCOMMON_DESC_ARAB()
	{
	    return COMMON_DESC_ARAB;
	}

	public void setCOMMON_DESC_ARAB(String cOMMONDESCARAB)
	{
	    COMMON_DESC_ARAB = cOMMONDESCARAB;
	}

	public String getLONG_DESC_ARAB() {
		return LONG_DESC_ARAB;
	}

	public void setLONG_DESC_ARAB(String lONGDESCARAB) {
		LONG_DESC_ARAB = lONGDESCARAB;
	}

	public String getARAB_COMENT() {
		return ARAB_COMENT;
	}

	public void setARAB_COMENT(String aRABCOMENT) {
		ARAB_COMENT = aRABCOMENT;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getAPP_SPECIFIC() {
		return APP_SPECIFIC;
	}

	public void setAPP_SPECIFIC(String aPPSPECIFIC) {
		APP_SPECIFIC = aPPSPECIFIC;
	}

	public String getAPP_NAME() {
		return APP_NAME;
	}

	public void setAPP_NAME(String aPPNAME) {
		APP_NAME = aPPNAME;
	} 

	public void setACC_BR(BigDecimal aCC_BR) {
		ACC_BR = aCC_BR;
	}

	public BigDecimal getACC_BR() {
		return ACC_BR;
	}

	public BigDecimal getACC_CY() {
		return ACC_CY;
	}

	public void setACC_CY(BigDecimal aCCCY) {
		ACC_CY = aCCCY;
	}

	public BigDecimal getACC_GL() {
		return ACC_GL;
	}

	public void setACC_GL(BigDecimal aCCGL) {
		ACC_GL = aCCGL;
	}

	public BigDecimal getACC_CIF() {
		return ACC_CIF;
	}

	public void setACC_CIF(BigDecimal aCCCIF) {
		ACC_CIF = aCCCIF;
	}

	public BigDecimal getACC_SL() {
		return ACC_SL;
	}

	public void setACC_SL(BigDecimal aCCSL) {
		ACC_SL = aCCSL;
	}

	public void setCIF_NO(BigDecimal cIF_NO) {
		CIF_NO = cIF_NO;
	}

	public BigDecimal getCIF_NO() {
		return CIF_NO;
	}

	public void setCIF_ACCNO(String cIF_ACCNO) {
		CIF_ACCNO = cIF_ACCNO;
	}

	public String getCIF_ACCNO() {
		return CIF_ACCNO;
	}

	public void setCIF_SPECIFIC(String cIF_SPECIFIC) {
		CIF_SPECIFIC = cIF_SPECIFIC;
	}

	public String getCIF_SPECIFIC() {
		return CIF_SPECIFIC;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public Date getFROM_DATE() {
		return FROM_DATE;
	}

	public void setFROM_DATE(Date fROMDATE) {
		FROM_DATE = fROMDATE;
	}

	public Date getDATE_TO() {
		return DATE_TO;
	}

	public void setDATE_TO(Date dATETO) {
		DATE_TO = dATETO;
	}

	public CTSMEMO_DETVO getCtsmemoDETVO() {
		return ctsmemoDETVO;
	}

	public void setCtsmemoDETVO(CTSMEMO_DETVO ctsmemoDETVO) {
		this.ctsmemoDETVO = ctsmemoDETVO;
	}

	public String getCheckArg()
	{
	    return checkArg;
	}

	public void setCheckArg(String checkArg)
	{
	    this.checkArg = checkArg;
	}

	public BigDecimal getCondAutomationCode()
	{
	    return condAutomationCode;
	}

	public void setCondAutomationCode(BigDecimal condAutomationCode)
	{
	    this.condAutomationCode = condAutomationCode;
	}

	public String getForCifOrAcc()
	{
	    return forCifOrAcc;
	}

	public void setForCifOrAcc(String forCifOrAcc)
	{
	    this.forCifOrAcc = forCifOrAcc;
	}

	public BigDecimal getEventType()
	{
	    return eventType;
	}

	public void setEventType(BigDecimal eventType)
	{
	    this.eventType = eventType;
	}

	public BigDecimal getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(BigDecimal aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public BigDecimal getTRX_REF() {
		return TRX_REF;
	}

	public void setTRX_REF(BigDecimal tRX_REF) {
		TRX_REF = tRX_REF;
	}

	public String getTRX_TYPE() {
		return TRX_TYPE;
	}

	public void setTRX_TYPE(String tRX_TYPE) {
		TRX_TYPE = tRX_TYPE;
	}

	public String getTRX_DESC() {
		return TRX_DESC;
	}

	public void setTRX_DESC(String tRX_DESC) {
		TRX_DESC = tRX_DESC;
	}

	public BigDecimal getCURRENCIES_DECIMAL_POINTS() {
		return CURRENCIES_DECIMAL_POINTS;
	}

	public void setCURRENCIES_DECIMAL_POINTS(BigDecimal cURRENCIES_DECIMAL_POINTS) {
		CURRENCIES_DECIMAL_POINTS = cURRENCIES_DECIMAL_POINTS;
	}

	public String getCURRENCIES_BRIEF_DESC_ENG() {
		return CURRENCIES_BRIEF_DESC_ENG;
	}

	public void setCURRENCIES_BRIEF_DESC_ENG(String cURRENCIES_BRIEF_DESC_ENG) {
		CURRENCIES_BRIEF_DESC_ENG = cURRENCIES_BRIEF_DESC_ENG;
	}

	public String getCURRENCIES_FLAG_CTR() {
		return CURRENCIES_FLAG_CTR;
	}

	public void setCURRENCIES_FLAG_CTR(String cURRENCIES_FLAG_CTR) {
		CURRENCIES_FLAG_CTR = cURRENCIES_FLAG_CTR;
	}

	public BigDecimal getCOMMON_REF()
	{
	    return COMMON_REF;
	}

	public void setCOMMON_REF(BigDecimal cOMMON_REF)
	{
	    COMMON_REF = cOMMON_REF;
	}

	public String getCIF_ROLE()
	{
	    return CIF_ROLE;
	}

	public void setCIF_ROLE(String cIF_ROLE)
	{
	    CIF_ROLE = cIF_ROLE;
	}
	
	public String getSEGMENT_SPECIFIC_YN()
	{
	    return SEGMENT_SPECIFIC_YN;
	}

	public void setSEGMENT_SPECIFIC_YN(String sEGMENT_SPECIFIC_YN)
	{
	    SEGMENT_SPECIFIC_YN = sEGMENT_SPECIFIC_YN;
	}	

}
