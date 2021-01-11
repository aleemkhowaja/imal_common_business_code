package com.path.vo.core.reports;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_SOA_CTRLVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.RIFMESSAGEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.trxmgnt.TrxMgntCO;

public class ReportsCO extends RetailBaseVO
{
    // VOs & COs
    private COMPANIESVO companiesVO = new COMPANIESVO();
    private CURRENCIESVO currenciesVO = new CURRENCIESVO();
    private RIFMESSAGEVO rifMessageVO = new RIFMESSAGEVO();
    private BRANCHESVO branchesVO = new BRANCHESVO();
    private AMFVO amfVOFrom = new AMFVO();
    private AMFVO amfVOTo = new AMFVO();
    private CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private ACC_NV_CONTROLVO accNVCONTROLVO = new ACC_NV_CONTROLVO();
    private ReportResponseCO reportResponseCO = new ReportResponseCO();
    private CTS_SOA_CTRLVO ctsSoaCtrlVO = new CTS_SOA_CTRLVO();
    private CTS_SOA_CTRLVO ctsAdminSoaCtrlVO = new CTS_SOA_CTRLVO();
    private PTH_CTRLVO pthCtrlVO = new PTH_CTRLVO();
    private TrxMgntCO trxMgntCO;
    private String reportParams;
    private String _type;

    private Date from_date, to_date;
    private Date from_date_hijri, to_date_hijri;
    private String from_date_str, to_date_str;
    private Date modifiedFromDate;
    private Date valueDate;
    private Date dateOpened;
    private BigDecimal year;
    private BigDecimal month;
    private String compDesc;

    private String gregoHijri;
    private boolean showDateFormat = true;


    private String exportType;
    private String swiftMessage;
    private String savePathJava;

//    private String languageOpt;
//    private String msgIncludeInReport;
//    private String reportByDate;
//    private String includeRevaluation;
//    private String includeReverse;

    private String glCodeRange;
    private String cifCodeRange;
    private String considerMinStmtBal;
    private String printStmtIfNoTrx;
    private String ifLanguageForCifIsBothPrint;
    private String excludeDeletedAccounts;
    private String excludeSuspendedAccounts;
    private String bs_contra;
    private int dateCriteria;
    
    private String fromCardNo;

    private String isTellerAccount;
    private String ls_option;

    private String rifMsgDesc;

    private String stmtPeriodicity;
    private int rangeByCriteria;

    private boolean showLanguage = true;
    private boolean showGlRange = true;

    public String excludeRenewedDeposits;
    
    private String showOverdaftDetYN;

    public String excludeMaturedAccounts;

    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    
    
    private String reportBase64;
    private BigDecimal reportSize;
    private String reportName;
    private String reportFormat;
   
    /**
     * Getters and Setters
     */
    public CURRENCIESVO getCurrenciesVO()
    {
	return currenciesVO;
    }

    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
	this.currenciesVO = currenciesVO;
    }

    public RIFMESSAGEVO getRifMessageVO()
    {
	return rifMessageVO;
    }

    public void setRifMessageVO(RIFMESSAGEVO rifMessageVO)
    {
	this.rifMessageVO = rifMessageVO;
    }

    public COMPANIESVO getCompaniesVO()
    {
	return companiesVO;
    }

    public void setCompaniesVO(COMPANIESVO companiesVO)
    {
	this.companiesVO = companiesVO;
    }

    public BRANCHESVO getBranchesVO()
    {
	return branchesVO;
    }

    public void setBranchesVO(BRANCHESVO branchesVO)
    {
	this.branchesVO = branchesVO;
    }

    public AMFVO getAmfVOFrom()
    {
	return amfVOFrom;
    }

    public void setAmfVOFrom(AMFVO amfVOFrom)
    {
	this.amfVOFrom = amfVOFrom;
    }

    public AMFVO getAmfVOTo()
    {
	return amfVOTo;
    }

    public void setAmfVOTo(AMFVO amfVOTo)
    {
	this.amfVOTo = amfVOTo;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public ReportResponseCO getReportResponseCO()
    {
	return reportResponseCO;
    }

    public void setReportResponseCO(ReportResponseCO reportResponseCO)
    {
	this.reportResponseCO = reportResponseCO;
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

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public String getIsTellerAccount()
    {
	return isTellerAccount;
    }

    public void setIsTellerAccount(String isTellerAccount)
    {
	this.isTellerAccount = isTellerAccount;
    }

    public String getLs_option()
    {
	return ls_option;
    }

    public void setLs_option(String lsOption)
    {
	ls_option = lsOption;
    }

    public Date getDateOpened()
    {
	return dateOpened;
    }

    public void setDateOpened(Date dateOpened)
    {
	this.dateOpened = dateOpened;
    }

    public Date getModifiedFromDate()
    {
	return modifiedFromDate;
    }

    public void setModifiedFromDate(Date modifiedFromDate)
    {
	this.modifiedFromDate = modifiedFromDate;
    }

    public BigDecimal getYear()
    {
	return year;
    }

    public void setYear(BigDecimal year)
    {
	this.year = year;
    }

    public BigDecimal getMonth()
    {
	return month;
    }

    public void setMonth(BigDecimal month)
    {
	this.month = month;
    }

    public CTSCONTROLVO getCtsControlVO()
    {
	return ctsControlVO;
    }

    public void setCtsControlVO(CTSCONTROLVO ctsControlVO)
    {
	this.ctsControlVO = ctsControlVO;
    }

    public String getGregoHijri()
    {
	return gregoHijri;
    }

    public void setGregoHijri(String gregoHijri)
    {
	this.gregoHijri = gregoHijri;
    }

    public String getRifMsgDesc()
    {
	return rifMsgDesc;
    }

    public void setRifMsgDesc(String rifMsgDesc)
    {
	this.rifMsgDesc = rifMsgDesc;
    }

    public String getCompDesc()
    {
	return compDesc;
    }

    public void setCompDesc(String compDesc)
    {
	this.compDesc = compDesc;
    }

    public String getReportParams()
    {
	return reportParams;
    }

    public void setReportParams(String reportParams)
    {
	this.reportParams = reportParams;
    }

    public String getStmtPeriodicity()
    {
	return stmtPeriodicity;
    }

    public void setStmtPeriodicity(String stmtPeriodicity)
    {
	this.stmtPeriodicity = stmtPeriodicity;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
	return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
	this.hm = hm;
    }

    public String getGlCodeRange()
    {
	return glCodeRange;
    }

    public void setGlCodeRange(String glCodeRange)
    {
	this.glCodeRange = glCodeRange;
    }

    public String getCifCodeRange()
    {
	return cifCodeRange;
    }

    public void setCifCodeRange(String cifCodeRange)
    {
	this.cifCodeRange = cifCodeRange;
    }

    public String getConsiderMinStmtBal()
    {
	return considerMinStmtBal;
    }

    public void setConsiderMinStmtBal(String considerMinStmtBal)
    {
	this.considerMinStmtBal = considerMinStmtBal;
    }

    public String getPrintStmtIfNoTrx()
    {
	return printStmtIfNoTrx;
    }

    public void setPrintStmtIfNoTrx(String printStmtIfNoTrx)
    {
	this.printStmtIfNoTrx = printStmtIfNoTrx;
    }

    public String getIfLanguageForCifIsBothPrint()
    {
	return ifLanguageForCifIsBothPrint;
    }

    public void setIfLanguageForCifIsBothPrint(String ifLanguageForCifIsBothPrint)
    {
	this.ifLanguageForCifIsBothPrint = ifLanguageForCifIsBothPrint;
    }

    public String getExcludeDeletedAccounts()
    {
	return excludeDeletedAccounts;
    }

    public void setExcludeDeletedAccounts(String excludeDeletedAccounts)
    {
	this.excludeDeletedAccounts = excludeDeletedAccounts;
    }

    public String getExcludeSuspendedAccounts()
    {
	return excludeSuspendedAccounts;
    }

    public void setExcludeSuspendedAccounts(String excludeSuspendedAccounts)
    {
	this.excludeSuspendedAccounts = excludeSuspendedAccounts;
    }

    public String get_type()
    {
	return _type;
    }

    public void set_type(String type)
    {
	_type = type;
    }

    public String getBs_contra()
    {
	return bs_contra;
    }

    public void setBs_contra(String bsContra)
    {
	bs_contra = bsContra;
    }

    public String getFrom_date_str()
    {
	return from_date_str;
    }

    public void setFrom_date_str(String fromDateStr)
    {
	from_date_str = fromDateStr;
    }

    public String getTo_date_str()
    {
	return to_date_str;
    }

    public void setTo_date_str(String toDateStr)
    {
	to_date_str = toDateStr;
    }

    public String getFromCardNo()
    {
	return fromCardNo;
    }

    public void setFromCardNo(String fromCardNo)
    {
	this.fromCardNo = fromCardNo;
    }

    public int getRangeByCriteria()
    {
        return rangeByCriteria;
    }

    public void setRangeByCriteria(int rangeByCriteria)
    {
        this.rangeByCriteria = rangeByCriteria;
    }

    public CTS_SOA_CTRLVO getCtsSoaCtrlVO()
    {
        return ctsSoaCtrlVO;
    }

    public void setCtsSoaCtrlVO(CTS_SOA_CTRLVO ctsSoaCtrlVO)
    {
        this.ctsSoaCtrlVO = ctsSoaCtrlVO;
    }

    public CTS_SOA_CTRLVO getCtsAdminSoaCtrlVO()
    {
        return ctsAdminSoaCtrlVO;
    }

    public void setCtsAdminSoaCtrlVO(CTS_SOA_CTRLVO ctsAdminSoaCtrlVO)
    {
        this.ctsAdminSoaCtrlVO = ctsAdminSoaCtrlVO;
    }

    public PTH_CTRLVO getPthCtrlVO()
    {
        return pthCtrlVO;
    }

    public void setPthCtrlVO(PTH_CTRLVO pthCtrlVO)
    {
        this.pthCtrlVO = pthCtrlVO;
    }

    public TrxMgntCO getTrxMgntCO()
    {
        return trxMgntCO;
    }

    public void setTrxMgntCO(TrxMgntCO trxMgntCO)
    {
        this.trxMgntCO = trxMgntCO;
    }

    public boolean isShowDateFormat()
    {
        return showDateFormat;
    }

    public void setShowDateFormat(boolean showDateFormat)
    {
        this.showDateFormat = showDateFormat;
    }

    public Date getFrom_date_hijri()
    {
        return from_date_hijri;
    }

    public void setFrom_date_hijri(Date fromDateHijri)
    {
        from_date_hijri = fromDateHijri;
    }

    public Date getTo_date_hijri()
    {
        return to_date_hijri;
    }

    public void setTo_date_hijri(Date toDateHijri)
    {
        to_date_hijri = toDateHijri;
    }

    public ACC_NV_CONTROLVO getAccNVCONTROLVO()
    {
        return accNVCONTROLVO;
    }

    public void setAccNVCONTROLVO(ACC_NV_CONTROLVO accNVCONTROLVO)
    {
        this.accNVCONTROLVO = accNVCONTROLVO;
    }

    public boolean isShowLanguage()
    {
        return showLanguage;
    }

    public void setShowLanguage(boolean showLanguage)
    {
        this.showLanguage = showLanguage;
    }

    public boolean isShowGlRange()
    {
        return showGlRange;
    }

    public void setShowGlRange(boolean showGlRange)
    {
        this.showGlRange = showGlRange;
    }

    public String getExcludeRenewedDeposits()
    {
        return excludeRenewedDeposits;
    }

    public void setExcludeRenewedDeposits(String excludeRenewedDeposits)
    {
        this.excludeRenewedDeposits = excludeRenewedDeposits;
    }


    public String getExcludeMaturedAccounts()
    {
        return excludeMaturedAccounts;
    }

    public void setExcludeMaturedAccounts(String excludeMaturedAccounts)
    {
        this.excludeMaturedAccounts = excludeMaturedAccounts;
    }

    public int getDateCriteria()
    {
        return dateCriteria;
    }

    public void setDateCriteria(int dateCriteria)
    {
        this.dateCriteria = dateCriteria;
    }

    public String getExportType()
    {
        return exportType;
    }

    public void setExportType(String exportType)
    {
        this.exportType = exportType;
    }

    public String getSwiftMessage()
    {
        return swiftMessage;
    }

    public void setSwiftMessage(String swiftMessage)
    {
        this.swiftMessage = swiftMessage;
    }

    public String getSavePathJava()
    {
        return savePathJava;
    }

    public void setSavePathJava(String savePathJava)
    {
        this.savePathJava = savePathJava;
    }

    public String getReportBase64()
    {
	return reportBase64;
    }

    public void setReportBase64(String reportBase64)
    {
	this.reportBase64 = reportBase64;
    }

    public BigDecimal getReportSize()
    {
	return reportSize;
    }

    public void setReportSize(BigDecimal reportSize)
    {
	this.reportSize = reportSize;
    }

    public String getReportName()
    {
	return reportName;
    }

    public void setReportName(String reportName)
    {
	this.reportName = reportName;
    }

    public String getReportFormat()
    {
	return reportFormat;
    }

    public void setReportFormat(String reportFormat)
    {
	this.reportFormat = reportFormat;
    }

    public String getShowOverdaftDetYN()
    {
	return showOverdaftDetYN;
    }

    public void setShowOverdaftDetYN(String showOverdaftDetYN)
    {
	this.showOverdaftDetYN = showOverdaftDetYN;
    }
  
}
