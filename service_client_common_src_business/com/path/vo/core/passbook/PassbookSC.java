package com.path.vo.core.passbook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class PassbookSC extends GridParamsSC
{

    private BigDecimal passbookCode;
    private BigDecimal cifTypeCode;
    private String ivCrud;
    private BigDecimal lovType;
    private String appName;
    private String progRef;
    private String preferredLanguage;
    private String pr_flag;
    private int first_line;
    private int row_count;
    private String lang;
    private boolean messagesConfirmed;
    private BigDecimal branch_code;
    private String langCode;
    private BigDecimal lovType_layout;
    private BigDecimal ACC_CIF;
    private BigDecimal trsNo;
    
    private boolean checkPassBkMinimumAlert;
    private String allowCifCreationMaskYN;
    private String pageRef;
    private boolean checkNbRec;
    private int trxMgntNbRecords;
    private List<PassBookCO> accountListRecords = new ArrayList<>();
    private int lastLineNumber;
    private BigDecimal maxNumPage;
    
    public BigDecimal getACC_CIF()
    {
	return ACC_CIF;
    }

    public void setACC_CIF(BigDecimal aCCCIF)
    {
	ACC_CIF = aCCCIF;
    }

    public boolean getMessagesConfirmed()
    {
	return messagesConfirmed;
    }

    public void setMessagesConfirmed(boolean messagesConfirmed)
    {
	this.messagesConfirmed = messagesConfirmed;
    }

    public BigDecimal getPassbookCode()
    {
	return passbookCode;
    }

    public void setPassbookCode(BigDecimal passbookCode)
    {
	this.passbookCode = passbookCode;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getPreferredLanguage()
    {
	return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
	this.preferredLanguage = preferredLanguage;
    }

    public String getPr_flag()
    {
	return pr_flag;
    }

    public void setPr_flag(String prFlag)
    {
	pr_flag = prFlag;
    }

    public int getFirst_line()
    {
	return first_line;
    }

    public void setFirst_line(int firstLine)
    {
	first_line = firstLine;
    }

    public int getRow_count()
    {
	return row_count;
    }

    public void setRow_count(int rowCount)
    {
	row_count = rowCount;
    }

    public String getLang()
    {
	return lang;
    }

    public void setLang(String lang)
    {
	this.lang = lang;
    }

    public BigDecimal getBranch_code()
    {
	return branch_code;
    }

    public void setBranch_code(BigDecimal branchCode)
    {
	branch_code = branchCode;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public BigDecimal getLovType_layout()
    {
	return lovType_layout;
    }

    public void setLovType_layout(BigDecimal lovTypeLayout)
    {
	lovType_layout = lovTypeLayout;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public boolean isCheckPassBkMinimumAlert()
    {
        return checkPassBkMinimumAlert;
    }

    public void setCheckPassBkMinimumAlert(boolean checkPassBkMinimumAlert)
    {
        this.checkPassBkMinimumAlert = checkPassBkMinimumAlert;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    
    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }
    
    public boolean isCheckNbRec()
    {
        return checkNbRec;
    }

    public void setCheckNbRec(boolean checkNbRec)
    {
        this.checkNbRec = checkNbRec;
    }

    public int getTrxMgntNbRecords()
    {
        return trxMgntNbRecords;
    }

    public void setTrxMgntNbRecords(int trxMgntNbRecords)
    {
        this.trxMgntNbRecords = trxMgntNbRecords;
    }

    public List<PassBookCO> getAccountListRecords()
    {
        return accountListRecords;
    }

    public void setAccountListRecords(List<PassBookCO> accountListRecords)
    {
        this.accountListRecords = accountListRecords;
    }

    public void setLastLineNumber(int lastLineNumber)
    {
	this.lastLineNumber = lastLineNumber;
    }

    public int getLastLineNumber()
    {
	return lastLineNumber;
    }

    public void setMaxNumPage(BigDecimal maxNumPage)
    {
	this.maxNumPage = maxNumPage;
    }

    public BigDecimal getMaxNumPage()
    {
	return maxNumPage;
    }

}
